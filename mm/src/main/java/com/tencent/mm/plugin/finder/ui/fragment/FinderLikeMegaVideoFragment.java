package com.tencent.mm.plugin.finder.ui.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.megavideo.loader.FinderLikeMegaVideoLoader;
import com.tencent.mm.plugin.finder.megavideo.ui.c;
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

@l(hxD = {1, 1, 16}, hxE = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 !2\u0014\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0005J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0002H\u0016J\b\u0010\u0019\u001a\u00020\u0004H\u0016J\b\u0010\u001a\u001a\u00020\u0003H\u0016J\b\u0010\u001b\u001a\u00020\u0015H\u0016J\b\u0010\u001c\u001a\u00020\u0015H\u0016J\b\u0010\u001d\u001a\u00020\u0015H\u0016J\b\u0010\u001e\u001a\u00020\u0015H\u0002J\u000e\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u0017R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u001e\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00110\u0010j\b\u0012\u0004\u0012\u00020\u0011`\u0012X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000¨\u0006\""}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderLikeMegaVideoFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderBaseMegaVideoFeedFragment;", "Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderLikeMegaVideoLoader;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderLikeMegaVideoUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/megavideo/ui/FinderLikeMegaVideoUIContract$Presenter;", "()V", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "feedLoader", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderLikeMegaVideoLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/megavideo/loader/FinderLikeMegaVideoLoader;)V", "presenter", "unLikeIdList", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "viewCallback", "checkEmptyOnUnLike", "", "getLayoutId", "", "getLoader", "getPresenter", "getViewCallback", "initOnCreate", "onDestroy", "onResume", "updateFooterCount", "updateTitle", "count", "Companion", "plugin-finder_release"})
public final class FinderLikeMegaVideoFragment extends FinderBaseMegaVideoFeedFragment<FinderLikeMegaVideoLoader, c.b, c.a> {
    public static final a vQN = new a((byte) 0);
    private HashMap _$_findViewCache;
    private IListener<hn> tOh;
    private HashSet<Long> vQH = new HashSet<>();
    private c.a vQK;
    private c.b vQL;
    public FinderLikeMegaVideoLoader vQM;

    static {
        AppMethodBeat.i(252923);
        AppMethodBeat.o(252923);
    }

    @Override // com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment, com.tencent.mm.ui.component.UIComponentFragment, com.tencent.mm.plugin.finder.ui.fragment.FinderBaseMegaVideoFeedFragment
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(252926);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(252926);
    }

    @Override // com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment, com.tencent.mm.ui.component.UIComponentFragment, com.tencent.mm.plugin.finder.ui.fragment.FinderBaseMegaVideoFeedFragment, android.support.v4.app.Fragment
    public final /* synthetic */ void onDestroyView() {
        AppMethodBeat.i(252927);
        super.onDestroyView();
        _$_clearFindViewByIdCache();
        AppMethodBeat.o(252927);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/ui/fragment/FinderLikeMegaVideoFragment$initOnCreate$1$2"})
    static final class c extends q implements kotlin.g.a.b<IResponse<bo>, x> {
        final /* synthetic */ FinderLikeMegaVideoFragment vQO;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderLikeMegaVideoFragment finderLikeMegaVideoFragment) {
            super(1);
            this.vQO = finderLikeMegaVideoFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(IResponse<bo> iResponse) {
            TextView textView;
            AppMethodBeat.i(252912);
            IResponse<bo> iResponse2 = iResponse;
            p.h(iResponse2, LocaleUtil.ITALIAN);
            this.vQO.dAw();
            if (!((FinderLikeMegaVideoLoader.a) iResponse2).getHasMore()) {
                FinderLikeMegaVideoFragment.a(this.vQO).tLS.setEnableLoadMore(this.vQO.dAw().getSize() > 5);
                FinderLikeMegaVideoFragment.b(this.vQO);
                View loadMoreFooter = FinderLikeMegaVideoFragment.a(this.vQO).tLS.getLoadMoreFooter();
                if (!(loadMoreFooter == null || (textView = (TextView) loadMoreFooter.findViewById(R.id.ep1)) == null)) {
                    textView.setVisibility(0);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(252912);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderLikeMegaVideoFragment$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public FinderLikeMegaVideoFragment() {
        AppMethodBeat.i(252922);
        this.dLS = 103;
        AppMethodBeat.o(252922);
    }

    public static final /* synthetic */ c.b a(FinderLikeMegaVideoFragment finderLikeMegaVideoFragment) {
        AppMethodBeat.i(252924);
        c.b bVar = finderLikeMegaVideoFragment.vQL;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        AppMethodBeat.o(252924);
        return bVar;
    }

    public static final /* synthetic */ void b(FinderLikeMegaVideoFragment finderLikeMegaVideoFragment) {
        AppMethodBeat.i(252925);
        finderLikeMegaVideoFragment.dAu();
        AppMethodBeat.o(252925);
    }

    public final FinderLikeMegaVideoLoader dAw() {
        AppMethodBeat.i(252915);
        FinderLikeMegaVideoLoader finderLikeMegaVideoLoader = this.vQM;
        if (finderLikeMegaVideoLoader == null) {
            p.btv("feedLoader");
        }
        AppMethodBeat.o(252915);
        return finderLikeMegaVideoLoader;
    }

    @Override // com.tencent.mm.ui.component.UIComponentFragment
    public final int getLayoutId() {
        return R.layout.acm;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/ui/fragment/FinderLikeMegaVideoFragment$initOnCreate$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
    public static final class b implements h {
        final /* synthetic */ FinderLikeMegaVideoFragment vQO;

        b(FinderLikeMegaVideoFragment finderLikeMegaVideoFragment) {
            this.vQO = finderLikeMegaVideoFragment;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.h
        public final void call(int i2) {
            View emptyView;
            RecyclerView recyclerView;
            AppMethodBeat.i(252911);
            c.b a2 = FinderLikeMegaVideoFragment.a(this.vQO);
            if (a2 == null || (emptyView = a2.getEmptyView()) == null) {
                AppMethodBeat.o(252911);
                return;
            }
            emptyView.setVisibility(8);
            c.b a3 = FinderLikeMegaVideoFragment.a(this.vQO);
            if (!(a3 == null || (recyclerView = a3.tLS.getRecyclerView()) == null)) {
                recyclerView.setVisibility(0);
            }
            EventCenter.instance.publish(new hn());
            AppMethodBeat.o(252911);
        }
    }

    @Override // com.tencent.mm.plugin.finder.ui.fragment.FinderBaseMegaVideoFeedFragment
    public final void initOnCreate() {
        AppMethodBeat.i(252916);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        FinderLikeMegaVideoLoader finderLikeMegaVideoLoader = new FinderLikeMegaVideoLoader(((FinderReporterUIC) com.tencent.mm.ui.component.a.b(dAq()).get(FinderReporterUIC.class)).dIx());
        finderLikeMegaVideoLoader.setInitDone(new b(this));
        finderLikeMegaVideoLoader.fetchEndCallback = new c(this);
        this.vQM = finderLikeMegaVideoLoader;
        MMFinderUI dAq = dAq();
        FinderLikeMegaVideoLoader finderLikeMegaVideoLoader2 = this.vQM;
        if (finderLikeMegaVideoLoader2 == null) {
            p.btv("feedLoader");
        }
        this.vQK = new c.a(dAq, finderLikeMegaVideoLoader2);
        MMFinderUI dAq2 = dAq();
        View view = getView();
        if (view == null) {
            p.hyc();
        }
        p.g(view, "view!!");
        this.vQL = new c.b(dAq2, view);
        c.b bVar = this.vQL;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        c.a aVar2 = this.vQK;
        if (aVar2 == null) {
            p.btv("presenter");
        }
        bVar.a(aVar2);
        this.tOh = new d(this);
        IListener<hn> iListener = this.tOh;
        if (iListener != null) {
            iListener.alive();
            AppMethodBeat.o(252916);
            return;
        }
        AppMethodBeat.o(252916);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/ui/fragment/FinderLikeMegaVideoFragment$initOnCreate$2", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class d extends IListener<hn> {
        final /* synthetic */ FinderLikeMegaVideoFragment vQO;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(FinderLikeMegaVideoFragment finderLikeMegaVideoFragment) {
            this.vQO = finderLikeMegaVideoFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(hn hnVar) {
            AppMethodBeat.i(252914);
            hn hnVar2 = hnVar;
            if (hnVar2 != null) {
                com.tencent.mm.ac.d.h(new a(this, hnVar2));
            }
            AppMethodBeat.o(252914);
            return true;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/ui/fragment/FinderLikeMegaVideoFragment$initOnCreate$2$callback$1$1"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ d vQP;
            final /* synthetic */ hn vQy;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(d dVar, hn hnVar) {
                super(0);
                this.vQP = dVar;
                this.vQy = hnVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(252913);
                if (this.vQy.dLW.type == 4) {
                    if (this.vQy.dLW.dLZ == 0) {
                        this.vQP.vQO.vQH.add(Long.valueOf(this.vQy.dLW.id));
                    } else if (this.vQy.dLW.dLZ == 1) {
                        this.vQP.vQO.vQH.remove(Long.valueOf(this.vQy.dLW.id));
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(252913);
                return xVar;
            }
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentFragment, com.tencent.mm.plugin.finder.ui.fragment.FinderBaseMegaVideoFeedFragment, android.support.v4.app.Fragment
    public final void onResume() {
        AppMethodBeat.i(252917);
        super.onResume();
        Iterator<T> it = this.vQH.iterator();
        while (it.hasNext()) {
            long longValue = it.next().longValue();
            FinderLikeMegaVideoLoader finderLikeMegaVideoLoader = this.vQM;
            if (finderLikeMegaVideoLoader == null) {
                p.btv("feedLoader");
            }
            long ER = finderLikeMegaVideoLoader.ER(longValue);
            l.a aVar = com.tencent.mm.plugin.finder.storage.data.l.vGw;
            l.a.M(ER, 11);
            FinderLikeMegaVideoLoader finderLikeMegaVideoLoader2 = this.vQM;
            if (finderLikeMegaVideoLoader2 == null) {
                p.btv("feedLoader");
            }
            if (finderLikeMegaVideoLoader2.getSize() == 0) {
                c.b bVar = this.vQL;
                if (bVar == null) {
                    p.btv("viewCallback");
                }
                bVar.bIo();
            }
        }
        this.vQH.clear();
        FinderLikeMegaVideoLoader finderLikeMegaVideoLoader3 = this.vQM;
        if (finderLikeMegaVideoLoader3 == null) {
            p.btv("feedLoader");
        }
        int i2 = finderLikeMegaVideoLoader3.gAZ;
        if (i2 > 0) {
            dAq().setMMTitle(dAq().getResources().getString(R.string.cq1, String.valueOf(i2)));
        } else {
            dAq().setMMTitle(dAq().getResources().getString(R.string.cq2));
        }
        dAu();
        AppMethodBeat.o(252917);
    }

    private final void dAu() {
        TextView textView;
        AppMethodBeat.i(252918);
        c.b bVar = this.vQL;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        View loadMoreFooter = bVar.tLS.getLoadMoreFooter();
        if (loadMoreFooter == null || (textView = (TextView) loadMoreFooter.findViewById(R.id.ep1)) == null) {
            AppMethodBeat.o(252918);
            return;
        }
        Object[] objArr = new Object[1];
        FinderLikeMegaVideoLoader finderLikeMegaVideoLoader = this.vQM;
        if (finderLikeMegaVideoLoader == null) {
            p.btv("feedLoader");
        }
        objArr[0] = Integer.valueOf(finderLikeMegaVideoLoader.tUU);
        textView.setText(getString(R.string.ezp, objArr));
        AppMethodBeat.o(252918);
    }

    @Override // com.tencent.mm.ui.component.UIComponentFragment, com.tencent.mm.plugin.finder.ui.fragment.FinderBaseMegaVideoFeedFragment, android.support.v4.app.Fragment
    public final void onDestroy() {
        AppMethodBeat.i(252919);
        super.onDestroy();
        IListener<hn> iListener = this.tOh;
        if (iListener != null) {
            iListener.dead();
            AppMethodBeat.o(252919);
            return;
        }
        AppMethodBeat.o(252919);
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.megavideo.ui.a$a' to match base method */
    @Override // com.tencent.mm.plugin.finder.ui.fragment.FinderBaseMegaVideoFeedFragment
    public final /* synthetic */ c.a dkn() {
        AppMethodBeat.i(252920);
        c.a aVar = this.vQK;
        if (aVar == null) {
            p.btv("presenter");
        }
        c.a aVar2 = aVar;
        AppMethodBeat.o(252920);
        return aVar2;
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.megavideo.ui.a$b' to match base method */
    @Override // com.tencent.mm.plugin.finder.ui.fragment.FinderBaseMegaVideoFeedFragment
    public final /* synthetic */ c.b dma() {
        AppMethodBeat.i(252921);
        c.b bVar = this.vQL;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        c.b bVar2 = bVar;
        AppMethodBeat.o(252921);
        return bVar2;
    }
}
