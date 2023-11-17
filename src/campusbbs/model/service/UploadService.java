package campusbbs.model.service;

import java.awt.Image;
import java.io.IOException;

import javax.servlet.http.Part;

public interface UploadService {
	
	//
	public Image getImage(Part part) throws IOException;	

	public void saveImage(Image img,String path,String fileName);	
	
	/**
	 * 保存图片
	 * @param part Part类型参数
	 * @param path 图片文件保存路径
	 * @param fileName 图片文件名
	 */
	public boolean saveImage(Part part,String path,String newfileName,String oldFileName);
	
	/**
	 * 获取上传的图片文件名
	 * @param part Part类型参数
	 * @return 图片格式
	 */
	public String getImageName(Part part);
	
	/**
	 * 获取文本参数
	 * @param part Part类型参数
	 * @return 参数值
	 */
	public String getStringParameter(Part part);
	
}



























































