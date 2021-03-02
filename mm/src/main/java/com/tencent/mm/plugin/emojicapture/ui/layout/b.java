package com.tencent.mm.plugin.emojicapture.ui.layout;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/emojicapture/ui/layout/RecommendStickerDecoration;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "itemPadding", "", "itemWidth", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-emojicapture_release"})
public final class b extends RecyclerView.h {
    private final int itemPadding;
    private final int qmd;

    public b(Context context) {
        p.h(context, "context");
        AppMethodBeat.i(883);
        this.qmd = context.getResources().getDimensionPixelSize(R.dimen.a1y);
        this.itemPadding = context.getResources().getDimensionPixelSize(R.dimen.ct);
        AppMethodBeat.o(883);
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
        int width;
        AppMethodBeat.i(882);
        p.h(rect, "outRect");
        p.h(view, "view");
        p.h(recyclerView, "parent");
        p.h(sVar, "state");
        int bw = RecyclerView.bw(view);
        RecyclerView.a adapter = recyclerView.getAdapter();
        int itemCount = adapter != null ? adapter.getItemCount() : 0;
        RecyclerView.a adapter2 = recyclerView.getAdapter();
        Integer valueOf = adapter2 != null ? Integer.valueOf(adapter2.getItemViewType(bw)) : null;
        if (bw == 0) {
            rect.set((recyclerView.getWidth() - this.qmd) / 2, 0, this.itemPadding, 0);
            AppMethodBeat.o(882);
        } else if (bw == itemCount - 1) {
            if (valueOf != null && valueOf.intValue() == 2) {
                width = ((recyclerView.getWidth() / 2) - ((this.qmd / 2) * 3)) - (this.itemPadding * 2);
            } else {
                width = (recyclerView.getWidth() - this.qmd) / 2;
            }
            rect.set(this.itemPadding, 0, width, 0);
            AppMethodBeat.o(882);
        } else {
            rect.set(this.itemPadding, 0, this.itemPadding, 0);
            AppMethodBeat.o(882);
        }
    }
}
