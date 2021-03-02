package com.tencent.mm.plugin.finder.live.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.core.b.g;
import com.tencent.mm.live.core.core.d.b;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.plugin.bw;
import com.tencent.mm.plugin.finder.live.plugin.bz;
import com.tencent.mm.plugin.finder.report.live.m;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.a;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
public final class FinderLiveVisitorPluginLayout$onAcceptLinkMicSelf$1 extends q implements a<x> {
    final /* synthetic */ com.tencent.mm.live.b.a $info;
    final /* synthetic */ FinderLiveVisitorPluginLayout this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FinderLiveVisitorPluginLayout$onAcceptLinkMicSelf$1(FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout, com.tencent.mm.live.b.a aVar) {
        super(0);
        this.this$0 = finderLiveVisitorPluginLayout;
        this.$info = aVar;
    }

    @Override // kotlin.g.a.a
    public final void invoke() {
        String str;
        g gVar;
        AppMethodBeat.i(247607);
        b bVar = this.this$0.liveCore;
        if (bVar != null) {
            bVar.aDY();
        }
        bw bwVar = this.this$0.linkMicStatePlugin;
        if (bwVar != null) {
            bwVar.dgX();
        }
        Integer num = this.$info.hFE;
        if (num != null && num.intValue() == 1) {
            bz bzVar = this.this$0.previewPlugin;
            if (bzVar != null) {
                b bVar2 = this.this$0.liveCore;
                if (bVar2 == null || (gVar = bVar2.hAz) == null) {
                    str = null;
                } else {
                    str = gVar.hzG;
                }
                bzVar.atO(str);
            }
            this.this$0.notifyAudienceMicUserChange();
            m.a(m.vli, s.ax.ANCHOR_PASS_LINKMIC_REQUEST, s.z.AUDIO, 4);
        } else {
            Integer num2 = this.$info.hFE;
            if (num2 != null && num2.intValue() == 2) {
                this.this$0.notifyAudienceMicUserChange();
                bz bzVar2 = this.this$0.previewPlugin;
                if (bzVar2 != null) {
                    bzVar2.startPreview();
                }
                b bVar3 = this.this$0.liveCore;
                if (bVar3 != null) {
                    bVar3.aBY();
                }
                m.a(m.vli, s.ax.ANCHOR_PASS_LINKMIC_REQUEST, s.z.vpH, 4);
            } else {
                Log.i(this.this$0.TAG, "onAcceptLinkMicSelf TRTC invalid micType:" + this.$info.hFE);
            }
        }
        o oVar = o.ujN;
        o.dgh();
        AppMethodBeat.o(247607);
    }
}
