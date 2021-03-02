package com.tencent.mm.plugin.finder.live.widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.finder.live.model.o;
import com.tencent.mm.plugin.finder.live.model.s;
import com.tencent.mm.plugin.finder.live.plugin.d;
import com.tencent.mm.plugin.finder.model.bo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017R\u000e\u0010\t\u001a\u00020\nXD¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorShoppingEntranceWidget;", "", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "basePlugin", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;)V", "TAG", "", "getBasePlugin", "()Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "getRoot", "()Landroid/view/ViewGroup;", "getStatusMonitor", "()Lcom/tencent/mm/live/plugin/ILiveStatus;", "checkVisible", "", "isVisible", "", "setVisible", "visible", "", "plugin-finder_release"})
public final class c {
    private final String TAG = "Finder.FinderLiveAnchorShoppingEntranceWidget";
    final b hOp;
    public final ViewGroup hwr;
    public final d uFw;

    public c(ViewGroup viewGroup, b bVar, d dVar) {
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        p.h(dVar, "basePlugin");
        AppMethodBeat.i(248030);
        this.hwr = viewGroup;
        this.hOp = bVar;
        this.uFw = dVar;
        this.hwr.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.finder.live.widget.c.AnonymousClass1 */
            final /* synthetic */ c uFE;

            {
                this.uFE = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(248028);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorShoppingEntranceWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                bo boVar = this.uFE.uFw.getLiveData().UPW;
                Bundle bundle = new Bundle();
                if (boVar instanceof com.tencent.mm.plugin.finder.live.view.a.c) {
                    bundle.putLong("PARAM_FINDER_LIVE_BUBBLE_PRODUCTID", ((com.tencent.mm.plugin.finder.live.view.a.c) boVar).uko);
                } else if (boVar instanceof com.tencent.mm.plugin.finder.live.view.a.b) {
                    bundle.putLong("PARAM_FINDER_LIVE_BUBBLE_ADID", ((com.tencent.mm.plugin.finder.live.view.a.b) boVar).UPE);
                }
                this.uFE.hOp.statusChange(b.c.hMZ, bundle);
                a.a(this, "com/tencent/mm/plugin/finder/live/widget/FinderLiveAnchorShoppingEntranceWidget$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(248028);
            }
        });
        AppMethodBeat.o(248030);
    }

    public final void rg(int i2) {
        AppMethodBeat.i(248029);
        if (this.uFw.getLiveData().isLiveStarted() || i2 != 0) {
            this.hwr.setVisibility(i2);
            AppMethodBeat.o(248029);
            return;
        }
        o oVar = o.ujN;
        s finderLiveAssistant = o.getFinderLiveAssistant();
        if (finderLiveAssistant != null) {
            finderLiveAssistant.ag(this.hwr, i2);
            AppMethodBeat.o(248029);
            return;
        }
        AppMethodBeat.o(248029);
    }
}
