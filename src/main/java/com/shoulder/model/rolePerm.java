package com.shoulder.model;

public class rolePerm {
    private Integer id;
    private Integer rid;
    private Integer pid;

    @Override
    public String toString() {
        return "rolePerm{" +
                "id=" + id +
                ", rid=" + rid +
                ", pid=" + pid +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}
