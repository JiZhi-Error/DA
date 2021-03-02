package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.feed.model.BaseFinderFeedLoader;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.storage.ah;
import com.tencent.mm.plugin.finder.storage.al;
import com.tencent.mm.plugin.finder.view.FinderLikeDrawer;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.j;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.g;
import com.tencent.mm.view.recyclerview.h;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract;", "", "()V", "Presenter", "ViewCallback", "plugin-finder_release"})
public final class c {

    @l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00040\u0003B%\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\b\u0010\u001c\u001a\u00020\u001dH&J\n\u0010\u001e\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u001f\u001a\u00020 H&J\u0012\u0010!\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010#\u001a\u00020 H\u0016J\b\u0010$\u001a\u00020 H&J\u0010\u0010%\u001a\u00020 2\u0006\u0010&\u001a\u00020\u0002H\u0016J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020 H\u0016J\b\u0010*\u001a\u00020 H\u0016J\b\u0010+\u001a\u00020 H\u0016J\b\u0010,\u001a\u00020 H&R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006-"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Lcom/tencent/mm/vending/lifecycle/ILifeCycle;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "feedLoader", "Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "(Lcom/tencent/mm/ui/MMActivity;IILcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;)V", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "getFeedLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/BaseFinderFeedLoader;", "proxyRLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "getProxyRLayout", "()Lcom/tencent/mm/view/IViewActionCallback;", "setProxyRLayout", "(Lcom/tencent/mm/view/IViewActionCallback;)V", "viewCallback", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;)V", "buildItemCoverts", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getIViewActionCallback", "initViewCallback", "", "keep", "p0", "loadInitData", "loadMoreData", "onAttach", "callback", "onBackPressed", "", "onDetach", "onUIPause", "onUIResume", "requestRefresh", "plugin-finder_release"})
    public static abstract class a implements com.tencent.mm.plugin.finder.presenter.base.a<b>, com.tencent.mm.vending.e.b<com.tencent.mm.vending.e.a> {
        final MMActivity gte;
        public final BaseFinderFeedLoader tFM;
        public b tMd;
        private j tMe = new j(this) {
            /* class com.tencent.mm.plugin.finder.feed.c.a.AnonymousClass1 */
            final /* synthetic */ a tMf;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.tMf = r1;
            }

            @Override // com.tencent.mm.view.i
            public final void onPreFinishRefresh(RefreshLoadMoreLayout.c<Object> cVar) {
                RefreshLoadMoreLayout refreshLoadMoreLayout;
                AppMethodBeat.i(243685);
                p.h(cVar, "reason");
                b bVar = this.tMf.tMd;
                if (bVar == null || (refreshLoadMoreLayout = bVar.tLS) == null) {
                    AppMethodBeat.o(243685);
                    return;
                }
                refreshLoadMoreLayout.onPreFinishRefresh(cVar);
                AppMethodBeat.o(243685);
            }

            @Override // com.tencent.mm.view.i
            public final void onPreFinishLoadMore(RefreshLoadMoreLayout.c<Object> cVar) {
                RefreshLoadMoreLayout refreshLoadMoreLayout;
                AppMethodBeat.i(243686);
                p.h(cVar, "reason");
                b bVar = this.tMf.tMd;
                if (bVar == null || (refreshLoadMoreLayout = bVar.tLS) == null) {
                    AppMethodBeat.o(243686);
                    return;
                }
                refreshLoadMoreLayout.onPreFinishLoadMore(cVar);
                AppMethodBeat.o(243686);
            }

            @Override // com.tencent.mm.view.i
            public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.c<Object> cVar) {
                RefreshLoadMoreLayout refreshLoadMoreLayout;
                AppMethodBeat.i(243687);
                p.h(cVar, "reason");
                b bVar = this.tMf.tMd;
                if (bVar == null || (refreshLoadMoreLayout = bVar.tLS) == null) {
                    AppMethodBeat.o(243687);
                    return;
                }
                refreshLoadMoreLayout.onPreFinishLoadMoreSmooth(cVar);
                AppMethodBeat.o(243687);
            }

            @Override // com.tencent.mm.view.j
            public final void onChanged() {
                RefreshLoadMoreLayout refreshLoadMoreLayout;
                AppMethodBeat.i(243688);
                b bVar = this.tMf.tMd;
                if (bVar == null || (refreshLoadMoreLayout = bVar.tLS) == null) {
                    AppMethodBeat.o(243688);
                    return;
                }
                refreshLoadMoreLayout.onChanged();
                AppMethodBeat.o(243688);
            }

            @Override // com.tencent.mm.view.j
            public final void onItemRangeChanged(int i2, int i3) {
                RefreshLoadMoreLayout refreshLoadMoreLayout;
                int i4;
                WxRecyclerAdapter<?> adapter;
                AppMethodBeat.i(243689);
                b bVar = this.tMf.tMd;
                if (bVar == null || (refreshLoadMoreLayout = bVar.tLS) == null) {
                    AppMethodBeat.o(243689);
                    return;
                }
                b bVar2 = this.tMf.tMd;
                if (bVar2 == null || (adapter = bVar2.getAdapter()) == null) {
                    i4 = 0;
                } else {
                    i4 = adapter.RqM.size();
                }
                refreshLoadMoreLayout.onItemRangeChanged(i4 + i2, i3);
                AppMethodBeat.o(243689);
            }

            @Override // com.tencent.mm.view.j
            public final void onItemRangeChanged(int i2, int i3, Object obj) {
                RefreshLoadMoreLayout refreshLoadMoreLayout;
                int i4;
                WxRecyclerAdapter<?> adapter;
                AppMethodBeat.i(243690);
                b bVar = this.tMf.tMd;
                if (bVar == null || (refreshLoadMoreLayout = bVar.tLS) == null) {
                    AppMethodBeat.o(243690);
                    return;
                }
                b bVar2 = this.tMf.tMd;
                if (bVar2 == null || (adapter = bVar2.getAdapter()) == null) {
                    i4 = 0;
                } else {
                    i4 = adapter.RqM.size();
                }
                refreshLoadMoreLayout.onItemRangeChanged(i4 + i2, i3, obj);
                AppMethodBeat.o(243690);
            }

            @Override // com.tencent.mm.view.j
            public final void onItemRangeInserted(int i2, int i3) {
                RefreshLoadMoreLayout refreshLoadMoreLayout;
                int i4;
                WxRecyclerAdapter<?> adapter;
                AppMethodBeat.i(243691);
                b bVar = this.tMf.tMd;
                if (bVar == null || (refreshLoadMoreLayout = bVar.tLS) == null) {
                    AppMethodBeat.o(243691);
                    return;
                }
                b bVar2 = this.tMf.tMd;
                if (bVar2 == null || (adapter = bVar2.getAdapter()) == null) {
                    i4 = 0;
                } else {
                    i4 = adapter.RqM.size();
                }
                refreshLoadMoreLayout.onItemRangeInserted(i4 + i2, i3);
                AppMethodBeat.o(243691);
            }

            @Override // com.tencent.mm.view.j
            public final void onItemRangeRemoved(int i2, int i3) {
                RefreshLoadMoreLayout refreshLoadMoreLayout;
                int i4;
                WxRecyclerAdapter<?> adapter;
                AppMethodBeat.i(243692);
                b bVar = this.tMf.tMd;
                if (!(bVar == null || (refreshLoadMoreLayout = bVar.tLS) == null)) {
                    b bVar2 = this.tMf.tMd;
                    if (bVar2 == null || (adapter = bVar2.getAdapter()) == null) {
                        i4 = 0;
                    } else {
                        i4 = adapter.RqM.size();
                    }
                    refreshLoadMoreLayout.onItemRangeRemoved(i4 + i2, i3);
                }
                b bVar3 = this.tMf.tMd;
                if (bVar3 != null) {
                    bVar3.dcv();
                    AppMethodBeat.o(243692);
                    return;
                }
                AppMethodBeat.o(243692);
            }
        };

        public abstract void boE();

        public abstract void dcb();

        public abstract f dce();

        public abstract void requestRefresh();

        public a(MMActivity mMActivity, BaseFinderFeedLoader baseFinderFeedLoader) {
            p.h(mMActivity, "context");
            p.h(baseFinderFeedLoader, "feedLoader");
            this.gte = mMActivity;
            this.tFM = baseFinderFeedLoader;
        }

        public j dco() {
            return null;
        }

        /* renamed from: a */
        public void onAttach(b bVar) {
            p.h(bVar, "callback");
            this.tMd = bVar;
            BaseFinderFeedLoader baseFinderFeedLoader = this.tFM;
            j dco = dco();
            if (dco == null) {
                dco = this.tMe;
            }
            baseFinderFeedLoader.register(dco);
            dcb();
        }

        @Override // com.tencent.mm.plugin.finder.presenter.base.a
        public void onDetach() {
            BaseFinderFeedLoader baseFinderFeedLoader = this.tFM;
            j dco = dco();
            if (dco == null) {
                dco = this.tMe;
            }
            baseFinderFeedLoader.unregister(dco);
        }

        public final boolean onBackPressed() {
            b bVar = this.tMd;
            if (bVar == null) {
                p.hyc();
            }
            FinderLikeDrawer dcj = bVar.dcj();
            if (dcj == null) {
                p.hyc();
            }
            if (!dcj.dGs()) {
                return false;
            }
            b bVar2 = this.tMd;
            if (bVar2 == null) {
                p.hyc();
            }
            FinderLikeDrawer dcj2 = bVar2.dcj();
            if (dcj2 == null) {
                p.hyc();
            }
            dcj2.dGr();
            return true;
        }

        @Override // com.tencent.mm.vending.e.b
        public void keep(com.tencent.mm.vending.e.a aVar) {
        }

        public void dcp() {
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\b&\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001f\u0010?\u001a\u0002H@\"\b\b\u0000\u0010@*\u00020*2\u0006\u0010A\u001a\u00020\u0006H\u0004¢\u0006\u0002\u0010BJ\n\u0010C\u001a\u0006\u0012\u0002\b\u00030\u0010J\u0018\u0010D\u001a\u0004\u0018\u00010\f2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020G0FH&J\n\u0010H\u001a\u0004\u0018\u00010*H&J\n\u0010I\u001a\u0004\u0018\u00010*H&J\b\u0010J\u001a\u00020KH&J\u0010\u0010L\u001a\u00020\u001e2\u0006\u0010\u0003\u001a\u00020MH&J\b\u0010N\u001a\u00020\u0002H\u0016J\b\u0010O\u001a\u00020PH\u0016J\u0006\u0010Q\u001a\u00020RJ\n\u0010S\u001a\u0004\u0018\u00010*H\u0016J\u0018\u0010T\u001a\u0004\u0018\u00010\f2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020G0FH&J \u0010U\u001a\u00020V2\u0016\u0010W\u001a\u0012\u0012\u0004\u0012\u00020Y0Xj\b\u0012\u0004\u0012\u00020Y`ZH\u0016J\u0018\u0010[\u001a\u00020V2\u0006\u0010\\\u001a\u00020]2\u0006\u0010^\u001a\u00020\u0006H\u0016J$\u0010_\u001a\u00020V2\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030`2\u0006\u0010a\u001a\u00020*2\u0006\u0010^\u001a\u00020\u0006H&J\b\u0010b\u001a\u00020VH&J\u0016\u0010c\u001a\u00020V2\f\u0010E\u001a\b\u0012\u0004\u0012\u00020G0FH\u0016J\b\u0010d\u001a\u00020VH\u0016J\u0010\u0010e\u001a\u00020\t2\u0006\u0010\\\u001a\u00020]H\u0016J\b\u0010f\u001a\u00020\tH\u0016J\u0006\u0010g\u001a\u00020VJ\b\u0010h\u001a\u00020VH\u0016J\u0010\u0010i\u001a\u00020V2\u0006\u0010j\u001a\u00020*H\u0002J\b\u0010k\u001a\u00020\tH\u0016R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0006XD¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010X.¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\u001eX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020$X.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u00020\u0002X.¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u00104\u001a\u000205X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0014R\u001a\u0010;\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0014\"\u0004\b=\u0010>¨\u0006l"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "context", "Lcom/tencent/mm/ui/MMActivity;", "scene", "", "commentScene", "commentSafeMode", "", "(Lcom/tencent/mm/ui/MMActivity;IIZ)V", "TAG", "", "VIEW_TYPE_FOOTER", "VIEW_TYPE_HEADER", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getCommentSafeMode", "()Z", "getCommentScene", "()I", "config", "Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "getConfig", "()Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;", "setConfig", "(Lcom/tencent/mm/plugin/finder/storage/IFinderLayoutConfig;)V", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "finderManager", "Landroid/support/v7/widget/RecyclerView$LayoutManager;", "getFinderManager", "()Landroid/support/v7/widget/RecyclerView$LayoutManager;", "setFinderManager", "(Landroid/support/v7/widget/RecyclerView$LayoutManager;)V", "friendLikeDrawer", "Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "getFriendLikeDrawer", "()Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;", "setFriendLikeDrawer", "(Lcom/tencent/mm/plugin/finder/view/FinderLikeDrawer;)V", "headerview", "Landroid/view/View;", "getHeaderview", "()Landroid/view/View;", "setHeaderview", "(Landroid/view/View;)V", "present", "getPresent", "()Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;", "setPresent", "(Lcom/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$Presenter;)V", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "getScene", "spanCount", "getSpanCount", "setSpanCount", "(I)V", "findViewById", "T", "id", "(I)Landroid/view/View;", "getAdapter", "getDescStringID", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "getEmptyView", "getHeaderView", "getItemDecoration", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "getLayoutManager", "Landroid/content/Context;", "getPresenter", "getRecyclerView", "Landroid/support/v7/widget/RecyclerView;", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "getRootView", "getTitleStringId", "initView", "", "data", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "Lkotlin/collections/ArrayList;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "onGridItemClick", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "onItemDelete", "onTopicOnRefreshEnd", "onViewPrepared", "otherFullSpan", "refreshWhenEnter", "requestLoadMore", "showEmptyView", "showEmptyViewInternal", "emptyView", "showHeaderOnDataEmpty", "plugin-finder_release"})
    public static abstract class b implements com.tencent.mm.plugin.finder.presenter.base.c<a> {
        private final String TAG;
        int att;
        final MMActivity gte;
        private final int scene;
        private final int tCE;
        private WxRecyclerAdapter<?> tFp;
        public RefreshLoadMoreLayout tLS;
        public FinderLikeDrawer tLV;
        private final boolean tLZ;
        public a tMg;
        final int tMh;
        final int tMi;
        private al tMj;
        public RecyclerView.LayoutManager tMk;
        public View tMl;

        public abstract void a(RecyclerView.a<?> aVar, View view, int i2);

        public abstract String b(RefreshLoadMoreLayout.c<Object> cVar);

        public abstract String c(RefreshLoadMoreLayout.c<Object> cVar);

        public abstract void dcv();

        public abstract RecyclerView.LayoutManager eS(Context context);

        public abstract View getEmptyView();

        public abstract View getHeaderView();

        public abstract RecyclerView.h getItemDecoration();

        public /* synthetic */ b(MMActivity mMActivity, int i2, int i3) {
            this(mMActivity, i2, i3, false);
        }

        public b(MMActivity mMActivity, int i2, int i3, boolean z) {
            p.h(mMActivity, "context");
            this.gte = mMActivity;
            this.scene = i2;
            this.tCE = i3;
            this.tLZ = z;
            this.TAG = "Finder.FinderBaseGridFeedUIContract.ViewCallback";
            this.att = 3;
            this.tLS = (RefreshLoadMoreLayout) findViewById(R.id.h7t);
            this.tMi = -1;
            this.tMj = new ah();
        }

        public final a dcq() {
            a aVar = this.tMg;
            if (aVar == null) {
                p.btv("present");
            }
            return aVar;
        }

        public final void setRlLayout(RefreshLoadMoreLayout refreshLoadMoreLayout) {
            p.h(refreshLoadMoreLayout, "<set-?>");
            this.tLS = refreshLoadMoreLayout;
        }

        public final void a(a aVar) {
            p.h(aVar, "<set-?>");
            this.tMg = aVar;
        }

        public final a dcr() {
            a aVar = this.tMg;
            if (aVar == null) {
                p.btv("present");
            }
            return aVar;
        }

        public final FinderLikeDrawer dcj() {
            FinderLikeDrawer finderLikeDrawer = this.tLV;
            if (finderLikeDrawer == null) {
                p.btv("friendLikeDrawer");
            }
            return finderLikeDrawer;
        }

        public al dcs() {
            return this.tMj;
        }

        /* access modifiers changed from: protected */
        public final <T extends View> T findViewById(int i2) {
            T t;
            View rootView = getRootView();
            if (rootView != null && (t = (T) rootView.findViewById(i2)) != null) {
                return t;
            }
            T t2 = (T) this.gte.findViewById(i2);
            p.g(t2, "context.findViewById(id)");
            return t2;
        }

        public final void dbY() {
            com.tencent.mm.ac.d.a(com.tencent.mm.ac.d.aBx(), new d(this));
        }

        public boolean dct() {
            return true;
        }

        public boolean l(h hVar) {
            p.h(hVar, "holder");
            return false;
        }

        public void ab(ArrayList<bo> arrayList) {
            p.h(arrayList, "data");
            RecyclerView recyclerView = this.tLS.getRecyclerView();
            this.tMk = eS(this.gte);
            FinderLikeDrawer.a aVar = FinderLikeDrawer.wnm;
            Window window = this.gte.getWindow();
            p.g(window, "context.window");
            FinderLikeDrawer.a aVar2 = FinderLikeDrawer.wnm;
            this.tLV = FinderLikeDrawer.a.a(this.gte, window, FinderLikeDrawer.dGP());
            RecyclerView.LayoutManager layoutManager = this.tMk;
            if (layoutManager == null) {
                p.btv("finderManager");
            }
            recyclerView.setLayoutManager(layoutManager);
            this.tFp = new a(this, arrayList, dcq().dce(), arrayList);
            WxRecyclerAdapter<?> wxRecyclerAdapter = this.tFp;
            if (wxRecyclerAdapter == null) {
                p.btv("adapter");
            }
            recyclerView.setAdapter(wxRecyclerAdapter);
            recyclerView.b(getItemDecoration());
            WxRecyclerAdapter<?> wxRecyclerAdapter2 = this.tFp;
            if (wxRecyclerAdapter2 == null) {
                p.btv("adapter");
            }
            wxRecyclerAdapter2.RqP = new C1138b(this);
            this.tMl = getHeaderView();
            if (this.tMl != null) {
                WxRecyclerAdapter<?> wxRecyclerAdapter3 = this.tFp;
                if (wxRecyclerAdapter3 == null) {
                    p.btv("adapter");
                }
                if (wxRecyclerAdapter3 != null) {
                    View view = this.tMl;
                    if (view == null) {
                        p.hyc();
                    }
                    g.b unused = wxRecyclerAdapter3.f(view, this.tMh, true);
                }
            }
            this.tLS.setActionCallback(new C1139c(this));
            com.tencent.mm.ui.component.a aVar3 = com.tencent.mm.ui.component.a.PRN;
            com.tencent.mm.plugin.finder.event.base.f d2 = FinderReporterUIC.d((FinderReporterUIC) com.tencent.mm.ui.component.a.b(this.gte).get(FinderReporterUIC.class));
            if (d2 != null) {
                d2.m(recyclerView);
            }
            dbY();
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J&\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\u0010"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$1", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onBindFirstBodyViewHolder", "", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "onBindViewHolder", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "", "payloads", "", "", "onViewAttachedToWindow", "plugin-finder_release"})
        public static final class a extends WxRecyclerAdapter<bo> {
            final /* synthetic */ b tMm;
            final /* synthetic */ ArrayList tMn;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(b bVar, ArrayList arrayList, f fVar, ArrayList arrayList2) {
                super(fVar, arrayList2);
                this.tMm = bVar;
                this.tMn = arrayList;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$v, int, java.util.List] */
            @Override // com.tencent.mm.view.recyclerview.g, android.support.v7.widget.RecyclerView.a
            public final /* synthetic */ void a(h hVar, int i2, List list) {
                AppMethodBeat.i(243696);
                h hVar2 = hVar;
                p.h(hVar2, "holder");
                p.h(list, "payloads");
                super.a(hVar2, i2, list);
                this.tMm.m(hVar2);
                AppMethodBeat.o(243696);
            }

            @Override // com.tencent.mm.view.recyclerview.WxRecyclerAdapter, android.support.v7.widget.RecyclerView.a
            public final /* synthetic */ void k(RecyclerView.v vVar) {
                AppMethodBeat.i(243694);
                n((h) vVar);
                AppMethodBeat.o(243694);
            }

            @Override // com.tencent.mm.view.recyclerview.WxRecyclerAdapter
            public final void n(h hVar) {
                AppMethodBeat.i(243693);
                p.h(hVar, "holder");
                super.n(hVar);
                View view = hVar.aus;
                p.g(view, "holder.itemView");
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams != null && (layoutParams instanceof StaggeredGridLayoutManager.LayoutParams)) {
                    if (hVar.lU() == this.tMm.tMh || hVar.lU() == this.tMm.tMi) {
                        ((StaggeredGridLayoutManager.LayoutParams) layoutParams).aC(true);
                        AppMethodBeat.o(243693);
                        return;
                    } else if (this.tMm.l(hVar)) {
                        ((StaggeredGridLayoutManager.LayoutParams) layoutParams).aC(true);
                    }
                }
                AppMethodBeat.o(243693);
            }

            @Override // com.tencent.mm.view.recyclerview.WxRecyclerAdapter
            public final void n(RecyclerView recyclerView) {
                com.tencent.mm.plugin.finder.event.base.f d2;
                AppMethodBeat.i(243695);
                p.h(recyclerView, "recyclerView");
                FinderReporterUIC.a aVar = FinderReporterUIC.wzC;
                FinderReporterUIC fH = FinderReporterUIC.a.fH(this.tMm.gte);
                if (fH == null || (d2 = FinderReporterUIC.d(fH)) == null) {
                    AppMethodBeat.o(243695);
                    return;
                }
                d2.dap().onScrollStateChanged(recyclerView, 5);
                AppMethodBeat.o(243695);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J.\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0002H\u0016¨\u0006\f"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$2", "Lcom/tencent/mm/view/recyclerview/RecyclerViewAdapterEx$OnItemClickListener;", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "onItemClick", "", "adapter", "Landroid/support/v7/widget/RecyclerView$Adapter;", "view", "Landroid/view/View;", "position", "", "holder", "plugin-finder_release"})
        /* renamed from: com.tencent.mm.plugin.finder.feed.c$b$b  reason: collision with other inner class name */
        public static final class C1138b implements g.c<h> {
            final /* synthetic */ b tMm;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            C1138b(b bVar) {
                this.tMm = bVar;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [android.support.v7.widget.RecyclerView$a, android.view.View, int, android.support.v7.widget.RecyclerView$v] */
            @Override // com.tencent.mm.view.recyclerview.g.c
            public final /* synthetic */ void a(RecyclerView.a<h> aVar, View view, int i2, h hVar) {
                AppMethodBeat.i(243697);
                p.h(aVar, "adapter");
                p.h(view, "view");
                p.h(hVar, "holder");
                this.tMm.a(aVar, view, i2);
                AppMethodBeat.o(243697);
            }
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J\u0016\u0010\r\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\u0016\u0010\u0013\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, hxF = {"com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback;", "firstChange", "", "getFirstChange", "()Z", "setFirstChange", "(Z)V", "onItemChange", "", "changeItemCount", "", "onLoadMoreBegin", "onLoadMoreEnd", "reason", "Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;", "", "onRefreshBegin", "refreshType", "onRefreshEnd", "plugin-finder_release"})
        /* renamed from: com.tencent.mm.plugin.finder.feed.c$b$c  reason: collision with other inner class name */
        public static final class C1139c extends RefreshLoadMoreLayout.a {
            private boolean tMa = true;
            final /* synthetic */ b tMm;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            C1139c(b bVar) {
                this.tMm = bVar;
            }

            @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
            public final void onRefreshEnd(RefreshLoadMoreLayout.c<Object> cVar) {
                int i2;
                AppMethodBeat.i(243702);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(cVar);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
                p.h(cVar, "reason");
                super.onRefreshEnd(cVar);
                View emptyView = this.tMm.getEmptyView();
                if (emptyView != null) {
                    RecyclerView.a adapter = this.tMm.tLS.getRecyclerView().getAdapter();
                    if (!(adapter instanceof WxRecyclerAdapter)) {
                        adapter = null;
                    }
                    WxRecyclerAdapter wxRecyclerAdapter = (WxRecyclerAdapter) adapter;
                    if (cVar.Rmh != -1) {
                        if (wxRecyclerAdapter != null) {
                            i2 = wxRecyclerAdapter.hgt();
                        } else {
                            i2 = 0;
                        }
                        if (i2 > 0 || this.tMm.dcu()) {
                            emptyView.setVisibility(8);
                            View view = this.tMm.tMl;
                            if (view != null) {
                                TextView textView = (TextView) view.findViewById(R.id.ipm);
                                if (textView != null) {
                                    textView.setText(this.tMm.b(cVar));
                                }
                                TextView textView2 = (TextView) view.findViewById(R.id.bmr);
                                if (textView2 != null) {
                                    textView2.setText(this.tMm.c(cVar));
                                }
                            }
                            RefreshLoadMoreLayout refreshLoadMoreLayout = this.tMm.tLS;
                            if (refreshLoadMoreLayout != null) {
                                refreshLoadMoreLayout.setVisibility(0);
                            }
                        } else {
                            this.tMm.bIo();
                        }
                    } else {
                        emptyView.setVisibility(0);
                        RefreshLoadMoreLayout refreshLoadMoreLayout2 = this.tMm.tLS;
                        if (refreshLoadMoreLayout2 != null) {
                            refreshLoadMoreLayout2.setVisibility(8);
                        }
                        TextView textView3 = (TextView) emptyView.findViewById(R.id.c35);
                        if (textView3 != null) {
                            textView3.setVisibility(8);
                        }
                        TextView textView4 = (TextView) emptyView.findViewById(R.id.h5w);
                        if (textView4 != null) {
                            textView4.setVisibility(0);
                        }
                        View findViewById = emptyView.findViewById(R.id.gl7);
                        if (findViewById != null) {
                            findViewById.setVisibility(8);
                        }
                        View findViewById2 = emptyView.findViewById(R.id.h5w);
                        if (findViewById2 != null) {
                            findViewById2.setOnClickListener(new View$OnClickListenerC1141c(emptyView, this, cVar));
                        }
                    }
                }
                this.tMm.j(cVar);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
                AppMethodBeat.o(243702);
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4$onRefreshEnd$1$2"})
            /* renamed from: com.tencent.mm.plugin.finder.feed.c$b$c$c  reason: collision with other inner class name */
            static final class View$OnClickListenerC1141c implements View.OnClickListener {
                final /* synthetic */ View tCl;
                final /* synthetic */ C1139c tMo;
                final /* synthetic */ RefreshLoadMoreLayout.c tMp;

                View$OnClickListenerC1141c(View view, C1139c cVar, RefreshLoadMoreLayout.c cVar2) {
                    this.tCl = view;
                    this.tMo = cVar;
                    this.tMp = cVar2;
                }

                public final void onClick(View view) {
                    AppMethodBeat.i(243701);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4$onRefreshEnd$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    p.g(view, LocaleUtil.ITALIAN);
                    view.setVisibility(8);
                    View findViewById = this.tCl.findViewById(R.id.gl7);
                    if (findViewById != null) {
                        findViewById.setVisibility(0);
                    }
                    com.tencent.f.h.RTc.aX(new Runnable(this) {
                        /* class com.tencent.mm.plugin.finder.feed.c.b.C1139c.View$OnClickListenerC1141c.AnonymousClass1 */
                        final /* synthetic */ View$OnClickListenerC1141c tMq;

                        {
                            this.tMq = r1;
                        }

                        public final void run() {
                            AppMethodBeat.i(243700);
                            this.tMq.tMo.tMm.dcr().requestRefresh();
                            AppMethodBeat.o(243700);
                        }
                    });
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4$onRefreshEnd$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(243701);
                }
            }

            @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
            public final void ED(int i2) {
                View emptyView;
                AppMethodBeat.i(243703);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.pH(i2);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V", this, bVar.axR());
                super.ED(i2);
                if (this.tMm.dcq().tFM.getSize() == 0 && (emptyView = this.tMm.getEmptyView()) != null) {
                    emptyView.setVisibility(0);
                    RefreshLoadMoreLayout refreshLoadMoreLayout = this.tMm.tLS;
                    if (refreshLoadMoreLayout != null) {
                        refreshLoadMoreLayout.setVisibility(8);
                    }
                    View findViewById = emptyView.findViewById(R.id.gl7);
                    if (findViewById != null) {
                        findViewById.setVisibility(0);
                    }
                }
                com.tencent.f.h.RTc.aX(new RunnableC1140b(this));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onRefreshBegin", "(I)V");
                AppMethodBeat.o(243703);
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
            /* renamed from: com.tencent.mm.plugin.finder.feed.c$b$c$b  reason: collision with other inner class name */
            static final class RunnableC1140b implements Runnable {
                final /* synthetic */ C1139c tMo;

                RunnableC1140b(C1139c cVar) {
                    this.tMo = cVar;
                }

                public final void run() {
                    AppMethodBeat.i(243699);
                    this.tMo.tMm.dcr().requestRefresh();
                    AppMethodBeat.o(243699);
                }
            }

            @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
            public final void cxo() {
                AppMethodBeat.i(243704);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V", this);
                super.cxo();
                com.tencent.f.h.RTc.aX(new a(this));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreBegin", "()V");
                AppMethodBeat.o(243704);
            }

            @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
            /* renamed from: com.tencent.mm.plugin.finder.feed.c$b$c$a */
            static final class a implements Runnable {
                final /* synthetic */ C1139c tMo;

                a(C1139c cVar) {
                    this.tMo = cVar;
                }

                public final void run() {
                    AppMethodBeat.i(243698);
                    this.tMo.tMm.dcr().boE();
                    AppMethodBeat.o(243698);
                }
            }

            @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
            public final void a(RefreshLoadMoreLayout.c<Object> cVar) {
                AppMethodBeat.i(243705);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(cVar);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V", this, bVar.axR());
                p.h(cVar, "reason");
                super.a(cVar);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/FinderBaseGridFeedUIContract$ViewCallback$initView$4", "com/tencent/mm/view/RefreshLoadMoreLayout$ActionCallback", "onLoadMoreEnd", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout$MoreReason;)V");
                AppMethodBeat.o(243705);
            }

            @Override // com.tencent.mm.view.RefreshLoadMoreLayout.a
            public final void IF(int i2) {
                if (this.tMa && i2 > 0) {
                    this.tMa = false;
                }
            }
        }

        public void j(RefreshLoadMoreLayout.c<Object> cVar) {
            p.h(cVar, "reason");
        }

        public boolean dcu() {
            return false;
        }

        public void bIo() {
            View emptyView = getEmptyView();
            if (emptyView != null) {
                emptyView.setVisibility(0);
                RefreshLoadMoreLayout refreshLoadMoreLayout = this.tLS;
                if (refreshLoadMoreLayout != null) {
                    refreshLoadMoreLayout.setVisibility(8);
                }
                TextView textView = (TextView) emptyView.findViewById(R.id.c35);
                if (textView != null) {
                    textView.setVisibility(0);
                }
                View findViewById = emptyView.findViewById(R.id.gl7);
                if (findViewById != null) {
                    findViewById.setVisibility(8);
                }
                View findViewById2 = emptyView.findViewById(R.id.h5w);
                if (findViewById2 != null) {
                    findViewById2.setVisibility(8);
                }
            }
        }

        public final WxRecyclerAdapter<?> getAdapter() {
            WxRecyclerAdapter<?> wxRecyclerAdapter = this.tFp;
            if (wxRecyclerAdapter == null) {
                p.btv("adapter");
            }
            return wxRecyclerAdapter;
        }

        public void m(h hVar) {
            p.h(hVar, "holder");
        }

        public View getRootView() {
            return null;
        }

        /* access modifiers changed from: package-private */
        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Ljava/lang/Void;", "invoke"})
        public static final class d extends q implements kotlin.g.a.b<Void, x> {
            final /* synthetic */ b tMm;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            d(b bVar) {
                super(1);
                this.tMm = bVar;
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // kotlin.g.a.b
            public final /* synthetic */ x invoke(Void r3) {
                AppMethodBeat.i(243706);
                this.tMm.dcq().dcp();
                if (this.tMm.dct()) {
                    RefreshLoadMoreLayout.d(this.tMm.tLS);
                }
                x xVar = x.SXb;
                AppMethodBeat.o(243706);
                return xVar;
            }
        }
    }
}
