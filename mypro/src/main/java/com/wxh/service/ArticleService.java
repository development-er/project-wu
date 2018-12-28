package com.wxh.service;

import com.wxh.pojo.Article;

public interface ArticleService {

	//添加社团介绍
	public void addArticle(Article article);
	
	//查询社团介绍
	public Article queryArticleByName(String articleName);

}
