package com.tencent.youtu.ytposedetect.jni;

import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytposedetect.data.YTActRefData;
import java.io.ByteArrayOutputStream;

public class YTPoseDetectJNIInterface {
    private static IYtLoggerListener loggerListener;

    public interface IYtLoggerListener {
        void log(String str, String str2);
    }

    public static native boolean canReflect();

    public static native void configNativeLog(boolean z);

    public static native YTActRefData getActionReflectData(int i2);

    public static native byte[] getBestImage(int i2);

    public static native byte[] getEyeImage(int i2);

    public static native byte[][] getFrameList();

    public static native byte[] getMouthImage(int i2);

    public static native String getVersion();

    public static native int initModel(String str);

    public static native boolean isRecordingDone();

    public static native int poseDetect(float[] fArr, float[] fArr2, int i2, byte[] bArr, int i3, int i4, int i5, float f2, float f3, float f4, int i6);

    public static native void releaseAll();

    public static native void resetDetect();

    public static native void setSafetyLevel(int i2);

    public static native int updateParam(String str, String str2);

    public static byte[] encodeJpeg(Bitmap bitmap) {
        AppMethodBeat.i(62514);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 99, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        AppMethodBeat.o(62514);
        return byteArray;
    }

    public static void setLoggerListener(IYtLoggerListener iYtLoggerListener) {
        loggerListener = iYtLoggerListener;
    }

    public static void nativeLog(String str, String str2) {
        AppMethodBeat.i(192532);
        if (loggerListener != null) {
            loggerListener.log(str, str2);
        }
        AppMethodBeat.o(192532);
    }

    public static void nativeLog(int i2, String str) {
        AppMethodBeat.i(192533);
        if (loggerListener != null) {
            loggerListener.log("[YTPoseDetectJNIInterface.nativeLog]", str);
        }
        AppMethodBeat.o(192533);
    }
}
