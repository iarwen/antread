package com.antread.bdp.report.dao.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.context.ContextLoaderListener;

import com.antread.bdp.report.dao.ICoreReportBaseDao;

/**
 * 报表的核心数据访问类
 * 
 * @author wentao_chang
 *
 */
public class AbstractCoreReportBaseDao implements ICoreReportBaseDao {

	// 配置的jdbcTemplate实现实例

	protected JdbcTemplate jdbcTemplate = null;

	protected String getDataSourceType() {
		return "main";
	}

	/**
	 * 获取jdbcTemplate模板
	 * 
	 * @return
	 */
	public synchronized JdbcTemplate getJdbcTemplate() {
		if (jdbcTemplate == null) {
			jdbcTemplate = initJdbcTemplate();
		}
		return jdbcTemplate;
	}

	protected JdbcTemplate initJdbcTemplate() {

		return (JdbcTemplate) ContextLoaderListener.getCurrentWebApplicationContext().getBean(
				"jdbcTemplate_" + getDataSourceType());
	}
}
