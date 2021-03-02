package android.support.v7.widget;

import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.Scroller;

public abstract class at extends RecyclerView.j {
    private final RecyclerView.l asS = new RecyclerView.l() {
        /* class android.support.v7.widget.at.AnonymousClass1 */
        boolean awK = false;

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            super.onScrollStateChanged(recyclerView, i2);
            if (i2 == 0 && this.awK) {
                this.awK = false;
                at.this.mz();
            }
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            if (i2 != 0 || i3 != 0) {
                this.awK = true;
            }
        }
    };
    private Scroller awJ;
    RecyclerView mRecyclerView;

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
            RecyclerView.r g2 = g(layoutManager);
            if (g2 == null) {
                z = false;
            } else {
                int a2 = a(layoutManager, i2, i3);
                if (a2 == -1) {
                    z = false;
                } else {
                    g2.atO = a2;
                    layoutManager.startSmoothScroll(g2);
                    z = true;
                }
            }
        }
        return z;
    }

    public void f(RecyclerView recyclerView) {
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

    public final int[] aC(int i2, int i3) {
        this.awJ.fling(0, 0, i2, i3, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return new int[]{this.awJ.getFinalX(), this.awJ.getFinalY()};
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
    public RecyclerView.r g(RecyclerView.LayoutManager layoutManager) {
        return f(layoutManager);
    }

    /* access modifiers changed from: protected */
    @Deprecated
    public ae f(RecyclerView.LayoutManager layoutManager) {
        if (!(layoutManager instanceof RecyclerView.r.b)) {
            return null;
        }
        return new ae(this.mRecyclerView.getContext()) {
            /* class android.support.v7.widget.at.AnonymousClass2 */

            /* access modifiers changed from: protected */
            @Override // android.support.v7.widget.ae, android.support.v7.widget.RecyclerView.r
            public final void a(View view, RecyclerView.s sVar, RecyclerView.r.a aVar) {
                if (at.this.mRecyclerView != null) {
                    int[] a2 = at.this.a(at.this.mRecyclerView.getLayoutManager(), view);
                    int i2 = a2[0];
                    int i3 = a2[1];
                    int cc = cc(Math.max(Math.abs(i2), Math.abs(i3)));
                    if (cc > 0) {
                        aVar.a(i2, i3, cc, this.VQ);
                    }
                }
            }

            /* access modifiers changed from: protected */
            @Override // android.support.v7.widget.ae
            public final float a(DisplayMetrics displayMetrics) {
                return 100.0f / ((float) displayMetrics.densityDpi);
            }
        };
    }
}
