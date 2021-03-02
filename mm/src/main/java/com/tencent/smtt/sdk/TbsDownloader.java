package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsDownloadUpload;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.sdk.TbsLogReport;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.a;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.f;
import com.tencent.smtt.utils.g;
import com.tencent.smtt.utils.n;
import com.tencent.tav.core.ExportErrorStatus;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

public class TbsDownloader {
    public static final boolean DEBUG_DISABLE_DOWNLOAD = false;
    public static boolean DOWNLOAD_OVERSEA_TBS = false;
    public static final String LOGTAG = "TbsDownload";
    public static final String TBS_METADATA = "com.tencent.mm.BuildInfo.CLIENT_VERSION";

    /* renamed from: a  reason: collision with root package name */
    static boolean f1796a;

    /* renamed from: b  reason: collision with root package name */
    private static String f1797b;

    /* renamed from: c  reason: collision with root package name */
    private static Context f1798c;

    /* renamed from: d  reason: collision with root package name */
    private static Handler f1799d;

    /* renamed from: e  reason: collision with root package name */
    private static String f1800e;

    /* renamed from: f  reason: collision with root package name */
    private static Object f1801f = new byte[0];

    /* renamed from: g  reason: collision with root package name */
    private static m f1802g;

    /* renamed from: h  reason: collision with root package name */
    private static HandlerThread f1803h;

    /* renamed from: i  reason: collision with root package name */
    private static boolean f1804i = false;

    /* renamed from: j  reason: collision with root package name */
    private static boolean f1805j = false;
    private static boolean k = false;
    private static long l = -1;

    public interface TbsDownloaderCallback {
        void onNeedDownloadFinish(boolean z, int i2);
    }

    static /* synthetic */ boolean a(boolean z, boolean z2, boolean z3, boolean z4) {
        AppMethodBeat.i(54152);
        boolean b2 = b(z, z2, z3, z4);
        AppMethodBeat.o(54152);
        return b2;
    }

    public static HandlerThread getsTbsHandlerThread() {
        return f1803h;
    }

    public static String getBackupFileName(boolean z) {
        AppMethodBeat.i(54114);
        if (z) {
            if (b.d()) {
                AppMethodBeat.o(54114);
                return "x5.tbs.decouple.64";
            }
            AppMethodBeat.o(54114);
            return "x5.tbs.decouple";
        } else if (b.d()) {
            AppMethodBeat.o(54114);
            return "x5.tbs.org.64";
        } else {
            AppMethodBeat.o(54114);
            return "x5.tbs.org";
        }
    }

    private static boolean c() {
        AppMethodBeat.i(54115);
        try {
            for (String str : TbsShareManager.getCoreProviderAppList()) {
                if (TbsShareManager.getSharedTbsCoreVersion(f1798c, str) > 0) {
                    AppMethodBeat.o(54115);
                    return true;
                }
            }
        } catch (Exception e2) {
        }
        AppMethodBeat.o(54115);
        return false;
    }

    public static void setAppContext(Context context) {
        AppMethodBeat.i(54116);
        if (!(context == null || context.getApplicationContext() == null)) {
            f1798c = context.getApplicationContext();
        }
        AppMethodBeat.o(54116);
    }

    public static boolean needSendRequest(Context context, boolean z) {
        boolean z2;
        boolean z3 = true;
        AppMethodBeat.i(54117);
        f1798c = context.getApplicationContext();
        TbsLog.initIfNeed(context);
        if (!a(f1798c, z)) {
            AppMethodBeat.o(54117);
            return false;
        }
        int n = q.a().n(context);
        TbsLog.i(LOGTAG, "[TbsDownloader.needSendRequest] localTbsVersion=".concat(String.valueOf(n)));
        if (n > 0) {
            AppMethodBeat.o(54117);
            return false;
        } else if (a(f1798c, false, true)) {
            AppMethodBeat.o(54117);
            return true;
        } else {
            TbsDownloadConfig instance = TbsDownloadConfig.getInstance(f1798c);
            boolean contains = instance.mPreferences.contains(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD);
            TbsLog.i(LOGTAG, "[TbsDownloader.needSendRequest] hasNeedDownloadKey=".concat(String.valueOf(contains)));
            if (!contains) {
                z2 = true;
            } else {
                z2 = instance.mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, false);
            }
            TbsLog.i(LOGTAG, "[TbsDownloader.needSendRequest] needDownload=".concat(String.valueOf(z2)));
            if (!z2 || !h()) {
                z3 = false;
            }
            TbsLog.i(LOGTAG, "[TbsDownloader.needSendRequest] ret=".concat(String.valueOf(z3)));
            AppMethodBeat.o(54117);
            return z3;
        }
    }

    private static boolean a(Context context, boolean z, boolean z2) {
        boolean z3;
        String str;
        AppMethodBeat.i(54118);
        TbsDownloadConfig instance = TbsDownloadConfig.getInstance(context);
        String str2 = null;
        if (!z) {
            String string = instance.mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONNAME, null);
            int i2 = instance.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONCODE, 0);
            String string2 = instance.mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_APP_METADATA, null);
            String c2 = b.c(f1798c);
            int d2 = b.d(f1798c);
            String a2 = b.a(f1798c, TBS_METADATA);
            TbsLog.i(LOGTAG, "[TbsDownloader.needSendQueryRequest] appVersionName=" + c2 + " oldAppVersionName=" + string + " appVersionCode=" + d2 + " oldAppVersionCode=" + i2 + " appMetadata=" + a2 + " oldAppVersionMetadata=" + string2);
            long currentTimeMillis = System.currentTimeMillis();
            long j2 = instance.mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_LAST_CHECK, 0);
            TbsLog.i(LOGTAG, "[TbsDownloader.needSendQueryRequest] timeLastCheck=" + j2 + " timeNow=" + currentTimeMillis);
            if (z2) {
                boolean contains = instance.mPreferences.contains(TbsDownloadConfig.TbsConfigKey.KEY_LAST_CHECK);
                TbsLog.i(LOGTAG, "[TbsDownloader.needSendQueryRequest] hasLaskCheckKey=".concat(String.valueOf(contains)));
                if (contains && j2 == 0) {
                    j2 = currentTimeMillis;
                }
            }
            long j3 = instance.mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_LAST_REQUEST_SUCCESS, 0);
            long j4 = instance.mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_COUNT_REQUEST_FAIL_IN_24HOURS, 0);
            long retryInterval = instance.getRetryInterval();
            TbsLog.i(LOGTAG, "retryInterval = " + retryInterval + " s");
            TbsPVConfig.releaseInstance();
            int emergentCoreVersion = TbsPVConfig.getInstance(f1798c).getEmergentCoreVersion();
            int i3 = TbsDownloadConfig.getInstance(f1798c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
            if (currentTimeMillis - j2 <= 1000 * retryInterval && ((emergentCoreVersion <= q.a().j(f1798c) || emergentCoreVersion <= i3) && (!TbsShareManager.isThirdPartyApp(f1798c) || j3 <= 0 || currentTimeMillis - j3 <= retryInterval * 1000 || j4 >= 11))) {
                if (!TbsShareManager.isThirdPartyApp(f1798c) || TbsShareManager.findCoreForThirdPartyApp(f1798c) != 0 || e()) {
                    if (c2 == null || d2 == 0 || a2 == null) {
                        if (TbsShareManager.isThirdPartyApp(f1798c)) {
                            str = "timeNow - timeLastCheck is " + (currentTimeMillis - j2) + " TbsShareManager.findCoreForThirdPartyApp(sAppContext) is " + TbsShareManager.findCoreForThirdPartyApp(f1798c) + " sendRequestWithSameHostCoreVersion() is " + e() + " appVersionName is " + c2 + " appVersionCode is " + d2 + " appMetadata is " + a2 + " oldAppVersionName is " + string + " oldAppVersionCode is " + i2 + " oldAppVersionMetadata is " + string2;
                        }
                        str = null;
                    } else {
                        if (!c2.equals(string) || d2 != i2 || !a2.equals(string2)) {
                            z3 = true;
                            if (!z3 && TbsShareManager.isThirdPartyApp(f1798c)) {
                                TbsLogReport.TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(f1798c).tbsLogInfo();
                                tbsLogInfo.setErrorCode(-119);
                                tbsLogInfo.setFailDetail(str2);
                                TbsLogReport.getInstance(f1798c).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, tbsLogInfo);
                            }
                            AppMethodBeat.o(54118);
                            return z3;
                        }
                        str = null;
                    }
                    str2 = str;
                    z3 = false;
                    TbsLogReport.TbsLogInfo tbsLogInfo2 = TbsLogReport.getInstance(f1798c).tbsLogInfo();
                    tbsLogInfo2.setErrorCode(-119);
                    tbsLogInfo2.setFailDetail(str2);
                    TbsLogReport.getInstance(f1798c).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, tbsLogInfo2);
                    AppMethodBeat.o(54118);
                    return z3;
                }
                q.a().e(f1798c);
                z3 = true;
                TbsLogReport.TbsLogInfo tbsLogInfo22 = TbsLogReport.getInstance(f1798c).tbsLogInfo();
                tbsLogInfo22.setErrorCode(-119);
                tbsLogInfo22.setFailDetail(str2);
                TbsLogReport.getInstance(f1798c).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, tbsLogInfo22);
                AppMethodBeat.o(54118);
                return z3;
            }
        }
        z3 = true;
        TbsLogReport.TbsLogInfo tbsLogInfo222 = TbsLogReport.getInstance(f1798c).tbsLogInfo();
        tbsLogInfo222.setErrorCode(-119);
        tbsLogInfo222.setFailDetail(str2);
        TbsLogReport.getInstance(f1798c).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, tbsLogInfo222);
        AppMethodBeat.o(54118);
        return z3;
    }

    private static boolean a(Context context, boolean z) {
        Matcher matcher = null;
        AppMethodBeat.i(54119);
        TbsDownloadConfig instance = TbsDownloadConfig.getInstance(context);
        if (Build.VERSION.SDK_INT < 8) {
            instance.setDownloadInterruptCode(-102);
            AppMethodBeat.o(54119);
            return false;
        } else if (QbSdk.f1704c || !TbsShareManager.isThirdPartyApp(f1798c) || c()) {
            if (!instance.mPreferences.contains(TbsDownloadConfig.TbsConfigKey.KEY_IS_OVERSEA)) {
                if (z && !"com.tencent.mm".equals(context.getApplicationInfo().packageName)) {
                    TbsLog.i(LOGTAG, "needDownload-oversea is true, but not WX");
                    z = false;
                }
                instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_IS_OVERSEA, Boolean.valueOf(z));
                instance.commit();
                f1805j = z;
                TbsLog.i(LOGTAG, "needDownload-first-called--isoversea = ".concat(String.valueOf(z)));
            }
            if (!getOverSea(context) || Build.VERSION.SDK_INT == 16 || Build.VERSION.SDK_INT == 17 || Build.VERSION.SDK_INT == 18) {
                String string = instance.mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_DEVICE_CPUABI, null);
                f1800e = string;
                if (!TextUtils.isEmpty(string)) {
                    try {
                        matcher = Pattern.compile("i686|mips|x86_64").matcher(f1800e);
                    } catch (Exception e2) {
                    }
                    if (matcher != null && matcher.find()) {
                        TbsLog.e(LOGTAG, "can not support x86 devices!!");
                        instance.setDownloadInterruptCode(-104);
                        AppMethodBeat.o(54119);
                        return false;
                    }
                }
                AppMethodBeat.o(54119);
                return true;
            }
            TbsLog.i(LOGTAG, "needDownload- return false,  because of  version is " + Build.VERSION.SDK_INT + ", and overea");
            instance.setDownloadInterruptCode(-103);
            AppMethodBeat.o(54119);
            return false;
        } else {
            AppMethodBeat.o(54119);
            return false;
        }
    }

    public static boolean needDownload(Context context, boolean z) {
        AppMethodBeat.i(54120);
        boolean needDownload = needDownload(context, z, false, true, null);
        AppMethodBeat.o(54120);
        return needDownload;
    }

    public static boolean needDownload(Context context, boolean z, boolean z2, TbsDownloaderCallback tbsDownloaderCallback) {
        AppMethodBeat.i(54121);
        boolean needDownload = needDownload(context, z, z2, true, tbsDownloaderCallback);
        AppMethodBeat.o(54121);
        return needDownload;
    }

    public static boolean needDownload(Context context, boolean z, boolean z2, boolean z3, TbsDownloaderCallback tbsDownloaderCallback) {
        boolean z4;
        AppMethodBeat.i(54122);
        TbsOneGreyInfoHelper.initExtension(context);
        TbsLog.i(LOGTAG, "current Process=" + QbSdk.getCurrentProcessName(context) + ",oneEnable=" + TbsOneGreyInfoHelper.isTbsOneModeEnable(context) + Log.getStackTraceString(new Throwable()));
        if (TbsOneGreyInfoHelper.isTbsOneModeEnable(context)) {
            TbsOneGreyInfoHelper.a(context).setAutoUpdateEnabled(true);
            if (!TbsOneGreyInfoHelper.a(context).isComponentInstalled("x5webview")) {
                TbsOneGreyInfoHelper.a(context).installComponent("x5webview", new TBSOneCallback<File>() {
                    /* class com.tencent.smtt.sdk.TbsDownloader.AnonymousClass1 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.tencent.tbs.one.TBSOneCallback
                    public final /* synthetic */ void onCompleted(File file) {
                        AppMethodBeat.i(55108);
                        a(file);
                        AppMethodBeat.o(55108);
                    }

                    @Override // com.tencent.tbs.one.TBSOneCallback
                    public final void onProgressChanged(int i2, int i3) {
                        AppMethodBeat.i(55105);
                        TbsLog.i("TbsDownloader", "onProgressChanged,i=" + i2 + ",i1=" + i3);
                        AppMethodBeat.o(55105);
                    }

                    @Override // com.tencent.tbs.one.TBSOneCallback
                    public final void onError(int i2, String str) {
                        AppMethodBeat.i(55106);
                        TbsLog.i("TbsDownloader", "onError,i=" + i2 + ",str=" + str);
                        AppMethodBeat.o(55106);
                    }

                    public final void a(File file) {
                        AppMethodBeat.i(55107);
                        TbsLog.i("TbsDownloader", "x5webview onCompleted,onCompleted=".concat(String.valueOf(file)));
                        AppMethodBeat.o(55107);
                    }
                });
            }
            if (!TbsOneGreyInfoHelper.a(context).isComponentInstalled("file")) {
                TbsOneGreyInfoHelper.a(context).installComponent("file", new TBSOneCallback<File>() {
                    /* class com.tencent.smtt.sdk.TbsDownloader.AnonymousClass2 */

                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.tencent.tbs.one.TBSOneCallback
                    public final /* synthetic */ void onCompleted(File file) {
                        AppMethodBeat.i(55213);
                        a(file);
                        AppMethodBeat.o(55213);
                    }

                    public final void a(File file) {
                        AppMethodBeat.i(55211);
                        TbsLog.i("TbsDownloader", "file install onCompleted,onCompleted=".concat(String.valueOf(file)));
                        AppMethodBeat.o(55211);
                    }

                    @Override // com.tencent.tbs.one.TBSOneCallback
                    public final void onError(int i2, String str) {
                        AppMethodBeat.i(55212);
                        TbsLog.i("TbsDownloader", "file onError,i=" + i2 + ",str=" + str);
                        AppMethodBeat.o(55212);
                    }
                });
            }
            AppMethodBeat.o(54122);
            return false;
        }
        TbsLog.i(LOGTAG, "needDownload,process=" + QbSdk.getCurrentProcessName(context) + "stack=" + Log.getStackTraceString(new Throwable()));
        TbsDownloadUpload.clear();
        TbsDownloadUpload instance = TbsDownloadUpload.getInstance(context);
        instance.f1788a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, 140);
        instance.commit();
        TbsLog.i(LOGTAG, "[TbsDownloader.needDownload] oversea=" + z + ",isDownloadForeground=" + z2);
        boolean z5 = false;
        TbsLog.initIfNeed(context);
        if (q.f2105b) {
            if (tbsDownloaderCallback != null) {
                tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
            }
            TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#1,return false");
            instance.f1788a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_RETURN, Integer.valueOf((int) TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_1));
            instance.commit();
            AppMethodBeat.o(54122);
            return false;
        }
        TbsLog.app_extra(LOGTAG, context);
        Context applicationContext = context.getApplicationContext();
        f1798c = applicationContext;
        TbsDownloadConfig instance2 = TbsDownloadConfig.getInstance(applicationContext);
        instance2.setDownloadInterruptCode(-100);
        if (!a(f1798c, z)) {
            TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#2,return false");
            instance.f1788a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, 141);
            instance.commit();
            instance.f1788a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_RETURN, 172);
            instance.commit();
            if (tbsDownloaderCallback != null) {
                tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
            }
            AppMethodBeat.o(54122);
            return false;
        }
        d();
        if (f1804i) {
            if (tbsDownloaderCallback != null) {
                tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
            }
            instance2.setDownloadInterruptCode(-105);
            TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#3,return false");
            instance.f1788a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, Integer.valueOf((int) TbsListener.ErrorCode.NEEDDOWNLOAD_3));
            instance.commit();
            instance.f1788a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_RETURN, Integer.valueOf((int) TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_3));
            instance.commit();
            if (tbsDownloaderCallback != null) {
                tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
            }
            AppMethodBeat.o(54122);
            return false;
        }
        boolean a2 = a(f1798c, z2, false);
        TbsLog.i(LOGTAG, "[TbsDownloader.needDownload],needSendRequest=".concat(String.valueOf(a2)));
        if (a2) {
            a(z2, tbsDownloaderCallback, z3);
            instance2.setDownloadInterruptCode(-114);
        } else {
            instance.f1788a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, Integer.valueOf((int) TbsListener.ErrorCode.NEEDDOWNLOAD_4));
            instance.commit();
        }
        f1799d.removeMessages(102);
        Message.obtain(f1799d, 102).sendToTarget();
        boolean z6 = false;
        if (QbSdk.f1704c || !TbsShareManager.isThirdPartyApp(context)) {
            z6 = instance2.mPreferences.contains(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD);
            TbsLog.i(LOGTAG, "[TbsDownloader.needDownload] hasNeedDownloadKey=".concat(String.valueOf(z6)));
            if (z6 || TbsShareManager.isThirdPartyApp(context)) {
                z5 = instance2.mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, false);
            } else {
                z5 = true;
            }
        }
        TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#4,needDownload=" + z5 + ",hasNeedDownloadKey=" + z6);
        if (!z5) {
            int n = q.a().n(f1798c);
            TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#7,tbsLocalVersion=" + n + ",needSendRequest=" + a2);
            if (a2 || n <= 0) {
                f1799d.removeMessages(103);
                if (n > 0 || a2) {
                    Message.obtain(f1799d, 103, 1, 0, f1798c).sendToTarget();
                } else {
                    Message.obtain(f1799d, 103, 0, 0, f1798c).sendToTarget();
                }
                instance2.setDownloadInterruptCode(ExportErrorStatus.WRITE_VIDEO_SAMPLE);
                z4 = z5;
            } else {
                instance2.setDownloadInterruptCode(-119);
                z4 = z5;
            }
        } else if (!h()) {
            TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#5,set needDownload = false");
            z4 = false;
        } else {
            instance2.setDownloadInterruptCode(-118);
            TbsLog.i(LOGTAG, "[TbsDownloader.needDownload]#6");
            z4 = z5;
        }
        if (!a2 && tbsDownloaderCallback != null) {
            tbsDownloaderCallback.onNeedDownloadFinish(false, 0);
        }
        TbsLog.i(LOGTAG, "[TbsDownloader.needDownload] needDownload=".concat(String.valueOf(z4)));
        instance.f1788a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_RETURN, Integer.valueOf(z4 ? TbsListener.ErrorCode.NEEDDOWNLOAD_TRUE : TbsListener.ErrorCode.NEEDDOWNLOAD_FALSE_4));
        instance.commit();
        AppMethodBeat.o(54122);
        return z4;
    }

    static boolean a(Context context) {
        AppMethodBeat.i(54123);
        if (TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOADDECOUPLECORE, 0) == 1) {
            AppMethodBeat.o(54123);
            return true;
        }
        AppMethodBeat.o(54123);
        return false;
    }

    public static void startDownload(Context context) {
        AppMethodBeat.i(54124);
        startDownload(context, false);
        AppMethodBeat.o(54124);
    }

    public static synchronized void startDownload(Context context, boolean z) {
        int i2 = 1;
        synchronized (TbsDownloader.class) {
            AppMethodBeat.i(54125);
            TbsDownloadUpload instance = TbsDownloadUpload.getInstance(context);
            instance.f1788a.put(TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE, 160);
            instance.commit();
            TbsLog.i(LOGTAG, "[TbsDownloader.startDownload] sAppContext=" + f1798c);
            if (q.f2105b) {
                instance.f1788a.put(TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE, 161);
                instance.commit();
                AppMethodBeat.o(54125);
            } else {
                f1796a = true;
                Context applicationContext = context.getApplicationContext();
                f1798c = applicationContext;
                TbsDownloadConfig.getInstance(applicationContext).setDownloadInterruptCode(-200);
                if (Build.VERSION.SDK_INT < 8) {
                    QbSdk.l.onDownloadFinish(110);
                    TbsDownloadConfig.getInstance(f1798c).setDownloadInterruptCode(-201);
                    instance.f1788a.put(TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE, Integer.valueOf((int) TbsListener.ErrorCode.STARTDOWNLOAD_3));
                    instance.commit();
                    AppMethodBeat.o(54125);
                } else {
                    d();
                    if (f1804i) {
                        QbSdk.l.onDownloadFinish(121);
                        TbsDownloadConfig.getInstance(f1798c).setDownloadInterruptCode(-202);
                        instance.f1788a.put(TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE, Integer.valueOf((int) TbsListener.ErrorCode.STARTDOWNLOAD_4));
                        instance.commit();
                        AppMethodBeat.o(54125);
                    } else {
                        if (z) {
                            stopDownload();
                        }
                        f1799d.removeMessages(101);
                        f1799d.removeMessages(100);
                        Message obtain = Message.obtain(f1799d, 101, QbSdk.l);
                        if (!z) {
                            i2 = 0;
                        }
                        obtain.arg1 = i2;
                        obtain.sendToTarget();
                        AppMethodBeat.o(54125);
                    }
                }
            }
        }
    }

    public static int getCoreShareDecoupleCoreVersionByContext(Context context) {
        AppMethodBeat.i(54126);
        int i2 = q.a().i(context);
        AppMethodBeat.o(54126);
        return i2;
    }

    public static int getCoreShareDecoupleCoreVersion() {
        AppMethodBeat.i(54127);
        int i2 = q.a().i(f1798c);
        AppMethodBeat.o(54127);
        return i2;
    }

    public static boolean needDownloadDecoupleCore() {
        AppMethodBeat.i(54128);
        if (TbsShareManager.isThirdPartyApp(f1798c)) {
            AppMethodBeat.o(54128);
            return false;
        } else if (a(f1798c)) {
            AppMethodBeat.o(54128);
            return false;
        } else {
            long j2 = TbsDownloadConfig.getInstance(f1798c).mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_LAST_DOWNLOAD_DECOUPLE_CORE, 0);
            if (System.currentTimeMillis() - j2 < 1000 * TbsDownloadConfig.getInstance(f1798c).getRetryInterval()) {
                AppMethodBeat.o(54128);
                return false;
            }
            int i2 = TbsDownloadConfig.getInstance(f1798c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
            if (i2 <= 0 || i2 == q.a().i(f1798c) || TbsDownloadConfig.getInstance(f1798c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0) == i2) {
                AppMethodBeat.o(54128);
                return false;
            }
            AppMethodBeat.o(54128);
            return true;
        }
    }

    public static boolean startDecoupleCoreIfNeeded() {
        AppMethodBeat.i(54129);
        TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded ");
        if (TbsShareManager.isThirdPartyApp(f1798c)) {
            AppMethodBeat.o(54129);
            return false;
        }
        TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded #1");
        if (a(f1798c)) {
            AppMethodBeat.o(54129);
            return false;
        } else if (f1799d == null) {
            AppMethodBeat.o(54129);
            return false;
        } else {
            TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded #2");
            long j2 = TbsDownloadConfig.getInstance(f1798c).mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_LAST_DOWNLOAD_DECOUPLE_CORE, 0);
            if (System.currentTimeMillis() - j2 < 1000 * TbsDownloadConfig.getInstance(f1798c).getRetryInterval()) {
                AppMethodBeat.o(54129);
                return false;
            }
            TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded #3");
            int i2 = TbsDownloadConfig.getInstance(f1798c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, 0);
            if (i2 <= 0 || i2 == q.a().i(f1798c)) {
                TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded no need, deCoupleCoreVersion is " + i2 + " getTbsCoreShareDecoupleCoreVersion is " + q.a().i(f1798c));
            } else if (TbsDownloadConfig.getInstance(f1798c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0) != i2 || TbsDownloadConfig.getInstance(f1798c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) == 1) {
                TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded #4");
                f1796a = true;
                f1799d.removeMessages(108);
                Message obtain = Message.obtain(f1799d, 108, QbSdk.l);
                obtain.arg1 = 0;
                obtain.sendToTarget();
                TbsDownloadConfig.getInstance(f1798c).mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_LAST_DOWNLOAD_DECOUPLE_CORE, Long.valueOf(System.currentTimeMillis()));
                AppMethodBeat.o(54129);
                return true;
            } else {
                TbsLog.i(LOGTAG, "startDecoupleCoreIfNeeded no need, KEY_TBS_DOWNLOAD_V is " + TbsDownloadConfig.getInstance(f1798c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0) + " deCoupleCoreVersion is " + i2 + " KEY_TBS_DOWNLOAD_V_TYPE is " + TbsDownloadConfig.getInstance(f1798c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0));
            }
            AppMethodBeat.o(54129);
            return false;
        }
    }

    public static void stopDownload() {
        AppMethodBeat.i(54130);
        if (f1804i) {
            AppMethodBeat.o(54130);
            return;
        }
        TbsLog.i(LOGTAG, "[TbsDownloader.stopDownload]");
        if (f1802g != null) {
            f1802g.b();
        }
        if (f1799d != null) {
            f1799d.removeMessages(100);
            f1799d.removeMessages(101);
            f1799d.removeMessages(108);
        }
        AppMethodBeat.o(54130);
    }

    public static synchronized boolean isDownloading() {
        boolean z;
        synchronized (TbsDownloader.class) {
            AppMethodBeat.i(54131);
            TbsLog.i(LOGTAG, "[TbsDownloader.isDownloading] is " + f1796a);
            z = f1796a;
            AppMethodBeat.o(54131);
        }
        return z;
    }

    public static boolean isDownloadForeground() {
        AppMethodBeat.i(54132);
        if (f1802g == null || !f1802g.d()) {
            AppMethodBeat.o(54132);
            return false;
        }
        AppMethodBeat.o(54132);
        return true;
    }

    private static synchronized void d() {
        synchronized (TbsDownloader.class) {
            AppMethodBeat.i(54133);
            if (f1803h == null) {
                f1803h = o.a();
                try {
                    f1802g = new m(f1798c);
                    f1799d = new Handler(f1803h.getLooper()) {
                        /* class com.tencent.smtt.sdk.TbsDownloader.AnonymousClass3 */

                        public final void handleMessage(Message message) {
                            int n;
                            boolean z;
                            boolean z2;
                            boolean z3 = true;
                            AppMethodBeat.i(55112);
                            switch (message.what) {
                                case 100:
                                    boolean z4 = message.arg1 == 1;
                                    if (message.arg2 == 1) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                    boolean a2 = TbsDownloader.a(true, false, false, z2);
                                    if (message.obj != null && (message.obj instanceof TbsDownloaderCallback)) {
                                        TbsLog.i(TbsDownloader.LOGTAG, "needDownload-onNeedDownloadFinish needStartDownload=".concat(String.valueOf(a2)));
                                        String str = "";
                                        if (!(TbsDownloader.f1798c == null || TbsDownloader.f1798c.getApplicationContext() == null || TbsDownloader.f1798c.getApplicationContext().getApplicationInfo() == null)) {
                                            str = TbsDownloader.f1798c.getApplicationContext().getApplicationInfo().packageName;
                                        }
                                        if (!a2 || z4) {
                                            ((TbsDownloaderCallback) message.obj).onNeedDownloadFinish(a2, TbsDownloadConfig.getInstance(TbsDownloader.f1798c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
                                        } else if ("com.tencent.mm".equals(str) || TbsConfig.APP_QQ.equals(str)) {
                                            TbsLog.i(TbsDownloader.LOGTAG, "needDownload-onNeedDownloadFinish in mm or QQ callback needStartDownload = ".concat(String.valueOf(a2)));
                                            ((TbsDownloaderCallback) message.obj).onNeedDownloadFinish(a2, TbsDownloadConfig.getInstance(TbsDownloader.f1798c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
                                        }
                                    }
                                    if (TbsShareManager.isThirdPartyApp(TbsDownloader.f1798c) && a2) {
                                        TbsDownloader.startDownload(TbsDownloader.f1798c);
                                        AppMethodBeat.o(55112);
                                        return;
                                    }
                                case 101:
                                case 108:
                                    FileOutputStream fileOutputStream = null;
                                    FileLock fileLock = null;
                                    if (!TbsShareManager.isThirdPartyApp(TbsDownloader.f1798c)) {
                                        fileOutputStream = f.b(TbsDownloader.f1798c, false, "tbs_download_lock_file" + TbsDownloadConfig.getInstance(TbsDownloader.f1798c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0) + ".txt");
                                        if (fileOutputStream != null) {
                                            fileLock = f.a(TbsDownloader.f1798c, fileOutputStream);
                                            if (fileLock == null) {
                                                QbSdk.l.onDownloadFinish(TbsListener.ErrorCode.NONEEDDOWNLOAD_OTHER_PROCESS_DOWNLOADING);
                                                TbsLog.i(TbsDownloader.LOGTAG, "file lock locked,wx or qq is downloading");
                                                TbsDownloadConfig.getInstance(TbsDownloader.f1798c).setDownloadInterruptCode(-203);
                                                TbsLog.i(TbsDownloader.LOGTAG, "MSG_START_DOWNLOAD_DECOUPLECORE return #1");
                                                AppMethodBeat.o(55112);
                                                return;
                                            }
                                        } else if (f.a(TbsDownloader.f1798c)) {
                                            TbsDownloadConfig.getInstance(TbsDownloader.f1798c).setDownloadInterruptCode(-204);
                                            TbsLog.i(TbsDownloader.LOGTAG, "MSG_START_DOWNLOAD_DECOUPLECORE return #2");
                                            AppMethodBeat.o(55112);
                                            return;
                                        }
                                    }
                                    boolean z5 = message.arg1 == 1;
                                    TbsDownloadConfig instance = TbsDownloadConfig.getInstance(TbsDownloader.f1798c);
                                    if (108 == message.what) {
                                        z = true;
                                    } else {
                                        z = false;
                                    }
                                    if (!TbsDownloader.a(false, z5, z, true)) {
                                        QbSdk.l.onDownloadFinish(110);
                                    } else if (z5 && q.a().b(TbsDownloader.f1798c, TbsDownloadConfig.getInstance(TbsDownloader.f1798c).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0))) {
                                        QbSdk.l.onDownloadFinish(122);
                                        instance.setDownloadInterruptCode(-213);
                                    } else if (instance.mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, false)) {
                                        TbsDownloadConfig.getInstance(TbsDownloader.f1798c).setDownloadInterruptCode(-215);
                                        m mVar = TbsDownloader.f1802g;
                                        if (108 != message.what) {
                                            z3 = false;
                                        }
                                        mVar.b(z5, z3);
                                    } else {
                                        QbSdk.l.onDownloadFinish(110);
                                    }
                                    TbsLog.i(TbsDownloader.LOGTAG, "------freeFileLock called :");
                                    f.a(fileLock, fileOutputStream);
                                    AppMethodBeat.o(55112);
                                    return;
                                case 102:
                                    TbsLog.i(TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] MSG_REPORT_DOWNLOAD_STAT");
                                    if (TbsShareManager.isThirdPartyApp(TbsDownloader.f1798c)) {
                                        n = TbsShareManager.a(TbsDownloader.f1798c, false);
                                    } else {
                                        n = q.a().n(TbsDownloader.f1798c);
                                    }
                                    TbsLog.i(TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] localTbsVersion=".concat(String.valueOf(n)));
                                    TbsDownloader.f1802g.a(n);
                                    TbsLogReport.getInstance(TbsDownloader.f1798c).dailyReport();
                                    AppMethodBeat.o(55112);
                                    return;
                                case 103:
                                    TbsLog.i(TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] MSG_CONTINUEINSTALL_TBSCORE");
                                    if (message.arg1 != 0) {
                                        q.a().a((Context) message.obj, false);
                                        break;
                                    } else {
                                        q.a().a((Context) message.obj, true);
                                        AppMethodBeat.o(55112);
                                        return;
                                    }
                                case 104:
                                    TbsLog.i(TbsDownloader.LOGTAG, "[TbsDownloader.handleMessage] MSG_UPLOAD_TBSLOG");
                                    TbsLogReport.getInstance(TbsDownloader.f1798c).reportTbsLog();
                                    AppMethodBeat.o(55112);
                                    return;
                            }
                            AppMethodBeat.o(55112);
                        }
                    };
                } catch (Exception e2) {
                    f1804i = true;
                    TbsLog.e(LOGTAG, "TbsApkDownloader init has Exception");
                    AppMethodBeat.o(54133);
                }
            }
            AppMethodBeat.o(54133);
        }
    }

    private static void a(boolean z, TbsDownloaderCallback tbsDownloaderCallback, boolean z2) {
        int i2;
        int i3 = 1;
        AppMethodBeat.i(54134);
        TbsLog.i(LOGTAG, "[TbsDownloader.queryConfig]");
        f1799d.removeMessages(100);
        Message obtain = Message.obtain(f1799d, 100);
        if (tbsDownloaderCallback != null) {
            obtain.obj = tbsDownloaderCallback;
        }
        obtain.arg1 = 0;
        if (z) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        obtain.arg1 = i2;
        if (!z2) {
            i3 = 0;
        }
        obtain.arg2 = i3;
        obtain.sendToTarget();
        AppMethodBeat.o(54134);
    }

    private static boolean e() {
        AppMethodBeat.i(54135);
        try {
            boolean equals = TbsDownloadConfig.getInstance(f1798c).mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_LAST_THIRDAPP_SENDREQUEST_COREVERSION, "").equals(g().toString());
            AppMethodBeat.o(54135);
            return equals;
        } catch (Exception e2) {
            AppMethodBeat.o(54135);
            return false;
        }
    }

    private static String[] f() {
        String[] strArr;
        AppMethodBeat.i(54136);
        if (QbSdk.getOnlyDownload()) {
            strArr = new String[]{f1798c.getApplicationContext().getPackageName()};
        } else {
            String[] coreProviderAppList = TbsShareManager.getCoreProviderAppList();
            String packageName = f1798c.getApplicationContext().getPackageName();
            if (packageName.equals(TbsShareManager.f(f1798c))) {
                int length = coreProviderAppList.length;
                strArr = new String[(length + 1)];
                System.arraycopy(coreProviderAppList, 0, strArr, 0, length);
                strArr[length] = packageName;
            } else {
                strArr = coreProviderAppList;
            }
        }
        AppMethodBeat.o(54136);
        return strArr;
    }

    private static void a(JSONArray jSONArray) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(54137);
        String[] f2 = f();
        for (String str : f2) {
            int sharedTbsCoreVersion = TbsShareManager.getSharedTbsCoreVersion(f1798c, str);
            if (sharedTbsCoreVersion > 0) {
                Context packageContext = TbsShareManager.getPackageContext(f1798c, str, true);
                if (packageContext == null || q.a().g(packageContext)) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= jSONArray.length()) {
                            z2 = false;
                            break;
                        } else if (jSONArray.optInt(i2) == sharedTbsCoreVersion) {
                            z2 = true;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (!z2) {
                        jSONArray.put(sharedTbsCoreVersion);
                    }
                } else {
                    TbsLog.e(LOGTAG, "host check failed,packageName = ".concat(String.valueOf(str)));
                }
            }
        }
        String[] f3 = f();
        for (String str2 : f3) {
            int coreShareDecoupleCoreVersion = TbsShareManager.getCoreShareDecoupleCoreVersion(f1798c, str2);
            if (coreShareDecoupleCoreVersion > 0) {
                Context packageContext2 = TbsShareManager.getPackageContext(f1798c, str2, true);
                if (packageContext2 == null || q.a().g(packageContext2)) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= jSONArray.length()) {
                            z = false;
                            break;
                        } else if (jSONArray.optInt(i3) == coreShareDecoupleCoreVersion) {
                            z = true;
                            break;
                        } else {
                            i3++;
                        }
                    }
                    if (!z) {
                        jSONArray.put(coreShareDecoupleCoreVersion);
                    }
                } else {
                    TbsLog.e(LOGTAG, "host check failed,packageName = ".concat(String.valueOf(str2)));
                }
            }
        }
        AppMethodBeat.o(54137);
    }

    private static void b(JSONArray jSONArray) {
        boolean z = false;
        AppMethodBeat.i(54138);
        if (TbsShareManager.getHostCorePathAppDefined() != null) {
            int a2 = q.a().a(TbsShareManager.getHostCorePathAppDefined());
            int i2 = 0;
            while (true) {
                if (i2 >= jSONArray.length()) {
                    break;
                } else if (jSONArray.optInt(i2) == a2) {
                    z = true;
                    break;
                } else {
                    i2++;
                }
            }
            if (!z) {
                jSONArray.put(a2);
            }
        }
        AppMethodBeat.o(54138);
    }

    private static JSONArray g() {
        AppMethodBeat.i(54139);
        if (TbsShareManager.isThirdPartyApp(f1798c)) {
            JSONArray jSONArray = new JSONArray();
            a(jSONArray);
            c(jSONArray);
            b(jSONArray);
            AppMethodBeat.o(54139);
            return jSONArray;
        }
        AppMethodBeat.o(54139);
        return null;
    }

    private static void c(JSONArray jSONArray) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(54140);
        if (!TbsPVConfig.getInstance(f1798c).isDisableHostBackupCore()) {
            String[] f2 = f();
            for (String str : f2) {
                int backupCoreVersion = TbsShareManager.getBackupCoreVersion(f1798c, str);
                if (backupCoreVersion > 0) {
                    Context packageContext = TbsShareManager.getPackageContext(f1798c, str, false);
                    if (packageContext == null || q.a().g(packageContext)) {
                        int i2 = 0;
                        while (true) {
                            if (i2 >= jSONArray.length()) {
                                z2 = false;
                                break;
                            } else if (jSONArray.optInt(i2) == backupCoreVersion) {
                                z2 = true;
                                break;
                            } else {
                                i2++;
                            }
                        }
                        if (!z2) {
                            jSONArray.put(backupCoreVersion);
                        }
                    } else {
                        TbsLog.e(LOGTAG, "host check failed,packageName = ".concat(String.valueOf(str)));
                    }
                }
                int backupDecoupleCoreVersion = TbsShareManager.getBackupDecoupleCoreVersion(f1798c, str);
                if (backupDecoupleCoreVersion > 0) {
                    Context packageContext2 = TbsShareManager.getPackageContext(f1798c, str, false);
                    if (packageContext2 == null || q.a().g(packageContext2)) {
                        int i3 = 0;
                        while (true) {
                            if (i3 >= jSONArray.length()) {
                                z = false;
                                break;
                            } else if (jSONArray.optInt(i3) == backupDecoupleCoreVersion) {
                                z = true;
                                break;
                            } else {
                                i3++;
                            }
                        }
                        if (!z) {
                            jSONArray.put(backupDecoupleCoreVersion);
                        }
                    } else {
                        TbsLog.e(LOGTAG, "host check failed,packageName = ".concat(String.valueOf(str)));
                    }
                }
            }
        }
        AppMethodBeat.o(54140);
    }

    /* JADX WARNING: Removed duplicated region for block: B:100:0x033f  */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0351  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x035a  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0080 A[Catch:{ Exception -> 0x025f }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0099 A[Catch:{ Exception -> 0x025f }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x00af A[Catch:{ Exception -> 0x025f }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00bd A[Catch:{ Exception -> 0x025f }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x00cc A[Catch:{ Exception -> 0x025f }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0148 A[Catch:{ Exception -> 0x025f }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0153 A[Catch:{ Exception -> 0x025f }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0160 A[Catch:{ Exception -> 0x025f }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x01ac A[Catch:{ Exception -> 0x025f }] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x01f5 A[Catch:{ Exception -> 0x025f }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x020d A[Catch:{ Exception -> 0x025f }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0212 A[Catch:{ Exception -> 0x025f }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0221 A[Catch:{ Exception -> 0x025f }] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x022a A[Catch:{ Exception -> 0x025f }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x0256  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0273  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0310  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x031d  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x033c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static org.json.JSONObject a(boolean r11, boolean r12, boolean r13) {
        /*
        // Method dump skipped, instructions count: 864
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsDownloader.a(boolean, boolean, boolean):org.json.JSONObject");
    }

    public static synchronized boolean getOverSea(Context context) {
        boolean z;
        synchronized (TbsDownloader.class) {
            AppMethodBeat.i(54142);
            if (!k) {
                k = true;
                TbsDownloadConfig instance = TbsDownloadConfig.getInstance(context);
                if (instance.mPreferences.contains(TbsDownloadConfig.TbsConfigKey.KEY_IS_OVERSEA)) {
                    f1805j = instance.mPreferences.getBoolean(TbsDownloadConfig.TbsConfigKey.KEY_IS_OVERSEA, false);
                    TbsLog.i(LOGTAG, "[TbsDownloader.getOverSea]  first called. sOverSea = " + f1805j);
                }
                TbsLog.i(LOGTAG, "[TbsDownloader.getOverSea]  sOverSea = " + f1805j);
            }
            z = f1805j;
            AppMethodBeat.o(54142);
        }
        return z;
    }

    private static boolean b(final boolean z, boolean z2, boolean z3, boolean z4) {
        int i2;
        boolean z5;
        long j2;
        AppMethodBeat.i(54143);
        if (z) {
            TbsDownloadUpload instance = TbsDownloadUpload.getInstance(f1798c);
            instance.f1788a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, 144);
            instance.commit();
        } else if (!z3) {
            TbsDownloadUpload instance2 = TbsDownloadUpload.getInstance(f1798c);
            instance2.f1788a.put(TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE, Integer.valueOf((int) TbsListener.ErrorCode.STARTDOWNLOAD_5));
            instance2.commit();
        }
        if (!z && Apn.getApnType(f1798c) != 3 && !QbSdk.getDownloadWithoutWifi()) {
            TbsLog.i(LOGTAG, "current request is download,current network is not wifi,return!");
            AppMethodBeat.o(54143);
            return false;
        } else if (QbSdk.mSettings == null || !QbSdk.mSettings.containsKey(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD) || !QbSdk.mSettings.get(QbSdk.KEY_SET_SENDREQUEST_AND_UPLOAD).equals("false")) {
            q.a().b(f1798c, g.f2050a == 0);
            if (q.a().b(f1798c)) {
                TbsLog.i(LOGTAG, "need To Rename,no need to send request!");
                AppMethodBeat.o(54143);
                return false;
            }
            TbsLog.i(LOGTAG, "[TbsDownloader.sendRequest]isQuery: " + z + " forDecoupleCore is " + z3);
            if (q.a().d(f1798c)) {
                TbsLog.i(LOGTAG, "[TbsDownloader.sendRequest] -- isTbsLocalInstalled!");
                if (z) {
                    TbsDownloadUpload instance3 = TbsDownloadUpload.getInstance(f1798c);
                    instance3.f1788a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, 146);
                    instance3.commit();
                } else if (!z3) {
                    TbsDownloadUpload instance4 = TbsDownloadUpload.getInstance(f1798c);
                    instance4.f1788a.put(TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE, 166);
                    instance4.commit();
                }
                AppMethodBeat.o(54143);
                return false;
            }
            final TbsDownloadConfig instance5 = TbsDownloadConfig.getInstance(f1798c);
            File file = new File(f.a(f1798c, 1), getOverSea(f1798c) ? "x5.oversea.tbs.org" : getBackupFileName(false));
            File file2 = new File(f.a(f1798c, 2), getOverSea(f1798c) ? "x5.oversea.tbs.org" : getBackupFileName(false));
            File file3 = new File(f.a(f1798c, 3), getOverSea(f1798c) ? "x5.oversea.tbs.org" : getBackupFileName(false));
            File file4 = new File(f.a(f1798c, 4), getOverSea(f1798c) ? "x5.oversea.tbs.org" : getBackupFileName(false));
            if (!file4.exists()) {
                if (file3.exists()) {
                    file3.renameTo(file4);
                } else if (file2.exists()) {
                    file2.renameTo(file4);
                } else if (file.exists()) {
                    file.renameTo(file4);
                }
            }
            if (f1800e == null) {
                f1800e = b.b();
                instance5.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DEVICE_CPUABI, f1800e);
                instance5.commit();
            }
            boolean z6 = false;
            if (!TextUtils.isEmpty(f1800e)) {
                Matcher matcher = null;
                try {
                    matcher = Pattern.compile("i686|mips|x86_64").matcher(f1800e);
                } catch (Exception e2) {
                }
                if (matcher != null && matcher.find()) {
                    if (TbsShareManager.isThirdPartyApp(f1798c)) {
                        TbsLog.e(LOGTAG, "don't support x86 devices,skip send request");
                        TbsLogReport.TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(f1798c).tbsLogInfo();
                        if (z) {
                            instance5.setDownloadInterruptCode(-104);
                            tbsLogInfo.setErrorCode(-104);
                        } else {
                            instance5.setDownloadInterruptCode(-205);
                            tbsLogInfo.setErrorCode(-205);
                        }
                        tbsLogInfo.setFailDetail("mycpu is " + f1800e);
                        TbsLogReport.getInstance(f1798c).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, tbsLogInfo);
                    } else if (z) {
                        instance5.setDownloadInterruptCode(-104);
                    } else {
                        instance5.setDownloadInterruptCode(-205);
                    }
                    z6 = true;
                }
            }
            instance5.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONNAME, b.c(f1798c));
            instance5.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONCODE, Integer.valueOf(b.d(f1798c)));
            instance5.commit();
            JSONObject a2 = a(z, z2, z3);
            try {
                i2 = a2.getInt("TBSV");
            } catch (Exception e3) {
                i2 = -1;
            }
            if (z6 || i2 != -1) {
                long currentTimeMillis = System.currentTimeMillis();
                if (TbsShareManager.isThirdPartyApp(f1798c)) {
                    long j3 = instance5.mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_REQUEST_FAIL, 0);
                    long j4 = instance5.mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_COUNT_REQUEST_FAIL_IN_24HOURS, 0);
                    if (currentTimeMillis - j3 < instance5.getRetryInterval() * 1000) {
                        j2 = 1 + j4;
                    } else {
                        j2 = 1;
                    }
                    instance5.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_COUNT_REQUEST_FAIL_IN_24HOURS, Long.valueOf(j2));
                }
                instance5.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_REQUEST_FAIL, Long.valueOf(currentTimeMillis));
                instance5.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONNAME, b.c(f1798c));
                instance5.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_APP_VERSIONCODE, Integer.valueOf(b.d(f1798c)));
                instance5.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_APP_METADATA, b.a(f1798c, TBS_METADATA));
                instance5.commit();
                if (z6) {
                    if (z) {
                        TbsDownloadUpload instance6 = TbsDownloadUpload.getInstance(f1798c);
                        instance6.f1788a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, Integer.valueOf((int) TbsListener.ErrorCode.NEEDDOWNLOAD_8));
                        instance6.commit();
                    } else if (!z3) {
                        TbsDownloadUpload instance7 = TbsDownloadUpload.getInstance(f1798c);
                        instance7.f1788a.put(TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE, Integer.valueOf((int) TbsListener.ErrorCode.STARTDOWNLOAD_8));
                        instance7.commit();
                    }
                    AppMethodBeat.o(54143);
                    return false;
                }
            }
            if (i2 != -1 || z3) {
                try {
                    String d2 = n.a(f1798c).d();
                    TbsLog.i(LOGTAG, "[TbsDownloader.sendRequest] postUrl=".concat(String.valueOf(d2)));
                    if (z) {
                        TbsDownloadUpload instance8 = TbsDownloadUpload.getInstance(f1798c);
                        instance8.f1788a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, 148);
                        instance8.f1788a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_SENT, 1);
                        instance8.commit();
                        TbsLog.i(LOGTAG, "sendRequest query 148");
                    } else if (!z3) {
                        TbsDownloadUpload instance9 = TbsDownloadUpload.getInstance(f1798c);
                        instance9.f1788a.put(TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE, 168);
                        instance9.f1788a.put(TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_SENT, 1);
                        instance9.commit();
                        TbsLog.i(LOGTAG, "sendRequest download 168");
                    }
                    z5 = a(g.a(d2, a2.toString().getBytes(ProtocolPackage.ServerEncoding), new g.a() {
                        /* class com.tencent.smtt.sdk.TbsDownloader.AnonymousClass4 */

                        @Override // com.tencent.smtt.utils.g.a
                        public final void a(int i2) {
                            AppMethodBeat.i(54985);
                            instance5.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_LAST_CHECK, Long.valueOf(System.currentTimeMillis()));
                            instance5.commit();
                            TbsLog.i(TbsDownloader.LOGTAG, "[TbsDownloader.sendRequest] httpResponseCode=".concat(String.valueOf(i2)));
                            if (TbsShareManager.isThirdPartyApp(TbsDownloader.f1798c) && i2 == 200) {
                                instance5.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_LAST_REQUEST_SUCCESS, Long.valueOf(System.currentTimeMillis()));
                                instance5.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_REQUEST_FAIL, 0L);
                                instance5.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_COUNT_REQUEST_FAIL_IN_24HOURS, 0L);
                                instance5.commit();
                            }
                            if (i2 >= 300) {
                                if (z) {
                                    instance5.setDownloadInterruptCode(-107);
                                    AppMethodBeat.o(54985);
                                    return;
                                }
                                instance5.setDownloadInterruptCode(-207);
                            }
                            AppMethodBeat.o(54985);
                        }
                    }, false), i2, z, z2, z4);
                } catch (Throwable th) {
                    if (z) {
                        instance5.setDownloadInterruptCode(-106);
                        z5 = false;
                    } else {
                        instance5.setDownloadInterruptCode(-206);
                        z5 = false;
                    }
                }
            } else if (z) {
                TbsDownloadUpload instance10 = TbsDownloadUpload.getInstance(f1798c);
                instance10.f1788a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, 149);
                instance10.commit();
                z5 = false;
            } else {
                if (!z3) {
                    TbsDownloadUpload instance11 = TbsDownloadUpload.getInstance(f1798c);
                    instance11.f1788a.put(TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE, 169);
                    instance11.commit();
                }
                z5 = false;
            }
            AppMethodBeat.o(54143);
            return z5;
        } else {
            TbsLog.i(LOGTAG, "[TbsDownloader.sendRequest] -- SET_SENDREQUEST_AND_UPLOAD is false");
            if (z) {
                TbsDownloadUpload instance12 = TbsDownloadUpload.getInstance(f1798c);
                instance12.f1788a.put(TbsDownloadUpload.TbsUploadKey.KEY_NEEDDOWNLOAD_CODE, 145);
                instance12.commit();
            } else if (!z3) {
                TbsDownloadUpload instance13 = TbsDownloadUpload.getInstance(f1798c);
                instance13.f1788a.put(TbsDownloadUpload.TbsUploadKey.KEY_STARTDOWNLOAD_CODE, Integer.valueOf((int) TbsListener.ErrorCode.STARTDOWNLOAD_6));
                instance13.commit();
            }
            AppMethodBeat.o(54143);
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0355, code lost:
        if (r2 > 0) goto L_0x0357;
     */
    @android.annotation.TargetApi(11)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean a(java.lang.String r31, int r32, boolean r33, boolean r34, boolean r35) {
        /*
        // Method dump skipped, instructions count: 2158
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsDownloader.a(java.lang.String, int, boolean, boolean, boolean):boolean");
    }

    public static void setRetryIntervalInSeconds(Context context, long j2) {
        AppMethodBeat.i(54145);
        if (context == null) {
            AppMethodBeat.o(54145);
            return;
        }
        if (context.getApplicationInfo().packageName.equals("com.tencent.qqlive")) {
            l = j2;
        }
        TbsLog.i(LOGTAG, "mRetryIntervalInSeconds is " + l);
        AppMethodBeat.o(54145);
    }

    public static long getRetryIntervalInSeconds() {
        return l;
    }

    static String b(Context context) {
        String str;
        String str2;
        AppMethodBeat.i(54146);
        if (!TextUtils.isEmpty(f1797b)) {
            String str3 = f1797b;
            AppMethodBeat.o(54146);
            return str3;
        }
        Locale locale = Locale.getDefault();
        StringBuffer stringBuffer = new StringBuffer();
        String str4 = Build.VERSION.RELEASE;
        try {
            str = new String(str4.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET), "ISO8859-1");
        } catch (Exception e2) {
            str = str4;
        }
        if (str == null) {
            stringBuffer.append("1.0");
        } else if (str.length() > 0) {
            stringBuffer.append(str);
        } else {
            stringBuffer.append("1.0");
        }
        stringBuffer.append("; ");
        String language = locale.getLanguage();
        if (language != null) {
            stringBuffer.append(language.toLowerCase());
            String country = locale.getCountry();
            if (country != null) {
                stringBuffer.append("-");
                stringBuffer.append(country.toLowerCase());
            }
        } else {
            stringBuffer.append(LocaleUtil.ENGLISH);
        }
        if ("REL".equals(Build.VERSION.CODENAME)) {
            String str5 = Build.MODEL;
            try {
                str2 = new String(str5.getBytes(MimeTypeUtil.ContentType.DEFAULT_CHARSET), "ISO8859-1");
            } catch (Exception e3) {
                str2 = str5;
            }
            if (str2 == null) {
                stringBuffer.append("; ");
            } else if (str2.length() > 0) {
                stringBuffer.append("; ");
                stringBuffer.append(str2);
            }
        }
        String replaceAll = (Build.ID == null ? "" : Build.ID).replaceAll("[一-龥]", "");
        if (replaceAll == null) {
            stringBuffer.append(" Build/");
            stringBuffer.append("00");
        } else if (replaceAll.length() > 0) {
            stringBuffer.append(" Build/");
            stringBuffer.append(replaceAll);
        }
        String format = String.format("Mozilla/5.0 (Linux; U; Android %s) AppleWebKit/533.1 (KHTML, like Gecko)Version/4.0 Mobile Safari/533.1", stringBuffer);
        f1797b = format;
        AppMethodBeat.o(54146);
        return format;
    }

    private static String a(String str) {
        return str == null ? "" : str;
    }

    @TargetApi(11)
    static void c(Context context) {
        SharedPreferences sharedPreferences;
        SharedPreferences sharedPreferences2;
        AppMethodBeat.i(54147);
        TbsDownloadConfig.getInstance(context).clear();
        TbsLogReport.getInstance(context).clear();
        m.c(context);
        if (Build.VERSION.SDK_INT >= 11) {
            sharedPreferences = context.getSharedPreferences("tbs_extension_config", 4);
        } else {
            sharedPreferences = context.getSharedPreferences("tbs_extension_config", 0);
        }
        sharedPreferences.edit().clear().commit();
        if (Build.VERSION.SDK_INT >= 11) {
            sharedPreferences2 = context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4);
        } else {
            sharedPreferences2 = context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0);
        }
        sharedPreferences2.edit().clear().commit();
        AppMethodBeat.o(54147);
    }

    private static boolean h() {
        AppMethodBeat.i(54148);
        TbsDownloadConfig instance = TbsDownloadConfig.getInstance(f1798c);
        if (instance.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_SUCCESS_RETRYTIMES, 0) >= instance.getDownloadSuccessMaxRetrytimes()) {
            TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] out of success retrytimes", true);
            instance.setDownloadInterruptCode(-115);
            AppMethodBeat.o(54148);
            return false;
        } else if (instance.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_FAILED_RETRYTIMES, 0) >= instance.getDownloadFailedMaxRetrytimes()) {
            TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] out of failed retrytimes", true);
            instance.setDownloadInterruptCode(-116);
            AppMethodBeat.o(54148);
            return false;
        } else if (!f.b(f1798c)) {
            TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] local rom freespace limit", true);
            instance.setDownloadInterruptCode(-117);
            AppMethodBeat.o(54148);
            return false;
        } else {
            if (System.currentTimeMillis() - instance.mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_STARTTIME, 0) <= Util.MILLSECONDS_OF_DAY) {
                long j2 = instance.mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, 0);
                TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] downloadFlow=".concat(String.valueOf(j2)));
                if (j2 >= instance.getDownloadMaxflow()) {
                    TbsLog.i(LOGTAG, "[TbsDownloader.needStartDownload] failed because you exceeded max flow!", true);
                    instance.setDownloadInterruptCode(-120);
                    AppMethodBeat.o(54148);
                    return false;
                }
            }
            AppMethodBeat.o(54148);
            return true;
        }
    }

    protected static File a(int i2) {
        AppMethodBeat.i(54149);
        String[] coreProviderAppList = TbsShareManager.getCoreProviderAppList();
        File file = null;
        int length = coreProviderAppList.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            String str = coreProviderAppList[i3];
            if (!str.equals(f1798c.getApplicationInfo().packageName)) {
                file = new File(f.a(f1798c, str, 4, false), getOverSea(f1798c) ? "x5.oversea.tbs.org" : getBackupFileName(false));
                if (!file.exists()) {
                    TbsLog.i(LOGTAG, "can not find local backup core file");
                } else if (a.a(f1798c, file) == i2) {
                    TbsLog.i(LOGTAG, "local tbs version fond,path = " + file.getAbsolutePath());
                    break;
                } else {
                    TbsLog.i(LOGTAG, "version is not match");
                }
            }
            i3++;
        }
        AppMethodBeat.o(54149);
        return file;
    }

    protected static File b(int i2) {
        AppMethodBeat.i(54150);
        String[] coreProviderAppList = TbsShareManager.getCoreProviderAppList();
        File file = null;
        int length = coreProviderAppList.length;
        int i3 = 0;
        while (true) {
            if (i3 >= length) {
                break;
            }
            String str = coreProviderAppList[i3];
            File file2 = new File(f.a(f1798c, str, 4, false), getOverSea(f1798c) ? "x5.oversea.tbs.org" : getBackupFileName(false));
            if (file2.exists() && a.a(f1798c, file2) == i2) {
                TbsLog.i(LOGTAG, "local tbs version fond,path = " + file2.getAbsolutePath());
                file = file2;
                break;
            }
            file = new File(f.a(f1798c, str, 4, false), "x5.tbs.decouple");
            if (file.exists() && a.a(f1798c, file) == i2) {
                TbsLog.i(LOGTAG, "local tbs version fond,path = " + file.getAbsolutePath());
                break;
            }
            i3++;
        }
        AppMethodBeat.o(54150);
        return file;
    }

    private static JSONArray a(boolean z) {
        File file;
        boolean z2;
        AppMethodBeat.i(54151);
        JSONArray jSONArray = new JSONArray();
        String[] coreProviderAppList = TbsShareManager.getCoreProviderAppList();
        for (String str : coreProviderAppList) {
            if (z) {
                file = new File(f.a(f1798c, str, 4, false), getOverSea(f1798c) ? "x5.oversea.tbs.org" : getBackupFileName(false));
            } else {
                file = new File(f.a(f1798c, str, 4, false), "x5.tbs.decouple");
            }
            if (file.exists()) {
                long a2 = (long) a.a(f1798c, file);
                if (a2 > 0) {
                    int i2 = 0;
                    while (true) {
                        if (i2 >= jSONArray.length()) {
                            z2 = false;
                            break;
                        } else if (((long) jSONArray.optInt(i2)) == a2) {
                            z2 = true;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    if (!z2) {
                        jSONArray.put(a2);
                    }
                }
            }
        }
        AppMethodBeat.o(54151);
        return jSONArray;
    }
}
