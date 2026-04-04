package com.juggle.im.models.user;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class UserInfo {
    @SerializedName("user_id")
    private String userId;
    @SerializedName("nickname")
    private String nickname;
    @SerializedName("user_portrait")
    private String userPortrait;
    @SerializedName("updated_time")
    private long updatedTime;
    @SerializedName("ext_fields")
    private Map<String, String> extFields;
    @SerializedName("settings")
    private Map<String, String> settings;

    public UserInfo(){}
    public UserInfo(String userId, String nickname, String userPortrait){
        this.userId = userId;
        this.nickname = nickname;
        this.userPortrait = userPortrait;
    }

    public UserInfo setUserId(String userId){
        this.userId = userId;
        return this;
    }

    public String getUserId(){
        return this.userId;
    }

    public UserInfo setNickname(String nickname){
        this.nickname = nickname;
        return this;
    }

    public String getNickname(){
        return this.nickname;
    }

    public UserInfo setUserPortrait(String userPortrait){
        this.userPortrait = userPortrait;
        return this;
    }

    public String getUserPortrait(){
        return this.userPortrait;
    }

    public long getUpdatedTime(){
        return this.updatedTime;
    }

    public Map<String, String> getExtFields() {
        return extFields;
    }

    public UserInfo setExtFields(Map<String, String> extFields) {
        this.extFields = extFields;
        return this;
    }

    public Map<String, String> getSettings() {
        return settings;
    }

    public UserInfo setSettings(Map<String, String> settings) {
        this.settings = settings;
        return this;
    }
}
