package com.tencent.mm.plugin.finder.presenter.contract;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.FinderLiveLotteryAnchorAllHistoryLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.presenter.contract.BaseFinderLotteryContract;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryAnchorAllHistoryContract;", "", "()V", "Presenter", "ViewCallback", "plugin-finder_release"})
public final class FinderLotteryAnchorAllHistoryContract {
    public static final FinderLotteryAnchorAllHistoryContract uXZ = new FinderLotteryAnchorAllHistoryContract();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryAnchorAllHistoryContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$Presenter;", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryAnchorAllHistoryLoader;", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryAnchorAllHistoryLoader;)V", "generateAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onAttach", "", "callback", "Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$ViewCallback;", "plugin-finder_release"})
    public static final class Presenter extends BaseFinderLotteryContract.Presenter {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Presenter(FinderLiveLotteryAnchorAllHistoryLoader finderLiveLotteryAnchorAllHistoryLoader) {
            super(finderLiveLotteryAnchorAllHistoryLoader);
            p.h(finderLiveLotteryAnchorAllHistoryLoader, "loader");
            AppMethodBeat.i(249853);
            AppMethodBeat.o(249853);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.plugin.finder.presenter.contract.BaseFinderLotteryContract.Presenter, com.tencent.mm.plugin.finder.presenter.base.a
        public final /* synthetic */ void onAttach(BaseFinderLotteryContract.ViewCallback viewCallback) {
            AppMethodBeat.i(249852);
            a(viewCallback);
            AppMethodBeat.o(249852);
        }

        @Override // com.tencent.mm.plugin.finder.presenter.contract.BaseFinderLotteryContract.Presenter
        public final WxRecyclerAdapter<bo> dlN() {
            AppMethodBeat.i(249850);
            WxRecyclerAdapter<bo> wxRecyclerAdapter = new WxRecyclerAdapter<>(new FinderLotteryAnchorAllHistoryContract$Presenter$generateAdapter$1(), cDk());
            wxRecyclerAdapter.RqP = new FinderLotteryAnchorAllHistoryContract$Presenter$generateAdapter$2$1();
            AppMethodBeat.o(249850);
            return wxRecyclerAdapter;
        }

        @Override // com.tencent.mm.plugin.finder.presenter.contract.BaseFinderLotteryContract.Presenter
        public final void a(BaseFinderLotteryContract.ViewCallback viewCallback) {
            AppMethodBeat.i(249851);
            p.h(viewCallback, "callback");
            super.onAttach(viewCallback);
            BaseFeedLoader<bo> baseFeedLoader = this.uWg;
            if (!(baseFeedLoader instanceof FinderLiveLotteryAnchorAllHistoryLoader)) {
                baseFeedLoader = null;
            }
            FinderLiveLotteryAnchorAllHistoryLoader finderLiveLotteryAnchorAllHistoryLoader = (FinderLiveLotteryAnchorAllHistoryLoader) baseFeedLoader;
            if (finderLiveLotteryAnchorAllHistoryLoader != null) {
                finderLiveLotteryAnchorAllHistoryLoader.fetchEndCallback = new FinderLotteryAnchorAllHistoryContract$Presenter$onAttach$1(this);
                AppMethodBeat.o(249851);
                return;
            }
            AppMethodBeat.o(249851);
        }
    }

    static {
        AppMethodBeat.i(249855);
        AppMethodBeat.o(249855);
    }

    private FinderLotteryAnchorAllHistoryContract() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryAnchorAllHistoryContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$ViewCallback;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryAnchorAllHistoryContract$Presenter;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryAnchorAllHistoryContract$Presenter;)V", "plugin-finder_release"})
    public static final class ViewCallback extends BaseFinderLotteryContract.ViewCallback {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewCallback(MMActivity mMActivity, Presenter presenter) {
            super(mMActivity, presenter);
            p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            p.h(presenter, "presenter");
            AppMethodBeat.i(249854);
            AppMethodBeat.o(249854);
        }
    }
}
