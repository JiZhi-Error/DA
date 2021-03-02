package com.tencent.qqmusic.mediaplayer;

/* access modifiers changed from: package-private */
public interface PlayerCallback {
    void playThreadStart(CorePlayer corePlayer);

    void playerEnded(CorePlayer corePlayer);

    void playerException(CorePlayer corePlayer, int i2, int i3, int i4);

    void playerPaused(CorePlayer corePlayer);

    void playerPrepared(CorePlayer corePlayer);

    void playerSeekCompletion(CorePlayer corePlayer, int i2);

    void playerStarted(CorePlayer corePlayer);

    void playerStopped(CorePlayer corePlayer);
}
