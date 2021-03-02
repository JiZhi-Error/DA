package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public final class w extends RecyclerView.h {
    private static final int[] QA = {16843284};
    private Drawable amP;
    private final Rect mBounds = new Rect();
    private int mOrientation;

    public w(Context context, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(QA);
        this.amP = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        if (i2 == 0 || i2 == 1) {
            this.mOrientation = i2;
            return;
        }
        throw new IllegalArgumentException("Invalid orientation. It should be either HORIZONTAL or VERTICAL");
    }

    public final void setDrawable(Drawable drawable) {
        if (drawable == null) {
            throw new IllegalArgumentException("Drawable cannot be null.");
        }
        this.amP = drawable;
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public final void a(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
        int height;
        int i2;
        int width;
        int i3;
        int i4 = 0;
        if (recyclerView.getLayoutManager() != null && this.amP != null) {
            if (this.mOrientation == 1) {
                canvas.save();
                if (recyclerView.getClipToPadding()) {
                    i3 = recyclerView.getPaddingLeft();
                    width = recyclerView.getWidth() - recyclerView.getPaddingRight();
                    canvas.clipRect(i3, recyclerView.getPaddingTop(), width, recyclerView.getHeight() - recyclerView.getPaddingBottom());
                } else {
                    width = recyclerView.getWidth();
                    i3 = 0;
                }
                int childCount = recyclerView.getChildCount();
                while (i4 < childCount) {
                    View childAt = recyclerView.getChildAt(i4);
                    RecyclerView.getDecoratedBoundsWithMargins(childAt, this.mBounds);
                    int round = Math.round(childAt.getTranslationY()) + this.mBounds.bottom;
                    this.amP.setBounds(i3, round - this.amP.getIntrinsicHeight(), width, round);
                    this.amP.draw(canvas);
                    i4++;
                }
                canvas.restore();
                return;
            }
            canvas.save();
            if (recyclerView.getClipToPadding()) {
                i2 = recyclerView.getPaddingTop();
                height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
                canvas.clipRect(recyclerView.getPaddingLeft(), i2, recyclerView.getWidth() - recyclerView.getPaddingRight(), height);
            } else {
                height = recyclerView.getHeight();
                i2 = 0;
            }
            int childCount2 = recyclerView.getChildCount();
            while (i4 < childCount2) {
                View childAt2 = recyclerView.getChildAt(i4);
                recyclerView.getLayoutManager().getDecoratedBoundsWithMargins(childAt2, this.mBounds);
                int round2 = Math.round(childAt2.getTranslationX()) + this.mBounds.right;
                this.amP.setBounds(round2 - this.amP.getIntrinsicWidth(), i2, round2, height);
                this.amP.draw(canvas);
                i4++;
            }
            canvas.restore();
        }
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
        if (this.amP == null) {
            rect.set(0, 0, 0, 0);
        } else if (this.mOrientation == 1) {
            rect.set(0, 0, 0, this.amP.getIntrinsicHeight());
        } else {
            rect.set(0, 0, this.amP.getIntrinsicWidth(), 0);
        }
    }
}
