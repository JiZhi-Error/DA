package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0016\u001a\u00020\u0017R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR*\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\n0\u0010j\b\u0012\u0004\u0012\u00020\n`\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/util/AppCpuStatisticsCache;", "", "()V", "averageCpuCachePair", "Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "getAverageCpuCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "setAverageCpuCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;)V", "cpuCachePair", "Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "getCpuCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "setCpuCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/CachePair;)V", "levelList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getLevelList", "()Ljava/util/ArrayList;", "setLevelList", "(Ljava/util/ArrayList;)V", "getCache", "Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "plugin-finder_release"})
public final class c {
    private ArrayList<i> uvW = new ArrayList<>();
    private i uvX = new i("AppCpu", 0, 6);
    private e uvY = new e("AverageAppCpu", 14);

    public c() {
        AppMethodBeat.i(247226);
        AppMethodBeat.o(247226);
    }

    public final w did() {
        AppMethodBeat.i(247225);
        this.uvW.add(new i("GoodCpu", 20, 4));
        this.uvW.add(new i("NormalCpu", 60, 4));
        this.uvW.add(new i("BadCpu", 100, 4));
        w wVar = new w(this.uvX, this.uvY, this.uvW);
        AppMethodBeat.o(247225);
        return wVar;
    }
}
