package com.tencent.mm.plugin.nearby.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.lo;
import com.tencent.mm.g.a.ls;
import com.tencent.mm.g.a.lt;
import com.tencent.mm.g.a.lu;
import com.tencent.mm.g.a.my;
import com.tencent.mm.g.a.ng;
import com.tencent.mm.g.a.nh;
import com.tencent.mm.g.a.ps;
import com.tencent.mm.g.a.xi;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.appbrand.service.w;
import com.tencent.mm.plugin.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.c.d;
import com.tencent.mm.protocal.protobuf.cho;
import com.tencent.mm.protocal.protobuf.chq;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.by;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public final class f implements bd {
    c<ng> AzA = new c<ng>() {
        /* class com.tencent.mm.plugin.nearby.a.f.AnonymousClass3 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.pluginsdk.c.c
        public final /* synthetic */ q a(ng ngVar) {
            AppMethodBeat.i(89779);
            ng ngVar2 = ngVar;
            c cVar = new c(ngVar2.dTh.dJY, ngVar2.dTh.dTj, ngVar2.dTh.latitude, ngVar2.dTh.dTk, ngVar2.dTh.dTl, ngVar2.dTh.dTm, ngVar2.dTh.dTn);
            AppMethodBeat.o(89779);
            return cVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, com.tencent.mm.ak.q, com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.pluginsdk.c.c
        public final /* synthetic */ IEvent a(int i2, q qVar, ng ngVar) {
            AppMethodBeat.i(89780);
            ng ngVar2 = ngVar;
            c cVar = (c) qVar;
            ngVar2.dTi.dTo = cVar.ewR();
            ngVar2.dTi.dTq = cVar.ewS();
            ngVar2.dTi.dTp = cVar.ewT();
            ngVar2.dTi.dJY = ngVar2.dTh.dJY;
            AppMethodBeat.o(89780);
            return ngVar2;
        }

        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(IEvent iEvent) {
            AppMethodBeat.i(89781);
            ng ngVar = (ng) iEvent;
            if (ngVar.dTh.dSQ) {
                c.j(ngVar);
                AppMethodBeat.o(89781);
            } else {
                k(ngVar);
                AppMethodBeat.o(89781);
            }
            return false;
        }

        @Override // com.tencent.mm.pluginsdk.c.c
        public final int alY() {
            return 148;
        }
    };
    c<nh> AzB = new c<nh>() {
        /* class com.tencent.mm.plugin.nearby.a.f.AnonymousClass4 */

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.pluginsdk.c.c
        public final /* synthetic */ q a(nh nhVar) {
            AppMethodBeat.i(89782);
            e eVar = new e(nhVar.dTr.dRj);
            AppMethodBeat.o(89782);
            return eVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, com.tencent.mm.ak.q, com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.pluginsdk.c.c
        public final /* synthetic */ IEvent a(int i2, q qVar, nh nhVar) {
            AppMethodBeat.i(89783);
            nh nhVar2 = nhVar;
            e eVar = (e) qVar;
            nhVar2.dTs.dRN = ((chq) eVar.rr.iLL.iLR).gsq;
            nh.b bVar = nhVar2.dTs;
            LinkedList<cho> linkedList = ((chq) eVar.rr.iLL.iLR).KGQ;
            if (linkedList != null) {
                g.aAf().azk();
                Iterator<cho> it = linkedList.iterator();
                while (it.hasNext()) {
                    cho next = it.next();
                    a.bqE().aTp().mP(next.UserName, next.LRO);
                }
            }
            bVar.dTe = linkedList;
            AppMethodBeat.o(89783);
            return nhVar2;
        }

        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(IEvent iEvent) {
            AppMethodBeat.i(89784);
            nh nhVar = (nh) iEvent;
            if (nhVar.dTr.dSQ) {
                c.j(nhVar);
                AppMethodBeat.o(89784);
            } else {
                k(nhVar);
                AppMethodBeat.o(89784);
            }
            return false;
        }

        @Override // com.tencent.mm.pluginsdk.c.c
        public final int alY() {
            return 377;
        }
    };
    d AzC = new d() {
        /* class com.tencent.mm.plugin.nearby.a.f.AnonymousClass6 */

        @Override // com.tencent.mm.pluginsdk.c.d
        public final IEvent azl(String str) {
            AppMethodBeat.i(89786);
            lo loVar = new lo();
            loVar.dQS.event = str;
            AppMethodBeat.o(89786);
            return loVar;
        }

        @Override // com.tencent.mm.pluginsdk.c.d
        public final MStorage dSG() {
            AppMethodBeat.i(89787);
            g.aAf().azk();
            MStorage mStorage = (MStorage) ((l) g.af(l.class)).eiv();
            AppMethodBeat.o(89787);
            return mStorage;
        }
    };
    private bv.a AzD = new bv.a() {
        /* class com.tencent.mm.plugin.nearby.a.f.AnonymousClass7 */

        @Override // com.tencent.mm.storage.bv.a
        public final void a(bv bvVar, as asVar) {
            AppMethodBeat.i(89788);
            if (!(bvVar == null || asVar == null || !asVar.ary())) {
                g.aAf().azk();
                ((l) g.af(l.class)).eiv().aEq(asVar.field_username);
            }
            AppMethodBeat.o(89788);
        }

        @Override // com.tencent.mm.storage.bv.a
        public final as Kn(String str) {
            return null;
        }

        @Override // com.tencent.mm.storage.bv.a
        public final int b(as asVar, boolean z) {
            return 0;
        }
    };
    private IListener<ps> AzE = new IListener<ps>() {
        /* class com.tencent.mm.plugin.nearby.a.f.AnonymousClass8 */

        {
            AppMethodBeat.i(160512);
            this.__eventId = ps.class.getName().hashCode();
            AppMethodBeat.o(160512);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ps psVar) {
            AppMethodBeat.i(89790);
            boolean bet = bet();
            AppMethodBeat.o(89790);
            return bet;
        }

        private static boolean bet() {
            AppMethodBeat.i(89789);
            f.ewU();
            AppMethodBeat.o(89789);
            return false;
        }
    };
    private IListener<my> AzF = new IListener<my>() {
        /* class com.tencent.mm.plugin.nearby.a.f.AnonymousClass9 */

        {
            AppMethodBeat.i(160513);
            this.__eventId = my.class.getName().hashCode();
            AppMethodBeat.o(160513);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(my myVar) {
            AppMethodBeat.i(89792);
            boolean ewV = ewV();
            AppMethodBeat.o(89792);
            return ewV;
        }

        private static boolean ewV() {
            AppMethodBeat.i(89791);
            f.ewU();
            AppMethodBeat.o(89791);
            return false;
        }
    };
    private IListener Azy = new IListener<lt>() {
        /* class com.tencent.mm.plugin.nearby.a.f.AnonymousClass1 */

        {
            AppMethodBeat.i(160509);
            this.__eventId = lt.class.getName().hashCode();
            AppMethodBeat.o(160509);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(lt ltVar) {
            AppMethodBeat.i(89777);
            boolean a2 = a(ltVar);
            AppMethodBeat.o(89777);
            return a2;
        }

        private static boolean a(lt ltVar) {
            int i2 = 3;
            AppMethodBeat.i(89776);
            bp.b bVar = ltVar.dRf.dRg;
            ca caVar = ltVar.dRf.dCM;
            if (bVar.iEw != null && bVar.scene == 1) {
                g.aAh().azQ().set(73729, (Object) 1);
                bx bxVar = new bx();
                bxVar.field_content = caVar.field_content;
                bxVar.field_createtime = Util.nowSecond();
                bxVar.field_imgpath = "";
                bxVar.field_sayhicontent = MMApplicationContext.getContext().getString(R.string.fb5);
                bxVar.field_sayhiuser = caVar.field_talker;
                bxVar.field_scene = 18;
                if (caVar.field_status > 3) {
                    i2 = caVar.field_status;
                }
                bxVar.field_status = i2;
                bxVar.field_svrid = caVar.field_msgSvrId;
                bxVar.field_talker = caVar.field_talker;
                bxVar.field_type = 34;
                bxVar.field_isSend = 0;
                bxVar.field_sayhiencryptuser = caVar.field_talker;
                bxVar.field_ticket = bVar.iEw;
                g.aAf().azk();
                ((by) ((l) g.af(l.class)).eiv()).a(bxVar);
                ls lsVar = new ls();
                lsVar.dRd.dRe = caVar.field_talker;
                EventCenter.instance.publish(lsVar);
            }
            AppMethodBeat.o(89776);
            return false;
        }
    };
    private IListener Azz = new IListener<lu>() {
        /* class com.tencent.mm.plugin.nearby.a.f.AnonymousClass2 */

        {
            AppMethodBeat.i(160510);
            this.__eventId = lu.class.getName().hashCode();
            AppMethodBeat.o(160510);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(lu luVar) {
            boolean z;
            AppMethodBeat.i(89778);
            lu luVar2 = luVar;
            switch (luVar2.dRh.dJY) {
                case 1:
                    b.eV(luVar2.dRh.dRj, luVar2.dRh.dRk);
                    break;
                case 2:
                    b.Ts(luVar2.dRh.dRk);
                    break;
                case 3:
                    luVar2.dRi.dFE = b.ewO();
                    break;
                case 4:
                    b.ewP();
                    break;
                case 5:
                    b.ewQ();
                    break;
                case 6:
                    b.aIt(luVar2.dRh.dRj);
                    break;
                case 7:
                    lu.b bVar = luVar2.dRi;
                    Long l = (Long) g.aAh().azQ().get(8210, (Object) null);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (l == null) {
                        z = true;
                    } else if (currentTimeMillis > l.longValue()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    bVar.dFE = z;
                    break;
                default:
                    Log.e("MicroMsg.SubCoreNearby", "LbsroomLogicEvent unkown opcode!");
                    break;
            }
            AppMethodBeat.o(89778);
            return false;
        }
    };
    private IListener grk = new IListener<xi>() {
        /* class com.tencent.mm.plugin.nearby.a.f.AnonymousClass5 */

        {
            AppMethodBeat.i(160511);
            this.__eventId = xi.class.getName().hashCode();
            AppMethodBeat.o(160511);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(xi xiVar) {
            AppMethodBeat.i(89785);
            xi xiVar2 = xiVar;
            if (xiVar2.edC.edD.equals(ng.class.getName())) {
                if (xiVar2.edC.dJY == 1) {
                    f.this.AzA.gmc();
                } else {
                    f.this.AzA.ecc();
                }
            } else if (xiVar2.edC.edD.equals(nh.class.getName())) {
                if (xiVar2.edC.dJY == 1) {
                    f.this.AzB.gmc();
                } else {
                    f.this.AzB.ecc();
                }
            } else if (xiVar2.edC.edD.equals(lo.class.getName())) {
                if (xiVar2.edC.dJY == 1) {
                    f.this.AzC.LW();
                } else {
                    f.this.AzC.unregister();
                }
            }
            AppMethodBeat.o(89785);
            return false;
        }
    };

    public f() {
        AppMethodBeat.i(89793);
        AppMethodBeat.o(89793);
    }

    @Override // com.tencent.mm.model.bd
    public final void onAccountRelease() {
        AppMethodBeat.i(89794);
        ((l) g.af(l.class)).aSN().b(this.AzD);
        this.AzF.alive();
        this.AzE.dead();
        EventCenter.instance.removeListener(this.Azz);
        EventCenter.instance.removeListener(this.grk);
        EventCenter.instance.removeListener(this.AzA);
        EventCenter.instance.removeListener(this.AzB);
        this.Azy.dead();
        AppMethodBeat.o(89794);
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
        AppMethodBeat.i(89795);
        ((l) g.af(l.class)).aSN().a(this.AzD);
        this.AzF.alive();
        this.AzE.alive();
        EventCenter.instance.addListener(this.grk);
        EventCenter.instance.addListener(this.Azz);
        EventCenter.instance.addListener(this.AzA);
        EventCenter.instance.addListener(this.AzB);
        this.Azy.alive();
        AppMethodBeat.o(89795);
    }

    @Override // com.tencent.mm.model.bd
    public final void onSdcardMount(boolean z) {
    }

    static /* synthetic */ void ewU() {
        AppMethodBeat.i(89796);
        if (!((com.tencent.mm.plugin.welab.a.a.a) g.af(com.tencent.mm.plugin.welab.a.a.a.class)).Uw("labs_nearbylife")) {
            Log.i("MicroMsg.SubCoreNearby", "checkLifeAroundPreload welab not open");
            AppMethodBeat.o(89796);
            return;
        }
        int i2 = com.tencent.mm.n.h.aqJ().getInt("LifeAppLatestVersionValue", 0);
        int i3 = g.aAh().azQ().getInt(ar.a.USERINFO_LIFE_APP_PRE_LOAD_LAST_REQUEST_VERSION_INT, 0);
        Log.i("MicroMsg.SubCoreNearby", "checkLifeAroundPreload lifeAroundLatestVersion %d lastRequestLifeAroundVersion %d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i2 > i3) {
            int i4 = com.tencent.mm.n.h.aqJ().getInt("LifeAppPrefetchTimeThreshold", 259200);
            long a2 = g.aAh().azQ().a(ar.a.USERINFO_LIFE_APP_PRE_LOAD_LAST_REQUEST_TIME_LONG, 0);
            Log.i("MicroMsg.SubCoreNearby", "checkLifeAroundPreload lastRequestLifeAroundTime %d lifeAroundPreloadInterval %d", Long.valueOf(a2), Integer.valueOf(i4));
            if (System.currentTimeMillis() - a2 > ((long) i4) * 1000) {
                try {
                    Log.i("MicroMsg.SubCoreNearby", "checkLifeAroundPreload");
                    g.aAh().azQ().set(ar.a.USERINFO_LIFE_APP_PRE_LOAD_LAST_REQUEST_VERSION_INT, Integer.valueOf(i2));
                    g.aAh().azQ().set(ar.a.USERINFO_LIFE_APP_PRE_LOAD_LAST_REQUEST_TIME_LONG, Long.valueOf(System.currentTimeMillis()));
                    ((w) g.af(w.class)).bb(((com.tencent.mm.plugin.welab.a.a.a) g.af(com.tencent.mm.plugin.welab.a.a.a.class)).bbF("labs_nearbylife"), 0);
                    e.INSTANCE.idkeyStat(863, 30, 1, false);
                    AppMethodBeat.o(89796);
                    return;
                } catch (Exception e2) {
                }
            }
        }
        AppMethodBeat.o(89796);
    }
}
