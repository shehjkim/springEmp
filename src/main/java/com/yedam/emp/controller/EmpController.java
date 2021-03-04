package com.yedam.emp.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.yedam.emp.DeptSearchVO;
import com.yedam.emp.EmpSearchVO;
import com.yedam.emp.EmpVO;
import com.yedam.emp.JobVO;
import com.yedam.emp.common.Paging;
import com.yedam.emp.service.DeptService;
import com.yedam.emp.service.EmpService;
import com.yedam.emp.service.JobService;


@org.springframework.stereotype.Controller
public class EmpController {

	@Autowired EmpService empService;
	@Autowired DeptService deptService;
	@Autowired JobService jobService;
	
	@RequestMapping("/")
	public String main() {
		return "main";
	}

	@GetMapping("/insertEmp") // 등록페이지로
	public String insertEmp(EmpVO vo) {
		return "/emp/insertEmp";
	}

	@PostMapping("/insertEmp") // 등록 처리
	public String insertEmpProc(EmpVO vo,Model model,
								DeptSearchVO deptSearchVO,
								JobVO jobVO) {
		deptSearchVO.setStart(1);
		deptSearchVO.setEnd(1000);
		model.addAttribute("deptList", deptService.getSearchDept(deptSearchVO));
		model.addAttribute("jobList",jobService.getSearchJob(jobVO));
		empService.insertEmp(vo);
		return "redirect:/getSearchEmp";
	}

	@GetMapping("/updateEmp") // 수정페이지로
	public String updateEmp(EmpVO vo,Model model,
							DeptSearchVO deptSearchVO,
							JobVO jobVO) {
		deptSearchVO.setStart(1);
		deptSearchVO.setEnd(1000);
		model.addAttribute("empVO", empService.getEmp(vo));
		model.addAttribute("deptList",deptService.getSearchDept(deptSearchVO));
		model.addAttribute("jobList",jobService.getSearchJob(jobVO));
		return "/emp/updateEmp";
	}

	@PostMapping("/updateEmp") // 수정 처리
	public String updateEmpProc(EmpVO vo) {
		empService.updateEmp(vo);
		return "redirect:/getSearchEmp";
	}
	@GetMapping("/deleteEmp") //삭제처리
	public String deleteEmpProc(EmpVO vo) {
		empService.deleteEmp(vo);
		return "redirect:/getSearchEmp";
	}
	
	@GetMapping("/getEmp") // 단건 조회 
	public String getEmp(Model model,
									//HttpServletRequest request)
//								@RequestParam String employee_id
//								@RequestParam (value="id",
//												required=false,
//												defaultValue="100") String employee_id
			
//								@PathVariable String employee_id
								EmpVO vo
			){						
//		1.getParameter(원래하던방법)
//		String emp_id = request.getParameter("employee_id");
//		if(employee_id == null) {
//			employee_id = "100"
//		}
		
//		EmpVO vo = new EmpVO();
//		vo.setEmployee_id(employee_id);
		
		
		model.addAttribute("emp", empService.getEmp(vo));
		return "/emp/getEmp";
	}
	
	@GetMapping("/getSearchEmp") //검색조회
	public String getSearchEmp(EmpSearchVO vo,Paging paging,Model model) {
		paging.setPageUnit(5);	//한페이지에 표시되는 레코드 건수
		paging.setPageSize(3); 	//페이지번호
		//페이징
		if(vo.getPage() == null) {
			vo.setPage(1);
		}
		vo.setStart(paging.getFirst());
		vo.setEnd(paging.getLast());
		paging.setTotalRecord(empService.getCount(vo));	//데이터 없으면 더이상 다음페이지 안만들어짐
		model.addAttribute("paging", paging);
		model.addAttribute("list", empService.getSearchEmp(vo) );
		return "/emp/getSearchEmp";
	}
}
