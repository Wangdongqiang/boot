package com.framework.boot.service;

import com.framework.boot.entity.UserInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface UserInfoService {
	UserInfo getUser(String name);
	Page<UserInfo> findUserByPage(Pageable pageInfo);
	UserInfo  getUserById(Long id);
	UserInfo updateUser(UserInfo user);
	void deleteUser(UserInfo user);
	UserInfo addUser(UserInfo user);
	UserInfo findByUsername(String username);
}
