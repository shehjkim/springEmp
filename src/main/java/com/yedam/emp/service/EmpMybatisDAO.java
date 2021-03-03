package com.yedam.emp.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yedam.emp.EmpVO;

@Repository
public class EmpMybatisDAO {

	@Autowired SqlSessionTemplate sqlSession;
	
	//등록
	public int insertEmp(EmpVO vo) {
		return sqlSession.insert("EmpDAO.insertEmp",vo);
	}
	
	public int updateEmp(EmpVO vo) {
		return sqlSession.update("EmpDAO.updateEmp",vo);
	}
	
	public int deleteEmp(EmpVO vo) {
		return sqlSession.delete("EmpDAO.deleteEmp",vo);
	}
	
	public EmpVO getEmp(EmpVO empVO) {
		return sqlSession.selectOne("EmpDAO.getEmp", empVO);
	}
	
	
	public List<EmpVO> getSearchEmp(EmpVO empVO) {
//		System.out.println("mybatis list");
		return sqlSession.selectList("EmpDAO.getSearchEmp", empVO);		//emp_mapper에 있는 getSearchEmp
	}
	
}
