package com.tencent.mm.plugin.finder.nearby.live.square.more;

import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.nearby.live.square.NearbyLiveSquareFragment;
import com.tencent.mm.plugin.finder.nearby.report.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\u001a\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u000f"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/live/square/more/NearbyLiveSquareMoreFragment;", "Lcom/tencent/mm/plugin/finder/nearby/live/square/NearbyLiveSquareFragment;", "()V", "getClickTabContextId", "", "getCommentScene", "", "getReportType", "onResume", "", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder_release"})
public final class NearbyLiveSquareMoreFragment extends NearbyLiveSquareFragment {
    private HashMap _$_findViewCache;

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment, com.tencent.mm.ui.component.UIComponentFragment, com.tencent.mm.plugin.finder.nearby.live.square.NearbyLiveSquareFragment
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(249223);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(249223);
    }

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment, com.tencent.mm.ui.component.UIComponentFragment, android.support.v4.app.Fragment, com.tencent.mm.plugin.finder.nearby.live.square.NearbyLiveSquareFragment
    public final /* synthetic */ void onDestroyView() {
        AppMethodBeat.i(249224);
        super.onDestroyView();
        _$_clearFindViewByIdCache();
        AppMethodBeat.o(249224);
    }

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment, android.support.v4.app.Fragment
    public final void onViewCreated(View view, Bundle bundle) {
        AppMethodBeat.i(249221);
        p.h(view, "view");
        super.onViewCreated(view, bundle);
        super.onUserVisibleFocused();
        AppMethodBeat.o(249221);
    }

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment, com.tencent.mm.plugin.finder.nearby.live.square.NearbyLiveSquareFragment
    public final int ddN() {
        return 3;
    }

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment, com.tencent.mm.plugin.finder.nearby.live.square.NearbyLiveSquareFragment
    public final int getCommentScene() {
        return 80;
    }

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment, com.tencent.mm.plugin.finder.nearby.live.square.NearbyLiveSquareFragment
    public final String ack() {
        return "1004";
    }

    @Override // com.tencent.mm.plugin.finder.nearby.base.AbsNearByFragment, com.tencent.mm.ui.component.UIComponentFragment, android.support.v4.app.Fragment, com.tencent.mm.plugin.finder.nearby.live.square.NearbyLiveSquareFragment
    public final void onResume() {
        AppMethodBeat.i(249222);
        super.onResume();
        Log.i("NearbyLiveSquareUIC", "onResume()");
        d dVar = d.uTq;
        d.dlB();
        AppMethodBeat.o(249222);
    }
}
