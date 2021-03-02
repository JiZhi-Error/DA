package com.tencent.thumbplayer.e.a;

import com.tencent.thumbplayer.api.resourceloader.ITPAssetResourceLoaderListener;

public interface a {
    String Mf(int i2);

    void a(ITPAssetResourceLoaderListener iTPAssetResourceLoaderListener);

    String getContentType(int i2, String str);

    long getDataTotalSize(int i2, String str);

    void hnB();

    int k(int i2, long j2, long j3);

    int onStartReadData(int i2, String str, long j2, long j3);

    int onStopReadData(int i2, String str, int i3);

    void release();

    void reset();
}
