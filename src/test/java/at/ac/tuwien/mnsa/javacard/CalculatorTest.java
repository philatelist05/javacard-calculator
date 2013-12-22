package at.ac.tuwien.mnsa.javacard;

import com.licel.jcardsim.base.Simulator;
import javacard.framework.AID;
import javacard.framework.Applet;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.smartcardio.CommandAPDU;
import javax.smartcardio.ResponseAPDU;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.internal.junit.ArrayAsserts.assertArrayEquals;

public class CalculatorTest {

	private Simulator simulator;
	private final byte[] aidBytes = new byte[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
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

	@Test(dataProvider = "APDUDataProvider", dataProviderClass = APDUDataProvider.class)
	public void testAPDUCommand(CommandAPDU commandAPDU,
	                            ResponseAPDU expected)
			throws Exception {
		ResponseAPDU actual = simulator.transmitCommand(commandAPDU);

		assertEquals(expected.getSW1(), actual.getSW1());
		assertEquals(expected.getSW2(), actual.getSW2());
		assertArrayEquals(expected.getData(), actual.getData());
	}
}
