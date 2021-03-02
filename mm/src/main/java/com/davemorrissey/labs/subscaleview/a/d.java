package com.davemorrissey.labs.subscaleview.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.net.Uri;

public interface d {
    Bitmap a(Rect rect, int i2);

    Point d(Context context, Uri uri);

    boolean isReady();

    void recycle();
}
