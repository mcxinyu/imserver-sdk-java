package com.juggle.im.models.hismsg;

import com.google.gson.annotations.SerializedName;
import com.juggle.im.models.Result;
import com.juggle.im.util.GsonUtil;

public class HisMsgsResult extends Result {
    @SerializedName("data")
    private HisMsgsData data;

    public HisMsgsResult(Integer code, String errMsg, HisMsgsData data) {
        super(code, errMsg);
        this.data = data;
    }

    public HisMsgsData getData() {
        return data;
    }

    @Override
    public String toString() {
        return GsonUtil.toJson(this, HisMsgsResult.class);
    }
}
