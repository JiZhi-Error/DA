package com.tencent.mm.plugin.finder.feed;

import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.hl;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.w;
import com.tencent.mm.plugin.finder.feed.b;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.d;
import com.tencent.mm.plugin.finder.feed.model.f;
import com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer;
import com.tencent.mm.plugin.finder.feed.v;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderCommentPreloaderUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderLiveNoticePreLoadUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.event.EventCenter;
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
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000 \u00032\u00020\u0001:\u0003\u0003\u0004\u0005B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract;", "", "()V", "Companion", "Presenter", "ViewCallback", "plugin-finder_release"})
public final class a {
    private static final String TAG = TAG;
    public static final C1116a tLx = new C1116a((byte) 0);

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.feed.a$a  reason: collision with other inner class name */
    public static final class C1116a {
        private C1116a() {
        }

        public /* synthetic */ C1116a(byte b2) {
            this();
        }
    }

    static {
        AppMethodBeat.i(243673);
        AppMethodBeat.o(243673);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0002\u0010\rJ\u0018\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J \u0010$\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\tH\u0016J\b\u0010(\u001a\u00020\u001fH\u0016J\u0018\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020\u001fH\u0016J\b\u0010/\u001a\u00020\u001fH\u0016R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u001aR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0019R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u00060"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "isSelfFlag", "", ch.COL_USERNAME, "", "requestAtScene", "", "fromScene", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMActivity;ZLjava/lang/String;IILcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "commentPreloader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getCommentPreloader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderCommentPreloader;", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "finderLiveNoticePreLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "getFinderLiveNoticePreLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveNoticePreLoader;", "getFromScene", "()I", "()Z", "getRequestAtScene", "getUsername", "()Ljava/lang/String;", "createSecondMenu", "", "feed", "Lcom/tencent/mm/plugin/finder/model/BaseFinderFeed;", "menu", "Lcom/tencent/mm/ui/base/MMMenu;", "dealMenuClick", "menuItem", "Landroid/view/MenuItem;", FirebaseAnalytics.b.INDEX, "loadMoreData", "onAttach", "model", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "callback", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "onDetach", "requestRefresh", "plugin-finder_release"})
    public static final class b extends v.a {
        private final int fromScene;
        private final boolean tFN;
        private final int tLA;
        private final d tLy;
        private final f tLz;
        private final bbn ttO;
        private final String username;

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "pos", "", "invoke"})
        /* renamed from: com.tencent.mm.plugin.finder.feed.a$b$a  reason: collision with other inner class name */
        static final class C1117a extends q implements kotlin.g.a.b<Integer, bo> {
            final /* synthetic */ b tLB;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1117a(b bVar) {
                super(1);
                this.tLB = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ bo invoke(Integer num) {
                bo boVar;
                BaseFinderFeed baseFinderFeed;
                DataBuffer dataListJustForAdapter;
                AppMethodBeat.i(243661);
                int intValue = num.intValue();
                if (intValue >= 0) {
                    BaseFinderFeedLoader baseFinderFeedLoader = this.tLB.tFM;
                    if (intValue < ((baseFinderFeedLoader == null || (dataListJustForAdapter = baseFinderFeedLoader.getDataListJustForAdapter()) == null) ? 0 : dataListJustForAdapter.size())) {
                        BaseFinderFeedLoader baseFinderFeedLoader2 = this.tLB.tFM;
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
                        AppMethodBeat.o(243661);
                        return baseFinderFeed2;
                    }
                }
                AppMethodBeat.o(243661);
                return null;
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0006"}, hxF = {"<anonymous>", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "firstItemPos", "", "lastItemPos", "invoke"})
        /* renamed from: com.tencent.mm.plugin.finder.feed.a$b$b  reason: collision with other inner class name */
        static final class C1118b extends q implements m<Integer, Integer, LinkedList<bo>> {
            final /* synthetic */ b tLB;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C1118b(b bVar) {
                super(2);
                this.tLB = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // kotlin.g.a.m
            public final /* synthetic */ LinkedList<bo> invoke(Integer num, Integer num2) {
                BaseFinderFeedLoader baseFinderFeedLoader;
                DataBuffer dataListJustForAdapter;
                List a2;
                DataBuffer dataListJustForAdapter2;
                AppMethodBeat.i(243662);
                int intValue = num.intValue();
                int intValue2 = num2.intValue();
                if (intValue >= 0) {
                    BaseFinderFeedLoader baseFinderFeedLoader2 = this.tLB.tFM;
                    if (!(intValue2 >= ((baseFinderFeedLoader2 == null || (dataListJustForAdapter2 = baseFinderFeedLoader2.getDataListJustForAdapter()) == null) ? 0 : dataListJustForAdapter2.size()) || (baseFinderFeedLoader = this.tLB.tFM) == null || (dataListJustForAdapter = baseFinderFeedLoader.getDataListJustForAdapter()) == null || (a2 = j.a((List) dataListJustForAdapter, new kotlin.k.f(intValue, intValue2))) == null)) {
                        LinkedList linkedList = new LinkedList(a2);
                        AppMethodBeat.o(243662);
                        return linkedList;
                    }
                }
                AppMethodBeat.o(243662);
                return null;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(MMActivity mMActivity, boolean z, String str, int i2, int i3, bbn bbn) {
            super(mMActivity);
            p.h(mMActivity, "context");
            p.h(str, ch.COL_USERNAME);
            AppMethodBeat.i(243669);
            this.tFN = z;
            this.username = str;
            this.tLA = i2;
            this.fromScene = i3;
            this.ttO = bbn;
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            this.tLy = ((FinderCommentPreloaderUIC) com.tencent.mm.ui.component.a.b(mMActivity).get(FinderCommentPreloaderUIC.class)).tLy;
            com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
            this.tLz = ((FinderLiveNoticePreLoadUIC) com.tencent.mm.ui.component.a.b(mMActivity).get(FinderLiveNoticePreLoadUIC.class)).wyi;
            AppMethodBeat.o(243669);
        }

        @Override // com.tencent.mm.plugin.finder.feed.v.a
        public final void a(BaseFinderFeedLoader baseFinderFeedLoader, v.b bVar) {
            com.tencent.mm.plugin.finder.event.base.c a2;
            com.tencent.mm.plugin.finder.event.base.c a3;
            AppMethodBeat.i(243665);
            p.h(baseFinderFeedLoader, "model");
            p.h(bVar, "callback");
            super.a(baseFinderFeedLoader, bVar);
            this.tLy.a(this.tLA, this.tCE, new C1117a(this));
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            FinderReporterUIC fH = FinderReporterUIC.a.fH(this.gte);
            if (!(fH == null || (a3 = FinderReporterUIC.a(fH)) == null)) {
                a3.a(this.tLy);
            }
            this.tLz.e(new C1118b(this));
            FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
            FinderReporterUIC fH2 = FinderReporterUIC.a.fH(this.gte);
            if (fH2 == null || (a2 = FinderReporterUIC.a(fH2)) == null) {
                AppMethodBeat.o(243665);
                return;
            }
            a2.a(this.tLz);
            AppMethodBeat.o(243665);
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.a
        public final void a(BaseFinderFeed baseFinderFeed, com.tencent.mm.ui.base.m mVar) {
            AppMethodBeat.i(243666);
            p.h(baseFinderFeed, "feed");
            p.h(mVar, "menu");
            super.a(baseFinderFeed, mVar);
            if (this.tFN) {
                mVar.aS(this.tLI, R.string.chz, R.raw.icons_outlined_delete);
            }
            AppMethodBeat.o(243666);
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.a
        public final void a(BaseFinderFeed baseFinderFeed, MenuItem menuItem, int i2) {
            int i3;
            AppMethodBeat.i(243667);
            p.h(baseFinderFeed, "feed");
            p.h(menuItem, "menuItem");
            super.a(baseFinderFeed, menuItem, i2);
            if (menuItem.getItemId() == this.tLI) {
                if (this.fromScene == 1) {
                    h hVar = h.INSTANCE;
                    Object[] objArr = new Object[2];
                    if (p.j(this.username, z.aUg())) {
                        i3 = 1;
                    } else {
                        i3 = 0;
                    }
                    objArr[0] = Integer.valueOf(i3);
                    objArr[1] = 3;
                    hVar.a(21206, objArr);
                }
                BaseFinderFeedLoader baseFinderFeedLoader = this.tFM;
                if (baseFinderFeedLoader != null) {
                    baseFinderFeedLoader.remove(baseFinderFeed.lT(), true);
                }
                new w(baseFinderFeed.lT(), this.ttO).aYI();
                hl hlVar = new hl();
                hlVar.dLU.feedId = baseFinderFeed.lT();
                EventCenter.instance.publish(hlVar);
            }
            AppMethodBeat.o(243667);
        }

        @Override // com.tencent.mm.plugin.finder.feed.v.a, com.tencent.mm.plugin.finder.feed.b.a, com.tencent.mm.plugin.finder.presenter.base.a
        public final void onDetach() {
            com.tencent.mm.plugin.finder.event.base.c a2;
            com.tencent.mm.plugin.finder.event.base.c a3;
            AppMethodBeat.i(243668);
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
            AppMethodBeat.o(243668);
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.a
        public final void requestRefresh() {
            AppMethodBeat.i(243663);
            BaseFinderFeedLoader baseFinderFeedLoader = this.tFM;
            if (baseFinderFeedLoader != null) {
                baseFinderFeedLoader.requestRefresh();
                AppMethodBeat.o(243663);
                return;
            }
            AppMethodBeat.o(243663);
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.a
        public final void boE() {
            AppMethodBeat.i(243664);
            BaseFinderFeedLoader baseFinderFeedLoader = this.tFM;
            if (baseFinderFeedLoader != null) {
                baseFinderFeedLoader.requestLoadMore();
                AppMethodBeat.o(243664);
                return;
            }
            AppMethodBeat.o(243664);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\n\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J\u0016\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0016J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0018\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0018\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0010H\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\f¨\u0006\u001b"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderLoaderFeedUIContract$ViewCallback;", "context", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$Presenter;", "scene", "", "commentScene", "isAutoRefresh", "", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderAtTimelineUIContract$Presenter;IIZ)V", "()Z", "getEmptyView", "Landroid/view/View;", "initRecyclerView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onLoadInitDataError", "errCode", "errMsg", "", "onLoadMoreError", "onRefreshError", "onViewPrepared", "plugin-finder_release"})
    public static final class c extends v.b {
        private final boolean tLC;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(MMActivity mMActivity, b bVar, int i2, int i3, boolean z) {
            super(mMActivity, bVar, i2, i3);
            p.h(mMActivity, "context");
            p.h(bVar, "presenter");
            AppMethodBeat.i(243672);
            this.tLC = z;
            AppMethodBeat.o(243672);
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.AbstractC1134b
        public final void aa(ArrayList<bo> arrayList) {
            AppMethodBeat.i(243671);
            p.h(arrayList, "data");
            super.aa(arrayList);
            RefreshLoadMoreLayout refreshLoadMoreLayout = this.tLS;
            View inflate = aa.jQ(this.gte).inflate(dck() ? R.layout.b22 : R.layout.b21, (ViewGroup) null);
            p.g(inflate, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
            refreshLoadMoreLayout.setLoadMoreFooter(inflate);
            AppMethodBeat.o(243671);
        }

        @Override // com.tencent.mm.plugin.finder.feed.b.AbstractC1134b
        public final View getEmptyView() {
            return null;
        }

        @Override // com.tencent.mm.plugin.finder.feed.v.b, com.tencent.mm.plugin.finder.feed.b.AbstractC1134b
        public final void dbY() {
            AppMethodBeat.i(243670);
            b.a aVar = this.tLY;
            if (aVar == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderLoaderFeedUIContract.Presenter");
                AppMethodBeat.o(243670);
                throw tVar;
            }
            ((v.a) aVar).dcp();
            if (this.tLC) {
                b.a aVar2 = this.tLY;
                if (aVar2 == null) {
                    t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.feed.FinderLoaderFeedUIContract.Presenter");
                    AppMethodBeat.o(243670);
                    throw tVar2;
                }
                ((v.a) aVar2).requestRefresh();
            }
            AppMethodBeat.o(243670);
        }
    }
}
