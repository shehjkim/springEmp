package com.yedam.emp.controller;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.deser.std.CollectionDeserializer.CollectionReferringAccumulator;
import com.yedam.emp.UserVO;
import com.yedam.emp.service.UserService;

@RestController
public class UserController {
	
	@Autowired UserService userService;
	
	//단건조회
	@GetMapping("/user/{id}")
	public UserVO getUser(UserVO vo,@PathVariable String id) {
			vo.setId(id);
			return userService.getUser(vo);
	}
	
	//다건조회
	@GetMapping ("/User")
	public List<UserVO> getSearchUser(UserVO vo){
		return userService.getSearchUser(vo);
	}
	
	//등록처리
	@PostMapping("/User")
	public UserVO insertUserVO(@RequestBody UserVO vo) {
		userService.insert(vo);
		if(vo.getId().equals("0")){
			return vo;
		}else {
			return userService.getUser(vo);
		}
	}
	
	//수정처리
	@PutMapping("/User")
	public UserVO updateUserProc(@RequestBody UserVO vo) {
		return vo;
	}
	
	//삭제
	@DeleteMapping(value="/User/{id}")
	public Map deleteUserProc(@RequestBody UserVO vo) {
		int r = userService.delete(vo);
		return Collections.singletonMap("cnt", r);
	}
}
