package com.demo.service;

import java.util.List;

import com.demo.beans.TModule;
import com.demo.beans.TModuleExample;

public interface TModuleService {
	
	// 通过moduleid 查找 tmodule
	public TModule geTModule(String moduleid);

	public List<TModule> getAllTModule(TModuleExample module);
	
	public List<TModule> getTModuleList(String ifLeaf);
	
	

}
