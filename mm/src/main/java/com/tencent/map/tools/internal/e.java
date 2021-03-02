package com.tencent.map.tools.internal;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.map.tools.sheet.SheetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.lang.Thread;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class e implements c {

    /* renamed from: a  reason: collision with root package name */
    Thread.UncaughtExceptionHandler f1323a;

    /* renamed from: b  reason: collision with root package name */
    private b f1324b;

    /* renamed from: c  reason: collision with root package name */
    private f f1325c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f1326d;

    public e(Context context, SheetManager.Options options) {
        AppMethodBeat.i(180779);
        a.f1309a = options.getPluginName();
        a.f1310b = options.getSdkVersion();
        a.f1311c = options.getSdkVersionCode();
        a.f1312d = options.getSdkRepo();
        a.f1313e = options.getSdkFlavor();
        a.f1314f = options.getSdkMapKey();
        a.f1315g = options.getSoLibName();
        a.f1317i = options.isCoreLogOn();
        this.f1326d = options.isSheetEnable();
        if (!this.f1326d) {
            final SheetManager.UncaughtListener uncaughtListener = options.getUncaughtListener();
            if (uncaughtListener != null && this.f1323a == null) {
                this.f1323a = Thread.getDefaultUncaughtExceptionHandler();
                Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                    /* class com.tencent.map.tools.internal.e.AnonymousClass1 */

                    public final void uncaughtException(Thread thread, Throwable th) {
                        AppMethodBeat.i(193526);
                        CountDownLatch countDownLatch = new CountDownLatch(1);
                        uncaughtListener.onModuleSDKCrashed(th);
                        try {
                            countDownLatch.await(400, TimeUnit.MILLISECONDS);
                        } catch (InterruptedException e2) {
                        }
                        if (e.this.f1323a != null) {
                            e.this.f1323a.uncaughtException(thread, th);
                        }
                        AppMethodBeat.o(193526);
                    }
                });
            }
            AppMethodBeat.o(180779);
            return;
        }
        this.f1324b = b.a(context);
        if (a.f1317i) {
            String coreLogReportUrl = options.getCoreLogReportUrl();
            if (!TextUtils.isEmpty(coreLogReportUrl)) {
                a.k = coreLogReportUrl;
            }
            SheetManager.UncaughtListener uncaughtListener2 = options.getUncaughtListener();
            if (uncaughtListener2 != null) {
                m mVar = this.f1324b.f1320a;
                if (uncaughtListener2 != null) {
                    mVar.f1368b = uncaughtListener2;
                    mVar.f1370d = new n(mVar.f1367a);
                    n nVar = mVar.f1370d;
                    if (!nVar.f1378a) {
                        nVar.f1379b = uncaughtListener2;
                        Thread.setDefaultUncaughtExceptionHandler(nVar);
                        nVar.f1378a = true;
                    }
                }
            }
            File coreLogDir = options.getCoreLogDir();
            if (coreLogDir != null) {
                if (!coreLogDir.exists()) {
                    coreLogDir.mkdirs();
                }
                m mVar2 = this.f1324b.f1320a;
                mVar2.f1369c = coreLogDir;
                if (a.f1317i) {
                    g.a(mVar2.f1367a).f1337g = mVar2.f1369c;
                }
            }
        }
        g a2 = g.a(this.f1324b.f1320a.f1367a);
        if (!a2.f1333c) {
            if (a.f1317i) {
                a2.f1335e = new k(a2.f1334d, a2.f1331a.getLooper(), a2.f1337g, a2.f1336f);
            }
            a2.f1333c = true;
        }
        AppMethodBeat.o(180779);
    }

    @Override // com.tencent.map.tools.internal.c
    public final boolean a() {
        return this.f1326d;
    }

    @Override // com.tencent.map.tools.internal.c
    public final File b() {
        AppMethodBeat.i(180780);
        if (this.f1324b != null) {
            g a2 = g.a(this.f1324b.f1320a.f1367a);
            if (a2.f1335e != null) {
                File file = a2.f1335e.f1356c;
                AppMethodBeat.o(180780);
                return file;
            }
            AppMethodBeat.o(180780);
            return null;
        }
        AppMethodBeat.o(180780);
        return null;
    }

    @Override // com.tencent.map.tools.internal.c
    public final d c() {
        AppMethodBeat.i(180781);
        if (this.f1325c == null && this.f1324b != null) {
            this.f1325c = new f(this.f1324b);
        }
        f fVar = this.f1325c;
        AppMethodBeat.o(180781);
        return fVar;
    }
}
