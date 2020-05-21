package com.demo.test;

import com.demo.beans.College;
import com.demo.beans.CollegeExample;
import com.demo.beans.Student;
import com.demo.beans.TModule;
import com.demo.beans.TModuleExample;
import com.demo.beans.TModuleExample.Criteria;
import com.demo.beans.TUser;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.service.CollegeService;
import com.demo.service.LoginService;
import com.demo.service.StudentService;
import com.demo.service.TModuleService;

/**
 * @author whc mybatis数据库连接测试
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml", "classpath:mybatis-config.xml" })
public class MybatisTest {

	@Autowired
	LoginService service;

	@Autowired
	TModuleService service2;

	@Autowired
	StudentService service3;

	@Autowired
	CollegeService collegeService;

	@Autowired
	SqlSessionFactoryBean sqlSessionFactory;

	@Test
	public void collegeTest() {
		
	}

	@Test
	public void tUserTest() {

		TUser tUser = service.getTUserByUserId("admin");
		System.out.println(tUser.toString());

	}

	@Test
	public void tModuleExampleTest() {
		TModuleExample example = new TModuleExample();
		example.createCriteria().andIfleafEqualTo("1");
		List<TModule> tModule = service2.getAllTModule(example);
		System.out.println(tModule.toString());
	}

}
