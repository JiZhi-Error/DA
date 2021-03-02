package com.tencent.mm.av.a.g;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;
import java.io.InputStream;

public final class a {
    public static Bitmap a(c cVar, String str, int i2, int i3) {
        AppMethodBeat.i(130443);
        if (i2 > 0 && i3 > 0) {
            Bitmap extractThumbNail = BitmapUtil.extractThumbNail(str, i3, i2, false);
            AppMethodBeat.o(130443);
            return extractThumbNail;
        } else if (cVar == null || cVar.width <= 0 || cVar.width <= 0) {
            Bitmap bitmapNative = BitmapUtil.getBitmapNative(str);
            AppMethodBeat.o(130443);
            return bitmapNative;
        } else {
            Bitmap bitmapNative2 = BitmapUtil.getBitmapNative(str, cVar.width, cVar.height);
            AppMethodBeat.o(130443);
            return bitmapNative2;
        }
    }

    public static Bitmap b(c cVar, String str, int i2, int i3) {
        int i4;
        int i5;
        AppMethodBeat.i(130444);
        BitmapFactory.Options imageOptions = BitmapUtil.getImageOptions(str);
        if (imageOptions == null || (imageOptions.outWidth < imageOptions.outHeight * 2 && imageOptions.outWidth * 2 > imageOptions.outHeight)) {
            Bitmap extractThumbNail = BitmapUtil.extractThumbNail(str, i3, i2, false);
            AppMethodBeat.o(130444);
            return extractThumbNail;
        } else if (i2 > 0 && i3 > 0) {
            Bitmap extractThumbNail2 = BitmapUtil.extractThumbNail(str, i3, i2, true);
            AppMethodBeat.o(130444);
            return extractThumbNail2;
        } else if (cVar == null || cVar.width <= 0 || cVar.width <= 0) {
            if (cVar == null || cVar.getImageView() == null) {
                Log.w("MicroMsg.imageloader.ImageLoaderUtils", "crop bitmap cant not un set width or height");
                i4 = 0;
                i5 = 0;
            } else {
                int measuredWidth = cVar.getImageView().getMeasuredWidth();
                i4 = cVar.getImageView().getMeasuredHeight();
                i5 = measuredWidth;
            }
            Bitmap extractThumbNail3 = BitmapUtil.extractThumbNail(str, i4, i5, true);
            AppMethodBeat.o(130444);
            return extractThumbNail3;
        } else {
            Bitmap extractThumbNail4 = BitmapUtil.extractThumbNail(str, cVar.height, cVar.width, true);
            AppMethodBeat.o(130444);
            return extractThumbNail4;
        }
    }

    public static Bitmap a(c cVar, InputStream inputStream, int i2, int i3, boolean z, float f2, boolean z2) {
        Bitmap bitmap;
        AppMethodBeat.i(130445);
        if (i2 > 0 && i3 > 0) {
            bitmap = BitmapUtil.decodeStream(inputStream, 0.0f, i2, i3);
        } else if (cVar == null || cVar.width <= 0 || cVar.width <= 0) {
            bitmap = BitmapUtil.decodeStream(inputStream);
        } else {
            bitmap = BitmapUtil.decodeStream(inputStream, 0.0f, cVar.width, cVar.height);
        }
        if (z) {
            bitmap = BitmapUtil.extractThumbNail(bitmap, i2, i3, false, true);
        }
        if (f2 > 0.0f) {
            bitmap = BitmapUtil.setAlpha(bitmap, f2);
        }
        if (z2) {
            bitmap = BitmapUtil.setGrayscale(bitmap);
        }
        AppMethodBeat.o(130445);
        return bitmap;
    }

    public static Bitmap a(c cVar, byte[] bArr, int i2, int i3, boolean z, float f2, boolean z2) {
        Bitmap bitmap;
        AppMethodBeat.i(130446);
        if (i2 > 0 && i3 > 0) {
            bitmap = BitmapUtil.decodeByteArray(bArr, i2, i3);
        } else if (cVar == null || cVar.width <= 0 || cVar.width <= 0) {
            bitmap = BitmapUtil.decodeByteArray(bArr);
        } else {
            bitmap = BitmapUtil.decodeByteArray(bArr, cVar.width, cVar.height);
        }
        if (z) {
            bitmap = BitmapUtil.extractThumbNail(BitmapUtil.decodeByteArray(bArr, i2, i3), i2, i3, false, true);
        }
        if (f2 > 0.0f) {
            bitmap = BitmapUtil.setAlpha(bitmap, f2);
        }
        if (z2) {
            bitmap = BitmapUtil.setGrayscale(bitmap);
        }
        AppMethodBeat.o(130446);
        return bitmap;
    }

    public static Bitmap c(c cVar, String str, int i2, int i3) {
        AppMethodBeat.i(130447);
        if (i2 <= 0 || i3 <= 0) {
            if (cVar != null) {
                try {
                    if (cVar.width > 0 && cVar.width > 0) {
                        Bitmap extractThumbNailAssets = BitmapUtil.extractThumbNailAssets(str, cVar.width, cVar.height);
                        AppMethodBeat.o(130447);
                        return extractThumbNailAssets;
                    }
                } catch (IOException e2) {
                    Log.e("MicroMsg.imageloader.ImageLoaderUtils", "get bitmap from assert failed. :%s", e2.toString());
                    AppMethodBeat.o(130447);
                    return null;
                }
            }
            Bitmap extractThumbNailAssets2 = BitmapUtil.extractThumbNailAssets(str, 0, 0);
            AppMethodBeat.o(130447);
            return extractThumbNailAssets2;
        }
        Bitmap extractThumbNailAssets3 = BitmapUtil.extractThumbNailAssets(str, i2, i3);
        AppMethodBeat.o(130447);
        return extractThumbNailAssets3;
    }

    public static Bitmap a(c cVar, int i2, int i3, int i4) {
        AppMethodBeat.i(130448);
        if (i3 > 0 && i4 > 0) {
            Bitmap bitmapNative = BitmapUtil.getBitmapNative(i2, i3, i4);
            AppMethodBeat.o(130448);
            return bitmapNative;
        } else if (cVar == null || cVar.width <= 0 || cVar.width <= 0) {
            Bitmap bitmapNative2 = BitmapUtil.getBitmapNative(i2);
            AppMethodBeat.o(130448);
            return bitmapNative2;
        } else {
            Bitmap bitmapNative3 = BitmapUtil.getBitmapNative(i2, cVar.width, cVar.height);
            AppMethodBeat.o(130448);
            return bitmapNative3;
        }
    }
}
