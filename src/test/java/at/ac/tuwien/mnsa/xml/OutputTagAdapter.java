package at.ac.tuwien.mnsa.xml;

import at.ac.tuwien.mnsa.xml.tag.OutputTag;
import org.apache.commons.lang3.ArrayUtils;

import javax.smartcardio.ResponseAPDU;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class OutputTagAdapter extends XmlAdapter<OutputTag, ResponseAPDU> {

	@Override
	public ResponseAPDU unmarshal(OutputTag outputTag) throws Exception {
		ResponseAPDU responseAPDU = new ResponseAPDU(ArrayUtils
				.addAll(outputTag.getData(), new byte[]{outputTag.getSw1(), outputTag.getSw2()}));
		return responseAPDU;
	}

	@Override
	public OutputTag marshal(ResponseAPDU responseAPDU) throws Exception {
		throw new UnsupportedOperationException();
	}
}
