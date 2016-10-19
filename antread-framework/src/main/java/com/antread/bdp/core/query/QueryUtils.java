package com.antread.bdp.core.query;

import java.util.ArrayList;
import java.util.List;

import com.antread.bdp.core.query.SortItem.SortType;

/**
 * 查询工具类
 * 
 * @author wentao_chang
 *
 */
public abstract class QueryUtils {

	/**
	 * 构造排序SQL子语句
	 * 
	 * @param sorts
	 * @return
	 */
	public static String buildOrderBySql(List<SortItem> sorts) {
		if (sorts == null || sorts.isEmpty()) {
			return "";
		}
		StringBuffer order = new StringBuffer();

		for (SortItem item : sorts) {
			order.append("," + item.getFieldName()
					+ (item.getSortType() == SortType.DESC ? " desc" : "") + "");
		}
		if (order.length() > 0) {
			return " order by " + order.substring(1) + " ";
		} else {
			return "";
		}
	}

	/**
	 * 构造查询子SQL语句
	 * 
	 * @param selector
	 * @return
	 */
	public static String buildSelectorSql(SelectorInfo selector) {
		if (selector == null || selector.isEmpty() || selector.isAll()) {
			return "";
		}

		StringBuffer select = new StringBuffer();

		for (String item : selector.getQueryFields()) {
			select.append("," + item);
		}

		if (select.length() > 0) {
			return "select " + select.substring(1) + " ";
		} else {
			return "";
		}
	}

	// 测试
	public static void main(String[] args) {

		// 测试排序输入逻辑是否正确
		{
			List<SortItem> sorts = new ArrayList<SortItem>();

			System.out.println("empty list is :" + buildOrderBySql(sorts));

			SortItem item = new SortItem("a", SortType.DESC);
			sorts.add(item);

			item = new SortItem("bb", SortType.ASC);
			sorts.add(item);

			item = new SortItem("ccc");
			sorts.add(item);

			System.out.println("full list is :" + buildOrderBySql(sorts));
		}

		// 测试查询拼接逻辑是否正确
		{
			SelectorInfo selector = new SelectorInfo();
			System.out.println("empty sql  is :" + buildSelectorSql(selector));

			selector.addFied("name");
			System.out.println("one sql  is :" + buildSelectorSql(selector));

			selector.addFied("number");
			System.out.println("two sql  is :" + buildSelectorSql(selector));

			selector.addFied("*");
			System.out.println("* sql  is :" + buildSelectorSql(selector));
		}

	}
}
