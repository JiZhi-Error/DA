package com.tencent.mm.plugin.finder.presenter.contract;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ac.d;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.presenter.base.a;
import com.tencent.mm.plugin.finder.presenter.base.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.j;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.util.ArrayList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract;", "", "()V", "Presenter", "ViewCallback", "plugin-finder_release"})
public final class BaseFinderLotteryContract {
    public static final BaseFinderLotteryContract uWe = new BaseFinderLotteryContract();

    @l(hxD = {1, 1, 16}, hxE = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b&\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001#B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0006J\u000e\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\bH&J\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u001cJ\u0006\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010\u001f\u001a\u00020\u001e2\u0006\u0010 \u001a\u00020\u0002H\u0016J\b\u0010!\u001a\u00020\u001eH\u0016J\u0006\u0010\"\u001a\u00020\u001eR \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006$"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/base/IPresenter;", "Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$ViewCallback;", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;)V", "adapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "getAdapter", "()Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "setAdapter", "(Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;)V", "getLoader", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/BaseFeedLoader;", "proxyRLayout", "Lcom/tencent/mm/view/IViewActionCallback;", "getProxyRLayout", "()Lcom/tencent/mm/view/IViewActionCallback;", "setProxyRLayout", "(Lcom/tencent/mm/view/IViewActionCallback;)V", "viewCallback", "getViewCallback", "()Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$ViewCallback;", "setViewCallback", "(Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$ViewCallback;)V", "generateAdapter", "getData", "Ljava/util/ArrayList;", "loadMore", "", "onAttach", "callback", "onDetach", "refresh", "Companion", "plugin-finder_release"})
    public static abstract class Presenter implements a<ViewCallback> {
        public static final Companion uWh = new Companion((byte) 0);
        public WxRecyclerAdapter<bo> tFp;
        private j tMe = new j(this) {
            /* class com.tencent.mm.plugin.finder.presenter.contract.BaseFinderLotteryContract.Presenter.AnonymousClass1 */
            final /* synthetic */ Presenter uWi;

            /* JADX WARN: Incorrect args count in method signature: ()V */
            {
                this.uWi = r1;
            }

            @Override // com.tencent.mm.view.i
            public final void onPreFinishRefresh(RefreshLoadMoreLayout.c<Object> cVar) {
                RefreshLoadMoreLayout dcQ;
                AppMethodBeat.i(249662);
                p.h(cVar, "reason");
                ViewCallback viewCallback = this.uWi.uWf;
                if (viewCallback == null || (dcQ = viewCallback.dcQ()) == null) {
                    AppMethodBeat.o(249662);
                    return;
                }
                dcQ.onPreFinishRefresh(cVar);
                AppMethodBeat.o(249662);
            }

            @Override // com.tencent.mm.view.i
            public final void onPreFinishLoadMore(RefreshLoadMoreLayout.c<Object> cVar) {
                RefreshLoadMoreLayout dcQ;
                AppMethodBeat.i(249663);
                p.h(cVar, "reason");
                ViewCallback viewCallback = this.uWi.uWf;
                if (viewCallback == null || (dcQ = viewCallback.dcQ()) == null) {
                    AppMethodBeat.o(249663);
                    return;
                }
                dcQ.onPreFinishLoadMore(cVar);
                AppMethodBeat.o(249663);
            }

            @Override // com.tencent.mm.view.i
            public final void onPreFinishLoadMoreSmooth(RefreshLoadMoreLayout.c<Object> cVar) {
                RefreshLoadMoreLayout dcQ;
                AppMethodBeat.i(249664);
                p.h(cVar, "reason");
                ViewCallback viewCallback = this.uWi.uWf;
                if (viewCallback == null || (dcQ = viewCallback.dcQ()) == null) {
                    AppMethodBeat.o(249664);
                    return;
                }
                dcQ.onPreFinishLoadMoreSmooth(cVar);
                AppMethodBeat.o(249664);
            }

            @Override // com.tencent.mm.view.j
            public final void onChanged() {
                RefreshLoadMoreLayout dcQ;
                AppMethodBeat.i(249665);
                ViewCallback viewCallback = this.uWi.uWf;
                if (viewCallback == null || (dcQ = viewCallback.dcQ()) == null) {
                    AppMethodBeat.o(249665);
                    return;
                }
                dcQ.onChanged();
                AppMethodBeat.o(249665);
            }

            @Override // com.tencent.mm.view.j
            public final void onItemRangeChanged(int i2, int i3) {
                RefreshLoadMoreLayout dcQ;
                AppMethodBeat.i(249666);
                ViewCallback viewCallback = this.uWi.uWf;
                if (viewCallback == null || (dcQ = viewCallback.dcQ()) == null) {
                    AppMethodBeat.o(249666);
                    return;
                }
                dcQ.onItemRangeChanged(this.uWi.getAdapter().RqM.size() + i2, i3);
                AppMethodBeat.o(249666);
            }

            @Override // com.tencent.mm.view.j
            public final void onItemRangeChanged(int i2, int i3, Object obj) {
                RefreshLoadMoreLayout dcQ;
                AppMethodBeat.i(249667);
                ViewCallback viewCallback = this.uWi.uWf;
                if (viewCallback == null || (dcQ = viewCallback.dcQ()) == null) {
                    AppMethodBeat.o(249667);
                    return;
                }
                dcQ.onItemRangeChanged(this.uWi.getAdapter().RqM.size() + i2, i3, obj);
                AppMethodBeat.o(249667);
            }

            @Override // com.tencent.mm.view.j
            public final void onItemRangeInserted(int i2, int i3) {
                RefreshLoadMoreLayout dcQ;
                AppMethodBeat.i(249668);
                ViewCallback viewCallback = this.uWi.uWf;
                if (viewCallback == null || (dcQ = viewCallback.dcQ()) == null) {
                    AppMethodBeat.o(249668);
                    return;
                }
                dcQ.onItemRangeInserted(this.uWi.getAdapter().RqM.size() + i2, i3);
                AppMethodBeat.o(249668);
            }

            @Override // com.tencent.mm.view.j
            public final void onItemRangeRemoved(int i2, int i3) {
                RefreshLoadMoreLayout dcQ;
                AppMethodBeat.i(249669);
                ViewCallback viewCallback = this.uWi.uWf;
                if (viewCallback == null || (dcQ = viewCallback.dcQ()) == null) {
                    AppMethodBeat.o(249669);
                    return;
                }
                dcQ.onItemRangeRemoved(this.uWi.getAdapter().RqM.size() + i2, i3);
                AppMethodBeat.o(249669);
            }
        };
        ViewCallback uWf;
        public final BaseFeedLoader<bo> uWg;

        public abstract WxRecyclerAdapter<bo> dlN();

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$Presenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(byte b2) {
                this();
            }
        }

        public Presenter(BaseFeedLoader<bo> baseFeedLoader) {
            p.h(baseFeedLoader, "loader");
            this.uWg = baseFeedLoader;
        }

        public final WxRecyclerAdapter<bo> getAdapter() {
            WxRecyclerAdapter<bo> wxRecyclerAdapter = this.tFp;
            if (wxRecyclerAdapter == null) {
                p.btv("adapter");
            }
            return wxRecyclerAdapter;
        }

        /* renamed from: a */
        public void onAttach(ViewCallback viewCallback) {
            p.h(viewCallback, "callback");
            this.tFp = dlN();
            this.uWf = viewCallback;
            ViewCallback viewCallback2 = this.uWf;
            if (viewCallback2 != null) {
                View findViewById = viewCallback2.activity.findViewById(R.id.h7t);
                p.g(findViewById, "activity.findViewById(R.id.rl_layout)");
                viewCallback2.tLS = (RefreshLoadMoreLayout) findViewById;
                RefreshLoadMoreLayout refreshLoadMoreLayout = viewCallback2.tLS;
                if (refreshLoadMoreLayout == null) {
                    p.btv("rlLayout");
                }
                refreshLoadMoreLayout.setEnableRefresh(false);
                RefreshLoadMoreLayout refreshLoadMoreLayout2 = viewCallback2.tLS;
                if (refreshLoadMoreLayout2 == null) {
                    p.btv("rlLayout");
                }
                RecyclerView recyclerView = refreshLoadMoreLayout2.getRecyclerView();
                recyclerView.setLayoutManager(new LinearLayoutManager());
                recyclerView.setAdapter(viewCallback2.uWj.getAdapter());
                RefreshLoadMoreLayout refreshLoadMoreLayout3 = viewCallback2.tLS;
                if (refreshLoadMoreLayout3 == null) {
                    p.btv("rlLayout");
                }
                refreshLoadMoreLayout3.setActionCallback(new BaseFinderLotteryContract$ViewCallback$initView$1(viewCallback2, recyclerView));
                viewCallback2.nK(true);
                d.a(300, new BaseFinderLotteryContract$ViewCallback$initView$2(viewCallback2));
            }
            this.uWg.register(this.tMe);
        }

        @Override // com.tencent.mm.plugin.finder.presenter.base.a
        public void onDetach() {
            this.uWg.unregister(this.tMe);
        }

        public final ArrayList<bo> cDk() {
            return this.uWg.getDataListJustForAdapter();
        }
    }

    static {
        AppMethodBeat.i(249680);
        AppMethodBeat.o(249680);
    }

    private BaseFinderLotteryContract() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u0004H\u0016J\b\u0010\u000e\u001a\u00020\u0002H\u0016J\u0006\u0010\u000f\u001a\u00020\bJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/base/IViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$Presenter;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "presenter", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$Presenter;)V", "rlLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "getRlLayout", "()Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "setRlLayout", "(Lcom/tencent/mm/view/RefreshLoadMoreLayout;)V", "getActivity", "getPresenter", "getRefreshLoadMoreLayout", "initView", "", "showEmptyView", "showProgress", "ifShow", "", "plugin-finder_release"})
    public static class ViewCallback implements c<Presenter> {
        final MMActivity activity;
        public RefreshLoadMoreLayout tLS;
        final Presenter uWj;

        public ViewCallback(MMActivity mMActivity, Presenter presenter) {
            p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            p.h(presenter, "presenter");
            AppMethodBeat.i(249679);
            this.activity = mMActivity;
            this.uWj = presenter;
            AppMethodBeat.o(249679);
        }

        public final RefreshLoadMoreLayout getRlLayout() {
            AppMethodBeat.i(249676);
            RefreshLoadMoreLayout refreshLoadMoreLayout = this.tLS;
            if (refreshLoadMoreLayout == null) {
                p.btv("rlLayout");
            }
            AppMethodBeat.o(249676);
            return refreshLoadMoreLayout;
        }

        public final RefreshLoadMoreLayout dcQ() {
            AppMethodBeat.i(249677);
            RefreshLoadMoreLayout refreshLoadMoreLayout = this.tLS;
            if (refreshLoadMoreLayout == null) {
                p.btv("rlLayout");
            }
            AppMethodBeat.o(249677);
            return refreshLoadMoreLayout;
        }

        public final void nK(boolean z) {
            AppMethodBeat.i(249678);
            View findViewById = this.activity.findViewById(R.id.etk);
            if (findViewById != null) {
                findViewById.setVisibility(z ? 0 : 8);
                AppMethodBeat.o(249678);
                return;
            }
            AppMethodBeat.o(249678);
        }

        @Override // com.tencent.mm.plugin.finder.presenter.base.c
        public final /* bridge */ /* synthetic */ MMFragmentActivity dcl() {
            return this.activity;
        }
    }
}
