package com.wxh.controller;

import com.wxh.pojo.Article;
import com.wxh.pojo.Base64Image;
import com.wxh.service.ArticleService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ArticleController {
	@Autowired
	private ArticleService articleService;

	@RequestMapping("/addArticle")
	public void addArticle(HttpServletRequest request, HttpServletResponse response) {
		try {
			String articleName = request.getParameter("articleName");
			String paragraphs1 = request.getParameter("paragraphs1");
			String paragraphs2 = request.getParameter("paragraphs2");
			String paragraphs3 = request.getParameter("paragraphs3");
			String iconBase64 = request.getParameter("icon");
			String image1Base = request.getParameter("image1");
			String image2Base = request.getParameter("image2");

			Base64Image.GenerateImage(iconBase64);

			Article article = new Article();
			article.setIconPath(Base64Image.IMG_PATH);
			Base64Image.GenerateImage(image1Base);
			article.setImage1Path(Base64Image.IMG_PATH);
			Base64Image.GenerateImage(image2Base);
			article.setImage2Path(Base64Image.IMG_PATH);

			article.setArticleName(articleName);
			article.setParagraphs1(paragraphs1);
			article.setParagraphs2(paragraphs2);
			article.setParagraphs3(paragraphs3);

			this.articleService.addArticle(article);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping({ "/queryArticleByName" })
	public void queryArticleByName(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		try {
			String articleName = request.getParameter("articleName");
			Article art = this.articleService.queryArticleByName(articleName);
			art.setIconPath(Base64Image.GetImageStr(art.getIconPath()));
			art.setImage1Path(Base64Image.GetImageStr(art.getImage1Path()));
			art.setImage2Path(Base64Image.GetImageStr(art.getImage2Path()));
			JSONArray array = JSONArray.fromObject(art);
			PrintWriter out = response.getWriter();
			out.print(array);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
