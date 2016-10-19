package com.antread.bdp.core.query;

public class FilterItemInfo {

	private String field;
	private Object value;
	private CompareType type = CompareType.Equals;

	public FilterItemInfo() {
	}

	public FilterItemInfo(String field, Object value) {
		this.field = field;
		this.value = value;
	}

	public FilterItemInfo(String field, Object value, CompareType type) {
		this.field = field;
		this.value = value;
		this.type = type;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public CompareType getType() {
		return type;
	}

	public void setType(CompareType type) {
		this.type = type;
	}

}
