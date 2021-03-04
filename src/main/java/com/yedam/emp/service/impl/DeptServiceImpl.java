package com.yedam.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.emp.DeptSearchVO;
import com.yedam.emp.DeptVO;
import com.yedam.emp.service.DeptDAO;
import com.yedam.emp.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService{

//	@Autowired DeptDAO dao;
	@Autowired DeptMapper dao;
	
	@Override
	public int insertDept(DeptVO vo) {
		return dao.insertDept(vo);
	}

	@Override
	public int updateDept(DeptVO vo) {
		return dao.updateDept(vo);
	}

	@Override
	public int deleteDept(DeptVO vo) {
		return dao.deleteDept(vo);
	}

	@Override
	public DeptVO getDept(DeptVO vo) {
		return dao.getDept(vo);
	}

	@Override
	public List<DeptVO> getSearchDept(DeptVO vo) {
		return dao.getSearchDept(vo);
	}

	@Override
	public int getCount(DeptSearchVO vo) {
		return dao.getCount(vo);
	}

}
