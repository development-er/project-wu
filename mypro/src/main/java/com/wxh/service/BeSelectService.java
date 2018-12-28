package com.wxh.service;

import com.wxh.pojo.BeSelect;
import java.util.List;

public interface BeSelectService {
	public void add(BeSelect paramBeSelect);

	public void delete(String paramString);

	public List<BeSelect> queryBeSelectList();

	public List<BeSelect> queryListByStuNum(String paramString);
}
