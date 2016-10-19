package com.small.sbtest.system.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.small.bdp.framework.domain.AbstractCoreBaseInfo;

@Entity
@Table(name = "t_sys_user")
public class UserInfo extends AbstractCoreBaseInfo {

	private static final long serialVersionUID = -2627841764412910886L;

	@NotNull
	private String email;

	@NotNull
	private String name;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}