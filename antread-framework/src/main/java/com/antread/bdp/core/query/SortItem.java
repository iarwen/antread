package com.antread.bdp.core.query;

/**
 * DAO层访问数据库时，需要排序时，使用的对象。
 * 
 * @author wentao_chang
 *
 */
public class SortItem {

	// 排序方式枚举
	public enum SortType {
		ASC, DESC
	}

	// 排序字段名
	private String fieldName;
	// 排序方式，默认升序
	private SortType sortType = SortType.ASC;

	public SortItem(String fieldName) {
		this(fieldName, SortType.ASC);
	}

	public SortItem(String fieldName, SortType sortType) {
		this.fieldName = fieldName;
		this.sortType = sortType;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public SortType getSortType() {
		return sortType;
	}

	public void setSortType(SortType sortType) {
		this.sortType = sortType;
	}

}
