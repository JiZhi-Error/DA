package com.tencent.mm.plugin.downloader_app.ui;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;

public final class a extends RecyclerView.h {
    private final Drawable amP;
    private int mSize;
    private final Drawable qMG;

    public a(Resources resources) {
        AppMethodBeat.i(9025);
        this.amP = new ColorDrawable(resources.getColor(R.color.m7));
        this.mSize = resources.getDimensionPixelSize(R.dimen.a_1);
        this.qMG = new ColorDrawable(resources.getColor(R.color.afz));
        AppMethodBeat.o(9025);
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public final void a(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
        AppMethodBeat.i(9026);
        int paddingLeft = recyclerView.getPaddingLeft();
        int width = recyclerView.getWidth() - recyclerView.getPaddingRight();
        int childCount = recyclerView.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = recyclerView.getChildAt(i2);
            View childAt2 = ((ViewGroup) childAt).getChildAt(0);
            int bottom = childAt.getBottom() + ((RecyclerView.LayoutParams) childAt.getLayoutParams()).bottomMargin;
            int i3 = bottom + this.mSize;
            if (childAt.getVisibility() == 8 || childAt2.getVisibility() == 8) {
                if (childAt2 instanceof TaskItemView) {
                    this.qMG.setBounds(paddingLeft, bottom, width, i3);
                    this.qMG.draw(canvas);
                }
            } else if ((childAt2 instanceof TaskManagerHeaderView) || (childAt2 instanceof TaskHeaderView) || (childAt2 instanceof ExpandView)) {
                this.amP.setBounds(paddingLeft, bottom, width, i3);
                this.amP.draw(canvas);
            } else {
                if (childAt2 instanceof TaskItemView) {
                    View childAt3 = recyclerView.getChildAt(i2 + 1);
                    if (childAt3 != null) {
                        View childAt4 = ((ViewGroup) childAt3).getChildAt(0);
                        if (!(childAt4 instanceof TaskHeaderView)) {
                            if ((childAt4 instanceof ExpandView) && childAt4.getVisibility() == 8) {
                                this.amP.setBounds(paddingLeft, bottom, width, i3);
                                this.amP.draw(canvas);
                            }
                        }
                    }
                    this.amP.setBounds(((TaskItemView) childAt2).getNamePaddingLeft() + paddingLeft, bottom, width, i3);
                    this.amP.draw(canvas);
                    this.qMG.setBounds(paddingLeft, bottom, ((TaskItemView) childAt2).getNamePaddingLeft() + paddingLeft, i3);
                    this.qMG.draw(canvas);
                }
                super.a(canvas, recyclerView, sVar);
            }
        }
        AppMethodBeat.o(9026);
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
        AppMethodBeat.i(9027);
        rect.set(0, 0, 0, this.mSize);
        AppMethodBeat.o(9027);
    }
}
