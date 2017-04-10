package com.test.web.mysql;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;

/**
 * database管理器，提供mysql连接池的初始化、获得连接、关闭连接池。
 * 
 * May the force be with you
 * @author  Jone Scher 2013-8-29 起的比鸡早，睡的比鸡晚
 * @author  libei 2014-10-30 
 * @since   0.1.2
 */
public class DataSourceManager {
	
	private BasicDataSource ds;

	private static Map<String, DataSourceConfig> configMap = null;
	
	private static Map<String, DataSourceManager> instanceCache = new HashMap<String, DataSourceManager>();
	
	public synchronized static DataSourceManager getInstance(String bizName) {
        String env = System.getProperty("ds_mode");
        String key = null;
        if (env != null) {
            key = bizName + "-" + env;
        } else {
            key = bizName;
        }
        
        DataSourceManager instance = instanceCache.get(key);
        if (instance == null) {
            if (configMap == null) {
                loadDbProperties();
            }
            DataSourceConfig dsc = configMap.get(key);
            if (dsc != null) {
                instance = new DataSourceManager(dsc);
                instanceCache.put(key, instance);
            } else {
                return null;
            }
        }
        return instance;
    }
	
	private static void loadDbProperties() {
        configMap = new HashMap<String, DataSourceConfig>();
        InputStream in = DataSourceManager.class.getClassLoader().getResourceAsStream("mysql.properties");
        if (in == null) {
            return;
        }
        Properties properties = new Properties();
        try {
            properties.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {}
        }
        
        for (Iterator<Object> it = properties.keySet().iterator(); it.hasNext(); ) {
            String key = (String) it.next();
            key = key.trim();
            if (key.startsWith("#")) {
                continue;
            }
            String[] tmp = key.split("\\.");
            if (tmp.length != 3 || !tmp[0].equals("mysql")) {
                continue;
            }
            
            String bizName = tmp[1];
            String item = tmp[2];
            String value = properties.getProperty(key).trim();
            
            DataSourceConfig dsc = configMap.get(bizName);
            if (dsc == null) {
                dsc = new DataSourceConfig();
                configMap.put(bizName, dsc);
            }
            
            if (item.equals("host")) {
                dsc.setHost(value);
            } else if (item.equals("port")) {
                dsc.setPort(value);
            } else if (item.equals("username")) {
                dsc.setUsername(value);
            } else if (item.equals("password")) {
                dsc.setPassword(value);
            } else if (item.equals("dbname")) {
                dsc.setDbName(value);
            } else if (item.equals("initialSize")) {
                dsc.setInitialSize(Integer.valueOf(value));
            } else if (item.equals("maxTotal")) {
                dsc.setMaxTotal(Integer.valueOf(value));
            } else if (item.equals("minIdle")) {
                dsc.setMinIdle(Integer.valueOf(value));
            } else if (item.equals("maxIdle")) {
                dsc.setMaxIdle(Integer.valueOf(value));
            }
        }
    }
	
	/**
	 * datasource初始化 
	 *
	 * @author Jone Scher  2013-8-29
	 */
	private DataSourceManager(DataSourceConfig dsc) {
		if (dsc != null) {
			String host = dsc.getHost();
			String port = dsc.getPort();
			String dbName = dsc.getDbName();
			String username = dsc.getUsername();
			String password = dsc.getPassword();
			
			ds = new BasicDataSource();
			ds.setDriverClassName("com.mysql.jdbc.Driver");
			ds.setUrl("jdbc:mysql://"+host+":"+port+"/"+dbName+
					"?connectTimeout=1000&autoReconnect=true&useUnicode=true&rewriteBatchedStatements=true");
			ds.setUsername(username);
			ds.setPassword(password);
			ds.setInitialSize(dsc.getInitialSize() == 0 ? 3 : dsc.getInitialSize());
            ds.setMaxTotal(dsc.getMaxTotal() == 0 ? 200 : dsc.getMaxTotal());
			ds.setMinIdle(dsc.getMinIdle() == 0 ? 3 : dsc.getMinIdle());
			ds.setMaxIdle(dsc.getMaxIdle() == 0 ? 10 : dsc.getMaxIdle());
			ds.setTestOnReturn(false);
			ds.setTestWhileIdle(true);
			ds.setMinEvictableIdleTimeMillis(60 * 1000l * 10);
			ds.setTimeBetweenEvictionRunsMillis(1000 * 60);
			ds.setNumTestsPerEvictionRun(5);
			ds.setValidationQuery("SELECT 6");
		
		}
	}
	
	/**
	 * 获得连接
	 *
	 * @return
	 * @throws SQLException   
	 * @author Jone Scher  2013-8-29  
	 */
	public Connection getConnection() throws SQLException{
		return ds.getConnection();
	}

	/**
	 * 关闭数据库
	 *   
	 * @author Jone Scher  2013-8-29  
	 */
	public void shutdownDataSource() {
        try {
			ds.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
	
}
