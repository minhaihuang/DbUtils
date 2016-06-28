package minhaihuang.dbutils.myUtils;

import java.sql.SQLException;

import minhaihuang.dbutils.myHandLer.MyBeanHandlerTest;
import minhaihuang.dbutils.myHandLer.MyBeanhandler;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

/**
 * 测试DbUtils
 * @author 黄帅哥
 *
 */
public class MyDbUtils {

	public static void main(String[] args) throws SQLException {
		// 创建 ResultSetHandler 的实现类的对象，用来把结果集的第一行转化为Person对象
		MyBeanHandlerTest<Persons> bean=new MyBeanHandlerTest<Persons>(Persons.class);
		// 创建一个QueryRunner对象，用来执行查询，构造时需要一个数据库连接池对象
		QueryRunner runner=new QueryRunner(MyDataSource.getDataSource());
		// 执行查询，根据参数 BeanHandler的泛型返回响应类型的对象
		Persons person=runner.query("select *from Persons where name=?",bean,"hhm");
		//不被推荐的写法
		//Persons person=runner.query("select *from Persons where name=?","hhm",bean);
		System.out.println(person);
	}
		
}
