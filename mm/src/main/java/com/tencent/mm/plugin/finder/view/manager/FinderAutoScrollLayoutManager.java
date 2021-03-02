package com.tencent.mm.plugin.finder.view.manager;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ae;
import android.util.DisplayMetrics;
import android.view.View;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016¨\u0006\u000e"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/manager/FinderAutoScrollLayoutManager;", "Landroid/support/v7/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "smoothScrollToPosition", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "position", "", "Companion", "plugin-finder_release"})
public final class FinderAutoScrollLayoutManager extends LinearLayoutManager {
    public static final a wsO = new a((byte) 0);

    static {
        AppMethodBeat.i(255258);
        AppMethodBeat.o(255258);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/manager/FinderAutoScrollLayoutManager$Companion;", "", "()V", "DURATION_PER_SCREEN", "", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public FinderAutoScrollLayoutManager(Context context) {
        p.h(context, "context");
        AppMethodBeat.i(255257);
        AppMethodBeat.o(255257);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00009\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003H\u0014J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0014¨\u0006\u0017"}, hxF = {"com/tencent/mm/plugin/finder/view/manager/FinderAutoScrollLayoutManager$smoothScrollToPosition$linearSmoothScroller$1", "Landroid/support/v7/widget/LinearSmoothScroller;", "calculateDtToFit", "", "viewStart", "viewEnd", "boxStart", "boxEnd", "snapPreference", "calculateSpeedPerPixel", "", "displayMetrics", "Landroid/util/DisplayMetrics;", "calculateTimeForDeceleration", "dx", "onTargetFound", "", "targetView", "Landroid/view/View;", "state", "Landroid/support/v7/widget/RecyclerView$State;", NativeProtocol.WEB_DIALOG_ACTION, "Landroid/support/v7/widget/RecyclerView$SmoothScroller$Action;", "plugin-finder_release"})
    public static final class b extends ae {
        final /* synthetic */ RecyclerView tDJ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(RecyclerView recyclerView, Context context) {
            super(context);
            this.tDJ = recyclerView;
        }

        @Override // android.support.v7.widget.ae
        public final float a(DisplayMetrics displayMetrics) {
            AppMethodBeat.i(255253);
            p.h(displayMetrics, "displayMetrics");
            float f2 = 4000.0f / ((float) displayMetrics.widthPixels);
            AppMethodBeat.o(255253);
            return f2;
        }

        @Override // android.support.v7.widget.ae
        public final int cc(int i2) {
            AppMethodBeat.i(255254);
            int cd = cd(i2);
            AppMethodBeat.o(255254);
            return cd;
        }

        @Override // android.support.v7.widget.ae, android.support.v7.widget.RecyclerView.r
        public final void a(View view, RecyclerView.s sVar, RecyclerView.r.a aVar) {
            AppMethodBeat.i(255255);
            p.h(view, "targetView");
            p.h(sVar, "state");
            p.h(aVar, NativeProtocol.WEB_DIALOG_ACTION);
            int F = F(view, kz());
            int E = E(view, kA());
            int cd = cd((int) Math.sqrt(((double) (F * F)) + (((double) E) * ((double) E))));
            if (cd > 0) {
                aVar.a(-F, -E, cd, this.aqS);
            }
            AppMethodBeat.o(255255);
        }

        @Override // android.support.v7.widget.ae
        public final int f(int i2, int i3, int i4, int i5, int i6) {
            return i5 - i3;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView.s sVar, int i2) {
        Context context;
        AppMethodBeat.i(255256);
        if (recyclerView != null) {
            context = recyclerView.getContext();
        } else {
            context = null;
        }
        b bVar = new b(recyclerView, context);
        if (i2 >= 0) {
            bVar.ct(i2);
            startSmoothScroll(bVar);
            AppMethodBeat.o(255256);
            return;
        }
        Log.e("Finder.AutoScrollLayoutManager", "Invalid target position");
        AppMethodBeat.o(255256);
    }
}
