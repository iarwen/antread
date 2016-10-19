package com.antread.bdp.framework.service.impl;

import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;

import com.antread.bdp.core.query.CompareType;
import com.antread.bdp.core.query.QueryFilterInfo;
import com.antread.bdp.core.query.SelectorInfo;
import com.antread.bdp.core.query.SortItem;
import com.antread.bdp.framework.domain.AbstractCoreBaseInfo;
import com.antread.bdp.framework.exception.BaseException;
import com.antread.bdp.framework.service.ICoreBaseService;

/**
 * 服务层基础服务对象
 * 
 * 提供了常用的增、删、改、查相关的方法
 * 
 * @author wentao_chang
 *
 */
public abstract class AbstractCoreBaseService<T extends AbstractCoreBaseInfo> implements ICoreBaseService<T> {

	// 日志对象，子类可以直接使用输出
	protected Logger logger = Logger.getLogger(this.getClass());

	@Override
	public void addnew(T object) {
		getDaoInstance().addnew(object);
	}

	@Override
	public void batchPersist(List<T> list) {
		getDaoInstance().batchPersist(list);
	}

	@Override
	public void update(String fid, T object) {
		getDaoInstance().update(fid, object);
	}

	@Override
	public void update(String fid, T object, boolean isAllowNoData) {
		getDaoInstance().update(fid, object, isAllowNoData);
	}

	@Override
	public void deleteAll() {
		getDaoInstance().deleteAll();
	}

	@Override
	public void delete(T object) {
		getDaoInstance().delete(object);
	}

	@Override
	public void delete(String fid) {
		getDaoInstance().delete(fid);
	}

	@Override
	public void delete(T object, boolean isAllowNoData) {
		getDaoInstance().delete(object, isAllowNoData);
	}

	@Override
	public void delete(String fid, boolean isAllowNoData) {
		getDaoInstance().delete(fid, isAllowNoData);
	}

	@Override
	public void delete(QueryFilterInfo ev) {
		getDaoInstance().delete(ev);
	}

	@Override
	public void save(T object) {
		getDaoInstance().save(object);
	}

	@Override
	public T findById(String fid) {
		return getDaoInstance().findById(fid);
	}

	@Override
	public T findById(String fid, SelectorInfo sic) {
		return getDaoInstance().findById(fid, sic);
	}

	@Override
	public T findById(String fid, boolean isAllowNoData) {
		if (!isAllowNoData) {
			throw new BaseException("At service isAllowNoData must be true!");
		}
		return getDaoInstance().findById(fid, isAllowNoData);
	}

	@Override
	public T findById(String fid, SelectorInfo sic, boolean isAllowNoData) {
		return getDaoInstance().findById(fid, sic, isAllowNoData);
	}

	@Override
	public boolean exists(String fid) {
		return getDaoInstance().exists(fid);
	}

	@Override
	public boolean exists(QueryFilterInfo ev) {
		return getDaoInstance().exists(ev);
	}

	@Override
	public List<T> findByIds(Set<String> ids) {
		return getDaoInstance().findByIds(ids);
	}

	@Override
	public List<T> findByIds(Set<String> ids, SelectorInfo sic) {
		return getDaoInstance().findByIds(ids, sic);
	}

	@Override
	public List<T> findByIds(Set<String> ids, List<SortItem> sorts) {
		return getDaoInstance().findByIds(ids, sorts);
	}

	@Override
	public List<T> findByIds(Set<String> ids, List<SortItem> sorts, SelectorInfo sic) {
		return getDaoInstance().findByIds(ids, sorts, sic);
	}

	@Override
	public List<T> findByField(String fieldName, Object fieldValue) {
		return getDaoInstance().findByField(fieldName, fieldValue);
	}

	@Override
	public List<T> findByField(String fieldName, Object fieldValue, List<SortItem> sorts) {
		return getDaoInstance().findByField(fieldName, fieldValue, sorts);
	}

	@Override
	public List<T> findByField(String fieldName, Object fieldValue, SelectorInfo sic) {
		return getDaoInstance().findByField(fieldName, fieldValue, sic);
	}

	@Override
	public List<T> findByField(String fieldName, Object fieldValue, List<SortItem> sorts, SelectorInfo sic) {
		return getDaoInstance().findByField(fieldName, fieldValue, sorts, sic);
	}

	@Override
	public List<T> findByField(String fieldName, Object fieldValue, CompareType type) {
		return getDaoInstance().findByField(fieldName, fieldValue, type);
	}

	@Override
	public List<T> findByField(String fieldName, Object fieldValue, CompareType type, List<SortItem> sorts) {
		return getDaoInstance().findByField(fieldName, fieldValue, type, sorts);
	}

	@Override
	public List<T> findByField(String fieldName, Object fieldValue, CompareType type, SelectorInfo sic) {
		return getDaoInstance().findByField(fieldName, fieldValue, type, sic);
	}

	@Override
	public List<T> findByField(String fieldName, Object fieldValue, CompareType type, List<SortItem> sorts,
			SelectorInfo sic) {
		return getDaoInstance().findByField(fieldName, fieldValue, type, sorts, sic);
	}

	@Override
	public List<T> findByFieldWithPaging(String fieldName, Object fieldValue, int currentPageIndex, int pageSize) {
		return getDaoInstance().findByFieldWithPaging(fieldName, fieldValue, currentPageIndex, pageSize);
	}

	@Override
	public List<T> findByFieldWithPaging(String fieldName, Object fieldValue, int currentPageIndex, int pageSize,
			List<SortItem> sorts) {
		return getDaoInstance().findByFieldWithPaging(fieldName, fieldValue, currentPageIndex, pageSize, sorts);
	}

	@Override
	public List<T> findByFieldWithPaging(String fieldName, Object fieldValue, int currentPageIndex, int pageSize,
			SelectorInfo sic) {
		return getDaoInstance().findByFieldWithPaging(fieldName, fieldValue, currentPageIndex, pageSize, sic);
	}

	@Override
	public List<T> findByFieldWithPaging(String fieldName, Object fieldValue, int currentPageIndex, int pageSize,
			List<SortItem> sorts, SelectorInfo sic) {
		return getDaoInstance().findByFieldWithPaging(fieldName, fieldValue, currentPageIndex, pageSize, sorts, sic);
	}

	@Override
	public List<T> findByFieldWithPaging(String fieldName, Object fieldValue, CompareType type, int currentPageIndex,
			int pageSize) {
		return getDaoInstance().findByFieldWithPaging(fieldName, fieldValue, type, currentPageIndex, pageSize);
	}

	@Override
	public List<T> findByFieldWithPaging(String fieldName, Object fieldValue, CompareType type, int currentPageIndex,
			int pageSize, List<SortItem> sorts) {
		return getDaoInstance().findByFieldWithPaging(fieldName, fieldValue, type, currentPageIndex, pageSize, sorts);
	}

	@Override
	public List<T> findByFieldWithPaging(String fieldName, Object fieldValue, CompareType type, int currentPageIndex,
			int pageSize, SelectorInfo sic) {
		return getDaoInstance().findByFieldWithPaging(fieldName, fieldValue, currentPageIndex, pageSize, sic);
	}

	@Override
	public List<T> findByFieldWithPaging(String fieldName, Object fieldValue, CompareType type, int currentPageIndex,
			int pageSize, List<SortItem> sorts, SelectorInfo sic) {
		return getDaoInstance().findByFieldWithPaging(fieldName, fieldValue, type, currentPageIndex, pageSize, sorts,
				sic);
	}

	@Override
	public List<T> findByFields(QueryFilterInfo ev) {
		return getDaoInstance().findByFields(ev);
	}

	@Override
	public List<T> findByFields(QueryFilterInfo ev, List<SortItem> sorts) {
		return getDaoInstance().findByFields(ev, sorts);
	}

	@Override
	public List<T> findByFields(QueryFilterInfo ev, SelectorInfo sic) {
		return getDaoInstance().findByFields(ev, sic);
	}

	@Override
	public List<T> findByFields(QueryFilterInfo ev, List<SortItem> sorts, SelectorInfo sic) {
		return getDaoInstance().findByFields(ev, sorts, sic);
	}

	@Override
	public List<T> findByFieldsWithPaging(QueryFilterInfo ev, int currentPageIndex, int pageSize) {
		return getDaoInstance().findByFieldsWithPaging(ev, currentPageIndex, pageSize);
	}

	@Override
	public List<T> findByFieldsWithPaging(QueryFilterInfo ev, int currentPageIndex, int pageSize,
			List<SortItem> sorts) {
		return getDaoInstance().findByFieldsWithPaging(ev, currentPageIndex, pageSize, sorts);
	}

	@Override
	public List<T> findByFieldsWithPaging(QueryFilterInfo ev, int currentPageIndex, int pageSize, SelectorInfo sic) {
		return getDaoInstance().findByFieldsWithPaging(ev, currentPageIndex, pageSize, sic);
	}

	@Override
	public List<T> findByFieldsWithPaging(QueryFilterInfo ev, int currentPageIndex, int pageSize, List<SortItem> sorts,
			SelectorInfo sic) {
		return getDaoInstance().findByFieldsWithPaging(ev, currentPageIndex, pageSize, sorts, sic);
	}

	@Override
	public T findByFieldSingle(String fieldName, Object fieldValue) {
		return getDaoInstance().findByFieldSingle(fieldName, fieldValue);
	}

	@Override
	public T findByFieldSingle(String fieldName, Object fieldValue, SelectorInfo sic) {
		return getDaoInstance().findByFieldSingle(fieldName, fieldValue, sic);
	}

	@Override
	public T findByFieldSingle(String fieldName, Object fieldValue, List<SortItem> sorts) {
		return getDaoInstance().findByFieldSingle(fieldName, fieldValue, sorts);
	}

	@Override
	public T findByFieldSingle(String fieldName, Object fieldValue, List<SortItem> sorts, SelectorInfo sic) {
		return getDaoInstance().findByFieldSingle(fieldName, fieldValue, sorts, sic);
	}

	@Override
	public T findByFieldSingle(String fieldName, Object fieldValue, CompareType type) {
		return getDaoInstance().findByFieldSingle(fieldName, fieldValue, type);
	}

	@Override
	public T findByFieldSingle(String fieldName, Object fieldValue, CompareType type, SelectorInfo sic) {
		return getDaoInstance().findByFieldSingle(fieldName, fieldValue, type, sic);
	}

	@Override
	public T findByFieldSingle(String fieldName, Object fieldValue, CompareType type, List<SortItem> sorts) {
		return getDaoInstance().findByFieldSingle(fieldName, fieldValue, type, sorts);
	}

	@Override
	public T findByFieldSingle(String fieldName, Object fieldValue, CompareType type, List<SortItem> sorts,
			SelectorInfo sic) {
		return getDaoInstance().findByFieldSingle(fieldName, fieldValue, type, sorts, sic);
	}

	@Override
	public T findByFieldsSingle(QueryFilterInfo ev) {
		return getDaoInstance().findByFieldsSingle(ev);
	}

	@Override
	public T findByFieldsSingle(QueryFilterInfo ev, SelectorInfo sic) {
		return getDaoInstance().findByFieldsSingle(ev, sic);
	}

	@Override
	public T findByFieldsSingle(QueryFilterInfo ev, List<SortItem> sorts) {
		return getDaoInstance().findByFieldsSingle(ev, sorts);
	}

	@Override
	public T findByFieldsSingle(QueryFilterInfo ev, List<SortItem> sorts, SelectorInfo sic) {
		return getDaoInstance().findByFieldsSingle(ev, sorts, sic);
	}

	@Override
	public List<T> findAll() {
		return getDaoInstance().findAll();
	}

	@Override
	public List<T> findAll(SelectorInfo sic) {
		return getDaoInstance().findAll(sic);
	}

	@Override
	public List<T> findAll(List<SortItem> sorts) {
		return getDaoInstance().findAll(sorts);
	}

	@Override
	public List<T> findAll(List<SortItem> sorts, SelectorInfo sic) {
		return getDaoInstance().findAll(sorts, sic);
	}

	@Override
	public List<T> findAllWithPaging(int currentPageIndex, int pageSize) {
		return getDaoInstance().findAllWithPaging(currentPageIndex, pageSize);
	}

	@Override
	public List<T> findAllWithPaging(int currentPageIndex, int pageSize, SelectorInfo sic) {
		return getDaoInstance().findAllWithPaging(currentPageIndex, pageSize, sic);
	}

	@Override
	public List<T> findAllWithPaging(int currentPageIndex, int pageSize, List<SortItem> sorts) {
		return getDaoInstance().findAllWithPaging(currentPageIndex, pageSize, sorts);
	}

	@Override
	public List<T> findAllWithPaging(int currentPageIndex, int pageSize, List<SortItem> sorts, SelectorInfo sic) {
		return getDaoInstance().findAllWithPaging(currentPageIndex, pageSize, sorts, sic);
	}

}
