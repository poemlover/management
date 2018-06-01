package com.ssm.back.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.ssm.back.common.Constants;
import com.ssm.back.mapper.ArticleMapper;
import com.ssm.back.pojo.Article;
import com.ssm.back.redis.RedisUtil;
import com.ssm.back.service.ArticleService;
import com.ssm.back.util.AntiXssUtil;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {

	private static final Logger log = Logger.getLogger(ArticleService.class);

	@Resource
	private ArticleMapper articleMapper;
	@Resource
	private RedisUtil redisUtil;

	@Override
	public List<Article> findArticle(Map<String, Object> map) {
		return articleMapper.findArticles(map);
	}

	@Override
	public Long getTotalArticle(Map<String, Object> map) {
		return articleMapper.getTotalArticles(map);
	}

	@Override
	public int addArticle(Article article) {
		if (article.getArticleTitle() == null || article.getArticleContent() == null || getTotalArticle(null) > 90
				|| article.getArticleContent().length() > 50000) {
			return 0;
		}
		article.setArticleTitle(AntiXssUtil.replaceHtmlCode(article.getArticleTitle()));
		if (articleMapper.insertArticle(article) > 0) {
			log.info("insert article success,save article to redis");
			// DB saved on disk
			redisUtil.put(Constants.ARTICLE_CACHE_KEY + article.getId(), article);
			return 1;
		}
		return 0;
	}

	@Override
	public int updateArticle(Article article) {
		if (article.getArticleTitle() == null || article.getArticleContent() == null || getTotalArticle(null) > 90
				|| article.getArticleContent().length() > 50000) {
			return 0;
		}
		article.setArticleTitle(AntiXssUtil.replaceHtmlCode(article.getArticleTitle()));
		if (articleMapper.updArticle(article) > 0) {
			log.info("update article success,delete article in redis and save again");
			redisUtil.del(Constants.ARTICLE_CACHE_KEY + article.getId());
			redisUtil.put(Constants.ARTICLE_CACHE_KEY + article.getId(), article);
			return 1;
		}
		return 0;
	}

	@Override
	public int deleteArticle(String id) {
		redisUtil.del(Constants.ARTICLE_CACHE_KEY + id);
		return articleMapper.delArticle(id);
	}

	@Override
	public Article findById(String id) {
		log.info("get article by id:" + id);
		Article article = (Article) redisUtil.get(Constants.ARTICLE_CACHE_KEY + id, Article.class);
		if (article != null) {
			log.info("article in redis");
			return article;
		}
		Article articleFromMysql = articleMapper.getArticleById(id);
		if (articleFromMysql != null) {
			log.info("get article from mysql and save article to redis");
			redisUtil.put(Constants.ARTICLE_CACHE_KEY + articleFromMysql.getId(), articleFromMysql);
			return articleFromMysql;
		}
		return null;
	}

}
