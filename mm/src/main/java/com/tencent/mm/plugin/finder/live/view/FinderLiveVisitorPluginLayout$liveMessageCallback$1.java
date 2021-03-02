package com.tencent.mm.plugin.finder.live.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.live.model.t;
import com.tencent.mm.plugin.finder.live.plugin.aj;
import com.tencent.mm.plugin.finder.live.plugin.al;
import com.tencent.mm.plugin.finder.live.plugin.as;
import com.tencent.mm.plugin.finder.live.plugin.bj;
import com.tencent.mm.plugin.finder.live.plugin.v;
import com.tencent.mm.protocal.protobuf.aut;
import com.tencent.mm.protocal.protobuf.awq;
import java.util.List;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

/* access modifiers changed from: package-private */
@l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
public final class FinderLiveVisitorPluginLayout$liveMessageCallback$1 extends q implements a<x> {
    final /* synthetic */ FinderLiveVisitorPluginLayout this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FinderLiveVisitorPluginLayout$liveMessageCallback$1(FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout) {
        super(0);
        this.this$0 = finderLiveVisitorPluginLayout;
    }

    @Override // kotlin.g.a.a
    public final void invoke() {
        AppMethodBeat.i(247597);
        d.h(new a<x>(this) {
            /* class com.tencent.mm.plugin.finder.live.view.FinderLiveVisitorPluginLayout$liveMessageCallback$1.AnonymousClass1 */
            final /* synthetic */ FinderLiveVisitorPluginLayout$liveMessageCallback$1 this$0;

            {
                this.this$0 = r2;
            }

            @Override // kotlin.g.a.a
            public final void invoke() {
                AppMethodBeat.i(247595);
                bj bjVar = this.this$0.this$0.topCommentPlugin;
                if (bjVar != null) {
                    List<awq> list = this.this$0.this$0.getLiveData().uDu;
                    p.g(list, "liveData.topMsgList");
                    bjVar.ea(list);
                }
                v vVar = this.this$0.this$0.commentPlugin;
                if (vVar != null) {
                    List<t> list2 = this.this$0.this$0.getLiveData().uDs;
                    p.g(list2, "liveData.msgList");
                    vVar.ea(list2);
                }
                al alVar = this.this$0.this$0.lotteryBubblePlugin;
                if (alVar != null) {
                    alVar.dht();
                }
                FinderLiveVisitorPluginLayout.access$trySwitchCdnStream(this.this$0.this$0);
                aj ajVar = this.this$0.this$0.confettiPlugin;
                if (ajVar != null) {
                    List<aut> list3 = this.this$0.this$0.getLiveData().uDv;
                    p.g(list3, "liveData.highLightCheerList");
                    ajVar.ed(list3);
                }
                as asVar = this.this$0.this$0.luckyMoneyPlugin;
                if (asVar != null) {
                    asVar.hTC();
                    AppMethodBeat.o(247595);
                    return;
                }
                AppMethodBeat.o(247595);
            }
        });
        AppMethodBeat.o(247597);
    }
}
