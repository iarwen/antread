package com.antread.bdp.core.db.gen;

import java.beans.Transient;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.Table;

import com.antread.bdp.framework.domain.AbstractCoreBaseInfo;

/**
 * 
 * JavaBean生成数SQL的数据库工具类
 * 
 * @author wentao_chang
 *
 */
public abstract class BeanGenSqlUtils {

	/**
	 * 数据库类型
	 * 
	 * @author wentao_chang
	 *
	 */
	public enum DBType {
		SQLIte3, MySQL
	}

	/**
	 * 根据JavaBean类生成建表SQL
	 * 
	 * @param beanClass
	 * @param dbtype
	 * @return
	 */
	public static String genCreateTableSql(Class<? extends AbstractCoreBaseInfo> beanClass, DBType dbtype) {

		String sqlStr = "CREATE TABLE \"{0}\" ({1});";
		if (dbtype == DBType.MySQL) {
			sqlStr = "CREATE TABLE {0} ({1});";
		}

		String sqlStr2 = subfield(beanClass, dbtype);
		Class<?> c = beanClass.getSuperclass();
		while (c != null) {
			sqlStr2 += subfield(c, dbtype);
			c = c.getSuperclass();
		}
		String tablename = "TNAME";

		Table[] tt = beanClass.getAnnotationsByType(Table.class);
		if (tt != null && tt.length > 0) {
			tablename = tt[0].name();
		}
		String sql = MessageFormat.format(sqlStr, tablename, sqlStr2.substring(1));
		return sql;
	}

	private static String subfield(Class<?> c, DBType dbtype) {
		Field[] fields = c.getDeclaredFields();
		String sqlFormat = "\"{0}\" {1}";
		if (dbtype == DBType.MySQL) {
			sqlFormat = "{0} {1}";
		}
		String sqlStr2 = "";
		for (Field f : fields) {
			String name = f.getName();
			if ("serialVersionUID".equals(name)) {
				continue;
			}

			Transient[] tts = f.getAnnotationsByType(Transient.class);
			if (tts != null && tts.length > 0) {
				continue;
			}

			boolean isfid = false;
			Id[] ants = f.getAnnotationsByType(Id.class);
			if (ants != null && ants.length > 0) {
				isfid = true;
			}

			if (isfid) {
				sqlStr2 += "," + MessageFormat.format(sqlFormat, name, " " + sqltype(f.getType(), dbtype, 44) + " PRIMARY KEY ");
			} else {
				sqlStr2 += "," + MessageFormat.format(sqlFormat, name, name.endsWith("Id") ? sqltype(f.getType(), dbtype, 44) : sqltype(f.getType(), dbtype));
			}

		}
		return sqlStr2;
	}

	private static String sqltype(Class<?> c, DBType dbtype) {
		return sqltype(c, dbtype, 255);
	}

	private static String sqltype(Class<?> c, DBType dbtype, int length) {

		if (dbtype == DBType.SQLIte3) {
			if (c.equals(String.class)) {
				return "VARCHAR";
			} else if (c.equals(BigDecimal.class) || c.equals(double.class) || c.equals(float.class)) {
				return "REAL";
			} else if (c.equals(boolean.class) || c.equals(Boolean.class) || c.equals(long.class) || c.equals(Long.class) || c.equals(int.class)
					|| c.equals(Integer.class)) {
				return "INTEGER";
			} else if (c.equals(Date.class)) {
				return "DATETIME";
			}

			return "NULL";
		} else if (dbtype == DBType.MySQL) {

			if (c.equals(String.class)) {
				return "varchar(" + length + ")";
			} else if (c.equals(BigDecimal.class) || c.equals(double.class) || c.equals(float.class)) {
				return "decimal(28,10)";
			} else if (c.equals(boolean.class) || c.equals(Boolean.class) || c.equals(int.class) || c.equals(Integer.class)) {
				return "int";
			} else if (c.equals(long.class) || c.equals(Long.class)) {
				return "bigint";
			} else if (c.equals(Date.class)) {
				return "datetime";
			}

			return "NULL";
		}
		return "";
	}

	@SuppressWarnings("rawtypes")
	public static List<Class> getEntityClassList() {
		List<Class> classList = new ArrayList<Class>();
		return classList;
	}

}
