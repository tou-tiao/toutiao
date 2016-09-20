package com.toutiao.pojo;

public class Link {
    private Integer lid;

    private String exclName;

    private String title;

    private String url;

    private Integer createTime;

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public String getExclName() {
        return exclName;
    }

    public void setExclName(String exclName) {
        this.exclName = exclName == null ? null : exclName.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }
}