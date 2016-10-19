package com.antread.bdp.framework.dto;

/**
 * 请调用结果返回
 * 
 * @author wentao_chang
 *
 */
public class ResultDto {

	private boolean success = true;

	private String msg;

	private int errorCode = -1;

	private Object userObject;

	private long timestamp = System.currentTimeMillis();

	public ResultDto() {
	}

	public ResultDto(boolean success) {
		this.success = success;
	}

	public ResultDto(boolean success, String msg) {
		this.success = success;
		this.msg = msg;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getUserObject() {
		return userObject;
	}

	public void setUserObject(Object userObject) {
		this.userObject = userObject;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

}
