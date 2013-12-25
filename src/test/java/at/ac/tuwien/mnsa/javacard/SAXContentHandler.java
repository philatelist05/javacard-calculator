package at.ac.tuwien.mnsa.javacard;

import org.apache.commons.lang3.ArrayUtils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.smartcardio.CommandAPDU;
import javax.smartcardio.ResponseAPDU;
import javax.xml.bind.DatatypeConverter;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SAXContentHandler extends DefaultHandler {

	private final List<Object[]> objects;
	private final Queue<Object> queue;

	public SAXContentHandler(List<Object[]> objects) {
		this.objects = objects;
		queue = new LinkedList<Object>();

	}

	@Override
	public void startElement(String namespaceURI, String localName, String qName, Attributes attrs) throws SAXException {

		if (localName.equalsIgnoreCase("Input") || qName.equalsIgnoreCase("Input")) {
			byte cla = toByteArray(attrs.getValue("cla"))[0];
			byte ins = toByteArray(attrs.getValue("ins"))[0];
			byte p1 = toByteArray(attrs.getValue("p1"))[0];
			byte p2 = toByteArray(attrs.getValue("p2"))[0];
			byte[] data = toByteArray(attrs.getValue("data"));
			byte[] bytes = ArrayUtils.addAll(new byte[]{cla, ins, p1, p2}, data);

			CommandAPDU commandAPDU = new CommandAPDU(bytes);
			queue.add(commandAPDU);
		}
		else if (localName.equalsIgnoreCase("Output") || qName.equalsIgnoreCase("Output")) {
			byte sw1 = toByteArray(attrs.getValue("sw1"))[0];
			byte sw2 = toByteArray(attrs.getValue("sw2"))[0];
			byte[] data = toByteArray(attrs.getValue("data"));
			byte[] bytes = ArrayUtils.addAll(data, new byte[]{sw1, sw2});

			ResponseAPDU responseAPDU = new ResponseAPDU(bytes);
			queue.add(responseAPDU);
		}
	}

	@Override
	public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
		if (localName.equalsIgnoreCase("Test") || qName.equalsIgnoreCase("Test")) {
			objects.add(new Object[]{queue.poll(), queue.poll()});
		}
	}

	private byte[] toByteArray(String value) {
		if (value == null) {
			return new byte[]{};
		}
		return DatatypeConverter.parseHexBinary(value);
	}
}
