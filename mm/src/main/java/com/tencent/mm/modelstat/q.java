package com.tencent.mm.modelstat;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.h;
import com.tencent.mm.co.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.bd;
import com.tencent.mm.model.y;
import com.tencent.mm.network.ac;
import com.tencent.mm.network.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storagebase.h;
import java.util.HashMap;

public class q implements bd {
    private static HashMap<Integer, h.b> baseDBFactories;
    private p iRt = new p.a() {
        /* class com.tencent.mm.modelstat.q.AnonymousClass3 */

        @Override // com.tencent.mm.network.p
        public final void onNetworkChange(int i2) {
            AppMethodBeat.i(151134);
            if (i2 == 4 || i2 == 6) {
                g.aAk().postToWorkerDelayed(new Runnable() {
                    /* class com.tencent.mm.modelstat.q.AnonymousClass3.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(151132);
                        if (!g.aAf().azp()) {
                            AppMethodBeat.o(151132);
                            return;
                        }
                        q.bgm().bgh();
                        AppMethodBeat.o(151132);
                    }

                    public final String toString() {
                        AppMethodBeat.i(151133);
                        String str = super.toString() + "|onNetworkChange";
                        AppMethodBeat.o(151133);
                        return str;
                    }
                }, 3000);
                Log.d("MicroMsg.SubCoreStat", "NetTypeReporter st:%d", Integer.valueOf(i2));
                o.run(2);
                AppMethodBeat.o(151134);
                return;
            }
            AppMethodBeat.o(151134);
        }
    };
    private l jpq = new l();
    private com.tencent.mm.co.h<m> jpr = new com.tencent.mm.co.h<>(new c<m>() {
        /* class com.tencent.mm.modelstat.q.AnonymousClass1 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.tencent.mm.co.c
        public final /* synthetic */ m get() {
            AppMethodBeat.i(151130);
            m mVar = new m(g.aAh().hqK);
            AppMethodBeat.o(151130);
            return mVar;
        }
    });
    private ac jps = new ac();
    private com.tencent.mm.co.h<g> jpt = new com.tencent.mm.co.h<>(new c<g>() {
        /* class com.tencent.mm.modelstat.q.AnonymousClass2 */

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.tencent.mm.co.c
        public final /* synthetic */ g get() {
            AppMethodBeat.i(151131);
            g gVar = new g(ar.NSe);
            AppMethodBeat.o(151131);
            return gVar;
        }
    });

    public q() {
        AppMethodBeat.i(151136);
        AppMethodBeat.o(151136);
    }

    public static g bgm() {
        AppMethodBeat.i(151137);
        g.aAf().azk();
        g gVar = bgn().jpt.get();
        AppMethodBeat.o(151137);
        return gVar;
    }

    private static q bgn() {
        AppMethodBeat.i(151138);
        q qVar = (q) y.at(q.class);
        AppMethodBeat.o(151138);
        return qVar;
    }

    public static m bgo() {
        AppMethodBeat.i(151139);
        g.aAf().azk();
        m mVar = bgn().jpr.get();
        AppMethodBeat.o(151139);
        return mVar;
    }

    public static void d(com.tencent.mm.network.g gVar) {
        boolean z;
        AppMethodBeat.i(151140);
        Object[] objArr = new Object[2];
        if (gVar == null) {
            z = true;
        } else {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        objArr[1] = Util.getStack();
        Log.d("MicroMsg.SubCoreStat", "dknetstat setNetworkMoniter  isnull:%b  ,  %s ", objArr);
        if (gVar != null) {
            gVar.a(bgn().jpq);
        }
        AppMethodBeat.o(151140);
    }

    public static void e(com.tencent.mm.network.g gVar) {
        AppMethodBeat.i(151141);
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(gVar == null);
        objArr[1] = Util.getStack();
        Log.d("MicroMsg.SubCoreStat", "setKVReportMonitor  isnull:%b  ,  %s ", objArr);
        if (gVar != null) {
            gVar.a(bgn().jps);
        }
        AppMethodBeat.o(151141);
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountRelease() {
        AppMethodBeat.i(151142);
        g.aAg().b(this.iRt);
        h.d.b(9998, this.jpq);
        this.jpq = new l();
        ay.a.iDr = null;
        AppMethodBeat.o(151142);
    }

    static {
        AppMethodBeat.i(151144);
        HashMap<Integer, h.b> hashMap = new HashMap<>();
        baseDBFactories = hashMap;
        hashMap.put(Integer.valueOf("NETSTAT_TABLE".hashCode()), new h.b() {
            /* class com.tencent.mm.modelstat.q.AnonymousClass4 */

            @Override // com.tencent.mm.storagebase.h.b
            public final String[] getSQLs() {
                return m.SQL_CREATE;
            }
        });
        AppMethodBeat.o(151144);
    }

    @Override // com.tencent.mm.model.bd
    public HashMap<Integer, h.b> getBaseDBFactories() {
        return baseDBFactories;
    }

    @Override // com.tencent.mm.model.bd
    public void clearPluginData(int i2) {
    }

    @Override // com.tencent.mm.model.bd
    public void onAccountPostReset(boolean z) {
        AppMethodBeat.i(151143);
        h.d.a(9998, this.jpq);
        g.aAg().a(this.iRt);
        ay.a.iDr = new ay.e() {
            /* class com.tencent.mm.modelstat.q.AnonymousClass5 */

            @Override // com.tencent.mm.model.ay.e
            public final void dl(int i2, int i3) {
                AppMethodBeat.i(151135);
                Log.d("MicroMsg.SubCoreStat", "ReportDataFlow [%d][%d][%d] : %s ", Integer.valueOf(i2), Integer.valueOf(i3), 0, Util.getStack());
                n.D((long) i2, (long) i3);
                AppMethodBeat.o(151135);
            }
        };
        AppMethodBeat.o(151143);
    }

    @Override // com.tencent.mm.model.bd
    public void onSdcardMount(boolean z) {
    }
}
