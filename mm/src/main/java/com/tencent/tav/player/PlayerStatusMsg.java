package com.tencent.tav.player;

import com.tencent.tav.player.IPlayer;

public class PlayerStatusMsg {
    private String errorMsg;
    private IPlayer.PlayerStatus playerStatus;

    public PlayerStatusMsg(IPlayer.PlayerStatus playerStatus2, String str) {
        this.playerStatus = playerStatus2;
        this.errorMsg = str;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }

    public IPlayer.PlayerStatus getPlayerStatus() {
        return this.playerStatus;
    }
}
