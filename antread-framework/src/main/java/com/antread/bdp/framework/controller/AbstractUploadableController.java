package com.antread.bdp.framework.controller;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

public abstract class AbstractUploadableController {
	public File handlerUploadFile(HttpServletRequest request)
			throws IllegalStateException, IOException {
		// 解析器解析request的上下文
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		// 先判断request中是否包涵multipart类型的数据，
		if (multipartResolver.isMultipart(request)) {
			// 再将request中的数据转化成multipart类型的数据
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator<String> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				MultipartFile file = multiRequest.getFile((String) iter.next());
				if (file != null) {
					File temp = new File(System.getProperty("java.io.tmpdir")
							+ File.separatorChar + UUID.randomUUID().toString()+"_"+ file.getOriginalFilename());
					if (temp.exists()) {
						temp.delete();
					}
					file.transferTo(temp);
					return temp;
				}
			}
		}
		return null;
	}

}
