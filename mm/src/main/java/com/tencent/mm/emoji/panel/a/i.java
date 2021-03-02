package com.tencent.mm.emoji.panel.a;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, hxF = {"Lcom/tencent/mm/emoji/panel/adapter/EmojiPanelItemDecoration;", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "sizeResolver", "Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;", "(Lcom/tencent/mm/emoji/panel/adapter/PanelSizeResolver;)V", "TAG", "", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "plugin-emojisdk_release"})
public final class i extends RecyclerView.h {
    private final String TAG = "MicroMsg.EmojiPanelItemDecoration";
    private final o hah;

    public i(o oVar) {
        p.h(oVar, "sizeResolver");
        AppMethodBeat.i(105667);
        this.hah = oVar;
        AppMethodBeat.o(105667);
    }

    @Override // android.support.v7.widget.RecyclerView.h
    public final void a(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
        AppMethodBeat.i(105666);
        p.h(rect, "outRect");
        p.h(view, "view");
        p.h(recyclerView, "parent");
        p.h(sVar, "state");
        RecyclerView.a adapter = recyclerView.getAdapter();
        if (adapter == null) {
            AppMethodBeat.o(105666);
            return;
        }
        p.g(adapter, "parent.adapter ?: return");
        int bw = RecyclerView.bw(view);
        if (bw == -1) {
            AppMethodBeat.o(105666);
            return;
        }
        int itemViewType = adapter.getItemViewType(bw);
        int i2 = this.hah.hbf;
        switch (itemViewType) {
            case 2:
                rect.set(i2, 0, i2, 0);
                break;
        }
        AppMethodBeat.o(105666);
    }
}
