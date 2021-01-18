package com.bitacademy.mysite.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bitacademy.mysite.repository.UserRepository;
import com.bitacademy.mysite.vo.UserVo;

@Service
public class UserService {
	private static final Log LOGGER = LogFactory.getLog(UserService.class);

	@Autowired
	private UserRepository userRepository;

	public boolean join(UserVo vo) {
		LOGGER.info("before--->" + vo);
		int count = userRepository.insert(vo);
		LOGGER.info("after--->" + vo);

		return count == 1;
	}

	public UserVo getUser(UserVo vo) {
		// System.out.println("findbyEmail-->" + userRepository.findByEmail(vo.getEmail()));
		// return userRepository.findByEmailAndPassword2(vo);
		return userRepository.findByEmailAndPassword(vo);
	}

	public UserVo getUser(Long no) {
		return userRepository.findByNo(no);
	}

	public boolean updateUser(UserVo vo) {
		int count = userRepository.update(vo);
		return count == 1;
	}
	
	
}
