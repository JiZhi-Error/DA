package com.tencent.mm.plugin.topstory.ui.widget;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ae;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;

public abstract class f extends RecyclerView.j {
    private final RecyclerView.l asS = new RecyclerView.l() {
        /* class com.tencent.mm.plugin.topstory.ui.widget.f.AnonymousClass1 */
        boolean awK = false;

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(126674);
            b bVar = new b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            a.b("com/tencent/mm/plugin/topstory/ui/widget/TopStoryVideoSnapHelper$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 0 && this.awK) {
                this.awK = false;
                f.this.mz();
            }
            a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/TopStoryVideoSnapHelper$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(126674);
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(236420);
            b bVar = new b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            a.b("com/tencent/mm/plugin/topstory/ui/widget/TopStoryVideoSnapHelper$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            if (!(i2 == 0 && i3 == 0)) {
                this.awK = true;
            }
            a.a(this, "com/tencent/mm/plugin/topstory/ui/widget/TopStoryVideoSnapHelper$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(236420);
        }
    };
    protected Scroller awJ;
    public RecyclerView mRecyclerView;

    public abstract int a(RecyclerView.LayoutManager layoutManager, int i2, int i3);

    public abstract View a(RecyclerView.LayoutManager layoutManager);

    public abstract int[] a(RecyclerView.LayoutManager layoutManager, View view);

    @Override // android.support.v7.widget.RecyclerView.j
    public final boolean av(int i2, int i3) {
        boolean z;
        RecyclerView.LayoutManager layoutManager = this.mRecyclerView.getLayoutManager();
        if (layoutManager == null || this.mRecyclerView.getAdapter() == null) {
            return false;
        }
        int minFlingVelocity = this.mRecyclerView.getMinFlingVelocity();
        if (Math.abs(i3) <= minFlingVelocity && Math.abs(i2) <= minFlingVelocity) {
            return false;
        }
        if (!(layoutManager instanceof RecyclerView.r.b)) {
            z = false;
        } else {
            ae f2 = f(layoutManager);
            if (f2 == null) {
                z = false;
            } else {
                int a2 = a(layoutManager, i2, i3);
                if (a2 == -1) {
                    z = false;
                } else {
                    f2.atO = a2;
                    layoutManager.startSmoothScroll(f2);
                    z = true;
                }
            }
        }
        return z;
    }

    public final void f(RecyclerView recyclerView) {
        if (this.mRecyclerView != recyclerView) {
            if (this.mRecyclerView != null) {
                this.mRecyclerView.b(this.asS);
                this.mRecyclerView.setOnFlingListener(null);
            }
            this.mRecyclerView = recyclerView;
            if (this.mRecyclerView == null) {
                return;
            }
            if (this.mRecyclerView.getOnFlingListener() != null) {
                throw new IllegalStateException("An instance of OnFlingListener already set.");
            }
            this.mRecyclerView.a(this.asS);
            this.mRecyclerView.setOnFlingListener(this);
            this.awJ = new Scroller(this.mRecyclerView.getContext(), new DecelerateInterpolator());
            mz();
        }
    }

    /* access modifiers changed from: package-private */
    public final void mz() {
        RecyclerView.LayoutManager layoutManager;
        View a2;
        if (this.mRecyclerView != null && (layoutManager = this.mRecyclerView.getLayoutManager()) != null && (a2 = a(layoutManager)) != null) {
            int[] a3 = a(layoutManager, a2);
            if (a3[0] != 0 || a3[1] != 0) {
                this.mRecyclerView.a(a3[0], a3[1], (Interpolator) null);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public ae f(RecyclerView.LayoutManager layoutManager) {
        if (!(layoutManager instanceof RecyclerView.r.b)) {
            return null;
        }
        return new ae(this.mRecyclerView.getContext()) {
            /* class com.tencent.mm.plugin.topstory.ui.widget.f.AnonymousClass2 */

            @Override // android.support.v7.widget.ae, android.support.v7.widget.RecyclerView.r
            public final void a(View view, RecyclerView.s sVar, RecyclerView.r.a aVar) {
                AppMethodBeat.i(126675);
                if (f.this.mRecyclerView == null) {
                    AppMethodBeat.o(126675);
                    return;
                }
                int[] a2 = f.this.a(f.this.mRecyclerView.getLayoutManager(), view);
                int i2 = a2[0];
                int i3 = a2[1];
                int cc = cc(Math.max(Math.abs(i2), Math.abs(i3)));
                if (cc > 0) {
                    aVar.a(i2, i3, cc, this.VQ);
                }
                AppMethodBeat.o(126675);
            }

            @Override // android.support.v7.widget.ae
            public final float a(DisplayMetrics displayMetrics) {
                return 100.0f / ((float) displayMetrics.densityDpi);
            }
        };
    }
}
