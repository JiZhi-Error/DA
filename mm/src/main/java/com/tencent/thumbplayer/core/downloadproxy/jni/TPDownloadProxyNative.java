package com.tencent.thumbplayer.core.downloadproxy.jni;

import android.content.Context;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.api.TPPlayerMgr;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyLogListener;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyNativeLibLoader;
import com.tencent.thumbplayer.core.downloadproxy.apiinner.TPListenerManager;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyLog;
import com.tencent.thumbplayer.core.downloadproxy.utils.TPDLProxyUtils;

public class TPDownloadProxyNative {
    private static final String FILE_NAME = "TPDownloadProxyNative";
    private static Context appContext = null;
    private static boolean isLoadDownloadProxySucceed = false;
    private ITPDLProxyNativeLibLoader mLibLoader;

    public native int createDownloadTask(int i2, String str, int i3, int i4);

    public native int deInitService(int i2);

    public native int deleteCache(String str, String str2);

    public native byte[] getClipPlayUrl(int i2, int i3, int i4);

    public native byte[] getErrorCodeStr(int i2);

    public native byte[] getHLSOfflineExttag(String str, String str2, int i2, long j2);

    public native byte[] getNativeInfo(String str);

    public native byte[] getVersion();

    public native int initService(int i2, String str, String str2, String str3);

    public native boolean isNativeReadyForWork();

    public native int pauseDownload(int i2);

    public native void pushEvent(int i2);

    public native int resumeDownload(int i2);

    public native int setClipInfo(int i2, int i3, String str, int i4, String str2, String str3, String str4);

    public native int setMaxStorageSizeMB(int i2, long j2);

    public native void setPlayerState(int i2, int i3);

    public native void setUserData(String str, String str2);

    public native int startDownload(int i2);

    public native int stopAllDownload(int i2);

    public native int stopDownload(int i2);

    public native void updatePlayerPlayMsg(int i2, int i3, int i4, int i5);

    public native int updateStoragePath(int i2, String str);

    public native long verifyOfflineCacheSync(String str, int i2, String str2, String str3);

    private TPDownloadProxyNative() {
    }

    /* access modifiers changed from: package-private */
    public static class SingletonHolder {
        private static final TPDownloadProxyNative INSTANCE = new TPDownloadProxyNative();

        private SingletonHolder() {
        }

        static {
            AppMethodBeat.i(210025);
            AppMethodBeat.o(210025);
        }
    }

    public static TPDownloadProxyNative getInstance() {
        AppMethodBeat.i(210026);
        TPDownloadProxyNative tPDownloadProxyNative = SingletonHolder.INSTANCE;
        AppMethodBeat.o(210026);
        return tPDownloadProxyNative;
    }

    private static void nativeMessageCallback(int i2, int i3, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        AppMethodBeat.i(210027);
        TPListenerManager.getInstance().handleCallbackMessage(i2, i3, obj, obj2, obj3, obj4, obj5);
        AppMethodBeat.o(210027);
    }

    private static int nativeIntMessageCallback(int i2, int i3, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        AppMethodBeat.i(210028);
        int handleIntCallbackMessage = TPListenerManager.getInstance().handleIntCallbackMessage(i2, i3, obj, obj2, obj3, obj4, obj5);
        AppMethodBeat.o(210028);
        return handleIntCallbackMessage;
    }

    private static String nativeStringMessageCallback(int i2, int i3, Object obj, Object obj2, Object obj3, Object obj4, Object obj5) {
        AppMethodBeat.i(210029);
        String handleStringCallbackMessage = TPListenerManager.getInstance().handleStringCallbackMessage(i2, i3, obj, obj2, obj3, obj4, obj5);
        AppMethodBeat.o(210029);
        return handleStringCallbackMessage;
    }

    private static void nativeLogCallback(int i2, byte[] bArr, int i3, byte[] bArr2, byte[] bArr3) {
        AppMethodBeat.i(210030);
        if (i2 == 6) {
            TPDLProxyLog.e(TPDLProxyUtils.byteArrayToString(bArr), i3, TPDLProxyUtils.byteArrayToString(bArr2), TPDLProxyUtils.byteArrayToString(bArr3));
            AppMethodBeat.o(210030);
        } else if (i2 == 5) {
            TPDLProxyLog.w(TPDLProxyUtils.byteArrayToString(bArr), i3, TPDLProxyUtils.byteArrayToString(bArr2), TPDLProxyUtils.byteArrayToString(bArr3));
            AppMethodBeat.o(210030);
        } else if (i2 == 4 || i2 != 3) {
            TPDLProxyLog.i(TPDLProxyUtils.byteArrayToString(bArr), i3, TPDLProxyUtils.byteArrayToString(bArr2), TPDLProxyUtils.byteArrayToString(bArr3));
            AppMethodBeat.o(210030);
        } else {
            TPDLProxyLog.d(TPDLProxyUtils.byteArrayToString(bArr), i3, TPDLProxyUtils.byteArrayToString(bArr2), TPDLProxyUtils.byteArrayToString(bArr3));
            AppMethodBeat.o(210030);
        }
    }

    public boolean isNativeLoaded() {
        AppMethodBeat.i(210031);
        if (!isLoadDownloadProxySucceed) {
            try {
                if (this.mLibLoader != null) {
                    isLoadDownloadProxySucceed = this.mLibLoader.loadLib(TPPlayerMgr.TP_DOWNLOAD_PROXY_MODULE_NAME, getNativeVersion());
                    TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "third module so load ret:" + (isLoadDownloadProxySucceed ? AppEventsConstants.EVENT_PARAM_VALUE_NO : "1"));
                }
            } catch (Throwable th) {
                isLoadDownloadProxySucceed = false;
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "third module so load failed, error:" + th.toString());
            }
            try {
                if (!isLoadDownloadProxySucceed) {
                    System.loadLibrary(TPPlayerMgr.TP_DOWNLOAD_PROXY_MODULE_NAME);
                    isLoadDownloadProxySucceed = true;
                    TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "system so load success!");
                }
            } catch (Throwable th2) {
                isLoadDownloadProxySucceed = false;
                TPDLProxyLog.e(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "system so load failed, error:" + th2.toString());
            }
        }
        boolean z = isLoadDownloadProxySucceed;
        AppMethodBeat.o(210031);
        return z;
    }

    public String getNativeVersion() {
        AppMethodBeat.i(210032);
        String str = "2.10.0.00056";
        if (isLoadDownloadProxySucceed) {
            str = TPDLProxyUtils.byteArrayToString(getVersion());
        }
        TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "get native version:".concat(String.valueOf(str)));
        AppMethodBeat.o(210032);
        return str;
    }

    public void setLibLoader(ITPDLProxyNativeLibLoader iTPDLProxyNativeLibLoader) {
        AppMethodBeat.i(210033);
        TPDLProxyLog.i(FILE_NAME, 0, ITPDLProxyLogListener.COMMON_TAG, "set third module so loader!!!");
        this.mLibLoader = iTPDLProxyNativeLibLoader;
        AppMethodBeat.o(210033);
    }

    public void setAppContext(Context context) {
        appContext = context;
    }

    public boolean isReadyForWork() {
        AppMethodBeat.i(210034);
        if (isLoadDownloadProxySucceed) {
            boolean isNativeReadyForWork = isNativeReadyForWork();
            AppMethodBeat.o(210034);
            return isNativeReadyForWork;
        }
        AppMethodBeat.o(210034);
        return false;
    }
}
