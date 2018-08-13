package com.hand.filmmgt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hand.filmmgt.model.Film;

public interface FilmRepository extends JpaRepository<Film, Long>{

}
