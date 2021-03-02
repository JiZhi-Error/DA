package com.tencent.mm.plugin.finder.report;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.arc;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001dB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012J\u0006\u0010\u0014\u001a\u00020\u0015J\u0015\u0010\u0016\u001a\u00020\u00152\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0017J\u0015\u0010\u0018\u001a\u00020\u00152\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0017J\u0015\u0010\u0019\u001a\u00020\u00152\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\u00152\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0017J\u0015\u0010\u001b\u001a\u00020\u00152\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0017J\u0015\u0010\u001c\u001a\u00020\u00152\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R2\u0010\u0007\u001a&\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t \n*\u0012\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t\u0018\u00010\u000b0\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\t0\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/FinderHotspotChangeReporter;", "", "()V", "TAG", "", "isChangeTab", "", "reportedData", "", "Lcom/tencent/mm/plugin/finder/report/FinderHotspotChangeReporter$RecordData;", "kotlin.jvm.PlatformType", "", "videoDataMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "getData", "feedId", "getStatsReportFluencyInfo", "", "Lcom/tencent/mm/protocal/protobuf/FinderFluencyInfo;", "notifyChangeTab", "", "notifyDecodeStart", "(Ljava/lang/Long;)V", "notifyFirstVideoFrameRendered", "notifyVideoDownload", "notifyVideoFirstFrame", "notifyVideoPause", "notifyVideoPlay", "RecordData", "plugin-finder_release"})
public final class f {
    public static final ConcurrentHashMap<Long, a> vdY = new ConcurrentHashMap<>();
    public static final Set<a> vdZ = Collections.synchronizedSet(new HashSet());
    private static boolean vea;
    public static final f veb = new f();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0014\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0012\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0015\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\f\"\u0004\b\u0017\u0010\u000eR\u001a\u0010\u0018\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\f\"\u0004\b\u001a\u0010\u000eR\u001a\u0010\u001b\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000e¨\u0006\u001e"}, hxF = {"Lcom/tencent/mm/plugin/finder/report/FinderHotspotChangeReporter$RecordData;", "", "()V", "changeHotpotType", "", "getChangeHotpotType", "()I", "setChangeHotpotType", "(I)V", "firstVideoFrameRendered", "", "getFirstVideoFrameRendered", "()J", "setFirstVideoFrameRendered", "(J)V", "videoDecodeStart", "getVideoDecodeStart", "setVideoDecodeStart", "videoDownloadStart", "getVideoDownloadStart", "setVideoDownloadStart", "videoFirstFrame", "getVideoFirstFrame", "setVideoFirstFrame", "videoPause", "getVideoPause", "setVideoPause", "videoPlay", "getVideoPlay", "setVideoPlay", "plugin-finder_release"})
    public static final class a {
        public long vec;
        public long ved;
        public long vee;
        public long vef;
        public long veg;
        public long veh;
        int vei = 2;
    }

    static {
        AppMethodBeat.i(250552);
        AppMethodBeat.o(250552);
    }

    private f() {
    }

    public static void dnO() {
        vea = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0026, code lost:
        if (r0 == null) goto L_0x0028;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void h(java.lang.Long r8) {
        /*
            r7 = this;
            r6 = 250548(0x3d2b4, float:3.51093E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r6)
            if (r8 == 0) goto L_0x0038
            r8.longValue()
            long r0 = r8.longValue()
            com.tencent.mm.plugin.finder.report.f$a r0 = EZ(r0)
            long r2 = r0.vee
            r4 = 0
            int r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r1 != 0) goto L_0x003c
            r1 = 1
        L_0x001c:
            if (r1 == 0) goto L_0x003e
        L_0x001e:
            if (r0 == 0) goto L_0x0028
            long r2 = com.tencent.mm.model.cl.aWA()
            r0.vee = r2
            if (r0 != 0) goto L_0x0034
        L_0x0028:
            com.tencent.mm.plugin.finder.report.f r7 = (com.tencent.mm.plugin.finder.report.f) r7
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, com.tencent.mm.plugin.finder.report.f$a> r0 = com.tencent.mm.plugin.finder.report.f.vdY
            r0.remove(r8)
            r7.h(r8)
            kotlin.x r0 = kotlin.x.SXb
        L_0x0034:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
        L_0x0037:
            return
        L_0x0038:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r6)
            goto L_0x0037
        L_0x003c:
            r1 = 0
            goto L_0x001c
        L_0x003e:
            r0 = 0
            goto L_0x001e
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.report.f.h(java.lang.Long):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0030, code lost:
        if (r1 == null) goto L_0x0032;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i(java.lang.Long r10) {
        /*
            r9 = this;
            r0 = 1
            r3 = 0
            r8 = 250549(0x3d2b5, float:3.51094E-40)
            com.tencent.matrix.trace.core.AppMethodBeat.i(r8)
            if (r10 == 0) goto L_0x0042
            r10.longValue()
            long r4 = r10.longValue()
            com.tencent.mm.plugin.finder.report.f$a r1 = EZ(r4)
            long r4 = r1.vec
            r6 = 0
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 != 0) goto L_0x0046
            r2 = r0
        L_0x001e:
            if (r2 == 0) goto L_0x0048
        L_0x0020:
            if (r1 == 0) goto L_0x0032
            long r4 = com.tencent.mm.model.cl.aWA()
            r1.vec = r4
            boolean r2 = com.tencent.mm.plugin.finder.report.f.vea
            if (r2 == 0) goto L_0x004a
        L_0x002c:
            r1.vei = r0
            com.tencent.mm.plugin.finder.report.f.vea = r3
            if (r1 != 0) goto L_0x003e
        L_0x0032:
            com.tencent.mm.plugin.finder.report.f r9 = (com.tencent.mm.plugin.finder.report.f) r9
            java.util.concurrent.ConcurrentHashMap<java.lang.Long, com.tencent.mm.plugin.finder.report.f$a> r0 = com.tencent.mm.plugin.finder.report.f.vdY
            r0.remove(r10)
            r9.i(r10)
            kotlin.x r0 = kotlin.x.SXb
        L_0x003e:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r8)
        L_0x0041:
            return
        L_0x0042:
            com.tencent.matrix.trace.core.AppMethodBeat.o(r8)
            goto L_0x0041
        L_0x0046:
            r2 = r3
            goto L_0x001e
        L_0x0048:
            r1 = 0
            goto L_0x0020
        L_0x004a:
            r0 = 2
            goto L_0x002c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.report.f.i(java.lang.Long):void");
    }

    public static a EZ(long j2) {
        AppMethodBeat.i(250550);
        a aVar = vdY.get(Long.valueOf(j2));
        if (aVar == null) {
            a aVar2 = new a();
            vdY.put(Long.valueOf(j2), aVar2);
            aVar = aVar2;
        }
        AppMethodBeat.o(250550);
        return aVar;
    }

    public static List<arc> dnP() {
        long j2;
        long j3;
        long j4;
        AppMethodBeat.i(250551);
        LinkedList linkedList = new LinkedList();
        Set<a> set = vdZ;
        p.g(set, "reportedData");
        Set<a> set2 = set;
        synchronized (set2) {
            try {
                for (T t : set2) {
                    arc arc = new arc();
                    arc.scene = 1;
                    arc.LCO = t.vei;
                    if (t.vef > 0) {
                        j2 = t.vef;
                    } else if (t.ved > 0) {
                        j2 = t.ved;
                    } else {
                        j2 = 0;
                    }
                    arc.LCS = (j2 <= 0 || t.vee <= 0) ? 0 : (int) (j2 - t.vee);
                    if (t.vef > 0) {
                        j3 = t.vef;
                    } else if (t.vec > 0) {
                        j3 = t.vec;
                    } else {
                        j3 = 0;
                    }
                    if (t.veg > 0) {
                        j4 = t.veg;
                    } else if (t.ved > 0) {
                        j4 = t.ved;
                    } else {
                        j4 = 0;
                    }
                    arc.LCT = (j3 <= 0 || j4 <= 0) ? 0 : (int) (j4 - j3);
                    linkedList.add(arc);
                    Log.i("FinderHotspotChangeReporter", "finderFluencyInfo: scene = " + arc.scene + ", hot = " + arc.LCO + ", downloadToDecodeMs = " + arc.LCS + ',' + " decodeToFirstFrameMs = " + arc.LCT);
                }
                x xVar = x.SXb;
            } catch (Throwable th) {
                AppMethodBeat.o(250551);
                throw th;
            }
        }
        vdZ.clear();
        LinkedList linkedList2 = linkedList;
        AppMethodBeat.o(250551);
        return linkedList2;
    }
}
