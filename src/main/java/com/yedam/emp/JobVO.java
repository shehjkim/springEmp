package com.yedam.emp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class JobVO {

	private String job_id;
	private String job_title;
	private String min_salary;
	private String max_salary;
}
