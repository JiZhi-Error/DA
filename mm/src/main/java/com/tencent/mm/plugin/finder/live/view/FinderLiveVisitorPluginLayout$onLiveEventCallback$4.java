package com.tencent.mm.plugin.finder.live.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.plugin.bz;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
final class FinderLiveVisitorPluginLayout$onLiveEventCallback$4 implements Runnable {
    final /* synthetic */ FinderLiveVisitorPluginLayout this$0;

    FinderLiveVisitorPluginLayout$onLiveEventCallback$4(FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout) {
        this.this$0 = finderLiveVisitorPluginLayout;
    }

    public final void run() {
        AppMethodBeat.i(260852);
        this.this$0.getLastMicUserList().clear();
        this.this$0.notifyAudienceMicUserChange();
        bz bzVar = this.this$0.previewPlugin;
        if (bzVar != null) {
            bzVar.startPreview();
            AppMethodBeat.o(260852);
            return;
        }
        AppMethodBeat.o(260852);
    }
}
