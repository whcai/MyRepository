package com.demo.service.impl;

import com.demo.beans.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.TUserMapper;
import com.demo.service.LoginService;

@Service
public class LoginServiceImp implements LoginService {

	@Autowired
	public TUserMapper dao;

	public TUser getTUserByUserId(String userid) {

		TUser tUser = dao.getTUserByUserId(userid);
		if (tUser != null) {
			return tUser;
		}
		return null;
	}

}
