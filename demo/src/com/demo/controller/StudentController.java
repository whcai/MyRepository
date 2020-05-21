package com.demo.controller;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.demo.beans.Student;
import com.demo.service.StudentService;

@RequestMapping(value = "/smanager")
@Controller
public class StudentController {

	private static Logger logger = LogManager.getLogger(StudentController.class);

	@Autowired
	public StudentService service;

	@RequestMapping(value = "/list")
	public ModelAndView list() {
		ModelAndView mv = new ModelAndView();
		List<Student> student = null;
		try {
			student = service.getAllStudents();
			if (student.size() > 0) {
				mv.addObject("student", student);
			}
		} catch (Exception e) {
			logger.info("获取的student列表为空！");
		}
		mv.setViewName("student/list");
		return mv;
	}
	
	@RequestMapping("/init")
	public ModelAndView add() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("student/init");
		return mv;
	}

}
