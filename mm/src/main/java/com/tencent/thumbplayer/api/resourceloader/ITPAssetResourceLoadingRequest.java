package com.tencent.thumbplayer.api.resourceloader;

public interface ITPAssetResourceLoadingRequest {
    void finishLoading();

    TPAssetResourceLoadingContentInformationRequest getContentInformation();

    ITPAssetResourceLoadingDataRequest getLoadingDataRequest();

    boolean isCancelled();

    boolean isFinished();
}
