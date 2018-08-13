package com.hand.filmmgt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hand.filmmgt.model.Language;
import com.hand.filmmgt.repository.LanguageRepository;
import com.hand.filmmgt.service.LanguageService;

@Service
public class LanguageServiceImpl implements LanguageService{
	
	@Autowired
	private LanguageRepository languageRepository;

	@Override
	public Language findById(Long id) {
		return languageRepository.findOne(id);
	}

	@Override
	public void update(Language language) {
		languageRepository.saveAndFlush(language);
	}

	public LanguageRepository getLanguageRepository() {
		return languageRepository;
	}

	public void setLanguageRepository(LanguageRepository languageRepository) {
		this.languageRepository = languageRepository;
	}

	@Override
	public void save(Language language) {
		languageRepository.save(language);
	}

	@Override
	public List<Language> findAll() {
		return languageRepository.findAll();
	}
	
}
