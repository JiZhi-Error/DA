package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.sdk.TbsListener;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.tbs.one.impl.common.statistic.StatisticReport;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/* access modifiers changed from: package-private */
public class g {

    /* renamed from: a  reason: collision with root package name */
    static int f2050a = 0;

    /* renamed from: b  reason: collision with root package name */
    static boolean f2051b = false;

    /* renamed from: d  reason: collision with root package name */
    private static g f2052d = null;

    /* renamed from: g  reason: collision with root package name */
    private static int f2053g = 0;

    /* renamed from: h  reason: collision with root package name */
    private static int f2054h = 3;

    /* renamed from: j  reason: collision with root package name */
    private static String f2055j = null;

    /* renamed from: c  reason: collision with root package name */
    private TbsWizard f2056c = null;

    /* renamed from: e  reason: collision with root package name */
    private boolean f2057e = false;

    /* renamed from: f  reason: collision with root package name */
    private boolean f2058f = false;

    /* renamed from: i  reason: collision with root package name */
    private File f2059i = null;

    static {
        AppMethodBeat.i(55173);
        AppMethodBeat.o(55173);
    }

    private g() {
    }

    public static g a(boolean z) {
        AppMethodBeat.i(188194);
        if (f2052d == null && z) {
            synchronized (g.class) {
                try {
                    if (f2052d == null) {
                        f2052d = new g();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(188194);
                    throw th;
                }
            }
        }
        g gVar = f2052d;
        AppMethodBeat.o(188194);
        return gVar;
    }

    public synchronized void a(Context context, boolean z, boolean z2, p pVar) {
        boolean z3 = true;
        synchronized (this) {
            AppMethodBeat.i(188195);
            TbsLog.addLog(999, null, new Object[0]);
            TbsLog.initIfNeed(context);
            TbsLog.i("SDKEngine", "init -- context: " + context + ", isPreIniting: " + z2 + ",tbsoneMode=" + TbsOneGreyInfoHelper.isOneModeAvailable(context) + ",switch option:" + TbsOneGreyInfoHelper.isTbsOneModeEnable(context));
            TbsLog.d("SDKEngine", "init -- stack: " + Log.getStackTraceString(new Throwable("$")));
            f2050a++;
            TbsOneGreyInfoHelper.initExtension(context);
            if (pVar != null) {
                pVar.f2102b = f2050a == 1;
            }
            TbsCoreLoadStat.getInstance().a();
            if (pVar != null) {
                pVar.a("tbs_rename_task", (byte) 1);
            }
            q.a().b(context, f2050a == 1);
            q.a().l(context);
            if (pVar != null) {
                pVar.a("tbs_rename_task", (byte) 2);
            }
            TbsShareManager.forceToLoadX5ForThirdApp(context, true);
            if (pVar != null) {
                pVar.a("can_load_x5", (byte) 1);
            }
            TbsOneGreyInfoHelper.init(context);
            boolean a2 = QbSdk.a(context, z, z2);
            if (pVar != null) {
                pVar.a("can_load_x5", (byte) 2);
            }
            boolean z4 = Build.VERSION.SDK_INT >= 7;
            if (!a2 || !z4) {
                z3 = false;
            }
            if (z3) {
                long currentTimeMillis = System.currentTimeMillis();
                z3 = q.a().g(context, d());
                TbsLog.i("SDKEngine", "isTbsCoreLegal: " + z3 + "; cost: " + (System.currentTimeMillis() - currentTimeMillis));
            }
            if (!z3) {
                String str = "can_load_x5=" + a2 + "; is_compatible=" + z4;
                TbsLog.e("SDKEngine", "SDKEngine.init canLoadTbs=false; failure: ".concat(String.valueOf(str)));
                if (!QbSdk.f1702a || !this.f2057e) {
                    this.f2057e = false;
                    TbsCoreLoadStat.getInstance().setLoadErrorCode(context, 405, new Throwable(str));
                }
                c.a().a(context);
                this.f2059i = q.t(context);
                this.f2058f = true;
                AppMethodBeat.o(188195);
            } else if (this.f2057e) {
                AppMethodBeat.o(188195);
            } else {
                try {
                    this.f2057e = a(context, pVar);
                } catch (Throwable th) {
                    TbsLog.e("SDKEngine", "useSystemWebView by exception: ".concat(String.valueOf(th)));
                    if (TbsOneGreyInfoHelper.isOneModeAvailable(context)) {
                        StatisticReport.create("LOAD_ERROR", TbsListener.ErrorCode.ERROR_ONE_WIZARD_CREATE_FAIL).setDescription("catched throwable", th).report();
                    }
                    TbsCoreLoadStat.getInstance().setLoadErrorCode(context, TbsListener.ErrorCode.TEST_THROWABLE_ISNOT_NULL, th);
                    this.f2057e = false;
                    QbSdk.a(context, "SDKEngine::useSystemWebView by exception: ".concat(String.valueOf(th)));
                }
                c.a().a(context);
                this.f2059i = q.t(context);
                this.f2058f = true;
                AppMethodBeat.o(188195);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(Context context, p pVar) {
        AppMethodBeat.i(188196);
        if (this.f2056c != null) {
            AppMethodBeat.o(188196);
            return true;
        }
        TbsOneGreyInfoHelper.initExtension(context);
        File r = q.a().r(context);
        if (r == null) {
            this.f2057e = false;
            QbSdk.a(context, "SDKEngine::useSystemWebView by tbs_core_share_dir null!");
            AppMethodBeat.o(188196);
            return false;
        }
        String[] dexLoaderFileList = QbSdk.getDexLoaderFileList(context, context, r.getAbsolutePath());
        for (int i2 = 0; i2 < dexLoaderFileList.length; i2++) {
            TbsLog.d("SDKEngine", "dexLoaderFileList[" + i2 + "]: " + dexLoaderFileList[i2]);
        }
        String absolutePath = r.getAbsolutePath();
        TbsLog.i("SDKEngine", "SDKEngine init optDir is ".concat(String.valueOf(absolutePath)));
        if (TbsOneGreyInfoHelper.isOneModeAvailable(context)) {
            this.f2056c = new TbsWizard(context);
        } else {
            this.f2056c = new TbsWizard(context, context, r.getAbsolutePath(), absolutePath, dexLoaderFileList, QbSdk.getLibraryPath(), pVar);
        }
        AppMethodBeat.o(188196);
        return true;
    }

    public TbsWizard a() {
        if (this.f2057e) {
            return this.f2056c;
        }
        return null;
    }

    public boolean b() {
        return this.f2057e;
    }

    /* access modifiers changed from: package-private */
    public TbsWizard c() {
        return this.f2056c;
    }

    public static int d() {
        return f2053g;
    }

    static void a(int i2) {
        f2053g = i2;
    }

    public String e() {
        AppMethodBeat.i(188197);
        if (this.f2056c == null || QbSdk.f1702a) {
            AppMethodBeat.o(188197);
            return "system webview get nothing...";
        }
        String crashExtraMessage = this.f2056c.getCrashExtraMessage();
        AppMethodBeat.o(188197);
        return crashExtraMessage;
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        AppMethodBeat.i(188198);
        TbsLog.d("SDKEngine", "getTbsNeedReboot");
        if (f2051b) {
            if (f2055j == null) {
                AppMethodBeat.o(188198);
                return false;
            }
            int h2 = h();
            if (h2 == 0) {
                b(1);
            } else if (h2 + 1 <= f2054h) {
                b(h2 + 1);
            } else {
                AppMethodBeat.o(188198);
                return false;
            }
        }
        boolean z = f2051b;
        AppMethodBeat.o(188198);
        return z;
    }

    /* access modifiers changed from: package-private */
    public boolean b(boolean z) {
        f2051b = z;
        return z;
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        return this.f2058f;
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        f2055j = str;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0053 A[SYNTHETIC, Splitter:B:15:0x0053] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005d A[SYNTHETIC, Splitter:B:20:0x005d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int h() {
        /*
        // Method dump skipped, instructions count: 111
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.g.h():int");
    }

    private void b(int i2) {
        AppMethodBeat.i(188200);
        TbsLog.d("SDKEngine", "setCountProp i = ".concat(String.valueOf(i2)));
        String valueOf = String.valueOf(i2);
        Properties properties = new Properties();
        properties.setProperty(f2055j, valueOf);
        try {
            properties.store(new FileOutputStream(new File(this.f2059i, "count.prop")), (String) null);
            AppMethodBeat.o(188200);
        } catch (FileNotFoundException e2) {
            AppMethodBeat.o(188200);
        } catch (IOException e3) {
            AppMethodBeat.o(188200);
        }
    }
}
