package com.tencent.youtu.ytcommon.auth;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Looper;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.youtu.ytcommon.auth.HttpUtil;
import com.tencent.youtu.ytcommon.tools.YTLogger;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class YTAuthJNIInterface {
    private static final String DAT_SUFFIX = "SDK.dat";
    private static final String LICENCE_SUFFIX = "SDK.licence";
    private static final String SDK_NAME = "YoutuFaceTrack";
    private static final String SDK_PREFIX = "YT";
    private static final String TAG = "log_print_java";
    private static String VERSION = "1.2";
    private static long handle = 0;
    private static boolean isReportStarted = false;
    private static String licenceStr = "";
    private static HttpUtil.HttpResponseListener mListener = new HttpUtil.HttpResponseListener() {
        /* class com.tencent.youtu.ytcommon.auth.YTAuthJNIInterface.AnonymousClass3 */

        @Override // com.tencent.youtu.ytcommon.auth.HttpUtil.HttpResponseListener
        public final void onSuccess(String str) {
            AppMethodBeat.i(73352);
            try {
                YTLogger.d(YTAuthJNIInterface.TAG, "response: ".concat(String.valueOf(str)));
                YTLogger.d(YTAuthJNIInterface.TAG, "handle: " + YTAuthJNIInterface.handle);
                YTAuthJNIInterface.access$300(YTAuthJNIInterface.handle, str);
                AppMethodBeat.o(73352);
            } catch (Exception e2) {
                AppMethodBeat.o(73352);
            }
        }

        @Override // com.tencent.youtu.ytcommon.auth.HttpUtil.HttpResponseListener
        public final void onFail(int i2) {
            AppMethodBeat.i(73353);
            try {
                YTLogger.d(YTAuthJNIInterface.TAG, "http request error : ".concat(String.valueOf(i2)));
                YTLogger.d(YTAuthJNIInterface.TAG, "handle: " + YTAuthJNIInterface.handle);
                YTAuthJNIInterface.access$300(YTAuthJNIInterface.handle, null);
                AppMethodBeat.o(73353);
            } catch (Exception e2) {
                AppMethodBeat.o(73353);
            }
        }
    };
    private static Timer timerFlush;
    private static Timer timerReport;
    private long nativePtr;

    private static native int getCurrentAuthStatus(long j2);

    private static native int getIsNeedReport(long j2);

    private static native String getReportContent();

    private static native boolean nativeCheck(long j2);

    private static native long nativeFlush();

    private static native long nativeInitN(Context context, int i2, String str, AssetManager assetManager, String str2);

    private static native int nativePreInitAndCheck(byte[] bArr, int i2, String str, String str2, String str3);

    private static native long nativeUpdateFromServer(long j2, String str);

    static /* synthetic */ String access$000() {
        AppMethodBeat.i(73361);
        String reportContent = getReportContent();
        AppMethodBeat.o(73361);
        return reportContent;
    }

    static /* synthetic */ long access$100() {
        AppMethodBeat.i(73362);
        long nativeFlush = nativeFlush();
        AppMethodBeat.o(73362);
        return nativeFlush;
    }

    static /* synthetic */ long access$300(long j2, String str) {
        AppMethodBeat.i(73363);
        long nativeUpdateFromServer = nativeUpdateFromServer(j2, str);
        AppMethodBeat.o(73363);
        return nativeUpdateFromServer;
    }

    static {
        AppMethodBeat.i(73364);
        AppMethodBeat.o(73364);
    }

    public static int preCheckAndInitWithLicenceStr(Context context, String str) {
        AppMethodBeat.i(73355);
        licenceStr = str;
        int i2 = -1;
        try {
            byte[] bytes = str.getBytes();
            int length = bytes.length;
            if (length <= 0) {
                IOException iOException = new IOException("licence error");
                AppMethodBeat.o(73355);
                throw iOException;
            }
            String packageName = context.getPackageName();
            String deviceUid = StatisticsUtils.getDeviceUid(context);
            YTLogger.d(TAG, "Package name: ".concat(String.valueOf(packageName)));
            YTLogger.d(TAG, "Device id: ".concat(String.valueOf(deviceUid)));
            i2 = nativePreInitAndCheck(bytes, length, packageName, deviceUid, context.getFilesDir().getPath() + "/YTYoutuFaceTrackSDK.dat");
            AppMethodBeat.o(73355);
            return i2;
        } catch (IOException e2) {
        }
    }

    private static void startTimer() {
        AppMethodBeat.i(73356);
        YTLogger.d(TAG, "start timer");
        if (isReportStarted) {
            AppMethodBeat.o(73356);
            return;
        }
        AnonymousClass1 r1 = new TimerTask() {
            /* class com.tencent.youtu.ytcommon.auth.YTAuthJNIInterface.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(73350);
                String access$000 = YTAuthJNIInterface.access$000();
                if (access$000 != "") {
                    YTAuthJNIInterface.report(access$000);
                }
                AppMethodBeat.o(73350);
            }
        };
        Timer timer = new Timer(true);
        timerReport = timer;
        timer.schedule(r1, 600000, 600000);
        AnonymousClass2 r12 = new TimerTask() {
            /* class com.tencent.youtu.ytcommon.auth.YTAuthJNIInterface.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(73351);
                YTLogger.d(YTAuthJNIInterface.TAG, "flush in java ");
                YTAuthJNIInterface.access$100();
                AppMethodBeat.o(73351);
            }
        };
        Timer timer2 = new Timer(true);
        timerFlush = timer2;
        timer2.schedule(r12, 600000, 600000);
        isReportStarted = true;
        AppMethodBeat.o(73356);
    }

    public static int init(Context context, String str, int i2, boolean z) {
        AppMethodBeat.i(73357);
        YTLogger.d(TAG, "start init");
        String str2 = context.getFilesDir().getPath() + "/YTYoutuFaceTrackSDK.dat";
        YTLogger.d(TAG, "path: ".concat(String.valueOf(str2)));
        handle = nativeInitN(context, i2, str, context.getAssets(), str2);
        YTLogger.d(TAG, "handleinit: " + handle);
        if (getIsNeedReport(handle) == 0) {
            YTLogger.d(TAG, "no need to report");
        } else {
            YTLogger.d(TAG, "need report");
            startTimer();
        }
        int currentAuthStatus = getCurrentAuthStatus(handle);
        AppMethodBeat.o(73357);
        return currentAuthStatus;
    }

    public static long getHandle() {
        return handle;
    }

    public static boolean check() {
        AppMethodBeat.i(73358);
        boolean nativeCheck = nativeCheck(handle);
        YTLogger.d(ServerProtocol.DIALOG_PARAM_SDK_VERSION, "--------------check");
        AppMethodBeat.o(73358);
        return nativeCheck;
    }

    private static boolean isInMainThread() {
        AppMethodBeat.i(73359);
        if (Looper.myLooper() == Looper.getMainLooper()) {
            AppMethodBeat.o(73359);
            return true;
        }
        AppMethodBeat.o(73359);
        return false;
    }

    public static void report(final String str) {
        AppMethodBeat.i(73360);
        if (isInMainThread()) {
            new Thread(new Runnable() {
                /* class com.tencent.youtu.ytcommon.auth.YTAuthJNIInterface.AnonymousClass4 */

                public final void run() {
                    AppMethodBeat.i(73354);
                    try {
                        HttpUtil.post("https://api.youtu.qq.com/auth/report", str, YTAuthJNIInterface.mListener);
                        AppMethodBeat.o(73354);
                    } catch (IOException e2) {
                        AppMethodBeat.o(73354);
                    }
                }
            }).start();
            AppMethodBeat.o(73360);
            return;
        }
        try {
            HttpUtil.post("https://api.youtu.qq.com/auth/report", str, mListener);
            AppMethodBeat.o(73360);
        } catch (IOException e2) {
            AppMethodBeat.o(73360);
        }
    }
}
