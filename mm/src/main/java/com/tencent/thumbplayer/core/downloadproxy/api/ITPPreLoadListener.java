package com.tencent.thumbplayer.core.downloadproxy.api;

public interface ITPPreLoadListener {
    void onPrepareDownloadProgressUpdate(int i2, int i3, long j2, long j3, String str);

    void onPrepareError(int i2, int i3, String str);

    void onPrepareOK();
}
