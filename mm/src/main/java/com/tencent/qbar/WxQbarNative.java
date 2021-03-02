package com.tencent.qbar;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qbar.QbarNative;

public class WxQbarNative {

    public static class QBarReportMsg {
        public String binaryMethod;
        public String charsetMode;
        public float decodeScale;
        public int detectTime;
        public String ecLevel;
        public boolean inBlackList;
        public boolean inWhiteList;
        public int pyramidLv;
        public int qrcodeVersion;
        public String scaleList;
        public int srTime;
    }

    public static native int FocusInit(int i2, int i3, boolean z, int i4, int i5);

    public static native boolean FocusPro(byte[] bArr, boolean z, boolean[] zArr);

    public static native int FocusRelease();

    public static native int QIPUtilYUVCrop(byte[] bArr, byte[] bArr2, int i2, int i3, int i4, int i5, int i6, int i7);

    public static native int focusedEngineForBankcardInit(int i2, int i3, int i4, boolean z);

    public static native int focusedEngineGetVersion();

    public static native int focusedEngineProcess(byte[] bArr);

    public static native int focusedEngineRelease();

    /* access modifiers changed from: protected */
    public native int AddBlackInternal(int i2, int i3);

    /* access modifiers changed from: protected */
    public native int AddBlackList(String str, int i2);

    /* access modifiers changed from: protected */
    public native int AddWhiteList(String str, int i2);

    /* access modifiers changed from: protected */
    public native String GetDebugString(int i2);

    /* access modifiers changed from: protected */
    public native int GetDetailResults(QbarNative.QBarResultJNI[] qBarResultJNIArr, QbarNative.QBarPoint[] qBarPointArr, QBarReportMsg[] qBarReportMsgArr, int i2);

    /* access modifiers changed from: protected */
    public native int GetDetailResultsNew(QbarNative.QBarResultJNI[] qBarResultJNIArr, QbarNative.QBarPoint[] qBarPointArr, QBarReportMsg[] qBarReportMsgArr, int i2);

    /* access modifiers changed from: protected */
    public native int GetDetectInfoByFrames(QbarNative.QBarCodeDetectInfo qBarCodeDetectInfo, QbarNative.QBarPoint qBarPoint, int i2);

    /* access modifiers changed from: protected */
    public native int GetOneResultReport(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int[] iArr, int[] iArr2, int i2);

    /* access modifiers changed from: protected */
    public native int GetZoomInfo(QbarNative.QBarZoomInfo qBarZoomInfo, int i2);

    /* access modifiers changed from: protected */
    public native void Reset(int i2, boolean z);

    /* access modifiers changed from: protected */
    public native int ScanImage712(byte[] bArr, int i2, int i3, int i4);

    /* access modifiers changed from: protected */
    public native int SetCenterCoordinate(int i2, int i3, int i4, int i5, int i6);

    /* access modifiers changed from: protected */
    public native int SetTouchCoordinate(int i2, float f2, float f3);

    static {
        AppMethodBeat.i(158877);
        System.loadLibrary("wechatQrMod");
        AppMethodBeat.o(158877);
    }
}
