package com.juggle.im.models.friend;

import com.google.gson.annotations.SerializedName;

public class FriendItem {
    @SerializedName("user_id")
    private String userId;
    @SerializedName("friend_id")
    private String friendId;
    @SerializedName("display_name")
    private String displayName;

    public String getUserId() {
        return userId;
    }

    public FriendItem setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getFriendId() {
        return friendId;
    }

    public FriendItem setFriendId(String friendId) {
        this.friendId = friendId;
        return this;
    }

    public String getDisplayName() {
        return displayName;
    }

    public FriendItem setDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }
}
