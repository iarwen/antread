package com.antread.bdp.framework.task.impl;

import org.apache.log4j.Logger;

import com.antread.bdp.framework.task.ICoreTask;

/**
 * 定时任务基类
 * 
 * @author wentao_chang
 *
 */
public abstract class AbstractCoreTask implements ICoreTask {

	protected Logger logger = Logger.getLogger(this.getClass());

}
