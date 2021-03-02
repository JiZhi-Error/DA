package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import com.tencent.mm.plugin.finder.storage.z;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "mixItem", "Lcom/tencent/mm/plugin/finder/storage/FinderMixItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderMixItem;)V", "baseFinderFeed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "getBaseFinderFeed", "()Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "setBaseFinderFeed", "(Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;)V", "getMixItem", "()Lcom/tencent/mm/plugin/finder/storage/FinderMixItem;", "compare", "", "obj", "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "getItemId", "", "getItemType", "toString", "", "plugin-finder_release"})
public final class c implements bo {
    public BaseFinderFeed uNI;
    public final z uNJ;

    public c(z zVar) {
        BaseFinderFeed baseFinderFeed;
        p.h(zVar, "mixItem");
        AppMethodBeat.i(248695);
        this.uNJ = zVar;
        FinderItem finderItem = this.uNJ.vEG;
        if (finderItem != null) {
            c.a aVar = com.tencent.mm.plugin.finder.storage.logic.c.vGN;
            baseFinderFeed = c.a.s(finderItem);
        } else {
            baseFinderFeed = null;
        }
        this.uNI = baseFinderFeed;
        AppMethodBeat.o(248695);
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final long lT() {
        return this.uNJ.vEH;
    }

    @Override // com.tencent.mm.view.recyclerview.a
    public final int cxn() {
        return this.uNJ.qcr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x005c  */
    @Override // com.tencent.mm.plugin.finder.feed.model.internal.i
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(com.tencent.mm.plugin.finder.feed.model.internal.i r12) {
        /*
        // Method dump skipped, instructions count: 198
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.finder.model.c.a(com.tencent.mm.plugin.finder.feed.model.internal.i):int");
    }

    public final String toString() {
        AppMethodBeat.i(248694);
        String str = "ItemId=" + this.uNJ.vEH + ",ItemType=" + this.uNJ.qcr + ' ';
        AppMethodBeat.o(248694);
        return str;
    }
}
