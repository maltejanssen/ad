package ad09;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;

public class Feistel {

	public final int BLOCKSIZE;
	public final int OFFSET;
	public final int NUMBER_OF_CYCLES;
	final byte PADDING_VALUE = 0x20;

	private Feistelblock[] blocks;
	private byte[] sessionKey;

	/**
	 * 
	 * @param string:
	 *            message
	 */
	public Feistel(int blocksize, int numberOfCycles) {

		BLOCKSIZE = blocksize;
		OFFSET = blocksize;
		NUMBER_OF_CYCLES = numberOfCycles;

	}

	public String encode(String message) {
		byte[] preCipherArray = initFeistel(message);

		blocks = new Feistelblock[(preCipherArray.length - OFFSET) / BLOCKSIZE];

		createFistelblocks(preCipherArray);

		for (int i = 0; i < blocks.length; i++) {
			blocks[i].cycle(sessionKey, 12);
		}

		byte[] afterCipherArray = sessionKey;
		byte[] paddingForKey = new byte[BLOCKSIZE / 2];
		afterCipherArray = concat(afterCipherArray, paddingForKey);

		for (int i = 0; i < blocks.length; i++) {
			afterCipherArray = concat(afterCipherArray, blocks[i].getLeft());
			afterCipherArray = concat(afterCipherArray, blocks[i].getRight());
		}

		String cipherString;
		try {
			cipherString = new String(afterCipherArray, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
		return cipherString;
	}

	public byte[] concat(byte[] a, byte[] b) {
		int aLen = a.length;
		int bLen = b.length;
		byte[] c = new byte[aLen + bLen];
		System.arraycopy(a, 0, c, 0, aLen);
		System.arraycopy(b, 0, c, aLen, bLen);
		return c;
	}

	private void createFistelblocks(byte[] cipherArray) {
		for (int i = OFFSET, j = 0; i < cipherArray.length; i += BLOCKSIZE, j++) {
			byte[] left = new byte[BLOCKSIZE / 2];
			byte[] right = new byte[BLOCKSIZE / 2];

			System.arraycopy(cipherArray, i, left, 0, BLOCKSIZE / 2);
			System.arraycopy(cipherArray, i + left.length, right, 0, BLOCKSIZE / 2);
			blocks[j] = new Feistelblock(right, left, BLOCKSIZE);
		}
	}

	private byte[] initFeistel(String message) {
		// Convert String in Byte Array
		byte[] messageByteArray = message.getBytes();

		// calculate padding
		int padding = 0;
		if (messageByteArray.length % BLOCKSIZE != 0) {
			padding = BLOCKSIZE - (messageByteArray.length % BLOCKSIZE);
		}

		// Include Offset for key and padding
		byte[] cipherArray = new byte[messageByteArray.length + OFFSET + padding];
		System.arraycopy(messageByteArray, 0, cipherArray, OFFSET, messageByteArray.length);

		// If necessary, padded with PADDING_VALUE
		if (padding != 0) {
			for (int i = messageByteArray.length + OFFSET; i < cipherArray.length; i++)
				cipherArray[i] = PADDING_VALUE;
		}

		// Generate random key
		Random random = new Random();
		sessionKey = new byte[BLOCKSIZE / 2];
		random.nextBytes(sessionKey);

		// Include key
		System.arraycopy(sessionKey, 0, cipherArray, 0, sessionKey.length);
		return cipherArray;
	}

	public static void main(String[] args) {
		Feistel F = new Feistel(16, 12);
		String message = "abcdefghijklmnopqrstuvwxyz";
		System.out.println("Input: " + message);
		String cipherString = F.encode(message);
		System.out.println("Encoded: " + cipherString);

	}

}
