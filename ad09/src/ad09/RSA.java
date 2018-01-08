package ad09;

import java.math.BigInteger;
import java.util.Random;

public class RSA {

	private BigInteger privateK, publicK;//d,e
	private BigInteger hauptmodul; // n
	private BigInteger nebenmodul; 
	private int bitlen;

	public RSA(int bits) {
		bitlen = bits;
		Random r = new Random();
		BigInteger p = new BigInteger(bitlen , 100, r);
		BigInteger q = new BigInteger(bitlen , 100, r);
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

	public String encrypt(String message) {
		return (new BigInteger(message.getBytes())).modPow(publicK, hauptmodul).toString();
	}

	public String decrypt(String message) {
		return new String((new BigInteger(message)).modPow(privateK, hauptmodul).toByteArray());
	}
	
	public BigInteger encrypt(BigInteger message) {
		return message.modPow(publicK, hauptmodul);
	}

	public BigInteger decrypt(BigInteger message) {
		return message.modPow(privateK, hauptmodul);
	} 
	
	public BigInteger getPublicKey() {
		return publicK;
	}
	
	public BigInteger getHauptmodul() {
		return hauptmodul;
	}
	
	public static void main(String[] args) {
	    RSA rsaEmpfänger = new RSA(64);
	    RSA rsaSender = new RSA(rsaEmpfänger.getHauptmodul(), rsaEmpfänger.getPublicKey());
	    
	    
	    
	    
	    String text1 = "Dennis stinkt";
	    System.out.println("Plaintext: " + text1);
	    
	    BigInteger textI = new BigInteger(text1.getBytes());
//	    String verifyIdentifier = new String(textI.toByteArray());
//	    System.out.println(verifyIdentifier);
	    
	    BigInteger ciphertext = rsaSender.encrypt(textI);
	    System.out.println("Ciphertext: " + new String(ciphertext.toByteArray()));
	    
	    BigInteger plaintext = rsaEmpfänger.decrypt(ciphertext);
	    System.out.println("plaintext:"+  new String(plaintext.toByteArray()));
	   
	    
//	    String ciphertext = rsaSender.encrypt(text1);
//	    System.out.println("Ciphertext: " + ciphertext);
//	    
//	    String plaintext = rsaEmpfänger.decrypt(ciphertext);
//	    System.out.println("plaintext:"+  plaintext);
  }

}
