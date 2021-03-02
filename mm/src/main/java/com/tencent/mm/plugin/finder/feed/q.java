package com.tencent.mm.plugin.finder.feed;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.event.base.c;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.d;
import com.tencent.mm.plugin.finder.feed.model.f;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.v;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
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
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeTimelineContract;", "", "()V", "Presenter", "ViewCallback", "plugin-finder_release"})
public final class q {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0012H\u0016J\b\u0010\u0019\u001a\u00020\u0012H\u0016R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001a"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeTimelineContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "(Lcom/tencent/mm/ui/MMActivity;I)V", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "finderLiveNoticePreLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "getFinderLiveNoticePreLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "getScene", "()I", "loadMoreData", "", "onAttach", "model", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "requestRefresh", "plugin-finder_release"})
    public static final class a extends v.a {
        private final int scene;
        private final d tLy;
        private final f tLz;

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "pos", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.finder.feed.q$a$a  reason: collision with other inner class name */
        static final class C1163a extends kotlin.g.b.q implements kotlin.g.a.b<Integer, bo> {
            final /* synthetic */ a tOo;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1163a(a aVar) {
                super(1);
                this.tOo = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ bo invoke(Integer num) {
                bo boVar;
                BaseFinderFeed baseFinderFeed;
                DataBuffer dataListJustForAdapter;
                AppMethodBeat.i(243876);
                int intValue = num.intValue();
                if (intValue >= 0) {
                    BaseFinderFeedLoader baseFinderFeedLoader = this.tOo.tFM;
                    if (intValue < ((baseFinderFeedLoader == null || (dataListJustForAdapter = baseFinderFeedLoader.getDataListJustForAdapter()) == null) ? 0 : dataListJustForAdapter.size())) {
                        BaseFinderFeedLoader baseFinderFeedLoader2 = this.tOo.tFM;
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
                        AppMethodBeat.o(243876);
                        return baseFinderFeed2;
                    }
                }
                AppMethodBeat.o(243876);
                return null;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "firstItemPos", "", "lastItemPos", "invoke"})
        static final class b extends kotlin.g.b.q implements m<Integer, Integer, LinkedList<bo>> {
            final /* synthetic */ a tOo;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            b(a aVar) {
                super(2);
                this.tOo = aVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ LinkedList<bo> invoke(Integer num, Integer num2) {
                BaseFinderFeedLoader baseFinderFeedLoader;
                DataBuffer dataListJustForAdapter;
                List a2;
                DataBuffer dataListJustForAdapter2;
                AppMethodBeat.i(243877);
                int intValue = num.intValue();
                int intValue2 = num2.intValue();
                if (intValue >= 0) {
                    BaseFinderFeedLoader baseFinderFeedLoader2 = this.tOo.tFM;
                    if (!(intValue2 >= ((baseFinderFeedLoader2 == null || (dataListJustForAdapter2 = baseFinderFeedLoader2.getDataListJustForAdapter()) == null) ? 0 : dataListJustForAdapter2.size()) || (baseFinderFeedLoader = this.tOo.tFM) == null || (dataListJustForAdapter = baseFinderFeedLoader.getDataListJustForAdapter()) == null || (a2 = j.a((List) dataListJustForAdapter, new kotlin.k.f(intValue, intValue2))) == null)) {
                        LinkedList linkedList = new LinkedList(a2);
                        AppMethodBeat.o(243877);
                        return linkedList;
                    }
                }
                AppMethodBeat.o(243877);
                return null;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(MMActivity mMActivity, int i2) {
            super(mMActivity);
            p.h(mMActivity, "context");
            AppMethodBeat.i(243882);
            this.scene = i2;
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            this.tLy = ((FinderCommentPreloaderUIC) com.tencent.mm.ui.component.a.b(mMActivity).get(FinderCommentPreloaderUIC.class)).tLy;
            com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
            this.tLz = ((FinderLiveNoticePreLoadUIC) com.tencent.mm.ui.component.a.b(mMActivity).get(FinderLiveNoticePreLoadUIC.class)).wyi;
            AppMethodBeat.o(243882);
        }

        @Override // com.tencent.mm.plugin.finder.feed.v.a
        public final void a(BaseFinderFeedLoader baseFinderFeedLoader, v.b bVar) {
            c a2;
            c a3;
            AppMethodBeat.i(243880);
            p.h(baseFinderFeedLoader, "model");
            p.h(bVar, "callback");
            super.a(baseFinderFeedLoader, bVar);
            this.tLy.a(this.scene, this.tCE, new C1163a(this));
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            FinderReporterUIC fH = FinderReporterUIC.a.fH(this.gte);
            if (!(fH == null || (a3 = FinderReporterUIC.a(fH)) == null)) {
                a3.a(this.tLy);
            }
            this.tLz.e(new b(this));
            FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
            FinderReporterUIC fH2 = FinderReporterUIC.a.fH(this.gte);
            if (fH2 == null || (a2 = FinderReporterUIC.a(fH2)) == null) {
                AppMethodBeat.o(243880);
                return;
            }
            a2.a(this.tLz);
            AppMethodBeat.o(243880);
        }

        @Override // com.tencent.mm.plugin.finder.feed.v.a, com.tencent.mm.plugin.finder.feed.b.a, com.tencent.mm.plugin.finder.presenter.base.a
        public final void onDetach() {
            c a2;
            c a3;
            AppMethodBeat.i(243881);
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
            super.onDetach();
            AppMethodBeat.o(243881);
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.a
        public final void requestRefresh() {
            AppMethodBeat.i(243878);
            BaseFinderFeedLoader baseFinderFeedLoader = this.tFM;
            if (baseFinderFeedLoader != null) {
                baseFinderFeedLoader.requestRefresh();
                AppMethodBeat.o(243878);
                return;
            }
            AppMethodBeat.o(243878);
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.a
        public final void boE() {
            AppMethodBeat.i(243879);
            BaseFinderFeedLoader baseFinderFeedLoader = this.tFM;
            if (baseFinderFeedLoader != null) {
                baseFinderFeedLoader.requestLoadMore();
                AppMethodBeat.o(243879);
                return;
            }
            AppMethodBeat.o(243879);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0016\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014H\u0016¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeTimelineContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeTimelineContract$Presenter;", "scene", "", "commentScene", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderFriendLikeTimelineContract$Presenter;II)V", "getEmptyView", "Landroid/view/View;", "initRecyclerView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onLoadInitDataError", "errCode", "errMsg", "", "onLoadMoreError", "onRefreshError", "plugin-finder_release"})
    public static final class b extends v.b {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(MMActivity mMActivity, a aVar, int i2, int i3) {
            super(mMActivity, aVar, i2, i3);
            p.h(mMActivity, "context");
            p.h(aVar, "presenter");
            AppMethodBeat.i(243885);
            AppMethodBeat.o(243885);
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.AbstractC1134b
        public final void aa(ArrayList<bo> arrayList) {
            AppMethodBeat.i(243883);
            p.h(arrayList, "data");
            super.aa(arrayList);
            RefreshLoadMoreLayout refreshLoadMoreLayout = this.tLS;
            LayoutInflater jQ = aa.jQ(this.gte);
            y yVar = y.vXH;
            View inflate = jQ.inflate(y.isOtherEnableFullScreenEnjoy() ? R.layout.b24 : R.layout.b23, (ViewGroup) null);
            p.g(inflate, "MMLayoutInflater.getInfl…e_footer_with_tips, null)");
            refreshLoadMoreLayout.setLoadMoreFooter(inflate);
            AppMethodBeat.o(243883);
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.AbstractC1134b
        public final View getEmptyView() {
            AppMethodBeat.i(243884);
            View findViewById = this.gte.findViewById(R.id.c3e);
            AppMethodBeat.o(243884);
            return findViewById;
        }
    }
}
