package at.ac.tuwien.mnsa.xml;

import javax.smartcardio.CommandAPDU;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class CommandAPDUAdapter extends XmlAdapter<TestNode.XmlCommandAPDU, CommandAPDU> {

	@Override
	public CommandAPDU unmarshal(TestNode.XmlCommandAPDU xmlCommandAPDU) throws Exception {
		CommandAPDU commandAPDU =
				new CommandAPDU(xmlCommandAPDU.cla[0], xmlCommandAPDU.ins[0], xmlCommandAPDU.p1[0], xmlCommandAPDU.p2[0], xmlCommandAPDU.data);
		System.out.println(commandAPDU);
		return commandAPDU;
	}

	@Override
	public TestNode.XmlCommandAPDU marshal(CommandAPDU commandAPDU) throws Exception {
		throw new UnsupportedOperationException();
	}
}
