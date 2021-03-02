package com.tencent.mm.plugin.finder.feed;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.cl;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.aj;
import com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.storage.o;
import com.tencent.mm.plugin.finder.ui.fragment.FinderHomeTabFragment;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 J2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001JB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\tH\u0016J\u001a\u0010(\u001a\u00020$2\u0010\b\u0002\u0010)\u001a\n\u0012\u0004\u0012\u00020+\u0018\u00010*H\u0002J\u0010\u0010,\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020.H\u0002J\u000e\u0010/\u001a\b\u0012\u0004\u0012\u00020100H\u0016J\u0018\u00102\u001a\u00020$2\u0006\u00103\u001a\u00020.2\u0006\u00104\u001a\u00020&H\u0002J\u0010\u00105\u001a\u00020$2\u0006\u00106\u001a\u00020\tH\u0016J\u0016\u00107\u001a\u00020$2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00020\u001eH\u0016J \u00109\u001a\u00020$2\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020\u001cH\u0016J\b\u0010?\u001a\u00020$H\u0016J\b\u0010@\u001a\u00020$H\u0016J\b\u0010A\u001a\u00020$H\u0016J\b\u0010B\u001a\u00020$H\u0016J\u0016\u0010C\u001a\u00020$2\f\u0010D\u001a\b\u0012\u0004\u0012\u00020+0*H\u0016J\b\u0010E\u001a\u00020$H\u0016J\b\u0010F\u001a\u00020$H\u0002J\u000e\u0010G\u001a\u00020$2\u0006\u0010H\u001a\u00020IR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u000e¢\u0006\u0002\n\u0000R \u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00020\u001eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"¨\u0006K"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$Presenter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "fragment", "Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/ui/fragment/FinderHomeTabFragment;)V", "canTimelineRefresh", "", "emptyData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderEmptyData;", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;", "isEmptyLocation", "isRequestingLbs", "()Z", "setRequestingLbs", "(Z)V", "msgNotifyData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderMsgNotifyData;", "tagViewActionCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "totalDy", "", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsContract$ViewCallback;)V", "autoFlingToRefresh", "", "delayStart", "", "isSilence", "checkEmptyHeader", "r", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "findFirstPosition", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getHeaderInfo", "", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "notifyChanged", "rv", "itemId", "onActionbarClick", "isDouble", "onAttach", "callback", "onClickReport", "struct", "Lcom/tencent/mm/autogen/mmdata/rpt/FinderLbsCardActionReportStruct;", "lbsItem", "Lcom/tencent/mm/plugin/finder/storage/FinderLbsItem;", "feedIndex", "onDetach", "onFinishing", "onLoadMore", "onRefresh", "onRefreshEnd", "reason", "onUserVisibleFocused", "refreshMsgNotify", "refreshRV", "data", "Landroid/content/Intent;", "Companion", "plugin-finder_release"})
public final class am implements aj.a<bo> {
    public static final b tRp = new b((byte) 0);
    public final MMActivity activity;
    private final boolean canTimelineRefresh = this.tlCache.JN(2);
    private com.tencent.mm.plugin.finder.model.g emptyData;
    public boolean isEmptyLocation;
    boolean isRequestingLbs;
    private final com.tencent.mm.plugin.finder.model.h msgNotifyData;
    public aj.b<bo> tQZ;
    private final FinderHomeTabFragment tRb;
    public final FinderTimelineFeedLoader tRo;
    private com.tencent.mm.view.j tagViewActionCallback;
    public final FinderHomeTabStateVM tlCache;
    public int totalDy;

    static {
        AppMethodBeat.i(244276);
        AppMethodBeat.o(244276);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class i extends q implements kotlin.g.a.a<x> {
        public static final i tRy = new i();

        static {
            AppMethodBeat.i(244249);
            AppMethodBeat.o(244249);
        }

        i() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "RVFeed", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke"})
    public static final class k extends q implements kotlin.g.a.b<bo, Boolean> {
        public static final k tRA = new k();

        static {
            AppMethodBeat.i(244253);
            AppMethodBeat.o(244253);
        }

        k() {
            super(1);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ Boolean invoke(bo boVar) {
            boolean z;
            AppMethodBeat.i(244252);
            bo boVar2 = boVar;
            p.h(boVar2, "RVFeed");
            if (!(boVar2 instanceof com.tencent.mm.plugin.finder.model.x)) {
                z = true;
            } else {
                z = false;
            }
            Boolean valueOf = Boolean.valueOf(z);
            AppMethodBeat.o(244252);
            return valueOf;
        }
    }

    public am(MMActivity mMActivity, FinderHomeTabFragment finderHomeTabFragment) {
        p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(244275);
        this.activity = mMActivity;
        this.tRb = finderHomeTabFragment;
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ViewModel viewModel = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
        p.g(viewModel, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
        this.tlCache = (FinderHomeTabStateVM) viewModel;
        e.a aVar2 = com.tencent.mm.plugin.finder.feed.model.internal.e.tYB;
        com.tencent.mm.plugin.finder.feed.model.internal.e IO = e.a.IO(2);
        int i2 = this.canTimelineRefresh ? 0 : 1;
        com.tencent.mm.ui.component.a aVar3 = com.tencent.mm.ui.component.a.PRN;
        FinderTimelineFeedLoader finderTimelineFeedLoader = new FinderTimelineFeedLoader(IO, i2, ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.activity).get(FinderReporterUIC.class)).dIx());
        finderTimelineFeedLoader.setInitDone(new a(finderTimelineFeedLoader, this));
        this.tRo = finderTimelineFeedLoader;
        this.tagViewActionCallback = new l(this);
        this.emptyData = new com.tencent.mm.plugin.finder.model.g();
        this.msgNotifyData = new com.tencent.mm.plugin.finder.model.h();
        AppMethodBeat.o(244275);
    }

    @Override // com.tencent.mm.plugin.finder.presenter.base.a
    public final /* synthetic */ void onAttach(Object obj) {
        AppMethodBeat.i(244268);
        a((aj.b) obj);
        AppMethodBeat.o(244268);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    public final aj.b<bo> dcS() {
        AppMethodBeat.i(244263);
        aj.b<bo> bVar = this.tQZ;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        AppMethodBeat.o(244263);
        return bVar;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$feedLoader$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
    public static final class a implements com.tencent.mm.plugin.finder.feed.model.internal.h {
        final /* synthetic */ FinderTimelineFeedLoader tRq;
        final /* synthetic */ am tRr;

        a(FinderTimelineFeedLoader finderTimelineFeedLoader, am amVar) {
            this.tRq = finderTimelineFeedLoader;
            this.tRr = amVar;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.h
        public final void call(int i2) {
            AppMethodBeat.i(244233);
            Log.i(this.tRq.getTAG(), "[initData] canTimelineRefresh=" + this.tRr.canTimelineRefresh + ", incrementCount=" + i2);
            if (this.tRr.canTimelineRefresh) {
                this.tRr.ED(0);
                RefreshLoadMoreLayout dcQ = this.tRr.dcS().dcQ();
                if (dcQ != null) {
                    dcQ.post(an.tRs);
                }
            } else {
                FinderHomeTabStateVM.a Mq = this.tRr.tlCache.Mq(2);
                final int i3 = Mq.wuf;
                final int i4 = Mq.wug;
                Log.i(this.tRq.getTAG(), "[initData] canTimelineRefresh " + this.tRr.canTimelineRefresh + " lastPos=" + i3 + " fromTopPixel=" + i4);
                RecyclerView recyclerView = this.tRr.dcS().getRecyclerView();
                final RecyclerView.LayoutManager layoutManager = recyclerView != null ? recyclerView.getLayoutManager() : null;
                this.tRr.totalDy = i4;
                if (layoutManager instanceof StaggeredGridLayoutManager) {
                    ((StaggeredGridLayoutManager) layoutManager).ah(i3, i4);
                    RecyclerView recyclerView2 = this.tRr.dcS().getRecyclerView();
                    if (recyclerView2 != null) {
                        recyclerView2.post(new Runnable() {
                            /* class com.tencent.mm.plugin.finder.feed.am.a.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(244232);
                                ((StaggeredGridLayoutManager) layoutManager).ah(i3, i4);
                                AppMethodBeat.o(244232);
                            }
                        });
                    }
                }
            }
            RefreshLoadMoreLayout dcQ2 = this.tRr.dcS().dcQ();
            if (dcQ2 != null) {
                dcQ2.post(ao.tRt);
                AppMethodBeat.o(244233);
                return;
            }
            AppMethodBeat.o(244233);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\f\u0010\u0002\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\"\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J \u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0016\u0010\u0011\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013H\u0016J\u0016\u0010\u0014\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013H\u0016J\u0016\u0010\u0015\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013H\u0016¨\u0006\u0016"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$tagViewActionCallback$1", "Lcom/tencent/mm/view/IViewActionCallback;", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", MessengerShareContentUtility.ATTACHMENT_PAYLOAD, "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "plugin-finder_release"})
    public static final class l implements com.tencent.mm.view.j {
        final /* synthetic */ am tRr;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        l(am amVar) {
            this.tRr = amVar;
        }

        private WxRecyclerAdapter<?> getAdapter() {
            RecyclerView recyclerView;
            AppMethodBeat.i(244254);
            aj.b<bo> dcS = this.tRr.dcS();
            RecyclerView.a adapter = (dcS == null || (recyclerView = dcS.getRecyclerView()) == null) ? null : recyclerView.getAdapter();
            if (!(adapter instanceof WxRecyclerAdapter)) {
                adapter = null;
            }
            WxRecyclerAdapter<?> wxRecyclerAdapter = (WxRecyclerAdapter) adapter;
            AppMethodBeat.o(244254);
            return wxRecyclerAdapter;
        }

        @Override // com.tencent.mm.view.j
        public final void onChanged() {
            RefreshLoadMoreLayout dcQ;
            AppMethodBeat.i(244255);
            aj.b<bo> dcS = this.tRr.dcS();
            if (dcS == null || (dcQ = dcS.dcQ()) == null) {
                AppMethodBeat.o(244255);
                return;
            }
            dcQ.onChanged();
            AppMethodBeat.o(244255);
        }

        @Override // com.tencent.mm.view.j
        public final void onItemRangeChanged(int i2, int i3) {
            RefreshLoadMoreLayout dcQ;
            int i4;
            AppMethodBeat.i(244256);
            aj.b<bo> dcS = this.tRr.dcS();
            if (dcS == null || (dcQ = dcS.dcQ()) == null) {
                AppMethodBeat.o(244256);
                return;
            }
            WxRecyclerAdapter<?> adapter = getAdapter();
            if (adapter != null) {
                i4 = adapter.RqM.size();
            } else {
                i4 = 0;
            }
            dcQ.onItemRangeChanged(i4 + i2, i3);
            AppMethodBeat.o(244256);
        }

        @Override // com.tencent.mm.view.j
        public final void onItemRangeChanged(int i2, int i3, Object obj) {
            RefreshLoadMoreLayout dcQ;
            int i4;
            AppMethodBeat.i(244257);
            aj.b<bo> dcS = this.tRr.dcS();
            if (dcS == null || (dcQ = dcS.dcQ()) == null) {
                AppMethodBeat.o(244257);
                return;
            }
            WxRecyclerAdapter<?> adapter = getAdapter();
            if (adapter != null) {
                i4 = adapter.RqM.size();
            } else {
                i4 = 0;
            }
            dcQ.onItemRangeChanged(i4 + i2, i3, obj);
            AppMethodBeat.o(244257);
        }

        @Override // com.tencent.mm.view.j
        public final void onItemRangeInserted(int i2, int i3) {
            RefreshLoadMoreLayout dcQ;
            int i4;
            AppMethodBeat.i(244258);
            aj.b<bo> dcS = this.tRr.dcS();
            if (dcS == null || (dcQ = dcS.dcQ()) == null) {
                AppMethodBeat.o(244258);
                return;
            }
            WxRecyclerAdapter<?> adapter = getAdapter();
            if (adapter != null) {
                i4 = adapter.RqM.size();
            } else {
                i4 = 0;
            }
            dcQ.onItemRangeInserted(i4 + i2, i3);
            AppMethodBeat.o(244258);
        }

        @Override // com.tencent.mm.view.j
        public final void onItemRangeRemoved(int i2, int i3) {
            RefreshLoadMoreLayout dcQ;
            int i4;
            AppMethodBeat.i(244259);
            aj.b<bo> dcS = this.tRr.dcS();
            if (dcS == null || (dcQ = dcS.dcQ()) == null) {
                AppMethodBeat.o(244259);
                return;
            }
            WxRecyclerAdapter<?> adapter = getAdapter();
            if (adapter != null) {
                i4 = adapter.RqM.size();
            } else {
                i4 = 0;
            }
            dcQ.onItemRangeRemoved(i4 + i2, i3);
            AppMethodBeat.o(244259);
        }

        @Override // com.tencent.mm.view.i
        public final void onPreFinishRefresh(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(244260);
            p.h(cVar, "reason");
            RefreshLoadMoreLayout dcQ = this.tRr.dcS().dcQ();
            if (dcQ != null) {
                dcQ.onPreFinishRefresh(cVar);
                AppMethodBeat.o(244260);
                return;
            }
            AppMethodBeat.o(244260);
        }

        @Override // com.tencent.mm.view.i
        public final void onPreFinishLoadMore(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(244261);
            p.h(cVar, "reason");
            RefreshLoadMoreLayout dcQ = this.tRr.dcS().dcQ();
            if (dcQ != null) {
                dcQ.onPreFinishLoadMore(cVar);
                AppMethodBeat.o(244261);
                return;
            }
            AppMethodBeat.o(244261);
        }

        @Override // com.tencent.mm.view.i
        public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(244262);
            p.h(cVar, "reason");
            RefreshLoadMoreLayout dcQ = this.tRr.dcS().dcQ();
            if (dcQ != null) {
                dcQ.onPreFinishLoadMoreSmooth(cVar);
                AppMethodBeat.o(244262);
                return;
            }
            AppMethodBeat.o(244262);
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.aj.a
    public final void onRefresh() {
        AppMethodBeat.i(244264);
        com.tencent.mm.plugin.finder.utils.l lVar = com.tencent.mm.plugin.finder.utils.l.vVE;
        com.tencent.mm.plugin.finder.utils.l.a(new f(this), new g(this), new h(this));
        AppMethodBeat.o(244264);
    }

    @Override // com.tencent.mm.plugin.finder.feed.aj.a
    public final void onLoadMore() {
        AppMethodBeat.i(244266);
        this.tRo.requestLoadMore();
        AppMethodBeat.o(244266);
    }

    public final void a(aj.b<bo> bVar) {
        AppMethodBeat.i(244267);
        p.h(bVar, "callback");
        this.tQZ = bVar;
        aj.b<bo> bVar2 = this.tQZ;
        if (bVar2 == null) {
            p.btv("viewCallback");
        }
        bVar2.ab(this.tRo.getDataListJustForAdapter());
        this.tRo.register(this.tagViewActionCallback);
        com.tencent.mm.plugin.finder.utils.l lVar = com.tencent.mm.plugin.finder.utils.l.vVE;
        if (com.tencent.mm.plugin.finder.utils.l.dBJ()) {
            this.tlCache.Mq(2).wuc.size();
            BaseFeedLoader.requestInit$default(this.tRo, false, 1, null);
            aj.b<bo> bVar3 = this.tQZ;
            if (bVar3 == null) {
                p.btv("viewCallback");
            }
            RecyclerView recyclerView = bVar3.getRecyclerView();
            if (recyclerView != null) {
                recyclerView.a(new e(this));
                AppMethodBeat.o(244267);
                return;
            }
            AppMethodBeat.o(244267);
            return;
        }
        RefreshLoadMoreLayout.c<Object> cVar = new RefreshLoadMoreLayout.c<>(0);
        cVar.Rmh = -2;
        checkEmptyHeader(cVar);
        AppMethodBeat.o(244267);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$onAttach$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
    public static final class e extends RecyclerView.l {
        final /* synthetic */ am tRr;

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(244241);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$onAttach$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            super.onScrollStateChanged(recyclerView, i2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$onAttach$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(244241);
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(am amVar) {
            this.tRr = amVar;
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(244240);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$onAttach$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            p.h(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            this.tRr.totalDy -= i3;
            com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
            com.tencent.mm.plugin.finder.report.live.k.b(recyclerView, s.p.LIVE_AUDIENCE_EXPLORE_SINGLE_AVATAR, s.j.COMMENT_SCENE_LBS_TOP_LIVE_CARD.scene, com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_SCROLL);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter$onAttach$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(244240);
        }
    }

    private final void checkEmptyHeader(RefreshLoadMoreLayout.c<Object> cVar) {
        AppMethodBeat.i(244269);
        com.tencent.mm.ac.d.h(new d(this, cVar));
        AppMethodBeat.o(244269);
    }

    public final void ED(long j2) {
        AppMethodBeat.i(244270);
        aj.b<bo> bVar = this.tQZ;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        RefreshLoadMoreLayout dcQ = bVar.dcQ();
        if (dcQ != null) {
            dcQ.postDelayed(new c(dcQ), j2);
            AppMethodBeat.o(244270);
            return;
        }
        AppMethodBeat.o(244270);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class c implements Runnable {
        final /* synthetic */ boolean $isSilence = false;
        final /* synthetic */ RefreshLoadMoreLayout $rlLayout;

        c(RefreshLoadMoreLayout refreshLoadMoreLayout) {
            this.$rlLayout = refreshLoadMoreLayout;
        }

        public final void run() {
            AppMethodBeat.i(244234);
            this.$rlLayout.DD(this.$isSilence);
            AppMethodBeat.o(244234);
        }
    }

    public final void onActionbarClick(boolean z) {
        AppMethodBeat.i(244271);
        aj.b<bo> bVar = this.tQZ;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        RecyclerView recyclerView = bVar.getRecyclerView();
        if (recyclerView == null) {
            AppMethodBeat.o(244271);
            return;
        }
        int findFirstPosition = findFirstPosition(recyclerView);
        Log.i("Finder.TimelineLbsPresenter", "[onActionbarClick] position=" + findFirstPosition + " isDouble=" + z);
        if (findFirstPosition <= 12) {
            com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter", "onActionbarClick", "(Z)V", "Undefined", "smoothScrollToPosition", "(I)V");
            recyclerView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter", "onActionbarClick", "(Z)V", "Undefined", "smoothScrollToPosition", "(I)V");
        } else {
            com.tencent.mm.hellhoundlib.b.a a3 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
            com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a3.axQ(), "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter", "onActionbarClick", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
            recyclerView.scrollToPosition(((Integer) a3.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/finder/feed/FinderTimelineLbsPresenter", "onActionbarClick", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
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
                AppMethodBeat.o(244271);
                return;
            }
            AppMethodBeat.o(244271);
            return;
        }
        FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
        FinderReporterUIC fH2 = FinderReporterUIC.a.fH(this.activity);
        if (fH2 != null) {
            com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
            com.tencent.mm.plugin.finder.report.k.a(fH2.dIx(), 1);
            AppMethodBeat.o(244271);
            return;
        }
        AppMethodBeat.o(244271);
    }

    public static int findFirstPosition(RecyclerView recyclerView) {
        AppMethodBeat.i(244272);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            int[] iArr = new int[2];
            ((StaggeredGridLayoutManager) layoutManager).n(iArr);
            int i2 = iArr[1];
            AppMethodBeat.o(244272);
            return i2;
        } else if (layoutManager instanceof LinearLayoutManager) {
            int ks = ((LinearLayoutManager) layoutManager).ks();
            AppMethodBeat.o(244272);
            return ks;
        } else {
            AppMethodBeat.o(244272);
            return 0;
        }
    }

    @Override // com.tencent.mm.plugin.finder.presenter.base.a
    public final void onDetach() {
        AppMethodBeat.i(244273);
        this.tRo.unregister(this.tagViewActionCallback);
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ((FinderHomeTabStateVM) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).Mp(2);
        AppMethodBeat.o(244273);
    }

    @Override // com.tencent.mm.plugin.finder.feed.aj.a
    public final void a(cl clVar, o oVar, int i2) {
        AppMethodBeat.i(244274);
        p.h(clVar, "struct");
        p.h(oVar, "lbsItem");
        AppMethodBeat.o(244274);
    }

    @Override // com.tencent.mm.plugin.finder.feed.aj.a
    public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> cVar) {
        AppMethodBeat.i(244265);
        p.h(cVar, "reason");
        if (cVar.Rmk <= 0) {
            aj.b<bo> bVar = this.tQZ;
            if (bVar == null) {
                p.btv("viewCallback");
            }
            RefreshLoadMoreLayout dcQ = bVar.dcQ();
            if (dcQ != null) {
                com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
                dcQ.b(com.tencent.mm.plugin.finder.storage.c.dsb(), i.tRy);
            }
        }
        checkEmptyHeader(cVar);
        com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFinder.class);
        p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
        ((PluginFinder) ah).getRedDotManager().asV("finder_tl_nearby_tab");
        com.tencent.mm.kernel.b.a ah2 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
        p.g(ah2, "MMKernel.plugin(PluginFinder::class.java)");
        ((PluginFinder) ah2).getRedDotManager().gI("finder_tl_nearby_tab", "onRefreshEnd");
        com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
        com.tencent.mm.plugin.finder.report.live.k.b(null, s.p.LIVE_AUDIENCE_EXPLORE_SINGLE_AVATAR, s.j.COMMENT_SCENE_LBS_TOP_LIVE_CARD.scene, com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_REFRESH);
        AppMethodBeat.o(244265);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class f extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ am tRr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(am amVar) {
            super(0);
            this.tRr = amVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(244243);
            RefreshLoadMoreLayout dcQ = this.tRr.dcS().dcQ();
            if (dcQ != null) {
                dcQ.postDelayed(new Runnable(this) {
                    /* class com.tencent.mm.plugin.finder.feed.am.f.AnonymousClass1 */
                    final /* synthetic */ f tRu;

                    {
                        this.tRu = r1;
                    }

                    public final void run() {
                        AppMethodBeat.i(244242);
                        RefreshLoadMoreLayout.c<Object> cVar = new RefreshLoadMoreLayout.c<>(0);
                        cVar.Rmh = -2;
                        RefreshLoadMoreLayout dcQ = this.tRu.tRr.dcS().dcQ();
                        if (dcQ != null) {
                            dcQ.g(cVar);
                            AppMethodBeat.o(244242);
                            return;
                        }
                        AppMethodBeat.o(244242);
                    }
                }, 200);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(244243);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class g extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ am tRr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(am amVar) {
            super(0);
            this.tRr = amVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(244247);
            if (!this.tRr.isRequestingLbs) {
                this.tRr.isRequestingLbs = true;
                com.tencent.mm.ac.d.b("LbsPresenter_requestLbs", new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.mm.plugin.finder.feed.am.g.AnonymousClass1 */
                    final /* synthetic */ g tRv;

                    {
                        this.tRv = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(244246);
                        com.tencent.mm.plugin.finder.utils.l lVar = com.tencent.mm.plugin.finder.utils.l.vVE;
                        final boolean dBK = com.tencent.mm.plugin.finder.utils.l.dBK();
                        this.tRv.tRr.isRequestingLbs = false;
                        com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                            /* class com.tencent.mm.plugin.finder.feed.am.g.AnonymousClass1.AnonymousClass1 */
                            final /* synthetic */ AnonymousClass1 tRw;

                            {
                                this.tRw = r2;
                            }

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            @Override // kotlin.g.a.a
                            public final /* synthetic */ x invoke() {
                                AppMethodBeat.i(244245);
                                if (dBK) {
                                    com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                                    com.tencent.mm.plugin.finder.report.k.ac(this.tRw.tRv.tRr.activity, 6);
                                    this.tRw.tRv.tRr.tRo.requestRefresh();
                                } else {
                                    com.tencent.mm.plugin.finder.report.k kVar2 = com.tencent.mm.plugin.finder.report.k.vfA;
                                    com.tencent.mm.plugin.finder.report.k.ac(this.tRw.tRv.tRr.activity, 7);
                                    RefreshLoadMoreLayout dcQ = this.tRw.tRv.tRr.dcS().dcQ();
                                    if (dcQ != null) {
                                        dcQ.postDelayed(new Runnable(this) {
                                            /* class com.tencent.mm.plugin.finder.feed.am.g.AnonymousClass1.AnonymousClass1.AnonymousClass1 */
                                            final /* synthetic */ AnonymousClass1 tRx;

                                            {
                                                this.tRx = r1;
                                            }

                                            public final void run() {
                                                AppMethodBeat.i(244244);
                                                RefreshLoadMoreLayout.c<Object> cVar = new RefreshLoadMoreLayout.c<>(0);
                                                cVar.Rmh = -2;
                                                RefreshLoadMoreLayout dcQ = this.tRx.tRw.tRv.tRr.dcS().dcQ();
                                                if (dcQ != null) {
                                                    dcQ.g(cVar);
                                                    AppMethodBeat.o(244244);
                                                    return;
                                                }
                                                AppMethodBeat.o(244244);
                                            }
                                        }, 200);
                                    }
                                }
                                x xVar = x.SXb;
                                AppMethodBeat.o(244245);
                                return xVar;
                            }
                        });
                        x xVar = x.SXb;
                        AppMethodBeat.o(244246);
                        return xVar;
                    }
                });
            }
            x xVar = x.SXb;
            AppMethodBeat.o(244247);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class h extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ am tRr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(am amVar) {
            super(0);
            this.tRr = amVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(244248);
            this.tRr.tRo.requestRefresh();
            x xVar = x.SXb;
            AppMethodBeat.o(244248);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class d extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ RefreshLoadMoreLayout.c $r;
        final /* synthetic */ am tRr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(am amVar, RefreshLoadMoreLayout.c cVar) {
            super(0);
            this.tRr = amVar;
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
            AppMethodBeat.i(244235);
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
            aj.b<bo> dcS = this.tRr.dcS();
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
            Log.i("Finder.TimelineLbsPresenter", "[checkEmptyHeader] isEmpty=" + z3 + " reason=" + cVar);
            if (cVar.actionType == 2 || cVar.Rmh != -2) {
                z = false;
            } else {
                z = true;
            }
            if (z3 || z) {
                if (z) {
                    this.tRr.tRo.getDataList().clear();
                    if (wxRecyclerAdapter != null) {
                        wxRecyclerAdapter.notifyDataSetChanged();
                    }
                    this.tRr.isEmptyLocation = true;
                }
                aj.b<bo> dcS2 = this.tRr.dcS();
                if (!(dcS2 == null || (dcQ = dcS2.dcQ()) == null)) {
                    dcQ.setEnableLoadMore(false);
                }
                com.tencent.mm.plugin.finder.model.g gVar = this.tRr.emptyData;
                Context context2 = MMApplicationContext.getContext();
                p.g(context2, "MMApplicationContext.getContext()");
                String string = context2.getResources().getString(R.string.d3g);
                p.g(string, "MMApplicationContext.get…g.finder_no_more_content)");
                gVar.P(string);
                this.tRr.emptyData.type = cVar.Rmh;
                this.tRr.emptyData.dLS = 2;
                if (wxRecyclerAdapter != null && !wxRecyclerAdapter.a(this.tRr.emptyData)) {
                    wxRecyclerAdapter.a((g.b) this.tRr.emptyData, false);
                } else if (wxRecyclerAdapter != null) {
                    wxRecyclerAdapter.Or((long) this.tRr.emptyData.hashCode());
                }
            } else if (wxRecyclerAdapter != null) {
                wxRecyclerAdapter.T((long) this.tRr.emptyData.hashCode(), false);
            }
            aj.b<bo> dcS3 = this.tRr.dcS();
            if (!(dcS3 == null || (dcQ2 = dcS3.dcQ()) == null)) {
                if (cVar.Rmh != -1 || !z3) {
                    z2 = true;
                }
                dcQ2.setEnableNestedScroll(z2);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(244235);
            return xVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class j extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ am tRr;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(am amVar) {
            super(0);
            this.tRr = amVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(244251);
            com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
            p.g(aAh, "MMKernel.storage()");
            int i2 = aAh.azQ().getInt(ar.a.USERINFO_FINDER_WX_MENTION_COMMENT_INT_SYNC, 0);
            com.tencent.mm.kernel.e aAh2 = com.tencent.mm.kernel.g.aAh();
            p.g(aAh2, "MMKernel.storage()");
            int i3 = aAh2.azQ().getInt(ar.a.USERINFO_FINDER_WX_MENTION_LIKE_INT_SYNC, 0);
            com.tencent.mm.kernel.e aAh3 = com.tencent.mm.kernel.g.aAh();
            p.g(aAh3, "MMKernel.storage()");
            int i4 = aAh3.azQ().getInt(ar.a.USERINFO_FINDER_WX_MENTION_OBJECT_LIEK_LIKE_INT_SYNC, 0);
            com.tencent.mm.kernel.e aAh4 = com.tencent.mm.kernel.g.aAh();
            p.g(aAh4, "MMKernel.storage()");
            int i5 = aAh4.azQ().getInt(ar.a.USERINFO_FINDER_WX_MENTION_OBJECT_RECOMMEND_LIKE_INT_SYNC, 0);
            Log.i("Finder.TimelineLbsPresenter", "refreshMsgNotify commentCnt " + i2 + ", likeCnt " + i3 + " objectLikeLikeCnt " + i4 + " objectRecommendLikeCnt " + i5);
            this.tRr.msgNotifyData.count = i2 + i3 + i4 + i5;
            com.tencent.mm.plugin.finder.model.h hVar = this.tRr.msgNotifyData;
            com.tencent.mm.kernel.e aAh5 = com.tencent.mm.kernel.g.aAh();
            p.g(aAh5, "MMKernel.storage()");
            Object obj = aAh5.azQ().get(ar.a.USERINFO_FINDER_WX_MENTION_AVATAR_STRING_SYNC, "");
            if (obj == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(244251);
                throw tVar;
            }
            hVar.setAvatar((String) obj);
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.finder.feed.am.j.AnonymousClass1 */
                final /* synthetic */ j tRz;

                {
                    this.tRz = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(244250);
                    RecyclerView recyclerView = this.tRz.tRr.dcS().getRecyclerView();
                    if (recyclerView != null) {
                        com.tencent.mm.plugin.finder.model.h unused = this.tRz.tRr.msgNotifyData;
                        am.o(recyclerView);
                    }
                    x xVar = x.SXb;
                    AppMethodBeat.o(244250);
                    return xVar;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(244251);
            return xVar;
        }
    }

    public static final /* synthetic */ void o(RecyclerView recyclerView) {
        AppMethodBeat.i(244277);
        RecyclerView.a adapter = recyclerView.getAdapter();
        if (adapter == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
            AppMethodBeat.o(244277);
            throw tVar;
        }
        RecyclerView.v vVar = ((com.tencent.mm.view.recyclerview.g) adapter).V(512, false);
        Integer valueOf = vVar != null ? Integer.valueOf(vVar.lR()) : null;
        if (valueOf != null) {
            valueOf.intValue();
            RecyclerView.a adapter2 = recyclerView.getAdapter();
            if (adapter2 != null) {
                adapter2.ci(valueOf.intValue());
                AppMethodBeat.o(244277);
                return;
            }
            AppMethodBeat.o(244277);
            return;
        }
        AppMethodBeat.o(244277);
    }
}
