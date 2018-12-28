package com.wxh.controller;

import com.wxh.pojo.BeSelect;
import com.wxh.pojo.User;
import com.wxh.service.BeSelectService;
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

@Controller
public class BeSelectController {
	@Autowired
	private BeSelectService beSelectService;
	@Autowired
	private UserService userService;

	@RequestMapping({ "/add" })
	public void add(HttpServletRequest request, HttpServletResponse response) {
		try {
			String id = request.getParameter("id");
			String societyid = request.getParameter("societyId");
			System.out.println(societyid);
			User user = this.userService.queryUserById(id);
			if (societyid.equals("双截棍社团")) {
				societyid = "001";
			} else if (societyid.equals("英语协会")) {
				societyid = "002";
			} else if (societyid.equals("篮球协会")) {
				societyid = "003";
			} else if (societyid.equals("羽毛球协会")) {
				societyid = "004";
			} else {
				societyid = "005";
			}
			BeSelect bs = new BeSelect();
			bs.setSocietyid(societyid);
			bs.setUserName(user.getUserName());
			bs.setPassword(user.getPassword());
			bs.setStuNum(user.getStuNum());
			this.beSelectService.add(bs);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping({ "deleteByStuNum" })
	public void delete(HttpServletRequest request, HttpServletResponse response) {
		try {
			String stuNum = request.getParameter("stuNum");
			this.beSelectService.delete(stuNum);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping({ "/queryListBySocietyid" })
	public void queryListBySocietyid(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/json;charset=utf-8");
			String societyid = request.getParameter("societyid");
			if (societyid.equals("双截棍社团")) {
				societyid = "001";
			} else if (societyid.equals("英语协会")) {
				societyid = "002";
			} else if (societyid.equals("篮球协会")) {
				societyid = "003";
			} else if (societyid.equals("羽毛球协会")) {
				societyid = "004";
			} else {
				societyid = "005";
			}
			List<BeSelect> list = this.beSelectService.queryListByStuNum(societyid);
			PrintWriter out = response.getWriter();
			JSONArray array = JSONArray.fromObject(list);
			out.write(array.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping({ "/queryBeSelectList" })
	public void queryBeSelectList(HttpServletRequest request, HttpServletResponse response) throws IOException {
		try {
			response.setContentType("text/json;charset=utf-8");
			List<BeSelect> list = this.beSelectService.queryBeSelectList();
			JSONArray array = JSONArray.fromObject(list);
			PrintWriter out = response.getWriter();
			out.write(array.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
