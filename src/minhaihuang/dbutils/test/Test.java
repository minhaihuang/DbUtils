package minhaihuang.dbutils.test;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import minhaihuang.dbutils.myUtils.MyDataSource;
import minhaihuang.dbutils.myUtils.Persons;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.BeanMapHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

/**
 * 测试各种ResultHandler
 * @author 黄帅哥
 *
 */
public class Test {

	public static void main(String[] args) throws SQLException {
		//BeanListHandlerTest();
		//BeanMapHandlerTest() ;
		//ScalarHandlerTest();
		//ArrayHandlerTest();
		//ArrayListHandlerTest();
		//MapHandlerTest();
		//MapListHandlerTest();
		//ColumnListHandlerTest();
		KeyedHandlerTest();
	}
	
	
	/**
	 * 测试BeanHandler
	 * @throws SQLException 
	 */
	public static void BeanHandlerTest() throws SQLException{
		//建立一个要处理成的对象
				BeanHandler<Persons> handler=new BeanHandler<Persons>(Persons.class);
				// 创建一个QueryRunner对象，用来执行查询，构造时需要一个数据库连接池对象
				QueryRunner runner=new QueryRunner(MyDataSource.getDataSource());
				//执行查询的语句，需要穿传入查询语句，处理类型，以及参数参数
				Persons person=runner.query("select * from Persons where name=?", handler,"hhm01");
				System.out.println(person);
	}
	
	/**
	 * 测试BeanListHandler
	 * @throws SQLException 
	 */
	public static void BeanListHandlerTest() throws SQLException{
		//建立一个要处理成的对象
		BeanListHandler<Persons> handler=new BeanListHandler<Persons>(Persons.class);
				// 创建一个QueryRunner对象，用来执行查询，构造时需要一个数据库连接池对象
				QueryRunner runner=new QueryRunner(MyDataSource.getDataSource());
				//执行查询的语句，需要穿传入查询语句，处理类型，以及参数参数
				List<Persons> persons=runner.query("select * from Persons", handler);
				System.out.println(persons.toString());
	}
	
	/**
	 * 测试BeanMapHandler
	 * @throws SQLException 
	 */
	public static void BeanMapHandlerTest() throws SQLException{
		//建立一个要处理成的对象
		BeanMapHandler<Object,Persons> handler=new BeanMapHandler<Object,Persons>(Persons.class);
				// 创建一个QueryRunner对象，用来执行查询，构造时需要一个数据库连接池对象
				QueryRunner runner=new QueryRunner(MyDataSource.getDataSource());
				//执行查询的语句，需要穿传入查询语句，处理类型，以及参数参数
				Map<Object,Persons> persons=runner.query("select * from Persons", handler);
				System.out.println(persons.toString());
	}
	
	/**
	 * 测试ScalarHandler
	 * @throws SQLException 
	 */
	public static void ScalarHandlerTest() throws SQLException{
		//建立一个要处理成的对象
			ScalarHandler<Persons> handler=new ScalarHandler<Persons>();
				// 创建一个QueryRunner对象，用来执行查询，构造时需要一个数据库连接池对象
				QueryRunner runner=new QueryRunner(MyDataSource.getDataSource());
				//执行查询的语句，需要穿传入查询语句，处理类型，以及参数参数
				Object count=runner.query("select count(*) from Persons", handler);
				System.out.println(count);
	}
	
	/**
	 * 测试ArrayHandler
	 * @throws SQLException 
	 */
	public static void ArrayHandlerTest() throws SQLException{
		//建立一个要处理成的对象
		ArrayHandler handler=new ArrayHandler();
		// 创建一个QueryRunner对象，用来执行查询，构造时需要一个数据库连接池对象
		QueryRunner runner=new QueryRunner(MyDataSource.getDataSource());
		//执行查询的语句，需要穿传入查询语句，处理类型，以及参数参数
		Object[] person=runner.query("select * from Persons", handler);
		System.out.println(Arrays.toString(person));
	}
	
	/**
	 * 测试ArrayListHandler
	 * @throws SQLException 
	 */
	public static void ArrayListHandlerTest() throws SQLException{
		//建立一个要处理成的对象
		ArrayListHandler handler=new ArrayListHandler();
		// 创建一个QueryRunner对象，用来执行查询，构造时需要一个数据库连接池对象
		QueryRunner runner=new QueryRunner(MyDataSource.getDataSource());
		//执行查询的语句，需要穿传入查询语句，处理类型，以及参数参数
		List<Object[]> person=runner.query("select * from Persons", handler);
		System.out.println(person.toString());
	}
	
	/**
	 * 测试MapHandler
	 * @throws SQLException 
	 */
	public static void MapHandlerTest() throws SQLException{
		//建立一个要处理成的对象
		MapHandler handler=new MapHandler();
		// 创建一个QueryRunner对象，用来执行查询，构造时需要一个数据库连接池对象
		QueryRunner runner=new QueryRunner(MyDataSource.getDataSource());
		//执行查询的语句，需要穿传入查询语句，处理类型，以及参数参数
		Map<String,Object> person=runner.query("select * from Persons", handler);
		System.out.println(person.toString());
	}
	
	/**
	 * 测试MapListHandler	//把结果集的所有行数据处理成元素为Map的List对象
	 * @throws SQLException 
	 */
	public static void MapListHandlerTest() throws SQLException{
		//建立一个要处理成的对象
		MapListHandler handler=new MapListHandler();
		// 创建一个QueryRunner对象，用来执行查询，构造时需要一个数据库连接池对象
		QueryRunner runner=new QueryRunner(MyDataSource.getDataSource());
		//执行查询的语句，需要穿传入查询语句，处理类型，以及参数参数
		List<Map<String,Object>> person=runner.query("select * from Persons", handler);
		System.out.println(person.toString());
	}
	
	/**
	 * 测试ColumnListHandler<T>	//把结果集的某一列数据处理成List对象
	 * @throws SQLException 
	 */
	public static void ColumnListHandlerTest() throws SQLException{
		//建立一个要处理成的对象
		ColumnListHandler handler=new ColumnListHandler();
		// 创建一个QueryRunner对象，用来执行查询，构造时需要一个数据库连接池对象
		QueryRunner runner=new QueryRunner(MyDataSource.getDataSource());
		//执行查询的语句，需要穿传入查询语句，处理类型，以及参数参数
		List column=runner.query("select * from Persons", handler);
		System.out.println(column.toString());
	}
	
	/**
	 * 测试KeyedHandler<K,V>	//把结果集的所有行数据处理成值为Map的Map对象
	 * @throws SQLException 
	 */
	public static void KeyedHandlerTest() throws SQLException{
		//建立一个要处理成的对象
		KeyedHandler<Persons> handler=new KeyedHandler<Persons>();
		// 创建一个QueryRunner对象，用来执行查询，构造时需要一个数据库连接池对象
		QueryRunner runner=new QueryRunner(MyDataSource.getDataSource());
		//执行查询的语句，需要穿传入查询语句，处理类型，以及参数参数
		Map<Persons, Map<String, Object>> map=runner.query("select * from Persons", handler);
		System.out.println(map.toString());
	}
	
}
