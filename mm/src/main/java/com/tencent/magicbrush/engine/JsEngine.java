package com.tencent.magicbrush.engine;

import com.tencent.magicbrush.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

class JsEngine {
    static native void addJsInterface(long j2, Object obj, String str);

    static native long createVM(String str, byte[] bArr);

    static native long createVMContext(long j2, int i2);

    static native String evaluateJavascript(long j2, String str);

    static native String evaluateJavascriptCache(long j2, String str, String str2, String str3, String str4);

    static native String evaluateJavascriptDebug(long j2, String str, String str2);

    static native String evaluateJavascriptFile(long j2, String str, String str2);

    static native ByteBuffer getNativeBuffer(int i2, long j2);

    static native int getNativeBufferId();

    static native void pumpMessageLoop(long j2);

    static native boolean pushObject(long j2, long j3, String str);

    static native void releaseVM(long j2);

    static native void releaseVMContext(long j2);

    static native boolean removeJsInterface(long j2, String str);

    static native boolean removeObject(long j2, String str);

    static native void setNativeBuffer(int i2, ByteBuffer byteBuffer);

    static native void waitForDebuger(long j2, String str);

    JsEngine() {
    }

    static {
        AppMethodBeat.i(139986);
        b.loadLibraries();
        AppMethodBeat.o(139986);
    }
}
