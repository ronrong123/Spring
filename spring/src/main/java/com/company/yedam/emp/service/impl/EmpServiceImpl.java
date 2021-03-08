package com.company.yedam.emp.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.yedam.emp.EmpDAO;
import com.company.yedam.emp.EmpVO;
import com.company.yedam.emp.service.EmpService;

@Service  //@component 상속.  빈등록, 예외처리
public class EmpServiceImpl implements EmpService{

	@Autowired EmpDAO empDAO;
	//dao를 읽어옴
	@Override
	public void empInsert(EmpVO vo) {
		empDAO.insert(vo);
	}

	@Override
	public void empUpdate(EmpVO vo) {
		empDAO.update(vo);
	}

	@Override
	public void empDelete(EmpVO vo) {

	}

	@Override
	public EmpVO empSearch(EmpVO vo) {
		return empDAO.selectOne(vo.getEmployee_id());
	}

	@Override
	public ArrayList<EmpVO> empList() {
		return empDAO.selectList();
	}

	@Override
	public EmpVO selectOne(EmpVO vo) {
		return empDAO.selectOne(vo.getEmployee_id());
	}
	

}
