package com.arc.view;

import java.util.ArrayList;

import com.arc.t1.DeptDTO;

public class DeptView {
	
	public void view(String str) {
		System.out.println(str);
	}

	public void view(DeptDTO deptDTO) {
		System.out.println("Deptno : "+deptDTO.getDeptno());
		System.out.println("Dname : "+deptDTO.getDname());
		System.out.println("Loc : "+deptDTO.getLoc());
		
		
	}
}
