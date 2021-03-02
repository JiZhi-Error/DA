package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.feed.model.FinderLiveLotteryAnchorAllHistoryLoader;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLotteryAnchorAllHistoryContract;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0012"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveAnchorAllLotteryHistoryUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryAnchorAllHistoryContract$Presenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryAnchorAllHistoryContract$Presenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryAnchorAllHistoryContract$Presenter;)V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "plugin-finder_release"})
public final class FinderLiveAnchorAllLotteryHistoryUIC extends UIComponent {
    public FinderLotteryAnchorAllHistoryContract.Presenter wxZ;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLiveAnchorAllLotteryHistoryUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(255727);
        AppMethodBeat.o(255727);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final int getLayoutId() {
        return R.layout.aej;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(255725);
        super.onCreate(bundle);
        AppCompatActivity activity = getActivity();
        if (activity == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(255725);
            throw tVar;
        }
        MMActivity mMActivity = (MMActivity) activity;
        mMActivity.setMMTitle(R.string.cx5);
        mMActivity.setBackBtn(new a(mMActivity));
        this.wxZ = new FinderLotteryAnchorAllHistoryContract.Presenter(new FinderLiveLotteryAnchorAllHistoryLoader());
        AppCompatActivity activity2 = getActivity();
        if (activity2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(255725);
            throw tVar2;
        }
        MMActivity mMActivity2 = (MMActivity) activity2;
        FinderLotteryAnchorAllHistoryContract.Presenter presenter = this.wxZ;
        if (presenter == null) {
            p.btv("presenter");
        }
        FinderLotteryAnchorAllHistoryContract.ViewCallback viewCallback = new FinderLotteryAnchorAllHistoryContract.ViewCallback(mMActivity2, presenter);
        FinderLotteryAnchorAllHistoryContract.Presenter presenter2 = this.wxZ;
        if (presenter2 == null) {
            p.btv("presenter");
        }
        presenter2.a(viewCallback);
        AppMethodBeat.o(255725);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class a implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ MMActivity nbr;

        a(MMActivity mMActivity) {
            this.nbr = mMActivity;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(255724);
            this.nbr.finish();
            AppMethodBeat.o(255724);
            return true;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(255726);
        super.onDestroy();
        if (this.wxZ != null) {
            FinderLotteryAnchorAllHistoryContract.Presenter presenter = this.wxZ;
            if (presenter == null) {
                p.btv("presenter");
            }
            presenter.onDetach();
        }
        AppMethodBeat.o(255726);
    }
}
