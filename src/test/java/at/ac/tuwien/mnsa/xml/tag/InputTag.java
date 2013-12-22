package at.ac.tuwien.mnsa.xml.tag;

import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.adapters.HexBinaryAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

public class InputTag {

	@XmlAttribute
	@XmlJavaTypeAdapter(HexBinaryAdapter.class)
	private byte[] cla;

	@XmlAttribute
	@XmlJavaTypeAdapter(HexBinaryAdapter.class)
	private byte[] ins;

	@XmlAttribute
	@XmlJavaTypeAdapter(HexBinaryAdapter.class)
	private byte[] p1;

	@XmlAttribute
	@XmlJavaTypeAdapter(HexBinaryAdapter.class)
	private byte[] p2;

	@XmlAttribute
	@XmlJavaTypeAdapter(HexBinaryAdapter.class)
	private byte[] data;

	public byte getCla() {
		return cla[0];
	}


	public byte getIns() {
		return ins[0];
	}

	public byte getP1() {
		return p1[0];
	}

	public byte getP2() {
		return p2[0];
	}

	public byte[] getData() {
		return data;
	}


	@Override
	public String toString() {
		return "InputTag{" +
				"cla=" + DatatypeConverter.printHexBinary(cla) +
				", ins=" + DatatypeConverter.printHexBinary(ins) +
				", p1=" + DatatypeConverter.printHexBinary(p1) +
				", p2=" + DatatypeConverter.printHexBinary(p2) +
				", data=" + DatatypeConverter.printHexBinary(data) +
				'}';
	}
}
