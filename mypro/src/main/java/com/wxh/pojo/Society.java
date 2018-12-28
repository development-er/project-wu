package com.wxh.pojo;

public class Society {
	
	private String iconPath;
	
	private String title;
	
	private String intro;
	
	public Society(){
		
	}

	public String getIconPath() {
		return iconPath;
	}

	public void setIconPath(String iconPath) {
		this.iconPath = iconPath;
	}

	public String getTitle() {
		return title;
	}

	public void setTitile(String title) {
		this.title = title;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	public Society(String iconPath, String title, String intro) {
		super();
		this.iconPath = iconPath;
		this.title = title;
		this.intro = intro;
	}
	
	

}
