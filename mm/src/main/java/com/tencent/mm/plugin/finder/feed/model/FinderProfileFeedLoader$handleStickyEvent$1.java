package com.tencent.mm.plugin.finder.feed.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.g.a.hm;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "event", "Lcom/tencent/mm/autogen/events/FeedStickyEvent;", "invoke"})
public final class FinderProfileFeedLoader$handleStickyEvent$1 extends q implements b<hm, x> {
    public static final FinderProfileFeedLoader$handleStickyEvent$1 INSTANCE = new FinderProfileFeedLoader$handleStickyEvent$1();

    static {
        AppMethodBeat.i(244809);
        AppMethodBeat.o(244809);
    }

    FinderProfileFeedLoader$handleStickyEvent$1() {
        super(1);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.g.a.b
    public final /* bridge */ /* synthetic */ x invoke(hm hmVar) {
        AppMethodBeat.i(244807);
        invoke(hmVar);
        x xVar = x.SXb;
        AppMethodBeat.o(244807);
        return xVar;
    }

    public final void invoke(hm hmVar) {
        AppMethodBeat.i(244808);
        p.h(hmVar, "event");
        d.h(AnonymousClass1.INSTANCE);
        AppMethodBeat.o(244808);
    }
}
