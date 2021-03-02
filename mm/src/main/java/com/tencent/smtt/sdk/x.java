package com.tencent.smtt.sdk;

import android.content.Context;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.f;
import java.nio.channels.FileLock;

/* access modifiers changed from: package-private */
public class x {

    /* renamed from: a  reason: collision with root package name */
    private static x f2140a;

    /* renamed from: e  reason: collision with root package name */
    private static FileLock f2141e = null;

    /* renamed from: b  reason: collision with root package name */
    private y f2142b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f2143c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f2144d;

    private x() {
    }

    public static x a() {
        AppMethodBeat.i(188322);
        if (f2140a == null) {
            synchronized (x.class) {
                try {
                    if (f2140a == null) {
                        f2140a = new x();
                    }
                } catch (Throwable th) {
                    AppMethodBeat.o(188322);
                    throw th;
                }
            }
        }
        x xVar = f2140a;
        AppMethodBeat.o(188322);
        return xVar;
    }

    public boolean b() {
        if (QbSdk.f1702a) {
            return false;
        }
        return this.f2143c;
    }

    public y c() {
        if (QbSdk.f1702a) {
            return null;
        }
        return this.f2142b;
    }

    public synchronized void a(Context context, p pVar) {
        Throwable th;
        Object obj = null;
        synchronized (this) {
            AppMethodBeat.i(188323);
            TbsLog.i("X5CoreEngine", "init #1");
            if (pVar != null) {
                pVar.a("x5_core_engine_init_sync", (byte) 2);
            }
            g a2 = g.a(true);
            a2.a(context, false, false, pVar);
            StringBuilder sb = new StringBuilder();
            if (pVar != null) {
                pVar.a("init_x5_core", (byte) 1);
            }
            TbsWizard a3 = a2.a();
            if (!a2.b() || a3 == null) {
                this.f2143c = false;
                sb.append("can not use X5 by !tbs available");
                th = null;
            } else {
                if (!this.f2144d) {
                    if (pVar != null) {
                        pVar.f2101a = true;
                    }
                    this.f2142b = new y(a3.dexLoader());
                    try {
                        this.f2143c = TbsOneGreyInfoHelper.getCoreEntry().canUseX5();
                        if (!this.f2143c) {
                            sb.append("can not use X5 by x5corewizard return false");
                        }
                        th = null;
                    } catch (NoSuchMethodException e2) {
                        this.f2143c = true;
                        th = null;
                    } catch (Throwable th2) {
                        th = th2;
                        this.f2143c = false;
                        sb.append("can not use x5 by throwable " + Log.getStackTraceString(th));
                    }
                    if (this.f2143c) {
                        CookieManager.getInstance().a(context, true, true);
                        CookieManager.getInstance().a();
                    }
                }
                th = null;
            }
            TbsLog.i("X5CoreEngine", "init  mCanUseX5 is " + this.f2143c);
            if (!this.f2143c) {
                TbsLog.e("X5CoreEngine", "mCanUseX5 is false --> report");
                if (a2.b() && a3 != null && th == null) {
                    try {
                        DexLoader dexLoader = a3.dexLoader();
                        if (dexLoader != null) {
                            obj = dexLoader.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
                        }
                        if (obj instanceof Throwable) {
                            Throwable th3 = (Throwable) obj;
                            sb.append("#" + th3.getMessage() + "; cause: " + th3.getCause() + "; th: " + th3);
                        }
                        if (obj instanceof String) {
                            sb.append("failure detail:".concat(String.valueOf(obj)));
                        }
                    } catch (Throwable th4) {
                    }
                    if (sb.toString().contains("isPreloadX5Disabled:-10000")) {
                        TbsCoreLoadStat.getInstance().setLoadErrorCode(context, 408, new Throwable("X5CoreEngine::init, mCanUseX5=false, available true, details: " + sb.toString()));
                    } else {
                        TbsCoreLoadStat.getInstance().setLoadErrorCode(context, 407, new Throwable("X5CoreEngine::init, mCanUseX5=false, available true, details: " + sb.toString()));
                    }
                } else if (a2.b()) {
                    TbsCoreLoadStat.getInstance().setLoadErrorCode(context, 409, new Throwable("mCanUseX5=false, available true, reason: ".concat(String.valueOf(th))));
                } else {
                    TbsCoreLoadStat.getInstance().setLoadErrorCode(context, 410, new Throwable("mCanUseX5=false, available false, reason: ".concat(String.valueOf(th))));
                }
            } else {
                TbsLog.i("X5CoreEngine", "init  sTbsCoreLoadFileLock is " + f2141e);
                if (f2141e == null) {
                    a(context);
                }
            }
            this.f2144d = true;
            if (pVar != null) {
                pVar.a("init_x5_core", (byte) 2);
            }
            AppMethodBeat.o(188323);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return this.f2144d;
    }

    public FileLock a(Context context) {
        AppMethodBeat.i(188324);
        TbsLog.i("X5CoreEngine", "tryTbsCoreLoadFileLock ##");
        if (f2141e != null) {
            FileLock fileLock = f2141e;
            AppMethodBeat.o(188324);
            return fileLock;
        }
        synchronized (x.class) {
            try {
                if (f2141e == null) {
                    FileLock e2 = f.e(context);
                    f2141e = e2;
                    if (e2 == null) {
                        TbsLog.i("X5CoreEngine", "init -- sTbsCoreLoadFileLock failed!");
                    } else {
                        TbsLog.i("X5CoreEngine", "init -- sTbsCoreLoadFileLock succeeded: " + f2141e);
                    }
                }
            } catch (Throwable th) {
                AppMethodBeat.o(188324);
                throw th;
            }
        }
        FileLock fileLock2 = f2141e;
        AppMethodBeat.o(188324);
        return fileLock2;
    }
}
