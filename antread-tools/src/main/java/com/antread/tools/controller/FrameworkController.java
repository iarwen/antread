package com.antread.tools.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.antread.bdp.framework.dto.ResultDto;
import com.antread.tools.ApplicationMain;

@Controller
public class FrameworkController {

	@RequestMapping(path = "/", method = { RequestMethod.GET })
	public @ResponseBody ResultDto index(HttpServletRequest request) {
		ResultDto dto = new ResultDto();
		dto.setUserObject(ApplicationMain.getDesc());
		return dto;
	}

}
