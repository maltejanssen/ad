package ad09;
import java.math.BigInteger;
import java.util.Base64;

public class Hybrid {
	
	
	private Feistel feistel;
	private static String message;

	public Hybrid() {
		feistel = new Feistel(16, 16);
	}
	
	public String encode(String message , RSA rsa) {
		byte[] sessionKeyCipherText = feistel.encode("Fisch");
		BigInteger sessionKey = feistel.getSessionKey();
		BigInteger encryptedSessionKey = rsa.encrypt(sessionKey);
		
		byte[] encSessionKeyArray = encryptedSessionKey.toByteArray();
				//Feistel.BigInt2Byte(encryptedSessionKey, 16);
		System.arraycopy(encSessionKeyArray, 0, sessionKeyCipherText, 0, 16);
		
		System.out.println("ciphertext: " + new String(sessionKeyCipherText));
		return Base64.getEncoder().encodeToString(sessionKeyCipherText);
	}
	
	public String decode(String encodedMessage, RSA receiver) {
		byte[] cipherText = Base64.getDecoder().decode(encodedMessage);
		byte[] cipheredSessionKey = new byte[16];
		System.arraycopy(cipherText, 0, cipheredSessionKey, 0, 16);
		BigInteger bI = new BigInteger(cipheredSessionKey);
		bI = receiver.decrypt(bI);
		byte[] decryptedSessionKey = new byte[16];
		byte[] temp = bI.toByteArray();
		System.arraycopy(temp, 0, decryptedSessionKey, 0, 8);
		System.arraycopy(decryptedSessionKey, 0, cipherText, 0, 16);
				//Feistel.BigInt2Byte(bI, 8);
		System.out.println("decr.SessionKey: " + new String(decryptedSessionKey));
		String result = feistel.decode(cipherText);
		
//		if(result.charAt(result.length()-1) != ' ') {
//			String e = encode(message, receiver);
//			result=  decode(e,receiver);
//		}
		return result;
	}

	public static void main(String[] args) {
		RSA receiver = new RSA(64);
		RSA sender = new RSA(receiver.getHauptmodul(), receiver.getPublicKey());
		message = "Fisch";
		
		Hybrid hybrid = new Hybrid();
		String cipher = hybrid.encode(message, sender);
		String decodedText = hybrid.decode(cipher, receiver);
		while(decodedText.charAt(decodedText.length()-1) != ' ') {
			hybrid = new Hybrid();
			cipher = hybrid.encode(message, sender);
			decodedText = hybrid.decode(cipher, receiver);
		}
		System.out.println("decodedtext: "+decodedText);
	}

}
