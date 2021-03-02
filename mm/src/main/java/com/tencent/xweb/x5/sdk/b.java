package com.tencent.xweb.x5.sdk;

import android.content.Context;
import com.tencent.xweb.x5.sdk.f;

public interface b {
    boolean a(Context context, boolean z, boolean z2, f.a aVar);

    boolean isDownloadForeground();

    boolean isDownloading();

    boolean lE(Context context);

    void startDownload(Context context, boolean z);

    void stopDownload();
}
