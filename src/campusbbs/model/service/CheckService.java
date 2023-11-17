package campusbbs.model.service;

import java.awt.image.BufferedImage;

public interface CheckService {

	public BufferedImage getCheckImage(String check,int width,int height);
	
	public String getCheckString(int checkLenght);
	
}
