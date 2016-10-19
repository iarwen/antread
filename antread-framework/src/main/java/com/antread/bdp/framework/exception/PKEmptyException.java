package com.antread.bdp.framework.exception;

/**
 * 数据对象未找到异常
 * 
 * @author wentao_chang
 *
 */
public class PKEmptyException extends DataException {

	private static final long serialVersionUID = -7651385073160156621L;

	public PKEmptyException() {
		super();
	}

	public PKEmptyException(String msg) {
		super(msg);
	}

	public PKEmptyException(Throwable ex) {
		super(ex);
	}

	public PKEmptyException(String msg, Throwable ex) {
		super(msg, ex);
	}
}
