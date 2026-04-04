package com.juggle.im.methods.friend;

import com.juggle.im.JuggleIm;
import com.juggle.im.models.ResponseResult;
import com.juggle.im.models.friend.FriendIds;
import com.juggle.im.util.GsonUtil;
import com.juggle.im.util.HttpUtil;

import java.net.HttpURLConnection;

public class Friend {
    private JuggleIm juggleim;

    public Friend(JuggleIm juggleim) {
        this.juggleim = juggleim;
    }

    public ResponseResult add(FriendIds friendIds) throws Exception {
        String urlPath = this.juggleim.getApiUrl() + "/apigateway/friends/add";
        String body = GsonUtil.toJson(friendIds);
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

    public ResponseResult remove(FriendIds friendIds) throws Exception {
        String urlPath = this.juggleim.getApiUrl() + "/apigateway/friends/del";
        String body = GsonUtil.toJson(friendIds);
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
