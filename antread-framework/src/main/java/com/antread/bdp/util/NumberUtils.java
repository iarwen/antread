package com.antread.bdp.util;

import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberUtils {

	/**
	 * 移除BigDecimal的尾巴0
	 * 
	 * @param b
	 * @return
	 */
	public static String removeTailZero(BigDecimal b) {
		if (b == null || b.signum() == 0) {
			return "0";
		}
		String s = b.toString();
		if (s.length() == 1) {
			return s;
		}
		int i, len = s.length();
		for (i = 0; i < len; i++)
			if (s.charAt(len - 1 - i) != '0')
				break;
		if (s.charAt(len - i - 1) == '.')
			return s.substring(0, len - i - 1);
		return s.substring(0, len - i);
	}

	public static String NONNEGATIVEINTEGER = "^(0|[1-9][0-9]*)$";// 匹配非负整数（正整数和零）

	/**
	 * 判断一个字符串是否为非负浮点数
	 */
	public static boolean isNonNegativeNumber(String numberStr) {
		if (StringUtils.isEmptyString(numberStr)) {
			return false;
		}
		BigDecimal b;
		try {
			b = new BigDecimal(numberStr);
		} catch (Exception e) {
			return false;
		}
		if (b.signum() < 0) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * 判断一个字符串是否为正整数
	 */
	public static boolean isNonNegativeInteger(String numberStr) {
		if (StringUtils.isEmptyString(numberStr)) {
			return false;
		}
		Pattern p = Pattern.compile(NONNEGATIVEINTEGER);
		Matcher m = p.matcher(numberStr);
		return m.find();
	}

	public static void main(String[] args) {
		System.out.println(isNonNegativeNumber("16800寸0"));
		System.out.println(isNonNegativeInteger("-0"));
		System.out.println(isNonNegativeInteger("0"));
		System.out.println(isNonNegativeInteger("1.0"));
		System.out.println(patternCode("手机号：(18210948769)店铺信456456息"));
	}

	/**
	 * 捕获字符串中的手机号码
	 * 
	 * @param patternContent
	 * @return
	 */
	public static String patternCode(String patternContent) {
		String patternCoder = "(?<!\\d)\\d{11}(?!\\d)";
		if (StringUtils.isEmptyString(patternContent)) {
			return "";
		}
		Pattern p = Pattern.compile(patternCoder);
		Matcher matcher = p.matcher(patternContent);
		if (matcher.find()) {
			return matcher.group();
		}
		return "";
	}
}
