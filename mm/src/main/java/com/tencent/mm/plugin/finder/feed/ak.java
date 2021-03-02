package com.tencent.mm.plugin.finder.feed;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.cl;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.aj;
import com.tencent.mm.plugin.finder.feed.model.FinderLbsLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.report.ac;
import com.tencent.mm.plugin.finder.storage.o;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import java.util.Set;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 D2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001DB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00182\u0006\u0010(\u001a\u00020\tH\u0016J\u001a\u0010)\u001a\u00020&2\u0010\b\u0002\u0010*\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010+H\u0002J\u0010\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020/H\u0002J\u000e\u00100\u001a\b\u0012\u0004\u0012\u00020201H\u0016J\u0010\u00103\u001a\u00020&2\u0006\u00104\u001a\u00020\tH\u0016J\u0016\u00105\u001a\u00020&2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u00020 H\u0016J \u00107\u001a\u00020&2\u0006\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u001eH\u0016J\b\u0010=\u001a\u00020&H\u0016J\b\u0010>\u001a\u00020&H\u0016J\b\u0010?\u001a\u00020&H\u0016J\b\u0010@\u001a\u00020&H\u0016J\u0016\u0010A\u001a\u00020&2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020,0+H\u0016J\b\u0010C\u001a\u00020&H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u000e¢\u0006\u0002\n\u0000R \u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00020 X.¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006E"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;)V", "canTimelineRefresh", "", "emptyData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderEmptyData;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLbsLoader;)V", "isEmptyLocation", "isRequestingLbs", "()Z", "setRequestingLbs", "(Z)V", "refreshTime", "", "tagViewActionCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "totalDy", "", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;)V", "autoFlingToRefresh", "", "delayStart", "isSilence", "checkEmptyHeader", "r", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "findFirstPosition", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getHeaderInfo", "", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "onActionbarClick", "isDouble", "onAttach", "callback", "onClickReport", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderLbsCardActionReportStruct;", "lbsItem", "Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;", "feedIndex", "onDetach", "onFinishing", "onLoadMore", "onRefresh", "onRefreshEnd", "reason", "onUserVisibleFocused", "Companion", "plugin-finder_release"})
public final class ak implements aj.a<com.tencent.mm.plugin.finder.model.c> {
    public static final a tRc = new a((byte) 0);
    public final MMActivity activity;
    private final boolean canTimelineRefresh = this.tlCache.JN(1000);
    private com.tencent.mm.plugin.finder.model.g emptyData = new com.tencent.mm.plugin.finder.model.g();
    public boolean isEmptyLocation;
    boolean isRequestingLbs;
    public FinderLbsLoader tQY;
    public aj.b<com.tencent.mm.plugin.finder.model.c> tQZ;
    private long tRa = -1;
    private final FinderHomeTabFragment tRb;
    private com.tencent.mm.view.j tagViewActionCallback = new l(this);
    public final FinderHomeTabStateVM tlCache;
    public int totalDy;

    static {
        AppMethodBeat.i(244216);
        AppMethodBeat.o(244216);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/BaseMixFeed;", "invoke", "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$1$2"})
    public static final class e extends q implements kotlin.g.a.b<IResponse<com.tencent.mm.plugin.finder.model.c>, x> {
        final /* synthetic */ ak tRd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(ak akVar) {
            super(1);
            this.tRd = akVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(IResponse<com.tencent.mm.plugin.finder.model.c> iResponse) {
            View loadMoreFooter;
            View findViewById;
            View loadMoreFooter2;
            TextView textView;
            View loadMoreFooter3;
            TextView textView2;
            View loadMoreFooter4;
            TextView textView3;
            View loadMoreFooter5;
            AppMethodBeat.i(244180);
            p.h(iResponse, LocaleUtil.ITALIAN);
            if (this.tRd.dcR().getDataListJustForAdapter().size() > 4) {
                RefreshLoadMoreLayout dcQ = this.tRd.dcS().dcQ();
                if (!(dcQ == null || (loadMoreFooter5 = dcQ.getLoadMoreFooter()) == null)) {
                    loadMoreFooter5.setVisibility(0);
                }
                RefreshLoadMoreLayout dcQ2 = this.tRd.dcS().dcQ();
                if (!(dcQ2 == null || (loadMoreFooter4 = dcQ2.getLoadMoreFooter()) == null || (textView3 = (TextView) loadMoreFooter4.findViewById(R.id.ep1)) == null)) {
                    textView3.setText(R.string.d0m);
                }
                RefreshLoadMoreLayout dcQ3 = this.tRd.dcS().dcQ();
                if (!(dcQ3 == null || (loadMoreFooter3 = dcQ3.getLoadMoreFooter()) == null || (textView2 = (TextView) loadMoreFooter3.findViewById(R.id.ep1)) == null)) {
                    textView2.setTextColor(this.tRd.activity.getResources().getColor(R.color.FG_2));
                }
                RefreshLoadMoreLayout dcQ4 = this.tRd.dcS().dcQ();
                if (!(dcQ4 == null || (loadMoreFooter2 = dcQ4.getLoadMoreFooter()) == null || (textView = (TextView) loadMoreFooter2.findViewById(R.id.ep1)) == null)) {
                    textView.setVisibility(8);
                }
                RefreshLoadMoreLayout dcQ5 = this.tRd.dcS().dcQ();
                if (!(dcQ5 == null || (loadMoreFooter = dcQ5.getLoadMoreFooter()) == null || (findViewById = loadMoreFooter.findViewById(R.id.ep0)) == null)) {
                    findViewById.setVisibility(0);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(244180);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class k extends q implements kotlin.g.a.a<x> {
        public static final k tRj = new k();

        static {
            AppMethodBeat.i(244191);
            AppMethodBeat.o(244191);
        }

        k() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    public ak(MMActivity mMActivity, FinderHomeTabFragment finderHomeTabFragment) {
        p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(244215);
        this.activity = mMActivity;
        this.tRb = finderHomeTabFragment;
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ViewModel viewModel = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
        p.g(viewModel, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
        this.tlCache = (FinderHomeTabStateVM) viewModel;
        AppMethodBeat.o(244215);
    }

    public static final /* synthetic */ void a(ak akVar, RefreshLoadMoreLayout.c cVar) {
        AppMethodBeat.i(244217);
        akVar.checkEmptyHeader(cVar);
        AppMethodBeat.o(244217);
    }

    @Override // com.tencent.mm.plugin.finder.presenter.base.a
    public final /* synthetic */ void onAttach(Object obj) {
        AppMethodBeat.i(244207);
        a((aj.b) obj);
        AppMethodBeat.o(244207);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final FinderLbsLoader dcR() {
        AppMethodBeat.i(244201);
        FinderLbsLoader finderLbsLoader = this.tQY;
        if (finderLbsLoader == null) {
            p.btv("feedLoader");
        }
        AppMethodBeat.o(244201);
        return finderLbsLoader;
    }

    public final aj.b<com.tencent.mm.plugin.finder.model.c> dcS() {
        AppMethodBeat.i(244202);
        aj.b<com.tencent.mm.plugin.finder.model.c> bVar = this.tQZ;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        AppMethodBeat.o(244202);
        return bVar;
    }

    @Override // com.tencent.mm.plugin.finder.feed.aj.a
    public final void onRefresh() {
        AppMethodBeat.i(244203);
        com.tencent.mm.plugin.finder.utils.l lVar = com.tencent.mm.plugin.finder.utils.l.vVE;
        com.tencent.mm.plugin.finder.utils.l.a(new h(this), new i(this), new j(this));
        AppMethodBeat.o(244203);
    }

    @Override // com.tencent.mm.plugin.finder.feed.aj.a
    public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> cVar) {
        AppMethodBeat.i(244204);
        p.h(cVar, "reason");
        this.tRa = cl.aWA();
        if (cVar.Rmk <= 0) {
            aj.b<com.tencent.mm.plugin.finder.model.c> bVar = this.tQZ;
            if (bVar == null) {
                p.btv("viewCallback");
            }
            RefreshLoadMoreLayout dcQ = bVar.dcQ();
            if (dcQ != null) {
                com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
                dcQ.b(com.tencent.mm.plugin.finder.storage.c.dsb(), k.tRj);
            }
        }
        if (cVar.Rmj) {
            aj.b<com.tencent.mm.plugin.finder.model.c> bVar2 = this.tQZ;
            if (bVar2 == null) {
                p.btv("viewCallback");
            }
            RefreshLoadMoreLayout dcQ2 = bVar2.dcQ();
            if (dcQ2 != null && !dcQ2.RlV) {
                aj.b<com.tencent.mm.plugin.finder.model.c> bVar3 = this.tQZ;
                if (bVar3 == null) {
                    p.btv("viewCallback");
                }
                RefreshLoadMoreLayout dcQ3 = bVar3.dcQ();
                if (dcQ3 != null) {
                    dcQ3.setHasBottomMore(true);
                }
            }
            aj.b<com.tencent.mm.plugin.finder.model.c> bVar4 = this.tQZ;
            if (bVar4 == null) {
                p.btv("viewCallback");
            }
            RefreshLoadMoreLayout dcQ4 = bVar4.dcQ();
            if (dcQ4 != null && !dcQ4.getEnableLoadMore()) {
                aj.b<com.tencent.mm.plugin.finder.model.c> bVar5 = this.tQZ;
                if (bVar5 == null) {
                    p.btv("viewCallback");
                }
                RefreshLoadMoreLayout dcQ5 = bVar5.dcQ();
                if (dcQ5 != null) {
                    dcQ5.setEnableLoadMore(true);
                }
                aj.b<com.tencent.mm.plugin.finder.model.c> bVar6 = this.tQZ;
                if (bVar6 == null) {
                    p.btv("viewCallback");
                }
                RefreshLoadMoreLayout dcQ6 = bVar6.dcQ();
                if (dcQ6 != null) {
                    View inflate = aa.jQ(this.activity).inflate(R.layout.b21, (ViewGroup) null);
                    p.g(inflate, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
                    dcQ6.setLoadMoreFooter(inflate);
                }
            }
        }
        checkEmptyHeader(cVar);
        AppMethodBeat.o(244204);
    }

    @Override // com.tencent.mm.plugin.finder.feed.aj.a
    public final void onLoadMore() {
        AppMethodBeat.i(244205);
        FinderLbsLoader finderLbsLoader = this.tQY;
        if (finderLbsLoader == null) {
            p.btv("feedLoader");
        }
        finderLbsLoader.requestLoadMore();
        AppMethodBeat.o(244205);
    }

    public final void a(aj.b<com.tencent.mm.plugin.finder.model.c> bVar) {
        AppMethodBeat.i(244206);
        p.h(bVar, "callback");
        this.tRa = cl.aWA();
        this.tQZ = bVar;
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        FinderLbsLoader finderLbsLoader = new FinderLbsLoader(((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.activity).get(FinderReporterUIC.class)).dIx());
        finderLbsLoader.setInitDone(new d(finderLbsLoader, this));
        finderLbsLoader.fetchEndCallback = new e(this);
        this.tQY = finderLbsLoader;
        aj.b<com.tencent.mm.plugin.finder.model.c> bVar2 = this.tQZ;
        if (bVar2 == null) {
            p.btv("viewCallback");
        }
        FinderLbsLoader finderLbsLoader2 = this.tQY;
        if (finderLbsLoader2 == null) {
            p.btv("feedLoader");
        }
        bVar2.ab(finderLbsLoader2.getDataListJustForAdapter());
        FinderLbsLoader finderLbsLoader3 = this.tQY;
        if (finderLbsLoader3 == null) {
            p.btv("feedLoader");
        }
        finderLbsLoader3.register(this.tagViewActionCallback);
        com.tencent.mm.plugin.finder.utils.l lVar = com.tencent.mm.plugin.finder.utils.l.vVE;
        if (com.tencent.mm.plugin.finder.utils.l.dBJ()) {
            this.tlCache.Mq(1000).wud.size();
            FinderLbsLoader finderLbsLoader4 = this.tQY;
            if (finderLbsLoader4 == null) {
                p.btv("feedLoader");
            }
            finderLbsLoader4.requestInit(false);
            aj.b<com.tencent.mm.plugin.finder.model.c> bVar3 = this.tQZ;
            if (bVar3 == null) {
                p.btv("viewCallback");
            }
            RecyclerView recyclerView = bVar3.getRecyclerView();
            if (recyclerView != null) {
                recyclerView.a(new f(this));
            }
        } else {
            RefreshLoadMoreLayout.c<Object> cVar = new RefreshLoadMoreLayout.c<>(0);
            cVar.Rmh = -2;
            checkEmptyHeader(cVar);
        }
        aj.b<com.tencent.mm.plugin.finder.model.c> bVar4 = this.tQZ;
        if (bVar4 == null) {
            p.btv("viewCallback");
        }
        RecyclerView recyclerView2 = bVar4.getRecyclerView();
        if (recyclerView2 != null) {
            com.tencent.mm.view.recyclerview.c.a(recyclerView2, new g(this));
            AppMethodBeat.o(244206);
            return;
        }
        AppMethodBeat.o(244206);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
    public static final class d implements com.tencent.mm.plugin.finder.feed.model.internal.h {
        final /* synthetic */ ak tRd;
        final /* synthetic */ FinderLbsLoader tRe;

        d(FinderLbsLoader finderLbsLoader, ak akVar) {
            this.tRe = finderLbsLoader;
            this.tRd = akVar;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.h
        public final void call(int i2) {
            final RecyclerView.LayoutManager layoutManager;
            RefreshLoadMoreLayout.c cVar = null;
            AppMethodBeat.i(244179);
            Log.i(this.tRe.getTAG(), "[initData] canTimelineRefresh=" + this.tRd.canTimelineRefresh + ", incrementCount=" + i2);
            if (this.tRd.canTimelineRefresh) {
                this.tRd.ED(0);
            } else {
                FinderHomeTabStateVM.a Mq = this.tRd.tlCache.Mq(1000);
                final int i3 = Mq.wuf;
                final int i4 = Mq.wug;
                Log.i(this.tRe.getTAG(), "[initData] canTimelineRefresh " + this.tRd.canTimelineRefresh + " lastPos=" + i3 + " fromTopPixel=" + i4);
                RecyclerView recyclerView = this.tRd.dcS().getRecyclerView();
                if (recyclerView != null) {
                    layoutManager = recyclerView.getLayoutManager();
                } else {
                    layoutManager = null;
                }
                this.tRd.totalDy = i4;
                if (layoutManager instanceof StaggeredGridLayoutManager) {
                    ((StaggeredGridLayoutManager) layoutManager).ah(i3, i4);
                    RecyclerView recyclerView2 = this.tRd.dcS().getRecyclerView();
                    if (recyclerView2 != null) {
                        recyclerView2.post(new Runnable() {
                            /* class com.tencent.mm.plugin.finder.feed.ak.d.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(244178);
                                ((StaggeredGridLayoutManager) layoutManager).ah(i3, i4);
                                AppMethodBeat.o(244178);
                            }
                        });
                    }
                }
            }
            if (i2 <= 0) {
                ak akVar = this.tRd;
                if (this.tRd.canTimelineRefresh) {
                    cVar = new RefreshLoadMoreLayout.c(0);
                }
                ak.a(akVar, cVar);
            }
            AppMethodBeat.o(244179);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$2", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
    public static final class f extends RecyclerView.l {
        final /* synthetic */ ak tRd;

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(244182);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            super.onScrollStateChanged(recyclerView, i2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(244182);
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(ak akVar) {
            this.tRd = akVar;
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(244181);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            p.h(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            this.tRd.totalDy -= i3;
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(244181);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00070\u0006H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$onAttach$4", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecordListener;", "Lcom/tencent/mm/view/recyclerview/ConvertData;", "onExposeTimeRecorded", "", "recordsSet", "", "Lcom/tencent/mm/view/recyclerview/ExposeTimeRecord;", "plugin-finder_release"})
    public static final class g extends com.tencent.mm.view.recyclerview.d<com.tencent.mm.view.recyclerview.a> {
        final /* synthetic */ ak tRd;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        g(ak akVar) {
            this.tRd = akVar;
        }

        @Override // com.tencent.mm.view.recyclerview.d
        public final void l(Set<com.tencent.mm.view.recyclerview.b<com.tencent.mm.view.recyclerview.a>> set) {
            AppMethodBeat.i(244183);
            p.h(set, "recordsSet");
            Log.i("Finder.FinderTimelineLbsMixPresenter", "onExposeTimeRecorded: size = " + set.size());
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            FinderReporterUIC fH = FinderReporterUIC.a.fH(this.tRd.activity);
            com.tencent.mm.plugin.finder.report.e c2 = fH != null ? FinderReporterUIC.c(fH) : null;
            if (c2 instanceof ac) {
                ArrayList arrayList = new ArrayList();
                for (T t : set) {
                    if (t.RqA instanceof com.tencent.mm.plugin.finder.model.c) {
                        arrayList.add(t);
                    }
                }
                ((ac) c2).e(arrayList, this.tRd.tRa);
            }
            AppMethodBeat.o(244183);
        }
    }

    public final void ED(long j2) {
        AppMethodBeat.i(244208);
        aj.b<com.tencent.mm.plugin.finder.model.c> bVar = this.tQZ;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        RefreshLoadMoreLayout dcQ = bVar.dcQ();
        if (dcQ != null) {
            dcQ.postDelayed(new b(dcQ), j2);
            AppMethodBeat.o(244208);
            return;
        }
        AppMethodBeat.o(244208);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class b implements Runnable {
        final /* synthetic */ boolean $isSilence = false;
        final /* synthetic */ RefreshLoadMoreLayout $rlLayout;

        b(RefreshLoadMoreLayout refreshLoadMoreLayout) {
            this.$rlLayout = refreshLoadMoreLayout;
        }

        public final void run() {
            AppMethodBeat.i(244176);
            this.$rlLayout.DD(this.$isSilence);
            AppMethodBeat.o(244176);
        }
    }

    public final void onActionbarClick(boolean z) {
        AppMethodBeat.i(244209);
        aj.b<com.tencent.mm.plugin.finder.model.c> bVar = this.tQZ;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        RecyclerView recyclerView = bVar.getRecyclerView();
        if (recyclerView == null) {
            AppMethodBeat.o(244209);
            return;
        }
        int findFirstPosition = findFirstPosition(recyclerView);
        Log.i("Finder.FinderTimelineLbsMixPresenter", "[onActionbarClick] position=" + findFirstPosition + " isDouble=" + z);
        if (findFirstPosition <= 12) {
            com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter", "onActionbarClick", "(Z)V", "Undefined", "smoothScrollToPosition", "(I)V");
            recyclerView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter", "onActionbarClick", "(Z)V", "Undefined", "smoothScrollToPosition", "(I)V");
        } else {
            com.tencent.mm.hellhoundlib.b.a a3 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a3.axQ(), "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter", "onActionbarClick", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
            recyclerView.scrollToPosition(((Integer) a3.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter", "onActionbarClick", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
        }
        if (z) {
            if (findFirstPosition <= 12) {
                ED(20);
            } else {
                ED(600);
            }
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            FinderReporterUIC fH = FinderReporterUIC.a.fH(this.activity);
            if (fH != null) {
                com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                com.tencent.mm.plugin.finder.report.k.a(fH.dIx(), 5);
                AppMethodBeat.o(244209);
                return;
            }
            AppMethodBeat.o(244209);
            return;
        }
        FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
        FinderReporterUIC fH2 = FinderReporterUIC.a.fH(this.activity);
        if (fH2 != null) {
            com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k.a(fH2.dIx(), 1);
            AppMethodBeat.o(244209);
            return;
        }
        AppMethodBeat.o(244209);
    }

    public static int findFirstPosition(RecyclerView recyclerView) {
        AppMethodBeat.i(244210);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            int[] iArr = new int[2];
            ((StaggeredGridLayoutManager) layoutManager).n(iArr);
            int i2 = iArr[1];
            AppMethodBeat.o(244210);
            return i2;
        } else if (layoutManager instanceof LinearLayoutManager) {
            int ks = ((LinearLayoutManager) layoutManager).ks();
            AppMethodBeat.o(244210);
            return ks;
        } else {
            AppMethodBeat.o(244210);
            return 0;
        }
    }

    @Override // com.tencent.mm.plugin.finder.presenter.base.a
    public final void onDetach() {
        AppMethodBeat.i(244211);
        FinderLbsLoader finderLbsLoader = this.tQY;
        if (finderLbsLoader == null) {
            p.btv("feedLoader");
        }
        finderLbsLoader.unregister(this.tagViewActionCallback);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ((FinderHomeTabStateVM) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).Mp(1000);
        AppMethodBeat.o(244211);
    }

    static /* synthetic */ void a(ak akVar) {
        AppMethodBeat.i(244213);
        akVar.checkEmptyHeader(null);
        AppMethodBeat.o(244213);
    }

    private final void checkEmptyHeader(RefreshLoadMoreLayout.c<Object> cVar) {
        AppMethodBeat.i(244212);
        com.tencent.mm.ac.d.h(new c(this, cVar));
        AppMethodBeat.o(244212);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\f\u0010\u0002\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\"\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J \u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0016\u0010\u0011\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013H\u0016J\u0016\u0010\u0014\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013H\u0016J\u0016\u0010\u0015\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013H\u0016¨\u0006\u0016"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsMixPresenter$tagViewActionCallback$1", "Lcom/tencent/mm/view/IViewActionCallback;", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", MessengerShareContentUtility.ATTACHMENT_PAYLOAD, "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "plugin-finder_release"})
    public static final class l implements com.tencent.mm.view.j {
        final /* synthetic */ ak tRd;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        l(ak akVar) {
            this.tRd = akVar;
        }

        private WxRecyclerAdapter<?> getAdapter() {
            AppMethodBeat.i(244192);
            RecyclerView recyclerView = this.tRd.dcS().getRecyclerView();
            RecyclerView.a adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (!(adapter instanceof WxRecyclerAdapter)) {
                adapter = null;
            }
            WxRecyclerAdapter<?> wxRecyclerAdapter = (WxRecyclerAdapter) adapter;
            AppMethodBeat.o(244192);
            return wxRecyclerAdapter;
        }

        @Override // com.tencent.mm.view.j
        public final void onChanged() {
            RefreshLoadMoreLayout dcQ;
            AppMethodBeat.i(244193);
            aj.b<com.tencent.mm.plugin.finder.model.c> dcS = this.tRd.dcS();
            if (!(dcS == null || (dcQ = dcS.dcQ()) == null)) {
                dcQ.onChanged();
            }
            ak.a(this.tRd);
            AppMethodBeat.o(244193);
        }

        @Override // com.tencent.mm.view.j
        public final void onItemRangeChanged(int i2, int i3) {
            RefreshLoadMoreLayout dcQ;
            int i4;
            AppMethodBeat.i(244194);
            aj.b<com.tencent.mm.plugin.finder.model.c> dcS = this.tRd.dcS();
            if (dcS == null || (dcQ = dcS.dcQ()) == null) {
                AppMethodBeat.o(244194);
                return;
            }
            WxRecyclerAdapter<?> adapter = getAdapter();
            if (adapter != null) {
                i4 = adapter.RqM.size();
            } else {
                i4 = 0;
            }
            dcQ.onItemRangeChanged(i4 + i2, i3);
            AppMethodBeat.o(244194);
        }

        @Override // com.tencent.mm.view.j
        public final void onItemRangeChanged(int i2, int i3, Object obj) {
            RefreshLoadMoreLayout dcQ;
            int i4;
            AppMethodBeat.i(244195);
            aj.b<com.tencent.mm.plugin.finder.model.c> dcS = this.tRd.dcS();
            if (dcS == null || (dcQ = dcS.dcQ()) == null) {
                AppMethodBeat.o(244195);
                return;
            }
            WxRecyclerAdapter<?> adapter = getAdapter();
            if (adapter != null) {
                i4 = adapter.RqM.size();
            } else {
                i4 = 0;
            }
            dcQ.onItemRangeChanged(i4 + i2, i3, obj);
            AppMethodBeat.o(244195);
        }

        @Override // com.tencent.mm.view.j
        public final void onItemRangeInserted(int i2, int i3) {
            RefreshLoadMoreLayout dcQ;
            int i4;
            AppMethodBeat.i(244196);
            aj.b<com.tencent.mm.plugin.finder.model.c> dcS = this.tRd.dcS();
            if (dcS == null || (dcQ = dcS.dcQ()) == null) {
                AppMethodBeat.o(244196);
                return;
            }
            WxRecyclerAdapter<?> adapter = getAdapter();
            if (adapter != null) {
                i4 = adapter.RqM.size();
            } else {
                i4 = 0;
            }
            dcQ.onItemRangeInserted(i4 + i2, i3);
            AppMethodBeat.o(244196);
        }

        @Override // com.tencent.mm.view.j
        public final void onItemRangeRemoved(int i2, int i3) {
            RefreshLoadMoreLayout dcQ;
            int i4;
            AppMethodBeat.i(244197);
            aj.b<com.tencent.mm.plugin.finder.model.c> dcS = this.tRd.dcS();
            if (dcS == null || (dcQ = dcS.dcQ()) == null) {
                AppMethodBeat.o(244197);
                return;
            }
            WxRecyclerAdapter<?> adapter = getAdapter();
            if (adapter != null) {
                i4 = adapter.RqM.size();
            } else {
                i4 = 0;
            }
            dcQ.onItemRangeRemoved(i4 + i2, i3);
            AppMethodBeat.o(244197);
        }

        @Override // com.tencent.mm.view.i
        public final void onPreFinishRefresh(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(244198);
            p.h(cVar, "reason");
            RefreshLoadMoreLayout dcQ = this.tRd.dcS().dcQ();
            if (dcQ != null) {
                dcQ.onPreFinishRefresh(cVar);
                AppMethodBeat.o(244198);
                return;
            }
            AppMethodBeat.o(244198);
        }

        @Override // com.tencent.mm.view.i
        public final void onPreFinishLoadMore(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(244199);
            p.h(cVar, "reason");
            RefreshLoadMoreLayout dcQ = this.tRd.dcS().dcQ();
            if (dcQ != null) {
                dcQ.onPreFinishLoadMore(cVar);
                AppMethodBeat.o(244199);
                return;
            }
            AppMethodBeat.o(244199);
        }

        @Override // com.tencent.mm.view.i
        public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(244200);
            p.h(cVar, "reason");
            RefreshLoadMoreLayout dcQ = this.tRd.dcS().dcQ();
            if (dcQ != null) {
                dcQ.onPreFinishLoadMoreSmooth(cVar);
                AppMethodBeat.o(244200);
                return;
            }
            AppMethodBeat.o(244200);
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.aj.a
    public final void a(com.tencent.mm.g.b.a.cl clVar, o oVar, int i2) {
        AppMethodBeat.i(244214);
        p.h(clVar, "struct");
        p.h(oVar, "lbsItem");
        FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
        FinderReporterUIC fH = FinderReporterUIC.a.fH(this.activity);
        com.tencent.mm.plugin.finder.report.e c2 = fH != null ? FinderReporterUIC.c(fH) : null;
        if (c2 instanceof ac) {
            clVar.gv(this.tRa);
            p.h(clVar, "struct");
            p.h(oVar, "lbsItem");
            com.tencent.mm.g.b.a.cl clVar2 = (com.tencent.mm.g.b.a.cl) ac.a((com.tencent.mm.g.b.a.cl) ((ac) c2).b(clVar), oVar);
            if (i2 >= 0 && i2 < oVar.vDZ.size()) {
                clVar2.gz((long) i2);
                BaseFinderFeed baseFinderFeed = oVar.vDZ.get(i2);
                p.g(baseFinderFeed, "lbsItem.feedList[feedIndex]");
                ac.a(clVar2, baseFinderFeed);
            }
            clVar2.bfK();
        }
        AppMethodBeat.o(244214);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class h extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ ak tRd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(ak akVar) {
            super(0);
            this.tRd = akVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(244185);
            RefreshLoadMoreLayout dcQ = this.tRd.dcS().dcQ();
            if (dcQ != null) {
                dcQ.postDelayed(new Runnable(this) {
                    /* class com.tencent.mm.plugin.finder.feed.ak.h.AnonymousClass1 */
                    final /* synthetic */ h tRf;

                    {
                        this.tRf = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(244184);
                        RefreshLoadMoreLayout.c<Object> cVar = new RefreshLoadMoreLayout.c<>(0);
                        cVar.Rmh = -2;
                        RefreshLoadMoreLayout dcQ = this.tRf.tRd.dcS().dcQ();
                        if (dcQ != null) {
                            dcQ.g(cVar);
                            AppMethodBeat.o(244184);
                            return;
                        }
                        AppMethodBeat.o(244184);
                    }
                }, 200);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(244185);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class i extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ ak tRd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(ak akVar) {
            super(0);
            this.tRd = akVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(244189);
            if (!this.tRd.isRequestingLbs) {
                this.tRd.isRequestingLbs = true;
                com.tencent.mm.ac.d.b("LbsPresenter_requestLbs", new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.mm.plugin.finder.feed.ak.i.AnonymousClass1 */
                    final /* synthetic */ i tRg;

                    {
                        this.tRg = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(244188);
                        com.tencent.mm.plugin.finder.utils.l lVar = com.tencent.mm.plugin.finder.utils.l.vVE;
                        final boolean dBK = com.tencent.mm.plugin.finder.utils.l.dBK();
                        this.tRg.tRd.isRequestingLbs = false;
                        com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                            /* class com.tencent.mm.plugin.finder.feed.ak.i.AnonymousClass1.AnonymousClass1 */
                            final /* synthetic */ AnonymousClass1 tRh;

                            {
                                this.tRh = r2;
                            }

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            @Override // kotlin.g.a.a
                            public final /* synthetic */ x invoke() {
                                AppMethodBeat.i(244187);
                                if (dBK) {
                                    com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                                    com.tencent.mm.plugin.finder.report.k.ac(this.tRh.tRg.tRd.activity, 6);
                                    this.tRh.tRg.tRd.dcR().requestRefresh();
                                } else {
                                    com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
                                    com.tencent.mm.plugin.finder.report.k.ac(this.tRh.tRg.tRd.activity, 7);
                                    RefreshLoadMoreLayout dcQ = this.tRh.tRg.tRd.dcS().dcQ();
                                    if (dcQ != null) {
                                        dcQ.postDelayed(new Runnable(this) {
                                            /* class com.tencent.mm.plugin.finder.feed.ak.i.AnonymousClass1.AnonymousClass1.AnonymousClass1 */
                                            final /* synthetic */ AnonymousClass1 tRi;

                                            {
                                                this.tRi = r1;
                                            }

                                            public final void run() {
                                                AppMethodBeat.i(244186);
                                                RefreshLoadMoreLayout.c<Object> cVar = new RefreshLoadMoreLayout.c<>(0);
                                                cVar.Rmh = -2;
                                                RefreshLoadMoreLayout dcQ = this.tRi.tRh.tRg.tRd.dcS().dcQ();
                                                if (dcQ != null) {
                                                    dcQ.g(cVar);
                                                    AppMethodBeat.o(244186);
                                                    return;
                                                }
                                                AppMethodBeat.o(244186);
                                            }
                                        }, 200);
                                    }
                                }
                                x xVar = x.SXb;
                                AppMethodBeat.o(244187);
                                return xVar;
                            }
                        });
                        x xVar = x.SXb;
                        AppMethodBeat.o(244188);
                        return xVar;
                    }
                });
            }
            x xVar = x.SXb;
            AppMethodBeat.o(244189);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class j extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ ak tRd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(ak akVar) {
            super(0);
            this.tRd = akVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(244190);
            this.tRd.dcR().requestRefresh();
            x xVar = x.SXb;
            AppMethodBeat.o(244190);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ RefreshLoadMoreLayout.c $r;
        final /* synthetic */ ak tRd;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(ak akVar, RefreshLoadMoreLayout.c cVar) {
            super(0);
            this.tRd = akVar;
            this.$r = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            RefreshLoadMoreLayout.c cVar;
            int i2;
            boolean z;
            RefreshLoadMoreLayout dcQ;
            RefreshLoadMoreLayout dcQ2;
            RecyclerView recyclerView;
            boolean z2 = false;
            AppMethodBeat.i(244177);
            RefreshLoadMoreLayout.c cVar2 = this.$r;
            if (cVar2 == null) {
                RefreshLoadMoreLayout.c cVar3 = new RefreshLoadMoreLayout.c(0);
                Context context = MMApplicationContext.getContext();
                p.g(context, "MMApplicationContext.getContext()");
                cVar3.Rmi = context.getResources().getString(R.string.d3g);
                cVar = cVar3;
            } else {
                cVar = cVar2;
            }
            aj.b<com.tencent.mm.plugin.finder.model.c> dcS = this.tRd.dcS();
            RecyclerView.a adapter = (dcS == null || (recyclerView = dcS.getRecyclerView()) == null) ? null : recyclerView.getAdapter();
            if (!(adapter instanceof WxRecyclerAdapter)) {
                adapter = null;
            }
            WxRecyclerAdapter wxRecyclerAdapter = (WxRecyclerAdapter) adapter;
            if (wxRecyclerAdapter != null) {
                i2 = wxRecyclerAdapter.hgt();
            } else {
                i2 = 0;
            }
            boolean z3 = i2 <= 0;
            Log.i("Finder.FinderTimelineLbsMixPresenter", "[checkEmptyHeader] isEmpty=" + z3 + " reason=" + cVar);
            if (cVar.actionType == 2 || cVar.Rmh != -2) {
                z = false;
            } else {
                z = true;
            }
            if (z3 || z) {
                if (z) {
                    this.tRd.dcR().getDataList().clear();
                    if (wxRecyclerAdapter != null) {
                        wxRecyclerAdapter.notifyDataSetChanged();
                    }
                    this.tRd.isEmptyLocation = true;
                }
                aj.b<com.tencent.mm.plugin.finder.model.c> dcS2 = this.tRd.dcS();
                if (!(dcS2 == null || (dcQ = dcS2.dcQ()) == null)) {
                    dcQ.setEnableLoadMore(false);
                }
                com.tencent.mm.plugin.finder.model.g gVar = this.tRd.emptyData;
                Context context2 = MMApplicationContext.getContext();
                p.g(context2, "MMApplicationContext.getContext()");
                String string = context2.getResources().getString(R.string.d3g);
                p.g(string, "MMApplicationContext.get…g.finder_no_more_content)");
                gVar.P(string);
                this.tRd.emptyData.type = cVar.Rmh;
                this.tRd.emptyData.dLS = 1000;
                if (wxRecyclerAdapter != null && !wxRecyclerAdapter.a(this.tRd.emptyData)) {
                    wxRecyclerAdapter.a((g.b) this.tRd.emptyData, false);
                } else if (wxRecyclerAdapter != null) {
                    wxRecyclerAdapter.Or((long) this.tRd.emptyData.hashCode());
                }
            } else if (wxRecyclerAdapter != null) {
                wxRecyclerAdapter.T((long) this.tRd.emptyData.hashCode(), false);
            }
            aj.b<com.tencent.mm.plugin.finder.model.c> dcS3 = this.tRd.dcS();
            if (!(dcS3 == null || (dcQ2 = dcS3.dcQ()) == null)) {
                if (cVar.Rmh != -1 || !z3) {
                    z2 = true;
                }
                dcQ2.setEnableNestedScroll(z2);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(244177);
            return xVar;
        }
    }
}
