package com.wxh.controller;

import com.wxh.pojo.User;
import com.wxh.pojo.Wait;
import com.wxh.service.UserService;
import com.wxh.service.WaitService;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WaitController {
	@Autowired
	private WaitService waitService;
	@Autowired
	private UserService userService;

	@RequestMapping({ "/queryWaitList" })
	public void queryWaitList(HttpServletRequest request, HttpServletResponse response)
			throws UnsupportedEncodingException {
		try {
			String callback = request.getParameter("callback");
			if (callback != null) {
				response.setContentType("text/json;charset=utf-8");
				List<Wait> list = this.waitService.queryWaitList();
				PrintWriter out = response.getWriter();
				JSONArray array = JSONArray.fromObject(list);
				out.write(callback + "(" + array.toString() + ")");
			} else {
				response.setContentType("text/json;charset=utf-8");
				List<Wait> list = this.waitService.queryWaitList();
				PrintWriter out = response.getWriter();
				JSONArray array = JSONArray.fromObject(list);
				out.write(array.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping({ "/queryWaitListBySocietyId" })
	public void queryWaitListBySocietyId(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/json;charset=utf-8");
			String societyId = request.getParameter("societyid");
			List<Wait> list = this.waitService.queryWaitListBySocietyId(societyId);
			PrintWriter out = response.getWriter();
			JSONArray array = JSONArray.fromObject(list);
			out.write(array.toString());
		} catch (Exception localException) {
		}
	}

	@RequestMapping({ "/addToWaitList" })
	public void addToWaitList(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			String id = request.getParameter("id");
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
			User user = this.userService.queryUserById(id);
			Wait wait = new Wait();
			wait.setUserName(user.getUserName());
			wait.setPassword(user.getPassword());
			wait.setStuNum(user.getStuNum());
			wait.setSocietyid(societyid);
		} catch (Exception localException) {
		}
	}

	@RequestMapping({ "/deleteForWaitList" })
	public void deleteForWait(HttpServletRequest request, HttpServletResponse response) {
		try {
			String stuNum = request.getParameter("stuNum");
			System.out.println(stuNum);
			this.waitService.deleteForWait(stuNum);
		} catch (Exception localException) {
		}
	}
}
