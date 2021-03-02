package com.tencent.mm.plugin.festival.finder;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.live.c.b;
import com.tencent.mm.plugin.festival.model.e;
import com.tencent.mm.plugin.finder.live.plugin.d;
import com.tencent.mm.plugin.finder.report.live.m;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u001a\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/festival/finder/FestivalFinderLiveVisitorClosePlugin;", "Lcom/tencent/mm/plugin/festival/finder/FestivalFinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "closeBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "canClearScreen", "", "resume", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-festival_release"})
public final class ay extends p {
    final b hOy;
    private final View hRd;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ay(ViewGroup viewGroup, b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statueMonitor");
        AppMethodBeat.i(262595);
        this.hOy = bVar;
        this.hRd = viewGroup.findViewById(R.id.end);
        rg(8);
        this.hRd.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.plugin.festival.finder.ay.AnonymousClass1 */
            final /* synthetic */ ay UuI;

            {
                this.UuI = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(262591);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/festival/finder/FestivalFinderLiveVisitorClosePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                b.C0376b.a(this.UuI.hOy, b.c.hLC);
                m.vli.a(s.at.CloseTypeFull);
                e.a aVar = e.UxL;
                e.a.gFm();
                a.a(this, "com/tencent/mm/plugin/festival/finder/FestivalFinderLiveVisitorClosePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(262591);
            }
        });
        if (viewGroup.getLayoutParams() != null && (viewGroup.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && isLandscape()) {
            switch (getCurrentOrientation()) {
                case 1:
                    ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                    if (layoutParams != null) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).setMarginEnd(au.aD(viewGroup.getContext()));
                        break;
                    } else {
                        t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                        AppMethodBeat.o(262595);
                        throw tVar;
                    }
                case 3:
                    ViewGroup.LayoutParams layoutParams2 = viewGroup.getLayoutParams();
                    if (layoutParams2 != null) {
                        ((ViewGroup.MarginLayoutParams) layoutParams2).setMarginEnd(at.fromDPToPix(viewGroup.getContext(), 16));
                        break;
                    } else {
                        t tVar2 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                        AppMethodBeat.o(262595);
                        throw tVar2;
                    }
            }
        }
        com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
        com.tencent.mm.plugin.finder.utils.m.a((d) this, false);
        com.tencent.mm.plugin.finder.utils.m mVar2 = com.tencent.mm.plugin.finder.utils.m.vVH;
        com.tencent.mm.plugin.finder.utils.m.a(this);
        AppMethodBeat.o(262595);
    }

    @Override // com.tencent.mm.live.c.a
    public final void resume() {
        AppMethodBeat.i(262593);
        super.resume();
        AppMethodBeat.o(262593);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final boolean dgK() {
        return true;
    }

    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        AppMethodBeat.i(262594);
        p.h(cVar, "status");
        switch (az.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
                rg(8);
                AppMethodBeat.o(262594);
                return;
            case 4:
                com.tencent.mm.plugin.finder.utils.m mVar = com.tencent.mm.plugin.finder.utils.m.vVH;
                com.tencent.mm.plugin.finder.utils.m.a((d) this, false);
                break;
        }
        AppMethodBeat.o(262594);
    }
}
