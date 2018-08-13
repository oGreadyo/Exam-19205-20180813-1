package com.hand.filmmgt.service;

import java.util.List;

import com.hand.filmmgt.model.Film;

public interface FilmService {
	
	/**
	 * 保存一个电影
	 * @param film
	 */
	public void save(Film film);
	
	/**
	 * 更新一个电影
	 * @param film
	 */
	public void update(Film film);
	
	/**
	 * 通过id查找一个电影
	 * @param id
	 */
	public Film findById(Long id);
	
	/**
	 * 找出所有电影
	 * @return
	 */
	public List<Film> findAll();
	
	/**
	 * 通过电影Id删除电影
	 * @param id
	 */
	public void deleteById(Long id);
}
