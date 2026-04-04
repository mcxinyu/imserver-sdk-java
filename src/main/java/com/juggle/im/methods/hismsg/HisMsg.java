package com.juggle.im.methods.hismsg;

import com.juggle.im.JuggleIm;
import com.juggle.im.models.ResponseResult;
import com.juggle.im.models.hismsg.DelMsgsReq;
import com.juggle.im.models.hismsg.HisMsgsResult;
import com.juggle.im.util.GsonUtil;
import com.juggle.im.util.HttpUtil;

import java.net.HttpURLConnection;
import java.net.URLEncoder;

public class HisMsg {
    private JuggleIm juggleim;

    public HisMsg(JuggleIm juggleim) {
        this.juggleim = juggleim;
    }

    public HisMsgsResult queryHistory(String fromId, String targetId, Integer channelType, Long startTime, Integer count, Boolean positiveOrder) throws Exception {
        int queryCount = count == null ? 50 : count;
        if (queryCount < 0 || queryCount > 50) {
            queryCount = 50;
        }
        int order = (positiveOrder != null && positiveOrder) ? 1 : 0;
        long queryStart = startTime == null ? 0L : startTime;

        StringBuilder urlPath = new StringBuilder();
        urlPath.append(this.juggleim.getApiUrl())
                .append("/apigateway/hismsgs/query?channel_type=")
                .append(channelType)
                .append("&from_id=")
                .append(URLEncoder.encode(fromId, "UTF-8"))
                .append("&target_id=")
                .append(URLEncoder.encode(targetId, "UTF-8"))
                .append("&count=")
                .append(queryCount)
                .append("&order=")
                .append(order)
                .append("&start=")
                .append(queryStart);

        HttpURLConnection conn = HttpUtil.CreateGetHttpConnection(this.juggleim.getAppkey(), this.juggleim.getSecret(), urlPath.toString());
        String response = "";
        HisMsgsResult result = null;
        try {
            response = HttpUtil.returnResult(conn);
            result = (HisMsgsResult) GsonUtil.fromJson(response, HisMsgsResult.class);
        } catch (Exception e) {
            result = new HisMsgsResult(500, "request:" + conn.getURL() + ",response:" + response + ",Exception:" + e.getMessage(), null);
        }
        return result;
    }

    public ResponseResult delete(DelMsgsReq delMsgsReq) throws Exception {
        String urlPath = this.juggleim.getApiUrl() + "/apigateway/hismsgs/del";
        String body = GsonUtil.toJson(delMsgsReq);
        HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(this.juggleim.getAppkey(), this.juggleim.getSecret(), urlPath);
        HttpUtil.setBodyParameter(body, conn);
        String response = "";
        ResponseResult result = null;
        try {
            response = HttpUtil.returnResult(conn);
            result = (ResponseResult) GsonUtil.fromJson(response, ResponseResult.class);
        } catch (Exception e) {
            result = new ResponseResult(500, "request:" + conn.getURL() + ",response:" + response + ",Exception:" + e.getMessage());
        }
        return result;
    }

}
