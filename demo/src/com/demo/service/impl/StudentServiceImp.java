package com.demo.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Student;
import com.demo.beans.StudentExample;
import com.demo.dao.StudentMapper;
import com.demo.service.StudentService;

@Service
public class StudentServiceImp implements StudentService {

	private static Logger logger = LoggerFactory.getLogger(StudentServiceImp.class);

	@Autowired
	public StudentMapper dao;

	@Override
	public List<Student> getAllStudents() {
		StudentExample se = new StudentExample();
		List<Student> students = null;
		try {
			students = dao.selectByExample(se);
			if (students.size() > 0) {
				return students;
			}
		} catch (Exception e) {
			logger.error("获取学生列表为空!");
		}

		return null;
	}

	@Override
	public Student getStudent(String sno) {
		StudentExample se = new StudentExample();
		se.createCriteria().andSnoEqualTo(sno);
		List<Student> students = null;
		try {
			students = dao.selectByExample(se);
			if (students.size() > 0) {
				return students.get(0);
			}
		} catch (Exception e) {
			logger.error("获取学生列表为空!");
		}
		return null;
	}

	@Override
	public int addStudent(Student student) {
		int result = dao.insertSelective(student);
		if (result > 0) {
			return 1;
		}
		return 0;
	}

	@Override
	public int update(Student student) {
		int result = dao.updateByPrimaryKey(student);
		if (result > 0) {
			return 1;
		}
		return 0;
	}

	@Override
	public int update(Student student, StudentExample se) {
		int result = dao.updateByExampleSelective(student, se);
		if (result > 0) {
			return 1;
		}
		return 0;
	}

	// 删除 student by id
	@Override
	public int delete(Integer id) {
		int result = dao.deleteByPrimaryKey(id);
		if (result > 0) {
			return 1;
		}
		return 0;
	}

	// 删除 student by 自定义条件
	@Override
	public int delete(StudentExample se) {
		int result = dao.deleteByExample(se);
		if (result > 0) {
			return 1;
		}
		return 0;
	}

}
