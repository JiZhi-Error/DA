package com.tencent.qqmusic.mediaplayer.perf;

import android.net.Uri;

public interface PlayerInfoCollector {
    void putBoolean(String str, boolean z);

    void putInt(String str, int i2);

    void putLong(String str, long j2);

    void putString(String str, String str2);

    void putUri(String str, Uri uri);
}
