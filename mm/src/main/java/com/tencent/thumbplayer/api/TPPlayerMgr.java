package com.tencent.thumbplayer.api;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.thumbplayer.core.common.ITPNativeLibraryExternalLoader;
import com.tencent.thumbplayer.core.common.ITPNativeLogCallback;
import com.tencent.thumbplayer.core.common.TPNativeLibraryLoader;
import com.tencent.thumbplayer.core.common.TPNativeLog;
import com.tencent.thumbplayer.core.common.TPThumbplayerCapabilityHelper;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyNativeLibLoader;
import com.tencent.thumbplayer.core.downloadproxy.api.ITPProxyAdapter;
import com.tencent.thumbplayer.core.downloadproxy.api.TPDownloadProxyHelper;
import com.tencent.thumbplayer.d.a;
import com.tencent.thumbplayer.utils.TPNetworkChangeMonitor;
import com.tencent.thumbplayer.utils.e;
import com.tencent.thumbplayer.utils.g;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class TPPlayerMgr {
    public static final String BEACON_LOG_HOST_KEY = "beacon_log_host";
    public static final String BEACON_PLYAER_HOST_KEY = "player_host_config";
    public static final String BEACON_POLICY_HOST_KEY = "beacon_policy_host";
    public static final int EVENT_ID_APP_ENTER_BACKGROUND = 100001;
    public static final int EVENT_ID_APP_ENTER_FOREGROUND = 100002;
    private static final String TAG = "TPThumbPlayer[TPPlayerMgr.java]";
    public static final String TP_DOWNLOAD_PROXY_MODULE_NAME = "DownloadProxy";
    public static final String TP_PLAYERCORE_MODULE_NAME = "TPCore";
    private static boolean isInit;
    private static Context mAppContext;

    @Retention(RetentionPolicy.SOURCE)
    public @interface EventId {
    }

    public interface OnLogListener {
        int d(String str, String str2);

        int e(String str, String str2);

        int i(String str, String str2);

        int v(String str, String str2);

        int w(String str, String str2);
    }

    public static void initSdk(Context context, String str, int i2) {
        AppMethodBeat.i(189030);
        if (!isInit) {
            g.i(TAG, "Enter initSdk");
            isInit = true;
            mAppContext = context.getApplicationContext();
            a.setGuid(str);
            a.setPlatform(i2);
            TPNetworkChangeMonitor.hop().init(mAppContext);
            g.i(TAG, "Enter initSdk for monitor");
            g.i(TAG, "Enter initSdk for report");
            TPNativeLog.setLogCallback(new ITPNativeLogCallback() {
                /* class com.tencent.thumbplayer.api.TPPlayerMgr.AnonymousClass1 */

                /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                @Override // com.tencent.thumbplayer.core.common.ITPNativeLogCallback
                public final void onPrintLog(int i2, String str, String str2) {
                    AppMethodBeat.i(189027);
                    switch (i2) {
                        case 0:
                            g.v(str, str2);
                            AppMethodBeat.o(189027);
                            return;
                        case 1:
                            g.d(str, str2);
                            AppMethodBeat.o(189027);
                            return;
                        case 2:
                            g.i(str, str2);
                            AppMethodBeat.o(189027);
                            return;
                        case 3:
                            g.w(str, str2);
                            AppMethodBeat.o(189027);
                            return;
                        case 4:
                            g.e(str, str2);
                            break;
                    }
                    AppMethodBeat.o(189027);
                }
            });
            try {
                TPNativeLibraryLoader.loadLibIfNeeded(mAppContext);
            } catch (UnsupportedOperationException e2) {
                g.e(TAG, e2);
            }
            g.i(TAG, "Enter initSdk for loadlib");
            com.tencent.thumbplayer.a.a.b.a.init(mAppContext);
            g.i(TAG, "Enter initSdk for drm cap");
            TPThumbplayerCapabilityHelper.init(mAppContext, true);
            g.i(TAG, "Enter initSdk DONE");
        }
        AppMethodBeat.o(189030);
    }

    public static void setHost(String str) {
        AppMethodBeat.i(189031);
        a.bqy(str);
        AppMethodBeat.o(189031);
    }

    public static void setDebugEnable(boolean z) {
        AppMethodBeat.i(189032);
        a.setDebugEnable(z);
        AppMethodBeat.o(189032);
    }

    public static void setOnLogListener(OnLogListener onLogListener) {
        AppMethodBeat.i(189033);
        g.setOnLogListener(onLogListener);
        AppMethodBeat.o(189033);
    }

    public static void setProxyEnable(boolean z) {
        AppMethodBeat.i(189034);
        a.DT(z);
        AppMethodBeat.o(189034);
    }

    public static boolean isProxyEnable() {
        AppMethodBeat.i(189035);
        if (!a.hnj() || !TPDownloadProxyHelper.isReadyForPlay()) {
            AppMethodBeat.o(189035);
            return false;
        }
        AppMethodBeat.o(189035);
        return true;
    }

    public static void setUserInfo(String str, boolean z) {
        AppMethodBeat.i(189036);
        a.bqz(str);
        a.DU(z);
        AppMethodBeat.o(189036);
    }

    public static void setUpcInfo(String str, int i2) {
        AppMethodBeat.i(189037);
        a.bqA(str);
        a.arn(i2);
        e.g(100003, i2, 0, str);
        AppMethodBeat.o(189037);
    }

    public static void setOutNetIP(String str) {
        AppMethodBeat.i(189038);
        a.bqB(str);
        AppMethodBeat.o(189038);
    }

    public static void setProxyServiceType(int i2) {
        AppMethodBeat.i(189039);
        a.setProxyServiceType(i2);
        AppMethodBeat.o(189039);
    }

    public static boolean isThumbPlayerEnable() {
        AppMethodBeat.i(189040);
        boolean isLibLoaded = TPNativeLibraryLoader.isLibLoaded();
        AppMethodBeat.o(189040);
        return isLibLoaded;
    }

    public static void postEvent(int i2, int i3, int i4, Object obj) {
        AppMethodBeat.i(189041);
        e.g(i2, i3, i4, obj);
        AppMethodBeat.o(189041);
    }

    public static void setLibLoader(final ITPModuleLoader iTPModuleLoader) {
        AppMethodBeat.i(189042);
        if (isInit) {
            IllegalStateException illegalStateException = new IllegalStateException("player has init");
            AppMethodBeat.o(189042);
            throw illegalStateException;
        }
        TPNativeLibraryLoader.setLibLoader(new ITPNativeLibraryExternalLoader() {
            /* class com.tencent.thumbplayer.api.TPPlayerMgr.AnonymousClass2 */

            @Override // com.tencent.thumbplayer.core.common.ITPNativeLibraryExternalLoader
            public final boolean loadLib(String str, String str2) {
                AppMethodBeat.i(189028);
                if (iTPModuleLoader != null) {
                    try {
                        iTPModuleLoader.loadLibrary(str, str2);
                        AppMethodBeat.o(189028);
                        return true;
                    } catch (Throwable th) {
                        g.e(TPPlayerMgr.TAG, th);
                    }
                }
                AppMethodBeat.o(189028);
                return false;
            }
        });
        TPDownloadProxyHelper.setNativeLibLoader(new ITPDLProxyNativeLibLoader() {
            /* class com.tencent.thumbplayer.api.TPPlayerMgr.AnonymousClass3 */

            @Override // com.tencent.thumbplayer.core.downloadproxy.api.ITPDLProxyNativeLibLoader
            public final boolean loadLib(String str, String str2) {
                AppMethodBeat.i(189029);
                if (iTPModuleLoader != null) {
                    try {
                        iTPModuleLoader.loadLibrary(str, str2);
                        AppMethodBeat.o(189029);
                        return true;
                    } catch (Throwable th) {
                        g.e(TPPlayerMgr.TAG, th);
                    }
                }
                AppMethodBeat.o(189029);
                return false;
            }
        });
        AppMethodBeat.o(189042);
    }

    public static void setTPProxyAdapter(ITPProxyAdapter iTPProxyAdapter) {
        AppMethodBeat.i(189043);
        TPDownloadProxyHelper.setTPProxyAdapter(iTPProxyAdapter);
        AppMethodBeat.o(189043);
    }

    public static String getLibVersion(String str) {
        AppMethodBeat.i(189044);
        if (!isInit) {
            IllegalStateException illegalStateException = new IllegalStateException("player not initialized");
            AppMethodBeat.o(189044);
            throw illegalStateException;
        }
        if (!TextUtils.isEmpty(str)) {
            if (str.equals(TP_DOWNLOAD_PROXY_MODULE_NAME)) {
                String nativeLibVersion = TPDownloadProxyHelper.getNativeLibVersion();
                AppMethodBeat.o(189044);
                return nativeLibVersion;
            } else if (str.equals(TP_PLAYERCORE_MODULE_NAME)) {
                String libVersion = TPNativeLibraryLoader.getLibVersion();
                AppMethodBeat.o(189044);
                return libVersion;
            }
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("libName:".concat(String.valueOf(str)));
        AppMethodBeat.o(189044);
        throw illegalArgumentException;
    }

    public static Context getAppContext() {
        return mAppContext;
    }

    public static String getThumbPlayerVersion() {
        return "2.9.0.1112";
    }
}
