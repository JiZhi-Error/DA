package com.tencent.wxmm;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class v2render {
    public final int FLAG_Angle270 = 12;
    public final int FLAG_Angle90 = 4;
    public final int FLAG_Mirror = 16;
    public final int FLAG_NV12 = 2;
    public final int FLAG_NV21 = 3;
    public final int FLAG_RGBA = 0;
    public final int FLAG_RGBAClip = 1;
    public final int FLAG_YV12 = 0;
    public final int FLAG_YV12Edge = 1;
    public final int MSG_FLUSH = 1;
    public final int MSG_RENDER = 0;
    public final int MSG_RESET = 2;
    public final int RenderLocal = 0;
    public final int RenderRemote = 1;
    public float mBrightness = 1.2f;
    public float mContrast = 1.93f;
    public float mSaturation = 1.05f;

    public native void Init(int i2, Object obj, int i3);

    public native void Uninit(int i2);

    public native void render32(int[] iArr, int i2, int i3, int i4, int i5);

    public native void render8(byte[] bArr, int i2, int i3, int i4, int i5);

    public native void setMode(int i2, int i3, int i4, int i5);

    public native void setParam(float f2, float f3, float f4, int i2);

    static {
        AppMethodBeat.i(40800);
        System.loadLibrary("voipGLRender");
        AppMethodBeat.o(40800);
    }

    public static int getGLVersion() {
        return 2;
    }
}
