package com.wxh.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.wxh.pojo.User;

public interface UserDao {
	
	public void insertUserInformation(User user);
	
	@Select("select * from user")
	public List<User> queryUserInformation();
	
	public User queryUserById(String id);
	
	//通过学号查询学生对象，通过社团id添加至相应社团
	public void insertIntoSomeGroup(User user,String groupName);
	
	public void deleteUserInfoByStuNum(String stuNum);
	
}
