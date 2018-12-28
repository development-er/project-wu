package com.wxh.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wxh.dao.SocietyDao;
import com.wxh.pojo.Society;
import com.wxh.service.SocietyService;

@Service
public class SocietyServiceImpl implements SocietyService {
	
	@Autowired
	private SocietyDao societyDao;

	@Override
	public void addSociety(Society sc) {
		this.societyDao.addSociety(sc);
	}

	@Override
	public void deleteSociety(String title) {
		this.societyDao.deleteSociety(title);
	}

	@Override
	public List<Society> querySocieList() {
		return this.societyDao.querySocieList();
	}

	@Override
	public void updateSocieInfo(Society sc) {
		this.updateSocieInfo(sc);
	}

}
