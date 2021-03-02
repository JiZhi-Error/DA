package com.tencent.mm.plugin.fav.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.aj;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class b implements i, r {
    private static Map<Long, f.a> dAC = new HashMap();
    private Queue<g> dAA = new LinkedList();
    private boolean dAE = false;
    private long dAG = 0;
    public MTimerHandler dAJ = new MTimerHandler(com.tencent.mm.kernel.g.aAk().getLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.fav.b.e.b.AnonymousClass4 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(101614);
            try {
                b.b(b.this);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.Fav.FavCheckCdnService", e2, "", new Object[0]);
            }
            AppMethodBeat.o(101614);
            return false;
        }

        public final String toString() {
            AppMethodBeat.i(101615);
            String str = super.toString() + "|scenePusher";
            AppMethodBeat.o(101615);
            return str;
        }
    }, false);
    public p iRt = new p.a() {
        /* class com.tencent.mm.plugin.fav.b.e.b.AnonymousClass2 */

        @Override // com.tencent.mm.network.p
        public final void onNetworkChange(int i2) {
            AppMethodBeat.i(101611);
            try {
                boolean isWifi = NetStatusUtil.isWifi(MMApplicationContext.getContext());
                if (i2 == 4 || i2 == 6) {
                    Log.i("MicroMsg.Fav.FavCheckCdnService", "onNetworkChange st:%d isWifi:%B, lastIsWifi:%B", Integer.valueOf(i2), Boolean.valueOf(isWifi), Boolean.valueOf(b.this.tcf));
                    if (!b.this.tcf && isWifi) {
                        b bVar = b.this;
                        List<g> cUR = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().cUR();
                        if (cUR == null || cUR.size() <= 0) {
                            Log.i("MicroMsg.Fav.FavCheckCdnService", "startAll list.size 0");
                        } else {
                            Log.i("MicroMsg.Fav.FavCheckCdnService", "startAll list.size:%d", Integer.valueOf(cUR.size()));
                            for (g gVar : cUR) {
                                if (gVar.field_itemStatus == 3) {
                                    gVar.field_itemStatus = 1;
                                    ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(gVar, ch.COL_LOCALID);
                                }
                            }
                            bVar.run();
                        }
                    }
                    b.this.tcf = isWifi;
                    AppMethodBeat.o(101611);
                    return;
                }
                b.this.tcf = isWifi;
                AppMethodBeat.o(101611);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.Fav.FavCheckCdnService", e2, "", new Object[0]);
                AppMethodBeat.o(101611);
            }
        }
    };
    private boolean running = false;
    private boolean tcf = NetStatusUtil.isWifi(MMApplicationContext.getContext());

    static {
        AppMethodBeat.i(101621);
        AppMethodBeat.o(101621);
    }

    public b() {
        AppMethodBeat.i(101616);
        com.tencent.mm.kernel.g.aAg().a(this.iRt);
        com.tencent.mm.kernel.g.azz().a(404, this);
        AppMethodBeat.o(101616);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(final int i2, int i3, String str, final q qVar) {
        AppMethodBeat.i(101617);
        com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.fav.b.e.b.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(101609);
                if (qVar.getType() != 404) {
                    AppMethodBeat.o(101609);
                } else if (!(qVar instanceof aj)) {
                    AppMethodBeat.o(101609);
                } else {
                    b.this.dAE = false;
                    long j2 = ((aj) qVar).tbr.field_localId;
                    g gVar = ((aj) qVar).tbr;
                    b.dAC.remove(Long.valueOf(j2));
                    if (i2 != 0) {
                        Log.e("MicroMsg.Fav.FavCheckCdnService", "achieved retry limit, set error, localId:%d", Long.valueOf(j2));
                        h.INSTANCE.a(10659, 0, Integer.valueOf(gVar.field_type), -2, Long.valueOf(com.tencent.mm.plugin.fav.a.b.b(gVar)), Long.valueOf(com.tencent.mm.plugin.fav.a.h.DR(gVar.field_localId)));
                        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(3, j2);
                    }
                    b.b(b.this);
                    AppMethodBeat.o(101609);
                }
            }

            public final String toString() {
                AppMethodBeat.i(101610);
                String str = super.toString() + "|onSceneEnd";
                AppMethodBeat.o(101610);
                return str;
            }
        });
        AppMethodBeat.o(101617);
    }

    @Override // com.tencent.mm.plugin.fav.a.r
    public final void run() {
        AppMethodBeat.i(101618);
        com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.fav.b.e.b.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(101612);
                long currentTimeMillis = System.currentTimeMillis() - b.this.dAG;
                if (b.this.running) {
                    if (currentTimeMillis < Util.MILLSECONDS_OF_MINUTE) {
                        AppMethodBeat.o(101612);
                        return;
                    }
                    Log.e("MicroMsg.Fav.FavCheckCdnService", "klem ERR: Try Run service runningFlag:" + b.this.running + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + b.this.running);
                }
                b.this.dAE = false;
                b.this.running = true;
                b.this.dAJ.startTimer(10);
                AppMethodBeat.o(101612);
            }

            public final String toString() {
                AppMethodBeat.i(101613);
                String str = super.toString() + "|run";
                AppMethodBeat.o(101613);
                return str;
            }
        });
        AppMethodBeat.o(101618);
    }

    public final void aax() {
        AppMethodBeat.i(101619);
        this.dAA.clear();
        dAC.clear();
        this.running = false;
        this.dAE = false;
        AppMethodBeat.o(101619);
    }

    static /* synthetic */ void b(b bVar) {
        g poll;
        List<g> cUS;
        AppMethodBeat.i(101620);
        bVar.dAG = System.currentTimeMillis();
        if (!bVar.dAE && bVar.dAA.size() == 0 && (cUS = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().cUS()) != null && cUS.size() != 0) {
            for (g gVar : cUS) {
                if (dAC.containsKey(Long.valueOf(gVar.field_localId))) {
                    Log.d("MicroMsg.Fav.FavCheckCdnService", "File is Already running:" + gVar.field_localId);
                } else {
                    bVar.dAA.add(gVar);
                    dAC.put(Long.valueOf(gVar.field_localId), null);
                }
            }
            Log.i("MicroMsg.Fav.FavCheckCdnService", "klem GetNeedRun procing:" + dAC.size() + ",send:" + bVar.dAA.size() + "]");
            bVar.dAA.size();
        }
        if (bVar.dAE || bVar.dAA.size() > 0) {
            if (!bVar.dAE && bVar.dAA.size() > 0 && (poll = bVar.dAA.poll()) != null && poll.field_localId > 0) {
                bVar.dAE = true;
                com.tencent.mm.kernel.g.azz().a(new aj(poll), 0);
            }
            AppMethodBeat.o(101620);
            return;
        }
        bVar.aax();
        Log.i("MicroMsg.Fav.FavCheckCdnService", "klem No Data Any More , Stop Service");
        AppMethodBeat.o(101620);
    }
}
