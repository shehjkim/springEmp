package com.yedam.emp.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yedam.emp.EmpVO;


@Repository
public class EmpSpringDAO {

	@Autowired JdbcTemplate jdbc;
	
	private String INSERT_EMP="INSERT INTO EMPLOYEES "
							+ "EMPLOYEE_ID, "
							+ "LAST_NAME, "
							+ "EMAIL, "
							+ "HIRE_DATE, "
							+ "JOB_ID, "
							+ "department_id, "
							+ "VALUES (?,?,?,?,?,?)";
	private String UPDATE_EMP="UPDATE employees SET EMAIL=?, phone_number=?, job_id=?,department_id=? WHERE EMPLOYEE_ID=?";
	private String DELETE_EMP="DELETE FROM employees WHERE employee_id=?";
	private String GET_EMP="SELECT employee_id, first_name, last_name, salary, hire_date, department_id, job_id, email FROM EMPLOYEES WHERE employee_id=?";
	private String GET_SEARCH_EMP="SELECT employee_id, first_name, last_name, salary, hire_date, department_id, job_id, email FROM EMPLOYEES";
	
	//등록
		public int insertEmp(EmpVO vo) {
			int result = 0;
			result = jdbc.update(INSERT_EMP, vo.getEmployee_id(),
											vo.getLast_name(),
											vo.getEmail(), 
											vo.getPhone_number(),
											vo.getHire_date(), 
											vo.getJob_id(),
											vo.getDepartment_id());
			
			return result;
		}
	//수정
		public int updateEmp(EmpVO vo) {
			int result = 0;
			result = jdbc.update(UPDATE_EMP	,vo.getEmail()
											,vo.getPhone_number()
											,vo.getJob_id()
											,vo.getDepartment_id()
											,vo.getEmployee_id());
					
			
			return result;
		}
	
	//삭제
		public int deleteEmp(EmpVO vo) {
			int result = 0;
			result = jdbc.update(DELETE_EMP, vo.getEmployee_id());
		
			return result;
		}
	
	//단건조회
		public EmpVO getEmp(EmpVO empVO) {
			return jdbc.queryForObject(GET_EMP, 
										new EmpRowMapper(), 
										empVO.getEmployee_id());

		}
	//검색조회
		public List<EmpVO> getSearchEmp(EmpVO empVO) {
			return jdbc.query(GET_SEARCH_EMP,
							  new EmpRowMapper());
		}
	
		
		
	//rowmapper
		class EmpRowMapper implements RowMapper<EmpVO>{

			@Override
			public EmpVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				EmpVO vo = new EmpVO();
				vo.setEmployee_id(rs.getString("employee_id"));
				vo.setFirst_name(rs.getString("first_name"));
				vo.setLast_name(rs.getString("last_name"));
				vo.setSalary(rs.getString("salary"));
				vo.setHire_date(rs.getDate("hire_date"));
				vo.setDepartment_id(rs.getString("department_id"));
				vo.setJob_id(rs.getString("job_id"));
				vo.setEmail(rs.getString("email"));
				
				return vo;
			}
			
		}
}
