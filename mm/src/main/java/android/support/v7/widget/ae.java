package android.support.v7.widget;

import android.content.Context;
import android.graphics.PointF;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;

public class ae extends RecyclerView.r {
    protected final DecelerateInterpolator VQ = new DecelerateInterpolator();
    protected final LinearInterpolator aqS = new LinearInterpolator();
    protected PointF aqT;
    private final float aqU;
    protected int aqV = 0;
    protected int aqW = 0;

    public ae(Context context) {
        this.aqU = a(context.getResources().getDisplayMetrics());
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.widget.RecyclerView.r
    public void a(View view, RecyclerView.s sVar, RecyclerView.r.a aVar) {
        int F = F(view, kz());
        int E = E(view, kA());
        int cc = cc((int) Math.sqrt((double) ((F * F) + (E * E))));
        if (cc > 0) {
            aVar.a(-F, -E, cc, this.VQ);
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.widget.RecyclerView.r
    public final void a(int i2, int i3, RecyclerView.r.a aVar) {
        if (this.mRecyclerView.asc.getChildCount() == 0) {
            stop();
            return;
        }
        this.aqV = aj(this.aqV, i2);
        this.aqW = aj(this.aqW, i3);
        if (this.aqV == 0 && this.aqW == 0) {
            PointF bZ = bZ(this.atO);
            if (bZ == null || (bZ.x == 0.0f && bZ.y == 0.0f)) {
                aVar.atV = this.atO;
                stop();
                return;
            }
            float sqrt = (float) Math.sqrt((double) ((bZ.x * bZ.x) + (bZ.y * bZ.y)));
            bZ.x /= sqrt;
            bZ.y /= sqrt;
            this.aqT = bZ;
            this.aqV = (int) (bZ.x * 10000.0f);
            this.aqW = (int) (bZ.y * 10000.0f);
            aVar.a((int) (((float) this.aqV) * 1.2f), (int) (((float) this.aqW) * 1.2f), (int) (((float) cd(10000)) * 1.2f), this.aqS);
        }
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.widget.RecyclerView.r
    public void onStop() {
        this.aqW = 0;
        this.aqV = 0;
        this.aqT = null;
    }

    /* access modifiers changed from: protected */
    public float a(DisplayMetrics displayMetrics) {
        return 25.0f / ((float) displayMetrics.densityDpi);
    }

    /* access modifiers changed from: protected */
    public int cc(int i2) {
        return (int) Math.ceil(((double) cd(i2)) / 0.3356d);
    }

    /* access modifiers changed from: protected */
    public int cd(int i2) {
        return (int) Math.ceil((double) (((float) Math.abs(i2)) * this.aqU));
    }

    /* access modifiers changed from: protected */
    public int kz() {
        if (this.aqT == null || this.aqT.x == 0.0f) {
            return 0;
        }
        return this.aqT.x > 0.0f ? 1 : -1;
    }

    /* access modifiers changed from: protected */
    public int kA() {
        if (this.aqT == null || this.aqT.y == 0.0f) {
            return 0;
        }
        return this.aqT.y > 0.0f ? 1 : -1;
    }

    private static int aj(int i2, int i3) {
        int i4 = i2 - i3;
        if (i2 * i4 <= 0) {
            return 0;
        }
        return i4;
    }

    public int f(int i2, int i3, int i4, int i5, int i6) {
        switch (i6) {
            case -1:
                return i4 - i2;
            case 0:
                int i7 = i4 - i2;
                if (i7 > 0) {
                    return i7;
                }
                int i8 = i5 - i3;
                if (i8 >= 0) {
                    return 0;
                }
                return i8;
            case 1:
                return i5 - i3;
            default:
                throw new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
        }
    }

    public int E(View view, int i2) {
        RecyclerView.LayoutManager layoutManager = this.arI;
        if (layoutManager == null || !layoutManager.canScrollVertically()) {
            return 0;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        return f(layoutManager.getDecoratedTop(view) - layoutParams.topMargin, layoutManager.getDecoratedBottom(view) + layoutParams.bottomMargin, layoutManager.getPaddingTop(), layoutManager.getHeight() - layoutManager.getPaddingBottom(), i2);
    }

    public int F(View view, int i2) {
        RecyclerView.LayoutManager layoutManager = this.arI;
        if (layoutManager == null || !layoutManager.canScrollHorizontally()) {
            return 0;
        }
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
        return f(layoutManager.getDecoratedLeft(view) - layoutParams.leftMargin, layoutManager.getDecoratedRight(view) + layoutParams.rightMargin, layoutManager.getPaddingLeft(), layoutManager.getWidth() - layoutManager.getPaddingRight(), i2);
    }
}
