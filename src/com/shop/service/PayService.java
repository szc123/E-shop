package com.shop.service;

import java.util.Map;

import com.shop.model.BackData;
import com.shop.model.SendData;

public interface PayService {
	//把加密后信息存储到requestMap中
	public abstract Map<String, Object> saveDataToRequest(Map<String, Object> request, SendData sendData);
	//把返回的数据进行加密得到密文，并与传回来的密文进行比较
	public boolean checkDataBack(BackData backData);

}
