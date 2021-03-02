package com.tencent.mm.loader.l;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.os.Build;
import com.tencent.mm.loader.e.b.g;
import com.tencent.mm.loader.h.a.b;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import java.io.InputStream;

public final class a {
    public static boolean e(com.tencent.mm.loader.h.a.a aVar) {
        if (aVar == null || aVar.aKr() == b.ASSET_DATA || aVar.aKr() == b.DRAWABLE_ID || aVar.aKr() == b.LOCAL_PATH) {
            return true;
        }
        return false;
    }

    public static Bitmap a(g<?> gVar, InputStream inputStream, int i2, int i3) {
        if (i2 > 0 && i3 > 0) {
            return BitmapUtil.decodeStream(inputStream, 0.0f, i3, i2);
        }
        if (gVar == null || gVar.width <= 0 || gVar.width <= 0) {
            return BitmapUtil.getBitmapNative(inputStream);
        }
        return BitmapUtil.getBitmapNative(inputStream, gVar.width, gVar.height);
    }

    @TargetApi(12)
    public static long bR(Object obj) {
        if (obj == null || !(obj instanceof Bitmap)) {
            return 0;
        }
        Bitmap bitmap = (Bitmap) obj;
        if (Build.VERSION.SDK_INT >= 12) {
            return (long) bitmap.getByteCount();
        }
        return (long) (bitmap.getRowBytes() * bitmap.getHeight());
    }
}
