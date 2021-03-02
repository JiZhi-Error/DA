package com.tencent.xweb.downloader;

public interface c {
    void onProgressChange(String str, long j2, long j3);

    void onTaskFail(String str, int i2, boolean z);

    void onTaskSucc(String str, String str2, boolean z);
}
