package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/model/FinderFeedLiveMoreHeader;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "feedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "getItemType", "", "plugin-finder_release"})
public final class z extends BaseFinderFeed {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public z(FinderItem finderItem) {
        super(finderItem);
        p.h(finderItem, "feedObject");
        AppMethodBeat.i(248751);
        AppMethodBeat.o(248751);
    }

    @Override // com.tencent.mm.view.recyclerview.a, com.tencent.mm.plugin.finder.model.BaseFinderFeed
    public final int cxn() {
        return -10;
    }
}
