package com.test.web.mysql;

public abstract class DataAccessAware {
	
	protected final DataAccessMgr dataAccess = DataAccessMgr.getInstance();
	
}

