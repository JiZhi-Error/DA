package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.feed.model.FinderLiveLotteryListLoader;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLotteryListContract;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveWinLotteryListUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryListContract$Presenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryListContract$Presenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryListContract$Presenter;)V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "plugin-finder_release"})
public final class FinderLiveWinLotteryListUIC extends UIComponent {
    public static final a wyH = new a((byte) 0);
    public FinderLotteryListContract.Presenter tEE;

    static {
        AppMethodBeat.i(255834);
        AppMethodBeat.o(255834);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveWinLotteryListUIC$Companion;", "", "()V", "KEY_LOTTERY_ID", "", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLiveWinLotteryListUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(255833);
        AppMethodBeat.o(255833);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final int getLayoutId() {
        return R.layout.aej;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        int i2;
        AppMethodBeat.i(255831);
        super.onCreate(bundle);
        long longExtra = getActivity().getIntent().getLongExtra("KEY_LOTTERY_HISTORY_LIVE_ID", 0);
        long longExtra2 = getActivity().getIntent().getLongExtra("KEY_LOTTERY_HISTORY_OBJECT_ID", 0);
        String stringExtra = getActivity().getIntent().getStringExtra("KEY_LOTTERY_HISTORY_OBJECT_NONCE_ID");
        if (stringExtra == null) {
            stringExtra = "";
        }
        String stringExtra2 = getActivity().getIntent().getStringExtra("KEY_LOTTERY_ID");
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        if (longExtra == 0 || longExtra2 == 0 || Util.isNullOrNil(stringExtra2)) {
            new StringBuilder("onCreate: error parameter lotteryId = ").append(stringExtra2).append(", liveId = ").append(longExtra).append(", objectId = ").append(longExtra2).append(", objectNonceId = ").append(stringExtra);
            getActivity().finish();
            AppMethodBeat.o(255831);
            return;
        }
        this.tEE = new FinderLotteryListContract.Presenter(new FinderLiveLotteryListLoader(stringExtra2, longExtra, longExtra2, stringExtra));
        AppCompatActivity activity = getActivity();
        if (activity == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(255831);
            throw tVar;
        }
        MMActivity mMActivity = (MMActivity) activity;
        FinderLotteryListContract.Presenter presenter = this.tEE;
        if (presenter == null) {
            p.btv("presenter");
        }
        FinderLotteryListContract.ViewCallback viewCallback = new FinderLotteryListContract.ViewCallback(mMActivity, presenter);
        FinderLotteryListContract.Presenter presenter2 = this.tEE;
        if (presenter2 == null) {
            p.btv("presenter");
        }
        presenter2.a(viewCallback);
        boolean booleanExtra = getIntent().getBooleanExtra("KEY_SHOW_SETTING_TITLE", false);
        AppCompatActivity activity2 = getActivity();
        if (activity2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(255831);
            throw tVar2;
        }
        MMActivity mMActivity2 = (MMActivity) activity2;
        if (booleanExtra) {
            i2 = R.string.cx6;
        } else {
            i2 = R.string.cx3;
        }
        mMActivity2.setMMTitle(i2);
        AppCompatActivity activity3 = getActivity();
        if (activity3 == null) {
            t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(255831);
            throw tVar3;
        }
        ((MMActivity) activity3).setBackBtn(new b(this));
        ((FrameLayout) getActivity().findViewById(R.id.be7)).setBackgroundColor(getActivity().getResources().getColor(R.color.afz));
        AppMethodBeat.o(255831);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class b implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderLiveWinLotteryListUIC wyI;

        b(FinderLiveWinLotteryListUIC finderLiveWinLotteryListUIC) {
            this.wyI = finderLiveWinLotteryListUIC;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(255830);
            this.wyI.getActivity().finish();
            AppMethodBeat.o(255830);
            return true;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(255832);
        super.onDestroy();
        if (this.tEE != null) {
            FinderLotteryListContract.Presenter presenter = this.tEE;
            if (presenter == null) {
                p.btv("presenter");
            }
            presenter.onDetach();
        }
        AppMethodBeat.o(255832);
    }
}
