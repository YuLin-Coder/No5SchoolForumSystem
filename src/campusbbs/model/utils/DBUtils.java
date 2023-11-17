package campusbbs.model.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBUtils {
	
	private static DataSource dataSource;
	static {
		dataSource=new ComboPooledDataSource();
	}
	
	/**
	 * 从连接池获取数据库连接
	 * @return
	 */
	public static Connection getDBConnection(){
		Connection con=null;
		try {
			con=dataSource.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println("获取connection");
		return con;
	}

	/**
	 * 获取SQL处理工具类
	 * @return SQLUtils对象
	 */
	public static <T> SQLUtils<T> getSQLUtils(){
		return new SQLUtils<T>(getDBConnection());
	}	
	
}
