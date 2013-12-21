package at.ac.tuwien.mnsa.javacard;

import com.licel.jcardsim.base.Simulator;
import javacard.framework.AID;
import javacard.framework.Applet;
import org.bouncycastle.util.encoders.Hex;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.smartcardio.CommandAPDU;
import javax.smartcardio.ResponseAPDU;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

public class CalculatorTest {

	private Simulator simulator;
	private final byte[] aidBytes = Hex.decode("010203040506070809");
	private final AID aid = new AID(aidBytes, (short) 0,
			(byte) aidBytes.length);
	private final Class<? extends Applet> appletClass = Calculator.class;

	@BeforeMethod
	public void setUp() throws Exception {
		simulator = new Simulator();
		simulator.installApplet(aid, appletClass);
		simulator.selectApplet(aid);
	}

	@AfterMethod
	public void tearDown() throws Exception {
		simulator.reset();
		simulator.resetRuntime();
	}

	@Test
	public void test() throws Exception {
		ResponseAPDU responseAPDU =
				simulator.transmitCommand(new CommandAPDU(0, 1, 1, 1, 0));
		assertEquals(responseAPDU.getSW1(), 144);
		assertEquals(responseAPDU.getSW2(), 0);
		assertArrayEquals(responseAPDU.getData(), new byte[]{0x02, 0x00});
	}
}
