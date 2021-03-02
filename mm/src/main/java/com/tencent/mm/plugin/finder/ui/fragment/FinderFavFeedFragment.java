package com.tencent.mm.plugin.finder.ui.fragment;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.feed.g;
import com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.data.l;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderFavListTabUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 '2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001'B\u0005¢\u0006\u0002\u0010\u0004J\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u00020\u0014H\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0003H\u0016J\b\u0010 \u001a\u00020\u0002H\u0016J\b\u0010!\u001a\u00020\u001bH\u0016J\b\u0010\"\u001a\u00020\u001bH\u0016J\b\u0010#\u001a\u00020\u001bH\u0016J\b\u0010$\u001a\u00020\u001bH\u0016J\u000e\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\u0014R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014XD¢\u0006\u0002\n\u0000R\"\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000¨\u0006("}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderFavFeedFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderBaseGridFeedFragment;", "Lcom/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedPresenter;", "()V", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "getEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "setEventListener", "(Lcom/tencent/mm/sdk/event/IListener;)V", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderFavFeedLoader;)V", "presenter", "scene", "", "unFavIdList", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "viewCallback", "checkEmptyOnUnFav", "", "getLayoutId", "getLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getPresenter", "getViewCallback", "initAfterAttach", "initOnCreate", "onDestroy", "onResume", "updateTitle", "count", "Companion", "plugin-finder_release"})
public final class FinderFavFeedFragment extends FinderBaseGridFeedFragment<g.b, g.a> {
    public static final a vQv = new a((byte) 0);
    private HashMap _$_findViewCache;
    private final int scene = 2;
    private IListener<hn> tOh;
    public FinderFavFeedLoader tZQ;
    private g.a vQs;
    private g.b vQt;
    private HashSet<Long> vQu;

    static {
        AppMethodBeat.i(252857);
        AppMethodBeat.o(252857);
    }

    @Override // com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment, com.tencent.mm.ui.component.UIComponentFragment, com.tencent.mm.plugin.finder.ui.fragment.FinderBaseGridFeedFragment
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(252859);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(252859);
    }

    @Override // com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment, com.tencent.mm.ui.component.UIComponentFragment, android.support.v4.app.Fragment, com.tencent.mm.plugin.finder.ui.fragment.FinderBaseGridFeedFragment
    public final /* synthetic */ void onDestroyView() {
        AppMethodBeat.i(252860);
        super.onDestroyView();
        _$_clearFindViewByIdCache();
        AppMethodBeat.o(252860);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke", "com/tencent/mm/plugin/finder/ui/fragment/FinderFavFeedFragment$initOnCreate$1$2"})
    static final class c extends q implements kotlin.g.a.b<IResponse<bo>, x> {
        final /* synthetic */ FinderFavFeedFragment vQw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderFavFeedFragment finderFavFeedFragment) {
            super(1);
            this.vQw = finderFavFeedFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(IResponse<bo> iResponse) {
            boolean z;
            View findViewById;
            TextView textView;
            TextView textView2;
            TextView textView3;
            TextView textView4;
            AppMethodBeat.i(252845);
            IResponse<bo> iResponse2 = iResponse;
            p.h(iResponse2, LocaleUtil.ITALIAN);
            FinderFavFeedLoader dAr = this.vQw.dAr();
            if (dAr == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader");
                AppMethodBeat.o(252845);
                throw tVar;
            }
            if (dAr.gAZ != 0) {
                View view = FinderFavFeedFragment.a(this.vQw).tMl;
                if (!(view == null || (textView4 = (TextView) view.findViewById(R.id.bmr)) == null)) {
                    Resources resources = this.vQw.dAq().getResources();
                    Object[] objArr = new Object[1];
                    FinderFavFeedLoader dAr2 = this.vQw.dAr();
                    if (dAr2 == null) {
                        t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader");
                        AppMethodBeat.o(252845);
                        throw tVar2;
                    }
                    objArr[0] = Integer.valueOf(dAr2.gAZ);
                    textView4.setText(resources.getString(R.string.cmh, objArr));
                }
                FinderFavFeedFragment finderFavFeedFragment = this.vQw;
                FinderFavFeedLoader dAr3 = this.vQw.dAr();
                if (dAr3 == null) {
                    t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader");
                    AppMethodBeat.o(252845);
                    throw tVar3;
                }
                finderFavFeedFragment.IQ(dAr3.gAZ);
            }
            if (iResponse2.getPullType() == 0) {
                if (((FinderFavFeedLoader.b) iResponse2).tUU > 0) {
                    com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                    FinderFavListTabUIC finderFavListTabUIC = (FinderFavListTabUIC) com.tencent.mm.ui.component.a.b(this.vQw.dAq()).get(FinderFavListTabUIC.class);
                    com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
                    if (com.tencent.mm.plugin.finder.storage.c.dvJ().value().intValue() == 1) {
                        com.tencent.mm.ac.d.h(new FinderFavListTabUIC.a(finderFavListTabUIC));
                    }
                } else {
                    com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
                    ((FinderFavListTabUIC) com.tencent.mm.ui.component.a.b(this.vQw.dAq()).get(FinderFavListTabUIC.class)).nR(true);
                }
            }
            if (!((FinderFavFeedLoader.b) iResponse2).getHasMore()) {
                RefreshLoadMoreLayout refreshLoadMoreLayout = FinderFavFeedFragment.a(this.vQw).tLS;
                if (this.vQw.dAr().getSize() > 10) {
                    z = true;
                } else {
                    z = false;
                }
                refreshLoadMoreLayout.setEnableLoadMore(z);
                View loadMoreFooter = FinderFavFeedFragment.a(this.vQw).tLS.getLoadMoreFooter();
                if (!(loadMoreFooter == null || (textView3 = (TextView) loadMoreFooter.findViewById(R.id.ep1)) == null)) {
                    textView3.setText(R.string.d0m);
                }
                View loadMoreFooter2 = FinderFavFeedFragment.a(this.vQw).tLS.getLoadMoreFooter();
                if (!(loadMoreFooter2 == null || (textView2 = (TextView) loadMoreFooter2.findViewById(R.id.ep1)) == null)) {
                    textView2.setTextColor(this.vQw.getResources().getColor(R.color.FG_2));
                }
                View loadMoreFooter3 = FinderFavFeedFragment.a(this.vQw).tLS.getLoadMoreFooter();
                if (!(loadMoreFooter3 == null || (textView = (TextView) loadMoreFooter3.findViewById(R.id.ep1)) == null)) {
                    textView.setVisibility(8);
                }
                View loadMoreFooter4 = FinderFavFeedFragment.a(this.vQw).tLS.getLoadMoreFooter();
                if (!(loadMoreFooter4 == null || (findViewById = loadMoreFooter4.findViewById(R.id.ep0)) == null)) {
                    findViewById.setVisibility(0);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(252845);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderFavFeedFragment$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public FinderFavFeedFragment() {
        this.dLS = 100;
    }

    public static final /* synthetic */ g.b a(FinderFavFeedFragment finderFavFeedFragment) {
        AppMethodBeat.i(252858);
        g.b bVar = finderFavFeedFragment.vQt;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        AppMethodBeat.o(252858);
        return bVar;
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.feed.c$a' to match base method */
    @Override // com.tencent.mm.plugin.finder.ui.fragment.FinderBaseGridFeedFragment
    public final /* synthetic */ g.a dcq() {
        AppMethodBeat.i(252853);
        g.a dAs = dAs();
        AppMethodBeat.o(252853);
        return dAs;
    }

    public final FinderFavFeedLoader dAr() {
        AppMethodBeat.i(252849);
        FinderFavFeedLoader finderFavFeedLoader = this.tZQ;
        if (finderFavFeedLoader == null) {
            p.btv("feedLoader");
        }
        AppMethodBeat.o(252849);
        return finderFavFeedLoader;
    }

    @Override // com.tencent.mm.ui.component.UIComponentFragment
    public final int getLayoutId() {
        return R.layout.a_q;
    }

    @Override // com.tencent.mm.plugin.finder.ui.fragment.FinderBaseGridFeedFragment
    public final void initOnCreate() {
        AppMethodBeat.i(252850);
        this.vQu = new HashSet<>();
        IQ(0);
        String aUg = z.aUg();
        p.g(aUg, "ConfigStorageLogic.getMyFinderUsername()");
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        FinderFavFeedLoader finderFavFeedLoader = new FinderFavFeedLoader(aUg, ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(dAq()).get(FinderReporterUIC.class)).dIx(), false);
        finderFavFeedLoader.setInitDone(new b(this));
        finderFavFeedLoader.fetchEndCallback = new c(this);
        this.tZQ = finderFavFeedLoader;
        MMFinderUI dAq = dAq();
        dAq().getCommentScene();
        FinderFavFeedLoader finderFavFeedLoader2 = this.tZQ;
        if (finderFavFeedLoader2 == null) {
            p.btv("feedLoader");
        }
        this.vQs = new g.a(dAq, finderFavFeedLoader2);
        this.vQt = new d(this, dAq(), this.scene, dAq().getCommentScene());
        g.b bVar = this.vQt;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        g.a aVar2 = this.vQs;
        if (aVar2 == null) {
            p.btv("presenter");
        }
        bVar.a(aVar2);
        this.tOh = new e(this);
        EventCenter.instance.add(this.tOh);
        AppMethodBeat.o(252850);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/ui/fragment/FinderFavFeedFragment$initOnCreate$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
    public static final class b implements h {
        final /* synthetic */ FinderFavFeedFragment vQw;

        b(FinderFavFeedFragment finderFavFeedFragment) {
            this.vQw = finderFavFeedFragment;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.h
        public final void call(int i2) {
            View emptyView;
            RecyclerView recyclerView;
            AppMethodBeat.i(252844);
            g.b a2 = FinderFavFeedFragment.a(this.vQw);
            if (a2 == null || (emptyView = a2.getEmptyView()) == null) {
                AppMethodBeat.o(252844);
                return;
            }
            emptyView.setVisibility(8);
            g.b a3 = FinderFavFeedFragment.a(this.vQw);
            if (!(a3 == null || (recyclerView = a3.tLS.getRecyclerView()) == null)) {
                recyclerView.setVisibility(0);
            }
            EventCenter.instance.publish(new hn());
            AppMethodBeat.o(252844);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016¨\u0006\u0004"}, hxF = {"com/tencent/mm/plugin/finder/ui/fragment/FinderFavFeedFragment$initOnCreate$2", "Lcom/tencent/mm/plugin/finder/feed/FinderFavFeedUIContract$FavFeedViewCallback;", "getRootView", "Landroid/view/View;", "plugin-finder_release"})
    public static final class d extends g.b {
        final /* synthetic */ FinderFavFeedFragment vQw;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(FinderFavFeedFragment finderFavFeedFragment, MMActivity mMActivity, int i2, int i3) {
            super(mMActivity, i2, i3, (byte) 0);
            this.vQw = finderFavFeedFragment;
        }

        @Override // com.tencent.mm.plugin.finder.feed.c.b
        public final View getRootView() {
            AppMethodBeat.i(252846);
            View view = this.vQw.getView();
            AppMethodBeat.o(252846);
            return view;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/ui/fragment/FinderFavFeedFragment$initOnCreate$3", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class e extends IListener<hn> {
        final /* synthetic */ FinderFavFeedFragment vQw;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(FinderFavFeedFragment finderFavFeedFragment) {
            this.vQw = finderFavFeedFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(hn hnVar) {
            AppMethodBeat.i(252848);
            hn hnVar2 = hnVar;
            if (hnVar2 != null) {
                com.tencent.mm.ac.d.h(new a(this, hnVar2));
            }
            AppMethodBeat.o(252848);
            return true;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/ui/fragment/FinderFavFeedFragment$initOnCreate$3$callback$1$1"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ e vQx;
            final /* synthetic */ hn vQy;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(e eVar, hn hnVar) {
                super(0);
                this.vQx = eVar;
                this.vQy = hnVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                HashSet hashSet;
                AppMethodBeat.i(252847);
                if (this.vQy.dLW.dLK != 1 && this.vQy.dLW.type == 5) {
                    if (this.vQy.dLW.dLX == 2) {
                        HashSet hashSet2 = this.vQx.vQw.vQu;
                        if (hashSet2 != null) {
                            hashSet2.add(Long.valueOf(this.vQy.dLW.id));
                        }
                    } else if (this.vQy.dLW.dLX == 1 && (hashSet = this.vQx.vQw.vQu) != null) {
                        hashSet.remove(Long.valueOf(this.vQy.dLW.id));
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(252847);
                return xVar;
            }
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentFragment, android.support.v4.app.Fragment, com.tencent.mm.plugin.finder.ui.fragment.FinderBaseGridFeedFragment
    public final void onResume() {
        AppMethodBeat.i(252851);
        super.onResume();
        HashSet<Long> hashSet = this.vQu;
        if (hashSet != null) {
            Iterator<T> it = hashSet.iterator();
            while (it.hasNext()) {
                long longValue = it.next().longValue();
                FinderFavFeedLoader finderFavFeedLoader = this.tZQ;
                if (finderFavFeedLoader == null) {
                    p.btv("feedLoader");
                }
                finderFavFeedLoader.remove(longValue, true);
                l.a aVar = com.tencent.mm.plugin.finder.storage.data.l.vGw;
                l.a.L(longValue, 10);
                FinderFavFeedLoader finderFavFeedLoader2 = this.tZQ;
                if (finderFavFeedLoader2 == null) {
                    p.btv("feedLoader");
                }
                if (finderFavFeedLoader2.getSize() == 0) {
                    g.b bVar = this.vQt;
                    if (bVar == null) {
                        p.btv("viewCallback");
                    }
                    bVar.bIo();
                }
            }
        }
        FinderFavFeedLoader finderFavFeedLoader3 = this.tZQ;
        if (finderFavFeedLoader3 == null) {
            p.btv("feedLoader");
        }
        if (finderFavFeedLoader3 == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.model.FinderFavFeedLoader");
            AppMethodBeat.o(252851);
            throw tVar;
        }
        IQ(finderFavFeedLoader3.gAZ);
        AppMethodBeat.o(252851);
    }

    public final g.a dAs() {
        AppMethodBeat.i(252852);
        g.a aVar = this.vQs;
        if (aVar == null) {
            p.btv("presenter");
        }
        AppMethodBeat.o(252852);
        return aVar;
    }

    public final void IQ(int i2) {
        AppMethodBeat.i(252855);
        if (i2 > 0) {
            dAq().setMMTitle(dAq().getResources().getString(R.string.cme, Integer.valueOf(i2)));
            AppMethodBeat.o(252855);
            return;
        }
        dAq().setMMTitle(dAq().getResources().getString(R.string.cmf));
        AppMethodBeat.o(252855);
    }

    @Override // com.tencent.mm.ui.component.UIComponentFragment, android.support.v4.app.Fragment, com.tencent.mm.plugin.finder.ui.fragment.FinderBaseGridFeedFragment
    public final void onDestroy() {
        AppMethodBeat.i(252856);
        EventCenter.instance.removeListener(this.tOh);
        super.onDestroy();
        AppMethodBeat.o(252856);
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.feed.c$b' to match base method */
    @Override // com.tencent.mm.plugin.finder.ui.fragment.FinderBaseGridFeedFragment
    public final /* synthetic */ g.b ddS() {
        AppMethodBeat.i(252854);
        g.b bVar = this.vQt;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        g.b bVar2 = bVar;
        AppMethodBeat.o(252854);
        return bVar2;
    }
}
