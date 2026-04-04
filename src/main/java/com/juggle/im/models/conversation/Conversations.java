package com.juggle.im.models.conversation;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Conversations {
    @SerializedName("user_id")
    private String userId;
    @SerializedName("items")
    private List<ConversationItem> items;

    public String getUserId() {
        return userId;
    }

    public Conversations setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public List<ConversationItem> getItems() {
        return items;
    }

    public Conversations setItems(List<ConversationItem> items) {
        this.items = items;
        return this;
    }
}
