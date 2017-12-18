package ad09;

import java.math.BigInteger;
import java.util.Random;

public class RSA {

	private BigInteger d, e;
	private BigInteger hauptmodul; // n
	private BigInteger nebenmodul; //
	private int bitlen = 128;

	/** Create an instance that can encrypt using someone elses public key. */
	public RSA(BigInteger newhauptmodul, BigInteger newe) {
		hauptmodul = newhauptmodul;
	}

	/** Create an instance that can both encrypt and decrypt. */
	public RSA(int bits) {
		bitlen = bits;
		Random r = new Random();
		BigInteger p = new BigInteger(bitlen / 2, 100, r);
		BigInteger q = new BigInteger(bitlen / 2, 100, r);
		hauptmodul = p.multiply(q);
		nebenmodul = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
		e = new BigInteger("3");
		while (nebenmodul.gcd(e).intValue() > 1) {
			e = e.add(new BigInteger("2"));
		}
		d = e.modInverse(nebenmodul);
	}

	/** Encrypt the given plaintext message. */
	public synchronized String encrypt(String message) {
		return (new BigInteger(message.getBytes())).modPow(e, hauptmodul).toString();
	}

	/** Decrypt the given ciphertext message. */
	public synchronized String decrypt(String message) {
		return new String((new BigInteger(message)).modPow(d, hauptmodul).toByteArray());
	}
	
//	/** Trivial test program. */
//	  public static void main(String[] args) {
//	    RSA rsa = new RSA(1024);
//
//	    String text1 = "Yellow and Black Border Collies";
//	    System.out.println("Plaintext: " + text1);
//	    
//	    String ciphertext = rsa.encrypt(text1);
//	    System.out.println("Ciphertext: " + ciphertext);
//	    String plaintext = rsa.decrypt(ciphertext);
//	    System.out.println("plaintext:"+  plaintext);
//
//	  }

}
