package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hi;
import com.tencent.mm.sdk.event.IListener;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/feed/model/FinderProfileFeedLoader$liveLifeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedLiveLifeEvent;", "callback", "", "event", "plugin-finder_release"})
public final class FinderProfileFeedLoader$liveLifeListener$1 extends IListener<hi> {
    final /* synthetic */ FinderProfileFeedLoader this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    FinderProfileFeedLoader$liveLifeListener$1(FinderProfileFeedLoader finderProfileFeedLoader) {
        this.this$0 = finderProfileFeedLoader;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* bridge */ /* synthetic */ boolean callback(hi hiVar) {
        AppMethodBeat.i(244811);
        boolean callback = callback(hiVar);
        AppMethodBeat.o(244811);
        return callback;
    }

    public final boolean callback(hi hiVar) {
        AppMethodBeat.i(244810);
        if (hiVar != null) {
            this.this$0.requestRefresh();
        }
        AppMethodBeat.o(244810);
        return false;
    }
}
