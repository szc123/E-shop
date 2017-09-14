package com.shop.utils;

import com.shop.model.FileImage;

public interface FileUpload {
	
	//实现文件上传的功能，返回上传后新的文件名称  
    public abstract String uploadFile(FileImage fileImage); 
    //获取图片集合
    public String[] getBankImage();
}
