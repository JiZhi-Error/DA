package com.tencent.mm.plugin.finder.live.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
public final class FinderLiveVisitorPluginLayout$directStartLive$1 implements Runnable {
    final /* synthetic */ FinderLiveVisitorPluginLayout this$0;

    FinderLiveVisitorPluginLayout$directStartLive$1(FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout) {
        this.this$0 = finderLiveVisitorPluginLayout;
    }

    public final void run() {
        AppMethodBeat.i(247586);
        FinderLiveVisitorPluginLayout.access$restoreLinkMicUI(this.this$0);
        AppMethodBeat.o(247586);
    }
}
