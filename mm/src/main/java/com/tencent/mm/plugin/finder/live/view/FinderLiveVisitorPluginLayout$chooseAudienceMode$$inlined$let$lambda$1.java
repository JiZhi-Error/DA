package com.tencent.mm.plugin.finder.live.view;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import kotlin.g.a.b;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "invoke", "com/tencent/mm/plugin/finder/live/view/FinderLiveVisitorPluginLayout$chooseAudienceMode$2$1"})
public final class FinderLiveVisitorPluginLayout$chooseAudienceMode$$inlined$let$lambda$1 extends q implements b<Boolean, x> {
    final /* synthetic */ boolean $fromMiniWin$inlined;
    final /* synthetic */ FinderLiveVisitorPluginLayout this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FinderLiveVisitorPluginLayout$chooseAudienceMode$$inlined$let$lambda$1(FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout, boolean z) {
        super(1);
        this.this$0 = finderLiveVisitorPluginLayout;
        this.$fromMiniWin$inlined = z;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.g.a.b
    public final /* synthetic */ x invoke(Boolean bool) {
        AppMethodBeat.i(247582);
        invoke(bool.booleanValue());
        x xVar = x.SXb;
        AppMethodBeat.o(247582);
        return xVar;
    }

    public final void invoke(boolean z) {
        AppMethodBeat.i(247583);
        if (z) {
            com.tencent.mm.live.core.core.d.b bVar = this.this$0.liveCore;
            if (bVar != null) {
                bVar.aEb();
            }
            Bundle bundle = new Bundle();
            bundle.putBoolean("PARAM_FINDER_LIVE_START_BY_MINI_WINDOW", this.$fromMiniWin$inlined);
            this.this$0.statusChange(b.c.hLB, bundle);
        }
        AppMethodBeat.o(247583);
    }
}
