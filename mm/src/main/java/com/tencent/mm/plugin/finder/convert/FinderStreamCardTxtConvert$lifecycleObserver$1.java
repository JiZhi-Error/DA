package com.tencent.mm.plugin.finder.convert;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.ah;
import com.tencent.mm.plugin.finder.report.t;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/finder/convert/FinderStreamCardTxtConvert$lifecycleObserver$1", "Landroid/arch/lifecycle/LifecycleObserver;", "onPause", "", "plugin-finder_release"})
public final class FinderStreamCardTxtConvert$lifecycleObserver$1 implements LifecycleObserver {
    final /* synthetic */ ci tGW;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    FinderStreamCardTxtConvert$lifecycleObserver$1(ci ciVar) {
        this.tGW = ciVar;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        AppMethodBeat.i(243336);
        View view = this.tGW.aus;
        if (view != null) {
            View view2 = this.tGW.tGP;
            if ((view2 != null ? view2.getHeight() : 0) > 0 && ci.a(this.tGW, view)) {
                Object tag = view.getTag();
                if (!(tag instanceof ah)) {
                    tag = null;
                }
                ah ahVar = (ah) tag;
                if (ahVar != null && this.tGW.tGS) {
                    t tVar = t.vhJ;
                    t.a(ahVar.tQV, ahVar.tQW, ahVar.position, ahVar.tQX, "", ci.b(this.tGW));
                }
                this.tGW.tGS = true;
            }
            AppMethodBeat.o(243336);
            return;
        }
        AppMethodBeat.o(243336);
    }
}
