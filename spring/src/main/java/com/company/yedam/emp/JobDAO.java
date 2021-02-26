package com.company.yedam.emp;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.stereotype.Component;
@Component
public class JobDAO {
	Connection conn;
	PreparedStatement psmt;
	
	
	public ArrayList<JobVO> selectAll(){
		ArrayList<JobVO> list = new ArrayList<JobVO>();
		JobVO vo = null;
		try {
			conn = JdbcUtil.connect();
			String sql = "SELECT * FROM JOBS ORDER BY JOB_TITLE";
			psmt = conn.prepareStatement(sql);
			ResultSet rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new JobVO();
				vo.setJobId(rs.getString("job_id"));
				vo.setJobTitle(rs.getString("job_title"));
				vo.setMaxSalary(rs.getInt("max_salary"));
				vo.setMinSalary(rs.getInt("min_salary"));
				list.add(vo);
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			JdbcUtil.disconnect(conn);
		}	
		return list;
	}

}
