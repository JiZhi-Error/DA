package android.support.v7.widget;

import android.graphics.PointF;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;

public class ak extends at {
    private aj aqX;
    private aj aqY;

    @Override // android.support.v7.widget.at
    public int[] a(RecyclerView.LayoutManager layoutManager, View view) {
        int[] iArr = new int[2];
        if (layoutManager.canScrollHorizontally()) {
            iArr[0] = a(layoutManager, view, c(layoutManager));
        } else {
            iArr[0] = 0;
        }
        if (layoutManager.canScrollVertically()) {
            iArr[1] = a(layoutManager, view, b(layoutManager));
        } else {
            iArr[1] = 0;
        }
        return iArr;
    }

    @Override // android.support.v7.widget.at
    public View a(RecyclerView.LayoutManager layoutManager) {
        if (layoutManager.canScrollVertically()) {
            return a(layoutManager, b(layoutManager));
        }
        if (layoutManager.canScrollHorizontally()) {
            return a(layoutManager, c(layoutManager));
        }
        return null;
    }

    @Override // android.support.v7.widget.at
    public int a(RecyclerView.LayoutManager layoutManager, int i2, int i3) {
        int position;
        boolean z;
        PointF bZ;
        boolean z2 = false;
        int itemCount = layoutManager.getItemCount();
        if (itemCount == 0) {
            return -1;
        }
        View view = null;
        if (layoutManager.canScrollVertically()) {
            view = c(layoutManager, b(layoutManager));
        } else if (layoutManager.canScrollHorizontally()) {
            view = c(layoutManager, c(layoutManager));
        }
        if (view == null || (position = layoutManager.getPosition(view)) == -1) {
            return -1;
        }
        if (layoutManager.canScrollHorizontally()) {
            z = i2 > 0;
        } else {
            z = i3 > 0;
        }
        if ((layoutManager instanceof RecyclerView.r.b) && (bZ = ((RecyclerView.r.b) layoutManager).bZ(itemCount - 1)) != null && (bZ.x < 0.0f || bZ.y < 0.0f)) {
            z2 = true;
        }
        if (!z2) {
            return z ? position + 1 : position;
        }
        if (z) {
            return position - 1;
        }
        return position;
    }

    /* access modifiers changed from: protected */
    @Override // android.support.v7.widget.at
    public final ae f(RecyclerView.LayoutManager layoutManager) {
        if (!(layoutManager instanceof RecyclerView.r.b)) {
            return null;
        }
        return new ae(this.mRecyclerView.getContext()) {
            /* class android.support.v7.widget.ak.AnonymousClass1 */

            /* access modifiers changed from: protected */
            @Override // android.support.v7.widget.ae, android.support.v7.widget.RecyclerView.r
            public final void a(View view, RecyclerView.s sVar, RecyclerView.r.a aVar) {
                int[] a2 = ak.this.a(ak.this.mRecyclerView.getLayoutManager(), view);
                int i2 = a2[0];
                int i3 = a2[1];
                int cc = cc(Math.max(Math.abs(i2), Math.abs(i3)));
                if (cc > 0) {
                    aVar.a(i2, i3, cc, this.VQ);
                }
            }

            /* access modifiers changed from: protected */
            @Override // android.support.v7.widget.ae
            public final float a(DisplayMetrics displayMetrics) {
                return 100.0f / ((float) displayMetrics.densityDpi);
            }

            /* access modifiers changed from: protected */
            @Override // android.support.v7.widget.ae
            public final int cd(int i2) {
                return Math.min(100, super.cd(i2));
            }
        };
    }

    private static int a(RecyclerView.LayoutManager layoutManager, View view, aj ajVar) {
        int end;
        int bs = (ajVar.bs(view) / 2) + ajVar.bo(view);
        if (layoutManager.getClipToPadding()) {
            end = ajVar.kH() + (ajVar.kJ() / 2);
        } else {
            end = ajVar.getEnd() / 2;
        }
        return bs - end;
    }

    private static View a(RecyclerView.LayoutManager layoutManager, aj ajVar) {
        int end;
        View view = null;
        int childCount = layoutManager.getChildCount();
        if (childCount != 0) {
            if (layoutManager.getClipToPadding()) {
                end = ajVar.kH() + (ajVar.kJ() / 2);
            } else {
                end = ajVar.getEnd() / 2;
            }
            int i2 = Integer.MAX_VALUE;
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = layoutManager.getChildAt(i3);
                int abs = Math.abs((ajVar.bo(childAt) + (ajVar.bs(childAt) / 2)) - end);
                if (abs >= i2) {
                    abs = i2;
                    childAt = view;
                }
                i3++;
                i2 = abs;
                view = childAt;
            }
        }
        return view;
    }

    private static View c(RecyclerView.LayoutManager layoutManager, aj ajVar) {
        View view = null;
        int childCount = layoutManager.getChildCount();
        if (childCount != 0) {
            int i2 = Integer.MAX_VALUE;
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = layoutManager.getChildAt(i3);
                int bo = ajVar.bo(childAt);
                if (bo >= i2) {
                    bo = i2;
                    childAt = view;
                }
                i3++;
                i2 = bo;
                view = childAt;
            }
        }
        return view;
    }

    private aj b(RecyclerView.LayoutManager layoutManager) {
        if (this.aqX == null || this.aqX.arI != layoutManager) {
            this.aqX = aj.e(layoutManager);
        }
        return this.aqX;
    }

    private aj c(RecyclerView.LayoutManager layoutManager) {
        if (this.aqY == null || this.aqY.arI != layoutManager) {
            this.aqY = aj.d(layoutManager);
        }
        return this.aqY;
    }
}
