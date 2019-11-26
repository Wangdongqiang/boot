package com.framework.boot.config;

import javax.annotation.Resource;

import com.framework.boot.entity.SysPermission;
import com.framework.boot.entity.SysRole;
import com.framework.boot.entity.UserInfo;
import com.framework.boot.service.UserInfoService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 身份校验核心类
 * 
 * @author Administrator
 * 
 */
public class MyShiroRealm extends AuthorizingRealm {
	private static final Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);
	@Resource
	private UserInfoService userInfoService;

	/**
	 * 认证信息(身份验证) Authentication 是用来验证用户身份
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		logger.info("MyShiroRealm.doGetAuthenticationInfo()");
		// 获取用户的输入帐号
		String username = (String) token.getPrincipal();
		System.out.println(token.getCredentials());
		// 通过username从数据库中查找 User对象，如果找到，没找到.
		// 实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
		UserInfo userInfo = userInfoService.findByUsername(username);
		logger.info("----->>userInfo=" + userInfo);
		if (userInfo == null) {
			return null;
		}

		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userInfo, // 用户名
				userInfo.getPassword(), // 密码
				ByteSource.Util.bytes(userInfo.getCredentialsSalt()), // salt=username+salt
				getName() // realm name
		);
		return authenticationInfo;
	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		logger.info("权限配置-->MyShiroRealm.doGetAuthorizationInfo()");

		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		UserInfo userInfo = (UserInfo) principals.getPrimaryPrincipal();

		for (SysRole role : userInfo.getRoleList()) {

			authorizationInfo.addRole(role.getRole());
			System.out.println(role.getPermissions());
			for (SysPermission p : role.getPermissions()) {
				System.out.println(p);
				authorizationInfo.addStringPermission(p.getPermission());
			}
		}
		return authorizationInfo;
	}

}
