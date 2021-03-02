package com.tencent.mm.plugin.finder.ui.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.hn;
import com.tencent.mm.plugin.finder.feed.model.FinderLikedFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.feed.model.internal.h;
import com.tencent.mm.plugin.finder.feed.u;
import com.tencent.mm.plugin.finder.storage.data.l;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderLikeListTabUIC;
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

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u00020\u0014H\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0003H\u0016J\b\u0010 \u001a\u00020\u0002H\u0016J\b\u0010!\u001a\u00020\u001bH\u0016J\b\u0010\"\u001a\u00020\u001bH\u0016J\b\u0010#\u001a\u00020\u001bH\u0016J\b\u0010$\u001a\u00020\u001bH\u0016J\u000e\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\u0014R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0003X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014XD¢\u0006\u0002\n\u0000R\"\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\u0017\u0018\u0001`\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0002X.¢\u0006\u0002\n\u0000¨\u0006'"}, hxF = {"Lcom/tencent/mm/plugin/finder/ui/fragment/FinderLikeFeedGridFragment;", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderBaseGridFeedFragment;", "Lcom/tencent/mm/plugin/finder/feed/FinderLikeFeedUIContract$LikeFeedViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLikeFeedUIContract$LikeFeedPresenter;", "()V", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "getEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "setEventListener", "(Lcom/tencent/mm/sdk/event/IListener;)V", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader;)V", "presenter", "scene", "", "unLikeIdList", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "viewCallback", "checkEmptyOnUnLike", "", "getLayoutId", "getLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "getPresenter", "getViewCallback", "initAfterAttach", "initOnCreate", "onDestroy", "onResume", "updateTitle", "count", "plugin-finder_release"})
public final class FinderLikeFeedGridFragment extends FinderBaseGridFeedFragment<u.b, u.a> {
    private HashMap _$_findViewCache;
    private final int scene = 2;
    private IListener<hn> tOh;
    public FinderLikedFeedLoader uXc;
    private u.a vQF;
    private u.b vQG;
    private HashSet<Long> vQH;

    @Override // com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment, com.tencent.mm.ui.component.UIComponentFragment, com.tencent.mm.plugin.finder.ui.fragment.FinderBaseGridFeedFragment
    public final void _$_clearFindViewByIdCache() {
        AppMethodBeat.i(252909);
        if (this._$_findViewCache != null) {
            this._$_findViewCache.clear();
        }
        AppMethodBeat.o(252909);
    }

    @Override // com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment, com.tencent.mm.ui.component.UIComponentFragment, android.support.v4.app.Fragment, com.tencent.mm.plugin.finder.ui.fragment.FinderBaseGridFeedFragment
    public final /* synthetic */ void onDestroyView() {
        AppMethodBeat.i(252910);
        super.onDestroyView();
        _$_clearFindViewByIdCache();
        AppMethodBeat.o(252910);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/feed/model/FinderLikedFeedLoader$LikedTimelineResponse;", "invoke", "com/tencent/mm/plugin/finder/ui/fragment/FinderLikeFeedGridFragment$initOnCreate$1$3"})
    static final class c extends q implements kotlin.g.a.b<FinderLikedFeedLoader.b, x> {
        final /* synthetic */ FinderLikedFeedLoader uXh;
        final /* synthetic */ FinderLikeFeedGridFragment vQI;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(FinderLikedFeedLoader finderLikedFeedLoader, FinderLikeFeedGridFragment finderLikeFeedGridFragment) {
            super(1);
            this.uXh = finderLikedFeedLoader;
            this.vQI = finderLikeFeedGridFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(FinderLikedFeedLoader.b bVar) {
            TextView textView;
            AppMethodBeat.i(252898);
            FinderLikedFeedLoader.b bVar2 = bVar;
            p.h(bVar2, LocaleUtil.ITALIAN);
            if (bVar2.gAZ != 0) {
                View view = FinderLikeFeedGridFragment.a(this.vQI).tMl;
                if (!(view == null || (textView = (TextView) view.findViewById(R.id.bmr)) == null)) {
                    textView.setText(this.vQI.dAq().getResources().getString(R.string.cmh, Integer.valueOf(this.uXh.gAZ)));
                }
                this.vQI.IQ(this.uXh.gAZ);
            }
            if (bVar2.getPullType() == 1) {
                if (bVar2.tUU > 0) {
                    com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                    FinderLikeListTabUIC finderLikeListTabUIC = (FinderLikeListTabUIC) com.tencent.mm.ui.component.a.b(this.vQI.dAq()).get(FinderLikeListTabUIC.class);
                    com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
                    if (com.tencent.mm.plugin.finder.storage.c.dvJ().value().intValue() == 1) {
                        com.tencent.mm.ac.d.h(new FinderLikeListTabUIC.a(finderLikeListTabUIC));
                    }
                } else {
                    com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
                    ((FinderLikeListTabUIC) com.tencent.mm.ui.component.a.b(this.vQI.dAq()).get(FinderLikeListTabUIC.class)).nR(true);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(252898);
            return xVar;
        }
    }

    public FinderLikeFeedGridFragment() {
        this.dLS = 102;
    }

    public static final /* synthetic */ u.b a(FinderLikeFeedGridFragment finderLikeFeedGridFragment) {
        AppMethodBeat.i(252908);
        u.b bVar = finderLikeFeedGridFragment.vQG;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        AppMethodBeat.o(252908);
        return bVar;
    }

    public final FinderLikedFeedLoader dAv() {
        AppMethodBeat.i(252901);
        FinderLikedFeedLoader finderLikedFeedLoader = this.uXc;
        if (finderLikedFeedLoader == null) {
            p.btv("feedLoader");
        }
        AppMethodBeat.o(252901);
        return finderLikedFeedLoader;
    }

    @Override // com.tencent.mm.ui.component.UIComponentFragment
    public final int getLayoutId() {
        return R.layout.acm;
    }

    @Override // com.tencent.mm.plugin.finder.ui.fragment.FinderBaseGridFeedFragment
    public final void initOnCreate() {
        AppMethodBeat.i(252902);
        this.vQH = new HashSet<>();
        IQ(0);
        e eVar = e.FEED_LIKED_TIMELINE;
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        FinderLikedFeedLoader finderLikedFeedLoader = new FinderLikedFeedLoader(false, eVar, ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(dAq()).get(FinderReporterUIC.class)).dIx());
        finderLikedFeedLoader.setInitDone(new a(this));
        finderLikedFeedLoader.tTS = new b(this);
        finderLikedFeedLoader.tVS = new c(finderLikedFeedLoader, this);
        this.uXc = finderLikedFeedLoader;
        MMFinderUI dAq = dAq();
        dAq().getCommentScene();
        FinderLikedFeedLoader finderLikedFeedLoader2 = this.uXc;
        if (finderLikedFeedLoader2 == null) {
            p.btv("feedLoader");
        }
        this.vQF = new u.a(dAq, finderLikedFeedLoader2);
        this.vQG = new u.b(dAq(), this.scene, dAq().getCommentScene(), (byte) 0);
        u.b bVar = this.vQG;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        u.a aVar2 = this.vQF;
        if (aVar2 == null) {
            p.btv("presenter");
        }
        bVar.a(aVar2);
        this.tOh = new d(this);
        EventCenter.instance.add(this.tOh);
        AppMethodBeat.o(252902);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/ui/fragment/FinderLikeFeedGridFragment$initOnCreate$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
    public static final class a implements h {
        final /* synthetic */ FinderLikeFeedGridFragment vQI;

        a(FinderLikeFeedGridFragment finderLikeFeedGridFragment) {
            this.vQI = finderLikeFeedGridFragment;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.h
        public final void call(int i2) {
            AppMethodBeat.i(252896);
            View emptyView = FinderLikeFeedGridFragment.a(this.vQI).getEmptyView();
            if (emptyView != null) {
                emptyView.setVisibility(8);
                RecyclerView recyclerView = FinderLikeFeedGridFragment.a(this.vQI).tLS.getRecyclerView();
                if (recyclerView != null) {
                    recyclerView.setVisibility(0);
                }
                EventCenter.instance.publish(new hn());
                AppMethodBeat.o(252896);
                return;
            }
            AppMethodBeat.o(252896);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/ui/fragment/FinderLikeFeedGridFragment$initOnCreate$2", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FeedUpdateEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class d extends IListener<hn> {
        final /* synthetic */ FinderLikeFeedGridFragment vQI;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        d(FinderLikeFeedGridFragment finderLikeFeedGridFragment) {
            this.vQI = finderLikeFeedGridFragment;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(hn hnVar) {
            AppMethodBeat.i(252900);
            hn hnVar2 = hnVar;
            if (hnVar2 != null) {
                com.tencent.mm.ac.d.h(new a(this, hnVar2));
            }
            AppMethodBeat.o(252900);
            return true;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/ui/fragment/FinderLikeFeedGridFragment$initOnCreate$2$callback$1$1"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ d vQJ;
            final /* synthetic */ hn vQy;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(d dVar, hn hnVar) {
                super(0);
                this.vQJ = dVar;
                this.vQy = hnVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                HashSet hashSet;
                AppMethodBeat.i(252899);
                if (this.vQy.dLW.dLK != 1 && this.vQy.dLW.type == 4) {
                    if (this.vQy.dLW.dLZ == 0) {
                        HashSet hashSet2 = this.vQJ.vQI.vQH;
                        if (hashSet2 != null) {
                            hashSet2.add(Long.valueOf(this.vQy.dLW.id));
                        }
                    } else if (this.vQy.dLW.dLZ == 1 && (hashSet = this.vQJ.vQI.vQH) != null) {
                        hashSet.remove(Long.valueOf(this.vQy.dLW.id));
                    }
                }
                x xVar = x.SXb;
                AppMethodBeat.o(252899);
                return xVar;
            }
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentFragment, android.support.v4.app.Fragment, com.tencent.mm.plugin.finder.ui.fragment.FinderBaseGridFeedFragment
    public final void onResume() {
        AppMethodBeat.i(252903);
        super.onResume();
        HashSet<Long> hashSet = this.vQH;
        if (hashSet != null) {
            Iterator<T> it = hashSet.iterator();
            while (it.hasNext()) {
                long longValue = it.next().longValue();
                FinderLikedFeedLoader finderLikedFeedLoader = this.uXc;
                if (finderLikedFeedLoader == null) {
                    p.btv("feedLoader");
                }
                finderLikedFeedLoader.remove(longValue, true);
                l.a aVar = com.tencent.mm.plugin.finder.storage.data.l.vGw;
                l.a.L(longValue, 2);
                FinderLikedFeedLoader finderLikedFeedLoader2 = this.uXc;
                if (finderLikedFeedLoader2 == null) {
                    p.btv("feedLoader");
                }
                if (finderLikedFeedLoader2.getSize() == 0) {
                    u.b bVar = this.vQG;
                    if (bVar == null) {
                        p.btv("viewCallback");
                    }
                    bVar.bIo();
                }
            }
        }
        FinderLikedFeedLoader finderLikedFeedLoader3 = this.uXc;
        if (finderLikedFeedLoader3 == null) {
            p.btv("feedLoader");
        }
        IQ(finderLikedFeedLoader3.gAZ);
        AppMethodBeat.o(252903);
    }

    public final void IQ(int i2) {
        AppMethodBeat.i(252906);
        if (i2 > 0) {
            dAq().setMMTitle(dAq().getResources().getString(R.string.cq1, String.valueOf(i2)));
            AppMethodBeat.o(252906);
            return;
        }
        dAq().setMMTitle(dAq().getResources().getString(R.string.cq2));
        AppMethodBeat.o(252906);
    }

    @Override // com.tencent.mm.ui.component.UIComponentFragment, android.support.v4.app.Fragment, com.tencent.mm.plugin.finder.ui.fragment.FinderBaseGridFeedFragment
    public final void onDestroy() {
        AppMethodBeat.i(252907);
        EventCenter.instance.removeListener(this.tOh);
        super.onDestroy();
        AppMethodBeat.o(252907);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/ui/fragment/FinderLikeFeedGridFragment$initOnCreate$1$2"})
    static final class b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ FinderLikeFeedGridFragment vQI;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(FinderLikeFeedGridFragment finderLikeFeedGridFragment) {
            super(0);
            this.vQI = finderLikeFeedGridFragment;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            View findViewById;
            TextView textView;
            TextView textView2;
            TextView textView3;
            AppMethodBeat.i(252897);
            FinderLikeFeedGridFragment.a(this.vQI).tLS.setEnableLoadMore(this.vQI.dAv().getSize() > 10);
            View loadMoreFooter = FinderLikeFeedGridFragment.a(this.vQI).tLS.getLoadMoreFooter();
            if (!(loadMoreFooter == null || (textView3 = (TextView) loadMoreFooter.findViewById(R.id.ep1)) == null)) {
                textView3.setText(R.string.d0m);
            }
            View loadMoreFooter2 = FinderLikeFeedGridFragment.a(this.vQI).tLS.getLoadMoreFooter();
            if (!(loadMoreFooter2 == null || (textView2 = (TextView) loadMoreFooter2.findViewById(R.id.ep1)) == null)) {
                textView2.setTextColor(this.vQI.getResources().getColor(R.color.FG_2));
            }
            View loadMoreFooter3 = FinderLikeFeedGridFragment.a(this.vQI).tLS.getLoadMoreFooter();
            if (!(loadMoreFooter3 == null || (textView = (TextView) loadMoreFooter3.findViewById(R.id.ep1)) == null)) {
                textView.setVisibility(8);
            }
            View loadMoreFooter4 = FinderLikeFeedGridFragment.a(this.vQI).tLS.getLoadMoreFooter();
            if (!(loadMoreFooter4 == null || (findViewById = loadMoreFooter4.findViewById(R.id.ep0)) == null)) {
                findViewById.setVisibility(0);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(252897);
            return xVar;
        }
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.feed.c$a' to match base method */
    @Override // com.tencent.mm.plugin.finder.ui.fragment.FinderBaseGridFeedFragment
    public final /* synthetic */ u.a dcq() {
        AppMethodBeat.i(252904);
        u.a aVar = this.vQF;
        if (aVar == null) {
            p.btv("presenter");
        }
        u.a aVar2 = aVar;
        AppMethodBeat.o(252904);
        return aVar2;
    }

    /* Return type fixed from 'com.tencent.mm.plugin.finder.feed.c$b' to match base method */
    @Override // com.tencent.mm.plugin.finder.ui.fragment.FinderBaseGridFeedFragment
    public final /* synthetic */ u.b ddS() {
        AppMethodBeat.i(252905);
        u.b bVar = this.vQG;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        u.b bVar2 = bVar;
        AppMethodBeat.o(252905);
        return bVar2;
    }
}
