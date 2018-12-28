package com.wxh.serviceimpl;

import com.wxh.dao.BeSelectDao;
import com.wxh.pojo.BeSelect;
import com.wxh.service.BeSelectService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BeSelectServiceImpl implements BeSelectService {
	@Autowired
	private BeSelectDao beSelectDao;

	public void add(BeSelect beSelect) {
		this.beSelectDao.add(beSelect);
	}

	public void delete(String stuNum) {
		this.beSelectDao.delete(stuNum);
	}

	public List<BeSelect> queryBeSelectList() {
		return this.beSelectDao.queryBeSelectList();
	}

	public List<BeSelect> queryListByStuNum(String societyid) {
		return this.beSelectDao.queryListByStuNum(societyid);
	}
}
