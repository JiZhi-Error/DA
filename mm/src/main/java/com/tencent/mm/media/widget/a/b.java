package com.tencent.mm.media.widget.a;

import android.graphics.Point;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u001fH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u000e\"\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0013\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR\u001a\u0010\u0016\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\u001a\u0010\u0019\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\b¨\u0006 "}, hxF = {"Lcom/tencent/mm/media/widget/camera/CameraConfig;", "", "()V", "encodeVideoBestSizeHeight", "", "getEncodeVideoBestSizeHeight", "()I", "setEncodeVideoBestSizeHeight", "(I)V", "encodeVideoBestSizeWidth", "getEncodeVideoBestSizeWidth", "setEncodeVideoBestSizeWidth", "isCpuCrop", "", "()Z", "setCpuCrop", "(Z)V", "isFrontCamera", "setFrontCamera", "previewHeight", "getPreviewHeight", "setPreviewHeight", "previewWidth", "getPreviewWidth", "setPreviewWidth", "rotateDegree", "getRotateDegree", "setRotateDegree", "cameraTextureSize", "Landroid/graphics/Point;", "toString", "", "plugin-mediaeditor_release"})
public final class b {
    private static int ijt;
    private static int imd;
    private static int ime;
    private static boolean imf;
    private static boolean img;
    public static final b imh = new b();
    private static int previewHeight;
    private static int previewWidth;

    static {
        AppMethodBeat.i(94010);
        AppMethodBeat.o(94010);
    }

    private b() {
    }

    public static int getPreviewHeight() {
        return previewHeight;
    }

    public static void rr(int i2) {
        previewHeight = i2;
    }

    public static int getPreviewWidth() {
        return previewWidth;
    }

    public static void rs(int i2) {
        previewWidth = i2;
    }

    public static int aPk() {
        return ijt;
    }

    public static void rt(int i2) {
        ijt = i2;
    }

    public static int aPl() {
        return imd;
    }

    public static void ru(int i2) {
        imd = i2;
    }

    public static int aPm() {
        return ime;
    }

    public static void rv(int i2) {
        ime = i2;
    }

    public static boolean aPn() {
        return imf;
    }

    public static void setFrontCamera(boolean z) {
        imf = z;
    }

    public static void eZ(boolean z) {
        img = z;
    }

    public final String toString() {
        AppMethodBeat.i(94008);
        String str = "previewHeight: " + previewHeight + " ,previewWidth:" + previewWidth + " ,rotateDegree: " + ijt + " ,isFrontCamera:" + imf + ' ' + " encodeVideoBestSizeWidth : " + imd + " , encodeVideoBestSizeHeight : " + ime + ", isCpuCrop: " + img + ' ';
        AppMethodBeat.o(94008);
        return str;
    }

    public static Point aPo() {
        AppMethodBeat.i(94009);
        Point point = new Point(previewWidth, previewHeight);
        AppMethodBeat.o(94009);
        return point;
    }
}
