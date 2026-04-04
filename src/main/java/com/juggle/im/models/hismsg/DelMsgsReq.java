package com.juggle.im.models.hismsg;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DelMsgsReq {
    @SerializedName("from_id")
    private String fromId;
    @SerializedName("target_id")
    private String targetId;
    @SerializedName("channel_type")
    private Integer channelType;
    @SerializedName("del_scope")
    private Integer delScope;
    @SerializedName("msgs")
    private List<DelMsg> msgs;

    public String getFromId() {
        return fromId;
    }

    public DelMsgsReq setFromId(String fromId) {
        this.fromId = fromId;
        return this;
    }

    public String getTargetId() {
        return targetId;
    }

    public DelMsgsReq setTargetId(String targetId) {
        this.targetId = targetId;
        return this;
    }

    public Integer getChannelType() {
        return channelType;
    }

    public DelMsgsReq setChannelType(Integer channelType) {
        this.channelType = channelType;
        return this;
    }

    public Integer getDelScope() {
        return delScope;
    }

    public DelMsgsReq setDelScope(Integer delScope) {
        this.delScope = delScope;
        return this;
    }

    public List<DelMsg> getMsgs() {
        return msgs;
    }

    public DelMsgsReq setMsgs(List<DelMsg> msgs) {
        this.msgs = msgs;
        return this;
    }
}
