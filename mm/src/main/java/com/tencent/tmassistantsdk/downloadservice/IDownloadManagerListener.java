package com.tencent.tmassistantsdk.downloadservice;

public interface IDownloadManagerListener {
    void OnDownloadProgressChanged(String str, long j2, long j3);

    void OnDownloadStateChanged(String str, int i2, int i3, String str2, boolean z, boolean z2);
}
