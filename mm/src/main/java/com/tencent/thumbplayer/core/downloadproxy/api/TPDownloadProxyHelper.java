package com.tencent.thumbplayer.core.downloadproxy.api;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.downloadproxy.jni.TPDownloadProxyNative;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyUtils;

public class TPDownloadProxyHelper {
    private static final String FILE_NAME = "TPDownloadProxyHelper";
    private static Context applicationContext;
    private static ITPOfflineVinfoAdapter offlineVinfoAdapter = null;

    public static void setContext(Context context) {
        applicationContext = context;
    }

    public static Context getContext() {
        return applicationContext;
    }

    public static void setUseService(boolean z) {
        AppMethodBeat.i(209935);
        TPDownloadProxyFactory.setUseService(z);
        AppMethodBeat.o(209935);
    }

    public static void setNativeLibLoader(ITPDLProxyNativeLibLoader iTPDLProxyNativeLibLoader) {
        AppMethodBeat.i(209936);
        TPDownloadProxyNative.getInstance().setLibLoader(iTPDLProxyNativeLibLoader);
        AppMethodBeat.o(209936);
    }

    public static String getNativeLibVersion() {
        AppMethodBeat.i(209937);
        String nativeVersion = TPDownloadProxyFactory.getNativeVersion();
        AppMethodBeat.o(209937);
        return nativeVersion;
    }

    public static boolean isReadyForPlay() {
        AppMethodBeat.i(209938);
        boolean isReadyForPlay = TPDownloadProxyFactory.isReadyForPlay();
        AppMethodBeat.o(209938);
        return isReadyForPlay;
    }

    public static void setTPOfflineVinfoAdapter(ITPOfflineVinfoAdapter iTPOfflineVinfoAdapter) {
        offlineVinfoAdapter = iTPOfflineVinfoAdapter;
    }

    public static String checkVideoStatus(String str, String str2) {
        AppMethodBeat.i(209939);
        if (!TPDownloadProxyFactory.canUseService()) {
            AppMethodBeat.o(209939);
            return "";
        } else if (offlineVinfoAdapter != null) {
            String checkVideoStatus = offlineVinfoAdapter.checkVideoStatus(str, str2);
            AppMethodBeat.o(209939);
            return checkVideoStatus;
        } else {
            AppMethodBeat.o(209939);
            return "";
        }
    }

    public static int getRecordDuration(String str, String str2) {
        AppMethodBeat.i(209940);
        if (offlineVinfoAdapter != null) {
            int recordDuration = offlineVinfoAdapter.getRecordDuration(str, str2);
            AppMethodBeat.o(209940);
            return recordDuration;
        }
        AppMethodBeat.o(209940);
        return -1;
    }

    public static void setTPProxyAdapter(ITPProxyAdapter iTPProxyAdapter) {
    }

    public static String getHLSOfflineExttag(String str, String str2, int i2, long j2) {
        AppMethodBeat.i(209941);
        try {
            if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
                String byteArrayToString = TPDLProxyUtils.byteArrayToString(TPDownloadProxyNative.getInstance().getHLSOfflineExttag(str, str2, i2, j2));
                AppMethodBeat.o(209941);
                return byteArrayToString;
            }
        } catch (Throwable th) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "get exttag failed, error:" + th.toString());
        }
        AppMethodBeat.o(209941);
        return "";
    }

    public static long verifyOfflineCacheSync(String str, int i2, String str2, String str3) {
        AppMethodBeat.i(209942);
        try {
            if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
                long verifyOfflineCacheSync = TPDownloadProxyNative.getInstance().verifyOfflineCacheSync(str, i2, str2, str3);
                AppMethodBeat.o(209942);
                return verifyOfflineCacheSync;
            }
        } catch (Throwable th) {
            TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "verify offline cache failed, error:" + th.toString());
        }
        AppMethodBeat.o(209942);
        return -1;
    }

    public static void setUserData(String str, Object obj) {
        AppMethodBeat.i(209943);
        if (TPDownloadProxyNative.getInstance().isNativeLoaded()) {
            try {
                TPDownloadProxyNative.getInstance().setUserData(str, obj.toString());
                AppMethodBeat.o(209943);
                return;
            } catch (Throwable th) {
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "setUserData failed, error:" + th.toString());
            }
        }
        AppMethodBeat.o(209943);
    }
}
