package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.util.Log;
import android.webkit.ValueCallback;
import com.facebook.internal.ServerProtocol;
import com.google.android.gms.common.internal.ImagesContract;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.g;
import com.tencent.smtt.export.external.TbsCoreSettings;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.sandbox.SandboxListener;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsDownloadUpload;
import com.tencent.smtt.sdk.TbsDownloader;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.TbsLogReport;
import com.tencent.smtt.sdk.c.c;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.TbsLogClient;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.f;
import com.tencent.smtt.utils.m;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@SuppressLint({"NewApi"})
public class QbSdk {
    private static boolean A = false;
    public static final int ERRORCODE_MINIQBREADER_CONTEXTISNULL = -100;
    public static final int ERRORCODE_MINIQBREADER_ISOVERSEA = -103;
    public static final int ERRORCODE_MINIQBREADER_REFLECTFAILED = -104;
    public static final int ERRORCODE_MINIQBREADER_REFUSE = -101;
    public static final int ERRORCODE_MINIQBREADER_X5COREINITFAILED = -102;
    public static String KEY_SET_SENDREQUEST_AND_UPLOAD = "SET_SENDREQUEST_AND_UPLOAD";
    public static final String LOGIN_TYPE_KEY_PARTNER_CALL_POS = "PosID";
    public static final String LOGIN_TYPE_KEY_PARTNER_ID = "ChannelID";
    public static final String PARAM_KEY_FEATUREID = "param_key_featureid";
    public static final String PARAM_KEY_FUNCTIONID = "param_key_functionid";
    public static final String PARAM_KEY_POSITIONID = "param_key_positionid";
    public static final int QBMODE = 2;
    public static final String SVNVERSION = "jnizz";
    public static final int TBSMODE = 1;
    public static final String TID_QQNumber_Prefix = "QQ:";
    public static final int VERSION = 1;

    /* renamed from: a  reason: collision with root package name */
    static boolean f1702a = false;

    /* renamed from: b  reason: collision with root package name */
    static boolean f1703b = false;

    /* renamed from: c  reason: collision with root package name */
    static boolean f1704c = true;

    /* renamed from: d  reason: collision with root package name */
    static boolean f1705d = false;

    /* renamed from: e  reason: collision with root package name */
    static long f1706e = 0;

    /* renamed from: f  reason: collision with root package name */
    static long f1707f = 0;

    /* renamed from: g  reason: collision with root package name */
    static Object f1708g = new Object();

    /* renamed from: h  reason: collision with root package name */
    static boolean f1709h = true;

    /* renamed from: i  reason: collision with root package name */
    static boolean f1710i = true;

    /* renamed from: j  reason: collision with root package name */
    static boolean f1711j = false;
    static volatile boolean k = f1702a;
    static TbsListener l = new TbsListener() {
        /* class com.tencent.smtt.sdk.QbSdk.AnonymousClass6 */

        @Override // com.tencent.smtt.sdk.TbsListener
        public final void onDownloadFinish(int i2) {
            boolean z = true;
            AppMethodBeat.i(54622);
            if (TbsDownloader.needDownloadDecoupleCore()) {
                TbsLog.i("QbSdk", "onDownloadFinish needDownloadDecoupleCore is true", true);
                TbsDownloader.f1796a = true;
                AppMethodBeat.o(54622);
                return;
            }
            TbsLog.i("QbSdk", "onDownloadFinish needDownloadDecoupleCore is false", true);
            TbsDownloader.f1796a = false;
            if (i2 != 100) {
                z = false;
            }
            new StringBuilder("downloadX5 -> isSuccess:").append(z).append(",code:").append(i2);
            if (QbSdk.x != null) {
                QbSdk.x.onDownloadFinish(i2);
            }
            if (QbSdk.y != null) {
                QbSdk.y.onDownloadFinish(i2);
            }
            AppMethodBeat.o(54622);
        }

        @Override // com.tencent.smtt.sdk.TbsListener
        public final void onInstallFinish(int i2) {
            boolean z;
            AppMethodBeat.i(54623);
            if (i2 == 200 || i2 == 220) {
                z = true;
            } else {
                z = false;
            }
            new StringBuilder("installX5 -> isSuccess:").append(z).append(",code:").append(i2);
            QbSdk.setTBSInstallingStatus(false);
            TbsDownloader.f1796a = false;
            if (TbsDownloader.startDecoupleCoreIfNeeded()) {
                TbsDownloader.f1796a = true;
            } else {
                TbsDownloader.f1796a = false;
            }
            if (QbSdk.x != null) {
                QbSdk.x.onInstallFinish(i2);
            }
            if (QbSdk.y != null) {
                QbSdk.y.onInstallFinish(i2);
            }
            AppMethodBeat.o(54623);
        }

        @Override // com.tencent.smtt.sdk.TbsListener
        public final void onDownloadProgress(int i2) {
            AppMethodBeat.i(54624);
            if (QbSdk.y != null) {
                QbSdk.y.onDownloadProgress(i2);
            }
            if (QbSdk.x != null) {
                QbSdk.x.onDownloadProgress(i2);
            }
            AppMethodBeat.o(54624);
        }
    };
    private static boolean m = true;
    public static boolean mDisableUseHostBackupCore = false;
    public static Map<String, Object> mSettings = null;
    private static boolean n = false;
    private static String o = "NULL";
    private static String p = "UNKNOWN";
    private static boolean q = false;
    private static int r = 0;
    private static int s = TbsListener.ErrorCode.NEEDDOWNLOAD_TRUE;
    public static boolean sIsVersionPrinted = false;
    private static String t = null;
    private static String u = null;
    private static boolean v = false;
    private static boolean w = true;
    private static TbsListener x = null;
    private static TbsListener y = null;
    private static boolean z = false;

    public interface PreInitCallback {
        void onCoreInitFinished();

        void onViewInitFinished(boolean z);
    }

    static {
        AppMethodBeat.i(55430);
        AppMethodBeat.o(55430);
    }

    public static String getLibraryPath() {
        AppMethodBeat.i(55372);
        String libraryPath = TbsOneGreyInfoHelper.getSDKExtensionEntry().getLibraryPath();
        AppMethodBeat.o(55372);
        return libraryPath;
    }

    public static boolean startQBToLoadurl(Context context, String str, int i2, WebView webView) {
        x a2;
        Object invokeStaticMethod;
        IX5WebViewBase iX5WebViewBase;
        AppMethodBeat.i(55373);
        HashMap hashMap = new HashMap();
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationInfo().processName);
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, Integer.toString(i2));
        if (webView == null) {
            try {
                String str2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
                if (!((str2 != "com.tencent.mm" && str2 != TbsConfig.APP_QQ) || (a2 = x.a()) == null || !a2.b() || (invokeStaticMethod = a2.c().a().invokeStaticMethod("com.tencent.smtt.webkit.WebViewList", "getCurrentMainWebviewJustForQQandWechat", new Class[0], new Object[0])) == null || (iX5WebViewBase = (IX5WebViewBase) invokeStaticMethod) == null)) {
                    webView = (WebView) iX5WebViewBase.getView().getParent();
                }
            } catch (Exception e2) {
            }
        }
        if (c.a(context, str, hashMap, "QbSdk.startQBToLoadurl", webView) == 0) {
            AppMethodBeat.o(55373);
            return true;
        }
        AppMethodBeat.o(55373);
        return false;
    }

    public static boolean startQBForVideo(Context context, String str, int i2) {
        AppMethodBeat.i(55374);
        HashMap hashMap = new HashMap();
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationInfo().processName);
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, Integer.toString(i2));
        boolean a2 = c.a(context, str, hashMap);
        AppMethodBeat.o(55374);
        return a2;
    }

    public static boolean startQBForDoc(Context context, String str, int i2, int i3, String str2, Bundle bundle) {
        AppMethodBeat.i(55375);
        HashMap hashMap = new HashMap();
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationContext().getApplicationInfo().processName);
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, Integer.toString(i2));
        boolean a2 = c.a(context, str, i3, str2, hashMap, bundle);
        AppMethodBeat.o(55375);
        return a2;
    }

    public static boolean getIsSysWebViewForcedByOuter() {
        return f1703b;
    }

    @SuppressLint({"NewApi"})
    static boolean a(Context context, boolean z2) {
        AppMethodBeat.i(55376);
        TbsLog.initIfNeed(context);
        TbsLog.d("QbSdk", "QbSdk-init currentProcessId=" + Process.myPid());
        TbsLog.d("QbSdk", "QbSdk-init currentThreadName=" + Thread.currentThread().getName());
        if (!sIsVersionPrinted) {
            TbsLog.i("QbSdk", "svn revision: jnizz; SDK_VERSION_CODE: 43809; SDK_VERSION_NAME: 4.4.0.0006");
            sIsVersionPrinted = true;
        }
        if (f1702a && !z2) {
            TbsLog.e("QbSdk", "QbSdk init: " + p, false);
            TbsCoreLoadStat.getInstance().setLoadErrorCode(context, 414, new Throwable(p));
            AppMethodBeat.o(55376);
            return false;
        } else if (f1703b) {
            TbsLog.e("QbSdk", "QbSdk init mIsSysWebViewForcedByOuter = true", true);
            TbsCoreLoadStat.getInstance().setLoadErrorCode(context, 402, new Throwable(o));
            AppMethodBeat.o(55376);
            return false;
        } else {
            if (!w) {
                b(context);
            }
            boolean init = TbsOneGreyInfoHelper.getSDKExtensionEntry().init(context);
            AppMethodBeat.o(55376);
            return init;
        }
    }

    public static boolean canLoadX5FirstTimeThirdApp(Context context) {
        AppMethodBeat.i(55377);
        TbsLog.d("QbSdk", "canLoadX5FirstTimeThirdApp");
        boolean canLoadX5FirstTimeThirdApp = TbsOneGreyInfoHelper.getSDKExtensionEntry().canLoadX5FirstTimeThirdApp(context);
        AppMethodBeat.o(55377);
        return canLoadX5FirstTimeThirdApp;
    }

    public static void setOnlyDownload(boolean z2) {
        f1711j = z2;
    }

    public static boolean getOnlyDownload() {
        return f1711j;
    }

    static boolean a(Context context) {
        SharedPreferences sharedPreferences;
        AppMethodBeat.i(55378);
        if (context == null) {
            AppMethodBeat.o(55378);
            return false;
        }
        try {
            if (context.getApplicationInfo().packageName.contains("com.tencent.portfolio")) {
                TbsLog.i("QbSdk", "clearPluginConfigFile #1");
                String string = TbsDownloadConfig.getInstance(context).mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONNAME, null);
                String str = context.getPackageManager().getPackageInfo("com.tencent.portfolio", 0).versionName;
                TbsLog.i("QbSdk", "clearPluginConfigFile oldAppVersionName is " + string + " newAppVersionName is " + str);
                if (!(string == null || string.contains(str) || (sharedPreferences = context.getSharedPreferences("plugin_setting", 0)) == null)) {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.clear();
                    edit.commit();
                    TbsLog.i("QbSdk", "clearPluginConfigFile done");
                }
            }
            AppMethodBeat.o(55378);
            return true;
        } catch (Throwable th) {
            TbsLog.i("QbSdk", "clearPluginConfigFile error is " + th.getMessage());
            AppMethodBeat.o(55378);
            return false;
        }
    }

    static Bundle a(Context context, Bundle bundle) {
        AppMethodBeat.i(55379);
        Bundle incrUpdate = TbsOneGreyInfoHelper.getSDKExtensionEntry().incrUpdate(context, bundle);
        AppMethodBeat.o(55379);
        return incrUpdate;
    }

    static boolean a(Context context, int i2) {
        AppMethodBeat.i(55380);
        boolean a2 = a(context, i2, (int) g.sHCENCODEVIDEOTIMEOUT);
        AppMethodBeat.o(55380);
        return a2;
    }

    static boolean a(Context context, int i2, int i3) {
        AppMethodBeat.i(55381);
        boolean isX5Disabled = TbsOneGreyInfoHelper.getSDKExtensionEntry().isX5Disabled(context, i2, i3);
        AppMethodBeat.o(55381);
        return isX5Disabled;
    }

    public static boolean canLoadX5(Context context) {
        AppMethodBeat.i(55382);
        boolean a2 = a(context, false, false);
        AppMethodBeat.o(55382);
        return a2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v16, types: [java.io.FileInputStream, java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r0v26, types: [java.util.Properties] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f7 A[SYNTHETIC, Splitter:B:40:0x00f7] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0103 A[SYNTHETIC, Splitter:B:46:0x0103] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x014b A[SYNTHETIC, Splitter:B:68:0x014b] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0157 A[SYNTHETIC, Splitter:B:76:0x0157] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x015e  */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean canOpenWebPlus(android.content.Context r10) {
        /*
        // Method dump skipped, instructions count: 387
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.QbSdk.canOpenWebPlus(android.content.Context):boolean");
    }

    public static boolean isX5DisabledSync(Context context) {
        AppMethodBeat.i(55384);
        boolean isX5DisabledSync = TbsOneGreyInfoHelper.getSDKExtensionEntry().isX5DisabledSync(context);
        AppMethodBeat.o(55384);
        return isX5DisabledSync;
    }

    public static void setTbsLogClient(TbsLogClient tbsLogClient) {
        AppMethodBeat.i(55385);
        TbsLog.setTbsLogClient(tbsLogClient);
        AppMethodBeat.o(55385);
    }

    public static boolean installLocalQbApk(Context context, String str, String str2, Bundle bundle) {
        AppMethodBeat.i(55386);
        if (TbsOneGreyInfoHelper.isTbsAvailable(context)) {
            boolean installLocalQbApk = TbsOneGreyInfoHelper.getCoreEntry().getX5CoreMessy().installLocalQbApk(context, str, str2, bundle);
            AppMethodBeat.o(55386);
            return installLocalQbApk;
        }
        AppMethodBeat.o(55386);
        return false;
    }

    public static boolean canUseVideoFeatrue(Context context, int i2) {
        AppMethodBeat.i(55387);
        boolean canUseVideoFeatrue = TbsOneGreyInfoHelper.getSDKExtensionEntry().canUseVideoFeatrue(context, i2);
        AppMethodBeat.o(55387);
        return canUseVideoFeatrue;
    }

    public static boolean canLoadVideo(Context context) {
        AppMethodBeat.i(55388);
        boolean canLoadVideo = TbsOneGreyInfoHelper.getSDKExtensionEntry().canLoadVideo(context);
        AppMethodBeat.o(55388);
        return canLoadVideo;
    }

    static boolean a(Context context, boolean z2, boolean z3) {
        AppMethodBeat.i(55389);
        boolean canLoadX5 = TbsOneGreyInfoHelper.getSDKExtensionEntry().canLoadX5(context, z2, z3);
        AppMethodBeat.o(55389);
        return canLoadX5;
    }

    public static boolean canOpenMimeFileType(Context context, String str) {
        AppMethodBeat.i(55390);
        if (!a(context, false)) {
            AppMethodBeat.o(55390);
        } else {
            AppMethodBeat.o(55390);
        }
        return false;
    }

    public static void setCurrentID(String str) {
        AppMethodBeat.i(55391);
        if (str == null) {
            AppMethodBeat.o(55391);
            return;
        }
        if (str.startsWith(TID_QQNumber_Prefix)) {
            String substring = str.substring(3);
            t = "0000000000000000".substring(substring.length()) + substring;
        }
        AppMethodBeat.o(55391);
    }

    public static String getTID() {
        return t;
    }

    public static String getTbsResourcesPath(Context context) {
        AppMethodBeat.i(55392);
        String g2 = TbsShareManager.g(context);
        AppMethodBeat.o(55392);
        return g2;
    }

    public static void setQQBuildNumber(String str) {
        u = str;
    }

    public static String getQQBuildNumber() {
        return u;
    }

    static synchronized void a(Context context, String str) {
        synchronized (QbSdk.class) {
            AppMethodBeat.i(55393);
            if (f1702a) {
                TbsLog.d("QbSdk", "already forced: " + p);
                AppMethodBeat.o(55393);
            } else {
                f1702a = true;
                p = "forceSysWebViewInner: ".concat(String.valueOf(str));
                TbsLog.e("QbSdk", "QbSdk.SysWebViewForcedInner..." + p);
                TbsCoreLoadStat.getInstance().setLoadErrorCode(context, 401, new Throwable(p));
                AppMethodBeat.o(55393);
            }
        }
    }

    public static void forceSysWebView() {
        AppMethodBeat.i(55394);
        f1703b = true;
        o = "SysWebViewForcedByOuter: " + Log.getStackTraceString(new Throwable());
        TbsLog.e("QbSdk", "sys WebView: SysWebViewForcedByOuter");
        AppMethodBeat.o(55394);
    }

    public static void unForceSysWebView() {
        AppMethodBeat.i(55395);
        f1703b = false;
        TbsLog.e("QbSdk", "sys WebView: unForceSysWebView called");
        AppMethodBeat.o(55395);
    }

    public static void canOpenFile(final Context context, final String str, final ValueCallback<Boolean> valueCallback) {
        AppMethodBeat.i(55396);
        new Thread() {
            /* class com.tencent.smtt.sdk.QbSdk.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(54064);
                final boolean z = false;
                try {
                    if (g.a(true).a(context, null)) {
                        z = TbsOneGreyInfoHelper.getTbsFileInterface(context).a(context, str);
                        if (!z) {
                            TbsLogReport.TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(context).tbsLogInfo();
                            tbsLogInfo.setErrorCode(TbsListener.ErrorCode.INFO_OPEN_FILE_MINIQB_RETURN_CANNOT_OPEN);
                            TbsLogReport.getInstance(context).eventReport(TbsLogReport.EventType.TYPE_SDK_REPORT_INFO, tbsLogInfo);
                        }
                    } else {
                        TbsLogReport.TbsLogInfo tbsLogInfo2 = TbsLogReport.getInstance(context).tbsLogInfo();
                        tbsLogInfo2.setErrorCode(TbsListener.ErrorCode.INFO_OPEN_FILE_TBS_INIT_FAILED);
                        TbsLogReport.getInstance(context).eventReport(TbsLogReport.EventType.TYPE_SDK_REPORT_INFO, tbsLogInfo2);
                    }
                } catch (Throwable th) {
                }
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    /* class com.tencent.smtt.sdk.QbSdk.AnonymousClass1.AnonymousClass1 */

                    public void run() {
                        AppMethodBeat.i(55088);
                        valueCallback.onReceiveValue(Boolean.valueOf(z));
                        AppMethodBeat.o(55088);
                    }
                });
                AppMethodBeat.o(54064);
            }
        }.start();
        AppMethodBeat.o(55396);
    }

    public static void closeFileReader(Context context) {
        AppMethodBeat.i(55397);
        boolean z2 = false;
        try {
            z2 = g.a(true).a(context, null);
        } catch (Throwable th) {
        }
        if (z2) {
            TbsOneGreyInfoHelper.getTbsFileInterface(context).a();
        }
        AppMethodBeat.o(55397);
    }

    public static synchronized void preInit(Context context) {
        synchronized (QbSdk.class) {
            AppMethodBeat.i(55398);
            preInit(context, null);
            AppMethodBeat.o(55398);
        }
    }

    public static void setDisableUseHostBackupCoreBySwitch(boolean z2) {
        AppMethodBeat.i(55399);
        mDisableUseHostBackupCore = z2;
        TbsLog.i("QbSdk", "setDisableUseHostBackupCoreBySwitch -- mDisableUseHostBackupCore is " + mDisableUseHostBackupCore);
        AppMethodBeat.o(55399);
    }

    public static void setDisableUnpreinitBySwitch(boolean z2) {
        AppMethodBeat.i(55400);
        v = z2;
        TbsLog.i("QbSdk", "setDisableUnpreinitBySwitch -- mDisableUnpreinitBySwitch is " + v);
        AppMethodBeat.o(55400);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0028 A[Catch:{ Throwable -> 0x005d, all -> 0x005b }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0038 A[SYNTHETIC, Splitter:B:15:0x0038] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0044 A[SYNTHETIC, Splitter:B:21:0x0044] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004e A[SYNTHETIC, Splitter:B:27:0x004e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getCurrentProcessName(android.content.Context r8) {
        /*
            r1 = 0
            r6 = 256(0x100, float:3.59E-43)
            r0 = 0
            r7 = 55401(0xd869, float:7.7633E-41)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r7)
            java.lang.String r3 = "/proc/self/cmdline"
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch:{ Throwable -> 0x0040, all -> 0x004a }
            r2.<init>(r3)     // Catch:{ Throwable -> 0x0040, all -> 0x004a }
            r3 = 256(0x100, float:3.59E-43)
            byte[] r4 = new byte[r3]     // Catch:{ Throwable -> 0x005d, all -> 0x005b }
            r3 = r0
        L_0x0017:
            int r5 = r2.read()     // Catch:{ Throwable -> 0x005d, all -> 0x005b }
            if (r5 <= 0) goto L_0x0026
            if (r3 >= r6) goto L_0x0026
            int r0 = r3 + 1
            byte r5 = (byte) r5     // Catch:{ Throwable -> 0x005d, all -> 0x005b }
            r4[r3] = r5     // Catch:{ Throwable -> 0x005d, all -> 0x005b }
            r3 = r0
            goto L_0x0017
        L_0x0026:
            if (r3 <= 0) goto L_0x0038
            java.lang.String r0 = new java.lang.String     // Catch:{ Throwable -> 0x005d, all -> 0x005b }
            r5 = 0
            java.lang.String r6 = "UTF-8"
            r0.<init>(r4, r5, r3, r6)     // Catch:{ Throwable -> 0x005d, all -> 0x005b }
            r2.close()     // Catch:{ IOException -> 0x0055 }
        L_0x0034:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r7)
        L_0x0037:
            return r0
        L_0x0038:
            r2.close()     // Catch:{ IOException -> 0x0057 }
        L_0x003b:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r7)
            r0 = r1
            goto L_0x0037
        L_0x0040:
            r0 = move-exception
            r0 = r1
        L_0x0042:
            if (r0 == 0) goto L_0x003b
            r0.close()     // Catch:{ IOException -> 0x0048 }
            goto L_0x003b
        L_0x0048:
            r0 = move-exception
            goto L_0x003b
        L_0x004a:
            r0 = move-exception
            r2 = r1
        L_0x004c:
            if (r2 == 0) goto L_0x0051
            r2.close()     // Catch:{ IOException -> 0x0059 }
        L_0x0051:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r7)
            throw r0
        L_0x0055:
            r1 = move-exception
            goto L_0x0034
        L_0x0057:
            r0 = move-exception
            goto L_0x003b
        L_0x0059:
            r1 = move-exception
            goto L_0x0051
        L_0x005b:
            r0 = move-exception
            goto L_0x004c
        L_0x005d:
            r0 = move-exception
            r0 = r2
            goto L_0x0042
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.QbSdk.getCurrentProcessName(android.content.Context):java.lang.String");
    }

    public static synchronized void preInit(final Context context, final PreInitCallback preInitCallback) {
        synchronized (QbSdk.class) {
            AppMethodBeat.i(55402);
            TbsLog.initIfNeed(context);
            TbsLog.i("QbSdk", "preInit -- processName: " + getCurrentProcessName(context));
            TbsLog.i("QbSdk", "preInit -- stack: " + Log.getStackTraceString(new Throwable("#")));
            k = f1702a;
            if (!n) {
                final AnonymousClass2 r0 = new Handler(Looper.getMainLooper()) {
                    /* class com.tencent.smtt.sdk.QbSdk.AnonymousClass2 */

                    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
                    public final void handleMessage(Message message) {
                        AppMethodBeat.i(55190);
                        switch (message.what) {
                            case 1:
                                boolean unused = QbSdk.v = TbsExtensionFunctionManager.getInstance().canUseFunction(context, TbsExtensionFunctionManager.DISABLE_UNPREINIT);
                                if (QbSdk.f1710i) {
                                    TbsOneGreyInfoHelper.getCoreEntry().createX5WebView(context, false);
                                }
                                if (preInitCallback != null) {
                                    preInitCallback.onViewInitFinished(true);
                                }
                                TbsLog.writeLogToDisk();
                                AppMethodBeat.o(55190);
                                return;
                            case 2:
                                if (preInitCallback != null) {
                                    preInitCallback.onViewInitFinished(false);
                                }
                                TbsLog.writeLogToDisk();
                                AppMethodBeat.o(55190);
                                return;
                            case 3:
                                if (preInitCallback != null) {
                                    preInitCallback.onCoreInitFinished();
                                    break;
                                }
                                break;
                        }
                        AppMethodBeat.o(55190);
                    }
                };
                AnonymousClass3 r2 = new Thread() {
                    /* class com.tencent.smtt.sdk.QbSdk.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(54055);
                        int a2 = q.a().a(true, context);
                        TbsDownloader.setAppContext(context);
                        TbsLog.i("QbSdk", "QbSdk preinit ver is ".concat(String.valueOf(a2)));
                        if (a2 == 0) {
                            q.a().b(context, true);
                        }
                        TbsLog.i("QbSdk", "preInit -- prepare initAndLoadSo");
                        g.a(true).a(context, false, false, null);
                        x a3 = x.a();
                        a3.a(context, null);
                        boolean b2 = a3.b();
                        r0.sendEmptyMessage(3);
                        if (!b2) {
                            r0.sendEmptyMessage(2);
                            AppMethodBeat.o(54055);
                            return;
                        }
                        r0.sendEmptyMessage(1);
                        AppMethodBeat.o(54055);
                    }
                };
                r2.setName("tbs_preinit");
                r2.setPriority(10);
                r2.start();
                n = true;
            }
            AppMethodBeat.o(55402);
        }
    }

    public static void setUploadCode(Context context, int i2) {
        AppMethodBeat.i(55403);
        if (i2 < 130 || i2 > 139) {
            if (i2 >= 150 && i2 <= 159) {
                TbsDownloadUpload instance = TbsDownloadUpload.getInstance(context);
                instance.f1788a.put(TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE, Integer.valueOf(i2));
                instance.commit();
            }
            AppMethodBeat.o(55403);
            return;
        }
        TbsDownloadUpload instance2 = TbsDownloadUpload.getInstance(context);
        instance2.f1788a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, Integer.valueOf(i2));
        instance2.commit();
        AppMethodBeat.o(55403);
    }

    public static void checkTbsValidity(Context context) {
        AppMethodBeat.i(55404);
        if (context == null) {
            AppMethodBeat.o(55404);
            return;
        }
        if (!m.b(context)) {
            TbsLog.e("QbSdk", "sys WebView: SysWebViewForcedBy checkTbsValidity");
            TbsCoreLoadStat.getInstance().setLoadErrorCode(context, 419);
            forceSysWebView();
        }
        AppMethodBeat.o(55404);
    }

    public static void disableAutoCreateX5Webview() {
        f1710i = false;
    }

    public static boolean isTbsCoreInited() {
        AppMethodBeat.i(55405);
        g a2 = g.a(false);
        if (a2 == null || !a2.g()) {
            AppMethodBeat.o(55405);
            return false;
        }
        AppMethodBeat.o(55405);
        return true;
    }

    public static void initX5Environment(final Context context, final PreInitCallback preInitCallback) {
        AppMethodBeat.i(55406);
        if (context == null) {
            TbsLog.e("QbSdk", "initX5Environment,context=null");
            AppMethodBeat.o(55406);
            return;
        }
        a(context);
        y = new TbsListener() {
            /* class com.tencent.smtt.sdk.QbSdk.AnonymousClass4 */

            @Override // com.tencent.smtt.sdk.TbsListener
            public final void onDownloadFinish(int i2) {
            }

            @Override // com.tencent.smtt.sdk.TbsListener
            public final void onInstallFinish(int i2) {
                AppMethodBeat.i(54687);
                QbSdk.preInit(context, preInitCallback);
                AppMethodBeat.o(54687);
            }

            @Override // com.tencent.smtt.sdk.TbsListener
            public final void onDownloadProgress(int i2) {
            }
        };
        if (TbsShareManager.isThirdPartyApp(context)) {
            q.a().b(context, g.f2050a == 0);
        }
        TbsDownloader.needDownload(context, false, false, true, new TbsDownloader.TbsDownloaderCallback() {
            /* class com.tencent.smtt.sdk.QbSdk.AnonymousClass5 */

            @Override // com.tencent.smtt.sdk.TbsDownloader.TbsDownloaderCallback
            public final void onNeedDownloadFinish(boolean z, int i2) {
                AppMethodBeat.i(55027);
                if (TbsShareManager.findCoreForThirdPartyApp(context) == 0 && !TbsShareManager.getCoreDisabled()) {
                    TbsShareManager.forceToLoadX5ForThirdApp(context, false);
                }
                if (QbSdk.f1709h && TbsShareManager.isThirdPartyApp(context)) {
                    TbsExtensionFunctionManager.getInstance().initTbsBuglyIfNeed(context);
                }
                QbSdk.preInit(context, preInitCallback);
                AppMethodBeat.o(55027);
            }
        });
        AppMethodBeat.o(55406);
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0183  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void b(android.content.Context r12) {
        /*
        // Method dump skipped, instructions count: 530
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.QbSdk.b(android.content.Context):void");
    }

    public static int getTbsSdkVersion() {
        return TbsConfig.TBS_SDK_VERSIONCODE;
    }

    public static void setSandboxListener(SandboxListener sandboxListener) {
        AppMethodBeat.i(55408);
        i.a(sandboxListener);
        AppMethodBeat.o(55408);
    }

    public static String replaceLibraryName(String str) {
        AppMethodBeat.i(55409);
        String a2 = i.a(str);
        AppMethodBeat.o(55409);
        return a2;
    }

    public static int getTbsVersion(Context context) {
        AppMethodBeat.i(55410);
        if (TbsShareManager.isThirdPartyApp(context)) {
            int a2 = TbsShareManager.a(context, false);
            AppMethodBeat.o(55410);
            return a2;
        }
        int j2 = q.a().j(context);
        AppMethodBeat.o(55410);
        return j2;
    }

    public static int getTbsVersionForCrash(Context context) {
        AppMethodBeat.i(55411);
        if (TbsShareManager.isThirdPartyApp(context)) {
            int a2 = TbsShareManager.a(context, false);
            AppMethodBeat.o(55411);
            return a2;
        }
        int k2 = q.a().k(context);
        if (k2 == 0 && n.a(context).c() == 3) {
            reset(context);
        }
        AppMethodBeat.o(55411);
        return k2;
    }

    public static String[] getDexLoaderFileList(Context context, Context context2, String str) {
        AppMethodBeat.i(55412);
        String[] dexLoaderFileList = TbsOneGreyInfoHelper.getSDKExtensionEntry().getDexLoaderFileList(context, context2, str);
        AppMethodBeat.o(55412);
        return dexLoaderFileList;
    }

    public static boolean useSoftWare() {
        AppMethodBeat.i(55413);
        boolean useSoftWare = TbsOneGreyInfoHelper.getSDKExtensionEntry().useSoftWare();
        AppMethodBeat.o(55413);
        return useSoftWare;
    }

    public static void setTbsListener(TbsListener tbsListener) {
        x = tbsListener;
    }

    public static void setDownloadWithoutWifi(boolean z2) {
        z = z2;
    }

    public static boolean getDownloadWithoutWifi() {
        return z;
    }

    public static long getApkFileSize(Context context) {
        AppMethodBeat.i(55414);
        if (context != null) {
            long j2 = TbsDownloadConfig.getInstance(context.getApplicationContext()).mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_TBSAPKFILESIZE, 0);
            AppMethodBeat.o(55414);
            return j2;
        }
        AppMethodBeat.o(55414);
        return 0;
    }

    public static void setTBSInstallingStatus(boolean z2) {
        A = z2;
    }

    public static boolean getTBSInstalling() {
        return A;
    }

    public static String getTbsCoreVersionString() {
        AppMethodBeat.i(55415);
        String tbsCoreVersionString = TbsOneGreyInfoHelper.getSDKExtensionEntry().getTbsCoreVersionString();
        AppMethodBeat.o(55415);
        return tbsCoreVersionString;
    }

    public static void reset(Context context) {
        AppMethodBeat.i(55416);
        reset(context, false);
        AppMethodBeat.o(55416);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0031, code lost:
        if (r2 != r3) goto L_0x0033;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void reset(android.content.Context r6, boolean r7) {
        /*
        // Method dump skipped, instructions count: 172
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.QbSdk.reset(android.content.Context, boolean):void");
    }

    public static void resetDecoupleCore(Context context) {
        AppMethodBeat.i(55418);
        TbsLog.e("QbSdk", "QbSdk resetDecoupleCore!", true);
        try {
            f.b(q.a().q(context));
            AppMethodBeat.o(55418);
        } catch (Throwable th) {
            TbsLog.e("QbSdk", "QbSdk resetDecoupleCore exception:" + Log.getStackTraceString(th));
            AppMethodBeat.o(55418);
        }
    }

    public static void clear(Context context) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00d0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void clearAllWebViewCache(android.content.Context r6, boolean r7) {
        /*
        // Method dump skipped, instructions count: 387
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.QbSdk.clearAllWebViewCache(android.content.Context, boolean):void");
    }

    public static int startMiniQBToLoadUrl(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(55420);
        TbsCoreLoadStat.getInstance().setLoadErrorCode(context, 501);
        TbsLog.i("QbSdk", "startMiniQBToLoadUrl,url=" + str + ";args=" + hashMap);
        if (TbsOneGreyInfoHelper.isOneModeAvailable(context) && hashMap != null && ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equals(hashMap.get(ImagesContract.LOCAL))) {
            TbsLog.i("QbSdk", "openFile Use TbsOne mode");
            int startMiniQB = TbsOneFileOpenManager.getInstance(context).startMiniQB(context, str, hashMap, "", valueCallback);
            AppMethodBeat.o(55420);
            return startMiniQB;
        } else if (context == null) {
            AppMethodBeat.o(55420);
            return -100;
        } else {
            try {
                if (!g.a(true).a(context, null)) {
                    TbsCoreLoadStat.getInstance().setLoadErrorCode(context, 502);
                    AppMethodBeat.o(55420);
                    return -102;
                } else if (context == null || !context.getApplicationInfo().packageName.equals("com.nd.android.pandahome2") || getTbsVersion(context) >= 25487) {
                    int startMiniQB2 = TbsOneGreyInfoHelper.getCoreEntry().getX5CoreMessy().startMiniQB(context, str, hashMap, valueCallback);
                    if (startMiniQB2 == 0) {
                        TbsCoreLoadStat.getInstance().setLoadErrorCode(context, 503);
                    } else {
                        TbsLogReport.getInstance(context).setLoadErrorCode(504, String.valueOf(startMiniQB2));
                    }
                    AppMethodBeat.o(55420);
                    return startMiniQB2;
                } else {
                    TbsLogReport.TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(context).tbsLogInfo();
                    tbsLogInfo.setErrorCode(TbsListener.ErrorCode.INFO_OPEN_FILE_MINIQB_INIT_FAILED);
                    TbsLogReport.getInstance(context).eventReport(TbsLogReport.EventType.TYPE_SDK_REPORT_INFO, tbsLogInfo);
                    AppMethodBeat.o(55420);
                    return -101;
                }
            } catch (Throwable th) {
            }
        }
    }

    public static boolean startQbOrMiniQBToLoadUrl(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(55421);
        if (context == null) {
            AppMethodBeat.o(55421);
            return false;
        }
        x a2 = x.a();
        a2.a(context, null);
        if (hashMap != null && "5".equals(hashMap.get(LOGIN_TYPE_KEY_PARTNER_CALL_POS)) && a2.b()) {
            TbsOneGreyInfoHelper.getCoreEntry().getX5CoreMessy().getAdWebViewInfoFromX5Core();
        }
        if (c.a(context, str, hashMap, "QbSdk.startMiniQBToLoadUrl", null) == 0) {
            AppMethodBeat.o(55421);
            return true;
        } else if (startMiniQBToLoadUrl(context, str, hashMap, valueCallback) == 0) {
            AppMethodBeat.o(55421);
            return true;
        } else {
            AppMethodBeat.o(55421);
            return false;
        }
    }

    public static String getMiniQBVersion(Context context) {
        AppMethodBeat.i(55422);
        x a2 = x.a();
        a2.a(context, null);
        if (a2 == null || !a2.b()) {
            AppMethodBeat.o(55422);
            return null;
        }
        String miniQBVersion = TbsOneGreyInfoHelper.getCoreEntry().getX5CoreMessy().getMiniQBVersion();
        AppMethodBeat.o(55422);
        return miniQBVersion;
    }

    public static void initTbsSettings(Map<String, Object> map) {
        AppMethodBeat.i(55423);
        if (mSettings == null) {
            mSettings = map;
        } else {
            try {
                mSettings.putAll(map);
            } catch (Exception e2) {
            }
        }
        TbsLog.i("QbSdk", "initTbsSettings,maps=".concat(String.valueOf(map)));
        AppMethodBeat.o(55423);
    }

    public static Map<String, Object> getSettings() {
        return mSettings;
    }

    static Object a(Context context, String str, Bundle bundle) {
        AppMethodBeat.i(55424);
        Object onMiscCallExtension = TbsOneGreyInfoHelper.getSDKExtensionEntry().onMiscCallExtension(context, str, bundle);
        AppMethodBeat.o(55424);
        return onMiscCallExtension;
    }

    protected static String a() {
        AppMethodBeat.i(55425);
        x a2 = x.a();
        if (a2 == null || !a2.b()) {
            AppMethodBeat.o(55425);
            return null;
        }
        String guid = TbsOneGreyInfoHelper.getCoreEntry().getX5CoreMessy().getGUID();
        AppMethodBeat.o(55425);
        return guid;
    }

    public static void disAllowThirdAppDownload() {
        f1704c = false;
    }

    public static void initBuglyAsync(boolean z2) {
        f1709h = z2;
    }

    public static boolean checkApkExist(Context context, String str) {
        AppMethodBeat.i(55426);
        if (str == null || "".equals(str)) {
            AppMethodBeat.o(55426);
            return false;
        }
        try {
            context.getPackageManager().getApplicationInfo(str, 8192);
            AppMethodBeat.o(55426);
            return true;
        } catch (PackageManager.NameNotFoundException e2) {
            AppMethodBeat.o(55426);
            return false;
        }
    }

    public static void continueLoadSo(Context context) {
    }

    public static void setNeedInitX5FirstTime(boolean z2) {
        q = z2;
    }

    public static boolean isNeedInitX5FirstTime() {
        return q;
    }

    public static int getTmpDirTbsVersion(Context context) {
        AppMethodBeat.i(55427);
        if (n.a(context).c() == 2) {
            int e2 = q.a().e(context, 0);
            AppMethodBeat.o(55427);
            return e2;
        } else if (n.a(context).b("copy_status") == 1) {
            int e3 = q.a().e(context, 1);
            AppMethodBeat.o(55427);
            return e3;
        } else {
            AppMethodBeat.o(55427);
            return 0;
        }
    }

    public static File getTbsFolderDir(Context context) {
        AppMethodBeat.i(55428);
        if (context == null) {
            AppMethodBeat.o(55428);
            return null;
        }
        try {
            if (b.d()) {
                File dir = context.getDir("tbs_64", 0);
                AppMethodBeat.o(55428);
                return dir;
            }
        } catch (Exception e2) {
        }
        File dir2 = context.getDir("tbs", 0);
        AppMethodBeat.o(55428);
        return dir2;
    }

    public static void fileInfoDetect(Context context, String str, ValueCallback<String> valueCallback) {
        AppMethodBeat.i(55429);
        x a2 = x.a();
        if (a2 != null && a2.b()) {
            TbsOneGreyInfoHelper.getCoreEntry().getX5CoreMessy().fileInfoDetect(context, str, valueCallback);
        }
        AppMethodBeat.o(55429);
    }

    public static void setNewDnsHostList(String str) {
        AppMethodBeat.i(188319);
        x a2 = x.a();
        if (a2 == null || !a2.b()) {
            AppMethodBeat.o(188319);
            return;
        }
        try {
            a2.c().a().invokeStaticMethod(TbsWizard.WEBCOREPROXY_CLASSNAME, "setNewDnsHostList", new Class[]{String.class}, str);
            AppMethodBeat.o(188319);
        } catch (Exception e2) {
            AppMethodBeat.o(188319);
        }
    }

    public static void disableSensitiveApi() {
        AppMethodBeat.i(188320);
        m = false;
        HashMap hashMap = new HashMap();
        hashMap.put(TbsCoreSettings.NO_SENSITIVE_API, Boolean.TRUE);
        initTbsSettings(hashMap);
        AppMethodBeat.o(188320);
    }

    public static boolean isEnableSensitiveApi() {
        return m;
    }
}
