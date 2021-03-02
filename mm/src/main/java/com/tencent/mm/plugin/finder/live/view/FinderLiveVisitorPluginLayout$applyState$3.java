package com.tencent.mm.plugin.finder.live.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
final class FinderLiveVisitorPluginLayout$applyState$3 implements Runnable {
    final /* synthetic */ String $realNameUrl;
    final /* synthetic */ FinderLiveVisitorPluginLayout this$0;

    FinderLiveVisitorPluginLayout$applyState$3(FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout, String str) {
        this.this$0 = finderLiveVisitorPluginLayout;
        this.$realNameUrl = str;
    }

    public final void run() {
        AppMethodBeat.i(247579);
        FinderLiveVisitorPluginLayout.access$showRealNameBottomSheet(this.this$0, this.$realNameUrl);
        AppMethodBeat.o(247579);
    }
}
