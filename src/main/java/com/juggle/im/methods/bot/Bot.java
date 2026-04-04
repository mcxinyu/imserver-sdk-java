package com.juggle.im.methods.bot;

import com.juggle.im.JuggleIm;
import com.juggle.im.models.ResponseResult;
import com.juggle.im.models.bot.BotInfo;
import com.juggle.im.util.GsonUtil;
import com.juggle.im.util.HttpUtil;

import java.net.HttpURLConnection;

public class Bot {
    private JuggleIm juggleim;

    public Bot(JuggleIm juggleim) {
        this.juggleim = juggleim;
    }

    public ResponseResult add(BotInfo botInfo) throws Exception {
        String urlPath = this.juggleim.getApiUrl() + "/apigateway/bots/add";
        String body = GsonUtil.toJson(botInfo);
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
