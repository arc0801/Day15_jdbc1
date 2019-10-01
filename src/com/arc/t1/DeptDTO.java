package com.arc.t1;

public class DeptDTO {

	//DTO : Data Transfer Object
	//VO : Value Object
	
	//DAO : Data Access Object
	//멤버변수
	//모든 멤버변수의 접근지정자는 private
	//getter, setter
	//멤버변수명은 table의 컬럼명과 동일하게
	//Datatype은 table 컬럼의 DataType과 동일하게
	//디폴트 생성자는 존재해야 함 ; 안만들면 자동으로 생성
	private int deptno;
	private String dname;
	private String loc;
	
	public int getDeptno() {
		return deptno;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
}
