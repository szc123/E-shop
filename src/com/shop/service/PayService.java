package com.shop.service;

import java.util.Map;

import com.shop.model.BackData;
import com.shop.model.SendData;

public interface PayService {
	//�Ѽ��ܺ���Ϣ�洢��requestMap��
	public abstract Map<String, Object> saveDataToRequest(Map<String, Object> request, SendData sendData);
	//�ѷ��ص����ݽ��м��ܵõ����ģ����봫���������Ľ��бȽ�
	public boolean checkDataBack(BackData backData);

}
