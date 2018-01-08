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
		generateSessionKey();
	}
	
	public BigInteger getSessionKey() {
		return new BigInteger(sessionKey);
	}
	
	public void setSessionKey(BigInteger key) {
		sessionKey = BigInt2Byte(key, BLOCKSIZE / 2);
	}

	public byte[] encode(String message) {
		byte[] preCipherArray = initFeistel(message);
		
		createFeistelblocks(preCipherArray);
		
		
		
		for (int i = 0; i < blocks.length; i++) {
			blocks[i].cycle(sessionKey, NUMBER_OF_CYCLES);
		}
		
		//include the sessionkey (blocksize/2) and the ´padding bytes for the key
		byte[] afterCipherArray = sessionKey;
		byte[] paddingForKey = new byte[BLOCKSIZE / 2];
		afterCipherArray = concat(afterCipherArray, paddingForKey);

		//concat the results from the feistelblocks
		for (int i = 0; i < blocks.length; i++) {
			afterCipherArray = concat(afterCipherArray, blocks[i].getLeft());
			afterCipherArray = concat(afterCipherArray, blocks[i].getRight());
		}

		
		//pack in a string
		//String cipherString = packInAString(afterCipherArray);
		
		return afterCipherArray;
	}
	
	public String decode(byte[] cipherText) {
		
		// extract key
		byte[] key = new byte[BLOCKSIZE/2];
		System.arraycopy(cipherText, 0, key, 0, BLOCKSIZE / 2);
		
		// generate array without key
		byte[] cipherTextWithoutKey = new byte[cipherText.length-OFFSET];
		System.arraycopy(cipherText, OFFSET, cipherTextWithoutKey, 0, cipherText.length-OFFSET);
		
		//generate feistelblocks
		createFeistelblocks(cipherTextWithoutKey);
		
		//
		
		for (int i = 0; i < blocks.length; i++) {
			blocks[i].swap();
			blocks[i].cycle(key, NUMBER_OF_CYCLES);
			blocks[i].swap();
		}
		
		byte[] decodedArray = {};
		//concat the results from the feistelblocks
		for (int i = 0; i < blocks.length; i++) {
			decodedArray = concat(decodedArray, blocks[i].getLeft());
			decodedArray = concat(decodedArray, blocks[i].getRight());
		}
		
		String decodedString = packInAString(decodedArray);
		
		
		
		return decodedString;
	}
	
	private static String packInAString(byte[] decodedArray) {
		//pack in a string
		String decodedString;
//		try {
			decodedString = new String(decodedArray/*, "UTF-8"*/);
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//			return null;
//		}
		return decodedString;
	}

	public byte[] concat(byte[] a, byte[] b) {
		int aLen = a.length;
		int bLen = b.length;
		byte[] c = new byte[aLen + bLen];
		System.arraycopy(a, 0, c, 0, aLen);
		System.arraycopy(b, 0, c, aLen, bLen);
		return c;
	}

	private void createFeistelblocks(byte[] cipherArray) {
		
		blocks = new Feistelblock[(cipherArray.length) / BLOCKSIZE];
		
		for (int i = 0, j = 0; i < cipherArray.length; i += BLOCKSIZE, j++) {
			byte[] left = new byte[BLOCKSIZE / 2];
			byte[] right = new byte[BLOCKSIZE / 2];

			System.arraycopy(cipherArray, i, left, 0, BLOCKSIZE / 2);
			System.arraycopy(cipherArray, i + left.length, right, 0, BLOCKSIZE / 2);
			blocks[j] = new Feistelblock(right, left, BLOCKSIZE);
		}
	}

	private byte[] initFeistel(String message) {
		// Convert String in Byte Array
		byte[] messageByteArray;
//		try { 
			messageByteArray= message.getBytes(/*"UTF-8"*/);
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//			return null;
//		}

		// calculate padding
		int padding = 0;
		if (messageByteArray.length % BLOCKSIZE != 0) {
			padding = BLOCKSIZE - (messageByteArray.length % BLOCKSIZE);
		}

		// Include padding
		byte[] cipherArray = new byte[messageByteArray.length + padding];
		System.arraycopy(messageByteArray, 0, cipherArray, 0, messageByteArray.length);

		// If necessary, padded with PADDING_VALUE
		if (padding != 0) {
			for (int i = messageByteArray.length; i < cipherArray.length; i++)
				cipherArray[i] = PADDING_VALUE;
		}

		
		return cipherArray;
	}

	private void generateSessionKey() {
		// Generate random key
		sessionKey = new byte[BLOCKSIZE / 2];
		
		for (int i = 0; i < sessionKey.length; i++)
		{
			sessionKey[i] = ((byte)randomInt(0,255));
		}
	}
	
	

	private int randomInt(int i, int j) {
		Random random = new Random();

		return random.nextInt(j-i+1)+i;
	}

	public static void main(String[] args) throws UnsupportedEncodingException {
		Feistel F = new Feistel(16,10);
		
		String rawMessage = "Fisch";
		String message = new String(rawMessage.getBytes()/*, "UTF-8"*/);
		System.out.println("Input: " + message);
		
		byte[] afterCipherArray = F.encode(message);
		String cipherString = packInAString(afterCipherArray);
		System.out.println("Encoded: " + cipherString);
		
		String decodedMessage = F.decode(afterCipherArray);
		System.out.println("Decoded: " + decodedMessage);
	}

	/**
	 * Solution ref.: RSA Verschlüsselung: Ronald Rivest, Adi Shamir, Leonard
	 * Adleman
	 * 
	 * @param src
	 * @param bytesize
	 * @return
	 */
	static byte[] BigInt2Byte(BigInteger src, int bytesize) {
		byte[] out = new byte[bytesize];
		BigInteger mod = new BigInteger("2");
		mod = mod.pow(bytesize * 8);
		src = src.mod(mod);
		int startdst = bytesize - src.toByteArray().length;
		int cpylength = src.toByteArray().length;

		if ((src.bitLength() % 8) != 0) {
			System.arraycopy(src.toByteArray(), 0, out, startdst, cpylength);
		} else {
			System.arraycopy(src.toByteArray(), 1, out, startdst + 1, cpylength - 1);
		}
		return out;
	}
}
