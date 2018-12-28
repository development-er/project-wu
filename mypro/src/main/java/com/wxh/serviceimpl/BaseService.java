package com.wxh.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wxh.dao.Mapper;

@Service
public class BaseService<T> {

	@Autowired
	private Mapper<T> mapper;

	public void insertAll(T t) {
		this.mapper.insertAll(t);
	}
}
