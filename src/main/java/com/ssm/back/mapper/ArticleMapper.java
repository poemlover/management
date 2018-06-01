package com.ssm.back.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ssm.back.pojo.Article;
import com.ssm.back.pojo.ArticleExample;

@Repository
public interface ArticleMapper {

	/**
	 * 返回相应的数据集合
	 */
	public List<Article> findArticles(Map<String, Object> map);

	/**
	 * 数据数目
	 */
	public Long getTotalArticles(Map<String, Object> map);

	/**
	 * 添加文章
	 */
	public int insertArticle(Article article);

	/**
	 * 修改文章
	 */
	public int updArticle(Article article);

	/**
	 * 删除
	 */
	public int delArticle(String id);

	/**
	 * 根据id查找
	 */
	public Article getArticleById(String id);

	int deleteByPrimaryKey(Integer id);

	int insert(Article record);

	int insertSelective(Article record);

	List<Article> selectByExampleWithBLOBs(ArticleExample example);

	List<Article> selectByExample(ArticleExample example);

	Article selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Article record);

	int updateByPrimaryKeyWithBLOBs(Article record);

	int updateByPrimaryKey(Article record);
}