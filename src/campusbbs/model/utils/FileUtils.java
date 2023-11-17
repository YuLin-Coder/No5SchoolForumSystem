package campusbbs.model.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtils {

	//复制文件
	public static boolean copyFile(String srcFileName, String destFileName,  
            boolean overlay) {  
		

		srcFileName=srcFileName.replaceAll("\\\\","/");
		destFileName=destFileName.replaceAll("\\\\","/");
		
        File srcFile = new File(srcFileName);          
        
        System.out.println("复制文件："+srcFileName+" --> "+destFileName);
        // 判断源文件是否存在  
        if (!srcFile.exists()) {  
            return false;  
        } else if (!srcFile.isFile()) {  
            return false;  
        }  
  
        // 判断目标文件是否存在  
        File destFile = new File(destFileName);  
        if (destFile.exists()) {  
            // 如果目标文件存在并允许覆盖  
            if (overlay) {  
                // 删除已经存在的目标文件，无论目标文件是目录还是单个文件  
                new File(destFileName).delete();  
            }  
        } else {  
            // 如果目标文件所在目录不存在，则创建目录  
            if (!destFile.getParentFile().exists()) {  
                // 目标文件所在目录不存在  
                if (!destFile.getParentFile().mkdirs()) {  
                    // 复制文件失败：创建目标文件所在目录失败  
                    return false;  
                }  
            }  
        }  
  
        // 复制文件  
        int byteread = 0; // 读取的字节数  
        InputStream in = null;  
        OutputStream out = null;  
  
        try {  
            in = new FileInputStream(srcFile);  
            out = new FileOutputStream(destFile);  
            byte[] buffer = new byte[1024];  
  
            while ((byteread = in.read(buffer)) != -1) {  
                out.write(buffer, 0, byteread);  
            }  
            return true;  
        } catch (FileNotFoundException e) {  
            System.out.println("复制出错1");
            return false;  
        } catch (IOException e) {  
            System.out.println("复制出错2");
            return false;  
        } finally {  
            try {  
                if (out != null)  
                    out.close();  
                if (in != null)  
                    in.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
            System.out.println("复制完成");
        }  
    }  
  
	//删除文件
	public static boolean deleteFile(String fileName){
		File file=new File(fileName);
		if(file.isFile()&&file.exists()){
			return file.delete();
		}
		return false;
	}
	
}





































