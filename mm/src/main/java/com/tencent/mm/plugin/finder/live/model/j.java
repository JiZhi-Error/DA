package com.tencent.mm.plugin.finder.live.model;

import android.os.Build;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.fn;
import com.tencent.mm.live.core.core.b.c;
import com.tencent.mm.live.core.core.e;
import com.tencent.mm.live.core.core.f;
import com.tencent.mm.protocal.protobuf.avk;
import com.tencent.mm.protocal.protobuf.awx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ\u0017\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u0012J\u0006\u0010\u0013\u001a\u00020\fJ\u0006\u0010\u0014\u001a\u00020\fJ\u0006\u0010\u0015\u001a\u00020\fJ\u0006\u0010\u0016\u001a\u00020\fJ\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/model/FinderLiveQosReporter;", "", "()V", "TAG", "", "lapCount", "", "lastTimestamp", "", "qosKvTimer", "Lcom/tencent/mm/sdk/platformtools/MTimerHandler;", "cleanClientStatus", "", "doLivePlayReport", "liveStarted", "", "genClientStatus", "Lcom/tencent/mm/protocal/protobuf/FinderLiveClientStatus;", "(Ljava/lang/Long;)Lcom/tencent/mm/protocal/protobuf/FinderLiveClientStatus;", "lagIncrease", "reset", "startQosKvReport", "stopQosKvReport", "toFinderLiveQosInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveQoSInfo;", "qosInfo", "Lcom/tencent/mm/live/core/core/model/LiveQosInfo;", "plugin-finder_release"})
public final class j {
    private static final String TAG = TAG;
    private static long qzL;
    private static int ujf;
    private static final MTimerHandler ujg = new MTimerHandler("FinderLiveReporterTimer", (MTimerHandler.CallBack) a.uji, true);
    public static final j ujh = new j();

    static {
        AppMethodBeat.i(246174);
        AppMethodBeat.o(246174);
    }

    private j() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "onTimerExpired"})
    static final class a implements MTimerHandler.CallBack {
        public static final a uji = new a();

        static {
            AppMethodBeat.i(246167);
            AppMethodBeat.o(246167);
        }

        a() {
        }

        @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
        public final boolean onTimerExpired() {
            AppMethodBeat.i(246166);
            j jVar = j.ujh;
            j.dfN();
            j jVar2 = j.ujh;
            j.dfO();
            AppMethodBeat.o(246166);
            return true;
        }
    }

    public static void dfL() {
        AppMethodBeat.i(246168);
        qzL = System.currentTimeMillis();
        ujg.stopTimer();
        ujg.startTimer(Util.MILLSECONDS_OF_MINUTE);
        AppMethodBeat.o(246168);
    }

    public static void dfM() {
        AppMethodBeat.i(246169);
        ujg.stopTimer();
        AppMethodBeat.o(246169);
    }

    public static /* synthetic */ void dfN() {
        AppMethodBeat.i(246171);
        nm(true);
        AppMethodBeat.o(246171);
    }

    public static void nm(boolean z) {
        long j2;
        long j3;
        AppMethodBeat.i(246170);
        long currentTimeMillis = System.currentTimeMillis() - qzL;
        LinkedList<c> aDk = f.hys.aDk();
        qzL = System.currentTimeMillis();
        Log.i(TAG, "doLivePlayReport qosInfoQueue.size:" + aDk.size() + " liveStarted:" + z);
        if (!Util.isNullOrNil(aDk)) {
            fn fnVar = new fn();
            fnVar.oK(currentTimeMillis / 1000);
            fnVar.agy();
            for (T t : aDk) {
                if (Util.isNullOrNil(fnVar.adj())) {
                    fnVar.su(String.valueOf(t.hyH));
                }
                if (fnVar.getWidth() == 0) {
                    fnVar.oi((long) t.width);
                }
                if (fnVar.getHeight() == 0) {
                    fnVar.oj((long) t.height);
                }
                if (fnVar.agl() == 0) {
                    fnVar.ou((long) t.hyS);
                }
                if (fnVar.agp() == 0) {
                    fnVar.oz((long) t.hyX);
                }
                if (fnVar.agt() == 0) {
                    fnVar.oD((long) t.hzb);
                }
                if (Util.isNullOrNil(fnVar.agu())) {
                    String str = t.hzc;
                    if (str == null) {
                        str = "";
                    }
                    fnVar.sv(str);
                }
                if (fnVar.agv() == 0) {
                    fnVar.oE((long) t.hzd);
                }
                if (fnVar.agz() == 0) {
                    int i2 = t.role;
                    e.i iVar = e.i.hyd;
                    if (i2 == e.i.aCX()) {
                        j3 = 1;
                    } else {
                        int i3 = t.role;
                        e.i iVar2 = e.i.hyd;
                        j3 = i3 == e.i.aCW() ? 2 : 0;
                    }
                    fnVar.oN(j3);
                }
                fnVar.oM((long) t.netType);
                int i4 = t.mode;
                e.a aVar = e.a.hxc;
                if (i4 == e.a.aCf()) {
                    j2 = 1;
                } else {
                    int i5 = t.mode;
                    e.a aVar2 = e.a.hxc;
                    j2 = i5 == e.a.aCf() ? 2 : 0;
                }
                fnVar.oL(j2);
                fnVar.ok(fnVar.agb() + ((long) t.hyI));
                fnVar.ol(fnVar.agc() + ((long) t.hyJ));
                fnVar.om(fnVar.agd() + ((long) t.hyK));
                fnVar.on(fnVar.age() + ((long) t.hyL));
                fnVar.oo(fnVar.agf() + ((long) t.hyM));
                fnVar.or(fnVar.agi() + ((long) t.hyP));
                fnVar.ow(fnVar.agn() + ((long) t.hyU));
                fnVar.oA(fnVar.agq() + ((long) t.hyY));
                fnVar.oB(fnVar.agr() + ((long) t.hyZ));
                fnVar.oC(fnVar.ags() + ((long) t.hza));
                fnVar.sw(fnVar.agw() + ((long) t.hze));
                fnVar.sx(fnVar.agx() + ((long) t.hzf));
                fnVar.op(fnVar.agg() + ((long) t.hyN));
                fnVar.oq(fnVar.agh() + ((long) t.hyO));
                fnVar.os(fnVar.agj() + ((long) t.hyQ));
                fnVar.ot(fnVar.agk() + ((long) t.hyR));
                fnVar.ox(t.hyV);
                fnVar.oy(fnVar.ago() + t.hyW);
                fnVar.ov(kotlin.k.j.aM(fnVar.agm(), (long) t.hyT));
                fnVar.oG(kotlin.k.j.aM(fnVar.agd(), (long) t.hyK));
                fnVar.oI(kotlin.k.j.aM(fnVar.age(), (long) t.hyL));
                fnVar.oH(kotlin.k.j.aN(fnVar.agd(), (long) t.hyK));
                fnVar.oI(kotlin.k.j.aN(fnVar.age(), (long) t.hyL));
            }
            fnVar.oF((long) ujf);
            fnVar.ok((long) (((float) fnVar.agb()) / ((float) aDk.size())));
            fnVar.ol((long) (((float) fnVar.agc()) / ((float) aDk.size())));
            fnVar.om((long) (((float) fnVar.agd()) / ((float) aDk.size())));
            fnVar.on((long) (((float) fnVar.age()) / ((float) aDk.size())));
            fnVar.oo((long) (((float) fnVar.agf()) / ((float) aDk.size())));
            fnVar.or((long) (((float) fnVar.agi()) / ((float) aDk.size())));
            fnVar.ow((long) (((float) fnVar.agn()) / ((float) aDk.size())));
            fnVar.oA((long) (((float) fnVar.agq()) / ((float) aDk.size())));
            fnVar.oB((long) (((float) fnVar.agr()) / ((float) aDk.size())));
            fnVar.oC((long) (((float) fnVar.ags()) / ((float) aDk.size())));
            if (z) {
                fnVar.oJ(0);
            } else {
                fnVar.oJ(1);
            }
            fnVar.bfK();
            ujf = 0;
        }
        AppMethodBeat.o(246170);
    }

    public static void dfO() {
        AppMethodBeat.i(246172);
        Log.i(TAG, "cleanClientStatus");
        f.hys.aDm();
        AppMethodBeat.o(246172);
    }

    public static avk d(Long l) {
        avk avk;
        AppMethodBeat.i(246173);
        LinkedList<awx> linkedList = new LinkedList<>();
        ArrayList arrayList = new ArrayList();
        for (T t : f.hys.aDk()) {
            if (t.timestamps > (l != null ? l.longValue() : 0)) {
                arrayList.add(t);
            }
        }
        ArrayList<c> arrayList2 = arrayList;
        Log.i(TAG, "genClientStatus lastTimestamp:" + l + " liveQosInfoQueue.size:" + arrayList2.size());
        for (c cVar : arrayList2) {
            p.h(cVar, "qosInfo");
            awx awx = new awx();
            awx.hyH = cVar.hyH;
            awx.width = cVar.width;
            awx.height = cVar.height;
            awx.hyI = cVar.hyI;
            awx.hyJ = cVar.hyJ;
            awx.hyK = cVar.hyK;
            awx.hyL = cVar.hyL;
            awx.hyM = cVar.hyM;
            awx.hyN = cVar.hyN;
            awx.hyO = cVar.hyO;
            awx.hyP = cVar.hyP;
            awx.hyQ = cVar.hyQ;
            awx.hyR = cVar.hyR;
            awx.hyS = cVar.hyS;
            awx.hyT = cVar.hyT;
            awx.hyU = cVar.hyU;
            awx.LHA = (int) cVar.hyV;
            awx.LHB = (int) cVar.hyW;
            awx.hyX = cVar.hyX;
            awx.hyY = cVar.hyY;
            awx.hyZ = cVar.hyZ;
            awx.hza = cVar.hza;
            awx.hzb = cVar.hzb;
            awx.hzc = cVar.hzc;
            awx.hzd = cVar.hzd;
            awx.hze = cVar.hze;
            awx.hzf = cVar.hzf;
            linkedList.add(awx);
        }
        if (!Util.isNullOrNil(linkedList)) {
            awx removeLast = linkedList.removeLast();
            Log.i(TAG, "genClientStatus curQosInfo:" + removeLast + " lastLiveQosInfo.size:" + linkedList.size());
            if (removeLast != null) {
                avk avk2 = new avk();
                avk2.Loh = NetStatusUtil.getNetType(MMApplicationContext.getContext());
                avk2.LGb = NetStatusUtil.getNetTypeString(MMApplicationContext.getContext());
                avk2.LGc = CdnLogic.getRecentAverageSpeed(2);
                avk2.LnW = Build.MODEL;
                avk2.LGd = Build.BRAND;
                avk2.LGe = Build.DISPLAY;
                avk2.Lob = Build.VERSION.RELEASE;
                avk2.LGf = removeLast;
                avk2.LGg = linkedList;
                avk = avk2;
                AppMethodBeat.o(246173);
                return avk;
            }
        }
        avk = null;
        AppMethodBeat.o(246173);
        return avk;
    }

    public static void dfP() {
        ujf++;
    }
}
