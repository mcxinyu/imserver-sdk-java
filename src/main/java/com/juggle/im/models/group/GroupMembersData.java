package com.juggle.im.models.group;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GroupMembersData {
    @SerializedName("items")
    private List<GroupMemberInfo> items;
    @SerializedName("offset")
    private String offset;

    public List<GroupMemberInfo> getItems() {
        return items;
    }

    public String getOffset() {
        return offset;
    }
}
