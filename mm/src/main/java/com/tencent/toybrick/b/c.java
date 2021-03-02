package com.tencent.toybrick.b;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.toybrick.c.g;
import com.tencent.toybrick.d.a;

public final class c extends RecyclerView.h {
    private static final int[] QA = {16843284};
    public a.C2220a Snl;
    private final Rect mBounds = new Rect();
    private int mOrientation;

    public c(Context context) {
        AppMethodBeat.i(159929);
        context.obtainStyledAttributes(QA).recycle();
        this.mOrientation = 1;
        AppMethodBeat.o(159929);
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public final void b(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
        int height;
        int i2;
        AppMethodBeat.i(168816);
        if (recyclerView.getLayoutManager() == null || this.Snl.Soj == null) {
            AppMethodBeat.o(168816);
        } else if (this.mOrientation == 1) {
            if (this.Snl.Soi) {
                canvas.save();
                int childCount = recyclerView.getChildCount();
                for (int i3 = 0; i3 < childCount; i3++) {
                    View childAt = recyclerView.getChildAt(i3);
                    int lR = recyclerView.bu(childAt).lR();
                    if (lR >= 0) {
                        g asz = ((b) recyclerView.getAdapter()).asz(lR);
                        if (asz.SnX) {
                            int i4 = asz.hN(childAt)[0];
                            int width = recyclerView.getWidth() - asz.hN(childAt)[1];
                            RecyclerView.getDecoratedBoundsWithMargins(childAt, this.mBounds);
                            int round = Math.round(childAt.getTranslationY()) + this.mBounds.bottom;
                            this.Snl.Soj.setBounds(i4, round - this.Snl.Soj.getIntrinsicHeight(), width, round);
                            this.Snl.Soj.draw(canvas);
                        }
                    }
                }
                canvas.restore();
            }
            AppMethodBeat.o(168816);
        } else {
            if (this.Snl.Soi) {
                canvas.save();
                if (recyclerView.getClipToPadding()) {
                    i2 = recyclerView.getPaddingTop();
                    int height2 = recyclerView.getHeight() - recyclerView.getPaddingBottom();
                    canvas.clipRect(recyclerView.getPaddingLeft(), i2, recyclerView.getWidth() - recyclerView.getPaddingRight(), height2);
                    height = height2;
                } else {
                    height = recyclerView.getHeight();
                    i2 = 0;
                }
                int childCount2 = recyclerView.getChildCount();
                for (int i5 = 0; i5 < childCount2; i5++) {
                    View childAt2 = recyclerView.getChildAt(i5);
                    if (this.Snl.Soh.get(recyclerView.bu(childAt2).lR()).SnX) {
                        recyclerView.getLayoutManager().getDecoratedBoundsWithMargins(childAt2, this.mBounds);
                        int round2 = this.mBounds.right + Math.round(childAt2.getTranslationX());
                        this.Snl.Soj.setBounds(round2 - this.Snl.Soj.getIntrinsicWidth(), i2, round2, height);
                        this.Snl.Soj.draw(canvas);
                    }
                }
                canvas.restore();
            }
            AppMethodBeat.o(168816);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
        AppMethodBeat.i(159931);
        if (this.Snl.Soj == null) {
            rect.set(0, 0, 0, 0);
            AppMethodBeat.o(159931);
        } else if (this.mOrientation == 1) {
            rect.set(0, 0, 0, this.Snl.Soj.getIntrinsicHeight());
            AppMethodBeat.o(159931);
        } else {
            rect.set(0, 0, this.Snl.Soj.getIntrinsicWidth(), 0);
            AppMethodBeat.o(159931);
        }
    }
}
