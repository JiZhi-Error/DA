package com.tencent.mm.plugin.finder.live.util;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\b¢\u0006\u0002\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R.\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\u0003\u0018\u0001`\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/util/StatisticsCache;", "", "cache", "Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "averageCache", "Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "levelList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "(Lcom/tencent/mm/plugin/finder/live/util/CachePair;Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;Ljava/util/ArrayList;)V", "average", "getAverage", "()Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;", "setAverage", "(Lcom/tencent/mm/plugin/finder/live/util/AverageCachePair;)V", "continueFlag", "", "getContinueFlag", "()Z", "setContinueFlag", "(Z)V", "level", "getLevel", "()Ljava/util/ArrayList;", "setLevel", "(Ljava/util/ArrayList;)V", "realtime", "getRealtime", "()Lcom/tencent/mm/plugin/finder/live/util/CachePair;", "setRealtime", "(Lcom/tencent/mm/plugin/finder/live/util/CachePair;)V", "plugin-finder_release"})
public final class w {
    boolean tuG = true;
    public i uxm;
    public e uxn;
    ArrayList<i> uxo;

    public w(i iVar, e eVar, ArrayList<i> arrayList) {
        p.h(iVar, "cache");
        AppMethodBeat.i(247301);
        this.uxm = iVar;
        this.uxn = eVar;
        this.uxo = arrayList;
        AppMethodBeat.o(247301);
    }
}
