package com.tencent.mm.kernel;

import android.app.Application;
import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.app.o;
import com.tencent.mm.b.p;
import com.tencent.mm.booter.aa;
import com.tencent.mm.co.a;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.api.d;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.c.e;
import com.tencent.mm.kernel.j;
import com.tencent.mm.model.cm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.DeprecatedThreadFactory;
import com.tencent.tinker.entry.ApplicationLifeCycle;
import java.util.concurrent.ConcurrentHashMap;
import junit.framework.Assert;

public final class g {
    public static final String[] hrf = {":appbrand0", ":appbrand1", ":appbrand2", ":appbrand3", ":appbrand4"};
    private static g hrg;
    public final b.a hqh = new b.a();
    public h<h> hrh;
    private MMHandlerThread hri;
    private cm hrj = null;
    public e hrk;
    public a hrl;
    public b hrm;
    public com.tencent.mm.cg.b hrn;
    public final a hro = new a((byte) 0);
    private final boolean hrp;
    private ConcurrentHashMap hrq = new ConcurrentHashMap();
    public volatile boolean hrr = false;

    static /* synthetic */ void a(g gVar, h hVar, Object obj) {
        AppMethodBeat.i(182902);
        gVar.a(hVar, obj);
        AppMethodBeat.o(182902);
    }

    /* access modifiers changed from: package-private */
    public static class a extends com.tencent.mm.co.a<t.a> implements t.a {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        @Override // com.tencent.mm.ak.t.a
        public final void a(final t tVar, final boolean z) {
            AppMethodBeat.i(132122);
            a(new a.AbstractC0297a<t.a>() {
                /* class com.tencent.mm.kernel.g.a.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.co.a.AbstractC0297a
                public final /* synthetic */ void bw(t.a aVar) {
                    AppMethodBeat.i(132120);
                    aVar.a(tVar, z);
                    AppMethodBeat.o(132120);
                }
            });
            AppMethodBeat.o(132122);
        }

        @Override // com.tencent.mm.ak.t.a
        public final void a(final t tVar) {
            AppMethodBeat.i(132123);
            a(new a.AbstractC0297a<t.a>() {
                /* class com.tencent.mm.kernel.g.a.AnonymousClass2 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.co.a.AbstractC0297a
                public final /* synthetic */ void bw(t.a aVar) {
                    AppMethodBeat.i(132121);
                    aVar.a(tVar);
                    AppMethodBeat.o(132121);
                }
            });
            AppMethodBeat.o(132123);
        }
    }

    private g(final h hVar) {
        AppMethodBeat.i(132124);
        this.hrh = h.c(hVar);
        this.hrp = this.hrh.aAe().azG().aBb();
        if (this.hrp) {
            this.hrj = new cm();
            this.hri = new MMHandlerThread(DeprecatedThreadFactory.createHandlerThread("worker"));
            this.hri.postToWorker(new Runnable() {
                /* class com.tencent.mm.kernel.g.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(182890);
                    NetStatusUtil.initMobileStrengthListener(MMApplicationContext.getContext());
                    AppMethodBeat.o(182890);
                }
            });
        }
        this.hrh.aAd().hqw = new c.a() {
            /* class com.tencent.mm.kernel.g.AnonymousClass2 */

            @Override // com.tencent.mm.kernel.c.a
            public final void b(f fVar) {
                AppMethodBeat.i(182891);
                g.a(g.this, hVar, fVar);
                AppMethodBeat.o(182891);
            }

            @Override // com.tencent.mm.kernel.c.a
            public final void a(com.tencent.mm.kernel.c.a aVar) {
                AppMethodBeat.i(182892);
                g.a(g.this, hVar, aVar);
                com.tencent.mm.kernel.a.c.aAu().bA(aVar);
                AppMethodBeat.o(182892);
            }

            @Override // com.tencent.mm.kernel.c.a
            public final void b(com.tencent.mm.kernel.c.a aVar) {
                AppMethodBeat.i(182893);
                g.b(g.this, hVar, aVar);
                AppMethodBeat.o(182893);
            }

            @Override // com.tencent.mm.kernel.c.a
            public final void c(f fVar) {
                AppMethodBeat.i(182894);
                com.tencent.mm.kernel.a.c aAu = com.tencent.mm.kernel.a.c.aAu();
                if (fVar != null) {
                    aAu.bB(fVar);
                }
                AppMethodBeat.o(182894);
            }

            @Override // com.tencent.mm.kernel.c.a
            public final void c(com.tencent.mm.kernel.c.a aVar) {
                AppMethodBeat.i(182895);
                com.tencent.mm.kernel.a.c aAu = com.tencent.mm.kernel.a.c.aAu();
                if (aVar != null) {
                    aAu.bB(aVar);
                }
                AppMethodBeat.o(182895);
            }
        };
        AppMethodBeat.o(132124);
    }

    public final void by(Object obj) {
        AppMethodBeat.i(132125);
        a(aAe().azG(), obj);
        AppMethodBeat.o(132125);
    }

    private void a(h hVar, Object obj) {
        AppMethodBeat.i(132126);
        if (this.hrq.containsKey(obj)) {
            Log.i("MicroMsg.MMKernel", "Already add, skip it[%s].", obj);
            AppMethodBeat.o(132126);
        } else if (this.hrq.putIfAbsent(obj, this.hrq) != null) {
            Log.i("MicroMsg.MMKernel", "Already add, skip[%s].", obj);
            AppMethodBeat.o(132126);
        } else {
            com.tencent.mm.kernel.a.c.aAu().add(obj);
            if (obj instanceof ApplicationLifeCycle) {
                hVar.a((ApplicationLifeCycle) obj);
            }
            if (obj instanceof d) {
                this.hqh.add((d) obj);
            }
            if (obj instanceof com.tencent.mm.kernel.api.g) {
                this.hrh.a((com.tencent.mm.kernel.api.g) obj);
            }
            AppMethodBeat.o(132126);
        }
    }

    public final void a(com.tencent.mm.kernel.api.g gVar) {
        AppMethodBeat.i(132127);
        this.hrh.a(gVar);
        AppMethodBeat.o(132127);
    }

    public final void b(com.tencent.mm.kernel.api.g gVar) {
        AppMethodBeat.i(132128);
        this.hrh.b(gVar);
        AppMethodBeat.o(132128);
    }

    public final boolean aAb() {
        return this.hrr;
    }

    public static boolean aAc() {
        AppMethodBeat.i(132129);
        a aVar = aAi().hrl;
        if (aVar == null || !aVar.azp()) {
            AppMethodBeat.o(132129);
            return false;
        }
        AppMethodBeat.o(132129);
        return true;
    }

    public static c aAd() {
        AppMethodBeat.i(132130);
        Assert.assertNotNull("mCorePlugins not initialized!", aAi().hrh.aAd());
        c aAd = aAi().hrh.aAd();
        AppMethodBeat.o(132130);
        return aAd;
    }

    public static d<h> aAe() {
        AppMethodBeat.i(132131);
        Assert.assertNotNull("mCoreProcess not initialized!", aAi().hrh.aAe());
        d<h> aAe = aAi().hrh.aAe();
        AppMethodBeat.o(132131);
        return aAe;
    }

    public static a aAf() {
        AppMethodBeat.i(132132);
        Assert.assertNotNull("mCoreAccount not initialized!", aAi().hrl);
        a aVar = aAi().hrl;
        AppMethodBeat.o(132132);
        return aVar;
    }

    public static b aAg() {
        AppMethodBeat.i(132133);
        Assert.assertNotNull("mCoreNetwork not initialized!", aAi().hrm);
        b bVar = aAi().hrm;
        AppMethodBeat.o(132133);
        return bVar;
    }

    public static e aAh() {
        AppMethodBeat.i(132134);
        Assert.assertNotNull("mCoreStorage not initialized!", aAi().hrk);
        e eVar = aAi().hrk;
        AppMethodBeat.o(132134);
        return eVar;
    }

    public static g aAi() {
        AppMethodBeat.i(132135);
        Assert.assertNotNull("Kernel not initialized by MMApplication!", hrg);
        g gVar = hrg;
        AppMethodBeat.o(132135);
        return gVar;
    }

    public static <T extends com.tencent.mm.kernel.b.a> T ah(Class<T> cls) {
        AppMethodBeat.i(132136);
        aAi();
        T t = (T) aAd().ah(cls);
        AppMethodBeat.o(132136);
        return t;
    }

    public static <T extends com.tencent.mm.kernel.c.a> T af(Class<T> cls) {
        AppMethodBeat.i(132137);
        aAi();
        T t = (T) aAd().af(cls);
        AppMethodBeat.o(132137);
        return t;
    }

    public static <T extends com.tencent.mm.kernel.c.a, N extends T> void b(Class<T> cls, N n) {
        AppMethodBeat.i(132138);
        aAi();
        aAd().a(cls, new e(n));
        AppMethodBeat.o(132138);
    }

    public static <T extends com.tencent.mm.kernel.c.a, N extends T> void a(Class<T> cls, com.tencent.mm.kernel.c.c<N> cVar) {
        AppMethodBeat.i(132139);
        aAi();
        aAd().a(cls, cVar);
        AppMethodBeat.o(132139);
    }

    public static void ag(Class<? extends com.tencent.mm.kernel.c.a> cls) {
        AppMethodBeat.i(132140);
        aAi();
        aAd().ag(cls);
        AppMethodBeat.o(132140);
    }

    public static t azz() {
        AppMethodBeat.i(132141);
        aAi();
        t tVar = aAg().hqi;
        AppMethodBeat.o(132141);
        return tVar;
    }

    public static cm aAj() {
        AppMethodBeat.i(132142);
        Assert.assertTrue(aAi().hrp);
        cm cmVar = aAi().hrj;
        AppMethodBeat.o(132142);
        return cmVar;
    }

    @Deprecated
    public static MMHandlerThread aAk() {
        AppMethodBeat.i(132143);
        Assert.assertTrue(aAi().hrp);
        MMHandlerThread mMHandlerThread = aAi().hri;
        AppMethodBeat.o(132143);
        return mMHandlerThread;
    }

    public static synchronized void a(h hVar) {
        synchronized (g.class) {
            AppMethodBeat.i(132144);
            if (hrg != null) {
                h azG = hrg.hrh.aAe().azG();
                Application application = hVar.ca;
                azG.htz = hVar.htz;
                azG.ca = application;
                Log.i("MicroMsg.MMKernel", "Kernel not null, has initialized.");
                AppMethodBeat.o(132144);
            } else {
                j.a(new j.a() {
                    /* class com.tencent.mm.kernel.g.AnonymousClass3 */

                    @Override // com.tencent.mm.kernel.j.a
                    public final void e(String str, String str2, Object... objArr) {
                        AppMethodBeat.i(182896);
                        Log.e(str, str2, objArr);
                        AppMethodBeat.o(182896);
                    }

                    @Override // com.tencent.mm.kernel.j.a
                    public final void w(String str, String str2, Object... objArr) {
                        AppMethodBeat.i(182897);
                        Log.w(str, str2, objArr);
                        AppMethodBeat.o(182897);
                    }

                    @Override // com.tencent.mm.kernel.j.a
                    public final void i(String str, String str2, Object... objArr) {
                        AppMethodBeat.i(182898);
                        Log.i(str, str2, objArr);
                        AppMethodBeat.o(182898);
                    }

                    @Override // com.tencent.mm.kernel.j.a
                    public final void d(String str, String str2, Object... objArr) {
                        AppMethodBeat.i(182899);
                        Log.d(str, str2, objArr);
                        AppMethodBeat.o(182899);
                    }

                    @Override // com.tencent.mm.kernel.j.a
                    public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
                        AppMethodBeat.i(182900);
                        Log.printErrStackTrace(str, th, str2, objArr);
                        AppMethodBeat.o(182900);
                    }
                });
                Log.i("MicroMsg.MMKernel", "Initialize kernel, create whole WeChat world.");
                hrg = new g(hVar);
                AppMethodBeat.o(132144);
            }
        }
    }

    public static void qg(int i2) {
        AppMethodBeat.i(132145);
        a aAf = aAf();
        if (!a.qb(i2) || a.b.a(a.hpJ) != i2 || !aAf.azp()) {
            synchronized (aAf.hpI) {
                try {
                    a.b.a(a.hpJ, i2);
                    aAf.aze();
                    aAf.hpW = SystemClock.elapsedRealtime();
                    aAf.er(true);
                } finally {
                    AppMethodBeat.o(132145);
                }
            }
            return;
        }
        Log.w("MMKernel.CoreAccount", "loginUin, uin not changed, return :%d", Integer.valueOf(i2));
        AppMethodBeat.o(132145);
    }

    public final void FS(String str) {
        AppMethodBeat.i(132146);
        Log.w("MicroMsg.MMKernel", "logoutAccount uin:%s info:%s stack:%s", p.getString(a.getUin()), str, Util.getStack());
        a.FM(Util.getStack().toString() + str);
        this.hrl.azh().Ak((long) a.getUin());
        releaseAll();
        a.azc();
        a.es(false);
        AppMethodBeat.o(132146);
    }

    public final void releaseAll() {
        AppMethodBeat.i(132147);
        long currentTimeMillis = System.currentTimeMillis();
        Object[] objArr = new Object[1];
        String string = this.hrl != null ? p.getString(a.getUin()) : "-1";
        objArr[0] = string;
        Log.w("MicroMsg.MMKernel", "release uin:%s ", objArr);
        if (this.hrm.hqi != null) {
            this.hrm.hqi.reset();
        }
        com.tencent.f.g.shutdown();
        if (this.hri != null) {
            this.hri.syncReset(new MMHandlerThread.ResetCallback() {
                /* class com.tencent.mm.kernel.g.AnonymousClass4 */

                @Override // com.tencent.mm.sdk.platformtools.MMHandlerThread.ResetCallback
                public final void callback() {
                    AppMethodBeat.i(182901);
                    com.tencent.f.g.a(MMApplicationContext.getContext(), new aa());
                    if (g.this.hrl != null) {
                        g.this.hrl.release();
                    }
                    AppMethodBeat.o(182901);
                }
            });
        }
        Log.i("MicroMsg.MMKernel", "release uin:%s finish!!! cost:%sms", string, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
        AppMethodBeat.o(132147);
    }

    public final void a(com.tencent.mm.vending.h.d dVar) {
        AppMethodBeat.i(132148);
        this.hrh.a(dVar);
        AppMethodBeat.o(132148);
    }

    public final void et(boolean z) {
        AppMethodBeat.i(132149);
        this.hrh.hrD.cQ(z);
        AppMethodBeat.o(132149);
    }

    static /* synthetic */ void b(g gVar, h hVar, Object obj) {
        AppMethodBeat.i(132150);
        com.tencent.mm.kernel.a.c aAu = com.tencent.mm.kernel.a.c.aAu();
        if (obj instanceof com.tencent.mm.kernel.api.c) {
            aAu.hrU.remove((com.tencent.mm.kernel.api.c) obj);
        }
        if (obj instanceof com.tencent.mm.kernel.api.e) {
            aAu.hrV.remove((com.tencent.mm.kernel.api.e) obj);
        }
        if (obj instanceof com.tencent.mm.kernel.api.b) {
            aAu.hrW.remove((com.tencent.mm.kernel.api.b) obj);
        }
        if (obj instanceof com.tencent.mm.kernel.api.f) {
            aAu.hrX.remove((com.tencent.mm.kernel.api.f) obj);
        }
        if (obj instanceof o) {
            aAu.hrY.remove((o) obj);
        }
        if (obj instanceof ApplicationLifeCycle) {
            hVar.htA.remove((ApplicationLifeCycle) obj);
        }
        if (obj instanceof d) {
            gVar.hqh.remove((d) obj);
        }
        if (obj instanceof com.tencent.mm.kernel.api.g) {
            gVar.hrh.b((com.tencent.mm.kernel.api.g) obj);
        }
        AppMethodBeat.o(132150);
    }
}
