package com.tencent.mm.plugin.location.model;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.app.o;
import com.tencent.mm.bx.a.a;
import com.tencent.mm.g.a.by;
import com.tencent.mm.g.a.fo;
import com.tencent.mm.g.a.hp;
import com.tencent.mm.g.a.kg;
import com.tencent.mm.g.a.lw;
import com.tencent.mm.g.a.ly;
import com.tencent.mm.g.a.ss;
import com.tencent.mm.g.a.xq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bp;
import com.tencent.mm.model.cj;
import com.tencent.mm.model.e;
import com.tencent.mm.model.y;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.x;
import com.tencent.mm.plugin.k.c;
import com.tencent.mm.plugin.location.model.a;
import com.tencent.mm.plugin.location.ui.impl.d;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.dqy;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.vfs.s;
import com.tencent.wxmm.v2helper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class n implements bd {
    private static o.a appForegroundListener = new o.a() {
        /* class com.tencent.mm.plugin.location.model.n.AnonymousClass4 */

        @Override // com.tencent.mm.app.o
        public final void onAppForeground(String str) {
            AppMethodBeat.i(55728);
            if (g.aAc() && g.aAf().hpY) {
                g.aAf();
                if (!com.tencent.mm.kernel.a.azj()) {
                    ss ssVar = new ss();
                    ssVar.dZj.active = true;
                    EventCenter.instance.publish(ssVar);
                }
            }
            AppMethodBeat.o(55728);
        }

        @Override // com.tencent.mm.app.o
        public final void onAppBackground(String str) {
            AppMethodBeat.i(55729);
            if (g.aAc() && g.aAf().hpY) {
                g.aAf();
                if (!com.tencent.mm.kernel.a.azj()) {
                    ss ssVar = new ss();
                    ssVar.dZj.active = false;
                    EventCenter.instance.publish(ssVar);
                }
            }
            AppMethodBeat.o(55729);
        }
    };
    private IListener yGA = new IListener<by>() {
        /* class com.tencent.mm.plugin.location.model.n.AnonymousClass6 */

        {
            AppMethodBeat.i(160946);
            this.__eventId = by.class.getName().hashCode();
            AppMethodBeat.o(160946);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(by byVar) {
            AppMethodBeat.i(55731);
            l ecQ = n.ecQ();
            Log.i("MicroMsg.StaticMapMsgLogic", "clean task");
            ecQ.yFV.clear();
            ecQ.yFZ.clear();
            ecQ.yGa.clear();
            ecQ.yFX.clear();
            ecQ.yFY.clear();
            ecQ.yGb.clear();
            ecQ.yFW.clear();
            n.ecP().b(ecQ);
            n.ecP().b(ecQ);
            AppMethodBeat.o(55731);
            return false;
        }
    };
    private cj.a yGB = new cj.a() {
        /* class com.tencent.mm.plugin.location.model.n.AnonymousClass7 */

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.a aVar) {
            AppMethodBeat.i(55732);
            new p().b(aVar);
            AppMethodBeat.o(55732);
        }

        @Override // com.tencent.mm.model.cj.a
        public final void a(h.c cVar) {
        }
    };
    private c yGi = new c((byte) 0);
    private a yGj = new a((byte) 0);
    private b yGk = new b((byte) 0);
    private a.C1461a yGl;
    private int yGm = 0;
    private e yGn = new b();
    private e yGo = new p();
    private q yGp = null;
    private r yGq = null;
    private k yGr = null;
    private o yGs = null;
    private d yGt = new d();
    private m yGu = null;
    private l yGv = null;
    private i yGw = new i() {
        /* class com.tencent.mm.plugin.location.model.n.AnonymousClass1 */

        @Override // com.tencent.mm.ak.i
        public final void onSceneEnd(int i2, int i3, String str, q qVar) {
            AppMethodBeat.i(55725);
            if (i2 == 0 && i3 == 0) {
                x xVar = (x) qVar;
                dqy bfB = xVar.bfB();
                if (bfB.oUv == 0) {
                    n.w(xVar.msgId, x.PE(bfB.MbV));
                }
            }
            AppMethodBeat.o(55725);
        }
    };
    private IListener yGx = new IListener<fo>() {
        /* class com.tencent.mm.plugin.location.model.n.AnonymousClass2 */

        {
            AppMethodBeat.i(160943);
            this.__eventId = fo.class.getName().hashCode();
            AppMethodBeat.o(160943);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(fo foVar) {
            com.tencent.mm.plugin.location.a.a aCZ;
            AppMethodBeat.i(55726);
            fo foVar2 = foVar;
            Log.i("MicroMsg.SubCoreLocation", "exit track trackMgr:%s event:%s", com.tencent.mm.bi.d.jpB.bgL(), foVar2.dIN.username);
            n.ecR().stop();
            if (!Util.isNullOrNil(com.tencent.mm.bi.d.jpA.bgK())) {
                n.ecR().Px(1);
                xq xqVar = new xq();
                xqVar.edR.edU = true;
                EventCenter.instance.publish(xqVar);
            }
            if (!Util.isNullOrNil(foVar2.dIN.username) && (aCZ = n.ecS().aCZ(foVar2.dIN.username)) != null) {
                aCZ.dTe.remove(z.aTY());
                n.ecS().a(foVar2.dIN.username, aCZ.dTe, aCZ.latitude, aCZ.longitude, aCZ.yFq, null, null);
                if (com.tencent.mm.bh.g.jpy != null) {
                    com.tencent.mm.bh.g.jpy.a(foVar2.dIN.username, null, null, null, 1);
                }
            }
            AppMethodBeat.o(55726);
            return false;
        }
    };
    private IListener yGy = new IListener<ss>() {
        /* class com.tencent.mm.plugin.location.model.n.AnonymousClass3 */

        {
            AppMethodBeat.i(160944);
            this.__eventId = ss.class.getName().hashCode();
            AppMethodBeat.o(160944);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ss ssVar) {
            AppMethodBeat.i(55727);
            ss ssVar2 = ssVar;
            Log.d("MicroMsg.SubCoreLocation", "trackEvent state " + ssVar2.dZj.active);
            if (ssVar2.dZj.active) {
                if (n.ecR().ecV() && n.ecR().yGO) {
                    n.ecR().ecX();
                }
            } else if (n.ecR().ecV()) {
                q ecR = n.ecR();
                Log.d("MicorMsg.TrackRefreshManager", "pause refresh");
                ecR.yGO = true;
                if (ecR.iOv != null) {
                    ecR.iOv.c(ecR.gmA);
                }
                if (ecR.yGG != null) {
                    ecR.yGG.b(ecR.yGU);
                }
            }
            AppMethodBeat.o(55727);
            return false;
        }
    };
    private IListener yGz = new IListener<kg>() {
        /* class com.tencent.mm.plugin.location.model.n.AnonymousClass5 */

        {
            AppMethodBeat.i(160945);
            this.__eventId = kg.class.getName().hashCode();
            AppMethodBeat.o(160945);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(kg kgVar) {
            boolean z;
            String str;
            Bitmap a2;
            int Kp;
            AppMethodBeat.i(55730);
            kg kgVar2 = kgVar;
            l ecQ = n.ecQ();
            ca caVar = kgVar2.dPi.dCM;
            ImageView imageView = kgVar2.dPi.dPk;
            ProgressBar progressBar = kgVar2.dPi.dPm;
            ImageView imageView2 = kgVar2.dPi.dPl;
            int i2 = kgVar2.dPi.dPn;
            int i3 = kgVar2.dPi.w;
            int i4 = kgVar2.dPi.f1455h;
            String str2 = caVar.field_content;
            if (!Util.isNullOrNil(str2)) {
                ecQ.w = i3;
                ecQ.f1505h = i4;
                if (ecQ.w <= 0 || ecQ.f1505h <= 0) {
                    ecQ.w = 300;
                    ecQ.f1505h = 300;
                }
                if (caVar.field_isSend == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (!ab.Eq(caVar.field_talker) || !z || (Kp = bp.Kp(str2)) == -1) {
                    str = str2;
                } else {
                    str = str2.substring(Kp + 1).trim();
                }
                ca.b aEL = ((l) g.af(l.class)).eiy().aEL(str);
                if (caVar.fQX == 5 || ecQ.yGb.contains(Long.valueOf(caVar.field_msgId))) {
                    Log.i("MicroMsg.StaticMapMsgLogic", "this has die %d errCount %d", Long.valueOf(caVar.field_msgId), Integer.valueOf(caVar.fQX));
                    imageView2.setVisibility(0);
                    progressBar.setVisibility(8);
                } else {
                    com.tencent.mm.pluginsdk.location.d dVar = new com.tencent.mm.pluginsdk.location.d(caVar.field_msgId, (float) aEL.yFu, (float) aEL.yFv, (int) (((double) aEL.dRt) * 1.1d), 0);
                    progressBar.setVisibility(0);
                    imageView2.setVisibility(8);
                    m ecP = n.ecP();
                    ecP.w = i3;
                    ecP.f1506h = i4;
                    if (ecP.w <= 0 || ecP.f1506h <= 0) {
                        ecP.w = 300;
                        ecP.f1506h = 300;
                    }
                    String b2 = m.b(dVar);
                    if (s.YS(b2)) {
                        if (!g.aAc()) {
                            b2 = "";
                        }
                    } else if (ecP.yGd == null || !ecP.yGd.toString().equals(dVar.toString())) {
                        Iterator<com.tencent.mm.pluginsdk.location.d> it = ecP.yGc.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (dVar.toString().equals(it.next().toString())) {
                                    Log.i("MicroMsg.StaticMapServer", "has add queue");
                                    ecP.bbY();
                                    b2 = "";
                                    break;
                                }
                            } else {
                                ecP.yGc.add(dVar);
                                Log.i("MicroMsg.StaticMapServer", "task size %d w%d h %d", Integer.valueOf(ecP.yGc.size()), Integer.valueOf(ecP.w), Integer.valueOf(ecP.f1506h));
                                ecP.bbY();
                                b2 = "";
                                break;
                            }
                        }
                    } else {
                        Log.i("MicroMsg.StaticMapServer", "has add queue");
                        ecP.bbY();
                        b2 = "";
                    }
                    if (Util.isNullOrNil(b2) || !s.YS(b2)) {
                        ecQ.yFW.put(Long.valueOf(dVar.JTu), aEL);
                        ecQ.yGa.put(Long.valueOf(caVar.field_msgId), Integer.valueOf(i2));
                        ecQ.yFZ.put(aEL, caVar);
                        ecQ.yFV.put(Long.valueOf(caVar.field_msgId), new WeakReference<>(imageView));
                        ecQ.yFX.put(Long.valueOf(caVar.field_msgId), new WeakReference<>(progressBar));
                        ecQ.yFY.put(Long.valueOf(caVar.field_msgId), new WeakReference<>(imageView2));
                        ecQ.start();
                    } else {
                        Log.d("MicroMsg.StaticMapMsgLogic", "readloc from local %d", Integer.valueOf(i2));
                        if (g.aAc() && (a2 = com.tencent.mm.av.q.bcR().a(caVar.field_msgId, b2, i2, ecQ.w, ecQ.f1505h, z)) != null && !a2.isRecycled()) {
                            imageView.setImageBitmap(a2);
                            progressBar.setVisibility(8);
                            imageView2.setVisibility(0);
                        }
                    }
                }
            }
            AppMethodBeat.o(55730);
            return false;
        }
    };

    public n() {
        AppMethodBeat.i(55736);
        AppMethodBeat.o(55736);
    }

    private static n ecN() {
        AppMethodBeat.i(55737);
        n nVar = (n) y.at(n.class);
        AppMethodBeat.o(55737);
        return nVar;
    }

    public static a.C1461a ecO() {
        AppMethodBeat.i(55738);
        g.aAf().azk();
        if (ecN().yGl == null) {
            ecN().yGl = new a.C1461a();
        }
        a.C1461a aVar = ecN().yGl;
        AppMethodBeat.o(55738);
        return aVar;
    }

    public static m ecP() {
        AppMethodBeat.i(55739);
        g.aAf().azk();
        if (ecN().yGu == null) {
            ecN().yGu = new m();
        }
        m mVar = ecN().yGu;
        AppMethodBeat.o(55739);
        return mVar;
    }

    public static l ecQ() {
        AppMethodBeat.i(55740);
        g.aAf().azk();
        if (ecN().yGv == null) {
            ecN().yGv = new l();
        }
        l lVar = ecN().yGv;
        AppMethodBeat.o(55740);
        return lVar;
    }

    public static q ecR() {
        AppMethodBeat.i(55741);
        if (ecN().yGp == null) {
            ecN().yGp = new q();
        }
        q qVar = ecN().yGp;
        AppMethodBeat.o(55741);
        return qVar;
    }

    public static r ecS() {
        AppMethodBeat.i(55742);
        if (ecN().yGq == null) {
            ecN().yGq = new r();
        }
        r rVar = ecN().yGq;
        AppMethodBeat.o(55742);
        return rVar;
    }

    public static k ecT() {
        AppMethodBeat.i(55743);
        if (ecN().yGr == null) {
            ecN().yGr = new k();
        }
        k kVar = ecN().yGr;
        AppMethodBeat.o(55743);
        return kVar;
    }

    public static void aA(ca caVar) {
        AppMethodBeat.i(55744);
        if (!(caVar == null || caVar.field_msgId == 0)) {
            ca.b bkB = ca.b.bkB(caVar.field_content);
            g.azz().a(new x((float) bkB.yFv, (float) bkB.yFu, caVar.field_msgId), 0);
        }
        AppMethodBeat.o(55744);
    }

    public static String ecU() {
        AppMethodBeat.i(55745);
        String str = g.aAh().cachePath + "trackroom/";
        AppMethodBeat.o(55745);
        return str;
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return null;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
        AppMethodBeat.i(55746);
        h.d.a(48, this.yGn);
        h.d.a(61, this.yGo);
        ((com.tencent.mm.plugin.messenger.foundation.a.s) g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().a("trackmsg", this.yGB, true);
        g.azz().a(v2helper.EMethodSetSpkEnhance, this.yGw);
        EventCenter.instance.addListener(this.yGi);
        EventCenter.instance.addListener(this.yGj);
        EventCenter.instance.addListener(this.yGx);
        EventCenter.instance.addListener(this.yGy);
        EventCenter.instance.addListener(this.yGz);
        EventCenter.instance.addListener(this.yGA);
        EventCenter.instance.addListener(this.yGk);
        appForegroundListener.alive();
        com.tencent.mm.bi.d.jpB = ecR();
        r ecS = ecS();
        com.tencent.mm.bi.d.jpA = ecS;
        ecS.bgs();
        if (ecN().yGs == null) {
            ecN().yGs = new o();
        }
        a.C0284a.NAL = ecN().yGs;
        g.aAf().azk();
        if (ecN().yGt == null) {
            ecN().yGt = new d();
        }
        c.a.yOs = ecN().yGt;
        AppMethodBeat.o(55746);
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(55747);
        appForegroundListener.dead();
        if (this.yGp != null) {
            this.yGp.yGP = null;
            this.yGp.stop();
            this.yGp.Px(1);
        }
        h.d.b(48, this.yGn);
        h.d.b(61, this.yGo);
        ((com.tencent.mm.plugin.messenger.foundation.a.s) g.ah(com.tencent.mm.plugin.messenger.foundation.a.s.class)).getSysCmdMsgExtension().b("trackmsg", this.yGB, true);
        g.azz().b(v2helper.EMethodSetSpkEnhance, this.yGw);
        EventCenter.instance.removeListener(this.yGi);
        EventCenter.instance.removeListener(this.yGj);
        EventCenter.instance.removeListener(this.yGx);
        EventCenter.instance.removeListener(this.yGy);
        EventCenter.instance.removeListener(this.yGz);
        EventCenter.instance.removeListener(this.yGA);
        EventCenter.instance.removeListener(this.yGk);
        if (this.yGr != null) {
            k kVar = this.yGr;
            kVar.ecM();
            kVar.yFN.clear();
        }
        if (this.yGu != null) {
            this.yGu.stop();
        }
        if (this.yGv != null) {
            ecP().b(this.yGv);
        }
        AppMethodBeat.o(55747);
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }

    public static void w(long j2, String str) {
        AppMethodBeat.i(55748);
        ca Hb = ((l) g.af(l.class)).eiy().Hb(j2);
        if (Hb.dOS()) {
            Hb.CA(str);
            ((l) g.af(l.class)).eiy().a(j2, Hb);
        }
        AppMethodBeat.o(55748);
    }

    static {
        AppMethodBeat.i(55749);
        AppMethodBeat.o(55749);
    }

    static final class c extends IListener<ly> {
        private volatile boolean mIsStarted;

        private c() {
            AppMethodBeat.i(160951);
            this.mIsStarted = false;
            this.__eventId = ly.class.getName().hashCode();
            AppMethodBeat.o(160951);
        }

        /* synthetic */ c(byte b2) {
            this();
            AppMethodBeat.i(160952);
            this.__eventId = ly.class.getName().hashCode();
            AppMethodBeat.o(160952);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ly lyVar) {
            AppMethodBeat.i(55735);
            ly lyVar2 = lyVar;
            if (lyVar2 instanceof ly) {
                Log.d("MicroMsg.SubCoreLocation", "e.data.eventType : " + lyVar2.dRv.dRq);
                switch (lyVar2.dRv.dRq) {
                    case 0:
                        n.ecO().yFC = new HashSet();
                        this.mIsStarted = true;
                        break;
                    case 1:
                        if (this.mIsStarted) {
                            String[] az = n.ecO().az(lyVar2.dRv.dCM);
                            lyVar2.dRw.dNk = az[0];
                            lyVar2.dRw.dRy = az[1];
                            break;
                        } else {
                            lyVar2.dRw.dNk = "err_not_started";
                            break;
                        }
                    case 2:
                        if (this.mIsStarted) {
                            n.ecO().ecJ();
                            break;
                        }
                        break;
                }
                AppMethodBeat.o(55735);
                return true;
            }
            AppMethodBeat.o(55735);
            return false;
        }
    }

    static final class a extends IListener<hp> {
        private a() {
            AppMethodBeat.i(160947);
            this.__eventId = hp.class.getName().hashCode();
            AppMethodBeat.o(160947);
        }

        /* synthetic */ a(byte b2) {
            this();
            AppMethodBeat.i(160948);
            this.__eventId = hp.class.getName().hashCode();
            AppMethodBeat.o(160948);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(hp hpVar) {
            AppMethodBeat.i(55733);
            hp hpVar2 = hpVar;
            if (hpVar2 instanceof hp) {
                n.aA(hpVar2.dMg.dCM);
                AppMethodBeat.o(55733);
                return true;
            }
            AppMethodBeat.o(55733);
            return false;
        }
    }

    static final class b extends IListener<lw> {
        private b() {
            AppMethodBeat.i(160949);
            this.__eventId = lw.class.getName().hashCode();
            AppMethodBeat.o(160949);
        }

        /* synthetic */ b(byte b2) {
            this();
            AppMethodBeat.i(160950);
            this.__eventId = lw.class.getName().hashCode();
            AppMethodBeat.o(160950);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(lw lwVar) {
            AppMethodBeat.i(55734);
            lw lwVar2 = lwVar;
            if (lwVar2 instanceof lw) {
                Log.d("MicroMsg.SubCoreLocation", "e.data.eventType : " + lwVar2.dRo.dRq);
                switch (lwVar2.dRo.dRq) {
                    case 0:
                        lwVar2.dRp.path = e.b(lwVar2.dRo.dRr, lwVar2.dRo.filename, lwVar2.dRo.view);
                        break;
                    case 1:
                        com.tencent.mm.pluginsdk.location.d dVar = new com.tencent.mm.pluginsdk.location.d(-1, lwVar2.dRo.latitude, lwVar2.dRo.dRs, lwVar2.dRo.dRt, 1);
                        lwVar2.dRp.path = m.b(dVar);
                        break;
                    case 2:
                        g.azz().a(new h(lwVar2.dRo.latitude, lwVar2.dRo.dRs, lwVar2.dRo.dRt, lwVar2.dRo.width, lwVar2.dRo.height, lwVar2.dRo.filename, LocaleUtil.getApplicationLanguage()), 0);
                        break;
                    case 3:
                        lwVar2.dRp.path = ((h) lwVar2.dRo.dGJ).yFG;
                        break;
                }
                AppMethodBeat.o(55734);
                return true;
            }
            AppMethodBeat.o(55734);
            return false;
        }
    }
}
