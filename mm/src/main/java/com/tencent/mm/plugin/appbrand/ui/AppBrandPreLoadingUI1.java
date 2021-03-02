package com.tencent.mm.plugin.appbrand.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI1;", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandPreLoadingUI;", "()V", "plugin-appbrand-integration_release"})
public final class AppBrandPreLoadingUI1 extends AppBrandPreLoadingUI {
    private HashMap _$_findViewCache;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.plugin.appbrand.ui.AppBrandPreLoadingUI
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(229495);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(229495);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.plugin.appbrand.ui.AppBrandPreLoadingUI
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(229494);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(229494);
        return view;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.plugin.secdata.ui.MMSecDataFragmentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.appbrand.ui.AppBrandPreLoadingUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }
}
