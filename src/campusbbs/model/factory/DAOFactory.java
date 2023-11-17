package campusbbs.model.factory;

import java.util.ResourceBundle;

import campusbbs.model.utils.FactoryUtils;

public class DAOFactory {
	
	private static ResourceBundle bundle=ResourceBundle.getBundle("dao");
	
	@SuppressWarnings("unchecked")
	public static <T> T getDAOInstance(String key,Class<T> classObj){
		return (T)FactoryUtils.getInstance(bundle, key, classObj);
	}
	
}


































