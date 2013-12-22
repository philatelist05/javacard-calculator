package at.ac.tuwien.mnsa.xml;

import org.apache.commons.lang3.ArrayUtils;

import javax.smartcardio.ResponseAPDU;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class ResponseAPDUAdapter extends XmlAdapter<TestNode.XmlResponseAPDU, ResponseAPDU> {
	@Override
	public ResponseAPDU unmarshal(TestNode.XmlResponseAPDU xmlResponseAPDU) throws Exception {
		return new ResponseAPDU(ArrayUtils
				.addAll(xmlResponseAPDU.sw, xmlResponseAPDU.data));
	}

	@Override
	public TestNode.XmlResponseAPDU marshal(ResponseAPDU responseAPDU) throws Exception {
		throw new UnsupportedOperationException();
	}
}
