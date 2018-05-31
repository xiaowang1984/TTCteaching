package com.neuedu.service.language;

import java.util.List;
import com.neuedu.util.Message;
import com.neuedu.pojo.Language;
import com.neuedu.util.ResultData;

public interface IlanguageService {
	public ResultData getLanguages(Language language);
	public Message add(Language language);
	public Message update(Language language);
	public Message del(int id);
	public Language getLanguageById(Language language);
	public List<Language> getList(Language language);
	public List<Language> getLanguagesAndModules();
}
