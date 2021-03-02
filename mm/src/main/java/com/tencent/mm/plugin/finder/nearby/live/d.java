package com.tencent.mm.plugin.finder.nearby.live;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.feed.model.internal.IResponse;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.nearby.base.d;
import com.tencent.mm.plugin.finder.nearby.live.b;
import com.tencent.mm.plugin.finder.nearby.live.square.NearbyLiveSquareUIC;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.protocal.protobuf.auh;
import com.tencent.mm.protocal.protobuf.axj;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0016\u0018\u0000 N2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001NB\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u00020\u0013H\u0016J\u001a\u00102\u001a\u00020.2\u0010\b\u0002\u00103\u001a\n\u0012\u0004\u0012\u000205\u0018\u000104H\u0002J\b\u00106\u001a\u00020\rH\u0002J\u0010\u00107\u001a\u00020$2\u0006\u00108\u001a\u000209H\u0002J\b\u0010:\u001a\u00020$H\u0016J\b\u0010;\u001a\u00020$H\u0016J\n\u0010<\u001a\u0004\u0018\u00010=H\u0016J\b\u0010>\u001a\u00020$H\u0014J\b\u0010?\u001a\u00020$H\u0016J\b\u0010@\u001a\u00020\u0006H\u0016J\b\u0010A\u001a\u00020$H\u0014J\u0010\u0010B\u001a\u00020.2\u0006\u0010C\u001a\u00020\u0013H\u0016J\u0016\u0010D\u001a\u00020.2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00020(H\u0016J\b\u0010F\u001a\u00020.H\u0016J\b\u0010G\u001a\u00020.H\u0016J\b\u0010H\u001a\u00020.H\u0016J\b\u0010I\u001a\u00020.H\u0016J\u0016\u0010J\u001a\u00020.2\f\u0010K\u001a\b\u0012\u0004\u0012\u00020504H\u0016J\b\u0010L\u001a\u00020.H\u0016J\b\u0010M\u001a\u00020.H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u001a\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\"X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u000e¢\u0006\u0002\n\u0000R \u0010'\u001a\b\u0012\u0004\u0012\u00020\u00020(X.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,¨\u0006O"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter;", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$Presenter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;)V", "getContextObj", "()Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "emptyData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderEmptyData;", "feedLoader", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader;", "setFeedLoader", "(Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveFeedLoader;)V", "firstAttach", "", "fragment", "Landroid/support/v4/app/Fragment;", "getFragment", "()Landroid/support/v4/app/Fragment;", "setFragment", "(Landroid/support/v4/app/Fragment;)V", "isRequestingLbs", "tabInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "getTabInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;", "setTabInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderLiveTabInfo;)V", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "totalDy", "", "viewActionCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "viewCallback", "Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLiveContract$ViewCallback;)V", "autoFlingToRefresh", "", "delayStart", "", "isSilence", "checkEmptyHeader", "r", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "createFeedLoader", "findFirstPosition", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getCommentScene", "getFileCacheFlag", "getHeaderInfo", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "getLocalTypeFlag", "getMemoryCacheFlag", "getReportContextObj", "getTabType", "onActionbarClick", "isDouble", "onAttach", "callback", "onDetach", "onFinishing", "onLoadMore", "onRefresh", "onRefreshEnd", "reason", "onUserVisibleFocused", "onUserVisibleUnFocused", "Companion", "plugin-finder_release"})
public class d implements b.a<bo> {
    public static final a uQW = new a((byte) 0);
    private final MMActivity activity;
    private com.tencent.mm.plugin.finder.model.g emptyData = new com.tencent.mm.plugin.finder.model.g();
    private boolean firstAttach;
    protected Fragment fragment;
    private boolean isRequestingLbs;
    private final FinderHomeTabStateVM tlCache;
    private int totalDy;
    protected final bbn ttO;
    protected axj uQK;
    public b.AbstractC1238b<bo> uQT;
    NearbyLiveFeedLoader uQU;
    private com.tencent.mm.view.j uQV = new k(this);

    static {
        AppMethodBeat.i(249097);
        AppMethodBeat.o(249097);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/finder/feed/model/internal/IResponse;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "invoke"})
    public static final class e extends q implements kotlin.g.a.b<IResponse<bo>, x> {
        final /* synthetic */ NearbyLiveFeedLoader uRb;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(NearbyLiveFeedLoader nearbyLiveFeedLoader) {
            super(1);
            this.uRb = nearbyLiveFeedLoader;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(IResponse<bo> iResponse) {
            int i2 = 1;
            AppMethodBeat.i(249062);
            IResponse<bo> iResponse2 = iResponse;
            p.h(iResponse2, LocaleUtil.ITALIAN);
            if (iResponse2.getPullType() == 0 || iResponse2.getPullType() == 1) {
                i.a aVar = com.tencent.mm.plugin.finder.extension.reddot.i.tLi;
                bbn contextObj = this.uRb.getContextObj();
                if (iResponse2.getPullType() != 0) {
                    i2 = 0;
                }
                i.a.a(2, contextObj, i2);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(249062);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class j extends q implements kotlin.g.a.a<x> {
        public static final j uRh = new j();

        static {
            AppMethodBeat.i(249072);
            AppMethodBeat.o(249072);
        }

        j() {
            super(0);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* bridge */ /* synthetic */ x invoke() {
            return x.SXb;
        }
    }

    public d(MMActivity mMActivity, bbn bbn) {
        p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        p.h(bbn, "contextObj");
        AppMethodBeat.i(249096);
        this.activity = mMActivity;
        this.ttO = bbn;
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ViewModel viewModel = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
        p.g(viewModel, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
        this.tlCache = (FinderHomeTabStateVM) viewModel;
        AppMethodBeat.o(249096);
    }

    public static final /* synthetic */ void d(d dVar) {
        AppMethodBeat.i(249098);
        dVar.checkEmptyHeader(null);
        AppMethodBeat.o(249098);
    }

    @Override // com.tencent.mm.plugin.finder.presenter.base.a
    public /* synthetic */ void onAttach(Object obj) {
        AppMethodBeat.i(249092);
        a((b.AbstractC1238b) obj);
        AppMethodBeat.o(249092);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public final b.AbstractC1238b<bo> dlp() {
        AppMethodBeat.i(249082);
        b.AbstractC1238b<bo> bVar = this.uQT;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        AppMethodBeat.o(249082);
        return bVar;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\f\u0010\u0002\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\"\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J \u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016J\u0016\u0010\u0011\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013H\u0016J\u0016\u0010\u0014\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013H\u0016J\u0016\u0010\u0015\u001a\u00020\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013H\u0016¨\u0006\u0016"}, hxF = {"com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter$viewActionCallback$1", "Lcom/tencent/mm/view/IViewActionCallback;", "getAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "onChanged", "", "onItemRangeChanged", "positionStart", "", "itemCount", MessengerShareContentUtility.ATTACHMENT_PAYLOAD, "", "onItemRangeInserted", "onItemRangeMoved", "fromPosition", "toPosition", "onItemRangeRemoved", "onPreFinishLoadMore", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "onPreFinishLoadMoreSmooth", "onPreFinishRefresh", "plugin-finder_release"})
    public static final class k implements com.tencent.mm.view.j {
        final /* synthetic */ d uQX;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        k(d dVar) {
            this.uQX = dVar;
        }

        private WxRecyclerAdapter<?> getAdapter() {
            AppMethodBeat.i(249073);
            RecyclerView recyclerView = this.uQX.dlp().getRecyclerView();
            RecyclerView.a adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (!(adapter instanceof WxRecyclerAdapter)) {
                adapter = null;
            }
            WxRecyclerAdapter<?> wxRecyclerAdapter = (WxRecyclerAdapter) adapter;
            AppMethodBeat.o(249073);
            return wxRecyclerAdapter;
        }

        @Override // com.tencent.mm.view.j
        public final void onChanged() {
            RefreshLoadMoreLayout dcQ;
            AppMethodBeat.i(249074);
            b.AbstractC1238b<bo> dlp = this.uQX.dlp();
            if (dlp == null || (dcQ = dlp.dcQ()) == null) {
                AppMethodBeat.o(249074);
                return;
            }
            dcQ.onChanged();
            AppMethodBeat.o(249074);
        }

        @Override // com.tencent.mm.view.j
        public final void onItemRangeChanged(int i2, int i3) {
            RefreshLoadMoreLayout dcQ;
            int i4;
            AppMethodBeat.i(249075);
            b.AbstractC1238b<bo> dlp = this.uQX.dlp();
            if (dlp == null || (dcQ = dlp.dcQ()) == null) {
                AppMethodBeat.o(249075);
                return;
            }
            WxRecyclerAdapter<?> adapter = getAdapter();
            if (adapter != null) {
                i4 = adapter.RqM.size();
            } else {
                i4 = 0;
            }
            dcQ.onItemRangeChanged(i4 + i2, i3);
            AppMethodBeat.o(249075);
        }

        @Override // com.tencent.mm.view.j
        public final void onItemRangeChanged(int i2, int i3, Object obj) {
            RefreshLoadMoreLayout dcQ;
            int i4;
            AppMethodBeat.i(249076);
            b.AbstractC1238b<bo> dlp = this.uQX.dlp();
            if (dlp == null || (dcQ = dlp.dcQ()) == null) {
                AppMethodBeat.o(249076);
                return;
            }
            WxRecyclerAdapter<?> adapter = getAdapter();
            if (adapter != null) {
                i4 = adapter.RqM.size();
            } else {
                i4 = 0;
            }
            dcQ.onItemRangeChanged(i4 + i2, i3, obj);
            AppMethodBeat.o(249076);
        }

        @Override // com.tencent.mm.view.j
        public final void onItemRangeInserted(int i2, int i3) {
            RefreshLoadMoreLayout dcQ;
            int i4;
            AppMethodBeat.i(249077);
            b.AbstractC1238b<bo> dlp = this.uQX.dlp();
            if (!(dlp == null || (dcQ = dlp.dcQ()) == null)) {
                WxRecyclerAdapter<?> adapter = getAdapter();
                if (adapter != null) {
                    i4 = adapter.RqM.size();
                } else {
                    i4 = 0;
                }
                dcQ.onItemRangeInserted(i4 + i2, i3);
            }
            d.a aVar = com.tencent.mm.plugin.finder.nearby.base.d.uQu;
            d.a.JA(this.uQX.dlr()).uQr = System.currentTimeMillis();
            AppMethodBeat.o(249077);
        }

        @Override // com.tencent.mm.view.j
        public final void onItemRangeRemoved(int i2, int i3) {
            RefreshLoadMoreLayout dcQ;
            int i4;
            AppMethodBeat.i(249078);
            b.AbstractC1238b<bo> dlp = this.uQX.dlp();
            if (dlp == null || (dcQ = dlp.dcQ()) == null) {
                AppMethodBeat.o(249078);
                return;
            }
            WxRecyclerAdapter<?> adapter = getAdapter();
            if (adapter != null) {
                i4 = adapter.RqM.size();
            } else {
                i4 = 0;
            }
            dcQ.onItemRangeRemoved(i4 + i2, i3);
            AppMethodBeat.o(249078);
        }

        @Override // com.tencent.mm.view.i
        public final void onPreFinishRefresh(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(249079);
            p.h(cVar, "reason");
            this.uQX.dlp().dcQ().onPreFinishRefresh(cVar);
            AppMethodBeat.o(249079);
        }

        @Override // com.tencent.mm.view.i
        public final void onPreFinishLoadMore(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(249080);
            p.h(cVar, "reason");
            this.uQX.dlp().dcQ().onPreFinishLoadMore(cVar);
            AppMethodBeat.o(249080);
        }

        @Override // com.tencent.mm.view.i
        public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(249081);
            p.h(cVar, "reason");
            this.uQX.dlp().dcQ().onPreFinishLoadMoreSmooth(cVar);
            AppMethodBeat.o(249081);
        }
    }

    @Override // com.tencent.mm.plugin.finder.nearby.live.b.a
    public int getCommentScene() {
        return 76;
    }

    /* access modifiers changed from: protected */
    public int getTabType() {
        return 1001;
    }

    /* access modifiers changed from: protected */
    public int dlq() {
        return 15;
    }

    @Override // com.tencent.mm.plugin.finder.nearby.live.b.a
    public final void onRefresh() {
        AppMethodBeat.i(249083);
        com.tencent.mm.plugin.finder.utils.l lVar = com.tencent.mm.plugin.finder.utils.l.vVE;
        com.tencent.mm.plugin.finder.utils.l.a(new g(this), new h(this), new i(this));
        AppMethodBeat.o(249083);
    }

    @Override // com.tencent.mm.plugin.finder.nearby.live.b.a
    public void onRefreshEnd(RefreshLoadMoreLayout.c<Object> cVar) {
        View loadMoreFooter;
        View findViewById;
        View loadMoreFooter2;
        TextView textView;
        AppMethodBeat.i(249084);
        p.h(cVar, "reason");
        d.a aVar = com.tencent.mm.plugin.finder.nearby.base.d.uQu;
        com.tencent.mm.plugin.finder.nearby.base.d JA = d.a.JA(dlr());
        JA.uQs = System.currentTimeMillis();
        Log.i("NearbyTimeConsumingHelper-" + JA.dLS, "onVisible->onRefreshEnd:" + (JA.uQs - JA.uQm) + " \nonAttach->startFetch:" + (JA.uQn - JA.uQm) + " \nstartFetch->startCgi:" + (JA.uQo - JA.uQn) + " \nstartCgi->onCgiBack:" + (JA.uQp - JA.uQo) + " \nonCgiBack->onFetchDone:" + (JA.uQq - JA.uQp) + " \nonFetchDone->onViewUpdate:" + (JA.uQr - JA.uQq) + " \nonViewUpdate->onRefreshEnd:" + (JA.uQs - JA.uQr));
        JA.uQm = 0;
        JA.uQn = 0;
        JA.uQo = 0;
        JA.uQp = 0;
        JA.uQq = 0;
        JA.uQr = 0;
        JA.uQs = 0;
        if (cVar.Rmk <= 0) {
            b.AbstractC1238b<bo> bVar = this.uQT;
            if (bVar == null) {
                p.btv("viewCallback");
            }
            bVar.dcQ().b(0, j.uRh);
        }
        if (cVar.Rmj) {
            b.AbstractC1238b<bo> bVar2 = this.uQT;
            if (bVar2 == null) {
                p.btv("viewCallback");
            }
            RefreshLoadMoreLayout dcQ = bVar2.dcQ();
            if (!(dcQ != null ? Boolean.valueOf(dcQ.RlV) : null).booleanValue()) {
                b.AbstractC1238b<bo> bVar3 = this.uQT;
                if (bVar3 == null) {
                    p.btv("viewCallback");
                }
                RefreshLoadMoreLayout dcQ2 = bVar3.dcQ();
                if (dcQ2 != null) {
                    dcQ2.setHasBottomMore(true);
                }
                b.AbstractC1238b<bo> bVar4 = this.uQT;
                if (bVar4 == null) {
                    p.btv("viewCallback");
                }
                RefreshLoadMoreLayout dcQ3 = bVar4.dcQ();
                if (!(dcQ3 == null || (loadMoreFooter2 = dcQ3.getLoadMoreFooter()) == null || (textView = (TextView) loadMoreFooter2.findViewById(R.id.ep1)) == null)) {
                    textView.setVisibility(0);
                }
                b.AbstractC1238b<bo> bVar5 = this.uQT;
                if (bVar5 == null) {
                    p.btv("viewCallback");
                }
                RefreshLoadMoreLayout dcQ4 = bVar5.dcQ();
                if (!(dcQ4 == null || (loadMoreFooter = dcQ4.getLoadMoreFooter()) == null || (findViewById = loadMoreFooter.findViewById(R.id.ep0)) == null)) {
                    findViewById.setVisibility(8);
                }
            }
            b.AbstractC1238b<bo> bVar6 = this.uQT;
            if (bVar6 == null) {
                p.btv("viewCallback");
            }
            RefreshLoadMoreLayout dcQ5 = bVar6.dcQ();
            if (!(dcQ5 != null ? Boolean.valueOf(dcQ5.getEnableLoadMore()) : null).booleanValue()) {
                b.AbstractC1238b<bo> bVar7 = this.uQT;
                if (bVar7 == null) {
                    p.btv("viewCallback");
                }
                RefreshLoadMoreLayout dcQ6 = bVar7.dcQ();
                if (dcQ6 != null) {
                    dcQ6.setEnableLoadMore(true);
                }
                b.AbstractC1238b<bo> bVar8 = this.uQT;
                if (bVar8 == null) {
                    p.btv("viewCallback");
                }
                RefreshLoadMoreLayout dcQ7 = bVar8.dcQ();
                if (dcQ7 != null) {
                    View inflate = aa.jQ(this.activity).inflate(R.layout.b21, (ViewGroup) null);
                    p.g(inflate, "MMLayoutInflater.getInfl…t.load_more_footer, null)");
                    dcQ7.setLoadMoreFooter(inflate);
                }
            }
        }
        checkEmptyHeader(cVar);
        com.tencent.mm.kernel.b.a ah = com.tencent.mm.kernel.g.ah(PluginFinder.class);
        p.g(ah, "MMKernel.plugin(PluginFinder::class.java)");
        ((PluginFinder) ah).getRedDotManager().asV("NearbyLiveTab");
        com.tencent.mm.kernel.b.a ah2 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
        p.g(ah2, "MMKernel.plugin(PluginFinder::class.java)");
        ((PluginFinder) ah2).getRedDotManager().gI("NearbyLiveTab", "onRefreshEnd");
        AppMethodBeat.o(249084);
    }

    @Override // com.tencent.mm.plugin.finder.nearby.live.b.a
    public final void onLoadMore() {
        AppMethodBeat.i(249085);
        NearbyLiveFeedLoader nearbyLiveFeedLoader = this.uQU;
        if (nearbyLiveFeedLoader != null) {
            nearbyLiveFeedLoader.b(this.uQK);
            AppMethodBeat.o(249085);
            return;
        }
        AppMethodBeat.o(249085);
    }

    public final void onFinishing() {
        AppMethodBeat.i(249086);
        b.AbstractC1238b<bo> bVar = this.uQT;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        int scrollY = bVar.dlo().getScrollY();
        b.AbstractC1238b<bo> bVar2 = this.uQT;
        if (bVar2 == null) {
            p.btv("viewCallback");
        }
        RecyclerView recyclerView = bVar2.getRecyclerView();
        if (recyclerView == null) {
            AppMethodBeat.o(249086);
            return;
        }
        int findFirstPosition = findFirstPosition(recyclerView);
        NearbyLiveFeedLoader nearbyLiveFeedLoader = this.uQU;
        if (nearbyLiveFeedLoader == null) {
            p.hyc();
        }
        int size = nearbyLiveFeedLoader.getDataListJustForAdapter().size();
        int dlr = dlr();
        Log.i("Finder.NearbyLivePresenter", "[onFinishing] memoryCacheFlag:" + dlr + " position=" + findFirstPosition + " totalDy=" + this.totalDy + " size:" + size);
        if (size > 0) {
            FinderHomeTabStateVM finderHomeTabStateVM = this.tlCache;
            int i2 = this.totalDy;
            NearbyLiveFeedLoader nearbyLiveFeedLoader2 = this.uQU;
            if (nearbyLiveFeedLoader2 == null) {
                p.hyc();
            }
            FinderHomeTabStateVM.a(finderHomeTabStateVM, dlr, scrollY, findFirstPosition, i2, nearbyLiveFeedLoader2.getDataListJustForAdapter());
        }
        AppMethodBeat.o(249086);
    }

    public final void onActionbarClick(boolean z) {
        AppMethodBeat.i(249087);
        b.AbstractC1238b<bo> bVar = this.uQT;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        RecyclerView recyclerView = bVar.getRecyclerView();
        if (recyclerView == null) {
            AppMethodBeat.o(249087);
            return;
        }
        int findFirstPosition = findFirstPosition(recyclerView);
        Log.i("Finder.TimelineLbsPresenter", "[onActionbarClick] position=" + findFirstPosition + " isDouble=" + z);
        if (z) {
            if (findFirstPosition <= 12) {
                com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter", "onActionbarClick", "(Z)V", "Undefined", "smoothScrollToPosition", "(I)V");
                recyclerView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter", "onActionbarClick", "(Z)V", "Undefined", "smoothScrollToPosition", "(I)V");
            } else {
                com.tencent.mm.hellhoundlib.b.a a3 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a3.axQ(), "com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter", "onActionbarClick", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
                recyclerView.scrollToPosition(((Integer) a3.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter", "onActionbarClick", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
            }
            if (findFirstPosition <= 12) {
                ED(20);
                AppMethodBeat.o(249087);
                return;
            }
            ED(600);
        }
        AppMethodBeat.o(249087);
    }

    public final int dlr() {
        int tabType;
        AppMethodBeat.i(249088);
        axj axj = this.uQK;
        if (axj != null) {
            com.tencent.mm.plugin.finder.nearby.live.square.tab.a aVar = com.tencent.mm.plugin.finder.nearby.live.square.tab.a.uRQ;
            String str = axj.LHR;
            if (str == null) {
                p.hyc();
            }
            p.g(str, "tabInfo.tab_name!!");
            tabType = com.tencent.mm.plugin.finder.nearby.live.square.tab.a.aul(str);
        } else {
            tabType = getTabType();
        }
        if (tabType == -1) {
            int tabType2 = getTabType();
            AppMethodBeat.o(249088);
            return tabType2;
        }
        AppMethodBeat.o(249088);
        return tabType;
    }

    public final void onUserVisibleFocused() {
        int dlq;
        AppMethodBeat.i(249089);
        d.a aVar = com.tencent.mm.plugin.finder.nearby.base.d.uQu;
        d.a.JA(dlr()).uQm = System.currentTimeMillis();
        if (this.firstAttach) {
            com.tencent.mm.plugin.finder.utils.l lVar = com.tencent.mm.plugin.finder.utils.l.vVE;
            if (com.tencent.mm.plugin.finder.utils.l.dBJ()) {
                NearbyLiveFeedLoader nearbyLiveFeedLoader = this.uQU;
                if (nearbyLiveFeedLoader == null) {
                    p.hyc();
                }
                int dlr = dlr();
                do {
                    axj axj = this.uQK;
                    if (axj != null) {
                        com.tencent.mm.plugin.finder.nearby.live.square.tab.a aVar2 = com.tencent.mm.plugin.finder.nearby.live.square.tab.a.uRQ;
                        String str = axj.LHR;
                        if (str == null) {
                            p.hyc();
                        }
                        p.g(str, "tabInfo.tab_name!!");
                        dlq = com.tencent.mm.plugin.finder.nearby.live.square.tab.a.aul(str);
                    } else {
                        dlq = dlq();
                    }
                } while (dlq == -1);
                nearbyLiveFeedLoader.a(dlr, dlq, this.uQK);
            } else {
                RefreshLoadMoreLayout.c<Object> cVar = new RefreshLoadMoreLayout.c<>(0);
                cVar.Rmh = -2;
                checkEmptyHeader(cVar);
            }
            this.firstAttach = false;
        }
        AppMethodBeat.o(249089);
    }

    public final void ED(long j2) {
        AppMethodBeat.i(249090);
        b.AbstractC1238b<bo> bVar = this.uQT;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        RefreshLoadMoreLayout dcQ = bVar.dcQ();
        dcQ.postDelayed(new b(dcQ), j2);
        AppMethodBeat.o(249090);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class b implements Runnable {
        final /* synthetic */ boolean $isSilence = false;
        final /* synthetic */ RefreshLoadMoreLayout $rlLayout;

        b(RefreshLoadMoreLayout refreshLoadMoreLayout) {
            this.$rlLayout = refreshLoadMoreLayout;
        }

        public final void run() {
            AppMethodBeat.i(249057);
            this.$rlLayout.DD(this.$isSilence);
            AppMethodBeat.o(249057);
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016¨\u0006\t"}, hxF = {"com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter$onAttach$1", "Landroid/support/v7/widget/RecyclerView$OnScrollListener;", "onScrolled", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "dx", "", "dy", "plugin-finder_release"})
    public static final class f extends RecyclerView.l {
        final /* synthetic */ d uQX;

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrollStateChanged(RecyclerView recyclerView, int i2) {
            AppMethodBeat.i(249064);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter$onAttach$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, bVar.axR());
            super.onScrollStateChanged(recyclerView, i2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter$onAttach$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
            AppMethodBeat.o(249064);
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        f(d dVar) {
            this.uQX = dVar;
        }

        @Override // android.support.v7.widget.RecyclerView.l
        public final void onScrolled(RecyclerView recyclerView, int i2, int i3) {
            AppMethodBeat.i(249063);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(recyclerView);
            bVar.pH(i2);
            bVar.pH(i3);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter$onAttach$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, bVar.axR());
            p.h(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, i2, i3);
            this.uQX.totalDy -= i3;
            Log.d("Finder.NearbyLivePresenter", "onScrolled totalDy:" + this.uQX.totalDy + " dy:" + i3);
            com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
            com.tencent.mm.plugin.finder.report.live.k.a(recyclerView, s.p.LIVE_AUDIENCE_EXPLORE_FEED_CARD, String.valueOf(this.uQX.getCommentScene()), com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_SCROLL, -100, -100);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter$onAttach$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(249063);
        }
    }

    @Override // com.tencent.mm.plugin.finder.presenter.base.a
    public void onDetach() {
        AppMethodBeat.i(249093);
        NearbyLiveFeedLoader nearbyLiveFeedLoader = this.uQU;
        if (nearbyLiveFeedLoader != null) {
            nearbyLiveFeedLoader.unregister(this.uQV);
        }
        NearbyLiveFeedLoader nearbyLiveFeedLoader2 = this.uQU;
        if (nearbyLiveFeedLoader2 == null) {
            p.hyc();
        }
        if (nearbyLiveFeedLoader2.getDataListJustForAdapter().size() > 0) {
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            ((FinderHomeTabStateVM) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).Mp(dlr());
        }
        this.firstAttach = false;
        AppMethodBeat.o(249093);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter$createFeedLoader$1$1", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IInitDone;", "call", "", "incrementCount", "", "plugin-finder_release"})
    /* renamed from: com.tencent.mm.plugin.finder.nearby.live.d$d  reason: collision with other inner class name */
    public static final class C1240d implements com.tencent.mm.plugin.finder.feed.model.internal.h {
        final /* synthetic */ d uQX;
        final /* synthetic */ NearbyLiveFeedLoader uRb;
        final /* synthetic */ boolean uRc;

        C1240d(NearbyLiveFeedLoader nearbyLiveFeedLoader, d dVar, boolean z) {
            this.uRb = nearbyLiveFeedLoader;
            this.uQX = dVar;
            this.uRc = z;
        }

        @Override // com.tencent.mm.plugin.finder.feed.model.internal.h
        public final void call(int i2) {
            AppMethodBeat.i(249061);
            Log.i(this.uRb.getTAG(), "[initData] canTimelineRefresh=" + this.uRc + ", incrementCount=" + i2);
            if (this.uRc) {
                this.uQX.ED(0);
                AppMethodBeat.o(249061);
                return;
            }
            FinderHomeTabStateVM.a Mq = this.uQX.tlCache.Mq(this.uQX.dlr());
            int i3 = Mq.wue;
            final int i4 = Mq.wuf;
            final int i5 = Mq.wug;
            Log.i(this.uRb.getTAG(), "[initData] canTimelineRefresh " + this.uRc + " lastRootScrollPy:" + i3 + " lastPos=" + i4 + " fromTopPixel=" + i5);
            RecyclerView recyclerView = this.uQX.dlp().getRecyclerView();
            final RecyclerView.LayoutManager layoutManager = recyclerView != null ? recyclerView.getLayoutManager() : null;
            this.uQX.totalDy = i5;
            if (layoutManager instanceof StaggeredGridLayoutManager) {
                ((StaggeredGridLayoutManager) layoutManager).ah(i4, i5);
                if (recyclerView != null) {
                    recyclerView.post(new Runnable() {
                        /* class com.tencent.mm.plugin.finder.nearby.live.d.C1240d.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(249060);
                            ((StaggeredGridLayoutManager) layoutManager).ah(i4, i5);
                            AppMethodBeat.o(249060);
                        }
                    });
                }
            }
            if (i2 <= 0) {
                d.d(this.uQX);
            }
            AppMethodBeat.o(249061);
        }
    }

    private static int findFirstPosition(RecyclerView recyclerView) {
        AppMethodBeat.i(249094);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            int[] iArr = new int[2];
            ((StaggeredGridLayoutManager) layoutManager).n(iArr);
            int i2 = iArr[0];
            AppMethodBeat.o(249094);
            return i2;
        } else if (layoutManager instanceof LinearLayoutManager) {
            int ks = ((LinearLayoutManager) layoutManager).ks();
            AppMethodBeat.o(249094);
            return ks;
        } else {
            AppMethodBeat.o(249094);
            return 0;
        }
    }

    private final void checkEmptyHeader(RefreshLoadMoreLayout.c<Object> cVar) {
        AppMethodBeat.i(249095);
        com.tencent.mm.ac.d.h(new c(this, cVar));
        AppMethodBeat.o(249095);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class g extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ d uQX;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(d dVar) {
            super(0);
            this.uQX = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(249066);
            this.uQX.dlp().dcQ().postDelayed(new Runnable(this) {
                /* class com.tencent.mm.plugin.finder.nearby.live.d.g.AnonymousClass1 */
                final /* synthetic */ g uRd;

                {
                    this.uRd = r1;
                }

                public final void run() {
                    AppMethodBeat.i(249065);
                    RefreshLoadMoreLayout.c<Object> cVar = new RefreshLoadMoreLayout.c<>(0);
                    cVar.Rmh = -2;
                    this.uRd.uQX.dlp().dcQ().g(cVar);
                    AppMethodBeat.o(249065);
                }
            }, 200);
            x xVar = x.SXb;
            AppMethodBeat.o(249066);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class h extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ d uQX;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(d dVar) {
            super(0);
            this.uQX = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(249070);
            if (!this.uQX.isRequestingLbs) {
                this.uQX.isRequestingLbs = true;
                com.tencent.mm.ac.d.b("LbsPresenter_requestLbs", new kotlin.g.a.a<x>(this) {
                    /* class com.tencent.mm.plugin.finder.nearby.live.d.h.AnonymousClass1 */
                    final /* synthetic */ h uRe;

                    {
                        this.uRe = r2;
                    }

                    /* Return type fixed from 'java.lang.Object' to match base method */
                    @Override // kotlin.g.a.a
                    public final /* synthetic */ x invoke() {
                        AppMethodBeat.i(249069);
                        com.tencent.mm.plugin.finder.utils.l lVar = com.tencent.mm.plugin.finder.utils.l.vVE;
                        final boolean dBK = com.tencent.mm.plugin.finder.utils.l.dBK();
                        this.uRe.uQX.isRequestingLbs = false;
                        com.tencent.mm.ac.d.h(new kotlin.g.a.a<x>(this) {
                            /* class com.tencent.mm.plugin.finder.nearby.live.d.h.AnonymousClass1.AnonymousClass1 */
                            final /* synthetic */ AnonymousClass1 uRf;

                            {
                                this.uRf = r2;
                            }

                            /* Return type fixed from 'java.lang.Object' to match base method */
                            @Override // kotlin.g.a.a
                            public final /* synthetic */ x invoke() {
                                AppMethodBeat.i(249068);
                                if (dBK) {
                                    NearbyLiveFeedLoader nearbyLiveFeedLoader = this.uRf.uRe.uQX.uQU;
                                    if (nearbyLiveFeedLoader == null) {
                                        p.hyc();
                                    }
                                    nearbyLiveFeedLoader.a(this.uRf.uRe.uQX.uQK);
                                } else {
                                    this.uRf.uRe.uQX.dlp().dcQ().postDelayed(new Runnable(this) {
                                        /* class com.tencent.mm.plugin.finder.nearby.live.d.h.AnonymousClass1.AnonymousClass1.AnonymousClass1 */
                                        final /* synthetic */ AnonymousClass1 uRg;

                                        {
                                            this.uRg = r1;
                                        }

                                        public final void run() {
                                            AppMethodBeat.i(249067);
                                            RefreshLoadMoreLayout.c<Object> cVar = new RefreshLoadMoreLayout.c<>(0);
                                            cVar.Rmh = -2;
                                            this.uRg.uRf.uRe.uQX.dlp().dcQ().g(cVar);
                                            AppMethodBeat.o(249067);
                                        }
                                    }, 200);
                                }
                                x xVar = x.SXb;
                                AppMethodBeat.o(249068);
                                return xVar;
                            }
                        });
                        x xVar = x.SXb;
                        AppMethodBeat.o(249069);
                        return xVar;
                    }
                });
            }
            x xVar = x.SXb;
            AppMethodBeat.o(249070);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class i extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ d uQX;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(d dVar) {
            super(0);
            this.uQX = dVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(249071);
            NearbyLiveFeedLoader nearbyLiveFeedLoader = this.uQX.uQU;
            if (nearbyLiveFeedLoader == null) {
                p.hyc();
            }
            nearbyLiveFeedLoader.a(this.uQX.uQK);
            x xVar = x.SXb;
            AppMethodBeat.o(249071);
            return xVar;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    public static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ RefreshLoadMoreLayout.c $r;
        final /* synthetic */ d uQX;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(d dVar, RefreshLoadMoreLayout.c cVar) {
            super(0);
            this.uQX = dVar;
            this.$r = cVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            RefreshLoadMoreLayout.c cVar;
            int i2;
            RefreshLoadMoreLayout dcQ;
            boolean z = false;
            AppMethodBeat.i(249059);
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
            RecyclerView recyclerView = this.uQX.dlp().getRecyclerView();
            RecyclerView.a adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (!(adapter instanceof WxRecyclerAdapter)) {
                adapter = null;
            }
            WxRecyclerAdapter wxRecyclerAdapter = (WxRecyclerAdapter) adapter;
            if (wxRecyclerAdapter != null) {
                i2 = wxRecyclerAdapter.hgt();
            } else {
                i2 = 0;
            }
            boolean z2 = i2 <= 0;
            Log.i("Finder.TimelineLbsPresenter", "[checkEmptyHeader] isEmpty=" + z2 + " reason=" + cVar);
            if (z2) {
                this.uQX.dlp().dcQ().setEnableLoadMore(false);
                com.tencent.mm.plugin.finder.model.g gVar = this.uQX.emptyData;
                Context context2 = MMApplicationContext.getContext();
                p.g(context2, "MMApplicationContext.getContext()");
                String string = context2.getResources().getString(R.string.d3g);
                p.g(string, "MMApplicationContext.get…g.finder_no_more_content)");
                gVar.P(string);
                this.uQX.emptyData.type = cVar.Rmh;
                this.uQX.emptyData.dLS = 1001;
                com.tencent.mm.plugin.finder.model.g gVar2 = this.uQX.emptyData;
                Context context3 = MMApplicationContext.getContext();
                p.g(context3, "MMApplicationContext.getContext()");
                String string2 = context3.getResources().getString(R.string.d3g);
                p.g(string2, "MMApplicationContext.get…g.finder_no_more_content)");
                gVar2.P(string2);
                axj axj = this.uQX.uQK;
                if (axj != null) {
                    com.tencent.mm.plugin.finder.model.g gVar3 = this.uQX.emptyData;
                    Context context4 = MMApplicationContext.getContext();
                    p.g(context4, "MMApplicationContext.getContext()");
                    String string3 = context4.getResources().getString(R.string.fal, axj.LHR);
                    p.g(string3, "MMApplicationContext.get…ore_content, it.tab_name)");
                    gVar3.P(string3);
                    this.uQX.emptyData.uNP = 1000;
                    if (cVar.iMa instanceof auh) {
                        E e2 = cVar.iMa;
                        if (e2 == null) {
                            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.protocal.protobuf.FinderJumpLiveTab");
                            AppMethodBeat.o(249059);
                            throw tVar;
                        }
                        axj axj2 = e2.LFb;
                        if (axj2 != null) {
                            if (axj.LHQ == axj2.LHQ) {
                                this.uQX.emptyData.uNP = 1000;
                                com.tencent.mm.plugin.finder.model.g gVar4 = this.uQX.emptyData;
                                Context context5 = MMApplicationContext.getContext();
                                p.g(context5, "MMApplicationContext.getContext()");
                                String string4 = context5.getResources().getString(R.string.fal, axj.LHR);
                                p.g(string4, "MMApplicationContext.get…ore_content, it.tab_name)");
                                gVar4.P(string4);
                            } else {
                                this.uQX.emptyData.uNP = 2000;
                                this.uQX.emptyData.P(String.valueOf(axj.LHR));
                                this.uQX.emptyData.uGD = new a(axj2, axj, this, cVar);
                            }
                        }
                    }
                }
                if (wxRecyclerAdapter != null && !wxRecyclerAdapter.a(this.uQX.emptyData)) {
                    wxRecyclerAdapter.a((g.b) this.uQX.emptyData, false);
                } else if (wxRecyclerAdapter != null) {
                    wxRecyclerAdapter.Or((long) this.uQX.emptyData.hashCode());
                }
            } else if (wxRecyclerAdapter != null) {
                wxRecyclerAdapter.T((long) this.uQX.emptyData.hashCode(), false);
            }
            b.AbstractC1238b<bo> dlp = this.uQX.dlp();
            if (!(dlp == null || (dcQ = dlp.dcQ()) == null)) {
                if (cVar.Rmh != -1 || !z2) {
                    z = true;
                }
                dcQ.setEnableNestedScroll(z);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(249059);
            return xVar;
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0004"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter$checkEmptyHeader$1$1$1$1", "com/tencent/mm/plugin/finder/nearby/live/NearbyLivePresenter$checkEmptyHeader$1$$special$$inlined$let$lambda$1"})
        static final class a extends q implements kotlin.g.a.a<x> {
            final /* synthetic */ RefreshLoadMoreLayout.c tMp;
            final /* synthetic */ axj uQY;
            final /* synthetic */ axj uQZ;
            final /* synthetic */ c uRa;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(axj axj, axj axj2, c cVar, RefreshLoadMoreLayout.c cVar2) {
                super(0);
                this.uQY = axj;
                this.uQZ = axj2;
                this.uRa = cVar;
                this.tMp = cVar2;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // kotlin.g.a.a
            public final /* synthetic */ x invoke() {
                AppMethodBeat.i(249058);
                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                Fragment fragment = this.uRa.uQX.fragment;
                if (fragment == null) {
                    p.hyc();
                }
                Fragment parentFragment = fragment.getParentFragment();
                if (parentFragment == null) {
                    p.hyc();
                }
                p.g(parentFragment, "fragment!!.parentFragment!!");
                ((NearbyLiveSquareUIC) com.tencent.mm.ui.component.a.of(parentFragment).get(NearbyLiveSquareUIC.class)).JB(this.uQY.LHQ);
                x xVar = x.SXb;
                AppMethodBeat.o(249058);
                return xVar;
            }
        }
    }

    public final void a(b.AbstractC1238b<bo> bVar) {
        AppMethodBeat.i(249091);
        p.h(bVar, "callback");
        boolean JN = this.tlCache.JN(dlr());
        NearbyLiveFeedLoader nearbyLiveFeedLoader = new NearbyLiveFeedLoader(this.ttO, getCommentScene(), JN ? 0 : 1, getTabType(), dlq());
        nearbyLiveFeedLoader.setInitDone(new C1240d(nearbyLiveFeedLoader, this, JN));
        nearbyLiveFeedLoader.fetchEndCallback = new e(nearbyLiveFeedLoader);
        this.uQU = nearbyLiveFeedLoader;
        this.uQT = bVar;
        b.AbstractC1238b<bo> bVar2 = this.uQT;
        if (bVar2 == null) {
            p.btv("viewCallback");
        }
        NearbyLiveFeedLoader nearbyLiveFeedLoader2 = this.uQU;
        if (nearbyLiveFeedLoader2 == null) {
            p.hyc();
        }
        bVar2.ab(nearbyLiveFeedLoader2.getDataListJustForAdapter());
        NearbyLiveFeedLoader nearbyLiveFeedLoader3 = this.uQU;
        if (nearbyLiveFeedLoader3 != null) {
            nearbyLiveFeedLoader3.register(this.uQV);
        }
        b.AbstractC1238b<bo> bVar3 = this.uQT;
        if (bVar3 == null) {
            p.btv("viewCallback");
        }
        RecyclerView recyclerView = bVar3.getRecyclerView();
        if (recyclerView != null) {
            recyclerView.a(new f(this));
        }
        this.firstAttach = true;
        AppMethodBeat.o(249091);
    }
}
