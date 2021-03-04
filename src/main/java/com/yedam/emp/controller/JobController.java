package com.yedam.emp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.yedam.emp.JobVO;
import com.yedam.emp.common.Paging;
import com.yedam.emp.service.JobService;

@Controller
public class JobController {
	
	@Autowired JobService jobService;
	
	//등록폼
		@GetMapping("/insertJob")
		public String insertJob(JobVO vo) {
			return "/job/insertJob";
		}

	//등록처리
		@PostMapping("/insertJob")
		public String insertJobProc(JobVO vo) {
			jobService.insertJob(vo);
			return "redirect:/getSearchJob";
		}
	//수정폼
		@GetMapping("/updateJob")
		public String updateJob(JobVO vo,Model model) {
			model.addAttribute("jobVO", jobService.getJob(vo));
			return "/job/updateJob";
		}

	//수정처리
		@PostMapping("/updateJob")
		public String updateJobProc(JobVO vo) {
			jobService.updateJob(vo);
			return "redirect:/getSearchJob";
		}
	//삭제처리
		@GetMapping("/deleteJob")
		public String deleteJob(JobVO vo) {
			jobService.deleteJob(vo);
			return "/job/getSearchJob";
		}

	//단건조회
		@GetMapping("/getJob")
		public String getJob(JobVO vo,Model model) {
			model.addAttribute("job", jobService.getJob(vo));
			return "/job/getJob";
		}

	//검색조회
		@GetMapping("/getSearchJob")
		public String getSearchJob(JobVO vo,Paging paging, Model model) {
			model.addAttribute("list", jobService.getSearchJob(vo));
			return "/job/getSearchJob"; }
		}
	
