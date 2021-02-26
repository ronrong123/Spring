package com.company.yedam.emp.conroller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.yedam.HomeController;
import com.company.yedam.emp.DeptDAO;
import com.company.yedam.emp.EmpDAO;
import com.company.yedam.emp.EmpVO;
import com.company.yedam.emp.JobDAO;

@Controller  //@Component  1. 컨테이너의 빈으로 등록, 컨트롤러화
public class EmpController {
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired EmpDAO empDAO; //자동인덱션	
	@Autowired JobDAO jobdao;
	@Autowired DeptDAO deptdao;
	//사원목록
	@RequestMapping("/empList")
	public String empList(HttpServletRequest request) {
		request.setAttribute("list", empDAO.selectList());
		return "emp/empList";
	}
	//등록폼
	@GetMapping("/empInsert")
	public String empInsert(HttpServletRequest request) {
		request.setAttribute("jobList", jobdao.selectAll());
		request.setAttribute("deptList", deptdao.selectAll());
		return "emp/empInsert";
	}	
	//등록처리
	@PostMapping("/empInsert")
	public String empInsertProc(EmpVO vo) {
		logger.debug(vo.toString());
		empDAO.insert(vo);
		return "redirect:empList";
		//아무것도 없으면 디폴트로forward
	}	
	//수정폼
	@GetMapping("/empUpdate")
	public String empUpdate(HttpServletRequest request) {
		String empid = request.getParameter("employee_id");
		request.setAttribute("empVO", empDAO.selectOne(empid));
		request.setAttribute("jobList", jobdao.selectAll());
		request.setAttribute("deptList", deptdao.selectAll());
		return "emp/empInsert";
	}		
	//수정처리
	@PostMapping("/empUpdate")
	public String empUpdateProc(EmpVO vo) {
		logger.debug(vo.toString());
		empDAO.update(vo);
		return "redirect:empList";
	}		
	//이메일체크
	
	//사원검색
	@RequestMapping("/empSearch")
	public String empSearch(HttpServletRequest request) {
		request.setAttribute("list", empDAO.selectList());
		return "emp/empSearch";
	}
}
