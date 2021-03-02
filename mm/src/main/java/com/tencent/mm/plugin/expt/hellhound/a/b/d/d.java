package com.tencent.mm.plugin.expt.hellhound.a.b.d;

import com.google.android.gms.measurement.AppMeasurement;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c;
import com.tencent.mm.plugin.expt.hellhound.a.b.c.b;
import com.tencent.mm.plugin.expt.hellhound.a.f.a.c;
import com.tencent.mm.plugin.expt.hellhound.a.f.b.b;
import com.tencent.mm.protocal.protobuf.cym;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 (2\u00020\u0001:\u0001(B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bH\u0002J \u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tJ\"\u0010\u0012\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0002J\"\u0010\u0013\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0002J \u0010\u0014\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tJ\"\u0010\u0015\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0002J\"\u0010\u0016\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\tH\u0002J\u001a\u0010\u0017\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0011\u001a\u00020\tH\u0002J*\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0002J*\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\u001e\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0011\u001a\u00020\tJ*\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010\u0004H\u0002J*\u0010!\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t2\b\u0010 \u001a\u0004\u0018\u00010\u0004H\u0002J\u0018\u0010\"\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0011\u001a\u00020\tJ\u0018\u0010#\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0011\u001a\u00020\tJ\u0018\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0010H\u0002R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000¨\u0006)"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderShareStatistics;", "", "()V", "mCurPageNameStaticsing", "", "mCurPageNameStaticsingOnCreate", "mStayTime", "Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/report/StayTimeStatistics;", "getBackgroundTime", "", "timePairLsit", "Ljava/util/LinkedList;", "on7Event", "", "pageName", "hashCode", "", AppMeasurement.Param.TIMESTAMP, "on7EventV1", "on7EventV2", "on8Event", "on8EventV1", "on8EventV2", "onActivityCreate", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/app/Activity;", "onActivityCreateV1", "sPageName", "extraInfo", "onActivityCreateV2", "onFinishActivity", "onFinishActivityV1", "enterSourceInfo", "onFinishActivityV2", "onPagePaused", "onPageResumed", "toStayTimeStatistics", "statistics", "Lcom/tencent/mm/protocal/protobuf/PageStatistics;", "reportType", "Companion", "plugin-expt_release"})
public final class d {
    public static final a sHc = new a((byte) 0);
    public b sGZ;
    public String sHa;
    public String sHb;

    static {
        AppMethodBeat.i(221057);
        AppMethodBeat.o(221057);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/FinderShareStatistics$Companion;", "", "()V", "TAG", "", "plugin-expt_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public static void a(String str, int i2, long j2, String str2) {
        AppMethodBeat.i(221051);
        Log.i("HABBYGE-MALI.FinderShareStatistics", "onActivityCreateV1, sPage=" + str + ", hashCode=" + i2);
        if (f.sHi.dk(str, i2) == null) {
            cym cym = new cym();
            cym.sessionId = c.cPU().cMD();
            cym.dMl = str;
            cym.aHK = i2;
            cym.sGC = j2;
            b.a aVar = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.sIy;
            cym.sGF = b.a.cPQ();
            cym.dYn = c.b.INOUT_WITHOUT_78EVENT.value;
            cym.extraInfo = str2;
            f.sHi.a(cym);
            Log.i("HABBYGE-MALI.FinderShareStatistics", "onActivityCreateV1, YES, sPage=" + str + ", hashCode=" + i2);
        }
        AppMethodBeat.o(221051);
    }

    public static void o(String str, int i2, long j2) {
        AppMethodBeat.i(221052);
        Log.i("HABBYGE-MALI.FinderShareStatistics", "on7EventV1: pageName=" + str + ", hashCode=" + i2);
        cym cPo = f.sHi.cPo();
        if (cPo == null) {
            AppMethodBeat.o(221052);
            return;
        }
        LinkedList<Long> linkedList = cPo.MDv;
        p.g(linkedList, "statistics.stayTimeOnBackground");
        if (!linkedList.isEmpty()) {
            if (cPo.MDv.size() % 2 != 0) {
                cPo.MDv.add(Long.valueOf(j2));
            } else {
                cPo.MDv.removeLast();
                cPo.MDv.add(Long.valueOf(j2));
            }
        }
        f.sHi.b(cPo);
        AppMethodBeat.o(221052);
    }

    public static void p(String str, int i2, long j2) {
        AppMethodBeat.i(221053);
        Log.i("HABBYGE-MALI.FinderShareStatistics", "on8EventV1: pageName=" + str + ", hashCode=" + i2);
        cym cPo = f.sHi.cPo();
        if (cPo == null) {
            AppMethodBeat.o(221053);
            return;
        }
        if (cPo.MDv.isEmpty()) {
            cPo.MDv.add(Long.valueOf(j2));
        } else if (cPo.MDv.size() % 2 == 0) {
            cPo.MDv.add(Long.valueOf(j2));
        } else {
            cPo.MDv.removeLast();
            cPo.MDv.add(Long.valueOf(j2));
        }
        f.sHi.b(cPo);
        AppMethodBeat.o(221053);
    }

    public static void q(String str, int i2, long j2) {
        AppMethodBeat.i(221054);
        Log.i("HABBYGE-MALI.FinderShareStatistics", "on7EventV2: pageName=" + str + ", hashCode=" + i2);
        cym cPq = f.sHi.cPq();
        if (cPq == null) {
            AppMethodBeat.o(221054);
        } else if (com.tencent.mm.plugin.expt.hellhound.core.b.aoz(str)) {
            f.sHi.cPr();
            AppMethodBeat.o(221054);
        } else {
            if (cPq.dYn == 8) {
                cPq.sGC = j2;
                cPq.sGD = 0;
                cPq.sGB = 0;
                cPq.dYn = c.b.INOUT.value;
                f.sHi.d(cPq);
                Log.i("HABBYGE-MALI.FinderShareStatistics", "on7EventV2: " + cPq.dMl + ", " + cPq.aHK);
            }
            AppMethodBeat.o(221054);
        }
    }

    public static com.tencent.mm.plugin.expt.hellhound.a.b.c.b a(cym cym, int i2) {
        boolean z = false;
        AppMethodBeat.i(221055);
        com.tencent.mm.plugin.expt.hellhound.a.b.c.b bVar = new com.tencent.mm.plugin.expt.hellhound.a.b.c.b();
        bVar.sessionId = cym.sessionId;
        bVar.dMl = cym.dMl;
        if (p.j(bVar.dMl, "FinderTopicFeedUI")) {
            c.a aVar = com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sFa;
            if (com.tencent.mm.plugin.expt.hellhound.a.b.b.c.sEX == c.d.Poi.value) {
                z = true;
            }
            bVar.sGG = z;
        } else {
            bVar.sGG = false;
        }
        bVar.sGB = cym.sGB;
        bVar.sGC = cym.sGC;
        bVar.sGD = cym.sGD;
        bVar.sGE = cym.sGE;
        bVar.sGF = cym.sGF;
        bVar.dYn = i2;
        bVar.extraInfo = cym.extraInfo;
        bVar.sGH = cym.sGH;
        AppMethodBeat.o(221055);
        return bVar;
    }

    public static long ab(LinkedList<Long> linkedList) {
        long j2 = 0;
        AppMethodBeat.i(221056);
        if (linkedList.isEmpty()) {
            AppMethodBeat.o(221056);
        } else {
            if (linkedList.size() % 2 != 0) {
                linkedList.removeLast();
            }
            kotlin.k.d a2 = j.a((kotlin.k.d) j.mY(0, linkedList.size()), 2);
            int i2 = a2.SYU;
            int i3 = a2.SYV;
            int i4 = a2.lCq;
            if (i4 < 0 ? i2 >= i3 : i2 <= i3) {
                while (true) {
                    long longValue = linkedList.get(i2 + 1).longValue();
                    Long l = linkedList.get(i2);
                    p.g(l, "timePairLsit[i]");
                    j2 += longValue - l.longValue();
                    if (i2 == i3) {
                        break;
                    }
                    i2 += i4;
                }
            }
            AppMethodBeat.o(221056);
        }
        return j2;
    }
}
