package com.tencent.mm.ui.l.a;

import android.webkit.ValueCallback;
import android.widget.FrameLayout;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.api.v;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.appbrand.ac.i;
import com.tencent.mm.plugin.appbrand.appcache.bd;
import com.tencent.mm.plugin.appbrand.appstorage.m;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.game.a.n;
import com.tencent.mm.plugin.appbrand.service.u;
import com.tencent.mm.plugin.emoji.magicemoji.b.a;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.chatting.d.b.j;
import com.tencent.mm.ui.l.a.e;
import com.tencent.mm.vending.g.c;
import com.tencent.mm.vending.g.d;
import com.tencent.mm.vfs.s;
import com.tencent.mmkv.MMKV;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentLinkedDeque;

public enum b implements v {
    INSTANCE;
    
    private boolean Qlt = false;
    private final Map<String, a> Qlv = new HashMap(1);
    private a.EnumC0959a VlY = null;
    private int VlZ = 0;

    public static class a {
        g QlF;
        e QlG;
        c<g> QlH;
        c<e> QlI;
        List<c> QlJ;
    }

    private b(String str) {
        AppMethodBeat.i(234348);
        AppMethodBeat.o(234348);
    }

    static /* synthetic */ void a(b bVar, a.EnumC0959a aVar) {
        AppMethodBeat.i(234359);
        bVar.b(aVar);
        AppMethodBeat.o(234359);
    }

    static /* synthetic */ void b(b bVar) {
        AppMethodBeat.i(257976);
        bVar.bUc();
        AppMethodBeat.o(257976);
    }

    static /* synthetic */ int c(b bVar) {
        int i2 = bVar.VlZ;
        bVar.VlZ = i2 + 1;
        return i2;
    }

    public static b valueOf(String str) {
        AppMethodBeat.i(234347);
        b bVar = (b) Enum.valueOf(b.class, str);
        AppMethodBeat.o(234347);
        return bVar;
    }

    static {
        AppMethodBeat.i(234363);
        AppMethodBeat.o(234363);
    }

    @Override // com.tencent.mm.api.v
    public final synchronized void zX(int i2) {
        AppMethodBeat.i(257969);
        Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: config with version: %d", Integer.valueOf(i2));
        ((u) g.af(u.class)).r(com.tencent.mm.plugin.emoji.magicemoji.b.a.xiT.userName, com.tencent.mm.plugin.emoji.magicemoji.b.a.xiT.appId, 999);
        ((com.tencent.mm.plugin.appbrand.service.v) g.af(com.tencent.mm.plugin.appbrand.service.v.class)).bc(com.tencent.mm.plugin.emoji.magicemoji.b.a.xiT.appId, i2);
        AppMethodBeat.o(257969);
    }

    @Override // com.tencent.mm.api.v
    public final void Vw() {
        AppMethodBeat.i(257970);
        if (((com.tencent.mm.plugin.emoji.magicemoji.a.a) g.af(com.tencent.mm.plugin.emoji.magicemoji.a.a.class)).cFs()) {
            Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: trigger preload magic emoji service");
            hed();
        }
        AppMethodBeat.o(257970);
    }

    @Override // com.tencent.mm.api.v
    public final synchronized void cFB() {
        AppMethodBeat.i(257971);
        Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: triggered destroy");
        bUc();
        AppMethodBeat.o(257971);
    }

    private void bUc() {
        AppMethodBeat.i(257972);
        String str = com.tencent.mm.plugin.emoji.magicemoji.b.a.xiT.appId;
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.MagicEmojiEnvMgr", "hy: appid invalid");
            AppMethodBeat.o(257972);
            return;
        }
        final a aVar = this.Qlv.get(str);
        if (aVar == null) {
            Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: item not event loaded");
            AppMethodBeat.o(257972);
            return;
        }
        this.Qlv.remove(str);
        aN(new Runnable() {
            /* class com.tencent.mm.ui.l.a.b.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(234331);
                Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: destroy imp in ui thread");
                synchronized (b.this) {
                    try {
                        if (aVar.QlH != null) {
                            Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: has serviceLoadTask, trigger terminate");
                            aVar.QlH.stop();
                            aVar.QlH = null;
                        }
                        if (aVar.QlI != null) {
                            Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: has runtimeLoadTask, trigger terminate");
                            aVar.QlI.stop();
                            aVar.QlI = null;
                        }
                        if (aVar.QlG != null) {
                            Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: has runtime, trigger destroy");
                            e eVar = aVar.QlG;
                            if (eVar.mIsRunning) {
                                Log.i("MicroMsg.MagicEmojiRuntime", "hy: destroying runtime");
                                synchronized (eVar) {
                                    try {
                                        ConcurrentLinkedDeque concurrentLinkedDeque = new ConcurrentLinkedDeque(eVar.Vmb);
                                        while (!concurrentLinkedDeque.isEmpty()) {
                                            ((e.a) Objects.requireNonNull(concurrentLinkedDeque.poll())).onDestroy();
                                        }
                                        eVar.Vmb.clear();
                                    } catch (Throwable th) {
                                        AppMethodBeat.o(234331);
                                        throw th;
                                    }
                                }
                                eVar.hYO();
                                e.a(eVar.QlV);
                                e.a(eVar.QlU);
                                eVar.QlV = null;
                                eVar.QlU = null;
                            }
                            eVar.mIsRunning = false;
                            aVar.QlG = null;
                        } else if (aVar.QlF != null) {
                            Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: has service, trigger destroy");
                            aVar.QlF.notifyDestroy();
                            aVar.QlF = null;
                        }
                    } finally {
                        AppMethodBeat.o(234331);
                    }
                }
            }
        });
        AppMethodBeat.o(257972);
    }

    private static void aN(Runnable runnable) {
        AppMethodBeat.i(234353);
        if (MMHandlerThread.isMainThread()) {
            runnable.run();
            AppMethodBeat.o(234353);
            return;
        }
        h.RTc.aV(runnable);
        AppMethodBeat.o(234353);
    }

    private synchronized c<g> hed() {
        final a aVar;
        c<g> h2;
        AppMethodBeat.i(257973);
        String str = com.tencent.mm.plugin.emoji.magicemoji.b.a.xiT.appId;
        a aVar2 = this.Qlv.get(str);
        if (aVar2 == null) {
            a aVar3 = new a();
            this.Qlv.put(str, aVar3);
            aVar = aVar3;
        } else {
            aVar = aVar2;
        }
        if (aVar.QlF != null) {
            Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: service already loaded");
            h2 = com.tencent.mm.co.g.ey(aVar.QlF).h(new com.tencent.mm.vending.c.a<g, g>() {
                /* class com.tencent.mm.ui.l.a.b.AnonymousClass5 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.vending.c.a
                public final /* bridge */ /* synthetic */ g call(g gVar) {
                    return gVar;
                }
            });
        } else if (aVar.QlH != null) {
            Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: service already loading");
            h2 = aVar.QlH;
        } else {
            h2 = com.tencent.mm.co.g.ey(str).h(new com.tencent.mm.vending.c.a<g, String>() {
                /* class com.tencent.mm.ui.l.a.b.AnonymousClass6 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.vending.c.a
                public final /* synthetic */ g call(String str) {
                    AppMethodBeat.i(234336);
                    g byK = byK(str);
                    AppMethodBeat.o(234336);
                    return byK;
                }

                private g byK(String str) {
                    AppMethodBeat.i(259029);
                    bd H = ((com.tencent.mm.plugin.appbrand.service.v) g.af(com.tencent.mm.plugin.appbrand.service.v.class)).H(str, com.tencent.mm.plugin.emoji.magicemoji.b.a.xiT.iOo, 0);
                    if (H != null) {
                        Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: reset config version to %d", Integer.valueOf(H.field_version));
                        b.this.zX(H.field_version);
                    }
                    a.EnumC0959a cFt = ((com.tencent.mm.plugin.emoji.magicemoji.a.a) g.af(com.tencent.mm.plugin.emoji.magicemoji.a.a.class)).cFt();
                    if (com.tencent.mm.plugin.emoji.magicemoji.b.a.a(cFt)) {
                        com.tencent.mm.vending.g.g.hdx().ej(cFt);
                        AppMethodBeat.o(259029);
                        return null;
                    }
                    ((com.tencent.mm.plugin.emoji.magicemoji.a.a) g.af(com.tencent.mm.plugin.emoji.magicemoji.a.a.class)).cFu();
                    g byJ = b.byJ(str);
                    synchronized (b.this) {
                        try {
                            aVar.QlF = byJ;
                            aVar.QlH = null;
                        } finally {
                            AppMethodBeat.o(259029);
                        }
                    }
                    return byJ;
                }
            });
        }
        aVar.QlH = h2;
        AppMethodBeat.o(257973);
        return h2;
    }

    public final synchronized void c(final c cVar) {
        final a aVar;
        AppMethodBeat.i(257974);
        String str = com.tencent.mm.plugin.emoji.magicemoji.b.a.xiT.appId;
        a aVar2 = this.Qlv.get(str);
        if (aVar2 != null && aVar2.QlG != null) {
            Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: on message and everything prepared");
            aVar2.QlG.a(cVar);
            AppMethodBeat.o(257974);
        } else if (aVar2 == null || aVar2.QlJ == null) {
            if (aVar2 == null) {
                a aVar3 = new a();
                this.Qlv.put(str, aVar3);
                aVar = aVar3;
            } else {
                aVar = aVar2;
            }
            aVar.QlJ = new LinkedList();
            aVar.QlJ.add(cVar);
            a(cVar.QlL.get(), cVar.QlK).f(new com.tencent.mm.vending.c.a<Boolean, e>() {
                /* class com.tencent.mm.ui.l.a.b.AnonymousClass8 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.vending.c.a
                public final /* synthetic */ Boolean call(e eVar) {
                    AppMethodBeat.i(234339);
                    Boolean a2 = a(eVar);
                    AppMethodBeat.o(234339);
                    return a2;
                }

                private Boolean a(e eVar) {
                    AppMethodBeat.i(234338);
                    for (c cVar : aVar.QlJ) {
                        if (cVar.QlK.get() == null || cVar.QlL.get() == null || cVar.QlK.get() != cVar.QlK.get() || cVar.QlL.get() != cVar.QlL.get()) {
                            Log.w("MicroMsg.MagicEmojiEnvMgr", "hy: pending msg chatting released. ignore current chatting");
                        } else {
                            eVar.a(cVar);
                        }
                    }
                    synchronized (b.this) {
                        try {
                            aVar.QlJ.clear();
                        } catch (Throwable th) {
                            AppMethodBeat.o(234338);
                            throw th;
                        }
                    }
                    Boolean bool = Boolean.TRUE;
                    AppMethodBeat.o(234338);
                    return bool;
                }
            }).a(new d.a<a.EnumC0959a>() {
                /* class com.tencent.mm.ui.l.a.b.AnonymousClass7 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.vending.g.d.a
                public final /* synthetic */ void cn(a.EnumC0959a aVar) {
                    AppMethodBeat.i(234337);
                    a.EnumC0959a aVar2 = aVar;
                    Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: on interrupt %s", aVar2.name());
                    com.tencent.mm.ui.l.b.a.bnK(String.format("magic emoji startup failed: %s", aVar2.name()));
                    b.a(b.this, aVar2);
                    if (aVar2 != a.EnumC0959a.NoPkg) {
                        b.b(b.this);
                        AppMethodBeat.o(234337);
                        return;
                    }
                    aVar.QlI = null;
                    aVar.QlG = null;
                    aVar.QlJ = null;
                    AppMethodBeat.o(234337);
                }
            });
            AppMethodBeat.o(257974);
        } else {
            Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: on message and runtime is preparing");
            aVar2.QlJ.add(cVar);
            AppMethodBeat.o(257974);
        }
    }

    private synchronized void b(a.EnumC0959a aVar) {
        AppMethodBeat.i(259030);
        if (this.VlY == null || this.VlY != aVar) {
            switch (aVar) {
                case Ok:
                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1619, 0);
                    break;
                case NoPkg:
                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1619, 1);
                    break;
                case DownloadFailed:
                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1619, 2);
                    break;
                case CrashTooMuch:
                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1619, 3);
                    break;
                case DisabledByServer:
                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1619, 4);
                    break;
                case MemoryWarningTooMuch:
                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1619, 5);
                    break;
                case DownloadSucc:
                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1619, 7);
                    break;
                case DownloadFailedTooMuch:
                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1619, 8);
                    break;
                default:
                    com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1619, 6);
                    break;
            }
        }
        this.VlY = aVar;
        AppMethodBeat.o(259030);
    }

    public final synchronized c<e> a(final FrameLayout frameLayout, final WeakReference<com.tencent.mm.ui.chatting.e.a> weakReference) {
        a aVar;
        c<e> cVar;
        AppMethodBeat.i(259031);
        final a.b bVar = com.tencent.mm.plugin.emoji.magicemoji.b.a.xiT;
        a aVar2 = this.Qlv.get(bVar.appId);
        if (aVar2 == null) {
            a aVar3 = new a();
            this.Qlv.put(bVar.appId, aVar3);
            aVar = aVar3;
        } else {
            aVar = aVar2;
        }
        cVar = aVar.QlI;
        if (aVar.QlG != null) {
            cVar = com.tencent.mm.co.g.ey(aVar.QlG).b(new com.tencent.mm.vending.c.a<e, e>() {
                /* class com.tencent.mm.ui.l.a.b.AnonymousClass9 */

                /* Return type fixed from 'java.lang.Object' to match base method */
                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.vending.c.a
                public final /* bridge */ /* synthetic */ e call(e eVar) {
                    return eVar;
                }
            });
            AppMethodBeat.o(259031);
        } else {
            if (cVar == null) {
                cVar = hed().c(new com.tencent.mm.vending.c.a<e, g>() {
                    /* class com.tencent.mm.ui.l.a.b.AnonymousClass3 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.tencent.mm.vending.c.a
                    public final /* synthetic */ e call(g gVar) {
                        AppMethodBeat.i(234333);
                        e a2 = b.a(gVar);
                        AppMethodBeat.o(234333);
                        return a2;
                    }
                }).c(new com.tencent.mm.vending.c.a<com.tencent.mm.vending.j.c<bd, e>, e>() {
                    /* class com.tencent.mm.ui.l.a.b.AnonymousClass2 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.tencent.mm.vending.c.a
                    public final /* synthetic */ com.tencent.mm.vending.j.c<bd, e> call(e eVar) {
                        AppMethodBeat.i(234332);
                        e eVar2 = eVar;
                        bd H = ((com.tencent.mm.plugin.appbrand.service.v) g.af(com.tencent.mm.plugin.appbrand.service.v.class)).H(bVar.appId, bVar.iOo, 0);
                        if (H == null) {
                            com.tencent.mm.pluginsdk.j.a.a.b.gnC();
                            String kC = com.tencent.mm.pluginsdk.j.a.a.b.kC(37, 9);
                            if (s.YS(kC)) {
                                int aiX = com.tencent.mm.plugin.emoji.e.h.cFT().aiX(kC);
                                b.this.zX(aiX);
                                Log.i("MicroMsg.MagicEmojiEnvMgr", "update magic emoji res from cache to version: %d", Integer.valueOf(aiX));
                                H = ((com.tencent.mm.plugin.appbrand.service.v) g.af(com.tencent.mm.plugin.appbrand.service.v.class)).H(bVar.appId, bVar.iOo, 0);
                            }
                        } else {
                            Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: local record is %d", Integer.valueOf(H.field_version));
                        }
                        com.tencent.mm.vending.j.c Q = com.tencent.mm.vending.j.c.Q(H, eVar2);
                        AppMethodBeat.o(234332);
                        return Q;
                    }
                }).c(new com.tencent.mm.vending.c.a<com.tencent.mm.vending.j.c<bd, e>, com.tencent.mm.vending.j.c<bd, e>>() {
                    /* class com.tencent.mm.ui.l.a.b.AnonymousClass12 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.tencent.mm.vending.c.a
                    public final /* synthetic */ com.tencent.mm.vending.j.c<bd, e> call(com.tencent.mm.vending.j.c<bd, e> cVar) {
                        AppMethodBeat.i(234345);
                        final com.tencent.mm.vending.j.c<bd, e> cVar2 = cVar;
                        if (cVar2.get(0) == null || b.gWz()) {
                            Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: not found record or need to sync wait!!");
                            final com.tencent.mm.vending.g.b hdH = com.tencent.mm.vending.g.g.hdH();
                            if (b.gWA()) {
                                b.c(b.this);
                                Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: trigger download. current download times: %d", Integer.valueOf(b.this.VlZ));
                                if (b.this.VlZ <= 3) {
                                    ((u) g.af(u.class)).a(bVar.appId, bVar.iOo, new u.b() {
                                        /* class com.tencent.mm.ui.l.a.b.AnonymousClass12.AnonymousClass1 */

                                        @Override // com.tencent.mm.plugin.appbrand.service.u.b
                                        public final void a(bd bdVar, String str) {
                                            AppMethodBeat.i(234343);
                                            Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: wxa pkg download succ, remote version %d", Integer.valueOf(bdVar.field_version));
                                            b.a(b.this, a.EnumC0959a.DownloadSucc);
                                            hdH.G(bdVar, cVar2.get(1));
                                            AppMethodBeat.o(234343);
                                        }
                                    }, new u.a() {
                                        /* class com.tencent.mm.ui.l.a.b.AnonymousClass12.AnonymousClass2 */

                                        @Override // com.tencent.mm.plugin.appbrand.service.u.a
                                        public final void onError(int i2, String str) {
                                            AppMethodBeat.i(234344);
                                            Log.w("MicroMsg.MagicEmojiEnvMgr", "hy: wxa pkg download failed! %d, %s", Integer.valueOf(i2), str);
                                            hdH.ej(a.EnumC0959a.DownloadFailed);
                                            AppMethodBeat.o(234344);
                                        }
                                    });
                                } else {
                                    hdH.ej(a.EnumC0959a.DownloadFailedTooMuch);
                                }
                            } else {
                                hdH.ej(a.EnumC0959a.NoPkg);
                            }
                        } else {
                            b.a(b.this, a.EnumC0959a.Ok);
                        }
                        AppMethodBeat.o(234345);
                        return cVar2;
                    }
                }).f(new com.tencent.mm.vending.c.a<com.tencent.mm.vending.j.c<bd, e>, com.tencent.mm.vending.j.c<bd, e>>() {
                    /* class com.tencent.mm.ui.l.a.b.AnonymousClass11 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.tencent.mm.vending.c.a
                    public final /* synthetic */ com.tencent.mm.vending.j.c<bd, e> call(com.tencent.mm.vending.j.c<bd, e> cVar) {
                        boolean z;
                        AppMethodBeat.i(234342);
                        com.tencent.mm.vending.j.c<bd, e> cVar2 = cVar;
                        e eVar = (e) cVar2.get(1);
                        Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: start prepare page");
                        FrameLayout frameLayout = frameLayout;
                        if (eVar.QlV != null) {
                            z = true;
                        } else {
                            z = false;
                        }
                        Log.i("MicroMsg.MagicEmojiRuntime", "hy: prepare holder with %s, hasPage: %b", frameLayout, Boolean.valueOf(z));
                        if (!BuildInfo.DEBUG || !z) {
                            eVar.QlV = new d(eVar);
                            eVar.QlV.e(frameLayout);
                            AppMethodBeat.o(234342);
                            return cVar2;
                        }
                        RuntimeException runtimeException = new RuntimeException("hy: recreate page is illegal");
                        AppMethodBeat.o(234342);
                        throw runtimeException;
                    }
                }).c(new com.tencent.mm.vending.c.a<e, com.tencent.mm.vending.j.c<bd, e>>() {
                    /* class com.tencent.mm.ui.l.a.b.AnonymousClass10 */

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                    @Override // com.tencent.mm.vending.c.a
                    public final /* synthetic */ e call(com.tencent.mm.vending.j.c<bd, e> cVar) {
                        AppMethodBeat.i(234341);
                        e b2 = b(cVar);
                        AppMethodBeat.o(234341);
                        return b2;
                    }

                    private e b(com.tencent.mm.vending.j.c<bd, e> cVar) {
                        String str;
                        AppMethodBeat.i(234340);
                        Log.i("MicroMsg.MagicEmojiEnvMgr", "loaded record");
                        a aVar = (a) b.this.Qlv.get(bVar.appId);
                        synchronized (b.this) {
                            try {
                                aVar.QlG = (e) cVar.get(1);
                                aVar.QlI = null;
                            } finally {
                                AppMethodBeat.o(234340);
                            }
                        }
                        e eVar = (e) cVar.get(1);
                        bd bdVar = (bd) cVar.get(0);
                        com.tencent.mm.ui.chatting.e.a aVar2 = (com.tencent.mm.ui.chatting.e.a) weakReference.get();
                        Log.i("MicroMsg.MagicEmojiRuntime", "hy: trigger startup: %s, %s, %d, is running: %b", bdVar.field_appId, bdVar.field_pkgPath, Integer.valueOf(bdVar.field_version), Boolean.valueOf(eVar.mIsRunning));
                        if (!eVar.mIsRunning) {
                            eVar.QlX = bdVar;
                            e.a(eVar.QlU, true);
                            g gVar = eVar.QlU;
                            Log.i("MicroMsg.MagicEmojiService", "hy: runtime ready, start inject game.js");
                            gVar.QlN = eVar;
                            q fileSystem = gVar.QlN.getFileSystem();
                            if (fileSystem == null) {
                                Log.e("MicroMsg.MagicEmojiUtils", "hy: can not read without fs");
                                str = "";
                            } else {
                                i<ByteBuffer> iVar = new i<>();
                                if (fileSystem.b("/game.js", iVar) != m.OK) {
                                    Log.e("MicroMsg.MagicEmojiUtils", "hy: no file found");
                                    str = "";
                                } else {
                                    str = new String(com.tencent.mm.plugin.appbrand.ac.d.p(iVar.value), StandardCharsets.UTF_8);
                                }
                            }
                            gVar.b(new Runnable() {
                                /* class com.tencent.mm.ui.l.a.g.AnonymousClass13 */

                                public final void run() {
                                    AppMethodBeat.i(234407);
                                    g.this.cBl.cAE.notifyRuntimeReady(g.this.mAppId, g.this.QlN.gWF());
                                    AppMethodBeat.o(234407);
                                }
                            }, false);
                            long currentTicks = Util.currentTicks();
                            ((com.tencent.mm.plugin.appbrand.m.i) gVar.getJsRuntime().R(com.tencent.mm.plugin.appbrand.m.i.class)).a(null, "/game.js".replace(FilePathGenerator.ANDROID_DIR_SEP, "") + "_" + gVar.mAppId, gVar.QlN.gWF(), 0, str, new ValueCallback<String>(currentTicks) {
                                /* class com.tencent.mm.ui.l.a.g.AnonymousClass14 */
                                final /* synthetic */ long Rca;

                                {
                                    this.Rca = r2;
                                }

                                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                                @Override // android.webkit.ValueCallback
                                public final /* synthetic */ void onReceiveValue(String str) {
                                    AppMethodBeat.i(234408);
                                    Log.i("MicroMsg.MagicEmojiService", "hy: inject game js using %d ms", Long.valueOf(Util.ticksToNow(this.Rca)));
                                    AppMethodBeat.o(234408);
                                }
                            });
                            e.a(eVar.QlV, true);
                            eVar.mIsRunning = true;
                            if (aVar2 != null) {
                                eVar.QlW = new WeakReference<>(aVar2);
                                ((j) aVar2.bh(j.class)).a(eVar.QlY);
                            } else {
                                Log.w("MicroMsg.MagicEmojiRuntime", "hy: chatting released despite started up. should considered pause");
                                eVar.Rd();
                            }
                            synchronized (eVar) {
                                try {
                                    ConcurrentLinkedDeque concurrentLinkedDeque = new ConcurrentLinkedDeque(eVar.Vmb);
                                    while (!concurrentLinkedDeque.isEmpty()) {
                                        Objects.requireNonNull(concurrentLinkedDeque.poll());
                                    }
                                } catch (Throwable th) {
                                    throw th;
                                }
                            }
                        } else if (BuildInfo.DEBUG) {
                            RuntimeException runtimeException = new RuntimeException("Runtime should be only started once!!");
                            AppMethodBeat.o(234340);
                            throw runtimeException;
                        }
                        e eVar2 = (e) cVar.get(1);
                        AppMethodBeat.o(234340);
                        return eVar2;
                    }
                });
                aVar.QlI = cVar;
            }
            AppMethodBeat.o(259031);
        }
        return cVar;
    }

    public static boolean gWz() {
        AppMethodBeat.i(234357);
        if (MMKV.mmkvWithID("__magic_emoji__").decodeBool("force_update", false)) {
            AppMethodBeat.o(234357);
            return true;
        }
        AppMethodBeat.o(234357);
        return false;
    }

    @Override // com.tencent.mm.api.v
    public final void agN() {
        AppMethodBeat.i(259032);
        String str = com.tencent.mm.plugin.emoji.magicemoji.b.a.xiT.appId;
        if (Util.isNullOrNil(str)) {
            Log.w("MicroMsg.MagicEmojiEnvMgr", "hy: appid invalid");
            AppMethodBeat.o(259032);
            return;
        }
        a aVar = this.Qlv.get(str);
        if (aVar == null) {
            Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: item not event loaded");
            AppMethodBeat.o(259032);
        } else if (aVar.QlF == null) {
            Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: service not event loaded");
            AppMethodBeat.o(259032);
        } else {
            aVar.QlF.CB(false);
            AppMethodBeat.o(259032);
        }
    }

    static /* synthetic */ g byJ(String str) {
        AppMethodBeat.i(259033);
        g gVar = new g(str);
        long currentTicks = Util.currentTicks();
        gVar.init();
        Log.i("MicroMsg.MagicEmojiEnvMgr", "hy: me service load using %d ms", Long.valueOf(Util.ticksToNow(currentTicks)));
        AppMethodBeat.o(259033);
        return gVar;
    }

    static /* synthetic */ boolean gWA() {
        AppMethodBeat.i(234361);
        if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_magic_emoji_pkg_download_android, -1) == 1) {
            AppMethodBeat.o(234361);
            return true;
        }
        AppMethodBeat.o(234361);
        return false;
    }

    static /* synthetic */ e a(g gVar) {
        AppMethodBeat.i(259034);
        boolean booleanValue = ((Boolean) n.lrO.aLT()).booleanValue();
        Log.d("MicroMsg.MagicEmojiEnvMgr", "hy: should use test magic emoji runtime: %b", Boolean.valueOf(booleanValue));
        if (booleanValue) {
            f fVar = new f(gVar);
            AppMethodBeat.o(259034);
            return fVar;
        }
        e eVar = new e(gVar);
        AppMethodBeat.o(259034);
        return eVar;
    }
}
