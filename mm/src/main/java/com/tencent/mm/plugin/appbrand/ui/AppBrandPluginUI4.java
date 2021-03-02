package com.tencent.mm.plugin.appbrand.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, hxF = {"Lcom/tencent/mm/plugin/appbrand/ui/AppBrandPluginUI4;", "Lcom/tencent/mm/plugin/appbrand/ui/AppBrandPluginUI;", "()V", "plugin-appbrand-integration_release"})
public final class AppBrandPluginUI4 extends AppBrandPluginUI {
    private HashMap _$_findViewCache;

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(229489);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(229489);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(229488);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(229488);
        return view;
    }

    @Override // com.tencent.mm.plugin.appbrand.ui.wxa_container.BaseAppBrandUIClipped, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.plugin.appbrand.ui.AppBrandPluginUI, com.tencent.mm.plugin.secdata.ui.MMSecDataFragmentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.appbrand.ui.AppBrandUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }
}
