package com.demo.beans;

import java.util.Date;

public class Banji {
    private Integer bid;

    private String bname;

    private String editdate;

    private String note;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname == null ? null : bname.trim();
    }

    public String getEditdate() {
        return editdate;
    }

    public void setEditdate(String editdate) {
        this.editdate = editdate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

	@Override
	public String toString() {
		return "Banji [bname=" + bname + ", editdate=" + editdate + ", note=" + note + "]";
	}
    
    
}