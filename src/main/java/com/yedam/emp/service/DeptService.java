package com.yedam.emp.service;

import java.util.List;

import com.yedam.emp.DeptSearchVO;
import com.yedam.emp.DeptVO;

public interface DeptService {
	
	//등록
	public int insertDept(DeptVO vo);
	//수정
	public int updateDept(DeptVO vo);
	//삭제
	public int deleteDept(DeptVO vo);
	//단건조회
	public DeptVO getDept(DeptVO vo);
	//전체/검색조회
	public List<DeptVO> getSearchDept(DeptVO vo);
	//
	public int getCount(DeptSearchVO vo);
}
