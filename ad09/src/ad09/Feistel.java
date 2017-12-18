package ad09;

import java.util.Random;

public class Feistel {
	
	int blocksize = 16;

	public Feistel(String string) {
		//Convert String Array in Byte Array
		byte[] text = string.getBytes();
		
		//Include Offset for key
		byte[] textKey = new byte[text.length+blocksize/2];
		System.arraycopy(text, 0, textKey, blocksize/2, text.length);
		
		//Generate random key
		Random random = new Random();
		byte[] key = new byte[blocksize/2];
		random.nextBytes(key);
		
		System.arraycopy(key, 0, textKey, blocksize, textKey.length - blocksize/2);
		
		byte[] R = new Byte []
		byte[] L = new Byte []		
		
	}
	
	public static void main(String[] args) {
		Feistel f = new Feistel("1");

	}

}
