package com.tencent.mm.plugin.finder.live.plugin;

import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.c.b;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u0019\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveIdentifyTipPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "identifyView", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "getIdentifyView", "()Landroid/widget/TextView;", "canClearScreen", "", "setVisible", "", "visible", "", "plugin-finder_release"})
public final class ar extends d {
    private final TextView UMu;
    private final b hOp;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ar(ViewGroup viewGroup, b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statusMonitor");
        AppMethodBeat.i(260653);
        this.hOp = bVar;
        this.UMu = (TextView) viewGroup.findViewById(R.id.jz2);
        TextView textView = this.UMu;
        p.g(textView, "identifyView");
        textView.setVisibility(8);
        if (!isLandscape()) {
            ViewGroup.LayoutParams layoutParams = viewGroup.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
                AppMethodBeat.o(260653);
                throw tVar;
            }
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin -= au.aD(viewGroup.getContext());
        }
        AppMethodBeat.o(260653);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final boolean dgK() {
        return true;
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d, com.tencent.mm.live.c.a
    public final void rg(int i2) {
        AppMethodBeat.i(260652);
        super.rg(i2);
        if (i2 == 0) {
            if (getLiveData().UQh.LFy == 1) {
                TextView textView = this.UMu;
                p.g(textView, "identifyView");
                textView.setVisibility(8);
                AppMethodBeat.o(260652);
                return;
            }
            TextView textView2 = this.UMu;
            p.g(textView2, "identifyView");
            textView2.setVisibility(0);
            TextView textView3 = this.UMu;
            p.g(textView3, "identifyView");
            String str = getLiveData().UQh.nickname;
            textView3.setText(str != null ? str : "");
        }
        AppMethodBeat.o(260652);
    }
}
