package com.tencent.mm.plugin.story.ui.view.gallery;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.smtt.sdk.WebView;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J(\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J \u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0018H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryDividerDecoration;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "orientation", "", "(I)V", "bounds", "Landroid/graphics/Rect;", "divider", "Landroid/graphics/drawable/Drawable;", "dividerSize", "getOrientation", "()I", "drawHorizontal", "", "canvas", "Landroid/graphics/Canvas;", "parent", "Landroid/support/v7/widget/RecyclerView;", "drawVertical", "getItemOffsets", "outRect", "view", "Landroid/view/View;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "onDraw", "c", "Companion", "plugin-story_release"})
public final class b extends RecyclerView.h {
    public static final a FEJ = new a((byte) 0);
    private int FEI = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 16);
    private final Rect hN = new Rect();
    private final Drawable kjR = new ColorDrawable(WebView.NIGHT_MODE_COLOR);
    private final int orientation;

    static {
        AppMethodBeat.i(120329);
        AppMethodBeat.o(120329);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/story/ui/view/gallery/GalleryDividerDecoration$Companion;", "", "()V", "Horizontal", "", "Vertical", "plugin-story_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public b(int i2) {
        AppMethodBeat.i(120328);
        this.orientation = i2;
        AppMethodBeat.o(120328);
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public final void a(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
        int height;
        int i2;
        int width;
        int i3;
        int i4 = 0;
        AppMethodBeat.i(120326);
        p.h(canvas, "c");
        p.h(recyclerView, "parent");
        p.h(sVar, "state");
        if (recyclerView.getLayoutManager() == null) {
            AppMethodBeat.o(120326);
        } else if (this.orientation == 1) {
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
                RecyclerView.getDecoratedBoundsWithMargins(childAt, this.hN);
                int i5 = this.hN.bottom;
                p.g(childAt, "child");
                int round = Math.round(childAt.getTranslationY()) + i5;
                this.kjR.setBounds(i3, round - this.FEI, width, round);
                this.kjR.draw(canvas);
                i4++;
            }
            canvas.restore();
            AppMethodBeat.o(120326);
        } else {
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
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                if (layoutManager != null) {
                    layoutManager.getDecoratedBoundsWithMargins(childAt2, this.hN);
                }
                int i6 = this.hN.right;
                p.g(childAt2, "child");
                int round2 = Math.round(childAt2.getTranslationX()) + i6;
                this.kjR.setBounds(round2 - this.FEI, i2, round2, height);
                this.kjR.draw(canvas);
                i4++;
            }
            canvas.restore();
            AppMethodBeat.o(120326);
        }
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
        int i2;
        AppMethodBeat.i(120327);
        p.h(rect, "outRect");
        p.h(view, "view");
        p.h(recyclerView, "parent");
        p.h(sVar, "state");
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        int position = layoutManager != null ? layoutManager.getPosition(view) : -1;
        RecyclerView.LayoutManager layoutManager2 = recyclerView.getLayoutManager();
        if (layoutManager2 != null) {
            i2 = layoutManager2.getItemCount();
        } else {
            i2 = 0;
        }
        int i3 = i2 - 1;
        if (position < 0) {
            AppMethodBeat.o(120327);
            return;
        }
        if (i3 > position) {
            if (this.orientation == 0) {
                rect.set(0, 0, this.FEI, 0);
                AppMethodBeat.o(120327);
                return;
            }
            rect.set(0, 0, 0, this.FEI);
        }
        AppMethodBeat.o(120327);
    }
}
