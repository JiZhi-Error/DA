package com.tencent.tav.player;

public class UpdateCompositionMessage {
    public final PlayerItem playerItem;
    public final OnCompositionUpdateListener updateListener;

    public UpdateCompositionMessage(PlayerItem playerItem2, OnCompositionUpdateListener onCompositionUpdateListener) {
        this.playerItem = playerItem2;
        this.updateListener = onCompositionUpdateListener;
    }
}
