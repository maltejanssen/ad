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
		
		createFeistelblocks(preCipherArray);
		generateSessionKey();
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
		String cipherString = packInAString(afterCipherArray);
		
		return cipherString;
	}
	
	public String decode(String message) {
		byte[] cipherText = initFeistel(message);
		
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

	private String packInAString(byte[] decodedArray) {
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
		Random random = new Random();
		sessionKey = new byte[BLOCKSIZE / 2];
		random.nextBytes(sessionKey);
	}
	
	

	public static void main(String[] args) throws UnsupportedEncodingException {
		Feistel F = new Feistel(16, 18);
		
		String rawMessage = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		String message = new String(rawMessage.getBytes()/*, "UTF-8"*/);
		System.out.println("Input: " + message);
		
		String cipherString = F.encode(message);
		System.out.println("Encoded: " + cipherString);
		
		String decodedMessage = F.decode(cipherString);
		System.out.println("Decoded: " + decodedMessage);
	}

}
