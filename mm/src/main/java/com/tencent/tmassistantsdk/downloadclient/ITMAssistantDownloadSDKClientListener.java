package com.tencent.tmassistantsdk.downloadclient;

public interface ITMAssistantDownloadSDKClientListener {
    void OnDownloadSDKTaskProgressChanged(TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient, String str, long j2, long j3);

    void OnDownloadSDKTaskStateChanged(TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient, String str, int i2, int i3, String str2, boolean z, boolean z2);

    void OnDwonloadSDKServiceInvalid(TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient);
}
