package com.tencent.thumbplayer.core.downloadproxy.api;

import java.util.Map;

public interface ITPOfflineDownloadListener {
    void onDownloadCdnUrlExpired(Map<String, String> map);

    void onDownloadCdnUrlInfoUpdate(String str, String str2, String str3, String str4);

    void onDownloadCdnUrlUpdate(String str);

    void onDownloadError(int i2, int i3, String str);

    void onDownloadFinish();

    void onDownloadProgressUpdate(int i2, int i3, long j2, long j3, String str);

    void onDownloadProtocolUpdate(String str, String str2);

    void onDownloadStatusUpdate(int i2);
}
