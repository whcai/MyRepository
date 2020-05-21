package com.demo.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.TModule;
import com.demo.beans.TModuleExample;
import com.demo.dao.TModuleMapper;
import com.demo.service.TModuleService;

@Service
public class TModuleServiceImp implements TModuleService {

	public static Logger logger = Logger.getLogger(TModuleServiceImp.class);

	@Autowired
	public TModuleMapper dao;

	@Override
	public TModule geTModule(String moduleid) {
		TModule tModule = null;
		try {
			tModule = dao.selectByPrimaryKey(moduleid);
			if (tModule != null) {
				return tModule;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<TModule> getAllTModule(TModuleExample example) {
		List<TModule> tModules = null;
		try {
			tModules = dao.selectByExample(example);
			if (tModules.size() > 0) {
				return tModules;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	// 通过ifLeaf 获取一级、二级、三级菜单
	@Override
	public List<TModule> getTModuleList(String ifLeaf) {
		TModuleExample te = new TModuleExample();
		te.createCriteria().andIfleafEqualTo(ifLeaf);
		List<TModule> tModules = null;
		try {
			tModules = dao.selectByExample(te);
			if (tModules.size() > 0) {
				return tModules;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
