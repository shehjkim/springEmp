package com.yedam.emp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yedam.emp.UserVO;

@Service
public interface UserService {

	public int insert(UserVO vo);
	
	public int update(UserVO vo);
	
	public int delete(UserVO vo);
	
	public UserVO getUser(UserVO vo);
	
	public List<UserVO> getSearchUser(UserVO vo);
	
}
