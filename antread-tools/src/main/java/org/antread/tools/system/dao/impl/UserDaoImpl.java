package com.small.sbtest.system.dao.impl;

import org.springframework.stereotype.Repository;

import com.small.bdp.framework.dao.impl.AbstractCoreBaseDao;
import com.small.sbtest.system.dao.IUserDao;
import com.small.sbtest.system.domain.UserInfo;

@Repository
public class UserDaoImpl extends AbstractCoreBaseDao<UserInfo> implements IUserDao {

}
