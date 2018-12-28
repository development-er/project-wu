package com.wxh.service;

import java.util.List;

import com.wxh.pojo.Society;

public interface SocietyService {

	// 注册社团
	public void addSociety(Society sc);

	// 删除社团
	public void deleteSociety(String title);

	// 查询所有社团
	public List<Society> querySocieList();

	// 更改社团信息
	public void updateSocieInfo(Society sc);

}
