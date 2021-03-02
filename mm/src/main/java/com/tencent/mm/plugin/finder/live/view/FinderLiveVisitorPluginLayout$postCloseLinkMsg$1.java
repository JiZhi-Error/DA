package com.tencent.mm.plugin.finder.live.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.cgi.d;
import com.tencent.mm.protocal.protobuf.avm;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/live/view/FinderLiveVisitorPluginLayout$postCloseLinkMsg$1", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderCloseLiveMic$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveCloseMicWithAudienceResponse;", "plugin-finder_release"})
public final class FinderLiveVisitorPluginLayout$postCloseLinkMsg$1 implements d.a {
    final /* synthetic */ String $sessionId;
    final /* synthetic */ FinderLiveVisitorPluginLayout this$0;

    FinderLiveVisitorPluginLayout$postCloseLinkMsg$1(FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout, String str) {
        this.this$0 = finderLiveVisitorPluginLayout;
        this.$sessionId = str;
    }

    @Override // com.tencent.mm.plugin.finder.live.model.cgi.d.a
    public final void onCgiBack(int i2, int i3, String str, avm avm) {
        AppMethodBeat.i(247621);
        p.h(avm, "resp");
        com.tencent.mm.ac.d.h(new FinderLiveVisitorPluginLayout$postCloseLinkMsg$1$onCgiBack$1(this, i3, i2, str));
        AppMethodBeat.o(247621);
    }
}
