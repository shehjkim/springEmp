package com.yedam.emp;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder					//bulider가 들어가면 생성자를  대체 할 수 있
@NoArgsConstructor
@AllArgsConstructor

public class EmpVO {	
	
	private String employee_id;
	private String first_name;
	private String last_name;
	private String email;
	private String phone_number;
	private Date hire_date;
	private String job_id;
	private String salary;
	private String commission_pct;
	private String manager_id;
	private String department_id;
	private String department_name;
	private String job_title;
	
}
