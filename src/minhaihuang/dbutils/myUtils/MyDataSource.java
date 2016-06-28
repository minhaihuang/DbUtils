package minhaihuang.dbutils.myUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

/**
 * 建立数据库连接的方法
 * @author 黄帅哥
 *
 */
public class MyDataSource {
	private static DataSource dataSource;
	
	static{
		InputStream in=MyDataSource.class.getResourceAsStream("dbcp.properties");
		
		Properties properties=new Properties();
		try {
			properties.load(in);
			dataSource=(DataSource) BasicDataSourceFactory.createDataSource(properties);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static DataSource getDataSource(){
		return (DataSource) dataSource;
	}
}
