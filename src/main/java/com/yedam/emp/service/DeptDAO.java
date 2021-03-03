package com.yedam.emp.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yedam.emp.DeptVO;

@Repository
public class DeptDAO {

	@Autowired JdbcTemplate jdbc;
	
	private String sql1="INSERT INTO departments (?,?,?,?)";
	private String sql2="UPDATE department SET department_name=?,manager_id=?, location_id=? WHERE department_id=?";
	private String sql3="DELETE FROM departments WHERE department_id=?";
	private String sql4="SELECT * FROM departments WHERE department_id=?";
	private String sql5="SELECT * FROM departments";
			
	
//	등록 sql1 
	public int insertDept(DeptVO vo) {
		int result=0;
		result = jdbc.update(sql1, vo.getDepartment_id(),
								   vo.getDepartment_name(),
								   vo.getManager_id(),
								   vo.getLocation_id()
							);
				
		return result;
	}
	
//수정	sql1 
	public int updateDept(DeptVO vo) {
		int result =0;
		result = jdbc.update(sql2, vo.getDepartment_name(),
									vo.getManager_id(),
									vo.getLocation_id(),
									vo.getDepartment_id()
									);
		return result;
	}
	
//	삭제	sql3
	public int deleteDept(DeptVO vo) {
		int result = 0;
		result = jdbc.update(sql3, vo.getDepartment_id());
		
		return result;
	}
	
//	단건조회
	public DeptVO getDept(DeptVO deptVO) {
		return jdbc.queryForObject(sql4,
									new DeptRowMapper(),
									deptVO.getDepartment_id());
	}
	
//	검색조회
	public List<DeptVO> getSearchDept(DeptVO deptVO){
		return jdbc.query(sql5, new DeptRowMapper());
	}
	

	//rowmapper
	class DeptRowMapper implements RowMapper<DeptVO>{

		@Override
		public DeptVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			DeptVO vo = new DeptVO();
			vo.setDepartment_id(rs.getString("department_id"));
			vo.setDepartment_name(rs.getString("department_name"));
			vo.setManager_id(rs.getString("manager_id"));
			vo.setLocation_id(rs.getString("location_id"));
			
			return vo;
		}
		
		
	}
}
