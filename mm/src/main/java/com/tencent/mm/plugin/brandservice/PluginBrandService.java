package com.tencent.mm.plugin.brandservice;

import android.content.Context;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.al.ag;
import com.tencent.mm.app.o;
import com.tencent.mm.g.a.ao;
import com.tencent.mm.g.a.ap;
import com.tencent.mm.kernel.api.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.y;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.brandservice.a;
import com.tencent.mm.plugin.brandservice.a.d;
import com.tencent.mm.plugin.brandservice.a.e;
import com.tencent.mm.plugin.brandservice.b.a;
import com.tencent.mm.plugin.brandservice.b.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.preload.j;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.q;
import com.tencent.mm.plugin.webcanvas.l;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.s;
import java.util.Map;
import kotlin.g.b.p;

public class PluginBrandService extends f implements c, d {
    private o.a appForegroundListener = new o.a() {
        /* class com.tencent.mm.plugin.brandservice.PluginBrandService.AnonymousClass6 */

        @Override // com.tencent.mm.app.o
        public final void onAppForeground(String str) {
            boolean z;
            boolean z2;
            boolean z3 = true;
            AppMethodBeat.i(194849);
            r rVar = r.NPl;
            r.gzV();
            com.tencent.mm.pluginsdk.c cVar = com.tencent.mm.pluginsdk.c.JSr;
            if (com.tencent.mm.pluginsdk.c.glJ()) {
                com.tencent.mm.pluginsdk.c cVar2 = com.tencent.mm.pluginsdk.c.JSr;
                if (!com.tencent.mm.pluginsdk.c.glK()) {
                    z2 = false;
                } else {
                    z2 = com.tencent.mm.pluginsdk.c.aTI().getBoolean("biz_time_preload_at_foreground", false);
                    Log.d("MicroMsg.BizImagePreloadStrategy", "ImageStrategy foregroundPreloadEnable %b", Boolean.valueOf(z2));
                }
                if (z2) {
                    com.tencent.mm.pluginsdk.c.JSr.glN();
                }
            }
            ad adVar = ad.NRn;
            if (!BuildInfo.DEBUG) {
                if (!ad.gBi()) {
                    z3 = false;
                } else if (ad.NRl != null) {
                    Boolean bool = ad.NRl;
                    if (bool == null) {
                        p.hyc();
                    }
                    z3 = bool.booleanValue();
                } else {
                    if (((b) g.af(b.class)).a(b.a.clicfg_open_biz_time_line_fore_ground_resort, 0) == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    ad.NRl = Boolean.valueOf(z);
                    Log.i("MicroMsg.BizTimeLineResortLogic", "isForeGroundBizMsgResortOpen open %b", ad.NRl);
                    Boolean bool2 = ad.NRl;
                    if (bool2 == null) {
                        p.hyc();
                    }
                    z3 = bool2.booleanValue();
                }
            }
            if (z3) {
                ad adVar2 = ad.NRn;
                ad.aka(ab.NQO);
            }
            AppMethodBeat.o(194849);
        }

        @Override // com.tencent.mm.app.o
        public final void onAppBackground(String str) {
            AppMethodBeat.i(194850);
            r rVar = r.NPl;
            r.gzU();
            AppMethodBeat.o(194850);
        }
    };
    private i.a gsV = new i.a() {
        /* class com.tencent.mm.plugin.brandservice.PluginBrandService.AnonymousClass5 */

        @Override // com.tencent.mm.plugin.messenger.foundation.a.a.i.a
        public final void a(i iVar, final i.c cVar) {
            AppMethodBeat.i(194848);
            if (iVar == null || cVar == null) {
                AppMethodBeat.o(194848);
                return;
            }
            b.a("BrandServiceWorkerThread", new Runnable() {
                /* class com.tencent.mm.plugin.brandservice.PluginBrandService.AnonymousClass5.AnonymousClass1 */

                public final void run() {
                    int i2 = 0;
                    AppMethodBeat.i(5541);
                    if (("insert".equals(cVar.zqn) || "update".equals(cVar.zqn)) && cVar.hIs != null) {
                        while (i2 < cVar.hIs.size()) {
                            ca caVar = cVar.hIs.get(i2);
                            if (caVar.field_isSend != 1) {
                                ab.aV(caVar);
                            }
                            i2++;
                        }
                        AppMethodBeat.o(5541);
                        return;
                    }
                    if ("delete".equals(cVar.zqn) && cVar.hIs != null) {
                        while (i2 < cVar.hIs.size()) {
                            ab.aW(cVar.hIs.get(i2));
                            i2++;
                        }
                    }
                    AppMethodBeat.o(5541);
                }
            }, 0);
            AppMethodBeat.o(194848);
        }
    };
    private q pmA = new q() {
        /* class com.tencent.mm.plugin.brandservice.PluginBrandService.AnonymousClass10 */

        @Override // com.tencent.mm.plugin.messenger.foundation.a.q
        public final void onNewXmlReceived(String str, final Map<String, String> map, h.a aVar) {
            AppMethodBeat.i(194853);
            b.a("BrandServiceWorkerThread", new Runnable() {
                /* class com.tencent.mm.plugin.brandservice.PluginBrandService.AnonymousClass10.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(194852);
                    a.pmT.ab(map);
                    AppMethodBeat.o(194852);
                }
            }, 0);
            AppMethodBeat.o(194853);
        }
    };
    private q pmB = new q() {
        /* class com.tencent.mm.plugin.brandservice.PluginBrandService.AnonymousClass2 */

        @Override // com.tencent.mm.plugin.messenger.foundation.a.q
        public final void onNewXmlReceived(String str, final Map<String, String> map, final h.a aVar) {
            AppMethodBeat.i(194845);
            b.a("BrandServiceWorkerThread", new Runnable() {
                /* class com.tencent.mm.plugin.brandservice.PluginBrandService.AnonymousClass2.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(194844);
                    com.tencent.mm.plugin.biz.b.b bVar = com.tencent.mm.plugin.biz.b.b.pfn;
                    Map map = map;
                    h.a aVar = aVar;
                    if ((aVar != null ? aVar.heO : null) == null || aVar.heO.KHn == null || map == null) {
                        Log.w("MicroMsg.BizPayAlbumLogic", "onBizPayAlbumNotify data invalid");
                        AppMethodBeat.o(194844);
                        return;
                    }
                    com.tencent.mm.plugin.biz.b.b.g(map, z.a(aVar.heO.KHn));
                    AppMethodBeat.o(194844);
                }
            }, 0);
            AppMethodBeat.o(194845);
        }
    };
    private aa.c pmx = new aa.c() {
        /* class com.tencent.mm.plugin.brandservice.PluginBrandService.AnonymousClass7 */

        @Override // com.tencent.mm.storage.aa.c
        public final void a(Object obj, aa.a aVar) {
            AppMethodBeat.i(194851);
            b.a("UpdateBizMainCellThread", new Runnable() {
                /* class com.tencent.mm.plugin.brandservice.PluginBrandService.AnonymousClass7.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(5543);
                    ab.gBa();
                    AppMethodBeat.o(5543);
                }
            }, 0);
            AppMethodBeat.o(194851);
        }
    };
    private q pmy = new q() {
        /* class com.tencent.mm.plugin.brandservice.PluginBrandService.AnonymousClass8 */

        @Override // com.tencent.mm.plugin.messenger.foundation.a.q
        public final void onNewXmlReceived(String str, final Map<String, String> map, final h.a aVar) {
            AppMethodBeat.i(5546);
            b.a("BrandServiceWorkerThread", new Runnable() {
                /* class com.tencent.mm.plugin.brandservice.PluginBrandService.AnonymousClass8.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(5545);
                    ab.c(map, aVar);
                    AppMethodBeat.o(5545);
                }
            }, 0);
            AppMethodBeat.o(5546);
        }
    };
    private q pmz = new q() {
        /* class com.tencent.mm.plugin.brandservice.PluginBrandService.AnonymousClass9 */

        @Override // com.tencent.mm.plugin.messenger.foundation.a.q
        public final void onNewXmlReceived(String str, final Map<String, String> map, final h.a aVar) {
            AppMethodBeat.i(5548);
            b.a("BrandServiceWorkerThread", new Runnable() {
                /* class com.tencent.mm.plugin.brandservice.PluginBrandService.AnonymousClass9.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(5547);
                    if (!(aVar == null || aVar.heO == null || aVar.heO.KHn == null)) {
                        Map map = map;
                        String a2 = z.a(aVar.heO.KHn);
                        p.h(map, "values");
                        p.h(a2, "content");
                        if (af.gBp()) {
                            ege bV = af.bV(map);
                            if (bV == null) {
                                AppMethodBeat.o(5547);
                                return;
                            } else if (!af.b(bV, (com.tencent.mm.storage.z) null)) {
                                Log.i("MicroMsg.BizTimeLineStorageLogicExKt", "[TRACE_BIZRECCARD] onBizRecommendExpt illegal");
                                AppMethodBeat.o(5547);
                                return;
                            } else {
                                switch (bV.MOD) {
                                    case 0:
                                        MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("brandService");
                                        StringBuilder sb = new StringBuilder("BizLatestRecommendCardInfo");
                                        p.g(g.aAf(), "MMKernel.account()");
                                        singleMMKV.encode(sb.append(com.tencent.mm.kernel.a.ayV()).toString(), a2);
                                        r.NPl.b(bV);
                                        break;
                                    case 1:
                                        af.f(bV);
                                        break;
                                    case 2:
                                        ac acVar = ac.NRc;
                                        ac.bjb(a2);
                                        r.NPl.b(bV);
                                        ac acVar2 = ac.NRc;
                                        ac.Nd(2);
                                        break;
                                }
                                l lVar = l.IAx;
                                l.LV(81);
                                long j2 = Util.getLong((String) map.get(".sysmsg.BizRecommendExpt.RecID"), 0);
                                s sVar = s.NPC;
                                s.a(Util.getInt((String) map.get(".sysmsg.BizRecommendExpt.Pos"), -1), Util.getInt((String) map.get(".sysmsg.BizRecommendExpt.Weight"), -1), Util.getInt((String) map.get(".sysmsg.BizRecommendExpt.UseServerTime"), 0), 5, 1001, j2, (String) map.get(".sysmsg.BizRecommendExpt.CardID"), (String) map.get(".sysmsg.BizRecommendExpt.ExpType"), (String) map.get(".sysmsg.BizRecommendExpt.ExtraData"));
                            }
                        }
                    }
                    AppMethodBeat.o(5547);
                }
            }, 0);
            AppMethodBeat.o(5548);
        }
    };

    public PluginBrandService() {
        AppMethodBeat.i(5549);
        AppMethodBeat.o(5549);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void installed() {
        AppMethodBeat.i(5550);
        alias(d.class);
        AppMethodBeat.o(5550);
    }

    @Override // com.tencent.mm.kernel.b.f
    public void configure(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(5551);
        Log.i("MicroMsg.PluginBrandService", "configure");
        addBrandServiceEvent();
        addPlaceTopChangeListener();
        if (gVar.aBb()) {
            registerVFS();
            pin(new y(d.class));
            ((com.tencent.mm.plugin.messenger.foundation.a.s) g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).setBizTimeLineCallback(new com.tencent.mm.plugin.messenger.foundation.a.b() {
                /* class com.tencent.mm.plugin.brandservice.PluginBrandService.AnonymousClass1 */

                {
                    AppMethodBeat.i(160479);
                    AppMethodBeat.o(160479);
                }

                @Override // com.tencent.mm.plugin.messenger.foundation.a.b
                public final boolean aB(int i2, String str) {
                    AppMethodBeat.i(194843);
                    Log.i("MicroMsg.PluginBrandService", "testInsertBizAd %d, %s", Integer.valueOf(i2), str);
                    if (i2 == 1) {
                        r.NPl.ajP(2);
                    } else if (i2 == 2) {
                        MultiProcessMMKV singleMMKV = MultiProcessMMKV.getSingleMMKV("brandService");
                        singleMMKV.encode("BizTimeLineAdTestMode", Util.getInt(str, 0));
                        singleMMKV.apply();
                    }
                    AppMethodBeat.o(194843);
                    return true;
                }
            });
        }
        AppMethodBeat.o(5551);
    }

    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(com.tencent.mm.kernel.b.g gVar) {
        AppMethodBeat.i(5552);
        com.tencent.mm.br.b.bfQ("brandservice");
        Log.i("MicroMsg.PluginBrandService", "PluginBrandService execute, process name: " + gVar.mProcessName);
        if (gVar.aBb() || gVar.FY(":tools") || gVar.FY(":toolsmp") || gVar.FZ(":appbrand")) {
            g.b(com.tencent.mm.plugin.brandservice.a.b.class, new c());
            g.b(e.class, new e());
        }
        j.LW();
        a.C0860a aVar = a.pma;
        com.tencent.mm.pluginsdk.cmd.b.a(new a(), a.plZ);
        AppMethodBeat.o(5552);
    }

    private void registerVFS() {
        AppMethodBeat.i(194854);
        Log.i("MicroMsg.PluginBrandService", "register VFSStrategy webCache");
        com.tencent.mm.vfs.y.b("WebPrefetchContent", "webprefetch/content", Util.MILLSECONDS_OF_DAY, 68);
        com.tencent.mm.vfs.y.b("WebPrefetchManifest", "webprefetch/manifest", 604800000, 68);
        com.tencent.mm.vfs.y.b("WebPrefetchResource", "webprefetch/resource", 604800000, 68);
        AppMethodBeat.o(194854);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountInitialized(e.c cVar) {
        AppMethodBeat.i(5553);
        ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().a(this.gsV, Looper.getMainLooper());
        ag.ban().a(this.pmx, Looper.getMainLooper());
        ag.bap().a(this.pmx, Looper.getMainLooper());
        this.appForegroundListener.alive();
        if (ab.clc()) {
            new com.tencent.mm.plugin.brandservice.ui.timeline.c();
            Log.i("MicroMsg.BizTimeLineMigrateImp", "migrateMainCell");
            int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_BIZ_TIME_LINE_MIGRATE_DATA_INT_SYNC, (Object) 0)).intValue();
            if ((intValue & 1) == 0) {
                ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().bka("officialaccounts");
                ag.ban().gAQ();
                g.aAh().azQ().set(ar.a.USERINFO_BIZ_TIME_LINE_MIGRATE_DATA_INT_SYNC, Integer.valueOf(intValue | 1));
            }
        }
        ((com.tencent.mm.plugin.messenger.foundation.a.s) g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("BizRecommendNotify", this.pmy);
        ((com.tencent.mm.plugin.messenger.foundation.a.s) g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("MMBizPaySubscribePayNotify", this.pmA);
        ((com.tencent.mm.plugin.messenger.foundation.a.s) g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("BizNotification", this.pmB);
        ((com.tencent.mm.plugin.messenger.foundation.a.s) g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("BizRecommendExpt", this.pmz);
        AppMethodBeat.o(5553);
    }

    @Override // com.tencent.mm.kernel.api.c
    public void onAccountRelease() {
        AppMethodBeat.i(5554);
        ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().a(this.gsV);
        ag.ban().a(this.pmx);
        ag.bap().a(this.pmx);
        this.appForegroundListener.dead();
        ((com.tencent.mm.plugin.messenger.foundation.a.s) g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("BizRecommendNotify", this.pmy);
        ((com.tencent.mm.plugin.messenger.foundation.a.s) g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("MMBizPaySubscribePayNotify", this.pmA);
        ((com.tencent.mm.plugin.messenger.foundation.a.s) g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("BizNotification", this.pmB);
        ((com.tencent.mm.plugin.messenger.foundation.a.s) g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("BizRecommendExpt", this.pmz);
        AppMethodBeat.o(5554);
    }

    private void addBrandServiceEvent() {
        AppMethodBeat.i(5555);
        EventCenter.instance.addListener(new IListener<ap>() {
            /* class com.tencent.mm.plugin.brandservice.PluginBrandService.AnonymousClass3 */

            {
                AppMethodBeat.i(160480);
                this.__eventId = ap.class.getName().hashCode();
                AppMethodBeat.o(160480);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(ap apVar) {
                AppMethodBeat.i(5537);
                ap apVar2 = apVar;
                if (apVar2 == null || !(apVar2 instanceof ap)) {
                    AppMethodBeat.o(5537);
                    return false;
                }
                ap apVar3 = apVar2;
                switch (apVar3.dDt.action) {
                    case 1:
                        Context context = apVar3.dDt.context;
                        String str = apVar3.dDt.dDv;
                        String str2 = apVar3.dDt.title;
                        int i2 = apVar3.dDt.fromScene;
                        long j2 = apVar3.dDt.dDw;
                        int i3 = apVar3.dDt.offset;
                        boolean z = apVar3.dDt.dDx;
                        if (context == null || Util.isNullOrNil(str)) {
                            Log.e("MicroMsg.BrandService.BrandServiceLogic", "context(%s) or keyword(%s) is null or nil.", context, str);
                            AppMethodBeat.o(5537);
                            return false;
                        }
                        g.azz().a(1071, new e.a(context, str, j2, i3, i2, str2, z, apVar3));
                        g.azz().a(new com.tencent.mm.plugin.brandservice.b.l(str, j2, i3, i2, ""), 0);
                        AppMethodBeat.o(5537);
                        return true;
                    default:
                        Log.d("MicroMsg.BrandService.BrandServiceLogic", "Do not support the action(%d).", Integer.valueOf(apVar3.dDt.action));
                        AppMethodBeat.o(5537);
                        return false;
                }
            }
        });
        AppMethodBeat.o(5555);
    }

    private void addPlaceTopChangeListener() {
        AppMethodBeat.i(5556);
        EventCenter.instance.add(new IListener<ao>() {
            /* class com.tencent.mm.plugin.brandservice.PluginBrandService.AnonymousClass4 */

            {
                AppMethodBeat.i(194846);
                this.__eventId = ao.class.getName().hashCode();
                AppMethodBeat.o(194846);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(ao aoVar) {
                AppMethodBeat.i(194847);
                ag.ban().biW(aoVar.dDs.userName);
                AppMethodBeat.o(194847);
                return true;
            }
        });
        AppMethodBeat.o(5556);
    }
}
