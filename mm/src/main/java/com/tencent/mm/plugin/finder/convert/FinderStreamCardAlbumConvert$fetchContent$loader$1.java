package com.tencent.mm.plugin.finder.convert;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.finder.cgi.bh;
import com.tencent.mm.plugin.finder.feed.model.FinderFeedRelTimelineLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.g;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.protocal.protobuf.ato;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.protocal.protobuf.ecq;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$fetchContent$loader$1", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "createDataFetch", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "isObservePostEvent", "", "plugin-finder_release"})
public final class FinderStreamCardAlbumConvert$fetchContent$loader$1 extends FinderFeedRelTimelineLoader {
    final /* synthetic */ ch tGu;
    final /* synthetic */ ecq tGy;

    /* JADX DEBUG: Multi-variable search result rejected for r22v0, resolved type: int */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FinderStreamCardAlbumConvert$fetchContent$loader$1(ch chVar, ecq ecq, int i2) {
        super(0, null, 0, null, 10, false, null, null, null, 0, i2, 0.0f, 0.0f, 28655);
        this.tGu = chVar;
        this.tGy = ecq;
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader, com.tencent.mm.plugin.finder.feed.model.FinderFeedRelTimelineLoader
    public final boolean isObservePostEvent() {
        return false;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00060\u0001R\u00020\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\u0005"}, hxF = {"com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$fetchContent$loader$1$createDataFetch$1", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader$FinderStreamCardDataFetcher;", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "genRefreshNetScene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "plugin-finder_release"})
    public static final class a extends FinderFeedRelTimelineLoader.c {
        final /* synthetic */ FinderStreamCardAlbumConvert$fetchContent$loader$1 tGC;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(FinderStreamCardAlbumConvert$fetchContent$loader$1 finderStreamCardAlbumConvert$fetchContent$loader$1) {
            super();
            this.tGC = finderStreamCardAlbumConvert$fetchContent$loader$1;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.FinderFeedRelTimelineLoader.a, com.tencent.mm.plugin.finder.feed.model.internal.a, com.tencent.mm.plugin.finder.feed.model.FinderFeedRelTimelineLoader.c
        public final q genRefreshNetScene() {
            AppMethodBeat.i(243288);
            ecq ecq = this.tGC.tGy;
            bbn contextObj = this.tGC.getContextObj();
            ato ato = this.tGC.tta;
            if (ato == null) {
                ato = new ato();
            }
            bh bhVar = new bh(ecq, contextObj, ato);
            bhVar.pullType = 0;
            bh bhVar2 = bhVar;
            AppMethodBeat.o(243288);
            return bhVar2;
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.model.FinderFeedRelTimelineLoader, com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader
    public final g<bo> createDataFetch() {
        AppMethodBeat.i(243289);
        a aVar = new a(this);
        AppMethodBeat.o(243289);
        return aVar;
    }
}
