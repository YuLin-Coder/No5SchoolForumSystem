package campusbbs.model.service.impl;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.Part;
import campusbbs.model.service.UploadService;
import campusbbs.model.utils.FileUtils;

public class UploadServiceImpl implements UploadService{
	
	@Override
	public Image getImage(Part part) throws IOException{
		// TODO Auto-generated method stub
		
		byte[] buf=new byte[(int)part.getSize()];		
		InputStream is=part.getInputStream();
		is.read(buf);		
		ByteArrayInputStream bis=new ByteArrayInputStream(buf);		
		
		return ImageIO.read(bis);
		
	}

	@Override
	public void saveImage(Image img, String path, String fileName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean saveImage(Part part, String path,String newFileName,String oldFileName) {
		// TODO Auto-generated method stub
		
		path=path.replaceAll("\\\\","/");
		
		String temFileName=path+"/tem";//新文件
		String tarFileName=path+"/"+newFileName;//旧文件
		System.out.println(temFileName);
		System.out.println(tarFileName);
		//创建文件
		File file=new File(temFileName);
		if(file.exists()){
			file.delete();
		}
		
		try {
			file.createNewFile();
			
			byte[] data=new byte[1024];
			int len;
					
//			InputStream is=part.getInputStream();
			DataInputStream dis=new DataInputStream(part.getInputStream());
			DataOutputStream dos=new DataOutputStream(new FileOutputStream(file));
			
			//读入图片
			while((len=dis.read(data))!=-1){
				dos.write(data, 0, len);
			}
			
			dis.close();
			dos.close();
						
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		FileUtils.copyFile(temFileName, tarFileName, true);
		
		//删除原来的文件
		FileUtils.deleteFile(temFileName);
		
		System.out.println("完成");
		return true;
	}

	@Override
	public String getImageName(Part part) {
		// TODO Auto-generated method stub
		
		//content-disposition
		String head=part.getHeader("Content-Disposition");
		//form-data; name="upImg"; filename="yishutuan.png"
		String fileName=head.substring(head.indexOf("filename=\"")+"filename=\"".length());
		fileName=fileName.substring(0,fileName.indexOf("\""));
		System.out.println("::::::"+fileName);
		
		return fileName;
	}

	@Override
	public String getStringParameter(Part part) {
		// TODO Auto-generated method stub
		
		StringBuffer sb=new StringBuffer();

		try {
			
			byte[] data=new byte[8096];
			int len=0;
			InputStream in=part.getInputStream();
			String tem=null;
			while((len=in.read(data))!=-1){
				tem=new String(data, 0, len, "utf-8");
				System.out.println(len+" : "+tem);
				sb.append(tem);
			}
			in.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sb.toString();
		
	}
	
	
}

















































