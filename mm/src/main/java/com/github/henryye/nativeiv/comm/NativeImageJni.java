package com.github.henryye.nativeiv.comm;

import android.support.annotation.Keep;
import com.github.henryye.nativeiv.a.a;
import com.github.henryye.nativeiv.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class NativeImageJni {
    long mNativeInst = 0;

    /* access modifiers changed from: package-private */
    @Keep
    public native CommNativeBitmapStruct nativeDecodeNative(long j2, ByteBuffer byteBuffer, int i2, boolean z);

    /* access modifiers changed from: package-private */
    @Keep
    public native void nativeDestroy(long j2);

    /* access modifiers changed from: package-private */
    @Keep
    public native long nativeInit();

    /* access modifiers changed from: package-private */
    @Keep
    public native void nativeRecycleNative(long j2, long j3);

    static {
        AppMethodBeat.i(127376);
        b.d("NativeImageJni", "load library", new Object[0]);
        a.loadLibrary("native-iv");
        AppMethodBeat.o(127376);
    }
}
