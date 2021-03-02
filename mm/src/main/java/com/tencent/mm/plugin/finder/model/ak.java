package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016J\b\u0010\f\u001a\u00020\bH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/finder/model/FinderLineDivider;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "layoutId", "", "(J)V", "getLayoutId", "()J", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "getItemType", "toString", "", "plugin-finder_release"})
public final class ak implements bo {
    private final long uOx;

    public ak(long j2) {
        this.uOx = j2;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final long lT() {
        return this.uOx;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final int cxn() {
        return 2015;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.internal.i
    public final int a(i iVar) {
        AppMethodBeat.i(248770);
        p.h(iVar, "obj");
        if (!(iVar instanceof ak) || ((ak) iVar).uOx != this.uOx) {
            AppMethodBeat.o(248770);
            return -1;
        }
        AppMethodBeat.o(248770);
        return 0;
    }

    public final String toString() {
        AppMethodBeat.i(248771);
        String str = "ItemId=" + this.uOx + ",ItemType=2015";
        AppMethodBeat.o(248771);
        return str;
    }
}
