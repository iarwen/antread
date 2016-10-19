package com.antread.bdp.framework.exception;

/**
 * 业务异常基类
 * 
 * @author wentao_chang
 *
 */
public class BizException extends BaseException {

	private static final long serialVersionUID = -86245449719864967L;

	public BizException() {
		super();
	}

	public BizException(String msg) {
		super(msg);
	}

	public BizException(int errorCode, String msg) {
		super(errorCode, msg);
	}

	public BizException(Throwable ex) {
		super(ex);
	}

	public BizException(String msg, Throwable ex) {
		super(msg, ex);
	}

	public BizException(int errorCode, String msg, Throwable ex) {
		super(errorCode, msg, ex);
	}
}
