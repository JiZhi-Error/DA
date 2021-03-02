package com.tencent.mm.plugin.fav.b.e;

import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.ak;
import com.tencent.mm.plugin.fav.a.am;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.a.z;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.ane;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.cps;
import com.tencent.mm.protocal.protobuf.cpv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.wxmm.v2helper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class d implements i, z {
    private static Map<Integer, f.a> dAC = new HashMap();
    private static Map<Integer, Integer> tcr = new HashMap();
    private Queue<g> dAA = new LinkedList();
    private boolean dAE = false;
    public int dAF = 0;
    private long dAG = 0;
    public MTimerHandler dAJ = new MTimerHandler(com.tencent.mm.kernel.g.aAk().getLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
        /* class com.tencent.mm.plugin.fav.b.e.d.AnonymousClass3 */

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(101636);
            try {
                d.d(d.this);
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.Fav.FavModService", e2, "", new Object[0]);
            }
            AppMethodBeat.o(101636);
            return false;
        }

        public final String toString() {
            AppMethodBeat.i(101637);
            String str = super.toString() + "|scenePusher";
            AppMethodBeat.o(101637);
            return str;
        }
    }, false);
    private boolean running = false;

    static /* synthetic */ int b(d dVar) {
        int i2 = dVar.dAF;
        dVar.dAF = i2 - 1;
        return i2;
    }

    static /* synthetic */ void e(d dVar) {
        AppMethodBeat.i(101646);
        dVar.aax();
        AppMethodBeat.o(101646);
    }

    static {
        AppMethodBeat.i(101647);
        AppMethodBeat.o(101647);
    }

    public d() {
        AppMethodBeat.i(101638);
        com.tencent.mm.kernel.g.azz().a(v2helper.EMethodSetAgcRxOn, this);
        AppMethodBeat.o(101638);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(final int i2, final int i3, String str, final q qVar) {
        AppMethodBeat.i(101639);
        if (qVar.getType() != 426) {
            AppMethodBeat.o(101639);
        } else if (!(qVar instanceof am)) {
            AppMethodBeat.o(101639);
        } else {
            com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.fav.b.e.d.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(101632);
                    d.this.dAE = false;
                    int i2 = ((am) qVar).tbB;
                    d.dAC.remove(Integer.valueOf(i2));
                    if (!(i3 == 3 && i3 == 0)) {
                        d.b(d.this);
                    }
                    g DZ = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DZ((long) i2);
                    if (DZ == null || DZ.field_itemStatus == 10) {
                        AppMethodBeat.o(101632);
                        return;
                    }
                    if (i2 != 0 || i3 != 0) {
                        Integer valueOf = Integer.valueOf(Util.nullAs((Integer) d.tcr.get(Integer.valueOf(i2)), 0));
                        if (!(i2 == 1 || i2 == 0)) {
                            valueOf = Integer.valueOf(valueOf.intValue() - 1);
                        }
                        if (valueOf.intValue() <= 0) {
                            int fS = h.fS(i2, i3);
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(10659, 0, Integer.valueOf(DZ.field_type), Integer.valueOf(fS), Long.valueOf(b.b(DZ)), Long.valueOf(h.DR(DZ.field_localId)));
                            d.tcr.remove(Integer.valueOf(i2));
                            Log.e("MicroMsg.Fav.FavModService", "achieved retry limit, set error, favId:%d", Integer.valueOf(i2));
                            DZ.field_itemStatus = 18;
                            ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(DZ, ch.COL_LOCALID);
                        }
                    } else if (DZ.field_itemStatus == 17) {
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(10659, 0, Integer.valueOf(DZ.field_type), 0, Long.valueOf(b.b(DZ)), Long.valueOf(h.DR(DZ.field_localId)));
                        Log.i("MicroMsg.Fav.FavModService", "mod end set status done. favId:%d", Integer.valueOf(DZ.field_id));
                        DZ.field_itemStatus = 10;
                        d.B(DZ);
                        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a(DZ, ch.COL_LOCALID);
                        ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().DV(DZ.field_localId);
                    }
                    if (d.this.dAF <= 0) {
                        Log.i("MicroMsg.Fav.FavModService", "klem stopFlag <= 0 , Stop Service");
                        d.e(d.this);
                    } else if (!d.d(d.this)) {
                        d.startSync();
                        AppMethodBeat.o(101632);
                        return;
                    }
                    AppMethodBeat.o(101632);
                }

                public final String toString() {
                    AppMethodBeat.i(101633);
                    String str = super.toString() + "|onSceneEnd";
                    AppMethodBeat.o(101633);
                    return str;
                }
            });
            AppMethodBeat.o(101639);
        }
    }

    @Override // com.tencent.mm.plugin.fav.a.z
    public final void run() {
        AppMethodBeat.i(101640);
        com.tencent.mm.kernel.g.aAk().postToWorker(new Runnable() {
            /* class com.tencent.mm.plugin.fav.b.e.d.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(101634);
                long currentTimeMillis = System.currentTimeMillis() - d.this.dAG;
                if (d.this.running) {
                    if (currentTimeMillis < Util.MILLSECONDS_OF_MINUTE) {
                        AppMethodBeat.o(101634);
                        return;
                    }
                    Log.e("MicroMsg.Fav.FavModService", "klem ERR: Try Run service runningFlag:" + d.this.running + " timeWait:" + currentTimeMillis + ">=MAX_TIME_WAIT sending:" + d.this.running);
                }
                d.this.dAE = false;
                d.this.running = true;
                d.this.dAF = 3;
                d.this.dAJ.startTimer(10);
                AppMethodBeat.o(101634);
            }

            public final String toString() {
                AppMethodBeat.i(101635);
                String str = super.toString() + "|run";
                AppMethodBeat.o(101635);
                return str;
            }
        });
        AppMethodBeat.o(101640);
    }

    public final void aax() {
        AppMethodBeat.i(101641);
        this.dAA.clear();
        dAC.clear();
        this.running = false;
        this.dAE = false;
        tcr.clear();
        AppMethodBeat.o(101641);
    }

    public static void startSync() {
        AppMethodBeat.i(101642);
        com.tencent.mm.kernel.g.azz().a(new ak(), 0);
        AppMethodBeat.o(101642);
    }

    private static void a(long j2, LinkedList<cps> linkedList, LinkedList<cpv> linkedList2) {
        aml a2;
        AppMethodBeat.i(101643);
        cps cps = new cps();
        cps.MvI = 4;
        cps.MvJ = 0;
        linkedList.add(cps);
        List<c> DU = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().DU(j2);
        Log.i("MicroMsg.Fav.FavModService", "setModAfterClientUpload %d modcdnlistsize %d", Long.valueOf(j2), Integer.valueOf(DU.size()));
        for (c cVar : DU) {
            boolean arJ = b.arJ(cVar.field_dataId);
            if (Util.isNullOrNil(cVar.field_cdnUrl) || arJ) {
                Log.e("MicroMsg.Fav.FavModService", "setModAfterClientUpload cdnUrl:%s, isThumb:%b,  favLocalId:%d", cVar.field_cdnUrl, Boolean.valueOf(arJ), Long.valueOf(j2));
            } else {
                cpv cpv = new cpv();
                cpv.xMo = "dataitem." + cVar.field_dataId + ".cdn_dataurl";
                cpv.Cyk = cVar.field_cdnUrl;
                linkedList2.add(cpv);
                cpv cpv2 = new cpv();
                cpv2.xMo = "dataitem." + cVar.field_dataId + ".cdn_datakey";
                cpv2.Cyk = cVar.field_cdnKey;
                linkedList2.add(cpv2);
                cpv cpv3 = new cpv();
                cpv3.xMo = "dataitem." + cVar.field_dataId;
                cpv3.MvO = "datastatus";
                cpv3.Cyk = AppEventsConstants.EVENT_PARAM_VALUE_NO;
                linkedList2.add(cpv3);
                g DY = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(cVar.field_favLocalId);
                if (DY != null) {
                    if ((DY.field_type == 4) && (a2 = b.a(DY, cVar.field_dataId)) != null) {
                        cpv cpv4 = new cpv();
                        cpv4.xMo = "dataitem." + cVar.field_dataId + ".stream_videoid";
                        cpv4.Cyk = a2.LvX;
                        linkedList2.add(cpv4);
                    }
                }
            }
        }
        AppMethodBeat.o(101643);
    }

    static /* synthetic */ void B(g gVar) {
        AppMethodBeat.i(101644);
        ane ane = new ane();
        StringBuffer stringBuffer = new StringBuffer();
        ane.KGZ = gVar.field_id;
        stringBuffer.append("favid:" + gVar.field_id);
        ane.Lye = new LinkedList<>();
        Iterator<aml> it = gVar.field_favProto.ppH.iterator();
        while (it.hasNext()) {
            aml next = it.next();
            if (next.Lwz != 0) {
                aoc aoc = new aoc();
                if (next.Lwz > 0) {
                    aoc.LiU = next.dLl;
                    aoc.Lja = 0;
                    aoc.oTW = next.Lwz;
                } else {
                    aoc.LiU = next.dLl;
                    aoc.Lja = 1;
                    aoc.oTW = -next.Lwz;
                }
                stringBuffer.append(" fileId:" + aoc.LiU + " IsThumb:" + aoc.Lja + " status:" + aoc.oTW);
                ane.Lye.add(aoc);
                next.ajg(0);
            }
        }
        Log.i("MicroMsg.Fav.FavModService", "checkFavItem %s", stringBuffer.toString());
        if (ane.Lye.size() > 0) {
            ((af) com.tencent.mm.kernel.g.ah(af.class)).checkFavItem(ane);
        }
        AppMethodBeat.o(101644);
    }

    static /* synthetic */ boolean d(d dVar) {
        g poll;
        List<g> cUU;
        AppMethodBeat.i(101645);
        dVar.dAG = System.currentTimeMillis();
        if (!dVar.dAE && dVar.dAA.size() == 0 && (cUU = ((af) com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().cUU()) != null && cUU.size() != 0) {
            for (g gVar : cUU) {
                if (dAC.containsKey(Integer.valueOf(gVar.field_id))) {
                    Log.i("MicroMsg.Fav.FavModService", "File is Already running:" + gVar.field_id);
                } else {
                    if (!tcr.containsKey(Integer.valueOf(gVar.field_id))) {
                        tcr.put(Integer.valueOf(gVar.field_id), 3);
                    }
                    dVar.dAA.add(gVar);
                    dAC.put(Integer.valueOf(gVar.field_id), null);
                }
            }
            Log.i("MicroMsg.Fav.FavModService", "klem GetNeedRun procing:" + dAC.size() + ",send:" + dVar.dAA.size() + "]");
            dVar.dAA.size();
        }
        if (!dVar.dAE && dVar.dAA.size() <= 0) {
            dVar.aax();
            Log.i("MicroMsg.Fav.FavModService", "klem No Data Any More , Stop Service");
        } else if (!dVar.dAE && dVar.dAA.size() > 0 && (poll = dVar.dAA.poll()) != null && poll.field_id > 0) {
            dVar.dAE = true;
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            if (poll.cUD()) {
                Log.i("MicroMsg.Fav.FavModService", "Resend Item %d", Long.valueOf(poll.field_localId));
                com.tencent.mm.kernel.g.azz().a(new am(poll.field_id, linkedList, linkedList2, g.t(poll), (byte) 0), 0);
            } else if (poll.field_type != 18) {
                a(poll.field_localId, linkedList, linkedList2);
                com.tencent.mm.kernel.g.azz().a(new am(poll.field_id, linkedList, linkedList2), 0);
            } else {
                cps cps = new cps();
                cps.MvI = 1;
                cps.MvJ = (int) Util.nowSecond();
                linkedList.add(cps);
                com.tencent.mm.kernel.g.azz().a(new am(poll.field_id, linkedList, linkedList2, g.t(poll)), 0);
            }
            AppMethodBeat.o(101645);
            return true;
        }
        AppMethodBeat.o(101645);
        return false;
    }
}
