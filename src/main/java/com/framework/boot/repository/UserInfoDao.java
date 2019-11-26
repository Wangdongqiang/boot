package com.framework.boot.repository;

import com.framework.boot.entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoDao  extends JpaRepository<UserInfo, Long>, JpaSpecificationExecutor<UserInfo> {
	 /** 通过username查找用户信息 **/  
    public UserInfo findByUsername(String username);

    public UserInfo findByUid(Long id);
}
