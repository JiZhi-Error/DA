package com.tencent.mm.plugin.topstory.ui.video.fs;

import android.graphics.PointF;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ae;
import android.support.v7.widget.aj;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.topstory.ui.widget.f;

public final class b extends f {
    private aj aqX;
    private aj aqY;

    @Override // com.tencent.mm.plugin.topstory.ui.widget.f
    public final int[] a(RecyclerView.LayoutManager layoutManager, View view) {
        AppMethodBeat.i(126236);
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
        AppMethodBeat.o(126236);
        return iArr;
    }

    @Override // com.tencent.mm.plugin.topstory.ui.widget.f
    public final View a(RecyclerView.LayoutManager layoutManager) {
        AppMethodBeat.i(126237);
        if (layoutManager.canScrollVertically()) {
            View a2 = a(layoutManager, b(layoutManager));
            AppMethodBeat.o(126237);
            return a2;
        } else if (layoutManager.canScrollHorizontally()) {
            View a3 = a(layoutManager, c(layoutManager));
            AppMethodBeat.o(126237);
            return a3;
        } else {
            AppMethodBeat.o(126237);
            return null;
        }
    }

    @Override // com.tencent.mm.plugin.topstory.ui.widget.f
    public final int a(RecyclerView.LayoutManager layoutManager, int i2, int i3) {
        boolean z;
        PointF bZ;
        boolean z2 = false;
        AppMethodBeat.i(126238);
        if (Math.abs(i3) <= 500 || Math.abs(i2) >= Math.abs(i3)) {
            AppMethodBeat.o(126238);
            return -1;
        }
        int itemCount = layoutManager.getItemCount();
        if (itemCount == 0) {
            AppMethodBeat.o(126238);
            return -1;
        }
        View view = null;
        if (layoutManager.canScrollVertically()) {
            view = c(layoutManager, b(layoutManager));
        } else if (layoutManager.canScrollHorizontally()) {
            view = c(layoutManager, c(layoutManager));
        }
        if (view == null) {
            AppMethodBeat.o(126238);
            return -1;
        }
        int position = layoutManager.getPosition(view);
        if (position == -1) {
            AppMethodBeat.o(126238);
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
        if (z2) {
            if (z) {
                int i4 = position - 1;
                AppMethodBeat.o(126238);
                return i4;
            }
            AppMethodBeat.o(126238);
            return position;
        } else if (z) {
            int i5 = position + 1;
            AppMethodBeat.o(126238);
            return i5;
        } else {
            AppMethodBeat.o(126238);
            return position;
        }
    }

    @Override // com.tencent.mm.plugin.topstory.ui.widget.f
    public final ae f(RecyclerView.LayoutManager layoutManager) {
        AppMethodBeat.i(126239);
        if (!(layoutManager instanceof RecyclerView.r.b)) {
            AppMethodBeat.o(126239);
            return null;
        }
        AnonymousClass1 r0 = new ae(this.mRecyclerView.getContext()) {
            /* class com.tencent.mm.plugin.topstory.ui.video.fs.b.AnonymousClass1 */

            @Override // android.support.v7.widget.ae, android.support.v7.widget.RecyclerView.r
            public final void a(View view, RecyclerView.s sVar, RecyclerView.r.a aVar) {
                AppMethodBeat.i(126234);
                int[] a2 = b.this.a(b.this.mRecyclerView.getLayoutManager(), view);
                int i2 = a2[0];
                int i3 = a2[1];
                int cc = cc(Math.max(Math.abs(i2), Math.abs(i3)));
                if (cc > 0) {
                    aVar.a(i2, i3, cc, this.VQ);
                }
                AppMethodBeat.o(126234);
            }

            @Override // android.support.v7.widget.ae
            public final float a(DisplayMetrics displayMetrics) {
                return 100.0f / ((float) displayMetrics.densityDpi);
            }

            @Override // android.support.v7.widget.ae
            public final int cd(int i2) {
                AppMethodBeat.i(126235);
                int min = Math.min(100, super.cd(i2));
                AppMethodBeat.o(126235);
                return min;
            }
        };
        AppMethodBeat.o(126239);
        return r0;
    }

    private static int a(RecyclerView.LayoutManager layoutManager, View view, aj ajVar) {
        int end;
        AppMethodBeat.i(126240);
        int bs = (ajVar.bs(view) / 2) + ajVar.bo(view);
        if (layoutManager.getClipToPadding()) {
            end = ajVar.kH() + (ajVar.kJ() / 2);
        } else {
            end = ajVar.getEnd() / 2;
        }
        int i2 = bs - end;
        AppMethodBeat.o(126240);
        return i2;
    }

    private static View a(RecyclerView.LayoutManager layoutManager, aj ajVar) {
        int end;
        View view = null;
        AppMethodBeat.i(126241);
        int childCount = layoutManager.getChildCount();
        if (childCount == 0) {
            AppMethodBeat.o(126241);
        } else {
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
            AppMethodBeat.o(126241);
        }
        return view;
    }

    private static View c(RecyclerView.LayoutManager layoutManager, aj ajVar) {
        View view = null;
        AppMethodBeat.i(126242);
        int childCount = layoutManager.getChildCount();
        if (childCount == 0) {
            AppMethodBeat.o(126242);
        } else {
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
            AppMethodBeat.o(126242);
        }
        return view;
    }

    private aj b(RecyclerView.LayoutManager layoutManager) {
        AppMethodBeat.i(126243);
        if (this.aqX == null || this.aqX.getLayoutManager() != layoutManager) {
            this.aqX = aj.e(layoutManager);
        }
        aj ajVar = this.aqX;
        AppMethodBeat.o(126243);
        return ajVar;
    }

    private aj c(RecyclerView.LayoutManager layoutManager) {
        AppMethodBeat.i(126244);
        if (this.aqY == null || this.aqY.getLayoutManager() != layoutManager) {
            this.aqY = aj.d(layoutManager);
        }
        aj ajVar = this.aqY;
        AppMethodBeat.o(126244);
        return ajVar;
    }
}
