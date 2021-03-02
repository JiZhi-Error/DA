package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.a.hg;
import com.tencent.mm.sdk.event.IListener;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader$feedDeleteListener$1", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedDeleteEvent;", "callback", "", "event", "plugin-finder_release"})
public final class BaseFinderFeedLoader$feedDeleteListener$1 extends IListener<hg> {
    final /* synthetic */ BaseFinderFeedLoader this$0;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    BaseFinderFeedLoader$feedDeleteListener$1(BaseFinderFeedLoader baseFinderFeedLoader) {
        this.this$0 = baseFinderFeedLoader;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
    @Override // com.tencent.mm.sdk.event.IListener
    public final /* bridge */ /* synthetic */ boolean callback(hg hgVar) {
        AppMethodBeat.i(166021);
        boolean callback = callback(hgVar);
        AppMethodBeat.o(166021);
        return callback;
    }

    public final boolean callback(hg hgVar) {
        AppMethodBeat.i(244544);
        if (hgVar != null) {
            d.h(new BaseFinderFeedLoader$feedDeleteListener$1$callback$$inlined$let$lambda$1(this, hgVar));
        }
        AppMethodBeat.o(244544);
        return false;
    }
}
