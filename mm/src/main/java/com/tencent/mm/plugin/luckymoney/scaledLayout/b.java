package com.tencent.mm.plugin.luckymoney.scaledLayout;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract class b {
    final Rect Ui;
    protected final RecyclerView.LayoutManager arI;
    private int arJ;

    public abstract int bs(View view);

    public abstract int bt(View view);

    public abstract int efm();

    public abstract int kH();

    public abstract int kJ();

    /* synthetic */ b(RecyclerView.LayoutManager layoutManager, byte b2) {
        this(layoutManager);
    }

    private b(RecyclerView.LayoutManager layoutManager) {
        this.arJ = Integer.MIN_VALUE;
        this.Ui = new Rect();
        this.arI = layoutManager;
    }

    public static b b(RecyclerView.LayoutManager layoutManager, int i2) {
        switch (i2) {
            case 0:
                return new b(layoutManager) {
                    /* class com.tencent.mm.plugin.luckymoney.scaledLayout.b.AnonymousClass1 */

                    @Override // com.tencent.mm.plugin.luckymoney.scaledLayout.b
                    public final int kH() {
                        AppMethodBeat.i(65325);
                        int paddingLeft = this.arI.getPaddingLeft();
                        AppMethodBeat.o(65325);
                        return paddingLeft;
                    }

                    @Override // com.tencent.mm.plugin.luckymoney.scaledLayout.b
                    public final int bs(View view) {
                        AppMethodBeat.i(65326);
                        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                        int decoratedMeasuredWidth = layoutParams.rightMargin + this.arI.getDecoratedMeasuredWidth(view) + layoutParams.leftMargin;
                        AppMethodBeat.o(65326);
                        return decoratedMeasuredWidth;
                    }

                    @Override // com.tencent.mm.plugin.luckymoney.scaledLayout.b
                    public final int bt(View view) {
                        AppMethodBeat.i(65327);
                        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                        int decoratedMeasuredHeight = layoutParams.bottomMargin + this.arI.getDecoratedMeasuredHeight(view) + layoutParams.topMargin;
                        AppMethodBeat.o(65327);
                        return decoratedMeasuredHeight;
                    }

                    @Override // com.tencent.mm.plugin.luckymoney.scaledLayout.b
                    public final int kJ() {
                        AppMethodBeat.i(65328);
                        int width = (this.arI.getWidth() - this.arI.getPaddingLeft()) - this.arI.getPaddingRight();
                        AppMethodBeat.o(65328);
                        return width;
                    }

                    @Override // com.tencent.mm.plugin.luckymoney.scaledLayout.b
                    public final int efm() {
                        AppMethodBeat.i(65329);
                        int height = (this.arI.getHeight() - this.arI.getPaddingTop()) - this.arI.getPaddingBottom();
                        AppMethodBeat.o(65329);
                        return height;
                    }
                };
            case 1:
                return new b(layoutManager) {
                    /* class com.tencent.mm.plugin.luckymoney.scaledLayout.b.AnonymousClass2 */

                    @Override // com.tencent.mm.plugin.luckymoney.scaledLayout.b
                    public final int kH() {
                        AppMethodBeat.i(65330);
                        int paddingTop = this.arI.getPaddingTop();
                        AppMethodBeat.o(65330);
                        return paddingTop;
                    }

                    @Override // com.tencent.mm.plugin.luckymoney.scaledLayout.b
                    public final int bs(View view) {
                        AppMethodBeat.i(65331);
                        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                        int decoratedMeasuredHeight = layoutParams.bottomMargin + this.arI.getDecoratedMeasuredHeight(view) + layoutParams.topMargin;
                        AppMethodBeat.o(65331);
                        return decoratedMeasuredHeight;
                    }

                    @Override // com.tencent.mm.plugin.luckymoney.scaledLayout.b
                    public final int bt(View view) {
                        AppMethodBeat.i(65332);
                        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) view.getLayoutParams();
                        int decoratedMeasuredWidth = layoutParams.rightMargin + this.arI.getDecoratedMeasuredWidth(view) + layoutParams.leftMargin;
                        AppMethodBeat.o(65332);
                        return decoratedMeasuredWidth;
                    }

                    @Override // com.tencent.mm.plugin.luckymoney.scaledLayout.b
                    public final int kJ() {
                        AppMethodBeat.i(65333);
                        int height = (this.arI.getHeight() - this.arI.getPaddingTop()) - this.arI.getPaddingBottom();
                        AppMethodBeat.o(65333);
                        return height;
                    }

                    @Override // com.tencent.mm.plugin.luckymoney.scaledLayout.b
                    public final int efm() {
                        AppMethodBeat.i(65334);
                        int width = (this.arI.getWidth() - this.arI.getPaddingLeft()) - this.arI.getPaddingRight();
                        AppMethodBeat.o(65334);
                        return width;
                    }
                };
            default:
                throw new IllegalArgumentException("invalid orientation");
        }
    }
}
