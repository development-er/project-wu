package com.wxh.dao;

import com.wxh.pojo.BeSelect;
import java.util.List;

public interface BeSelectDao {
	public abstract void add(BeSelect paramBeSelect);

	public abstract void delete(String paramString);

	public abstract List<BeSelect> queryBeSelectList();

	public abstract List<BeSelect> queryListByStuNum(String paramString);
}
