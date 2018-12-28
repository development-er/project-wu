package com.wxh.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wxh.dao.ArticleDao;
import com.wxh.pojo.Article;
import com.wxh.service.ArticleService;

@Service
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleDao articleDao;

	@Override
	public void addArticle(Article article) {
		this.articleDao.addArticle(article);
	}

	@Override
	public Article queryArticleByName(String articleName) {
		return this.articleDao.queryArticleByName(articleName);
	}

}
