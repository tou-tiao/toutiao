package com.toutiao.pojo;

public class Collect {
    private Integer uid;

    private Integer lid;

    private Byte isCollect;

    private Integer collectTime;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public Byte getIsCollect() {
        return isCollect;
    }

    public void setIsCollect(Byte isCollect) {
        this.isCollect = isCollect;
    }

    public Integer getCollectTime() {
        return collectTime;
    }

    public void setCollectTime(Integer collectTime) {
        this.collectTime = collectTime;
    }
}