package com.tencent.mm.plugin.finder.nearby.video;

import android.arch.lifecycle.ViewModel;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.bw.b;
import com.tencent.mm.hellhoundlib.b.c;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.e;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.model.g;
import com.tencent.mm.plugin.finder.model.h;
import com.tencent.mm.plugin.finder.nearby.video.a;
import com.tencent.mm.plugin.finder.report.k;
import com.tencent.mm.plugin.finder.utils.y;
import com.tencent.mm.plugin.finder.viewmodel.FinderHomeTabStateVM;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.protocal.protobuf.bbn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aa;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.j;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 A2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001AB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0007H\u0016J\u001a\u0010'\u001a\u00020#2\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)H\u0002J\u0010\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020\u001bH\u0016J\u000e\u0010/\u001a\b\u0012\u0004\u0012\u00020100H\u0016J\u0010\u00102\u001a\u00020#2\u0006\u00103\u001a\u00020\u0007H\u0016J\u0016\u00104\u001a\u00020#2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\u00020\u001dH\u0016J\b\u00106\u001a\u00020#H\u0016J\b\u00107\u001a\u00020#H\u0016J\b\u00108\u001a\u00020#H\u0016J\b\u00109\u001a\u00020#H\u0016J\u0016\u0010:\u001a\u00020#2\f\u0010;\u001a\b\u0012\u0004\u0012\u00020*0)H\u0016J\b\u0010<\u001a\u00020#H\u0016J\b\u0010=\u001a\u00020#H\u0016J\u000e\u0010>\u001a\u00020#2\u0006\u0010?\u001a\u00020@R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u0002\n\u0000R \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u001dX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006B"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoPresenter;", "Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoContract$Presenter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "canTimelineRefresh", "", "emptyData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderEmptyData;", "feedLoader", "Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedLoader;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoFeedLoader;", "firstAttach", "isEmptyLocation", "isRequestingLbs", "()Z", "setRequestingLbs", "(Z)V", "msgNotifyData", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderMsgNotifyData;", "tagViewActionCallback", "Lcom/tencent/mm/view/IViewActionCallback;", "tlCache", "Lcom/tencent/mm/plugin/finder/viewmodel/FinderHomeTabStateVM;", "totalDy", "", "viewCallback", "Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoContract$ViewCallback;", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoContract$ViewCallback;)V", "autoFlingToRefresh", "", "delayStart", "", "isSilence", "checkEmptyHeader", "r", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "findFirstPosition", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "getCommentScene", "getHeaderInfo", "", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$FixedViewInfo;", "onActionbarClick", "isDouble", "onAttach", "callback", "onDetach", "onFinishing", "onLoadMore", "onRefresh", "onRefreshEnd", "reason", "onUserVisibleFocused", "onUserVisibleUnFocused", "refreshRV", "data", "Landroid/content/Intent;", "Companion", "plugin-finder_release"})
public final class NearbyVideoPresenter implements a.AbstractC1247a<bo> {
    public static final Companion Companion = new Companion(null);
    public static final String TAG = "Finder.NearbyVideoPresenter";
    private byte _hellAccFlag_;
    private final MMActivity activity;
    private final boolean canTimelineRefresh = this.tlCache.JN(2);
    private g emptyData;
    private final NearbyVideoFeedLoader feedLoader;
    private boolean firstAttach;
    private boolean isEmptyLocation;
    private boolean isRequestingLbs;
    private final h msgNotifyData;
    private j tagViewActionCallback;
    private final FinderHomeTabStateVM tlCache;
    private int totalDy;
    public a.b<bo> viewCallback;

    static {
        AppMethodBeat.i(249449);
        AppMethodBeat.o(249449);
    }

    public NearbyVideoPresenter(MMActivity mMActivity) {
        p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(249448);
        this.activity = mMActivity;
        com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
        ViewModel viewModel = com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class);
        p.g(viewModel, "UICProvider.of(PluginFin…meTabStateVM::class.java)");
        this.tlCache = (FinderHomeTabStateVM) viewModel;
        e.a aVar2 = e.tYB;
        e IO = e.a.IO(2);
        int i2 = this.canTimelineRefresh ? 0 : 1;
        com.tencent.mm.ui.component.a aVar3 = com.tencent.mm.ui.component.a.PRN;
        bbn dIx = ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.activity).get(FinderReporterUIC.class)).dIx();
        dIx.tCE = getCommentScene();
        NearbyVideoFeedLoader nearbyVideoFeedLoader = new NearbyVideoFeedLoader(IO, i2, dIx);
        nearbyVideoFeedLoader.setInitDone(new NearbyVideoPresenter$$special$$inlined$apply$lambda$1(nearbyVideoFeedLoader, this));
        this.feedLoader = nearbyVideoFeedLoader;
        this.tagViewActionCallback = new NearbyVideoPresenter$tagViewActionCallback$1(this);
        this.emptyData = new g();
        this.msgNotifyData = new h();
        AppMethodBeat.o(249448);
    }

    public static final /* synthetic */ void access$checkEmptyHeader(NearbyVideoPresenter nearbyVideoPresenter, RefreshLoadMoreLayout.c cVar) {
        AppMethodBeat.i(249450);
        nearbyVideoPresenter.checkEmptyHeader(cVar);
        AppMethodBeat.o(249450);
    }

    @Override // com.tencent.mm.plugin.finder.presenter.base.a
    public final /* bridge */ /* synthetic */ void onAttach(Object obj) {
        AppMethodBeat.i(249437);
        onAttach((a.b) obj);
        AppMethodBeat.o(249437);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/nearby/video/NearbyVideoPresenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(kotlin.g.b.j jVar) {
            this();
        }
    }

    public final a.b<bo> getViewCallback() {
        AppMethodBeat.i(249431);
        a.b<bo> bVar = this.viewCallback;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        AppMethodBeat.o(249431);
        return bVar;
    }

    public final void setViewCallback(a.b<bo> bVar) {
        AppMethodBeat.i(249432);
        p.h(bVar, "<set-?>");
        this.viewCallback = bVar;
        AppMethodBeat.o(249432);
    }

    public final NearbyVideoFeedLoader getFeedLoader() {
        return this.feedLoader;
    }

    public final boolean isRequestingLbs() {
        return this.isRequestingLbs;
    }

    public final void setRequestingLbs(boolean z) {
        this.isRequestingLbs = z;
    }

    @Override // com.tencent.mm.plugin.finder.nearby.video.a.AbstractC1247a
    public final void onRefresh() {
        AppMethodBeat.i(249433);
        com.tencent.mm.plugin.finder.utils.l lVar = com.tencent.mm.plugin.finder.utils.l.vVE;
        com.tencent.mm.plugin.finder.utils.l.a(new NearbyVideoPresenter$onRefresh$1(this), new NearbyVideoPresenter$onRefresh$2(this), new NearbyVideoPresenter$onRefresh$3(this));
        AppMethodBeat.o(249433);
    }

    @Override // com.tencent.mm.plugin.finder.nearby.video.a.AbstractC1247a
    public final void onLoadMore() {
        AppMethodBeat.i(249435);
        this.feedLoader.requestLoadMore();
        AppMethodBeat.o(249435);
    }

    public final void onAttach(a.b<bo> bVar) {
        AppMethodBeat.i(249436);
        p.h(bVar, "callback");
        this.viewCallback = bVar;
        a.b<bo> bVar2 = this.viewCallback;
        if (bVar2 == null) {
            p.btv("viewCallback");
        }
        bVar2.ab(this.feedLoader.getDataListJustForAdapter());
        a.b<bo> bVar3 = this.viewCallback;
        if (bVar3 == null) {
            p.btv("viewCallback");
        }
        bVar3.getRecyclerView().a(new NearbyVideoPresenter$onAttach$1(this));
        this.feedLoader.register(this.tagViewActionCallback);
        this.firstAttach = true;
        AppMethodBeat.o(249436);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.tencent.mm.plugin.finder.nearby.video.NearbyVideoPresenter */
    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void checkEmptyHeader$default(NearbyVideoPresenter nearbyVideoPresenter, RefreshLoadMoreLayout.c cVar, int i2, Object obj) {
        AppMethodBeat.i(249439);
        if ((i2 & 1) != 0) {
            cVar = null;
        }
        nearbyVideoPresenter.checkEmptyHeader(cVar);
        AppMethodBeat.o(249439);
    }

    private final void checkEmptyHeader(RefreshLoadMoreLayout.c<Object> cVar) {
        AppMethodBeat.i(249438);
        d.h(new NearbyVideoPresenter$checkEmptyHeader$1(this, cVar));
        AppMethodBeat.o(249438);
    }

    public final void autoFlingToRefresh(long j2, boolean z) {
        AppMethodBeat.i(249440);
        a.b<bo> bVar = this.viewCallback;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        RefreshLoadMoreLayout dcQ = bVar.dcQ();
        dcQ.postDelayed(new NearbyVideoPresenter$autoFlingToRefresh$1(dcQ, z), j2);
        AppMethodBeat.o(249440);
    }

    @Override // com.tencent.mm.plugin.finder.nearby.video.a.AbstractC1247a
    public final int getCommentScene() {
        return 15;
    }

    public final void onFinishing() {
        AppMethodBeat.i(249441);
        a.b<bo> bVar = this.viewCallback;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        Log.i(TAG, "[onFinishing] position=" + findFirstPosition(bVar.getRecyclerView()) + " totalDy=" + this.totalDy);
        for (bo boVar : this.feedLoader.getDataListJustForAdapter()) {
            if (boVar instanceof BaseFinderFeed) {
                ((BaseFinderFeed) boVar).dku();
            }
        }
        FinderHomeTabStateVM.a(this.tlCache, 2, 0, this.totalDy, this.feedLoader.getDataListJustForAdapter());
        AppMethodBeat.o(249441);
    }

    public final void onActionbarClick(boolean z) {
        AppMethodBeat.i(249442);
        a.b<bo> bVar = this.viewCallback;
        if (bVar == null) {
            p.btv("viewCallback");
        }
        RecyclerView recyclerView = bVar.getRecyclerView();
        int findFirstPosition = findFirstPosition(recyclerView);
        Log.i(TAG, "[onActionbarClick] position=" + findFirstPosition + " isDouble=" + z);
        if (z) {
            if (findFirstPosition <= 12) {
                com.tencent.mm.hellhoundlib.b.a a2 = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a2.axQ(), "com/tencent/mm/plugin/finder/nearby/video/NearbyVideoPresenter", "onActionbarClick", "(Z)V", "Undefined", "smoothScrollToPosition", "(I)V");
                recyclerView.smoothScrollToPosition(((Integer) a2.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/finder/nearby/video/NearbyVideoPresenter", "onActionbarClick", "(Z)V", "Undefined", "smoothScrollToPosition", "(I)V");
            } else {
                com.tencent.mm.hellhoundlib.b.a a3 = c.a(0, new com.tencent.mm.hellhoundlib.b.a());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, a3.axQ(), "com/tencent/mm/plugin/finder/nearby/video/NearbyVideoPresenter", "onActionbarClick", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
                recyclerView.scrollToPosition(((Integer) a3.pG(0)).intValue());
                com.tencent.mm.hellhoundlib.a.a.a(recyclerView, "com/tencent/mm/plugin/finder/nearby/video/NearbyVideoPresenter", "onActionbarClick", "(Z)V", "Undefined", "scrollToPosition", "(I)V");
            }
            if (findFirstPosition <= 12) {
                autoFlingToRefresh(20, false);
            } else {
                autoFlingToRefresh(600, false);
            }
            FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
            FinderReporterUIC fH = FinderReporterUIC.a.fH(this.activity);
            if (fH != null) {
                k kVar = k.vfA;
                k.a(fH.dIx(), 5);
                AppMethodBeat.o(249442);
                return;
            }
            AppMethodBeat.o(249442);
            return;
        }
        FinderReporterUIC.a aVar2 = FinderReporterUIC.wzC;
        FinderReporterUIC fH2 = FinderReporterUIC.a.fH(this.activity);
        if (fH2 != null) {
            k kVar2 = k.vfA;
            k.a(fH2.dIx(), 1);
            AppMethodBeat.o(249442);
            return;
        }
        AppMethodBeat.o(249442);
    }

    private final int findFirstPosition(RecyclerView recyclerView) {
        AppMethodBeat.i(249443);
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            int[] iArr = new int[2];
            ((StaggeredGridLayoutManager) layoutManager).n(iArr);
            int i2 = iArr[0];
            AppMethodBeat.o(249443);
            return i2;
        } else if (layoutManager instanceof LinearLayoutManager) {
            int ks = ((LinearLayoutManager) layoutManager).ks();
            AppMethodBeat.o(249443);
            return ks;
        } else {
            AppMethodBeat.o(249443);
            return 0;
        }
    }

    @Override // com.tencent.mm.plugin.finder.presenter.base.a
    public final void onDetach() {
        AppMethodBeat.i(249444);
        this.feedLoader.unregister(this.tagViewActionCallback);
        NearbyVideoFeedLoader nearbyVideoFeedLoader = this.feedLoader;
        if (nearbyVideoFeedLoader == null) {
            p.hyc();
        }
        if (nearbyVideoFeedLoader.getDataListJustForAdapter().size() > 0) {
            com.tencent.mm.ui.component.a aVar = com.tencent.mm.ui.component.a.PRN;
            ((FinderHomeTabStateVM) com.tencent.mm.ui.component.a.bi(PluginFinder.class).get(FinderHomeTabStateVM.class)).Mp(2);
        }
        this.firstAttach = false;
        AppMethodBeat.o(249444);
    }

    public final List<g.b> getHeaderInfo() {
        AppMethodBeat.i(249445);
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
        this.msgNotifyData.count = i2 + i3 + i4 + aAh4.azQ().getInt(ar.a.USERINFO_FINDER_WX_MENTION_OBJECT_RECOMMEND_LIKE_INT_SYNC, 0);
        h hVar = this.msgNotifyData;
        com.tencent.mm.kernel.e aAh5 = com.tencent.mm.kernel.g.aAh();
        p.g(aAh5, "MMKernel.storage()");
        Object obj = aAh5.azQ().get(ar.a.USERINFO_FINDER_WX_MENTION_AVATAR_STRING_SYNC, "");
        if (obj == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.String");
            AppMethodBeat.o(249445);
            throw tVar;
        }
        hVar.setAvatar((String) obj);
        linkedList.add(this.msgNotifyData);
        LinkedList linkedList2 = linkedList;
        AppMethodBeat.o(249445);
        return linkedList2;
    }

    public final void onUserVisibleFocused() {
        AppMethodBeat.i(249446);
        if (this.firstAttach) {
            com.tencent.mm.plugin.finder.utils.l lVar = com.tencent.mm.plugin.finder.utils.l.vVE;
            if (com.tencent.mm.plugin.finder.utils.l.dBJ()) {
                BaseFeedLoader.requestInit$default(this.feedLoader, false, 1, null);
            } else {
                RefreshLoadMoreLayout.c<Object> cVar = new RefreshLoadMoreLayout.c<>(0);
                cVar.Rmh = -2;
                checkEmptyHeader(cVar);
            }
            this.firstAttach = false;
        }
        AppMethodBeat.o(249446);
    }

    public final void onUserVisibleUnFocused() {
    }

    public final void refreshRV(Intent intent) {
        RecyclerView recyclerView;
        b bVar;
        AppMethodBeat.i(249447);
        p.h(intent, "data");
        a.b<bo> bVar2 = this.viewCallback;
        if (bVar2 == null) {
            p.btv("viewCallback");
        }
        if (bVar2 == null || (recyclerView = bVar2.getRecyclerView()) == null) {
            AppMethodBeat.o(249447);
            return;
        }
        y yVar = y.vXH;
        com.tencent.mm.plugin.finder.feed.model.h a2 = y.a(intent, recyclerView, (BaseFeedLoader<bo>) this.feedLoader, false, (kotlin.g.a.b<? super bo, Boolean>) NearbyVideoPresenter$refreshRV$1$backCache$1.INSTANCE);
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        p.g(aAh, "MMKernel.storage()");
        ao azQ = aAh.azQ();
        y yVar2 = y.vXH;
        azQ.set(y.LK(2), Util.encodeHexString((a2 == null || (bVar = a2.lastBuffer) == null) ? null : bVar.toByteArray()));
        AppMethodBeat.o(249447);
    }

    @Override // com.tencent.mm.plugin.finder.nearby.video.a.AbstractC1247a
    public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> cVar) {
        View loadMoreFooter;
        View findViewById;
        View loadMoreFooter2;
        TextView textView;
        AppMethodBeat.i(249434);
        p.h(cVar, "reason");
        if (cVar.Rmk <= 0) {
            a.b<bo> bVar = this.viewCallback;
            if (bVar == null) {
                p.btv("viewCallback");
            }
            bVar.dcQ().b(0, NearbyVideoPresenter$onRefreshEnd$1.INSTANCE);
        }
        if (cVar.Rmj) {
            a.b<bo> bVar2 = this.viewCallback;
            if (bVar2 == null) {
                p.btv("viewCallback");
            }
            RefreshLoadMoreLayout dcQ = bVar2.dcQ();
            if (!(dcQ != null ? Boolean.valueOf(dcQ.RlV) : null).booleanValue()) {
                a.b<bo> bVar3 = this.viewCallback;
                if (bVar3 == null) {
                    p.btv("viewCallback");
                }
                RefreshLoadMoreLayout dcQ2 = bVar3.dcQ();
                if (dcQ2 != null) {
                    dcQ2.setHasBottomMore(true);
                }
                a.b<bo> bVar4 = this.viewCallback;
                if (bVar4 == null) {
                    p.btv("viewCallback");
                }
                RefreshLoadMoreLayout dcQ3 = bVar4.dcQ();
                if (!(dcQ3 == null || (loadMoreFooter2 = dcQ3.getLoadMoreFooter()) == null || (textView = (TextView) loadMoreFooter2.findViewById(R.id.ep1)) == null)) {
                    textView.setVisibility(0);
                }
                a.b<bo> bVar5 = this.viewCallback;
                if (bVar5 == null) {
                    p.btv("viewCallback");
                }
                RefreshLoadMoreLayout dcQ4 = bVar5.dcQ();
                if (!(dcQ4 == null || (loadMoreFooter = dcQ4.getLoadMoreFooter()) == null || (findViewById = loadMoreFooter.findViewById(R.id.ep0)) == null)) {
                    findViewById.setVisibility(8);
                }
            }
            a.b<bo> bVar6 = this.viewCallback;
            if (bVar6 == null) {
                p.btv("viewCallback");
            }
            RefreshLoadMoreLayout dcQ5 = bVar6.dcQ();
            if (!(dcQ5 != null ? Boolean.valueOf(dcQ5.getEnableLoadMore()) : null).booleanValue()) {
                a.b<bo> bVar7 = this.viewCallback;
                if (bVar7 == null) {
                    p.btv("viewCallback");
                }
                RefreshLoadMoreLayout dcQ6 = bVar7.dcQ();
                if (dcQ6 != null) {
                    dcQ6.setEnableLoadMore(true);
                }
                a.b<bo> bVar8 = this.viewCallback;
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
        ((PluginFinder) ah).getRedDotManager().asV("finder_tl_nearby_tab");
        com.tencent.mm.kernel.b.a ah2 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
        p.g(ah2, "MMKernel.plugin(PluginFinder::class.java)");
        ((PluginFinder) ah2).getRedDotManager().gI("finder_tl_nearby_tab", "onRefreshEnd");
        i.a aVar = i.tLi;
        com.tencent.mm.ui.component.a aVar2 = com.tencent.mm.ui.component.a.PRN;
        i.a.b(2, ((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.activity).get(FinderReporterUIC.class)).dIx());
        com.tencent.mm.kernel.b.a ah3 = com.tencent.mm.kernel.g.ah(PluginFinder.class);
        p.g(ah3, "MMKernel.plugin(PluginFinder::class.java)");
        ((PluginFinder) ah3).getRedDotManager().asV("NearbyFeedTab");
        AppMethodBeat.o(249434);
    }
}
