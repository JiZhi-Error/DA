package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.hg;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader$feedDeleteListener$1$callback$1$1"})
public final class BaseFinderFeedLoader$feedDeleteListener$1$callback$$inlined$let$lambda$1 extends q implements a<x> {
    final /* synthetic */ hg $event$inlined;
    final /* synthetic */ BaseFinderFeedLoader$feedDeleteListener$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    BaseFinderFeedLoader$feedDeleteListener$1$callback$$inlined$let$lambda$1(BaseFinderFeedLoader$feedDeleteListener$1 baseFinderFeedLoader$feedDeleteListener$1, hg hgVar) {
        super(0);
        this.this$0 = baseFinderFeedLoader$feedDeleteListener$1;
        this.$event$inlined = hgVar;
    }

    @Override // kotlin.g.a.a
    public final void invoke() {
        AppMethodBeat.i(244543);
        if (this.$event$inlined.dLJ.dLK == 1) {
            AppMethodBeat.o(244543);
        } else if (this.$event$inlined.dLJ.id != 0) {
            this.this$0.this$0.remove(this.$event$inlined.dLJ.id, true);
            AppMethodBeat.o(244543);
        } else {
            this.this$0.this$0.removeByLocalId(this.$event$inlined.dLJ.localId, true);
            AppMethodBeat.o(244543);
        }
    }
}
