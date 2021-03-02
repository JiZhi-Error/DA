package com.tencent.mm.plugin.finder.report;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.aa;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.fp;
import com.tencent.mm.g.a.id;
import com.tencent.mm.g.a.uc;
import com.tencent.mm.g.b.a.fc;
import com.tencent.mm.g.b.a.hq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.f;
import com.tencent.mm.plugin.finder.extension.reddot.k;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.aaw;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.protocal.protobuf.djz;
import com.tencent.mm.protocal.protobuf.dka;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashSet;
import kotlin.g.b.p;

public final class ad {
    private static ad viu;
    String kvy;
    private IListener<uc> lEE;
    private IListener<fp> qZd;
    boolean vij;
    boolean vik;
    boolean vil;
    HashSet<String> vim;
    HashSet<String> vin;
    HashSet<String> vio;
    boolean vip;
    String viq;
    String vir;
    String vis;
    String vit;

    public static ad doP() {
        AppMethodBeat.i(241803);
        if (viu == null) {
            viu = new ad();
        }
        ad adVar = viu;
        AppMethodBeat.o(241803);
        return adVar;
    }

    private ad() {
        AppMethodBeat.i(241804);
        this.vij = false;
        this.vik = false;
        this.vil = false;
        this.vim = null;
        this.vin = null;
        this.vio = null;
        this.vip = false;
        this.lEE = new IListener<uc>() {
            /* class com.tencent.mm.plugin.finder.report.ad.AnonymousClass1 */

            {
                AppMethodBeat.i(241798);
                this.__eventId = uc.class.getName().hashCode();
                AppMethodBeat.o(241798);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(uc ucVar) {
                int i2;
                String str;
                aaw aaw;
                aaw aaw2;
                AppMethodBeat.i(241799);
                uc ucVar2 = ucVar;
                if (ucVar2 != null && ((aj) g.ah(aj.class)).showFinderEntry()) {
                    ad adVar = ad.this;
                    if (ucVar2.eav.type == 0) {
                        adVar.kvy = adVar.vit;
                        adVar.vit = ucVar2.eav.sessionId;
                        if ("2".equalsIgnoreCase(adVar.kvy)) {
                            h.RTc.bqo("report_session");
                            h.RTc.a(new Runnable(ucVar2) {
                                /* class com.tencent.mm.plugin.finder.report.ad.AnonymousClass2 */
                                final /* synthetic */ uc viw;

                                {
                                    this.viw = r2;
                                }

                                public final void run() {
                                    AppMethodBeat.i(241800);
                                    ad adVar = ad.this;
                                    String str = this.viw.eav.sessionId;
                                    if (adVar.vip) {
                                        int i2 = Util.getInt(str, -1);
                                        if (i2 < 0 || i2 >= 255) {
                                            e.INSTANCE.idkeyStat(1437, 255, 1, false);
                                        } else {
                                            e.INSTANCE.idkeyStat(1437, (long) i2, 1, false);
                                        }
                                    }
                                    ad adVar2 = ad.this;
                                    String str2 = this.viw.eav.sessionId;
                                    Log.i("MicroMsg.MMSessionReporter", "notify finder sync sid[%s] finderSyncStr[%s] finderSyncAll[%b]", str2, adVar2.vis, Boolean.valueOf(adVar2.vil));
                                    int i3 = Util.getInt(str2, -1);
                                    if (i3 >= 0 && i3 < 255 && (adVar2.vil || adVar2.vio.contains(str2))) {
                                        id idVar = new id();
                                        idVar.dMJ.dMK = true;
                                        idVar.dMJ.dML = 47613;
                                        idVar.dMJ.scene = i3 + 10000;
                                        EventCenter.instance.publish(idVar);
                                    }
                                    ad adVar3 = ad.this;
                                    String str3 = this.viw.eav.sessionId;
                                    long j2 = this.viw.eav.eaw;
                                    Log.i("MicroMsg.MMSessionReporter", "report session sid[%s] op[%d] kv[%s] kvAll[%b]", str3, Long.valueOf(j2), adVar3.viq, Boolean.valueOf(adVar3.vij));
                                    fc fcVar = new fc();
                                    fcVar.erU = fcVar.x("Sessionid", str3, true);
                                    fcVar.nf(j2);
                                    if (adVar3.vij || adVar3.vim.contains(str3)) {
                                        bdo asW = ((PluginFinder) g.ah(PluginFinder.class)).getRedDotManager().asW("FinderEntrance");
                                        k asX = ((PluginFinder) g.ah(PluginFinder.class)).getRedDotManager().asX("FinderEntrance");
                                        if (asX != null) {
                                            fcVar.eBo = fcVar.x("RedDotTipsID", asX.field_tipsId, true);
                                            fcVar.eBn = (long) asX.field_ctrInfo.type;
                                        }
                                        if (asW != null) {
                                            fcVar.eBr = (long) asW.xGz;
                                        }
                                        fcVar.bfK();
                                    }
                                    ad adVar4 = ad.this;
                                    String str4 = this.viw.eav.sessionId;
                                    long j3 = this.viw.eav.eaw;
                                    Log.i("MicroMsg.MMSessionReporter", "rt report session sid[%s] op[%d] rtKvStr[%s] rtKvAll[%b]", str4, Long.valueOf(j3), adVar4.vir, Boolean.valueOf(adVar4.vik));
                                    hq hqVar = new hq();
                                    hqVar.erU = hqVar.x("Sessionid", str4, true);
                                    hqVar.qR(j3);
                                    if (adVar4.vik || adVar4.vin.contains(str4)) {
                                        bdo asW2 = ((PluginFinder) g.ah(PluginFinder.class)).getRedDotManager().asW("FinderEntrance");
                                        k asX2 = ((PluginFinder) g.ah(PluginFinder.class)).getRedDotManager().asX("FinderEntrance");
                                        if (asX2 != null) {
                                            hqVar.eBo = hqVar.x("RedDotTipsID", asX2.field_tipsId, true);
                                            hqVar.eBn = (long) asX2.field_ctrInfo.type;
                                        }
                                        if (asW2 != null) {
                                            hqVar.eBr = (long) asW2.xGz;
                                        }
                                        int id = hqVar.getId();
                                        String concat = "ClientIPV6,".concat(String.valueOf(hqVar.abV()));
                                        d.a aVar = new d.a();
                                        aVar.iLN = new djz();
                                        aVar.iLO = new dka();
                                        aVar.uri = "/cgi-bin/micromsg-bin/rtkvreport";
                                        aVar.funcId = 716;
                                        d aXF = aVar.aXF();
                                        djz djz = (djz) aXF.iLK.iLR;
                                        djz.hid = com.tencent.mm.protocal.d.KyJ;
                                        djz.hie = com.tencent.mm.protocal.d.KyI;
                                        djz.hif = com.tencent.mm.protocal.d.KyL;
                                        djz.hig = com.tencent.mm.protocal.d.KyM;
                                        djz.hih = LocaleUtil.getApplicationLanguage();
                                        djz.MlF = id;
                                        djz.Cyk = concat;
                                        Log.i("MicroMsg.AbsReportStruct", "reportCgi logId:%d, value:%s", Integer.valueOf(id), concat);
                                        aa.a(aXF, new aa.a(Util.nowMilliSecond(), djz) {
                                            /* class com.tencent.mm.plugin.report.a.AnonymousClass1 */
                                            final /* synthetic */ long jpi;
                                            final /* synthetic */ djz jpj;

                                            {
                                                this.jpi = r2;
                                                this.jpj = r4;
                                            }

                                            @Override // com.tencent.mm.ak.aa.a
                                            public final int a(int i2, int i3, String str, d dVar, q qVar) {
                                                AppMethodBeat.i(224149);
                                                Log.i("MicroMsg.AbsReportStruct", "onGYNetEnd errType:%d errCode:%d msg:%s  %d val:%s ", Integer.valueOf(i2), Integer.valueOf(i3), str, Long.valueOf(Util.milliSecondsToNow(this.jpi)), this.jpj.Cyk);
                                                AppMethodBeat.o(224149);
                                                return 0;
                                            }
                                        });
                                    }
                                    AppMethodBeat.o(241800);
                                }
                            }, 100, "report_session");
                        }
                    }
                    if (ucVar2 != null && ucVar2.eav != null && ucVar2.eav.type == 0 && "2".equalsIgnoreCase(ucVar2.eav.sessionId)) {
                        f redDotManager = ((PluginFinder) g.ah(PluginFinder.class)).getRedDotManager();
                        p.h("FinderEntrance", "path");
                        k asX = redDotManager.asX("FinderEntrance");
                        if (asX != null) {
                            bdo atl = asX.atl("FinderEntrance");
                            if ((atl != null ? atl.LNq : null) == null && atl != null) {
                                atl.LNq = new aaw();
                            }
                            if (atl != null) {
                                aaw = atl.LNq;
                            } else {
                                aaw = null;
                            }
                            if (aaw == null) {
                                p.hyc();
                            }
                            aaw aaw3 = atl != null ? atl.LNq : null;
                            if (aaw3 == null) {
                                p.hyc();
                            }
                            aaw.Lmd = aaw3.Lmd + 1;
                            if (atl == null || (aaw2 = atl.LNq) == null) {
                                i2 = 0;
                            } else {
                                i2 = aaw2.Lmd;
                            }
                            k.a(asX, redDotManager.tJN);
                        } else {
                            i2 = 0;
                        }
                        StringBuilder append = new StringBuilder("increase reddot expose path = ").append("FinderEntrance").append(", exposeCount = ").append(i2).append(", tipsId=[");
                        if (asX != null) {
                            str = asX.field_tipsId;
                        } else {
                            str = null;
                        }
                        Log.v("Finder.RedDotManager", append.append(str).append(']').toString());
                    }
                }
                AppMethodBeat.o(241799);
                return false;
            }
        };
        this.qZd = new IListener<fp>() {
            /* class com.tencent.mm.plugin.finder.report.ad.AnonymousClass3 */

            {
                AppMethodBeat.i(241801);
                this.__eventId = fp.class.getName().hashCode();
                AppMethodBeat.o(241801);
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
            @Override // com.tencent.mm.sdk.event.IListener
            public final /* synthetic */ boolean callback(fp fpVar) {
                AppMethodBeat.i(241802);
                ad.this.doQ();
                AppMethodBeat.o(241802);
                return false;
            }
        };
        this.vit = "";
        this.kvy = "";
        this.vim = new HashSet<>();
        this.vin = new HashSet<>();
        this.vio = new HashSet<>();
        AppMethodBeat.o(241804);
    }

    public final void LW() {
        AppMethodBeat.i(241805);
        if (MMApplicationContext.isMainProcess()) {
            doQ();
            EventCenter.instance.add(this.lEE);
            EventCenter.instance.add(this.qZd);
        }
        AppMethodBeat.o(241805);
    }

    public final void unregister() {
        AppMethodBeat.i(241806);
        if (MMApplicationContext.isMainProcess()) {
            EventCenter.instance.removeListener(this.lEE);
            EventCenter.instance.removeListener(this.qZd);
        }
        AppMethodBeat.o(241806);
    }

    /* access modifiers changed from: package-private */
    public final void doQ() {
        AppMethodBeat.i(241807);
        doR();
        doS();
        doT();
        this.vip = ((b) g.af(b.class)).a(b.a.clicfg_idkey_report_session, false);
        AppMethodBeat.o(241807);
    }

    private void doR() {
        AppMethodBeat.i(241808);
        this.vij = false;
        this.vim.clear();
        PBool pBool = new PBool();
        PString pString = new PString();
        HashSet<String> a2 = a(b.a.clicfg_kv_report_session, pBool, pString);
        this.vij = pBool.value;
        this.viq = pString.value;
        if (a2 != null) {
            this.vim.addAll(a2);
        }
        AppMethodBeat.o(241808);
    }

    private void doS() {
        AppMethodBeat.i(241809);
        this.vik = false;
        this.vin.clear();
        PBool pBool = new PBool();
        PString pString = new PString();
        HashSet<String> a2 = a(b.a.clicfg_rt_report_session, pBool, pString);
        this.vik = pBool.value;
        this.vir = pString.value;
        if (a2 != null) {
            this.vin.addAll(a2);
        }
        AppMethodBeat.o(241809);
    }

    private void doT() {
        AppMethodBeat.i(241810);
        this.vil = false;
        this.vio.clear();
        PBool pBool = new PBool();
        PString pString = new PString();
        HashSet<String> a2 = a(b.a.clicfg_finder_sync_session, pBool, pString);
        this.vil = pBool.value;
        this.vis = pString.value;
        if (a2 != null) {
            this.vio.addAll(a2);
        }
        AppMethodBeat.o(241810);
    }

    private static HashSet<String> a(b.a aVar, PBool pBool, PString pString) {
        AppMethodBeat.i(241811);
        String a2 = ((b) g.af(b.class)).a(aVar, "");
        Log.i("MicroMsg.MMSessionReporter", "reset control key[%s] [%s]", aVar.name(), a2);
        pString.value = a2;
        if (Util.isNullOrNil(a2)) {
            pBool.value = false;
            AppMethodBeat.o(241811);
            return null;
        } else if ("-1".equalsIgnoreCase(a2)) {
            pBool.value = true;
            AppMethodBeat.o(241811);
            return null;
        } else {
            HashSet<String> hashSet = new HashSet<>();
            String[] split = a2.split(",");
            if (split != null && split.length > 0) {
                for (String str : split) {
                    hashSet.add(str);
                }
            }
            pBool.value = false;
            AppMethodBeat.o(241811);
            return hashSet;
        }
    }
}
