package com.tencent.mm.sandbox.monitor;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Parcel;
import com.facebook.internal.FacebookRequestErrorClassification;
import com.tencent.mm.b.c;
import com.tencent.mm.b.g;
import com.tencent.mm.b.p;
import com.tencent.mm.b.s;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sandbox.monitor.ErrLog;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.ErrorCode;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ConfigFile;
import com.tencent.mm.sdk.thread.ThreadPool;
import com.tencent.mm.storage.ar;
import com.tencent.sqlitelint.config.SharePluginInfo;
import java.io.File;
import java.io.FilenameFilter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Pattern;

public final class a {
    static final HashMap<String, Integer> gNk;

    static {
        HashMap<String, Integer> hashMap = new HashMap<>(16);
        gNk = hashMap;
        hashMap.put("exception", 10001);
        gNk.put("anr", 10002);
        gNk.put("handler", Integer.valueOf((int) ErrorCode.ERROR_SYSLIB_OPEN_JPEG_FAIL));
        gNk.put(SharePluginInfo.ISSUE_KEY_SQL, Integer.valueOf((int) ErrorCode.ERROR_SYSLIB_READHEAD_JPEG_FAIL));
        gNk.put("permission", 10005);
        gNk.put("main_thread_watch", 10006);
    }

    public static int gvV() {
        File file = new File(ar.NSe + "crash/");
        if (!file.exists()) {
            Log.w("MicroMsg.CrashUpload", "dkcrash checkUpload dir never create ?");
            return -1;
        } else if (file.isFile()) {
            file.delete();
            Log.w("MicroMsg.CrashUpload", "dkcrash is the fucking file ??");
            return -1;
        } else {
            String[] list = file.list(new FilenameFilter() {
                /* class com.tencent.mm.sandbox.monitor.a.AnonymousClass1 */

                public final boolean accept(File file, String str) {
                    if (str.endsWith(".crashlog") || str.endsWith(".preventcrashlog")) {
                        return true;
                    }
                    return false;
                }
            });
            if (list == null || list.length == 0) {
                return -1;
            }
            Pattern compile = Pattern.compile(".");
            for (String str : list) {
                String[] split = compile.split(str);
                if (split != null && split.length > 0) {
                    D(split[0], split.length >= 2 ? split[1] : "", str.endsWith(".preventcrashlog"));
                }
            }
            return 1;
        }
    }

    public static int gvW() {
        ErrLog.PreventError preventError;
        int i2;
        File file = new File(ar.NSe + "crashprevent/");
        if (!file.exists()) {
            Log.w("MicroMsg.CrashUpload", "checkPreventUpload dir never create ?");
            return -1;
        } else if (file.isFile()) {
            file.delete();
            Log.w("MicroMsg.CrashUpload", "checkPreventUpload:crash is the fucking file ??");
            return -1;
        } else {
            String[] list = file.list(new FilenameFilter() {
                /* class com.tencent.mm.sandbox.monitor.a.AnonymousClass2 */

                public final boolean accept(File file, String str) {
                    return str.endsWith(".crashlog");
                }
            });
            if (list == null || list.length == 0) {
                return -1;
            }
            int i3 = 1;
            int length = list.length;
            for (int i4 = 0; i4 < length; i4++) {
                String str = ar.NSe + "crashprevent/" + list[i4];
                try {
                    byte[] bhJ = d.bhJ(str);
                    if (Util.isNullOrNil(bhJ)) {
                        preventError = null;
                    } else {
                        Parcel obtain = Parcel.obtain();
                        obtain.unmarshall(bhJ, 0, bhJ.length);
                        obtain.setDataPosition(0);
                        preventError = (ErrLog.PreventError) obtain.readParcelable(ErrLog.PreventError.class.getClassLoader());
                    }
                    if (preventError != null) {
                        String str2 = preventError.processName;
                        Log.i("MicroMsg.CrashSecondReport", "secondReportCrash() process:%s", str2);
                        if (Util.isEqual(str2, "mm")) {
                            h.INSTANCE.idkeyStat(1185, 21, 1, true);
                        } else if (Util.isEqual(str2, "push")) {
                            h.INSTANCE.idkeyStat(1185, 22, 1, true);
                        } else if (Util.isEqual(str2, FacebookRequestErrorClassification.KEY_OTHER)) {
                            h.INSTANCE.idkeyStat(1185, 23, 1, true);
                        }
                        Log.i("MicroMsg.CrashUpload", "checkPreventUpload processName:%s crashPreventPath:%s", preventError.processName, str);
                        if (a(preventError.username, preventError.tag, preventError.NEe, str, true) == 0) {
                            i2 = 0;
                        } else {
                            i2 = i3;
                        }
                        i3 = i2;
                    }
                } catch (Exception e2) {
                    d.deleteFile(str);
                    Log.e("MicroMsg.CrashUpload", "checkPreventUpload crashPreventPath:%s Exception:%s %s", str, e2.getClass().getSimpleName(), e2.getMessage());
                    h.INSTANCE.idkeyStat(1185, 51, 1, true);
                }
            }
            return i3;
        }
    }

    private static int D(String str, String str2, boolean z) {
        String str3;
        String str4 = ar.NSe + "crash/" + str + "." + str2 + ".crashini";
        long nullAsNil = Util.nullAsNil(ConfigFile.getLongValue(str4, "count"));
        long nowMilliSecond = Util.nowMilliSecond() - Util.nullAsNil(ConfigFile.getLongValue(str4, "lasttime"));
        if (z) {
            str3 = ar.NSe + "crash/" + str + "." + str2 + ".preventcrashlog";
        } else {
            str3 = ar.NSe + "crash/" + str + "." + str2 + ".crashlog";
        }
        int bhI = d.bhI(str3);
        Log.d("MicroMsg.CrashUpload", "dkcrash count:" + nullAsNil + " t:" + nowMilliSecond + " len:" + bhI);
        if (bhI < 5242880) {
            bn(str, str2, str3);
        }
        d.deleteFile(str3);
        ConfigFile.saveValue(str4, "count", 0);
        ConfigFile.saveValue(str4, "lasttime", Util.nowMilliSecond());
        return 1;
    }

    private static void bn(final String str, final String str2, String str3) {
        byte[] bhJ = d.bhJ(str3);
        if (!Util.isNullOrNil(bhJ)) {
            final int length = bhJ.length;
            final String lowerCase = g.getMessageDigest(String.format("weixin#$()%d%d", Integer.valueOf(d.KyO), Integer.valueOf(length)).getBytes()).toLowerCase();
            byte[] compress = s.compress(bhJ);
            final PByteArray pByteArray = new PByteArray();
            c.a(pByteArray, compress, lowerCase.getBytes());
            ThreadPool.post(new Runnable() {
                /* class com.tencent.mm.sandbox.monitor.a.AnonymousClass3 */

                public final void run() {
                    SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0);
                    StringBuilder sb = new StringBuilder(HttpWrapperBase.PROTOCAL_HTTP);
                    String str = com.tencent.mm.network.c.icB;
                    StringBuilder append = new StringBuilder().append(sb.append(sharedPreferences.getString(str, str)).toString()).append("/cgi-bin/mmsupport-bin/stackreport?version=").append(Integer.toHexString(d.KyO)).append("&devicetype=").append(d.ics).append("&filelength=").append(length).append("&sum=").append(lowerCase).append("&reporttype=1&NewReportType=").append(Util.nullAsNil(a.gNk.get(str2)));
                    if (str != null && !str.equals("")) {
                        append.append("&username=").append(str);
                    }
                    Log.d("MicroMsg.CrashUpload", "dkcrash sb:" + append.toString());
                    a.z(append.toString(), pByteArray.value);
                }
            }, "CrashUpload_upload");
        }
    }

    public static int a(String str, String str2, ErrLog.Error error, String str3, boolean z) {
        String str4;
        if (error == null || Util.isNullOrNil(error.toString())) {
            return -1;
        }
        File file = new File(ar.NSe + "crash/");
        if (!file.exists()) {
            file.mkdir();
        }
        String str5 = ar.NSe + "crash/" + str + "." + str2 + ".crashini";
        ConfigFile.saveValue(str5, "count", Util.nullAsNil(ConfigFile.getLongValue(str5, "count")) + 1);
        if (Util.nullAsNil(ConfigFile.getLongValue(str5, "lasttime")) == 0) {
            ConfigFile.saveValue(str5, "lasttime", Util.nowMilliSecond());
        }
        if (z) {
            str4 = ar.NSe + "crash/" + str + "." + str2 + ".preventcrashlog";
        } else {
            str4 = ar.NSe + "crash/" + str + "." + str2 + ".crashlog";
        }
        Log.d("MicroMsg.CrashUpload", "crash:[%s] len:[%d]", str4, Integer.valueOf(error.toString().length()));
        a(error);
        a(str4, error);
        if (!Util.isNullOrNil(str3)) {
            d.deleteFile(str3);
        }
        return D(str, str2, z);
    }

    public static String bt(Intent intent) {
        if (intent == null) {
            return "";
        }
        try {
            String stringExtra = intent.getStringExtra("tag");
            if (stringExtra == null) {
                stringExtra = "exception";
            }
            return ar.NSe + "crashprevent/" + intent.getStringExtra("userName") + "." + stringExtra + "." + cl.aWy() + ".crashlog";
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.CrashUpload", e2, "", new Object[0]);
            return "";
        }
    }

    public static void p(Intent intent, String str) {
        if (intent != null && !Util.isNullOrNil(str)) {
            File file = new File(ar.NSe + "crashprevent/");
            if (!file.exists()) {
                file.mkdir();
            }
            try {
                String stringExtra = intent.getStringExtra("tag");
                if (stringExtra == null) {
                    stringExtra = "exception";
                }
                String stringExtra2 = intent.getStringExtra("exceptionMsg");
                String stringExtra3 = intent.getStringExtra("userName");
                boolean booleanExtra = intent.getBooleanExtra("exceptionWriteSdcard", true);
                String stringExtra4 = intent.getStringExtra("exceptionProcess");
                ErrLog.Error error = new ErrLog.Error(stringExtra3, stringExtra, Util.nowSecond(), stringExtra2, booleanExtra);
                ErrLog.PreventError preventError = new ErrLog.PreventError(stringExtra3, stringExtra, error, stringExtra4);
                Parcel obtain = Parcel.obtain();
                obtain.writeParcelable(preventError, 0);
                d.A(str, obtain.marshall());
                Log.i("MicroMsg.CrashUpload", "crashPreventPath:[%s] len:[%d]", str, Integer.valueOf(error.toString().length()));
                if (MMApplicationContext.isMainProcess()) {
                    Log.i("MicroMsg.CrashSecondReport", "reportWritePreventCrashFile() process:mm");
                    h.INSTANCE.idkeyStat(1185, 31, 1, true);
                } else if (MMApplicationContext.isPushProcess()) {
                    Log.i("MicroMsg.CrashSecondReport", "reportWritePreventCrashFile() process:push");
                    h.INSTANCE.idkeyStat(1185, 32, 1, true);
                } else {
                    Log.i("MicroMsg.CrashSecondReport", "reportWritePreventCrashFile() process:other");
                    h.INSTANCE.idkeyStat(1185, 33, 1, true);
                }
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.CrashUpload", e2, "", new Object[0]);
            }
        }
    }

    private static void a(ErrLog.Error error) {
        if (error.NEd) {
            File file = new File(b.aKL());
            if (!file.exists()) {
                file.mkdirs();
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (Util.milliSecondsToNow(file2.lastModified()) > 604800000) {
                        Log.i("MicroMsg.CrashUpload", "dealWithSdcardCrash del old file: %s", file2.getPath());
                        file2.delete();
                    }
                }
            }
            Date date = new Date();
            String str = b.aKL() + "crash_" + new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(date) + ".txt";
            Log.i("MicroMsg.CrashUpload", "dealWithSdcardCrash %s", str);
            a(str, error);
        }
    }

    private static void a(String str, ErrLog.Error error) {
        if (!new File(str).exists()) {
            int i2 = MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", 0).getInt("default_uin", 0);
            StringBuilder sb = new StringBuilder();
            if (i2 == 0) {
                String dr = q.dr(false);
                if (!Util.isNullOrNil(dr)) {
                    sb.append("uin[" + dr + "] ");
                } else {
                    sb.append("uin[" + Integer.toString((Build.DEVICE + Build.FINGERPRINT + Build.MANUFACTURER + Build.MODEL).hashCode()) + "] ");
                }
            } else {
                sb.append("uin[" + p.getString(i2) + "] ");
            }
            sb.append(Log.getSysInfo());
            sb.append(" BRAND:[" + Build.BRAND + "] ");
            String[] aoN = q.aoN();
            sb.append("c1[" + aoN[0] + "] ");
            sb.append("c2[" + aoN[1] + "] ");
            sb.append("\n");
            d.A(str, sb.toString().getBytes());
        }
        if (d.bhI(str) > 10485760) {
            d.deleteFile(str);
        }
        d.A(str, (error.toString() + "\n").getBytes());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x005d, code lost:
        r3 = com.tencent.mm.sdk.platformtools.XmlParser.parseXml(r1, "Response", null);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void z(java.lang.String r11, byte[] r12) {
        /*
        // Method dump skipped, instructions count: 214
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.sandbox.monitor.a.z(java.lang.String, byte[]):void");
    }
}
