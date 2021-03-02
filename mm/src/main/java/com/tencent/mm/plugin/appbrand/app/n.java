package com.tencent.mm.plugin.appbrand.app;

import android.content.SharedPreferences;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.ServerProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ch;
import com.tencent.mm.g.a.fp;
import com.tencent.mm.g.a.ho;
import com.tencent.mm.g.a.l;
import com.tencent.mm.g.a.lr;
import com.tencent.mm.g.a.ma;
import com.tencent.mm.g.a.mq;
import com.tencent.mm.g.a.o;
import com.tencent.mm.g.a.q;
import com.tencent.mm.g.a.qs;
import com.tencent.mm.g.a.s;
import com.tencent.mm.g.a.t;
import com.tencent.mm.g.a.yj;
import com.tencent.mm.g.a.yw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.cj;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.plugin.appbrand.ac.m;
import com.tencent.mm.plugin.appbrand.app.b;
import com.tencent.mm.plugin.appbrand.appcache.ag;
import com.tencent.mm.plugin.appbrand.appcache.au;
import com.tencent.mm.plugin.appbrand.appcache.ax;
import com.tencent.mm.plugin.appbrand.appcache.be;
import com.tencent.mm.plugin.appbrand.appcache.bh;
import com.tencent.mm.plugin.appbrand.appcache.bj;
import com.tencent.mm.plugin.appbrand.appcache.bm;
import com.tencent.mm.plugin.appbrand.appcache.predownload.b.j;
import com.tencent.mm.plugin.appbrand.appstorage.d;
import com.tencent.mm.plugin.appbrand.appstorage.h;
import com.tencent.mm.plugin.appbrand.appusage.ar;
import com.tencent.mm.plugin.appbrand.appusage.t;
import com.tencent.mm.plugin.appbrand.appusage.u;
import com.tencent.mm.plugin.appbrand.appusage.x;
import com.tencent.mm.plugin.appbrand.backgroundrunning.AppBrandBackgroundRunningApp;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.aa;
import com.tencent.mm.plugin.appbrand.config.e;
import com.tencent.mm.plugin.appbrand.config.q;
import com.tencent.mm.plugin.appbrand.config.y;
import com.tencent.mm.plugin.appbrand.config.z;
import com.tencent.mm.plugin.appbrand.game.b.a.b;
import com.tencent.mm.plugin.appbrand.launching.ao;
import com.tencent.mm.plugin.appbrand.launching.at;
import com.tencent.mm.plugin.appbrand.media.music.a;
import com.tencent.mm.plugin.appbrand.task.a.c;
import com.tencent.mm.plugin.appbrand.task.h;
import com.tencent.mm.plugin.appbrand.ui.AppBrandGuideUI;
import com.tencent.mm.plugin.appbrand.ui.banner.AppBrandStickyBannerLogic;
import com.tencent.mm.plugin.appbrand.widget.f;
import com.tencent.mm.plugin.appbrand.widget.i;
import com.tencent.mm.pluginsdk.model.x;
import com.tencent.mm.protocal.j;
import com.tencent.mm.protocal.x;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bw;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storagebase.h;
import com.tencent.xweb.WebView;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.xwalk.core.XWalkEnvironment;

public final class n implements bd {
    private static volatile d kIX;
    private static volatile e kIY;
    private static volatile bh kIZ;
    private static volatile x kJa;
    private static volatile z kJb;
    private static volatile ao kJc;
    private static volatile f kJd;
    private static volatile i kJe;
    private static volatile r.a kJf;
    private static volatile com.tencent.mm.plugin.appbrand.widget.n kJg;
    private static volatile com.tencent.mm.ag.a.d kJh;
    private static volatile com.tencent.mm.plugin.appbrand.ab.a kJi;
    private static volatile ag kJj;
    private static volatile b kJk;
    private static volatile at kJl;
    private static volatile ax kJm;
    private static volatile bm kJn;
    private static volatile c kJo;
    private static com.tencent.mm.plugin.appbrand.b.c kJp;
    private static com.tencent.mm.plugin.appbrand.b.b kJq;
    private MStorage.IOnStorageChange iHr = new MStorage.IOnStorageChange() {
        /* class com.tencent.mm.plugin.appbrand.app.n.AnonymousClass32 */

        @Override // com.tencent.mm.sdk.storage.MStorage.IOnStorageChange
        public final void onNotifyChange(String str, MStorageEventData mStorageEventData) {
            AppMethodBeat.i(226343);
            if (str != null && str.length() > 0 && "event_updated".equals(str)) {
                n.buV();
                n.buW();
                n.buX();
                n.buY();
                n.buZ();
            }
            AppMethodBeat.o(226343);
        }
    };
    private final p iRt = new p.a() {
        /* class com.tencent.mm.plugin.appbrand.app.n.AnonymousClass27 */

        {
            AppMethodBeat.i(160588);
            AppMethodBeat.o(160588);
        }

        @Override // com.tencent.mm.network.p
        public final void onNetworkChange(int i2) {
            AppMethodBeat.i(226336);
            if (MMApplicationContext.isMainProcess()) {
                h.bWb().onNetworkChange();
            }
            j.INSTANCE.bwR();
            AppMethodBeat.o(226336);
        }
    };
    private final IListener<s> kJA = new IListener<s>() {
        /* class com.tencent.mm.plugin.appbrand.app.n.AnonymousClass19 */

        {
            AppMethodBeat.i(160582);
            this.__eventId = s.class.getName().hashCode();
            AppMethodBeat.o(160582);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(s sVar) {
            AppMethodBeat.i(44186);
            s sVar2 = sVar;
            if (!Util.isNullOrNil(sVar2.dCF.dCl)) {
                String str = sVar2.dCF.dCl;
                n.NL().cN(str + "_unreadCount", new StringBuilder().append(sVar2.dCF.dCm).toString());
                com.tencent.mm.plugin.appbrand.ipc.e.bI(y.Xw(str), sVar2.dCF.dCm);
            }
            AppMethodBeat.o(44186);
            return false;
        }
    };
    private final IListener<q> kJB = new IListener<q>() {
        /* class com.tencent.mm.plugin.appbrand.app.n.AnonymousClass20 */

        {
            AppMethodBeat.i(160583);
            this.__eventId = q.class.getName().hashCode();
            AppMethodBeat.o(160583);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(q qVar) {
            AppMethodBeat.i(44187);
            Log.i("MicroMsg.AppBrandCommonKVDataStorage", "sql:%s, updateRet : %b", "update AppBrandCommonKVData set value = '0' where key like '%_unreadCount'", Boolean.valueOf(n.NL().kLX.execSQL("AppBrandCommonKVData", "update AppBrandCommonKVData set value = '0' where key like '%_unreadCount'")));
            AppMethodBeat.o(44187);
            return true;
        }
    };
    private final IListener<yj> kJC = new IListener<yj>() {
        /* class com.tencent.mm.plugin.appbrand.app.n.AnonymousClass21 */

        {
            AppMethodBeat.i(160584);
            this.__eventId = yj.class.getName().hashCode();
            AppMethodBeat.o(160584);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(yj yjVar) {
            AppMethodBeat.i(44188);
            yj yjVar2 = yjVar;
            if (Boolean.valueOf(n.NL().get(q.a.Xj(yjVar2.eeG.appId), ServerProtocol.DIALOG_RETURN_SCOPES_TRUE)).booleanValue() == yjVar2.eeG.dCs) {
                Log.i("MicroMsg.SubCoreAppBrand", "update with same value, appId:%s", yjVar2.eeG.appId);
                AppMethodBeat.o(44188);
            } else {
                n.NL().cN(q.a.Xj(yjVar2.eeG.appId), Boolean.toString(yjVar2.eeG.dCs));
                o oVar = new o();
                oVar.dCr.appId = yjVar2.eeG.appId;
                oVar.dCr.dCs = yjVar2.eeG.dCs;
                EventCenter.instance.publish(oVar);
                AppMethodBeat.o(44188);
            }
            return true;
        }
    };
    private final IListener<l> kJD = new IListener<l>() {
        /* class com.tencent.mm.plugin.appbrand.app.n.AnonymousClass22 */

        {
            AppMethodBeat.i(160585);
            this.__eventId = l.class.getName().hashCode();
            AppMethodBeat.o(160585);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(l lVar) {
            AppMethodBeat.i(44189);
            l lVar2 = lVar;
            if (lVar2 == null || lVar2.dCi == null) {
                AppMethodBeat.o(44189);
            } else if (lVar2.dCi.isActive) {
                AppMethodBeat.o(44189);
            } else if (!g.aAf().hpY) {
                AppMethodBeat.o(44189);
            } else {
                au.gH(false);
                m.bZn().postToWorker(new Runnable() {
                    /* class com.tencent.mm.plugin.appbrand.appusage.j.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(44479);
                        if (!g.aAc()) {
                            AppMethodBeat.o(44479);
                        } else if (i.bxP()) {
                            AppMethodBeat.o(44479);
                        } else {
                            j jVar = j.this;
                            v.bym();
                            j.a(jVar, 2, 0, 7, 0, true, null, -1, -1, null);
                            AppMethodBeat.o(44479);
                        }
                    }
                });
                com.tencent.mm.plugin.appbrand.appcache.predownload.b.bwH();
                j.INSTANCE.bwR();
                n.W(com.tencent.mm.plugin.appbrand.appcache.predownload.e.e.class);
                com.tencent.mm.plugin.appbrand.appusage.a.g.gN(false);
                AppMethodBeat.o(44189);
            }
            return false;
        }
    };
    private final IListener<com.tencent.mm.g.a.p> kJE = new IListener<com.tencent.mm.g.a.p>() {
        /* class com.tencent.mm.plugin.appbrand.app.n.AnonymousClass24 */

        {
            AppMethodBeat.i(226334);
            this.__eventId = com.tencent.mm.g.a.p.class.getName().hashCode();
            AppMethodBeat.o(226334);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(com.tencent.mm.g.a.p pVar) {
            AppMethodBeat.i(226335);
            com.tencent.mm.g.a.p pVar2 = pVar;
            com.tencent.mm.plugin.appbrand.report.i.a(pVar2.dCt.dCu, pVar2.dCt.appId, pVar2.dCt.appVersion, pVar2.dCt.dCv, pVar2.dCt.scene, pVar2.dCt.dCw, pVar2.dCt.dCx, pVar2.dCt.action, pVar2.dCt.dCy, pVar2.dCt.dCz, pVar2.dCt.dCA, pVar2.dCt.dCB, pVar2.dCt.dCC);
            AppMethodBeat.o(226335);
            return true;
        }
    };
    private final IListener<ch> kJF = new IListener<ch>() {
        /* class com.tencent.mm.plugin.appbrand.app.n.AnonymousClass25 */

        {
            AppMethodBeat.i(160586);
            this.__eventId = ch.class.getName().hashCode();
            AppMethodBeat.o(160586);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ch chVar) {
            WxaAttributes d2;
            AppMethodBeat.i(44191);
            ch chVar2 = chVar;
            if (!Util.isNullOrNil(chVar2.dFr.username) && g.aAf().hpY && (d2 = n.buC().d(chVar2.dFr.username, "roundedSquareIconURL", "brandIconURL", "bigHeadURL", "appId", "nickname")) != null) {
                chVar2.dFs.cze = new String[]{d2.field_roundedSquareIconURL, d2.field_brandIconURL, d2.field_bigHeadURL};
                chVar2.dFs.appId = d2.field_appId;
                chVar2.dFs.nickname = d2.field_nickname;
            }
            AppMethodBeat.o(44191);
            return true;
        }
    };
    private final IListener<lr> kJG = new IListener<lr>() {
        /* class com.tencent.mm.plugin.appbrand.app.n.AnonymousClass26 */

        {
            AppMethodBeat.i(160587);
            this.__eventId = lr.class.getName().hashCode();
            AppMethodBeat.o(160587);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(lr lrVar) {
            AppMethodBeat.i(44192);
            AppBrandStickyBannerLogic.b.R(lrVar.dRb.dRc);
            AppMethodBeat.o(44192);
            return true;
        }
    };
    private final cj.a kJH = new be();
    private IListener kJI = new IListener<ho>() {
        /* class com.tencent.mm.plugin.appbrand.app.n.AnonymousClass28 */

        {
            AppMethodBeat.i(226337);
            this.__eventId = ho.class.getName().hashCode();
            AppMethodBeat.o(226337);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ho hoVar) {
            AppMethodBeat.i(226338);
            ho hoVar2 = hoVar;
            Log.i("MicroMsg.SubCoreAppBrand", "FetchAppBrandInfoForMusicEvent callback");
            hoVar2.dMd.appId = a.C0751a.bOR().ncY;
            hoVar2.dMd.appUserName = a.C0751a.bOR().appUserName;
            hoVar2.dMd.brandName = a.C0751a.bOR().brandName;
            hoVar2.dMd.dMe = a.C0751a.bOR().dMe;
            WxaAttributes d2 = n.buC().d(hoVar2.dMd.appUserName, "roundedSquareIconURL", "brandIconURL", "bigHeadURL");
            if (d2 != null) {
                hoVar2.dMd.dMf = d2.field_brandIconURL;
            }
            AppMethodBeat.o(226338);
            return true;
        }
    };
    private IListener kJJ = new IListener<com.tencent.mm.g.a.d>() {
        /* class com.tencent.mm.plugin.appbrand.app.n.AnonymousClass29 */

        {
            AppMethodBeat.i(160589);
            this.__eventId = com.tencent.mm.g.a.d.class.getName().hashCode();
            AppMethodBeat.o(160589);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(com.tencent.mm.g.a.d dVar) {
            AppMethodBeat.i(44195);
            if (!dVar.dBP.dBQ) {
                ((com.tencent.mm.modelappbrand.g) g.af(com.tencent.mm.modelappbrand.g.class)).aXH().exit();
            }
            AppMethodBeat.o(44195);
            return false;
        }
    };
    private final IListener<l> kJK = new IListener<l>() {
        /* class com.tencent.mm.plugin.appbrand.app.n.AnonymousClass30 */

        {
            AppMethodBeat.i(226339);
            this.__eventId = l.class.getName().hashCode();
            AppMethodBeat.o(226339);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(l lVar) {
            AppMethodBeat.i(226340);
            l lVar2 = lVar;
            if (lVar2 != null && lVar2.dCi.isActive) {
                com.tencent.mm.plugin.appbrand.backgroundfetch.b.byO();
            }
            AppMethodBeat.o(226340);
            return false;
        }
    };
    private final IListener<t> kJL = new IListener<t>() {
        /* class com.tencent.mm.plugin.appbrand.app.n.AnonymousClass31 */

        {
            AppMethodBeat.i(226341);
            this.__eventId = t.class.getName().hashCode();
            AppMethodBeat.o(226341);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(t tVar) {
            AppMethodBeat.i(226342);
            Log.i("MicroMsg.SubCoreAppBrand", "callback AppBrandVoipCheckIsDeviceUsingEvent true");
            n.a(tVar);
            AppMethodBeat.o(226342);
            return false;
        }
    };
    private final AppBrandGuideUI.a kJM = new AppBrandGuideUI.a();
    private final IListener<fp> kJN = new IListener<fp>() {
        /* class com.tencent.mm.plugin.appbrand.app.n.AnonymousClass33 */

        {
            AppMethodBeat.i(226344);
            this.__eventId = fp.class.getName().hashCode();
            AppMethodBeat.o(226344);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(fp fpVar) {
            AppMethodBeat.i(226345);
            com.tencent.mm.plugin.appbrand.ui.recommend.d.ofe.bYV();
            AppMethodBeat.o(226345);
            return false;
        }
    };
    private bw.a kJr = new com.tencent.mm.plugin.appbrand.z.a();
    private com.tencent.mm.vending.b.b kJs = null;
    private final com.tencent.mm.plugin.auth.a.b kJt = new com.tencent.mm.plugin.auth.a.b() {
        /* class com.tencent.mm.plugin.appbrand.app.n.AnonymousClass13 */

        {
            AppMethodBeat.i(160576);
            AppMethodBeat.o(160576);
        }

        @Override // com.tencent.mm.plugin.auth.a.b
        public final void a(j.h hVar, j.i iVar, boolean z) {
            boolean z2;
            boolean z3 = false;
            AppMethodBeat.i(226333);
            if (iVar != null && (iVar instanceof j.g)) {
                com.tencent.mm.plugin.appbrand.appusage.j.bxQ().bxR();
                au.gH(true);
            }
            if (!z || !(hVar instanceof j.a) || hVar.getSceneStatus() != 12) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (z2) {
                au.gH(true);
            }
            if (((hVar instanceof j.f) && hVar.getSceneStatus() == 1) || ((hVar instanceof j.a) && hVar.getSceneStatus() == 12)) {
                z3 = true;
            }
            if (z3) {
                com.tencent.mm.plugin.appbrand.appusage.a.g.gN(true);
            }
            AppMethodBeat.o(226333);
        }

        @Override // com.tencent.mm.plugin.auth.a.b
        public final void a(x.b bVar, String str, int i2, String str2, String str3, int i3) {
        }
    };
    private final Set<IListener> kJu = new HashSet();
    private final IListener<ma> kJv = new IListener<ma>() {
        /* class com.tencent.mm.plugin.appbrand.app.n.AnonymousClass14 */

        {
            AppMethodBeat.i(160577);
            this.__eventId = ma.class.getName().hashCode();
            AppMethodBeat.o(160577);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ma maVar) {
            AppMethodBeat.i(44181);
            switch (maVar.dRA.bDZ) {
                case 1:
                case 3:
                    h.bWb().zn(1);
                    break;
                case 2:
                default:
                    h.bWb().zn(3);
                    break;
            }
            com.tencent.mm.plugin.appbrand.dynamic.h.b.bCn();
            AppMethodBeat.o(44181);
            return true;
        }
    };
    private final IListener<yw> kJw = new IListener<yw>() {
        /* class com.tencent.mm.plugin.appbrand.app.n.AnonymousClass15 */

        {
            AppMethodBeat.i(160578);
            this.__eventId = yw.class.getName().hashCode();
            AppMethodBeat.o(160578);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(yw ywVar) {
            boolean z = true;
            AppMethodBeat.i(44182);
            yw ywVar2 = ywVar;
            if (Util.isNullOrNil(ywVar2.efe.dCl)) {
                AppMethodBeat.o(44182);
            } else {
                y.bAj();
                String str = ywVar2.efe.dCl;
                int i2 = ywVar2.efe.option;
                if (ywVar2.efe.action != 1) {
                    z = false;
                }
                ywVar2.eff.efg = y.k(str, i2, z);
                AppMethodBeat.o(44182);
            }
            return false;
        }
    };
    private final IListener<mq> kJx = new IListener<mq>() {
        /* class com.tencent.mm.plugin.appbrand.app.n.AnonymousClass16 */

        {
            AppMethodBeat.i(160579);
            this.__eventId = mq.class.getName().hashCode();
            AppMethodBeat.o(160579);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(mq mqVar) {
            AppMethodBeat.i(44183);
            as asVar = mqVar.dSg.dSh;
            if (as.HF(asVar.field_username)) {
                asVar.setType(0);
                aa.XD(asVar.field_username);
            }
            AppMethodBeat.o(44183);
            return false;
        }
    };
    private final IListener<qs> kJy = new IListener<qs>() {
        /* class com.tencent.mm.plugin.appbrand.app.n.AnonymousClass17 */

        {
            AppMethodBeat.i(160580);
            this.__eventId = qs.class.getName().hashCode();
            AppMethodBeat.o(160580);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(qs qsVar) {
            int i2;
            AppMethodBeat.i(44184);
            ca caVar = qsVar.dXi.dCM;
            if (caVar != null) {
                String str = caVar.field_talker;
                if (as.HF(str)) {
                    n.NL().cN(str + "_unreadCount", String.valueOf(Util.getInt(n.NL().get(str + "_unreadCount", AppEventsConstants.EVENT_PARAM_VALUE_NO), 0) + 1));
                    az bjY = ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().bjY(str);
                    if (bjY != null) {
                        i2 = bjY.field_unReadCount;
                    } else {
                        i2 = 0;
                    }
                    com.tencent.mm.plugin.appbrand.ipc.e.bI(y.Xw(str), i2);
                }
            }
            AppMethodBeat.o(44184);
            return false;
        }
    };
    private final IListener<com.tencent.mm.g.a.m> kJz = new IListener<com.tencent.mm.g.a.m>() {
        /* class com.tencent.mm.plugin.appbrand.app.n.AnonymousClass18 */

        {
            AppMethodBeat.i(160581);
            this.__eventId = com.tencent.mm.g.a.m.class.getName().hashCode();
            AppMethodBeat.o(160581);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(com.tencent.mm.g.a.m mVar) {
            AppMethodBeat.i(44185);
            com.tencent.mm.g.a.m mVar2 = mVar;
            if (!Util.isNullOrNil(mVar2.dCj.dCl)) {
                mVar2.dCk.dCm = Util.getInt(n.NL().get(mVar2.dCj.dCl + "_unreadCount", AppEventsConstants.EVENT_PARAM_VALUE_NO), 0);
            }
            AppMethodBeat.o(44185);
            return false;
        }
    };

    private HashMap<Integer, h.b> bux() {
        AppMethodBeat.i(44197);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        hashMap.put(Integer.valueOf("AppKVStorageDBCreate".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.appbrand.app.n.AnonymousClass1 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return d.SQL_CREATE;
            }
        });
        hashMap.put(Integer.valueOf("AppBrandWxaPkgStorageDBCreate".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.appbrand.app.n.AnonymousClass12 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return bh.kNI;
            }
        });
        hashMap.put(Integer.valueOf("AppBrandCommonConfigStorageCreate".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.appbrand.app.n.AnonymousClass23 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return e.iBh;
            }
        });
        hashMap.put(Integer.valueOf("AppBrandLayoutStorageCreate".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.appbrand.app.n.AnonymousClass34 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.plugin.appbrand.appusage.x.iBh;
            }
        });
        hashMap.put(Integer.valueOf("AppBrandStarAppStorageCreate".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.appbrand.app.n.AnonymousClass35 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return u.iBh;
            }
        });
        hashMap.put(Integer.valueOf("WxaAttributesTableCreate".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.appbrand.app.n.AnonymousClass36 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                AppMethodBeat.i(226346);
                String[] strArr = {MAutoStorage.getCreateSQLs(WxaAttributes.kLR, "WxaAttributesTable")};
                AppMethodBeat.o(226346);
                return strArr;
            }
        });
        hashMap.put(Integer.valueOf("LaunchWxaAppInfoCreate".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.appbrand.app.n.AnonymousClass37 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return new String[]{ao.mWc};
            }
        });
        hashMap.put(Integer.valueOf("DynamicMsgCacheDataCreate".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.appbrand.app.n.AnonymousClass38 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return f.iBh;
            }
        });
        hashMap.put(Integer.valueOf("LaunchWxaWidgetCacheCreate".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.appbrand.app.n.AnonymousClass39 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return new String[]{i.mWc};
            }
        });
        hashMap.put(Integer.valueOf("WxaWidgetInfoStorageCreate".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.appbrand.app.n.AnonymousClass2 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.plugin.appbrand.widget.n.iBh;
            }
        });
        hashMap.put(Integer.valueOf("WxaUpdateableMsgStorageCreate".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.appbrand.app.n.AnonymousClass3 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.ag.a.d.iBh;
            }
        });
        hashMap.put(Integer.valueOf("AppBrandCommonKVBinaryDataStorage".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.appbrand.app.n.AnonymousClass4 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.plugin.appbrand.ab.a.iBh;
            }
        });
        hashMap.put(Integer.valueOf("PkgUpdateStatsStorage".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.appbrand.app.n.AnonymousClass5 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return ag.iBh;
            }
        });
        hashMap.put(Integer.valueOf("MiniGameInfoStorage".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.appbrand.app.n.AnonymousClass6 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return b.iBh;
            }
        });
        hashMap.put(Integer.valueOf("AppBrandRecommendCardStorage".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.appbrand.app.n.AnonymousClass7 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return com.tencent.mm.plugin.appbrand.appusage.a.b.iBh;
            }
        });
        hashMap.put(Integer.valueOf("LaunchWxaJsApiPluginInfoStorage".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.appbrand.app.n.AnonymousClass8 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return at.iBh;
            }
        });
        hashMap.put(Integer.valueOf("AppBrandTaskWxaCheckDemoInfoStorage".hashCode()), new h.b() {
            /* class com.tencent.mm.plugin.appbrand.app.n.AnonymousClass9 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return c.iBh;
            }
        });
        for (Map.Entry<b.a, String[]> entry : b.kHX.entrySet()) {
            final String[] value = entry.getValue();
            hashMap.put(Integer.valueOf(entry.getKey().hashCode()), new h.b() {
                /* class com.tencent.mm.plugin.appbrand.app.n.AnonymousClass10 */

                @Override // com.tencent.mm.storagebase.h.b
                public final String[] getSQLs() {
                    return value;
                }
            });
        }
        AppMethodBeat.o(44197);
        return hashMap;
    }

    public static r.a buy() {
        return kJf;
    }

    public static n buz() {
        n nVar;
        AppMethodBeat.i(44198);
        com.tencent.mm.plugin.appbrand.api.c cVar = (com.tencent.mm.plugin.appbrand.api.c) g.ah(com.tencent.mm.plugin.appbrand.api.c.class);
        if (cVar != null) {
            nVar = ((PluginAppBrand) cVar).getCore();
        } else {
            nVar = null;
        }
        AppMethodBeat.o(44198);
        return nVar;
    }

    public final r.a buA() {
        AppMethodBeat.i(44199);
        String str = g.aAh().cachePath + "AppBrandComm.db";
        if (kJf == null || !str.equals(kJf.getPath())) {
            r.a a2 = r.a(hashCode(), str, bux(), true);
            kJf = a2;
            AppMethodBeat.o(44199);
            return a2;
        }
        r.a aVar = kJf;
        AppMethodBeat.o(44199);
        return aVar;
    }

    @Override // com.tencent.mm.model.bd
    public final HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }

    @Override // com.tencent.mm.model.bd
    public final void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountPostReset(boolean z) {
        Set<String> stringSet;
        AppMethodBeat.i(44200);
        Log.d("MicroMsg.SubCoreAppBrand", "onAccountPostReset updated %b", Boolean.valueOf(z));
        this.kJs = ((com.tencent.mm.plugin.auth.a.c) g.ah(com.tencent.mm.plugin.auth.a.c.class)).addHandleAuthResponse(this.kJt);
        SharedPreferences sharedPreferences = MMApplicationContext.getContext().getSharedPreferences("app_brand_global_sp", 0);
        if (!(sharedPreferences == null || (stringSet = sharedPreferences.getStringSet("uin_set", new HashSet())) == null)) {
            StringBuilder sb = new StringBuilder();
            g.aAf();
            if (stringSet.add(sb.append(com.tencent.mm.kernel.a.getUin()).toString())) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.remove("uin_set");
                edit.commit();
                edit.putStringSet("uin_set", stringSet);
                edit.commit();
            }
        }
        for (IListener iListener : this.kJu) {
            iListener.alive();
        }
        com.tencent.mm.plugin.appbrand.floatball.b.bCE();
        for (String str : be.kNv.keySet()) {
            ((com.tencent.mm.plugin.messenger.foundation.a.s) g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a(str, this.kJH, true);
        }
        t.b.LW();
        ar arVar = ar.kWH;
        com.tencent.mm.kernel.b.a ah = g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class);
        kotlin.g.b.p.g(ah, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.s) ah).getSysCmdMsgExtension().a("UpdateWxaUsageListNotify", (cj.a) arVar, true);
        ar.appForegroundListener.alive();
        ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().c(this.kJr);
        buA();
        kIX = new d(kJf);
        kIY = new e(kJf);
        kIZ = new bh(kJf);
        kJa = new com.tencent.mm.plugin.appbrand.appusage.x(kJf);
        kJc = new ao(kJf);
        kJd = new f(kJf);
        kJe = new i(kJf);
        kJg = new com.tencent.mm.plugin.appbrand.widget.n(kJf);
        kJh = new com.tencent.mm.ag.a.d(kJf);
        kJi = new com.tencent.mm.plugin.appbrand.ab.a(kJf);
        kJj = new ag(kJf);
        kJk = new com.tencent.mm.plugin.appbrand.game.b.a.b(kJf);
        kJl = new at(kJf);
        kJm = new ax();
        kJn = new bm();
        kJo = new c(kJf);
        buC();
        b.a(kJf);
        com.tencent.mm.plugin.appbrand.l.setup();
        y.bAj();
        ((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).getFTSTaskDaemon().a(-86016, new com.tencent.mm.plugin.fts.a.a.a() {
            /* class com.tencent.mm.plugin.appbrand.app.n.AnonymousClass11 */

            {
                AppMethodBeat.i(160575);
                AppMethodBeat.o(160575);
            }

            @Override // com.tencent.mm.plugin.fts.a.a.a
            public final boolean execute() {
                AppMethodBeat.i(226332);
                com.tencent.mm.plugin.appbrand.j.c cVar = new com.tencent.mm.plugin.appbrand.j.c();
                ((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).registerIndexStorage(cVar);
                cVar.create();
                com.tencent.mm.plugin.appbrand.j.b bVar = new com.tencent.mm.plugin.appbrand.j.b();
                ((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).registerNativeLogic(7, bVar);
                bVar.create();
                ((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).registerFTSUILogic(new com.tencent.mm.plugin.appbrand.j.g());
                ((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).registerFTSUILogic(new com.tencent.mm.plugin.appbrand.j.e());
                AppMethodBeat.o(226332);
                return true;
            }

            @Override // com.tencent.mm.plugin.fts.a.a.a
            public final String getName() {
                return "InitFTSWeAppPluginTask";
            }
        });
        g.aAg().a(this.iRt);
        com.tencent.mm.plugin.appbrand.dynamic.g.initialize();
        com.tencent.mm.model.c.d.aXu().add(this.iHr);
        this.kJN.alive();
        com.tencent.mm.pluginsdk.cmd.b.a(new a((byte) 0), "//xwebdebug");
        com.tencent.mm.plugin.appbrand.config.h.init();
        AppBrandGuideUI.a aVar = this.kJM;
        AppBrandGuideUI.a.bWY().registerActivityLifecycleCallbacks(aVar);
        AppBrandStickyBannerLogic.b.d(aVar);
        aVar.nTE = false;
        com.tencent.mm.plugin.appbrand.floatball.f.bCM();
        com.tencent.mm.plugin.appbrand.floatball.g.bCM();
        com.tencent.mm.plugin.appbrand.keylogger.g.bMT();
        AppMethodBeat.o(44200);
    }

    @Override // com.tencent.mm.model.bd
    public final void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountRelease() {
        AppMethodBeat.i(44201);
        Log.d("MicroMsg.SubCoreAppBrand", "onAccountRelease");
        if (this.kJs != null) {
            this.kJs.dead();
            this.kJs = null;
        }
        for (IListener iListener : this.kJu) {
            iListener.dead();
        }
        com.tencent.mm.plugin.appbrand.floatball.b.bCF();
        com.tencent.mm.plugin.appbrand.l.release();
        for (String str : be.kNv.keySet()) {
            ((com.tencent.mm.plugin.messenger.foundation.a.s) g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b(str, this.kJH, true);
        }
        t.b.unregister();
        ar arVar = ar.kWH;
        com.tencent.mm.kernel.b.a ah = g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class);
        kotlin.g.b.p.g(ah, "MMKernel.plugin(IPluginM…erFoundation::class.java)");
        ((com.tencent.mm.plugin.messenger.foundation.a.s) ah).getSysCmdMsgExtension().b("UpdateWxaUsageListNotify", arVar, true);
        ar.appForegroundListener.dead();
        ((com.tencent.mm.plugin.messenger.foundation.a.l) g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aST().d(this.kJr);
        bj.shutdown();
        kIX = null;
        kJb = null;
        kIY = null;
        kIZ = null;
        kJa = null;
        kJc = null;
        kJd = null;
        kJe = null;
        kJg = null;
        kJh = null;
        kJi = null;
        kJj = null;
        kJk = null;
        kJl = null;
        kJm = null;
        kJn = null;
        kJo = null;
        b.buh();
        if (kJq != null) {
            com.tencent.mm.plugin.appbrand.b.b bVar = kJq;
            bVar.laX.clear();
            bVar.laY.clear();
            kJq = null;
        }
        kJp = null;
        if (kJf != null) {
            kJf.uS(hashCode());
            kJf = null;
        }
        com.tencent.mm.plugin.appbrand.appusage.j.release();
        y.release();
        com.tencent.mm.plugin.appbrand.appcache.predownload.b.j.INSTANCE.cleanup();
        com.tencent.mm.plugin.appbrand.utils.f.bZm();
        ((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).unregisterIndexStorage(512);
        ((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).unregisterNativeLogic(7);
        ((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).unregisterFTSUILogic(144);
        ((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).unregisterFTSUILogic(4224);
        ((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).unregisterIndexStorage(8);
        ((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).unregisterNativeLogic(10);
        ((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).unregisterFTSUILogic(208);
        ((com.tencent.mm.plugin.fts.a.n) g.ah(com.tencent.mm.plugin.fts.a.n.class)).unregisterFTSUILogic(4240);
        g.aAg().b(this.iRt);
        com.tencent.mm.plugin.appbrand.dynamic.g.release();
        com.tencent.mm.model.c.d.aXu().remove(this.iHr);
        this.kJN.dead();
        com.tencent.mm.plugin.appbrand.config.h.release();
        AppBrandGuideUI.a aVar = this.kJM;
        AppBrandGuideUI.a.bWY().unregisterActivityLifecycleCallbacks(aVar);
        AppBrandStickyBannerLogic.b.c(aVar);
        aVar.nTE = false;
        h.a aVar2 = com.tencent.mm.plugin.appbrand.appstorage.h.kSl;
        g.aAf();
        long longValue = new com.tencent.mm.b.p(com.tencent.mm.kernel.a.getUin()).longValue();
        synchronized (com.tencent.mm.plugin.appbrand.appstorage.h.kSk) {
            try {
                com.tencent.mm.plugin.appbrand.appstorage.h.kSk.remove(Long.valueOf(longValue));
                Log.i("AppBrandMMKVStorage", "onAccountRelease remove cache uin:".concat(String.valueOf(longValue)));
                kotlin.x xVar = kotlin.x.SXb;
            } catch (Throwable th) {
                AppMethodBeat.o(44201);
                throw th;
            }
        }
        com.tencent.mm.plugin.appbrand.floatball.f.bCN();
        com.tencent.mm.plugin.appbrand.floatball.g.bCN();
        AppMethodBeat.o(44201);
    }

    public n() {
        AppMethodBeat.i(44202);
        this.kJu.add(this.kJD);
        this.kJu.add(new com.tencent.mm.plugin.appbrand.launching.b());
        this.kJu.add(this.kJE);
        this.kJu.add(this.kJx);
        this.kJu.add(this.kJy);
        this.kJu.add(this.kJw);
        this.kJu.add(new com.tencent.mm.plugin.appbrand.config.g());
        this.kJu.add(this.kJv);
        this.kJu.add(com.tencent.mm.plugin.appbrand.appusage.i.kUr);
        this.kJu.add(this.kJz);
        this.kJu.add(this.kJA);
        this.kJu.add(this.kJB);
        this.kJu.add(this.kJC);
        this.kJu.add(this.kJF);
        this.kJu.add(this.kJG);
        this.kJu.add(this.kJI);
        this.kJu.add(this.kJJ);
        this.kJu.add(this.kJK);
        this.kJu.add(this.kJL);
        AppMethodBeat.o(44202);
    }

    public static AppBrandGuideUI.a buB() {
        AppMethodBeat.i(44203);
        if (buz() == null) {
            AppMethodBeat.o(44203);
            return null;
        }
        AppBrandGuideUI.a aVar = buz().kJM;
        AppMethodBeat.o(44203);
        return aVar;
    }

    public static d NK() {
        return kIX;
    }

    public static z buC() {
        AppMethodBeat.i(44204);
        synchronized (n.class) {
            try {
                if ((kJb == null || !kJb.bAh()) && kJf != null && !kJf.isClose()) {
                    kJb = new z(kJf);
                }
            } catch (Throwable th) {
                AppMethodBeat.o(44204);
                throw th;
            }
        }
        z zVar = kJb;
        AppMethodBeat.o(44204);
        return zVar;
    }

    public static ao buD() {
        return kJc;
    }

    public static i buE() {
        return kJe;
    }

    public static at buF() {
        return kJl;
    }

    public static c buG() {
        return kJo;
    }

    public static com.tencent.mm.plugin.appbrand.widget.n buH() {
        return kJg;
    }

    public static com.tencent.mm.ag.a.d buI() {
        return kJh;
    }

    public static e NL() {
        AppMethodBeat.i(44205);
        if (kIY == null && kJf != null && !kJf.isClose()) {
            kIY = new e(kJf);
        }
        e eVar = kIY;
        AppMethodBeat.o(44205);
        return eVar;
    }

    public static com.tencent.mm.plugin.appbrand.appusage.x buJ() {
        return kJa;
    }

    @Deprecated
    public static u buK() {
        AppMethodBeat.i(44206);
        u uVar = (u) W(u.class);
        AppMethodBeat.o(44206);
        return uVar;
    }

    public static bh buL() {
        return kIZ;
    }

    public static f buM() {
        return kJd;
    }

    public static com.tencent.mm.plugin.appbrand.b.c buN() {
        AppMethodBeat.i(44207);
        if (kJp == null) {
            kJp = new com.tencent.mm.plugin.appbrand.b.c();
        }
        com.tencent.mm.plugin.appbrand.b.c cVar = kJp;
        AppMethodBeat.o(44207);
        return cVar;
    }

    public static com.tencent.mm.plugin.appbrand.b.b buO() {
        AppMethodBeat.i(44208);
        if (kJq == null) {
            kJq = new com.tencent.mm.plugin.appbrand.b.b();
        }
        com.tencent.mm.plugin.appbrand.b.b bVar = kJq;
        AppMethodBeat.o(44208);
        return bVar;
    }

    public static com.tencent.mm.plugin.appbrand.ab.a buP() {
        return kJi;
    }

    public static ag buQ() {
        return kJj;
    }

    public static <T> T W(Class<T> cls) {
        AppMethodBeat.i(44209);
        if (cls == com.tencent.mm.plugin.appbrand.appusage.x.class) {
            T t = (T) kJa;
            AppMethodBeat.o(44209);
            return t;
        } else if (cls == com.tencent.mm.plugin.appbrand.config.x.class || cls == z.class) {
            T t2 = (T) buC();
            AppMethodBeat.o(44209);
            return t2;
        } else {
            T t3 = (T) b.W(cls);
            AppMethodBeat.o(44209);
            return t3;
        }
    }

    public static ax buR() {
        return kJm;
    }

    public static bm buS() {
        return kJn;
    }

    public static com.tencent.mm.plugin.appbrand.backgroundfetch.d buT() {
        AppMethodBeat.i(44210);
        com.tencent.mm.plugin.appbrand.backgroundfetch.d dVar = (com.tencent.mm.plugin.appbrand.backgroundfetch.d) W(com.tencent.mm.plugin.appbrand.backgroundfetch.d.class);
        AppMethodBeat.o(44210);
        return dVar;
    }

    public static com.tencent.mm.plugin.appbrand.backgroundfetch.g buU() {
        AppMethodBeat.i(44211);
        com.tencent.mm.plugin.appbrand.backgroundfetch.g gVar = (com.tencent.mm.plugin.appbrand.backgroundfetch.g) W(com.tencent.mm.plugin.appbrand.backgroundfetch.g.class);
        AppMethodBeat.o(44211);
        return gVar;
    }

    static class a implements com.tencent.mm.pluginsdk.cmd.a {
        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0035, code lost:
            if (r3.equals("turnon") != false) goto L_0x0026;
         */
        @Override // com.tencent.mm.pluginsdk.cmd.a
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean a(android.content.Context r7, java.lang.String[] r8, java.lang.String r9) {
            /*
                r6 = this;
                r0 = 0
                r5 = 44196(0xaca4, float:6.1932E-41)
                r1 = 1
                com.tencent.matrix.trace.core.AppMethodBeat.i(r5)
                int r2 = com.tencent.mm.sdk.platformtools.Log.getLogLevel()
                if (r2 <= r1) goto L_0x0012
                com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
            L_0x0011:
                return r0
            L_0x0012:
                int r2 = r8.length
                r3 = 2
                if (r2 >= r3) goto L_0x001b
                com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
                r0 = r1
                goto L_0x0011
            L_0x001b:
                r3 = r8[r1]
                r2 = -1
                int r4 = r3.hashCode()
                switch(r4) {
                    case -862428388: goto L_0x002e;
                    default: goto L_0x0025;
                }
            L_0x0025:
                r0 = r2
            L_0x0026:
                switch(r0) {
                    case 0: goto L_0x0038;
                    default: goto L_0x0029;
                }
            L_0x0029:
                com.tencent.matrix.trace.core.AppMethodBeat.o(r5)
                r0 = r1
                goto L_0x0011
            L_0x002e:
                java.lang.String r4 = "turnon"
                boolean r3 = r3.equals(r4)
                if (r3 == 0) goto L_0x0025
                goto L_0x0026
            L_0x0038:
                android.content.Context r0 = com.tencent.mm.sdk.platformtools.MMApplicationContext.getContext()
                java.lang.String r2 = "wcwebview"
                int r3 = com.tencent.mm.compatible.util.g.aps()
                android.content.SharedPreferences r0 = r0.getSharedPreferences(r2, r3)
                android.content.SharedPreferences$Editor r0 = r0.edit()
                java.lang.String r2 = "m_bEnableLocalDebug"
                android.content.SharedPreferences$Editor r0 = r0.putBoolean(r2, r1)
                r0.commit()
                goto L_0x0029
                switch-data {-862428388->0x002e, }
                switch-data {0->0x0038, }
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.app.n.a.a(android.content.Context, java.lang.String[], java.lang.String):boolean");
        }
    }

    static /* synthetic */ boolean a(com.tencent.mm.g.a.t tVar) {
        boolean z;
        boolean z2;
        AppMethodBeat.i(226347);
        if (g.af(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class) != null) {
            z = false;
            for (AppBrandBackgroundRunningApp appBrandBackgroundRunningApp : ((com.tencent.mm.plugin.appbrand.backgroundrunning.g) g.af(com.tencent.mm.plugin.appbrand.backgroundrunning.g.class)).byZ()) {
                if (com.tencent.mm.plugin.appbrand.backgroundrunning.c.contains(appBrandBackgroundRunningApp.beL, com.tencent.mm.plugin.appbrand.backgroundrunning.c.APPBRAND_VOIP_1v1.beL)) {
                    Log.i("MicroMsg.SubCoreAppBrand", "checkVoIPDeviceOccupy, already exist wxa using VOIP 1v1, appId:%s", appBrandBackgroundRunningApp.appId);
                    tVar.dCG.dCI = true;
                    if (MultiProcessMMKV.getMMKV(appBrandBackgroundRunningApp.appId + "_wxa_voip").getBoolean("isCameraStart", false)) {
                        Log.i("MicroMsg.SubCoreAppBrand", "isCameraStart true");
                        tVar.dCG.dCH = true;
                        z2 = true;
                        z = z2;
                    }
                }
                z2 = z;
                z = z2;
            }
        } else {
            z = false;
        }
        AppMethodBeat.o(226347);
        return z;
    }

    static /* synthetic */ void buV() {
        int i2;
        AppMethodBeat.i(44213);
        com.tencent.mm.storage.c Fu = com.tencent.mm.model.c.d.aXu().Fu("100249");
        if (Fu.isValid()) {
            i2 = Util.getInt(Fu.gzz().get("appbrand_player"), -1);
        } else {
            i2 = -1;
        }
        MMApplicationContext.getContext().getSharedPreferences("system_config_prefs", com.tencent.mm.compatible.util.g.aps()).edit().putInt("appbrand_video_player", i2).commit();
        Log.i("MicroMsg.SubCoreAppBrand", "check appbrand video ab test[%d]", Integer.valueOf(i2));
        AppMethodBeat.o(44213);
    }

    static /* synthetic */ void buW() {
        AppMethodBeat.i(44214);
        try {
            com.tencent.xweb.y.lC(MMApplicationContext.getContext());
            com.tencent.mm.storage.c Fu = com.tencent.mm.model.c.d.aXu().Fu("100367");
            if (Fu.isValid()) {
                Log.i("MicroMsg.SubCoreAppBrand", "get abtest of webview core");
                Map<String, String> gzz = Fu.gzz();
                if (Util.getInt(gzz.get("WebCoreTestFlag"), 0) == 1) {
                    Log.i("MicroMsg.SubCoreAppBrand", "abtest of webview core is on");
                    int i2 = Util.getInt(gzz.get("ModuleToolsType"), 2);
                    int i3 = Util.getInt(gzz.get("ModuleAppbrandType"), 2);
                    int i4 = Util.getInt(gzz.get("ModuleSupportType"), 2);
                    Log.i("MicroMsg.SubCoreAppBrand", "moduleToolsType:" + i2 + ";moduleAppbrandType:" + i3 + ";moduleSupportType" + i4 + ":jsRuntimeType" + Util.getInt(gzz.get("JsRuntimeType"), 0));
                    com.tencent.xweb.y.hsF().b("tools", WebView.c.values()[i2]);
                    com.tencent.xweb.y.hsF().b("toolsmp", WebView.c.values()[i2]);
                    com.tencent.xweb.y.hsF().b("mm", WebView.c.values()[i2]);
                    com.tencent.xweb.y.hsF().b("appbrand", WebView.c.values()[i3]);
                    com.tencent.xweb.y.hsF().b("support", WebView.c.values()[i4]);
                    if (i2 == 1 || i3 == 1 || i4 == 1) {
                        XWalkEnvironment.setGrayValueForTest(1);
                    }
                }
            }
            AppMethodBeat.o(44214);
        } catch (Exception e2) {
            AppMethodBeat.o(44214);
        }
    }

    static /* synthetic */ void buX() {
        AppMethodBeat.i(44215);
        com.tencent.mm.storage.c Fu = com.tencent.mm.model.c.d.aXu().Fu("100371");
        Log.i("MicroMsg.SubCoreAppBrand", "get abtest of XWebLocalDebug");
        if (Fu.isValid()) {
            Log.i("MicroMsg.SubCoreAppBrand", "abtest of XWebLocalDebug is on");
            int i2 = Util.getInt(Fu.gzz().get("bEnableLocalDebug"), 0);
            SharedPreferences.Editor edit = MMApplicationContext.getContext().getSharedPreferences("wcwebview", com.tencent.mm.compatible.util.g.aps()).edit();
            if (i2 == 1) {
                edit.putBoolean("m_bEnableLocalDebug", true).commit();
                AppMethodBeat.o(44215);
                return;
            }
            edit.putBoolean("m_bEnableLocalDebug", false).commit();
        }
        AppMethodBeat.o(44215);
    }

    static /* synthetic */ void buY() {
        AppMethodBeat.i(44216);
        try {
            com.tencent.xweb.y.lC(MMApplicationContext.getContext());
            com.tencent.mm.storage.c Fu = com.tencent.mm.model.c.d.aXu().Fu("100449");
            if (Fu.isValid()) {
                Log.i("MicroMsg.SubCoreAppBrand", "abtest of xweb command received");
                Map<String, String> gzz = Fu.gzz();
                if (Util.getInt(gzz.get("WebCoreTestFlag"), 0) == 1) {
                    Log.i("MicroMsg.SubCoreAppBrand", "WebCoreTestFlag is on");
                    String str = gzz.get("XWebConfigName");
                    if (str != null && str.trim().length() > 1) {
                        String trim = str.trim();
                        Log.i("MicroMsg.SubCoreAppBrand", "abtest xweb config url  is ".concat(String.valueOf(trim)));
                        com.tencent.mm.cr.d.kT(MMApplicationContext.getContext());
                        XWalkEnvironment.setTestDownLoadUrl(MMApplicationContext.getContext(), trim);
                        com.tencent.xweb.a.a(null, AppEventsConstants.EVENT_PARAM_VALUE_NO);
                        SharedPreferences.Editor edit = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
                        edit.putLong("nLastFetchConfigTime", 0);
                        edit.putBoolean("bCanUseCellular", true);
                        edit.putLong("nTimeToUpdate", 100);
                        edit.commit();
                        MMApplicationContext.getContext();
                        x.a.ahJ(5);
                    }
                    String str2 = gzz.get("XWebCommand");
                    if (str2 != null && str2.length() > 15) {
                        try {
                            new WebView(MMApplicationContext.getContext()).loadUrl(str2);
                            Log.i("MicroMsg.SubCoreAppBrand", "excute xwebcmd finished");
                            AppMethodBeat.o(44216);
                            return;
                        } catch (Exception e2) {
                            Log.e("MicroMsg.SubCoreAppBrand", "excute xwebcmd failed : " + e2.getMessage());
                        }
                    }
                }
            }
            AppMethodBeat.o(44216);
        } catch (Exception e3) {
            AppMethodBeat.o(44216);
        }
    }

    static /* synthetic */ void buZ() {
        AppMethodBeat.i(226348);
        com.tencent.mm.plugin.appbrand.appstorage.f.kRZ.vC();
        AppMethodBeat.o(226348);
    }
}
