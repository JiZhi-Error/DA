package com.tencent.mm.kernel.a;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.o;
import com.tencent.mm.co.a;
import com.tencent.mm.kernel.a.a.a;
import com.tencent.mm.kernel.a.b.e;
import com.tencent.mm.kernel.a.b.f;
import com.tencent.mm.kernel.a.c.b;
import com.tencent.mm.kernel.api.h;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.at;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import junit.framework.Assert;

public final class c implements com.tencent.mm.kernel.api.c, com.tencent.mm.kernel.api.e, com.tencent.mm.kernel.api.f {
    private static c hrZ = new c();
    public static com.tencent.mm.vending.c.a<Void, f.a> hsc = new com.tencent.mm.vending.c.a<Void, f.a>() {
        /* class com.tencent.mm.kernel.a.c.AnonymousClass2 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Void call(f.a aVar) {
            AppMethodBeat.i(132157);
            f.a aVar2 = aVar;
            if (aVar2.htb.hsF == com.tencent.mm.kernel.b.b.class) {
                T t = aVar2.hsB;
                if (t.isConfigured()) {
                    Log.i("MicroMsg.CallbacksProxy", "skip configure for plugin %s.", t);
                } else {
                    Log.i("MicroMsg.CallbacksProxy", "configuring plugin [%s]...", t);
                    t.invokeConfigure(g.aAe().azG());
                }
            }
            Void r0 = QZL;
            AppMethodBeat.o(132157);
            return r0;
        }
    };
    public static com.tencent.mm.vending.c.a<Void, f.a> hsd = new com.tencent.mm.vending.c.a<Void, f.a>() {
        /* class com.tencent.mm.kernel.a.c.AnonymousClass3 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Void call(f.a aVar) {
            AppMethodBeat.i(132158);
            f.a aVar2 = aVar;
            if (aVar2.htb.hsF == b.class) {
                c.a(aVar2.hsB, g.aAe().azG());
            }
            Void r0 = QZL;
            AppMethodBeat.o(132158);
            return r0;
        }
    };
    public static com.tencent.mm.vending.c.a<Void, f.a> hse = new com.tencent.mm.vending.c.a<Void, f.a>() {
        /* class com.tencent.mm.kernel.a.c.AnonymousClass4 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.vending.c.a
        public final /* synthetic */ Void call(f.a aVar) {
            AppMethodBeat.i(132159);
            f.a aVar2 = aVar;
            Log.i("MicroMsg.CallbacksProxy", "before running %s", aVar2.hsB);
            if (aVar2.htb.hsF == h.class) {
                aVar2.hsB.aAq();
            } else if (aVar2.htb.hsF == com.tencent.mm.kernel.api.a.class) {
                c.a((com.tencent.mm.kernel.api.a) aVar2.hsB);
            } else if (aVar2.htb.hsF == com.tencent.mm.kernel.api.e.class) {
                aVar2.hsB.onDataBaseOpened(g.aAh().hqK, g.aAh().hqL);
            } else if (aVar2.htb.hsF == at.class) {
                c.b(aVar2.hsB);
            } else if (aVar2.htb.hsF == com.tencent.mm.kernel.api.c.class) {
                aVar2.hsB.onAccountInitialized(g.aAf().hpO);
            }
            Log.i("MicroMsg.CallbacksProxy", "[account-init] for phase(%s) subject(%s)", aVar2.htb.hsF, aVar2.hsB);
            Void r0 = QZL;
            AppMethodBeat.o(132159);
            return r0;
        }
    };
    private static Map<String, Map> hsf = new ConcurrentHashMap();
    private boolean hrQ = true;
    public final com.tencent.mm.kernel.a.b.g hrR = new com.tencent.mm.kernel.a.b.g();
    public final com.tencent.mm.kernel.a.b.g hrS = new com.tencent.mm.kernel.a.b.g();
    public final com.tencent.mm.kernel.a.b.g hrT = new com.tencent.mm.kernel.a.b.g();
    public final C0366c hrU = new C0366c((byte) 0);
    public final d hrV = new d();
    public final b hrW = new b();
    public final e hrX = new e();
    public final a hrY = new a();
    public volatile boolean hsa = false;
    private AtomicBoolean hsb = new AtomicBoolean(false);
    private Set<Looper> hsg = new HashSet();
    private ConcurrentHashMap<Object, f> hsh = new ConcurrentHashMap<>();
    private ConcurrentHashMap hsi = new ConcurrentHashMap();

    private c() {
        AppMethodBeat.i(132188);
        AppMethodBeat.o(132188);
    }

    static {
        AppMethodBeat.i(132212);
        AppMethodBeat.o(132212);
    }

    public static c aAu() {
        return hrZ;
    }

    public static boolean a(com.tencent.mm.kernel.a.b.g gVar, Class cls, Object obj) {
        AppMethodBeat.i(132189);
        f.a aVar = (f.a) gVar.an(cls).bE(obj);
        if (aVar == null) {
            AppMethodBeat.o(132189);
            return false;
        }
        boolean z = aVar.hsC;
        AppMethodBeat.o(132189);
        return z;
    }

    public final void bA(Object obj) {
        AppMethodBeat.i(132190);
        if (!g.aAe().azG().aBb()) {
            Log.d("MicroMsg.CallbacksProxy", "Not main process, skip making parallels dependencies.");
            AppMethodBeat.o(132190);
        } else if (com.tencent.mm.kernel.f.bx(obj)) {
            Log.printErrStackTrace("MicroMsg.CallbacksProxy", new RuntimeException(), "Found dummy subject!", new Object[0]);
            AppMethodBeat.o(132190);
        } else {
            this.hrT.bM(obj);
            AppMethodBeat.o(132190);
        }
    }

    public final void g(boolean z, String str) {
        AppMethodBeat.i(132191);
        if (z) {
            this.hrY.onAppForeground(str);
            AppMethodBeat.o(132191);
            return;
        }
        this.hrY.onAppBackground(str);
        AppMethodBeat.o(132191);
    }

    @Override // com.tencent.mm.kernel.api.f
    public final void aAp() {
        AppMethodBeat.i(259562);
        this.hrX.aAp();
        AppMethodBeat.o(259562);
    }

    @Override // com.tencent.mm.kernel.api.f
    public final void FU(String str) {
        AppMethodBeat.i(132193);
        this.hrW.FV(str);
        this.hrX.FU(str);
        AppMethodBeat.o(132193);
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(132194);
        if (this.hrQ) {
            com.tencent.mm.blink.a.CM("beforeAccountInit");
            this.hrT.c(com.tencent.mm.kernel.api.c.class, true);
            com.tencent.mm.kernel.a.b.e aAK = com.tencent.mm.kernel.a.b.e.aAK();
            aAK.a(new e.b(), hse, this.hrT);
            this.hrT.aAX();
            aAK.start("account-init from onAccountInitialized");
            aAK.aAM();
            AppMethodBeat.o(132194);
            return;
        }
        this.hrU.onAccountInitialized(cVar);
        AppMethodBeat.o(132194);
    }

    @Override // com.tencent.mm.kernel.api.c
    public final void onAccountRelease() {
        AppMethodBeat.i(132195);
        this.hrU.onAccountRelease();
        this.hrT.c(h.class, true);
        AppMethodBeat.o(132195);
    }

    @Override // com.tencent.mm.kernel.api.e
    public final void onDataBaseOpened(com.tencent.mm.storagebase.h hVar, com.tencent.mm.storagebase.h hVar2) {
        AppMethodBeat.i(132196);
        if (!this.hrQ) {
            this.hrV.onDataBaseOpened(hVar, hVar2);
        }
        AppMethodBeat.o(132196);
    }

    @Override // com.tencent.mm.kernel.api.e
    public final void onDataBaseClosed(com.tencent.mm.storagebase.h hVar, com.tencent.mm.storagebase.h hVar2) {
        AppMethodBeat.i(132197);
        this.hrV.onDataBaseClosed(hVar, hVar2);
        AppMethodBeat.o(132197);
    }

    public final void add(Object obj) {
        AppMethodBeat.i(132198);
        if (obj instanceof com.tencent.mm.kernel.api.c) {
            this.hrU.add((com.tencent.mm.kernel.api.c) obj);
        }
        if (obj instanceof com.tencent.mm.kernel.api.e) {
            this.hrV.add((com.tencent.mm.kernel.api.e) obj);
        }
        if (obj instanceof com.tencent.mm.kernel.api.b) {
            this.hrW.a((com.tencent.mm.kernel.api.b) obj);
        }
        if (obj instanceof com.tencent.mm.kernel.api.f) {
            this.hrX.a((com.tencent.mm.kernel.api.f) obj);
        }
        if (obj instanceof o) {
            this.hrY.c((o) obj);
        }
        AppMethodBeat.o(132198);
    }

    public final void f(Looper looper) {
        AppMethodBeat.i(132199);
        Log.i("MicroMsg.CallbacksProxy", "Thread(%s) not allow load-alone.", looper);
        this.hsg.add(looper);
        AppMethodBeat.o(132199);
    }

    private boolean aAv() {
        AppMethodBeat.i(132200);
        if (!g.aAe().azG().aBb()) {
            AppMethodBeat.o(132200);
            return false;
        } else if (this.hsg.contains(Looper.myLooper())) {
            Log.d("MicroMsg.CallbacksProxy", "Invalidate scene, it not allows to load alone in this thread(%s), illegal.", Looper.myLooper());
            AppMethodBeat.o(132200);
            return false;
        } else if (!g.aAi().hrh.hrB) {
            Log.e("MicroMsg.CallbacksProxy", "Invalidate scene, kernel does not startup done.");
            AppMethodBeat.o(132200);
            return false;
        } else {
            AppMethodBeat.o(132200);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public static final class f {
        private long hsv;
        private int mStatus;

        public f() {
            AppMethodBeat.i(132186);
            this.hsv = 0;
            this.mStatus = 0;
            this.hsv = Thread.currentThread().getId();
            AppMethodBeat.o(132186);
        }

        public final synchronized boolean aAB() {
            boolean z = false;
            synchronized (this) {
                AppMethodBeat.i(132187);
                if (this.mStatus == 1 && this.hsv == Thread.currentThread().getId()) {
                    AppMethodBeat.o(132187);
                } else if (this.mStatus == 2) {
                    AppMethodBeat.o(132187);
                } else {
                    AppMethodBeat.o(132187);
                    z = true;
                }
            }
            return z;
        }

        public final synchronized void qh(int i2) {
            if (i2 > this.mStatus) {
                this.mStatus = i2;
            }
        }
    }

    public final void bB(Object obj) {
        AppMethodBeat.i(132201);
        if (!this.hsb.get() || this.hsa) {
            AppMethodBeat.o(132201);
        } else if (!aAv()) {
            Log.d("MicroMsg.CallbacksProxy", "Invalidate scene for subject %s to load account-init alone.", obj);
            AppMethodBeat.o(132201);
        } else {
            if (!this.hsh.containsKey(obj)) {
                this.hsh.putIfAbsent(obj, new f());
            }
            f fVar = this.hsh.get(obj);
            if (!fVar.aAB()) {
                AppMethodBeat.o(132201);
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            Log.i("MicroMsg.CallbacksProxy", "loadAlone for subject %s", obj);
            Log.printErrStackTrace("MicroMsg.CallbacksProxy", new RuntimeException(), "loadAlone", new Object[0]);
            if (!this.hrT.bL(obj)) {
                Log.e("MicroMsg.CallbacksProxy", "This subject(%s) has not made dependency while loading alone.");
                this.hrT.bM(obj);
            }
            try {
                fVar.qh(1);
                if (obj instanceof com.tencent.mm.kernel.b.f) {
                    if (!((com.tencent.mm.kernel.b.f) obj).isConfigured()) {
                        f.a bJ = this.hrS.an(com.tencent.mm.kernel.b.b.class).bJ((com.tencent.mm.kernel.b.b) obj);
                        Assert.assertNotNull(bJ);
                        bJ.a(hsc);
                    }
                    f.a bJ2 = this.hrR.an(b.class).bJ((b) obj);
                    Assert.assertNotNull(bJ2);
                    bJ2.a(hsd);
                }
                if (!g.aAf().azp()) {
                    Log.i("MicroMsg.CallbacksProxy", "account not init, return.");
                    fVar.qh(2);
                    Log.i("MicroMsg.CallbacksProxy", "Subject(%s) load alone spend %sms", obj, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                    AppMethodBeat.o(132201);
                    return;
                }
                if (obj instanceof h) {
                    f.a bJ3 = this.hrT.an(h.class).bJ((h) obj);
                    Assert.assertNotNull(bJ3);
                    bJ3.a(hse);
                }
                if (obj instanceof com.tencent.mm.kernel.api.a) {
                    f.a bJ4 = this.hrT.an(com.tencent.mm.kernel.api.a.class).bJ((com.tencent.mm.kernel.api.a) obj);
                    Assert.assertNotNull(bJ4);
                    bJ4.a(hse);
                }
                if (obj instanceof at) {
                    f.a bJ5 = this.hrT.an(at.class).bJ((at) obj);
                    Assert.assertNotNull(bJ5);
                    bJ5.a(hse);
                }
                if (obj instanceof com.tencent.mm.kernel.api.e) {
                    f.a bJ6 = this.hrT.an(com.tencent.mm.kernel.api.e.class).bJ((com.tencent.mm.kernel.api.e) obj);
                    Assert.assertNotNull(bJ6);
                    bJ6.a(hse);
                }
                if (obj instanceof com.tencent.mm.kernel.api.c) {
                    f.a bJ7 = this.hrT.an(com.tencent.mm.kernel.api.c.class).bJ((com.tencent.mm.kernel.api.c) obj);
                    Assert.assertNotNull(bJ7);
                    bJ7.a(hse);
                }
                fVar.qh(2);
                Log.i("MicroMsg.CallbacksProxy", "Subject(%s) load alone spend %sms", obj, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(132201);
            } catch (Throwable th) {
                fVar.qh(2);
                Log.i("MicroMsg.CallbacksProxy", "Subject(%s) load alone spend %sms", obj, Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
                AppMethodBeat.o(132201);
                throw th;
            }
        }
    }

    public final void bC(Object obj) {
        AppMethodBeat.i(132202);
        Log.i("MicroMsg.CallbacksProxy", "add pending callbacks %s", obj);
        this.hsi.putIfAbsent(obj, this.hsi);
        AppMethodBeat.o(132202);
    }

    private void aAw() {
        AppMethodBeat.i(132203);
        for (Object obj : this.hsi.keySet()) {
            g.aAi().by(obj);
            hrZ.bA(obj);
        }
        AppMethodBeat.o(132203);
    }

    public final void aAx() {
        AppMethodBeat.i(132204);
        com.tencent.mm.blink.a.CM("initializePendingPlugins");
        if (this.hsb.compareAndSet(false, true)) {
            Log.i("MicroMsg.CallbacksProxy", "initialize pending plugins.");
            aAy();
            aAw();
            aAz();
            aAA();
            this.hsa = true;
            if (g.aAe().azG().aBb()) {
                g.aAf().azg();
            }
            com.tencent.mm.blink.a.CM("initializePendingPlugins done");
            if ((com.tencent.mm.protocal.d.KyR || com.tencent.mm.protocal.d.KyQ) && g.aAe().azG().aBb() && g.aAf().azp()) {
                a(this.hrR);
                a(this.hrS);
                a(this.hrT);
            }
            com.tencent.mm.kernel.a.b.e.aAK();
            com.tencent.mm.blink.a.CM("checkAllUnConsumed done");
        }
        AppMethodBeat.o(132204);
    }

    private static void a(com.tencent.mm.kernel.a.b.g gVar) {
        AppMethodBeat.i(132205);
        Map<com.tencent.mm.kernel.a.b.f, List<a.C0364a>> aAW = gVar.aAW();
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(aAW.size() > 0);
        objArr[1] = gVar;
        Log.i("MicroMsg.CallbacksProxy", "do parallels result check, %s for %s", objArr);
        if (aAW.size() > 0) {
            com.tencent.mm.blink.a.t(0, 1);
            HashMap hashMap = new HashMap();
            StringBuilder sb = new StringBuilder();
            for (com.tencent.mm.kernel.a.b.f fVar : aAW.keySet()) {
                sb.append(fVar.hsU);
                sb.append(" : ");
                sb.append(aAW.get(fVar).toString());
                sb.append("\n");
            }
            String sb2 = sb.toString();
            Log.e("MicroMsg.CallbacksProxy", "unconsumed message %s", sb2);
            Log.e("MicroMsg.CallbacksProxy", "maybe cycle dependencies");
            com.tencent.mm.plugin.report.e.INSTANCE.e("BlinkStartup", sb2, hashMap);
        }
        AppMethodBeat.o(132205);
    }

    private void aAz() {
        AppMethodBeat.i(132207);
        com.tencent.mm.blink.a.CM("configureAndExecutePendingPlugins");
        this.hrS.c(com.tencent.mm.kernel.b.b.class, false);
        com.tencent.mm.kernel.a.b.e.aAK().a(new e.b(), hsc, this.hrS, "configure-functional from pending plugins");
        y.heW();
        this.hrR.c(b.class, false);
        com.tencent.mm.kernel.a.b.e.aAK().a(new e.b(), hsd, this.hrR, "task-functional from pending plugins");
        com.tencent.mm.blink.a.CM("configureAndExecutePendingPlugins done");
        AppMethodBeat.o(132207);
    }

    private void aAA() {
        AppMethodBeat.i(132208);
        if (!g.aAe().azG().aBb() || !g.aAf().azp()) {
            AppMethodBeat.o(132208);
            return;
        }
        this.hrT.c(h.class, false);
        com.tencent.mm.kernel.a.b.e aAK = com.tencent.mm.kernel.a.b.e.aAK();
        aAK.a(new e.b(), hse, this.hrT);
        this.hrT.aAX();
        aAK.start("account-init from pending plugins");
        aAK.aAM();
        AppMethodBeat.o(132208);
    }

    /* renamed from: com.tencent.mm.kernel.a.c$c  reason: collision with other inner class name */
    public static class C0366c extends com.tencent.mm.co.a<com.tencent.mm.kernel.api.c> implements com.tencent.mm.kernel.api.c {
        private C0366c() {
        }

        /* synthetic */ C0366c(byte b2) {
            this();
        }

        @Override // com.tencent.mm.kernel.api.c
        public final void onAccountInitialized(final e.c cVar) {
            AppMethodBeat.i(132173);
            a(new a.AbstractC0297a<com.tencent.mm.kernel.api.c>() {
                /* class com.tencent.mm.kernel.a.c.C0366c.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.co.a.AbstractC0297a
                public final /* synthetic */ void bw(com.tencent.mm.kernel.api.c cVar) {
                    AppMethodBeat.i(132171);
                    cVar.onAccountInitialized(cVar);
                    AppMethodBeat.o(132171);
                }
            });
            AppMethodBeat.o(132173);
        }

        @Override // com.tencent.mm.kernel.api.c
        public final void onAccountRelease() {
            AppMethodBeat.i(132174);
            a(new a.AbstractC0297a<com.tencent.mm.kernel.api.c>() {
                /* class com.tencent.mm.kernel.a.c.C0366c.AnonymousClass2 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.co.a.AbstractC0297a
                public final /* synthetic */ void bw(com.tencent.mm.kernel.api.c cVar) {
                    AppMethodBeat.i(132172);
                    com.tencent.mm.kernel.api.c cVar2 = cVar;
                    if (C0366c.a(cVar2)) {
                        cVar2.onAccountRelease();
                    }
                    AppMethodBeat.o(132172);
                }
            });
            AppMethodBeat.o(132174);
        }

        static /* synthetic */ boolean a(com.tencent.mm.kernel.api.c cVar) {
            AppMethodBeat.i(132175);
            boolean a2 = c.a(c.aAu().hrT, com.tencent.mm.kernel.api.c.class, cVar);
            AppMethodBeat.o(132175);
            return a2;
        }
    }

    public static class d extends com.tencent.mm.co.a<com.tencent.mm.kernel.api.e> implements com.tencent.mm.kernel.api.e {
        d() {
        }

        @Override // com.tencent.mm.kernel.api.e
        public final void onDataBaseOpened(final com.tencent.mm.storagebase.h hVar, final com.tencent.mm.storagebase.h hVar2) {
            AppMethodBeat.i(132178);
            a(new a.AbstractC0297a<com.tencent.mm.kernel.api.e>() {
                /* class com.tencent.mm.kernel.a.c.d.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.co.a.AbstractC0297a
                public final /* synthetic */ void bw(com.tencent.mm.kernel.api.e eVar) {
                    AppMethodBeat.i(132176);
                    eVar.onDataBaseOpened(hVar, hVar2);
                    AppMethodBeat.o(132176);
                }
            });
            AppMethodBeat.o(132178);
        }

        @Override // com.tencent.mm.kernel.api.e
        public final void onDataBaseClosed(final com.tencent.mm.storagebase.h hVar, final com.tencent.mm.storagebase.h hVar2) {
            AppMethodBeat.i(132179);
            a(new a.AbstractC0297a<com.tencent.mm.kernel.api.e>() {
                /* class com.tencent.mm.kernel.a.c.d.AnonymousClass2 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.co.a.AbstractC0297a
                public final /* synthetic */ void bw(com.tencent.mm.kernel.api.e eVar) {
                    AppMethodBeat.i(132177);
                    eVar.onDataBaseClosed(hVar, hVar2);
                    AppMethodBeat.o(132177);
                }
            });
            AppMethodBeat.o(132179);
        }
    }

    public static class b extends com.tencent.mm.co.a<com.tencent.mm.kernel.api.b> implements com.tencent.mm.kernel.api.b {
        private boolean hsl = false;

        b() {
        }

        /* Return type fixed from 'com.tencent.mm.vending.b.b' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.co.a
        public final /* synthetic */ com.tencent.mm.vending.b.b<com.tencent.mm.kernel.api.b> add(com.tencent.mm.kernel.api.b bVar) {
            AppMethodBeat.i(132170);
            com.tencent.mm.vending.b.b<com.tencent.mm.kernel.api.b> a2 = a(bVar);
            AppMethodBeat.o(132170);
            return a2;
        }

        public final synchronized com.tencent.mm.vending.b.b<com.tencent.mm.kernel.api.b> a(com.tencent.mm.kernel.api.b bVar) {
            com.tencent.mm.vending.b.b<com.tencent.mm.kernel.api.b> add;
            AppMethodBeat.i(132166);
            add = super.add(bVar);
            if (this.hsl) {
                List<String> aAo = bVar.aAo();
                if (aAo != null && aAo.size() > 0) {
                    d(aAo, g.aAh().hqG);
                }
                Log.i("MicroMsg.CallbacksProxy", "collectStoragePaths has been called. cb %s", bVar);
            }
            AppMethodBeat.o(132166);
            return add;
        }

        @Override // com.tencent.mm.kernel.api.b
        public final List<String> aAo() {
            List<String> aAo;
            AppMethodBeat.i(132167);
            LinkedList<com.tencent.mm.vending.b.b> queue = getQueue();
            LinkedList linkedList = new LinkedList();
            Iterator<com.tencent.mm.vending.b.b> it = queue.iterator();
            while (it.hasNext()) {
                com.tencent.mm.vending.b.b next = it.next();
                if (!(next == null || (aAo = next.QZG.aAo()) == null)) {
                    linkedList.addAll(aAo);
                }
            }
            AppMethodBeat.o(132167);
            return linkedList;
        }

        public final synchronized void FV(String str) {
            AppMethodBeat.i(132168);
            List<String> aAo = aAo();
            this.hsl = true;
            Log.i("MicroMsg.CallbacksProxy", "all account storage folder %s", aAo.toString());
            d(aAo, str);
            AppMethodBeat.o(132168);
        }

        private static void d(List<String> list, String str) {
            AppMethodBeat.i(132169);
            String[] strArr = new String[(list.size() + 1)];
            strArr[0] = str;
            for (int i2 = 0; i2 < list.size(); i2++) {
                strArr[i2 + 1] = str + list.get(i2);
            }
            for (String str2 : strArr) {
                com.tencent.mm.vfs.o oVar = new com.tencent.mm.vfs.o(str2);
                if (!oVar.exists() && (!oVar.mkdirs() || !oVar.isDirectory())) {
                    Log.e("MicroMsg.CallbacksProxy", "batchMkDirs mkdir error. %s", str2);
                }
            }
            AppMethodBeat.o(132169);
        }
    }

    public static class e extends com.tencent.mm.co.a<com.tencent.mm.kernel.api.f> implements com.tencent.mm.kernel.api.f {
        private boolean hsr = false;
        private String hss;

        e() {
        }

        /* Return type fixed from 'com.tencent.mm.vending.b.b' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.co.a
        public final /* synthetic */ com.tencent.mm.vending.b.b<com.tencent.mm.kernel.api.f> add(com.tencent.mm.kernel.api.f fVar) {
            AppMethodBeat.i(132185);
            com.tencent.mm.vending.b.b<com.tencent.mm.kernel.api.f> a2 = a(fVar);
            AppMethodBeat.o(132185);
            return a2;
        }

        @Override // com.tencent.mm.kernel.api.f
        public final void aAp() {
            AppMethodBeat.i(132182);
            a(new a.AbstractC0297a<com.tencent.mm.kernel.api.f>() {
                /* class com.tencent.mm.kernel.a.c.e.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.co.a.AbstractC0297a
                public final /* synthetic */ void bw(com.tencent.mm.kernel.api.f fVar) {
                    AppMethodBeat.i(132180);
                    fVar.aAp();
                    AppMethodBeat.o(132180);
                }
            });
            AppMethodBeat.o(132182);
        }

        public final synchronized com.tencent.mm.vending.b.b<com.tencent.mm.kernel.api.f> a(com.tencent.mm.kernel.api.f fVar) {
            com.tencent.mm.vending.b.b<com.tencent.mm.kernel.api.f> add;
            AppMethodBeat.i(132183);
            add = super.add(fVar);
            if (this.hsr) {
                fVar.FU(this.hss);
                Log.i("MicroMsg.CallbacksProxy", "onAccountPathChanged has been called. cb %s", fVar);
            }
            AppMethodBeat.o(132183);
            return add;
        }

        @Override // com.tencent.mm.kernel.api.f
        public final synchronized void FU(final String str) {
            AppMethodBeat.i(132184);
            a(new a.AbstractC0297a<com.tencent.mm.kernel.api.f>() {
                /* class com.tencent.mm.kernel.a.c.e.AnonymousClass2 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.co.a.AbstractC0297a
                public final /* synthetic */ void bw(com.tencent.mm.kernel.api.f fVar) {
                    AppMethodBeat.i(132181);
                    fVar.FU(str);
                    AppMethodBeat.o(132181);
                }
            });
            this.hsr = true;
            this.hss = str;
            AppMethodBeat.o(132184);
        }
    }

    public static class a extends com.tencent.mm.co.a<o> implements o {
        a() {
        }

        /* Return type fixed from 'com.tencent.mm.vending.b.b' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.co.a
        public final /* synthetic */ com.tencent.mm.vending.b.b<o> add(o oVar) {
            AppMethodBeat.i(132165);
            com.tencent.mm.vending.b.b<o> c2 = c(oVar);
            AppMethodBeat.o(132165);
            return c2;
        }

        public final synchronized com.tencent.mm.vending.b.b<o> c(o oVar) {
            com.tencent.mm.vending.b.b<o> add;
            AppMethodBeat.i(132162);
            add = super.add(oVar);
            AppMethodBeat.o(132162);
            return add;
        }

        @Override // com.tencent.mm.app.o
        public final synchronized void onAppForeground(final String str) {
            AppMethodBeat.i(132163);
            a(new a.AbstractC0297a<o>() {
                /* class com.tencent.mm.kernel.a.c.a.AnonymousClass1 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.co.a.AbstractC0297a
                public final /* synthetic */ void bw(o oVar) {
                    AppMethodBeat.i(132160);
                    oVar.onAppForeground(str);
                    AppMethodBeat.o(132160);
                }
            });
            AppMethodBeat.o(132163);
        }

        @Override // com.tencent.mm.app.o
        public final synchronized void onAppBackground(final String str) {
            AppMethodBeat.i(132164);
            a(new a.AbstractC0297a<o>() {
                /* class com.tencent.mm.kernel.a.c.a.AnonymousClass2 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.co.a.AbstractC0297a
                public final /* synthetic */ void bw(o oVar) {
                    AppMethodBeat.i(132161);
                    oVar.onAppBackground(str);
                    AppMethodBeat.o(132161);
                }
            });
            AppMethodBeat.o(132164);
        }
    }

    private static void aAy() {
        AppMethodBeat.i(132206);
        c cVar = hrZ;
        for (com.tencent.mm.kernel.b.f fVar : g.aAd().azF()) {
            cVar.bA(fVar);
        }
        com.tencent.mm.blink.a.CM("makePluginsParallelsDependency");
        AppMethodBeat.o(132206);
    }

    static /* synthetic */ void a(b bVar, com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(132209);
        String str = bVar.getClass().getName() + "@" + bVar.hashCode();
        if (!hsf.containsKey(str)) {
            bVar.execute(gVar);
            hsf.put(str, hsf);
            a.k("boot task executing [%s] hash %s...", bVar.name(), Integer.valueOf(bVar.hashCode()));
            AppMethodBeat.o(132209);
            return;
        }
        a.k("skip task %s execution hash %s", bVar.name(), Integer.valueOf(bVar.hashCode()));
        AppMethodBeat.o(132209);
    }

    static /* synthetic */ void a(com.tencent.mm.kernel.api.a aVar) {
        AppMethodBeat.i(132210);
        g.aAh().a(g.aAh().hqK.gFG(), aVar.collectDatabaseFactory());
        AppMethodBeat.o(132210);
    }

    static /* synthetic */ void b(at atVar) {
        AppMethodBeat.i(132211);
        g.aAh().a(atVar);
        AppMethodBeat.o(132211);
    }
}
