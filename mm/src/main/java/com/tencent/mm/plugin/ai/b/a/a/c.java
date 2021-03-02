package com.tencent.mm.plugin.ai.b.a.a;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.aal;
import com.tencent.mm.g.a.aam;
import com.tencent.mm.g.a.ln;
import com.tencent.mm.g.a.nm;
import com.tencent.mm.g.a.sz;
import com.tencent.mm.g.a.uc;
import com.tencent.mm.g.b.a.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.ai.c.a;
import com.tencent.mm.plugin.ai.f.b;
import com.tencent.mm.plugin.ai.f.e;
import com.tencent.mm.plugin.ai.f.f;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.k;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.protobuf.bdo;
import com.tencent.mm.protocal.protobuf.eiq;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import org.json.JSONObject;

public final class c {
    private static final int[] kvJ = {10, 30, 90};
    private static c kvK;
    private a kvL = new a();
    private b kvM = new b();
    private long kvN = 0;
    private long kvO = 0;
    private PBool kvP = null;
    public IListener<ln> kvQ = new IListener<ln>() {
        /* class com.tencent.mm.plugin.ai.b.a.a.c.AnonymousClass1 */

        {
            AppMethodBeat.i(238858);
            this.__eventId = ln.class.getName().hashCode();
            AppMethodBeat.o(238858);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ln lnVar) {
            AppMethodBeat.i(238859);
            ln lnVar2 = lnVar;
            if (MMApplicationContext.isMainProcess()) {
                if (lnVar2 == null || lnVar2.dQQ == null) {
                    AppMethodBeat.o(238859);
                    return false;
                }
                if (lnVar2.dQQ.dQR == 19943) {
                    c.a(c.this, lnVar2.dQQ.content);
                }
                if (lnVar2.dQQ.dQR == 16563) {
                    c.TH(lnVar2.dQQ.content);
                }
                if (lnVar2.dQQ.dQR == 9999) {
                    Log.i("MicroMsg.AiFinderData", "cash debug here.");
                    c.TI("debug");
                }
            }
            AppMethodBeat.o(238859);
            return false;
        }
    };
    public IListener<uc> kvR = new IListener<uc>() {
        /* class com.tencent.mm.plugin.ai.b.a.a.c.AnonymousClass2 */

        {
            AppMethodBeat.i(238860);
            this.__eventId = uc.class.getName().hashCode();
            AppMethodBeat.o(238860);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(uc ucVar) {
            long j2 = 0;
            AppMethodBeat.i(238861);
            uc ucVar2 = ucVar;
            if (ucVar2 == null || ucVar2.eav == null) {
                AppMethodBeat.o(238861);
            } else {
                if (c.a(c.this)) {
                    Log.i("MicroMsg.AiFinderData", "wechat session event sid[%s] type[%d] opTimeMs[%d]", ucVar2.eav.sessionId, Integer.valueOf(ucVar2.eav.type), Long.valueOf(ucVar2.eav.eaw));
                    if (ucVar2.eav.type == 0) {
                        c cVar = c.this;
                        if (c.this.kvO > 0) {
                            j2 = ucVar2.eav.eaw - c.this.kvO;
                        }
                        cVar.kvz = j2;
                        String str = ucVar2.eav.sessionId;
                        char c2 = 65535;
                        switch (str.hashCode()) {
                            case 50:
                                if (str.equals("2")) {
                                    c2 = 0;
                                    break;
                                }
                                break;
                        }
                        switch (c2) {
                            case 0:
                                c.c(c.this);
                                if (!"143".equals(c.this.kvy)) {
                                    c.e(c.this);
                                    break;
                                }
                                break;
                        }
                        c.this.kvy = ucVar2.eav.sessionId;
                        c.this.kvO = ucVar2.eav.eaw;
                    }
                }
                AppMethodBeat.o(238861);
            }
            return false;
        }
    };
    public IListener<aam> kvS = new IListener<aam>() {
        /* class com.tencent.mm.plugin.ai.b.a.a.c.AnonymousClass3 */

        {
            AppMethodBeat.i(238862);
            this.__eventId = aam.class.getName().hashCode();
            AppMethodBeat.o(238862);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(aam aam) {
            AppMethodBeat.i(238863);
            aam aam2 = aam;
            if (aam2 == null || aam2.ehm == null) {
                AppMethodBeat.o(238863);
            } else {
                if (c.a(c.this)) {
                    Log.v("MicroMsg.AiFinderData", "wechat tab red dot [%d] redDot[%b] unread[%d]", Integer.valueOf(aam2.ehm.ehn), Boolean.valueOf(aam2.ehm.eho), Integer.valueOf(aam2.ehm.ehp));
                    if (aam2.ehm.ehn == 2) {
                        c.this.kvL.kvA = aam2.ehm.eho;
                        c.this.kvL.kvB = aam2.ehm.ehp;
                    }
                }
                AppMethodBeat.o(238863);
            }
            return false;
        }
    };
    public IListener<aal> kvT = new IListener<aal>() {
        /* class com.tencent.mm.plugin.ai.b.a.a.c.AnonymousClass4 */

        {
            AppMethodBeat.i(238864);
            this.__eventId = aal.class.getName().hashCode();
            AppMethodBeat.o(238864);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(aal aal) {
            AppMethodBeat.i(238865);
            aal aal2 = aal;
            if (aal2 == null || aal2.ehk == null) {
                AppMethodBeat.o(238865);
            } else if (!c.a(c.this)) {
                AppMethodBeat.o(238865);
            } else {
                c.this.kvM.kvI.eiJ = false;
                if (aal2.ehk.type == 7) {
                    if (Util.milliSecondsToNow(c.this.kvN) <= 10000) {
                        c.this.kvM.kvI.eiJ = true;
                    }
                    c.this.kvN = 0;
                }
                Log.v("MicroMsg.AiFinderData", "wechat front back event [%d] [%s] [%d]", Integer.valueOf(aal2.ehk.type), aal2.ehk.activity, Long.valueOf(aal2.ehk.ehl));
                AppMethodBeat.o(238865);
            }
            return false;
        }
    };
    public IListener<nm> kvU = new IListener<nm>() {
        /* class com.tencent.mm.plugin.ai.b.a.a.c.AnonymousClass5 */

        {
            AppMethodBeat.i(238866);
            this.__eventId = nm.class.getName().hashCode();
            AppMethodBeat.o(238866);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(nm nmVar) {
            AppMethodBeat.i(238867);
            nm nmVar2 = nmVar;
            if (nmVar2 == null || nmVar2.dTE == null) {
                AppMethodBeat.o(238867);
            } else if (!c.a(c.this)) {
                AppMethodBeat.o(238867);
            } else {
                c.this.kvN = Util.nowMilliSecond();
                Log.i("MicroMsg.AiFinderData", "wechat notification event talker[%s] unreadCount[%d] silence[%b]", nmVar2.dTE.talker, Integer.valueOf(nmVar2.dTE.dCm), Boolean.valueOf(nmVar2.dTE.dTF));
                AppMethodBeat.o(238867);
            }
            return false;
        }
    };
    private String kvy = "";
    private long kvz = 0;

    static /* synthetic */ void TI(String str) {
        AppMethodBeat.i(238875);
        TG(str);
        AppMethodBeat.o(238875);
    }

    static /* synthetic */ void e(c cVar) {
        AppMethodBeat.i(238878);
        cVar.a(false, 0, 0);
        AppMethodBeat.o(238878);
    }

    public static c bqt() {
        AppMethodBeat.i(238869);
        if (kvK == null) {
            kvK = new c();
        }
        c cVar = kvK;
        AppMethodBeat.o(238869);
        return cVar;
    }

    private c() {
        AppMethodBeat.i(238870);
        AppMethodBeat.o(238870);
    }

    private void a(final boolean z, final long j2, final long j3) {
        AppMethodBeat.i(238871);
        h.RTc.b(new Runnable() {
            /* class com.tencent.mm.plugin.ai.b.a.a.c.AnonymousClass6 */

            public final void run() {
                AppMethodBeat.i(238868);
                c.a(c.this, z, j2, j3);
                AppMethodBeat.o(238868);
            }
        }, "Ai_thread");
        AppMethodBeat.o(238871);
    }

    private static void TG(String str) {
        AppMethodBeat.i(238872);
        Log.i("MicroMsg.AiFinderData", "notify to run ai [%s]", str);
        sz szVar = new sz();
        szVar.dZv.info = str;
        EventCenter.instance.publish(szVar);
        AppMethodBeat.o(238872);
    }

    static /* synthetic */ void a(c cVar, String str) {
        AppMethodBeat.i(238873);
        if (!Util.isNullOrNil(str)) {
            String[] split = str.split(",");
            if (split == null || split.length <= 4) {
                AppMethodBeat.o(238873);
                return;
            } else if ("All".equals(split[1])) {
                long j2 = Util.getLong(split[2], 0);
                long j3 = Util.getLong(split[3], 0);
                cVar.a(true, j3, j2);
                b bVar = cVar.kvM;
                a aVar = cVar.kvL;
                bVar.kvI.hF(aVar.kvC);
                bVar.kvI.eiN = (long) aVar.kvD;
                bVar.kvI.eiO = (long) aVar.kvE;
                cVar.kvM.kvI.bF(j3);
                cVar.kvM.kvI.eiL = j2;
                g.aAh().azQ().set(ar.a.USERINFO_AI_FINDER_CONTEXT_STRING, cVar.kvM.kvI.abV());
            }
        }
        AppMethodBeat.o(238873);
    }

    static /* synthetic */ void TH(String str) {
        AppMethodBeat.i(238874);
        long currentTicks = Util.currentTicks();
        if (!Util.isNullOrNil(str)) {
            Log.v("MicroMsg.AiFinderData", "handle wechat app %s", str);
            String[] split = str.split(",");
            if (split == null || split.length <= 1) {
                AppMethodBeat.o(238874);
                return;
            }
            String str2 = split[0];
            if (!Util.isNullOrNil(str2)) {
                String replace = str2.replace(".", ",");
                if (!Util.isNullOrNil(replace)) {
                    String[] split2 = replace.split(";");
                    if (split2 == null || split2.length <= 0) {
                        AppMethodBeat.o(238874);
                        return;
                    }
                    LinkedList linkedList = new LinkedList();
                    for (String str3 : split2) {
                        e eVar = new e();
                        eVar.TN(str3);
                        linkedList.add(eVar);
                    }
                    Log.i("MicroMsg.AiFinderData", "handleWechatApp count[db: %d item: %d] cost: %d", Integer.valueOf(b.bqC().kxJ.bb(linkedList)), Integer.valueOf(linkedList.size()), Long.valueOf(Util.ticksToNow(currentTicks)));
                }
            }
        }
        AppMethodBeat.o(238874);
    }

    static /* synthetic */ boolean a(c cVar) {
        AppMethodBeat.i(238876);
        if (cVar.kvP == null) {
            cVar.kvP = new PBool();
            cVar.kvP.value = ((aj) g.ah(aj.class)).showFinderEntry();
        }
        boolean z = cVar.kvP.value;
        AppMethodBeat.o(238876);
        return z;
    }

    static /* synthetic */ void c(c cVar) {
        boolean z;
        eiq eiq;
        AppMethodBeat.i(238877);
        cVar.kvL.kvy = cVar.kvy;
        cVar.kvL.kvz = cVar.kvz;
        a aVar = cVar.kvL;
        aVar.kvG = 0;
        aVar.kvF = false;
        if (o.DCO != null) {
            aVar.kvG = o.DCO.ctM();
        }
        if (!Util.isNullOrNil((String) g.aAh().azQ().get(68377, (Object) null))) {
            aVar.kvF = true;
        }
        bdo asW = ((PluginFinder) g.ah(PluginFinder.class)).getRedDotManager().asW("FinderEntrance");
        k asX = ((PluginFinder) g.ah(PluginFinder.class)).getRedDotManager().asX("FinderEntrance");
        if (asX != null) {
            aVar.kvC = asX.field_tipsId;
            aVar.kvD = asX.field_ctrInfo.type;
        }
        if (asW != null) {
            aVar.kvE = asW.xGz;
        }
        if (aVar.kvC == null) {
            aVar.kvC = "";
        }
        aVar.kvH = false;
        if (((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxB()) {
            aVar.kvH = true;
        }
        boolean z2 = ((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxu() > 0 && ((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxm();
        if (z2) {
            aVar.kvH = true;
        }
        boolean fxK = ((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxK();
        if (!((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxl() || !fxK) {
            z = false;
        } else {
            z = true;
        }
        if (z2 || !z) {
            eiq = null;
        } else {
            eiq = ((com.tencent.mm.plugin.topstory.a.b) g.ah(com.tencent.mm.plugin.topstory.a.b.class)).getRedDotMgr().fxo();
        }
        if (eiq != null && eiq.type > 0 && eiq.type <= 4) {
            aVar.kvH = true;
        }
        Log.i("MicroMsg.AiFinderAtOnceStruct", "%s enter friends %s", new StringBuilder().append(aVar.hashCode()).toString(), aVar);
        AppMethodBeat.o(238877);
    }

    static /* synthetic */ void a(c cVar, boolean z, long j2, long j3) {
        long j4;
        long j5;
        long j6;
        long j7;
        boolean z2;
        long TO;
        boolean z3;
        AppMethodBeat.i(238879);
        long currentTicks = Util.currentTicks();
        d dVar = new d();
        if (z) {
            j4 = 1;
        } else {
            j4 = 0;
        }
        dVar.eiU = j4;
        dVar.eiJ = cVar.kvM.kvI.eiJ;
        dVar.bG(cVar.kvM.kvI.eiK);
        dVar.eiL = cVar.kvM.kvI.eiL;
        dVar.hG(cVar.kvM.kvI.eiM);
        dVar.eiW = (int) cVar.kvM.kvI.eiN;
        dVar.eiX = (int) cVar.kvM.kvI.eiO;
        dVar.hH(cVar.kvL.kvy);
        dVar.eji = cVar.kvL.kvz / 1000;
        if (cVar.kvL.kvA) {
            j5 = 1;
        } else {
            j5 = 0;
        }
        dVar.eiZ = j5;
        dVar.eja = (long) cVar.kvL.kvB;
        dVar.hI(cVar.kvL.kvC);
        dVar.ejb = cVar.kvL.kvD;
        dVar.ejc = cVar.kvL.kvE;
        if (cVar.kvL.kvF) {
            j6 = 1;
        } else {
            j6 = 0;
        }
        dVar.ejd = j6;
        dVar.eje = (long) cVar.kvL.kvG;
        if (cVar.kvL.kvH) {
            j7 = 1;
        } else {
            j7 = 0;
        }
        dVar.ejf = j7;
        dVar.bH(j2);
        dVar.ejh = j3;
        int AU = a.AU(Util.nowMilliSecond());
        f fVar = b.bqC().kxJ;
        PInt pInt = new PInt();
        PInt pInt2 = new PInt();
        long nowMilliSecond = Util.nowMilliSecond();
        int i2 = Util.getInt(fVar.bqD().format(new Date(nowMilliSecond)), -1);
        if (i2 > 0) {
            pInt.value = i2 - 7;
            pInt2.value = i2 - 1;
            Log.i("MicroMsg.WechatDurationHistoryStorage", "to sql date [%d, %d] day[%d] timeMs[%d]", Integer.valueOf(pInt.value), Integer.valueOf(pInt2.value), 7, Long.valueOf(nowMilliSecond));
            z2 = true;
        } else {
            z2 = false;
        }
        if (!z2) {
            TO = 0;
        } else {
            TO = fVar.TO("SELECT SUM( appIn ) FROM WechatAppHistory WHERE  ( appDs >= " + pInt.value + " AND appDs <= " + pInt2.value + " )  AND appHour = " + AU);
        }
        dVar.ejk = TO / 1000;
        try {
            JSONObject jSONObject = new JSONObject();
            int[] iArr = kvJ;
            for (int i3 : iArr) {
                jSONObject.put(String.valueOf(i3), b.bqC().kxI.vw(i3));
            }
            dVar.hJ(jSONObject.toString().replace(",", ";"));
        } catch (Exception e2) {
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            int[] iArr2 = kvJ;
            for (int i4 : iArr2) {
                f fVar2 = b.bqC().kxJ;
                long nowMilliSecond2 = Util.nowMilliSecond();
                jSONObject2.put(String.valueOf(i4), fVar2.TO("SELECT SUM( appIn ) FROM WechatAppHistory WHERE  ( appTbe >= " + (nowMilliSecond2 - ((long) ((i4 * 60) * 1000))) + " AND appTbe <= " + nowMilliSecond2 + " ) ") / 1000);
            }
            dVar.hK(jSONObject2.toString().replace(",", ";"));
        } catch (Exception e3) {
        }
        dVar.hL(NetStatusUtil.getFormatedNetType(MMApplicationContext.getContext()));
        f fVar3 = b.bqC().kxJ;
        dVar.ejn = (int) fVar3.TO("SELECT COUNT(*) FROM WechatAppHistory WHERE  ( appDs == " + fVar3.bqD().format(new Date(Util.nowMilliSecond())) + " ) ");
        dVar.bfK();
        Log.i("MicroMsg.AiFinderData", "ai report cost[%d] [%s]", Long.valueOf(Util.ticksToNow(currentTicks)), dVar.abW());
        boolean z4 = false;
        com.tencent.mm.plugin.ai.f.c cVar2 = new com.tencent.mm.plugin.ai.f.c();
        int i5 = (int) dVar.eiU;
        long nowMilliSecond3 = Util.nowMilliSecond();
        if (cVar2.kxO == null) {
            cVar2.kxO = new SimpleDateFormat("yyyyMMdd");
        }
        cVar2.field_ds = Util.getInt(cVar2.kxO.format(Long.valueOf(nowMilliSecond3)), -1);
        cVar2.field_actionMs = nowMilliSecond3;
        cVar2.field_hour = a.AU(nowMilliSecond3);
        cVar2.field_isGoToFinderUI = i5;
        if (cVar2.field_ds <= 0) {
            z3 = false;
        } else {
            z3 = true;
        }
        if (z3) {
            z4 = b.bqC().kxI.a(cVar2);
        }
        Log.i("MicroMsg.AiFinderData", "save to db [%s] flag[%b]", cVar2.toString(), Boolean.valueOf(z4));
        if (!z) {
            TG(dVar.abV());
        }
        AppMethodBeat.o(238879);
    }
}
