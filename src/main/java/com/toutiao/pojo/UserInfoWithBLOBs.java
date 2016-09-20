package com.toutiao.pojo;

public class UserInfoWithBLOBs extends UserInfo {
    private String instructions;

    private String careField;

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions == null ? null : instructions.trim();
    }

    public String getCareField() {
        return careField;
    }

    public void setCareField(String careField) {
        this.careField = careField == null ? null : careField.trim();
    }
}