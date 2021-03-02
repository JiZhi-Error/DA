package com.tencent.mm.plugin.finder.convert;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.ag;
import com.tencent.mm.plugin.finder.report.t;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0007J\b\u0010\u0004\u001a\u00020\u0003H\u0007¨\u0006\u0005"}, hxF = {"com/tencent/mm/plugin/finder/convert/FinderStreamCardAlbumConvert$lifecycleObserver$1", "Landroid/arch/lifecycle/LifecycleObserver;", "onPause", "", "onResume", "plugin-finder_release"})
public final class FinderStreamCardAlbumConvert$lifecycleObserver$1 implements LifecycleObserver {
    final /* synthetic */ ch tGu;

    /* JADX WARN: Incorrect args count in method signature: ()V */
    FinderStreamCardAlbumConvert$lifecycleObserver$1(ch chVar) {
        this.tGu = chVar;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public final void onPause() {
        ag agVar;
        AppMethodBeat.i(243292);
        View view = this.tGu.aus;
        if (view == null) {
            AppMethodBeat.o(243292);
        } else if (!ch.a(this.tGu, view) || (agVar = this.tGu.tGo.tGs) == null) {
            AppMethodBeat.o(243292);
        } else {
            long currentTimeMillis = System.currentTimeMillis() - this.tGu.tGo.startTimeMs;
            int indexOf = this.tGu.tGq.tRo.getDataListJustForAdapter().indexOf(agVar);
            t tVar = t.vhJ;
            String str = agVar.tQQ.IFO;
            if (str == null) {
                str = "";
            }
            t.a(str, agVar, indexOf, currentTimeMillis, ch.d(this.tGu));
            AppMethodBeat.o(243292);
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public final void onResume() {
        AppMethodBeat.i(243293);
        View view = this.tGu.aus;
        if (view != null) {
            if (ch.a(this.tGu, view)) {
                this.tGu.tGo.startTimeMs = System.currentTimeMillis();
            }
            AppMethodBeat.o(243293);
            return;
        }
        AppMethodBeat.o(243293);
    }
}
