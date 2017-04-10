package com.test.web.mysql;

public class DataSourceConfig {

	private String host;
	
	private String port;
	
	private String dbName;
	
	private String username;
	
	private String password;

	private int initialSize;

	private int maxTotal;

	private int minIdle;

	private int maxIdle;
	
	public DataSourceConfig() {
	    
	}
	
	public DataSourceConfig(String host, String port, String dbName, String username, String password) {
		super();
		this.host = host;
		this.port = port;
		this.dbName = dbName;
		this.username = username;
		this.password = password;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getInitialSize() {
		return initialSize;
	}

	public void setInitialSize(int initialSize) {
		this.initialSize = initialSize;
	}

	public int getMaxTotal() {
		return maxTotal;
	}

	public void setMaxTotal(int maxTotal) {
		this.maxTotal = maxTotal;
	}

	public int getMinIdle() {
		return minIdle;
	}

	public void setMinIdle(int minIdle) {
		this.minIdle = minIdle;
	}

	public int getMaxIdle() {
		return maxIdle;
	}

	public void setMaxIdle(int maxIdle) {
		this.maxIdle = maxIdle;
	}

	@Override
    public String toString() {
        return "DataSourceConfig [host=" + host + ", port=" + port + ", dbName=" + dbName + ", username=" + username
                + ", password=" + password + ",initialSize=" + initialSize + ",maxTotal=" + maxTotal
				+ ",minIdle=" + minIdle + ",maxIdle=" + maxIdle + "]";
    }
	
	
}

