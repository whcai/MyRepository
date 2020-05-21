package com.demo.beans;

public class Grade {
	private Integer gid; // 年级id

	private String gname; // 年级名称

	private String xz; // 学制

	private String note; // 备注

	public Integer getGid() {
		return gid;
	}

	public void setGid(Integer gid) {
		this.gid = gid;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname == null ? null : gname.trim();
	}

	public String getXz() {
		return xz;
	}

	public void setXz(String xz) {
		this.xz = xz;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note == null ? null : note.trim();
	}

	@Override
	public String toString() {
		return "Grade [gid=" + gid + ", gname=" + gname + ", xz=" + xz + ", note=" + note + "]";
	}

}