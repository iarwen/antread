package com.antread.bdp.core.query;

import java.util.ArrayList;
import java.util.List;

import com.antread.bdp.framework.exception.BaseException;
import com.antread.bdp.util.StringUtils;

public class QueryFilterInfo {

	private List<FilterItemInfo> filterItems = new ArrayList<FilterItemInfo>();

	public List<FilterItemInfo> getFilterItems() {
		return filterItems;
	}

	private String markString = "";

	public void addFilterItemInfo(FilterItemInfo itemInfo) {
		filterItems.add(itemInfo);
	}

	public void addFilterItemInfo(String field, Object value) {

		filterItems.add(new FilterItemInfo(field, value));
	}

	public void addFilterItemInfo(String field, CompareType type) {
		if (type != CompareType.IsNull && type != CompareType.IsNotNull) {
			throw new IllegalArgumentException("params type must is null or is not null!");
		}
		filterItems.add(new FilterItemInfo(field, null, type));
	}

	public void addFilterItemInfo(String field, Object value, CompareType type) {

		filterItems.add(new FilterItemInfo(field, value, type));
	}

	public void clearFilterItemInfo() {
		this.filterItems.clear();
	}

	public String getMarkString() {

		if (StringUtils.isEmptyString(markString) && this.filterItems.size() > 0) {

			StringBuffer ss = new StringBuffer();

			for (int i = 0; i < this.filterItems.size(); i++) {
				ss.append("and #" + i + "  ");
			}

			return ss.substring(3);

		} else {
			return markString;
		}
	}

	public void setMarkString(String markString) {

		if (!StringUtils.isEmptyString(markString)) {
			char[] chs = markString.toCharArray();
			int count = 0;
			for (char c : chs) {
				if (c == '#') {
					count++;
				}
			}
			if (count != this.filterItems.size()) {
				throw new BaseException("the markString size not equals fileteritem size.");
			}
		}

		this.markString = markString;
	}

	public QueryFilterInfo mergeFilter(QueryFilterInfo f) {
		return mergeFilter(f, "and");
	}

	/**
	 * 
	 * @param f
	 * @param relation
	 *            and or
	 * @return
	 */
	public QueryFilterInfo mergeFilter(QueryFilterInfo f, String relation) {
		if (f == null || f.getFilterItems().isEmpty()) {
			throw new BaseException("merge filter is null!");
		}
		if (!"and".equals(relation) && !"or".equals(relation)) {
			throw new BaseException("relation must and or or !");
		}

		// this 与 f 进行融合

		List<FilterItemInfo> oldlist = this.getFilterItems();
		String oldmarkstring = this.getMarkString();
		List<FilterItemInfo> newlist = f.getFilterItems();
		String newmarkstring = f.getMarkString();

		QueryFilterInfo newfilter = new QueryFilterInfo();

		for (FilterItemInfo ii : oldlist) {
			newfilter.addFilterItemInfo(ii);
		}

		for (FilterItemInfo ii : newlist) {
			newfilter.addFilterItemInfo(ii);
		}

		// 设置新的markstring
		int oldSize = oldlist.size();

		for (int i = newlist.size() - 1; i >= 0; i--) {
			newmarkstring = newmarkstring.replaceFirst(("#" + i), ("#" + (i + oldSize)));
		}

		if (StringUtils.isEmptyString(oldmarkstring)) {
			newfilter.setMarkString(" (" + newmarkstring + ") ");
		} else {
			newfilter.setMarkString("(" + oldmarkstring + ") " + relation + " (" + newmarkstring + ") ");
		}

		return newfilter;
	}

}
