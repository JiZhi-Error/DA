package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.a;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.f;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class TbsShareManager {

    /* renamed from: a  reason: collision with root package name */
    private static Context f1874a;

    /* renamed from: b  reason: collision with root package name */
    private static String f1875b = null;

    /* renamed from: c  reason: collision with root package name */
    private static String f1876c = null;

    /* renamed from: d  reason: collision with root package name */
    private static int f1877d = 0;

    /* renamed from: e  reason: collision with root package name */
    private static String f1878e = null;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f1879f = false;

    /* renamed from: g  reason: collision with root package name */
    private static boolean f1880g = false;

    /* renamed from: h  reason: collision with root package name */
    private static boolean f1881h = false;

    /* renamed from: i  reason: collision with root package name */
    private static String f1882i = null;

    /* renamed from: j  reason: collision with root package name */
    private static boolean f1883j = false;
    private static boolean k = false;
    public static boolean mHasQueryed = false;

    static void a(Context context) {
        AppMethodBeat.i(54896);
        TbsLog.i("TbsShareManager", "shareTbsCore #1");
        try {
            TbsLinuxToolsJni tbsLinuxToolsJni = new TbsLinuxToolsJni(context);
            a(context, tbsLinuxToolsJni, q.a().r(context));
            File s = q.a().s(context);
            TbsLog.i("TbsShareManager", "shareTbsCore tbsShareDir is " + s.getAbsolutePath());
            tbsLinuxToolsJni.a(s.getAbsolutePath(), "755");
            AppMethodBeat.o(54896);
        } catch (Throwable th) {
            TbsLog.i("TbsShareManager", "shareTbsCore tbsShareDir error is " + th.getMessage() + " ## " + th.getCause());
            AppMethodBeat.o(54896);
        }
    }

    static void b(Context context) {
        AppMethodBeat.i(54897);
        try {
            a(context, new TbsLinuxToolsJni(context), q.a().q(context));
            AppMethodBeat.o(54897);
        } catch (Throwable th) {
            AppMethodBeat.o(54897);
        }
    }

    private static void a(Context context, TbsLinuxToolsJni tbsLinuxToolsJni, File file) {
        AppMethodBeat.i(54898);
        TbsLog.i("TbsShareManager", "shareAllDirsAndFiles #1");
        if (file == null || !file.exists() || !file.isDirectory()) {
            AppMethodBeat.o(54898);
            return;
        }
        TbsLog.i("TbsShareManager", "shareAllDirsAndFiles dir is " + file.getAbsolutePath());
        tbsLinuxToolsJni.a(file.getAbsolutePath(), "755");
        File[] listFiles = file.listFiles();
        for (File file2 : listFiles) {
            if (file2.isFile()) {
                if (file2.getAbsolutePath().indexOf(".so") > 0) {
                    tbsLinuxToolsJni.a(file2.getAbsolutePath(), "755");
                } else {
                    tbsLinuxToolsJni.a(file2.getAbsolutePath(), "644");
                }
            } else if (file2.isDirectory()) {
                a(context, tbsLinuxToolsJni, file2);
            } else {
                TbsLog.e("TbsShareManager", "unknown file type.", true);
            }
        }
        AppMethodBeat.o(54898);
    }

    public static void setHostCorePathAppDefined(String str) {
        f1875b = str;
    }

    public static String getHostCorePathAppDefined() {
        return f1875b;
    }

    public static boolean isThirdPartyApp(Context context) {
        return false;
    }

    public static String[] getCoreProviderAppList() {
        return new String[]{TbsConfig.APP_DEMO, "com.tencent.mm", TbsConfig.APP_QQ, TbsConfig.APP_QZONE, "com.tencent.qqlite"};
    }

    public static long getHostCoreVersions(Context context) {
        AppMethodBeat.i(54899);
        long j2 = 0;
        String[] coreProviderAppList = getCoreProviderAppList();
        for (String str : coreProviderAppList) {
            if (str.equalsIgnoreCase("com.tencent.mm")) {
                j2 += ((long) getSharedTbsCoreVersion(context, str)) * 10000000000L;
            } else if (str.equalsIgnoreCase(TbsConfig.APP_QQ)) {
                j2 += ((long) getSharedTbsCoreVersion(context, str)) * 100000;
            } else if (str.equalsIgnoreCase(TbsConfig.APP_QZONE)) {
                j2 += (long) getSharedTbsCoreVersion(context, str);
            }
        }
        AppMethodBeat.o(54899);
        return j2;
    }

    public static int getSharedTbsCoreVersion(Context context, String str) {
        AppMethodBeat.i(54900);
        Context packageContext = getPackageContext(context, str, true);
        if (packageContext != null) {
            int j2 = q.a().j(packageContext);
            AppMethodBeat.o(54900);
            return j2;
        }
        AppMethodBeat.o(54900);
        return 0;
    }

    public static int getCoreShareDecoupleCoreVersion(Context context, String str) {
        AppMethodBeat.i(54901);
        Context packageContext = getPackageContext(context, str, true);
        if (packageContext != null) {
            int i2 = q.a().i(packageContext);
            AppMethodBeat.o(54901);
            return i2;
        }
        AppMethodBeat.o(54901);
        return 0;
    }

    public static int getBackupCoreVersion(Context context, String str) {
        int i2 = 0;
        AppMethodBeat.i(54902);
        try {
            File file = new File(new File(f.a(getPackageContext(context, str, false), 4)), TbsDownloader.getBackupFileName(false));
            if (file.exists()) {
                i2 = a.b(file);
                AppMethodBeat.o(54902);
                return i2;
            }
        } catch (Throwable th) {
        }
        AppMethodBeat.o(54902);
        return i2;
    }

    public static int getBackupDecoupleCoreVersion(Context context, String str) {
        int i2 = 0;
        AppMethodBeat.i(54903);
        try {
            File file = new File(new File(f.a(getPackageContext(context, str, false), 4)), TbsDownloader.getBackupFileName(true));
            if (file.exists()) {
                i2 = a.b(file);
                AppMethodBeat.o(54903);
                return i2;
            }
        } catch (Throwable th) {
        }
        AppMethodBeat.o(54903);
        return i2;
    }

    public static File getBackupCoreFile(Context context, String str) {
        AppMethodBeat.i(54904);
        try {
            File file = new File(new File(f.a(getPackageContext(context, str, false), 4)), TbsDownloader.getBackupFileName(false));
            if (file.exists()) {
                AppMethodBeat.o(54904);
                return file;
            }
        } catch (Throwable th) {
        }
        AppMethodBeat.o(54904);
        return null;
    }

    public static File getBackupDecoupleCoreFile(Context context, String str) {
        AppMethodBeat.i(54905);
        try {
            File file = new File(new File(f.a(getPackageContext(context, str, true), 4)), TbsDownloader.getBackupFileName(true));
            if (file.exists()) {
                AppMethodBeat.o(54905);
                return file;
            }
        } catch (Throwable th) {
        }
        AppMethodBeat.o(54905);
        return null;
    }

    public static boolean getCoreDisabled() {
        return f1879f;
    }

    static String c(Context context) {
        AppMethodBeat.i(54906);
        j(context);
        String str = f1876c;
        AppMethodBeat.o(54906);
        return str;
    }

    static String a() {
        return f1876c;
    }

    static int d(Context context) {
        AppMethodBeat.i(54907);
        int a2 = a(context, true);
        AppMethodBeat.o(54907);
        return a2;
    }

    static int a(Context context, boolean z) {
        AppMethodBeat.i(54908);
        b(context, z);
        int i2 = f1877d;
        AppMethodBeat.o(54908);
        return i2;
    }

    static Context e(Context context) {
        Context context2 = null;
        AppMethodBeat.i(54909);
        j(context);
        if (f1878e != null) {
            Context packageContext = getPackageContext(context, f1878e, true);
            if (q.a().g(packageContext)) {
                context2 = packageContext;
            }
        }
        if (f1875b != null) {
            Context context3 = f1874a;
            AppMethodBeat.o(54909);
            return context3;
        }
        AppMethodBeat.o(54909);
        return context2;
    }

    private static boolean k(Context context) {
        AppMethodBeat.i(54910);
        if (f1878e == null) {
            AppMethodBeat.o(54910);
            return false;
        } else if (f1877d == getSharedTbsCoreVersion(context, f1878e)) {
            AppMethodBeat.o(54910);
            return true;
        } else if (f1877d == getCoreShareDecoupleCoreVersion(context, f1878e)) {
            AppMethodBeat.o(54910);
            return true;
        } else {
            AppMethodBeat.o(54910);
            return false;
        }
    }

    private static boolean l(Context context) {
        AppMethodBeat.i(54911);
        if (QbSdk.getOnlyDownload()) {
            AppMethodBeat.o(54911);
            return false;
        }
        String[] coreProviderAppList = getCoreProviderAppList();
        for (String str : coreProviderAppList) {
            if (f1877d > 0 && f1877d == getSharedTbsCoreVersion(context, str)) {
                Context packageContext = getPackageContext(context, str, true);
                if (q.a().g(context)) {
                    f1876c = q.a().b(context, packageContext).getAbsolutePath();
                    f1878e = str;
                    AppMethodBeat.o(54911);
                    return true;
                }
            }
        }
        for (String str2 : coreProviderAppList) {
            if (f1877d > 0 && f1877d == getCoreShareDecoupleCoreVersion(context, str2)) {
                Context packageContext2 = getPackageContext(context, str2, true);
                if (q.a().g(context)) {
                    f1876c = q.a().c(context, packageContext2).getAbsolutePath();
                    f1878e = str2;
                    AppMethodBeat.o(54911);
                    return true;
                }
            }
        }
        AppMethodBeat.o(54911);
        return false;
    }

    public static int findCoreForThirdPartyApp(Context context) {
        boolean z;
        AppMethodBeat.i(54912);
        n(context);
        TbsLog.i("TbsShareManager", "core_info mAvailableCoreVersion is " + f1877d + " mAvailableCorePath is " + f1876c + " mSrcPackageName is " + f1878e);
        if (f1878e == null) {
            TbsLog.e("TbsShareManager", "mSrcPackageName is null !!!");
        }
        if (f1878e == null || !f1878e.equals("AppDefined")) {
            if (!k(context) && !l(context)) {
                f1877d = 0;
                f1876c = null;
                f1878e = null;
                TbsLog.i("TbsShareManager", "core_info error checkCoreInfo is false and checkCoreInOthers is false ");
            }
        } else if (f1877d != q.a().a(f1875b)) {
            f1877d = 0;
            f1876c = null;
            f1878e = null;
            TbsLog.i("TbsShareManager", "check AppDefined core is error src is " + f1877d + " dest is " + q.a().a(f1875b));
        }
        if (f1877d > 0) {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (!("com.tencent.android.qqdownloader".equals(applicationInfo.packageName) || "com.jd.jrapp".equals(applicationInfo.packageName))) {
                z = QbSdk.a(context, f1877d);
            } else {
                z = false;
            }
            if (z || f1879f) {
                f1877d = 0;
                f1876c = null;
                f1878e = null;
                TbsLog.i("TbsShareManager", "core_info error QbSdk.isX5Disabled ");
            }
        }
        int i2 = f1877d;
        AppMethodBeat.o(54912);
        return i2;
    }

    private static boolean m(Context context) {
        AppMethodBeat.i(54913);
        if (context == null) {
            AppMethodBeat.o(54913);
            return false;
        }
        writeProperties(context, Integer.toString(0), "", "", Integer.toString(0));
        AppMethodBeat.o(54913);
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0081 A[SYNTHETIC, Splitter:B:24:0x0081] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0086 A[SYNTHETIC, Splitter:B:27:0x0086] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0098 A[SYNTHETIC, Splitter:B:35:0x0098] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x009d A[SYNTHETIC, Splitter:B:38:0x009d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void c(android.content.Context r9, boolean r10) {
        /*
        // Method dump skipped, instructions count: 185
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsShareManager.c(android.content.Context, boolean):void");
    }

    public static boolean forceLoadX5FromTBSDemo(Context context) {
        AppMethodBeat.i(54915);
        if (context == null || q.a().a(context, (File[]) null)) {
            AppMethodBeat.o(54915);
            return false;
        }
        int sharedTbsCoreVersion = getSharedTbsCoreVersion(context, TbsConfig.APP_DEMO);
        if (sharedTbsCoreVersion > 0) {
            writeProperties(context, Integer.toString(sharedTbsCoreVersion), TbsConfig.APP_DEMO, q.a().r(getPackageContext(context, TbsConfig.APP_DEMO, true)).getAbsolutePath(), "1");
            AppMethodBeat.o(54915);
            return true;
        }
        AppMethodBeat.o(54915);
        return false;
    }

    public static synchronized void writeCoreInfoForThirdPartyApp(Context context, int i2, boolean z) {
        boolean z2 = true;
        synchronized (TbsShareManager.class) {
            AppMethodBeat.i(54916);
            TbsLog.i("TbsShareManager", "writeCoreInfoForThirdPartyApp coreVersion is ".concat(String.valueOf(i2)));
            if (i2 == 0) {
                m(context);
                TbsDownloadConfig.getInstance(f1874a).setDownloadInterruptCode(-401);
                AppMethodBeat.o(54916);
            } else {
                int h2 = h(context);
                TbsLog.i("TbsShareManager", "writeCoreInfoForThirdPartyApp coreVersionFromConfig is ".concat(String.valueOf(h2)));
                if (h2 < 0) {
                    TbsDownloadConfig.getInstance(f1874a).setDownloadInterruptCode(-402);
                    AppMethodBeat.o(54916);
                } else if (i2 == h2) {
                    if (d(context) == 0 && !z) {
                        a(context, i2);
                    }
                    c(context, z);
                    TbsDownloadConfig.getInstance(f1874a).setDownloadInterruptCode(-403);
                    AppMethodBeat.o(54916);
                } else if (i2 < h2) {
                    m(context);
                    TbsDownloadConfig.getInstance(f1874a).setDownloadInterruptCode(-404);
                    AppMethodBeat.o(54916);
                } else {
                    int j2 = q.a().j(context);
                    TbsLog.i("TbsShareManager", "writeCoreInfoForThirdPartyApp coreVersionFromCoreShare is ".concat(String.valueOf(j2)));
                    if (i2 < j2) {
                        m(context);
                        TbsDownloadConfig.getInstance(f1874a).setDownloadInterruptCode(-404);
                        AppMethodBeat.o(54916);
                    } else {
                        String[] d2 = d(context, z);
                        if (f1875b != null) {
                            if (i2 == q.a().a(f1875b)) {
                                writeProperties(context, Integer.toString(i2), "AppDefined", f1875b, Integer.toString(1));
                                try {
                                    File tbsShareFile = getTbsShareFile(context, "core_info");
                                    if (!f1881h && tbsShareFile != null) {
                                        TbsLinuxToolsJni tbsLinuxToolsJni = new TbsLinuxToolsJni(f1874a);
                                        tbsLinuxToolsJni.a(tbsShareFile.getAbsolutePath(), "644");
                                        tbsLinuxToolsJni.a(q.a().s(context).getAbsolutePath(), "755");
                                        f1881h = true;
                                    }
                                    AppMethodBeat.o(54916);
                                } catch (Throwable th) {
                                    AppMethodBeat.o(54916);
                                }
                            } else if (i2 > q.a().a(f1875b)) {
                                int length = d2.length;
                                int i3 = 0;
                                while (true) {
                                    if (i3 >= length) {
                                        break;
                                    }
                                    String str = d2[i3];
                                    if (i2 == getSharedTbsCoreVersion(context, str)) {
                                        Context packageContext = getPackageContext(context, str, true);
                                        String absolutePath = q.a().r(packageContext).getAbsolutePath();
                                        b.d(context);
                                        if (q.a().g(packageContext)) {
                                            try {
                                                f.a(new File(absolutePath), new File(f1875b), new FileFilter() {
                                                    /* class com.tencent.smtt.sdk.TbsShareManager.AnonymousClass1 */

                                                    public final boolean accept(File file) {
                                                        AppMethodBeat.i(54986);
                                                        if (!file.getName().endsWith(ShareConstants.DEX_SUFFIX)) {
                                                            AppMethodBeat.o(54986);
                                                            return true;
                                                        }
                                                        AppMethodBeat.o(54986);
                                                        return false;
                                                    }
                                                });
                                                writeProperties(context, Integer.toString(i2), "AppDefined", f1875b, Integer.toString(1));
                                                File tbsShareFile2 = getTbsShareFile(context, "core_info");
                                                if (!f1881h && tbsShareFile2 != null) {
                                                    TbsLinuxToolsJni tbsLinuxToolsJni2 = new TbsLinuxToolsJni(f1874a);
                                                    tbsLinuxToolsJni2.a(tbsShareFile2.getAbsolutePath(), "644");
                                                    tbsLinuxToolsJni2.a(q.a().s(context).getAbsolutePath(), "755");
                                                    f1881h = true;
                                                }
                                                AppMethodBeat.o(54916);
                                            } catch (Throwable th2) {
                                                AppMethodBeat.o(54916);
                                            }
                                        }
                                    }
                                    i3++;
                                }
                            }
                        }
                        int length2 = d2.length;
                        int i4 = 0;
                        while (true) {
                            if (i4 >= length2) {
                                z2 = false;
                                break;
                            }
                            String str2 = d2[i4];
                            if (i2 == getSharedTbsCoreVersion(context, str2)) {
                                Context packageContext2 = getPackageContext(context, str2, true);
                                String absolutePath2 = q.a().r(packageContext2).getAbsolutePath();
                                int d3 = b.d(context);
                                if (q.a().g(packageContext2)) {
                                    if (!str2.equals(context.getApplicationContext().getPackageName())) {
                                        TbsLog.i("TbsShareManager", "thirdAPP pre--> delete old core_share Directory:".concat(String.valueOf(i2)));
                                        n.a(f1874a).a("remove_old_core", 1);
                                    }
                                    writeProperties(context, Integer.toString(i2), str2, absolutePath2, Integer.toString(d3));
                                    try {
                                        File tbsShareFile3 = getTbsShareFile(context, "core_info");
                                        if (!f1881h && tbsShareFile3 != null) {
                                            TbsLinuxToolsJni tbsLinuxToolsJni3 = new TbsLinuxToolsJni(f1874a);
                                            tbsLinuxToolsJni3.a(tbsShareFile3.getAbsolutePath(), "644");
                                            tbsLinuxToolsJni3.a(q.a().s(context).getAbsolutePath(), "755");
                                            f1881h = true;
                                        }
                                    } catch (Throwable th3) {
                                    }
                                }
                            } else if (i2 == getCoreShareDecoupleCoreVersion(context, str2)) {
                                Context packageContext3 = getPackageContext(context, str2, true);
                                String absolutePath3 = q.a().q(packageContext3).getAbsolutePath();
                                int d4 = b.d(context);
                                if (q.a().g(packageContext3)) {
                                    if (!str2.equals(context.getApplicationContext().getPackageName())) {
                                        TbsLog.i("TbsShareManager", "thirdAPP pre--> delete old core_share Directory:".concat(String.valueOf(i2)));
                                        try {
                                            f.b(q.a().r(context));
                                            TbsLog.i("TbsShareManager", "thirdAPP success--> delete old core_share Directory");
                                        } catch (Throwable th4) {
                                        }
                                    }
                                    writeProperties(context, Integer.toString(i2), str2, absolutePath3, Integer.toString(d4));
                                    try {
                                        File tbsShareFile4 = getTbsShareFile(context, "core_info");
                                        if (!f1881h && tbsShareFile4 != null) {
                                            TbsLinuxToolsJni tbsLinuxToolsJni4 = new TbsLinuxToolsJni(f1874a);
                                            tbsLinuxToolsJni4.a(tbsShareFile4.getAbsolutePath(), "644");
                                            tbsLinuxToolsJni4.a(q.a().s(context).getAbsolutePath(), "755");
                                            f1881h = true;
                                        }
                                    } catch (Throwable th5) {
                                    }
                                }
                            } else {
                                continue;
                            }
                            i4++;
                        }
                        if (!z2 && !z) {
                            a(context, i2);
                        }
                        AppMethodBeat.o(54916);
                    }
                }
            }
        }
    }

    private static String[] d(Context context, boolean z) {
        String[] coreProviderAppList;
        AppMethodBeat.i(54917);
        if (QbSdk.getOnlyDownload()) {
            coreProviderAppList = new String[]{context.getApplicationContext().getPackageName()};
        } else {
            coreProviderAppList = getCoreProviderAppList();
            if (z) {
                coreProviderAppList = new String[]{context.getApplicationContext().getPackageName()};
            }
        }
        AppMethodBeat.o(54917);
        return coreProviderAppList;
    }

    private static void a(Context context, int i2) {
        AppMethodBeat.i(54918);
        if (!TbsPVConfig.getInstance(f1874a).isDisableHostBackupCore() && q.a().u(context)) {
            String[] strArr = {TbsConfig.APP_DEMO, "com.tencent.mm", TbsConfig.APP_QQ, TbsConfig.APP_QZONE, context.getPackageName()};
            TbsLog.i("TbsShareManager", "find host backup core to unzip #1" + Log.getStackTraceString(new Throwable()));
            int i3 = 0;
            while (true) {
                if (i3 >= 5) {
                    break;
                }
                String str = strArr[i3];
                if (i2 == getBackupCoreVersion(context, str)) {
                    if (q.a().g(getPackageContext(context, str, false))) {
                        File backupCoreFile = getBackupCoreFile(context, str);
                        if (a.a(context, backupCoreFile, 0, i2)) {
                            TbsLog.i("TbsShareManager", "find host backup core to unzip normal coreVersion is " + i2 + " packageName is " + str);
                            q.a().b(context, backupCoreFile, i2);
                            break;
                        }
                    } else {
                        continue;
                    }
                } else if (i2 == getBackupDecoupleCoreVersion(context, str)) {
                    if (q.a().g(getPackageContext(context, str, false))) {
                        File backupDecoupleCoreFile = getBackupDecoupleCoreFile(context, str);
                        if (a.a(context, backupDecoupleCoreFile, 0, i2)) {
                            TbsLog.i("TbsShareManager", "find host backup core to unzip decouple coreVersion is " + i2 + " packageName is " + str);
                            q.a().b(context, backupDecoupleCoreFile, i2);
                            break;
                        }
                    } else {
                        continue;
                    }
                } else {
                    continue;
                }
                i3++;
            }
            q.a().b();
        }
        AppMethodBeat.o(54918);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00db A[SYNTHETIC, Splitter:B:25:0x00db] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00e0 A[SYNTHETIC, Splitter:B:28:0x00e0] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00f8 A[SYNTHETIC, Splitter:B:38:0x00f8] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00fd A[SYNTHETIC, Splitter:B:41:0x00fd] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void writeProperties(android.content.Context r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11) {
        /*
        // Method dump skipped, instructions count: 285
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsShareManager.writeProperties(android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x005c A[SYNTHETIC, Splitter:B:28:0x005c] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006a A[SYNTHETIC, Splitter:B:34:0x006a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static synchronized java.lang.String f(android.content.Context r6) {
        /*
        // Method dump skipped, instructions count: 130
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsShareManager.f(android.content.Context):java.lang.String");
    }

    static String g(Context context) {
        AppMethodBeat.i(54921);
        try {
            n(context);
            if (f1876c == null || TextUtils.isEmpty(f1876c)) {
                AppMethodBeat.o(54921);
                return null;
            }
            String str = f1876c + File.separator + "res.apk";
            AppMethodBeat.o(54921);
            return str;
        } catch (Throwable th) {
            new StringBuilder("getTbsResourcesPath exception: ").append(Log.getStackTraceString(th));
            AppMethodBeat.o(54921);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x0089 A[SYNTHETIC, Splitter:B:31:0x0089] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a1 A[SYNTHETIC, Splitter:B:37:0x00a1] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static synchronized int h(android.content.Context r6) {
        /*
        // Method dump skipped, instructions count: 184
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsShareManager.h(android.content.Context):int");
    }

    public static boolean getCoreFormOwn() {
        return f1883j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:45:0x0103 A[SYNTHETIC, Splitter:B:45:0x0103] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x010e A[SYNTHETIC, Splitter:B:51:0x010e] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void n(android.content.Context r8) {
        /*
        // Method dump skipped, instructions count: 297
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsShareManager.n(android.content.Context):void");
    }

    public static void forceToLoadX5ForThirdApp(Context context, boolean z) {
        int a2;
        AppMethodBeat.i(54924);
        try {
            if (!QbSdk.isNeedInitX5FirstTime()) {
                AppMethodBeat.o(54924);
            } else if (!isThirdPartyApp(context)) {
                AppMethodBeat.o(54924);
            } else if (QbSdk.getOnlyDownload()) {
                AppMethodBeat.o(54924);
            } else {
                File s = q.a().s(context);
                if (s == null) {
                    AppMethodBeat.o(54924);
                } else if (z && new File(s, "core_info").exists()) {
                    AppMethodBeat.o(54924);
                } else if (f1875b == null || (a2 = q.a().a(f1875b)) <= 0) {
                    TbsLog.i("TbsShareManager", "forceToLoadX5ForThirdApp #1");
                    int h2 = h(context);
                    int j2 = q.a().j(context);
                    TbsLog.i("TbsShareManager", "forceToLoadX5ForThirdApp coreVersionFromConfig is ".concat(String.valueOf(h2)));
                    TbsLog.i("TbsShareManager", "forceToLoadX5ForThirdApp coreVersionFromCoreShare is ".concat(String.valueOf(j2)));
                    String[] coreProviderAppList = getCoreProviderAppList();
                    for (String str : coreProviderAppList) {
                        int coreShareDecoupleCoreVersion = getCoreShareDecoupleCoreVersion(context, str);
                        if (coreShareDecoupleCoreVersion >= h2 && coreShareDecoupleCoreVersion >= j2 && coreShareDecoupleCoreVersion > 0) {
                            f1876c = q.a().c(context, getPackageContext(context, str, true)).getAbsolutePath();
                            f1878e = str;
                            f1877d = coreShareDecoupleCoreVersion;
                            TbsLog.i("TbsShareManager", "forceToLoadX5ForThirdApp #2 -- mAvailableCoreVersion: " + f1877d + " " + Log.getStackTraceString(new Throwable("#")));
                            if (QbSdk.canLoadX5FirstTimeThirdApp(context)) {
                                int d2 = b.d(context);
                                TbsLog.i("TbsShareManager", "forceToLoadX5ForThirdApp #2");
                                writeProperties(context, Integer.toString(f1877d), f1878e, f1876c, Integer.toString(d2));
                                AppMethodBeat.o(54924);
                                return;
                            }
                            f1877d = 0;
                            f1876c = null;
                            f1878e = null;
                        }
                    }
                    for (String str2 : coreProviderAppList) {
                        int sharedTbsCoreVersion = getSharedTbsCoreVersion(context, str2);
                        if (sharedTbsCoreVersion >= h2 && sharedTbsCoreVersion >= j2 && sharedTbsCoreVersion > 0) {
                            f1876c = q.a().b(context, getPackageContext(context, str2, true)).getAbsolutePath();
                            f1878e = str2;
                            f1877d = sharedTbsCoreVersion;
                            TbsLog.i("TbsShareManager", "forceToLoadX5ForThirdApp #3 -- mAvailableCoreVersion: " + f1877d + " " + Log.getStackTraceString(new Throwable("#")));
                            if (QbSdk.canLoadX5FirstTimeThirdApp(context)) {
                                writeProperties(context, Integer.toString(f1877d), f1878e, f1876c, Integer.toString(b.d(context)));
                                AppMethodBeat.o(54924);
                                return;
                            }
                            f1877d = 0;
                            f1876c = null;
                            f1878e = null;
                        }
                    }
                    if (!TbsPVConfig.getInstance(f1874a).isDisableHostBackupCore()) {
                        if (Thread.currentThread() != Looper.getMainLooper().getThread()) {
                            for (String str3 : coreProviderAppList) {
                                int backupCoreVersion = getBackupCoreVersion(context, str3);
                                if (backupCoreVersion < h2 || backupCoreVersion < j2 || backupCoreVersion <= 0) {
                                    int backupDecoupleCoreVersion = getBackupDecoupleCoreVersion(context, str3);
                                    if (backupDecoupleCoreVersion >= h2 && backupDecoupleCoreVersion >= j2 && backupDecoupleCoreVersion > 0) {
                                        TbsLog.i("TbsShareManager", "find host backup core to unzip forceload decouple coreVersion is " + backupDecoupleCoreVersion + " packageName is " + str3);
                                        q.a().a(context, getBackupCoreFile(context, str3), backupDecoupleCoreVersion);
                                        TbsLog.i("TbsShareManager", "find host backup decouple core to unzip forceload after unzip ");
                                        AppMethodBeat.o(54924);
                                        return;
                                    }
                                } else {
                                    TbsLog.i("TbsShareManager", "find host backup core to unzip forceload coreVersion is " + backupCoreVersion + " packageName is " + str3);
                                    q.a().a(context, getBackupCoreFile(context, str3), backupCoreVersion);
                                    TbsLog.i("TbsShareManager", "find host backup core to unzip forceload after unzip ");
                                    AppMethodBeat.o(54924);
                                    return;
                                }
                            }
                            AppMethodBeat.o(54924);
                            return;
                        }
                        TbsLog.i("TbsShareManager", "in mainthread so do not find host backup core to install ");
                    }
                    AppMethodBeat.o(54924);
                } else {
                    f1876c = f1875b;
                    f1878e = "AppDefined";
                    f1877d = a2;
                    TbsLog.i("TbsShareManager", "forceToLoadX5ForThirdApp #1 -- mAvailableCoreVersion: " + f1877d + " " + Log.getStackTraceString(new Throwable("#")));
                    writeProperties(context, Integer.toString(f1877d), f1878e, f1876c, Integer.toString(1));
                    AppMethodBeat.o(54924);
                }
            }
        } catch (Exception e2) {
            AppMethodBeat.o(54924);
        }
    }

    public static File getTbsShareFile(Context context, String str) {
        AppMethodBeat.i(54925);
        File s = q.a().s(context);
        if (s == null) {
            AppMethodBeat.o(54925);
            return null;
        }
        File file = new File(s, str);
        if (file.exists()) {
            AppMethodBeat.o(54925);
            return file;
        }
        try {
            file.createNewFile();
            AppMethodBeat.o(54925);
            return file;
        } catch (IOException e2) {
            AppMethodBeat.o(54925);
            return null;
        }
    }

    static boolean i(Context context) {
        AppMethodBeat.i(54926);
        try {
            if (f1877d == 0) {
                findCoreForThirdPartyApp(context);
            }
            if (f1877d == 0) {
                TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_NO_SHARE_X5CORE, null, new Object[0]);
                AppMethodBeat.o(54926);
                return false;
            }
            if (f1875b == null) {
                if (f1877d != 0 && getSharedTbsCoreVersion(context, f1878e) == f1877d) {
                    AppMethodBeat.o(54926);
                    return true;
                }
            } else if (f1877d != 0 && q.a().a(f1875b) == f1877d) {
                AppMethodBeat.o(54926);
                return true;
            }
            if (l(context)) {
                AppMethodBeat.o(54926);
                return true;
            }
            TbsCoreLoadStat.getInstance().setLoadErrorCode(context, 418, new Throwable("mAvailableCoreVersion=" + f1877d + "; mSrcPackageName=" + f1878e + "; getSharedTbsCoreVersion(ctx, mSrcPackageName) is " + getSharedTbsCoreVersion(context, f1878e) + "; getHostCoreVersions is " + getHostCoreVersions(context)));
            f1876c = null;
            f1877d = 0;
            TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_CONFLICT_X5CORE, null, new Object[0]);
            QbSdk.a(context, "TbsShareManager::isShareTbsCoreAvailableInner forceSysWebViewInner!");
            AppMethodBeat.o(54926);
            return false;
        } catch (Throwable th) {
            TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_UNAVAIL_X5CORE, null, new Object[0]);
            AppMethodBeat.o(54926);
            return false;
        }
    }

    static boolean j(Context context) {
        AppMethodBeat.i(54927);
        boolean b2 = b(context, true);
        AppMethodBeat.o(54927);
        return b2;
    }

    static boolean b(Context context, boolean z) {
        AppMethodBeat.i(54928);
        if (i(context)) {
            AppMethodBeat.o(54928);
            return true;
        }
        if (z) {
            QbSdk.a(context, "TbsShareManager::isShareTbsCoreAvailable forceSysWebViewInner!");
        }
        AppMethodBeat.o(54928);
        return false;
    }

    public static Context getPackageContext(Context context, String str, boolean z) {
        AppMethodBeat.i(54929);
        if (z) {
            try {
                if (!context.getPackageName().equals(str) && TbsPVConfig.getInstance(context).isEnableNoCoreGray()) {
                    TbsLog.i("TbsShareManager", "gray no core app,skip get context");
                    AppMethodBeat.o(54929);
                    return null;
                }
            } catch (PackageManager.NameNotFoundException e2) {
                AppMethodBeat.o(54929);
                return null;
            } catch (Exception e3) {
                AppMethodBeat.o(54929);
                return null;
            }
        }
        Context createPackageContext = context.createPackageContext(str, 2);
        AppMethodBeat.o(54929);
        return createPackageContext;
    }
}
