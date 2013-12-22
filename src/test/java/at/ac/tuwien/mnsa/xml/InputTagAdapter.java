package at.ac.tuwien.mnsa.xml;

import at.ac.tuwien.mnsa.xml.tag.InputTag;
import org.apache.commons.lang3.ArrayUtils;

import javax.smartcardio.CommandAPDU;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class InputTagAdapter extends XmlAdapter<InputTag, CommandAPDU> {

	@Override
	public CommandAPDU unmarshal(InputTag inputTag) throws Exception {
		byte[] bytes = ArrayUtils.addAll(new byte[]{inputTag.getCla(), inputTag.getIns(), inputTag.getP1(), inputTag.getP2()}, inputTag.getData());
		CommandAPDU commandAPDU = new CommandAPDU(bytes);
		return commandAPDU;
	}

	@Override
	public InputTag marshal(CommandAPDU commandAPDU) throws Exception {
		throw new UnsupportedOperationException();
	}
}
