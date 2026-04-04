package com.juggle.im.models.hismsg;

import com.google.gson.annotations.SerializedName;

public class HisMsg {
    @SerializedName("sender_id")
    private String senderId;
    @SerializedName("target_id")
    private String targetId;
    @SerializedName("receiver_id")
    private String receiverId;
    @SerializedName("channel_type")
    private Integer channelType;
    @SerializedName("msg_id")
    private String msgId;
    @SerializedName("msg_time")
    private Long msgTime;
    @SerializedName("msg_type")
    private String msgType;
    @SerializedName("msg_content")
    private String msgContent;
    @SerializedName("is_storage")
    private Boolean isStorage;
    @SerializedName("is_count")
    private Boolean isCount;

    public String getSenderId() {
        return senderId;
    }

    public String getTargetId() {
        return targetId;
    }

    public String getReceiverId() {
        return receiverId;
    }

    public Integer getChannelType() {
        return channelType;
    }

    public String getMsgId() {
        return msgId;
    }

    public Long getMsgTime() {
        return msgTime;
    }

    public String getMsgType() {
        return msgType;
    }

    public String getMsgContent() {
        return msgContent;
    }

    public Boolean getIsStorage() {
        return isStorage;
    }

    public Boolean getIsCount() {
        return isCount;
    }
}
