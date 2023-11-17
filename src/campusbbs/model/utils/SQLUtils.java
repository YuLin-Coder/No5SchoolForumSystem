package campusbbs.model.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

public class SQLUtils<T> {
	
	private Connection con;
	
	public SQLUtils(Connection con) {
		super();
		this.con = con;
	}
	
	public SQLUtils(DataSource source) throws SQLException{
		super();
		this.con = source.getConnection();
	}

	/**
	 * 查找一组数据
	 * @param sql sql查询语句
	 * @param beanClass 结果集数据的封装类
	 * @return 所查找的一组数据
	 */
	public List<T> queryByList(String sql,Class<T> beanClass){
		PreparedStatement p=null;
		ResultSet rs=null;
		List<T> list=null;
		try {
			p=con.prepareStatement(sql);
			rs=p.executeQuery();			
			BeanHandler<T> handler=new BeanHandler<>(beanClass);
			list=handler.getBeanList(rs);		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				if(rs!=null){
					rs.close();
				}
				if(p!=null){
					p.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}

	/**
	 * 查找一组数据的静态方法
	 * @param sql sql查询语句
	 * @param beanClass 结果集数据的封装类
	 * @return 所查找的一组数据
	 */
	public static <T> List<T> queryRecordList(String sql,Class<T> beanClass){
		
		System.out.println("queryRecordList\t"+sql);

		SQLUtils<T> sqlUtils=DBUtils.getSQLUtils();
		List<T> list=sqlUtils.queryByList(sql, beanClass);
		sqlUtils.close();
		
		return list;
		
	}

	/**
	 * 根据主键查询数据
	 * @param sql 查询sql语句
	 * @param beanClass 每条查询结果的类型
	 * @return 查询结果对象
	 */
	public T queryById(String sql,Class<T> beanClass){
		PreparedStatement p=null;
		ResultSet rs=null;
		T res=null;
		try {
			p=con.prepareStatement(sql);
			rs=p.executeQuery();
			BeanHandler<T> handler=new BeanHandler<>(beanClass);
			res=handler.findBeanById(rs);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null){
					rs.close();
				}
				if(p!=null){
					p.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return res;
	}
	
	/**
	 * 静态方法，根据主键查询数据
	 * @param sql 查询sql语句
	 * @param beanClass 每条查询结果的类型
	 * @return 查询结果对象
	 */
	public static <T> T queryRecordById(String sql,Class<T> beanClass){
		
		System.out.println("queryRecordById\t"+sql);
		
		SQLUtils<T> sqlUtils=DBUtils.getSQLUtils();
		T obj=sqlUtils.queryById(sql, beanClass);
		sqlUtils.close();
		
		return obj;
		
	}
	
	/**
	 * 执行获取记录条数的sql语句
	 * @param sql sql语句
	 * @return 数据数量
	 */
	public long getCount(String sql){
		PreparedStatement p=null;
		ResultSet rs=null;
		long count=0;
		try {
			p=con.prepareStatement(sql);
			rs=p.executeQuery();
			if(rs!=null){
				rs.next();
				count=rs.getLong(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null){
					rs.close();
				}
				if(p!=null){
					p.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;
	}
	
	/**
	 * 执行获取记录条数的sql语句
	 * @param sql sql语句
	 * @return 数据数量
	 */
	public static long getRecordCount(String sql){
		
		System.out.println("getRecordCount\t"+sql);
		
		SQLUtils<Long> sqlUtils = DBUtils.getSQLUtils();
		long count=sqlUtils.getCount(sql);
		sqlUtils.close();
		
		return count;
	}
	
	/**
	 * 更新数据
	 * @param sql 更新数据库的sql语句
	 */
	public void update(String sql){
		try {
			PreparedStatement p=con.prepareStatement(sql);
			p.execute();
			p.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	/**
	 * 更新数据
	 * @param sql 更新数据库的sql语句
	 */
	public static void updateRecord(String sql){
		
		System.out.println("updateRecord\t"+sql);
				
		@SuppressWarnings("rawtypes")
		SQLUtils sqlUtils = DBUtils.getSQLUtils();
		sqlUtils.update(sql);
		sqlUtils.close();
		
	}
	
	/**
	 * 
	 * 更新数据
	 * @param sql 更新数据库的sql语句
	 * @param param 参数
	 */
	public void update(String sql,Object[] param){
		try {
			PreparedStatement p=con.prepareStatement(sql);
			
			for(int i=0;i<param.length;i++){
				p.setObject(i+1, param[i]);
			}
			
			p.execute();
			p.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	
	/**
	 * 
	 * 更新数据
	 * @param sql 更新数据库的sql语句
	 * @param param 参数
	 */
	public static void updateRecord(String sql,Object[] param){

		
		System.out.println("updateRecord 2\t"+sql);
		
		@SuppressWarnings("rawtypes")
		SQLUtils sqlUtils = DBUtils.getSQLUtils();
		sqlUtils.update(sql, param);
		sqlUtils.close();
		
	}
	
	/**
	 * 释放数据库连接
	 */
	public void close(){
		try {
			if(con!=null){
				con.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}




































