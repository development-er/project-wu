package com.wxh.dao;

import com.wxh.pojo.Wait;
import java.util.List;

public interface WaitDao {
	public void addToWaitList(Wait paramWait);

	public void deleteForWait(String paramString);

	public List<Wait> queryWaitList();

	public List<Wait> queryWaitListBySocietyId(String paramString);
}
