package com.tencent.mm.plugin.appbrand.ui.collection;

import android.support.v7.widget.LinearLayoutManager;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/appbrand/ui/collection/AppBrandCollectionDisplayVerticalList$initView$1$1", "Landroid/support/v7/widget/LinearLayoutManager;", "supportsPredictiveItemAnimations", "", "plugin-appbrand-integration_release"})
public final class AppBrandCollectionDisplayVerticalList$initView$$inlined$apply$lambda$1 extends LinearLayoutManager {
    final /* synthetic */ AppBrandCollectionDisplayVerticalList oaI;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppBrandCollectionDisplayVerticalList$initView$$inlined$apply$lambda$1(AppBrandCollectionDisplayVerticalList appBrandCollectionDisplayVerticalList) {
        super(1, false);
        this.oaI = appBrandCollectionDisplayVerticalList;
    }

    @Override // android.support.v7.widget.RecyclerView.LayoutManager, android.support.v7.widget.LinearLayoutManager
    public final boolean supportsPredictiveItemAnimations() {
        return false;
    }
}
