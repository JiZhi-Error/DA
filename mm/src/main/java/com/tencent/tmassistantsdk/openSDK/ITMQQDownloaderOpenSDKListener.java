package com.tencent.tmassistantsdk.openSDK;

public interface ITMQQDownloaderOpenSDKListener {
    void OnDownloadTaskProgressChanged(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, long j2, long j3);

    void OnDownloadTaskStateChanged(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam, int i2, int i3, String str);

    void OnQQDownloaderInvalid();

    void OnServiceFree();
}
