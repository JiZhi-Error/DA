package com.tencent.mm.emoji.panel.a;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016R\u0012\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/emoji/panel/adapter/PanelSpanSizeLookup;", "Landroid/support/v7/widget/GridLayoutManager$SpanSizeLookup;", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "layoutManager", "Landroid/support/v7/widget/GridLayoutManager;", "(Landroid/support/v7/widget/RecyclerView$Adapter;Landroid/support/v7/widget/GridLayoutManager;)V", "getSpanSize", "", "position", "plugin-emojisdk_release"})
public final class p extends GridLayoutManager.b {
    private final GridLayoutManager haU;
    private final RecyclerView.a<?> hbg;

    public p(RecyclerView.a<?> aVar, GridLayoutManager gridLayoutManager) {
        kotlin.g.b.p.h(aVar, "adapter");
        kotlin.g.b.p.h(gridLayoutManager, "layoutManager");
        AppMethodBeat.i(105676);
        this.hbg = aVar;
        this.haU = gridLayoutManager;
        AppMethodBeat.o(105676);
    }

    @Override // android.support.v7.widget.GridLayoutManager.b
    public final int bX(int i2) {
        AppMethodBeat.i(105675);
        switch (this.hbg.getItemViewType(i2)) {
            case 2:
            case 4:
            case 5:
            case 7:
                int ki = this.haU.ki();
                AppMethodBeat.o(105675);
                return ki;
            case 3:
            case 6:
            default:
                AppMethodBeat.o(105675);
                return 1;
        }
    }
}
