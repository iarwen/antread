package com.antread.bdp.util;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * SockUtil工具类
 * 
 * @author wentao_chang
 *
 */
public class SocketUtils {

	/**
	 * 获取空闲端口
	 * 
	 * @return
	 */
	public static int getFreePort() {

		try {
			ServerSocket serverSocket = new ServerSocket(0);
			try {
				int port = serverSocket.getLocalPort();
				return port;
			} finally {
				serverSocket.close();
			}
		} catch (IOException e) {
			return -1;
		}

	}
}
