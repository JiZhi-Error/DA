package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.plugin.finder.storage.ak;
import com.tencent.mm.view.recyclerview.g;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/finder/model/FinderBlockSubTitleData;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig;", "(Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig;)V", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/IFinderBlockListConfig;", "setConfig", "compare", "", "obj", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class m extends g.b implements i {
    public ak uWp;

    public m(ak akVar) {
        p.h(akVar, "config");
        AppMethodBeat.i(261249);
        this.uWp = akVar;
        AppMethodBeat.o(261249);
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.i
    public final int a(i iVar) {
        AppMethodBeat.i(248719);
        p.h(iVar, "obj");
        AppMethodBeat.o(248719);
        return Integer.MAX_VALUE;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final long lT() {
        AppMethodBeat.i(248720);
        long hashCode = (long) hashCode();
        AppMethodBeat.o(248720);
        return hashCode;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final int cxn() {
        return -8;
    }
}
