package com.wxh.pojo;

public class User {
	private String photoPath;
	private String userName;
	private String password;
	private String gender;
	private String introduce;
	private String phone;
	private String department;
	private String id;
	private String stuNum;

	public User() {
	}

	public User(String photoPath, String userName, String password, String gender, String introduce, String phone,
			String department, String id, String stuNum) {
		this.photoPath = photoPath;
		this.userName = userName;
		this.password = password;
		this.gender = gender;
		this.introduce = introduce;
		this.phone = phone;
		this.department = department;
		this.id = id;
		this.stuNum = stuNum;
	}

	public String getStuNum() {
		return this.stuNum;
	}

	public void setStuNum(String stuNum) {
		this.stuNum = stuNum;
	}

	public String getPhotoPath() {
		return this.photoPath;
	}

	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIntroduce() {
		return this.introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
