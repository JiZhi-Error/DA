package com.tencent.smtt.sdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hardcoder.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.smtt.sdk.TbsDownloadConfig;
import com.tencent.smtt.sdk.TbsLogReport;
import com.tencent.smtt.utils.Apn;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.a;
import com.tencent.smtt.utils.b;
import com.tencent.smtt.utils.f;
import com.tencent.smtt.utils.q;
import com.tencent.tav.core.ExportErrorStatus;
import com.tencent.youtu.sdkkitframework.common.CommonUtils;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

/* access modifiers changed from: package-private */
public class m {

    /* renamed from: d  reason: collision with root package name */
    private static int f2087d = 5;

    /* renamed from: e  reason: collision with root package name */
    private static int f2088e = 1;

    /* renamed from: f  reason: collision with root package name */
    private static final String[] f2089f = {"tbs_downloading_com.tencent.mtt", "tbs_downloading_com.tencent.mm", "tbs_downloading_com.tencent.mobileqq", "tbs_downloading_com.tencent.tbs", "tbs_downloading_com.qzone"};
    private Set<String> A;
    private int B = f2087d;
    private boolean C;

    /* renamed from: a  reason: collision with root package name */
    String f2090a;

    /* renamed from: b  reason: collision with root package name */
    String[] f2091b = null;

    /* renamed from: c  reason: collision with root package name */
    int f2092c = 0;

    /* renamed from: g  reason: collision with root package name */
    private Context f2093g;

    /* renamed from: h  reason: collision with root package name */
    private String f2094h;

    /* renamed from: i  reason: collision with root package name */
    private String f2095i;

    /* renamed from: j  reason: collision with root package name */
    private String f2096j;
    private File k;
    private long l;
    private int m = CommonUtils.MAX_TIMEOUT_MS;
    private int n = g.sHCENCODEVIDEOTIMEOUT;
    private boolean o;
    private int p;
    private int q;
    private boolean r;
    private boolean s;
    private HttpURLConnection t;
    private String u;
    private TbsLogReport.TbsLogInfo v;
    private String w;
    private int x;
    private boolean y;
    private Handler z;

    static /* synthetic */ boolean a(m mVar) {
        AppMethodBeat.i(188383);
        boolean m2 = mVar.m();
        AppMethodBeat.o(188383);
        return m2;
    }

    public m(Context context) {
        AppMethodBeat.i(188346);
        this.f2093g = context.getApplicationContext();
        this.v = TbsLogReport.getInstance(this.f2093g).tbsLogInfo();
        this.A = new HashSet();
        this.u = "tbs_downloading_" + this.f2093g.getPackageName();
        q.a();
        this.k = q.t(this.f2093g);
        if (this.k == null) {
            NullPointerException nullPointerException = new NullPointerException("TbsCorePrivateDir is null!");
            AppMethodBeat.o(188346);
            throw nullPointerException;
        }
        e();
        this.w = null;
        this.x = -1;
        AppMethodBeat.o(188346);
    }

    private void e() {
        this.p = 0;
        this.q = 0;
        this.l = -1;
        this.f2096j = null;
        this.o = false;
        this.r = false;
        this.s = false;
        this.y = false;
    }

    private void a(String str) {
        AppMethodBeat.i(188347);
        URL url = new URL(str);
        if (this.t != null) {
            try {
                this.t.disconnect();
            } catch (Throwable th) {
                TbsLog.e(TbsDownloader.LOGTAG, "[initHttpRequest] mHttpRequest.disconnect() Throwable:" + th.toString());
            }
        }
        this.t = (HttpURLConnection) url.openConnection();
        this.t.setRequestProperty("User-Agent", TbsDownloader.b(this.f2093g));
        this.t.setRequestProperty("Accept-Encoding", "identity");
        this.t.setRequestMethod("GET");
        this.t.setInstanceFollowRedirects(false);
        this.t.setConnectTimeout(this.n);
        this.t.setReadTimeout(this.m);
        AppMethodBeat.o(188347);
    }

    private void f() {
        AppMethodBeat.i(188348);
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.closeHttpRequest]");
        if (this.t != null) {
            if (!this.r) {
                this.v.setResolveIp(a(this.t.getURL()));
            }
            try {
                this.t.disconnect();
            } catch (Throwable th) {
                TbsLog.e(TbsDownloader.LOGTAG, "[closeHttpRequest] mHttpRequest.disconnect() Throwable:" + th.toString());
            }
            this.t = null;
        }
        int i2 = this.v.f1821a;
        if (this.r || !this.y) {
            TbsDownloader.f1796a = false;
            AppMethodBeat.o(188348);
            return;
        }
        this.v.setEventTime(System.currentTimeMillis());
        String apnInfo = Apn.getApnInfo(this.f2093g);
        if (apnInfo == null) {
            apnInfo = "";
        }
        int apnType = Apn.getApnType(this.f2093g);
        this.v.setApn(apnInfo);
        this.v.setNetworkType(apnType);
        if (apnType != this.x || !apnInfo.equals(this.w)) {
            this.v.setNetworkChange(0);
        }
        if ((this.v.f1821a == 0 || this.v.f1821a == 107) && this.v.getDownFinalFlag() == 0) {
            if (!Apn.isNetworkAvailable(this.f2093g)) {
                a(101, (String) null, true);
            } else if (!k()) {
                a(101, (String) null, true);
            }
        }
        if (TbsDownloader.a(this.f2093g)) {
            TbsLogReport.getInstance(this.f2093g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE, this.v);
        } else {
            TbsLogReport.getInstance(this.f2093g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, this.v);
        }
        this.v.resetArgs();
        if (i2 != 100) {
            QbSdk.l.onDownloadFinish(i2);
        }
        AppMethodBeat.o(188348);
    }

    private boolean b(int i2) {
        AppMethodBeat.i(188349);
        try {
            File file = new File(this.k, "x5.tbs");
            File a2 = a(this.f2093g);
            if (a2 != null) {
                File file2 = new File(a2, TbsDownloader.getOverSea(this.f2093g) ? "x5.oversea.tbs.org" : TbsDownloader.getBackupFileName(false));
                file.delete();
                f.b(file2, file);
                if (!a.a(this.f2093g, file, 0, i2)) {
                    TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.copyTbsApkFromBackupToInstall] verifyTbsApk error!!");
                    AppMethodBeat.o(188349);
                    return false;
                }
                AppMethodBeat.o(188349);
                return true;
            }
            AppMethodBeat.o(188349);
            return false;
        } catch (Exception e2) {
            TbsLog.e(TbsDownloader.LOGTAG, "[TbsApkDownloader.copyTbsApkFromBackupToInstall] Exception is " + e2.getMessage());
            AppMethodBeat.o(188349);
            return false;
        }
    }

    public boolean a(boolean z2, boolean z3) {
        int i2;
        boolean z4;
        File g2;
        AppMethodBeat.i(188350);
        if (Build.VERSION.SDK_INT == 23) {
            AppMethodBeat.o(188350);
            return false;
        }
        int i3 = TbsDownloadConfig.getInstance(this.f2093g).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_USE_BACKUP_VERSION, 0);
        int j2 = q.a().j(this.f2093g);
        if (i3 == 0) {
            int i4 = TbsDownloadConfig.getInstance(this.f2093g).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
            this.f2090a = "by default key";
            i2 = i4;
        } else {
            this.f2090a = "by new key";
            i2 = i3;
        }
        if (i2 == 0 || i2 == j2) {
            AppMethodBeat.o(188350);
            return false;
        }
        if (z3) {
            File a2 = TbsDownloader.a(i2);
            if (a2 != null && a2.exists()) {
                File file = new File(f.a(this.f2093g, 4), TbsDownloader.getOverSea(this.f2093g) ? "x5.oversea.tbs.org" : TbsDownloader.getBackupFileName(false));
                try {
                    if (TbsDownloadConfig.getInstance(this.f2093g).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) != 1) {
                        f.b(a2, file);
                        z4 = true;
                        g2 = g();
                        if (g2 != null || !g2.exists() || !a(g2)) {
                            h();
                            if (a2 != null && a2.exists() && !a.a(this.f2093g, a2, 0, i2) && a2 != null && a2.exists()) {
                                f.b(a2);
                            }
                        } else if (b(i2)) {
                            TbsDownloadConfig.getInstance(this.f2093g).mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, -214);
                            TbsDownloadConfig.getInstance(this.f2093g).setDownloadInterruptCode(-214);
                            c(false);
                            if (z4) {
                                a(100, "use local backup apk in startDownload" + this.f2090a, true);
                                if (TbsDownloader.a(this.f2093g)) {
                                    TbsLogReport.getInstance(this.f2093g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE, this.v);
                                } else {
                                    TbsLogReport.getInstance(this.f2093g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, this.v);
                                }
                                this.v.resetArgs();
                            }
                            AppMethodBeat.o(188350);
                            return true;
                        }
                    }
                } catch (Exception e2) {
                }
            }
            z4 = false;
            g2 = g();
            if (g2 != null) {
            }
            h();
            f.b(a2);
        }
        if (c(false, z3)) {
            TbsDownloadConfig.getInstance(this.f2093g).mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, -214);
            TbsDownloadConfig.getInstance(this.f2093g).setDownloadInterruptCode(-214);
            c(false);
            AppMethodBeat.o(188350);
            return true;
        }
        if (!d(true) && !d(true)) {
            TbsLog.e(TbsDownloader.LOGTAG, "[TbsApkDownloader] delete file failed!");
            TbsDownloadConfig.getInstance(this.f2093g).setDownloadInterruptCode(-301);
        }
        AppMethodBeat.o(188350);
        return false;
    }

    public boolean a() {
        AppMethodBeat.i(188351);
        TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #1");
        try {
            File file = new File(f.a(this.f2093g, 4), TbsDownloader.getBackupFileName(true));
            if (file.exists()) {
                TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #2");
            } else {
                File b2 = TbsDownloader.b(TbsDownloadConfig.getInstance(this.f2093g).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, -1));
                if (b2 != null && b2.exists()) {
                    f.b(b2, file);
                }
            }
            if (a.a(this.f2093g, file, 0, TbsDownloadConfig.getInstance(this.f2093g).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, -1))) {
                TbsLog.i("TbsApkDownloader", "verifyAndInstallDecoupleCoreFromBackup #3");
                boolean f2 = q.a().f(this.f2093g);
                AppMethodBeat.o(188351);
                return f2;
            }
        } catch (Exception e2) {
        }
        AppMethodBeat.o(188351);
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:286:0x0ab3, code lost:
        a(r18);
        a(r16);
        a(r17);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:287:0x0acc, code lost:
        if (r30.s != false) goto L_0x0adb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:288:0x0ace, code lost:
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r30.f2093g).setDownloadInterruptCode(-319);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:289:0x0adb, code lost:
        if (r31 != false) goto L_0x021c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:290:0x0add, code lost:
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r30.f2093g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(r4));
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r30.f2093g).commit();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:379:0x0e8f, code lost:
        if (r31 != false) goto L_0x021c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:380:0x0e91, code lost:
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r30.f2093g).mSyncMap.put(com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey.KEY_TBSDOWNLOAD_FLOW, java.lang.Long.valueOf(r4));
        com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r30.f2093g).commit();
     */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x05eb  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0636  */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x0865 A[Catch:{ all -> 0x0bd8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:227:0x0896  */
    /* JADX WARNING: Removed duplicated region for block: B:418:0x0ecd A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:434:0x01f4 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:440:0x01f4 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0222  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(boolean r31, boolean r32) {
        /*
        // Method dump skipped, instructions count: 3980
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.m.b(boolean, boolean):void");
    }

    public boolean a(boolean z2) {
        AppMethodBeat.i(188353);
        if (z2 && !m() && (!QbSdk.getDownloadWithoutWifi() || !Apn.isNetworkAvailable(this.f2093g))) {
            AppMethodBeat.o(188353);
            return false;
        } else if (this.f2091b == null || this.f2092c < 0 || this.f2092c >= this.f2091b.length) {
            AppMethodBeat.o(188353);
            return false;
        } else {
            String[] strArr = this.f2091b;
            int i2 = this.f2092c;
            this.f2092c = i2 + 1;
            this.f2096j = strArr[i2];
            this.p = 0;
            this.q = 0;
            this.l = -1;
            this.o = false;
            this.r = false;
            this.s = false;
            this.y = false;
            AppMethodBeat.o(188353);
            return true;
        }
    }

    private long a(long j2, long j3) {
        AppMethodBeat.i(188354);
        long currentTimeMillis = System.currentTimeMillis();
        this.v.setDownConsumeTime(currentTimeMillis - j2);
        this.v.setDownloadSize(j3);
        AppMethodBeat.o(188354);
        return currentTimeMillis;
    }

    private void a(int i2, String str, boolean z2) {
        AppMethodBeat.i(188355);
        if (z2 || this.p > this.B) {
            this.v.setErrorCode(i2);
            this.v.setFailDetail(str);
        }
        AppMethodBeat.o(188355);
    }

    private String a(Throwable th) {
        AppMethodBeat.i(188356);
        String stackTraceString = Log.getStackTraceString(th);
        if (stackTraceString.length() > 1024) {
            String substring = stackTraceString.substring(0, 1024);
            AppMethodBeat.o(188356);
            return substring;
        }
        AppMethodBeat.o(188356);
        return stackTraceString;
    }

    private void c(boolean z2) {
        AppMethodBeat.i(188357);
        q.a(this.f2093g);
        TbsDownloadConfig instance = TbsDownloadConfig.getInstance(this.f2093g);
        instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_FULL_PACKAGE, Boolean.FALSE);
        instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.FALSE);
        instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_DOWNLOAD_INTERRUPT_CODE_REASON, Integer.valueOf((int) ExportErrorStatus.END_WRITE_VIDEO_SAMPLE));
        instance.commit();
        QbSdk.l.onDownloadFinish(z2 ? 100 : 120);
        int i2 = instance.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, 0);
        boolean a2 = TbsDownloader.a(this.f2093g);
        if (i2 == 5) {
            Bundle a3 = a(i2, a2);
            if (a3 == null) {
                AppMethodBeat.o(188357);
                return;
            }
            q.a().b(this.f2093g, a3);
            AppMethodBeat.o(188357);
        } else if (i2 == 3 || i2 > 10000) {
            File a4 = a(this.f2093g);
            if (a4 != null) {
                q.a().b(this.f2093g, a(i2, a4, a2));
                AppMethodBeat.o(188357);
                return;
            }
            c();
            instance.mSyncMap.put(TbsDownloadConfig.TbsConfigKey.KEY_NEEDDOWNLOAD, Boolean.TRUE);
            instance.commit();
            AppMethodBeat.o(188357);
        } else {
            q.a().a(this.f2093g, new File(this.k, "x5.tbs").getAbsolutePath(), instance.mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
            a(new File(this.k, "x5.tbs"), this.f2093g);
            AppMethodBeat.o(188357);
        }
    }

    public Bundle a(int i2, boolean z2) {
        File r2;
        int j2;
        String str;
        File f2;
        AppMethodBeat.i(188358);
        if (z2) {
            r2 = q.a().q(this.f2093g);
            j2 = q.a().i(this.f2093g);
        } else {
            r2 = q.a().r(this.f2093g);
            j2 = q.a().j(this.f2093g);
        }
        File file = new File(this.k, "x5.tbs");
        if (file.exists()) {
            str = file.getAbsolutePath();
        } else {
            str = null;
        }
        if (str == null) {
            AppMethodBeat.o(188358);
            return null;
        }
        int i3 = TbsDownloadConfig.getInstance(this.f2093g).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
        if (z2) {
            f2 = q.a().f(this.f2093g, 6);
        } else {
            f2 = q.a().f(this.f2093g, 5);
        }
        Bundle bundle = new Bundle();
        bundle.putInt("operation", i2);
        bundle.putInt("old_core_ver", j2);
        bundle.putInt("new_core_ver", i3);
        bundle.putString("old_apk_location", r2.getAbsolutePath());
        bundle.putString("new_apk_location", f2.getAbsolutePath());
        bundle.putString("diff_file_location", str);
        String a2 = f.a(this.f2093g, 7);
        File file2 = new File(a2);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        bundle.putString("backup_apk", new File(a2, i3 + ".tbs").getAbsolutePath());
        AppMethodBeat.o(188358);
        return bundle;
    }

    public Bundle a(int i2, File file, boolean z2) {
        File file2;
        AppMethodBeat.i(188359);
        if (z2) {
            file2 = new File(file, TbsDownloader.getBackupFileName(true));
        } else {
            file2 = new File(file, TbsDownloader.getOverSea(this.f2093g) ? "x5.oversea.tbs.org" : TbsDownloader.getBackupFileName(false));
        }
        int a2 = a.a(this.f2093g, file2);
        File file3 = new File(this.k, "x5.tbs");
        String absolutePath = file3.exists() ? file3.getAbsolutePath() : null;
        int i3 = TbsDownloadConfig.getInstance(this.f2093g).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
        Bundle bundle = new Bundle();
        bundle.putInt("operation", i2);
        bundle.putInt("old_core_ver", a2);
        bundle.putInt("new_core_ver", i3);
        bundle.putString("old_apk_location", file2.getAbsolutePath());
        bundle.putString("new_apk_location", absolutePath);
        bundle.putString("diff_file_location", absolutePath);
        AppMethodBeat.o(188359);
        return bundle;
    }

    private void a(Closeable closeable) {
        AppMethodBeat.i(188360);
        if (closeable != null) {
            try {
                closeable.close();
                AppMethodBeat.o(188360);
                return;
            } catch (IOException e2) {
            }
        }
        AppMethodBeat.o(188360);
    }

    private void a(long j2) {
        AppMethodBeat.i(188361);
        this.p++;
        if (j2 <= 0) {
            try {
                j2 = l();
            } catch (Exception e2) {
                AppMethodBeat.o(188361);
                return;
            }
        }
        Thread.sleep(j2);
        AppMethodBeat.o(188361);
    }

    private File g() {
        File file;
        AppMethodBeat.i(188362);
        File file2 = new File(f.a(this.f2093g, 4), TbsDownloader.getOverSea(this.f2093g) ? "x5.oversea.tbs.org" : TbsDownloader.getBackupFileName(false));
        if (TbsDownloader.a(this.f2093g)) {
            file = new File(f.a(this.f2093g, 4), TbsDownloader.getBackupFileName(true));
        } else {
            file = file2;
        }
        AppMethodBeat.o(188362);
        return file;
    }

    private boolean a(File file) {
        AppMethodBeat.i(188363);
        int i2 = TbsDownloadConfig.getInstance(this.f2093g).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_USE_BACKUP_VERSION, 0);
        if (i2 == 0) {
            i2 = TbsDownloadConfig.getInstance(this.f2093g).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0);
        }
        boolean a2 = a.a(this.f2093g, file, 0, i2);
        AppMethodBeat.o(188363);
        return a2;
    }

    private boolean c(boolean z2, boolean z3) {
        boolean z4;
        Exception exc;
        int i2;
        long j2;
        long j3 = 0;
        AppMethodBeat.i(188364);
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] isTempFile=".concat(String.valueOf(z2)));
        File file = new File(this.k, !z2 ? "x5.tbs" : "x5.tbs.temp");
        if (!file.exists()) {
            AppMethodBeat.o(188364);
            return false;
        }
        String string = TbsDownloadConfig.getInstance(this.f2093g).mPreferences.getString(TbsDownloadConfig.TbsConfigKey.KEY_TBSAPK_MD5, null);
        String a2 = a.a(file);
        if (string == null || !string.equals(a2)) {
            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z2 + " md5 failed");
            if (z2) {
                this.v.setCheckErrorDetail("fileMd5 not match");
            }
            AppMethodBeat.o(188364);
            return false;
        }
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] md5(" + a2 + ") successful!");
        if (z2) {
            long j4 = TbsDownloadConfig.getInstance(this.f2093g).mPreferences.getLong(TbsDownloadConfig.TbsConfigKey.KEY_TBSAPKFILESIZE, 0);
            if (!file.exists()) {
                j2 = 0;
            } else if (j4 > 0) {
                j2 = file.length();
                if (j4 == j2) {
                    j3 = j2;
                }
            }
            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z2 + " filelength failed");
            this.v.setCheckErrorDetail("fileLength:" + j2 + ",contentLength:" + j4);
            AppMethodBeat.o(188364);
            return false;
        }
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] length(" + j3 + ") successful!");
        int i3 = -1;
        if (!z3 || z2 || (i2 = TbsDownloadConfig.getInstance(this.f2093g).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0)) == (i3 = a.a(this.f2093g, file))) {
            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] tbsApkVersionCode(" + i3 + ") successful!");
            if (z3 && !z2) {
                String a3 = b.a(this.f2093g, false, file);
                if (!"3082023f308201a8a00302010202044c46914a300d06092a864886f70d01010505003064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f301e170d3130303732313036313835305a170d3430303731333036313835305a3064310b30090603550406130238363110300e060355040813074265696a696e673110300e060355040713074265696a696e673110300e060355040a130754656e63656e74310c300a060355040b13035753443111300f0603550403130873616d75656c6d6f30819f300d06092a864886f70d010101050003818d0030818902818100c209077044bd0d63ea00ede5b839914cabcc912a87f0f8b390877e0f7a2583f0d5933443c40431c35a4433bc4c965800141961adc44c9625b1d321385221fd097e5bdc2f44a1840d643ab59dc070cf6c4b4b4d98bed5cbb8046e0a7078ae134da107cdf2bfc9b440fe5cb2f7549b44b73202cc6f7c2c55b8cfb0d333a021f01f0203010001300d06092a864886f70d010105050003818100b007db9922774ef4ccfee81ba514a8d57c410257e7a2eba64bfa17c9e690da08106d32f637ac41fbc9f205176c71bde238c872c3ee2f8313502bee44c80288ea4ef377a6f2cdfe4d3653c145c4acfedbfbadea23b559d41980cc3cdd35d79a68240693739aabf5c5ed26148756cf88264226de394c8a24ac35b712b120d4d23a".equals(a3)) {
                    TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z2 + " signature failed");
                    if (z2) {
                        this.v.setCheckErrorDetail("signature:" + (a3 == null ? BuildConfig.COMMAND : Integer.valueOf(a3.length())));
                    }
                    AppMethodBeat.o(188364);
                    return false;
                }
            }
            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] signature successful!");
            if (z2) {
                try {
                    z4 = file.renameTo(new File(this.k, "x5.tbs"));
                    exc = null;
                } catch (Exception e2) {
                    exc = e2;
                    z4 = false;
                }
                if (!z4) {
                    a(109, a(exc), true);
                    AppMethodBeat.o(188364);
                    return false;
                }
            } else {
                z4 = false;
            }
            TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] rename(" + z4 + ") successful!");
            AppMethodBeat.o(188364);
            return true;
        }
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.verifyTbsApk] isTempFile=" + z2 + " versionCode failed");
        if (z2) {
            this.v.setCheckErrorDetail("fileVersion:" + i3 + ",configVersion:" + i2);
        }
        AppMethodBeat.o(188364);
        return false;
    }

    private boolean d(boolean z2) {
        File file;
        AppMethodBeat.i(188365);
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.deleteFile] isApk=".concat(String.valueOf(z2)));
        if (z2) {
            file = new File(this.k, "x5.tbs");
        } else {
            file = new File(this.k, "x5.tbs.temp");
        }
        if (file.exists()) {
            f.b(file);
        }
        AppMethodBeat.o(188365);
        return true;
    }

    private void h() {
        AppMethodBeat.i(188366);
        try {
            File g2 = g();
            if (g2 != null && g2.exists()) {
                f.b(g2);
                File[] listFiles = g2.getParentFile().listFiles();
                Pattern compile = Pattern.compile(a.a(TbsDownloader.a(this.f2093g)) + "(.*)");
                for (File file : listFiles) {
                    if (compile.matcher(file.getName()).find() && file.isFile() && file.exists()) {
                        f.b(file);
                    }
                }
            }
            AppMethodBeat.o(188366);
        } catch (Exception e2) {
            AppMethodBeat.o(188366);
        }
    }

    private boolean i() {
        AppMethodBeat.i(188367);
        boolean z2 = false;
        if (new File(this.k, "x5.tbs.temp").exists()) {
            z2 = true;
        }
        AppMethodBeat.o(188367);
        return z2;
    }

    private long j() {
        AppMethodBeat.i(188368);
        long j2 = 0;
        File file = new File(this.k, "x5.tbs.temp");
        if (file.exists()) {
            j2 = file.length();
        }
        AppMethodBeat.o(188368);
        return j2;
    }

    private boolean k() {
        InputStream inputStream;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        Throwable th;
        boolean z2 = false;
        AppMethodBeat.i(188369);
        try {
            inputStream = Runtime.getRuntime().exec("ping ".concat(String.valueOf("www.qq.com"))).getInputStream();
            try {
                inputStreamReader = new InputStreamReader(inputStream);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader);
                    int i2 = 0;
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine != null) {
                                if (!readLine.contains("TTL") && !readLine.contains("ttl")) {
                                    i2++;
                                    if (i2 >= 5) {
                                        break;
                                    }
                                } else {
                                    z2 = true;
                                }
                            } else {
                                break;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            a(inputStream);
                            a(inputStreamReader);
                            a(bufferedReader);
                            AppMethodBeat.o(188369);
                            throw th;
                        }
                    }
                    z2 = true;
                    a(inputStream);
                    a(inputStreamReader);
                    a(bufferedReader);
                } catch (Throwable th3) {
                    th = th3;
                    bufferedReader = null;
                    a(inputStream);
                    a(inputStreamReader);
                    a(bufferedReader);
                    AppMethodBeat.o(188369);
                    throw th;
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedReader = null;
                inputStreamReader = null;
                a(inputStream);
                a(inputStreamReader);
                a(bufferedReader);
                AppMethodBeat.o(188369);
                throw th;
            }
        } catch (Throwable th5) {
            th = th5;
            bufferedReader = null;
            inputStreamReader = null;
            inputStream = null;
            a(inputStream);
            a(inputStreamReader);
            a(bufferedReader);
            AppMethodBeat.o(188369);
            throw th;
        }
        AppMethodBeat.o(188369);
        return z2;
    }

    private String a(URL url) {
        AppMethodBeat.i(188370);
        String str = "";
        try {
            str = InetAddress.getByName(url.getHost()).getHostAddress();
        } catch (Error | Exception e2) {
        }
        AppMethodBeat.o(188370);
        return str;
    }

    private long l() {
        switch (this.p) {
            case 1:
            case 2:
                return 20000 * ((long) this.p);
            case 3:
            case 4:
                return 100000;
            default:
                return 200000;
        }
    }

    @TargetApi(8)
    static File a(Context context) {
        File file;
        AppMethodBeat.i(188371);
        try {
            if (Build.VERSION.SDK_INT >= 8) {
                file = new File(f.a(context, 4));
            } else {
                file = null;
            }
            if (file != null && !file.exists() && !file.isDirectory()) {
                file.mkdirs();
            }
            AppMethodBeat.o(188371);
            return file;
        } catch (Exception e2) {
            TbsLog.e(TbsDownloader.LOGTAG, "[TbsApkDownloader.backupApkPath] Exception is " + e2.getMessage());
            AppMethodBeat.o(188371);
            return null;
        }
    }

    @TargetApi(8)
    static File b(Context context) {
        File file;
        AppMethodBeat.i(188372);
        try {
            if (Build.VERSION.SDK_INT >= 8) {
                file = a(context, 4);
                if (file == null) {
                    file = a(context, 3);
                }
                if (file == null) {
                    file = a(context, 2);
                }
                if (file == null) {
                    file = a(context, 1);
                }
            } else {
                file = null;
            }
            AppMethodBeat.o(188372);
            return file;
        } catch (Exception e2) {
            TbsLog.e(TbsDownloader.LOGTAG, "[TbsApkDownloader.backupApkPath] Exception is " + e2.getMessage());
            AppMethodBeat.o(188372);
            return null;
        }
    }

    private static File a(Context context, int i2) {
        String backupFileName;
        AppMethodBeat.i(188373);
        File file = new File(f.a(context, i2));
        if (!file.exists() || !file.isDirectory()) {
            AppMethodBeat.o(188373);
            return null;
        }
        if (TbsDownloader.getOverSea(context)) {
            backupFileName = "x5.oversea.tbs.org";
        } else {
            backupFileName = TbsDownloader.getBackupFileName(false);
        }
        if (new File(file, backupFileName).exists()) {
            AppMethodBeat.o(188373);
            return file;
        }
        AppMethodBeat.o(188373);
        return null;
    }

    public int b(boolean z2) {
        AppMethodBeat.i(188374);
        File a2 = a(this.f2093g);
        if (z2) {
            if (a2 == null) {
                AppMethodBeat.o(188374);
                return 0;
            }
            int a3 = a.a(this.f2093g, new File(a2, TbsDownloader.getBackupFileName(true)));
            AppMethodBeat.o(188374);
            return a3;
        } else if (a2 == null) {
            AppMethodBeat.o(188374);
            return 0;
        } else {
            int a4 = a.a(this.f2093g, new File(a2, TbsDownloader.getOverSea(this.f2093g) ? "x5.oversea.tbs.org" : TbsDownloader.getBackupFileName(false)));
            AppMethodBeat.o(188374);
            return a4;
        }
    }

    public void b() {
        AppMethodBeat.i(188375);
        this.r = true;
        if (TbsShareManager.isThirdPartyApp(this.f2093g)) {
            TbsLogReport.TbsLogInfo tbsLogInfo = TbsLogReport.getInstance(this.f2093g).tbsLogInfo();
            tbsLogInfo.setErrorCode(-309);
            tbsLogInfo.setFailDetail(new Exception());
            if (TbsDownloader.a(this.f2093g)) {
                TbsLogReport.getInstance(this.f2093g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD_DECOUPLE, tbsLogInfo);
                AppMethodBeat.o(188375);
                return;
            }
            TbsLogReport.getInstance(this.f2093g).eventReport(TbsLogReport.EventType.TYPE_DOWNLOAD, tbsLogInfo);
        }
        AppMethodBeat.o(188375);
    }

    public void c() {
        AppMethodBeat.i(188376);
        b();
        d(false);
        d(true);
        AppMethodBeat.o(188376);
    }

    public void a(int i2) {
        AppMethodBeat.i(188377);
        if (q.a().u(this.f2093g)) {
            q.a().b();
            try {
                File file = new File(this.k, "x5.tbs");
                int a2 = a.a(this.f2093g, file);
                if (-1 == a2 || (i2 > 0 && i2 == a2)) {
                    f.b(file);
                }
                AppMethodBeat.o(188377);
                return;
            } catch (Exception e2) {
            }
        }
        AppMethodBeat.o(188377);
    }

    public static void a(File file, Context context) {
        File file2;
        String backupFileName;
        AppMethodBeat.i(188378);
        synchronized (a.class) {
            if (file != null) {
                try {
                    if (file.exists()) {
                        try {
                            File a2 = a(context);
                            if (a2 != null) {
                                if (TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) == 1) {
                                    file2 = new File(a2, TbsDownloader.getBackupFileName(true));
                                } else {
                                    if (TbsDownloader.getOverSea(context)) {
                                        backupFileName = "x5.oversea.tbs.org";
                                    } else {
                                        backupFileName = TbsDownloader.getBackupFileName(false);
                                    }
                                    file2 = new File(a2, backupFileName);
                                }
                                file2.delete();
                                f.b(file, file2);
                                boolean contains = file2.getName().contains("tbs.org");
                                boolean contains2 = file2.getName().contains("x5.tbs.decouple");
                                if (contains2 || contains) {
                                    File[] listFiles = a2.listFiles();
                                    Pattern compile = Pattern.compile(a.a(contains2) + "(.*)");
                                    for (File file3 : listFiles) {
                                        if (compile.matcher(file3.getName()).find() && file3.isFile() && file3.exists()) {
                                            file3.delete();
                                        }
                                    }
                                    File file4 = new File(a2, a.a(contains2) + "." + TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V, 0));
                                    if (file4.exists()) {
                                        TbsLog.e(TbsDownloader.LOGTAG, "[TbsApkDownloader.backupTbsApk]delete bacup config file error ");
                                        return;
                                    }
                                    file4.createNewFile();
                                }
                                if (TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_TBS_DOWNLOAD_V_TYPE, 0) != 1 && TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_DECOUPLECOREVERSION, 0) == a.a(context, file)) {
                                    int i2 = TbsDownloadConfig.getInstance(context).mPreferences.getInt(TbsDownloadConfig.TbsConfigKey.KEY_RESPONSECODE, 0);
                                    if (i2 == 5 || i2 == 3) {
                                        TbsLog.i("TbsApkDownloader", "response code=" + i2 + "return backup decouple apk");
                                    }
                                    File file5 = new File(a2, TbsDownloader.getBackupFileName(true));
                                    if (a.a(context, file) != a.a(context, file5)) {
                                        file5.delete();
                                        f.b(file, file5);
                                    }
                                }
                            }
                        } catch (Exception e2) {
                        }
                        AppMethodBeat.o(188378);
                        return;
                    }
                } finally {
                    AppMethodBeat.o(188378);
                }
            }
            AppMethodBeat.o(188378);
        }
    }

    public static void c(Context context) {
        AppMethodBeat.i(188379);
        try {
            q.a();
            File t2 = q.t(context);
            new File(t2, "x5.tbs").delete();
            new File(t2, "x5.tbs.temp").delete();
            File a2 = a(context);
            if (a2 != null) {
                new File(a2, TbsDownloader.getBackupFileName(false)).delete();
                new File(a2, "x5.oversea.tbs.org").delete();
                File[] listFiles = a2.listFiles();
                Pattern compile = Pattern.compile(a.a(true) + "(.*)");
                for (File file : listFiles) {
                    if (compile.matcher(file.getName()).find() && file.isFile() && file.exists()) {
                        file.delete();
                    }
                }
                Pattern compile2 = Pattern.compile(a.a(false) + "(.*)");
                for (File file2 : listFiles) {
                    if (compile2.matcher(file2.getName()).find() && file2.isFile() && file2.exists()) {
                        file2.delete();
                    }
                }
            }
            AppMethodBeat.o(188379);
        } catch (Exception e2) {
            AppMethodBeat.o(188379);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00c8 A[SYNTHETIC, Splitter:B:36:0x00c8] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d4 A[SYNTHETIC, Splitter:B:44:0x00d4] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00e2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m() {
        /*
        // Method dump skipped, instructions count: 231
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.m.m():boolean");
    }

    private void n() {
        AppMethodBeat.i(188381);
        if (this.z == null) {
            this.z = new Handler(o.a().getLooper()) {
                /* class com.tencent.smtt.sdk.m.AnonymousClass1 */

                public void handleMessage(Message message) {
                    AppMethodBeat.i(188246);
                    if (message.what == 150) {
                        m.a(m.this);
                    }
                    AppMethodBeat.o(188246);
                }
            };
        }
        AppMethodBeat.o(188381);
    }

    public boolean d() {
        AppMethodBeat.i(188382);
        TbsLog.i(TbsDownloader.LOGTAG, "[TbsApkDownloader.isDownloadForeground] mIsDownloadForeground=" + this.C);
        boolean z2 = this.C;
        AppMethodBeat.o(188382);
        return z2;
    }
}
