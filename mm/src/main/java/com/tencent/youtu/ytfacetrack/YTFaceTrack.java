package com.tencent.youtu.ytfacetrack;

import android.graphics.Bitmap;
import android.graphics.Rect;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytfacetrack.param.YTFaceAlignParam;
import com.tencent.youtu.ytfacetrack.param.YTFaceDetectParam;
import com.tencent.youtu.ytfacetrack.param.YTFaceTrackParam;

public class YTFaceTrack {
    public static String Version = "2.3.3.6";
    private static YTFaceTrack instance = null;
    private static IYtLoggerListener loggerListener;
    public long handleId = 0;
    private long nativePtr;

    public static class FaceStatus {
        public float pitch;
        public float[] pointsVis;
        public float roll;
        public float[] xys;
        public float[] xys5p;
        public float yaw;
    }

    public static class FaceStatus3d {
        public float[] denseFaceModel;
        public float[] expression;
        public float pitch;
        public float roll;
        public float[] transform;
        public float yaw;
    }

    public interface IYtLoggerListener {
        void log(String str, String str2);
    }

    public static class YTImage {
        public byte[] data;
        public int height;
        public int width;
    }

    private static native int GlobalInitInner(String str);

    private static native int GlobalInitSuccessCount();

    private static native boolean GlobalReleaseInner();

    private native void NativeConstructor();

    private native void NativeDestructor();

    private static native boolean nativeInit();

    public native FaceStatus[] DoDetectionProcess(YTImage yTImage);

    public native FaceStatus[] DoDetectionProcessBitmap(Bitmap bitmap, int i2, YTImage yTImage);

    public native FaceStatus[] DoDetectionProcessRGB(byte[] bArr, int i2, int i3, int i4, YTImage yTImage);

    public native FaceStatus[] DoDetectionProcessRGBA(byte[] bArr, int i2, int i3, int i4, YTImage yTImage);

    public native FaceStatus[] DoDetectionProcessYUV(byte[] bArr, int i2, int i3, int i4, YTImage yTImage);

    public native FaceStatus[] DoDetectionProcessYUVWithBlur(byte[] bArr, int i2, int i3, int i4, boolean z, float[] fArr, YTImage yTImage);

    public native YTFaceAlignParam GetFaceAlignParam();

    public native YTFaceDetectParam GetFaceDetectParam();

    public native Rect[] GetFaceRect(YTImage yTImage);

    public native YTFaceTrackParam GetFaceTrackParam();

    public native YTImage GetYTImageBitmap(Bitmap bitmap, int i2);

    public native int GetYTImageBitmapReuseData(Bitmap bitmap, int i2, YTImage yTImage);

    public native YTImage GetYTImageRGB(byte[] bArr, int i2, int i3, int i4);

    public native YTImage GetYTImageRGBA(byte[] bArr, int i2, int i3, int i4);

    public native int GetYTImageRGBAReuseData(byte[] bArr, int i2, int i3, int i4, YTImage yTImage);

    public native int GetYTImageRGBReuseData(byte[] bArr, int i2, int i3, int i4, YTImage yTImage);

    public native YTImage GetYTImageYUV(byte[] bArr, int i2, int i3, int i4);

    public native int GetYTImageYUVReuseData(byte[] bArr, int i2, int i3, int i4, YTImage yTImage);

    public native byte[] RotateYUV(byte[] bArr, int i2, int i3, int i4);

    public native void SaveYTImage(byte[] bArr, int i2, int i3);

    public native boolean SetFaceAlignParam(YTFaceAlignParam yTFaceAlignParam);

    public native boolean SetFaceDetectParam(YTFaceDetectParam yTFaceDetectParam);

    public native boolean SetFaceTrackParam(YTFaceTrackParam yTFaceTrackParam);

    static {
        AppMethodBeat.i(73435);
        nativeInit();
        AppMethodBeat.o(73435);
    }

    public static synchronized YTFaceTrack getInstance() {
        YTFaceTrack yTFaceTrack;
        synchronized (YTFaceTrack.class) {
            AppMethodBeat.i(73429);
            yTFaceTrack = instance;
            AppMethodBeat.o(73429);
        }
        return yTFaceTrack;
    }

    public YTFaceTrack() {
        AppMethodBeat.i(73430);
        NativeConstructor();
        AppMethodBeat.o(73430);
    }

    public static int GlobalInit(String str) {
        AppMethodBeat.i(73433);
        int GlobalInitInner = GlobalInitInner(str);
        if (GlobalInitInner == 0) {
            instance = new YTFaceTrack();
        }
        AppMethodBeat.o(73433);
        return GlobalInitInner;
    }

    public static boolean GlobalRelease() {
        AppMethodBeat.i(73434);
        if (instance != null) {
            instance.NativeDestructor();
            instance = null;
        }
        boolean GlobalReleaseInner = GlobalReleaseInner();
        AppMethodBeat.o(73434);
        return GlobalReleaseInner;
    }

    public static boolean IsInstanceExist() {
        return instance != null;
    }

    public static void setLoggerListener(IYtLoggerListener iYtLoggerListener) {
        loggerListener = iYtLoggerListener;
    }

    public static void nativeLog(int i2, String str) {
        AppMethodBeat.i(192714);
        if (loggerListener != null) {
            loggerListener.log("[YTFaceTrack.nativeLog]", str);
        }
        AppMethodBeat.o(192714);
    }
}
