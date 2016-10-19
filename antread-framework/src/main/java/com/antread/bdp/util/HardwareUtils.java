package com.antread.bdp.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Calendar;

import com.antread.bdp.framework.exception.BaseException;

public class HardwareUtils {
	public static void main(String[] args) {
		System.out.println(getLocalMacAddress());

		System.out.println(System.getProperty("os.name"));

		Calendar cal = Calendar.getInstance();
		long m = Long.parseLong("1439020289073");
		cal.setTimeInMillis(m);

		System.out.println(DateUtils.formatDetialDate(cal.getTime()));

		String s = " ether 00:16:3e:00:08:a6  txqueuelen 1000  (Ethernet)    ";
		String mac = s.substring(s.indexOf("ether") + "ether".length() + 1, s.indexOf("ether") + "ether".length() + 1 + 17).trim();
		System.out.print(mac);
	}

	public static String getLinuxMacAddress() {
		String mac = null;
		BufferedReader bufferedReader = null;
		Process process = null;
		try {
			/**
			 * Unix下的命令，一般取eth0作为本地主网卡 显示信息中包含有mac地址信息
			 */
			process = Runtime.getRuntime().exec("ifconfig eth0");
			bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line = null;
			int index = -1;
			while ((line = bufferedReader.readLine()) != null) {
				/**
				 * 寻找标示字符串[hwaddr]
				 */
				index = line.toLowerCase().indexOf("hwaddr");
				/**
				 * 找到了
				 */
				if (index != -1) {
					/**
					 * 取出mac地址并去除2边空格
					 */
					mac = line.substring(index + "hwaddr".length() + 1).trim();
					break;
				} else {
					index = line.toLowerCase().indexOf("ether");
					/**
					 * 找到了
					 */
					if (index != -1) {
						/**
						 * 取出mac地址并去除2边空格
						 */
						mac = line.substring(line.indexOf("ether") + "ether".length() + 1, line.indexOf("ether") + "ether".length() + 1 + 17).trim();

						break;
					}
				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			bufferedReader = null;
			process = null;
		}

		return mac != null ? mac.toUpperCase() : "";
	}

	public static String getLocalMacAddress() {
		if ("linux".equals(System.getProperty("os.name").toLowerCase())) {
			return getLinuxMacAddress();
		} else {
			try {
				InetAddress ia = InetAddress.getLocalHost();

				// 获取网卡，获取地址
				byte[] mac = NetworkInterface.getByInetAddress(ia).getHardwareAddress();
				StringBuffer sb = new StringBuffer("");
				for (int i = 0; i < mac.length; i++) {
					if (i != 0) {
						sb.append("-");
					}
					// 字节转换为整数
					int temp = mac[i] & 0xff;
					String str = Integer.toHexString(temp);
					if (str.length() == 1) {
						sb.append("0" + str);
					} else {
						sb.append(str);
					}
				}
				return sb.toString().toUpperCase();
			} catch (UnknownHostException | SocketException e) {
				throw new BaseException("get mac address erorr!");
			}
		}
	}
}
