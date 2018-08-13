package com.hand.filmmgt.service;

import java.util.List;

import com.hand.filmmgt.model.Language;

public interface LanguageService {

	public Language findById(Long id);
	
	public void update(Language language);
	
	public void save(Language language);
	
	public 	List<Language> findAll();
}
