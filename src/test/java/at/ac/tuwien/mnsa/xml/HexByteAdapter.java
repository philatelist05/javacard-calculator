package at.ac.tuwien.mnsa.xml;

import javax.xml.bind.DatatypeConverter;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class HexByteAdapter extends XmlAdapter<String, Byte> {

	@Override
	public Byte unmarshal(String s) throws Exception {
		return DatatypeConverter.parseHexBinary(s)[0];
	}

	@Override
	public String marshal(Byte aByte) throws Exception {
		return DatatypeConverter.printHexBinary(new byte[]{aByte});
	}
}
