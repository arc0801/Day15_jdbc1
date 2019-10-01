package com.arc.t1;

import com.arc.view.DeptView;

public class TestMain {

	public static void main(String[] args) {
		/*
		TestDAO testDAO = new TestDAO();
		testDAO.selectTest();
		
		System.out.println("============");
		testDAO.selectTest2();
		
		System.out.println("***********");
		testDAO.selectTest3();
		
		System.out.println("~~~~~~~~~~~");
		testDAO.selectTest4("SMITH");
		
		TestDAO2 testDAO2 = new TestDAO2();
		testDAO2.insertTest2(7534, "Lina", "ANALYST", 7566, "83/01/01", 3000, 0, 20);
		testDAO.selectTest5();
		
		TestDAO3 testDAO3 = new TestDAO3();
		testDAO3.update1(95, "JEJU");
		 */
		
		TestDAO3 testDAO3 = new TestDAO3();
		DeptView dv = new DeptView();
		DeptDTO deptDTO = testDAO3.deptSelectOne(10);
		
		if(deptDTO!=null) {
			dv.view(deptDTO);
		}else {
			dv.view("없는 부서입니다.");
		}
	}

}
