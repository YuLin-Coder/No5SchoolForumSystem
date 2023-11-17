package campusbbs.model.factory;

import java.util.ResourceBundle;

import campusbbs.model.utils.FactoryUtils;

public class BeanFactory{
	
	private static ResourceBundle bundle=ResourceBundle.getBundle("bean");	
	
	@SuppressWarnings("unchecked")
	public static <T> T getServiceInstance(String key,Class<T> classObj){
		return (T)FactoryUtils.getInstance(bundle, key, classObj);
	}
		
}
