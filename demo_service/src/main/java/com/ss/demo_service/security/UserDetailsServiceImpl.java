package com.ss.demo_service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ss.demo_service.db.UserRepository;
import com.ss.demo_service.entity.User;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(arg0);
		UserDetailsImpl userDetails = new UserDetailsImpl(user);
		return userDetails;
	}

}
