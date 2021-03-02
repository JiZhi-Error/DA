package com.tencent.thumbplayer.api;

import android.graphics.Bitmap;

public interface TPCaptureCallBack {
    void onCaptureVideoFailed(int i2);

    void onCaptureVideoSuccess(Bitmap bitmap);
}
