package com.hand.filmmgt.service.impl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hand.filmmgt.model.Film;
import com.hand.filmmgt.repository.FilmRepository;
import com.hand.filmmgt.service.FilmService;

@Service
public class FilmServiceImpl implements FilmService{
	
	@Autowired
	private FilmRepository filmRepository;

	@Override
	public void save(Film film) {
		filmRepository.save(film);
	}

	@Override
	public void update(Film film) {
		filmRepository.saveAndFlush(film);
	}

	@Override
	public Film findById(Long id) {
		return filmRepository.findOne(id);
	}

	@Override
	public List<Film> findAll() {
		return filmRepository.findAll();
	}
	
	
	@Override
	public void deleteById(Long id) {
		filmRepository.delete(id);
	}


	public FilmRepository getFilmRepository() {
		return filmRepository;
	}

	public void setFilmRepository(FilmRepository filmRepository) {
		this.filmRepository = filmRepository;
	}

}
