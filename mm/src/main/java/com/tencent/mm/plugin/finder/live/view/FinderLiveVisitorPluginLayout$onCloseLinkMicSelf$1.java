package com.tencent.mm.plugin.finder.live.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.aw;
import com.tencent.mm.live.core.core.e;
import com.tencent.mm.plugin.finder.live.plugin.bz;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.rtmp.TXLivePlayConfig;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
public final class FinderLiveVisitorPluginLayout$onCloseLinkMicSelf$1 extends q implements a<x> {
    final /* synthetic */ FinderLiveVisitorPluginLayout this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FinderLiveVisitorPluginLayout$onCloseLinkMicSelf$1(FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout) {
        super(0);
        this.this$0 = finderLiveVisitorPluginLayout;
    }

    @Override // kotlin.g.a.a
    public final void invoke() {
        AppMethodBeat.i(247613);
        int djc = this.this$0.getLiveData().djc();
        e.a aVar = e.a.hxc;
        if (djc == e.a.aCf()) {
            if (this.this$0.previewPlugin != null) {
                bz.exitRoom();
            }
            bz bzVar = this.this$0.previewPlugin;
            if (bzVar != null) {
                bzVar.rg(8);
            }
            aw awVar = this.this$0.liveTXLivePlayerPlygin;
            if (awVar != null) {
                awVar.rg(0);
            }
            aw awVar2 = this.this$0.liveTXLivePlayerPlygin;
            if (awVar2 != null) {
                m mVar = m.vVH;
                TXLivePlayConfig dBO = m.dBO();
                m mVar2 = m.vVH;
                aw.a(awVar2, 0, dBO, m.a(this.this$0.getLiveData(), this.this$0.isLandscape()), AnonymousClass1.INSTANCE, 1);
                AppMethodBeat.o(247613);
                return;
            }
        }
        AppMethodBeat.o(247613);
    }
}
