package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.beans.College;
import com.demo.beans.CollegeExample;
import com.demo.common.ResultStatus;
import com.demo.service.CollegeService;

@RequestMapping(value = "/cmanager")
@Controller
public class CollegeController {

	@Autowired
	public CollegeService service;

	@RequestMapping(value = "/list")
	public ModelAndView list(@RequestParam(value = "cid", required = false) String cid) {
		ModelAndView mv = new ModelAndView();
		CollegeExample example = new CollegeExample();
		if (cid != null && cid.trim().length() > 0) {
			example.createCriteria().andCidEqualTo(Integer.parseInt(cid));
		}

		List<College> colleges = service.getAllCollege(example);
		System.out.println(colleges.toString());
		if (colleges.size() > 0) {
			mv.addObject("colleges", colleges);
		}

		mv.setViewName("college/list");
		return mv;
	}

	@RequestMapping(value = "/init")
	public ModelAndView init(@RequestParam(value = "cid", required = false) String cid) {
		ModelAndView mv = new ModelAndView();
		College college = null;
		if (cid != null && cid.trim().length() > 0) {
			college = service.getCollege(Integer.parseInt(cid));
		}
		if (college != null) {
			mv.addObject("college", college);
		}
		mv.setViewName("college/init");
		return mv;
	}

	@RequestMapping(value = "/delete")
	public String delete(@RequestParam(value = "cid", required = true) String cid) {
		int result = -1;
		String message = "";
		String json = "";
		if (cid != null && cid.trim().length() > 0) {
			message += "学院号为空！";
		}
		result = service.delete(Integer.parseInt(cid));
		if (result > 0) {
			message += "删除成功";
		}
		json = ResultStatus.output("200", message, "closeCurrent");
		return json;
	}

}
