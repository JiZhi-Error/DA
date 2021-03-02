package com.tencent.mm.plugin.finder.nearby.live.square.more;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.nearby.live.b;
import com.tencent.mm.plugin.finder.nearby.live.e;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.ui.MMActivity;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/live/square/more/NearbyLiveMoreViewCallback;", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveViewCallback;", "baseContext", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$Presenter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "parent", "Landroid/view/View;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$Presenter;Landroid/view/View;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "plugin-finder_release"})
public final class b extends e {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(MMActivity mMActivity, b.a<bo> aVar, View view, bbn bbn) {
        super(mMActivity, aVar, view, bbn);
        p.h(mMActivity, "baseContext");
        p.h(aVar, "presenter");
        p.h(view, "parent");
        p.h(bbn, "contextObj");
        AppMethodBeat.i(249220);
        AppMethodBeat.o(249220);
    }
}
