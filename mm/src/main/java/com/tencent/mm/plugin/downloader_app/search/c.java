package com.tencent.mm.plugin.downloader_app.search;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class c extends RecyclerView.h {
    private final Drawable amP;
    private final Resources mRes;
    private int mSize;

    public c(Resources resources) {
        AppMethodBeat.i(8958);
        this.mRes = resources;
        this.amP = new ColorDrawable(resources.getColor(R.color.m7));
        this.mSize = resources.getDimensionPixelSize(R.dimen.a_1);
        AppMethodBeat.o(8958);
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public final void a(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
        AppMethodBeat.i(8959);
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount - 1; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            View findViewById = childAt.findViewById(R.id.he2);
            View findViewById2 = childAt.findViewById(R.id.he5);
            View findViewById3 = childAt.findViewById(R.id.hez);
            if (childAt.getVisibility() == 8) {
                super.a(canvas, recyclerView, sVar);
            } else {
                int bottom = ((RecyclerView.LayoutParams) childAt.getLayoutParams()).bottomMargin + childAt.getBottom();
                int i3 = this.mSize + bottom;
                if (findViewById.getVisibility() == 0) {
                    this.amP.setBounds(paddingLeft, bottom, width, i3);
                    this.amP.draw(canvas);
                } else if (findViewById2.getVisibility() == 0) {
                    this.amP.setBounds(this.mRes.getDimensionPixelSize(R.dimen.aig) + paddingLeft, bottom, width, i3);
                    this.amP.draw(canvas);
                } else if (findViewById3.getVisibility() == 0) {
                    this.amP.setBounds(this.mRes.getDimensionPixelSize(R.dimen.aif) + paddingLeft, bottom, width, i3);
                    this.amP.draw(canvas);
                }
            }
        }
        AppMethodBeat.o(8959);
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
        AppMethodBeat.i(8960);
        rect.set(0, 0, 0, this.mSize);
        AppMethodBeat.o(8960);
    }
}
