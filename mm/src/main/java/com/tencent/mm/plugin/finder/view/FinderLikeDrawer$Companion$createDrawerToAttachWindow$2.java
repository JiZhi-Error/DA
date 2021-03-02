package com.tencent.mm.plugin.finder.view;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMFragmentActivity;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/finder/view/FinderLikeDrawer$Companion$createDrawerToAttachWindow$2", "Landroid/arch/lifecycle/LifecycleObserver;", "onDestroy", "", "plugin-finder_release"})
public final class FinderLikeDrawer$Companion$createDrawerToAttachWindow$2 implements LifecycleObserver {
    final /* synthetic */ Context $context;
    final /* synthetic */ FinderLikeDrawer wno;

    FinderLikeDrawer$Companion$createDrawerToAttachWindow$2(FinderLikeDrawer finderLikeDrawer, Context context) {
        this.wno = finderLikeDrawer;
        this.$context = context;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        AppMethodBeat.i(254848);
        this.wno.dHu();
        ((MMFragmentActivity) this.$context).getLifecycle().removeObserver(this);
        AppMethodBeat.o(254848);
    }
}
