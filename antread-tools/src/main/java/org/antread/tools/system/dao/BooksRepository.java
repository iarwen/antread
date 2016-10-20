package org.antread.tools.system.dao;

import java.util.List;

import org.antread.tools.system.domain.BooksInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface BooksRepository extends MongoRepository<BooksInfo, Long>, QueryByExampleExecutor<BooksInfo> {
	List<BooksInfo> findByTitle(String title);
}