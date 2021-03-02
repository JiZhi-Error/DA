package com.tencent.mm.plugin.finder.feed;

import android.arch.lifecycle.ViewModel;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ig;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.aq;
import com.tencent.mm.plugin.finder.feed.model.FinderFeedRelTimelineLoader;
import com.tencent.mm.plugin.finder.feed.model.FinderTimelineFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.view.FinderTagView;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.FinderTagCacheVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.aoz;
import com.tencent.mm.protocal.protobuf.apa;
import com.tencent.mm.protocal.protobuf.bds;
import com.tencent.mm.protocal.protobuf.dmk;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 S2\u00020\u0001:\u0001SB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0006H\u0002J\u0010\u00103\u001a\u00020'2\u0006\u00104\u001a\u000205H\u0002J\u000e\u00106\u001a\b\u0012\u0004\u0012\u00020807H\u0016J\u0016\u00109\u001a\u00020/2\u0006\u0010:\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u0006J\u0006\u0010<\u001a\u00020/J\u0018\u0010=\u001a\u00020/2\u0006\u0010>\u001a\u0002052\u0006\u0010?\u001a\u000201H\u0002J\b\u0010@\u001a\u00020/H\u0016J\u0010\u0010A\u001a\u00020/2\u0006\u0010B\u001a\u00020)H\u0016J\u0006\u0010C\u001a\u00020/J\b\u0010D\u001a\u00020/H\u0016J\b\u0010E\u001a\u00020/H\u0016J\b\u0010F\u001a\u00020/H\u0016J\b\u0010G\u001a\u00020/H\u0016J\u0016\u0010H\u001a\u00020/2\f\u0010I\u001a\b\u0012\u0004\u0012\u00020K0JH\u0016J\b\u0010L\u001a\u00020/H\u0016J\b\u0010M\u001a\u00020/H\u0002J\u0006\u0010N\u001a\u00020/J\u0006\u0010O\u001a\u00020/J\u0018\u0010P\u001a\u00020/2\u0010\b\u0002\u0010Q\u001a\n\u0012\u0004\u0012\u00020/\u0018\u00010RR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u00020)X.¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u0006T"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$Presenter;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "canTimelineRefresh", "", "eventListener", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTagClickEvent;", "getEventListener", "()Lcom/tencent/mm/sdk/event/IListener;", "setEventListener", "(Lcom/tencent/mm/sdk/event/IListener;)V", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderTimelineFeedLoader;", "headerSearchData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderSearchData;", "headerTagsData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;", "getHeaderTagsData", "()Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;", "setHeaderTagsData", "(Lcom/tencent/mm/plugin/finder/model/FeedHeaderTagsData;)V", "msgNotifyData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderMsgNotifyData;", "relFeedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderFeedRelTimelineLoader;", "selectedTag", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "tagViewActionCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "tagsCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderTagCacheVM;", "tagsData", "Lcom/tencent/mm/protocal/protobuf/FinderCategoryRecommend;", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "totalDy", "", "viewCallback", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachineContract$ViewCallback;)V", "autoFlingToRefresh", "", "delayStart", "", "isSilence", "findFirstPosition", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getHeaderInfo", "", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "initDataFromCache", "forceCache", "refreshHeader", "initTagHeader", "notifyChanged", "rv", "itemId", "onActionbarClick", "onAttach", "callback", "onCategoryLoadMore", "onDetach", "onFinishing", "onLoadMore", "onRefresh", "onRefreshEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onUserVisibleFocused", "refreshMsgNotify", "refreshOnCategoryClick", "removeTagFlowView", "scrollToTop", "endCallBack", "Lkotlin/Function0;", "Companion", "plugin-finder_release"})
public final class ar implements aq.a {
    public static final b tRL = new b((byte) 0);
    private final MMActivity activity;
    private final boolean canTimelineRefresh = this.tlCache.JN(4);
    private final com.tencent.mm.plugin.finder.model.h msgNotifyData;
    private IListener<ig> tOh;
    private final FinderFeedRelTimelineLoader tRE;
    public final FinderTagCacheVM tRF;
    public aq.b tRG;
    private final com.tencent.mm.plugin.finder.model.i tRH = new com.tencent.mm.plugin.finder.model.i();
    public apa tRI;
    private bds tRJ;
    private com.tencent.mm.plugin.finder.model.j tRK;
    public final FinderTimelineFeedLoader tRo;
    private com.tencent.mm.view.j tagViewActionCallback;
    public final FinderHomeTabStateVM tlCache;
    public int totalDy;

    static {
        AppMethodBeat.i(244328);
        AppMethodBeat.o(244328);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke"})
    public static final class d extends q implements kotlin.g.a.b<IResponse<bo>, x> {
        final /* synthetic */ ar tRM;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(ar arVar) {
            super(1);
            this.tRM = arVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(IResponse<bo> iResponse) {
            AppMethodBeat.i(244297);
            IResponse<bo> iResponse2 = iResponse;
            p.h(iResponse2, LocaleUtil.ITALIAN);
            if (iResponse2.getPullType() != 2) {
                this.tRM.tRI = (apa) ((FinderTimelineFeedLoader.d) iResponse2).tXF;
                this.tRM.dcV();
            }
            x xVar = x.SXb;
            AppMethodBeat.o(244297);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class g extends q implements kotlin.g.a.a<x> {
        public static final g tRQ = new g();

        static {
            AppMethodBeat.i(244304);
            AppMethodBeat.o(244304);
        }

        g() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    public ar(MMActivity mMActivity) {
        p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(244327);
        this.activity = mMActivity;
        e.a aVar = com.tencent.mm.plugin.finder.feed.model.internal.e.tYB;
        int i2 = e.a.IO(4).value;
        com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
        this.tRE = new FinderFeedRelTimelineLoader(0, "", 4, null, i2, false, null, null, null, 0, ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.activity).get(FinderReporterUIC.class)).dIx(), 0.0f, 0.0f, 28648);
        com.tencent.mm.ui.component.a aVar3 = com.tencent.mm.ui.component.a.PRN;
        ViewModel viewModel = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
        p.g(viewModel, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
        this.tlCache = (FinderHomeTabStateVM) viewModel;
        com.tencent.mm.ui.component.a aVar4 = com.tencent.mm.ui.component.a.PRN;
        ViewModel viewModel2 = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderTagCacheVM.class);
        p.g(viewModel2, "UICProvider.of(PluginFin…erTagCacheVM::class.java)");
        this.tRF = (FinderTagCacheVM) viewModel2;
        e.a aVar5 = com.tencent.mm.plugin.finder.feed.model.internal.e.tYB;
        com.tencent.mm.plugin.finder.feed.model.internal.e IO = e.a.IO(4);
        int i3 = this.canTimelineRefresh ? 0 : 1;
        com.tencent.mm.ui.component.a aVar6 = com.tencent.mm.ui.component.a.PRN;
        FinderTimelineFeedLoader finderTimelineFeedLoader = new FinderTimelineFeedLoader(IO, i3, ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.activity).get(FinderReporterUIC.class)).dIx());
        finderTimelineFeedLoader.setInitDone(new a(finderTimelineFeedLoader, this));
        this.tRo = finderTimelineFeedLoader;
        this.tagViewActionCallback = new j(this);
        this.tRK = new com.tencent.mm.plugin.finder.model.j(new dmk());
        this.msgNotifyData = new com.tencent.mm.plugin.finder.model.h();
        AppMethodBeat.o(244327);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.tencent.mm.plugin.finder.presenter.base.a
    public final /* synthetic */ void onAttach(aq.b bVar) {
        AppMethodBeat.i(244323);
        a(bVar);
        AppMethodBeat.o(244323);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(byte b2) {
            this();
        }
    }

    public final aq.b dcU() {
        AppMethodBeat.i(244317);
        aq.b bVar = this.tRG;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        AppMethodBeat.o(244317);
        return bVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$feedLoader$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
    public static final class a implements com.tencent.mm.plugin.finder.feed.model.internal.h {
        final /* synthetic */ ar tRM;
        final /* synthetic */ FinderTimelineFeedLoader tRq;

        a(FinderTimelineFeedLoader finderTimelineFeedLoader, ar arVar) {
            this.tRq = finderTimelineFeedLoader;
            this.tRM = arVar;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.h
        public final void call(int i2) {
            boolean z;
            AppMethodBeat.i(244295);
            Log.i(this.tRq.getTAG(), "[initData] canTimelineRefresh=" + this.tRM.canTimelineRefresh + ", incrementCount=" + i2);
            if (this.tRM.canTimelineRefresh) {
                ar arVar = this.tRM;
                if (i2 <= 0) {
                    z = true;
                } else {
                    z = false;
                }
                ar.a(arVar, z);
                AppMethodBeat.o(244295);
                return;
            }
            FinderHomeTabStateVM.a Mq = this.tRM.tlCache.Mq(4);
            final int i3 = Mq.wuf;
            final int i4 = Mq.wug;
            this.tRM.totalDy = i4;
            Log.i(this.tRq.getTAG(), "[initData] canTimelineRefresh " + this.tRM.canTimelineRefresh + " lastPos=" + i3 + " fromTopPixel=" + i4);
            final RecyclerView.LayoutManager layoutManager = this.tRM.dcU().getRecyclerView().getLayoutManager();
            ar arVar2 = this.tRM;
            FinderTagCacheVM.a aVar = this.tRM.tRF.wtV.get(4);
            if (aVar == null) {
                aVar = new FinderTagCacheVM.a();
            }
            arVar2.tRI = aVar.wuT;
            this.tRM.dcV();
            if (layoutManager instanceof StaggeredGridLayoutManager) {
                ((StaggeredGridLayoutManager) layoutManager).ah(i3, i4);
                this.tRM.dcU().getRecyclerView().post(new Runnable() {
                    /* class com.tencent.mm.plugin.finder.feed.ar.a.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(244294);
                        ((StaggeredGridLayoutManager) layoutManager).ah(i3, i4);
                        AppMethodBeat.o(244294);
                    }
                });
            }
            AppMethodBeat.o(244295);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\f\u0010\u0002\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\"\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J \u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0016\u0010\u0011\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013H\u0016J\u0016\u0010\u0014\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013H\u0016J\u0016\u0010\u0015\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013H\u0016¨\u0006\u0016"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$tagViewActionCallback$1", "Lcom/tencent/mm/view/IViewActionCallback;", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", MessengerShareContentUtility.ATTACHMENT_PAYLOAD, "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "plugin-finder_release"})
    public static final class j implements com.tencent.mm.view.j {
        final /* synthetic */ ar tRM;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        j(ar arVar) {
            this.tRM = arVar;
        }

        private WxRecyclerAdapter<?> getAdapter() {
            AppMethodBeat.i(244308);
            WxRecyclerAdapter<bo> dcT = this.tRM.dcU().dcT();
            AppMethodBeat.o(244308);
            return dcT;
        }

        @Override // com.tencent.mm.view.j
        public final void onChanged() {
            AppMethodBeat.i(244309);
            int size = this.tRM.tRo.getSize();
            this.tRM.tRo.getDataListJustForAdapter().clear();
            onItemRangeRemoved(0, size);
            this.tRM.tRo.getDataListJustForAdapter().addAll(this.tRM.tRE.getDataListJustForAdapter());
            onItemRangeInserted(0, this.tRM.tRE.getSize());
            AppMethodBeat.o(244309);
        }

        @Override // com.tencent.mm.view.j
        public final void onItemRangeChanged(int i2, int i3) {
            RefreshLoadMoreLayout dcQ;
            int i4;
            AppMethodBeat.i(244310);
            aq.b dcU = this.tRM.dcU();
            if (dcU == null || (dcQ = dcU.dcQ()) == null) {
                AppMethodBeat.o(244310);
                return;
            }
            WxRecyclerAdapter<?> adapter = getAdapter();
            if (adapter != null) {
                i4 = adapter.RqM.size();
            } else {
                i4 = 0;
            }
            dcQ.onItemRangeChanged(i4 + i2, i3);
            AppMethodBeat.o(244310);
        }

        @Override // com.tencent.mm.view.j
        public final void onItemRangeChanged(int i2, int i3, Object obj) {
            RefreshLoadMoreLayout dcQ;
            int i4;
            AppMethodBeat.i(244311);
            aq.b dcU = this.tRM.dcU();
            if (dcU == null || (dcQ = dcU.dcQ()) == null) {
                AppMethodBeat.o(244311);
                return;
            }
            WxRecyclerAdapter<?> adapter = getAdapter();
            if (adapter != null) {
                i4 = adapter.RqM.size();
            } else {
                i4 = 0;
            }
            dcQ.onItemRangeChanged(i4 + i2, i3, obj);
            AppMethodBeat.o(244311);
        }

        @Override // com.tencent.mm.view.j
        public final void onItemRangeInserted(int i2, int i3) {
            RefreshLoadMoreLayout dcQ;
            int i4;
            AppMethodBeat.i(244312);
            aq.b dcU = this.tRM.dcU();
            if (dcU == null || (dcQ = dcU.dcQ()) == null) {
                AppMethodBeat.o(244312);
                return;
            }
            WxRecyclerAdapter<?> adapter = getAdapter();
            if (adapter != null) {
                i4 = adapter.RqM.size();
            } else {
                i4 = 0;
            }
            dcQ.onItemRangeInserted(i4 + i2, i3);
            AppMethodBeat.o(244312);
        }

        @Override // com.tencent.mm.view.j
        public final void onItemRangeRemoved(int i2, int i3) {
            RefreshLoadMoreLayout dcQ;
            int i4;
            AppMethodBeat.i(244313);
            aq.b dcU = this.tRM.dcU();
            if (dcU == null || (dcQ = dcU.dcQ()) == null) {
                AppMethodBeat.o(244313);
                return;
            }
            WxRecyclerAdapter<?> adapter = getAdapter();
            if (adapter != null) {
                i4 = adapter.RqM.size();
            } else {
                i4 = 0;
            }
            dcQ.onItemRangeRemoved(i4 + i2, i3);
            AppMethodBeat.o(244313);
        }

        @Override // com.tencent.mm.view.i
        public final void onPreFinishRefresh(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(244314);
            p.h(cVar, "reason");
            this.tRM.dcU().dcQ().onPreFinishRefresh(cVar);
            AppMethodBeat.o(244314);
        }

        @Override // com.tencent.mm.view.i
        public final void onPreFinishLoadMore(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(244315);
            p.h(cVar, "reason");
            this.tRM.dcU().dcQ().onPreFinishLoadMore(cVar);
            AppMethodBeat.o(244315);
        }

        @Override // com.tencent.mm.view.i
        public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(244316);
            p.h(cVar, "reason");
            this.tRM.dcU().dcQ().onPreFinishLoadMoreSmooth(cVar);
            AppMethodBeat.o(244316);
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.aq.a
    public final void onRefresh() {
        String str;
        AppMethodBeat.i(244318);
        if (this.tRJ != null) {
            Log.d("Finder.TimelineMachinePresenter", "refresh category feed:" + this.tRJ);
            FinderFeedRelTimelineLoader finderFeedRelTimelineLoader = this.tRE;
            bds bds = this.tRJ;
            if (bds != null) {
                str = bds.dST;
            } else {
                str = null;
            }
            finderFeedRelTimelineLoader.category = str;
            this.tRE.ttb = 1;
            this.tRE.requestRefresh();
            AppMethodBeat.o(244318);
            return;
        }
        Log.d("Finder.TimelineMachinePresenter", "refresh tl feed:");
        this.tRo.requestRefresh();
        AppMethodBeat.o(244318);
    }

    @Override // com.tencent.mm.plugin.finder.feed.aq.a
    public final void onLoadMore() {
        String str;
        AppMethodBeat.i(244320);
        if (this.tRJ != null) {
            Log.d("Finder.TimelineMachinePresenter", "loadMore category feed:" + this.tRJ);
            FinderFeedRelTimelineLoader finderFeedRelTimelineLoader = this.tRE;
            bds bds = this.tRJ;
            if (bds != null) {
                str = bds.dST;
            } else {
                str = null;
            }
            finderFeedRelTimelineLoader.category = str;
            this.tRE.ttb = 1;
            this.tRE.requestLoadMore();
            AppMethodBeat.o(244320);
            return;
        }
        Log.d("Finder.TimelineMachinePresenter", "loadMore tl feed:");
        this.tRo.requestLoadMore();
        AppMethodBeat.o(244320);
    }

    @Override // com.tencent.mm.plugin.finder.feed.aq.a
    public final List<g.b> getHeaderInfo() {
        AppMethodBeat.i(244321);
        LinkedList linkedList = new LinkedList();
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
        com.tencent.mm.kernel.e aAh5 = com.tencent.mm.kernel.g.aAh();
        p.g(aAh5, "MMKernel.storage()");
        this.msgNotifyData.count = i2 + i3 + i4 + i5 + aAh5.azQ().getInt(ar.a.USERINFO_FINDER_WX_MENTION_FOLLOW_ACCEPT_INT_SYNC, 0);
        com.tencent.mm.plugin.finder.model.h hVar = this.msgNotifyData;
        com.tencent.mm.kernel.e aAh6 = com.tencent.mm.kernel.g.aAh();
        p.g(aAh6, "MMKernel.storage()");
        Object obj = aAh6.azQ().get(ar.a.USERINFO_FINDER_WX_MENTION_AVATAR_STRING_SYNC, "");
        if (obj == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(244321);
            throw tVar;
        }
        hVar.setAvatar((String) obj);
        linkedList.add(this.msgNotifyData);
        linkedList.add(this.tRH);
        linkedList.add(this.tRK);
        LinkedList linkedList2 = linkedList;
        AppMethodBeat.o(244321);
        return linkedList2;
    }

    public final void a(aq.b bVar) {
        AppMethodBeat.i(244322);
        p.h(bVar, "callback");
        this.tRG = bVar;
        aq.b bVar2 = this.tRG;
        if (bVar2 == null) {
            p.btv("viewCallback");
        }
        bVar2.ab(this.tRo.getDataListJustForAdapter());
        this.tRo.register(bVar.dcQ());
        this.tRE.register(this.tagViewActionCallback);
        this.tlCache.Mq(4).wuc.size();
        BaseFeedLoader.requestInit$default(this.tRo, false, 1, null);
        this.tRo.tXr = new d(this);
        aq.b bVar3 = this.tRG;
        if (bVar3 == null) {
            p.btv("viewCallback");
        }
        bVar3.getRecyclerView().a(new e(this));
        this.tOh = new f(this);
        EventCenter.instance.add(this.tOh);
        AppMethodBeat.o(244322);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$2", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
    public static final class e extends RecyclerView.l {
        final /* synthetic */ ar tRM;

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(244299);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            super.onScrollStateChanged(recyclerView, i2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(244299);
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        e(ar arVar) {
            this.tRM = arVar;
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(244298);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            p.h(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            this.tRM.totalDy -= i3;
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$2", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(244298);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$3", "Lcom/tencent/mm/sdk/event/IListener;", "Lcom/tencent/mm/autogen/events/FinderTagClickEvent;", "callback", "", "event", "plugin-finder_release"})
    public static final class f extends IListener<ig> {
        final /* synthetic */ ar tRM;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(ar arVar) {
            this.tRM = arVar;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(ig igVar) {
            AppMethodBeat.i(244303);
            ig igVar2 = igVar;
            if (igVar2 != null) {
                com.tencent.mm.ac.d.h(new a(this, igVar2));
            }
            AppMethodBeat.o(244303);
            return true;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/feed/FinderTimelineMachinePresenter$onAttach$3$callback$1$1"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ f tRN;
            final /* synthetic */ ig tRO;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(f fVar, ig igVar) {
                super(0);
                this.tRN = fVar;
                this.tRO = igVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(244302);
                Log.d("Finder.TimelineMachinePresenter", "tag click:" + this.tRO.dMR.dMS + ",index:" + this.tRO.dMR.index);
                if (this.tRO.dMR.dMS != null) {
                    if (this.tRN.tRM.tRJ == null) {
                        FinderHomeTabStateVM finderHomeTabStateVM = this.tRN.tRM.tlCache;
                        int i2 = this.tRN.tRM.totalDy;
                        Object clone = this.tRN.tRM.tRo.getDataListJustForAdapter().clone();
                        if (clone == null) {
                            t tVar = new t("null cannot be cast to non-null type java.util.ArrayList<com.tencent.mm.plugin.finder.model.RVFeed>");
                            AppMethodBeat.o(244302);
                            throw tVar;
                        }
                        FinderHomeTabStateVM.a(finderHomeTabStateVM, 4, 0, i2, (ArrayList) clone);
                    }
                    this.tRN.tRM.tRJ = this.tRO.dMR.dMS;
                    this.tRN.tRM.F(new kotlin.g.a.a<x>(this) {
                        /* class com.tencent.mm.plugin.finder.feed.ar.f.a.AnonymousClass1 */
                        final /* synthetic */ a tRP;

                        {
                            this.tRP = r2;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* synthetic */ x invoke() {
                            AppMethodBeat.i(244300);
                            ar.a(this.tRP.tRN.tRM, false);
                            x xVar = x.SXb;
                            AppMethodBeat.o(244300);
                            return xVar;
                        }
                    });
                } else {
                    this.tRN.tRM.tRJ = this.tRO.dMR.dMS;
                    this.tRN.tRM.F(new kotlin.g.a.a<x>(this) {
                        /* class com.tencent.mm.plugin.finder.feed.ar.f.a.AnonymousClass2 */
                        final /* synthetic */ a tRP;

                        {
                            this.tRP = r2;
                        }

                        /* Return type fixed from 'java.lang.Object' to match base method */
                        @Override // kotlin.g.a.a
                        public final /* synthetic */ x invoke() {
                            AppMethodBeat.i(244301);
                            int size = this.tRP.tRN.tRM.tRo.getSize();
                            int size2 = this.tRP.tRN.tRM.dcU().dcT().RqM.size();
                            this.tRP.tRN.tRM.tRo.getDataListJustForAdapter().clear();
                            aq.b dcU = this.tRP.tRN.tRM.dcU();
                            (dcU != null ? dcU.dcQ() : null).onItemRangeRemoved(size2, size);
                            this.tRP.tRN.tRM.tRo.getDataListJustForAdapter().addAll(this.tRP.tRN.tRM.tlCache.Mq(4).wuc);
                            this.tRP.tRN.tRM.dcU().dcQ().onItemRangeInserted(size2, this.tRP.tRN.tRM.tRE.getSize());
                            x xVar = x.SXb;
                            AppMethodBeat.o(244301);
                            return xVar;
                        }
                    });
                }
                x xVar = x.SXb;
                AppMethodBeat.o(244302);
                return xVar;
            }
        }
    }

    public final void F(kotlin.g.a.a<x> aVar) {
        AppMethodBeat.i(244324);
        aq.b bVar = this.tRG;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        RecyclerView.LayoutManager layoutManager = bVar.getRecyclerView().getLayoutManager();
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            ((StaggeredGridLayoutManager) layoutManager).ah(0, 0);
            aq.b bVar2 = this.tRG;
            if (bVar2 == null) {
                p.btv("viewCallback");
            }
            bVar2.getRecyclerView().post(new i(layoutManager, aVar));
        }
        AppMethodBeat.o(244324);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class i implements Runnable {
        final /* synthetic */ RecyclerView.LayoutManager $layoutManager;
        final /* synthetic */ kotlin.g.a.a tRS;

        i(RecyclerView.LayoutManager layoutManager, kotlin.g.a.a aVar) {
            this.$layoutManager = layoutManager;
            this.tRS = aVar;
        }

        public final void run() {
            AppMethodBeat.i(244307);
            ((StaggeredGridLayoutManager) this.$layoutManager).ah(0, 0);
            kotlin.g.a.a aVar = this.tRS;
            if (aVar != null) {
                aVar.invoke();
                AppMethodBeat.o(244307);
                return;
            }
            AppMethodBeat.o(244307);
        }
    }

    public final void dcV() {
        AppMethodBeat.i(244325);
        if (this.tRI != null) {
            dmk dmk = new dmk();
            dmk.MPW = new LinkedList<>();
            apa apa = this.tRI;
            if (apa == null) {
                p.hyc();
            }
            LinkedList<aoz> linkedList = apa.LBa;
            p.g(linkedList, "tagsData!!.categoryInfo");
            Iterator<T> it = linkedList.iterator();
            while (it.hasNext()) {
                bds bds = new bds();
                bds.dST = it.next().xjU;
                dmk.MPW.add(bds);
            }
            this.tRK.a(dmk);
            aq.b bVar = this.tRG;
            if (bVar == null) {
                p.btv("viewCallback");
            }
            bVar.dcT().T((long) this.tRK.hashCode(), true);
            aq.b bVar2 = this.tRG;
            if (bVar2 == null) {
                p.btv("viewCallback");
            }
            View rootView = bVar2.getRootView();
            FinderTagView.a aVar = FinderTagView.wpv;
            View findViewById = rootView.findViewById(FinderTagView.wpt);
            if (findViewById != null) {
                aq.b bVar3 = this.tRG;
                if (bVar3 == null) {
                    p.btv("viewCallback");
                }
                View rootView2 = bVar3.getRootView();
                if (rootView2 == null) {
                    t tVar = new t("null cannot be cast to non-null type android.view.ViewGroup");
                    AppMethodBeat.o(244325);
                    throw tVar;
                }
                ((ViewGroup) rootView2).removeView(findViewById);
            }
            aq.b bVar4 = this.tRG;
            if (bVar4 == null) {
                p.btv("viewCallback");
            }
            bVar4.dcT().a((com.tencent.mm.view.recyclerview.g) this.tRK, (g.b) true);
        }
        AppMethodBeat.o(244325);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class c implements Runnable {
        final /* synthetic */ boolean $isSilence;
        final /* synthetic */ RefreshLoadMoreLayout $rlLayout;

        c(RefreshLoadMoreLayout refreshLoadMoreLayout, boolean z) {
            this.$rlLayout = refreshLoadMoreLayout;
            this.$isSilence = z;
        }

        public final void run() {
            AppMethodBeat.i(244296);
            this.$rlLayout.DD(this.$isSilence);
            AppMethodBeat.o(244296);
        }
    }

    @Override // com.tencent.mm.plugin.finder.presenter.base.a
    public final void onDetach() {
        AppMethodBeat.i(244326);
        FinderTimelineFeedLoader finderTimelineFeedLoader = this.tRo;
        aq.b bVar = this.tRG;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        finderTimelineFeedLoader.unregister(bVar.dcQ());
        EventCenter.instance.removeListener(this.tOh);
        AppMethodBeat.o(244326);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class h extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ ar tRM;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(ar arVar) {
            super(0);
            this.tRM = arVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(244306);
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
            com.tencent.mm.kernel.e aAh5 = com.tencent.mm.kernel.g.aAh();
            p.g(aAh5, "MMKernel.storage()");
            int i6 = aAh5.azQ().getInt(ar.a.USERINFO_FINDER_WX_MENTION_FOLLOW_ACCEPT_INT_SYNC, 0);
            Log.i("Finder.TimelineMachinePresenter", "refreshMsgNotify commentCnt " + i2 + ", likeCnt " + i3 + " objectLikeLikeCnt " + i4 + " objectRecommendLikeCnt " + i5);
            this.tRM.msgNotifyData.count = i2 + i3 + i4 + i5 + i6;
            com.tencent.mm.plugin.finder.model.h hVar = this.tRM.msgNotifyData;
            com.tencent.mm.kernel.e aAh6 = com.tencent.mm.kernel.g.aAh();
            p.g(aAh6, "MMKernel.storage()");
            Object obj = aAh6.azQ().get(ar.a.USERINFO_FINDER_WX_MENTION_AVATAR_STRING_SYNC, "");
            if (obj == null) {
                t tVar = new t("null cannot be cast to non-null type kotlin.String");
                AppMethodBeat.o(244306);
                throw tVar;
            }
            hVar.setAvatar((String) obj);
            com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                /* class com.tencent.mm.plugin.finder.feed.ar.h.AnonymousClass1 */
                final /* synthetic */ h tRR;

                {
                    this.tRR = r2;
                }

                /* Return type fixed from 'java.lang.Object' to match base method */
                @Override // kotlin.g.a.a
                public final /* synthetic */ x invoke() {
                    AppMethodBeat.i(244305);
                    RecyclerView recyclerView = this.tRR.tRM.dcU().getRecyclerView();
                    com.tencent.mm.plugin.finder.model.h unused = this.tRR.tRM.msgNotifyData;
                    ar.p(recyclerView);
                    x xVar = x.SXb;
                    AppMethodBeat.o(244305);
                    return xVar;
                }
            });
            x xVar = x.SXb;
            AppMethodBeat.o(244306);
            return xVar;
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.aq.a
    public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> cVar) {
        AppMethodBeat.i(244319);
        p.h(cVar, "reason");
        if (cVar.Rmk <= 0) {
            aq.b bVar = this.tRG;
            if (bVar == null) {
                p.btv("viewCallback");
            }
            RefreshLoadMoreLayout dcQ = bVar.dcQ();
            com.tencent.mm.plugin.finder.storage.c cVar2 = com.tencent.mm.plugin.finder.storage.c.vCb;
            dcQ.b(com.tencent.mm.plugin.finder.storage.c.dsb(), g.tRQ);
        }
        AppMethodBeat.o(244319);
    }

    public static final /* synthetic */ void p(RecyclerView recyclerView) {
        AppMethodBeat.i(244329);
        RecyclerView.a adapter = recyclerView.getAdapter();
        if (adapter == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.RecyclerViewAdapterEx<android.support.v7.widget.RecyclerView.ViewHolder!>");
            AppMethodBeat.o(244329);
            throw tVar;
        }
        RecyclerView.v vVar = ((com.tencent.mm.view.recyclerview.g) adapter).V(512, false);
        Integer valueOf = vVar != null ? Integer.valueOf(vVar.lR()) : null;
        if (valueOf != null) {
            valueOf.intValue();
            RecyclerView.a adapter2 = recyclerView.getAdapter();
            if (adapter2 != null) {
                adapter2.ci(valueOf.intValue());
                AppMethodBeat.o(244329);
                return;
            }
            AppMethodBeat.o(244329);
            return;
        }
        AppMethodBeat.o(244329);
    }

    public static final /* synthetic */ void a(ar arVar, boolean z) {
        AppMethodBeat.i(244330);
        aq.b bVar = arVar.tRG;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        RefreshLoadMoreLayout dcQ = bVar.dcQ();
        dcQ.postDelayed(new c(dcQ, z), 0);
        AppMethodBeat.o(244330);
    }
}
