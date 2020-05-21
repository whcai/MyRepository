package com.demo.service.impl;


import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.College;
import com.demo.beans.CollegeExample;
import com.demo.dao.CollegeMapper;
import com.demo.service.CollegeService;

@Service
public class CollegeServiceImp implements CollegeService {

	private static Logger logger = LoggerFactory.getLogger(CollegeServiceImp.class);

	@Autowired
	public CollegeMapper dao;

	@Override
	public College getCollege(Integer cid) {
		College college = null;
		try {
			college = dao.selectByPrimaryKey(cid);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return college;
	}

	@Override
	public College getCollegeByExample(CollegeExample example) {
		List<College> colleges = null;
		try {
			colleges = dao.selectByExample(example);
			if (colleges.size() > 0) {
				return colleges.get(0);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List getAllCollege(CollegeExample example) {
		List<College> colleges = null;
		try {
			colleges = dao.selectByExample(example);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return colleges;
	}

	@Override
	public int update(College college) {
		int result = -1;
		try {
			result = dao.updateByPrimaryKeySelective(college);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int update(College college, CollegeExample example) {
		int result = -1;
		try {
			result = dao.updateByExampleSelective(college, example);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delete(Integer cid) {
		int result = -1;
		try {
			result = dao.deleteByPrimaryKey(cid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int add(College college) {
		int result = -1;
		try {
			result = dao.insertSelective(college);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

}
