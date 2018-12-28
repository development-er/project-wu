package com.wxh.dao;

import com.wxh.pojo.Article;

public interface ArticleDao {
	public abstract void addArticle(Article paramArticle);

	public abstract Article queryArticleByName(String paramString);
}
