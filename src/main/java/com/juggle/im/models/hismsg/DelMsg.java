package com.juggle.im.models.hismsg;

import com.google.gson.annotations.SerializedName;

public class DelMsg {
    @SerializedName("msg_id")
    private String msgId;
    @SerializedName("msg_time")
    private Long msgTime;
    @SerializedName("msg_read_index")
    private Long msgReadIndex;

    public String getMsgId() {
        return msgId;
    }

    public DelMsg setMsgId(String msgId) {
        this.msgId = msgId;
        return this;
    }

    public Long getMsgTime() {
        return msgTime;
    }

    public DelMsg setMsgTime(Long msgTime) {
        this.msgTime = msgTime;
        return this;
    }

    public Long getMsgReadIndex() {
        return msgReadIndex;
    }

    public DelMsg setMsgReadIndex(Long msgReadIndex) {
        this.msgReadIndex = msgReadIndex;
        return this;
    }
}
