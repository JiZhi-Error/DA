package com.tencent.mm.plugin.gif;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.Log;

public class MMWXGFJNI {
    public static final int PIC_TYPE_JPG = 0;
    public static final int PIC_TYPE_PNG = 1;
    private static final String TAG = "MicroMsg.JNI.MMWXGF";
    static int mECode;
    static boolean mIsInit;

    private static native int nativeAV2Gif(String str, String str2);

    private static native int nativeAV2Gif(byte[] bArr, byte[] bArr2);

    public static native int nativeAddGifEncodeRgbaFrame(long j2, int i2, int i3, byte[] bArr, long j3);

    public static native int nativeAddWxAMEncodeRgbaFrame(long j2, int i2, int i3, byte[] bArr, long j3);

    public static native int nativeDecodeBufferFrame(long j2, byte[] bArr, int i2, Bitmap bitmap, int[] iArr);

    public static native int nativeDecodeBufferHeader(long j2, byte[] bArr, int i2);

    public static native byte[] nativeFinishGifEncode(long j2);

    public static native byte[] nativeFinishWxAMEncode(long j2);

    public static native int nativeGetOption(long j2, byte[] bArr, int i2, int[] iArr);

    public static native int nativeInit(String str);

    public static native long nativeInitGifEncode(int i2, int i3, long j2);

    public static native long nativeInitWxAMDecoder();

    public static native long nativeInitWxAMEncoder(int i2, int i3, long j2, int i4);

    public static native boolean nativeIsWXGF(byte[] bArr, int i2);

    private static native int nativePic2Wxam(String str, String str2, int i2, int i3, int i4);

    private static native int nativePic2WxamWithWH(String str, String str2, int i2, int i3, int i4, int i5);

    private static native int nativePic2WxamWithWH(String str, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8);

    public static native int nativeRewindBuffer(long j2);

    public static native int nativeUninit(long j2);

    private static native int nativeWxam2Pic(String str, String str2);

    public static native byte[] nativeWxam2PicBuf(byte[] bArr);

    public static native byte[] nativeWxamToGif(byte[] bArr);

    static {
        AppMethodBeat.i(104681);
        mIsInit = false;
        mECode = -1;
        Log.i(TAG, "static MMWXGFJNI");
        if (!mIsInit) {
            int nativeInit = nativeInit("libvoipCodec.so");
            mECode = nativeInit;
            mIsInit = nativeInit >= 0;
            Log.i(TAG, "native init MMWXGF mECode:%d result:%b :%s", Integer.valueOf(mECode), Boolean.valueOf(mIsInit), "libvoipCodec.so");
            AppMethodBeat.o(104681);
            return;
        }
        Log.d(TAG, "MMWXGF has init.");
        AppMethodBeat.o(104681);
    }

    public static int getErrorCode() {
        return mECode;
    }

    public static int pic2Wxam(String str, String str2, int i2, int i3) {
        AppMethodBeat.i(199790);
        int nativePic2Wxam = nativePic2Wxam(q.k(str, false), q.k(str2, true), i2, i3, ((b) g.af(b.class)).a(b.a.clicfg_wxam_full_range, 0));
        AppMethodBeat.o(199790);
        return nativePic2Wxam;
    }

    public static int wxam2Pic(String str, String str2) {
        AppMethodBeat.i(199791);
        int nativeWxam2Pic = nativeWxam2Pic(q.k(str, false), q.k(str2, true));
        AppMethodBeat.o(199791);
        return nativeWxam2Pic;
    }

    public static int pic2WxamWithWH(String str, String str2, int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(199792);
        int nativePic2WxamWithWH = nativePic2WxamWithWH(q.k(str, false), q.k(str2, true), i2, i3, i4, i5);
        AppMethodBeat.o(199792);
        return nativePic2WxamWithWH;
    }

    public static int pic2WxamWithWH(String str, byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        AppMethodBeat.i(199793);
        int nativePic2WxamWithWH = nativePic2WxamWithWH(q.k(str, true), bArr, i2, i3, i4, i5, i6, i7, i8);
        AppMethodBeat.o(199793);
        return nativePic2WxamWithWH;
    }
}
