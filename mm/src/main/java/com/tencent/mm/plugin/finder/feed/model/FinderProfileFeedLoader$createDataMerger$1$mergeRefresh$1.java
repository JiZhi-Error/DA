package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.n;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
final class FinderProfileFeedLoader$createDataMerger$1$mergeRefresh$1 extends q implements a<x> {
    final /* synthetic */ b $next;
    final /* synthetic */ n $op;
    final /* synthetic */ RefreshLoadMoreLayout.c $reason;
    final /* synthetic */ IResponse $response;
    final /* synthetic */ FinderProfileFeedLoader$createDataMerger$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FinderProfileFeedLoader$createDataMerger$1$mergeRefresh$1(FinderProfileFeedLoader$createDataMerger$1 finderProfileFeedLoader$createDataMerger$1, n nVar, RefreshLoadMoreLayout.c cVar, b bVar, IResponse iResponse) {
        super(0);
        this.this$0 = finderProfileFeedLoader$createDataMerger$1;
        this.$op = nVar;
        this.$reason = cVar;
        this.$next = bVar;
        this.$response = iResponse;
    }

    @Override // kotlin.g.a.a
    public final void invoke() {
        AppMethodBeat.i(244801);
        this.this$0.convertOpToReason(this.$op, this.$reason);
        this.this$0.this$0.dispatcher().onPreFinishRefresh(this.$reason);
        b bVar = this.$next;
        if (bVar != null) {
            bVar.invoke(this.$response);
            AppMethodBeat.o(244801);
            return;
        }
        AppMethodBeat.o(244801);
    }
}
