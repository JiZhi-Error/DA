package com.tencent.mm.plugin.gallery.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.content.b;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class c extends RecyclerView.h {
    private Drawable amP;
    private boolean xpw;
    private int xpx;
    private int xpy;

    /* synthetic */ c(int i2, int i3, int i4, boolean z, byte b2) {
        this(i2, i3, i4, z);
    }

    private c(int i2, int i3, int i4, boolean z) {
        AppMethodBeat.i(111507);
        this.xpx = i2;
        this.xpw = z;
        this.xpy = i3;
        this.amP = new ColorDrawable(i4);
        AppMethodBeat.o(111507);
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
        int i2;
        AppMethodBeat.i(111509);
        int u = u(recyclerView);
        int itemCount = recyclerView.getAdapter().getItemCount();
        int lQ = ((RecyclerView.LayoutParams) view.getLayoutParams()).atw.lQ();
        if (lQ < 0) {
            AppMethodBeat.o(111509);
            return;
        }
        int i3 = lQ % u;
        int i4 = (this.xpy * i3) / u;
        int i5 = this.xpy - (((i3 + 1) * this.xpy) / u);
        if (!a(recyclerView, lQ, u, itemCount) || this.xpw) {
            i2 = this.xpx;
        } else {
            i2 = 0;
        }
        rect.set(i4, 0, i5, i2);
        AppMethodBeat.o(111509);
    }

    private static int u(RecyclerView recyclerView) {
        int i2;
        AppMethodBeat.i(111510);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            i2 = ((GridLayoutManager) layoutManager).apM;
        } else {
            i2 = layoutManager instanceof StaggeredGridLayoutManager ? ((StaggeredGridLayoutManager) layoutManager).apM : -1;
        }
        AppMethodBeat.o(111510);
        return i2;
    }

    private static boolean a(RecyclerView recyclerView, int i2, int i3, int i4) {
        AppMethodBeat.i(111511);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            boolean aj = aj(i2, i3, i4);
            AppMethodBeat.o(111511);
            return aj;
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            if (((StaggeredGridLayoutManager) layoutManager).mOrientation == 1) {
                boolean aj2 = aj(i2, i3, i4);
                AppMethodBeat.o(111511);
                return aj2;
            } else if ((i2 + 1) % i3 == 0) {
                AppMethodBeat.o(111511);
                return true;
            }
        }
        AppMethodBeat.o(111511);
        return false;
    }

    private static boolean aj(int i2, int i3, int i4) {
        if (i4 % i3 == 0) {
            if (i2 >= i4 - i3) {
                return true;
            }
        } else if (i2 < i4 - (i4 % i3)) {
            return false;
        } else {
            return true;
        }
        return false;
    }

    public static class a {
        private int mColor = -1;
        private Context mContext;
        private Resources mResources;
        boolean xpw = true;
        private int xpx = 0;
        private int xpy = 0;

        public a(Context context) {
            AppMethodBeat.i(111506);
            this.mContext = context;
            this.mResources = context.getResources();
            AppMethodBeat.o(111506);
        }

        public final a dSd() {
            AppMethodBeat.i(257748);
            this.mColor = b.n(this.mContext, R.color.s0);
            AppMethodBeat.o(257748);
            return this;
        }

        public final a NO(int i2) {
            AppMethodBeat.i(257749);
            this.xpy = this.mResources.getDimensionPixelSize(i2);
            AppMethodBeat.o(257749);
            return this;
        }

        public final a NP(int i2) {
            AppMethodBeat.i(257750);
            this.xpx = this.mResources.getDimensionPixelSize(i2);
            AppMethodBeat.o(257750);
            return this;
        }

        public final a dSe() {
            this.xpw = false;
            return this;
        }

        public final c dSf() {
            AppMethodBeat.i(257751);
            c cVar = new c(this.xpx, this.xpy, this.mColor, this.xpw, (byte) 0);
            AppMethodBeat.o(257751);
            return cVar;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public final void b(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
        AppMethodBeat.i(164809);
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            if (!a(recyclerView, i2, u(recyclerView), childCount) || this.xpw) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) childAt.getLayoutParams();
                int bottom = layoutParams.bottomMargin + childAt.getBottom();
                this.amP.setBounds(childAt.getLeft() - layoutParams.leftMargin, bottom, childAt.getRight() + layoutParams.rightMargin, this.xpx + bottom);
                this.amP.draw(canvas);
            }
        }
        int childCount2 = recyclerView.getChildCount();
        for (int i3 = 0; i3 < childCount2; i3++) {
            View childAt2 = recyclerView.getChildAt(i3);
            if ((recyclerView.bi(childAt2).lR() + 1) % u(recyclerView) != 0) {
                RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) childAt2.getLayoutParams();
                int top = childAt2.getTop() - layoutParams2.topMargin;
                int bottom2 = childAt2.getBottom() + layoutParams2.bottomMargin + this.xpx;
                int right = childAt2.getRight() + layoutParams2.rightMargin;
                int i4 = this.xpy + right;
                if (i3 == childCount2 - 1) {
                    i4 -= this.xpy;
                }
                this.amP.setBounds(right, top, i4, bottom2);
                this.amP.draw(canvas);
            }
        }
        AppMethodBeat.o(164809);
    }
}
