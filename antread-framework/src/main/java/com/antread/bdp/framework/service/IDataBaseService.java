package com.antread.bdp.framework.service;

import com.antread.bdp.framework.domain.DataBaseInfo;

public interface IDataBaseService<T extends DataBaseInfo> extends ICoreBaseService<T> {

	public void deleteByIds( String ids);
}
