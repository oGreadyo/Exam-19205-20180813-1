package com.hand.filmmgt.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="langu")
public class Language {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id ;
	
	/**
	 * 语言
	 */
	private String language;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Language(Long id, String language) {
		super();
		this.id = id;
		this.language = language;
	}

	public Language() {
		super();
	}

	@Override
	public String toString() {
		return "Language [id=" + id + ", language=" + language + "]";
	}
	
}
