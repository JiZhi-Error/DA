package com.github.henryye.nativeiv.api;

import android.graphics.Bitmap;
import android.support.annotation.Keep;
import com.github.henryye.nativeiv.ImageDecodeConfig;
import com.github.henryye.nativeiv.a.c;
import com.github.henryye.nativeiv.bitmap.BitmapType;
import com.github.henryye.nativeiv.bitmap.IBitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface IImageDecodeService {

    public interface a {
        IBitmap a(String str, Object obj, com.github.henryye.nativeiv.b.b bVar, ImageDecodeConfig imageDecodeConfig);

        void a(b bVar);

        void aW(int i2, int i3);

        void destroy();

        void forceSetUseType(BitmapType bitmapType);

        boolean isDestroyed();
    }

    public interface c {
        void ad(Object obj);
    }

    @Keep
    void addDecodeEventListener(b bVar);

    @Keep
    void addImageStreamFetcher(com.github.henryye.nativeiv.b.b bVar, boolean z);

    @Keep
    String encodeToBase64(Bitmap bitmap, int i2, float f2);

    @Keep
    byte[] encodeToBuffer(Bitmap bitmap, int i2, float f2);

    @Keep
    void forceSetUseType(BitmapType bitmapType);

    @Keep
    Bitmap getBitmap(int i2, int i3);

    @Keep
    void init();

    @Keep
    void loadBitmapAsync(Object obj, ImageDecodeConfig imageDecodeConfig);

    @Keep
    void loadBitmapAsync(String str);

    @Keep
    void loadBitmapAsync(String str, ImageDecodeConfig imageDecodeConfig);

    @Keep
    IBitmap loadBitmapSync(Object obj, ImageDecodeConfig imageDecodeConfig);

    @Keep
    IBitmap loadBitmapSync(String str);

    @Keep
    IBitmap loadBitmapSync(String str, ImageDecodeConfig imageDecodeConfig);

    @Keep
    void release();

    @Keep
    void releaseBitmap(Bitmap bitmap);

    @Keep
    void removeDecodeEventListener(b bVar);

    @Keep
    void removeImageStreamFetcher(com.github.henryye.nativeiv.b.b bVar, boolean z);

    @Keep
    void setBitmapDecodeSlave(a aVar);

    @Keep
    void setIdKeyReportDelegate(c.a aVar);

    @Keep
    void setKvReportDelegate(c.b bVar);

    @Keep
    void setMaxDecodeDimension(int i2, int i3);

    @Keep
    void setNetworkTimeout(int i2, int i3);

    public interface b {
        void a(String str, a aVar, a aVar2);

        void a(String str, Object obj, c cVar, ImageDecodeConfig imageDecodeConfig);

        public enum a {
            OK,
            NOT_EXIST,
            PRE_DECODE_ERROR,
            DECODE_ERROR,
            UNSUPPORTED_IMG_FORMAT,
            HUGE_SIZE,
            IO_ERROR,
            OUT_OF_MEMORY,
            LEGACY_MODE,
            TIME_COST_HUGE,
            NATIVE_DECODE_ERROR,
            THROW_EXCEPTION;

            public static a valueOf(String str) {
                AppMethodBeat.i(127357);
                a aVar = (a) Enum.valueOf(a.class, str);
                AppMethodBeat.o(127357);
                return aVar;
            }

            static {
                AppMethodBeat.i(127358);
                AppMethodBeat.o(127358);
            }
        }
    }
}
