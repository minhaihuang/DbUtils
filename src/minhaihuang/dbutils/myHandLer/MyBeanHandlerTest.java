package minhaihuang.dbutils.myHandLer;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.apache.commons.dbutils.ResultSetHandler;

/**
 * 自己写一遍MyBeanHandler
 * @author 黄帅哥
 *
 */
public class MyBeanHandlerTest<T> implements ResultSetHandler<T>{

	//静态属性不能用泛型
	private  Class<T> clazz;

	//构造函数
	public MyBeanHandlerTest(Class<T> clazz){
		this.clazz=clazz;
	}
	
	
	public T handle(ResultSet rs) throws SQLException {
		T t=null;
		
		//根据query的里面传递的参数来查询数据库，获取数据
		if(!rs.next()){
			return null;
		}
		//如果查询结果不为空
		
		//构造对象
		try {
			t=clazz.newInstance();
			//ResultSetMetaData 结果集元数据，可以获得结果集一共有多少列，每列的类名，每列的类型等信息
			ResultSetMetaData allFields=rs.getMetaData();
			for(int i=0;i<allFields.getColumnCount();i++){//根据总列数循环
				String fieldName=allFields.getColumnName(i+1);//此方法的开始数为1，而不是0.
				Object fieldValue=rs.getObject(fieldName);//获取值
				System.out.println(fieldName);
				Field field=clazz.getDeclaredField(fieldName);//获取字段
				field.setAccessible(true);
				field.set(t, fieldValue);
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
		
		return t;
	}
}
