package com.tencent.qbar;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class QbarNative {

    public static class QBarCodeDetectInfo {
        public float prob;
        public int readerId;
    }

    public static class QBarPoint {
        public int point_cnt;
        public float x0;
        public float x1;
        public float x2;
        public float x3;
        public float y0;
        public float y1;
        public float y2;
        public float y3;
    }

    public static class QBarReportMsg {
        public int qrcodeVersion;
    }

    public static class QBarResultJNI {
        public String charset;
        public byte[] data;
        public int priorityLevel;
        public int typeID;
        public String typeName;
    }

    public static class QBarZoomInfo {
        public boolean isZoom;
        public float zoomFactor;
    }

    public static class QbarAiModelParam {
        public String detect_model_bin_path_;
        public String detect_model_param_path_;
        public String superresolution_model_bin_path_;
        public String superresolution_model_param_path_;
    }

    protected static native int Encode(byte[] bArr, int[] iArr, String str, int i2, int i3, String str2, int i4);

    protected static native int EncodeBitmap(String str, Bitmap bitmap, int i2, int i3, int i4, int i5, String str2, int i6);

    protected static native String GetVersion();

    protected static native int nativeArrayConvert(int i2, int i3, byte[] bArr, int[] iArr);

    protected static native int nativeCropGray2(byte[] bArr, byte[] bArr2, int i2, int i3, int i4);

    protected static native int nativeGrayRotateCropSub(byte[] bArr, int i2, int i3, int i4, int i5, int i6, int i7, byte[] bArr2, int[] iArr, int i8, int i9);

    protected static native int nativeTransBytes(int[] iArr, byte[] bArr, int i2, int i3);

    protected static native int nativeTransPixels(int[] iArr, byte[] bArr, int i2, int i3);

    protected static native int nativeYUVrotate(byte[] bArr, byte[] bArr2, int i2, int i3);

    protected static native int nativeYUVrotateLess(byte[] bArr, int i2, int i3);

    protected static native int nativeYuvToCropIntArray(byte[] bArr, int[] iArr, int i2, int i3, int i4, int i5, int i6, int i7);

    /* access modifiers changed from: protected */
    public native int GetCodeDetectInfo(QBarCodeDetectInfo[] qBarCodeDetectInfoArr, QBarPoint[] qBarPointArr, int i2);

    /* access modifiers changed from: protected */
    public native int GetDetailResults(QBarResultJNI[] qBarResultJNIArr, QBarPoint[] qBarPointArr, QBarReportMsg[] qBarReportMsgArr, int i2);

    /* access modifiers changed from: protected */
    public native int GetOneResult(byte[] bArr, byte[] bArr2, byte[] bArr3, int[] iArr, int i2);

    /* access modifiers changed from: protected */
    public native int GetResults(QBarResultJNI[] qBarResultJNIArr, int i2);

    /* access modifiers changed from: protected */
    public native int GetZoomInfo(QBarZoomInfo qBarZoomInfo, int i2);

    /* access modifiers changed from: protected */
    public native int Init(int i2, int i3, String str, String str2, QbarAiModelParam qbarAiModelParam);

    /* access modifiers changed from: protected */
    public native int Release(int i2);

    /* access modifiers changed from: protected */
    public native int ScanImage(byte[] bArr, int i2, int i3, int i4);

    /* access modifiers changed from: protected */
    public native int SetReaders(int[] iArr, int i2, int i3);

    static {
        AppMethodBeat.i(88406);
        System.loadLibrary("wechatQrMod");
        AppMethodBeat.o(88406);
    }
}
