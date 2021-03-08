package com.company.yedam.emp;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;
@Repository 
public class DeptDAO {
	Connection conn;
	PreparedStatement psmt;
	
	public ArrayList<DeptVO> selectAll(){
		ArrayList<DeptVO> list = new ArrayList<DeptVO>();
		DeptVO vo = null;
		String sql = "SELECT * FROM DEPARTMENTS";
		try {
			conn = JdbcUtil.connect();
			psmt = conn.prepareCall(sql);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new DeptVO();
				vo.setDepartmentId(rs.getInt("department_id"));
				vo.setDepartmentName(rs.getString("department_name"));
				vo.setLocationId(rs.getInt("location_id"));
				vo.setManagerId(rs.getInt("manager_id"));
				list.add(vo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
