package com.tencent.liteav.beauty;

import com.tencent.liteav.basic.util.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class NativeLoad {
    private static final String TAG = "NativeLoad";

    public static native void OnLoadBeauty();

    public static native void nativeClearQueue();

    public static native void nativeDeleteYuv2Yuv();

    public static native void nativeGlMapBufferToQueue(int i2, int i3, ByteBuffer byteBuffer);

    public static native void nativeGlReadPixs(int i2, int i3, byte[] bArr);

    public static native boolean nativeGlReadPixsFromQueue(int i2, int i3, byte[] bArr);

    public static native void nativeGlReadPixsToQueue(int i2, int i3);

    public static native int nativeLoadGLProgram(int i2);

    public static native void nativeglTexImage2D(int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, byte[] bArr, int i10);

    /* access modifiers changed from: package-private */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final NativeLoad f485a = new NativeLoad();

        static {
            AppMethodBeat.i(15160);
            f.f();
            AppMethodBeat.o(15160);
        }
    }

    private NativeLoad() {
        AppMethodBeat.i(15207);
        OnLoadBeauty();
        AppMethodBeat.o(15207);
    }

    public static NativeLoad getInstance() {
        return a.f485a;
    }
}
