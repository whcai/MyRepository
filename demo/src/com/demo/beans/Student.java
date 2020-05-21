package com.demo.beans;

public class Student {
	private Integer id;

	private String sno;

	private String name;

	private String cardid;

	private String sex;

	private String cid;

	private String pid;

	private String bid;

	private String gid;

	private String note;

	private String hid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSno() {
		return sno;
	}

	public void setSno(String sno) {
		this.sno = sno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public String getCardid() {
		return cardid;
	}

	public void setCardid(String cardid) {
		this.cardid = cardid == null ? null : cardid.trim();
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
	}

	public String getGid() {
		return gid;
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note == null ? null : note.trim();
	}

	@Override
	public String toString() {
		return "Student [sno=" + sno + ", name=" + name + ", cardid=" + cardid + ", sex=" + sex + ", cid=" + cid + ", pid=" + pid + ", bid=" + bid
				+ ", gid=" + gid + ", note=" + note + ", hid=" + hid + "]";
	}

}