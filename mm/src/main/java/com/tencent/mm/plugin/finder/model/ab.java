package com.tencent.mm.plugin.finder.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/model/FinderFeedPlainText;", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "feedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "(Lcom/tencent/mm/plugin/finder/storage/FinderItem;)V", "plugin-finder_release"})
public final class ab extends BaseFinderFeed {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ab(FinderItem finderItem) {
        super(finderItem);
        p.h(finderItem, "feedObject");
        AppMethodBeat.i(166386);
        AppMethodBeat.o(166386);
    }
}
