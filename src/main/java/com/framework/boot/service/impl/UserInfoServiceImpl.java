package com.framework.boot.service.impl;

import com.framework.boot.entity.UserInfo;
import com.framework.boot.repository.UserInfoDao;
import com.framework.boot.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service//注入成service
public class UserInfoServiceImpl implements UserInfoService {

	private static final Logger logger = LoggerFactory.getLogger(UserInfoServiceImpl.class);
	@Autowired
	private UserInfoDao userDao;

	//这里实现了分页，看着有点复杂，是因为我原来习惯使用分页插件包（pageHelper），这里为了方便理解直接省略了插件包
	//简化使用了这个包里面的两个类Page和PageInfo
	@Override
	public Page<UserInfo> findUserByPage(Pageable pageInfo) {
		//Page<UserInfo> list=userDao.findAll(new Page(pageInfo.getPageNumber(), pageInfo.getPageSize()));
		return null;
	}

	@Override
	public UserInfo getUserById(Long id) {
		return userDao.findByUid(id);
	}

	@Override
	public UserInfo updateUser(UserInfo user) {
		return userDao.saveAndFlush(user);
	}

	@Override
	public void deleteUser(UserInfo user) {
		 userDao.delete(user);
	}

	@Override
	public UserInfo addUser(UserInfo user) {
		return userDao.save(user);
	}

	@Override
	public UserInfo getUser(String name) {
		return null;
	}
	@Transactional(readOnly=true)  
    @Override  
    public UserInfo findByUsername(String username) {
		logger.info("UserInfoServiceImpl.findByUsername()");
        return userDao.findByUsername(username);  
    }  
}
