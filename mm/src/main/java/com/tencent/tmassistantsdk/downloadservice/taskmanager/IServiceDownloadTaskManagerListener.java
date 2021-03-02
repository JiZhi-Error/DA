package com.tencent.tmassistantsdk.downloadservice.taskmanager;

public interface IServiceDownloadTaskManagerListener {
    void OnDownloadProgressChanged(String str, String str2, long j2, long j3);

    void OnDownloadStateChanged(String str, String str2, int i2, int i3, String str3, boolean z, boolean z2);
}
