package com.fzu.controller.utils;

import com.fzu.pojo.User;
import com.fzu.pojo.Exclusive;
import com.fzu.repository.ExclusiveRepository;
import com.fzu.repository.UserRepository;
import com.fzu.security.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ViewUtils {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ExclusiveRepository exclusiveRepository;

	public User getCurrentUser() {
		return userRepository.findByEmail(SecurityUtils.getCurrentUserEmail());
	}

	public Exclusive getUserExclusive(){
		User user = getCurrentUser();
		return exclusiveRepository.findByOwnUserId(user.getId()).get(0);
	}

}
