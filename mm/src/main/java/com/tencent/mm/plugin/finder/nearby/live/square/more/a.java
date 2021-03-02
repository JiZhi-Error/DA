package com.tencent.mm.plugin.finder.nearby.live.square.more;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.nearby.live.d;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.ui.MMActivity;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000b\u001a\u00020\bH\u0014J\b\u0010\f\u001a\u00020\bH\u0014¨\u0006\r"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/live/square/more/NearbyLiveMorePresenter;", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getCommentScene", "", "getHeaderInfo", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "getLocalTypeFlag", "getTabType", "plugin-finder_release"})
public final class a extends d {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(MMActivity mMActivity, bbn bbn) {
        super(mMActivity, bbn);
        p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        p.h(bbn, "contextObj");
        AppMethodBeat.i(249208);
        AppMethodBeat.o(249208);
    }

    @Override // com.tencent.mm.plugin.finder.nearby.live.d, com.tencent.mm.plugin.finder.nearby.live.b.a
    public final int getCommentScene() {
        return 80;
    }

    @Override // com.tencent.mm.plugin.finder.nearby.live.d
    public final int getTabType() {
        return 1004;
    }

    @Override // com.tencent.mm.plugin.finder.nearby.live.d
    public final int dlq() {
        return 16;
    }
}
