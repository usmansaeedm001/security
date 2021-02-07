package com.mus.securedwebapplicationdemo.security;

import com.mus.securedwebapplicationdemo.annotation.SecurityService;
import com.mus.securedwebapplicationdemo.bean.CustomUserDetails;
import com.mus.securedwebapplicationdemo.repository.ApiUserRepository;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@SecurityService
public class CustomUserDetailService implements UserDetailsService {

	private final ApiUserRepository userRepository;

	public CustomUserDetailService(ApiUserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public CustomUserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		return new CustomUserDetails(userRepository.findApiUserByUsername(s).orElseThrow(() -> new BadCredentialsException("username or password is not correct")));
	}
}
