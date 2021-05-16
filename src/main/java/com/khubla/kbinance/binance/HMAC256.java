package com.khubla.kbinance.binance;

import javax.crypto.*;
import javax.crypto.spec.*;

/**
 * @author Tom Everett
 *         <p>
 *         Copyright (C) 2021,tom@khubla.com
 *         </p>
 */
// https://sorenpoulsen.com/calculate-hmac-sha256-with-java
public class HMAC256 {
	// convert byte array to hex string
	private static String bytesToHex(byte[] bytes) {
		final char[] hexArray = "0123456789abcdef".toCharArray();
		final char[] hexChars = new char[bytes.length * 2];
		for (int j = 0, v; j < bytes.length; j++) {
			v = bytes[j] & 0xFF;
			hexChars[j * 2] = hexArray[v >>> 4];
			hexChars[(j * 2) + 1] = hexArray[v & 0x0F];
		}
		return new String(hexChars);
	}

	static public String calcHmacSha256(String secretKey, String message) {
		byte[] hmacSha256 = null;
		try {
			final Mac mac = Mac.getInstance("HmacSHA256");
			final SecretKeySpec secretKeySpec = new SecretKeySpec(secretKey.getBytes("UTF-8"), "HmacSHA256");
			mac.init(secretKeySpec);
			hmacSha256 = mac.doFinal(message.getBytes("UTF-8"));
		} catch (final Exception e) {
			throw new RuntimeException("Failed to calculate hmac-sha256", e);
		}
		return bytesToHex(hmacSha256);
	}
}
