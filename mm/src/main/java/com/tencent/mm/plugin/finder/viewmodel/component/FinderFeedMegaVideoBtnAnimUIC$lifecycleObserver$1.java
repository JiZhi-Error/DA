package com.tencent.mm.plugin.finder.viewmodel.component;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0007J\b\u0010\u0004\u001a\u00020\u0003H\u0007J\b\u0010\u0005\u001a\u00020\u0003H\u0007¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/viewmodel/component/FinderFeedMegaVideoBtnAnimUIC$lifecycleObserver$1", "Landroid/arch/lifecycle/LifecycleObserver;", "onDestroy", "", "onPause", "onResume", "plugin-finder_release"})
public final class FinderFeedMegaVideoBtnAnimUIC$lifecycleObserver$1 implements LifecycleObserver {
    final /* synthetic */ FinderFeedMegaVideoBtnAnimUIC wwg;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    FinderFeedMegaVideoBtnAnimUIC$lifecycleObserver$1(FinderFeedMegaVideoBtnAnimUIC finderFeedMegaVideoBtnAnimUIC) {
        this.wwg = finderFeedMegaVideoBtnAnimUIC;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        AppMethodBeat.i(255498);
        this.wwg.wwd.alive();
        this.wwg.cQp = true;
        AppMethodBeat.o(255498);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        AppMethodBeat.i(255499);
        this.wwg.wwd.dead();
        this.wwg.cQp = false;
        AppMethodBeat.o(255499);
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public final void onDestroy() {
        AppMethodBeat.i(255500);
        this.wwg.wwd.dead();
        this.wwg.getActivity().getLifecycle().removeObserver(this);
        AppMethodBeat.o(255500);
    }
}
