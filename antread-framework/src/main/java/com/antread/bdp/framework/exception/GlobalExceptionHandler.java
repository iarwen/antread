package com.antread.bdp.framework.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.antread.bdp.framework.dto.ResultDto;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ResultDto defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
		ResultDto r = new ResultDto();
		r.setMsg(e.getMessage());
		r.setErrorCode(-5000);
		r.setSuccess(false);
		return r;
	}

	@ExceptionHandler(value = BizException.class)
	@ResponseBody
	public ResultDto jsonErrorHandler(HttpServletRequest req, BizException e) throws Exception {
		ResultDto r = new ResultDto();
		r.setMsg(e.getMessage());
		r.setErrorCode(-1000);
		r.setSuccess(false);
		return r;
	}

}
