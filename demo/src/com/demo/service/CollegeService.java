package com.demo.service;

import java.util.List;
import java.util.Map;

import com.demo.beans.College;
import com.demo.beans.CollegeExample;

public interface CollegeService {

	public College getCollege(Integer cid);
	
	public College getCollegeByExample(CollegeExample example);

	public List<College> getAllCollege(CollegeExample example);
	
	public int update(College college);
	
	public int update(College college,CollegeExample example);

	public int delete(Integer cid);
	
	public int add(College college);
	

}
