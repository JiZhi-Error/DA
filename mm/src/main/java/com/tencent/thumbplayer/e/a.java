package com.tencent.thumbplayer.e;

import com.tencent.thumbplayer.a.a.e;
import com.tencent.thumbplayer.api.TPOptionalParam;
import com.tencent.thumbplayer.api.TPVideoInfo;
import com.tencent.thumbplayer.api.composition.ITPMediaAsset;
import com.tencent.thumbplayer.api.proxy.ITPPlayerProxy;
import com.tencent.thumbplayer.api.proxy.ITPPlayerProxyListener;
import com.tencent.thumbplayer.api.proxy.TPDownloadParamData;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPPlayListener;

public interface a extends ITPPlayerProxy {
    void DV(boolean z);

    void OE(long j2);

    e a(long j2, String str, TPVideoInfo tPVideoInfo);

    ITPMediaAsset a(ITPMediaAsset iTPMediaAsset, long j2, TPVideoInfo tPVideoInfo);

    String a(int i2, String str, TPDownloadParamData tPDownloadParamData);

    void a(ITPPlayListener iTPPlayListener);

    void aro(int i2);

    ITPMediaAsset b(ITPMediaAsset iTPMediaAsset);

    e bqC(String str);

    void hnt();

    boolean hnu();

    String hnv();

    ITPPlayerProxyListener hnw();

    boolean isEnable();

    void nM(String str, String str2);

    void pauseDownload();

    void release();

    void resumeDownload();

    void setPlayerOptionalParam(TPOptionalParam tPOptionalParam);

    void setVideoInfo(TPVideoInfo tPVideoInfo);

    void stopDownload();
}
