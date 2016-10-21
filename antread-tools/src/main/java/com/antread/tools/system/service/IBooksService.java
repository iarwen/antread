package com.antread.tools.system.service;

import org.springframework.data.domain.Page;

import com.antread.tools.system.domain.BooksInfo;

public interface IBooksService {
	public Page<BooksInfo> findByTitleOrISBN(String matcher, int page, int rows);
}
