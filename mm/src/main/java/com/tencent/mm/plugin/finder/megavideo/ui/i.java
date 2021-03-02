package com.tencent.mm.plugin.finder.megavideo.ui;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ak;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.b;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\"\u0010\u0013\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0016R7\u0010\u0003\u001a\u001f\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/ui/MegaVideoPagerSnapHelper;", "Landroid/support/v7/widget/PagerSnapHelper;", "()V", "onPageSelectedListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "position", "", "getOnPageSelectedListener", "()Lkotlin/jvm/functions/Function1;", "setOnPageSelectedListener", "(Lkotlin/jvm/functions/Function1;)V", "targetSnapPos", "findSnapView", "Landroid/view/View;", "layoutManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "findTargetSnapPosition", "velocityX", "velocityY", "Companion", "plugin-finder_release"})
public final class i extends ak {
    public static final a uMC = new a((byte) 0);
    private int uMA = -1;
    b<? super Integer, x> uMB;

    static {
        AppMethodBeat.i(248601);
        AppMethodBeat.o(248601);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/megavideo/ui/MegaVideoPagerSnapHelper$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // android.support.v7.widget.at, android.support.v7.widget.ak
    public final int a(RecyclerView.LayoutManager layoutManager, int i2, int i3) {
        AppMethodBeat.i(248599);
        int a2 = super.a(layoutManager, i2, i3);
        this.uMA = a2;
        b<? super Integer, x> bVar = this.uMB;
        if (bVar != null) {
            bVar.invoke(Integer.valueOf(a2));
        }
        Log.i("MegaVideoPagerSnapHelper", "findTargetSnapPosition: targetSnapPos = " + this.uMA);
        AppMethodBeat.o(248599);
        return a2;
    }

    @Override // android.support.v7.widget.at, android.support.v7.widget.ak
    public final View a(RecyclerView.LayoutManager layoutManager) {
        b<? super Integer, x> bVar;
        AppMethodBeat.i(248600);
        View a2 = super.a(layoutManager);
        ViewGroup.LayoutParams layoutParams = a2 != null ? a2.getLayoutParams() : null;
        if (!(layoutParams instanceof RecyclerView.LayoutParams)) {
            layoutParams = null;
        }
        RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
        int lG = layoutParams2 != null ? layoutParams2.lG() : -1;
        Log.i("MegaVideoPagerSnapHelper", "findSnapView: targetPos = ".concat(String.valueOf(lG)));
        if (this.uMA == -1 && (bVar = this.uMB) != null) {
            bVar.invoke(Integer.valueOf(lG));
        }
        this.uMA = -1;
        AppMethodBeat.o(248600);
        return a2;
    }
}
