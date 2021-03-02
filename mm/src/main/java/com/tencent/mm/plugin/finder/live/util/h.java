package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\"\u001a\u00020#J\u0006\u0010$\u001a\u00020#R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R!\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u00040\fj\b\u0012\u0004\u0012\u00020\u0004`\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0006R\u0011\u0010\u0012\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0006R\u0011\u0010\u0014\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0006R\u0011\u0010\u0016\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0006R\u0011\u0010\u0018\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0006R\u0011\u0010\u001a\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0006R\u0011\u0010\u001c\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0006R\u0011\u0010\u001e\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0006R\u0011\u0010 \u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0006¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/util/CDNStatistics;", "", "()V", "audioBitrateStatisticsCache", "Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "getAudioBitrateStatisticsCache", "()Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "avPlayIntervalStatisticsCache", "getAvPlayIntervalStatisticsCache", "avRecIntervalStatisticsCache", "getAvRecIntervalStatisticsCache", "cacheList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getCacheList", "()Ljava/util/ArrayList;", "cpuStatisticsCache", "getCpuStatisticsCache", "frameRateStatisticsCache", "getFrameRateStatisticsCache", "heightStatisticsCache", "getHeightStatisticsCache", "netJitStatisticsCache", "getNetJitStatisticsCache", "netSpeedStatisticsCache", "getNetSpeedStatisticsCache", "sumCacheStatisticsCache", "getSumCacheStatisticsCache", "videoBitrateStatisticsCache", "getVideoBitrateStatisticsCache", "videoCacheStatisticsCache", "getVideoCacheStatisticsCache", "widthStatisticsCache", "getWidthStatisticsCache", "getLevelStr", "", "getRealTimeStr", "plugin-finder_release"})
public final class h {
    private final ArrayList<w> uwf = new ArrayList<>();
    public final w uwg = new c().did();
    public final w uwh = new aa().did();
    public final w uwi = new d().did();
    public final w uwj = new m().did();
    public final w uwk = new ac().did();
    public final w uwl = new o().did();
    public final w uwm;
    public final w uwn;
    public final w uwo;
    public final w uwp;
    public final w uwq;
    public final w uwr;

    public h() {
        AppMethodBeat.i(247241);
        s sVar = new s();
        sVar.uvW.add(new i("BadNetSpeed", 300, 4));
        sVar.uvW.add(new i("NormalNetSpeed", 1800, 4));
        sVar.uvW.add(new i("GoodNetSpeed", Integer.MAX_VALUE, 4));
        this.uwm = new w(sVar.uvU, sVar.uvV, sVar.uvW);
        r rVar = new r();
        rVar.uvW.add(new i("GoodNetJit", 3, 4));
        rVar.uvW.add(new i("NormalNetJit", 10, 4));
        rVar.uvW.add(new i("BadNetJit", Integer.MAX_VALUE, 4));
        this.uwn = new w(rVar.uvU, rVar.uvV, rVar.uvW);
        b bVar = new b();
        bVar.uvW.add(new i("GoodAVRecInterval", 10, 4));
        bVar.uvW.add(new i("NormalAVRecInterval", 50, 4));
        bVar.uvW.add(new i("BadAVRecInterval", Integer.MAX_VALUE, 4));
        this.uwo = new w(bVar.uvU, bVar.uvV, bVar.uvW);
        a aVar = new a();
        aVar.uvW.add(new i("GoodAVPlayInterval", 10, 4));
        aVar.uvW.add(new i("NormalAVPlayInterval", 50, 4));
        aVar.uvW.add(new i("BadAVPlayInterval", Integer.MAX_VALUE, 4));
        this.uwp = new w(aVar.uvU, aVar.uvV, aVar.uvW);
        ab abVar = new ab();
        abVar.uvW.add(new i("BadVideoCache", 100, 4));
        abVar.uvW.add(new i("NormalVideoCache", 1500, 4));
        abVar.uvW.add(new i("GoodVideoCache", Integer.MAX_VALUE, 4));
        this.uwq = new w(abVar.uvU, abVar.uvV, abVar.uvW);
        x xVar = new x();
        xVar.uvW.add(new i("BadSumCacheSize", 100, 4));
        xVar.uvW.add(new i("NormalSumCacheSize", 1500, 4));
        xVar.uvW.add(new i("GoodSumCacheSize", Integer.MAX_VALUE, 4));
        this.uwr = new w(xVar.uvU, xVar.uvV, xVar.uvW);
        this.uwf.add(this.uwg);
        this.uwf.add(this.uwh);
        this.uwf.add(this.uwi);
        this.uwf.add(this.uwj);
        this.uwf.add(this.uwm);
        this.uwf.add(this.uwn);
        this.uwf.add(this.uwo);
        this.uwf.add(this.uwp);
        this.uwf.add(this.uwq);
        this.uwf.add(this.uwr);
        AppMethodBeat.o(247241);
    }

    public final String dif() {
        AppMethodBeat.i(247240);
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
        AppMethodBeat.o(247240);
        return sb2;
    }
}
