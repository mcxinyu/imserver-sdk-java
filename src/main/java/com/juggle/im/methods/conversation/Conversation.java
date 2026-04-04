package com.juggle.im.methods.conversation;

import com.juggle.im.JuggleIm;
import com.juggle.im.models.ResponseResult;
import com.juggle.im.models.conversation.Conversations;
import com.juggle.im.models.conversation.ConversationsResult;
import com.juggle.im.util.GsonUtil;
import com.juggle.im.util.HttpUtil;

import java.net.HttpURLConnection;
import java.net.URLEncoder;

public class Conversation {
    private JuggleIm juggleim;

    public Conversation(JuggleIm juggleim) {
        this.juggleim = juggleim;
    }

    public ResponseResult clearUnread(Conversations conversations) throws Exception {
        String urlPath = this.juggleim.getApiUrl() + "/apigateway/convers/clearunread";
        String body = GsonUtil.toJson(conversations);
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

    public ConversationsResult queryGlobalConversations(Long startTime, Integer count, String targetId, Integer channelType) throws Exception {
        int queryCount = count == null ? 50 : count;
        if (queryCount < 0 || queryCount > 50) {
            queryCount = 50;
        }

        StringBuilder urlPath = new StringBuilder();
        urlPath.append(this.juggleim.getApiUrl())
                .append("/apigateway/globalconvers/query?start=")
                .append(startTime)
                .append("&count=")
                .append(queryCount);
        if (targetId != null && !targetId.isEmpty()) {
            urlPath.append("&target_id=").append(URLEncoder.encode(targetId, "UTF-8"));
        }
        if (channelType != null && channelType > 0) {
            urlPath.append("&channel_type=").append(channelType);
        }

        HttpURLConnection conn = HttpUtil.CreateGetHttpConnection(this.juggleim.getAppkey(), this.juggleim.getSecret(), urlPath.toString());
        String response = "";
        ConversationsResult result = null;
        try {
            response = HttpUtil.returnResult(conn);
            result = (ConversationsResult) GsonUtil.fromJson(response, ConversationsResult.class);
        } catch (Exception e) {
            result = new ConversationsResult(500, "request:" + conn.getURL() + ",response:" + response + ",Exception:" + e.getMessage(), null);
        }
        return result;
    }

}
