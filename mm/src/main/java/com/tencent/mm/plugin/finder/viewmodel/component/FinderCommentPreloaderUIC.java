package com.tencent.mm.plugin.finder.viewmodel.component;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.d;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderCommentPreloaderUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "plugin-finder_release"})
public final class FinderCommentPreloaderUIC extends UIComponent {
    public final d tLy;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderCommentPreloaderUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(255447);
        this.tLy = new d(appCompatActivity);
        AppMethodBeat.o(255447);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderCommentPreloaderUIC(Fragment fragment) {
        super(fragment);
        p.h(fragment, "fragment");
        AppMethodBeat.i(255448);
        FragmentActivity activity = fragment.getActivity();
        if (activity == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMFragmentActivity");
            AppMethodBeat.o(255448);
            throw tVar;
        }
        this.tLy = new d((MMFragmentActivity) activity);
        AppMethodBeat.o(255448);
    }
}