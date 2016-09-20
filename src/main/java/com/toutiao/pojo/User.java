package com.toutiao.pojo;

public class User {
    private Integer uid;

    private String nickName;

    private String passWord;

    private String avatar;

    private String email;

    private Integer createTime;

    private Integer updateTime;

    private Byte roleId;

    private Integer share;

    private Integer 
attention;

    private Integer fans;

    private Double io;

    private String exclName;

    private Integer sub;

    private Integer collect;

    private Byte status;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord == null ? null : passWord.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    public Byte getRoleId() {
        return roleId;
    }

    public void setRoleId(Byte roleId) {
        this.roleId = roleId;
    }

    public Integer getShare() {
        return share;
    }

    public void setShare(Integer share) {
        this.share = share;
    }

    public Integer getAttention() {
        return attention;
    }

    public void setAttention(Integer
                      attention) {
        this.attention =
                attention;
    }

    public Integer getFans() {
        return fans;
    }

    public void setFans(Integer fans) {
        this.fans = fans;
    }

    public Double getIo() {
        return io;
    }

    public void setIo(Double io) {
        this.io = io;
    }

    public String getExclName() {
        return exclName;
    }

    public void setExclName(String exclName) {
        this.exclName = exclName == null ? null : exclName.trim();
    }

    public Integer getSub() {
        return sub;
    }

    public void setSub(Integer sub) {
        this.sub = sub;
    }

    public Integer getCollect() {
        return collect;
    }

    public void setCollect(Integer collect) {
        this.collect = collect;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}