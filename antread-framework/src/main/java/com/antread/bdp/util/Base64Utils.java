package com.antread.bdp.util;

import java.io.UnsupportedEncodingException;

import org.apache.commons.codec.binary.Base64;

public class Base64Utils {

	public final static String encode(String s) {
		if (s == null) {
			return "";
		}
		try {
			return Base64.encodeBase64String(s.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return Base64.encodeBase64String(s.getBytes());
	}

	public final static String decode(String s) {
		try {
			return new String(Base64.decodeBase64(s.getBytes()), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

}
