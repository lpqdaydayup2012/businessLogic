package entity;

import java.io.Serializable;
import java.util.Date;

public class BaseRule implements Serializable {

    private int ruleid;

    private String rulename;

    private String remark;

    private String rulecontent;

    private Date createtime;

    private int rulestatus;

    private String creator;

    public int getRuleid() {
        return ruleid;
    }

    public void setRuleid(int ruleid) {
        this.ruleid = ruleid;
    }

    public String getRulename() {
        return rulename;
    }

    public void setRulename(String rulename) {
        this.rulename = rulename;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRulecontent() {
        return rulecontent;
    }

    public void setRulecontent(String rulecontent) {
        this.rulecontent = rulecontent;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public int getRulestatus() {
        return rulestatus;
    }

    public void setRulestatus(int rulestatus) {
        this.rulestatus = rulestatus;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

}
