package com.antread.bdp.framework.exception;

/**
 * 框架中所有异常的基类
 * 
 * @author wentao_chang
 *
 */
public class BaseException extends RuntimeException {

	private static final long serialVersionUID = 7356697899136717010L;

	private int errorCode = -1;

	public BaseException() {
		super();
	}

	public BaseException(String msg) {
		super(msg);
	}

	public BaseException(Throwable ex) {
		super(ex);
	}

	public BaseException(String msg, Throwable ex) {
		super(msg, ex);
	}

	public BaseException(int errorCode, String msg) {
		super(msg);
		this.errorCode = errorCode;
	}

	public BaseException(int errorCode, String msg, Throwable ex) {
		super(msg, ex);
		this.errorCode = errorCode;
	}

	@Override
	public String toString() {
		return super.toString();
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

}
