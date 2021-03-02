package com.tencent.thumbplayer.api.proxy;

import java.util.ArrayList;

public interface ITPPreloadProxy {

    public interface IPreloadListener {
        void onPrepareDownloadProgressUpdate(int i2, int i3, long j2, long j3);

        void onPrepareError();

        void onPrepareSuccess();
    }

    String getPlayErrorCodeStr(int i2);

    boolean isAvailable();

    void pushEvent(int i2);

    void setPreloadListener(IPreloadListener iPreloadListener);

    int startClipPreload(String str, ArrayList<TPDownloadParamData> arrayList);

    int startPreload(String str, TPDownloadParamData tPDownloadParamData);

    void stopPreload(int i2);
}
