package com.tencent.map.sdk.comps.offlinemap;

public interface OfflineItemController {
    boolean checkInvalidate();

    boolean close();

    boolean open();

    boolean removeCache();

    void startDownload();

    void stopDownload();
}
