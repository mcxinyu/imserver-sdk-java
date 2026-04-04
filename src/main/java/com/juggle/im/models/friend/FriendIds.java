package com.juggle.im.models.friend;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FriendIds {
    @SerializedName("user_id")
    private String userId;
    @SerializedName("friend_ids")
    private String[] friendIds;
    @SerializedName("friends")
    private List<FriendItem> friends;

    public String getUserId() {
        return userId;
    }

    public FriendIds setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String[] getFriendIds() {
        return friendIds;
    }

    public FriendIds setFriendIds(String[] friendIds) {
        this.friendIds = friendIds;
        return this;
    }

    public List<FriendItem> getFriends() {
        return friends;
    }

    public FriendIds setFriends(List<FriendItem> friends) {
        this.friends = friends;
        return this;
    }
}
