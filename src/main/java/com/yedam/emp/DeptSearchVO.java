package com.yedam.emp;

import lombok.Data;

@Data
public class DeptSearchVO extends DeptVO{
	
	Integer page = 1;
	int start = 1;
	int end =10;

}
