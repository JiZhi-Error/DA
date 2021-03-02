package com.tencent.mm.plugin.finder.live.view;

import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.plugin.bj;
import com.tencent.mm.plugin.finder.live.plugin.y;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
public final class FinderLiveVisitorPluginLayout$onLiveStartedWait$2 implements Runnable {
    final /* synthetic */ FinderLiveVisitorPluginLayout this$0;

    FinderLiveVisitorPluginLayout$onLiveStartedWait$2(FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout) {
        this.this$0 = finderLiveVisitorPluginLayout;
    }

    public final void run() {
        ViewGroup viewGroup;
        AppMethodBeat.i(247616);
        y commonInfoPlugin = this.this$0.getCommonInfoPlugin();
        if (commonInfoPlugin == null || (viewGroup = commonInfoPlugin.hwr) == null) {
            AppMethodBeat.o(247616);
            return;
        }
        bj bjVar = this.this$0.topCommentPlugin;
        if (bjVar != null) {
            bjVar.dY(viewGroup);
            AppMethodBeat.o(247616);
            return;
        }
        AppMethodBeat.o(247616);
    }
}
