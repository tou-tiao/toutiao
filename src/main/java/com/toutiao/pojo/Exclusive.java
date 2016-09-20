package com.toutiao.pojo;

public class Exclusive {
    private Integer eid;

    private String exclName;

    private String createrName;

    private Integer share;

    private Integer subscriber;

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getExclName() {
        return exclName;
    }

    public void setExclName(String exclName) {
        this.exclName = exclName == null ? null : exclName.trim();
    }

    public String getCreaterName() {
        return createrName;
    }

    public void setCreaterName(String createrName) {
        this.createrName = createrName == null ? null : createrName.trim();
    }

    public Integer getShare() {
        return share;
    }

    public void setShare(Integer share) {
        this.share = share;
    }

    public Integer getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(Integer subscriber) {
        this.subscriber = subscriber;
    }
}