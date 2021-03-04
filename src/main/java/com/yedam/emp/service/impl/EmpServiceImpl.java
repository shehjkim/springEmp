package com.yedam.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yedam.emp.EmpSearchVO;
import com.yedam.emp.EmpVO;
import com.yedam.emp.service.EmpMybatisDAO;
import com.yedam.emp.service.EmpService;
import com.yedam.emp.service.EmpSpringDAO;

@Service
public class EmpServiceImpl implements EmpService{

//	@Autowired EmpSpringDAO dao;
//	@Autowired EmpMybatisDAO dao;
	@Autowired EmpMapper dao;
	
	//@Transactional   
	public int insertEmp(EmpVO vo) {
		//dao.insertEmp(vo);			//트랜잭션이 지정되지 않으면 자동커밋됨
		return dao.insertEmp(vo);	//uk 에러 발생. 트랜잭션 지정된 경우에는 모든 쿼리가 롤백됨
	}

	@Override
	public int updateEmp(EmpVO vo) {
		return dao.updateEmp(vo);
	}

	@Override
	public int deleteEmp(EmpVO vo) {
		return dao.deleteEmp(vo);
	}

	@Override
	public EmpVO getEmp(EmpVO vo) {
		return dao.getEmp(vo);
	}

	@Override
	public List<EmpVO> getSearchEmp(EmpSearchVO vo) {
		// TODO Auto-generated method stub
		return dao.getSearchEmp(vo);
	}

	@Override
	public int getCount(EmpSearchVO vo) {
		return dao.getCount(vo);
	}
	
	

}
