package com.company.yedam.emp;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeptVO {
	private int departmentId;
	private String departmentName;
	private int managerId;
	private int locationId;
}
