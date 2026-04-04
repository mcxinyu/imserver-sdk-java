package com.juggle.im.models.conversation;

import com.google.gson.annotations.SerializedName;

public class ConversationItem {
    @SerializedName("user_id")
    private String userId;
    @SerializedName("target_id")
    private String targetId;
    @SerializedName("channel_type")
    private Integer channelType;
    @SerializedName("time")
    private Long time;

    public String getUserId() {
        return userId;
    }

    public ConversationItem setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getTargetId() {
        return targetId;
    }

    public ConversationItem setTargetId(String targetId) {
        this.targetId = targetId;
        return this;
    }

    public Integer getChannelType() {
        return channelType;
    }

    public ConversationItem setChannelType(Integer channelType) {
        this.channelType = channelType;
        return this;
    }

    public Long getTime() {
        return time;
    }

    public ConversationItem setTime(Long time) {
        this.time = time;
        return this;
    }
}
