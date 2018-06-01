package com.ssm.back.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssm.back.common.Result;
import com.ssm.back.common.ResultGenerator;
import com.ssm.back.pojo.PageBean;
import com.ssm.back.pojo.User;
import com.ssm.back.service.UserService;
import com.ssm.back.util.MD5Util;
import com.ssm.back.util.ResponseUtil;
import com.ssm.back.util.StringUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RequestMapping("/users")
@Controller
public class UserController {

	@Autowired
	private UserService userService;

	private static final Logger log = Logger.getLogger(UserController.class);// 日志文件

	/**
	 * 添加或修改管理员
	 */
	@RequestMapping(value = "", method = RequestMethod.POST)
	@ResponseBody
	public Result save(@RequestBody User user) throws Exception {
		int resultTotal = 0;
		String MD5pwd = MD5Util.MD5Encode(user.getPassword(), "UTF-8");
		user.setPassword(MD5pwd);
		resultTotal = userService.addUser(user);
		if (resultTotal > 0) {
			return ResultGenerator.genSuccessResult();
		} else {
			return ResultGenerator.genFailResult("FAIL");
		}
	}

	/**
	 * 修改
	 */
	@RequestMapping(value = "", method = RequestMethod.PUT)
	@ResponseBody
	public Result update(@RequestBody User user) throws Exception {
		String MD5pwd = MD5Util.MD5Encode(user.getPassword(), "UTF-8");
		user.setPassword(MD5pwd);
		int resultTotal = userService.updateUser(user);
		log.info("request: user/update , user: " + user.toString());
		if (resultTotal > 0) {
			return ResultGenerator.genSuccessResult();
		} else {
			return ResultGenerator.genFailResult("FAIL");
		}
	}

	/**
	 * 删除管理员
	 */
	@RequestMapping(value = "/{ids}", method = RequestMethod.DELETE)
	@ResponseBody
	public Result delete(@PathVariable(value = "ids") String ids) throws Exception {
		if (ids.length() > 20) {
			return ResultGenerator.genFailResult("ERROR");
		}
		String[] idsStr = ids.split(",");
		for (int i = 0; i < idsStr.length; i++) {
			userService.deleteUser(Integer.valueOf(idsStr[i]));
		}
		log.info("request: article/delete , ids: " + ids);
		return ResultGenerator.genSuccessResult();
	}

	@RequestMapping(value = "/datagrid", method = RequestMethod.POST)
	public String list(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows, User s_user, HttpServletResponse response)
			throws Exception {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userName", StringUtil.formatLike(s_user.getUserName()));
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<User> userList = userService.findUser(map);
		Long total = userService.getTotalUser(map);
		JSONObject result = new JSONObject();
		JSONArray jsonArray = JSONArray.fromObject(userList);
		result.put("rows", jsonArray);
		result.put("total", total);
		log.info("request: user/list , map: " + map.toString());
		ResponseUtil.write(response, result);
		return null;
	}

	/**
	 * 1. 有 @ModelAttribute 标记的方法, 会在每个目标方法执行之前被 SpringMVC 调用!
	 * 2. @ModelAttribute 注解也可以来修饰目标方法 POJO 类型的入参, 其 value 属性值有如下的作用: 1).
	 * SpringMVC 会使用 value 属性值在 implicitModel 中查找对应的对象, 若存在则会直接传入到目标方法的入参中. 2).
	 * SpringMVC 会一 value 为 key, POJO 类型的对象为 value, 存入到 request 中.
	 */
	// @ModelAttribute
	// public void getUser(@RequestParam(value="id",required=false) Integer id,
	// Map<String, Object> map){
	// System.out.println("modelAttribute method");
	// if(id != null){
	// //模拟从数据库中获取对象
	// User user = new User(1, "Tom", "123456", "Tom");
	// System.out.println("从数据库中获取一个对象: " + user);
	//
	// map.put("user", user);
	// }
	// }

	/**
	 * 登录
	 */
	@ResponseBody
	@RequestMapping(value = "/cookie", method = RequestMethod.POST)
	public Result login(User user) {
		// System.out.println(user);
		try {
			String MD5pwd = MD5Util.MD5Encode(user.getPassword(), "UTF-8");
			user.setPassword(MD5pwd);
		} catch (Exception e) {
			user.setPassword("");
		}
		User resultUser = userService.login(user);// 这里的登录是从数据库查找该用户的信息，若没有则为null
		// System.out.println(resultUser == null);
		log.info("request: user/login , user: " + user.toString());
		if (resultUser == null) {
			Result result = ResultGenerator.genFailResult("请认真核对账号、密码！");
			// System.out.println(result.getMessage());
			return result;
		} else {
			resultUser.setPassword("PASSWORD");
			Map data = new HashMap();
			data.put("currentUser", resultUser);
			Result result = ResultGenerator.genSuccessResult(data);
			// System.out.println(result);
			return result;
		}

	}

	// public UserController() {
	// System.out.println("UserController被加载...");
	// }

}
