package com.antread.tools.system.service.impl;

import static org.springframework.data.domain.ExampleMatcher.matching;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.antread.bdp.util.NumberUtils;
import com.antread.tools.system.dao.BooksRepository;
import com.antread.tools.system.domain.BooksInfo;
import com.antread.tools.system.service.IBooksService;

@Service
public class BooksServiceImpl implements IBooksService {

	@Autowired
	private BooksRepository booksRepository;

	@Override
	public Page<BooksInfo> findByTitleOrISBN(String matcher, int page, int rows) {
		// 模糊查询
		BooksInfo bookinfo = new BooksInfo();
		if (NumberUtils.isNonNegativeInteger(matcher)) {
			bookinfo.setIsbn13(matcher);
		} else {
			bookinfo.setTitle(matcher);
		}
		Example<BooksInfo> example = Example.of(bookinfo,
				matching().withStringMatcher(StringMatcher.CONTAINING).//
						withIgnorePaths("id", "pages").// base type
						withIgnoreNullValues()); // default

		Page<BooksInfo> list = booksRepository.findAll(example, new PageRequest(page-1, rows, Direction.DESC, "title"));
		return list;
	}

}
