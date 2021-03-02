package com.tencent.mm.plugin.finder.view.decoration;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bB\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ \u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J \u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J(\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J \u0010\u001a\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/finder/view/decoration/ItemDividerDecoration;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "divider", "Landroid/graphics/drawable/Drawable;", "dividerHeight", "", "(Landroid/graphics/drawable/Drawable;I)V", "orientation", "(Landroid/graphics/drawable/Drawable;II)V", "padding", "", "(Landroid/graphics/drawable/Drawable;I[I)V", "drawHorizontal", "", "c", "Landroid/graphics/Canvas;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "drawVertical", "getItemOffsets", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "onDraw", "plugin-finder_release"})
public final class b extends RecyclerView.h {
    private Drawable kjR;
    private int orientation = 1;
    private int[] wsj;

    public b(Drawable drawable, int i2) {
        p.h(drawable, "divider");
        AppMethodBeat.i(168501);
        this.kjR = drawable;
        if (this.orientation == 0) {
            drawable.setBounds(0, 0, i2, 0);
            AppMethodBeat.o(168501);
            return;
        }
        drawable.setBounds(0, 0, 0, i2);
        AppMethodBeat.o(168501);
    }

    public b(Drawable drawable, int i2, int[] iArr) {
        p.h(drawable, "divider");
        p.h(iArr, "padding");
        AppMethodBeat.i(255211);
        this.kjR = drawable;
        this.wsj = iArr;
        if (this.orientation == 0) {
            drawable.setBounds(0, 0, i2, 0);
            AppMethodBeat.o(255211);
            return;
        }
        drawable.setBounds(0, 0, 0, i2);
        AppMethodBeat.o(255211);
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public final void a(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
        AppMethodBeat.i(168499);
        p.h(canvas, "c");
        p.h(recyclerView, "parent");
        p.h(sVar, "state");
        super.a(canvas, recyclerView, sVar);
        switch (this.orientation) {
            case 0:
                int childCount = recyclerView.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = recyclerView.getChildAt(i2);
                    RecyclerView.v bi = recyclerView.bi(childAt);
                    Integer valueOf = bi != null ? Integer.valueOf(bi.lU()) : null;
                    if ((valueOf == null || valueOf.intValue() != -2) && ((valueOf == null || valueOf.intValue() != -3) && ((valueOf == null || valueOf.intValue() != -4) && (valueOf == null || valueOf.intValue() != -5)))) {
                        p.g(childAt, "child");
                        ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                        if (layoutParams == null) {
                            t tVar = new t("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.LayoutParams");
                            AppMethodBeat.o(168499);
                            throw tVar;
                        }
                        RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
                        int right = childAt.getRight() + layoutParams2.rightMargin;
                        this.kjR.setBounds(right, childAt.getTop() - layoutParams2.topMargin, this.kjR.getBounds().width() + right, layoutParams2.bottomMargin + childAt.getBottom());
                        this.kjR.draw(canvas);
                    }
                }
                AppMethodBeat.o(168499);
                return;
            default:
                int childCount2 = recyclerView.getChildCount();
                for (int i3 = 0; i3 < childCount2; i3++) {
                    View childAt2 = recyclerView.getChildAt(i3);
                    p.g(childAt2, "child");
                    ViewGroup.LayoutParams layoutParams3 = childAt2.getLayoutParams();
                    if (layoutParams3 == null) {
                        t tVar2 = new t("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.LayoutParams");
                        AppMethodBeat.o(168499);
                        throw tVar2;
                    }
                    RecyclerView.LayoutParams layoutParams4 = (RecyclerView.LayoutParams) layoutParams3;
                    int left = childAt2.getLeft() - layoutParams4.leftMargin;
                    int[] iArr = this.wsj;
                    int i4 = left + (iArr != null ? iArr[0] : 0);
                    int bottom = layoutParams4.bottomMargin + childAt2.getBottom();
                    int[] iArr2 = this.wsj;
                    int i5 = (iArr2 != null ? iArr2[1] : 0) + bottom;
                    int right2 = childAt2.getRight() + layoutParams4.rightMargin;
                    int[] iArr3 = this.wsj;
                    int i6 = right2 - (iArr3 != null ? iArr3[2] : 0);
                    int height = i5 + this.kjR.getBounds().height();
                    int[] iArr4 = this.wsj;
                    this.kjR.setBounds(i4, i5, i6, height - (iArr4 != null ? iArr4[3] : 0));
                    this.kjR.draw(canvas);
                }
                AppMethodBeat.o(168499);
                return;
        }
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
        AppMethodBeat.i(168500);
        p.h(rect, "outRect");
        p.h(view, "view");
        p.h(recyclerView, "parent");
        p.h(sVar, "state");
        super.a(rect, view, recyclerView, sVar);
        RecyclerView.v bi = recyclerView.bi(view);
        Integer valueOf = bi != null ? Integer.valueOf(bi.lU()) : null;
        if ((valueOf != null && valueOf.intValue() == -2) || ((valueOf != null && valueOf.intValue() == -3) || ((valueOf != null && valueOf.intValue() == -4) || (valueOf != null && valueOf.intValue() == -5)))) {
            AppMethodBeat.o(168500);
            return;
        }
        switch (this.orientation) {
            case 0:
                rect.set(0, 0, this.kjR.getBounds().width(), 0);
                AppMethodBeat.o(168500);
                return;
            default:
                rect.set(0, 0, 0, this.kjR.getBounds().height());
                AppMethodBeat.o(168500);
                return;
        }
    }
}
