package fr.doranco.cryptage.algo;

import java.security.Key;

import javax.crypto.Cipher;

import fr.doranco.jsf.enums.AlgorithmeCryptage;

public final class CryptageDES {
	
	private CryptageDES() {
	}

	public final static byte[] encrypt(String messageToEncrypt, Key key) throws Exception {

		Cipher cipher = Cipher.getInstance(AlgorithmeCryptage.DES.toString());
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] messageInByte = messageToEncrypt.getBytes("UTF-8");
		byte[] messageEncrypte = cipher.doFinal(messageInByte);
		
		return messageEncrypte;
	}

	public final static String decrypt(byte[] messageToDecrypt, Key key) throws Exception {
		
		Cipher cipher = Cipher.getInstance(AlgorithmeCryptage.DES.toString());
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] messageDecrypte = cipher.doFinal(messageToDecrypt);
		String originalMessage = new String(messageDecrypte, "UTF-8");
		
		return originalMessage;

	}

}
