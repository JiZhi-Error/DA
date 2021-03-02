package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import java.util.ArrayList;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0004"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader$onPostStart$1$1$1", "com/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader$$special$$inlined$let$lambda$1"})
public final class BaseFinderFeedLoader$onPostStart$$inlined$also$lambda$1 extends q implements a<x> {
    final /* synthetic */ BaseFinderFeed $feed$inlined;
    final /* synthetic */ ArrayList $feedList$inlined;
    final /* synthetic */ boolean $isFromSns$inlined;
    final /* synthetic */ FinderItem $item$inlined;
    final /* synthetic */ long $localId$inlined;
    final /* synthetic */ BaseFinderFeedLoader this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseFinderFeedLoader$onPostStart$$inlined$also$lambda$1(BaseFinderFeed baseFinderFeed, ArrayList arrayList, BaseFinderFeedLoader baseFinderFeedLoader, FinderItem finderItem, long j2, boolean z) {
        super(0);
        this.$feed$inlined = baseFinderFeed;
        this.$feedList$inlined = arrayList;
        this.this$0 = baseFinderFeedLoader;
        this.$item$inlined = finderItem;
        this.$localId$inlined = j2;
        this.$isFromSns$inlined = z;
    }

    @Override // kotlin.g.a.a
    public final void invoke() {
        AppMethodBeat.i(244546);
        this.this$0.getDataList().add(1, this.$feed$inlined);
        this.this$0.dispatcher().onItemRangeInserted(1, 1);
        AppMethodBeat.o(244546);
    }
}
