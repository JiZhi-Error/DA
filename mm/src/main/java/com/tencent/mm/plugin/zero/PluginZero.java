package com.tencent.mm.plugin.zero;

import android.app.Service;
import android.os.Build;
import android.os.Process;
import com.tencent.mars.Mars;
import com.tencent.mars.app.AppLogic;
import com.tencent.mars.mm.AppCallBack;
import com.tencent.mars.sdt.SdtLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.app.g;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.co.a;
import com.tencent.mm.co.i;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.a.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.kernel.l;
import com.tencent.mm.plugin.zero.a.d;
import com.tencent.mm.plugin.zero.tasks.LoadNormsgJNITask;
import com.tencent.mm.plugin.zero.tasks.LoadProtocolJNITask;
import com.tencent.mm.sdcard_migrate.ExtStorageMigrateMonitor;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vending.f.a;
import com.tencent.mm.vending.h.h;
import com.tencent.mm.vfs.o;
import com.tencent.stubs.logger.Log;
import java.util.HashMap;

public class PluginZero extends f implements com.tencent.mm.kernel.api.a, d {
    private static final int[] Vig = {6, 6, 0, 1, 2, 3, 4, 5};
    private a Vid = new a();
    private b Vie = new b();
    private final g Vif = new g();
    public com.tencent.mm.plugin.zero.a.b Vih;
    public b Vii = new b();
    public a Vij = new a();

    public PluginZero() {
        AppMethodBeat.i(133012);
        AppMethodBeat.o(133012);
    }

    @Override // com.tencent.mm.kernel.b.f
    public String toString() {
        return "plugin-zero";
    }

    @Override // com.tencent.mm.kernel.b.f
    public void installed() {
        AppMethodBeat.i(133013);
        alias(d.class);
        AppMethodBeat.o(133013);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void dependency() {
        AppMethodBeat.i(133014);
        dependsOnRoot();
        AppMethodBeat.o(133014);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(final com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(133015);
        try {
            initSDRoot();
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.PluginZero", e2, "what happened?", new Object[0]);
        }
        com.tencent.mm.kernel.a.a.k("configure [%s], setup broken library handler...", this);
        setupStubLog();
        setupVendingLog();
        if (gVar.aBb()) {
            com.tencent.mm.kernel.a.a.k("configure [%s], for process[%s]...", this, gVar.mProcessName);
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.zero.b.a.class, new e(this.Vid));
            com.tencent.mm.kernel.g.a(com.tencent.mm.plugin.zero.b.b.class, new e(this.Vie));
            com.tencent.mm.kernel.a.a.k("configure [%s], make worker core...", this);
            com.tencent.mm.kernel.g aAi = com.tencent.mm.kernel.g.aAi();
            if (!aAi.hrr) {
                aAi.hrk = new com.tencent.mm.kernel.e(c.aAu());
                aAi.hrl = new com.tencent.mm.kernel.a(c.aAu());
                aAi.hrm = new com.tencent.mm.kernel.b(aAi.hro, aAi.hqh);
                aAi.hrn = new com.tencent.mm.cg.b(MMApplicationContext.getContext());
                aAi.hrr = true;
            }
            NotifyReceiver.akE();
            com.tencent.mm.kernel.g.aAi().a(new com.tencent.mm.kernel.api.g() {
                /* class com.tencent.mm.plugin.zero.PluginZero.AnonymousClass1 */

                @Override // com.tencent.mm.kernel.api.g
                public final void WY() {
                    AppMethodBeat.i(132996);
                    com.tencent.mm.kernel.a.a.k("onStartupDone", new Object[0]);
                    AppMethodBeat.o(132996);
                }

                @Override // com.tencent.mm.kernel.api.g
                public final void cQ(boolean z) {
                    AppMethodBeat.i(132997);
                    if (z) {
                        l.s(gVar.ca, true);
                        l.t(gVar.ca, true);
                    }
                    Log.appenderFlush();
                    AppMethodBeat.o(132997);
                }
            });
            com.tencent.mm.kernel.g.aAi();
            i.RwW = new h(com.tencent.mm.co.d.b(com.tencent.mm.kernel.g.aAk().getWorkerHandler()), "WeChat.WORKER");
            com.tencent.mm.vending.h.g.a("WeChat.WORKER", i.RwW);
            new com.tencent.mm.plugin.zero.tasks.a().before(this);
        }
        if (gVar.aBb() || gVar.FY(":push")) {
            new LoadNormsgJNITask().before(new LoadProtocolJNITask().before(this));
        }
        if (gVar.FY(":push")) {
            AppLogic.setCallBack(new AppCallBack(MMApplicationContext.getContext()));
            getClass().getClassLoader();
            j.Ed(Mars.libMarsBase);
            getClass().getClassLoader();
            j.Ed(Mars.libMarsNetwork);
            getClass().getClassLoader();
            j.Ed(Mars.libMarsMM);
            SdtLogic.setHttpNetcheckCGI("/mmnetcheck");
        }
        AppMethodBeat.o(133015);
    }

    private void initSDRoot() {
        String str;
        AppMethodBeat.i(133016);
        if (!new o(ar.NSe + "SdcardInfo.cfg").exists()) {
            Log.i("MicroMsg.PluginZero", "summermount initSdCardPath sdcard info file not existed use[%s]", com.tencent.mm.loader.j.b.aKE());
            AppMethodBeat.o(133016);
            return;
        }
        String aKE = com.tencent.mm.loader.j.b.aKE();
        boolean z = false;
        an anVar = new an(ar.NSe + "SdcardInfo.cfg");
        String str2 = (String) anVar.get(1, "");
        int intValue = ((Integer) anVar.get(2, 0)).intValue();
        int i2 = Build.VERSION.SDK_INT;
        if (Util.isNullOrNil(str2)) {
            anVar.set(1, aKE);
            anVar.set(2, Integer.valueOf(i2));
            str = aKE;
        } else {
            z = true;
            str = str2;
        }
        Log.i("MicroMsg.PluginZero", "initSdCardPath cfgSdcardRoot[%s], initSdcardRoot[%s], primarySD[%s], ver[%d], sdk[%d]", str2, str, aKE, Integer.valueOf(intValue), Integer.valueOf(i2));
        com.tencent.mm.loader.j.b.A(str, false);
        if (intValue != i2 && !com.tencent.mm.compatible.util.e.apn()) {
            z = false;
            if (!com.tencent.mm.compatible.util.g.getExternalStorageState().equals("mounted") || !new o(aKE).canWrite()) {
                Log.i("MicroMsg.PluginZero", "summermount initSdCardPath ver change but neither primarySD nor old avail keep do nothing[%s][%b][%s]", com.tencent.mm.loader.j.b.aKD(), Boolean.valueOf(com.tencent.mm.compatible.util.e.apn()), aKE);
            } else {
                anVar.set(1, aKE);
                anVar.set(2, Integer.valueOf(i2));
                com.tencent.mm.loader.j.b.A(aKE, false);
                Log.i("MicroMsg.PluginZero", "summermount initSdCardPath ver change and old not avail reset SDCARD_ROOT[%s][%b]", com.tencent.mm.loader.j.b.aKD(), Boolean.valueOf(com.tencent.mm.compatible.util.e.apn()));
            }
        }
        if (MMApplicationContext.isMainProcess() && z) {
            ExtStorageMigrateMonitor.ME(140);
            if (!aKE.equals(str)) {
                ExtStorageMigrateMonitor.ME(141);
            }
        }
        AppMethodBeat.o(133016);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(final com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(133017);
        if (gVar.aBb()) {
            com.tencent.mm.kernel.g.aAi().hro.add(new t.a() {
                /* class com.tencent.mm.plugin.zero.PluginZero.AnonymousClass2 */

                @Override // com.tencent.mm.ak.t.a
                public final void a(t tVar, boolean z) {
                }

                @Override // com.tencent.mm.ak.t.a
                public final void a(t tVar) {
                    AppMethodBeat.i(132998);
                    PluginZero.this.Vif.bG(gVar.ca);
                    AppMethodBeat.o(132998);
                }
            });
            NotifyReceiver.akF();
        }
        AppMethodBeat.o(133017);
    }

    private void setupStubLog() {
        AppMethodBeat.i(133018);
        com.tencent.stubs.logger.Log.setLogger(new Log.Logger() {
            /* class com.tencent.mm.plugin.zero.PluginZero.AnonymousClass3 */

            @Override // com.tencent.stubs.logger.Log.Logger
            public final void println(int i2, String str, String str2) {
                AppMethodBeat.i(132999);
                if (!isLoggable(str, i2)) {
                    AppMethodBeat.o(132999);
                    return;
                }
                Log.LogImp impl = com.tencent.mm.sdk.platformtools.Log.getImpl();
                int myPid = Process.myPid();
                int myTid = Process.myTid();
                switch (i2) {
                    case 2:
                        impl.logV(0, str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                        AppMethodBeat.o(132999);
                        return;
                    case 3:
                        impl.logD(0, str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                        AppMethodBeat.o(132999);
                        return;
                    case 4:
                        impl.logI(0, str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                        AppMethodBeat.o(132999);
                        return;
                    case 5:
                        impl.logW(0, str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                        AppMethodBeat.o(132999);
                        return;
                    case 6:
                        impl.logE(0, str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                        AppMethodBeat.o(132999);
                        return;
                    case 7:
                        impl.logF(0, str, "", "", 0, myPid, (long) myTid, (long) myPid, str2);
                        AppMethodBeat.o(132999);
                        return;
                    default:
                        AppMethodBeat.o(132999);
                        return;
                }
            }

            @Override // com.tencent.stubs.logger.Log.Logger
            public final boolean isLoggable(String str, int i2) {
                AppMethodBeat.i(133000);
                if (i2 < 2 || i2 > 7 || PluginZero.Vig[i2] < com.tencent.mm.sdk.platformtools.Log.getLogLevel()) {
                    AppMethodBeat.o(133000);
                    return false;
                }
                AppMethodBeat.o(133000);
                return true;
            }
        });
        AppMethodBeat.o(133018);
    }

    private void setupVendingLog() {
        AppMethodBeat.i(133019);
        com.tencent.mm.vending.f.a.a(new a.AbstractC2151a() {
            /* class com.tencent.mm.plugin.zero.PluginZero.AnonymousClass4 */

            @Override // com.tencent.mm.vending.f.a.AbstractC2151a
            public final void e(String str, String str2, Object... objArr) {
                AppMethodBeat.i(133001);
                com.tencent.mm.sdk.platformtools.Log.e(str, str2, objArr);
                AppMethodBeat.o(133001);
            }

            @Override // com.tencent.mm.vending.f.a.AbstractC2151a
            public final void w(String str, String str2, Object... objArr) {
                AppMethodBeat.i(133002);
                com.tencent.mm.sdk.platformtools.Log.w(str, str2, objArr);
                AppMethodBeat.o(133002);
            }

            @Override // com.tencent.mm.vending.f.a.AbstractC2151a
            public final void i(String str, String str2, Object... objArr) {
                AppMethodBeat.i(133003);
                com.tencent.mm.sdk.platformtools.Log.i(str, str2, objArr);
                AppMethodBeat.o(133003);
            }

            @Override // com.tencent.mm.vending.f.a.AbstractC2151a
            public final void d(String str, String str2, Object... objArr) {
                AppMethodBeat.i(133004);
                com.tencent.mm.sdk.platformtools.Log.d(str, str2, objArr);
                AppMethodBeat.o(133004);
            }

            @Override // com.tencent.mm.vending.f.a.AbstractC2151a
            public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
                AppMethodBeat.i(133005);
                com.tencent.mm.sdk.platformtools.Log.printErrStackTrace(str, th, str2, objArr);
                AppMethodBeat.o(133005);
            }
        });
        AppMethodBeat.o(133019);
    }

    public static final class b extends com.tencent.mm.co.a<com.tencent.mm.plugin.zero.a.c> implements com.tencent.mm.plugin.zero.a.c {
        @Override // com.tencent.mm.plugin.zero.a.c
        public final void a(final NotifyReceiver.NotifyService notifyService, final int i2, final byte[] bArr, final byte[] bArr2, final long j2) {
            AppMethodBeat.i(133011);
            a(new a.AbstractC0297a<com.tencent.mm.plugin.zero.a.c>() {
                /* class com.tencent.mm.plugin.zero.PluginZero.b.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.co.a.AbstractC0297a
                public final /* synthetic */ void bw(com.tencent.mm.plugin.zero.a.c cVar) {
                    AppMethodBeat.i(133010);
                    cVar.a(notifyService, i2, bArr, bArr2, j2);
                    AppMethodBeat.o(133010);
                }
            });
            AppMethodBeat.o(133011);
        }
    }

    public static final class a extends com.tencent.mm.co.a<com.tencent.mm.plugin.zero.a.a> implements com.tencent.mm.plugin.zero.a.a {
        @Override // com.tencent.mm.plugin.zero.a.a
        public final void a(final Service service) {
            AppMethodBeat.i(133008);
            a(new a.AbstractC0297a<com.tencent.mm.plugin.zero.a.a>() {
                /* class com.tencent.mm.plugin.zero.PluginZero.a.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.co.a.AbstractC0297a
                public final /* synthetic */ void bw(com.tencent.mm.plugin.zero.a.a aVar) {
                    AppMethodBeat.i(133006);
                    aVar.a(service);
                    AppMethodBeat.o(133006);
                }
            });
            AppMethodBeat.o(133008);
        }

        @Override // com.tencent.mm.plugin.zero.a.a
        public final void b(final Service service) {
            AppMethodBeat.i(133009);
            a(new a.AbstractC0297a<com.tencent.mm.plugin.zero.a.a>() {
                /* class com.tencent.mm.plugin.zero.PluginZero.a.AnonymousClass2 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.co.a.AbstractC0297a
                public final /* synthetic */ void bw(com.tencent.mm.plugin.zero.a.a aVar) {
                    AppMethodBeat.i(133007);
                    aVar.b(service);
                    AppMethodBeat.o(133007);
                }
            });
            AppMethodBeat.o(133009);
        }
    }

    @Override // com.tencent.mm.plugin.zero.a.d
    public void setILightPushDelegate(com.tencent.mm.plugin.zero.a.b bVar) {
        this.Vih = bVar;
    }

    @Override // com.tencent.mm.plugin.zero.a.d
    public com.tencent.mm.vending.b.b addNotifyReceiverCallback(com.tencent.mm.plugin.zero.a.c cVar) {
        AppMethodBeat.i(133020);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.PluginZero", "addNotifyReceiverCallback this %s delegate %s ", this, cVar);
        com.tencent.mm.vending.b.b add = this.Vii.add(cVar);
        AppMethodBeat.o(133020);
        return add;
    }

    @Override // com.tencent.mm.plugin.zero.a.d
    public com.tencent.mm.vending.b.b addICoreServiceLifecycleCallback(com.tencent.mm.plugin.zero.a.a aVar) {
        AppMethodBeat.i(133021);
        com.tencent.mm.vending.b.b add = this.Vij.add(aVar);
        AppMethodBeat.o(133021);
        return add;
    }

    @Override // com.tencent.mm.kernel.api.a
    public HashMap<Integer, h.b> collectDatabaseFactory() {
        AppMethodBeat.i(197124);
        com.tencent.mm.sdk.platformtools.Log.i("MicroMsg.PluginZero", "CleanDeleteItemStorage collectDatabaseFactory");
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        hashMap.put(Integer.valueOf("CleanDeleteItem".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.zero.PluginZero.AnonymousClass5 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return am.SQL_CREATE;
            }
        });
        AppMethodBeat.o(197124);
        return hashMap;
    }
}
