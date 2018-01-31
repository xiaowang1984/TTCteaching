package com.neuedu.core;


import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

import com.thoughtworks.xstream.core.util.Base64Encoder;


public class DESUtils {
	private static Key key;
	private static String KEY_STR = "wy";
	static {
		try {
			KeyGenerator generator = KeyGenerator.getInstance("DES");
			SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
			secureRandom.setSeed(KEY_STR.getBytes("UTF-8"));
			generator.init(secureRandom);
			key = generator.generateKey();
			generator = null;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 瀵箂tr杩涜DES鍔犲瘑
	 * 
	 * @param str
	 * @return
	 */
	public static String getEncryptString(String str) {
		Base64Encoder base64en = new Base64Encoder();
		try {
			byte[] strBytes = str.getBytes("UTF8");
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] encryptStrBytes = cipher.doFinal(strBytes);
			return base64en.encode(encryptStrBytes);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * 瀵箂tr杩涜DES瑙ｅ瘑
	 * 
	 * @param str
	 * @return
	 */
	public static String getDecryptString(String str) {
		Base64Encoder base64De = new Base64Encoder();
		try {
			byte[] strBytes = base64De.decode(str);
			Cipher cipher = Cipher.getInstance("DES");
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] decryptStrBytes = cipher.doFinal(strBytes);
			return new String(decryptStrBytes, "UTF8");
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}
public static void main(String[] args) {
	
}
	
}
