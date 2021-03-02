package com.tencent.mm.plugin.finder.ui.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.megavideo.ui.a;
import com.tencent.mm.plugin.finder.megavideo.ui.a.AbstractC1222a;
import com.tencent.mm.plugin.finder.megavideo.ui.a.b;
import com.tencent.mm.plugin.finder.model.bo;
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

@l(hxD = {1, 1, 16}, hxE = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002*\b\b\u0001\u0010\u0004*\u00020\u0005*\b\b\u0002\u0010\u0006*\u00020\u00072\u00020\bB\u0005¢\u0006\u0002\u0010\tJ\r\u0010\u0010\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0011J\r\u0010\u0012\u001a\u00028\u0002H&¢\u0006\u0002\u0010\u0013J\r\u0010\u0014\u001a\u00028\u0001H&¢\u0006\u0002\u0010\u0015J\u0018\u0010\u0016\u001a\u0012\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00190\u0018\u0018\u00010\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u001bH&J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001bH\u0016J\b\u0010\u001f\u001a\u00020\u001bH\u0016J\b\u0010 \u001a\u00020\u001bH\u0016J\u001a\u0010!\u001a\u00020\u001b2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016R\u001b\u0010\n\u001a\u00020\u000b8FX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006&"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderBaseMegaVideoFeedFragment;", "M", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "V", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "()V", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "getActivity", "()Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "activity$delegate", "Lkotlin/Lazy;", "getLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$Presenter;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback;", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initOnCreate", "", "onBackPressed", "", "onDestroy", "onPause", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "plugin-finder_release"})
public abstract class FinderBaseMegaVideoFeedFragment<M extends BaseFeedLoader<bo>, V extends a.b, P extends a.AbstractC1222a> extends FinderHomeTabFragment {
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

    public abstract P dkn();

    public abstract V dma();

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
        dkn().onAttach(dma());
    }

    @Override // com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment
    public final boolean onBackPressed() {
        dkn();
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        dkn();
    }

    @Override // com.tencent.mm.ui.component.UIComponentFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        dkn();
    }

    @Override // com.tencent.mm.ui.component.UIComponentFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        dkn().onDetach();
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u000e\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u00020\u00040\u0003\"\b\b\u0001\u0010\u0005*\u00020\u0006\"\b\b\u0002\u0010\u0007*\u00020\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "M", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "V", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$ViewCallback;", "P", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderBaseMegaVideoUIContract$Presenter;", "invoke"})
    static final class a extends q implements kotlin.g.a.a<MMFinderUI> {
        final /* synthetic */ FinderBaseMegaVideoFeedFragment vQr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(FinderBaseMegaVideoFeedFragment finderBaseMegaVideoFeedFragment) {
            super(0);
            this.vQr = finderBaseMegaVideoFeedFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ MMFinderUI invoke() {
            AppMethodBeat.i(252843);
            FragmentActivity activity = this.vQr.getActivity();
            if (activity == null) {
                p.hyc();
            }
            if (activity == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.MMFinderUI");
                AppMethodBeat.o(252843);
                throw tVar;
            }
            MMFinderUI mMFinderUI = (MMFinderUI) activity;
            AppMethodBeat.o(252843);
            return mMFinderUI;
        }
    }
}
