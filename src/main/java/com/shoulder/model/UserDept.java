package com.shoulder.model;

public class UserDept {
    private Integer id;
    private Integer uid;
    private Long deptId;

    @Override
    public String toString() {
        return "UserDept{" +
                "id=" + id +
                ", uid=" + uid +
                ", deptId=" + deptId +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Long getDeptId() {
        return deptId;
    }

    public void setDeptId(Long deptId) {
        this.deptId = deptId;
    }
}
