package com.tencent.mm.plugin.finder.storage.data;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.c;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/data/FinderObjectTransform;", "Lcom/tencent/mm/plugin/finder/storage/data/PageDataTransform;", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "()V", "transform", "src", "plugin-finder_release"})
public final class k {
    public static final k vGq = new k();

    static {
        AppMethodBeat.i(252009);
        AppMethodBeat.o(252009);
    }

    private k() {
    }

    public static bo o(FinderItem finderItem) {
        AppMethodBeat.i(252008);
        p.h(finderItem, "src");
        c.a aVar = c.vGN;
        BaseFinderFeed s = c.a.s(finderItem);
        AppMethodBeat.o(252008);
        return s;
    }
}
