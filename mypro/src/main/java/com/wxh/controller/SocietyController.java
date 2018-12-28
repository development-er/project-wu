package com.wxh.controller;

import com.wxh.pojo.Base64Image;
import com.wxh.pojo.Society;
import com.wxh.service.SocietyService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SocietyController {
	@Autowired
	private SocietyService societyService;
	
	@RequestMapping({ "/addSociety" })
	public boolean addSociety(HttpServletRequest request, HttpServletResponse response) {
		try {
			String title = request.getParameter("title");
			String introduce = request.getParameter("introduce");
			String icon = request.getParameter("icon");
			boolean status = Base64Image.GenerateImage(icon);
			Society society = new Society();
			society.setIconPath(Base64Image.IMG_PATH);
			society.setIntro(introduce);
			society.setTitile(title);
			this.societyService.addSociety(society);
			return status;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@RequestMapping({ "/querySocieList" })
	public void querySocieList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		List<Society> list = this.societyService.querySocieList();
		
		for (int i = 0; i < list.size(); i++) {
			String imgFilePath = ((Society) list.get(i)).getIconPath();
//			byte[] data = null;
//			try {
//				InputStream in = new FileInputStream(imgFilePath);
//				data = new byte[in.available()];
//				in.read(data);
//				in.close();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
			list.get(i).setIconPath(Base64Image.GetImageStr(imgFilePath));
		}
		JSONArray array = JSONArray.fromObject(list);
		PrintWriter out = response.getWriter();
		out.print(array);
	}
}
