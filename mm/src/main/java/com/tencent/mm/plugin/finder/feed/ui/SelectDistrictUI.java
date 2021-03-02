package com.tencent.mm.plugin.finder.feed.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.ui.FinderSelectDistrictUI;
import java.util.HashMap;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/SelectDistrictUI;", "Lcom/tencent/mm/plugin/finder/ui/FinderSelectDistrictUI;", "()V", "plugin-finder_release"})
public final class SelectDistrictUI extends FinderSelectDistrictUI {
    private HashMap _$_findViewCache;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.plugin.finder.ui.FinderSelectDistrictUI
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(245773);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(245773);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.plugin.finder.ui.FinderSelectDistrictUI
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(245772);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(245772);
        return view;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.finder.ui.FinderSelectDistrictUI, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }
}
