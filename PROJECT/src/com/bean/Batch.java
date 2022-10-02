package com.bean;

public class Batch {

	private int bid;
	private String bname;
	private String cName;
	private int TotalSeats;
	
	public Batch(int bid, String bname, String cName, int totalSeats) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.cName = cName;
		TotalSeats = totalSeats;
	}
	public Batch() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getBid() {
		return bid;
	}
	public void setBid(int bid) {
		this.bid = bid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public int getTotalSeats() {
		return TotalSeats;
	}
	public void setTotalSeats(int totalSeats) {
		TotalSeats = totalSeats;
	}
	@Override
	public String toString() {
		return "Batch [bid=" + bid + ", bname=" + bname + ", cName=" + cName + ", TotalSeats=" + TotalSeats + "]";
	}
	

	
	
}
