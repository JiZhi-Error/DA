package android.support.v7.widget;

import android.graphics.PointF;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class af extends at {
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
    public int a(RecyclerView.LayoutManager layoutManager, int i2, int i3) {
        int i4;
        int i5;
        if (!(layoutManager instanceof RecyclerView.r.b)) {
            return -1;
        }
        int itemCount = layoutManager.getItemCount();
        if (itemCount == 0) {
            return -1;
        }
        View a2 = a(layoutManager);
        if (a2 == null) {
            return -1;
        }
        int position = layoutManager.getPosition(a2);
        if (position == -1) {
            return -1;
        }
        PointF bZ = ((RecyclerView.r.b) layoutManager).bZ(itemCount - 1);
        if (bZ == null) {
            return -1;
        }
        if (layoutManager.canScrollHorizontally()) {
            i4 = a(layoutManager, c(layoutManager), i2, 0);
            if (bZ.x < 0.0f) {
                i4 = -i4;
            }
        } else {
            i4 = 0;
        }
        if (layoutManager.canScrollVertically()) {
            i5 = a(layoutManager, b(layoutManager), 0, i3);
            if (bZ.y < 0.0f) {
                i5 = -i5;
            }
        } else {
            i5 = 0;
        }
        if (!layoutManager.canScrollVertically()) {
            i5 = i4;
        }
        if (i5 == 0) {
            return -1;
        }
        int i6 = position + i5;
        if (i6 < 0) {
            i6 = 0;
        }
        if (i6 >= itemCount) {
            return itemCount - 1;
        }
        return i6;
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

    private int a(RecyclerView.LayoutManager layoutManager, aj ajVar, int i2, int i3) {
        int[] aC = aC(i2, i3);
        float b2 = b(layoutManager, ajVar);
        if (b2 <= 0.0f) {
            return 0;
        }
        return Math.round(((float) (Math.abs(aC[0]) > Math.abs(aC[1]) ? aC[0] : aC[1])) / b2);
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

    private static float b(RecyclerView.LayoutManager layoutManager, aj ajVar) {
        int i2 = Integer.MAX_VALUE;
        int i3 = Integer.MIN_VALUE;
        int childCount = layoutManager.getChildCount();
        if (childCount == 0) {
            return 1.0f;
        }
        int i4 = 0;
        View view = null;
        View view2 = null;
        while (i4 < childCount) {
            View childAt = layoutManager.getChildAt(i4);
            int position = layoutManager.getPosition(childAt);
            if (position != -1) {
                if (position < i2) {
                    i2 = position;
                    view2 = childAt;
                }
                if (position > i3) {
                    i4++;
                    i3 = position;
                    view = childAt;
                }
            }
            position = i3;
            childAt = view;
            i4++;
            i3 = position;
            view = childAt;
        }
        if (view2 == null || view == null) {
            return 1.0f;
        }
        int max = Math.max(ajVar.bp(view2), ajVar.bp(view)) - Math.min(ajVar.bo(view2), ajVar.bo(view));
        if (max == 0) {
            return 1.0f;
        }
        return (((float) max) * 1.0f) / ((float) ((i3 - i2) + 1));
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
