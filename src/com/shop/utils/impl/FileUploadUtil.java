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
	
	//ʵ���ļ��ϴ��Ĺ��ܣ������ϴ����µ��ļ�����  
    public String uploadFile(FileImage fileImage) {  
        //��ȡ��Ψһ�ļ���  
        String pic = newFileName(fileImage.getFileName());  
        try {  
            FileUtil.copyFile(fileImage.getFile(), new File(filePath, pic));//��һ���������ϴ����ļ����ڶ��������ǽ��ļ���������·����  
            return pic;  
        } catch (Exception e) {  
            throw new RuntimeException(e);  
        } finally {  
            fileImage.getFile().delete();  
        }  
    }  
    
    public String[] getBankImage(){
    	String[] list=new File(bankImagePath).list(new FilenameFilter() {
			//�����ļ��Ƿ����ļ��б���
    		public boolean accept(File dir, String name) {
				//ͨ����׺��ʵ�ֶ��ļ��Ĺ���
    			return name.endsWith(".gif");
			}
		});
		return list;
    }
}
