package com.tencent.mm.plugin.finder.live.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.live.b.a;
import com.tencent.mm.live.c.aw;
import com.tencent.mm.live.core.core.b.g;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.plugin.bw;
import com.tencent.mm.plugin.finder.live.plugin.bz;
import com.tencent.mm.plugin.finder.report.live.m;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.rtmp.TXLivePlayConfig;
import kotlin.g.a.b;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", "success", "", "invoke", "com/tencent/mm/plugin/finder/live/view/FinderLiveVisitorPluginLayout$onAcceptLinkMicSelf$2$1"})
public final class FinderLiveVisitorPluginLayout$onAcceptLinkMicSelf$$inlined$let$lambda$1 extends q implements b<Boolean, x> {
    final /* synthetic */ a $info$inlined;
    final /* synthetic */ FinderLiveVisitorPluginLayout this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FinderLiveVisitorPluginLayout$onAcceptLinkMicSelf$$inlined$let$lambda$1(FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout, a aVar) {
        super(1);
        this.this$0 = finderLiveVisitorPluginLayout;
        this.$info$inlined = aVar;
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.g.a.b
    public final /* synthetic */ x invoke(Boolean bool) {
        AppMethodBeat.i(247604);
        invoke(bool.booleanValue());
        x xVar = x.SXb;
        AppMethodBeat.o(247604);
        return xVar;
    }

    public final void invoke(final boolean z) {
        AppMethodBeat.i(247605);
        d.h(new kotlin.g.a.a<x>(this) {
            /* class com.tencent.mm.plugin.finder.live.view.FinderLiveVisitorPluginLayout$onAcceptLinkMicSelf$$inlined$let$lambda$1.AnonymousClass1 */
            final /* synthetic */ FinderLiveVisitorPluginLayout$onAcceptLinkMicSelf$$inlined$let$lambda$1 this$0;

            {
                this.this$0 = r2;
            }

            @Override // kotlin.g.a.a
            public final void invoke() {
                String str;
                g gVar;
                AppMethodBeat.i(247603);
                if (z) {
                    bz bzVar = this.this$0.this$0.previewPlugin;
                    if (bzVar != null) {
                        bzVar.rg(0);
                    }
                    aw awVar = this.this$0.this$0.liveTXLivePlayerPlygin;
                    if (awVar != null) {
                        awVar.rg(8);
                    }
                    aw awVar2 = this.this$0.this$0.liveTXLivePlayerPlygin;
                    if (awVar2 != null) {
                        awVar2.ev(true);
                    }
                    com.tencent.mm.live.core.core.d.b bVar = this.this$0.this$0.liveCore;
                    if (bVar != null) {
                        bVar.aDY();
                    }
                    bw bwVar = this.this$0.this$0.linkMicStatePlugin;
                    if (bwVar != null) {
                        bwVar.dgX();
                    }
                    Integer num = this.this$0.$info$inlined.hFE;
                    if (num != null && num.intValue() == 1) {
                        bz bzVar2 = this.this$0.this$0.previewPlugin;
                        if (bzVar2 != null) {
                            com.tencent.mm.live.core.core.d.b bVar2 = this.this$0.this$0.liveCore;
                            if (bVar2 == null || (gVar = bVar2.hAz) == null) {
                                str = null;
                            } else {
                                str = gVar.hzG;
                            }
                            bzVar2.atO(str);
                        }
                        m.a(m.vli, s.ax.ANCHOR_PASS_LINKMIC_REQUEST, s.z.AUDIO, 4);
                    } else {
                        Integer num2 = this.this$0.$info$inlined.hFE;
                        if (num2 != null && num2.intValue() == 2) {
                            m.a(m.vli, s.ax.ANCHOR_PASS_LINKMIC_REQUEST, s.z.vpH, 4);
                        } else {
                            Log.i(this.this$0.this$0.TAG, "onAcceptLinkMicSelf CDN invalid micType:" + this.this$0.$info$inlined.hFE);
                        }
                    }
                } else {
                    bz bzVar3 = this.this$0.this$0.previewPlugin;
                    if (bzVar3 != null) {
                        bzVar3.rg(8);
                    }
                    aw awVar3 = this.this$0.this$0.liveTXLivePlayerPlygin;
                    if (awVar3 != null) {
                        awVar3.rg(0);
                    }
                    aw awVar4 = this.this$0.this$0.liveTXLivePlayerPlygin;
                    if (awVar4 != null) {
                        com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
                        TXLivePlayConfig dBO = com.tencent.mm.plugin.finder.utils.m.dBO();
                        com.tencent.mm.plugin.finder.utils.m mVar2 = com.tencent.mm.plugin.finder.utils.m.vVH;
                        aw.a(awVar4, 0, dBO, com.tencent.mm.plugin.finder.utils.m.a(this.this$0.this$0.getLiveData(), this.this$0.this$0.isLandscape()), FinderLiveVisitorPluginLayout$onAcceptLinkMicSelf$2$1$1$1.INSTANCE, 1);
                    }
                    Log.w(this.this$0.this$0.TAG, "enterRoom fail! stop link mic");
                }
                o oVar = o.ujN;
                o.dgh();
                AppMethodBeat.o(247603);
            }
        });
        AppMethodBeat.o(247605);
    }
}
