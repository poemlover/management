package com.ssm.back.pojo;

import java.io.Serializable;

public class Article implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String articleTitle;

	private String articleCreateDate;

	private Integer isTop;

	private String addName;

	private String articleContent;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle == null ? null : articleTitle.trim();
	}

	public String getArticleCreateDate() {
		return articleCreateDate;
	}

	public void setArticleCreateDate(String articleCreateDate) {
		this.articleCreateDate = articleCreateDate == null ? null : articleCreateDate.trim();
	}

	public Integer getIsTop() {
		return isTop;
	}

	public void setIsTop(Integer isTop) {
		this.isTop = isTop;
	}

	public String getAddName() {
		return addName;
	}

	public void setAdd_name(String addName) {
		this.addName = addName == null ? null : addName.trim();
	}

	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent == null ? null : articleContent.trim();
	}
}