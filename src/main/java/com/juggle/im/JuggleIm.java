package com.juggle.im;

import com.juggle.im.methods.bot.Bot;
import com.juggle.im.methods.chatroom.Chatroom;
import com.juggle.im.methods.conversation.Conversation;
import com.juggle.im.methods.friend.Friend;
import com.juggle.im.methods.group.Group;
import com.juggle.im.methods.hismsg.HisMsg;
import com.juggle.im.message.MsgSender;
import com.juggle.im.methods.sensitive.SensitiveWord;
import com.juggle.im.methods.user.User;

public class JuggleIm {
    private String appkey;
    private String secret;
    private String apiUrl;

    public User user;
    public MsgSender msgSender;
    public Group group;
    public Chatroom chatroom;
    public SensitiveWord sensitiveWord;
    public Friend friend;
    public Bot bot;
    public Conversation conversation;
    public HisMsg hisMsg;

    public JuggleIm(String appkey, String secret, String apiUrl){
        this.appkey = appkey;
        this.secret = secret;
        this.apiUrl = apiUrl;
        this.user = new User(this);
        this.msgSender = new MsgSender(this);
        this.group = new Group(this);
        this.chatroom = new Chatroom(this);
        this.sensitiveWord = new SensitiveWord(this);
        this.friend = new Friend(this);
        this.bot = new Bot(this);
        this.conversation = new Conversation(this);
        this.hisMsg = new HisMsg(this);
    }

    public String getAppkey(){
        return this.appkey;
    }

    public String getSecret(){
        return this.secret;
    }

    public String getApiUrl(){
        return this.apiUrl;
    }
}
