package com.antread.bdp.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.antread.bdp.framework.exception.BaseException;

public class ValidateCodeUtils {

	/**
	 * 根据手机号，生成6位随机验证码
	 * 
	 * @param phone
	 * @return
	 */
	public static String generate6CodeByPhone(String phone) {
		if (phone == null || phone.length() != 11) {
			throw new BaseException("phone is erro!");
		}
		String currString = String.valueOf(System.currentTimeMillis()).substring(13 - 10);
		char[] tempch = new char[10];
		for (int i = 0; i < tempch.length; i++) {
			tempch[i] = currString.charAt((int) (Math.random() * 10));
		}
		String currentTime = new String(tempch);

		if (phone.length() > 10) {
			phone = phone.substring(phone.length() - 10);
		}

		char[] chs = currentTime.toCharArray();
		char[] cellchs = phone.toCharArray();
		int[] newchs = new int[10];
		for (int i = 0; i < 10; i++) {
			char c = chs[i];
			char b = cellchs[i];
			newchs[i] = (char) ((c * b * Math.random() * 10) % 10);
		}

		List<Integer> codeList = new ArrayList<Integer>();
		while (true) {
			int index = (int) (Math.random() * 10);
			if (index > newchs.length - 1) {
				continue;
			}
			int acode = newchs[index];
			acode = (int) ((acode * Math.random() * 10) % 10);
			codeList.add(acode);
			if (codeList.size() >= 6) {
				break;
			}
		}
		// 打乱validateCode的顺序
		StringBuffer validateCode = new StringBuffer();
		Collections.shuffle(codeList);
		for (int a : codeList) {
			validateCode.append(a);
		}
		return validateCode.toString();
	}

	/**
	 * 根据手机号，生成4位校验码
	 * 
	 * @param phone
	 * @return
	 */
	public static String generate4CodeByPhone(String phone) {
		if (phone == null || phone.length() != 11) {
			throw new BaseException("phone is erro!");
		}
		String currString = String.valueOf(System.currentTimeMillis()).substring(13 - 10);
		char[] tempch = new char[10];
		for (int i = 0; i < tempch.length; i++) {
			tempch[i] = currString.charAt((int) (Math.random() * 10));
		}
		String currentTime = new String(tempch);

		if (phone.length() > 10) {
			phone = phone.substring(phone.length() - 10);
		}

		char[] chs = currentTime.toCharArray();
		char[] cellchs = phone.toCharArray();
		int[] newchs = new int[10];
		for (int i = 0; i < 10; i++) {
			char c = chs[i];
			char b = cellchs[i];
			newchs[i] = (char) ((c * b * Math.random() * 10) % 10);
		}

		List<Integer> codeList = new ArrayList<Integer>();
		while (true) {
			int index = (int) (Math.random() * 10);
			if (index > newchs.length - 1) {
				continue;
			}
			int acode = newchs[index];
			acode = (int) ((acode * Math.random() * 10) % 10);
			codeList.add(acode);
			if (codeList.size() >= 4) {
				break;
			}
		}
		// 打乱validateCode的顺序
		StringBuffer validateCode = new StringBuffer();
		Collections.shuffle(codeList);
		for (int a : codeList) {
			validateCode.append(a);
		}
		return validateCode.toString();
	}

	public static void main(String[] args) {
		System.out.println(generate4CodeByPhone("13632579226"));
	}
}
