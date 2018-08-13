package com.hand.filmmgt.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * 电影信息
 * @author 周宇
 *
 */
@Entity
@Table(name="film")
public class Film {

	@Id
	private Long id;
	
	/**
	 * 电影名
	 */
	private String title;
	
	/**
	 * 电影描述
	 */
	private String description;
	
	/**
	 * 对应的语言
	 */
	@OneToOne
	@JoinColumn(name="l_id")
	private Language language;
	
	/**
	 * 电影图片路径
	 */
	private String picPath;
	
	/**
	 * 版本号
	 */
	private Long versionId = 0L;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public String getPicPath() {
		return picPath;
	}

	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}

	public Long getVersionId() {
		return versionId;
	}

	public void setVersionId(Long versionId) {
		this.versionId = versionId;
	}

	public Film(Long id, String title, String description, Language language, String picPath, Long versionId) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.language = language;
		this.picPath = picPath;
		this.versionId = versionId;
	}

	public Film() {
		super();
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", title=" + title + ", description=" + description + ", language=" + language
				+ ", picPath=" + picPath + ", versionId=" + versionId + "]";
	}
	
}
