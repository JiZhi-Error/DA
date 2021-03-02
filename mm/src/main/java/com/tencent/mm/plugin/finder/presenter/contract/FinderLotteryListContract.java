package com.tencent.mm.plugin.finder.presenter.contract;

import android.support.v7.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.FinderLiveLotteryListLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.presenter.contract.BaseFinderLotteryContract;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import com.tencent.mm.view.f;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryListContract;", "", "()V", "Presenter", "ViewCallback", "plugin-finder_release"})
public final class FinderLotteryListContract {
    public static final FinderLotteryListContract uYg = new FinderLotteryListContract();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryListContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$Presenter;", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryListLoader;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryListLoader;)V", "canAnchorSendMsg2User", "", "getCanAnchorSendMsg2User", "()Z", "setCanAnchorSendMsg2User", "(Z)V", "generateAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "getLotteryId", "", "getObjectId", "", "onAttach", "", "callback", "Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$ViewCallback;", "Companion", "plugin-finder_release"})
    public static final class Presenter extends BaseFinderLotteryContract.Presenter {
        public static final Companion uYi = new Companion((byte) 0);
        public boolean uYh = true;

        static {
            AppMethodBeat.i(249875);
            AppMethodBeat.o(249875);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Presenter(FinderLiveLotteryListLoader finderLiveLotteryListLoader) {
            super(finderLiveLotteryListLoader);
            p.h(finderLiveLotteryListLoader, "loader");
            AppMethodBeat.i(249874);
            AppMethodBeat.o(249874);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.plugin.finder.presenter.contract.BaseFinderLotteryContract.Presenter, com.tencent.mm.plugin.finder.presenter.base.a
        public final /* synthetic */ void onAttach(BaseFinderLotteryContract.ViewCallback viewCallback) {
            AppMethodBeat.i(249873);
            a(viewCallback);
            AppMethodBeat.o(249873);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryListContract$Presenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(byte b2) {
                this();
            }
        }

        @Override // com.tencent.mm.plugin.finder.presenter.contract.BaseFinderLotteryContract.Presenter
        public final WxRecyclerAdapter<bo> dlN() {
            AppMethodBeat.i(249871);
            WxRecyclerAdapter<bo> wxRecyclerAdapter = new WxRecyclerAdapter<>(new FinderLotteryListContract$Presenter$generateAdapter$1(this), cDk());
            AppMethodBeat.o(249871);
            return wxRecyclerAdapter;
        }

        @Override // com.tencent.mm.plugin.finder.presenter.contract.BaseFinderLotteryContract.Presenter
        public final void a(BaseFinderLotteryContract.ViewCallback viewCallback) {
            RefreshLoadMoreLayout rlLayout;
            RecyclerView recyclerView;
            AppMethodBeat.i(249872);
            p.h(viewCallback, "callback");
            super.onAttach(viewCallback);
            BaseFeedLoader<bo> baseFeedLoader = this.uWg;
            if (!(baseFeedLoader instanceof FinderLiveLotteryListLoader)) {
                baseFeedLoader = null;
            }
            FinderLiveLotteryListLoader finderLiveLotteryListLoader = (FinderLiveLotteryListLoader) baseFeedLoader;
            if (finderLiveLotteryListLoader != null) {
                finderLiveLotteryListLoader.fetchEndCallback = new FinderLotteryListContract$Presenter$onAttach$1(this, viewCallback);
            }
            BaseFinderLotteryContract.ViewCallback viewCallback2 = this.uWf;
            if (viewCallback2 == null || (rlLayout = viewCallback2.getRlLayout()) == null || (recyclerView = rlLayout.getRecyclerView()) == null) {
                AppMethodBeat.o(249872);
                return;
            }
            f.a(recyclerView, new FinderLotteryListContract$Presenter$onAttach$2(this));
            AppMethodBeat.o(249872);
        }
    }

    static {
        AppMethodBeat.i(249877);
        AppMethodBeat.o(249877);
    }

    private FinderLotteryListContract() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryListContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$ViewCallback;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryListContract$Presenter;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryListContract$Presenter;)V", "plugin-finder_release"})
    public static final class ViewCallback extends BaseFinderLotteryContract.ViewCallback {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewCallback(MMActivity mMActivity, Presenter presenter) {
            super(mMActivity, presenter);
            p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            p.h(presenter, "presenter");
            AppMethodBeat.i(249876);
            AppMethodBeat.o(249876);
        }
    }
}
