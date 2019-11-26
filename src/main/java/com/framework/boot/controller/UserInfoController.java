package com.framework.boot.controller;

import com.framework.boot.entity.UserInfo;
import com.framework.boot.service.UserInfoService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserInfoController {
	@Autowired // 依赖注入service
			UserInfoService userService;

	@RequestMapping("/findUserByPage")
	@RequiresPermissions("userInfo:view") // 权限管理;
	@ResponseBody
	public Page<UserInfo> getStudents(Pageable pageInfo) {
		return userService.findUserByPage(pageInfo);
	}

	@RequestMapping("/getUserById")
	@RequiresPermissions("userInfo:view") // 权限管理;
	protected UserInfo getUserById(Long id) {
		return userService.getUserById(id);
	}

	@RequestMapping("/deleteUser")
	@RequiresPermissions("userInfo:del") // 权限管理;
	protected void deleteUser(Long id) {
		UserInfo user = new UserInfo();
		user.setUid(id);
		userService.deleteUser(user);
	}

	@RequestMapping(value = "/addUser")
	@RequiresPermissions("userInfo:add") // 权限管理;
	protected UserInfo addUser(UserInfo user) {
		if (user.getUid() != 0) {
			return userService.updateUser(user);
		} else {
			return userService.addUser(user);
		}
	}

	@RequestMapping(value = "/view")
	protected String view() {
		return "userInfo";
	}
}
