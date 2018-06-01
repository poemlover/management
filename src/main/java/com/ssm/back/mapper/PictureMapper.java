package com.ssm.back.mapper;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ssm.back.pojo.Picture;
import com.ssm.back.pojo.PictureExample;

@Repository
public interface PictureMapper {

	/**
	 * 返回相应的数据集合
	 *
	 * @param map
	 * @return
	 */
	public List<Picture> findPictures(Map<String, Object> map);

	/**
	 * 数据数目
	 *
	 * @param map
	 * @return
	 */
	public Long getTotalPictures(Map<String, Object> map);

	/**
	 * 添加图片
	 *
	 * @param picture
	 * @return
	 */
	public int insertPicture(Picture picture);

	/**
	 * 修改图片
	 *
	 * @param picture
	 * @return
	 */
	public int updPicture(Picture picture);

	/**
	 * 删除
	 *
	 * @param id
	 * @return
	 */
	public int delPicture(String id);

	/**
	 * 根据id查找
	 *
	 * @param id
	 * @return
	 */
	public Picture findPictureById(String id);

	int deleteByPrimaryKey(Integer id);

	int insert(Picture record);

	int insertSelective(Picture record);

	List<Picture> selectByExample(PictureExample example);

	Picture selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Picture record);

	int updateByPrimaryKey(Picture record);
}