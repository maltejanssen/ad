package ad09;

import java.math.BigInteger;
import java.util.Random;

public class RSA {

	private BigInteger privateK, publicK;//d,e
	private BigInteger hauptmodul; // n
	private BigInteger nebenmodul; 
	private int bitlen = 128;

	public RSA(int bits) {
		bitlen = bits;
		Random r = new Random();
		BigInteger p = new BigInteger(bitlen / 2, 100, r);
		BigInteger q = new BigInteger(bitlen / 2, 100, r);
		hauptmodul = p.multiply(q);
		nebenmodul = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
		publicK = new BigInteger("3");
		while (nebenmodul.gcd(publicK).intValue() > 1) {
			publicK = publicK.add(new BigInteger("2"));
		}
		privateK = publicK.modInverse(nebenmodul);
	}

	//Instance that can encrypt using someone elses public key
	public RSA(BigInteger otherHauptmodul, BigInteger otherpublicKey) {
		publicK = otherpublicKey;
		hauptmodul = otherHauptmodul;
	}

	public synchronized String encrypt(String message) {
		return (new BigInteger(message.getBytes())).modPow(publicK, hauptmodul).toString();
	}

	public synchronized String decrypt(String message) {
		return new String((new BigInteger(message)).modPow(privateK, hauptmodul).toByteArray());
	}
	
	public BigInteger getPublicKey() {
		return publicK;
	}
	
	public BigInteger getHauptmodul() {
		return hauptmodul;
	}
	
	public static void main(String[] args) {
	    RSA rsa = new RSA(128);
	
	    String text1 = "x";
	    System.out.println("Plaintext: " + text1);
	    
	    String ciphertext = rsa.encrypt(text1);
	    System.out.println("Ciphertext: " + ciphertext);
	    String plaintext = rsa.decrypt(ciphertext);
	    System.out.println("plaintext:"+  plaintext);
  }

}
