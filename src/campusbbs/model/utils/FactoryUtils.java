package campusbbs.model.utils;

import java.util.ResourceBundle;

public class FactoryUtils {
	
	public static <T> Object getInstance(ResourceBundle bundle,String key,Class<T> classObj){

		System.out.println(key);
		String className=bundle.getString(key);

		System.out.println(className);
		
		try {
			
			Object obj=Class.forName(className).newInstance();
			return obj;
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
}
