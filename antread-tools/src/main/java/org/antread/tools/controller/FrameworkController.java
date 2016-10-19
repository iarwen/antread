package com.small.sbtest.controller;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.small.bdp.core.context.Context;
import com.small.bdp.core.context.IContext;
import com.small.bdp.framework.dto.ResultDto;
import com.small.sbtest.system.service.IUserService;

@Controller
public class FrameworkController {

	@Autowired
	@Qualifier("userServiceImpl")
	private IUserService userService;

	@RequestMapping(value = "/", method = { RequestMethod.GET, RequestMethod.POST })
	public String index(HttpServletRequest req, Map<String, Object> model) {
		IContext ctx = Context.createDefaultContext();
		model.put("time", new Date());
		model.put("users", userService.findAllWithPaging(ctx, 10, 200));
		return "index";
	}

	@RequestMapping(value = "/login", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login/login");

		return mv;
	}

	@RequestMapping(value = "/main", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView main() {
		ModelAndView mv = new ModelAndView("hello.jsp");

		return mv;
	}

	@RequestMapping(value = "/bdp/serverinfos", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView serverinfos() {
		ModelAndView mv = new ModelAndView("bdp_freamwork/serverinfos");

		return mv;
	}

	@RequestMapping(value = "/bdp/active", method = { RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody ResultDto active() {
		ResultDto rs = new ResultDto(true);
		return rs;
	}

}
