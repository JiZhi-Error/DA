package com.tencent.mm.plugin.fav.b.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.fav.a.ac;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.fav.a.ak;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public final class e implements i, ac {
    private static Map<Long, f.a> dAC = new HashMap();
    private static Map<Long, Integer> tcr = new HashMap();
    private static Set<Long> tct = new HashSet();
    private Queue<g> dAA = new LinkedList();
    private boolean dAE = false;
    public int dAF = 0;
    private long dAG = 0;
    public MTimerHandler dAJ = new MTimerHandler(com.tencent.mm.kernel.g.aAk().getLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.fav.b.e.e.AnonymousClass3 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(101652);
            try {
                e.d(e.this);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.Fav.FavSendService", e2, "", new Object[0]);
            }
            AppMethodBeat.o(101652);
            return false;
        }

        public final String toString() {
            AppMethodBeat.i(101653);
            String str = super.toString() + "|scenePusher";
            AppMethodBeat.o(101653);
            return str;
        }
    }, false);
    private boolean running = false;

    static /* synthetic */ int b(e eVar) {
        int i2 = eVar.dAF;
        eVar.dAF = i2 - 1;
        return i2;
    }

    static /* synthetic */ void e(e eVar) {
        AppMethodBeat.i(101660);
        eVar.aax();
        AppMethodBeat.o(101660);
    }

    static {
        AppMethodBeat.i(101661);
        AppMethodBeat.o(101661);
    }

    public e() {
        AppMethodBeat.i(101654);
        com.tencent.mm.kernel.g.azz().a(401, this);
        AppMethodBeat.o(101654);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(final int i2, final int i3, String str, final q qVar) {
        AppMethodBeat.i(101655);
        Log.i("MicroMsg.Fav.FavSendService", "on scene end, errType %d, errCode %d", Integer.valueOf(i2), Integer.valueOf(i3));
        com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.fav.b.e.e.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(101648);
                if (qVar.getType() != 401) {
                    AppMethodBeat.o(101648);
                } else if (!(qVar instanceof ag)) {
                    AppMethodBeat.o(101648);
                } else {
                    e.this.dAE = false;
                    g gVar = ((ag) qVar).tbk;
                    long j2 = gVar.field_localId;
                    e.dAC.remove(Long.valueOf(j2));
                    if ((i2 == 0 && i3 == 0) || i3 == -400) {
                        e.tct.add(Long.valueOf(j2));
                    }
                    if (!(i2 == 0 || i3 == -400)) {
                        e.b(e.this);
                    }
                    Integer valueOf = Integer.valueOf(Util.nullAs((Integer) e.tcr.get(Long.valueOf(j2)), 0));
                    if (!(i2 == 1 || i2 == 0)) {
                        valueOf = Integer.valueOf(valueOf.intValue() - 1);
                        e.tcr.put(Long.valueOf(gVar.field_localId), valueOf);
                    }
                    if (valueOf.intValue() <= 0) {
                        int fS = h.fS(i2, i3);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(10659, 0, Integer.valueOf(gVar.field_type), Integer.valueOf(fS), Long.valueOf(b.b(gVar)), Long.valueOf(h.DR(gVar.field_localId)));
                        e.tcr.remove(Long.valueOf(j2));
                        Log.e("MicroMsg.Fav.FavSendService", "achieved retry limit, set error, localId:%d", Long.valueOf(j2));
                        if (gVar.field_itemStatus == 12) {
                            ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(14, gVar.field_localId);
                        }
                        if (gVar.field_itemStatus == 9) {
                            ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().af(11, gVar.field_localId);
                        }
                    }
                    if (e.this.dAF <= 0) {
                        Log.i("MicroMsg.Fav.FavSendService", "klem stopFlag <= 0 , Stop Service");
                        e.e(e.this);
                    } else if (!e.d(e.this)) {
                        e.startSync();
                        AppMethodBeat.o(101648);
                        return;
                    }
                    AppMethodBeat.o(101648);
                }
            }

            public final String toString() {
                AppMethodBeat.i(101649);
                String str = super.toString() + "|onSceneEnd";
                AppMethodBeat.o(101649);
                return str;
            }
        });
        AppMethodBeat.o(101655);
    }

    @Override // com.tencent.mm.plugin.fav.a.ac
    public final boolean big() {
        return this.dAE;
    }

    @Override // com.tencent.mm.plugin.fav.a.ac
    public final void run() {
        AppMethodBeat.i(101656);
        com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.fav.b.e.e.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(101650);
                long currentTimeMillis = System.currentTimeMillis() - e.this.dAG;
                if (e.this.running) {
                    if (currentTimeMillis < Util.MILLSECONDS_OF_MINUTE) {
                        AppMethodBeat.o(101650);
                        return;
                    }
                    Log.e("MicroMsg.Fav.FavSendService", "klem ERR: Try Run service runningFlag:" + e.this.running + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + e.this.running);
                }
                e.this.dAE = false;
                e.this.running = true;
                e.this.dAF = 3;
                e.this.dAJ.startTimer(10);
                AppMethodBeat.o(101650);
            }

            public final String toString() {
                AppMethodBeat.i(101651);
                String str = super.toString() + "|run";
                AppMethodBeat.o(101651);
                return str;
            }
        });
        AppMethodBeat.o(101656);
    }

    public final void aax() {
        AppMethodBeat.i(101657);
        Log.i("MicroMsg.Fav.FavSendService", "on finish");
        this.dAA.clear();
        dAC.clear();
        this.running = false;
        this.dAE = false;
        tcr.clear();
        AppMethodBeat.o(101657);
    }

    public static void startSync() {
        AppMethodBeat.i(101658);
        com.tencent.mm.kernel.g.azz().a(new ak(), 0);
        AppMethodBeat.o(101658);
    }

    static /* synthetic */ boolean d(e eVar) {
        g poll;
        List<g> cUT;
        AppMethodBeat.i(101659);
        Log.i("MicroMsg.Fav.FavSendService", "tryStartNetscene");
        eVar.dAG = System.currentTimeMillis();
        if (!eVar.dAE && eVar.dAA.size() == 0 && (cUT = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().cUT()) != null && cUT.size() != 0) {
            for (g gVar : cUT) {
                if (tct.contains(Long.valueOf(gVar.field_localId))) {
                    Log.i("MicroMsg.Fav.FavSendService", "info has existed, id %d, localId %d, sourceType %d, sourceId %s", Integer.valueOf(gVar.field_id), Long.valueOf(gVar.field_localId), Integer.valueOf(gVar.field_sourceType), gVar.field_sourceId);
                } else if (dAC.containsKey(Long.valueOf(gVar.field_localId))) {
                    Log.i("MicroMsg.Fav.FavSendService", "File is Already running:" + gVar.field_localId);
                } else {
                    if (!tcr.containsKey(Long.valueOf(gVar.field_localId))) {
                        tcr.put(Long.valueOf(gVar.field_localId), 3);
                    }
                    eVar.dAA.add(gVar);
                    dAC.put(Long.valueOf(gVar.field_localId), null);
                }
            }
            Log.i("MicroMsg.Fav.FavSendService", "klem GetNeedRun procing:" + dAC.size() + ",send:" + eVar.dAA.size() + "]");
            eVar.dAA.size();
        }
        if (eVar.dAE || eVar.dAA.size() > 0) {
            Log.i("MicroMsg.Fav.FavSendService", "Has Data, start service %d", Integer.valueOf(eVar.dAA.size()));
            if (!eVar.dAE && eVar.dAA.size() > 0 && (poll = eVar.dAA.poll()) != null && poll.field_localId > 0) {
                eVar.dAE = true;
                com.tencent.mm.kernel.g.azz().a(new ag(poll), 0);
                AppMethodBeat.o(101659);
                return true;
            }
        } else {
            eVar.aax();
            Log.i("MicroMsg.Fav.FavSendService", "klem No Data Any More , Stop Service");
        }
        AppMethodBeat.o(101659);
        return false;
    }
}
