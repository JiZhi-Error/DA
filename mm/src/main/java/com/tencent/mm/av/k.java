package com.tencent.mm.av;

import android.os.SystemClock;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.modelmulti.o;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.report.e;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public final class k implements i, j {
    private static Set<Integer> iYD = new HashSet();
    private Queue<g> dAA = new LinkedList();
    private boolean dAE = false;
    int dAF = 0;
    private long dAG = 0;
    f.a dAI = new f.a();
    private MTimerHandler dAJ;
    private LinkedList<n> iYE = new LinkedList<>();
    public a iYF = null;
    private boolean iYG = false;
    public n iYH = new n() {
        /* class com.tencent.mm.av.k.AnonymousClass1 */

        @Override // com.tencent.mm.ak.n
        public final void aYO() {
            AppMethodBeat.i(150643);
            g.aAi();
            g.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.av.k.AnonymousClass1.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(150642);
                    Log.i("MicroMsg.ImgService", "on image upload end. queue size : " + k.this.iYE.size());
                    k.this.iYG = false;
                    if (k.this.iYE.size() > 0) {
                        n nVar = (n) k.this.iYE.poll();
                        if (nVar != null) {
                            Log.i("MicroMsg.ImgService", "upload image scene hashcode : " + nVar.hashCode());
                            g.aAg().hqi.a(nVar, 0);
                            k.this.iYG = true;
                            AppMethodBeat.o(150642);
                            return;
                        }
                        Log.w("MicroMsg.ImgService", "poll image scene is null");
                    }
                    AppMethodBeat.o(150642);
                }
            });
            AppMethodBeat.o(150643);
        }
    };
    private boolean running = false;

    public interface a {
        void a(long j2, int i2, int i3);

        void j(long j2, boolean z);
    }

    static /* synthetic */ void f(k kVar) {
        AppMethodBeat.i(150664);
        kVar.aax();
        AppMethodBeat.o(150664);
    }

    static {
        AppMethodBeat.i(150665);
        AppMethodBeat.o(150665);
    }

    public static boolean tn(int i2) {
        AppMethodBeat.i(150652);
        if (CrashReportFactory.hasDebuger() || BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE) {
            Log.i("MicroMsg.ImgService", "setRun imgLocalId %s %s", Integer.valueOf(i2), Util.getStack().toString());
        }
        boolean add = iYD.add(Integer.valueOf(i2));
        AppMethodBeat.o(150652);
        return add;
    }

    public static boolean to(int i2) {
        AppMethodBeat.i(150653);
        if (CrashReportFactory.hasDebuger() || BuildInfo.IS_FLAVOR_RED || BuildInfo.IS_FLAVOR_PURPLE) {
            Log.i("MicroMsg.ImgService", "removeRun imgLocalId %s %s", Integer.valueOf(i2), Util.getStack().toString());
        }
        boolean remove = iYD.remove(Integer.valueOf(i2));
        AppMethodBeat.o(150653);
        return remove;
    }

    public k() {
        AppMethodBeat.i(150654);
        g.aAi();
        this.dAJ = new MTimerHandler(g.aAk().getLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
            /* class com.tencent.mm.av.k.AnonymousClass5 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(150649);
                try {
                    k.e(k.this);
                } catch (Exception e2) {
                    Log.e("MicroMsg.ImgService", "exception:%s", Util.stackTraceToString(e2));
                }
                AppMethodBeat.o(150649);
                return false;
            }

            public final String toString() {
                AppMethodBeat.i(150650);
                String str = super.toString() + "|scenePusher";
                AppMethodBeat.o(150650);
                return str;
            }
        }, false);
        if (g.aAg().hqi != null) {
            g.aAg().hqi.a(110, this);
        }
        this.iYE.clear();
        this.iYG = false;
        AppMethodBeat.o(150654);
    }

    public final long a(String str, String str2, String str3, int i2, boolean z) {
        AppMethodBeat.i(150655);
        int i3 = z.f(str3, str2, z) ? 1 : 0;
        Log.v("MicroMsg.ImgService", "pushsendimage, param.compressImg:%b, compresstype:%d", Boolean.valueOf(z), Integer.valueOf(i3));
        o.e tc = o.a(o.d.jdL).tc(3);
        tc.dRL = str;
        tc.toUser = str2;
        tc.iZt = str3;
        tc.iXp = i3;
        tc.jdS = this;
        tc.dQd = i2;
        tc.jdT = this.iYH;
        tc.jdV = true;
        tc.jdU = R.drawable.c3h;
        tc.jdR = 10;
        n nVar = (n) tc.bdQ().jdJ;
        a(nVar);
        long j2 = nVar.bcD().field_msgId;
        AppMethodBeat.o(150655);
        return j2;
    }

    public final void a(String str, String str2, ArrayList<String> arrayList) {
        AppMethodBeat.i(150656);
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            int i2 = z.f(next, str2, false) ? 1 : 0;
            Log.v("MicroMsg.ImgService", "pushsendimage, param.compressImg:%b, compresstype:%d", Boolean.FALSE, Integer.valueOf(i2));
            o.e tc = o.a(o.d.jdL).tc(3);
            tc.dRL = str;
            tc.toUser = str2;
            tc.iZt = next;
            tc.iXp = i2;
            tc.jdS = this;
            tc.dQd = 0;
            tc.jdT = this.iYH;
            tc.jdV = true;
            tc.jdU = R.drawable.c3h;
            tc.jdR = 10;
            a((n) tc.bdQ().jdJ);
        }
        AppMethodBeat.o(150656);
    }

    public final void a(final n nVar) {
        AppMethodBeat.i(150657);
        if (nVar == null) {
            AppMethodBeat.o(150657);
            return;
        }
        g.aAi();
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.av.k.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(150644);
                Log.i("MicroMsg.ImgService", "offer to queue ? %b, scene hashcode %d", Boolean.valueOf(k.this.iYG), Integer.valueOf(nVar.hashCode()));
                if (k.this.iYG) {
                    k.this.iYE.offer(nVar);
                    AppMethodBeat.o(150644);
                    return;
                }
                g.aAg().hqi.a(nVar, 0);
                k.this.iYG = true;
                AppMethodBeat.o(150644);
            }
        });
        AppMethodBeat.o(150657);
    }

    public static void tp(int i2) {
        ca Hb;
        AppMethodBeat.i(150658);
        Log.w("MicroMsg.ImgService", "setImgError, %d", Integer.valueOf(i2));
        g tl = q.bcR().tl(i2);
        if (tl == null || tl.localId <= 0) {
            AppMethodBeat.o(150658);
            return;
        }
        g tm = q.bcR().tm((int) tl.localId);
        if (tm != null) {
            tm.setStatus(-1);
            tm.cSx = 264;
            q.bcR().a((int) tm.localId, tm);
            Hb = ((l) g.af(l.class)).eiy().Hb(tm.iXv);
        } else {
            tl.setStatus(-1);
            tl.cSx = 264;
            q.bcR().a(i2, tl);
            Hb = ((l) g.af(l.class)).eiy().Hb(tl.iXv);
        }
        if (Hb.field_msgId != tl.iXv) {
            AppMethodBeat.o(150658);
            return;
        }
        Hb.setStatus(5);
        e.INSTANCE.idkeyStat(111, 31, 1, true);
        ((l) g.af(l.class)).eiy().a((long) ((int) Hb.field_msgId), Hb);
        AppMethodBeat.o(150658);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, final q qVar) {
        AppMethodBeat.i(150659);
        Log.i("MicroMsg.ImgService", "onSceneEnd errType %d, errCode %d, errMsg %s ", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (qVar instanceof n) {
            n nVar = (n) qVar;
            if (!(this.iYF == null || nVar == null || nVar.bcD() == null)) {
                this.iYF.j(nVar.bcD().field_msgId, nVar.bcD().field_status != 5);
            }
        }
        g.aAi();
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.av.k.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(150645);
                if (qVar.getType() != 110) {
                    AppMethodBeat.o(150645);
                } else if (!(qVar instanceof n)) {
                    AppMethodBeat.o(150645);
                } else {
                    k.this.dAE = false;
                    int i2 = (int) ((n) qVar).iYP;
                    if (k.this.dAF > 0) {
                        k.e(k.this);
                    } else {
                        k.f(k.this);
                    }
                    k.to(i2);
                    AppMethodBeat.o(150645);
                }
            }

            public final String toString() {
                AppMethodBeat.i(150646);
                String str = super.toString() + "|onSceneEnd";
                AppMethodBeat.o(150646);
                return str;
            }
        });
        AppMethodBeat.o(150659);
    }

    private void aax() {
        AppMethodBeat.i(150660);
        this.dAA.clear();
        this.running = false;
        Log.d("MicroMsg.ImgService", "Finish service use time(ms):" + this.dAI.apr());
        AppMethodBeat.o(150660);
    }

    public final void run() {
        AppMethodBeat.i(150661);
        g.aAi();
        g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.av.k.AnonymousClass4 */

            public final void run() {
                AppMethodBeat.i(150647);
                long currentTimeMillis = System.currentTimeMillis() - k.this.dAG;
                if (k.this.running) {
                    if (currentTimeMillis < Util.MILLSECONDS_OF_MINUTE) {
                        AppMethodBeat.o(150647);
                        return;
                    }
                    Log.e("MicroMsg.ImgService", "ERR: Try Run service runningFlag:" + k.this.running + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + k.this.running);
                }
                Log.i("MicroMsg.ImgService", "run from run");
                k.this.running = true;
                k.this.dAF = 3;
                k.this.dAI.gLm = SystemClock.elapsedRealtime();
                k.this.dAJ.startTimer(10);
                AppMethodBeat.o(150647);
            }

            public final String toString() {
                AppMethodBeat.i(150648);
                String str = super.toString() + "|run";
                AppMethodBeat.o(150648);
                return str;
            }
        });
        AppMethodBeat.o(150661);
    }

    @Override // com.tencent.mm.ak.j
    public final void a(int i2, int i3, q qVar) {
        AppMethodBeat.i(150662);
        n nVar = (n) qVar;
        if (!(this.iYF == null || nVar == null || nVar.bcD() == null)) {
            this.iYF.a(nVar.bcD().field_msgId, i2, i3);
        }
        AppMethodBeat.o(150662);
    }

    static /* synthetic */ void e(k kVar) {
        AppMethodBeat.i(150663);
        kVar.dAG = System.currentTimeMillis();
        if (!kVar.dAE && kVar.dAA.size() == 0) {
            List<g> bcz = q.bcR().bcz();
            if (bcz.size() == 0) {
                Log.i("MicroMsg.ImgService", "get need run info by search db, but size is 0.");
            } else {
                for (g gVar : bcz) {
                    if (Util.isNullOrNil(gVar.iXm)) {
                        Log.i("MicroMsg.ImgService", "the process is killed while selecting pic");
                    } else {
                        g tm = q.bcR().tm((int) gVar.localId);
                        if (iYD.contains(Integer.valueOf(tm == null ? (int) gVar.localId : (int) tm.localId))) {
                            Log.d("MicroMsg.ImgService", "File is Already running:" + gVar.localId);
                        } else if (tm == null ? !(gVar.iXv <= 0 || gVar.dTS > 0 || gVar.offset > gVar.iKP || gVar.status == -1) : !(tm.iXv <= 0 || tm.dTS > 0 || gVar.offset > gVar.iKP || gVar.status == -1 || tm.status == -1)) {
                            if (((long) (gVar.iXu + 600)) < Util.nowSecond()) {
                                tp((int) gVar.localId);
                            } else {
                                Log.i("MicroMsg.ImgService", "getNeedRunInfo queueSend add %s %s %s %s", Long.valueOf(gVar.localId), Boolean.valueOf(gVar.bcu()), Integer.valueOf(gVar.offset), Integer.valueOf(gVar.iKP));
                                kVar.dAA.add(gVar);
                            }
                        }
                    }
                }
                kVar.dAA.size();
            }
        }
        if (kVar.dAE || kVar.dAA.size() > 0) {
            g gVar2 = null;
            if (!kVar.dAE && kVar.dAA.size() > 0) {
                while (kVar.dAA.size() > 0) {
                    gVar2 = kVar.dAA.poll();
                    g tm2 = q.bcR().tm((int) gVar2.localId);
                    if (iYD.contains(Integer.valueOf(tm2 == null ? (int) gVar2.localId : (int) tm2.localId))) {
                        gVar2 = null;
                    }
                }
                kVar.dAE = true;
                if (gVar2 != null && gVar2.localId > 0) {
                    g tm3 = q.bcR().tm((int) gVar2.localId);
                    if (tm3 != null) {
                        Log.i("MicroMsg.ImgService", "try upload hdinfo %s", Long.valueOf(tm3.localId));
                        o.e a2 = o.a(o.d.jdL);
                        a2.jdZ = (int) tm3.localId;
                        a2.jdR = 2;
                        a2.bdQ().execute();
                        AppMethodBeat.o(150663);
                        return;
                    }
                    Log.i("MicroMsg.ImgService", "try upload normalinfo %s", Long.valueOf(gVar2.localId));
                    o.e a3 = o.a(o.d.jdL);
                    a3.jdZ = (int) gVar2.localId;
                    a3.iXp = 0;
                    a3.jdR = 2;
                    a3.bdQ().execute();
                }
            }
            AppMethodBeat.o(150663);
            return;
        }
        kVar.aax();
        Log.d("MicroMsg.ImgService", "No Data Any More , Stop Service");
        AppMethodBeat.o(150663);
    }
}
