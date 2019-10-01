package com.arc.t1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.arc.util.DBConnector;

public class TestDAO3 {

	private DBConnector db;

	public TestDAO3(){
		db = new DBConnector();
	}

	public void deptSelectOne(int deptno) {
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			con = db.getConnect();

			String sql = "select * from dept "
					+ "where deptno = "+ deptno;

			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			System.out.println("1");
			System.out.println(st);
			System.out.println(rs);
			
			
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


	public void update1(int deptno, String loc) {
		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";

		Connection con = null;
		PreparedStatement st = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);

			String sql = "update dept set loc = ? "
					+ "where deptno = ?";

			st = con.prepareStatement(sql);

			st.setString(1, loc);
			st.setInt(2, deptno);

			int result = st.executeUpdate();
			if(result>0) {
				System.out.println("성공");
			}else {
				System.out.println("실패");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	public void insert1(int deptno, String dname, String loc) {
		String user = "scott";
		String password = "tiger";
		String url = "jdbc:oracle:thin:@192.168.56.101:1521:xe";
		String driver = "oracle.jdbc.driver.OracleDriver";

		Connection con = null;
		PreparedStatement st = null; //쿼리문을 미리 전송
		try {
			Class.forName(driver);

			con = DriverManager.getConnection(url, user, password);

			String sql = "insert into dept (deptno, dname, loc) "
					+ "values(?, ?, ?)";

			st = con.prepareStatement(sql); //sql 미리 전송

			//? 세팅
			st.setInt(1, deptno);
			st.setString(2, dname);
			st.setString(3, loc);

			//최종 전송 후 결과물 처리
			int result = st.executeUpdate();
			if(result>0) {
				System.out.println("성공");
			}else {
				System.out.println("실패");
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
