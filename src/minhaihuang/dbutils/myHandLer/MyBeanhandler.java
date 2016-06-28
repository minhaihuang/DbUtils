package minhaihuang.dbutils.myHandLer;
/**
 * 实现自己的BeanHandler
 * @author 黄帅哥
 *
 */

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.apache.commons.dbutils.ResultSetHandler;

public class MyBeanhandler<T> implements ResultSetHandler<T> {

	private Class<T> clazz;

	public MyBeanhandler(Class<T> clazz) {
		this.clazz = clazz;
	}


	/**
	 * 到调用query方法时，调用此方法进行查询
	 * 用到了反射的技术
	 */
	public T handle(ResultSet resultSet) throws SQLException {
		if (!resultSet.next()) {
			return null;
		}
		T t = null;
		try {
			t = clazz.newInstance();

			ResultSetMetaData metaData = resultSet.getMetaData();
			int columnCount = metaData.getColumnCount();
			for (int i = 0; i < columnCount; i++) {
				String fieldName = metaData.getColumnName(i + 1);
				Object columnValue = resultSet.getObject(fieldName);
				Field field = clazz.getDeclaredField(fieldName);//一定要用此方法，因为属性均为private
				field.setAccessible(true);
				field.set(t, columnValue);
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		}

		return t;
	}
}
