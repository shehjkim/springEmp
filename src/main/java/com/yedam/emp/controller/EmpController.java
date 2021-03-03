package com.yedam.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.emp.EmpVO;
import com.yedam.emp.service.EmpService;

@org.springframework.stereotype.Controller
public class EmpController {

	@Autowired EmpService empService;
	
	@RequestMapping("/")
	public String main() {
		return "main";
	}

	@GetMapping("/insertEmp") // 등록페이지로
	public String insertEmp(EmpVO vo) {
		return "/emp/insertEmp";
	}

	@PostMapping("/insertEmp") // 등록 처리
	public String insertEmpProc(EmpVO vo) {
		empService.insertEmp(vo);
		return "redirect:/getSearchEmp";
	}

	@GetMapping("/updateEmp") // 수정페이지로
	public String updateEmp(EmpVO vo,Model model) {
		model.addAttribute("empVO", empService.getEmp(vo));
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
	public String getEmp(EmpVO vo,Model model) {
		model.addAttribute("emp", empService.getEmp(vo));
		return "/emp/getEmp";
	}
	@GetMapping("/getSearchEmp") // 검색 조회 
	public String getSearchEmp(EmpVO vo,Model model) {
		model.addAttribute("list", empService.getSearchEmp(vo) );
		return "/emp/getSearchEmp";
	}
}
