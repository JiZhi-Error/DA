package com.tencent.mm.live.c;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.live.c.b;
import com.tencent.mm.ui.at;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R$\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, hxF = {"Lcom/tencent/mm/live/plugin/LiveVisitorClosePlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "closeBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "value", "", "mNavigatorHeight", "getMNavigatorHeight", "()I", "setMNavigatorHeight", "(I)V", "resume", "", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class be extends a {
    private int hOw;
    final b hOy;
    private final View hRd;

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public be(ViewGroup viewGroup, b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statueMonitor");
        AppMethodBeat.i(208211);
        this.hOy = bVar;
        this.hRd = viewGroup.findViewById(R.id.end);
        this.hOw = au.aD(viewGroup.getContext());
        this.hRd.setOnClickListener(new View.OnClickListener(this) {
            /* class com.tencent.mm.live.c.be.AnonymousClass1 */
            final /* synthetic */ be hSU;

            {
                this.hSU = r1;
            }

            public final void onClick(View view) {
                AppMethodBeat.i(208207);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/live/plugin/LiveVisitorClosePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                b.C0376b.a(this.hSU.hOy, b.c.hLC);
                a.a(this, "com/tencent/mm/live/plugin/LiveVisitorClosePlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(208207);
            }
        });
        if (viewGroup.getLayoutParams() != null && (viewGroup.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && isLandscape()) {
            switch (getCurrentOrientation()) {
                case 1:
                    ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
                    if (layoutParams == null) {
                        t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                        AppMethodBeat.o(208211);
                        throw tVar;
                    }
                    ((ViewGroup.MarginLayoutParams) layoutParams).setMarginEnd(au.aD(viewGroup.getContext()));
                    AppMethodBeat.o(208211);
                    return;
                case 3:
                    ViewGroup.LayoutParams layoutParams2 = viewGroup.getLayoutParams();
                    if (layoutParams2 != null) {
                        ((ViewGroup.MarginLayoutParams) layoutParams2).setMarginEnd(at.fromDPToPix(viewGroup.getContext(), 16));
                        break;
                    } else {
                        t tVar2 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                        AppMethodBeat.o(208211);
                        throw tVar2;
                    }
            }
        }
        AppMethodBeat.o(208211);
    }

    @Override // com.tencent.mm.live.c.a
    public final void resume() {
        AppMethodBeat.i(208209);
        super.resume();
        int aD = au.aD(this.hwr.getContext());
        if (aD == 0) {
            aD = at.fromDPToPix(this.hwr.getContext(), 16);
        }
        this.hOw = aD;
        AppMethodBeat.o(208209);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        AppMethodBeat.i(208210);
        p.h(cVar, "status");
        switch (bf.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
                rg(8);
                AppMethodBeat.o(208210);
                return;
            case 4:
                rg(0);
                AppMethodBeat.o(208210);
                return;
            case 5:
                if (this.hOy.getLiveRole() == 0) {
                    if (bundle == null || !bundle.getBoolean("PARAM_IS_ENTERING_COMMENT")) {
                        rg(0);
                        AppMethodBeat.o(208210);
                        return;
                    }
                    rg(4);
                    AppMethodBeat.o(208210);
                    return;
                }
                break;
            case 6:
                if (this.hwr.getLayoutParams() != null && (this.hwr.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
                    switch (getCurrentOrientation()) {
                        case 1:
                            ViewGroup.LayoutParams layoutParams = this.hwr.getLayoutParams();
                            if (layoutParams != null) {
                                ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = this.hOw;
                                this.hwr.requestLayout();
                                break;
                            } else {
                                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                                AppMethodBeat.o(208210);
                                throw tVar;
                            }
                        case 3:
                            ViewGroup.LayoutParams layoutParams2 = this.hwr.getLayoutParams();
                            if (layoutParams2 == null) {
                                t tVar2 = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                                AppMethodBeat.o(208210);
                                throw tVar2;
                            }
                            ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin = at.fromDPToPix(this.hwr.getContext(), 16);
                            this.hwr.requestLayout();
                            AppMethodBeat.o(208210);
                            return;
                    }
                }
                break;
        }
        AppMethodBeat.o(208210);
    }
}
