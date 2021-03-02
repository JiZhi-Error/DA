package com.tencent.qqvideo.proxy.api;

import android.content.Context;

public interface IPlayManager {
    void appToBack();

    void appToFront();

    String buildPlayURLMp4(int i2);

    int cleanStorage();

    void deinit();

    int getCurrentOffset(int i2);

    int getLocalServerPort();

    String getProxyVersion();

    int getTotalOffset(int i2);

    int init(Context context, String str);

    int preLoad(int i2, int i3);

    void setCookie(String str);

    int setMaxStorageSize(long j2);

    void setNetWorkState(int i2);

    void setPlayerState(int i2);

    void setRemainTime(int i2, int i3);

    void setUtilsObject(IUtils iUtils);

    int startPlay(String str, int i2, String str2, long j2, int i3);

    void stopPlay(int i2);
}
