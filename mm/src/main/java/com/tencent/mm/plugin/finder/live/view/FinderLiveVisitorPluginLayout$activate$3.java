package com.tencent.mm.plugin.finder.live.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b;
import kotlin.g.a.b;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "available", "", "invoke"})
public final class FinderLiveVisitorPluginLayout$activate$3 extends q implements b<Boolean, x> {
    final /* synthetic */ FinderLiveVisitorPluginLayout this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FinderLiveVisitorPluginLayout$activate$3(FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout) {
        super(1);
        this.this$0 = finderLiveVisitorPluginLayout;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.g.a.b
    public final /* synthetic */ x invoke(Boolean bool) {
        AppMethodBeat.i(247575);
        invoke(bool.booleanValue());
        x xVar = x.SXb;
        AppMethodBeat.o(247575);
        return xVar;
    }

    public final void invoke(boolean z) {
        AppMethodBeat.i(247576);
        if (z) {
            b.C0376b.a(this.this$0, b.c.hMu);
            AppMethodBeat.o(247576);
            return;
        }
        b.C0376b.a(this.this$0, b.c.hMq);
        AppMethodBeat.o(247576);
    }
}
