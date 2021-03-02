package com.tencent.mm.plugin.finder.feed.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bw.b;
import com.tencent.mm.plugin.finder.feed.model.FinderFeedRelTimelineLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.feed.ui.FinderAlbumTimelineUI;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.blo;
import com.tencent.mm.protocal.protobuf.ecq;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\f\u0010\u0002\u001a\u00060\u0003R\u00020\u0001H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/finder/feed/ui/FinderAlbumTimelineUI$feedLoader$2$1", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader$FinderStreamCardDataFetcher;", "plugin-finder_release"})
public final class FinderAlbumTimelineUI$feedLoader$2$1 extends FinderFeedRelTimelineLoader {
    final /* synthetic */ FinderAlbumTimelineUI.h tZe;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FinderAlbumTimelineUI$feedLoader$2$1(FinderAlbumTimelineUI.h hVar, int i2, blo blo, b bVar, ecq ecq, bbn bbn) {
        super(0, null, 0, null, 0, false, blo, bVar, ecq, i2, bbn, 0.0f, 0.0f, 26751);
        this.tZe = hVar;
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.feed.model.internal.g' to match base method */
    @Override // com.tencent.mm.plugin.finder.feed.model.FinderFeedRelTimelineLoader, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final /* synthetic */ g<bo> createDataFetch() {
        AppMethodBeat.i(245051);
        FinderFeedRelTimelineLoader.c cVar = new FinderFeedRelTimelineLoader.c();
        AppMethodBeat.o(245051);
        return cVar;
    }
}
