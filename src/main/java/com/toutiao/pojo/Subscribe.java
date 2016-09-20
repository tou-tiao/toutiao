package com.toutiao.pojo;

public class Subscribe {
    private Integer sid;

    private String exclName;

    private String subscriber;

    private Integer isSub;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getExclName() {
        return exclName;
    }

    public void setExclName(String exclName) {
        this.exclName = exclName == null ? null : exclName.trim();
    }

    public String getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(String subscriber) {
        this.subscriber = subscriber == null ? null : subscriber.trim();
    }

    public Integer getIsSub() {
        return isSub;
    }

    public void setIsSub(Integer isSub) {
        this.isSub = isSub;
    }
}