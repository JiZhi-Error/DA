package com.tencent.smtt.export.external.interfaces;

import android.graphics.Bitmap;

public interface IX5CoreWebIconDB {
    void close();

    Bitmap getIconForPageUrl(String str);

    void open(String str);

    void releaseIconForPageUrl(String str);

    void removeAllIcons();

    void requestIconForPageUrl(String str, IconListener iconListener);

    void retainIconForPageUrl(String str);
}
