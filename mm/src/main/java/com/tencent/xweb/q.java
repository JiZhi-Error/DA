package com.tencent.xweb;

import android.graphics.Bitmap;
import java.io.File;

public interface q {
    File getCacheFileDir();

    int getMaxHeightSupported();

    File getResultFileDir();

    void onLongScreenshotFinished(int i2, String str);

    Bitmap overrideScreenshot(Bitmap bitmap);
}
