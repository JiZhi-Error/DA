package com.github.henryye.nativeiv.bitmap;

import android.support.annotation.Keep;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import java.io.InputStream;

public interface IBitmap<Type> {
    void decodeInputStream(InputStream inputStream, ImageDecodeConfig imageDecodeConfig, c cVar);

    long getDecodeTime();

    BitmapType getType();

    Type provide();

    @Keep
    void recycle();
}
