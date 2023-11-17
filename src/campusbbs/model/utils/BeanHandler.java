package campusbbs.model.utils;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Field;

public class BeanHandler<T> {
	
	private Class<T> classObject;  	
	
	public BeanHandler(Class<T> classObject) {
		super();
		this.classObject = classObject;
	}

	/**
	 * 将查询结果以列表形式返回
	 * @param rs 查询结果集
	 * @return 查询结果列表
	 * @throws SQLException 抛出sql异常
	 */
	public List<T> getBeanList(ResultSet rs) throws SQLException{
		
		ArrayList<T> list=new ArrayList<>();
		ResultSetMetaData rsmd=rs.getMetaData();
		T bean=null;
		int colNum=rsmd.getColumnCount();
		
		try {
			while(rs.next()){				
				bean=classObject.newInstance();
				for(int i=1;i<=colNum;i++){
					Object value=rs.getObject(i);
					String pro=rsmd.getColumnLabel(i);
					if(value==null){
						continue;
//						System.out.println("-------> "+pro+"\t"+value);
					}
//					System.out.println("--> "+pro);
					Field field=classObject.getDeclaredField(pro);
					field.setAccessible(true);
					field.set(bean, value);
					field.setAccessible(false);				
				}
				list.add(bean);				
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return list;		
	}
	
	/**
	 * 将查询结果的对应类对象返回
	 * @param rs 查询结果
	 * @return 代表查询结果的类对象
	 * @throws SQLException 抛出sql异常
	 */
	public T findBeanById(ResultSet rs) throws SQLException{
		ResultSetMetaData rsmd=rs.getMetaData();
		T bean=null;
		int colNum=rsmd.getColumnCount();
		try {
			if(rs!=null){
				if(rs.next()){
					bean=classObject.newInstance();
					for(int i=1;i<=colNum;i++){
						Object value=rs.getObject(i);
						String pro=rsmd.getColumnLabel(i);
						Field field=classObject.getDeclaredField(pro);
						field.setAccessible(true);
						field.set(bean, value);
						field.setAccessible(false);	
					}
				}				
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			bean=null;
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			bean=null;
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			bean=null;
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			bean=null;
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			bean=null;
			e.printStackTrace();
		}
		return bean;
	}
	
}




































