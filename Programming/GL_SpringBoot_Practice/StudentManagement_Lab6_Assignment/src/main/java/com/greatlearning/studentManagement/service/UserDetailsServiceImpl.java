package com.greatlearning.studentManagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.greatlearning.studentManagement.entity.Users;
import com.greatlearning.studentManagement.respository.UserRepository;
import com.greatlearning.studentManagement.security.MyUserDetails;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user = userRepository.getUserByUserName(username);
		if (user == null) {
			throw new UsernameNotFoundException("Invalid Username");
		}

		UserDetails userDetails = new MyUserDetails(user);
		return userDetails;
	}

}
