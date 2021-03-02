package com.tencent.youtu.ytagreflectlivecheck.jni;

import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.FullPack;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.RawYuvData;
import com.tencent.youtu.ytagreflectlivecheck.jni.cppDefine.Timeval;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class YTAGReflectLiveCheckJNIInterface {
    public static int TIME_REGULATION_LOOSE = 1;
    public static int TIME_REGULATION_STRICT = 0;
    private static YTAGReflectLiveCheckJNIInterface instance = null;
    private static Lock instanceLock = new ReentrantLock();
    private static IYtLoggerListener loggerListener;
    private long FRnativePtr;
    public Context context = null;

    public interface IYtLoggerListener {
        void log(String str, String str2);
    }

    public static native String FRGenConfigData(int i2, String str);

    public static native String FRVersion();

    public static native void configNativeLog(boolean z);

    public static native int updateParam(String str, String str2);

    public native int FRDoDetectionYuvs(boolean z, int i2);

    public native FullPack FRGetAGin();

    public native int FRGetChangePoint();

    public native int FRGetConfigBegin();

    public native int FRGetConfigEnd();

    public native int FRGetISOCaptureTimeVecSize();

    public native double FRGetISObackup();

    public native int FRGetISOchangeFrame();

    public native double FRGetISOmin();

    public native RawYuvData[] FRGetRawYuvDatas();

    public native int FRGetTriggerTime();

    public native int FRInit(boolean z, String str, int i2, long[] jArr, float f2);

    public native void FRNativeConstructor();

    public native void FRNativeDestructor();

    public native void FRPushCaptureTime(Timeval timeval);

    public native void FRPushISOCaptureTime(Timeval timeval);

    public native void FRPushISOImgYuv(byte[] bArr, int i2, int i3);

    public native void FRPushYuv(byte[] bArr, int i2, int i3, long j2, int i4, float[] fArr);

    public native int FRRelease();

    public native void FRSetBegin(Timeval timeval);

    public native void FRSetChangePointTime(Timeval timeval);

    public native void FRSetDoingDelayCalc(boolean z);

    public native void FRSetEnd(Timeval timeval);

    public native void FRSetISObackup(double d2);

    public native void FRSetISOchangeFrame(int i2);

    public native void FRSetISOchangeTime(Timeval timeval);

    public native void FRSetSafetyLevel(int i2);

    static {
        AppMethodBeat.i(193636);
        AppMethodBeat.o(193636);
    }

    public static synchronized YTAGReflectLiveCheckJNIInterface getInstance() {
        YTAGReflectLiveCheckJNIInterface yTAGReflectLiveCheckJNIInterface;
        synchronized (YTAGReflectLiveCheckJNIInterface.class) {
            AppMethodBeat.i(43373);
            try {
                instanceLock.lock();
                if (instance == null) {
                    instance = new YTAGReflectLiveCheckJNIInterface();
                }
                instanceLock.unlock();
                yTAGReflectLiveCheckJNIInterface = instance;
                AppMethodBeat.o(43373);
            } catch (Throwable th) {
                instanceLock.unlock();
                AppMethodBeat.o(43373);
                throw th;
            }
        }
        return yTAGReflectLiveCheckJNIInterface;
    }

    public static synchronized void clearInstance() {
        synchronized (YTAGReflectLiveCheckJNIInterface.class) {
            AppMethodBeat.i(193633);
            try {
                instanceLock.lock();
                if (instance != null) {
                    instance.FRNativeDestructor();
                    instance = null;
                }
            } finally {
                instanceLock.unlock();
                AppMethodBeat.o(193633);
            }
        }
    }

    private YTAGReflectLiveCheckJNIInterface() {
        AppMethodBeat.i(43374);
        FRNativeConstructor();
        AppMethodBeat.o(43374);
    }

    public static void compressTest(Bitmap bitmap, int i2) {
        AppMethodBeat.i(43377);
        try {
            File file = new File("/sdcard/reflect/");
            if (!file.exists()) {
                file.mkdirs();
            }
            String str = "/sdcard/reflect/" + i2 + FilePathGenerator.ANDROID_DIR_SEP;
            File file2 = new File(str);
            if (!file2.exists()) {
                file2.mkdirs();
            }
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str, "mytestInJava_" + System.currentTimeMillis() + ".jpg"));
            bitmap.compress(Bitmap.CompressFormat.JPEG, i2, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
            AppMethodBeat.o(43377);
        } catch (Exception e2) {
            AppMethodBeat.o(43377);
        }
    }

    public static byte[] encodeJpeg(Bitmap bitmap, int i2) {
        AppMethodBeat.i(43378);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, i2, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        AppMethodBeat.o(43378);
        return byteArray;
    }

    public static byte[] encodeJpeg(Bitmap bitmap) {
        AppMethodBeat.i(43379);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 99, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        AppMethodBeat.o(43379);
        return byteArray;
    }

    public static String sdkVersion() {
        return "";
    }

    public static String modelVersion() {
        return "";
    }

    public static void setLoggerListener(IYtLoggerListener iYtLoggerListener) {
        loggerListener = iYtLoggerListener;
    }

    public static void nativeLog(String str, String str2) {
        AppMethodBeat.i(193634);
        if (loggerListener != null) {
            loggerListener.log(str, str2);
        }
        AppMethodBeat.o(193634);
    }

    public static void nativeLog(int i2, String str) {
        AppMethodBeat.i(193635);
        if (loggerListener != null) {
            loggerListener.log("[YTAGReflectLiveCheckJNIInterface.nativeLog]", str);
        }
        AppMethodBeat.o(193635);
    }
}
