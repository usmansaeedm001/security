package com.mus.securedwebapplicationdemo.security;

import com.mus.securedwebapplicationdemo.annotation.SecurityService;
import com.mus.securedwebapplicationdemo.bean.CustomUserDetails;
import com.mus.securedwebapplicationdemo.constants.EncryptionAlgorithm;
import com.mus.securedwebapplicationdemo.model.ApiUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

@SecurityService
public class AuthenticationProviderService implements AuthenticationProvider {

	@Autowired
	private CustomUserDetailService userDetailService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private SCryptPasswordEncoder sCryptPasswordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = null;
		String username = authentication.getName();
		String password = authentication.getCredentials().toString();
		CustomUserDetails userDetails = userDetailService.loadUserByUsername(username);
		if (userDetails != null) {

			ApiUser apiUser = userDetails.getApiUser();
			if(EncryptionAlgorithm.BCRYPT == apiUser.getAlgorithm() && bCryptPasswordEncoder.matches(password, userDetails.getPassword())){
					usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(),
					userDetails.getAuthorities());
			}else if(EncryptionAlgorithm.BCRYPT == apiUser.getAlgorithm() && sCryptPasswordEncoder.matches(password, userDetails.getPassword())){
				usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword(),
						userDetails.getAuthorities());
			}else{
				throw new BadCredentialsException("username or password is not correct");
			}
		}
		return usernamePasswordAuthenticationToken;

	}

	@Override
	public boolean supports(Class<?> aClass) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(aClass);
	}
}
