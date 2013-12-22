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
public class InputTag {

	@XmlAttribute
	@XmlJavaTypeAdapter(HexByteAdapter.class)
	@XmlSchemaType(name = "hexBinary")
	private Byte cla;

	@XmlAttribute
	@XmlJavaTypeAdapter(HexByteAdapter.class)
	@XmlSchemaType(name = "hexBinary")
	private Byte ins;

	@XmlAttribute
	@XmlJavaTypeAdapter(HexByteAdapter.class)
	@XmlSchemaType(name = "hexBinary")
	private Byte p1;

	@XmlAttribute
	@XmlJavaTypeAdapter(HexByteAdapter.class)
	@XmlSchemaType(name = "hexBinary")
	private Byte p2;

	@XmlAttribute
	@XmlJavaTypeAdapter(HexBinaryAdapter.class)
	private byte[] data;

	public byte getCla() {
		return cla;
	}


	public byte getIns() {
		return ins;
	}

	public byte getP1() {
		return p1;
	}

	public byte getP2() {
		return p2;
	}

	public byte[] getData() {
		return data;
	}


	@Override
	public String toString() {
		return "InputTag{" +
				"cla=" + DatatypeConverter.printHexBinary(new byte[]{cla}) +
				", ins=" + DatatypeConverter.printHexBinary(new byte[]{ins}) +
				", p1=" + DatatypeConverter.printHexBinary(new byte[]{p1}) +
				", p2=" + DatatypeConverter.printHexBinary(new byte[]{p2}) +
				", data=" + DatatypeConverter.printHexBinary(data) +
				'}';
	}
}
