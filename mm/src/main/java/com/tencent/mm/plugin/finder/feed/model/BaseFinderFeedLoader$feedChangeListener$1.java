package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.event.IListener;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader$feedChangeListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "callback", "", "event", "plugin-finder_release"})
public final class BaseFinderFeedLoader$feedChangeListener$1 extends IListener<hn> {
    final /* synthetic */ bbn $contextObj;
    final /* synthetic */ BaseFinderFeedLoader this$0;

    BaseFinderFeedLoader$feedChangeListener$1(BaseFinderFeedLoader baseFinderFeedLoader, bbn bbn) {
        this.this$0 = baseFinderFeedLoader;
        this.$contextObj = bbn;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* bridge */ /* synthetic */ boolean callback(hn hnVar) {
        AppMethodBeat.i(166019);
        boolean callback = callback(hnVar);
        AppMethodBeat.o(166019);
        return callback;
    }

    public final boolean callback(hn hnVar) {
        AppMethodBeat.i(244542);
        p.h(hnVar, "event");
        d.a(0, new BaseFinderFeedLoader$feedChangeListener$1$callback$1(this, hnVar));
        AppMethodBeat.o(244542);
        return false;
    }
}
