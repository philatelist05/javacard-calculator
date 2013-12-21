package at.ac.tuwien.mnsa.javacard;

import javacard.framework.APDU;
import javacard.framework.Applet;
import javacard.framework.ISO7816;
import javacard.framework.ISOException;

public class Calculator extends Applet {

	private static final byte ADD = (byte) 0x01;
	private static final byte SUB = (byte) 0x02;
	private static final byte MUL = (byte) 0x03;
//	private static final byte DIV = (byte) 0x04;
	private static final byte AND = (byte) 0x05;
	private static final byte OR = (byte) 0x06;
	private static final byte NOT = (byte) 0x07;

	private Calculator() {
		register();
	}

	public static void install(byte[] bArray, short bOffset, byte bLength) {
		new Calculator();
	}

	public void process(APDU apdu) throws ISOException {
		if (selectingApplet()) {
			return;
		}

		byte[] buffer = apdu.getBuffer();
		if (buffer[ISO7816.OFFSET_CLA] != 0x00) {
			ISOException.throwIt(ISO7816.SW_CLA_NOT_SUPPORTED);
		}
		if (buffer[ISO7816.OFFSET_LC] != 0x00) {
			ISOException.throwIt(ISO7816.SW_WRONG_LENGTH);
		}

		byte p1 = buffer[ISO7816.OFFSET_P1];
		byte p2 = buffer[ISO7816.OFFSET_P2];
		short result = 0;

		switch (buffer[ISO7816.OFFSET_INS]) {
			case ADD:
				result = (short) (p1 + p1);
				break;
			case SUB:
				result = (short) (p1 - p2);
				break;
			case MUL:
				result = (short) (p1 * p2);
				break;
//			case DIV:
//				result = (short) (p1 / p2);
//				break;
			case AND:
				result = (short) (p1 & p2);
				break;
			case OR:
				result = (short) (p1 | p2);
				break;
			case NOT:
				if (p2 != 0x00) {
					ISOException.throwIt(ISO7816.SW_INCORRECT_P1P2);
				}
				result = (short) ~p1;
				break;
			default:
				ISOException.throwIt(ISO7816.SW_INS_NOT_SUPPORTED);
		}

		buffer[0] = (byte) (result & 0xff);
		/* >>> does not preserve the left most bit (e.g. it is always 0)
		 * >> does preserve the left most bit (=sign bit)
		 */
		buffer[1] = (byte) (result >>> 8);

		apdu.setOutgoingAndSend((short) 0, (short) 2);
	}
}
