package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
public final class FinderLiveVisitorPluginLayout$directStartLive$2 extends q implements a<x> {
    final /* synthetic */ FinderLiveVisitorPluginLayout this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FinderLiveVisitorPluginLayout$directStartLive$2(FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout) {
        super(0);
        this.this$0 = finderLiveVisitorPluginLayout;
    }

    @Override // kotlin.g.a.a
    public final void invoke() {
        AppMethodBeat.i(260847);
        FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout = this.this$0;
        Context context = this.this$0.getContext();
        if (context == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(260847);
            throw tVar;
        }
        finderLiveVisitorPluginLayout.goGetLuckMoney((MMActivity) context, this.this$0.getData().uCr.aFR());
        AppMethodBeat.o(260847);
    }
}
