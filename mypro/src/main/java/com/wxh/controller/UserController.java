package com.wxh.controller;

import com.wxh.pojo.Base64Image;
import com.wxh.pojo.User;
import com.wxh.service.UserService;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping({ "/test0" })
	@ResponseBody
	public String test(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("sssssssssssssssssssssssss");
		return "index.jsp";
	}

	@RequestMapping({ "/queryUserInformation" })
	@ResponseBody
	public void queryUserInformation(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			String callback = request.getParameter("callback");
			if ((callback != null) || (callback != "")) {
				List<User> list = this.userService.queryUserInformation();
				JSONArray array = JSONArray.fromObject(list);
				response.setContentType("text/json;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.write(callback + "(" + array.toString() + ")");
			}
			if (callback == null) {
				List<User> list = this.userService.queryUserInformation();
				JSONArray array = JSONArray.fromObject(list);
				response.setContentType("text/json;charset=utf-8");
				PrintWriter out = response.getWriter();
				out.write(array.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping({ "/queryUserById" })
	@ResponseBody
	public void queryUserById(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			String id = request.getParameter("id");
			User user = this.userService.queryUserById(id);
			JSONArray array = JSONArray.fromObject(user);
			response.setContentType("text/json;charset=utf-8");
			PrintWriter out = response.getWriter();
			out.write(array.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping({ "/insertUserInformation" })
	public void insertUserInformation(HttpServletRequest request, HttpServletResponse response) {
		try {
			String userName = request.getParameter("userName");
			String password = request.getParameter("password");
			String id = request.getParameter("id");
			String gender = request.getParameter("gender");
			String introduce = request.getParameter("introduce");
			String department = request.getParameter("department");
			String phone = request.getParameter("phone");
			String stuNum = request.getParameter("stuNum");
			String photoP = request.getParameter("photoPath");
			Base64Image.GenerateImage(photoP);
			String photoPath = Base64Image.IMG_PATH;
			User user = new User(photoPath, userName, password, id, gender, introduce, department, phone, stuNum);
			this.userService.insertUserInformation(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping({ "/insertIntoSomeGroup" })
	public void insertIntoSomeGroup(HttpServletRequest req, HttpServletResponse res) {
		try {
			String stuNum = req.getParameter("stuNum");
			String groupName = req.getParameter("groupName");
			User user = this.userService.queryUserById(stuNum);
			this.userService.insertIntoSomeGroup(user, groupName);
			this.userService.deleteUserInfoByStuNum(stuNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
