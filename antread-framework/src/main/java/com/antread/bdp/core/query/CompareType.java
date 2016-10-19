package com.antread.bdp.core.query;

public class CompareType {

	// ====================定义常量==================//
	// 等于
	public static final CompareType Equals = new CompareType("=");

	public static final CompareType NotEquals = new CompareType("!=");

	// 大于
	public static final CompareType GreaterThan = new CompareType(">");

	// 大于等于
	public static final CompareType GreaterThanEqual = new CompareType(">=");

	// 小于
	public static final CompareType LessThan = new CompareType("<");

	// 小于等于
	public static final CompareType LessThanEqual = new CompareType("<=");

	// 小于等于
	public static final CompareType Like = new CompareType("like");

	public static final CompareType NotLike = new CompareType("not like");
	// in 查询
	public static final CompareType In = new CompareType("in");

	// sql 子查询
	public static final CompareType InnerSql = new CompareType("in");

	// 检查是否存在
	public static final CompareType Exists = new CompareType("exists");

	// 不存在
	public static final CompareType NotExists = new CompareType("not exists");
	
	//为空
	public static final CompareType IsNull = new CompareType("is null");
	
	//不为空
	public static final CompareType IsNotNull = new CompareType("is not null");

	private String operator = "";

	private CompareType(String operator) {
		this.operator = operator;
	}

	public String getOperator() {
		return operator;
	}

	@Override
	public String toString() {
		return operator;
	}

	// 是否需要括号
	public boolean isNeedBrackets() {

		if (this == CompareType.In || this == CompareType.Exists
				|| this == CompareType.NotExists
				|| this == CompareType.InnerSql) {
			return true;
		}

		return false;
	}

	// 不用参数方式，直接替换SQL中的位置
	public boolean isReplaceInSql() {
		if (this == CompareType.InnerSql || this == CompareType.Exists
				|| this == CompareType.NotExists) {
			return true;
		}

		return false;
	}

}
