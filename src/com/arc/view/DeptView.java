package com.arc.view;

public class DeptView {

	public void view() {
		while(rs.next()) {
			int empno = rs.getInt(1);
			String ename = rs.getString(2);
			String job = rs.getString(3);
			int mgr = rs.getInt(4);
			String hiredate = rs.getString(5);
			int sal = rs.getInt(6);
			int comm = rs.getInt(7);
			int deptno = rs.getInt(8);

			System.out.println(empno);
			System.out.println(ename);
			System.out.println(job);
			System.out.println(mgr);
			System.out.println(hiredate);
			System.out.println(sal);
			System.out.println(comm);
			System.out.println(deptno);
			System.out.println("++++++++++++++++");
		}
		
	}
}
