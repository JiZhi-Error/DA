package com.tencent.thumbplayer.core.downloadproxy.api;

import android.content.Context;

public interface ITPDownloadProxy {
    int deinit();

    String getClipPlayUrl(int i2, int i3, int i4);

    String getPlayErrorCodeStr(int i2);

    String getPlayUrl(int i2, int i3);

    int init(Context context, TPDLProxyInitParam tPDLProxyInitParam);

    int pauseDownload(int i2);

    void pushEvent(int i2);

    int removeStorageCache(String str);

    int resumeDownload(int i2);

    boolean setClipInfo(int i2, int i3, String str, TPDownloadParam tPDownloadParam);

    void setLogListener(ITPDLProxyLogListener iTPDLProxyLogListener);

    void setMaxStorageSizeMB(long j2);

    void setPlayState(int i2, int i3);

    void setUserData(String str, Object obj);

    int startClipOfflineDownload(String str, int i2, ITPOfflineDownloadListener iTPOfflineDownloadListener);

    int startClipPlay(String str, int i2, ITPPlayListener iTPPlayListener);

    int startOfflineDownload(String str, TPDownloadParam tPDownloadParam, ITPOfflineDownloadListener iTPOfflineDownloadListener);

    int startPlay(String str, TPDownloadParam tPDownloadParam, ITPPlayListener iTPPlayListener);

    int startPreload(String str, TPDownloadParam tPDownloadParam, ITPPreLoadListener iTPPreLoadListener);

    void startTask(int i2);

    void stopOfflineDownload(int i2);

    void stopPlay(int i2);

    void stopPreload(int i2);

    void updateStoragePath(String str);
}
