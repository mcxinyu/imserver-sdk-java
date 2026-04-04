package com.juggle.im.models.bot;

import com.google.gson.annotations.SerializedName;

import java.util.Map;

public class BotInfo {
    @SerializedName("bot_id")
    private String botId;
    @SerializedName("nickname")
    private String nickname;
    @SerializedName("portrait")
    private String portrait;
    @SerializedName("bot_type")
    private Integer botType;
    @SerializedName("bot_conf")
    private String botConf;
    @SerializedName("webhook")
    private String webhook;
    @SerializedName("ext_fields")
    private Map<String, String> extFields;

    public String getBotId() {
        return botId;
    }

    public BotInfo setBotId(String botId) {
        this.botId = botId;
        return this;
    }

    public String getNickname() {
        return nickname;
    }

    public BotInfo setNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public String getPortrait() {
        return portrait;
    }

    public BotInfo setPortrait(String portrait) {
        this.portrait = portrait;
        return this;
    }

    public Integer getBotType() {
        return botType;
    }

    public BotInfo setBotType(Integer botType) {
        this.botType = botType;
        return this;
    }

    public String getBotConf() {
        return botConf;
    }

    public BotInfo setBotConf(String botConf) {
        this.botConf = botConf;
        return this;
    }

    public String getWebhook() {
        return webhook;
    }

    public BotInfo setWebhook(String webhook) {
        this.webhook = webhook;
        return this;
    }

    public Map<String, String> getExtFields() {
        return extFields;
    }

    public BotInfo setExtFields(Map<String, String> extFields) {
        this.extFields = extFields;
        return this;
    }
}
