package minhaihuang.dbutils.myUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;


/**
 * 创建一个Orm类，用来往数据库插入数据
 * @author 黄帅哥
 *
 */
public class MyOrm {
	
	public static void main(String[] args) {
		Persons p=new Persons(03,"hhm02",19,"30000");
		System.out.println(insertData(p));
	}
	
	/**
	 * 插入数据的方法
	 * @param p
	 * @return
	 * @throws IOException 
	 */
	private static boolean insertData(Persons p){
		//获得perso的信息
		int id=p.getId();
		String name=p.getName();
		int age=p.getAge();
		String salary=p.getSalary();
		
		//读取配置文件
		InputStream in=MyOrm.class.getResourceAsStream("dbcp.properties");
		Properties properties=new Properties();
		try {
			properties.load(in);
			//建立数据库连接，利用DBCP原理
			BasicDataSource dataSource=(BasicDataSource) BasicDataSourceFactory
					.createDataSource(properties);
			//获取数据库连接
			Connection conn=dataSource.getConnection();
			String sql="insert into Persons(id,name,age,salary) values(?,?,?,?)";
			int i=JdbcUtils.executeUpdata(conn, sql,id,name,age,salary);
			if(i==1){
				return true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return false;
	}
}
