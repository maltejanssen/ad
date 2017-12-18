package ad09;

import java.math.BigInteger;
import java.util.Base64;
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
		
		//Include key
		System.arraycopy(key, 0, textKey, blocksize, textKey.length - blocksize/2);
		
		//Divide in left and right side
		byte[] R = new byte [text.length/2];
		byte[] L = new byte [text.length/2];	
		System.arraycopy(text, 0, R, 0, text.length/2);
		System.arraycopy(text, text.length/2, L, 0, text.length/2);
		
		BigInteger r = new BigInteger(R); 
		BigInteger k = new BigInteger(key);	
		
		BigInteger function = (r.pow(2).add(k)).mod(new BigInteger("2").pow(64).subtract(new BigInteger("1")));
		
		byte[] functionArray = BigInt2Byte(function,blocksize/2);
		byte[] xor = xor_func(L, functionArray);
		
//		Base64.getEncoder().encodeToString(key);
//		Base64.getDecoder().decode(s)
//		//Include RSA key
//		System.arraycopy(key, 0, textKey, blocksize, textKey.length - blocksize/2);
		
		
		
	}
	
	private byte[] xor_func(byte[] a, byte[] b) {
	     byte[] out = new byte[a.length];
	     for (int i = 0; i < a.length; i++) {
	          out[i] = (byte) (a[i] ^ b[i]);
	     }
	     return out;
	}
	
	static byte[] BigInt2Byte (BigInteger src, int bytesize){ 
		byte[] out = new byte[bytesize];
		BigInteger mod = new BigInteger("2"); 
		mod = mod.pow(bytesize*8);
		src = src.mod(mod);
		int startdst = bytesize - src.toByteArray().length ;
		int cpylength = src.toByteArray().length;
		
		if((src.bitLength() % 8) != 0){ 
			System.arraycopy(src.toByteArray(),0,out,startdst,cpylength);
		}
		else {
			System.arraycopy(src.toByteArray(),1,out,startdst+1,cpylength-1);
		}
		return out; 
	}
	
	public static void main(String[] args) {
		Feistel f = new Feistel("1");

	}
	
	

}
