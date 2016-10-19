package com.antread.bdp.framework.domain;

import javax.persistence.MappedSuperclass;

/**
 * 基础资料基类
 * 
 * @author wentao_chang
 *
 */
@MappedSuperclass
public abstract class DataBaseInfo extends AbstractCoreBaseInfo {

	private static final long serialVersionUID = 7635292032620678038L;

	private String number;

	private String name;

	private String remark;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
