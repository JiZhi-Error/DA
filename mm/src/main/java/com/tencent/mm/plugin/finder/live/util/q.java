package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.b.c;
import com.tencent.mm.sdk.platformtools.MAlarmHandler;
import java.util.ArrayList;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016J\u0006\u0010\u0017\u001a\u00020\u0012J\u0010\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u0010\u0010\u001b\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/util/LiveStatisticsUtil;", "", "()V", "TAG", "", "cdnStatistics", "Lcom/tencent/mm/plugin/finder/live/util/CDNStatistics;", "getCdnStatistics", "()Lcom/tencent/mm/plugin/finder/live/util/CDNStatistics;", "setCdnStatistics", "(Lcom/tencent/mm/plugin/finder/live/util/CDNStatistics;)V", "trtcStatistics", "Lcom/tencent/mm/plugin/finder/live/util/TrtcStatistics;", "getTrtcStatistics", "()Lcom/tencent/mm/plugin/finder/live/util/TrtcStatistics;", "setTrtcStatistics", "(Lcom/tencent/mm/plugin/finder/live/util/TrtcStatistics;)V", "doStatistic", "", "value", "", "cache", "Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "reset", "statisticCDN", "qosInfo", "Lcom/tencent/mm/live/core/core/model/LiveQosInfo;", "statisticTRTC", "plugin-finder_release"})
public final class q {
    private static final String TAG = TAG;
    private static y uxh;
    private static h uxi;
    public static final q uxj = new q();

    static {
        AppMethodBeat.i(247295);
        AppMethodBeat.o(247295);
    }

    private q() {
    }

    public static y din() {
        return uxh;
    }

    public static h dio() {
        return uxi;
    }

    public static void a(c cVar) {
        w wVar;
        w wVar2;
        w wVar3;
        w wVar4;
        w wVar5;
        w wVar6;
        w wVar7;
        w wVar8;
        w wVar9;
        w wVar10;
        w wVar11 = null;
        AppMethodBeat.i(247292);
        if (cVar != null) {
            if (uxh == null) {
                uxh = new y();
            }
            int i2 = (int) cVar.hze;
            y yVar = uxh;
            if (yVar != null) {
                wVar = yVar.uwg;
            } else {
                wVar = null;
            }
            a(i2, wVar);
            int i3 = cVar.hza;
            y yVar2 = uxh;
            if (yVar2 != null) {
                wVar2 = yVar2.uxp;
            } else {
                wVar2 = null;
            }
            a(i3, wVar2);
            int i4 = cVar.upLoss;
            y yVar3 = uxh;
            if (yVar3 != null) {
                wVar3 = yVar3.uxq;
            } else {
                wVar3 = null;
            }
            a(i4, wVar3);
            int i5 = cVar.downLoss;
            y yVar4 = uxh;
            if (yVar4 != null) {
                wVar4 = yVar4.uxr;
            } else {
                wVar4 = null;
            }
            a(i5, wVar4);
            int i6 = (int) (cVar.sendBytes / 1000);
            y yVar5 = uxh;
            if (yVar5 != null) {
                wVar5 = yVar5.uxs;
            } else {
                wVar5 = null;
            }
            a(i6, wVar5);
            int i7 = (int) (cVar.receiveBytes / 1000);
            y yVar6 = uxh;
            if (yVar6 != null) {
                wVar6 = yVar6.uxt;
            } else {
                wVar6 = null;
            }
            a(i7, wVar6);
            int i8 = cVar.width;
            y yVar7 = uxh;
            if (yVar7 != null) {
                wVar7 = yVar7.uwk;
            } else {
                wVar7 = null;
            }
            a(i8, wVar7);
            int i9 = cVar.height;
            y yVar8 = uxh;
            if (yVar8 != null) {
                wVar8 = yVar8.uwl;
            } else {
                wVar8 = null;
            }
            a(i9, wVar8);
            int i10 = cVar.hyI;
            y yVar9 = uxh;
            if (yVar9 != null) {
                wVar9 = yVar9.uwj;
            } else {
                wVar9 = null;
            }
            a(i10, wVar9);
            int i11 = cVar.hyK;
            y yVar10 = uxh;
            if (yVar10 != null) {
                wVar10 = yVar10.uwh;
            } else {
                wVar10 = null;
            }
            a(i11, wVar10);
            int i12 = cVar.hyL;
            y yVar11 = uxh;
            if (yVar11 != null) {
                wVar11 = yVar11.uwi;
            }
            a(i12, wVar11);
            AppMethodBeat.o(247292);
            return;
        }
        AppMethodBeat.o(247292);
    }

    public static void b(c cVar) {
        w wVar;
        w wVar2;
        w wVar3;
        w wVar4;
        w wVar5;
        w wVar6;
        w wVar7;
        w wVar8;
        w wVar9;
        w wVar10;
        w wVar11;
        w wVar12 = null;
        AppMethodBeat.i(247293);
        if (cVar != null) {
            if (uxi == null) {
                uxi = new h();
            }
            int i2 = (int) cVar.hze;
            h hVar = uxi;
            if (hVar != null) {
                wVar = hVar.uwg;
            } else {
                wVar = null;
            }
            a(i2, wVar);
            int i3 = cVar.width;
            h hVar2 = uxi;
            if (hVar2 != null) {
                wVar2 = hVar2.uwk;
            } else {
                wVar2 = null;
            }
            a(i3, wVar2);
            int i4 = cVar.height;
            h hVar3 = uxi;
            if (hVar3 != null) {
                wVar3 = hVar3.uwl;
            } else {
                wVar3 = null;
            }
            a(i4, wVar3);
            int i5 = cVar.hyI;
            h hVar4 = uxi;
            if (hVar4 != null) {
                wVar4 = hVar4.uwj;
            } else {
                wVar4 = null;
            }
            a(i5, wVar4);
            int i6 = cVar.hyK;
            h hVar5 = uxi;
            if (hVar5 != null) {
                wVar5 = hVar5.uwh;
            } else {
                wVar5 = null;
            }
            a(i6, wVar5);
            int i7 = cVar.hyL;
            h hVar6 = uxi;
            if (hVar6 != null) {
                wVar6 = hVar6.uwi;
            } else {
                wVar6 = null;
            }
            a(i7, wVar6);
            int i8 = cVar.hyM;
            h hVar7 = uxi;
            if (hVar7 != null) {
                wVar7 = hVar7.uwm;
            } else {
                wVar7 = null;
            }
            a(i8, wVar7);
            int i9 = cVar.hyT;
            h hVar8 = uxi;
            if (hVar8 != null) {
                wVar8 = hVar8.uwn;
            } else {
                wVar8 = null;
            }
            a(i9, wVar8);
            int i10 = cVar.hyR;
            h hVar9 = uxi;
            if (hVar9 != null) {
                wVar9 = hVar9.uwo;
            } else {
                wVar9 = null;
            }
            a(i10, wVar9);
            int i11 = cVar.hyQ;
            h hVar10 = uxi;
            if (hVar10 != null) {
                wVar10 = hVar10.uwp;
            } else {
                wVar10 = null;
            }
            a(i11, wVar10);
            int i12 = cVar.hyN;
            h hVar11 = uxi;
            if (hVar11 != null) {
                wVar11 = hVar11.uwq;
            } else {
                wVar11 = null;
            }
            a(i12, wVar11);
            int i13 = cVar.hyP;
            h hVar12 = uxi;
            if (hVar12 != null) {
                wVar12 = hVar12.uwr;
            }
            a(i13, wVar12);
        }
        AppMethodBeat.o(247293);
    }

    private static void a(int i2, w wVar) {
        AppMethodBeat.i(247294);
        if (wVar == null) {
            AppMethodBeat.o(247294);
            return;
        }
        wVar.uxm.value = i2;
        if (!wVar.tuG) {
            AppMethodBeat.o(247294);
            return;
        }
        e eVar = wVar.uxn;
        if (eVar != null) {
            if (eVar.hjI >= Integer.MAX_VALUE || eVar.uvZ + ((long) i2) >= MAlarmHandler.NEXT_FIRE_INTERVAL) {
                wVar.tuG = false;
            } else {
                eVar.hjI++;
                eVar.uvZ += (long) i2;
                eVar.uwa = eVar.uvZ / ((long) eVar.hjI);
            }
        }
        ArrayList<i> arrayList = wVar.uxo;
        if (arrayList != null) {
            for (T t : arrayList) {
                if (i2 < t.value) {
                    if (t.hjI < Integer.MAX_VALUE) {
                        t.hjI++;
                        AppMethodBeat.o(247294);
                        return;
                    }
                    wVar.tuG = false;
                    AppMethodBeat.o(247294);
                    return;
                }
            }
            AppMethodBeat.o(247294);
            return;
        }
        AppMethodBeat.o(247294);
    }

    public static void reset() {
        uxh = null;
        uxi = null;
    }
}
