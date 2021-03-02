package com.tencent.thumbplayer.api.resourceloader;

public interface ITPAssetResourceLoadingDataRequest {
    long getCurrentOffset();

    int getRequestNum();

    long getRequestedLength();

    long getRequestedOffset();

    void notifyDataReady(long j2, long j3);

    void respondWithData(byte[] bArr);
}
