package com.antread.bdp.framework.exception;

/**
 * 数据访问层的异常基类
 * 
 * @author wentao_chang
 *
 */
public class DataException extends BaseException {

	private static final long serialVersionUID = 8097726573340316512L;

	public DataException() {
		super();
	}

	public DataException(String msg) {
		super(msg);
	}

	public DataException(Throwable ex) {
		super(ex);
	}

	public DataException(String msg, Throwable ex) {
		super(msg, ex);
	}
}
