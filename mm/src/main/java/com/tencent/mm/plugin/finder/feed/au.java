package com.tencent.mm.plugin.finder.feed;

import android.arch.lifecycle.ViewModel;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.v;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.feed.ai;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.plugin.finder.report.live.s;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.view.manager.FinderLinearLayoutManager;
import com.tencent.mm.plugin.finder.viewmodel.FinderRecyclerViewPool;
import com.tencent.mm.plugin.finder.viewmodel.FinderTabStreamUnreadVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderActionBarOverlayUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.widget.MMProcessBar;
import com.tencent.mm.view.HeadFooterLayout;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.WxRecyclerView;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.rtmp.sharp.jni.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.q;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 Z2\u00020\u00012\u00020\u0002:\u0002Z[B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0018\u0010<\u001a\u00020=2\u0006\u0010>\u001a\u00020?2\u0006\u0010@\u001a\u00020&H\u0016J\b\u0010A\u001a\u00020\u0004H\u0016J\b\u0010B\u001a\u00020\u0006H\u0016J\b\u0010C\u001a\u00020DH\u0016J\b\u0010E\u001a\u00020*H\u0016J\b\u0010F\u001a\u00020\bH\u0016J(\u0010G\u001a\u00020=2\u0016\u0010H\u001a\u0012\u0012\u0004\u0012\u00020J0Ij\b\u0012\u0004\u0012\u00020J`K2\u0006\u00103\u001a\u00020\u0013H\u0016J\b\u0010L\u001a\u00020&H\u0016J0\u0010M\u001a\u00020&2\u0006\u0010N\u001a\u00020\u00132\u0006\u0010O\u001a\u00020\u00132\u0006\u0010P\u001a\u00020\u00132\u0006\u0010Q\u001a\u00020&2\u0006\u0010R\u001a\u00020&H\u0016J0\u0010S\u001a\u00020&2\u0006\u0010N\u001a\u00020\u00132\u0006\u0010O\u001a\u00020\u00132\u0006\u0010P\u001a\u00020\u00132\u0006\u0010Q\u001a\u00020&2\u0006\u0010R\u001a\u00020&H\u0016J\u0010\u0010T\u001a\u00020=2\u0006\u0010P\u001a\u00020\u0013H\u0016J\u0016\u0010U\u001a\u00020=2\f\u0010V\u001a\b\u0012\u0004\u0012\u00020X0WH\u0016J(\u0010Y\u001a\u00020=2\u0006\u00103\u001a\u00020\u00132\u0016\u0010H\u001a\u0012\u0012\u0004\u0012\u00020J0Ij\b\u0012\u0004\u0012\u00020J`KH\u0016R\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0011\u001a\u0004\b\u0019\u0010\u001aR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001b\u0010\"\u001a\u00020\u00188BX\u0002¢\u0006\f\n\u0004\b$\u0010\u0011\u001a\u0004\b#\u0010\u001aR\u001b\u0010%\u001a\u00020&8BX\u0002¢\u0006\f\n\u0004\b(\u0010\u0011\u001a\u0004\b%\u0010'R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010)\u001a\u00020*8BX\u0002¢\u0006\f\n\u0004\b-\u0010\u0011\u001a\u0004\b+\u0010,R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u000e¢\u0006\u0002\n\u0000R\u001b\u00100\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b2\u0010\u0011\u001a\u0004\b1\u0010\u0015R\u000e\u00103\u001a\u00020\u0013X\u000e¢\u0006\u0002\n\u0000R\u001b\u00104\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b6\u0010\u0011\u001a\u0004\b5\u0010\u0015R\u001b\u00107\u001a\u0002088BX\u0002¢\u0006\f\n\u0004\b;\u0010\u0011\u001a\u0004\b9\u0010:¨\u0006\\"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$ViewCallback;", "Lcom/tencent/mm/view/HeadFooterLayout$OverCallback;", "baseContext", "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$Presenter;", "parent", "Landroid/view/View;", "fragment", "Landroid/support/v4/app/Fragment;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/feed/FinderTimelineContract$Presenter;Landroid/view/View;Landroid/support/v4/app/Fragment;)V", "actionBarOverlayUIC", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC;", "getActionBarOverlayUIC", "()Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC;", "actionBarOverlayUIC$delegate", "Lkotlin/Lazy;", "actionHeight", "", "getActionHeight", "()I", "actionHeight$delegate", "feedViewPool", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "getFeedViewPool", "()Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "feedViewPool$delegate", "friendLikeDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "getFriendLikeDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "setFriendLikeDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;)V", "fullFeedViewPool", "getFullFeedViewPool", "fullFeedViewPool$delegate", "isEnableFullScreenEnjoy", "", "()Z", "isEnableFullScreenEnjoy$delegate", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "rlLayout$delegate", "rlProcessBar", "Lcom/tencent/mm/ui/widget/MMProcessBar;", "statusHeight", "getStatusHeight", "statusHeight$delegate", "tabType", "topBarHeight", "getTopBarHeight", "topBarHeight$delegate", "topLoadingOffsetLimit", "", "getTopLoadingOffsetLimit", "()F", "topLoadingOffsetLimit$delegate", "autoFlingToRefresh", "", "delayStart", "", "isSilence", "getActivity", "getPresenter", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRefreshLoadMoreLayout", "getRootView", "initView", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "onBackPressed", "onOverEnd", "dx", "dy", "type", "isComsumed", "isVertical", "onOverStart", "onOverStop", "setOnItemClickListener", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "showEmptyView", "Companion", "TimelineAdapter", "plugin-finder_release"})
public final class au implements ai.b, HeadFooterLayout.b {
    public static final a tTg = new a((byte) 0);
    private int dLS;
    private final Fragment fragment;
    private final View hVd;
    public FinderLikeDrawer tLV;
    private final kotlin.f tLX = kotlin.g.ah(new l(this));
    private final kotlin.f tPX = kotlin.g.ah(new f(this));
    final MMActivity tRl;
    private final kotlin.f tSX = kotlin.g.ah(new m(this));
    private MMProcessBar tSY;
    private final kotlin.f tSZ = kotlin.g.ah(new n(this));
    private final kotlin.f tTa = kotlin.g.ah(new d(this));
    private final kotlin.f tTb = kotlin.g.ah(new o(this));
    private final kotlin.f tTc = kotlin.g.ah(new c(this));
    private final kotlin.f tTd = kotlin.g.ah(new p(this));
    private final kotlin.f tTe = kotlin.g.ah(new g(this));
    private final ai.a tTf;

    static {
        AppMethodBeat.i(165939);
        AppMethodBeat.o(165939);
    }

    private final boolean dck() {
        AppMethodBeat.i(244426);
        boolean booleanValue = ((Boolean) this.tLX.getValue()).booleanValue();
        AppMethodBeat.o(244426);
        return booleanValue;
    }

    private final int ddp() {
        AppMethodBeat.i(244424);
        int intValue = ((Number) this.tSZ.getValue()).intValue();
        AppMethodBeat.o(244424);
        return intValue;
    }

    private final int ddq() {
        AppMethodBeat.i(244425);
        int intValue = ((Number) this.tTa.getValue()).intValue();
        AppMethodBeat.o(244425);
        return intValue;
    }

    private final RefreshLoadMoreLayout getRlLayout() {
        AppMethodBeat.i(244423);
        RefreshLoadMoreLayout refreshLoadMoreLayout = (RefreshLoadMoreLayout) this.tSX.getValue();
        AppMethodBeat.o(244423);
        return refreshLoadMoreLayout;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "offset", "", "invoke"})
    static final class i extends q implements kotlin.g.a.b<Float, x> {
        final /* synthetic */ au tTi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(au auVar) {
            super(1);
            this.tTi = auVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Float f2) {
            ViewGroup viewGroup;
            AppMethodBeat.i(244410);
            float floatValue = f2.floatValue();
            FinderActionBarOverlayUIC b2 = au.b(this.tTi);
            if (!(b2 == null || b2.tSk == null || (viewGroup = (ViewGroup) b2.wvc.getValue()) == null)) {
                viewGroup.setTranslationY(floatValue);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(244410);
            return xVar;
        }
    }

    public au(MMActivity mMActivity, ai.a aVar, View view, Fragment fragment2) {
        kotlin.g.b.p.h(mMActivity, "baseContext");
        kotlin.g.b.p.h(aVar, "presenter");
        kotlin.g.b.p.h(view, "parent");
        AppMethodBeat.i(244430);
        this.tRl = mMActivity;
        this.tTf = aVar;
        this.hVd = view;
        this.fragment = fragment2;
        AppMethodBeat.o(244430);
    }

    public static final /* synthetic */ RefreshLoadMoreLayout d(au auVar) {
        AppMethodBeat.i(165950);
        RefreshLoadMoreLayout rlLayout = auVar.getRlLayout();
        AppMethodBeat.o(165950);
        return rlLayout;
    }

    public static final /* synthetic */ MMProcessBar e(au auVar) {
        AppMethodBeat.i(165951);
        MMProcessBar mMProcessBar = auVar.tSY;
        AppMethodBeat.o(165951);
        return mMProcessBar;
    }

    public static final /* synthetic */ int g(au auVar) {
        AppMethodBeat.i(244432);
        int ddp = auVar.ddp();
        AppMethodBeat.o(244432);
        return ddp;
    }

    public static final /* synthetic */ int h(au auVar) {
        AppMethodBeat.i(244433);
        int ddq = auVar.ddq();
        AppMethodBeat.o(244433);
        return ddq;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.ai.b
    public final RecyclerView getRecyclerView() {
        AppMethodBeat.i(165942);
        RecyclerView recyclerView = getRlLayout().getRecyclerView();
        AppMethodBeat.o(165942);
        return recyclerView;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ai.b
    public final RefreshLoadMoreLayout dcQ() {
        AppMethodBeat.i(165943);
        RefreshLoadMoreLayout rlLayout = getRlLayout();
        AppMethodBeat.o(165943);
        return rlLayout;
    }

    @Override // com.tencent.mm.plugin.finder.feed.ai.b
    public final void c(ArrayList<bo> arrayList, int i2) {
        AppMethodBeat.i(244427);
        kotlin.g.b.p.h(arrayList, "data");
        this.dLS = i2;
        FinderLikeDrawer.a aVar = FinderLikeDrawer.wnm;
        Window window = this.tRl.getWindow();
        kotlin.g.b.p.g(window, "getActivity().window");
        FinderLikeDrawer.a aVar2 = FinderLikeDrawer.wnm;
        this.tLV = FinderLikeDrawer.a.a(this.tRl, window, FinderLikeDrawer.tvl);
        RecyclerView recyclerView = getRlLayout().getRecyclerView();
        if (dck()) {
            RefreshLoadMoreLayout.StickTopLoadingLayout stickTopLoadingLayout = (RefreshLoadMoreLayout.StickTopLoadingLayout) this.hVd.findViewById(R.id.dc6);
            kotlin.g.b.p.g(stickTopLoadingLayout, "stickTopLoadingLayout");
            ViewGroup.LayoutParams layoutParams = stickTopLoadingLayout.getLayoutParams();
            if (layoutParams == null) {
                t tVar = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                AppMethodBeat.o(244427);
                throw tVar;
            }
            ((FrameLayout.LayoutParams) layoutParams).topMargin = ddp() + (ddq() / 2);
            stickTopLoadingLayout.setActionCallback(new h(this));
            stickTopLoadingLayout.setOnScrollCallback(new i(this));
            getRlLayout().setStickTopLoadingLayout(stickTopLoadingLayout);
            int dimension = (int) this.hVd.getResources().getDimension(R.dimen.a5g);
            int floatValue = (int) ((Number) this.tTd.getValue()).floatValue();
            getRlLayout().setLimitTopRequest(dimension - floatValue);
            getRlLayout().setRefreshTargetY(floatValue - dimension);
            getRlLayout().setDamping(1.6f);
            recyclerView.setRecycledViewPool((RecyclerView.m) this.tTe.getValue());
        } else {
            this.tSY = (MMProcessBar) this.hVd.findViewById(R.id.h7v);
            getRlLayout().setLimitTopRequest(((int) this.hVd.getResources().getDimension(R.dimen.a5g)) - ((int) this.hVd.getResources().getDimension(R.dimen.bx)));
            getRlLayout().setRefreshTargetY(((int) this.hVd.getResources().getDimension(R.dimen.cp)) - ((int) this.hVd.getResources().getDimension(R.dimen.a5g)));
            recyclerView.setRecycledViewPool((RecyclerView.m) this.tPX.getValue());
            getRlLayout().setDamping(1.85f);
        }
        FinderLinearLayoutManager finderLinearLayoutManager = new FinderLinearLayoutManager(this.tRl);
        if (dck()) {
            finderLinearLayoutManager.wsx = 25.0f;
            finderLinearLayoutManager.qOi = 100;
        }
        y yVar = y.vXH;
        finderLinearLayoutManager.setItemPrefetchEnabled(y.isAllHomeTabEnableFullScreenEnjoy());
        recyclerView.setLayoutManager(finderLinearLayoutManager);
        b bVar = new b(this, this.tTf.dce(), arrayList, i2 == 4);
        bVar.RrA = new j(i2);
        Iterator<T> it = this.tTf.getHeaderInfo().iterator();
        while (it.hasNext()) {
            bVar.a((com.tencent.mm.view.recyclerview.g) it.next(), (g.b) true);
        }
        if (recyclerView == null) {
            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.view.recyclerview.WxRecyclerView");
            AppMethodBeat.o(244427);
            throw tVar2;
        }
        ((WxRecyclerView) recyclerView).setAdapter(bVar);
        recyclerView.setHasFixedSize(true);
        com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
        ((WxRecyclerView) recyclerView).setFlingSpeedFactor(com.tencent.mm.plugin.finder.storage.c.dsZ().value().intValue());
        if (dck()) {
            recyclerView.setItemViewCacheSize(1);
            new com.tencent.mm.plugin.finder.ui.e().f(recyclerView);
        }
        ((WxRecyclerView) recyclerView).setItemAnimator(new com.tencent.mm.plugin.finder.view.animation.e());
        if (!dck()) {
            recyclerView.b(new com.tencent.mm.plugin.finder.view.decoration.b(new ColorDrawable(((WxRecyclerView) recyclerView).getResources().getColor(R.color.BW_93)), (int) ((WxRecyclerView) recyclerView).getResources().getDimension(R.dimen.a4f)));
        }
        getRlLayout().setActionCallback(new k(this, recyclerView));
        com.tencent.mm.ui.component.a aVar3 = com.tencent.mm.ui.component.a.PRN;
        com.tencent.mm.plugin.finder.event.base.f ME = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.tRl).get(FinderReporterUIC.class)).ME(this.tTf.getTabType());
        if (ME != null) {
            ME.m(getRlLayout().getRecyclerView());
        }
        getRlLayout().setOverCallback(this);
        AppMethodBeat.o(244427);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016¨\u0006\u0007"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$1", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "onRefreshEnd", "", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "plugin-finder_release"})
    public static final class h extends RefreshLoadMoreLayout.a {
        final /* synthetic */ au tTi;

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void ED(int i2) {
            AppMethodBeat.i(244407);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, bVar.axR());
            super.ED(i2);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
            AppMethodBeat.o(244407);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void a(RefreshLoadMoreLayout.c cVar) {
            AppMethodBeat.i(244409);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            super.a(cVar);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(244409);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void cxo() {
            AppMethodBeat.i(244408);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
            super.cxo();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
            AppMethodBeat.o(244408);
        }

        /* JADX WARN: Incorrect args count in method signature: ()V */
        h(au auVar) {
            this.tTi = auVar;
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> cVar) {
            FinderActionBarOverlayUIC b2;
            AppMethodBeat.i(244406);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            kotlin.g.b.p.h(cVar, "reason");
            super.onRefreshEnd(cVar);
            if (cVar.Rmk <= 0) {
                CharSequence charSequence = cVar.Rmi;
                if (!(charSequence == null || charSequence.length() == 0) && (b2 = au.b(this.tTi)) != null) {
                    FinderActionBarOverlayUIC.a(b2, cVar.Rmi);
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$1", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(244406);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$4", "Lcom/tencent/mm/view/recyclerview/WxRVListener;", "onScrollStatsChanged", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "data", "Lcom/tencent/mm/view/recyclerview/WxRVData;", "plugin-finder_release"})
    public static final class j implements com.tencent.mm.view.recyclerview.l {
        final /* synthetic */ int tTj;

        j(int i2) {
            this.tTj = i2;
        }

        @Override // com.tencent.mm.view.recyclerview.l
        public final void a(RecyclerView recyclerView, com.tencent.mm.view.recyclerview.j jVar) {
            AppMethodBeat.i(244411);
            kotlin.g.b.p.h(recyclerView, "recyclerView");
            kotlin.g.b.p.h(jVar, "data");
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            ViewModel viewModel = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderTabStreamUnreadVM.class);
            kotlin.g.b.p.g(viewModel, "UICProvider.of(PluginFin…reamUnreadVM::class.java)");
            FinderTabStreamUnreadVM finderTabStreamUnreadVM = (FinderTabStreamUnreadVM) viewModel;
            if (this.tTj == 4) {
                ArrayList arrayList = new ArrayList();
                for (T t : jVar.Rrl) {
                    if (t.Rrp instanceof BaseFinderFeed) {
                        arrayList.add(t);
                    }
                }
                ArrayList<com.tencent.mm.view.recyclerview.k> arrayList2 = arrayList;
                ArrayList arrayList3 = new ArrayList(kotlin.a.j.a(arrayList2, 10));
                for (com.tencent.mm.view.recyclerview.k kVar : arrayList2) {
                    com.tencent.mm.view.recyclerview.a aVar2 = kVar.Rrp;
                    if (aVar2 == null) {
                        t tVar = new t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.model.BaseFinderFeed");
                        AppMethodBeat.o(244411);
                        throw tVar;
                    }
                    arrayList3.add((BaseFinderFeed) aVar2);
                }
                finderTabStreamUnreadVM.o(19, arrayList3);
            }
            AppMethodBeat.o(244411);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\u0016\u0010\r\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\u0016\u0010\u0013\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$7", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "firstChange", "", "getFirstChange", "()Z", "setFirstChange", "(Z)V", "onItemChange", "", "changeItemCount", "", "onLoadMoreBegin", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "onRefreshEnd", "plugin-finder_release"})
    public static final class k extends RefreshLoadMoreLayout.a {
        final /* synthetic */ RecyclerView tDJ;
        private boolean tMa = true;
        final /* synthetic */ au tTi;

        k(au auVar, RecyclerView recyclerView) {
            this.tTi = auVar;
            this.tDJ = recyclerView;
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void ED(int i2) {
            AppMethodBeat.i(244413);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.pH(i2);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$7", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, bVar.axR());
            super.ED(i2);
            this.tTi.tTf.requestRefresh();
            this.tDJ.setItemAnimator(new com.tencent.mm.plugin.finder.view.animation.e());
            RefreshLoadMoreLayout.c.a aVar = RefreshLoadMoreLayout.c.Rms;
            if (i2 == RefreshLoadMoreLayout.c.Rmq) {
                com.tencent.mm.plugin.finder.storage.c cVar = com.tencent.mm.plugin.finder.storage.c.vCb;
                if (com.tencent.mm.plugin.finder.storage.c.dsx().value().intValue() == 1) {
                    FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
                    FinderReporterUIC fH = FinderReporterUIC.a.fH(this.tTi.tRl);
                    if (fH != null) {
                        com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                        com.tencent.mm.plugin.finder.report.k.a(fH.dIx(), 3);
                    }
                }
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$7", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
            AppMethodBeat.o(244413);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(244414);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$7", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            kotlin.g.b.p.h(cVar, "reason");
            super.onRefreshEnd(cVar);
            this.tTi.tTf.onRefreshEnd(cVar);
            this.tDJ.postDelayed(new a(this), 1000);
            switch (this.tTi.tTf.getTabType()) {
                case 1:
                    com.tencent.mm.plugin.finder.report.live.k kVar = com.tencent.mm.plugin.finder.report.live.k.vkd;
                    com.tencent.mm.plugin.finder.report.live.k.b(this.tDJ, s.p.LIVE_AUDIENCE_EXPLORE_SINGLE_AVATAR, s.j.COMMENT_SCENE_FRIEND_TAB_AVATAR_FLOW.scene, com.tencent.mm.plugin.finder.report.live.c.EVENT_ON_REFRESH);
                    break;
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$7", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(244414);
        }

        @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
        static final class a implements Runnable {
            final /* synthetic */ k tTk;

            a(k kVar) {
                this.tTk = kVar;
            }

            public final void run() {
                AppMethodBeat.i(244412);
                this.tTk.tDJ.setItemAnimator(new v());
                AppMethodBeat.o(244412);
            }
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void cxo() {
            AppMethodBeat.i(244415);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$7", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
            super.cxo();
            this.tTi.tTf.boE();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$7", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
            AppMethodBeat.o(244415);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void a(RefreshLoadMoreLayout.c<Object> cVar) {
            AppMethodBeat.i(244416);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(cVar);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$7", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
            kotlin.g.b.p.h(cVar, "reason");
            super.a(cVar);
            Log.i("Finder.TimelineViewCallback", "[onLoadMoreEnd] isHasAnyMore=".concat(String.valueOf(cVar)));
            if (!cVar.Rmj && this.tDJ.getChildCount() > 0) {
                View childAt = this.tDJ.getChildAt(this.tDJ.getChildCount() - 1);
                RecyclerView.v bu = this.tDJ.bu(childAt);
                Integer valueOf = bu != null ? Integer.valueOf(bu.lU()) : null;
                kotlin.g.b.p.g(childAt, "itemView");
                if (childAt.getHeight() > 0 && ((valueOf != null && valueOf.intValue() == 4) || (valueOf != null && valueOf.intValue() == 8))) {
                    int height = c.a.a(this.tTi).getDisplayMetrics().heightPixels - childAt.getHeight();
                    au.d(this.tTi).setExtraOverScrollFooterDx(height / 3);
                    Log.i("Finder.TimelineViewCallback", "extraOverScrollFooterDx=".concat(String.valueOf(height)));
                    com.tencent.mm.plugin.report.service.h.INSTANCE.n(1311, 2, 1);
                }
            }
            this.tTi.tTf.a(cVar);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$initView$7", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
            AppMethodBeat.o(244416);
        }

        @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
        public final void IF(int i2) {
            AppMethodBeat.i(244417);
            if (this.tMa && i2 > 0) {
                com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
                com.tencent.mm.plugin.finder.event.base.f ME = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.tTi.tRl).get(FinderReporterUIC.class)).ME(this.tTi.tTf.getTabType());
                if (ME != null) {
                    ME.dap().onScrollStateChanged(this.tDJ, 5);
                }
                this.tMa = false;
            }
            AppMethodBeat.o(244417);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0004\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B-\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0007j\b\u0012\u0004\u0012\u00028\u0000`\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J.\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0016J\u0018\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u0012H\u0016R\u001e\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0007j\b\u0012\u0004\u0012\u00028\u0000`\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback$TimelineAdapter;", QLog.TAG_REPORTLEVEL_DEVELOPER, "Lcom/tencent/mm/view/recyclerview/ConvertData;", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "itemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "data", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "needScrollData", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderTimelineViewCallback;Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;Ljava/util/ArrayList;Z)V", "showResult", "_onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "", "onBindFirstBodyViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "throwBindViewHolderException", "", "e", "Ljava/lang/Exception;", "payloads", "", "", "throwCreateViewHolderException", "type", "plugin-finder_release"})
    public final class b<D extends com.tencent.mm.view.recyclerview.a> extends WxRecyclerAdapter<D> {
        private final ArrayList<D> data;
        private final com.tencent.mm.view.recyclerview.f tDm;
        private boolean tTh;
        final /* synthetic */ au tTi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(au auVar, com.tencent.mm.view.recyclerview.f fVar, ArrayList<D> arrayList, boolean z) {
            super(fVar, arrayList, z);
            kotlin.g.b.p.h(fVar, "itemConvertFactory");
            kotlin.g.b.p.h(arrayList, "data");
            this.tTi = auVar;
            AppMethodBeat.i(244402);
            this.tDm = fVar;
            this.data = arrayList;
            AppMethodBeat.o(244402);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Exception, android.support.v7.widget.RecyclerView$v, java.util.List] */
        @Override // com.tencent.mm.view.recyclerview.g
        public final /* synthetic */ String a(Exception exc, com.tencent.mm.view.recyclerview.h hVar, List list) {
            AppMethodBeat.i(244401);
            com.tencent.mm.view.recyclerview.h hVar2 = hVar;
            kotlin.g.b.p.h(exc, "e");
            kotlin.g.b.p.h(hVar2, "holder");
            kotlin.g.b.p.h(list, "payloads");
            bo boVar = (bo) hVar2.hgv();
            if (boVar instanceof BaseFinderFeed) {
                String obj = boVar.toString();
                AppMethodBeat.o(244401);
                return obj;
            }
            String str = "Feed[" + boVar + "] is not BaseFinderFeed";
            AppMethodBeat.o(244401);
            return str;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int] */
        @Override // com.tencent.mm.view.recyclerview.WxRecyclerAdapter, com.tencent.mm.view.recyclerview.g
        public final /* synthetic */ void h(com.tencent.mm.view.recyclerview.h hVar, int i2) {
            AppMethodBeat.i(178277);
            a(hVar, i2);
            AppMethodBeat.o(178277);
        }

        @Override // com.tencent.mm.view.recyclerview.WxRecyclerAdapter
        public final void a(com.tencent.mm.view.recyclerview.h hVar, int i2) {
            AppMethodBeat.i(178276);
            kotlin.g.b.p.h(hVar, "holder");
            super.a(hVar, i2);
            if (!this.tTh) {
                com.tencent.mm.plugin.finder.report.k kVar = com.tencent.mm.plugin.finder.report.k.vfA;
                com.tencent.mm.plugin.finder.report.k.gS(this.tTi.tTf.cND(), "ShowResult");
                this.tTh = true;
            }
            AppMethodBeat.o(178276);
        }

        @Override // com.tencent.mm.view.recyclerview.WxRecyclerAdapter
        public final void n(RecyclerView recyclerView) {
            AppMethodBeat.i(244399);
            kotlin.g.b.p.h(recyclerView, "recyclerView");
            AppMethodBeat.o(244399);
        }

        @Override // com.tencent.mm.view.recyclerview.g
        public final String c(Exception exc, int i2) {
            AppMethodBeat.i(244400);
            kotlin.g.b.p.h(exc, "e");
            String c2 = super.c(exc, i2);
            AppMethodBeat.o(244400);
            return c2;
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.ai.b
    public final boolean onBackPressed() {
        AppMethodBeat.i(244428);
        FinderLikeDrawer finderLikeDrawer = this.tLV;
        if (finderLikeDrawer == null) {
            kotlin.g.b.p.btv("friendLikeDrawer");
        }
        if (finderLikeDrawer.dGs()) {
            FinderLikeDrawer finderLikeDrawer2 = this.tLV;
            if (finderLikeDrawer2 == null) {
                kotlin.g.b.p.btv("friendLikeDrawer");
            }
            finderLikeDrawer2.dGr();
            AppMethodBeat.o(244428);
            return true;
        }
        AppMethodBeat.o(244428);
        return false;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class e implements Runnable {
        final /* synthetic */ boolean $isSilence = false;
        final /* synthetic */ au tTi;

        e(au auVar) {
            this.tTi = auVar;
        }

        public final void run() {
            AppMethodBeat.i(165928);
            au.d(this.tTi).DD(this.$isSilence);
            MMProcessBar e2 = au.e(this.tTi);
            if (e2 != null) {
                e2.gYP();
                AppMethodBeat.o(165928);
                return;
            }
            AppMethodBeat.o(165928);
        }
    }

    @Override // com.tencent.mm.plugin.finder.feed.ai.b
    public final void dcP() {
        AppMethodBeat.i(244429);
        getRlLayout().postDelayed(new e(this), 150);
        AppMethodBeat.o(244429);
    }

    @Override // com.tencent.mm.plugin.finder.feed.ai.b
    public final View getRootView() {
        return this.hVd;
    }

    @Override // com.tencent.mm.view.HeadFooterLayout.b
    public final void ddr() {
        AppMethodBeat.i(165946);
        Log.i("Finder.TimelineViewCallback", "[onOverStop]");
        MMProcessBar mMProcessBar = this.tSY;
        if (mMProcessBar != null) {
            mMProcessBar.gYP();
            AppMethodBeat.o(165946);
            return;
        }
        AppMethodBeat.o(165946);
    }

    @Override // com.tencent.mm.view.HeadFooterLayout.b
    public final boolean u(int i2, int i3, boolean z) {
        AppMethodBeat.i(165947);
        MMProcessBar mMProcessBar = this.tSY;
        if (mMProcessBar != null) {
            if (mMProcessBar.gYQ()) {
                mMProcessBar.gYO();
            }
            Context context = MMApplicationContext.getContext();
            kotlin.g.b.p.g(context, "MMApplicationContext.getContext()");
            mMProcessBar.rotate(((float) i2) / ((float) ((int) context.getResources().getDimension(R.dimen.ca))));
        }
        AppMethodBeat.o(165947);
        return false;
    }

    @Override // com.tencent.mm.view.HeadFooterLayout.b
    public final boolean IJ(int i2) {
        AppMethodBeat.i(165948);
        AppMethodBeat.o(165948);
        return false;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, hxF = {"<anonymous>", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "kotlin.jvm.PlatformType", "invoke"})
    static final class m extends q implements kotlin.g.a.a<RefreshLoadMoreLayout> {
        final /* synthetic */ au tTi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        m(au auVar) {
            super(0);
            this.tTi = auVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ RefreshLoadMoreLayout invoke() {
            AppMethodBeat.i(244419);
            RefreshLoadMoreLayout refreshLoadMoreLayout = (RefreshLoadMoreLayout) this.tTi.hVd.findViewById(R.id.h7t);
            AppMethodBeat.o(244419);
            return refreshLoadMoreLayout;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class n extends q implements kotlin.g.a.a<Integer> {
        final /* synthetic */ au tTi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(au auVar) {
            super(0);
            this.tTi = auVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(244420);
            Integer valueOf = Integer.valueOf(com.tencent.mm.ui.au.getStatusBarHeight(this.tTi.tRl));
            AppMethodBeat.o(244420);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class d extends q implements kotlin.g.a.a<Integer> {
        final /* synthetic */ au tTi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(au auVar) {
            super(0);
            this.tTi = auVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(244404);
            Integer valueOf = Integer.valueOf(com.tencent.mm.ui.au.eu(this.tTi.tRl));
            AppMethodBeat.o(244404);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class o extends q implements kotlin.g.a.a<Integer> {
        final /* synthetic */ au tTi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(au auVar) {
            super(0);
            this.tTi = auVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Integer invoke() {
            AppMethodBeat.i(244421);
            Integer valueOf = Integer.valueOf(au.g(this.tTi) + au.h(this.tTi));
            AppMethodBeat.o(244421);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderActionBarOverlayUIC;", "invoke"})
    static final class c extends q implements kotlin.g.a.a<FinderActionBarOverlayUIC> {
        final /* synthetic */ au tTi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(au auVar) {
            super(0);
            this.tTi = auVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ FinderActionBarOverlayUIC invoke() {
            AppMethodBeat.i(244403);
            if (this.tTi.fragment == null) {
                AppMethodBeat.o(244403);
                return null;
            }
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            FinderActionBarOverlayUIC finderActionBarOverlayUIC = (FinderActionBarOverlayUIC) com.tencent.mm.ui.component.a.of(this.tTi.fragment).get(FinderActionBarOverlayUIC.class);
            AppMethodBeat.o(244403);
            return finderActionBarOverlayUIC;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class p extends q implements kotlin.g.a.a<Float> {
        final /* synthetic */ au tTi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(au auVar) {
            super(0);
            this.tTi = auVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Float invoke() {
            AppMethodBeat.i(244422);
            Float valueOf = Float.valueOf(this.tTi.tRl.getResources().getDimension(R.dimen.cr));
            AppMethodBeat.o(244422);
            return valueOf;
        }
    }

    @Override // com.tencent.mm.plugin.finder.presenter.base.c
    public final /* bridge */ /* synthetic */ MMFragmentActivity dcl() {
        return this.tRl;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class l extends q implements kotlin.g.a.a<Boolean> {
        final /* synthetic */ au tTi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        l(au auVar) {
            super(0);
            this.tTi = auVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ Boolean invoke() {
            AppMethodBeat.i(244418);
            Boolean valueOf = Boolean.valueOf(y.a(y.vXH, this.tTi.dLS, 0, 2));
            AppMethodBeat.o(244418);
            return valueOf;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "invoke"})
    static final class f extends q implements kotlin.g.a.a<RecyclerView.m> {
        final /* synthetic */ au tTi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(au auVar) {
            super(0);
            this.tTi = auVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ RecyclerView.m invoke() {
            AppMethodBeat.i(165931);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            RecyclerView.m mVar = ((FinderRecyclerViewPool) com.tencent.mm.ui.component.a.b(this.tTi.tRl).get(FinderRecyclerViewPool.class)).wuu;
            AppMethodBeat.o(165931);
            return mVar;
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "Landroid/support/v7/widget/RecyclerView$RecycledViewPool;", "invoke"})
    static final class g extends q implements kotlin.g.a.a<RecyclerView.m> {
        final /* synthetic */ au tTi;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(au auVar) {
            super(0);
            this.tTi = auVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ RecyclerView.m invoke() {
            AppMethodBeat.i(244405);
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            RecyclerView.m mVar = ((FinderRecyclerViewPool) com.tencent.mm.ui.component.a.b(this.tTi.tRl).get(FinderRecyclerViewPool.class)).wuv;
            AppMethodBeat.o(244405);
            return mVar;
        }
    }

    public static final /* synthetic */ FinderActionBarOverlayUIC b(au auVar) {
        AppMethodBeat.i(244431);
        FinderActionBarOverlayUIC finderActionBarOverlayUIC = (FinderActionBarOverlayUIC) auVar.tTc.getValue();
        AppMethodBeat.o(244431);
        return finderActionBarOverlayUIC;
    }
}
