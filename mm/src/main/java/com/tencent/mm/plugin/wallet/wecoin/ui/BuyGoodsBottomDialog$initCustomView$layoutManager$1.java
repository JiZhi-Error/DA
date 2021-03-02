package com.tencent.mm.plugin.wallet.wecoin.ui;

import android.support.v7.widget.LinearLayoutManager;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/wallet/wecoin/ui/BuyGoodsBottomDialog$initCustomView$layoutManager$1", "Landroid/support/v7/widget/LinearLayoutManager;", "canScrollHorizontally", "", "plugin-wxpay_release"})
public final class BuyGoodsBottomDialog$initCustomView$layoutManager$1 extends LinearLayoutManager {
    final /* synthetic */ a HOl;

    /* JADX WARN: Incorrect types in method signature: (Landroid/content/Context;)V */
    BuyGoodsBottomDialog$initCustomView$layoutManager$1(a aVar) {
        this.HOl = aVar;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final boolean canScrollHorizontally() {
        return false;
    }
}
