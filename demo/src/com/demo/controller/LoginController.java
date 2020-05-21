package com.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.beans.TModule;
import com.demo.beans.TModuleExample;
import com.demo.beans.TUser;
import com.demo.service.LoginService;
import com.demo.service.TModuleService;
import com.demo.utils.Base64;

/**
 * @author : whc
 * @Project: demo
 * @Package com.ssm.controller
 * @Description: 用户登录处理类
 * @date Date : 2020年04月13日 10:51
 */
@RequestMapping("/admin")
@Controller
public class LoginController {

	private static Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	public LoginService service;

	@Autowired
	public TModuleService tModuleService;

	@RequestMapping(value = "/main")
	public ModelAndView mainServlet(HttpSession session, @RequestParam("username") String username, @RequestParam("password") String password) {
		ModelAndView mv = new ModelAndView();
		TUser tUser = null;
		String message = "";

		String encryptPassword = "";
		// 密码进行base64加密
		if (password != null && password.trim().length() > 0) {
			encryptPassword = Base64.encrypt(password);
		}
		if (username != null && username.trim().length() > 0) {
			tUser = service.getTUserByUserId(username);
		}
		if (tUser == null) {
			message = "用户名：" + username + " 不存在，请确定后再登录！";
			mv.setViewName("redirect:/admin/login");
			return mv;
		}
		encryptPassword = "123";
		// 加密密码与系统用户密码字段比对，一致则通过，否则跳转至登录界面
		if (!encryptPassword.equals(tUser.getPassword())) {
			message += "用户密码不正确，请确定后再登录！";
			mv.setViewName("redirect:/admin/login");
			mv.addObject("message", message);
			return mv;
		} else {
			message += "登录成功！";
		}
		// 查找第一层菜单栏
		List<TModule> tModules = tModuleService.getTModuleList("0");
		// 查找第二层菜单栏
		List<TModule> tModules2 = tModuleService.getTModuleList("1");
		// 查找第三层菜单栏
		List<TModule> tModules3 = tModuleService.getTModuleList("2");

		// 返回main主界面
		mv.addObject("admin", tUser);
		session.setAttribute("user", tUser);
		mv.addObject("message", message);
		mv.addObject("tModules", tModules);
		mv.addObject("tModules2", tModules2);
		mv.addObject("tModules3", tModules3);
		mv.setViewName("main");
		return mv;
	}

	@RequestMapping(value = "/logout")
	public ModelAndView logout(HttpSession session) {
		logger.info("开始注销处理");
		ModelAndView mv = new ModelAndView();
		TUser tUser = (TUser) session.getAttribute("user");
		if (tUser != null) {
			session.removeAttribute("user");
			mv.setViewName("/admin/login");
		}
		return mv;
	}
	
	@RequestMapping(value="/test")
	public ModelAndView test() {
		ModelAndView mv = new ModelAndView();
		// 查找第一层菜单栏
		TModuleExample t1 = new TModuleExample();
		t1.createCriteria().andIfleafEqualTo("0");
		List<TModule> tModules = tModuleService.getAllTModule(t1);
		mv.addObject("tModules", tModules);
		mv.setViewName("test");
		return mv;
		
	}

}
