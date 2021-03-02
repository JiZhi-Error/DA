package com.tencent.mm.plugin.finder.feed.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.profile.uic.FinderProfileActionBarUIC;
import com.tencent.mm.plugin.finder.profile.uic.FinderProfileDistrictTipUIC;
import com.tencent.mm.plugin.finder.profile.uic.FinderProfileEduUIC;
import com.tencent.mm.plugin.finder.profile.uic.FinderProfileFloatBallUIC;
import com.tencent.mm.plugin.finder.profile.uic.FinderProfileHeaderUIC;
import com.tencent.mm.plugin.finder.profile.uic.FinderProfileTabUIC;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderLivePostBtnUIC;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashMap;
import java.util.Set;
import kotlin.a.ak;
import kotlin.g.b.p;
import kotlin.l;

@com.tencent.mm.ui.base.a(32)
@l(hxD = {1, 1, 16}, hxE = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\u0006\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\u0018\u00010\u0007H\u0016¨\u0006\u000b"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderProfileUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "getCommentScene", "", "getReportType", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "Companion", "plugin-finder_release"})
public final class FinderProfileUI extends MMFinderUI {
    private static final int ucA = 2001;
    public static final a ucB = new a((byte) 0);
    private HashMap _$_findViewCache;

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(245492);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(245492);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity
    public final View _$_findCachedViewById(int i2) {
        AppMethodBeat.i(245491);
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i2));
        if (view == null) {
            view = findViewById(i2);
            this._$_findViewCache.put(Integer.valueOf(i2), view);
        }
        AppMethodBeat.o(245491);
        return view;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public FinderProfileUI() {
        AppMethodBeat.i(166212);
        AppMethodBeat.o(166212);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$Companion;", "", "()V", "MARK_READ_PAYLOAD", "", "getMARK_READ_PAYLOAD", "()I", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(166213);
        AppMethodBeat.o(166213);
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMFragmentActivity
    public final Set<Class<? extends UIComponent>> importUIComponents() {
        AppMethodBeat.i(245489);
        Set<Class<? extends UIComponent>> of = ak.setOf((Object[]) new Class[]{FinderProfileTabUIC.class, FinderProfileActionBarUIC.class, FinderProfileHeaderUIC.class, FinderProfileDistrictTipUIC.class, FinderProfileEduUIC.class, FinderLivePostBtnUIC.class, FinderProfileFloatBallUIC.class});
        AppMethodBeat.o(245489);
        return of;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int getCommentScene() {
        boolean z = false;
        AppMethodBeat.i(245490);
        String stringExtra = getIntent().getStringExtra("finder_username");
        boolean booleanExtra = getIntent().getBooleanExtra("KEY_FINDER_SELF_FLAG", false);
        if (p.j(stringExtra, z.aUg()) && booleanExtra) {
            z = true;
        }
        if (z) {
            AppMethodBeat.o(245490);
            return 33;
        }
        AppMethodBeat.o(245490);
        return 32;
    }

    @Override // com.tencent.mm.plugin.finder.ui.MMFinderUI
    public final int ddN() {
        return 3;
    }
}
