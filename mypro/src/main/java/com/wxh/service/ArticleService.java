package com.wxh.service;

import com.wxh.pojo.Article;

public interface ArticleService {

	//������Ž���
	public void addArticle(Article article);
	
	//��ѯ���Ž���
	public Article queryArticleByName(String articleName);

}
