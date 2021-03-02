package com.tencent.mm.plugin.finder.live.view;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.model.cgi.b;
import com.tencent.mm.protocal.protobuf.avg;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/live/view/FinderLiveVisitorPluginLayout$statusChange$3", "Lcom/tencent/mm/plugin/finder/live/model/cgi/CgiFinderApplyLiveMic$CallBack;", "onCgiBack", "", "errType", "", "errCode", "errMsg", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveApplyMicWithAudienceResponse;", "plugin-finder_release"})
public final class FinderLiveVisitorPluginLayout$statusChange$3 implements b.a {
    final /* synthetic */ int $type;
    final /* synthetic */ FinderLiveVisitorPluginLayout this$0;

    FinderLiveVisitorPluginLayout$statusChange$3(FinderLiveVisitorPluginLayout finderLiveVisitorPluginLayout, int i2) {
        this.this$0 = finderLiveVisitorPluginLayout;
        this.$type = i2;
    }

    @Override // com.tencent.mm.plugin.finder.live.model.cgi.b.a
    public final void onCgiBack(int i2, int i3, String str, avg avg) {
        AppMethodBeat.i(260854);
        p.h(avg, "resp");
        Log.i(this.this$0.TAG, "ApplyLinkMic errCode:" + i3 + " errType:" + i2 + "  errMsg:" + str);
        FinderLiveVisitorPluginLayout.access$handleLinkMicRequest(this.this$0, this.$type, i3, i2, str, avg);
        AppMethodBeat.o(260854);
    }
}
