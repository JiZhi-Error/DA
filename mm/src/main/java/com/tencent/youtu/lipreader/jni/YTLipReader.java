package com.tencent.youtu.lipreader.jni;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayOutputStream;

public class YTLipReader {
    private static final String TAG = YTLipReader.class.getSimpleName();
    private long nativePtr;

    private native void NativeConstructor();

    private native void NativeDestructor();

    public native String feature();

    public native void feed(float[] fArr, byte[] bArr, int i2, int i3, int i4, float f2, float f3, float f4);

    public native String getImageListJsonStr();

    public native String getVersion();

    public native void init();

    public native String lipReadingFeature();

    public native void reset();

    static {
        AppMethodBeat.i(192713);
        AppMethodBeat.o(192713);
    }

    public YTLipReader() {
        AppMethodBeat.i(192708);
        NativeConstructor();
        AppMethodBeat.o(192708);
    }

    public void destroy() {
        AppMethodBeat.i(192709);
        NativeDestructor();
        AppMethodBeat.o(192709);
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        AppMethodBeat.i(192710);
        super.finalize();
        NativeDestructor();
        AppMethodBeat.o(192710);
    }

    public static byte[] encodeJpeg(Bitmap bitmap, int i2) {
        AppMethodBeat.i(192711);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        AppMethodBeat.o(192711);
        return byteArray;
    }

    public static byte[] encodePng(Bitmap bitmap, int i2) {
        AppMethodBeat.i(192712);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, i2, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        AppMethodBeat.o(192712);
        return byteArray;
    }
}
