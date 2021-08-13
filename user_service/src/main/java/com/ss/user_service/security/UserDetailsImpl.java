package com.ss.user_service.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.ss.user_service.entity.User;

public class UserDetailsImpl implements UserDetails {

	Logger logger = LoggerFactory.getLogger(UserDetailsImpl.class);
	
	private User user;
	
	public UserDetailsImpl(User user) {
		logger.error("HELLO1");
		this.user = user;
		logger.error("HELLO2");
		//logger.error(user.setRoleList());
		//logger.error(user.getRole().getName());
		logger.error("HELLO3");
		//logger.error(user.getRoleList().get(0));
		logger.error("HELLO4");

	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		user.getRoleList().forEach(r -> {
			GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + r);
			authorities.add(authority);
		});

		return authorities;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return user.getActive() == 1;
	}

}
