package com.antread.bdp.framework.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.antread.bdp.core.query.SortItem;
import com.antread.bdp.framework.domain.DataBaseInfo;
import com.antread.bdp.framework.service.IDataBaseService;

public abstract class AbstractDataBaseService<T extends DataBaseInfo> extends AbstractCoreBaseService<T> implements IDataBaseService<T> {

	@Override
	public List<T> findAll( ) {
		List<SortItem> sorts = new ArrayList<SortItem>();
		sorts.add(new SortItem("number"));
		return super.findAll(sorts);
	}

	@Override
	public void deleteByIds( String ids) {
		String[] idArray = ids.split(",");
		for (String fid : idArray) {
			delete(fid);
		}
	}

}
