package com.tencent.mm.plugin.finder.live.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.live.c.aw;
import com.tencent.mm.live.core.core.b.g;
import com.tencent.mm.live.core.core.d.b;
import com.tencent.mm.live.core.core.e;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.plugin.bp;
import com.tencent.mm.plugin.finder.live.plugin.bw;
import com.tencent.mm.plugin.finder.live.plugin.bz;
import com.tencent.mm.plugin.finder.live.viewmodel.e;
import com.tencent.mm.plugin.finder.live.viewmodel.g;
import com.tencent.mm.plugin.finder.report.live.m;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.utils.af;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.rtmp.TXLivePlayConfig;
import java.util.Iterator;
import java.util.List;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
final class FinderLiveVisitorPluginLayout$postCloseLinkMsg$1$onCgiBack$1 extends q implements a<x> {
    final /* synthetic */ int $errCode;
    final /* synthetic */ String $errMsg;
    final /* synthetic */ int $errType;
    final /* synthetic */ FinderLiveVisitorPluginLayout$postCloseLinkMsg$1 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FinderLiveVisitorPluginLayout$postCloseLinkMsg$1$onCgiBack$1(FinderLiveVisitorPluginLayout$postCloseLinkMsg$1 finderLiveVisitorPluginLayout$postCloseLinkMsg$1, int i2, int i3, String str) {
        super(0);
        this.this$0 = finderLiveVisitorPluginLayout$postCloseLinkMsg$1;
        this.$errCode = i2;
        this.$errType = i3;
        this.$errMsg = str;
    }

    @Override // kotlin.g.a.a
    public final void invoke() {
        T t;
        bz bzVar;
        g gVar;
        String str = null;
        AppMethodBeat.i(247620);
        String str2 = this.this$0.this$0.TAG;
        StringBuilder append = new StringBuilder("postCloseLinkMsg errCode:").append(this.$errCode).append(", errType:").append(this.$errType).append(", errMsg:").append(this.$errMsg).append(", audienceMode:").append(this.this$0.this$0.getLiveData().djc()).append(", micType:");
        e eVar = this.this$0.this$0.getLiveData().uEB;
        Log.i(str2, append.append(eVar != null ? Integer.valueOf(eVar.uCx) : null).toString());
        if (this.$errCode == 0 && this.$errType == 0) {
            af afVar = af.waa;
            af.dEr();
            o oVar = o.ujN;
            o.dgi();
            if (this.this$0.this$0.previewPlugin != null) {
                bz.dhZ();
            }
            List<e> list = this.this$0.this$0.getLiveData().UPZ;
            p.g(list, "liveData.audienceLinkMicUserList");
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                T next = it.next();
                if (Util.isEqual(next.uCo, this.this$0.this$0.getLiveData().djq())) {
                    t = next;
                    break;
                }
            }
            T t2 = t;
            if (t2 != null && t2.uCx == 1) {
                bw bwVar = this.this$0.this$0.linkMicStatePlugin;
                if (bwVar != null) {
                    bwVar.dgX();
                }
                m.a(m.vli, s.ax.ACTIVE_STOP_AUDIO_LINKMIC, (s.z) null, 6);
            } else if (t2 != null && t2.uCx == 2) {
                b bVar = this.this$0.this$0.liveCore;
                if (bVar != null) {
                    bVar.aBS();
                }
                m.a(m.vli, s.ax.ACTIVE_STOP_VIDEO_LINKMIC, (s.z) null, 6);
            }
            com.tencent.mm.plugin.finder.live.viewmodel.g liveData = this.this$0.this$0.getLiveData();
            String str3 = this.this$0.$sessionId;
            List<e> list2 = liveData.UPZ;
            p.g(list2, "audienceLinkMicUserList");
            d.a(list2, new g.m(str3));
            this.this$0.this$0.notifyAudienceMicUserChange();
            int djc = this.this$0.this$0.getLiveData().djc();
            e.a aVar = e.a.hxc;
            if (djc == e.a.aCf()) {
                if (this.this$0.this$0.previewPlugin != null) {
                    bz.exitRoom();
                }
                bz bzVar2 = this.this$0.this$0.previewPlugin;
                if (bzVar2 != null) {
                    bzVar2.rg(8);
                }
                aw awVar = this.this$0.this$0.liveTXLivePlayerPlygin;
                if (awVar != null) {
                    awVar.rg(0);
                }
                aw awVar2 = this.this$0.this$0.liveTXLivePlayerPlygin;
                if (awVar2 != null) {
                    com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
                    TXLivePlayConfig dBO = com.tencent.mm.plugin.finder.utils.m.dBO();
                    com.tencent.mm.plugin.finder.utils.m mVar2 = com.tencent.mm.plugin.finder.utils.m.vVH;
                    aw.a(awVar2, 0, dBO, com.tencent.mm.plugin.finder.utils.m.a(this.this$0.this$0.getLiveData(), this.this$0.this$0.isLandscape()), AnonymousClass1.INSTANCE, 1);
                }
            } else {
                int djc2 = this.this$0.this$0.getLiveData().djc();
                e.a aVar2 = e.a.hxc;
                if (djc2 == e.a.aCe() && (bzVar = this.this$0.this$0.previewPlugin) != null) {
                    b bVar2 = this.this$0.this$0.liveCore;
                    if (!(bVar2 == null || (gVar = bVar2.hAz) == null)) {
                        str = gVar.hzG;
                    }
                    bzVar.atO(str);
                }
            }
            this.this$0.this$0.getLiveData().uEC = 0;
            bp bottomOptionPlugin = this.this$0.this$0.getBottomOptionPlugin();
            if (bottomOptionPlugin != null) {
                bottomOptionPlugin.dgP();
                AppMethodBeat.o(247620);
                return;
            }
            AppMethodBeat.o(247620);
            return;
        }
        af afVar2 = af.waa;
        af.dEs();
        AppMethodBeat.o(247620);
    }
}
