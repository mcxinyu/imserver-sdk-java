package com.juggle.im.models.group;

import com.google.gson.annotations.SerializedName;
import com.juggle.im.models.Result;
import com.juggle.im.util.GsonUtil;

public class GroupMembersResult extends Result {
    @SerializedName("data")
    private GroupMembersData data;

    public GroupMembersResult(Integer code, String errMsg, GroupMembersData data) {
        super(code, errMsg);
        this.data = data;
    }

    public GroupMembersData getData() {
        return data;
    }

    @Override
    public String toString() {
        return GsonUtil.toJson(this, GroupMembersResult.class);
    }
}
