package com.tencent.mm.plugin.finder.feed;

import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.d;
import com.tencent.mm.plugin.finder.feed.model.f;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.v;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.report.h;
import com.tencent.mm.plugin.finder.report.live.c;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentPreloaderUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveNoticePreLoadUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamListContract;", "", "()V", "Presenter", "ViewCallback", "plugin-finder_release"})
public final class s {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0018\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0013H\u0016J\u0018\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0013H\u0016J\u0016\u0010\u001f\u001a\u00020\u00132\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!H\u0016J\b\u0010#\u001a\u00020\u0013H\u0016J\b\u0010$\u001a\u00020\u0013H\u0016R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006%"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamListContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "tabType", "(Lcom/tencent/mm/ui/MMActivity;II)V", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "finderLiveNoticePreLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "getFinderLiveNoticePreLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "getScene", "()I", "createSecondMenu", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "loadMoreData", "onAttach", "model", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshEnd", "requestRefresh", "plugin-finder_release"})
    public static final class a extends v.a {
        private final int scene;
        private final d tLy;
        private final f tLz;

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "pos", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.finder.feed.s$a$a  reason: collision with other inner class name */
        static final class C1165a extends q implements kotlin.g.a.b<Integer, bo> {
            final /* synthetic */ a tOv;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1165a(a aVar) {
                super(1);
                this.tOv = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ bo invoke(Integer num) {
                bo boVar;
                BaseFinderFeed baseFinderFeed;
                DataBuffer dataListJustForAdapter;
                AppMethodBeat.i(243912);
                int intValue = num.intValue();
                if (intValue >= 0) {
                    BaseFinderFeedLoader baseFinderFeedLoader = this.tOv.tFM;
                    if (intValue < ((baseFinderFeedLoader == null || (dataListJustForAdapter = baseFinderFeedLoader.getDataListJustForAdapter()) == null) ? 0 : dataListJustForAdapter.size())) {
                        BaseFinderFeedLoader baseFinderFeedLoader2 = this.tOv.tFM;
                        if (baseFinderFeedLoader2 != null) {
                            boVar = (bo) baseFinderFeedLoader2.get(intValue);
                        } else {
                            boVar = null;
                        }
                        if (boVar instanceof BaseFinderFeed) {
                            baseFinderFeed = (BaseFinderFeed) boVar;
                        } else {
                            baseFinderFeed = null;
                        }
                        BaseFinderFeed baseFinderFeed2 = baseFinderFeed;
                        AppMethodBeat.o(243912);
                        return baseFinderFeed2;
                    }
                }
                AppMethodBeat.o(243912);
                return null;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "firstItemPos", "", "lastItemPos", "invoke"})
        static final class b extends q implements m<Integer, Integer, LinkedList<bo>> {
            final /* synthetic */ a tOv;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(a aVar) {
                super(2);
                this.tOv = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ LinkedList<bo> invoke(Integer num, Integer num2) {
                BaseFinderFeedLoader baseFinderFeedLoader;
                DataBuffer dataListJustForAdapter;
                List a2;
                DataBuffer dataListJustForAdapter2;
                AppMethodBeat.i(243913);
                int intValue = num.intValue();
                int intValue2 = num2.intValue();
                if (intValue >= 0) {
                    BaseFinderFeedLoader baseFinderFeedLoader2 = this.tOv.tFM;
                    if (!(intValue2 >= ((baseFinderFeedLoader2 == null || (dataListJustForAdapter2 = baseFinderFeedLoader2.getDataListJustForAdapter()) == null) ? 0 : dataListJustForAdapter2.size()) || (baseFinderFeedLoader = this.tOv.tFM) == null || (dataListJustForAdapter = baseFinderFeedLoader.getDataListJustForAdapter()) == null || (a2 = j.a((List) dataListJustForAdapter, new kotlin.k.f(intValue, intValue2))) == null)) {
                        LinkedList linkedList = new LinkedList(a2);
                        AppMethodBeat.o(243913);
                        return linkedList;
                    }
                }
                AppMethodBeat.o(243913);
                return null;
            }
        }

        public /* synthetic */ a(MMActivity mMActivity, int i2, byte b2) {
            this(mMActivity, i2);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        private a(MMActivity mMActivity, int i2) {
            super(mMActivity);
            p.h(mMActivity, "context");
            AppMethodBeat.i(243920);
            this.scene = i2;
            this.dLS = 0;
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            this.tLy = ((FinderCommentPreloaderUIC) com.tencent.mm.ui.component.a.b(mMActivity).get(FinderCommentPreloaderUIC.class)).tLy;
            com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
            this.tLz = ((FinderLiveNoticePreLoadUIC) com.tencent.mm.ui.component.a.b(mMActivity).get(FinderLiveNoticePreLoadUIC.class)).wyi;
            AppMethodBeat.o(243920);
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.a
        public final void requestRefresh() {
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.a
        public final void dcd() {
            AppMethodBeat.i(243915);
            h hVar = h.veu;
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            h.a(hVar, 2, false, ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.gte).get(FinderReporterUIC.class)).dIx(), 8);
            k kVar = k.vkd;
            k.b(null, s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD, "16", c.EVENT_ON_REFRESH);
            AppMethodBeat.o(243915);
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.a
        public final void a(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(243916);
            p.h(cVar, "reason");
            h.a(h.veu, 2, false, null, 12);
            AppMethodBeat.o(243916);
        }

        @Override // com.tencent.mm.plugin.finder.feed.v.a
        public final void a(BaseFinderFeedLoader baseFinderFeedLoader, v.b bVar) {
            com.tencent.mm.plugin.finder.event.base.c a2;
            com.tencent.mm.plugin.finder.event.base.c a3;
            AppMethodBeat.i(243917);
            p.h(baseFinderFeedLoader, "model");
            p.h(bVar, "callback");
            super.a(baseFinderFeedLoader, bVar);
            this.tLy.a(this.scene, this.tCE, new C1165a(this));
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            FinderReporterUIC fH = FinderReporterUIC.a.fH(this.gte);
            if (!(fH == null || (a3 = FinderReporterUIC.a(fH)) == null)) {
                a3.a(this.tLy);
            }
            this.tLz.e(new b(this));
            FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
            FinderReporterUIC fH2 = FinderReporterUIC.a.fH(this.gte);
            if (fH2 == null || (a2 = FinderReporterUIC.a(fH2)) == null) {
                AppMethodBeat.o(243917);
                return;
            }
            a2.a(this.tLz);
            AppMethodBeat.o(243917);
        }

        @Override // com.tencent.mm.plugin.finder.feed.v.a, com.tencent.mm.plugin.finder.feed.b.a, com.tencent.mm.plugin.finder.presenter.base.a
        public final void onDetach() {
            com.tencent.mm.plugin.finder.event.base.c a2;
            com.tencent.mm.plugin.finder.event.base.c a3;
            AppMethodBeat.i(243918);
            this.tLy.onDetach();
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            FinderReporterUIC fH = FinderReporterUIC.a.fH(this.gte);
            if (!(fH == null || (a3 = FinderReporterUIC.a(fH)) == null)) {
                a3.b(this.tLy);
            }
            this.tLz.onDetach();
            FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
            FinderReporterUIC fH2 = FinderReporterUIC.a.fH(this.gte);
            if (!(fH2 == null || (a2 = FinderReporterUIC.a(fH2)) == null)) {
                a2.b(this.tLz);
            }
            h hVar = h.veu;
            FinderReporterUIC.a aVar3 = FinderReporterUIC.wzC;
            FinderReporterUIC fH3 = FinderReporterUIC.a.fH(this.gte);
            h.e(2, fH3 != null ? fH3.dIx() : null);
            super.onDetach();
            AppMethodBeat.o(243918);
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.a
        public final void a(BaseFinderFeed baseFinderFeed, com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(243919);
            p.h(baseFinderFeed, "feed");
            p.h(mVar, "menu");
            y yVar = y.vXH;
            if (!y.h(baseFinderFeed)) {
                mVar.b(this.tLD, this.gte.getString(R.string.f3j), R.raw.finder_feed_dislike);
            }
            super.a(baseFinderFeed, mVar);
            AppMethodBeat.o(243919);
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.a
        public final void boE() {
            AppMethodBeat.i(243914);
            BaseFinderFeedLoader baseFinderFeedLoader = this.tFM;
            if (baseFinderFeedLoader != null) {
                baseFinderFeedLoader.requestLoadMore();
                AppMethodBeat.o(243914);
                return;
            }
            AppMethodBeat.o(243914);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0016\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamListContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamListContract$Presenter;", "scene", "", "commentScene", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderLbsStreamListContract$Presenter;II)V", "getEmptyView", "Landroid/view/View;", "initRecyclerView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onLoadInitDataError", "errCode", "errMsg", "", "onLoadMoreError", "onRefreshError", "plugin-finder_release"})
    public static final class b extends v.b {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(MMActivity mMActivity, a aVar, int i2) {
            super(mMActivity, aVar, i2, 16);
            p.h(mMActivity, "context");
            p.h(aVar, "presenter");
            AppMethodBeat.i(243922);
            AppMethodBeat.o(243922);
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.AbstractC1134b
        public final void aa(ArrayList<bo> arrayList) {
            AppMethodBeat.i(243921);
            p.h(arrayList, "data");
            super.aa(arrayList);
            if (dck()) {
                RefreshLoadMoreLayout refreshLoadMoreLayout = this.tLS;
                View inflate = aa.jQ(this.gte).inflate(R.layout.auy, (ViewGroup) null);
                p.g(inflate, "MMLayoutInflater.getInfl…b_load_more_footer, null)");
                refreshLoadMoreLayout.setLoadMoreFooter(inflate);
                AppMethodBeat.o(243921);
                return;
            }
            RefreshLoadMoreLayout refreshLoadMoreLayout2 = this.tLS;
            View inflate2 = aa.jQ(this.gte).inflate(R.layout.b21, (ViewGroup) null);
            p.g(inflate2, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
            refreshLoadMoreLayout2.setLoadMoreFooter(inflate2);
            AppMethodBeat.o(243921);
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.AbstractC1134b
        public final View getEmptyView() {
            return null;
        }
    }
}
