package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0016J\b\u0010\u0013\u001a\u00020\u000eH\u0016R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0015"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFeedFriendLikeDrawerUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "drawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "getDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "setDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;)V", "onBackPressed", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "Companion", "plugin-finder_release"})
public final class FinderFeedFriendLikeDrawerUIC extends UIComponent {
    public static final a wwa = new a((byte) 0);
    FinderLikeDrawer wvZ;

    static {
        AppMethodBeat.i(255497);
        AppMethodBeat.o(255497);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderFeedFriendLikeDrawerUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(255496);
        AppMethodBeat.o(255496);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderFeedFriendLikeDrawerUIC$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final boolean onBackPressed() {
        AppMethodBeat.i(255493);
        if (this.wvZ == null) {
            this.wvZ = (FinderLikeDrawer) getActivity().findViewById(R.id.clq);
        }
        if (this.wvZ == null) {
            AppMethodBeat.o(255493);
            return false;
        }
        FinderLikeDrawer finderLikeDrawer = this.wvZ;
        if (finderLikeDrawer == null) {
            p.hyc();
        }
        if (finderLikeDrawer.dGs()) {
            FinderLikeDrawer finderLikeDrawer2 = this.wvZ;
            if (finderLikeDrawer2 == null) {
                p.hyc();
            }
            finderLikeDrawer2.dGr();
            AppMethodBeat.o(255493);
            return true;
        }
        AppMethodBeat.o(255493);
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onResume() {
        AppMethodBeat.i(255494);
        super.onResume();
        AppMethodBeat.o(255494);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onPause() {
        AppMethodBeat.i(255495);
        super.onPause();
        AppMethodBeat.o(255495);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
    }
}
