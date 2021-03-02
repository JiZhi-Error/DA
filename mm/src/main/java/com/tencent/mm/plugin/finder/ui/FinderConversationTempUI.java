package com.tencent.mm.plugin.finder.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.PluginFinder;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\b\u0010\u0007\u001a\u00020\u0006H\u0016¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/FinderConversationTempUI;", "Lcom/tencent/mm/plugin/finder/ui/FinderConversationParentUI;", "()V", "finish", "", "getLayoutId", "", "getTitleResId", "plugin-finder_release"})
public final class FinderConversationTempUI extends FinderConversationParentUI {
    private HashMap _$_findViewCache;

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.plugin.finder.ui.FinderConversationParentUI, com.tencent.mm.plugin.finder.ui.ReadyChattingCompatUI
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(252216);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(252216);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.plugin.finder.ui.FinderConversationParentUI, com.tencent.mm.plugin.finder.ui.ReadyChattingCompatUI
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(252215);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(252215);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.finder.ui.FinderConversationParentUI, com.tencent.mm.plugin.finder.ui.ReadyChattingCompatUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.MMActivity, com.tencent.mm.plugin.finder.ui.FinderConversationParentUI
    public final int getLayoutId() {
        return R.layout.a_8;
    }

    @Override // com.tencent.mm.plugin.finder.ui.FinderConversationParentUI
    public final int dzb() {
        return R.string.ck4;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public final void finish() {
        AppMethodBeat.i(252214);
        super.finish();
        a ah = g.ah(PluginFinder.class);
        p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
        ((PluginFinder) ah).getRedDotManager().tJB.das();
        a ah2 = g.ah(PluginFinder.class);
        p.g(ah2, "MMKernel.plugin(PluginFinder::class.java)");
        com.tencent.mm.plugin.finder.extension.reddot.a aVar = ((PluginFinder) ah2).getRedDotManager().tJB;
        aVar.handler.removeMessages(9);
        aVar.handler.sendEmptyMessage(9);
        AppMethodBeat.o(252214);
    }
}
