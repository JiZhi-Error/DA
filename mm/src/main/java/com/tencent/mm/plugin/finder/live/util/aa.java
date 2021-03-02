package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0016\u001a\u00020\u0017R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR*\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0010j\b\u0012\u0004\u0012\u00020\u0004`\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/util/VideoBitrateStatisticsCache;", "", "()V", "VideoBitrateCachePair", "Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "getVideoBitrateCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "setVideoBitrateCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/CachePair;)V", "averageVideoBitrateCachePair", "Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "getAverageVideoBitrateCachePair", "()Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "setAverageVideoBitrateCachePair", "(Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;)V", "levelList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getLevelList", "()Ljava/util/ArrayList;", "setLevelList", "(Ljava/util/ArrayList;)V", "getCache", "Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "plugin-finder_release"})
public final class aa {
    private ArrayList<i> uvW = new ArrayList<>();
    private i uxw = new i("VideoBitrate", 0, 6);
    private e uxx = new e("AverageVideoBitrate", 14);

    public aa() {
        AppMethodBeat.i(247307);
        AppMethodBeat.o(247307);
    }

    public final w did() {
        AppMethodBeat.i(247306);
        this.uvW.add(new i("BadVideoBitrate", 300, 4));
        this.uvW.add(new i("NormalVideoBitrate", 1800, 4));
        this.uvW.add(new i("GoodVideoBitrate", Integer.MAX_VALUE, 4));
        w wVar = new w(this.uxw, this.uxx, this.uvW);
        AppMethodBeat.o(247306);
        return wVar;
    }
}
