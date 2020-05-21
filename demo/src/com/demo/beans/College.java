package com.demo.beans;

import java.util.Date;

public class College {
    private Integer cid;

    private String cname;

    private String editdate;

    private String note;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname == null ? null : cname.trim();
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
		return "College [cid=" + cid + ", cname=" + cname + ", editdate=" + editdate + ", note=" + note + "]";
	}
    
    
}