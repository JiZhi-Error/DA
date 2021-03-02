package com.tencent.mm.xeffect;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashSet;

public class WeEffectRender {
    public static native long nAddFaceAutoSlimer(long j2, String str);

    public static native long nCreateFilter(long j2, String str, float f2);

    public static native long nCreateMakeUp(long j2, int i2, String str);

    public static native long nCreateSticker(long j2, int i2, String str);

    public static native void nDestroy(long j2);

    public static native ArrayList<HashSet<Integer>> nExportAction(long j2);

    public static native int nFaceTrack(long j2, Buffer buffer, int i2, int i3, long j3);

    public static native int nGetImageLabel(long j2);

    public static native int nGetSegmentTexture(long j2);

    public static native long nInit(int i2, String str, String str2, boolean z, boolean z2);

    public static native void nRemoveFilter(long j2, long j3);

    public static native int nRemoveResource(long j2, long j3);

    public static native int nRenderToBuffer(long j2, byte[] bArr, int i2, int i3, byte[] bArr2, int i4, int i5, boolean z);

    public static native int nRenderToTexture(long j2, int i2, int i3, int i4, int i5, int i6, boolean z, boolean z2);

    public static native void nResetAnim(long j2, long j3);

    public static native void nSetAnim(long j2, long j3, int i2);

    public static native int nSetConfigFlags(long j2, String str, float f2);

    public static native int nSetEffectLevel(long j2, int i2, float f2);

    public static native int nSetFaceAutoSlimerRate(long j2, long j3, float f2);

    public static native void nSetFocalLength(long j2, float f2);

    public static native void nSetNativeLog(long j2);

    public static native void nSetSegment(long j2, boolean z, int i2, int i3, int i4);

    public static native int nTrackImageLabel(long j2, Buffer buffer, int i2, int i3);

    public static native void nUpdateAnim(long j2, long j3);

    public static native void nUpdateSticker(long j2);

    static {
        AppMethodBeat.i(236762);
        d.load("xlabeffect");
        AppMethodBeat.o(236762);
    }

    public static long b(String str, int i2, boolean z, boolean z2) {
        AppMethodBeat.i(236761);
        long nInit = nInit(i2, str, str + "/OpenCLCNNLib.bin", z, z2);
        AppMethodBeat.o(236761);
        return nInit;
    }
}
