package com.small.sbtest.system.service.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.small.bdp.core.context.IContext;
import com.small.bdp.framework.dao.ICoreBaseDao;
import com.small.bdp.framework.exception.BizException;
import com.small.bdp.framework.service.impl.AbstractCoreBaseService;
import com.small.sbtest.system.dao.IUserDao;
import com.small.sbtest.system.domain.UserInfo;
import com.small.sbtest.system.service.IUserService;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class UserServiceImpl extends AbstractCoreBaseService<UserInfo> implements IUserService {

	@Autowired
	@Qualifier("userDaoImpl")
	private IUserDao userDao;

	@Override
	public ICoreBaseDao<UserInfo> getDaoInstance() {
		return userDao;
	}

	@Override
	public void save(IContext ctx, UserInfo object) {
		// check
		UserInfo ui = findByFieldSingle(ctx, "email", object.getEmail());
		if (ui != null) {
			throw new BizException("已经存在Email为" + ui.getEmail() + "的用户");
		}
		super.save(ctx, object);
	}

	@PostConstruct
	public void init() {
		System.out.println("");
	}
}
