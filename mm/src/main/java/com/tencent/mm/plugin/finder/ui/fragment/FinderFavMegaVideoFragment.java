package com.tencent.mm.plugin.finder.ui.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.megavideo.loader.FinderFavMegaVideoLoader;
import com.tencent.mm.plugin.finder.megavideo.ui.b;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.data.l;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 !2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\b\u0010\u001b\u001a\u00020\u0015H\u0016J\b\u0010\u001c\u001a\u00020\u0015H\u0016J\b\u0010\u001d\u001a\u00020\u0015H\u0016J\b\u0010\u001e\u001a\u00020\u0015H\u0002J\u000e\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u0017R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderFavMegaVideoFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderBaseMegaVideoFeedFragment;", "Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderFavMegaVideoLoader;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderFavMegaVideoUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderFavMegaVideoUIContract$Presenter;", "()V", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "feedLoader", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderFavMegaVideoLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderFavMegaVideoLoader;)V", "presenter", "unFavIdList", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "viewCallback", "checkEmptyOnUnFav", "", "getLayoutId", "", "getLoader", "getPresenter", "getViewCallback", "initOnCreate", "onDestroy", "onResume", "updateFooterCount", "updateTitle", "count", "Companion", "plugin-finder_release"})
public final class FinderFavMegaVideoFragment extends FinderBaseMegaVideoFeedFragment<FinderFavMegaVideoLoader, b.C1229b, b.a> {
    public static final a vQC = new a((byte) 0);
    private HashMap _$_findViewCache;
    private IListener<hn> tOh;
    private b.C1229b vQA;
    public FinderFavMegaVideoLoader vQB;
    private HashSet<Long> vQu = new HashSet<>();
    private b.a vQz;

    static {
        AppMethodBeat.i(252873);
        AppMethodBeat.o(252873);
    }

    @Override // com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment, com.tencent.mm.ui.component.UIComponentFragment, com.tencent.mm.plugin.finder.ui.fragment.FinderBaseMegaVideoFeedFragment
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(252876);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(252876);
    }

    @Override // com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment, com.tencent.mm.ui.component.UIComponentFragment, com.tencent.mm.plugin.finder.ui.fragment.FinderBaseMegaVideoFeedFragment, android.support.v4.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        AppMethodBeat.i(252877);
        super.onDestroyView();
        _$_clearFindViewByIdCache();
        AppMethodBeat.o(252877);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/ui/fragment/FinderFavMegaVideoFragment$initOnCreate$1$2"})
    static final class c extends q implements kotlin.g.a.b<IResponse<bo>, x> {
        final /* synthetic */ FinderFavMegaVideoFragment vQD;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderFavMegaVideoFragment finderFavMegaVideoFragment) {
            super(1);
            this.vQD = finderFavMegaVideoFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(IResponse<bo> iResponse) {
            TextView textView;
            AppMethodBeat.i(252862);
            IResponse<bo> iResponse2 = iResponse;
            p.h(iResponse2, LocaleUtil.ITALIAN);
            if (!((FinderFavMegaVideoLoader.b) iResponse2).getHasMore()) {
                FinderFavMegaVideoFragment.a(this.vQD).tLS.setEnableLoadMore(this.vQD.dAt().getSize() > 5);
                FinderFavMegaVideoFragment.b(this.vQD);
                View loadMoreFooter = FinderFavMegaVideoFragment.a(this.vQD).tLS.getLoadMoreFooter();
                if (!(loadMoreFooter == null || (textView = (TextView) loadMoreFooter.findViewById(R.id.ep1)) == null)) {
                    textView.setVisibility(0);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(252862);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderFavMegaVideoFragment$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public FinderFavMegaVideoFragment() {
        AppMethodBeat.i(252872);
        this.dLS = 101;
        AppMethodBeat.o(252872);
    }

    public static final /* synthetic */ b.C1229b a(FinderFavMegaVideoFragment finderFavMegaVideoFragment) {
        AppMethodBeat.i(252874);
        b.C1229b bVar = finderFavMegaVideoFragment.vQA;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        AppMethodBeat.o(252874);
        return bVar;
    }

    public static final /* synthetic */ void b(FinderFavMegaVideoFragment finderFavMegaVideoFragment) {
        AppMethodBeat.i(252875);
        finderFavMegaVideoFragment.dAu();
        AppMethodBeat.o(252875);
    }

    public final FinderFavMegaVideoLoader dAt() {
        AppMethodBeat.i(252865);
        FinderFavMegaVideoLoader finderFavMegaVideoLoader = this.vQB;
        if (finderFavMegaVideoLoader == null) {
            p.btv("feedLoader");
        }
        AppMethodBeat.o(252865);
        return finderFavMegaVideoLoader;
    }

    @Override // com.tencent.mm.ui.component.UIComponentFragment
    public final int getLayoutId() {
        return R.layout.a_q;
    }

    @Override // com.tencent.mm.plugin.finder.ui.fragment.FinderBaseMegaVideoFeedFragment
    public final void initOnCreate() {
        AppMethodBeat.i(252866);
        String aUg = z.aUg();
        p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        FinderFavMegaVideoLoader finderFavMegaVideoLoader = new FinderFavMegaVideoLoader(aUg, ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(dAq()).get(FinderReporterUIC.class)).dIx());
        finderFavMegaVideoLoader.setInitDone(new b(this));
        finderFavMegaVideoLoader.fetchEndCallback = new c(this);
        this.vQB = finderFavMegaVideoLoader;
        MMFinderUI dAq = dAq();
        FinderFavMegaVideoLoader finderFavMegaVideoLoader2 = this.vQB;
        if (finderFavMegaVideoLoader2 == null) {
            p.btv("feedLoader");
        }
        this.vQz = new b.a(dAq, finderFavMegaVideoLoader2);
        MMFinderUI dAq2 = dAq();
        View view = getView();
        if (view == null) {
            p.hyc();
        }
        p.g(view, "view!!");
        this.vQA = new b.C1229b(dAq2, view);
        b.C1229b bVar = this.vQA;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        b.a aVar2 = this.vQz;
        if (aVar2 == null) {
            p.btv("presenter");
        }
        bVar.a(aVar2);
        this.tOh = new d(this);
        IListener<hn> iListener = this.tOh;
        if (iListener != null) {
            iListener.alive();
            AppMethodBeat.o(252866);
            return;
        }
        AppMethodBeat.o(252866);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/ui/fragment/FinderFavMegaVideoFragment$initOnCreate$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
    public static final class b implements h {
        final /* synthetic */ FinderFavMegaVideoFragment vQD;

        b(FinderFavMegaVideoFragment finderFavMegaVideoFragment) {
            this.vQD = finderFavMegaVideoFragment;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.h
        public final void call(int i2) {
            View emptyView;
            RecyclerView recyclerView;
            AppMethodBeat.i(252861);
            b.C1229b a2 = FinderFavMegaVideoFragment.a(this.vQD);
            if (a2 == null || (emptyView = a2.getEmptyView()) == null) {
                AppMethodBeat.o(252861);
                return;
            }
            emptyView.setVisibility(8);
            b.C1229b a3 = FinderFavMegaVideoFragment.a(this.vQD);
            if (!(a3 == null || (recyclerView = a3.tLS.getRecyclerView()) == null)) {
                recyclerView.setVisibility(0);
            }
            EventCenter.instance.publish(new hn());
            AppMethodBeat.o(252861);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/ui/fragment/FinderFavMegaVideoFragment$initOnCreate$2", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class d extends IListener<hn> {
        final /* synthetic */ FinderFavMegaVideoFragment vQD;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(FinderFavMegaVideoFragment finderFavMegaVideoFragment) {
            this.vQD = finderFavMegaVideoFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(hn hnVar) {
            AppMethodBeat.i(252864);
            hn hnVar2 = hnVar;
            if (hnVar2 != null) {
                com.tencent.mm.ac.d.h(new a(this, hnVar2));
            }
            AppMethodBeat.o(252864);
            return true;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/ui/fragment/FinderFavMegaVideoFragment$initOnCreate$2$callback$1$1"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ d vQE;
            final /* synthetic */ hn vQy;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(d dVar, hn hnVar) {
                super(0);
                this.vQE = dVar;
                this.vQy = hnVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(252863);
                if (this.vQy.dLW.type == 5) {
                    if (this.vQy.dLW.dLX == 2) {
                        this.vQE.vQD.vQu.add(Long.valueOf(this.vQy.dLW.id));
                    } else if (this.vQy.dLW.dLX == 1) {
                        this.vQE.vQD.vQu.remove(Long.valueOf(this.vQy.dLW.id));
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(252863);
                return xVar;
            }
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentFragment, com.tencent.mm.plugin.finder.ui.fragment.FinderBaseMegaVideoFeedFragment, android.support.v4.app.Fragment
    public final void onResume() {
        AppMethodBeat.i(252867);
        super.onResume();
        Iterator<T> it = this.vQu.iterator();
        while (it.hasNext()) {
            long longValue = it.next().longValue();
            FinderFavMegaVideoLoader finderFavMegaVideoLoader = this.vQB;
            if (finderFavMegaVideoLoader == null) {
                p.btv("feedLoader");
            }
            long ER = finderFavMegaVideoLoader.ER(longValue);
            l.a aVar = com.tencent.mm.plugin.finder.storage.data.l.vGw;
            l.a.M(ER, 12);
            FinderFavMegaVideoLoader finderFavMegaVideoLoader2 = this.vQB;
            if (finderFavMegaVideoLoader2 == null) {
                p.btv("feedLoader");
            }
            if (finderFavMegaVideoLoader2.getSize() == 0) {
                b.C1229b bVar = this.vQA;
                if (bVar == null) {
                    p.btv("viewCallback");
                }
                bVar.bIo();
            }
        }
        this.vQu.clear();
        FinderFavMegaVideoLoader finderFavMegaVideoLoader3 = this.vQB;
        if (finderFavMegaVideoLoader3 == null) {
            p.btv("feedLoader");
        }
        int i2 = finderFavMegaVideoLoader3.gAZ;
        if (i2 > 0) {
            dAq().setMMTitle(dAq().getResources().getString(R.string.cme, Integer.valueOf(i2)));
        } else {
            dAq().setMMTitle(dAq().getResources().getString(R.string.cmf));
        }
        dAu();
        AppMethodBeat.o(252867);
    }

    @Override // com.tencent.mm.ui.component.UIComponentFragment, com.tencent.mm.plugin.finder.ui.fragment.FinderBaseMegaVideoFeedFragment, android.support.v4.app.Fragment
    public final void onDestroy() {
        AppMethodBeat.i(252868);
        super.onDestroy();
        IListener<hn> iListener = this.tOh;
        if (iListener != null) {
            iListener.dead();
            AppMethodBeat.o(252868);
            return;
        }
        AppMethodBeat.o(252868);
    }

    private final void dAu() {
        TextView textView;
        AppMethodBeat.i(252871);
        b.C1229b bVar = this.vQA;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        View loadMoreFooter = bVar.tLS.getLoadMoreFooter();
        if (loadMoreFooter == null || (textView = (TextView) loadMoreFooter.findViewById(R.id.ep1)) == null) {
            AppMethodBeat.o(252871);
            return;
        }
        Object[] objArr = new Object[1];
        FinderFavMegaVideoLoader finderFavMegaVideoLoader = this.vQB;
        if (finderFavMegaVideoLoader == null) {
            p.btv("feedLoader");
        }
        objArr[0] = Integer.valueOf(finderFavMegaVideoLoader.tUU);
        textView.setText(getString(R.string.ezk, objArr));
        AppMethodBeat.o(252871);
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.megavideo.ui.a$a' to match base method */
    @Override // com.tencent.mm.plugin.finder.ui.fragment.FinderBaseMegaVideoFeedFragment
    public final /* synthetic */ b.a dkn() {
        AppMethodBeat.i(252869);
        b.a aVar = this.vQz;
        if (aVar == null) {
            p.btv("presenter");
        }
        b.a aVar2 = aVar;
        AppMethodBeat.o(252869);
        return aVar2;
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.megavideo.ui.a$b' to match base method */
    @Override // com.tencent.mm.plugin.finder.ui.fragment.FinderBaseMegaVideoFeedFragment
    public final /* synthetic */ b.C1229b dma() {
        AppMethodBeat.i(252870);
        b.C1229b bVar = this.vQA;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        b.C1229b bVar2 = bVar;
        AppMethodBeat.o(252870);
        return bVar2;
    }
}
