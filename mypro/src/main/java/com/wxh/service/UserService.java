package com.wxh.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.wxh.pojo.User;
@Service
public interface UserService {

	public void insertUserInformation(User user);

//	public void deleteUserInformation(Integer id);

	public List<User> queryUserInformation();
	
	public User queryUserById(String id);
	
	public void insertIntoSomeGroup(User user,String groupName);
	
	public void deleteUserInfoByStuNum(String stuNum);

}
