package com.tencent.mm.pluginsdk.model.app;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.app.o;
import com.tencent.mm.blink.b;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.g.a.df;
import com.tencent.mm.g.a.dn;
import com.tencent.mm.g.a.ib;
import com.tencent.mm.g.a.jn;
import com.tencent.mm.g.a.r;
import com.tencent.mm.kernel.a;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.am;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.model.cg;
import com.tencent.mm.plugin.messenger.a.g;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.e;
import com.tencent.mm.pluginsdk.model.m;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public class ao implements bd {
    private static HashMap<Integer, h.b> baseDBFactories;
    private p JXa;
    private an.a JXb = null;
    private k JXc = new k();
    private e JXd = new e();
    private IListener<ib> JXe = new IListener<ib>() {
        /* class com.tencent.mm.pluginsdk.model.app.ao.AnonymousClass1 */

        {
            AppMethodBeat.i(232171);
            this.__eventId = ib.class.getName().hashCode();
            AppMethodBeat.o(232171);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ib ibVar) {
            AppMethodBeat.i(232172);
            ib ibVar2 = ibVar;
            m.a(ibVar2.dMF.dCE, "", "", ibVar2.dMF.username, ibVar2.dMF.dMG, (String) null);
            g.eir().ad(ibVar2.dMF.username, ibVar2.dMF.dMH, ab.JG(ibVar2.dMF.username));
            AppMethodBeat.o(232172);
            return false;
        }
    };
    private IListener<r> JXf = new IListener<r>() {
        /* class com.tencent.mm.pluginsdk.model.app.ao.AnonymousClass2 */

        {
            AppMethodBeat.i(232173);
            this.__eventId = r.class.getName().hashCode();
            AppMethodBeat.o(232173);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(r rVar) {
            AppMethodBeat.i(232174);
            r rVar2 = rVar;
            m.a(rVar2.dCD.dCE, "", "", rVar2.dCD.toUser, 2, (String) null);
            AppMethodBeat.o(232174);
            return false;
        }
    };
    private IListener JXg = new IListener<jn>() {
        /* class com.tencent.mm.pluginsdk.model.app.ao.AnonymousClass7 */

        {
            AppMethodBeat.i(232179);
            this.__eventId = jn.class.getName().hashCode();
            AppMethodBeat.o(232179);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(jn jnVar) {
            AppMethodBeat.i(232181);
            boolean a2 = a(jnVar);
            AppMethodBeat.o(232181);
            return a2;
        }

        private static boolean a(jn jnVar) {
            int i2;
            AppMethodBeat.i(232180);
            try {
                if (com.tencent.mm.n.h.aqJ() == null) {
                    i2 = 0;
                } else {
                    i2 = Util.getInt(com.tencent.mm.n.h.aqJ().getValue("AndroidUseUnicodeEmoji"), 0);
                }
            } catch (Exception e2) {
                i2 = 0;
            }
            jnVar.dOq.dGy = i2;
            AppMethodBeat.o(232180);
            return false;
        }
    };
    private IListener JXh = new IListener<df>() {
        /* class com.tencent.mm.pluginsdk.model.app.ao.AnonymousClass8 */

        {
            AppMethodBeat.i(232182);
            this.__eventId = df.class.getName().hashCode();
            AppMethodBeat.o(232182);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(df dfVar) {
            AppMethodBeat.i(232183);
            int i2 = Util.getInt(com.tencent.mm.n.h.aqJ().getValue("AndroidUseUnicodeEmoji"), 0);
            dn dnVar = new dn();
            dnVar.dGx.dGy = i2;
            EventCenter.instance.publish(dnVar);
            AppMethodBeat.o(232183);
            return false;
        }
    };
    private o.a appForegroundListener = new o.a() {
        /* class com.tencent.mm.pluginsdk.model.app.ao.AnonymousClass6 */

        {
            AppMethodBeat.i(161482);
            AppMethodBeat.o(161482);
        }

        @Override // com.tencent.mm.app.o
        public final void onAppForeground(String str) {
            AppMethodBeat.i(232177);
            if (com.tencent.mm.kernel.g.aAc() && com.tencent.mm.kernel.g.aAf().hpY) {
                com.tencent.mm.kernel.g.aAf();
                if (!a.azj()) {
                    b.ake().arrange(new Runnable() {
                        /* class com.tencent.mm.pluginsdk.model.app.ao.AnonymousClass6.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(232176);
                            ao.gnh().run();
                            AppMethodBeat.o(232176);
                        }
                    });
                }
            }
            AppMethodBeat.o(232177);
        }

        @Override // com.tencent.mm.app.o
        public final void onAppBackground(String str) {
            AppMethodBeat.i(232178);
            if (com.tencent.mm.kernel.g.aAc() && com.tencent.mm.kernel.g.aAf().hpY) {
                com.tencent.mm.kernel.g.aAf();
                a.azj();
            }
            AppMethodBeat.o(232178);
        }
    };

    public ao() {
        AppMethodBeat.i(31121);
        AppMethodBeat.o(31121);
    }

    private static ao gnd() {
        AppMethodBeat.i(31122);
        bg.aVz();
        ao aoVar = (ao) cg.KG(ao.class.getName());
        if (aoVar == null) {
            aoVar = new ao();
        }
        AppMethodBeat.o(31122);
        return aoVar;
    }

    public static k gne() {
        AppMethodBeat.i(31123);
        k kVar = gnd().JXc;
        AppMethodBeat.o(31123);
        return kVar;
    }

    public static d cgO() {
        AppMethodBeat.i(31124);
        d cgO = com.tencent.mm.plugin.r.a.cgO();
        AppMethodBeat.o(31124);
        return cgO;
    }

    public static i eAR() {
        AppMethodBeat.i(31125);
        i eAR = com.tencent.mm.plugin.r.a.eAR();
        AppMethodBeat.o(31125);
        return eAR;
    }

    public static j eAS() {
        AppMethodBeat.i(31126);
        j eAS = com.tencent.mm.plugin.r.a.eAS();
        AppMethodBeat.o(31126);
        return eAS;
    }

    public static l gnf() {
        AppMethodBeat.i(31127);
        l eAT = com.tencent.mm.plugin.r.a.eAT();
        AppMethodBeat.o(31127);
        return eAT;
    }

    public static p gng() {
        AppMethodBeat.i(31128);
        com.tencent.mm.kernel.g.aAf().azk();
        if (gnd().JXa == null) {
            ao gnd = gnd();
            bg.aVF();
            gnd.JXa = new p(c.getDataDB());
        }
        p pVar = gnd().JXa;
        AppMethodBeat.o(31128);
        return pVar;
    }

    public static an.a gnh() {
        AppMethodBeat.i(31129);
        com.tencent.mm.kernel.g.aAf().azk();
        if (gnd().JXb == null) {
            gnd().JXb = new an.a();
        }
        an.a aVar = gnd().JXb;
        AppMethodBeat.o(31129);
        return aVar;
    }

    public static n eAU() {
        AppMethodBeat.i(31130);
        n eAU = com.tencent.mm.plugin.r.a.eAU();
        AppMethodBeat.o(31130);
        return eAU;
    }

    public static e eAV() {
        AppMethodBeat.i(31131);
        e eAV = com.tencent.mm.plugin.r.a.eAV();
        AppMethodBeat.o(31131);
        return eAV;
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(31132);
        an.a aVar = gnd().JXb;
        if (aVar != null) {
            aVar.dAF = 0;
        }
        h.d.b(47, this.JXd);
        h.d.b(49, this.JXc);
        this.appForegroundListener.dead();
        EventCenter.instance.removeListener(this.JXg);
        EventCenter.instance.removeListener(this.JXh);
        this.JXe.dead();
        this.JXf.dead();
        m.gmv();
        AppMethodBeat.o(31132);
    }

    static {
        AppMethodBeat.i(31134);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        baseDBFactories = hashMap;
        hashMap.put(Integer.valueOf("APPMESSAGE_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.pluginsdk.model.app.ao.AnonymousClass3 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return l.SQL_CREATE;
            }
        });
        baseDBFactories.put(Integer.valueOf("APPSORT_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.pluginsdk.model.app.ao.AnonymousClass4 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return p.SQL_CREATE;
            }
        });
        AppMethodBeat.o(31134);
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return baseDBFactories;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
        AppMethodBeat.i(31133);
        am.a.iDo = com.tencent.mm.plugin.r.a.eAR();
        h.d.a(47, this.JXd);
        h.d.a(49, this.JXc);
        EventCenter.instance.addListener(this.JXg);
        EventCenter.instance.addListener(this.JXh);
        this.appForegroundListener.alive();
        this.JXe.alive();
        this.JXf.alive();
        AnonymousClass5 r0 = new Runnable() {
            /* class com.tencent.mm.pluginsdk.model.app.ao.AnonymousClass5 */

            {
                AppMethodBeat.i(161481);
                AppMethodBeat.o(161481);
            }

            public final void run() {
                AppMethodBeat.i(232175);
                SightVideoJNI.registerALL();
                AppMethodBeat.o(232175);
            }
        };
        try {
            r0.run();
            AppMethodBeat.o(31133);
        } catch (Throwable th) {
            if (d.oE(20)) {
                r0.run();
                AppMethodBeat.o(31133);
                return;
            }
            AppMethodBeat.o(31133);
            throw th;
        }
    }
}
