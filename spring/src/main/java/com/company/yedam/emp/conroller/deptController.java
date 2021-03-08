package com.company.yedam.emp.conroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.yedam.HomeController;
import com.company.yedam.emp.service.DeptService;

@Controller 
public class deptController {
	private static final 
	Logger logger = LoggerFactory.getLogger(HomeController.class);
	//부서목록
	@Autowired DeptService deptService;
	
	//목록
	@RequestMapping("/deptList")
	public String deptList(Model model) {
		model.addAttribute("list", deptService.deptList());
		return "dept/deptlist";
	}
	
}
