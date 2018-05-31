package com.neuedu.dao;

import java.util.List;

import com.neuedu.pojo.Module;

public interface ModuleDao {
	public List<Module> getModules(Module module);
	public int add(Module module);
	public int update(Module module);
	public int del(int id);
	public Module getModuleById(Module module);
	public int getCount(Module module);
}