package com.tencent.smtt.export.external.interfaces;

import java.io.File;
import java.io.InputStream;

public interface IX5CoreCacheManager {
    boolean cacheDisabled();

    void clearLocalStorage();

    void clearNetworkCache();

    InputStream getCacheFile(String str, boolean z);

    File getCacheFileBaseDir();

    String getLocalPath(String str);
}
