package com.yedam.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.emp.UserVO;
import com.yedam.emp.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired UserMapper dao;

	@Override
	public int insert(UserVO vo) {
		
		return dao.insert(vo);
	}

	@Override
	public int update(UserVO vo) {
		
		return dao.update(vo);
	}

	@Override
	public int delete(UserVO vo) {

		return dao.delete(vo);
	}

	@Override
	public UserVO getUser(UserVO vo) {

		return dao.getUser(vo);
	}

	@Override
	public List<UserVO> getSearchUser(UserVO vo) {

		return dao.getSearchUser(vo);
	}

}
