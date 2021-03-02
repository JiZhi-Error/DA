package com.tencent.mm.plugin.card.ui.v3;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.HeadFooterLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJP\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0014H\u0016J \u0010\u001a\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\tH\u0016¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/card/ui/v3/CardRefreshLoadMoreLayout;", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "onOverScroll", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "parent", "Lcom/tencent/mm/view/HeadFooterLayout;", "dy", "dampingDy", "isEnd", "", "isVertical", "consumed", "", "type", "isTopOverScroll", "onStopScroll", "plugin-card_release"})
public final class CardRefreshLoadMoreLayout extends RefreshLoadMoreLayout {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CardRefreshLoadMoreLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(201484);
        AppMethodBeat.o(201484);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CardRefreshLoadMoreLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        p.h(attributeSet, "attrs");
        AppMethodBeat.i(201485);
        AppMethodBeat.o(201485);
    }

    @Override // com.tencent.mm.view.HeadFooterLayout, com.tencent.mm.view.RefreshLoadMoreLayout
    public final void a(RecyclerView recyclerView, HeadFooterLayout headFooterLayout, int i2, int i3, boolean z, boolean z2, int[] iArr, int i4, boolean z3) {
        AppMethodBeat.i(201482);
        p.h(recyclerView, "recyclerView");
        p.h(headFooterLayout, "parent");
        p.h(iArr, "consumed");
        if (i4 == 1 && w(recyclerView) && this.isRefreshing) {
            recyclerView.kQ();
        }
        super.a(recyclerView, headFooterLayout, i2, i3, z, z2, iArr, i4, z3);
        AppMethodBeat.o(201482);
    }

    @Override // com.tencent.mm.view.HeadFooterLayout, com.tencent.mm.view.RefreshLoadMoreLayout
    public final void a(RecyclerView recyclerView, HeadFooterLayout headFooterLayout, int i2) {
        AppMethodBeat.i(201483);
        p.h(recyclerView, "recyclerView");
        p.h(headFooterLayout, "parent");
        super.a(recyclerView, headFooterLayout, i2);
        if (i2 == 0) {
            if (RefreshLoadMoreLayout.a((RefreshLoadMoreLayout) this, false, (String) null, 3) && this.isRefreshing && this.RlW) {
                recyclerView.kQ();
                RefreshLoadMoreLayout.a(this);
                AppMethodBeat.o(201483);
                return;
            }
        } else if (i2 == 1 && w(recyclerView) && this.isRefreshing && this.RlW) {
            recyclerView.kQ();
            RefreshLoadMoreLayout.a(this);
        }
        AppMethodBeat.o(201483);
    }
}
