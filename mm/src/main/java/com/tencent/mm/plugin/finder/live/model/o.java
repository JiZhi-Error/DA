package com.tencent.mm.plugin.finder.live.model;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
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
import com.tencent.mm.live.core.d.a;
import com.tencent.mm.live.core.mini.a;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import com.tencent.mm.plugin.finder.cgi.am;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveAnchorWithoutAffinityUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveMiniProProxyUI;
import com.tencent.mm.plugin.finder.feed.ui.FinderLiveVisitorWithoutAffinityUI;
import com.tencent.mm.plugin.finder.feed.ui.OccupyFinderUI13;
import com.tencent.mm.plugin.finder.live.model.cgi.ad;
import com.tencent.mm.plugin.finder.live.model.cgi.d;
import com.tencent.mm.plugin.finder.live.model.cgi.h;
import com.tencent.mm.plugin.finder.live.model.cgi.i;
import com.tencent.mm.plugin.finder.live.model.cgi.u;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.plugin.finder.live.view.FinderBaseLivePluginLayout;
import com.tencent.mm.plugin.finder.live.view.FinderLiveMiniView;
import com.tencent.mm.plugin.finder.live.viewmodel.d;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.data.e;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.aov;
import com.tencent.mm.protocal.protobuf.ass;
import com.tencent.mm.protocal.protobuf.auf;
import com.tencent.mm.protocal.protobuf.aus;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.auu;
import com.tencent.mm.protocal.protobuf.aux;
import com.tencent.mm.protocal.protobuf.avi;
import com.tencent.mm.protocal.protobuf.avk;
import com.tencent.mm.protocal.protobuf.avm;
import com.tencent.mm.protocal.protobuf.avn;
import com.tencent.mm.protocal.protobuf.avs;
import com.tencent.mm.protocal.protobuf.awc;
import com.tencent.mm.protocal.protobuf.awe;
import com.tencent.mm.protocal.protobuf.awl;
import com.tencent.mm.protocal.protobuf.awq;
import com.tencent.mm.protocal.protobuf.awz;
import com.tencent.mm.protocal.protobuf.axl;
import com.tencent.mm.protocal.protobuf.ciq;
import com.tencent.mm.protocal.protobuf.ciz;
import com.tencent.mm.protocal.protobuf.cja;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.protocal.protobuf.cjc;
import com.tencent.mm.protocal.protobuf.cjd;
import com.tencent.mm.protocal.protobuf.ffv;
import com.tencent.mm.protocal.protobuf.fgg;
import com.tencent.mm.protocal.protobuf.fgi;
import com.tencent.mm.protocal.protobuf.fgk;
import com.tencent.mm.protocal.protobuf.vh;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.trtc.TRTCCloudDef;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public final class o implements com.tencent.mm.live.core.core.c {
    private static final MTimerHandler UKA = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new z(), true);
    private static final Runnable UKB = b.UKD;
    private static w UKC;
    private static boolean dMz;
    private static HashMap<Integer, a.C0387a> filterMap = new HashMap<>();
    private static com.tencent.mm.live.core.b.a hDV;
    private static com.tencent.mm.live.core.b.b hDW;
    private static final Runnable hId = j.ujR;
    private static final Runnable hIe = g.ujP;
    private static View.OnClickListener hJe = l.ujS;
    private static com.tencent.mm.live.core.core.trtc.a hSS;
    private static final com.tencent.mm.model.d hWh = com.tencent.mm.model.d.aTu();
    private static final IListener<?> hXn = new n();
    private static com.tencent.mm.plugin.finder.live.view.i ufF;
    private static int ujA;
    private static int ujB = 1000;
    private static long ujC;
    private static com.tencent.mm.bw.b ujD;
    private static int ujE = -1;
    private static int ujF = -1;
    private static final IListener<zj> ujG = new s();
    private static final a ujH = new a();
    private static final View.OnClickListener ujI = m.ujT;
    private static final Runnable ujJ = RunnableC1187o.ujU;
    private static w ujK;
    private static w ujL;
    private static w ujM;
    public static final o ujN = new o();
    private static FinderBaseLivePluginLayout ujs;
    private static FinderLiveMiniView ujt;
    private static String uju = "";
    private static com.tencent.mm.live.core.b.a ujv;
    private static int ujw = 40;
    private static s ujx;
    private static com.tencent.mm.plugin.finder.live.viewmodel.d ujy;
    private static com.tencent.mm.plugin.finder.live.viewmodel.g ujz;

    public static final class c extends kotlin.g.b.q implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.e, Boolean> {
        final /* synthetic */ aut UKE;
        final /* synthetic */ aux UKF;
        final /* synthetic */ com.tencent.mm.plugin.finder.live.viewmodel.g UKG;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(aut aut, aux aux, com.tencent.mm.plugin.finder.live.viewmodel.g gVar) {
            super(1);
            this.UKE = aut;
            this.UKF = aux;
            this.UKG = gVar;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(com.tencent.mm.plugin.finder.live.viewmodel.e eVar) {
            AppMethodBeat.i(260476);
            Boolean valueOf = Boolean.valueOf(Util.isEqual(eVar.sessionId, this.UKE.session_id));
            AppMethodBeat.o(260476);
            return valueOf;
        }
    }

    public static final class t extends kotlin.g.b.q implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.e, Boolean> {
        final /* synthetic */ aut UKE;
        final /* synthetic */ aux UKF;
        final /* synthetic */ com.tencent.mm.plugin.finder.live.viewmodel.g UKG;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        t(aut aut, aux aux, com.tencent.mm.plugin.finder.live.viewmodel.g gVar) {
            super(1);
            this.UKE = aut;
            this.UKF = aux;
            this.UKG = gVar;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(com.tencent.mm.plugin.finder.live.viewmodel.e eVar) {
            String str;
            FinderContact finderContact;
            AppMethodBeat.i(260477);
            String str2 = eVar.username;
            avn avn = this.UKE.LFE;
            if (avn == null || (finderContact = avn.contact) == null) {
                str = null;
            } else {
                str = finderContact.username;
            }
            Boolean valueOf = Boolean.valueOf(Util.isEqual(str2, str));
            AppMethodBeat.o(260477);
            return valueOf;
        }
    }

    public static final class u extends kotlin.g.b.q implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.e, Boolean> {
        final /* synthetic */ aut UKE;
        final /* synthetic */ aux UKF;
        final /* synthetic */ com.tencent.mm.plugin.finder.live.viewmodel.g UKG;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        u(aut aut, aux aux, com.tencent.mm.plugin.finder.live.viewmodel.g gVar) {
            super(1);
            this.UKE = aut;
            this.UKF = aux;
            this.UKG = gVar;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(com.tencent.mm.plugin.finder.live.viewmodel.e eVar) {
            String str;
            FinderContact finderContact;
            AppMethodBeat.i(260478);
            String str2 = eVar.username;
            avn avn = this.UKE.LFE;
            if (avn == null || (finderContact = avn.contact) == null) {
                str = null;
            } else {
                str = finderContact.username;
            }
            Boolean valueOf = Boolean.valueOf(Util.isEqual(str2, str));
            AppMethodBeat.o(260478);
            return valueOf;
        }
    }

    public static final class v extends kotlin.g.b.q implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.e, Boolean> {
        final /* synthetic */ aut UKE;
        final /* synthetic */ aux UKF;
        final /* synthetic */ com.tencent.mm.plugin.finder.live.viewmodel.g UKG;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        v(aut aut, aux aux, com.tencent.mm.plugin.finder.live.viewmodel.g gVar) {
            super(1);
            this.UKE = aut;
            this.UKF = aux;
            this.UKG = gVar;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(com.tencent.mm.plugin.finder.live.viewmodel.e eVar) {
            AppMethodBeat.i(260479);
            Boolean valueOf = Boolean.valueOf(Util.isEqual(eVar.sessionId, this.UKE.session_id));
            AppMethodBeat.o(260479);
            return valueOf;
        }
    }

    public static final class w extends kotlin.g.b.q implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.e, Boolean> {
        final /* synthetic */ aut UKE;
        final /* synthetic */ com.tencent.mm.plugin.finder.live.viewmodel.g UKG;
        final /* synthetic */ fgi UKH;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        w(aut aut, fgi fgi, com.tencent.mm.plugin.finder.live.viewmodel.g gVar) {
            super(1);
            this.UKE = aut;
            this.UKH = fgi;
            this.UKG = gVar;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(com.tencent.mm.plugin.finder.live.viewmodel.e eVar) {
            String str;
            FinderContact finderContact;
            AppMethodBeat.i(260480);
            String str2 = eVar.username;
            avn avn = this.UKE.LFE;
            if (avn == null || (finderContact = avn.contact) == null) {
                str = null;
            } else {
                str = finderContact.username;
            }
            Boolean valueOf = Boolean.valueOf(Util.isEqual(str2, str));
            AppMethodBeat.o(260480);
            return valueOf;
        }
    }

    public static final class x extends kotlin.g.b.q implements kotlin.g.a.b<com.tencent.mm.plugin.finder.live.viewmodel.e, Boolean> {
        final /* synthetic */ aut UKE;
        final /* synthetic */ com.tencent.mm.plugin.finder.live.viewmodel.g UKG;
        final /* synthetic */ fgi UKH;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        x(aut aut, fgi fgi, com.tencent.mm.plugin.finder.live.viewmodel.g gVar) {
            super(1);
            this.UKE = aut;
            this.UKH = fgi;
            this.UKG = gVar;
        }

        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(com.tencent.mm.plugin.finder.live.viewmodel.e eVar) {
            String str;
            FinderContact finderContact;
            AppMethodBeat.i(260481);
            String str2 = eVar.username;
            avn avn = this.UKE.LFE;
            if (avn == null || (finderContact = avn.contact) == null) {
                str = null;
            } else {
                str = finderContact.username;
            }
            Boolean valueOf = Boolean.valueOf(Util.isEqual(str2, str));
            AppMethodBeat.o(260481);
            return valueOf;
        }
    }

    static {
        AppMethodBeat.i(246254);
        ujH.alive();
        AppMethodBeat.o(246254);
    }

    private o() {
    }

    public static final /* synthetic */ boolean a(o oVar, int i2, int i3, ass ass, int i4) {
        AppMethodBeat.i(260496);
        boolean b2 = b(i2, i3, ass, i4);
        AppMethodBeat.o(260496);
        return b2;
    }

    public static final /* synthetic */ boolean b(int i2, int i3, auf auf) {
        AppMethodBeat.i(246256);
        boolean a2 = a(i2, i3, auf);
        AppMethodBeat.o(246256);
        return a2;
    }

    public static final /* synthetic */ boolean b(int i2, int i3, awz awz) {
        AppMethodBeat.i(246257);
        boolean a2 = a(i2, i3, awz);
        AppMethodBeat.o(246257);
        return a2;
    }

    public static void a(com.tencent.mm.plugin.finder.live.view.i iVar) {
        ufF = iVar;
    }

    public static com.tencent.mm.plugin.finder.live.view.i dfU() {
        return ufF;
    }

    public static com.tencent.mm.live.core.b.a dfV() {
        return ujv;
    }

    public static int dfW() {
        return ujw;
    }

    public static com.tencent.mm.live.core.b.a aGk() {
        return hDV;
    }

    public static com.tencent.mm.live.core.b.b aGl() {
        return hDW;
    }

    public static HashMap<Integer, a.C0387a> dfX() {
        return filterMap;
    }

    public static s getFinderLiveAssistant() {
        return ujx;
    }

    public static com.tencent.mm.plugin.finder.live.viewmodel.d dfY() {
        return ujy;
    }

    public static void b(com.tencent.mm.plugin.finder.live.viewmodel.d dVar) {
        AppMethodBeat.i(246216);
        Log.i("Finder.FinderLiveService", "FinderLiveDataModel set ".concat(String.valueOf(dVar)));
        ujy = dVar;
        AppMethodBeat.o(246216);
    }

    public static com.tencent.mm.plugin.finder.live.viewmodel.g dfZ() {
        return ujz;
    }

    private static void f(com.tencent.mm.plugin.finder.live.viewmodel.g gVar) {
        AppMethodBeat.i(246217);
        Log.i("Finder.FinderLiveService", "write curLiveRoomData to :".concat(String.valueOf(gVar)));
        ujz = gVar;
        AppMethodBeat.o(246217);
    }

    public static int dga() {
        return ujA;
    }

    public static int dgb() {
        return ujB;
    }

    public static void b(com.tencent.mm.bw.b bVar) {
        ujD = bVar;
    }

    public static com.tencent.mm.bw.b dgc() {
        return ujD;
    }

    public static void Jg(int i2) {
        ujE = i2;
    }

    public static int dgd() {
        return ujE;
    }

    public static void Jh(int i2) {
        ujF = i2;
    }

    public static int dge() {
        return ujF;
    }

    public static final class z implements MTimerHandler.CallBack {
        z() {
        }

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            long j2;
            awe awe;
            AppMethodBeat.i(260485);
            o oVar = o.ujN;
            if (o.dfZ() != null) {
                o oVar2 = o.ujN;
                com.tencent.mm.plugin.finder.live.viewmodel.g dfZ = o.dfZ();
                if (dfZ == null || !dfZ.djl()) {
                    o oVar3 = o.ujN;
                    com.tencent.mm.plugin.finder.live.viewmodel.g dfZ2 = o.dfZ();
                    if (dfZ2 == null || (awe = dfZ2.liveInfo) == null) {
                        j2 = 0;
                    } else {
                        j2 = awe.liveId;
                    }
                    Log.i("Finder.FinderLiveService", "heartBeat manual recovery liveId:".concat(String.valueOf(j2)));
                    f.a.a(com.tencent.mm.plugin.finder.utils.c.vVc, "liveHeartBeatBreak_manualRecovery", false, false, new a(j2), 12);
                    o oVar4 = o.ujN;
                    o.P(0, j2);
                    AppMethodBeat.o(260485);
                    return true;
                }
            }
            AppMethodBeat.o(260485);
            return false;
        }

        static final class a extends kotlin.g.b.q implements kotlin.g.a.a<String> {
            final /* synthetic */ long hvK;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(long j2) {
                super(0);
                this.hvK = j2;
            }

            @Override // kotlin.g.a.a
            public final /* synthetic */ String invoke() {
                AppMethodBeat.i(260484);
                String str = "liveId:" + this.hvK;
                AppMethodBeat.o(260484);
                return str;
            }
        }
    }

    public static final class s extends IListener<zj> {
        s() {
        }

        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(zj zjVar) {
            AppMethodBeat.i(246215);
            zj zjVar2 = zjVar;
            kotlin.g.b.p.h(zjVar2, "event");
            if (com.tencent.mm.kernel.g.aAc()) {
                o oVar = o.ujN;
                if (o.dfZ() != null) {
                    if (zjVar2.efx.dKy == 3) {
                        o oVar2 = o.ujN;
                        if (!o.dMz) {
                            o.a(o.ujN);
                        }
                    }
                    AppMethodBeat.o(246215);
                    return true;
                }
            }
            AppMethodBeat.o(246215);
            return false;
        }
    }

    public static final class n extends IListener<mu> {
        n() {
        }

        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(mu muVar) {
            AppMethodBeat.i(246206);
            mu muVar2 = muVar;
            kotlin.g.b.p.h(muVar2, "event");
            if (com.tencent.mm.kernel.g.aAc()) {
                o oVar = o.ujN;
                if (o.dfZ() != null) {
                    if (muVar2.dSs.action == 3) {
                        o oVar2 = o.ujN;
                        if (!o.dMz) {
                            o.a(o.ujN);
                        }
                    }
                    AppMethodBeat.o(246206);
                    return false;
                }
            }
            AppMethodBeat.o(246206);
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
            AppMethodBeat.i(246186);
            hx hxVar2 = hxVar;
            if (!(hxVar2 == null || (aVar4 = hxVar2.dMy) == null)) {
                aVar4.isStart = false;
            }
            if (!(hxVar2 == null || (aVar3 = hxVar2.dMy) == null)) {
                aVar3.dMz = false;
            }
            o oVar = o.ujN;
            com.tencent.mm.plugin.finder.live.viewmodel.g dfZ = o.dfZ();
            if (!(dfZ == null || dfZ.liveInfo.liveId == 0 || dfZ.djl())) {
                if (!(hxVar2 == null || (aVar2 = hxVar2.dMy) == null)) {
                    o oVar2 = o.ujN;
                    aVar2.dMz = o.dMz;
                }
                if (!(hxVar2 == null || (aVar = hxVar2.dMy) == null)) {
                    aVar.isStart = true;
                }
            }
            AppMethodBeat.o(246186);
            return true;
        }
    }

    static final class l implements View.OnClickListener {
        public static final l ujS = new l();

        static {
            AppMethodBeat.i(246203);
            AppMethodBeat.o(246203);
        }

        l() {
        }

        public final void onClick(View view) {
            Class cls;
            boolean z;
            AppMethodBeat.i(246202);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/model/FinderLiveService$miniWindowClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            StringBuilder sb = new StringBuilder("miniWindowClickListener onClick ");
            o oVar = o.ujN;
            Log.i("Finder.FinderLiveService", sb.append(o.dfY()).toString());
            o oVar2 = o.ujN;
            com.tencent.mm.live.core.core.trtc.a aVar = o.hSS;
            if (aVar != null) {
                aVar.aBU();
            }
            o oVar3 = o.ujN;
            if (o.dMz) {
                o oVar4 = o.ujN;
                if (o.hSS instanceof com.tencent.mm.live.core.core.a.b) {
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
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/live/model/FinderLiveService$miniWindowClickListener$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/live/model/FinderLiveService$miniWindowClickListener$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            a.C0388a aVar2 = com.tencent.mm.live.core.mini.a.hCD;
            a.b bVar2 = a.b.hCF;
            a.b.aEi().bQc();
            o oVar5 = o.ujN;
            FinderLiveMiniView finderLiveMiniView = o.ujt;
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
                com.tencent.mm.plugin.finder.report.live.m.vli.a(false, s.r.LIVE_FLOAT_ACTION_MAXIMIZE);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/model/FinderLiveService$miniWindowClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(246202);
        }
    }

    static final class m implements View.OnClickListener {
        public static final m ujT = new m();

        static {
            AppMethodBeat.i(246205);
            AppMethodBeat.o(246205);
        }

        m() {
        }

        public final void onClick(View view) {
            boolean z;
            AppMethodBeat.i(246204);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/model/FinderLiveService$miniWindowCloseClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            boolean isTopApplication = Util.isTopApplication(MMApplicationContext.getContext());
            StringBuilder append = new StringBuilder("mini window close,is top applicaton:").append(isTopApplication).append(",is shopping in MiniPro:");
            o oVar = o.ujN;
            com.tencent.mm.plugin.finder.live.viewmodel.g dfZ = o.dfZ();
            StringBuilder append2 = append.append(dfZ != null ? Boolean.valueOf(dfZ.uEr) : null).append(",isAnchor:");
            o oVar2 = o.ujN;
            Log.i("Finder.FinderLiveService", append2.append(o.dMz).toString());
            o oVar3 = o.ujN;
            if (!o.dMz) {
                o oVar4 = o.ujN;
                com.tencent.mm.plugin.finder.live.viewmodel.g dfZ2 = o.dfZ();
                if (dfZ2 != null && dfZ2.uEr) {
                    o oVar5 = o.ujN;
                    com.tencent.mm.live.core.core.trtc.a aVar = o.hSS;
                    if (aVar != null) {
                        aVar.hAq.aEj();
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/model/FinderLiveService$miniWindowCloseClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(246204);
                    return;
                }
            }
            o.ujN.nn(isTopApplication);
            o oVar6 = o.ujN;
            FinderLiveMiniView finderLiveMiniView = o.ujt;
            if (finderLiveMiniView != null) {
                z = finderLiveMiniView.dMz;
            } else {
                z = false;
            }
            if (!z) {
                com.tencent.mm.plugin.finder.report.live.m.vli.a(s.at.CloseTypeFloat);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/model/FinderLiveService$miniWindowCloseClickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(246204);
        }
    }

    static final class g implements Runnable {
        public static final g ujP = new g();

        static {
            AppMethodBeat.i(246193);
            AppMethodBeat.o(246193);
        }

        g() {
        }

        public final void run() {
            AppMethodBeat.i(246192);
            o oVar = o.ujN;
            o.dgu();
            AppMethodBeat.o(246192);
        }
    }

    static final class j implements Runnable {
        public static final j ujR = new j();

        static {
            AppMethodBeat.i(246197);
            AppMethodBeat.o(246197);
        }

        j() {
        }

        public final void run() {
            AppMethodBeat.i(246196);
            o oVar = o.ujN;
            o.dgv();
            AppMethodBeat.o(246196);
        }
    }

    /* renamed from: com.tencent.mm.plugin.finder.live.model.o$o */
    static final class RunnableC1187o implements Runnable {
        public static final RunnableC1187o ujU = new RunnableC1187o();

        static {
            AppMethodBeat.i(246208);
            AppMethodBeat.o(246208);
        }

        RunnableC1187o() {
        }

        public final void run() {
            AppMethodBeat.i(246207);
            o oVar = o.ujN;
            o.dgw();
            AppMethodBeat.o(246207);
        }
    }

    static final class b implements Runnable {
        public static final b UKD = new b();

        static {
            AppMethodBeat.i(260475);
            AppMethodBeat.o(260475);
        }

        b() {
        }

        public final void run() {
            AppMethodBeat.i(260474);
            o oVar = o.ujN;
            o.hTk();
            AppMethodBeat.o(260474);
        }
    }

    public static final class d implements h.a {
        final /* synthetic */ com.tencent.mm.plugin.finder.live.viewmodel.g UKI;

        d(com.tencent.mm.plugin.finder.live.viewmodel.g gVar) {
            this.UKI = gVar;
        }

        @Override // com.tencent.mm.plugin.finder.live.model.cgi.h.a
        public final void a(int i2, int i3, ass ass, int i4) {
            int i5;
            awe awe;
            Long l;
            awe awe2;
            awe awe3;
            long j2;
            long j3 = 0;
            Long l2 = null;
            AppMethodBeat.i(260483);
            kotlin.g.b.p.h(ass, "resp");
            boolean a2 = o.a(o.ujN, i3, i2, ass, i4);
            o oVar = o.ujN;
            w wVar = o.ujK;
            if (wVar != null) {
                wVar.dgD();
            }
            if (ass.ViE > 0) {
                i5 = ass.ViE * 1000;
            } else if (a2) {
                com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
                i5 = com.tencent.mm.plugin.finder.storage.c.drI().value().intValue();
            } else {
                i5 = 5000;
            }
            if (a2) {
                o oVar2 = o.ujN;
                long j4 = (long) i5;
                awe awe4 = ass.liveInfo;
                if (awe4 != null) {
                    j2 = awe4.liveId;
                } else {
                    j2 = 0;
                }
                o.P(j4, j2);
            } else if (!this.UKI.djl()) {
                StringBuilder sb = new StringBuilder("handleLiveMsgResp result false, will retry heartbeat delay 5000. localLiveId:");
                o oVar3 = o.ujN;
                com.tencent.mm.plugin.finder.live.viewmodel.g dfZ = o.dfZ();
                if (dfZ == null || (awe3 = dfZ.liveInfo) == null) {
                    l = null;
                } else {
                    l = Long.valueOf(awe3.liveId);
                }
                Log.i("Finder.FinderLiveService", sb.append(l).toString());
                o oVar4 = o.ujN;
                long j5 = (long) i5;
                o oVar5 = o.ujN;
                com.tencent.mm.plugin.finder.live.viewmodel.g dfZ2 = o.dfZ();
                if (!(dfZ2 == null || (awe2 = dfZ2.liveInfo) == null)) {
                    j3 = awe2.liveId;
                }
                o.P(j5, j3);
            } else {
                StringBuilder sb2 = new StringBuilder("handleLiveMsgResp result false and live is finished. localLiveId:");
                o oVar6 = o.ujN;
                com.tencent.mm.plugin.finder.live.viewmodel.g dfZ3 = o.dfZ();
                if (!(dfZ3 == null || (awe = dfZ3.liveInfo) == null)) {
                    l2 = Long.valueOf(awe.liveId);
                }
                Log.i("Finder.FinderLiveService", sb2.append(l2).toString());
            }
            Log.i("Finder.FinderLiveService", "heartbeat onCgiBack it.isLiveFinish():" + this.UKI.djl());
            if (!this.UKI.djl()) {
                o oVar7 = o.ujN;
                o.UKA.stopTimer();
                o oVar8 = o.ujN;
                o.UKA.startTimer(10000, 10000);
                AppMethodBeat.o(260483);
                return;
            }
            o oVar9 = o.ujN;
            o.UKA.stopTimer();
            AppMethodBeat.o(260483);
        }
    }

    public static final class e implements i.a {
        e() {
        }

        @Override // com.tencent.mm.plugin.finder.live.model.cgi.i.a
        public final void a(int i2, int i3, String str, auf auf) {
            long j2;
            cjb cjb;
            AppMethodBeat.i(246190);
            kotlin.g.b.p.h(auf, "resp");
            o oVar = o.ujN;
            boolean b2 = o.b(i3, i2, auf);
            o oVar2 = o.ujN;
            w wVar = o.ujL;
            if (wVar != null) {
                wVar.dgD();
            }
            if (b2) {
                o oVar3 = o.ujN;
                com.tencent.mm.plugin.finder.live.viewmodel.g dfZ = o.dfZ();
                if (dfZ == null || (cjb = dfZ.hIv) == null) {
                    j2 = 0;
                } else {
                    j2 = cjb.Mor;
                }
                long aM = kotlin.k.j.aM((j2 - 60) * 1000, Util.MILLSECONDS_OF_MINUTE);
                o oVar4 = o.ujN;
                o.EJ(aM);
            }
            AppMethodBeat.o(246190);
        }
    }

    public static final class f implements u.a {
        f() {
        }

        @Override // com.tencent.mm.plugin.finder.live.model.cgi.u.a
        public final void c(int i2, int i3, awz awz) {
            long j2;
            cjb cjb;
            AppMethodBeat.i(246191);
            kotlin.g.b.p.h(awz, "resp");
            o oVar = o.ujN;
            boolean b2 = o.b(i3, i2, awz);
            o oVar2 = o.ujN;
            w wVar = o.ujM;
            if (wVar != null) {
                wVar.dgD();
            }
            if (b2) {
                o oVar3 = o.ujN;
                com.tencent.mm.plugin.finder.live.viewmodel.g dfZ = o.dfZ();
                if (dfZ == null || (cjb = dfZ.hIv) == null) {
                    j2 = 0;
                } else {
                    j2 = cjb.Mor;
                }
                long aM = kotlin.k.j.aM((j2 - 60) * 1000, Util.MILLSECONDS_OF_MINUTE);
                o oVar4 = o.ujN;
                o.EI(aM);
            }
            AppMethodBeat.o(246191);
        }
    }

    public static final class y implements ad.a {
        y() {
        }

        @Override // com.tencent.mm.plugin.finder.live.model.cgi.ad.a
        public final void a(ffv ffv) {
            boolean z;
            AppMethodBeat.i(260482);
            kotlin.g.b.p.h(ffv, "resp");
            o oVar = o.ujN;
            w wVar = o.UKC;
            if (wVar != null) {
                z = wVar.dgZ;
            } else {
                z = true;
            }
            Log.i("Finder.FinderLiveService", "doActivateMic onCgiBack taskFinished:".concat(String.valueOf(z)));
            if (!z) {
                o oVar2 = o.ujN;
                w wVar2 = o.UKC;
                if (wVar2 != null) {
                    wVar2.dgD();
                }
                o oVar3 = o.ujN;
                o.RJ(20000);
            }
            AppMethodBeat.o(260482);
        }
    }

    private static boolean b(int i2, int i3, ass ass, int i4) {
        awe awe;
        Long l2;
        boolean z2;
        LinkedList<aut> linkedList;
        Long l3;
        Integer num;
        Integer num2;
        com.tencent.mm.live.core.core.trtc.a aVar;
        avs avs;
        com.tencent.mm.bw.b bVar;
        long j2;
        Integer num3;
        aus aus;
        aus aus2;
        aus aus3;
        aut aut;
        byte[] bArr;
        String str;
        String str2;
        FinderContact finderContact;
        FinderContact finderContact2;
        FinderContact finderContact3;
        FinderContact finderContact4;
        FinderContact finderContact5;
        FinderContact finderContact6;
        boolean z3;
        awe awe2;
        awe awe3;
        awe awe4;
        awe awe5;
        AppMethodBeat.i(260486);
        com.tencent.mm.plugin.finder.utils.c cVar = com.tencent.mm.plugin.finder.utils.c.vVc;
        awe awe6 = ass.liveInfo;
        f.a.a(cVar, "liveHeartBeatSvrErr", (awe6 != null ? awe6.liveId : 0) != 0, false, new h(i2, i3), 12);
        com.tencent.mm.plugin.finder.utils.c cVar2 = com.tencent.mm.plugin.finder.utils.c.vVc;
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar = ujz;
        f.a.a(cVar2, "liveHeartBeatLocalErr", ((gVar == null || (awe5 = gVar.liveInfo) == null) ? 0 : awe5.liveId) != 0, false, new i(i2, i3, ass), 12);
        StringBuilder append = new StringBuilder("handleLiveMsgResp errCode:").append(i2).append(" curData:");
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar2 = ujz;
        StringBuilder append2 = append.append((gVar2 == null || (awe4 = gVar2.liveInfo) == null) ? null : Long.valueOf(awe4.liveId)).append(", resp.liveId:");
        awe awe7 = ass.liveInfo;
        Log.i("Finder.FinderLiveService", append2.append(awe7 != null ? Long.valueOf(awe7.liveId) : null).append(",reqVisitorRoleType:").append(i4).toString());
        if (ass != null) {
            awe awe8 = ass.liveInfo;
            if (awe8 != null) {
                l2 = Long.valueOf(awe8.liveId);
            } else {
                l2 = null;
            }
            com.tencent.mm.plugin.finder.live.viewmodel.g gVar3 = ujz;
            if (!(!kotlin.g.b.p.j(l2, (gVar3 == null || (awe3 = gVar3.liveInfo) == null) ? null : Long.valueOf(awe3.liveId)))) {
                awe awe9 = ass.liveInfo;
                if (e(awe9 != null ? Long.valueOf(awe9.liveId) : null)) {
                    StringBuilder sb = new StringBuilder("handleLiveMsgResp invalid live id, curData:");
                    com.tencent.mm.plugin.finder.live.viewmodel.g gVar4 = ujz;
                    StringBuilder append3 = sb.append((gVar4 == null || (awe2 = gVar4.liveInfo) == null) ? null : Long.valueOf(awe2.liveId)).append(", resp.liveId:");
                    awe awe10 = ass.liveInfo;
                    Log.i("Finder.FinderLiveService", append3.append(awe10 != null ? Long.valueOf(awe10.liveId) : null).toString());
                    AppMethodBeat.o(260486);
                    return false;
                }
                com.tencent.mm.plugin.finder.live.viewmodel.g gVar5 = ujz;
                if (gVar5 == null || !gVar5.djl()) {
                    if (i3 == 4 && i2 == -100020) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        EJ(0);
                        AppMethodBeat.o(260486);
                        return false;
                    } else if (i3 == 0 && i2 == 0) {
                        com.tencent.mm.plugin.finder.live.viewmodel.g gVar6 = ujz;
                        if (gVar6 != null) {
                            awe awe11 = ass.liveInfo;
                            if (awe11 != null) {
                                gVar6.UPS = ass.ViF - gVar6.UPT;
                                gVar6.UPT = kotlin.k.j.aM(gVar6.UPT, ass.ViF);
                                gVar6.liveInfo.LDN = awe11.LDN;
                                gVar6.liveInfo.ViH = awe11.ViH;
                                gVar6.liveInfo.uBn = ass.LDA;
                                gVar6.liveInfo.LGS = awe11.LGS;
                                gVar6.uDV = ass.LDH;
                                awe awe12 = ass.liveInfo;
                                if (awe12 != null) {
                                    int i5 = awe12.LGU;
                                    if (!gVar6.uEd) {
                                        if ((i5 & 1) > 0 || (i5 & 2) > 0) {
                                            z3 = true;
                                        } else {
                                            z3 = false;
                                        }
                                        gVar6.uEd = z3;
                                    }
                                }
                            }
                            LinkedList<awq> linkedList2 = ass.FoQ;
                            if (linkedList2 == null) {
                                linkedList2 = new LinkedList<>();
                            }
                            LinkedList<aut> linkedList3 = ass.LDI;
                            if (linkedList3 == null) {
                                linkedList3 = new LinkedList<>();
                            }
                            String aTY = com.tencent.mm.model.z.aTY();
                            String aUg = com.tencent.mm.model.z.aUg();
                            com.tencent.mm.plugin.finder.live.viewmodel.g gVar7 = ujz;
                            if (gVar7 != null) {
                                i iVar = i.uja;
                                i.c(gVar7, linkedList2);
                                i iVar2 = i.uja;
                                i.a(gVar7, linkedList2, linkedList3);
                                i iVar3 = i.uja;
                                i.a(gVar7, linkedList2, linkedList3, ujB, aTY, aUg);
                                i iVar4 = i.uja;
                                i.e(gVar7, linkedList2);
                                i iVar5 = i.uja;
                                i.f(gVar7, linkedList3);
                                i iVar6 = i.uja;
                                i.g(gVar7, linkedList3);
                                i iVar7 = i.uja;
                                i.d(gVar7, linkedList3);
                                Log.i("Finder.FinderLiveService", "handleMsg bulletCommetList.size:" + gVar7.uDt.size() + ", msgList.size:" + gVar7.uDs.size() + ", topMsgList.size:" + gVar7.uDu.size());
                            }
                            LinkedList<aut> linkedList4 = ass.LDI;
                            com.tencent.mm.plugin.finder.live.viewmodel.g gVar8 = ujz;
                            if (gVar8 != null) {
                                a aVar2 = a.uhJ;
                                a.a(gVar8, linkedList4);
                                i iVar8 = i.uja;
                                if (linkedList4 == null) {
                                    linkedList4 = new LinkedList<>();
                                }
                                i.i(gVar8, linkedList4);
                                Log.i("Finder.FinderLiveService", "handleAppMsg giftMsgList.size:" + gVar8.uDw.size());
                            }
                            LinkedList<axl> linkedList5 = ass.LDJ;
                            com.tencent.mm.plugin.finder.live.viewmodel.g gVar9 = ujz;
                            if (gVar9 != null) {
                                a aVar3 = a.uhJ;
                                a.b(gVar9, linkedList5);
                            }
                            LinkedList<aut> linkedList6 = ass.LDI;
                            if (linkedList6 == null) {
                                linkedList = new LinkedList<>();
                            } else {
                                linkedList = linkedList6;
                            }
                            com.tencent.mm.plugin.finder.live.viewmodel.g gVar10 = ujz;
                            if (gVar10 != null) {
                                j(gVar10, linkedList);
                                k(gVar10, linkedList);
                                i iVar9 = i.uja;
                                LinkedList<aut> bP = i.bP(linkedList);
                                if (dMz && (aut = (aut) kotlin.a.j.kt(bP)) != null) {
                                    fgg fgg = new fgg();
                                    fgg fgg2 = fgg;
                                    com.tencent.mm.bw.b bVar2 = aut.LFB;
                                    if (bVar2 != null) {
                                        bArr = bVar2.toByteArray();
                                    } else {
                                        bArr = null;
                                    }
                                    try {
                                        fgg2.parseFrom(bArr);
                                    } catch (Exception e2) {
                                        Log.printDebugStack("safeParser", "", e2);
                                    }
                                    Log.i("Finder.FinderLiveService", "[LinkMicPk]  receive accept pk msg, [applySdkUserId:" + fgg.ViN + ", sessionId:" + aut.session_id + "], curLiveUser:" + gVar10.uEB + "]}");
                                    String str3 = aut.session_id;
                                    if (str3 != null) {
                                        Integer num4 = gVar10.UQc.get(str3);
                                        if (num4 != null && num4.intValue() == 3) {
                                            Log.i("Finder.FinderLiveService", "[LinkMicPk] mic has closed, skip accept!");
                                        } else if (gVar10.djs()) {
                                            Log.i("Finder.FinderLiveService", "[LinkMicPk] anchor is linking mic, skip accept!");
                                        } else if (fgg.seq < gVar10.uEx) {
                                            Log.i("Finder.FinderLiveService", "[LinkMicPk] invalid seq acceptInfo.seq:" + fgg.seq + " liveData.acceptSeq:" + gVar10.uEx + ", skip accept!");
                                        } else {
                                            kotlin.g.b.p.g(str3, "sessionId");
                                            gVar10.UQc.put(str3, 2);
                                            String str4 = fgg.ViP;
                                            avn avn = aut.LFE;
                                            String str5 = (avn == null || (finderContact6 = avn.contact) == null) ? null : finderContact6.headUrl;
                                            avn avn2 = aut.LFE;
                                            String str6 = (avn2 == null || (finderContact5 = avn2.contact) == null) ? null : finderContact5.username;
                                            avn avn3 = aut.LFE;
                                            String str7 = (avn3 == null || (finderContact4 = avn3.contact) == null) ? null : finderContact4.nickname;
                                            String str8 = aut.session_id;
                                            com.tencent.mm.bw.b bVar3 = fgg.ViR;
                                            int i6 = fgg.ViQ;
                                            avn avn4 = aut.LFE;
                                            gVar10.uEB = new com.tencent.mm.plugin.finder.live.viewmodel.e(str4, str5, str6, str7, 2, str8, bVar3, true, i6, (avn4 == null || (finderContact3 = avn4.contact) == null) ? null : finderContact3.authInfo, null, 0, 0, 7168);
                                            Log.i("Finder.FinderLiveService", "[LinkMicPk] receive accept pk msg, curLinkMicUser is me");
                                            Log.i("Finder.FinderLiveService", "checkAcceptMicType micType:2");
                                            gVar10.uEC = 4;
                                            gVar10.uEx = fgg.seq;
                                            StringBuilder append4 = new StringBuilder("[LinkMicPk] receive accept msg:[isAnchor:").append(dMz).append(", username:");
                                            avn avn5 = aut.LFE;
                                            if (avn5 == null || (finderContact2 = avn5.contact) == null) {
                                                str = null;
                                            } else {
                                                str = finderContact2.username;
                                            }
                                            StringBuilder append5 = append4.append(str).append(", nickname:");
                                            avn avn6 = aut.LFE;
                                            if (avn6 == null || (finderContact = avn6.contact) == null) {
                                                str2 = null;
                                            } else {
                                                str2 = finderContact.nickname;
                                            }
                                            Log.i("Finder.FinderLiveService", append5.append(str2).append(", sdkUerId:").append(fgg.ViP).append(", sdkLiveId:").append(fgg.ViQ).append(" sessionId:").append(aut.session_id).append(']').toString());
                                            RJ(0);
                                            com.tencent.mm.live.b.s sVar = com.tencent.mm.live.b.s.hIl;
                                            com.tencent.mm.live.b.j aGe = com.tencent.mm.live.b.s.aGe();
                                            if (aGe != null) {
                                                long j3 = gVar10.liveInfo.liveId;
                                                String str9 = aut.session_id;
                                                String str10 = fgg.ViP;
                                                int hUb = gVar10.hUb();
                                                int i7 = fgg.ViQ;
                                                long j4 = fgg.seq;
                                                com.tencent.mm.bw.b bVar4 = fgg.ViR;
                                                aGe.onAcceptLiveMic(new com.tencent.mm.live.b.a(j3, str9, str10, hUb, 0, i7, "", "", 0, "", 2, j4, bVar4 != null ? bVar4.yO() : null, true));
                                            }
                                        }
                                    }
                                }
                                Log.i("Finder.FinderLiveService", "[LinkMicPk] acceptMicMsgPkList:" + bP.size() + " isAnchor:" + dMz);
                                l(gVar10, linkedList);
                                m(gVar10, linkedList);
                            }
                            com.tencent.mm.bw.b bVar5 = ass.LDx;
                            if (bVar5 != null) {
                                com.tencent.mm.plugin.finder.live.viewmodel.g gVar11 = ujz;
                                Integer valueOf = (gVar11 == null || (aus3 = gVar11.UQh) == null) ? null : Integer.valueOf(aus3.LFy);
                                if (valueOf == null || i4 == valueOf.intValue()) {
                                    kotlin.g.b.p.g(bVar5, "cookies");
                                    gVar6.hIt = bVar5.zy;
                                } else {
                                    StringBuilder sb2 = new StringBuilder("getLiveMsg wrong roleType:");
                                    com.tencent.mm.plugin.finder.live.viewmodel.g gVar12 = ujz;
                                    Log.i("Finder.FinderLiveService", sb2.append((gVar12 == null || (aus2 = gVar12.UQh) == null) ? null : Integer.valueOf(aus2.LFy)).toString());
                                }
                                com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
                                StringBuilder sb3 = new StringBuilder("getLiveMsg roleType:");
                                com.tencent.mm.plugin.finder.live.viewmodel.g gVar13 = ujz;
                                if (gVar13 == null || (aus = gVar13.UQh) == null) {
                                    num3 = null;
                                } else {
                                    num3 = Integer.valueOf(aus.LFy);
                                }
                                com.tencent.mm.plugin.finder.utils.m.hd("Finder.FinderLiveService", sb3.append(num3).append(" write liveCookies to:").append(Util.encodeHexString(gVar6.hIt)).toString());
                            }
                            awe awe13 = ass.liveInfo;
                            if (!(awe13 == null || (avs = awe13.LGR) == null || (bVar = avs.LGq) == null)) {
                                ciq ciq = new ciq();
                                kotlin.g.b.p.g(bVar, LocaleUtil.ITALIAN);
                                try {
                                    ciq.parseFrom(bVar.zy);
                                } catch (Exception e3) {
                                    Log.printDebugStack("safeParser", "", e3);
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
                            LinkedList<awq> linkedList7 = ass.FoQ;
                            kotlin.g.b.p.g(linkedList7, "it.msgList");
                            gVar6.aq(linkedList7);
                            com.tencent.mm.live.b.m mVar2 = com.tencent.mm.live.b.m.hGg;
                            com.tencent.mm.live.b.m.aFe();
                            boolean z4 = ass.LDC == 1;
                            if (z4) {
                                Log.i("Finder.FinderLiveService", "get live msg close live!");
                                gVar6.nB(true);
                                com.tencent.mm.live.core.core.trtc.a aVar4 = hSS;
                                if (aVar4 != null) {
                                    aVar4.a(com.tencent.mm.live.core.mini.d.STATE_FINISH);
                                }
                                com.tencent.mm.live.b.s sVar2 = com.tencent.mm.live.b.s.hIl;
                                com.tencent.mm.live.b.j aGe2 = com.tencent.mm.live.b.s.aGe();
                                if (aGe2 != null) {
                                    aGe2.onCloseLive(new com.tencent.mm.live.b.e(gVar6.liveInfo.liveId));
                                }
                            }
                            if (!z4) {
                                if (dMz && gVar6.uEU) {
                                    com.tencent.mm.live.core.core.trtc.a.a aDC = com.tencent.mm.live.core.core.trtc.a.a.aDC();
                                    kotlin.g.b.p.g(aDC, "ConfigHelper.getInstance()");
                                    String Lb = aDC.aDD().Lb();
                                    awl awl = gVar6.liveInfo.LGS;
                                    a(awl != null ? awl.LHh : null);
                                    com.tencent.mm.live.core.core.trtc.a.a aDC2 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
                                    kotlin.g.b.p.g(aDC2, "ConfigHelper.getInstance()");
                                    String Lb2 = aDC2.aDD().Lb();
                                    if (!Util.isEqual(Lb, Lb2) && (aVar = hSS) != null) {
                                        aVar.aDy();
                                    }
                                    Log.i("Finder.FinderLiveService", "check update sdk param while heartbeating, beforeKey:" + Lb + " afterKey:" + Lb2);
                                }
                                if (gVar6.uDU != ass.LDF) {
                                    Log.i("Finder.FinderLiveService", "[heartbeat] checkAnchorAlive isAnchor:" + dMz + " localLiveExtFlag:" + gVar6.uDU + " liveExtFlag:" + ass.LDF);
                                    if (!dMz) {
                                        if (!Ji(gVar6.uDU) && Ji(ass.LDF)) {
                                            Log.i("Finder.FinderLiveService", "[heartbeat] checkAnchorAlive anchor alive expired:true");
                                            com.tencent.mm.live.b.s sVar3 = com.tencent.mm.live.b.s.hIl;
                                            com.tencent.mm.live.b.j aGe3 = com.tencent.mm.live.b.s.aGe();
                                            if (aGe3 != null) {
                                                aGe3.onAnchorConnectionChange(false);
                                            }
                                        } else if (Ji(gVar6.uDU) && !Ji(ass.LDF)) {
                                            Log.i("Finder.FinderLiveService", "[heartbeat] checkAnchorAlive anchor alive expired:false");
                                            com.tencent.mm.live.b.s sVar4 = com.tencent.mm.live.b.s.hIl;
                                            com.tencent.mm.live.b.j aGe4 = com.tencent.mm.live.b.s.aGe();
                                            if (aGe4 != null) {
                                                aGe4.onAnchorConnectionChange(true);
                                            }
                                        }
                                    }
                                    Log.i("Finder.FinderLiveService", "[heartbeat] checkLinkMicEnable isAnchor:" + dMz + " localLiveExtFlag:" + gVar6.uDU + " liveExtFlag:" + ass.LDF + " localEnableLinkMicFun:" + gVar6.uEG + " localEnableLinkMic:" + gVar6.diZ() + " localEnableLinkMicAntispam:" + gVar6.uEH);
                                    if (dMz) {
                                        if (!com.tencent.mm.ac.d.cW(ass.LDF, 4)) {
                                            Log.i("Finder.FinderLiveService", "[heartbeat] checkLinkMicEnable disableLinkMic");
                                            gVar6.uEH = false;
                                            gVar6.uEE = 0;
                                            gVar6.uDA &= -65;
                                            s sVar5 = ujx;
                                            if (sVar5 != null) {
                                                s.a.a(sVar5, gVar6.liveInfo.liveId, gVar6.hFK, gVar6.uDA);
                                            }
                                        } else {
                                            gVar6.uEH = true;
                                        }
                                    } else if (!com.tencent.mm.ac.d.cW(ass.LDF, 4)) {
                                        Log.i("Finder.FinderLiveService", "[heartbeat] checkLinkMicEnable disableLinkMic");
                                        gVar6.uEG = false;
                                        gVar6.uDA &= -65;
                                        gVar6.uEE = 0;
                                    }
                                    Log.i("Finder.FinderLiveService", "[heartbeat] checkGiftEnable isAnchor:" + dMz + " localLiveExtFlag:" + gVar6.uDU + " liveExtFlag:" + ass.LDF + " localEnableGiftFun:" + gVar6.uEJ + " localEnableGift:" + gVar6.dja() + " localEnableGiftAntispam:" + gVar6.uEL);
                                    if (dMz) {
                                        if (!com.tencent.mm.ac.d.cW(ass.LDF, 2)) {
                                            Log.i("Finder.FinderLiveService", "[heartbeat] checkGiftEnable disableGift");
                                            gVar6.uEL = false;
                                            gVar6.uEI = 0;
                                            gVar6.uDA &= -129;
                                            s sVar6 = ujx;
                                            if (sVar6 != null) {
                                                s.a.a(sVar6, gVar6.liveInfo.liveId, gVar6.hFK, gVar6.uDA);
                                            }
                                        } else {
                                            gVar6.uEL = true;
                                        }
                                    } else if (!com.tencent.mm.ac.d.cW(ass.LDF, 2)) {
                                        Log.i("Finder.FinderLiveService", "[heartbeat] checkGiftEnable disableGift");
                                        gVar6.uEJ = false;
                                        gVar6.uDA &= -129;
                                        gVar6.uEI = 0;
                                    }
                                    gVar6.uDU = ass.LDF;
                                }
                            }
                            gVar6.a(ass.LDK);
                            StringBuilder append6 = new StringBuilder("cur liveId:").append(gVar6.liveInfo.liveId).append(",remote liveId:");
                            awe awe14 = ass.liveInfo;
                            if (awe14 != null) {
                                l3 = Long.valueOf(awe14.liveId);
                            } else {
                                l3 = null;
                            }
                            StringBuilder append7 = append6.append(l3).append(",likeCnt:").append(gVar6.liveInfo.wBG).append(", remoteLikeCnt:");
                            awe awe15 = ass.liveInfo;
                            if (awe15 != null) {
                                num = Integer.valueOf(awe15.wBG);
                            } else {
                                num = null;
                            }
                            StringBuilder append8 = append7.append(num).append(", onlineCount:").append(gVar6.liveInfo.uBn).append(",reward_total_amount_in_heat:").append(gVar6.liveInfo.LDN).append(", remoteMsgSize:");
                            LinkedList<awq> linkedList8 = ass.FoQ;
                            if (linkedList8 != null) {
                                num2 = Integer.valueOf(linkedList8.size());
                            } else {
                                num2 = null;
                            }
                            Log.i("Finder.FinderLiveService", append8.append(num2).append(", msgSize:").append(gVar6.uDs.size()).append(", remoteExtFlag:").append(ass.LDF).append(", participantCnt:").append(ass.LDH).append(", qosControl:").append(gVar6.uEU).append(", localExtFlag").append(gVar6.uDU).append(",heat_value:").append(gVar6.liveInfo.ViH).toString());
                        }
                        AppMethodBeat.o(260486);
                        return true;
                    } else {
                        switch (i2) {
                            case -200001:
                                q qVar = q.ukd;
                                q.dgB();
                                break;
                        }
                        AppMethodBeat.o(260486);
                        return false;
                    }
                } else {
                    Log.i("Finder.FinderLiveService", "handleLiveMsgResp live has finished");
                    AppMethodBeat.o(260486);
                    return false;
                }
            }
        }
        StringBuilder sb4 = new StringBuilder("handleLiveMsgResp invalid live resp, curData:");
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar14 = ujz;
        StringBuilder append9 = sb4.append((gVar14 == null || (awe = gVar14.liveInfo) == null) ? null : Long.valueOf(awe.liveId)).append(", resp.liveId:");
        awe awe16 = ass.liveInfo;
        Log.i("Finder.FinderLiveService", append9.append(awe16 != null ? Long.valueOf(awe16.liveId) : null).toString());
        AppMethodBeat.o(260486);
        return false;
    }

    private static boolean a(int i2, int i3, awz awz) {
        cjb cjb;
        com.tencent.mm.live.core.core.b.f fVar;
        TRTCCloudDef.TRTCParams tRTCParams;
        awe awe;
        AppMethodBeat.i(246219);
        StringBuilder append = new StringBuilder("handleRefreshMicResp errCode:").append(i2).append(", errType:").append(i3).append(", curData:");
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar = ujz;
        Log.i("Finder.FinderLiveService", append.append((gVar == null || (awe = gVar.liveInfo) == null) ? null : Long.valueOf(awe.liveId)).toString());
        boolean z2 = false;
        if (i3 == 0 && i2 == 0 && (cjb = awz.LFH) != null) {
            com.tencent.mm.plugin.finder.live.viewmodel.g gVar2 = ujz;
            if (gVar2 != null) {
                gVar2.a(cjb);
            }
            Log.i("Finder.FinderLiveService", "handleRefreshMicResp updatePrivateMapKey");
            b.a aVar = com.tencent.mm.live.core.core.a.b.hyv;
            if (b.a.aDp()) {
                b.a aVar2 = com.tencent.mm.live.core.core.a.b.hyv;
                MMApplicationContext.getContext();
                com.tencent.mm.live.core.core.a.b aDo = b.a.aDo();
                String yO = cjb.Mon.yO();
                kotlin.g.b.p.g(yO, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
                aDo.Go(yO);
            } else {
                a.C0381a aVar3 = com.tencent.mm.live.core.core.c.a.hAj;
                if (a.C0381a.aDp()) {
                    a.C0381a aVar4 = com.tencent.mm.live.core.core.c.a.hAj;
                    MMApplicationContext.getContext();
                    com.tencent.mm.live.core.core.c.a aDw = a.C0381a.aDw();
                    String yO2 = cjb.Mon.yO();
                    kotlin.g.b.p.g(yO2, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
                    aDw.Go(yO2);
                } else {
                    b.a aVar5 = com.tencent.mm.live.core.core.d.b.hCo;
                    if (b.a.aDp()) {
                        b.a aVar6 = com.tencent.mm.live.core.core.d.b.hCo;
                        MMApplicationContext.getContext();
                        com.tencent.mm.live.core.core.d.b aEf = b.a.aEf();
                        String yO3 = cjb.Mon.yO();
                        kotlin.g.b.p.g(yO3, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
                        aEf.Go(yO3);
                    }
                }
            }
            com.tencent.mm.plugin.finder.live.viewmodel.g gVar3 = ujz;
            if (!(gVar3 == null || (fVar = gVar3.hIy) == null || (tRTCParams = fVar.hzu) == null)) {
                tRTCParams.privateMapKey = cjb.Mon.yO();
            }
            b(cjb);
            z2 = true;
        }
        AppMethodBeat.o(246219);
        return z2;
    }

    private static boolean a(int i2, int i3, auf auf) {
        boolean z2;
        Long l2;
        com.tencent.mm.live.core.core.b.f fVar;
        TRTCCloudDef.TRTCParams tRTCParams;
        byte[] bArr;
        awe awe;
        awe awe2;
        awe awe3;
        long j2 = 0;
        byte[] bArr2 = null;
        Long l3 = null;
        AppMethodBeat.i(246220);
        StringBuilder append = new StringBuilder("handleKeepAliveResp errCode:").append(i2).append(", errType:").append(i3).append(", curData:");
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar = ujz;
        StringBuilder append2 = append.append((gVar == null || (awe3 = gVar.liveInfo) == null) ? null : Long.valueOf(awe3.liveId)).append(", resp.liveId:");
        awe awe4 = auf.liveInfo;
        Log.i("Finder.FinderLiveService", append2.append(awe4 != null ? Long.valueOf(awe4.liveId) : null).toString());
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
            Log.i("Finder.FinderLiveService", "handleKeepAliveResp live has finished");
            z2 = false;
        } else if (i3 != 0 || i2 != 0) {
            Log.i("Finder.FinderLiveService", "handleKeepAliveResp launch live room failed");
            z2 = false;
        } else if (auf == null) {
            Log.i("Finder.FinderLiveService", "handleKeepAliveResp invalid live resp");
            z2 = false;
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
                Log.i("Finder.FinderLiveService", append3.append(l3).toString());
                z2 = false;
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
                    Log.i("Finder.FinderLiveService", "doKeepAlive updatePrivateMapKey");
                    b.a aVar2 = com.tencent.mm.live.core.core.a.b.hyv;
                    if (b.a.aDp()) {
                        b.a aVar3 = com.tencent.mm.live.core.core.a.b.hyv;
                        MMApplicationContext.getContext();
                        com.tencent.mm.live.core.core.a.b aDo = b.a.aDo();
                        String yO = cjb.Mon.yO();
                        kotlin.g.b.p.g(yO, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
                        aDo.Go(yO);
                    } else {
                        a.C0381a aVar4 = com.tencent.mm.live.core.core.c.a.hAj;
                        if (a.C0381a.aDp()) {
                            a.C0381a aVar5 = com.tencent.mm.live.core.core.c.a.hAj;
                            MMApplicationContext.getContext();
                            com.tencent.mm.live.core.core.c.a aDw = a.C0381a.aDw();
                            String yO2 = cjb.Mon.yO();
                            kotlin.g.b.p.g(yO2, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
                            aDw.Go(yO2);
                        } else {
                            b.a aVar6 = com.tencent.mm.live.core.core.d.b.hCo;
                            if (b.a.aDp()) {
                                b.a aVar7 = com.tencent.mm.live.core.core.d.b.hCo;
                                MMApplicationContext.getContext();
                                com.tencent.mm.live.core.core.d.b aEf = b.a.aEf();
                                String yO3 = cjb.Mon.yO();
                                kotlin.g.b.p.g(yO3, "liveSdkInfo.sdk_private_map_key.toStringUtf8()");
                                aEf.Go(yO3);
                            }
                        }
                    }
                    com.tencent.mm.plugin.finder.live.viewmodel.g gVar6 = ujz;
                    if (gVar6 != null) {
                        com.tencent.mm.bw.b bVar = auf.LDx;
                        if (bVar != null) {
                            bArr = bVar.zy;
                        } else {
                            bArr = null;
                        }
                        gVar6.hIt = bArr;
                    }
                    com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
                    StringBuilder sb2 = new StringBuilder("KeepAlive write liveCookies to:");
                    com.tencent.mm.plugin.finder.live.viewmodel.g gVar7 = ujz;
                    if (gVar7 != null) {
                        bArr2 = gVar7.hIt;
                    }
                    com.tencent.mm.plugin.finder.utils.m.hd("Finder.FinderLiveService", sb2.append(Util.encodeHexString(bArr2)).toString());
                    com.tencent.mm.plugin.finder.live.viewmodel.g gVar8 = ujz;
                    if (!(gVar8 == null || (fVar = gVar8.hIy) == null || (tRTCParams = fVar.hzu) == null)) {
                        tRTCParams.privateMapKey = cjb.Mon.yO();
                    }
                    b(cjb);
                    if (hSS instanceof com.tencent.mm.live.core.core.a.b) {
                        com.tencent.mm.live.core.core.trtc.a aVar8 = hSS;
                        if (aVar8 == null) {
                            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.live.core.core.anchor.LiveAnchorTRTCCore");
                            AppMethodBeat.o(246220);
                            throw tVar;
                        }
                        ((com.tencent.mm.live.core.core.a.b) aVar8).ew(dgl());
                    }
                    z2 = true;
                } else {
                    z2 = false;
                }
            }
        }
        AppMethodBeat.o(246220);
        return z2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00d6, code lost:
        if (r0 != r1.aDR()) goto L_0x00d8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void b(com.tencent.mm.protocal.protobuf.cjb r6) {
        /*
        // Method dump skipped, instructions count: 247
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.model.o.b(com.tencent.mm.protocal.protobuf.cjb):void");
    }

    private static void a(cjd cjd) {
        AppMethodBeat.i(246222);
        if (cjd != null) {
            if (cjd.Mow > 0) {
                com.tencent.mm.live.core.core.trtc.a.a aDC = com.tencent.mm.live.core.core.trtc.a.a.aDC();
                kotlin.g.b.p.g(aDC, "ConfigHelper.getInstance()");
                com.tencent.mm.live.core.core.trtc.a.a.d aDD = aDC.aDD();
                kotlin.g.b.p.g(aDD, "ConfigHelper.getInstance().videoConfig");
                aDD.setVideoResolution(cjd.Mow);
            }
            if (cjd.Moy > 0) {
                com.tencent.mm.live.core.core.trtc.a.a aDC2 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
                kotlin.g.b.p.g(aDC2, "ConfigHelper.getInstance()");
                com.tencent.mm.live.core.core.trtc.a.a.d aDD2 = aDC2.aDD();
                kotlin.g.b.p.g(aDD2, "ConfigHelper.getInstance().videoConfig");
                aDD2.qu(cjd.Moy);
            }
            if (cjd.Moz > 0) {
                com.tencent.mm.live.core.core.trtc.a.a aDC3 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
                kotlin.g.b.p.g(aDC3, "ConfigHelper.getInstance()");
                com.tencent.mm.live.core.core.trtc.a.a.d aDD3 = aDC3.aDD();
                kotlin.g.b.p.g(aDD3, "ConfigHelper.getInstance().videoConfig");
                aDD3.setVideoBitrate(cjd.Moz);
            }
            if (cjd.VjP > 0) {
                com.tencent.mm.live.core.core.trtc.a.a aDC4 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
                kotlin.g.b.p.g(aDC4, "ConfigHelper.getInstance()");
                com.tencent.mm.live.core.core.trtc.a.a.d aDD4 = aDC4.aDD();
                kotlin.g.b.p.g(aDD4, "ConfigHelper.getInstance().videoConfig");
                aDD4.setMinVideoBitrate(cjd.VjP);
            }
            if (cjd.VjR > 0) {
                com.tencent.mm.live.core.core.trtc.a.a aDC5 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
                kotlin.g.b.p.g(aDC5, "ConfigHelper.getInstance()");
                com.tencent.mm.live.core.core.trtc.a.a.d aDD5 = aDC5.aDD();
                kotlin.g.b.p.g(aDD5, "ConfigHelper.getInstance().videoConfig");
                aDD5.aws(cjd.VjR);
            }
            if (cjd.VjS > 0) {
                com.tencent.mm.live.core.core.trtc.a.a aDC6 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
                kotlin.g.b.p.g(aDC6, "ConfigHelper.getInstance()");
                com.tencent.mm.live.core.core.trtc.a.a.d aDD6 = aDC6.aDD();
                kotlin.g.b.p.g(aDD6, "ConfigHelper.getInstance().videoConfig");
                aDD6.awt(cjd.VjS);
            }
            if (cjd.VjT > 0) {
                com.tencent.mm.live.core.core.trtc.a.a aDC7 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
                kotlin.g.b.p.g(aDC7, "ConfigHelper.getInstance()");
                com.tencent.mm.live.core.core.trtc.a.a.d aDD7 = aDC7.aDD();
                kotlin.g.b.p.g(aDD7, "ConfigHelper.getInstance().videoConfig");
                aDD7.awu(cjd.VjT);
            }
            if (cjd.VjU > 0) {
                com.tencent.mm.live.core.core.trtc.a.a aDC8 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
                kotlin.g.b.p.g(aDC8, "ConfigHelper.getInstance()");
                com.tencent.mm.live.core.core.trtc.a.a.d aDD8 = aDC8.aDD();
                kotlin.g.b.p.g(aDD8, "ConfigHelper.getInstance().videoConfig");
                aDD8.awv(cjd.VjU);
            }
            if (cjd.MoB > 0) {
                com.tencent.mm.live.core.core.trtc.a.a aDC9 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
                kotlin.g.b.p.g(aDC9, "ConfigHelper.getInstance()");
                com.tencent.mm.live.core.core.trtc.a.a.d aDD9 = aDC9.aDD();
                kotlin.g.b.p.g(aDD9, "ConfigHelper.getInstance().videoConfig");
                aDD9.qv(cjd.MoB);
            }
            int i2 = cjd.MoC;
            if (i2 >= 0 && 1 >= i2) {
                com.tencent.mm.live.core.core.trtc.a.a aDC10 = com.tencent.mm.live.core.core.trtc.a.a.aDC();
                kotlin.g.b.p.g(aDC10, "ConfigHelper.getInstance()");
                com.tencent.mm.live.core.core.trtc.a.a.d aDD10 = aDC10.aDD();
                kotlin.g.b.p.g(aDD10, "ConfigHelper.getInstance().videoConfig");
                aDD10.qt(cjd.MoC);
            }
            Log.i("Finder.FinderLiveService", "processLiveVideoSdkParam encResEnum:" + cjd.Mow + ", capFps:" + cjd.Moy + ", encBR:" + cjd.Moz + ", qosPreferneceEnum:" + cjd.MoB + ", qosControlModeEnum:" + cjd.MoC);
            AppMethodBeat.o(246222);
            return;
        }
        AppMethodBeat.o(246222);
    }

    private static void a(ciz ciz) {
        AppMethodBeat.i(246223);
        if (ciz != null) {
            if (ciz.MnT > 0) {
                com.tencent.mm.live.core.core.trtc.a.a aDC = com.tencent.mm.live.core.core.trtc.a.a.aDC();
                kotlin.g.b.p.g(aDC, "ConfigHelper.getInstance()");
                com.tencent.mm.live.core.core.trtc.a.a.a aDE = aDC.aDE();
                kotlin.g.b.p.g(aDE, "ConfigHelper.getInstance().audioConfig");
                aDE.setAudioQuality(ciz.MnT);
            }
            Log.i("Finder.FinderLiveService", "processLiveAudioSdkParam audioQuality:" + ciz.MnT);
            AppMethodBeat.o(246223);
            return;
        }
        AppMethodBeat.o(246223);
    }

    private static void a(cjc cjc, TRTCCloudDef.TRTCParams tRTCParams, com.tencent.mm.live.core.core.b.e eVar) {
        AppMethodBeat.i(246224);
        a(cjc.Mot);
        a(cjc.Mou);
        cja cja = cjc.Mov;
        if (!(cja == null || tRTCParams == null || eVar == null)) {
            Log.i("Finder.FinderLiveService", "userDefineRecordId:" + cja.MnU);
            String str = cja.MnV;
            String str2 = cja.MnU;
            int i2 = cja.Moe;
            if (!com.tencent.mm.modelcontrol.e.sX(5) && i2 == com.tencent.mm.live.core.core.a.CDN_QUALITY_HEVC.value) {
                i2 = cja.Mof;
            }
            eVar.hzr = cja.Mof;
            if (i2 < 100) {
                eVar.a(com.tencent.mm.live.core.core.b.a.MMLiveStreamSwitchMode_Fixed);
                eVar.hzq = i2;
            } else if (i2 == com.tencent.mm.live.core.core.a.CDN_QUALITY_AUTO_CLIQOS.value) {
                eVar.a(com.tencent.mm.live.core.core.b.a.MMLiveStreamSwitchMode_Auto);
            } else if (i2 == com.tencent.mm.live.core.core.a.CDN_QUALITY_AUTO_SVRML.value) {
                eVar.a(com.tencent.mm.live.core.core.b.a.MMLiveStreamSwitchMode_ML);
            }
            LinkedList<vh> linkedList = cja.Moa;
            if (!(linkedList == null || linkedList.isEmpty())) {
                LinkedList<vh> linkedList2 = cja.Moa;
                kotlin.g.b.p.g(linkedList2, "channelParams.cdn_trans_info");
                for (T t2 : linkedList2) {
                    Integer valueOf = Integer.valueOf(t2.LfB);
                    String str3 = t2.url;
                    kotlin.g.b.p.g(str3, "it.url");
                    eVar.hzs.put(valueOf, str3);
                }
            }
            if (!Util.isNullOrNil(str) || !Util.isNullOrNil(str2)) {
                com.tencent.mm.ab.i iVar = new com.tencent.mm.ab.i();
                if (!Util.isNullOrNil(str)) {
                    iVar.h("userdefine_streamid_main", str);
                }
                if (!Util.isNullOrNil(str2)) {
                    iVar.h("userdefine_record_id", str2);
                }
                com.tencent.mm.ab.i iVar2 = new com.tencent.mm.ab.i();
                iVar2.h("Str_uc_params", iVar);
                tRTCParams.businessInfo = iVar2.toString();
            }
            Log.i("Finder.FinderLiveService", "processLiveSdkParams cdnQualitySvrcfg" + eVar.hzq + " cdnSwitchMode:" + eVar.hzp + " cdn_quality_h265backcfg:" + eVar.hzr);
        }
        AppMethodBeat.o(246224);
    }

    private static boolean Ji(int i2) {
        AppMethodBeat.i(246225);
        if (i2 == -1 || !com.tencent.mm.ac.d.cW(i2, 1)) {
            AppMethodBeat.o(246225);
            return false;
        }
        AppMethodBeat.o(246225);
        return true;
    }

    public static void P(long j2, long j3) {
        awe awe;
        w wVar;
        awe awe2;
        AppMethodBeat.i(246226);
        StringBuilder append = new StringBuilder("heartBeat liveId:").append(j3).append(" delay:").append(j2).append(" curLive:");
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar = ujz;
        Log.i("Finder.FinderLiveService", append.append((gVar == null || (awe2 = gVar.liveInfo) == null) ? null : Long.valueOf(awe2.liveId)).append(" liveId:").append(j3).toString());
        if (j3 > 0) {
            com.tencent.mm.plugin.finder.live.viewmodel.g gVar2 = ujz;
            if (gVar2 == null || (awe = gVar2.liveInfo) == null) {
                AppMethodBeat.o(246226);
                return;
            } else if (awe.liveId == j3 && (wVar = ujK) != null) {
                wVar.f(Long.valueOf(j2));
                AppMethodBeat.o(246226);
                return;
            }
        }
        AppMethodBeat.o(246226);
    }

    public static void a(b.c cVar, Bundle bundle, long j2) {
        Long l2;
        Integer num;
        Integer num2;
        boolean z2;
        String str;
        bo boVar;
        awe awe;
        awe awe2;
        boolean z3 = false;
        Object obj = null;
        AppMethodBeat.i(246227);
        kotlin.g.b.p.h(cVar, "event");
        StringBuilder append = new StringBuilder("transferState before event:").append(cVar).append(" curLive:");
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar = ujz;
        if (gVar == null || (awe2 = gVar.liveInfo) == null) {
            l2 = null;
        } else {
            l2 = Long.valueOf(awe2.liveId);
        }
        StringBuilder append2 = append.append(l2).append(" liveState:");
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar2 = ujz;
        if (gVar2 != null) {
            num = Integer.valueOf(gVar2.uEg);
        } else {
            num = null;
        }
        StringBuilder append3 = append2.append(num).append(" uiState:");
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar3 = ujz;
        if (gVar3 != null) {
            num2 = Integer.valueOf(gVar3.uEf);
        } else {
            num2 = null;
        }
        Log.i("Finder.FinderLiveService", append3.append(num2).toString());
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar4 = ujz;
        if (gVar4 == null) {
            AppMethodBeat.o(246227);
        } else if (j2 != gVar4.liveInfo.liveId) {
            Log.w("Finder.FinderLiveService", "invalid liveId:" + j2 + ", ignore...");
            AppMethodBeat.o(246227);
        } else {
            gVar4.UPU = gVar4.uEg;
            switch (p.$EnumSwitchMapping$0[cVar.ordinal()]) {
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
                    if (!com.tencent.mm.ac.d.cW(gVar4.uEf, 32)) {
                        if (dMz) {
                            gVar4.uEg = 3;
                            gVar4.uEf = 1;
                        } else {
                            gVar4.uEg = 2;
                            gVar4.uEf = 1;
                        }
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
                        gVar4.uEg = 3;
                        break;
                    }
                case 16:
                    if (gVar4.isLiveStarted()) {
                        if (bundle != null) {
                            obj = Boolean.valueOf(bundle.getBoolean("PARAM_IS_ENTERING_COMMENT", false));
                        }
                        if (!kotlin.g.b.p.j(obj, Boolean.TRUE)) {
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
                        z3 = finderLiveMiniView.dMz;
                    }
                    if (!z3) {
                        com.tencent.mm.plugin.finder.report.live.m.a(com.tencent.mm.plugin.finder.report.live.m.vli, s.au.CommerceActionShoppingButtonClick, (String) null, (String) null);
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
                                com.tencent.mm.plugin.finder.live.viewmodel.g gVar7 = ujz;
                                jSONObject.put("productid", (gVar7 == null || (boVar = gVar7.UPW) == null) ? "" : Long.valueOf(boVar.lT()));
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
                        z2 = finderLiveMiniView2.dMz;
                    } else {
                        z2 = false;
                    }
                    if (!z2) {
                        com.tencent.mm.plugin.finder.report.live.m.a(com.tencent.mm.plugin.finder.report.live.m.vli, s.au.CommerceActionExitHalfPage, (String) null, (String) null);
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
            Log.i("Finder.FinderLiveService", "transferState after  event:" + cVar + " liveState:" + gVar4.uEg + " uiState:" + gVar4.uEf);
            AppMethodBeat.o(246227);
        }
    }

    private static void dgf() {
        AppMethodBeat.i(246228);
        ujK = new w("heartBeatLooper", hIe, 2);
        ujL = new w("keepLiveLooper", hId, 2);
        ujM = new w("refreshMicLooper", ujJ, 2);
        UKC = new w("activateMicLooper", UKB, 2);
        AppMethodBeat.o(246228);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x01e1  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x01f4  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0207  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x021a  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x022d  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0240  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0253  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x02b1  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x03e8 A[LOOP:0: B:69:0x03e2->B:71:0x03e8, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0442  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0445  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0448  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x044b  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x044e  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0451  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0454  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0457  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void dgg() {
        /*
        // Method dump skipped, instructions count: 1127
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.model.o.dgg():void");
    }

    public static /* synthetic */ void dgh() {
        AppMethodBeat.i(246231);
        EI(0);
        AppMethodBeat.o(246231);
    }

    public static void EI(long j2) {
        Long l2;
        awe awe;
        com.tencent.mm.plugin.finder.live.viewmodel.e eVar = null;
        AppMethodBeat.i(246230);
        StringBuilder append = new StringBuilder("refreshMic delay:").append(j2).append(" curLive:");
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar = ujz;
        if (gVar == null || (awe = gVar.liveInfo) == null) {
            l2 = null;
        } else {
            l2 = Long.valueOf(awe.liveId);
        }
        StringBuilder append2 = append.append(l2).append(" curLinkUser:");
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar2 = ujz;
        if (gVar2 != null) {
            eVar = gVar2.uEB;
        }
        Log.i("Finder.FinderLiveService", append2.append(eVar).toString());
        w wVar = ujM;
        if (wVar != null) {
            wVar.f(Long.valueOf(j2));
            AppMethodBeat.o(246230);
            return;
        }
        AppMethodBeat.o(246230);
    }

    public static void dgi() {
        Long l2;
        awe awe;
        com.tencent.mm.plugin.finder.live.viewmodel.e eVar = null;
        AppMethodBeat.i(246232);
        StringBuilder sb = new StringBuilder("stopRefreshMic curLive:");
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar = ujz;
        if (gVar == null || (awe = gVar.liveInfo) == null) {
            l2 = null;
        } else {
            l2 = Long.valueOf(awe.liveId);
        }
        StringBuilder append = sb.append(l2).append(" curLinkUser:");
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar2 = ujz;
        if (gVar2 != null) {
            eVar = gVar2.uEB;
        }
        Log.i("Finder.FinderLiveService", append.append(eVar).toString());
        w wVar = ujM;
        if (wVar != null) {
            wVar.dgE();
            AppMethodBeat.o(246232);
            return;
        }
        AppMethodBeat.o(246232);
    }

    public static /* synthetic */ void hTe() {
        AppMethodBeat.i(260488);
        RJ(0);
        AppMethodBeat.o(260488);
    }

    public static void RJ(long j2) {
        Long l2;
        awe awe;
        com.tencent.mm.plugin.finder.live.viewmodel.e eVar = null;
        AppMethodBeat.i(260487);
        StringBuilder append = new StringBuilder("activateMic delay:").append(j2).append(" curLive:");
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar = ujz;
        if (gVar == null || (awe = gVar.liveInfo) == null) {
            l2 = null;
        } else {
            l2 = Long.valueOf(awe.liveId);
        }
        StringBuilder append2 = append.append(l2).append(" curLinkUser:");
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar2 = ujz;
        if (gVar2 != null) {
            eVar = gVar2.uEB;
        }
        Log.i("Finder.FinderLiveService", append2.append(eVar).toString());
        w wVar = UKC;
        if (wVar != null) {
            wVar.f(Long.valueOf(j2));
            AppMethodBeat.o(260487);
            return;
        }
        AppMethodBeat.o(260487);
    }

    public static void hTf() {
        Long l2;
        awe awe;
        com.tencent.mm.plugin.finder.live.viewmodel.e eVar = null;
        AppMethodBeat.i(260489);
        StringBuilder sb = new StringBuilder("stopActivateMic curLive:");
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar = ujz;
        if (gVar == null || (awe = gVar.liveInfo) == null) {
            l2 = null;
        } else {
            l2 = Long.valueOf(awe.liveId);
        }
        StringBuilder append = sb.append(l2).append(" curLinkUser:");
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar2 = ujz;
        if (gVar2 != null) {
            eVar = gVar2.uEB;
        }
        Log.i("Finder.FinderLiveService", append.append(eVar).toString());
        w wVar = UKC;
        if (wVar != null) {
            wVar.dgE();
            AppMethodBeat.o(260489);
            return;
        }
        AppMethodBeat.o(260489);
    }

    public static void EJ(long j2) {
        awe awe;
        AppMethodBeat.i(246233);
        StringBuilder append = new StringBuilder("keepAlive delay:").append(j2).append(" curLive:");
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar = ujz;
        Log.i("Finder.FinderLiveService", append.append((gVar == null || (awe = gVar.liveInfo) == null) ? null : Long.valueOf(awe.liveId)).toString());
        w wVar = ujL;
        if (wVar != null) {
            wVar.dgE();
        }
        w wVar2 = ujL;
        if (wVar2 != null) {
            wVar2.f(Long.valueOf(j2));
            AppMethodBeat.o(246233);
            return;
        }
        AppMethodBeat.o(246233);
    }

    public final void a(com.tencent.mm.plugin.finder.live.viewmodel.g gVar, FinderBaseLivePluginLayout finderBaseLivePluginLayout, int i2) {
        com.tencent.mm.live.core.core.d.b aEf;
        AppMethodBeat.i(246234);
        kotlin.g.b.p.h(gVar, "liveData");
        kotlin.g.b.p.h(finderBaseLivePluginLayout, "finderBaseLayout");
        Log.i("Finder.FinderLiveService", "bindCurLive " + gVar + " curLiveRoomData:" + ujz);
        String a2 = ((com.tencent.mm.plugin.expt.b.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_live_not_support_switch_video_param, "mp1718");
        kotlin.g.b.p.g(a2, "MMKernel.service(IExptSe…ch_video_param, \"mp1718\")");
        if (a2 == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(246234);
            throw tVar;
        }
        String lowerCase = a2.toLowerCase();
        kotlin.g.b.p.g(lowerCase, "(this as java.lang.String).toLowerCase()");
        uju = lowerCase;
        ujs = finderBaseLivePluginLayout;
        ujx = new b(finderBaseLivePluginLayout);
        if (ujz == null) {
            dgf();
            ujG.alive();
            hXn.alive();
            f(gVar);
            ujA = i2;
            boolean z2 = (finderBaseLivePluginLayout instanceof com.tencent.mm.plugin.finder.live.view.a) || (finderBaseLivePluginLayout instanceof com.tencent.mm.plugin.finder.live.view.c);
            dMz = z2;
            if (z2) {
                com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
                if (!com.tencent.mm.plugin.finder.utils.m.i(gVar)) {
                    b.a aVar = com.tencent.mm.live.core.core.a.b.hyv;
                    finderBaseLivePluginLayout.getContext();
                    aEf = b.a.aDo();
                } else {
                    a.C0381a aVar2 = com.tencent.mm.live.core.core.c.a.hAj;
                    finderBaseLivePluginLayout.getContext();
                    aEf = a.C0381a.aDw();
                }
            } else {
                b.a aVar3 = com.tencent.mm.live.core.core.d.b.hCo;
                finderBaseLivePluginLayout.getContext();
                aEf = b.a.aEf();
            }
            hSS = aEf;
            Context context = MMApplicationContext.getContext();
            kotlin.g.b.p.g(context, "MMApplicationContext.getContext()");
            FinderLiveMiniView finderLiveMiniView = new FinderLiveMiniView(context);
            ujt = finderLiveMiniView;
            finderLiveMiniView.a(hJe, ujI);
            FinderLiveMiniView finderLiveMiniView2 = ujt;
            if (finderLiveMiniView2 != null) {
                finderLiveMiniView2.bi(gVar.hwd, dMz);
            }
            com.tencent.mm.live.core.core.trtc.a aVar4 = hSS;
            if (aVar4 != null) {
                aVar4.a(ujt);
            }
            com.tencent.mm.live.core.core.trtc.a aVar5 = hSS;
            if (aVar5 != null) {
                aVar5.hAx = this;
            }
            if (dMz) {
                dgg();
            }
        }
        AppMethodBeat.o(246234);
    }

    public static com.tencent.mm.plugin.finder.live.viewmodel.g a(com.tencent.mm.plugin.finder.live.viewmodel.c cVar) {
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar;
        FinderObject finderObject;
        AppMethodBeat.i(246235);
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
            kotlin.g.b.p.g(aBG, "livecData.staticConfig.anchorUsername");
            gVar.atT(aBG);
            String aBI = cVar.uCr.aBI();
            kotlin.g.b.p.g(aBI, "livecData.staticConfig.nonceId");
            gVar.atS(aBI);
            gVar.desc = cVar.uCr.getDesc();
            if (TextUtils.isEmpty(gVar.uEu)) {
                String aBE = cVar.uCr.aBE();
                kotlin.g.b.p.g(aBE, "livecData.staticConfig.thumbUrl");
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
            com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
            if (com.tencent.mm.plugin.finder.utils.y.dCM()) {
                com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
                int intValue = com.tencent.mm.plugin.finder.storage.c.dwd().value().intValue();
                avi avi = new avi();
                switch (intValue) {
                    case 0:
                        avi.LFV = 0;
                        break;
                    default:
                        avi.LFV = 1;
                        avi.LFX = intValue;
                        break;
                }
                gVar.a(avi);
                Log.i("Finder.FinderLiveService", "chcekBadgeDebugInfo badgeDebugValue:".concat(String.valueOf(intValue)));
            }
            gVar.hUc();
            Log.i("Finder.FinderLiveService", "transferLiveData liveId:" + gVar.liveInfo.liveId + " objectId:" + gVar.hFK + " anchorUsername:" + gVar.hwd);
        }
        AppMethodBeat.o(246235);
        return gVar;
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x01fd  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x015d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void a(boolean r11, boolean r12, java.lang.Boolean r13, int r14) {
        /*
        // Method dump skipped, instructions count: 734
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.live.model.o.a(boolean, boolean, java.lang.Boolean, int):void");
    }

    public static final class p implements d.a {
        p() {
        }

        @Override // com.tencent.mm.plugin.finder.live.model.cgi.d.a
        public final void onCgiBack(int i2, int i3, String str, avm avm) {
            AppMethodBeat.i(246209);
            kotlin.g.b.p.h(avm, "resp");
            Log.i("Finder.FinderLiveService", "closeLinkMic when release live. errCode:" + i3 + ", errType:" + i2);
            AppMethodBeat.o(246209);
        }
    }

    public static final class q implements com.tencent.mm.live.core.core.c {
        q() {
        }

        @Override // com.tencent.mm.live.core.core.c
        public final void callback(int i2, Bundle bundle) {
            AppMethodBeat.i(246210);
            Log.i("Finder.FinderLiveService", "on exitRoom finish");
            AppMethodBeat.o(246210);
        }
    }

    public static void aHh() {
        AppMethodBeat.i(246237);
        UKA.stopTimer();
        hWh.apm();
        w wVar = ujK;
        if (wVar != null) {
            wVar.dgE();
        }
        w wVar2 = ujL;
        if (wVar2 != null) {
            wVar2.dgE();
        }
        w wVar3 = ujM;
        if (wVar3 != null) {
            wVar3.dgE();
        }
        j jVar = j.ujh;
        j.dfM();
        AppMethodBeat.o(246237);
    }

    public static void EK(long j2) {
        AppMethodBeat.i(246238);
        hWh.aTv();
        P(0, j2);
        j jVar = j.ujh;
        j.dfL();
        AppMethodBeat.o(246238);
    }

    public static /* synthetic */ void a(o oVar) {
        AppMethodBeat.i(246240);
        oVar.nn(true);
        AppMethodBeat.o(246240);
    }

    public final void nn(boolean z2) {
        AppMethodBeat.i(246239);
        com.tencent.mm.live.core.core.trtc.a aVar = hSS;
        if (aVar != null) {
            aVar.aBW();
        }
        FinderBaseLivePluginLayout finderBaseLivePluginLayout = ujs;
        if (finderBaseLivePluginLayout != null) {
            finderBaseLivePluginLayout.finish();
        }
        a(z2, false, null, 6);
        AppMethodBeat.o(246239);
    }

    public static void dgj() {
        AppMethodBeat.i(246241);
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar = ujz;
        if (gVar != null) {
            Log.i("Finder.FinderLiveService", "receive logoutEvent, liveId:" + gVar.liveInfo.liveId);
            ujN.nn(true);
            AppMethodBeat.o(246241);
            return;
        }
        AppMethodBeat.o(246241);
    }

    private static void j(com.tencent.mm.plugin.finder.live.viewmodel.g gVar, LinkedList<aut> linkedList) {
        byte[] bArr;
        String str;
        boolean z2;
        String str2;
        com.tencent.mm.bw.b bVar;
        com.tencent.mm.bw.b bVar2;
        com.tencent.mm.bw.b bVar3;
        FinderBaseLivePluginLayout finderBaseLivePluginLayout;
        boolean z3;
        FinderContact finderContact;
        FinderContact finderContact2;
        FinderContact finderContact3;
        FinderContact finderContact4;
        FinderContact finderContact5;
        AppMethodBeat.i(260490);
        i iVar = i.uja;
        LinkedList<aut> aj = i.aj(linkedList);
        for (T t2 : aj) {
            auu auu = new auu();
            auu auu2 = auu;
            com.tencent.mm.bw.b bVar4 = t2.LFB;
            if (bVar4 != null) {
                bArr = bVar4.toByteArray();
            } else {
                bArr = null;
            }
            try {
                auu2.parseFrom(bArr);
            } catch (Exception e2) {
                Log.printDebugStack("safeParser", "", e2);
            }
            StringBuilder append = new StringBuilder("receive accept mic msg:[isAnchor:").append(dMz).append(", username:");
            avn avn = t2.LFE;
            StringBuilder append2 = append.append((avn == null || (finderContact5 = avn.contact) == null) ? null : finderContact5.username).append(", nickname:");
            avn avn2 = t2.LFE;
            StringBuilder append3 = append2.append((avn2 == null || (finderContact4 = avn2.contact) == null) ? null : finderContact4.nickname).append(", sdkUerId:");
            cjb cjb = auu.LFH;
            Log.i("Finder.FinderLiveService", append3.append(cjb != null ? cjb.MnL : null).append(", micType:").append(auu.LFG).append(", sessionId:").append(t2.session_id).append(", seq:").append(auu.seq).append(']').toString());
            String str3 = t2.session_id;
            if (str3 != null && !dMz) {
                Integer num = gVar.UQc.get(str3);
                if (num != null && num.intValue() == 3) {
                    Log.i("Finder.FinderLiveService", "mic has closed, skip msg");
                } else {
                    kotlin.g.b.p.g(str3, "sessionId");
                    gVar.UQc.put(str3, 2);
                    cjb cjb2 = auu.LFH;
                    if (cjb2 == null || (str = cjb2.MnL) == null) {
                        str = auu.Lmn;
                    }
                    avn avn3 = auu.LFI;
                    String str4 = (avn3 == null || (finderContact3 = avn3.contact) == null) ? null : finderContact3.headUrl;
                    avn avn4 = auu.LFI;
                    String str5 = (avn4 == null || (finderContact2 = avn4.contact) == null) ? null : finderContact2.username;
                    avn avn5 = auu.LFI;
                    String str6 = (avn5 == null || (finderContact = avn5.contact) == null) ? null : finderContact.nickname;
                    int i2 = auu.LFG;
                    String str7 = t2.session_id;
                    avn avn6 = auu.LFI;
                    gVar.f(new com.tencent.mm.plugin.finder.live.viewmodel.e(str, str4, str5, str6, i2, str7, null, false, 0, null, null, 0, avn6 != null ? avn6.LGj : 0, 4032));
                    List<com.tencent.mm.plugin.finder.live.viewmodel.e> list = gVar.UPZ;
                    kotlin.g.b.p.g(list, "liveData.audienceLinkMicUserList");
                    List<com.tencent.mm.plugin.finder.live.viewmodel.e> list2 = list;
                    synchronized (list2) {
                        try {
                            Iterator<T> it = list2.iterator();
                            z2 = false;
                            while (it.hasNext()) {
                                if (gVar.UQd.remove(it.next().uCo)) {
                                    z3 = true;
                                } else {
                                    z3 = z2;
                                }
                                z2 = z3;
                            }
                            kotlin.x xVar = kotlin.x.SXb;
                        } catch (Throwable th) {
                            AppMethodBeat.o(260490);
                            throw th;
                        }
                    }
                    gVar.UQd.clear();
                    if (z2 && (finderBaseLivePluginLayout = ujs) != null) {
                        finderBaseLivePluginLayout.notifyAudienceMicUserChange();
                    }
                    String djq = gVar.djq();
                    cjb cjb3 = auu.LFH;
                    if (cjb3 != null) {
                        str2 = cjb3.MnL;
                    } else {
                        str2 = null;
                    }
                    if (Util.isEqual(djq, str2)) {
                        gVar.uEC = 0;
                        com.tencent.mm.live.b.s sVar = com.tencent.mm.live.b.s.hIl;
                        com.tencent.mm.live.b.j aGe = com.tencent.mm.live.b.s.aGe();
                        if (aGe != null) {
                            long j2 = gVar.liveInfo.liveId;
                            String str8 = t2.session_id;
                            cjb cjb4 = auu.LFH;
                            String str9 = cjb4 != null ? cjb4.MnL : null;
                            cjb cjb5 = auu.LFH;
                            int i3 = cjb5 != null ? cjb5.Moj : 0;
                            cjb cjb6 = auu.LFH;
                            int i4 = cjb6 != null ? cjb6.Mol : 0;
                            cjb cjb7 = auu.LFH;
                            int i5 = cjb7 != null ? cjb7.Mok : 0;
                            cjb cjb8 = auu.LFH;
                            String yO = (cjb8 == null || (bVar3 = cjb8.Mom) == null) ? null : bVar3.yO();
                            cjb cjb9 = auu.LFH;
                            String yO2 = (cjb9 == null || (bVar2 = cjb9.Mon) == null) ? null : bVar2.yO();
                            cjb cjb10 = auu.LFH;
                            long j3 = cjb10 != null ? cjb10.Mor : 0;
                            cjb cjb11 = auu.LFH;
                            aGe.onAcceptLiveMic(new com.tencent.mm.live.b.a(j2, str8, str9, i3, i4, i5, yO, yO2, j3, (cjb11 == null || (bVar = cjb11.Moo) == null) ? null : bVar.yO(), Integer.valueOf(auu.LFG), auu.seq, 12288));
                        }
                    }
                }
            }
        }
        Log.i("Finder.FinderLiveService", "acceptMicMsgList:" + aj.size() + " isAnchor:" + dMz);
        AppMethodBeat.o(260490);
    }

    public static final class h extends kotlin.g.b.q implements kotlin.g.a.a<String> {
        final /* synthetic */ int $errCode;
        final /* synthetic */ int $errType;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(int i2, int i3) {
            super(0);
            this.$errCode = i2;
            this.$errType = i3;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            Long l;
            awe awe;
            AppMethodBeat.i(246194);
            StringBuilder append = new StringBuilder("errCode:").append(this.$errCode).append(" errType:").append(this.$errType).append(" localId:");
            o oVar = o.ujN;
            com.tencent.mm.plugin.finder.live.viewmodel.g dfZ = o.dfZ();
            if (dfZ == null || (awe = dfZ.liveInfo) == null) {
                l = null;
            } else {
                l = Long.valueOf(awe.liveId);
            }
            String sb = append.append(l).toString();
            AppMethodBeat.o(246194);
            return sb;
        }
    }

    public static final class i extends kotlin.g.b.q implements kotlin.g.a.a<String> {
        final /* synthetic */ int $errCode;
        final /* synthetic */ int $errType;
        final /* synthetic */ ass ujQ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(int i2, int i3, ass ass) {
            super(0);
            this.$errCode = i2;
            this.$errType = i3;
            this.ujQ = ass;
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            Long l;
            AppMethodBeat.i(246195);
            StringBuilder append = new StringBuilder("errCode:").append(this.$errCode).append(" errType:").append(this.$errType).append(" svrId:");
            awe awe = this.ujQ.liveInfo;
            if (awe != null) {
                l = Long.valueOf(awe.liveId);
            } else {
                l = null;
            }
            String sb = append.append(l).toString();
            AppMethodBeat.o(246195);
            return sb;
        }
    }

    private static void k(com.tencent.mm.plugin.finder.live.viewmodel.g gVar, LinkedList<aut> linkedList) {
        byte[] bArr;
        T t2;
        String str;
        FinderContact finderContact;
        T t3;
        String str2;
        FinderContact finderContact2;
        FinderContact finderContact3;
        AppMethodBeat.i(260491);
        i iVar = i.uja;
        ArrayList arrayList = new ArrayList();
        for (T t4 : i.ak(linkedList)) {
            avn avn = t4.LFE;
            if (!Util.isEqual((avn == null || (finderContact3 = avn.contact) == null) ? null : finderContact3.username, com.tencent.mm.model.z.aTY())) {
                arrayList.add(t4);
            }
        }
        ArrayList<aut> arrayList2 = arrayList;
        for (aut aut : arrayList2) {
            aux aux = new aux();
            aux aux2 = aux;
            com.tencent.mm.bw.b bVar = aut.LFB;
            if (bVar != null) {
                bArr = bVar.toByteArray();
            } else {
                bArr = null;
            }
            try {
                aux2.parseFrom(bArr);
            } catch (Exception e2) {
                Log.printDebugStack("safeParser", "", e2);
            }
            Log.i("Finder.FinderLiveService", "receive close mic msg, [sdkUserId:" + aux.Lmn + ", sessionId:" + aut.session_id + "], curLiveUser:" + gVar.uEB + ", applySessionId:" + gVar.uEy);
            String str3 = aut.session_id;
            if (str3 != null) {
                kotlin.g.b.p.g(str3, "sessionId");
                gVar.UQc.put(str3, 3);
                if (dMz) {
                    List<com.tencent.mm.plugin.finder.live.viewmodel.e> list = gVar.UPZ;
                    kotlin.g.b.p.g(list, "liveData.audienceLinkMicUserList");
                    List<com.tencent.mm.plugin.finder.live.viewmodel.e> list2 = list;
                    synchronized (list2) {
                        try {
                            Iterator<T> it = list2.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    t3 = null;
                                    break;
                                }
                                T next = it.next();
                                if (Util.isEqual(next.sessionId, aut.session_id)) {
                                    t3 = next;
                                    break;
                                }
                            }
                        } catch (Throwable th) {
                            AppMethodBeat.o(260491);
                            throw th;
                        }
                    }
                    T t5 = t3;
                    if (t5 != null) {
                        com.tencent.mm.live.b.s sVar = com.tencent.mm.live.b.s.hIl;
                        com.tencent.mm.live.b.j aGe = com.tencent.mm.live.b.s.aGe();
                        if (aGe != null) {
                            long j2 = gVar.liveInfo.liveId;
                            avn avn2 = aut.LFE;
                            if (avn2 == null || (finderContact2 = avn2.contact) == null) {
                                str2 = null;
                            } else {
                                str2 = finderContact2.username;
                            }
                            aGe.onCloseLiveMic(new com.tencent.mm.live.b.f(j2, str2, aut.session_id, t5.uCo, t5.uCx));
                        }
                        List<com.tencent.mm.plugin.finder.live.viewmodel.e> list3 = gVar.UPZ;
                        kotlin.g.b.p.g(list3, "liveData.audienceLinkMicUserList");
                        com.tencent.mm.ac.d.a(list3, new c(aut, aux, gVar));
                        Log.i("Finder.FinderLiveService", "anchor receive close msg, [sdkUserId:" + aux.Lmn + "] closeUser:" + ((Object) t5));
                    }
                    List<com.tencent.mm.plugin.finder.live.viewmodel.e> list4 = gVar.UPX;
                    kotlin.g.b.p.g(list4, "liveData.linkMicUserList");
                    kotlin.a.j.c((List) list4, (kotlin.g.a.b) new t(aut, aux, gVar));
                    List<com.tencent.mm.plugin.finder.live.viewmodel.e> list5 = gVar.UPY;
                    kotlin.g.b.p.g(list5, "liveData.newLinkMicUserList");
                    kotlin.a.j.c((List) list5, (kotlin.g.a.b) new u(aut, aux, gVar));
                } else {
                    List<com.tencent.mm.plugin.finder.live.viewmodel.e> list6 = gVar.UPZ;
                    kotlin.g.b.p.g(list6, "liveData.audienceLinkMicUserList");
                    List<com.tencent.mm.plugin.finder.live.viewmodel.e> list7 = list6;
                    synchronized (list7) {
                        try {
                            Iterator<T> it2 = list7.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    t2 = null;
                                    break;
                                }
                                T next2 = it2.next();
                                if (Util.isEqual(next2.sessionId, aut.session_id)) {
                                    t2 = next2;
                                    break;
                                }
                            }
                        } catch (Throwable th2) {
                            AppMethodBeat.o(260491);
                            throw th2;
                        }
                    }
                    T t6 = t2;
                    if (t6 != null) {
                        com.tencent.mm.live.b.s sVar2 = com.tencent.mm.live.b.s.hIl;
                        com.tencent.mm.live.b.j aGe2 = com.tencent.mm.live.b.s.aGe();
                        if (aGe2 != null) {
                            long j3 = gVar.liveInfo.liveId;
                            avn avn3 = aut.LFE;
                            if (avn3 == null || (finderContact = avn3.contact) == null) {
                                str = null;
                            } else {
                                str = finderContact.username;
                            }
                            aGe2.onCloseLiveMic(new com.tencent.mm.live.b.f(j3, str, aut.session_id, t6.uCo, t6.uCx));
                        }
                        List<com.tencent.mm.plugin.finder.live.viewmodel.e> list8 = gVar.UPZ;
                        kotlin.g.b.p.g(list8, "liveData.audienceLinkMicUserList");
                        com.tencent.mm.ac.d.a(list8, new v(aut, aux, gVar));
                    }
                    Log.i("Finder.FinderLiveService", "visitor receive close msg, [sdkUserId:" + aux.Lmn + "] closeUser:" + ((Object) t6));
                }
            }
        }
        Log.i("Finder.FinderLiveService", "closeMicMsgList:" + arrayList2.size() + " isAnchor:" + dMz);
        AppMethodBeat.o(260491);
    }

    private static void l(com.tencent.mm.plugin.finder.live.viewmodel.g gVar, LinkedList<aut> linkedList) {
        FinderContact finderContact;
        FinderContact finderContact2;
        AppMethodBeat.i(260492);
        i iVar = i.uja;
        ArrayList arrayList = new ArrayList();
        for (T t2 : i.bQ(linkedList)) {
            avn avn = t2.LFE;
            if (!Util.isEqual((avn == null || (finderContact2 = avn.contact) == null) ? null : finderContact2.username, com.tencent.mm.model.z.aUg())) {
                arrayList.add(t2);
            }
        }
        ArrayList<aut> arrayList2 = arrayList;
        if (dMz) {
            for (aut aut : arrayList2) {
                fgi fgi = new fgi();
                fgi fgi2 = fgi;
                com.tencent.mm.bw.b bVar = aut.LFB;
                try {
                    fgi2.parseFrom(bVar != null ? bVar.toByteArray() : null);
                } catch (Exception e2) {
                    Log.printDebugStack("safeParser", "", e2);
                }
                String str = aut.session_id;
                if (str != null) {
                    kotlin.g.b.p.g(str, "sessionId");
                    gVar.UQc.put(str, 3);
                    com.tencent.mm.plugin.finder.live.viewmodel.e eVar = gVar.uEB;
                    if (Util.isEqual(str, eVar != null ? eVar.sessionId : null)) {
                        hTf();
                        com.tencent.mm.live.b.s sVar = com.tencent.mm.live.b.s.hIl;
                        com.tencent.mm.live.b.j aGe = com.tencent.mm.live.b.s.aGe();
                        if (aGe != null) {
                            long j2 = gVar.liveInfo.liveId;
                            avn avn2 = aut.LFE;
                            aGe.onCloseLiveMic(new com.tencent.mm.live.b.f(j2, (avn2 == null || (finderContact = avn2.contact) == null) ? null : finderContact.username, aut.session_id));
                        }
                        gVar.uEC = 0;
                        gVar.uEB = null;
                        Log.i("Finder.FinderLiveService", "[LinkMicPk]  anchor receive close pk msg, [sdkUserId:" + fgi.Lmn + ']');
                    }
                    List<com.tencent.mm.plugin.finder.live.viewmodel.e> list = gVar.UPX;
                    kotlin.g.b.p.g(list, "liveData.linkMicUserList");
                    kotlin.a.j.c((List) list, (kotlin.g.a.b) new w(aut, fgi, gVar));
                    List<com.tencent.mm.plugin.finder.live.viewmodel.e> list2 = gVar.UPY;
                    kotlin.g.b.p.g(list2, "liveData.newLinkMicUserList");
                    kotlin.a.j.c((List) list2, (kotlin.g.a.b) new x(aut, fgi, gVar));
                }
                Log.i("Finder.FinderLiveService", "[LinkMicPk]  receive close pk msg, [sdkUserId:" + fgi.Lmn + ", sessionId:" + aut.session_id + "], curLiveUser:" + gVar.uEB + ", applySessionId:" + gVar.uEy);
            }
        }
        Log.i("Finder.FinderLiveService", "[LinkMicPk]  checkLinkClosePkMsg:" + arrayList2.size() + " isAnchor:" + dMz);
        AppMethodBeat.o(260492);
    }

    private static void m(com.tencent.mm.plugin.finder.live.viewmodel.g gVar, LinkedList<aut> linkedList) {
        byte[] bArr;
        Boolean bool;
        String str;
        com.tencent.mm.plugin.finder.live.viewmodel.e eVar;
        String str2;
        String str3;
        FinderContact finderContact;
        FinderContact finderContact2;
        FinderContact finderContact3;
        FinderContact finderContact4;
        FinderContact finderContact5;
        FinderContact finderContact6;
        FinderContact finderContact7;
        String str4;
        String str5;
        String str6;
        FinderContact finderContact8;
        FinderContact finderContact9;
        FinderContact finderContact10;
        FinderContact finderContact11;
        FinderContact finderContact12;
        AppMethodBeat.i(260493);
        i iVar = i.uja;
        LinkedList<aut> bR = i.bR(linkedList);
        if (!dMz) {
            for (T t2 : bR) {
                fgk fgk = new fgk();
                fgk fgk2 = fgk;
                com.tencent.mm.bw.b bVar = t2.LFB;
                if (bVar != null) {
                    bArr = bVar.toByteArray();
                } else {
                    bArr = null;
                }
                try {
                    fgk2.parseFrom(bArr);
                } catch (Exception e2) {
                    Log.printDebugStack("safeParser", "", e2);
                }
                StringBuilder append = new StringBuilder("[LinkMicPk] visitor receive pkStatusMsg: [pkStatusScene:").append(fgk.scene).append(" pkStatusSeq:").append(fgk.seq).append(" pkStatusPkUser:");
                avn avn = fgk.LFI;
                Log.i("Finder.FinderLiveService", append.append((avn == null || (finderContact12 = avn.contact) == null) ? null : finderContact12.nickname).append(']').toString());
                switch (fgk.scene) {
                    case 1:
                        StringBuilder append2 = new StringBuilder("[LinkMicPk] receive apply pk status msg:[session_id:").append(t2.session_id).append(", pkAnchorNickname:");
                        avn avn2 = fgk.LFI;
                        Log.i("Finder.FinderLiveService", append2.append((avn2 == null || (finderContact11 = avn2.contact) == null) ? null : finderContact11.nickname).append(", userSdkId:").append(fgk.Lmn).append(", isAnchor:").append(dMz).append(']').toString());
                        String str7 = t2.session_id;
                        if (str7 != null) {
                            if (gVar.UQc.get(str7) == null) {
                                if (fgk.seq < gVar.uEx) {
                                    Log.i("Finder.FinderLiveService", "[LinkMicPk] skip apply pk status msg, mic too old. sessionId:" + str7 + " curMsgSeq:" + fgk.seq + " acceptedSeq:" + gVar.uEx);
                                    break;
                                } else {
                                    kotlin.g.b.p.g(str7, "sessionId");
                                    gVar.UQc.put(str7, 0);
                                    avn avn3 = fgk.LFI;
                                    if (avn3 == null || (finderContact10 = avn3.contact) == null) {
                                        str4 = null;
                                    } else {
                                        str4 = finderContact10.username;
                                    }
                                    avn avn4 = fgk.LFI;
                                    if (avn4 == null || (finderContact9 = avn4.contact) == null) {
                                        str5 = null;
                                    } else {
                                        str5 = finderContact9.nickname;
                                    }
                                    avn avn5 = fgk.LFI;
                                    if (avn5 == null || (finderContact8 = avn5.contact) == null) {
                                        str6 = null;
                                    } else {
                                        str6 = finderContact8.headUrl;
                                    }
                                    gVar.UQb = new com.tencent.mm.plugin.finder.live.viewmodel.j(str7, str4, str5, str6);
                                    break;
                                }
                            } else {
                                Log.i("Finder.FinderLiveService", "[LinkMicPk] skip apply pk status msg, invalid apply msg. curMicStatus:" + gVar.UQc.get(str7));
                                break;
                            }
                        } else {
                            break;
                        }
                        break;
                    case 2:
                        StringBuilder append3 = new StringBuilder("[LinkMicPk] receive accept pk status msg:[session_id:").append(t2.session_id).append(", pkAnchorNickname:");
                        avn avn6 = fgk.LFI;
                        Log.i("Finder.FinderLiveService", append3.append((avn6 == null || (finderContact7 = avn6.contact) == null) ? null : finderContact7.nickname).append(", userSdkId:").append(fgk.Lmn).append(", isAnchor:").append(dMz).append(']').toString());
                        String str8 = t2.session_id;
                        if (str8 == null) {
                            break;
                        } else {
                            Integer num = gVar.UQc.get(str8);
                            if (num == null || num.intValue() != 3) {
                                if (fgk.seq < gVar.uEx) {
                                    Log.i("Finder.FinderLiveService", "[LinkMicPk] skip accept pk status msg, mic too old. sessionId:" + str8 + " curMsgSeq:" + fgk.seq + " acceptedSeq:" + gVar.uEx);
                                    break;
                                } else {
                                    gVar.UQb = null;
                                    kotlin.g.b.p.g(str8, "sessionId");
                                    gVar.UQc.put(str8, 2);
                                    gVar.uEx = fgk.seq;
                                    gVar.uEC = 4;
                                    String str9 = fgk.Lmn;
                                    avn avn7 = fgk.LFI;
                                    String str10 = (avn7 == null || (finderContact6 = avn7.contact) == null) ? null : finderContact6.headUrl;
                                    avn avn8 = fgk.LFI;
                                    String str11 = (avn8 == null || (finderContact5 = avn8.contact) == null) ? null : finderContact5.username;
                                    avn avn9 = fgk.LFI;
                                    String str12 = (avn9 == null || (finderContact4 = avn9.contact) == null) ? null : finderContact4.nickname;
                                    String str13 = t2.session_id;
                                    avn avn10 = fgk.LFI;
                                    gVar.uEB = new com.tencent.mm.plugin.finder.live.viewmodel.e(str9, str10, str11, str12, 2, str13, null, true, 0, (avn10 == null || (finderContact3 = avn10.contact) == null) ? null : finderContact3.authInfo, null, 0, 0, 7168);
                                    com.tencent.mm.live.b.s sVar = com.tencent.mm.live.b.s.hIl;
                                    com.tencent.mm.live.b.j aGe = com.tencent.mm.live.b.s.aGe();
                                    if (aGe != null) {
                                        aGe.onAcceptLiveMic(new com.tencent.mm.live.b.a(gVar.liveInfo.liveId, t2.session_id, "", gVar.hUb(), 0, 0, "", "", 0, "", 2, fgk.seq, "", true));
                                        break;
                                    } else {
                                        break;
                                    }
                                }
                            } else {
                                Log.i("Finder.FinderLiveService", "[LinkMicPk] skip accept pk status msg, mic closed. sessionId:".concat(String.valueOf(str8)));
                                break;
                            }
                        }
                        break;
                    case 3:
                        StringBuilder append4 = new StringBuilder("[LinkMicPk] receive close pk status msg:[session_id:").append(t2.session_id).append(", pkAnchorNickname:");
                        avn avn11 = fgk.LFI;
                        Log.i("Finder.FinderLiveService", append4.append((avn11 == null || (finderContact2 = avn11.contact) == null) ? null : finderContact2.nickname).append(", userSdkId:").append(fgk.Lmn).append(", isAnchor:").append(dMz).append(']').toString());
                        String str14 = t2.session_id;
                        if (str14 != null) {
                            kotlin.g.b.p.g(str14, "sessionId");
                            gVar.UQc.put(str14, 3);
                            gVar.UQb = null;
                            if (gVar.djs() && (eVar = gVar.uEB) != null && eVar.UPN) {
                                com.tencent.mm.plugin.finder.live.viewmodel.e eVar2 = gVar.uEB;
                                if (eVar2 != null) {
                                    str2 = eVar2.sessionId;
                                } else {
                                    str2 = null;
                                }
                                if (Util.isEqual(str2, t2.session_id)) {
                                    com.tencent.mm.live.b.s sVar2 = com.tencent.mm.live.b.s.hIl;
                                    com.tencent.mm.live.b.j aGe2 = com.tencent.mm.live.b.s.aGe();
                                    if (aGe2 != null) {
                                        long j2 = gVar.liveInfo.liveId;
                                        avn avn12 = fgk.LFI;
                                        if (avn12 == null || (finderContact = avn12.contact) == null) {
                                            str3 = null;
                                        } else {
                                            str3 = finderContact.username;
                                        }
                                        aGe2.onCloseLiveMic(new com.tencent.mm.live.b.f(j2, str3, t2.session_id));
                                        break;
                                    } else {
                                        break;
                                    }
                                }
                            }
                            StringBuilder append5 = new StringBuilder("[LinkMicPk] invalid params: [isLinking:").append(gVar.djs()).append(" isPkWithAnchor:");
                            com.tencent.mm.plugin.finder.live.viewmodel.e eVar3 = gVar.uEB;
                            if (eVar3 != null) {
                                bool = Boolean.valueOf(eVar3.UPN);
                            } else {
                                bool = null;
                            }
                            StringBuilder append6 = append5.append(bool).append(" curSessionId:");
                            com.tencent.mm.plugin.finder.live.viewmodel.e eVar4 = gVar.uEB;
                            if (eVar4 != null) {
                                str = eVar4.sessionId;
                            } else {
                                str = null;
                            }
                            Log.i("Finder.FinderLiveService", append6.append(str).append(" msgSessionId:").append(t2.session_id).append(']').toString());
                            break;
                        } else {
                            break;
                        }
                        break;
                }
            }
        }
        Log.i("Finder.FinderLiveService", "[LinkMicPk] checkPkStatusMsg:" + bR.size() + " isAnchor:" + dMz);
        AppMethodBeat.o(260493);
    }

    public static final class r extends kotlin.g.b.q implements kotlin.g.a.a<kotlin.x> {
        public static final r ujV = new r();

        static {
            AppMethodBeat.i(246214);
            AppMethodBeat.o(246214);
        }

        r() {
            super(0);
        }

        @Override // kotlin.g.a.a
        public final /* synthetic */ kotlin.x invoke() {
            AppMethodBeat.i(246213);
            o oVar = o.ujN;
            com.tencent.mm.live.core.core.trtc.a aVar = o.hSS;
            if (aVar == null) {
                kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.live.core.core.anchor.LiveAnchorTRTCCore");
                AppMethodBeat.o(246213);
                throw tVar;
            }
            o oVar2 = o.ujN;
            ((com.tencent.mm.live.core.core.a.b) aVar).qs(o.dgk());
            o oVar3 = o.ujN;
            com.tencent.mm.live.core.core.trtc.a aVar2 = o.hSS;
            if (aVar2 == null) {
                kotlin.t tVar2 = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.live.core.core.anchor.LiveAnchorTRTCCore");
                AppMethodBeat.o(246213);
                throw tVar2;
            }
            o oVar4 = o.ujN;
            com.tencent.mm.live.core.b.a aGk = o.aGk();
            o oVar5 = o.ujN;
            ((com.tencent.mm.live.core.core.a.b) aVar2).a(aGk, o.aGl());
            o oVar6 = o.ujN;
            FinderBaseLivePluginLayout finderBaseLivePluginLayout = o.ujs;
            if (finderBaseLivePluginLayout != null) {
                finderBaseLivePluginLayout.post(AnonymousClass1.ujW);
            }
            kotlin.x xVar = kotlin.x.SXb;
            AppMethodBeat.o(246213);
            return xVar;
        }
    }

    private static boolean e(Long l2) {
        long j2;
        awe awe;
        AppMethodBeat.i(246243);
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar = ujz;
        if (gVar == null || (awe = gVar.liveInfo) == null) {
            j2 = 0;
        } else {
            j2 = awe.liveId;
        }
        if (j2 == 0 || l2 == null || j2 != l2.longValue()) {
            AppMethodBeat.o(246243);
            return true;
        }
        AppMethodBeat.o(246243);
        return false;
    }

    @Override // com.tencent.mm.live.core.core.c
    public final void callback(int i2, Bundle bundle) {
        AppMethodBeat.i(246244);
        FinderBaseLivePluginLayout finderBaseLivePluginLayout = ujs;
        if (finderBaseLivePluginLayout != null) {
            finderBaseLivePluginLayout.onLiveEventCallback(i2, bundle);
            AppMethodBeat.o(246244);
            return;
        }
        AppMethodBeat.o(246244);
    }

    public static void b(Context context, com.tencent.mm.plugin.appbrand.api.g gVar) {
        AppMethodBeat.i(246245);
        kotlin.g.b.p.h(context, "context");
        kotlin.g.b.p.h(gVar, "bundle");
        int hashCode = gVar.hashCode();
        gVar.kHO = true;
        gVar.kHN = new k();
        d.a aVar = com.tencent.mm.plugin.finder.live.viewmodel.d.uCw;
        com.tencent.mm.plugin.finder.live.viewmodel.d.uCv.put(Integer.valueOf(hashCode), gVar);
        Log.i("Finder.FinderLiveService", "launchMiniProgram,key:" + hashCode + ",bundle is null:false");
        Intent intent = new Intent();
        FinderLiveMiniProProxyUI.a aVar2 = FinderLiveMiniProProxyUI.ubz;
        String str = FinderLiveMiniProProxyUI.ubu;
        FinderLiveMiniProProxyUI.a aVar3 = FinderLiveMiniProProxyUI.ubz;
        intent.putExtra(str, FinderLiveMiniProProxyUI.ubw);
        FinderLiveMiniProProxyUI.a aVar4 = FinderLiveMiniProProxyUI.ubz;
        intent.putExtra(FinderLiveMiniProProxyUI.ubv, hashCode);
        intent.putExtra("MMActivity.OverrideEnterAnimation", -1);
        intent.putExtra("MMActivity.OverrideExitAnimation", -1);
        intent.addFlags(335544320);
        intent.setClass(context, FinderLiveMiniProProxyUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/live/model/FinderLiveService", com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.f.NAME, "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/live/model/FinderLiveService", com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.f.NAME, "(Landroid/content/Context;Lcom/tencent/mm/plugin/appbrand/api/WeAppOpenBundle;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(246245);
    }

    public static final class k implements com.tencent.mm.plugin.appbrand.api.i {
        k() {
        }

        @Override // com.tencent.mm.plugin.appbrand.api.i
        public final void bud() {
            awe awe;
            AppMethodBeat.i(246198);
            StringBuilder sb = new StringBuilder("live:");
            o oVar = o.ujN;
            com.tencent.mm.plugin.finder.live.viewmodel.g dfZ = o.dfZ();
            Log.i("Finder.FinderLiveService", sb.append((dfZ == null || (awe = dfZ.liveInfo) == null) ? null : Long.valueOf(awe.liveId)).append(" luanchMiniProgram error!").toString());
            o oVar2 = o.ujN;
            com.tencent.mm.plugin.finder.live.viewmodel.g dfZ2 = o.dfZ();
            if (dfZ2 != null) {
                dfZ2.uEr = false;
            }
            o oVar3 = o.ujN;
            o.dfk();
            AppMethodBeat.o(246198);
        }

        @Override // com.tencent.mm.plugin.appbrand.api.i
        public final void bue() {
            awe awe;
            AppMethodBeat.i(246199);
            StringBuilder sb = new StringBuilder("live:");
            o oVar = o.ujN;
            com.tencent.mm.plugin.finder.live.viewmodel.g dfZ = o.dfZ();
            Log.i("Finder.FinderLiveService", sb.append((dfZ == null || (awe = dfZ.liveInfo) == null) ? null : Long.valueOf(awe.liveId)).append(" onAppBrandUIEnter!").toString());
            o oVar2 = o.ujN;
            com.tencent.mm.plugin.finder.live.viewmodel.g dfZ2 = o.dfZ();
            if (dfZ2 != null) {
                dfZ2.uEr = true;
                AppMethodBeat.o(246199);
                return;
            }
            AppMethodBeat.o(246199);
        }

        @Override // com.tencent.mm.plugin.appbrand.api.i
        public final void gC(boolean z) {
            Long l;
            awe awe;
            awc awc = null;
            AppMethodBeat.i(246200);
            StringBuilder sb = new StringBuilder("live:");
            o oVar = o.ujN;
            com.tencent.mm.plugin.finder.live.viewmodel.g dfZ = o.dfZ();
            if (dfZ == null || (awe = dfZ.liveInfo) == null) {
                l = null;
            } else {
                l = Long.valueOf(awe.liveId);
            }
            Log.i("Finder.FinderLiveService", sb.append(l).append(" onAppBrandUIExit!").toString());
            o oVar2 = o.ujN;
            com.tencent.mm.plugin.finder.live.viewmodel.g dfZ2 = o.dfZ();
            if (dfZ2 != null) {
                dfZ2.uEr = false;
            }
            com.tencent.mm.plugin.finder.live.h hVar = com.tencent.mm.plugin.finder.live.h.ufY;
            o oVar3 = o.ujN;
            com.tencent.mm.plugin.finder.live.viewmodel.g dfZ3 = o.dfZ();
            com.tencent.mm.plugin.finder.utils.y yVar = com.tencent.mm.plugin.finder.utils.y.vXH;
            o oVar4 = o.ujN;
            com.tencent.mm.plugin.finder.live.viewmodel.g dfZ4 = o.dfZ();
            if (dfZ4 != null) {
                awc = dfZ4.uEl;
            }
            com.tencent.mm.plugin.finder.live.h.a(dfZ3, com.tencent.mm.plugin.finder.utils.y.c(awc));
            AppMethodBeat.o(246200);
        }

        @Override // com.tencent.mm.plugin.appbrand.api.i
        public final void buf() {
            awe awe;
            AppMethodBeat.i(246201);
            StringBuilder sb = new StringBuilder("live:");
            o oVar = o.ujN;
            com.tencent.mm.plugin.finder.live.viewmodel.g dfZ = o.dfZ();
            Log.i("Finder.FinderLiveService", sb.append((dfZ == null || (awe = dfZ.liveInfo) == null) ? null : Long.valueOf(awe.liveId)).append(" onAppBrandProcessDied!").toString());
            o oVar2 = o.ujN;
            com.tencent.mm.plugin.finder.live.viewmodel.g dfZ2 = o.dfZ();
            if (dfZ2 != null) {
                dfZ2.uEr = false;
            }
            o oVar3 = o.ujN;
            o.dfk();
            AppMethodBeat.o(246201);
        }
    }

    public static void dfk() {
        AppMethodBeat.i(246246);
        FinderLiveMiniProProxyUI.a aVar = FinderLiveMiniProProxyUI.ubz;
        int i2 = FinderLiveMiniProProxyUI.ubx;
        if (!Util.isTopApplication(MMApplicationContext.getContext())) {
            FinderLiveMiniProProxyUI.a aVar2 = FinderLiveMiniProProxyUI.ubz;
            i2 = FinderLiveMiniProProxyUI.uby;
        }
        Context context = MMApplicationContext.getContext();
        kotlin.g.b.p.g(context, "MMApplicationContext.getContext()");
        ab(context, i2);
        AppMethodBeat.o(246246);
    }

    public static /* synthetic */ void fo(Context context) {
        AppMethodBeat.i(246248);
        FinderLiveMiniProProxyUI.a aVar = FinderLiveMiniProProxyUI.ubz;
        ab(context, FinderLiveMiniProProxyUI.ubx);
        AppMethodBeat.o(246248);
    }

    private static void ab(Context context, int i2) {
        AppMethodBeat.i(246247);
        kotlin.g.b.p.h(context, "context");
        Log.i("Finder.FinderLiveService", "closeMiniProgram,purpose:".concat(String.valueOf(i2)));
        d.a aVar = com.tencent.mm.plugin.finder.live.viewmodel.d.uCw;
        com.tencent.mm.plugin.finder.live.viewmodel.d.uCv.clear();
        Intent intent = new Intent();
        FinderLiveMiniProProxyUI.a aVar2 = FinderLiveMiniProProxyUI.ubz;
        intent.putExtra(FinderLiveMiniProProxyUI.ubu, i2);
        intent.addFlags(335544320);
        intent.setClass(context, FinderLiveMiniProProxyUI.class);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/finder/live/model/FinderLiveService", "closeMiniProgram", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        context.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/finder/live/model/FinderLiveService", "closeMiniProgram", "(Landroid/content/Context;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(246247);
    }

    public static boolean isAnchorLiving() {
        AppMethodBeat.i(246249);
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar = ujz;
        if (gVar == null || gVar.liveInfo.liveId == 0 || gVar.djl() || !dMz) {
            AppMethodBeat.o(246249);
            return false;
        }
        AppMethodBeat.o(246249);
        return true;
    }

    public static boolean isVisitorLiving() {
        AppMethodBeat.i(246250);
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar = ujz;
        if (gVar == null || gVar.liveInfo.liveId == 0 || gVar.djl() || dMz) {
            AppMethodBeat.o(246250);
            return false;
        }
        AppMethodBeat.o(246250);
        return true;
    }

    public static int dgk() {
        AppMethodBeat.i(246251);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        int intValue = com.tencent.mm.plugin.finder.storage.c.dwA().value().intValue();
        Log.i("Finder.FinderLiveService", "mirroMode:".concat(String.valueOf(intValue)));
        AppMethodBeat.o(246251);
        return intValue;
    }

    public static boolean dgl() {
        com.tencent.mm.live.core.core.b.f fVar;
        com.tencent.mm.live.core.core.b.f fVar2;
        com.tencent.mm.live.core.core.b.d dVar;
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar;
        com.tencent.mm.live.core.core.b.f fVar3;
        com.tencent.mm.live.core.core.b.d dVar2;
        boolean z2 = true;
        AppMethodBeat.i(246252);
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar2 = ujz;
        if (gVar2 != null) {
            fVar = gVar2.hIy;
        } else {
            fVar = null;
        }
        if (fVar == null || !((gVar = ujz) == null || (fVar3 = gVar.hIy) == null || (dVar2 = fVar3.hzt) == null || !dVar2.hzh)) {
            com.tencent.mm.plugin.finder.live.viewmodel.g gVar3 = ujz;
            if (!(gVar3 == null || (fVar2 = gVar3.hIy) == null || (dVar = fVar2.hzt) == null)) {
                z2 = dVar.hzk;
            }
            Log.i("Finder.FinderLiveService", "use front camera, finalMirror:".concat(String.valueOf(z2)));
        } else {
            z2 = false;
            Log.i("Finder.FinderLiveService", "use back camera, finalMirror:false");
        }
        AppMethodBeat.o(246252);
        return z2;
    }

    public static boolean dgm() {
        boolean z2;
        AppMethodBeat.i(246253);
        String str = Build.MODEL;
        kotlin.g.b.p.g(str, "Build.MODEL");
        if (str == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type java.lang.String");
            AppMethodBeat.o(246253);
            throw tVar;
        }
        String lowerCase = str.toLowerCase();
        kotlin.g.b.p.g(lowerCase, "(this as java.lang.String).toLowerCase()");
        if (!kotlin.n.n.a((CharSequence) uju, (CharSequence) lowerCase, false)) {
            z2 = true;
        } else {
            z2 = false;
        }
        Log.i("Finder.FinderLiveService", "enableDynamicVideoParam notSupportDynamicVideoParamDevice:" + uju + " model:" + lowerCase + " result:" + z2);
        AppMethodBeat.o(246253);
        return z2;
    }

    public static com.tencent.mm.live.core.core.d.b hTg() {
        AppMethodBeat.i(260494);
        if (hSS == null || !(hSS instanceof com.tencent.mm.live.core.core.d.b)) {
            AppMethodBeat.o(260494);
            return null;
        }
        com.tencent.mm.live.core.core.trtc.a aVar = hSS;
        if (aVar == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.live.core.core.visitor.LiveVisitorTRTCCore");
            AppMethodBeat.o(260494);
            throw tVar;
        }
        com.tencent.mm.live.core.core.d.b bVar = (com.tencent.mm.live.core.core.d.b) aVar;
        AppMethodBeat.o(260494);
        return bVar;
    }

    public static com.tencent.mm.live.core.core.a.b hTh() {
        AppMethodBeat.i(260495);
        if (hSS == null || !(hSS instanceof com.tencent.mm.live.core.core.a.b)) {
            AppMethodBeat.o(260495);
            return null;
        }
        com.tencent.mm.live.core.core.trtc.a aVar = hSS;
        if (aVar == null) {
            kotlin.t tVar = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.live.core.core.anchor.LiveAnchorTRTCCore");
            AppMethodBeat.o(260495);
            throw tVar;
        }
        com.tencent.mm.live.core.core.a.b bVar = (com.tencent.mm.live.core.core.a.b) aVar;
        AppMethodBeat.o(260495);
        return bVar;
    }

    public static final /* synthetic */ void dgu() {
        int i2;
        int i3;
        aus aus;
        AppMethodBeat.i(246258);
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar = ujz;
        if (gVar != null) {
            Log.i("Finder.FinderLiveService", "doGetLiveMsg heartBeatTimestamp:" + ujC + " [" + ujz + "]，cookie:" + Util.encodeHexString(gVar.hIt));
            com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
            if (com.tencent.mm.plugin.finder.utils.m.dBP()) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            avk avk = null;
            if (gVar.uET) {
                j jVar = j.ujh;
                avk = j.d(Long.valueOf(ujC));
            }
            am amVar = am.tuw;
            aov cXY = am.cXY();
            String aUg = com.tencent.mm.model.z.aUg();
            byte[] bArr = gVar.hIt;
            long j2 = gVar.liveInfo.liveId;
            long j3 = gVar.hFK;
            String str = gVar.hwg;
            com.tencent.mm.plugin.finder.live.viewmodel.g gVar2 = ujz;
            if (gVar2 == null || (aus = gVar2.UQh) == null) {
                i3 = 4;
            } else {
                i3 = aus.LFy;
            }
            new com.tencent.mm.plugin.finder.live.model.cgi.h(cXY, aUg, bArr, j2, j3, str, i2, false, avk, i3, new d(gVar), 128).aYI();
            ujC = System.currentTimeMillis();
            AppMethodBeat.o(246258);
            return;
        }
        AppMethodBeat.o(246258);
    }

    public static final /* synthetic */ void dgv() {
        int i2;
        AppMethodBeat.i(246259);
        Log.i("Finder.FinderLiveService", "doKeepLive[" + ujz + ']');
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar = ujz;
        if (gVar != null) {
            com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
            if (com.tencent.mm.plugin.finder.utils.m.dBP()) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            new com.tencent.mm.plugin.finder.live.model.cgi.i(gVar.liveInfo.liveId, gVar.hIt, com.tencent.mm.model.z.aUg(), gVar.hFK, i2, gVar.hwg, gVar.sessionBuffer, new e()).aYI();
            AppMethodBeat.o(246259);
            return;
        }
        AppMethodBeat.o(246259);
    }

    public static final /* synthetic */ void dgw() {
        int i2;
        AppMethodBeat.i(246260);
        Log.i("Finder.FinderLiveService", "doRefreshMic[" + ujz + ']');
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar = ujz;
        if (gVar != null) {
            com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
            if (com.tencent.mm.plugin.finder.utils.m.dBP()) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            s sVar = ujx;
            if (sVar != null) {
                sVar.a(gVar.liveInfo.liveId, gVar.hFK, gVar.hwg, gVar.hIt, i2, gVar.djq(), new f());
                AppMethodBeat.o(246260);
                return;
            }
            AppMethodBeat.o(246260);
            return;
        }
        AppMethodBeat.o(246260);
    }

    public static final /* synthetic */ void hTk() {
        com.tencent.mm.plugin.finder.live.viewmodel.e eVar;
        s sVar;
        AppMethodBeat.i(260497);
        Log.i("Finder.FinderLiveService", "doActivateMic curLiveRoomData:" + ujz + " isAnchor:" + dMz);
        com.tencent.mm.plugin.finder.live.viewmodel.g gVar = ujz;
        if (gVar == null) {
            AppMethodBeat.o(260497);
        } else if (!dMz || (eVar = gVar.uEB) == null) {
            AppMethodBeat.o(260497);
        } else {
            Log.i("Finder.FinderLiveService", "doActivateMic curLinkUser:" + ujz);
            if (!eVar.UPN || (sVar = ujx) == null) {
                AppMethodBeat.o(260497);
                return;
            }
            sVar.a(gVar.liveInfo.liveId, gVar.hFK, gVar.hwg, gVar.hIt, eVar.sessionId, new y());
            AppMethodBeat.o(260497);
        }
    }
}
