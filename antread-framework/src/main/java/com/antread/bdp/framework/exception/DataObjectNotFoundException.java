package com.antread.bdp.framework.exception;

/**
 * 数据对象未找到异常
 * 
 * @author wentao_chang
 *
 */
public class DataObjectNotFoundException extends DataException {

	private static final long serialVersionUID = -6279531928735785245L;

	public DataObjectNotFoundException() {
		super();
	}

	public DataObjectNotFoundException(String msg) {
		super(msg);
	}

	public DataObjectNotFoundException(Throwable ex) {
		super(ex);
	}

	public DataObjectNotFoundException(String msg, Throwable ex) {
		super(msg, ex);
	}
}
