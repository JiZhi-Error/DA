package com.tencent.mm.plugin.luckymoney.scaledLayout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.ae;
import android.support.v7.widget.aj;
import android.support.v7.widget.ak;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class a extends ak {
    public Context context;
    public View yYd;
    public boolean yYe = false;

    @Override // android.support.v7.widget.at, android.support.v7.widget.ak
    public final View a(RecyclerView.LayoutManager layoutManager) {
        int i2;
        AppMethodBeat.i(65321);
        View a2 = super.a(layoutManager);
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i3 < layoutManager.getChildCount()) {
            View childAt = layoutManager.getChildAt(i3);
            if (childAt == a2) {
                i2 = i3;
            } else {
                i2 = i4;
            }
            if (childAt == this.yYd) {
                i5 = i3;
            }
            i3++;
            i4 = i2;
        }
        if (i4 - i5 > 1) {
            View findViewByPosition = layoutManager.findViewByPosition(i5 + 1);
            AppMethodBeat.o(65321);
            return findViewByPosition;
        } else if (i4 - i5 < -1) {
            View findViewByPosition2 = layoutManager.findViewByPosition(i5 - 1);
            AppMethodBeat.o(65321);
            return findViewByPosition2;
        } else {
            AppMethodBeat.o(65321);
            return a2;
        }
    }

    @Override // android.support.v7.widget.at, android.support.v7.widget.ak
    public final int a(RecyclerView.LayoutManager layoutManager, int i2, int i3) {
        AppMethodBeat.i(65322);
        if (layoutManager.getItemCount() == 0) {
            AppMethodBeat.o(65322);
            return -1;
        }
        View h2 = h(layoutManager);
        if (h2 == null) {
            AppMethodBeat.o(65322);
            return -1;
        }
        if (!(this.yYd == null || this.yYd == h2)) {
            h2 = this.yYd;
        }
        int position = layoutManager.getPosition(h2);
        Log.d("CusPager", "pos: %s", Integer.valueOf(position));
        if (i2 >= 100 && position + 1 < layoutManager.getItemCount()) {
            int i4 = position + 1;
            AppMethodBeat.o(65322);
            return i4;
        } else if (i2 > -100 || position - 1 < 0) {
            AppMethodBeat.o(65322);
            return position;
        } else {
            int i5 = position - 1;
            AppMethodBeat.o(65322);
            return i5;
        }
    }

    public static View h(RecyclerView.LayoutManager layoutManager) {
        int end;
        View view = null;
        AppMethodBeat.i(65323);
        int childCount = layoutManager.getChildCount();
        if (childCount == 0) {
            AppMethodBeat.o(65323);
        } else {
            aj d2 = aj.d(layoutManager);
            if (layoutManager.getClipToPadding()) {
                end = d2.kH() + (d2.kJ() / 2);
            } else {
                end = d2.getEnd() / 2;
            }
            int i2 = Integer.MAX_VALUE;
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = layoutManager.getChildAt(i3);
                int abs = Math.abs((d2.bo(childAt) + (d2.bs(childAt) / 2)) - end);
                if (abs >= i2) {
                    abs = i2;
                    childAt = view;
                }
                i3++;
                i2 = abs;
                view = childAt;
            }
            AppMethodBeat.o(65323);
        }
        return view;
    }

    @Override // android.support.v7.widget.at
    public final RecyclerView.r g(final RecyclerView.LayoutManager layoutManager) {
        AppMethodBeat.i(65324);
        if (this.yYe) {
            RecyclerView.r g2 = super.g(layoutManager);
            AppMethodBeat.o(65324);
            return g2;
        }
        AnonymousClass1 r0 = new ae(this.context) {
            /* class com.tencent.mm.plugin.luckymoney.scaledLayout.a.AnonymousClass1 */

            @Override // android.support.v7.widget.ae, android.support.v7.widget.RecyclerView.r
            public final void a(View view, RecyclerView.s sVar, RecyclerView.r.a aVar) {
                AppMethodBeat.i(65319);
                int[] a2 = a.this.a(layoutManager, view);
                int i2 = a2[0];
                int i3 = a2[1];
                int cc = cc(Math.max(Math.abs(i2), Math.abs(i3)));
                if (cc > 0) {
                    aVar.a(i2, i3, cc, this.VQ);
                }
                AppMethodBeat.o(65319);
            }

            @Override // android.support.v7.widget.ae
            public final float a(DisplayMetrics displayMetrics) {
                return 50.0f / ((float) displayMetrics.densityDpi);
            }

            @Override // android.support.v7.widget.ae
            public final int cd(int i2) {
                AppMethodBeat.i(65320);
                int min = Math.min(50, super.cd(i2));
                AppMethodBeat.o(65320);
                return min;
            }
        };
        AppMethodBeat.o(65324);
        return r0;
    }
}
