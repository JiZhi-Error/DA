package com.tencent.mm.plugin.finder.profile;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u000256B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010&\u001a\u00020'H\u0016J\u001c\u0010(\u001a\u00020)2\n\u0010*\u001a\u00060+R\u00020,2\u0006\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u00020)H\u0002J\b\u00100\u001a\u000201H\u0016J\u001c\u00102\u001a\u00020)2\n\u0010*\u001a\u00060+R\u00020,2\u0006\u0010-\u001a\u00020.H\u0016J$\u00103\u001a\u00020\u000b2\u0006\u00104\u001a\u00020\u000b2\n\u0010*\u001a\u00060+R\u00020,2\u0006\u0010-\u001a\u00020.H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\r\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\r\"\u0004\b\u0014\u0010\u0011R\u000e\u0010\u0015\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0016\u001a\f\u0012\b\u0012\u00060\u0018R\u00020\u00000\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u001a\u001a\u00060\u0018R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001b\u001a\u00020\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\r\"\u0004\b!\u0010\u0011R\u000e\u0010\"\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010$\u001a\u00020\u000b8BX\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\r¨\u00067"}, hxF = {"Lcom/tencent/mm/plugin/finder/profile/FlowLayoutManager;", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "allItemFrames", "Landroid/util/SparseArray;", "Landroid/graphics/Rect;", "horizontalSpace", "", "getHorizontalSpace", "()I", "layoutHeight", "getLayoutHeight", "setLayoutHeight", "(I)V", "layoutWidth", "getLayoutWidth", "setLayoutWidth", "left", "lineRows", "", "Lcom/tencent/mm/plugin/finder/profile/FlowLayoutManager$Row;", "right", "row", "self", "getSelf", "()Lcom/tencent/mm/plugin/finder/profile/FlowLayoutManager;", "top", "totalHeight", "getTotalHeight", "setTotalHeight", "usedMaxWidth", "verticalScrollOffset", "verticalSpace", "getVerticalSpace", "canScrollVertically", "", "fillLayout", "", "recycler", "Landroid/support/v7/widget/RecyclerView$Recycler;", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "formatAboveRow", "generateDefaultLayoutParams", "Landroid/support/v7/widget/RecyclerView$LayoutParams;", "onLayoutChildren", "scrollVerticallyBy", "dy", "Item", "Row", "plugin-finder_release"})
public final class FlowLayoutManager extends RecyclerView.LayoutManager {
    private final String TAG = "Finder.FlowLayoutManager";
    private int left;
    private int right;
    private int top;
    private final List<b> uZA;
    private final SparseArray<Rect> uZB;
    private final FlowLayoutManager uZt;
    private int uZu;
    private int uZv;
    private int uZw;
    private int uZx;
    private int uZy;
    private b uZz;

    public FlowLayoutManager() {
        AppMethodBeat.i(250010);
        setAutoMeasureEnabled(true);
        this.uZt = this;
        this.uZz = new b();
        this.uZA = new ArrayList();
        this.uZB = new SparseArray<>();
        AppMethodBeat.o(250010);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0004\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/finder/profile/FlowLayoutManager$Item;", "", "useHeight", "", "view", "Landroid/view/View;", "rect", "Landroid/graphics/Rect;", "(Lcom/tencent/mm/plugin/finder/profile/FlowLayoutManager;ILandroid/view/View;Landroid/graphics/Rect;)V", "getRect", "()Landroid/graphics/Rect;", "setRect", "(Landroid/graphics/Rect;)V", "getUseHeight", "()I", "setUseHeight", "(I)V", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "plugin-finder_release"})
    public final class a {
        Rect rect;
        int uZC;
        final /* synthetic */ FlowLayoutManager uZD;
        View view;

        public a(FlowLayoutManager flowLayoutManager, int i2, View view2, Rect rect2) {
            p.h(view2, "view");
            p.h(rect2, "rect");
            this.uZD = flowLayoutManager;
            AppMethodBeat.i(250001);
            this.uZC = i2;
            this.view = view2;
            this.rect = rect2;
            AppMethodBeat.o(250001);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0014\u001a\u00020\u00152\n\u0010\u0016\u001a\u00060\u000eR\u00020\u000fR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\f\u0012\b\u0012\u00060\u000eR\u00020\u000f0\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/finder/profile/FlowLayoutManager$Row;", "", "(Lcom/tencent/mm/plugin/finder/profile/FlowLayoutManager;)V", "cuTop", "", "getCuTop", "()F", "setCuTop", "(F)V", "maxHeight", "getMaxHeight", "setMaxHeight", "views", "", "Lcom/tencent/mm/plugin/finder/profile/FlowLayoutManager$Item;", "Lcom/tencent/mm/plugin/finder/profile/FlowLayoutManager;", "getViews", "()Ljava/util/List;", "setViews", "(Ljava/util/List;)V", "addViews", "", "view", "plugin-finder_release"})
    public final class b {
        float maxHeight;
        float uZE;
        List<a> uZF = new ArrayList();

        /* JADX WARN: Incorrect args count in method signature: ()V */
        public b() {
            AppMethodBeat.i(250003);
            AppMethodBeat.o(250003);
        }

        public final void a(a aVar) {
            AppMethodBeat.i(250002);
            p.h(aVar, "view");
            this.uZF.add(aVar);
            AppMethodBeat.o(250002);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public final RecyclerView.LayoutParams generateDefaultLayoutParams() {
        AppMethodBeat.i(250004);
        RecyclerView.LayoutParams layoutParams = new RecyclerView.LayoutParams(-2, -2);
        AppMethodBeat.o(250004);
        return layoutParams;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public final void onLayoutChildren(RecyclerView.n nVar, RecyclerView.s sVar) {
        int i2;
        AppMethodBeat.i(250005);
        p.h(nVar, "recycler");
        p.h(sVar, "state");
        Log.d(this.TAG, "onLayoutChildren");
        this.uZy = 0;
        int i3 = this.top;
        int i4 = 0;
        int i5 = 0;
        this.uZz = new b();
        this.uZA.clear();
        this.uZB.clear();
        removeAllViews();
        if (getItemCount() == 0) {
            detachAndScrapAttachedViews(nVar);
            this.uZx = 0;
            AppMethodBeat.o(250005);
        } else if (getChildCount() != 0 || !sVar.lL()) {
            detachAndScrapAttachedViews(nVar);
            if (getChildCount() == 0) {
                this.uZu = getWidth();
                this.uZv = getHeight();
                this.left = getPaddingLeft();
                this.right = getPaddingRight();
                this.top = getPaddingTop();
                this.uZw = (this.uZu - this.left) - this.right;
            }
            int itemCount = getItemCount();
            int i6 = 0;
            while (i6 < itemCount) {
                Log.d(this.TAG, "index:".concat(String.valueOf(i6)));
                View cp = nVar.cp(i6);
                p.g(cp, "recycler.getViewForPosition(i)");
                if (8 != cp.getVisibility()) {
                    measureChildWithMargins(cp, 0, 0);
                    int decoratedMeasuredWidth = getDecoratedMeasuredWidth(cp);
                    int decoratedMeasuredHeight = getDecoratedMeasuredHeight(cp);
                    if (i4 + decoratedMeasuredWidth <= this.uZw) {
                        int i7 = this.left + i4;
                        Rect rect = this.uZB.get(i6);
                        if (rect == null) {
                            rect = new Rect();
                        }
                        rect.set(i7, i3, i7 + decoratedMeasuredWidth, i3 + decoratedMeasuredHeight);
                        this.uZB.put(i6, rect);
                        i4 += decoratedMeasuredWidth;
                        int max = Math.max(i5, decoratedMeasuredHeight);
                        this.uZz.a(new a(this, decoratedMeasuredHeight, cp, rect));
                        this.uZz.uZE = (float) i3;
                        this.uZz.maxHeight = (float) max;
                        i2 = max;
                    } else {
                        dmb();
                        i3 += i5;
                        this.uZy += i5;
                        int i8 = this.left;
                        Rect rect2 = this.uZB.get(i6);
                        if (rect2 == null) {
                            rect2 = new Rect();
                        }
                        rect2.set(i8, i3, i8 + decoratedMeasuredWidth, i3 + decoratedMeasuredHeight);
                        this.uZB.put(i6, rect2);
                        this.uZz.a(new a(this, decoratedMeasuredHeight, cp, rect2));
                        this.uZz.uZE = (float) i3;
                        this.uZz.maxHeight = (float) decoratedMeasuredHeight;
                        i2 = decoratedMeasuredHeight;
                        i4 = decoratedMeasuredWidth;
                    }
                    if (i6 == getItemCount() - 1) {
                        dmb();
                        this.uZy += i2;
                    }
                } else {
                    i2 = i5;
                }
                i6++;
                i5 = i2;
            }
            this.uZy = Math.max(this.uZy, dmc());
            Log.d(this.TAG, "onLayoutChildren totalHeight:" + this.uZy);
            g(sVar);
            AppMethodBeat.o(250005);
        } else {
            AppMethodBeat.o(250005);
        }
    }

    private final void g(RecyclerView.s sVar) {
        AppMethodBeat.i(250006);
        if (sVar.lL() || getItemCount() == 0) {
            AppMethodBeat.o(250006);
            return;
        }
        new Rect(getPaddingLeft(), getPaddingTop() + this.uZx, getWidth() - getPaddingRight(), this.uZx + (getHeight() - getPaddingBottom()));
        int size = this.uZA.size();
        for (int i2 = 0; i2 < size; i2++) {
            List<a> list = this.uZA.get(i2).uZF;
            int size2 = list.size();
            for (int i3 = 0; i3 < size2; i3++) {
                View view = list.get(i3).view;
                measureChildWithMargins(view, 0, 0);
                addView(view);
                Rect rect = list.get(i3).rect;
                layoutDecoratedWithMargins(view, rect.left, rect.top - this.uZx, rect.right, rect.bottom - this.uZx);
            }
        }
        AppMethodBeat.o(250006);
    }

    private final void dmb() {
        Rect rect;
        AppMethodBeat.i(250007);
        List<a> list = this.uZz.uZF;
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            a aVar = list.get(i2);
            View view = aVar.view;
            int position = getPosition(view);
            if (((float) this.uZB.get(position).top) < ((this.uZz.maxHeight - ((float) list.get(i2).uZC)) / 2.0f) + this.uZz.uZE) {
                Rect rect2 = this.uZB.get(position);
                if (rect2 == null) {
                    rect = new Rect();
                } else {
                    rect = rect2;
                }
                rect.set(this.uZB.get(position).left, (int) (((this.uZz.maxHeight - ((float) list.get(i2).uZC)) / 2.0f) + this.uZz.uZE), this.uZB.get(position).right, (int) (((this.uZz.maxHeight - ((float) list.get(i2).uZC)) / 2.0f) + this.uZz.uZE + ((float) getDecoratedMeasuredHeight(view))));
                this.uZB.put(position, rect);
                p.h(rect, "<set-?>");
                aVar.rect = rect;
                list.set(i2, aVar);
            }
        }
        b bVar = this.uZz;
        p.h(list, "<set-?>");
        bVar.uZF = list;
        this.uZA.add(this.uZz);
        this.uZz = new b();
        AppMethodBeat.o(250007);
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public final boolean canScrollVertically() {
        return true;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager
    public final int scrollVerticallyBy(int i2, RecyclerView.n nVar, RecyclerView.s sVar) {
        AppMethodBeat.i(250008);
        p.h(nVar, "recycler");
        p.h(sVar, "state");
        Log.d("TAG", "totalHeight:" + this.uZy);
        if (this.uZx + i2 < 0) {
            i2 = -this.uZx;
        } else if (this.uZx + i2 > this.uZy - dmc()) {
            i2 = (this.uZy - dmc()) - this.uZx;
        }
        this.uZx += i2;
        offsetChildrenVertical(-i2);
        g(sVar);
        AppMethodBeat.o(250008);
        return i2;
    }

    private final int dmc() {
        AppMethodBeat.i(250009);
        int height = (this.uZt.getHeight() - this.uZt.getPaddingBottom()) - this.uZt.getPaddingTop();
        AppMethodBeat.o(250009);
        return height;
    }
}
