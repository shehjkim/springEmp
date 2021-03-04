package com.yedam.emp.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.yedam.emp.JobVO;

@Repository
public class JobDAO {

	@Autowired
	JdbcTemplate jdbc;

	private String sql1 = "INSERT INTO jobs VALUES (?,?,?,?)";
	private String sql2 = "UPDATE jobs SET job_title=?, min_salary=?, max_salary=? WHERE job_id=?";
	private String sql3 = "DELETE FROM jobs WHERE job_id=?";
	private String sql4 = "SELECT * FROM jobs WHERE job_id=?";
	private String sql5 = "SELECT * FROM jobs";

//등록	
	public int insertJob(JobVO vo) {
		int result = 0;

		return result;
	}

//수정
	public int updateJob(JobVO vo) {
		int result = 0;

		return result;
	}

//삭제
	public int deleteJob(JobVO vo) {
		int result = 0;

		return result;
	}

//단건조회

	public JobVO getJobVO(JobVO jobVO) {
		return jdbc.queryForObject(sql4, new JobRowMapper(), jobVO.getJob_id());
	}

//전체조회

	public List<JobVO> getSearchJob(JobVO jobVO) {
		return jdbc.query(sql5, new JobRowMapper());
	}

	class JobRowMapper implements RowMapper<JobVO> {

		@Override
		public JobVO mapRow(ResultSet rs, int rowNum) throws SQLException {
			JobVO vo = new JobVO();
			vo.setJob_id(rs.getString("job_id"));
			vo.setJob_title(rs.getString("job_title"));
			vo.setMin_salary(rs.getString("min_salary"));
			vo.setMax_salary(rs.getString("max_salary"));

			return vo;
		}

	}
}
