package com.antread.tools.system.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

import com.antread.tools.system.domain.BooksInfo;

public interface BooksRepository extends MongoRepository<BooksInfo, Long>, QueryByExampleExecutor<BooksInfo> {
}