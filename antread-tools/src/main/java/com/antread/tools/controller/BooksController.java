package com.antread.tools.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.antread.bdp.framework.dto.ResultDto;
import com.antread.tools.system.service.IBooksService;

@Controller
@RequestMapping("/books")
public class BooksController {

	@Autowired
	private IBooksService booksService;

	@RequestMapping(path = "/search/{matcher}", method = { RequestMethod.GET })
	public @ResponseBody ResultDto getAll(HttpServletRequest request, @PathVariable String matcher,
			@RequestParam int page, @RequestParam int rows) {
		ResultDto dto = new ResultDto();
		dto.setUserObject(booksService.findByTitleOrISBN(matcher, page, rows));
		return dto;
	}
}
