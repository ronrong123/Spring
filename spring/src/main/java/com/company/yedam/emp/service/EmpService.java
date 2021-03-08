package com.company.yedam.emp.service;

import java.util.ArrayList;

import com.company.yedam.emp.EmpVO;

public interface EmpService {
	void empInsert(EmpVO vo);
	void empUpdate(EmpVO vo);
	void empDelete(EmpVO vo);
	EmpVO empSearch(EmpVO vo);
	ArrayList<EmpVO> empList();
	EmpVO selectOne(EmpVO vo);
}
