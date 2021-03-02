package com.tencent.mm.plugin.finder.convert;

import android.arch.lifecycle.LifecycleOwner;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.convert.l;
import com.tencent.mm.plugin.finder.life.UILifecycleObserver;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u000b"}, hxF = {"com/tencent/mm/plugin/finder/convert/FinderFeedConvert$uiLifecycleObserver$1", "Lcom/tencent/mm/plugin/finder/life/UILifecycleObserver;", "onCreate", "", "var1", "Landroid/arch/lifecycle/LifecycleOwner;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "plugin-finder_release"})
public final class FinderFeedConvert$uiLifecycleObserver$1 implements UILifecycleObserver {
    final /* synthetic */ l tAp;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    FinderFeedConvert$uiLifecycleObserver$1(l lVar) {
        this.tAp = lVar;
    }

    @Override // com.tencent.mm.plugin.finder.life.UILifecycleObserver
    public final void onCreate(LifecycleOwner lifecycleOwner) {
        AppMethodBeat.i(165380);
        p.h(lifecycleOwner, "var1");
        AppMethodBeat.o(165380);
    }

    @Override // com.tencent.mm.plugin.finder.life.UILifecycleObserver
    public final void onStart(LifecycleOwner lifecycleOwner) {
        AppMethodBeat.i(165381);
        p.h(lifecycleOwner, "var1");
        AppMethodBeat.o(165381);
    }

    @Override // com.tencent.mm.plugin.finder.life.UILifecycleObserver
    public final void onResume(LifecycleOwner lifecycleOwner) {
        AppMethodBeat.i(165382);
        p.h(lifecycleOwner, "var1");
        AppMethodBeat.o(165382);
    }

    @Override // com.tencent.mm.plugin.finder.life.UILifecycleObserver
    public final void onPause(LifecycleOwner lifecycleOwner) {
        AppMethodBeat.i(165383);
        p.h(lifecycleOwner, "var1");
        AppMethodBeat.o(165383);
    }

    @Override // com.tencent.mm.plugin.finder.life.UILifecycleObserver
    public final void onStop(LifecycleOwner lifecycleOwner) {
        AppMethodBeat.i(165384);
        p.h(lifecycleOwner, "var1");
        AppMethodBeat.o(165384);
    }

    @Override // com.tencent.mm.plugin.finder.life.UILifecycleObserver
    public final void onDestroy(LifecycleOwner lifecycleOwner) {
        AppMethodBeat.i(165385);
        p.h(lifecycleOwner, "var1");
        for (l.b bVar : this.tAp.tAb) {
            bVar.dead();
        }
        this.tAp.tAb.clear();
        AppMethodBeat.o(165385);
    }
}
