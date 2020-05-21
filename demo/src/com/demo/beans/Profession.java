package com.demo.beans;

import java.util.Date;

public class Profession {
    private Integer pid;

    private String pname;

    private String editdate;

    private String note;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname == null ? null : pname.trim();
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
		return "Profession [pid=" + pid + ", pname=" + pname + ", editdate=" + editdate + ", note=" + note + "]";
	}
    
    
}