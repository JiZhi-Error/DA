package com.tencent.mm.plugin.finder.profile;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.megavideo.loader.FinderMegaVideoProfileLoader;
import com.tencent.mm.plugin.finder.megavideo.ui.d;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.ui.fragment.FinderBaseMegaVideoFeedFragment;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.HashMap;
import kotlin.f;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0002H\u0016J\b\u0010\u0017\u001a\u00020\u0004H\u0016J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u001a\u0010\u0006\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R#\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\r8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0013\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/finder/profile/FinderProfileMegaVideoFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderBaseMegaVideoFeedFragment;", "Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoProfileLoader;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderMegaVideoProfileUIContract$Presenter;", "()V", "feedLoader", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoProfileLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderMegaVideoProfileLoader;)V", "presenter", "targetUsername", "", "kotlin.jvm.PlatformType", "getTargetUsername", "()Ljava/lang/String;", "targetUsername$delegate", "Lkotlin/Lazy;", "viewCallback", "getLayoutId", "", "getLoader", "getPresenter", "getViewCallback", "initOnCreate", "", "Companion", "plugin-finder_release"})
public final class FinderProfileMegaVideoFragment extends FinderBaseMegaVideoFeedFragment<FinderMegaVideoProfileLoader, d.b, d.a> {
    public static final a uZl = new a((byte) 0);
    private HashMap _$_findViewCache;
    private d.a uKA;
    private d.b uZi;
    public FinderMegaVideoProfileLoader uZj;
    private final f uZk = g.ah(new d(this));

    static {
        AppMethodBeat.i(249988);
        AppMethodBeat.o(249988);
    }

    private final String dlZ() {
        AppMethodBeat.i(249983);
        String str = (String) this.uZk.getValue();
        AppMethodBeat.o(249983);
        return str;
    }

    @Override // com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment, com.tencent.mm.ui.component.UIComponentFragment, com.tencent.mm.plugin.finder.ui.fragment.FinderBaseMegaVideoFeedFragment
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(249990);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(249990);
    }

    @Override // com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment, com.tencent.mm.ui.component.UIComponentFragment, com.tencent.mm.plugin.finder.ui.fragment.FinderBaseMegaVideoFeedFragment, android.support.v4.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        AppMethodBeat.i(249991);
        super.onDestroyView();
        _$_clearFindViewByIdCache();
        AppMethodBeat.o(249991);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/profile/FinderProfileMegaVideoFragment$initOnCreate$1$2"})
    static final class c extends q implements kotlin.g.a.b<IResponse<bo>, x> {
        final /* synthetic */ FinderProfileMegaVideoFragment uZm;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderProfileMegaVideoFragment finderProfileMegaVideoFragment) {
            super(1);
            this.uZm = finderProfileMegaVideoFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(IResponse<bo> iResponse) {
            View findViewById;
            TextView textView;
            TextView textView2;
            TextView textView3;
            AppMethodBeat.i(249981);
            IResponse<bo> iResponse2 = iResponse;
            p.h(iResponse2, LocaleUtil.ITALIAN);
            if (!((FinderMegaVideoProfileLoader.b) iResponse2).getHasMore()) {
                RefreshLoadMoreLayout refreshLoadMoreLayout = FinderProfileMegaVideoFragment.a(this.uZm).tLS;
                FinderMegaVideoProfileLoader finderMegaVideoProfileLoader = this.uZm.uZj;
                if (finderMegaVideoProfileLoader == null) {
                    p.btv("feedLoader");
                }
                refreshLoadMoreLayout.setEnableLoadMore(finderMegaVideoProfileLoader.getSize() > 5);
                View loadMoreFooter = FinderProfileMegaVideoFragment.a(this.uZm).tLS.getLoadMoreFooter();
                if (!(loadMoreFooter == null || (textView3 = (TextView) loadMoreFooter.findViewById(R.id.ep1)) == null)) {
                    textView3.setText(R.string.d0m);
                }
                View loadMoreFooter2 = FinderProfileMegaVideoFragment.a(this.uZm).tLS.getLoadMoreFooter();
                if (!(loadMoreFooter2 == null || (textView2 = (TextView) loadMoreFooter2.findViewById(R.id.ep1)) == null)) {
                    textView2.setTextColor(this.uZm.getResources().getColor(R.color.FG_2));
                }
                View loadMoreFooter3 = FinderProfileMegaVideoFragment.a(this.uZm).tLS.getLoadMoreFooter();
                if (!(loadMoreFooter3 == null || (textView = (TextView) loadMoreFooter3.findViewById(R.id.ep1)) == null)) {
                    textView.setVisibility(8);
                }
                View loadMoreFooter4 = FinderProfileMegaVideoFragment.a(this.uZm).tLS.getLoadMoreFooter();
                if (!(loadMoreFooter4 == null || (findViewById = loadMoreFooter4.findViewById(R.id.ep0)) == null)) {
                    findViewById.setVisibility(0);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(249981);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/profile/FinderProfileMegaVideoFragment$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public FinderProfileMegaVideoFragment() {
        AppMethodBeat.i(249987);
        this.dLS = 105;
        AppMethodBeat.o(249987);
    }

    public static final /* synthetic */ d.b a(FinderProfileMegaVideoFragment finderProfileMegaVideoFragment) {
        AppMethodBeat.i(249989);
        d.b bVar = finderProfileMegaVideoFragment.uZi;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        AppMethodBeat.o(249989);
        return bVar;
    }

    @Override // com.tencent.mm.ui.component.UIComponentFragment
    public final int getLayoutId() {
        return R.layout.agp;
    }

    @Override // com.tencent.mm.plugin.finder.ui.fragment.FinderBaseMegaVideoFeedFragment
    public final void initOnCreate() {
        AppMethodBeat.i(249984);
        String dlZ = dlZ();
        p.g(dlZ, "targetUsername");
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        FinderMegaVideoProfileLoader finderMegaVideoProfileLoader = new FinderMegaVideoProfileLoader(dlZ, ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(dAq()).get(FinderReporterUIC.class)).dIx());
        finderMegaVideoProfileLoader.uKQ = true;
        finderMegaVideoProfileLoader.setInitDone(new b(this));
        finderMegaVideoProfileLoader.fetchEndCallback = new c(this);
        this.uZj = finderMegaVideoProfileLoader;
        MMFinderUI dAq = dAq();
        FinderMegaVideoProfileLoader finderMegaVideoProfileLoader2 = this.uZj;
        if (finderMegaVideoProfileLoader2 == null) {
            p.btv("feedLoader");
        }
        this.uKA = new d.a(dAq, finderMegaVideoProfileLoader2);
        MMFinderUI dAq2 = dAq();
        View view = getView();
        if (view == null) {
            p.hyc();
        }
        p.g(view, "view!!");
        String dlZ2 = dlZ();
        p.g(dlZ2, "targetUsername");
        this.uZi = new d.b(dAq2, view, dlZ2);
        d.b bVar = this.uZi;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        d.a aVar2 = this.uKA;
        if (aVar2 == null) {
            p.btv("presenter");
        }
        bVar.a(aVar2);
        AppMethodBeat.o(249984);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/profile/FinderProfileMegaVideoFragment$initOnCreate$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
    public static final class b implements h {
        final /* synthetic */ FinderProfileMegaVideoFragment uZm;

        b(FinderProfileMegaVideoFragment finderProfileMegaVideoFragment) {
            this.uZm = finderProfileMegaVideoFragment;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.h
        public final void call(int i2) {
            View emptyView;
            RecyclerView recyclerView;
            AppMethodBeat.i(249980);
            d.b a2 = FinderProfileMegaVideoFragment.a(this.uZm);
            if (a2 == null || (emptyView = a2.getEmptyView()) == null) {
                AppMethodBeat.o(249980);
                return;
            }
            emptyView.setVisibility(8);
            d.b a3 = FinderProfileMegaVideoFragment.a(this.uZm);
            if (!(a3 == null || (recyclerView = a3.tLS.getRecyclerView()) == null)) {
                recyclerView.setVisibility(0);
            }
            EventCenter.instance.publish(new hn());
            AppMethodBeat.o(249980);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "", "kotlin.jvm.PlatformType", "invoke"})
    static final class d extends q implements kotlin.g.a.a<String> {
        final /* synthetic */ FinderProfileMegaVideoFragment uZm;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(FinderProfileMegaVideoFragment finderProfileMegaVideoFragment) {
            super(0);
            this.uZm = finderProfileMegaVideoFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ String invoke() {
            AppMethodBeat.i(249982);
            String stringExtra = this.uZm.dAq().getIntent().getStringExtra("finder_username");
            AppMethodBeat.o(249982);
            return stringExtra;
        }
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.megavideo.ui.a$a' to match base method */
    @Override // com.tencent.mm.plugin.finder.ui.fragment.FinderBaseMegaVideoFeedFragment
    public final /* synthetic */ d.a dkn() {
        AppMethodBeat.i(249985);
        d.a aVar = this.uKA;
        if (aVar == null) {
            p.btv("presenter");
        }
        d.a aVar2 = aVar;
        AppMethodBeat.o(249985);
        return aVar2;
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.megavideo.ui.a$b' to match base method */
    @Override // com.tencent.mm.plugin.finder.ui.fragment.FinderBaseMegaVideoFeedFragment
    public final /* synthetic */ d.b dma() {
        AppMethodBeat.i(249986);
        d.b bVar = this.uZi;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        d.b bVar2 = bVar;
        AppMethodBeat.o(249986);
        return bVar2;
    }
}
