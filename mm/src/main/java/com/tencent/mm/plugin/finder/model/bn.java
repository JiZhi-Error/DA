package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.view.recyclerview.g;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/model/MegaVideoLoadingData;", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "()V", "compare", "", "obj", "getItemId", "", "getItemType", "plugin-finder_release"})
public final class bn extends g.b implements i {
    @Override // com.tencent.mm.view.recyclerview.a
    public final long lT() {
        AppMethodBeat.i(248866);
        long hashCode = (long) hashCode();
        AppMethodBeat.o(248866);
        return hashCode;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final int cxn() {
        AppMethodBeat.i(248867);
        int hashCode = bn.class.hashCode();
        AppMethodBeat.o(248867);
        return hashCode;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.i
    public final int a(i iVar) {
        AppMethodBeat.i(248868);
        p.h(iVar, "obj");
        AppMethodBeat.o(248868);
        return 0;
    }
}
