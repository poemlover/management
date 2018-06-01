package com.ssm.back.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.back.mapper.PictureMapper;
import com.ssm.back.pojo.Picture;
import com.ssm.back.service.PictureService;
import com.ssm.back.util.AntiXssUtil;

@Service("pictureService")
public class PictureServiceImpl implements PictureService {
	@Resource
	private PictureMapper pictureMapper;

	@Override
	public List<Picture> findPicture(Map<String, Object> map) {
		return pictureMapper.findPictures(map);
	}

	@Override
	public Long getTotalPicture(Map<String, Object> map) {
		return pictureMapper.getTotalPictures(map);
	}

	@Override
	public int addPicture(Picture picture) {
		if (picture.getPath() == null || getTotalPicture(null) > 90 || picture.getPath().length() > 100
				|| picture.getUrl().length() > 100) {
			return 0;
		}
		picture.setUrl(AntiXssUtil.replaceHtmlCode(picture.getUrl()));
		return pictureMapper.insertPicture(picture);
	}

	@Override
	public int updatePicture(Picture picture) {
		if (picture.getPath() == null || getTotalPicture(null) > 90 || picture.getPath().length() > 100
				|| picture.getUrl().length() > 100) {
			return 0;
		}
		picture.setUrl(AntiXssUtil.replaceHtmlCode(picture.getUrl()));
		return pictureMapper.updPicture(picture);
	}

	@Override
	public int deletePicture(String id) {
		return pictureMapper.delPicture(id);
	}

	@Override
	public Picture findById(String id) {
		return pictureMapper.findPictureById(id);
	}

}
