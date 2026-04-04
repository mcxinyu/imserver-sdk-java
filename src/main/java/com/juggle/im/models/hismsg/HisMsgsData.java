package com.juggle.im.models.hismsg;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HisMsgsData {
    @SerializedName("msgs")
    private List<HisMsg> msgs;
    @SerializedName("is_finished")
    private Boolean isFinished;

    public List<HisMsg> getMsgs() {
        return msgs;
    }

    public Boolean getFinished() {
        return isFinished;
    }
}
