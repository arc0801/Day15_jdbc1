package com.arc.t1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class TestDAO2 {
	
	public void insertTest2(int empno, String ename, String job, int mgr, String hiredate, int sal, int comm, int deptno) {
		//empno 매개변수 임의의 값
		//job 매개변수 임의의 값 : 기존의 직종 중 1개
		//mgr 매개변수 임의의 값 : 기존의 매니저 번호 중 1개
		//deptno 매개변수 임의의 값 : 기존의 dept 부서번호 중 1개
		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Connection con = null;
		PreparedStatement st = null;
		
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			String sql = "insert into emp (empno, ename, job, mgr, hiredate, sal, comm, deptno) "
					+ "values(?, ?, ?, ?, ?, ?, ?, ?)";
			st = con.prepareStatement(sql);
			
			st.setInt(1, empno);
			st.setString(2, ename);
			st.setString(3, job);
			st.setInt(4, mgr);
			st.setString(5, hiredate);
			st.setInt(6, sal);
			st.setInt(7, comm);
			st.setInt(8, deptno);
			
			
			int result = st.executeUpdate();
			
			if(result>0) {
				System.out.println("Success");
			}else {
				System.out.println("Fail");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	

	public void insertTest(int deptno, String dname, String loc) {
		//dept 100 부서명:S1, 지역:Incheon
		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";
		
		Connection con = null;
		Statement st = null;
		
		
		try {
			Class.forName(driver);
			
			con = DriverManager.getConnection(url, user, password);
			
			String sql = "insert into dept (deptno, dname, loc) "
					+ "values (" +deptno+ ", '" +dname+ "', '" +loc+ "')";
			
			st = con.createStatement();
			int result = st.executeUpdate(sql);
			
			if(result>0) {
				System.out.println("Success");
			}else {
				System.out.println("Fail");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
	}
}
