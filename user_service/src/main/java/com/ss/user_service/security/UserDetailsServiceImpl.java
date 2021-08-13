package com.ss.user_service.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ss.user_service.dao.UserDao;
import com.ss.user_service.entity.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao userRepository;
	
	Logger logger = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(arg0);
		logger.error("HELLO");
		logger.error(user.setRoleList());
		user.setActive(1);
		UserDetailsImpl userDetails = new UserDetailsImpl(user);

		return userDetails;
	}

}
