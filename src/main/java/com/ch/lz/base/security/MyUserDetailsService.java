package com.ch.lz.base.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * 
 * 该类的主要作用是为Spring Security提供一个经过用户认证后的UserDetails
 * UserDetails包括 用户名、密码、是否可用、是否过期等信息。
 * @author lizhen
 *
 */
public class MyUserDetailsService implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
