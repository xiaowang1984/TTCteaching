package com.neuedu.dao;

import java.util.List;

import com.neuedu.pojo.Language;
import com.neuedu.pojo.Point;

public interface LanguageDao {
	public List<Language> getLanguages(Language language);
	public int add(Language language);
	public int update(Language language);
	public int del(int id);
	public Language getLanguageById(Language language);
	public int getCount(Language language);
	public List<Language> getLanguagesAndModules();
}