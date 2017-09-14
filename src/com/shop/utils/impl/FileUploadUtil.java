package com.shop.utils.impl;

import java.io.File;
import java.io.FilenameFilter;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.aspectj.util.FileUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.shop.model.FileImage;
import com.shop.utils.FileUpload;

@Component("fileUpload")
public class FileUploadUtil implements FileUpload{
	
	private String filePath;
	@Value("#{prop.basePath+prop.filePath}")
	private String bankImagePath;
	@Value("#{prop.basePath+prop.bankImagePath}")

	public void setFilePath(String filePath){
		this.filePath=filePath;
	}
	
	private String getFileExt(String fileName){
		return FilenameUtils.getExtension(fileName);
	}
	
	private String newFileName(String fileName){
		return UUID.randomUUID().toString().replace("-", "")+"."+getFileExt(fileName);
	}
	
	//实现文件上传的功能，返回上传后新的文件名称  
    public String uploadFile(FileImage fileImage) {  
        //获取新唯一文件名  
        String pic = newFileName(fileImage.getFileName());  
        try {  
            FileUtil.copyFile(fileImage.getFile(), new File(filePath, pic));//第一个参数是上传的文件，第二个参数是将文件拷贝到新路径下  
            return pic;  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        } finally {  
            fileImage.getFile().delete();  
        }  
    }  
    
    public String[] getBankImage(){
    	String[] list=new File(bankImagePath).list(new FilenameFilter() {
			//测试文件是否在文件列表中
    		public boolean accept(File dir, String name) {
				//通过后缀名实现对文件的过滤
    			return name.endsWith(".gif");
			}
		});
		return list;
    }
}
