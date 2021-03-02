package com.tencent.mm.plugin.finder.live.plugin;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.live.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.au;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u0011\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012¢\u0006\u0002\u0010\u0014J\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \r*\u0004\u0018\u00010\f0\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShadowPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "shadowDown", "Landroid/view/View;", "kotlin.jvm.PlatformType", "shadowUp", "canClearScreen", "", "getShadowRects", "", "Landroid/graphics/Rect;", "()[Landroid/graphics/Rect;", "statusChange", "", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "Companion", "plugin-finder_release"})
public final class bb extends d {
    public static final a utA = new a((byte) 0);
    private static final double uty = uty;
    private static final double utz = utz;
    private final String TAG = "FinderLiveShadowPlugin";
    private final b hOy;
    private final View hSu;
    private final View hSv;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public bb(ViewGroup viewGroup, b bVar) {
        super(viewGroup, bVar);
        p.h(viewGroup, "root");
        p.h(bVar, "statueMonitor");
        AppMethodBeat.i(246968);
        this.hOy = bVar;
        this.hSu = viewGroup.findViewById(R.id.elj);
        this.hSv = viewGroup.findViewById(R.id.ell);
        if (!isLandscape()) {
            View view = this.hSu;
            p.g(view, "shadowDown");
            view.getLayoutParams().height += au.aD(viewGroup.getContext());
            AppMethodBeat.o(246968);
            return;
        }
        int i2 = au.az(viewGroup.getContext()).y;
        View view2 = this.hSu;
        p.g(view2, "shadowDown");
        view2.getLayoutParams().height = (int) (((double) i2) * uty);
        View view3 = this.hSv;
        p.g(view3, "shadowUp");
        view3.getLayoutParams().height = (int) (((double) i2) * utz);
        String str = this.TAG;
        StringBuilder append = new StringBuilder("screenHeight:").append(i2).append(",shadowDown.height:");
        View view4 = this.hSu;
        p.g(view4, "shadowDown");
        StringBuilder append2 = append.append(view4.getLayoutParams().height).append(",shadowUp.height:");
        View view5 = this.hSv;
        p.g(view5, "shadowUp");
        Log.i(str, append2.append(view5.getLayoutParams().height).toString());
        AppMethodBeat.o(246968);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveShadowPlugin$Companion;", "", "()V", "LANDSCAPE_SHADOW_DOWN_HEIGHT_PERCENT", "", "getLANDSCAPE_SHADOW_DOWN_HEIGHT_PERCENT", "()D", "LANDSCAPE_SHADOW_UP_HEIGHT_PERCENT", "getLANDSCAPE_SHADOW_UP_HEIGHT_PERCENT", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(246969);
        AppMethodBeat.o(246969);
    }

    @Override // com.tencent.mm.plugin.finder.live.plugin.d
    public final boolean dgK() {
        return true;
    }

    @Override // com.tencent.mm.live.c.a
    public final void statusChange(b.c cVar, Bundle bundle) {
        AppMethodBeat.i(246967);
        p.h(cVar, "status");
        switch (bc.$EnumSwitchMapping$0[cVar.ordinal()]) {
            case 1:
            case 2:
            case 3:
                rg(4);
                AppMethodBeat.o(246967);
                return;
            case 4:
                if (this.hOy.getLiveRole() != 1) {
                    rg(4);
                    AppMethodBeat.o(246967);
                    return;
                }
                break;
            case 5:
                rg(0);
                break;
        }
        AppMethodBeat.o(246967);
    }
}
