package at.ac.tuwien.mnsa.xml;

import javax.smartcardio.CommandAPDU;
import javax.smartcardio.ResponseAPDU;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

public class TestNode {

	static class XmlCommandAPDU {
		@XmlAttribute
		byte[] cla;
		@XmlAttribute
		byte[] ins;
		@XmlAttribute
		byte[] p1;
		@XmlAttribute
		byte[] p2;
		@XmlAttribute
		byte[] data;
	}

	static class XmlResponseAPDU {
		@XmlAttribute
		byte[] sw;
		@XmlAttribute
		byte[] data;
	}

	@XmlElement(name = "APDUCommand")
	@XmlJavaTypeAdapter(CommandAPDUAdapter.class)
	private CommandAPDU commandAPDU;

	@XmlElement(name = "ExpectedResponse")
	@XmlJavaTypeAdapter(ResponseAPDUAdapter.class)
	private ResponseAPDU responseAPDU;

	public CommandAPDU getCommandAPDU() {
		return commandAPDU;
	}

	public ResponseAPDU getResponseAPDU() {
		return responseAPDU;
	}
}
