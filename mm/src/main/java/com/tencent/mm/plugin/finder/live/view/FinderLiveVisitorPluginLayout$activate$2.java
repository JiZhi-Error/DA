package com.tencent.mm.plugin.finder.live.view;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
public final class FinderLiveVisitorPluginLayout$activate$2 extends q implements a<x> {
    final /* synthetic */ FinderLiveVisitorPluginLayout this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FinderLiveVisitorPluginLayout$activate$2(FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout) {
        super(0);
        this.this$0 = finderLiveVisitorPluginLayout;
    }

    @Override // kotlin.g.a.a
    public final void invoke() {
        AppMethodBeat.i(247574);
        h.RTc.aV(new Runnable(this) {
            /* class com.tencent.mm.plugin.finder.live.view.FinderLiveVisitorPluginLayout$activate$2.AnonymousClass1 */
            final /* synthetic */ FinderLiveVisitorPluginLayout$activate$2 this$0;

            {
                this.this$0 = r1;
            }

            public final void run() {
                AppMethodBeat.i(247572);
                b.C0376b.a(this.this$0.this$0, b.c.hMl);
                AppMethodBeat.o(247572);
            }
        });
        AppMethodBeat.o(247574);
    }
}
