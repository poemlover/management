package com.ssm.back.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssm.back.mapper.UserMapper;
import com.ssm.back.pojo.User;
import com.ssm.back.service.UserService;
import com.ssm.back.util.AntiXssUtil;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public User login(User user) {
		return userMapper.login(user);
	}

	@Override
	public List<User> findUser(Map<String, Object> map) {
		return userMapper.findUsers(map);
	}

	@Override
	public Long getTotalUser(Map<String, Object> map) {
		return userMapper.getTotalUser(map);
	}

	@Override
	public int updateUser(User user) {
		// 防止有人胡乱修改导致其他人无法正常登陆
		if ("admin".equals(user.getUserName())) {
			return 0;
		}
		user.setUserName(AntiXssUtil.replaceHtmlCode(user.getUserName()));
		return userMapper.updateUser(user);
	}

	@Override
	public int addUser(User user) {
		if (user.getUserName() == null || user.getPassword() == null || getTotalUser(null) > 90) {
			return 0;
		}
		user.setUserName(AntiXssUtil.replaceHtmlCode(user.getUserName()));
		return userMapper.addUser(user);
	}

	@Override
	public int deleteUser(Integer id) {
		// 防止有人胡乱修改导致其他人无法正常登陆
		if (2 == id) {
			return 0;
		}
		return userMapper.deleteUser(id);
	}

}
