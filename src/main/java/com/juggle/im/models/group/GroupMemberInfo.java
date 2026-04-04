package com.juggle.im.models.group;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class GroupMemberInfo {
    @SerializedName("member_id")
    private String memberId;
    @SerializedName("is_mute")
    private Integer isMute;
    @SerializedName("is_allow")
    private Integer isAllow;
    @SerializedName("grp_display_name")
    private String grpDisplayName;
    @SerializedName("ext_fields")
    private Map<String, String> extFields;

    public String getMemberId() {
        return memberId;
    }

    public Integer getIsMute() {
        return isMute;
    }

    public Integer getIsAllow() {
        return isAllow;
    }

    public String getGrpDisplayName() {
        return grpDisplayName;
    }

    public Map<String, String> getExtFields() {
        return extFields;
    }
}
