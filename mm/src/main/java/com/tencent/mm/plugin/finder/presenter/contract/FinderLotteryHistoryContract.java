package com.tencent.mm.plugin.finder.presenter.contract;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.model.FinderLiveLotteryHistoryLoader;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.model.bo;
import com.tencent.mm.plugin.finder.presenter.contract.BaseFinderLotteryContract;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryHistoryContract;", "", "()V", "Presenter", "ViewCallback", "plugin-finder_release"})
public final class FinderLotteryHistoryContract {
    public static final FinderLotteryHistoryContract uYb = new FinderLotteryHistoryContract();

    @l(hxD = {1, 1, 16}, hxE = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJ\u000e\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryHistoryContract$Presenter;", "Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$Presenter;", "scene", "", "liveId", "", "objectId", "objectNonceId", "", "anchorUsername", "loader", "Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryHistoryLoader;", "(IJJLjava/lang/String;Ljava/lang/String;Lcom/tencent/mm/plugin/finder/feed/model/FinderLiveLotteryHistoryLoader;)V", "getAnchorUsername", "()Ljava/lang/String;", "getLiveId", "()J", "getObjectId", "getObjectNonceId", "getScene", "()I", "generateAdapter", "Lcom/tencent/mm/view/recyclerview/WxRecyclerAdapter;", "Lcom/tencent/mm/plugin/finder/model/RVFeed;", "onAttach", "", "callback", "Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$ViewCallback;", "Companion", "plugin-finder_release"})
    public static final class Presenter extends BaseFinderLotteryContract.Presenter {
        public static final Companion uYc = new Companion((byte) 0);
        final long hFK;
        final String hwd;
        final long liveId;
        final String objectNonceId;
        final int scene;

        static {
            AppMethodBeat.i(249863);
            AppMethodBeat.o(249863);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // com.tencent.mm.plugin.finder.presenter.contract.BaseFinderLotteryContract.Presenter, com.tencent.mm.plugin.finder.presenter.base.a
        public final /* synthetic */ void onAttach(BaseFinderLotteryContract.ViewCallback viewCallback) {
            AppMethodBeat.i(249861);
            a(viewCallback);
            AppMethodBeat.o(249861);
        }

        @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryHistoryContract$Presenter$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(byte b2) {
                this();
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Presenter(int i2, long j2, long j3, String str, String str2, FinderLiveLotteryHistoryLoader finderLiveLotteryHistoryLoader) {
            super(finderLiveLotteryHistoryLoader);
            p.h(str, "objectNonceId");
            p.h(str2, "anchorUsername");
            p.h(finderLiveLotteryHistoryLoader, "loader");
            AppMethodBeat.i(249862);
            this.scene = i2;
            this.liveId = j2;
            this.hFK = j3;
            this.objectNonceId = str;
            this.hwd = str2;
            AppMethodBeat.o(249862);
        }

        @Override // com.tencent.mm.plugin.finder.presenter.contract.BaseFinderLotteryContract.Presenter
        public final WxRecyclerAdapter<bo> dlN() {
            AppMethodBeat.i(249859);
            WxRecyclerAdapter<bo> wxRecyclerAdapter = new WxRecyclerAdapter<>(new FinderLotteryHistoryContract$Presenter$generateAdapter$1(), cDk());
            wxRecyclerAdapter.RqP = new FinderLotteryHistoryContract$Presenter$generateAdapter$$inlined$apply$lambda$1(this);
            AppMethodBeat.o(249859);
            return wxRecyclerAdapter;
        }

        @Override // com.tencent.mm.plugin.finder.presenter.contract.BaseFinderLotteryContract.Presenter
        public final void a(BaseFinderLotteryContract.ViewCallback viewCallback) {
            AppMethodBeat.i(249860);
            p.h(viewCallback, "callback");
            super.onAttach(viewCallback);
            BaseFeedLoader<bo> baseFeedLoader = this.uWg;
            if (!(baseFeedLoader instanceof FinderLiveLotteryHistoryLoader)) {
                baseFeedLoader = null;
            }
            FinderLiveLotteryHistoryLoader finderLiveLotteryHistoryLoader = (FinderLiveLotteryHistoryLoader) baseFeedLoader;
            if (finderLiveLotteryHistoryLoader != null) {
                Intent intent = viewCallback.activity.getIntent();
                p.g(intent, "callback.getActivity().intent");
                finderLiveLotteryHistoryLoader.initFromCache(intent);
                finderLiveLotteryHistoryLoader.fetchEndCallback = new FinderLotteryHistoryContract$Presenter$onAttach$$inlined$run$lambda$1(finderLiveLotteryHistoryLoader, this, viewCallback);
                AppMethodBeat.o(249860);
                return;
            }
            AppMethodBeat.o(249860);
        }
    }

    static {
        AppMethodBeat.i(249865);
        AppMethodBeat.o(249865);
    }

    private FinderLotteryHistoryContract() {
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryHistoryContract$ViewCallback;", "Lcom/tencent/mm/plugin/finder/presenter/contract/BaseFinderLotteryContract$ViewCallback;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Lcom/tencent/mm/ui/MMActivity;", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryHistoryContract$Presenter;", "(Lcom/tencent/mm/ui/MMActivity;Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryHistoryContract$Presenter;)V", "plugin-finder_release"})
    public static final class ViewCallback extends BaseFinderLotteryContract.ViewCallback {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewCallback(MMActivity mMActivity, Presenter presenter) {
            super(mMActivity, presenter);
            p.h(mMActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
            p.h(presenter, "presenter");
            AppMethodBeat.i(249864);
            AppMethodBeat.o(249864);
        }
    }
}
