package com.arc.t1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.arc.util.DBConnector;

public class TestDAO {
	
	private DBConnector db;
	
	public TestDAO(){
		db = new DBConnector();
	}

	public void selectTest5() {
		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			String sql = "select * from emp";
			st = con.createStatement();
			rs = st.executeQuery(sql);

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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void selectTest4(String ename) {
		//emp 출력
		//empno, ename, sal, job
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			//DBConnector db = new DBConnector();
			//String sql = "select empno, ename, sal, job "
			//		+ "from emp";
			con = db.getConnect();
			
			String sql = "select empno, ename, sal, job from emp "
					+ "where ename = '"+ename+"'";
			
			st = con.createStatement();
			rs = st.executeQuery(sql);

			if(rs.next()) {
				int empno = rs.getInt("empno");
				String name = rs.getString("ename");
				int sal = rs.getInt("sal");
				String job = rs.getString("job");

				System.out.println(empno);
				System.out.println(name);
				System.out.println(sal);
				System.out.println(job);
			}else {
				System.out.println("해당 사원이 없습니다.");
			}

			/*
			while(rs.next()) {
				int empno = rs.getInt(1);
				String name = rs.getString(2);
				int sal = rs.getInt(3);
				String job = rs.getString(4);

				if(name.equals(ename)){
					System.out.println(empno);
					System.out.println(name);
					System.out.println(sal);
					System.out.println(job);
				}else {
					break;
				}
			}
			 */
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}//4


	public void selectTest3() {
		//emp 출력
		//부서별, 부서번호, 급여총합계, 급여평균
		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			String sql = "select deptno, sum(sal) sum, avg(sal) avg "
					+ "from emp "
					+ "group by deptno";
			st = con.createStatement();
			rs = st.executeQuery(sql);

			while(rs.next()) {
				int deptno = rs.getInt(1);
				int sum = rs.getInt(2);
				Double avg = rs.getDouble(3);

				System.out.println("부서번호 : "+deptno);
				System.out.println("급여총액 : "+sum);
				System.out.println("급여평균 : "+avg);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}//3


	public void selectTest2() {
		//emp 테이블 출력
		//ename, sal, comm, job, deptno
		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";

		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			String sql = "select * from emp";
			st = con.createStatement();
			rs = st.executeQuery(sql);

			while(rs.next()) {
				String ename = rs.getString("ename");
				int sal = rs.getInt("sal");
				int comm = rs.getInt("comm");
				String job = rs.getString("job");
				int deptno = rs.getInt("deptno");

				System.out.println("사원명 : "+ename);
				System.out.println("급여 : "+sal);
				System.out.println("커미션 : "+comm);
				System.out.println("직무 : "+job);
				System.out.println("부서번호 : "+deptno);
				System.out.println("---------");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}//2


	public void selectTest() {
		//4가지 정보
		//1) ID
		String user = "scott";
		//2) PW
		String password = "tiger";
		//3) IP, PORT
		String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
		//4) Driver Class
		String driver = "oracle.jdbc.driver.OracleDriver";

		//2. driver를 메모리에 로딩
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			System.out.println("드라이버 로딩 완료");

			//3. Connection 정보(DB 서버에 로그인)
			con = DriverManager.getConnection(url, user, password);
			System.out.println("Log-in & Access Success");

			//4. Query 작성
			String sql = "select * from dept";//자바에선 sql문 끝에 ; 붙이지 X. 알아서 해 줌.

			//5. Query 전송 준비
			st = con.createStatement();

			//6. Query 전송 및 처리
			rs = st.executeQuery(sql);

			while(rs.next()) {
				int num = rs.getInt("deptno");
				String name = rs.getString("dname");
				String loc = rs.getString("loc");

				System.out.println(num);
				System.out.println(name);
				System.out.println(loc);
				System.out.println("++++++++++++");
			}//while
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}//try
	}//1
}
