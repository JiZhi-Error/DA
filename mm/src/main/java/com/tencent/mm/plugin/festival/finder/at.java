package com.tencent.mm.plugin.festival.finder;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.hilive.mediasdk.SdkInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.f;
import com.tencent.mm.g.a.hx;
import com.tencent.mm.g.a.mu;
import com.tencent.mm.g.a.zj;
import com.tencent.mm.live.c.b;
import com.tencent.mm.live.core.core.a.b;
import com.tencent.mm.live.core.core.c.a;
import com.tencent.mm.live.core.core.d.b;
import com.tencent.mm.live.core.core.d.c;
import com.tencent.mm.live.core.mini.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import com.tencent.mm.plugin.festival.model.r;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorWithoutAffinityUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveVisitorWithoutAffinityUI;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI13;
import com.tencent.mm.plugin.finder.live.model.cgi.h;
import com.tencent.mm.plugin.finder.live.model.cgi.i;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.model.q;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.plugin.finder.live.model.w;
import com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout;
import com.tencent.mm.plugin.finder.live.view.FinderLiveMiniView;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.report.live.m;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.plugin.finder.utils.ae;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.ass;
import com.tencent.mm.protocal.protobuf.auf;
import com.tencent.mm.protocal.protobuf.aus;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.avk;
import com.tencent.mm.protocal.protobuf.avs;
import com.tencent.mm.protocal.protobuf.awc;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.awq;
import com.tencent.mm.protocal.protobuf.axl;
import com.tencent.mm.protocal.protobuf.ciq;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.trtc.TRTCCloudDef;
import java.util.LinkedList;
import kotlin.g.b.p;
import org.json.JSONObject;

public final class at implements com.tencent.mm.live.core.core.c {
    private static final a Uuu = new a();
    public static final at Uuv = new at();
    static boolean dMz;
    static final Runnable hId = g.Uux;
    static final Runnable hIe = d.Uuw;
    static View.OnClickListener hJe = h.Uuy;
    static com.tencent.mm.live.core.core.trtc.a hSS;
    static final com.tencent.mm.model.d hWh = com.tencent.mm.model.d.aTu();
    static final IListener<?> hXn = new j();
    static int ujA;
    private static int ujB = 1000;
    private static long ujC;
    static final IListener<zj> ujG = new l();
    static final View.OnClickListener ujI = i.Uuz;
    static w ujK;
    static w ujL;
    static FinderBaseLivePluginLayout ujs;
    static FinderLiveMiniView ujt;
    static String uju = "";
    static s ujx;
    private static com.tencent.mm.plugin.finder.live.viewmodel.d ujy;
    static com.tencent.mm.plugin.finder.live.viewmodel.g ujz;

    static {
        AppMethodBeat.i(262565);
        Uuu.alive();
        AppMethodBeat.o(262565);
    }

    private at() {
    }

    public static final /* synthetic */ boolean a(at atVar, int i2, int i3, ass ass) {
        AppMethodBeat.i(262566);
        boolean a2 = a(i2, i3, ass);
        AppMethodBeat.o(262566);
        return a2;
    }

    public static s getFinderLiveAssistant() {
        return ujx;
    }

    public static com.tencent.mm.plugin.finder.live.viewmodel.d dfY() {
        return ujy;
    }

    public static void b(com.tencent.mm.plugin.finder.live.viewmodel.d dVar) {
        AppMethodBeat.i(262552);
        Log.i("Finder.FestivalFinderLiveService", "FinderLiveDataModel set ".concat(String.valueOf(dVar)));
        ujy = dVar;
        AppMethodBeat.o(262552);
    }

    public static com.tencent.mm.plugin.finder.live.viewmodel.g dfZ() {
        return ujz;
    }

    public static void f(com.tencent.mm.plugin.finder.live.viewmodel.g gVar) {
        AppMethodBeat.i(262553);
        Log.i("Finder.FestivalFinderLiveService", "write curLiveRoomData to :".concat(String.valueOf(gVar)));
        ujz = gVar;
        AppMethodBeat.o(262553);
    }

    public static int dga() {
        return ujA;
    }

    public static final class l extends IListener<zj> {
        l() {
        }

        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(zj zjVar) {
            AppMethodBeat.i(262551);
            zj zjVar2 = zjVar;
            p.h(zjVar2, "event");
            if (com.tencent.mm.kernel.g.aAc()) {
                at atVar = at.Uuv;
                if (at.dfZ() != null) {
                    if (zjVar2.efx.dKy == 3) {
                        at atVar2 = at.Uuv;
                        if (!at.dMz) {
                            at.a(at.Uuv);
                        }
                    }
                    AppMethodBeat.o(262551);
                    return true;
                }
            }
            AppMethodBeat.o(262551);
            return false;
        }
    }

    public static final class j extends IListener<mu> {
        j() {
        }

        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(mu muVar) {
            AppMethodBeat.i(262549);
            mu muVar2 = muVar;
            p.h(muVar2, "event");
            if (com.tencent.mm.kernel.g.aAc()) {
                at atVar = at.Uuv;
                if (at.dfZ() != null) {
                    if (muVar2.dSs.action == 3) {
                        at atVar2 = at.Uuv;
                        if (!at.dMz) {
                            at.a(at.Uuv);
                        }
                    }
                    AppMethodBeat.o(262549);
                    return false;
                }
            }
            AppMethodBeat.o(262549);
            return false;
        }
    }

    public static final class a extends IListener<hx> {
        a() {
        }

        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(hx hxVar) {
            hx.a aVar;
            hx.a aVar2;
            hx.a aVar3;
            hx.a aVar4;
            AppMethodBeat.i(262536);
            hx hxVar2 = hxVar;
            if (!(hxVar2 == null || (aVar4 = hxVar2.dMy) == null)) {
                aVar4.isStart = false;
            }
            if (!(hxVar2 == null || (aVar3 = hxVar2.dMy) == null)) {
                aVar3.dMz = false;
            }
            at atVar = at.Uuv;
            com.tencent.mm.plugin.finder.live.viewmodel.g dfZ = at.dfZ();
            if (!(dfZ == null || dfZ.liveInfo.liveId == 0 || dfZ.djl())) {
                if (!(hxVar2 == null || (aVar2 = hxVar2.dMy) == null)) {
                    at atVar2 = at.Uuv;
                    aVar2.dMz = at.dMz;
                }
                if (!(hxVar2 == null || (aVar = hxVar2.dMy) == null)) {
                    aVar.isStart = true;
                }
            }
            AppMethodBeat.o(262536);
            return true;
        }
    }

    static final class h implements View.OnClickListener {
        public static final h Uuy = new h();

        static {
            AppMethodBeat.i(262546);
            AppMethodBeat.o(262546);
        }

        h() {
        }

        public final void onClick(View view) {
            Class cls;
            boolean z;
            AppMethodBeat.i(262545);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/festival/finder/FestivalFinderLiveService$miniWindowClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            StringBuilder sb = new StringBuilder("miniWindowClickListener onClick ");
            at atVar = at.Uuv;
            Log.i("Finder.FestivalFinderLiveService", sb.append(at.dfY()).toString());
            at atVar2 = at.Uuv;
            com.tencent.mm.live.core.core.trtc.a aVar = at.hSS;
            if (aVar != null) {
                aVar.aBU();
            }
            at atVar3 = at.Uuv;
            if (at.dMz) {
                at atVar4 = at.Uuv;
                if (at.hSS instanceof com.tencent.mm.live.core.core.a.b) {
                    cls = FinderLiveAnchorWithoutAffinityUI.class;
                } else {
                    cls = OccupyFinderUI13.class;
                }
            } else {
                cls = FinderLiveVisitorWithoutAffinityUI.class;
            }
            Intent intent = new Intent(MMApplicationContext.getContext(), cls);
            intent.putExtra("route_to_maximize", true);
            intent.addFlags(872415232);
            Context context = MMApplicationContext.getContext();
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/festival/finder/FestivalFinderLiveService$miniWindowClickListener$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/festival/finder/FestivalFinderLiveService$miniWindowClickListener$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            a.C0388a aVar2 = com.tencent.mm.live.core.mini.a.hCD;
            a.b bVar2 = a.b.hCF;
            a.b.aEi().bQc();
            at atVar5 = at.Uuv;
            FinderLiveMiniView finderLiveMiniView = at.ujt;
            if (finderLiveMiniView != null) {
                z = finderLiveMiniView.dMz;
            } else {
                z = false;
            }
            if (z) {
                com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                com.tencent.mm.plugin.finder.report.live.k.dpl().vmk = false;
                com.tencent.mm.plugin.finder.report.live.k kVar2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                com.tencent.mm.plugin.finder.report.live.k.dpl().vml = true;
                com.tencent.mm.plugin.finder.report.live.k kVar3 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                com.tencent.mm.plugin.finder.report.live.k.a(s.c.LIVE_ANCHOR_ACTION_MINIMIZE, String.valueOf(s.r.LIVE_FLOAT_ACTION_MAXIMIZE.type));
            } else {
                m.vli.a(false, s.r.LIVE_FLOAT_ACTION_MAXIMIZE);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/festival/finder/FestivalFinderLiveService$miniWindowClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(262545);
        }
    }

    static final class i implements View.OnClickListener {
        public static final i Uuz = new i();

        static {
            AppMethodBeat.i(262548);
            AppMethodBeat.o(262548);
        }

        i() {
        }

        public final void onClick(View view) {
            boolean z;
            AppMethodBeat.i(262547);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/festival/finder/FestivalFinderLiveService$miniWindowCloseClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            boolean isTopApplication = Util.isTopApplication(MMApplicationContext.getContext());
            StringBuilder append = new StringBuilder("mini window close,is top applicaton:").append(isTopApplication).append(",is shopping in MiniPro:");
            at atVar = at.Uuv;
            com.tencent.mm.plugin.finder.live.viewmodel.g dfZ = at.dfZ();
            StringBuilder append2 = append.append(dfZ != null ? Boolean.valueOf(dfZ.uEr) : null).append(",isAnchor:");
            at atVar2 = at.Uuv;
            Log.i("Finder.FestivalFinderLiveService", append2.append(at.dMz).toString());
            at atVar3 = at.Uuv;
            if (!at.dMz) {
                at atVar4 = at.Uuv;
                com.tencent.mm.plugin.finder.live.viewmodel.g dfZ2 = at.dfZ();
                if (dfZ2 != null && dfZ2.uEr) {
                    at atVar5 = at.Uuv;
                    com.tencent.mm.live.core.core.trtc.a aVar = at.hSS;
                    if (aVar != null) {
                        aVar.hAq.aEj();
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/festival/finder/FestivalFinderLiveService$miniWindowCloseClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(262547);
                    return;
                }
            }
            at.Uuv.nn(isTopApplication);
            at atVar6 = at.Uuv;
            FinderLiveMiniView finderLiveMiniView = at.ujt;
            if (finderLiveMiniView != null) {
                z = finderLiveMiniView.dMz;
            } else {
                z = false;
            }
            if (!z) {
                m.vli.a(s.at.CloseTypeFloat);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/festival/finder/FestivalFinderLiveService$miniWindowCloseClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(262547);
        }
    }

    static final class d implements Runnable {
        public static final d Uuw = new d();

        static {
            AppMethodBeat.i(262540);
            AppMethodBeat.o(262540);
        }

        d() {
        }

        public final void run() {
            AppMethodBeat.i(262539);
            at atVar = at.Uuv;
            at.geJ();
            AppMethodBeat.o(262539);
        }
    }

    static final class g implements Runnable {
        public static final g Uux = new g();

        static {
            AppMethodBeat.i(262544);
            AppMethodBeat.o(262544);
        }

        g() {
        }

        public final void run() {
            AppMethodBeat.i(262543);
            at atVar = at.Uuv;
            at.ggb();
            AppMethodBeat.o(262543);
        }
    }

    public static final class b implements h.a {
        b() {
        }

        @Override // com.tencent.mm.plugin.finder.live.model.cgi.h.a
        public final void a(int i2, int i3, ass ass, int i4) {
            awe awe;
            awe awe2;
            long j2 = 0;
            AppMethodBeat.i(262537);
            p.h(ass, "resp");
            boolean a2 = at.a(at.Uuv, i3, i2, ass);
            at atVar = at.Uuv;
            w wVar = at.ujK;
            if (wVar != null) {
                wVar.dgD();
            }
            if (a2) {
                com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
                int intValue = com.tencent.mm.plugin.finder.storage.c.drI().value().intValue();
                at atVar2 = at.Uuv;
                long j3 = (long) intValue;
                awe awe3 = ass.liveInfo;
                at.P(j3, awe3 != null ? awe3.liveId : 0);
                AppMethodBeat.o(262537);
                return;
            }
            StringBuilder sb = new StringBuilder("handleLiveMsgResp result false, will retry heartbeat delay 5000. localLiveId:");
            at atVar3 = at.Uuv;
            com.tencent.mm.plugin.finder.live.viewmodel.g dfZ = at.dfZ();
            Log.i("Finder.FestivalFinderLiveService", sb.append((dfZ == null || (awe2 = dfZ.liveInfo) == null) ? null : Long.valueOf(awe2.liveId)).toString());
            at atVar4 = at.Uuv;
            at atVar5 = at.Uuv;
            com.tencent.mm.plugin.finder.live.viewmodel.g dfZ2 = at.dfZ();
            if (!(dfZ2 == null || (awe = dfZ2.liveInfo) == null)) {
                j2 = awe.liveId;
            }
            at.P(5000, j2);
            AppMethodBeat.o(262537);
        }
    }

    public static final class c implements i.a {
        c() {
        }

        @Override // com.tencent.mm.plugin.finder.live.model.cgi.i.a
        public final void a(int i2, int i3, String str, auf auf) {
            long j2;
            cjb cjb;
            AppMethodBeat.i(262538);
            p.h(auf, "resp");
            at atVar = at.Uuv;
            boolean c2 = at.c(i3, i2, auf);
            at atVar2 = at.Uuv;
            w wVar = at.ujL;
            if (wVar != null) {
                wVar.dgD();
            }
            if (c2) {
                at atVar3 = at.Uuv;
                com.tencent.mm.plugin.finder.live.viewmodel.g dfZ = at.dfZ();
                if (dfZ == null || (cjb = dfZ.hIv) == null) {
                    j2 = 0;
                } else {
                    j2 = cjb.Mor;
                }
                long aM = kotlin.k.j.aM((j2 - 60) * 1000, Util.MILLSECONDS_OF_MINUTE);
                at atVar4 = at.Uuv;
                at.EJ(aM);
            }
            AppMethodBeat.o(262538);
        }
    }

    private static boolean a(int i2, int i3, ass ass) {
        awe awe;
        Long l2;
        boolean z;
        Long l3;
        Integer num;
        Integer num2;
        avs avs;
        com.tencent.mm.bw.b bVar;
        long j2;
        boolean z2;
        awe awe2;
        awe awe3;
        awe awe4;
        awe awe5;
        AppMethodBeat.i(262554);
        com.tencent.mm.plugin.finder.utils.c cVar = com.tencent.mm.plugin.finder.utils.c.vVc;
        awe awe6 = ass.liveInfo;
        f.a.a(cVar, "liveHeartBeatSvrErr", (awe6 != null ? awe6.liveId : 0) != 0, false, new e(i2, i3), 12);
        com.tencent.mm.plugin.finder.utils.c cVar2 = com.tencent.mm.plugin.finder.utils.c.vVc;
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar = ujz;
        f.a.a(cVar2, "liveHeartBeatLocalErr", ((gVar == null || (awe5 = gVar.liveInfo) == null) ? 0 : awe5.liveId) != 0, false, new f(i2, i3, ass), 12);
        StringBuilder append = new StringBuilder("handleLiveMsgResp errCode:").append(i2).append(" curData:");
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar2 = ujz;
        StringBuilder append2 = append.append((gVar2 == null || (awe4 = gVar2.liveInfo) == null) ? null : Long.valueOf(awe4.liveId)).append(", resp.liveId:");
        awe awe7 = ass.liveInfo;
        Log.i("Finder.FestivalFinderLiveService", append2.append(awe7 != null ? Long.valueOf(awe7.liveId) : null).toString());
        if (ass != null) {
            awe awe8 = ass.liveInfo;
            if (awe8 != null) {
                l2 = Long.valueOf(awe8.liveId);
            } else {
                l2 = null;
            }
            com.tencent.mm.plugin.finder.live.viewmodel.g gVar3 = ujz;
            if (!(!p.j(l2, (gVar3 == null || (awe3 = gVar3.liveInfo) == null) ? null : Long.valueOf(awe3.liveId)))) {
                awe awe9 = ass.liveInfo;
                if (e(awe9 != null ? Long.valueOf(awe9.liveId) : null)) {
                    StringBuilder sb = new StringBuilder("handleLiveMsgResp invalid live id, curData:");
                    com.tencent.mm.plugin.finder.live.viewmodel.g gVar4 = ujz;
                    StringBuilder append3 = sb.append((gVar4 == null || (awe2 = gVar4.liveInfo) == null) ? null : Long.valueOf(awe2.liveId)).append(", resp.liveId:");
                    awe awe10 = ass.liveInfo;
                    Log.i("Finder.FestivalFinderLiveService", append3.append(awe10 != null ? Long.valueOf(awe10.liveId) : null).toString());
                    AppMethodBeat.o(262554);
                    return false;
                }
                com.tencent.mm.plugin.finder.live.viewmodel.g gVar5 = ujz;
                if (gVar5 == null || !gVar5.djl()) {
                    if (i3 == 4 && i2 == -100020) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z) {
                        EJ(0);
                    } else if (i3 != 0 || i2 != 0) {
                        Log.e("Finder.FestivalFinderLiveService", "onGYNetEnd error");
                        switch (i2) {
                            case -200001:
                                q qVar = q.ukd;
                                q.dgB();
                                break;
                        }
                    } else {
                        com.tencent.mm.plugin.finder.live.viewmodel.g gVar6 = ujz;
                        if (gVar6 != null) {
                            awe awe11 = ass.liveInfo;
                            if (awe11 != null) {
                                gVar6.UPS = ass.ViF - gVar6.UPT;
                                gVar6.UPT = kotlin.k.j.aM(gVar6.UPT, ass.ViF);
                                gVar6.liveInfo.LDN = awe11.LDN;
                                gVar6.liveInfo.uBn = ass.LDA;
                                gVar6.liveInfo.LGS = awe11.LGS;
                                gVar6.uDV = ass.LDH;
                                awe awe12 = ass.liveInfo;
                                if (awe12 != null) {
                                    int i4 = awe12.LGU;
                                    if (!gVar6.uEd) {
                                        if ((i4 & 1) > 0 || (i4 & 2) > 0) {
                                            z2 = true;
                                        } else {
                                            z2 = false;
                                        }
                                        gVar6.uEd = z2;
                                    }
                                }
                            }
                            LinkedList<awq> linkedList = ass.FoQ;
                            if (linkedList == null) {
                                linkedList = new LinkedList<>();
                            }
                            LinkedList<aut> linkedList2 = ass.LDI;
                            if (linkedList2 == null) {
                                linkedList2 = new LinkedList<>();
                            }
                            String aTY = z.aTY();
                            String aUg = z.aUg();
                            com.tencent.mm.plugin.finder.live.viewmodel.g gVar7 = ujz;
                            if (gVar7 != null) {
                                com.tencent.mm.plugin.finder.live.model.i iVar = com.tencent.mm.plugin.finder.live.model.i.uja;
                                com.tencent.mm.plugin.finder.live.model.i.c(gVar7, linkedList);
                                com.tencent.mm.plugin.finder.live.model.i iVar2 = com.tencent.mm.plugin.finder.live.model.i.uja;
                                com.tencent.mm.plugin.finder.live.model.i.a(gVar7, linkedList, linkedList2);
                                com.tencent.mm.plugin.finder.live.model.i iVar3 = com.tencent.mm.plugin.finder.live.model.i.uja;
                                com.tencent.mm.plugin.finder.live.model.i.a(gVar7, linkedList, linkedList2, ujB, aTY, aUg);
                                com.tencent.mm.plugin.finder.live.model.i iVar4 = com.tencent.mm.plugin.finder.live.model.i.uja;
                                com.tencent.mm.plugin.finder.live.model.i.e(gVar7, linkedList);
                                com.tencent.mm.plugin.finder.live.model.i iVar5 = com.tencent.mm.plugin.finder.live.model.i.uja;
                                com.tencent.mm.plugin.finder.live.model.i.f(gVar7, linkedList2);
                                com.tencent.mm.plugin.finder.live.model.i iVar6 = com.tencent.mm.plugin.finder.live.model.i.uja;
                                com.tencent.mm.plugin.finder.live.model.i.g(gVar7, linkedList2);
                                Log.i("Finder.FestivalFinderLiveService", "handleMsg bulletCommetList.size:" + gVar7.uDt.size() + ", msgList.size:" + gVar7.uDs.size() + ", topMsgList.size:" + gVar7.uDu.size());
                            }
                            LinkedList<aut> linkedList3 = ass.LDI;
                            com.tencent.mm.plugin.finder.live.viewmodel.g gVar8 = ujz;
                            if (gVar8 != null) {
                                com.tencent.mm.plugin.finder.live.model.a aVar = com.tencent.mm.plugin.finder.live.model.a.uhJ;
                                com.tencent.mm.plugin.finder.live.model.a.a(gVar8, linkedList3);
                                com.tencent.mm.plugin.finder.live.model.i iVar7 = com.tencent.mm.plugin.finder.live.model.i.uja;
                                if (linkedList3 == null) {
                                    linkedList3 = new LinkedList<>();
                                }
                                com.tencent.mm.plugin.finder.live.model.i.i(gVar8, linkedList3);
                                Log.i("Finder.FestivalFinderLiveService", "handleAppMsg giftMsgList.size:" + gVar8.uDw.size());
                            }
                            LinkedList<axl> linkedList4 = ass.LDJ;
                            com.tencent.mm.plugin.finder.live.viewmodel.g gVar9 = ujz;
                            if (gVar9 != null) {
                                com.tencent.mm.plugin.finder.live.model.a aVar2 = com.tencent.mm.plugin.finder.live.model.a.uhJ;
                                com.tencent.mm.plugin.finder.live.model.a.b(gVar9, linkedList4);
                            }
                            com.tencent.mm.bw.b bVar2 = ass.LDx;
                            if (bVar2 != null) {
                                p.g(bVar2, "cookies");
                                gVar6.hIt = bVar2.zy;
                            }
                            awe awe13 = ass.liveInfo;
                            if (!(awe13 == null || (avs = awe13.LGR) == null || (bVar = avs.LGq) == null)) {
                                ciq ciq = new ciq();
                                p.g(bVar, LocaleUtil.ITALIAN);
                                try {
                                    ciq.parseFrom(bVar.zy);
                                } catch (Exception e2) {
                                    Log.printDebugStack("safeParser", "", e2);
                                    ciq = null;
                                }
                                ciq ciq2 = ciq;
                                if (ciq2 != null) {
                                    j2 = ciq2.MnE;
                                } else {
                                    j2 = 0;
                                }
                                gVar6.RL(j2);
                            }
                            LinkedList<awq> linkedList5 = ass.FoQ;
                            p.g(linkedList5, "it.msgList");
                            gVar6.aq(linkedList5);
                            com.tencent.mm.live.b.m mVar = com.tencent.mm.live.b.m.hGg;
                            com.tencent.mm.live.b.m.aFe();
                            boolean z3 = ass.LDC == 1;
                            if (z3) {
                                Log.i("Finder.FestivalFinderLiveService", "get live msg close live!");
                                gVar6.nB(true);
                                com.tencent.mm.live.core.core.trtc.a aVar3 = hSS;
                                if (aVar3 != null) {
                                    aVar3.a(com.tencent.mm.live.core.mini.d.STATE_FINISH);
                                }
                                com.tencent.mm.live.b.s sVar = com.tencent.mm.live.b.s.hIl;
                                com.tencent.mm.live.b.j aGe = com.tencent.mm.live.b.s.aGe();
                                if (aGe != null) {
                                    aGe.onCloseLive(new com.tencent.mm.live.b.e(gVar6.liveInfo.liveId));
                                }
                            }
                            if (!z3 && gVar6.uDU != ass.LDF) {
                                Log.i("Finder.FestivalFinderLiveService", "[heartbeat] checkLinkMicEnable isAnchor:" + dMz + " localLiveExtFlag:" + gVar6.uDU + " liveExtFlag:" + ass.LDF);
                                if (!dMz) {
                                    if (!com.tencent.mm.ac.d.cW(gVar6.uDU, 1) && com.tencent.mm.ac.d.cW(ass.LDF, 1)) {
                                        com.tencent.mm.live.b.s sVar2 = com.tencent.mm.live.b.s.hIl;
                                        com.tencent.mm.live.b.j aGe2 = com.tencent.mm.live.b.s.aGe();
                                        if (aGe2 != null) {
                                            aGe2.onAnchorConnectionChange(false);
                                        }
                                    } else if (com.tencent.mm.ac.d.cW(gVar6.uDU, 1) && !com.tencent.mm.ac.d.cW(ass.LDF, 1)) {
                                        com.tencent.mm.live.b.s sVar3 = com.tencent.mm.live.b.s.hIl;
                                        com.tencent.mm.live.b.j aGe3 = com.tencent.mm.live.b.s.aGe();
                                        if (aGe3 != null) {
                                            aGe3.onAnchorConnectionChange(true);
                                        }
                                    }
                                }
                                gVar6.uDU = ass.LDF;
                            }
                            StringBuilder append4 = new StringBuilder("cur liveId:").append(gVar6.liveInfo.liveId).append(",remote liveId:");
                            awe awe14 = ass.liveInfo;
                            if (awe14 != null) {
                                l3 = Long.valueOf(awe14.liveId);
                            } else {
                                l3 = null;
                            }
                            StringBuilder append5 = append4.append(l3).append(",likeCnt:").append(gVar6.liveInfo.wBG).append(",remote likeCnt:");
                            awe awe15 = ass.liveInfo;
                            if (awe15 != null) {
                                num = Integer.valueOf(awe15.wBG);
                            } else {
                                num = null;
                            }
                            StringBuilder append6 = append5.append(num).append(",onlineCount:").append(gVar6.liveInfo.uBn).append(" remoteMsgSize:");
                            LinkedList<awq> linkedList6 = ass.FoQ;
                            if (linkedList6 != null) {
                                num2 = Integer.valueOf(linkedList6.size());
                            } else {
                                num2 = null;
                            }
                            Log.i("Finder.FestivalFinderLiveService", append6.append(num2).append(", msgSize:").append(gVar6.uDs.size()).append(", extFlag:").append(ass.LDF).append(", participantCnt:").append(ass.LDH).append(", qosControl:").append(gVar6.uEU).toString());
                        }
                    }
                    AppMethodBeat.o(262554);
                    return true;
                }
                Log.i("Finder.FestivalFinderLiveService", "handleLiveMsgResp live has finished");
                AppMethodBeat.o(262554);
                return false;
            }
        }
        StringBuilder sb2 = new StringBuilder("handleLiveMsgResp invalid live resp, curData:");
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar10 = ujz;
        StringBuilder append7 = sb2.append((gVar10 == null || (awe = gVar10.liveInfo) == null) ? null : Long.valueOf(awe.liveId)).append(", resp.liveId:");
        awe awe16 = ass.liveInfo;
        Log.i("Finder.FestivalFinderLiveService", append7.append(awe16 != null ? Long.valueOf(awe16.liveId) : null).toString());
        AppMethodBeat.o(262554);
        return false;
    }

    public static void P(long j2, long j3) {
        awe awe;
        w wVar;
        awe awe2;
        AppMethodBeat.i(262555);
        StringBuilder append = new StringBuilder("heartBeat liveId:").append(j3).append(" delay:").append(j2).append(" curLive:");
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar = ujz;
        Log.i("Finder.FestivalFinderLiveService", append.append((gVar == null || (awe2 = gVar.liveInfo) == null) ? null : Long.valueOf(awe2.liveId)).append(" liveId:").append(j3).toString());
        if (j3 > 0) {
            com.tencent.mm.plugin.finder.live.viewmodel.g gVar2 = ujz;
            if (gVar2 == null || (awe = gVar2.liveInfo) == null) {
                AppMethodBeat.o(262555);
                return;
            } else if (awe.liveId == j3 && (wVar = ujK) != null) {
                wVar.f(Long.valueOf(j2));
                AppMethodBeat.o(262555);
                return;
            }
        }
        AppMethodBeat.o(262555);
    }

    public static void a(b.c cVar, Bundle bundle, long j2) {
        Long l2;
        boolean z;
        String str;
        bo boVar;
        awe awe;
        awe awe2;
        boolean z2 = false;
        Object obj = null;
        AppMethodBeat.i(262556);
        p.h(cVar, "event");
        StringBuilder append = new StringBuilder("transferState before event:").append(cVar).append(" curLive:");
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar = ujz;
        if (gVar == null || (awe2 = gVar.liveInfo) == null) {
            l2 = null;
        } else {
            l2 = Long.valueOf(awe2.liveId);
        }
        StringBuilder append2 = append.append(l2).append(" liveState:");
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar2 = ujz;
        StringBuilder append3 = append2.append(gVar2 != null ? Integer.valueOf(gVar2.uEg) : null).append(" uiState:");
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar3 = ujz;
        Log.i("Finder.FestivalFinderLiveService", append3.append(gVar3 != null ? Integer.valueOf(gVar3.uEf) : null).toString());
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar4 = ujz;
        if (gVar4 == null) {
            AppMethodBeat.o(262556);
        } else if (j2 != gVar4.liveInfo.liveId) {
            Log.w("Finder.FestivalFinderLiveService", "invalid liveId:" + j2 + ", ignore...");
            AppMethodBeat.o(262556);
        } else {
            switch (au.$EnumSwitchMapping$0[cVar.ordinal()]) {
                case 1:
                    gVar4.uEg = 1;
                    gVar4.uEf = 1024;
                    break;
                case 2:
                    gVar4.uEg = 1;
                    gVar4.uEf &= -1025;
                    break;
                case 3:
                    gVar4.uEg = 0;
                    if (bundle == null || !bundle.getBoolean("PARAM_FINDER_LIVE_START_BY_MINI_WINDOW", false)) {
                        gVar4.uEf = 0;
                        break;
                    }
                case 4:
                    if (gVar4.isLiveStarted() && !com.tencent.mm.ac.d.cW(gVar4.uEf, 96)) {
                        gVar4.uEf |= 16;
                        break;
                    }
                case 5:
                    if (gVar4.isLiveStarted() && com.tencent.mm.ac.d.cW(gVar4.uEf, 16)) {
                        gVar4.uEf &= -17;
                        break;
                    }
                case 6:
                    if (gVar4.isLiveStarted() && !com.tencent.mm.ac.d.cW(gVar4.uEf, 96)) {
                        gVar4.uEf |= 2;
                        break;
                    }
                case 7:
                    if (gVar4.isLiveStarted() && com.tencent.mm.ac.d.cW(gVar4.uEf, 2)) {
                        gVar4.uEf &= -3;
                        break;
                    }
                case 8:
                    if (dMz && !com.tencent.mm.ac.d.cW(gVar4.uEf, 32)) {
                        gVar4.uEg = 3;
                        gVar4.uEf = 1;
                    }
                    com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
                    ujB = com.tencent.mm.plugin.finder.storage.c.dwj().value().intValue();
                    break;
                case 9:
                    if (!dMz && !gVar4.djl()) {
                        gVar4.uEg = 3;
                        gVar4.uEf = 1;
                        break;
                    }
                case 10:
                    gVar4.uEg = 4;
                    gVar4.uEf = 0;
                    break;
                case 11:
                    com.tencent.mm.live.core.core.trtc.a aVar = hSS;
                    if (aVar != null) {
                        aVar.a(com.tencent.mm.live.core.mini.d.STATE_DISCONNECT);
                    }
                    if (gVar4.isLiveStarted() && !com.tencent.mm.ac.d.cW(gVar4.uEf, 96)) {
                        gVar4.uEf |= 32;
                        gVar4.uEf &= -513;
                        break;
                    }
                case 12:
                    if (!gVar4.djl()) {
                        gVar4.uEg = 3;
                        gVar4.uEf = 1;
                        break;
                    }
                    break;
                case 13:
                    if (gVar4.isLiveStarted() && !com.tencent.mm.ac.d.cW(gVar4.uEf, SdkInfo.ErrCode.kErrCodeNotFound)) {
                        gVar4.uEf |= 512;
                        break;
                    }
                case 14:
                    if (gVar4.isLiveStarted() && !com.tencent.mm.ac.d.cW(gVar4.uEf, 96)) {
                        gVar4.uEf |= 64;
                        gVar4.uEf &= -513;
                        break;
                    }
                case 15:
                    if (gVar4.isLiveStarted() && com.tencent.mm.ac.d.cW(gVar4.uEf, 64)) {
                        gVar4.uEf &= -65;
                        break;
                    }
                case 16:
                    if (gVar4.isLiveStarted()) {
                        if (bundle != null) {
                            obj = Boolean.valueOf(bundle.getBoolean("PARAM_IS_ENTERING_COMMENT", false));
                        }
                        if (!p.j(obj, Boolean.TRUE)) {
                            gVar4.uEf &= -9;
                            break;
                        } else {
                            gVar4.uEf |= 8;
                            break;
                        }
                    }
                    break;
                case 17:
                    if ((gVar4.isLiveStarted() || gVar4.djk()) && !com.tencent.mm.ac.d.cW(gVar4.uEf, 96)) {
                        gVar4.uEf |= 4;
                    }
                    FinderLiveMiniView finderLiveMiniView = ujt;
                    if (finderLiveMiniView != null) {
                        z2 = finderLiveMiniView.dMz;
                    }
                    if (!z2) {
                        m.a(m.vli, s.au.CommerceActionShoppingButtonClick, (String) null, (String) null);
                        break;
                    } else {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("type", s.aa.LIVE_ENTER_SHOP.action);
                        com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                        jSONObject.put("sessionid", com.tencent.mm.plugin.finder.report.live.k.dpl().vlJ);
                        awc awc = gVar4.uEl;
                        if (awc == null || (str = awc.vtD) == null) {
                            str = "";
                        }
                        jSONObject.put("shopwindowid", str);
                        if (!gVar4.djk()) {
                            if (gVar4.isLiveStarted()) {
                                com.tencent.mm.plugin.finder.report.live.k kVar2 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                                if (com.tencent.mm.plugin.finder.report.live.k.dpl().vmn) {
                                    jSONObject.put("type", s.aa.LIVE_CLICK_PROMOTE_GOODS.action);
                                }
                                com.tencent.mm.plugin.finder.live.viewmodel.g gVar5 = ujz;
                                if (gVar5 != null) {
                                    obj = gVar5.uEq;
                                }
                                jSONObject.put("appid", obj);
                                com.tencent.mm.plugin.finder.live.viewmodel.g gVar6 = ujz;
                                long j3 = (gVar6 == null || (awe = gVar6.liveInfo) == null) ? -1 : awe.liveId;
                                if (j3 < 0) {
                                    jSONObject.put("liveid", "");
                                } else {
                                    jSONObject.put("liveid", com.tencent.mm.plugin.expt.hellhound.core.b.zs(j3));
                                }
                                c.a aVar2 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
                                jSONObject.put("clickid", com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEB);
                                c.a aVar3 = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
                                c.a.apD("");
                                o oVar = o.ujN;
                                com.tencent.mm.plugin.finder.live.viewmodel.g dfZ = o.dfZ();
                                jSONObject.put("productid", (dfZ == null || (boVar = dfZ.UPW) == null) ? "" : Long.valueOf(boVar.lT()));
                                com.tencent.mm.plugin.finder.report.live.k kVar3 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                                com.tencent.mm.plugin.finder.report.live.k.a(s.c.LIVE_ANCHOR_ACTION_COMMERCE, jSONObject.toString());
                                break;
                            }
                        } else {
                            com.tencent.mm.plugin.finder.report.live.k kVar4 = com.tencent.mm.plugin.finder.report.live.k.vkd;
                            com.tencent.mm.plugin.finder.report.live.k.q(s.a.LIVE_COMMERCE.hlf, jSONObject.toString());
                            break;
                        }
                    }
                    break;
                case 18:
                    if ((gVar4.isLiveStarted() || gVar4.djk()) && com.tencent.mm.ac.d.cW(gVar4.uEf, 4)) {
                        gVar4.uEf &= -5;
                    }
                    FinderLiveMiniView finderLiveMiniView2 = ujt;
                    if (finderLiveMiniView2 != null) {
                        z = finderLiveMiniView2.dMz;
                    } else {
                        z = false;
                    }
                    if (!z) {
                        m.a(m.vli, s.au.CommerceActionExitHalfPage, (String) null, (String) null);
                        break;
                    }
                    break;
                case 19:
                    gVar4.uEg = 3;
                    gVar4.uEf |= 128;
                    break;
                case 20:
                    gVar4.uEg = 3;
                    gVar4.uEf |= 256;
                    break;
                case 21:
                    gVar4.uEg = 3;
                    gVar4.uEf |= 4096;
                    break;
                case 22:
                    gVar4.uEf |= 2048;
                    break;
                case 23:
                case 24:
                case 25:
                    gVar4.uEf &= -2049;
                    break;
                case 26:
                    gVar4.uEf |= 8192;
                    break;
                case 27:
                    gVar4.uEf &= -8193;
                    break;
                case 28:
                    gVar4.uEf |= 16384;
                    break;
                case 29:
                    gVar4.uEf &= -16385;
                    break;
                case 30:
                    gVar4.uEf |= 32768;
                    break;
                case 31:
                    gVar4.uEf &= -32769;
                    break;
                case 32:
                    gVar4.uEf |= 65536;
                    break;
                case 33:
                    gVar4.uEf &= -65537;
                    break;
                case 34:
                    gVar4.uEf |= 131072;
                    break;
                case 35:
                    gVar4.uEf &= -131073;
                    break;
            }
            Log.i("Finder.FestivalFinderLiveService", "transferState after  event:" + cVar + " liveState:" + gVar4.uEg + " uiState:" + gVar4.uEf);
            AppMethodBeat.o(262556);
        }
    }

    public static void EJ(long j2) {
        awe awe;
        AppMethodBeat.i(262557);
        StringBuilder append = new StringBuilder("keepAlive delay:").append(j2).append(" curLive:");
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar = ujz;
        Log.i("Finder.FestivalFinderLiveService", append.append((gVar == null || (awe = gVar.liveInfo) == null) ? null : Long.valueOf(awe.liveId)).toString());
        w wVar = ujL;
        if (wVar != null) {
            wVar.f(Long.valueOf(j2));
            AppMethodBeat.o(262557);
            return;
        }
        AppMethodBeat.o(262557);
    }

    public static com.tencent.mm.plugin.finder.live.viewmodel.g a(com.tencent.mm.plugin.finder.live.viewmodel.c cVar) {
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar;
        FinderObject finderObject;
        AppMethodBeat.i(262558);
        if (cVar != null) {
            gVar = cVar.uCs;
        } else {
            gVar = null;
        }
        if (gVar != null && gVar.liveInfo.liveId == 0) {
            gVar.liveInfo.liveId = cVar.uCr.getLiveId();
            gVar.hFK = cVar.uCr.aBH();
            e.a aVar = com.tencent.mm.plugin.finder.storage.data.e.vFX;
            FinderItem Fy = e.a.Fy(gVar.hFK);
            if (Fy == null || (finderObject = Fy.getFinderObject()) == null) {
                finderObject = new FinderObject();
            }
            gVar.uDz = finderObject;
            String aBG = cVar.uCr.aBG();
            p.g(aBG, "livecData.staticConfig.anchorUsername");
            gVar.atT(aBG);
            String aBI = cVar.uCr.aBI();
            p.g(aBI, "livecData.staticConfig.nonceId");
            gVar.atS(aBI);
            gVar.desc = cVar.uCr.getDesc();
            if (TextUtils.isEmpty(gVar.uEu)) {
                String aBE = cVar.uCr.aBE();
                p.g(aBE, "livecData.staticConfig.thumbUrl");
                gVar.bxN(aBE);
            }
            if (!Util.isNullOrNil(cVar.uCr.aBJ())) {
                gVar.uDO = new com.tencent.mm.plugin.finder.live.viewmodel.h(cVar.uCr.aBJ(), cVar.uCr.aBM(), cVar.uCr.aBN(), cVar.uCr.aBK(), cVar.uCr.aBL());
            }
            String sessionBuffer = cVar.uCr.getSessionBuffer();
            if (sessionBuffer == null) {
                sessionBuffer = "";
            }
            gVar.setSessionBuffer(sessionBuffer);
            gVar.hUc();
            Log.i("Finder.FestivalFinderLiveService", "transferLiveData liveId:" + gVar.liveInfo.liveId + " objectId:" + gVar.hFK + " anchorUsername:" + gVar.hwd);
        }
        AppMethodBeat.o(262558);
        return gVar;
    }

    public static /* synthetic */ void a(boolean z, Boolean bool, Boolean bool2, int i2) {
        Boolean bool3;
        com.tencent.mm.plugin.finder.live.viewmodel.e eVar;
        com.tencent.mm.live.core.core.b.g gVar;
        AppMethodBeat.i(262559);
        if ((i2 & 1) != 0) {
            z = true;
        }
        if ((i2 & 4) != 0) {
            bool = Boolean.TRUE;
        }
        if ((i2 & 8) != 0) {
            bool2 = Boolean.TRUE;
        }
        StringBuilder append = new StringBuilder("release curLiveRoomData:").append(ujz).append(" isNormalMode:");
        com.tencent.mm.live.core.core.trtc.a aVar = hSS;
        if (aVar == null || (gVar = aVar.hAz) == null) {
            bool3 = null;
        } else {
            bool3 = Boolean.valueOf(gVar.isNormalMode());
        }
        StringBuilder append2 = append.append(bool3).append(",isTopApplication:").append(z).append(", miniWinPermission:false, curLinkState:");
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar2 = ujz;
        StringBuilder append3 = append2.append(gVar2 != null ? Integer.valueOf(gVar2.uEC) : null).append(", curLinkUser:");
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar3 = ujz;
        if (gVar3 != null) {
            eVar = gVar3.uEB;
        } else {
            eVar = null;
        }
        Log.i("Finder.FestivalFinderLiveService", append3.append(eVar).toString());
        com.tencent.mm.plugin.festival.model.i iVar = com.tencent.mm.plugin.festival.model.i.Uyl;
        com.tencent.mm.plugin.festival.model.i.log("FestivalFinderLiveService release releaseWishLive:".concat(String.valueOf(bool2)));
        Log.i("Finder.FestivalFinderLiveService", "release: stack:" + android.util.Log.getStackTraceString(new Throwable()));
        if (p.j(bool2, Boolean.TRUE)) {
            r rVar = r.UyJ;
            Log.i("FestivalMusicManager", "stop");
            r.hdZ();
            EventCenter.instance.removeListener(r.UyG);
            com.tencent.mm.ai.c.aGU(r.dtX);
            com.tencent.mm.ai.c.aGW(r.dtX);
            com.tencent.mm.plugin.festival.model.z zVar = com.tencent.mm.plugin.festival.model.z.Uzb;
            com.tencent.mm.plugin.festival.model.z.b(rVar);
            com.tencent.mm.plugin.festival.model.g.UxZ.gWK();
        }
        com.tencent.mm.live.b.d.c cVar = com.tencent.mm.live.b.d.c.hLq;
        com.tencent.mm.live.b.d.c.release();
        ujC = 0;
        ujG.dead();
        hXn.dead();
        ujs = null;
        aHh();
        if (p.j(bool, Boolean.TRUE)) {
            com.tencent.mm.plugin.finder.live.model.s sVar = ujx;
            if (sVar != null) {
                sVar.dfj();
            }
            com.tencent.mm.live.core.core.trtc.a aVar2 = hSS;
            if (aVar2 != null) {
                aVar2.b(new k());
            }
        }
        f(null);
        ujA = 0;
        com.tencent.mm.live.core.core.trtc.a aVar3 = hSS;
        if (aVar3 != null) {
            aVar3.hAx = null;
        }
        c.a aVar4 = com.tencent.mm.live.core.core.d.c.uKx;
        com.tencent.mm.live.core.core.d.c cVar2 = com.tencent.mm.live.core.core.d.c.uKw;
        if (cVar2 != null) {
            cVar2.release();
        }
        com.tencent.mm.live.core.core.d.c.uKw = null;
        hSS = null;
        ujx = null;
        ae aeVar = ae.vZW;
        ae.reset();
        com.tencent.mm.plugin.finder.live.util.q qVar = com.tencent.mm.plugin.finder.live.util.q.uxj;
        com.tencent.mm.plugin.finder.live.util.q.reset();
        com.tencent.mm.plugin.finder.live.model.e eVar2 = com.tencent.mm.plugin.finder.live.model.e.uiD;
        com.tencent.mm.plugin.finder.live.model.e.release();
        ujt = null;
        com.tencent.mm.plugin.festival.model.i iVar2 = com.tencent.mm.plugin.festival.model.i.Uyl;
        com.tencent.mm.plugin.festival.model.i.log("FestivalFinderLiveService release done");
        AppMethodBeat.o(262559);
    }

    public static final class k implements com.tencent.mm.live.core.core.c {
        k() {
        }

        @Override // com.tencent.mm.live.core.core.c
        public final void callback(int i2, Bundle bundle) {
            AppMethodBeat.i(262550);
            Log.i("Finder.FestivalFinderLiveService", "on exitRoom finish");
            AppMethodBeat.o(262550);
        }
    }

    public static void aHh() {
        AppMethodBeat.i(262560);
        hWh.apm();
        w wVar = ujK;
        if (wVar != null) {
            wVar.dgE();
        }
        w wVar2 = ujL;
        if (wVar2 != null) {
            wVar2.dgE();
            AppMethodBeat.o(262560);
            return;
        }
        AppMethodBeat.o(262560);
    }

    public static /* synthetic */ void a(at atVar) {
        AppMethodBeat.i(262562);
        atVar.nn(true);
        AppMethodBeat.o(262562);
    }

    public final void nn(boolean z) {
        AppMethodBeat.i(262561);
        com.tencent.mm.live.core.core.trtc.a aVar = hSS;
        if (aVar != null) {
            aVar.aBW();
        }
        FinderBaseLivePluginLayout finderBaseLivePluginLayout = ujs;
        if (finderBaseLivePluginLayout != null) {
            finderBaseLivePluginLayout.finish();
        }
        a(z, (Boolean) null, (Boolean) null, 14);
        AppMethodBeat.o(262561);
    }

    private static boolean e(Long l2) {
        long j2;
        awe awe;
        AppMethodBeat.i(262563);
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar = ujz;
        if (gVar == null || (awe = gVar.liveInfo) == null) {
            j2 = 0;
        } else {
            j2 = awe.liveId;
        }
        if (j2 == 0 || l2 == null || j2 != l2.longValue()) {
            AppMethodBeat.o(262563);
            return true;
        }
        AppMethodBeat.o(262563);
        return false;
    }

    @Override // com.tencent.mm.live.core.core.c
    public final void callback(int i2, Bundle bundle) {
        AppMethodBeat.i(262564);
        FinderBaseLivePluginLayout finderBaseLivePluginLayout = ujs;
        if (finderBaseLivePluginLayout != null) {
            finderBaseLivePluginLayout.onLiveEventCallback(i2, bundle);
            AppMethodBeat.o(262564);
            return;
        }
        AppMethodBeat.o(262564);
    }

    public static final class e extends kotlin.g.b.q implements kotlin.g.a.a<String> {
        final /* synthetic */ int $errCode;
        final /* synthetic */ int $errType;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(int i2, int i3) {
            super(0);
            this.$errCode = i2;
            this.$errType = i3;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            Long l;
            awe awe;
            AppMethodBeat.i(262541);
            StringBuilder append = new StringBuilder("errCode:").append(this.$errCode).append(" errType:").append(this.$errType).append(" localId:");
            at atVar = at.Uuv;
            com.tencent.mm.plugin.finder.live.viewmodel.g dfZ = at.dfZ();
            if (dfZ == null || (awe = dfZ.liveInfo) == null) {
                l = null;
            } else {
                l = Long.valueOf(awe.liveId);
            }
            String sb = append.append(l).toString();
            AppMethodBeat.o(262541);
            return sb;
        }
    }

    public static final class f extends kotlin.g.b.q implements kotlin.g.a.a<String> {
        final /* synthetic */ int $errCode;
        final /* synthetic */ int $errType;
        final /* synthetic */ ass ujQ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(int i2, int i3, ass ass) {
            super(0);
            this.$errCode = i2;
            this.$errType = i3;
            this.ujQ = ass;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            Long l;
            AppMethodBeat.i(262542);
            StringBuilder append = new StringBuilder("errCode:").append(this.$errCode).append(" errType:").append(this.$errType).append(" svrId:");
            awe awe = this.ujQ.liveInfo;
            if (awe != null) {
                l = Long.valueOf(awe.liveId);
            } else {
                l = null;
            }
            String sb = append.append(l).toString();
            AppMethodBeat.o(262542);
            return sb;
        }
    }

    public static final /* synthetic */ boolean c(int i2, int i3, auf auf) {
        boolean z;
        Long l2;
        com.tencent.mm.live.core.core.b.f fVar;
        TRTCCloudDef.TRTCParams tRTCParams;
        awe awe;
        awe awe2;
        awe awe3;
        long j2 = 0;
        byte[] bArr = null;
        Long l3 = null;
        AppMethodBeat.i(262567);
        StringBuilder append = new StringBuilder("handleKeepAliveResp errCode:").append(i2).append(", errType:").append(i3).append(", curData:");
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar = ujz;
        StringBuilder append2 = append.append((gVar == null || (awe3 = gVar.liveInfo) == null) ? null : Long.valueOf(awe3.liveId)).append(", resp.liveId:");
        awe awe4 = auf.liveInfo;
        Log.i("Finder.FestivalFinderLiveService", append2.append(awe4 != null ? Long.valueOf(awe4.liveId) : null).toString());
        if (i2 == -100038) {
            com.tencent.mm.plugin.finder.live.viewmodel.g gVar2 = ujz;
            if (gVar2 != null) {
                com.tencent.mm.live.core.core.trtc.a aVar = hSS;
                if (aVar != null) {
                    aVar.a(com.tencent.mm.live.core.mini.d.STATE_FINISH);
                }
                com.tencent.mm.live.b.s sVar = com.tencent.mm.live.b.s.hIl;
                com.tencent.mm.live.b.j aGe = com.tencent.mm.live.b.s.aGe();
                if (aGe != null) {
                    aGe.onCloseLive(new com.tencent.mm.live.b.e(gVar2.liveInfo.liveId));
                }
            }
            Log.i("Finder.FestivalFinderLiveService", "handleKeepAliveResp live has finished");
            z = false;
        } else if (i3 != 0 || i2 != 0) {
            Log.i("Finder.FestivalFinderLiveService", "handleKeepAliveResp launch live room failed");
            z = false;
        } else if (auf == null) {
            Log.i("Finder.FestivalFinderLiveService", "handleKeepAliveResp invalid live resp");
            z = false;
        } else {
            awe awe5 = auf.liveInfo;
            if (awe5 != null) {
                l2 = Long.valueOf(awe5.liveId);
            } else {
                l2 = null;
            }
            if (e(l2)) {
                StringBuilder sb = new StringBuilder("handleKeepAliveResp invalid live id, curData:");
                com.tencent.mm.plugin.finder.live.viewmodel.g gVar3 = ujz;
                if (!(gVar3 == null || (awe2 = gVar3.liveInfo) == null)) {
                    j2 = awe2.liveId;
                }
                StringBuilder append3 = sb.append(j2).append(", resp.liveId:");
                awe awe6 = auf.liveInfo;
                if (awe6 != null) {
                    l3 = Long.valueOf(awe6.liveId);
                }
                Log.i("Finder.FestivalFinderLiveService", append3.append(l3).toString());
                z = false;
            } else {
                cjb cjb = auf.hIv;
                if (cjb != null) {
                    com.tencent.mm.plugin.finder.live.viewmodel.g gVar4 = ujz;
                    if (gVar4 != null) {
                        gVar4.a(cjb);
                    }
                    com.tencent.mm.plugin.finder.live.viewmodel.g gVar5 = ujz;
                    if (!(gVar5 == null || (awe = gVar5.liveInfo) == null)) {
                        awe awe7 = auf.liveInfo;
                        if (awe7 != null) {
                            j2 = awe7.liveId;
                        }
                        awe.liveId = j2;
                    }
                    Log.i("Finder.FestivalFinderLiveService", "doKeepAlive updatePrivateMapKey");
                    b.a aVar2 = com.tencent.mm.live.core.core.a.b.hyv;
                    if (b.a.aDp()) {
                        b.a aVar3 = com.tencent.mm.live.core.core.a.b.hyv;
                        MMApplicationContext.getContext();
                        com.tencent.mm.live.core.core.a.b aDo = b.a.aDo();
                        String yO = cjb.Mon.yO();
                        p.g(yO, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
                        aDo.Go(yO);
                    } else {
                        a.C0381a aVar4 = com.tencent.mm.live.core.core.c.a.hAj;
                        if (a.C0381a.aDp()) {
                            a.C0381a aVar5 = com.tencent.mm.live.core.core.c.a.hAj;
                            MMApplicationContext.getContext();
                            com.tencent.mm.live.core.core.c.a aDw = a.C0381a.aDw();
                            String yO2 = cjb.Mon.yO();
                            p.g(yO2, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
                            aDw.Go(yO2);
                        } else {
                            b.a aVar6 = com.tencent.mm.live.core.core.d.b.hCo;
                            if (b.a.aDp()) {
                                b.a aVar7 = com.tencent.mm.live.core.core.d.b.hCo;
                                MMApplicationContext.getContext();
                                com.tencent.mm.live.core.core.d.b aEf = b.a.aEf();
                                String yO3 = cjb.Mon.yO();
                                p.g(yO3, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
                                aEf.Go(yO3);
                            }
                        }
                    }
                    com.tencent.mm.plugin.finder.live.viewmodel.g gVar6 = ujz;
                    if (gVar6 != null) {
                        com.tencent.mm.bw.b bVar = auf.LDx;
                        if (bVar != null) {
                            bArr = bVar.zy;
                        }
                        gVar6.hIt = bArr;
                    }
                    com.tencent.mm.plugin.finder.live.viewmodel.g gVar7 = ujz;
                    if (!(gVar7 == null || (fVar = gVar7.hIy) == null || (tRTCParams = fVar.hzu) == null)) {
                        tRTCParams.privateMapKey = cjb.Mon.yO();
                    }
                    z = true;
                } else {
                    z = false;
                }
            }
        }
        AppMethodBeat.o(262567);
        return z;
    }

    public static final /* synthetic */ void geJ() {
        int i2;
        int i3;
        aus aus;
        AppMethodBeat.i(262568);
        Log.i("Finder.FestivalFinderLiveService", "doGetLiveMsg heartBeatTimestamp:" + ujC + " [" + ujz + ']');
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar = ujz;
        if (gVar != null) {
            com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
            if (com.tencent.mm.plugin.finder.utils.m.dBP()) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            avk avk = null;
            if (gVar.uET) {
                com.tencent.mm.plugin.finder.live.model.j jVar = com.tencent.mm.plugin.finder.live.model.j.ujh;
                avk = com.tencent.mm.plugin.finder.live.model.j.d(Long.valueOf(ujC));
            }
            am amVar = am.tuw;
            aov cXY = am.cXY();
            String aUg = z.aUg();
            byte[] bArr = gVar.hIt;
            long j2 = gVar.liveInfo.liveId;
            long j3 = gVar.hFK;
            String str = gVar.hwg;
            o oVar = o.ujN;
            com.tencent.mm.plugin.finder.live.viewmodel.g dfZ = o.dfZ();
            if (dfZ == null || (aus = dfZ.UQh) == null) {
                i3 = 4;
            } else {
                i3 = aus.LFy;
            }
            new com.tencent.mm.plugin.finder.live.model.cgi.h(cXY, aUg, bArr, j2, j3, str, i2, false, avk, i3, new b(), 128).aYI();
            ujC = System.currentTimeMillis();
            AppMethodBeat.o(262568);
            return;
        }
        AppMethodBeat.o(262568);
    }

    public static final /* synthetic */ void ggb() {
        int i2;
        AppMethodBeat.i(262569);
        Log.i("Finder.FestivalFinderLiveService", "doKeepLive[" + ujz + ']');
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar = ujz;
        if (gVar != null) {
            com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
            if (com.tencent.mm.plugin.finder.utils.m.dBP()) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            new com.tencent.mm.plugin.finder.live.model.cgi.i(gVar.liveInfo.liveId, gVar.hIt, z.aUg(), gVar.hFK, i2, gVar.hwg, gVar.sessionBuffer, new c()).aYI();
            AppMethodBeat.o(262569);
            return;
        }
        AppMethodBeat.o(262569);
    }
}
