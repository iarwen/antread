package com.antread.bdp.framework.service;

import java.util.List;
import java.util.Set;

import com.antread.bdp.core.query.CompareType;
import com.antread.bdp.core.query.QueryFilterInfo;
import com.antread.bdp.core.query.SelectorInfo;
import com.antread.bdp.core.query.SortItem;
import com.antread.bdp.framework.dao.ICoreBaseDao;
import com.antread.bdp.framework.domain.AbstractCoreBaseInfo;

/**
 *  通用的服务接口基础对象，定义了基础服务的接口定义。
 * 
 * @author wentao_chang
 *
 */
public interface ICoreBaseService<T extends AbstractCoreBaseInfo> {

	/**
	 * 返回Dao对象的接口
	 * 
	 * @return
	 */
	public ICoreBaseDao<T> getDaoInstance();

	// 新增类
	public void addnew(T object);

	// 新增全部的类
	public void batchPersist(List<T> list);

	// 更新类
	public void update(String fid, T object);

	/**
	 * 
	 * @param fid
	 * @param object
	 * @param isAllowNoData
	 *            是否允许匹配不到数据的更新，默认不允许，如果按fid更新不到记录，则抛出异常。
	 */
	public void update(String fid, T object, boolean isAllowNoData);

	// 删除类
	public void deleteAll();

	public void delete(T object);

	public void delete(String fid);

	public void delete(T object, boolean isAllowNoData);

	public void delete(String fid, boolean isAllowNoData);

	public void delete(QueryFilterInfo ev);

	// 保存,自动判断新增还是更新
	public void save(T object);

	// 根据Id查询类
	public T findById(String fid);

	public T findById(String fid, SelectorInfo sic);

	public T findById(String fid, boolean isAllowNoData);

	public T findById(String fid, SelectorInfo sic, boolean isAllowNoData);

	public boolean exists(String fid);

	public boolean exists(QueryFilterInfo ev);

	public List<T> findByIds(Set<String> ids);

	public List<T> findByIds(Set<String> ids, SelectorInfo sic);

	public List<T> findByIds(Set<String> ids, List<SortItem> sorts);

	public List<T> findByIds(Set<String> ids, List<SortItem> sorts, SelectorInfo sic);

	// 按字段查询类
	public List<T> findByField(String fieldName, Object fieldValue);

	public List<T> findByField(String fieldName, Object fieldValue, List<SortItem> sorts);

	public List<T> findByField(String fieldName, Object fieldValue, SelectorInfo sic);

	public List<T> findByField(String fieldName, Object fieldValue, List<SortItem> sorts, SelectorInfo sic);

	public List<T> findByField(String fieldName, Object fieldValue, CompareType type);

	public List<T> findByField(String fieldName, Object fieldValue, CompareType type, List<SortItem> sorts);

	public List<T> findByField(String fieldName, Object fieldValue, CompareType type, SelectorInfo sic);

	public List<T> findByField(String fieldName, Object fieldValue, CompareType type, List<SortItem> sorts,
			SelectorInfo sic);

	// 按字段查询类，分页
	public List<T> findByFieldWithPaging(String fieldName, Object fieldValue, int currentPageIndex, int pageSize);

	public List<T> findByFieldWithPaging(String fieldName, Object fieldValue, int currentPageIndex, int pageSize,
			List<SortItem> sorts);

	public List<T> findByFieldWithPaging(String fieldName, Object fieldValue, int currentPageIndex, int pageSize,
			SelectorInfo sic);

	public List<T> findByFieldWithPaging(String fieldName, Object fieldValue, int currentPageIndex, int pageSize,
			List<SortItem> sorts, SelectorInfo sic);

	public List<T> findByFieldWithPaging(String fieldName, Object fieldValue, CompareType type, int currentPageIndex,
			int pageSize);

	public List<T> findByFieldWithPaging(String fieldName, Object fieldValue, CompareType type, int currentPageIndex,
			int pageSize, List<SortItem> sorts);

	public List<T> findByFieldWithPaging(String fieldName, Object fieldValue, CompareType type, int currentPageIndex,
			int pageSize, SelectorInfo sic);

	public List<T> findByFieldWithPaging(String fieldName, Object fieldValue, CompareType type, int currentPageIndex,
			int pageSize, List<SortItem> sorts, SelectorInfo sic);

	// 多字段查询方法
	public List<T> findByFields(QueryFilterInfo ev);

	public List<T> findByFields(QueryFilterInfo ev, List<SortItem> sorts);

	public List<T> findByFields(QueryFilterInfo ev, SelectorInfo sic);

	public List<T> findByFields(QueryFilterInfo ev, List<SortItem> sorts, SelectorInfo sic);

	// 多字段查询方法，分页
	public List<T> findByFieldsWithPaging(QueryFilterInfo ev, int currentPageIndex, int pageSize);

	public List<T> findByFieldsWithPaging(QueryFilterInfo ev, int currentPageIndex, int pageSize, List<SortItem> sorts);

	public List<T> findByFieldsWithPaging(QueryFilterInfo ev, int currentPageIndex, int pageSize, SelectorInfo sic);

	public List<T> findByFieldsWithPaging(QueryFilterInfo ev, int currentPageIndex, int pageSize, List<SortItem> sorts,
			SelectorInfo sic);

	// 按字段查询，返回单个结果类
	public T findByFieldSingle(String fieldName, Object fieldValue);

	public T findByFieldSingle(String fieldName, Object fieldValue, SelectorInfo sic);

	public T findByFieldSingle(String fieldName, Object fieldValue, List<SortItem> sorts);

	public T findByFieldSingle(String fieldName, Object fieldValue, List<SortItem> sorts, SelectorInfo sic);

	public T findByFieldSingle(String fieldName, Object fieldValue, CompareType type);

	public T findByFieldSingle(String fieldName, Object fieldValue, CompareType type, SelectorInfo sic);

	public T findByFieldSingle(String fieldName, Object fieldValue, CompareType type, List<SortItem> sorts);

	public T findByFieldSingle(String fieldName, Object fieldValue, CompareType type, List<SortItem> sorts,
			SelectorInfo sic);

	// 多字段查询，返单单个结果类
	public T findByFieldsSingle(QueryFilterInfo ev);

	public T findByFieldsSingle(QueryFilterInfo ev, SelectorInfo sic);

	public T findByFieldsSingle(QueryFilterInfo ev, List<SortItem> sorts);

	public T findByFieldsSingle(QueryFilterInfo ev, List<SortItem> sorts, SelectorInfo sic);

	// 查询全部数据的逻辑
	public List<T> findAll();

	public List<T> findAll(SelectorInfo sic);

	public List<T> findAll(List<SortItem> sorts);

	public List<T> findAll(List<SortItem> sorts, SelectorInfo sic);

	// 分页
	public List<T> findAllWithPaging(int currentPageIndex, int pageSize);

	public List<T> findAllWithPaging(int currentPageIndex, int pageSize, SelectorInfo sic);

	public List<T> findAllWithPaging(int currentPageIndex, int pageSize, List<SortItem> sorts);

	public List<T> findAllWithPaging(int currentPageIndex, int pageSize, List<SortItem> sorts, SelectorInfo sic);

}
