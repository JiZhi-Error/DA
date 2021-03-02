package com.tencent.map.lib.callbacks;

import android.graphics.Bitmap;
import android.support.annotation.Keep;

@Keep
public interface TileOverlayCallback {
    Bitmap onLoadTile(int i2, int i3, int i4, byte[] bArr);

    void onLoadTileFinish(int i2, int i3, int i4);

    void onWriteTile(int i2, int i3, int i4, String str, byte[] bArr);
}
