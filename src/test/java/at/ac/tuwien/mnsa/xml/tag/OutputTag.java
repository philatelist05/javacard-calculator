package at.ac.tuwien.mnsa.xml.tag;

import at.ac.tuwien.mnsa.xml.HexByteAdapter;

import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlAccessorType(XmlAccessType.FIELD)
public class OutputTag {

	@XmlAttribute
	@XmlJavaTypeAdapter(HexByteAdapter.class)
	private Byte sw1;

	@XmlAttribute
	@XmlJavaTypeAdapter(HexByteAdapter.class)
	private Byte sw2;

	@XmlAttribute
	@XmlJavaTypeAdapter(HexBinaryAdapter.class)
	@XmlSchemaType(name = "hexBinary")
	private byte[] data;

	public byte getSw1() {
		return sw1;
	}

	public byte getSw2() {
		return sw2;
	}

	public byte[] getData() {
		return data;
	}

	@Override
	public String toString() {
		return "OutputTag{" +
				"sw1=" + DatatypeConverter.printHexBinary(new byte[]{sw1}) +
				", sw2=" + DatatypeConverter.printHexBinary(new byte[]{sw2}) +
				", data=" + DatatypeConverter.printHexBinary(data) +
				'}';
	}
}
