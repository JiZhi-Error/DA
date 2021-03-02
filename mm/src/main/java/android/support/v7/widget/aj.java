package android.support.v7.widget;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class aj {
    final Rect Ui;
    protected final RecyclerView.LayoutManager arI;
    int arJ;

    public abstract int bo(View view);

    public abstract int bp(View view);

    public abstract int bq(View view);

    public abstract int br(View view);

    public abstract int bs(View view);

    public abstract int bt(View view);

    public abstract void ce(int i2);

    public abstract int getEnd();

    public abstract int getEndPadding();

    public abstract int getMode();

    public abstract int kH();

    public abstract int kI();

    public abstract int kJ();

    public abstract int kK();

    /* synthetic */ aj(RecyclerView.LayoutManager layoutManager, byte b2) {
        this(layoutManager);
    }

    private aj(RecyclerView.LayoutManager layoutManager) {
        this.arJ = Integer.MIN_VALUE;
        this.Ui = new Rect();
        this.arI = layoutManager;
    }

    public final RecyclerView.LayoutManager getLayoutManager() {
        return this.arI;
    }

    public final int kG() {
        if (Integer.MIN_VALUE == this.arJ) {
            return 0;
        }
        return kJ() - this.arJ;
    }

    public static aj a(RecyclerView.LayoutManager layoutManager, int i2) {
        switch (i2) {
            case 0:
                return d(layoutManager);
            case 1:
                return e(layoutManager);
            default:
                throw new IllegalArgumentException("invalid orientation");
        }
    }

    public static aj d(RecyclerView.LayoutManager layoutManager) {
        return new aj(layoutManager) {
            /* class android.support.v7.widget.aj.AnonymousClass1 */

            @Override // android.support.v7.widget.aj
            public final int kI() {
                return this.arI.getWidth() - this.arI.getPaddingRight();
            }

            @Override // android.support.v7.widget.aj
            public final int getEnd() {
                return this.arI.getWidth();
            }

            @Override // android.support.v7.widget.aj
            public final void ce(int i2) {
                this.arI.offsetChildrenHorizontal(i2);
            }

            @Override // android.support.v7.widget.aj
            public final int kH() {
                return this.arI.getPaddingLeft();
            }

            @Override // android.support.v7.widget.aj
            public final int bs(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return layoutParams.rightMargin + this.arI.getDecoratedMeasuredWidth(view) + layoutParams.leftMargin;
            }

            @Override // android.support.v7.widget.aj
            public final int bt(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return layoutParams.bottomMargin + this.arI.getDecoratedMeasuredHeight(view) + layoutParams.topMargin;
            }

            @Override // android.support.v7.widget.aj
            public final int bp(View view) {
                return ((RecyclerView.LayoutParams) view.getLayoutParams()).rightMargin + this.arI.getDecoratedRight(view);
            }

            @Override // android.support.v7.widget.aj
            public final int bo(View view) {
                return this.arI.getDecoratedLeft(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).leftMargin;
            }

            @Override // android.support.v7.widget.aj
            public final int bq(View view) {
                this.arI.getTransformedBoundingBox(view, true, this.Ui);
                return this.Ui.right;
            }

            @Override // android.support.v7.widget.aj
            public final int br(View view) {
                this.arI.getTransformedBoundingBox(view, true, this.Ui);
                return this.Ui.left;
            }

            @Override // android.support.v7.widget.aj
            public final int kJ() {
                return (this.arI.getWidth() - this.arI.getPaddingLeft()) - this.arI.getPaddingRight();
            }

            @Override // android.support.v7.widget.aj
            public final int getEndPadding() {
                return this.arI.getPaddingRight();
            }

            @Override // android.support.v7.widget.aj
            public final int getMode() {
                return this.arI.getWidthMode();
            }

            @Override // android.support.v7.widget.aj
            public final int kK() {
                return this.arI.getHeightMode();
            }
        };
    }

    public static aj e(RecyclerView.LayoutManager layoutManager) {
        return new aj(layoutManager) {
            /* class android.support.v7.widget.aj.AnonymousClass2 */

            @Override // android.support.v7.widget.aj
            public final int kI() {
                return this.arI.getHeight() - this.arI.getPaddingBottom();
            }

            @Override // android.support.v7.widget.aj
            public final int getEnd() {
                return this.arI.getHeight();
            }

            @Override // android.support.v7.widget.aj
            public final void ce(int i2) {
                this.arI.offsetChildrenVertical(i2);
            }

            @Override // android.support.v7.widget.aj
            public final int kH() {
                return this.arI.getPaddingTop();
            }

            @Override // android.support.v7.widget.aj
            public final int bs(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return layoutParams.bottomMargin + this.arI.getDecoratedMeasuredHeight(view) + layoutParams.topMargin;
            }

            @Override // android.support.v7.widget.aj
            public final int bt(View view) {
                RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                return layoutParams.rightMargin + this.arI.getDecoratedMeasuredWidth(view) + layoutParams.leftMargin;
            }

            @Override // android.support.v7.widget.aj
            public final int bp(View view) {
                return ((RecyclerView.LayoutParams) view.getLayoutParams()).bottomMargin + this.arI.getDecoratedBottom(view);
            }

            @Override // android.support.v7.widget.aj
            public final int bo(View view) {
                return this.arI.getDecoratedTop(view) - ((RecyclerView.LayoutParams) view.getLayoutParams()).topMargin;
            }

            @Override // android.support.v7.widget.aj
            public final int bq(View view) {
                this.arI.getTransformedBoundingBox(view, true, this.Ui);
                return this.Ui.bottom;
            }

            @Override // android.support.v7.widget.aj
            public final int br(View view) {
                this.arI.getTransformedBoundingBox(view, true, this.Ui);
                return this.Ui.top;
            }

            @Override // android.support.v7.widget.aj
            public final int kJ() {
                return (this.arI.getHeight() - this.arI.getPaddingTop()) - this.arI.getPaddingBottom();
            }

            @Override // android.support.v7.widget.aj
            public final int getEndPadding() {
                return this.arI.getPaddingBottom();
            }

            @Override // android.support.v7.widget.aj
            public final int getMode() {
                return this.arI.getHeightMode();
            }

            @Override // android.support.v7.widget.aj
            public final int kK() {
                return this.arI.getWidthMode();
            }
        };
    }
}
