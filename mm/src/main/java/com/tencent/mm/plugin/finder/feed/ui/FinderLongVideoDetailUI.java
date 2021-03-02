package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@com.tencent.mm.ui.base.a(ConstraintLayout.LayoutParams.Table.LAYOUT_CONSTRAINT_VERTICAL_CHAINSTYLE)
@l(hxD = {1, 1, 16}, hxE = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014¨\u0006\b"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLongVideoDetailUI;", "Lcom/tencent/mm/plugin/finder/feed/ui/FinderLongVideoTimelineUI;", "()V", "onNewIntent", "", "intent", "Landroid/content/Intent;", "Companion", "plugin-finder_release"})
public final class FinderLongVideoDetailUI extends FinderLongVideoTimelineUI {
    public static final a ubM = new a((byte) 0);
    private HashMap _$_findViewCache;

    static {
        AppMethodBeat.i(245414);
        AppMethodBeat.o(245414);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.plugin.finder.feed.ui.FinderLongVideoTimelineUI
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(245416);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(245416);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.plugin.finder.feed.ui.FinderLongVideoTimelineUI
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(245415);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(245415);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.plugin.finder.feed.ui.FinderLongVideoTimelineUI, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLongVideoDetailUI$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public final void onNewIntent(Intent intent) {
        AppMethodBeat.i(245413);
        super.onNewIntent(intent);
        Log.i("FinderLongVideoDetailUI", "onNewIntent: recreate for new mega video float ball click hash = ".concat(String.valueOf(this)));
        Intent intent2 = new Intent(intent);
        intent2.setFlags(0);
        com.tencent.mm.plugin.finder.utils.a aVar = com.tencent.mm.plugin.finder.utils.a.vUU;
        com.tencent.mm.plugin.finder.utils.a.d((Context) this, intent2, true);
        d.a(500, new b(this));
        AppMethodBeat.o(245413);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ FinderLongVideoDetailUI ubN;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(FinderLongVideoDetailUI finderLongVideoDetailUI) {
            super(0);
            this.ubN = finderLongVideoDetailUI;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(245412);
            this.ubN.finish();
            x xVar = x.SXb;
            AppMethodBeat.o(245412);
            return xVar;
        }
    }
}
