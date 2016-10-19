package com.antread.bdp.util;

public class StringUtils {

	public static boolean isEmptyString(String str, boolean isAutoTrim) {
		if (isAutoTrim && str != null) {
			str = str.trim();
		}
		if (str == null || str.length() == 0) {
			return true;
		}
		return false;
	}

	public static boolean isEmptyString(String str) {
		return isEmptyString(str, false);
	}

	public static boolean equals(String str1, String str2) {
		if (str1 == null && str2 == null) {
			return true;
		}

		return str1 != null ? str1.equals(str2) : str2.equals(str1);
	}

	public static boolean equalsIgnoreCase(String str1, String str2) {
		if (str1 == null && str2 == null) {
			return true;
		}

		return str1 != null ? str1.equalsIgnoreCase(str2) : str2.equalsIgnoreCase(str1);
	}

}
