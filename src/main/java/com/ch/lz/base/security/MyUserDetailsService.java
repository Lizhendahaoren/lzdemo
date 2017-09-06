package com.ch.lz.base.security;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ch.lz.base.constant.XaConstant;
import com.ch.lz.base.entity.XaCmsUser;
import com.ch.lz.base.repository.MyCmsUserRepository;
import com.ch.lz.base.repository.MyCmsUserRoleRepository;
import com.ch.lz.base.util.XaUtil;

/**
 * 
 * 该类的主要作用是为Spring Security提供一个经过用户认证后的UserDetails UserDetails包括
 * 用户名、密码、是否可用、是否过期等信息。
 * 
 * @author lizhen
 *
 */
@Service("MyUserDetailsService")
@Transactional
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private MyCmsUserRepository myCmsUserRepository;

	@Autowired
	private MyCmsUserRoleRepository myCmsUserRoleRepository;

	private static final Logger logger = Logger.getLogger(MyUserDetailsService.class);

	// 查询用户·权限的信息
	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		logger.info("--查询用户 · 权限的信息--");
		// 返回的用户信息权限实体
		MyUserDetails myUserDetails = new MyUserDetails();
		// 根据arg0查找用户信息
		XaCmsUser cmsUser = myCmsUserRepository.findUserByName(arg0, XaConstant.Status.valid);
		if (XaUtil.isEmpty(cmsUser)) {// 没有这个用户直接返回
			return myUserDetails;
		}
		// 用户名密码
		myUserDetails.setUsername(cmsUser.getUserName());
		myUserDetails.setPassword(cmsUser.getPassword());
		// 存在这个用户时，找出该用户的权限
		List<String> role = myCmsUserRoleRepository.findRoleByUserName(arg0);
		// 存放用户权限的信息
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		// 便利权限roleName
		for (String roleName : role) {
			// 接收一个表示权限的字符串
			GrantedAuthority authority = new SimpleGrantedAuthority(roleName);
			authorities.add(authority);
		}
		myUserDetails.setAuthorities(authorities);// 权限list的信息
		return myUserDetails;
	}

}
