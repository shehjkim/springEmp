package com.yedam.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
		// TODO Auto-generated method stub
		return dao.updateDept(vo);
	}

	@Override
	public int deleteDept(DeptVO vo) {
		// TODO Auto-generated method stub
		return dao.deleteDept(vo);
	}

	@Override
	public DeptVO getDept(DeptVO vo) {
		// TODO Auto-generated method stub
		return dao.getDept(vo);
	}

	@Override
	public List<DeptVO> getSearchDept(DeptVO vo) {
		// TODO Auto-generated method stub
		return dao.getSearchDept(vo);
	}

}
