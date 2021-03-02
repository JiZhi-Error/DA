package com.tencent.mm.plugin.finder.cgi.interceptor;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.aa;
import com.tencent.mm.plugin.finder.model.x;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u000f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/finder/cgi/interceptor/FinderLiveInterceptor;", "Lcom/tencent/mm/plugin/finder/cgi/interceptor/IFinderStreamInterceptor;", "()V", "map", "Landroid/util/SparseArray;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveList;", "onIntercept", "", "resp", "Lcom/tencent/mm/plugin/finder/cgi/CgiFinderStream$FinderStreamResponseEx;", "tabType", "", "onInterceptAfterStore", "loadedInfo", "Lcom/tencent/mm/plugin/finder/feed/model/CgiFinderStreamResult;", "onInterceptBeforeStore", "saveFeedLiveList", "", "plugin-finder_release"})
public final class b implements f {
    private SparseArray<x> mHa = new SparseArray<>();

    public b() {
        AppMethodBeat.i(242617);
        AppMethodBeat.o(242617);
    }

    @Override // com.tencent.mm.plugin.finder.cgi.interceptor.f
    public final boolean a(aa.f fVar) {
        AppMethodBeat.i(242614);
        p.h(fVar, "resp");
        AppMethodBeat.o(242614);
        return false;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.interceptor.f
    public final boolean a(com.tencent.mm.plugin.finder.feed.model.b bVar) {
        AppMethodBeat.i(242615);
        p.h(bVar, "loadedInfo");
        AppMethodBeat.o(242615);
        return false;
    }

    @Override // com.tencent.mm.plugin.finder.cgi.interceptor.f
    public final boolean b(com.tencent.mm.plugin.finder.feed.model.b bVar, int i2) {
        AppMethodBeat.i(242616);
        p.h(bVar, "loadedInfo");
        x xVar = this.mHa.get(i2);
        if (xVar != null) {
            bVar.tUz.add(0, xVar);
        }
        AppMethodBeat.o(242616);
        return false;
    }
}
