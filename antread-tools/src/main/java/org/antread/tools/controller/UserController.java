package com.small.sbtest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.small.bdp.core.context.Context;
import com.small.bdp.core.context.IContext;
import com.small.bdp.framework.dto.ResultDto;
import com.small.bdp.framework.exception.BizException;
import com.small.sbtest.system.domain.UserInfo;
import com.small.sbtest.system.service.IUserService;

@RestController
@RequestMapping("/user")
public class UserController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	@Qualifier("userServiceImpl")
	private IUserService userService;

	@RequestMapping(path = "/", method = { RequestMethod.GET })
	public @ResponseBody ResultDto getAll(HttpServletRequest request) {
		IContext ctx = Context.createDefaultContext();
		List<UserInfo> user = userService.findAll(ctx);
		ResultDto dto = new ResultDto();
		dto.setUserObject(user);
		return dto;
	}

	@RequestMapping(path = "/index", method = { RequestMethod.GET })
	public String index(HttpServletRequest request) {
		return "hello";
	}

	@RequestMapping(path = "/save", method = { RequestMethod.POST })
	public @ResponseBody ResultDto view(HttpServletRequest request, UserInfo user) {
		IContext ctx = Context.createDefaultContext();
		userService.save(ctx, user);
		ResultDto dto = new ResultDto();
		dto.setUserObject(user);
		return dto;
	}

	@RequestMapping(path = "/{id}", method = { RequestMethod.GET })
	public @ResponseBody ResultDto view(HttpServletRequest request, @PathVariable("id") String id) {
		logger.info("请求：" + id);
		IContext ctx = Context.createDefaultContext();
		UserInfo user = userService.findById(ctx, id);
		ResultDto dto = new ResultDto();
		dto.setUserObject(user);
		return dto;
	}

	@RequestMapping(path = "/{id}", method = { RequestMethod.DELETE })
	public @ResponseBody ResultDto delete(HttpServletRequest request, @PathVariable("id") String id) {
		logger.info("请求：" + id);
		IContext ctx = Context.createDefaultContext();
		userService.delete(ctx, id);
		ResultDto dto = new ResultDto();
		dto.setUserObject(id);
		return dto;
	}

	@RequestMapping("/get-by-email")
	public @ResponseBody ResultDto getByEmail(HttpServletRequest request, String email) {
		IContext ctx = Context.createDefaultContext();
		UserInfo user = userService.findByFieldSingle(ctx, "email", email);
		if (user != null) {
			ResultDto dto = new ResultDto();
			dto.setUserObject(user);
			return dto;
		}
		throw new BizException("nodata found");
	}
}
