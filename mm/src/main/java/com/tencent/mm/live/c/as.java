package com.tencent.mm.live.c;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.c.b;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\u0002\u0010\u000eJ\u001a\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/live/plugin/LiveShadowPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "shadowDown", "Landroid/view/View;", "kotlin.jvm.PlatformType", "shadowUp", "getShadowRects", "", "Landroid/graphics/Rect;", "()[Landroid/graphics/Rect;", "statusChange", "", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class as extends a {
    private final b hOy;
    private final View hSu;
    private final View hSv;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public as(ViewGroup viewGroup, b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statueMonitor");
        AppMethodBeat.i(208155);
        this.hOy = bVar;
        this.hSu = viewGroup.findViewById(R.id.elj);
        this.hSv = viewGroup.findViewById(R.id.ell);
        if (!isLandscape()) {
            View view = this.hSu;
            p.g(view, "shadowDown");
            view.getLayoutParams().height += au.aD(viewGroup.getContext());
        }
        AppMethodBeat.o(208155);
    }

    public final Rect[] aHH() {
        AppMethodBeat.i(208153);
        int[] iArr = new int[2];
        this.hSu.getLocationOnScreen(iArr);
        int i2 = iArr[0];
        int i3 = iArr[1];
        int i4 = iArr[0];
        View view = this.hSu;
        p.g(view, "shadowDown");
        int width = i4 + view.getWidth();
        int i5 = iArr[1];
        View view2 = this.hSu;
        p.g(view2, "shadowDown");
        Rect rect = new Rect(i2, i3, width, i5 + view2.getHeight());
        this.hSv.getLocationOnScreen(iArr);
        int i6 = iArr[0];
        int i7 = iArr[1];
        int i8 = iArr[0];
        View view3 = this.hSv;
        p.g(view3, "shadowUp");
        int width2 = i8 + view3.getWidth();
        int i9 = iArr[1];
        View view4 = this.hSv;
        p.g(view4, "shadowUp");
        Rect[] rectArr = {rect, new Rect(i6, i7, width2, i9 + view4.getHeight())};
        AppMethodBeat.o(208153);
        return rectArr;
    }

    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        AppMethodBeat.i(208154);
        p.h(cVar, "status");
        switch (at.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
                rg(4);
                AppMethodBeat.o(208154);
                return;
            case 4:
                if (this.hOy.getLiveRole() != 1) {
                    rg(4);
                    AppMethodBeat.o(208154);
                    return;
                }
                break;
            case 5:
                rg(0);
                AppMethodBeat.o(208154);
                return;
            case 6:
                if (this.hOy.getLiveRole() == 0) {
                    if (bundle == null || !bundle.getBoolean("PARAM_IS_ENTERING_COMMENT")) {
                        rg(0);
                        break;
                    } else {
                        rg(4);
                        AppMethodBeat.o(208154);
                        return;
                    }
                }
                break;
        }
        AppMethodBeat.o(208154);
    }
}
