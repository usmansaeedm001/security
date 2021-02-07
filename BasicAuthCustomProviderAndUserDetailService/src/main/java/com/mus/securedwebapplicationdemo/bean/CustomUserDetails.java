package com.mus.securedwebapplicationdemo.bean;

import com.mus.securedwebapplicationdemo.model.ApiUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

public class CustomUserDetails implements UserDetails {

	private ApiUser apiUser;

	public CustomUserDetails(ApiUser apiUser) {
		this.apiUser = apiUser;
	}

	public ApiUser getApiUser() {
		return apiUser;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
		Stream.ofNullable(apiUser.getAuthorities()).flatMap(Collection::stream).map(authority -> new SimpleGrantedAuthority(authority.getName()))
				.forEach(grantedAuthorityList::add);
		return grantedAuthorityList;
	}

	@Override
	public String getPassword() {
		return apiUser.getPassword();
	}

	@Override
	public String getUsername() {
		return apiUser.getUsername();
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
		return true;
	}
}
