package com.wxh.service;

import java.util.List;

import com.wxh.pojo.Society;

public interface SocietyService {

	// ע������
	public void addSociety(Society sc);

	// ɾ������
	public void deleteSociety(String title);

	// ��ѯ��������
	public List<Society> querySocieList();

	// ����������Ϣ
	public void updateSocieInfo(Society sc);

}
