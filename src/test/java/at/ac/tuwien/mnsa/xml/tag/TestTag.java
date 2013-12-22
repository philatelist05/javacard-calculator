package at.ac.tuwien.mnsa.xml.tag;

import at.ac.tuwien.mnsa.xml.InputTagAdapter;
import at.ac.tuwien.mnsa.xml.OutputTagAdapter;

import javax.smartcardio.CommandAPDU;
import javax.smartcardio.ResponseAPDU;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

public class TestTag {

	@XmlElement(name = "Input")
	@XmlJavaTypeAdapter(InputTagAdapter.class)
	private CommandAPDU commandAPDU;

	@XmlElement(name = "Output")
	@XmlJavaTypeAdapter(OutputTagAdapter.class)
	private ResponseAPDU responseAPDU;

	public CommandAPDU getCommandAPDU() {
		return commandAPDU;
	}

	public ResponseAPDU getResponseAPDU() {
		return responseAPDU;
	}

	@Override
	public String toString() {
		return "TestTag{" +
				"commandAPDU=" + commandAPDU +
				", responseAPDU=" + responseAPDU +
				'}';
	}
}
