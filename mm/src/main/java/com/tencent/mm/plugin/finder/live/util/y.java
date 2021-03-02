package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010 \u001a\u00020!J\u0006\u0010\"\u001a\u00020!J\u0006\u0010#\u001a\u00020!R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R!\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00040\bj\b\u0012\u0004\u0012\u00020\u0004`\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0006R\u0011\u0010\u000e\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0006R\u0011\u0010\u0010\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0006R\u0011\u0010\u0012\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0006R\u0011\u0010\u0014\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0006R\u0011\u0010\u0016\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0006R\u0011\u0010\u0018\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0006R\u0011\u0010\u001a\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0006R\u0011\u0010\u001c\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0006R\u0011\u0010\u001e\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0006¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/util/TrtcStatistics;", "", "()V", "audioBitrateStatisticsCache", "Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "getAudioBitrateStatisticsCache", "()Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "cacheList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getCacheList", "()Ljava/util/ArrayList;", "cpuStatisticsCache", "getCpuStatisticsCache", "downlossStatisticsCache", "getDownlossStatisticsCache", "frameRateStatisticsCache", "getFrameRateStatisticsCache", "heightStatisticsCache", "getHeightStatisticsCache", "receiveBytesStatisticsCache", "getReceiveBytesStatisticsCache", "rttStatisticsCache", "getRttStatisticsCache", "sendBytesStatisticsCache", "getSendBytesStatisticsCache", "uplossStatisticsCache", "getUplossStatisticsCache", "videoBitrateStatisticsCache", "getVideoBitrateStatisticsCache", "widthStatisticsCache", "getWidthStatisticsCache", "getAverageStr", "", "getLevelStr", "getRealTimeStr", "plugin-finder_release"})
public final class y {
    private final ArrayList<w> uwf = new ArrayList<>();
    public final w uwg = new c().did();
    public final w uwh = new aa().did();
    public final w uwi = new d().did();
    public final w uwj;
    public final w uwk;
    public final w uwl;
    public final w uxp;
    public final w uxq;
    public final w uxr;
    public final w uxs;
    public final w uxt;

    public y() {
        AppMethodBeat.i(247304);
        u uVar = new u();
        uVar.uvW.add(new i("GoodRtt", 50, 4));
        uVar.uvW.add(new i("NormalRtt", 100, 4));
        uVar.uvW.add(new i("BadRtt", Integer.MAX_VALUE, 4));
        this.uxp = new w(uVar.uxk, uVar.uxl, uVar.uvW);
        z zVar = new z();
        zVar.uvW.add(new i("GoodUploss", 5, 4));
        zVar.uvW.add(new i("NormalUploss", 10, 4));
        zVar.uvW.add(new i("BadUploss", Integer.MAX_VALUE, 4));
        this.uxq = new w(zVar.uxu, zVar.uxv, zVar.uvW);
        l lVar = new l();
        lVar.uvW.add(new i("GoodDownloss", 5, 4));
        lVar.uvW.add(new i("NormalDownloss", 10, 4));
        lVar.uvW.add(new i("BadDownloss", Integer.MAX_VALUE, 4));
        this.uxr = new w(lVar.uwM, lVar.uwN, lVar.uvW);
        v vVar = new v();
        vVar.uvW.add(new i("BadSendBytes", 500, 4));
        vVar.uvW.add(new i("NormalSendBytes", 1800, 4));
        vVar.uvW.add(new i("GoodSendBytes", Integer.MAX_VALUE, 4));
        this.uxs = new w(vVar.uvU, vVar.uvV, vVar.uvW);
        t tVar = new t();
        tVar.uvW.add(new i("BadReceiveBytes", 500, 4));
        tVar.uvW.add(new i("NormalReceiveBytes", 1800, 4));
        tVar.uvW.add(new i("GoodReceiveBytes", Integer.MAX_VALUE, 4));
        this.uxt = new w(tVar.uvU, tVar.uvV, tVar.uvW);
        this.uwj = new m().did();
        this.uwk = new ac().did();
        this.uwl = new o().did();
        this.uwf.add(this.uwg);
        this.uwf.add(this.uwh);
        this.uwf.add(this.uwi);
        this.uwf.add(this.uxp);
        this.uwf.add(this.uxq);
        this.uwf.add(this.uxr);
        this.uwf.add(this.uxs);
        this.uwf.add(this.uxt);
        this.uwf.add(this.uwj);
        AppMethodBeat.o(247304);
    }

    public final String dif() {
        AppMethodBeat.i(247303);
        StringBuilder sb = new StringBuilder();
        Iterator<T> it = this.uwf.iterator();
        while (it.hasNext()) {
            ArrayList<i> arrayList = it.next().uxo;
            if (arrayList != null) {
                for (T t : arrayList) {
                    sb.append("{" + t.key + '(' + t.value + "):" + t.hjI + "};");
                }
            }
            sb.append("\n");
        }
        String sb2 = sb.toString();
        p.g(sb2, "sb.toString()");
        AppMethodBeat.o(247303);
        return sb2;
    }
}
