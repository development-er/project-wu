package com.wxh.serviceimpl;

import com.wxh.dao.WaitDao;
import com.wxh.pojo.Wait;
import com.wxh.service.WaitService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WaitServiceImpl implements WaitService {
	@Autowired
	private WaitDao waitDao;

	public void addToWaitList(Wait wait) {
		this.waitDao.addToWaitList(wait);
	}

	public void deleteForWait(String stuNum) {
		this.waitDao.deleteForWait(stuNum);
	}

	public List<Wait> queryWaitList() {
		return this.waitDao.queryWaitList();
	}

	public List<Wait> queryWaitListBySocietyId(String societyid) {
		return this.waitDao.queryWaitListBySocietyId(societyid);
	}
}
