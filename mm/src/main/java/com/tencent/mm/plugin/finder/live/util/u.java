package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0016\u001a\u00020\u0017R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR*\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0010j\b\u0012\u0004\u0012\u00020\u0004`\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/util/RttStatisticsCache;", "", "()V", "RttCachePair", "Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "getRttCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "setRttCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/CachePair;)V", "averageRttCachePair", "Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "getAverageRttCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "setAverageRttCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;)V", "levelList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getLevelList", "()Ljava/util/ArrayList;", "setLevelList", "(Ljava/util/ArrayList;)V", "getCache", "Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "plugin-finder_release"})
public final class u {
    ArrayList<i> uvW = new ArrayList<>();
    i uxk = new i("Rtt", 0, 6);
    e uxl = new e("AverageRtt", 14);

    public u() {
        AppMethodBeat.i(247299);
        AppMethodBeat.o(247299);
    }
}
