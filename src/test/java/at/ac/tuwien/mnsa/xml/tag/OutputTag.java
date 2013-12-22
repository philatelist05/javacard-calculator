package at.ac.tuwien.mnsa.xml.tag;

import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
public class OutputTag {

	@XmlAttribute
	@XmlJavaTypeAdapter(HexBinaryAdapter.class)
	private byte[] sw1;

	@XmlAttribute
	@XmlJavaTypeAdapter(HexBinaryAdapter.class)
	private byte[] sw2;

	@XmlAttribute
	@XmlJavaTypeAdapter(HexBinaryAdapter.class)
	private byte[] data;

	public byte getSw1() {
		return sw1[0];
	}

	public byte getSw2() {
		return sw2[0];
	}

	public byte[] getData() {
		return data;
	}

	@Override
	public String toString() {
		return "OutputTag{" +
				"sw1=" + DatatypeConverter.printHexBinary(sw1) +
				", sw2=" + DatatypeConverter.printHexBinary(sw2) +
				", data=" + DatatypeConverter.printHexBinary(data) +
				'}';
	}
}
