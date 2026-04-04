package com.juggle.im.methods.chatroom;

import com.juggle.im.JuggleIm;
import com.juggle.im.models.ResponseResult;
import com.juggle.im.models.chatroom.ChatroomInfo;
import com.juggle.im.models.chatroom.ChatroomInfoResult;
import com.juggle.im.models.chatroom.ChrmMemberIds;
import com.juggle.im.models.chatroom.ChrmMembersExistResult;
import com.juggle.im.util.GsonUtil;
import com.juggle.im.util.HttpUtil;

import java.net.HttpURLConnection;
import java.net.URLEncoder;

/**
 * 类 {@code Chatroom } 聊天室相关操作方法
 * <p>
 * 主要包括 添加，删除，获取聊天室信息等相关操作
 * </p>
 *
 * @date 2024-11-28
 */
public class Chatroom {
    private JuggleIm juggleim;

    public ChatroomMemberBan chrmMemberBan;
    public ChatroomMemberMute chrmMemberMute;
    public ChrmGlobalMemberMute chrmGlobalMute;

    public Chatroom(JuggleIm juggleim) {
        this.juggleim = juggleim;

        this.chrmMemberBan = new ChatroomMemberBan(this.juggleim);
        this.chrmMemberMute = new ChatroomMemberMute(this.juggleim);
        this.chrmGlobalMute = new ChrmGlobalMemberMute(this.juggleim);
    }

    public ResponseResult create(ChatroomInfo chatroom) throws Exception {
        if (chatroom == null) {
            return new ResponseResult(1002, "Paramer 'chatrooms' is required");
        }
        String urlPath = this.juggleim.getApiUrl() + "/apigateway/chatrooms/create";
        String body = GsonUtil.toJson(chatroom);
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

    public ResponseResult destroy(ChatroomInfo chatroom) throws Exception {
        if (chatroom == null) {
            return new ResponseResult(1002, "Paramer 'chatrooms' is required");
        }
        String urlPath = this.juggleim.getApiUrl() + "/apigateway/chatrooms/destroy";
        String body = GsonUtil.toJson(chatroom);
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

    public ChatroomInfoResult get(String chatId, int count, int order) throws Exception {
        return get(chatId, true, false, count, order);
    }

    public ChatroomInfoResult get(String chatId, boolean withMembers, boolean withAtts, int count, int order) throws Exception {
        String urlPath = this.juggleim.getApiUrl() + "/apigateway/chatrooms/info?chat_id=" + URLEncoder.encode(chatId, "UTF-8");
        urlPath = urlPath + "&with_members=" + withMembers;
        urlPath = urlPath + "&with_atts=" + withAtts;
        urlPath = urlPath + "&count=" + count;
        urlPath = urlPath + "&order=" + order;
        HttpURLConnection conn = HttpUtil.CreateGetHttpConnection(this.juggleim.getAppkey(), this.juggleim.getSecret(), urlPath);
        String response = "";
        ChatroomInfoResult result = null;
        try {
            response = HttpUtil.returnResult(conn);
            result = (ChatroomInfoResult) GsonUtil.fromJson(response, ChatroomInfoResult.class);
        } catch (Exception e) {
            result = new ChatroomInfoResult(500, "request:" + conn.getURL() + ",response:" + response + ",Exception:" + e.getMessage(), null);
        }
        return result;
    }

    public ResponseResult setMute(String chatId, boolean isMute) throws Exception {
        String urlPath = this.juggleim.getApiUrl() + "/apigateway/chatrooms/chrmmute/set";
        ChatroomInfo chatroomInfo = new ChatroomInfo(chatId, null).setIsMute(isMute ? 1 : 0);
        String body = GsonUtil.toJson(chatroomInfo);
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

    public ChrmMembersExistResult checkMembersExist(ChrmMemberIds members) throws Exception {
        String urlPath = this.juggleim.getApiUrl() + "/apigateway/chatrooms/members/exist";
        String body = GsonUtil.toJson(members);
        HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(this.juggleim.getAppkey(), this.juggleim.getSecret(), urlPath);
        HttpUtil.setBodyParameter(body, conn);
        String response = "";
        ChrmMembersExistResult result = null;
        try {
            response = HttpUtil.returnResult(conn);
            result = (ChrmMembersExistResult) GsonUtil.fromJson(response, ChrmMembersExistResult.class);
        } catch (Exception e) {
            result = new ChrmMembersExistResult(500, "request:" + conn.getURL() + ",response:" + response + ",Exception:" + e.getMessage(), null);
        }
        return result;
    }

}
