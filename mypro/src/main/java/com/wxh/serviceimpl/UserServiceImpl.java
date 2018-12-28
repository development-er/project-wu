package com.wxh.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wxh.dao.UserDao;
import com.wxh.pojo.User;
import com.wxh.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;

	@Override
	public void insertUserInformation(User user) {
		this.userDao.insertUserInformation(user);
	}

//	@Override
//	public void deleteUserInformation(Integer id) {
//		this.userDao.deleteUserInformation(id);
//	}

	@Override
	public List<User> queryUserInformation() {
		System.out.println("list");
		return this.userDao.queryUserInformation();
		
	}

	@Override
	public User queryUserById(String id) {
		return this.userDao.queryUserById(id);
	}

	//根据学号查询学生信息，从user表删除添加至groupName表
	@Override
	public void insertIntoSomeGroup(User user, String groupName) {
		this.insertIntoSomeGroup(user, groupName);
	}

	@Override
	public void deleteUserInfoByStuNum(String stuNum) {
		this.deleteUserInfoByStuNum(stuNum);
	}

}
