package com.mus.securedwebapplicationdemo.repository;

import com.mus.securedwebapplicationdemo.model.ApiUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApiUserRepository extends JpaRepository<ApiUser, Long> {

	public Optional<ApiUser> findApiUserByUsername(String username);
}
