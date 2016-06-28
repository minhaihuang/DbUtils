package minhaihuang.dbutils.myUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * 新版的JdbcUtils
 * @author 黄帅哥
 *
 */
public class JdbcUtils {

	public static int executeUpdata(Connection conn,String sql,Object... objects ) {
		//准备sql语句
		PreparedStatement ps;
		int k=0;
		try {
			ps = conn.prepareStatement(sql);
			//完善参数
			if(objects.length!=0){
			for(int i=0;i<objects.length;i++){
				ps.setObject(i+1, objects[i]);
			}
			}
			//插入数据
			k=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			
		}
		return k;
	}
	
	public static void close(AutoCloseable...objects ){
		for(AutoCloseable o:objects){
			if(o!=null){
				try {
					o.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
