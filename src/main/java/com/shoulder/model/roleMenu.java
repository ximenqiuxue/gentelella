package com.shoulder.model;

public class roleMenu {
    private Integer id;
    private Integer rid;
    private Long mid;

    @Override
    public String toString() {
        return "roleMenu{" +
                "id=" + id +
                ", rid=" + rid +
                ", mid=" + mid +
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

    public Long getMid() {
        return mid;
    }

    public void setMid(Long mid) {
        this.mid = mid;
    }
}
