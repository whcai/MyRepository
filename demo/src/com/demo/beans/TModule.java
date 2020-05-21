package com.demo.beans;

public class TModule {
    private String moduleid;

    private String modulename;

    private String execfile;

    private String ifleaf;

    private String pos;

    private String parentid;

    private String rel;

    private Integer flag;

    public String getModuleid() {
        return moduleid;
    }

    public void setModuleid(String moduleid) {
        this.moduleid = moduleid == null ? null : moduleid.trim();
    }

    public String getModulename() {
        return modulename;
    }

    public void setModulename(String modulename) {
        this.modulename = modulename == null ? null : modulename.trim();
    }

    public String getExecfile() {
        return execfile;
    }

    public void setExecfile(String execfile) {
        this.execfile = execfile == null ? null : execfile.trim();
    }

    public String getIfleaf() {
        return ifleaf;
    }

    public void setIfleaf(String ifleaf) {
        this.ifleaf = ifleaf == null ? null : ifleaf.trim();
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos == null ? null : pos.trim();
    }

    public String getParentid() {
        return parentid;
    }

    public void setParentid(String parentid) {
        this.parentid = parentid == null ? null : parentid.trim();
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel == null ? null : rel.trim();
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

	@Override
	public String toString() {
		return "TModule [moduleid=" + moduleid + ", modulename=" + modulename + ", execfile=" + execfile + ", ifleaf=" + ifleaf + ", pos=" + pos
				+ ", parentid=" + parentid + ", rel=" + rel + ", flag=" + flag + "]";
	}
    
    
}