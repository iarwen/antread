package com.antread.bdp.core.query;

import java.util.ArrayList;
import java.util.List;

/**
 * DAO 查询数据时，指定查询字段范围的对象。
 * 
 * @author wentao_chang
 *
 */
public class SelectorInfo {

	private List<String> queryFields = new ArrayList<String>();

	public List<String> getQueryFields() {
		return queryFields;
	}

	public SelectorInfo() {
	}

	/**
	 * 添加需要查询的字段列表明
	 * 
	 * @param field
	 */
	public void addFied(String field) {
		if (queryFields.contains(field)) {
			return;
		}
		queryFields.add(field);
	}

	public boolean isEmpty() {
		return queryFields == null || queryFields.isEmpty();
	}

	public boolean isAll() {
		if (isEmpty()) {
			return true;
		}
		return queryFields.contains("*");
	}

}
