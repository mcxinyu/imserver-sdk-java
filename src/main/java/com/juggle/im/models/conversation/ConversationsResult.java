package com.juggle.im.models.conversation;

import com.google.gson.annotations.SerializedName;
import com.juggle.im.models.Result;
import com.juggle.im.util.GsonUtil;

public class ConversationsResult extends Result {
    @SerializedName("data")
    private Conversations data;

    public ConversationsResult(Integer code, String errMsg, Conversations data) {
        super(code, errMsg);
        this.data = data;
    }

    public Conversations getData() {
        return data;
    }

    public void setData(Conversations data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return GsonUtil.toJson(this, ConversationsResult.class);
    }
}
