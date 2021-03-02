package com.tencent.mm.plugin.finder.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.c;
import com.tencent.mm.plugin.finder.feed.c.a;
import com.tencent.mm.plugin.finder.feed.c.b;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.HashMap;
import java.util.Set;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH&J\r\u0010\u000f\u001a\u00028\u0001H&¢\u0006\u0002\u0010\u0010J\r\u0010\u0011\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0012J\u0018\u0010\u0013\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00160\u0015\u0018\u00010\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0018H&J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0018H\u0016J\b\u0010\u001d\u001a\u00020\u0018H\u0016J\b\u0010\u001e\u001a\u00020\u0018H\u0016J\u001a\u0010\u001f\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016R\u001b\u0010\u0007\u001a\u00020\b8FX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderBaseGridFeedFragment;", "V", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "()V", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "getActivity", "()Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "activity$delegate", "Lkotlin/Lazy;", "getLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initAfterAttach", "", "initOnCreate", "onBackPressed", "", "onDestroy", "onPause", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder_release"})
public abstract class FinderBaseGridFeedFragment<V extends c.b, P extends c.a> extends FinderHomeTabFragment {
    private HashMap _$_findViewCache;
    private final f vQp = g.ah(new a(this));

    @Override // com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment, com.tencent.mm.ui.component.UIComponentFragment
    public void _$_clearFindViewByIdCache() {
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
    }

    public final MMFinderUI dAq() {
        return (MMFinderUI) this.vQp.getValue();
    }

    public abstract P dcq();

    public abstract V ddS();

    public abstract void initOnCreate();

    @Override // com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment, com.tencent.mm.ui.component.UIComponentFragment, android.support.v4.app.Fragment
    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        _$_clearFindViewByIdCache();
    }

    @Override // com.tencent.mm.ui.component.UIComponentFragment
    public final Set<Class<? extends UIComponent>> importUIComponents() {
        return null;
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        p.h(view, "view");
        initOnCreate();
        dcq().onAttach(ddS());
    }

    @Override // com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment
    public final boolean onBackPressed() {
        return dcq().onBackPressed();
    }

    @Override // com.tencent.mm.ui.component.UIComponentFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        dcq();
    }

    @Override // com.tencent.mm.ui.component.UIComponentFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        dcq();
    }

    @Override // com.tencent.mm.ui.component.UIComponentFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        dcq().onDetach();
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0004*\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "V", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "invoke"})
    static final class a extends q implements kotlin.g.a.a<MMFinderUI> {
        final /* synthetic */ FinderBaseGridFeedFragment vQq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(FinderBaseGridFeedFragment finderBaseGridFeedFragment) {
            super(0);
            this.vQq = finderBaseGridFeedFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MMFinderUI invoke() {
            AppMethodBeat.i(252842);
            FragmentActivity activity = this.vQq.getActivity();
            if (activity == null) {
                p.hyc();
            }
            if (activity == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.MMFinderUI");
                AppMethodBeat.o(252842);
                throw tVar;
            }
            MMFinderUI mMFinderUI = (MMFinderUI) activity;
            AppMethodBeat.o(252842);
            return mMFinderUI;
        }
    }
}
