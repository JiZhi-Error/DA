package com.tencent.mm.app;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.util.Base64;
import android.util.StringBuilderPrinter;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.a;
import com.tencent.mm.loader.j.c;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;
import com.tencent.recovery.wx.util.WXUtil;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public final class l {
    public static String f(final Application application) {
        AppMethodBeat.i(200802);
        final String bJ = bJ(application.getApplicationContext());
        if (!(MMApplicationContext.getApplicationId() + ":cuploader").equals(bJ)) {
            MMUncaughtExceptionHandler.setReporter(new MMUncaughtExceptionHandler.IReporter() {
                /* class com.tencent.mm.app.l.AnonymousClass1 */

                @Override // com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.IReporter
                public final void reportException(MMUncaughtExceptionHandler mMUncaughtExceptionHandler, String str, Throwable th) {
                    String str2;
                    AppMethodBeat.i(125022);
                    Log.e("MicroMsg.FirstCrashCatcher", "reportException()");
                    Context context = application;
                    String str3 = bJ;
                    Log.e("MicroMsg.FirstCrashCatcher", "reportThrowable:".concat(String.valueOf(str)));
                    try {
                        StringBuilder sb = new StringBuilder(2560);
                        StringBuilderPrinter stringBuilderPrinter = new StringBuilderPrinter(sb);
                        stringBuilderPrinter.println("#client.version=" + a.CLIENT_VERSION);
                        if (BuildInfo.DEBUG) {
                            stringBuilderPrinter.println("#accinfo.revision=123321123");
                        } else {
                            stringBuilderPrinter.println("#accinfo.revision=" + a.aKv());
                        }
                        String p = l.p(context, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                        if (p == null || p.equals(AppEventsConstants.EVENT_PARAM_VALUE_NO)) {
                            p = Integer.toString((Build.DEVICE + Build.FINGERPRINT + Build.MANUFACTURER + Build.MODEL).hashCode());
                        }
                        stringBuilderPrinter.println("#accinfo.uin=".concat(String.valueOf(p)));
                        stringBuilderPrinter.println("#accinfo.runtime=" + (Util.nowMilliSecond() - d.dkt) + "(" + (str3 == null ? "" : str3) + ") by cup");
                        if (BuildInfo.DEBUG) {
                            stringBuilderPrinter.println("#accinfo.build=99/88/2077 66:55 PM:amm-dev");
                        } else {
                            stringBuilderPrinter.println("#accinfo.build=" + a.TIME + ":" + a.HOSTNAME + ":0");
                        }
                        try {
                            o X = o.X(Environment.getDataDirectory());
                            StatFs statFs = new StatFs(aa.z(X.mUri));
                            StatFs statFs2 = new StatFs(l.bK(context));
                            str2 = String.format("%dMB %dMB %s:%d:%d:%d %s:%d:%d:%d", Integer.valueOf(((ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getMemoryClass()), Integer.valueOf(((ActivityManager) context.getSystemService(EnvConsts.ACTIVITY_MANAGER_SRVNAME)).getLargeMemoryClass()), aa.z(X.her()), Integer.valueOf(statFs.getBlockSize()), Integer.valueOf(statFs.getBlockCount()), Integer.valueOf(statFs.getAvailableBlocks()), l.bK(context), Integer.valueOf(statFs2.getBlockSize()), Integer.valueOf(statFs2.getBlockCount()), Integer.valueOf(statFs2.getAvailableBlocks()));
                        } catch (Exception e2) {
                            str2 = "";
                        }
                        af.e(th);
                        stringBuilderPrinter.println("#accinfo.data=".concat(String.valueOf(str2)));
                        stringBuilderPrinter.println("#accinfo.crashTime=" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSZ", Locale.getDefault()).format(new Date()));
                        stringBuilderPrinter.println("#crashContent=");
                        if (h.bH(context) == 1) {
                            str = str.substring(0, h.bI(context));
                        }
                        h.d(context, str3, "first");
                        stringBuilderPrinter.println(str);
                        Log.e("MicroMsg.FirstCrashCatcher", "cpu catch crash:".concat(String.valueOf(str)));
                        Intent intent = new Intent();
                        intent.setAction("INTENT_ACTION_UNCATCH");
                        intent.putExtra("INTENT_EXTRA_USER_NAME", context.getSharedPreferences(context.getPackageName() + "_preferences", 0).getString(WXUtil.LAST_LOGIN_USERNAME, "never_login_crash"));
                        intent.putExtra("INTENT_EXTRA_EXCEPTION_MSG", Base64.encodeToString(sb.toString().getBytes(), 2));
                        intent.putExtra("INTENT_EXTRA_DATA_PATH", context.getFilesDir().getParentFile().getAbsolutePath() + "/MicroMsg/crash/");
                        intent.putExtra("INTENT_EXTRA_SDCARD_PATH", l.bK(context) + "/tencent/MicroMsg/crash");
                        intent.putExtra("INTENT_EXTRA_UIN", l.p(context, AppEventsConstants.EVENT_PARAM_VALUE_NO));
                        intent.putExtra("INTENT_EXTRA_CLIENT_VERSION", a.CLIENT_VERSION);
                        intent.putExtra("INTENT_EXTRA_DEVICE_TYPE", a.ics);
                        intent.putExtra("INTENT_EXTRA_TAG", "exception");
                        SharedPreferences sharedPreferences = context.getSharedPreferences("system_config_prefs", 0);
                        StringBuilder sb2 = new StringBuilder(HttpWrapperBase.PROTOCAL_HTTP);
                        String str4 = c.icB;
                        intent.putExtra("INTENT_EXTRA_HOST", sb2.append(sharedPreferences.getString(str4, str4)).toString());
                        intent.setClassName(context, MMApplicationContext.getSourcePackageName() + ".crash.FirstCrashUploadBroadcastReceiver");
                        context.sendBroadcast(intent);
                        AppMethodBeat.o(125022);
                    } catch (Exception e3) {
                        AppMethodBeat.o(125022);
                    }
                }
            });
            MMUncaughtExceptionHandler.setAfterReport(new MMUncaughtExceptionHandler.IAfterReport() {
                /* class com.tencent.mm.app.l.AnonymousClass2 */

                @Override // com.tencent.mm.sdk.platformtools.MMUncaughtExceptionHandler.IAfterReport
                public final void afterReport() {
                    String str = a.ict;
                }
            });
        }
        AppMethodBeat.o(200802);
        return bJ;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x009d A[SYNTHETIC, Splitter:B:37:0x009d] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00a8 A[SYNTHETIC, Splitter:B:43:0x00a8] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String bJ(android.content.Context r8) {
        /*
        // Method dump skipped, instructions count: 192
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.app.l.bJ(android.content.Context):java.lang.String");
    }

    static String p(Context context, String str) {
        AppMethodBeat.i(200804);
        String string = context.getSharedPreferences(context.getPackageName() + "_preferences", 0).getString(WXUtil.LAST_LOGIN_UIN, str);
        AppMethodBeat.o(200804);
        return string;
    }

    static String bK(Context context) {
        AppMethodBeat.i(200805);
        if ("com.tencent.mm:isolated_process0".equalsIgnoreCase(bJ(context))) {
            AppMethodBeat.o(200805);
            return "/sdcard";
        }
        String absolutePath = Environment.getExternalStorageDirectory().getAbsolutePath();
        AppMethodBeat.o(200805);
        return absolutePath;
    }
}
