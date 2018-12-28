package com.wxh.service;

import com.wxh.pojo.Wait;
import java.util.List;

public abstract interface WaitService {
	public abstract void addToWaitList(Wait paramWait);

	public abstract void deleteForWait(String paramString);

	public abstract List<Wait> queryWaitList();

	public abstract List<Wait> queryWaitListBySocietyId(String paramString);
}
