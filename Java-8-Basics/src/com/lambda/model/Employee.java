package com.lambda.model;

public class Employee {

	private Integer eNo;
	private String eName;
	public Employee(Integer eNo,String eName) {
		this.eNo = eNo;
		this.eName = eName;
	}
	public Integer geteNo() {
		return eNo;
	}
	public void seteNo(Integer eNo) {
		this.eNo = eNo;
	}
	public String geteName() {
		return eName;
	}
	public void seteName(String eName) {
		this.eName = eName;
	}
	@Override
	public String toString() {
		return "Employee [eNo=" + eNo + ", eName=" + eName + "]";
	}
	
}
