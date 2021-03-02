package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.feed.model.FinderLiveLotteryHistoryLoader;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLotteryHistoryContract;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0013"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveSingleLotteryHistoryUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", EnvConsts.ACTIVITY_MANAGER_SRVNAME, "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryHistoryContract$Presenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryHistoryContract$Presenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLotteryHistoryContract$Presenter;)V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "Companion", "plugin-finder_release"})
public final class FinderLiveSingleLotteryHistoryUIC extends UIComponent {
    public static final a wyx = new a((byte) 0);
    public FinderLotteryHistoryContract.Presenter wyw;

    static {
        AppMethodBeat.i(255787);
        AppMethodBeat.o(255787);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLiveSingleLotteryHistoryUIC(AppCompatActivity appCompatActivity) {
        super(appCompatActivity);
        p.h(appCompatActivity, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        AppMethodBeat.i(255786);
        AppMethodBeat.o(255786);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveSingleLotteryHistoryUIC$Companion;", "", "()V", "KEY_LIVE_ANCHOR_USERNAME", "", "KEY_LOTTERY_HISTORY_LIVE_ID", "KEY_LOTTERY_HISTORY_OBJECT_ID", "KEY_LOTTERY_HISTORY_OBJECT_NONCE_ID", "KEY_LOTTERY_HISTORY_SCENE", "KEY_SHOW_SETTING_TITLE", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final int getLayoutId() {
        return R.layout.aej;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        boolean z;
        int i2;
        AppMethodBeat.i(255784);
        super.onCreate(bundle);
        int intExtra = getActivity().getIntent().getIntExtra("KEY_LOTTERY_HISTORY_SCENE", 0);
        long longExtra = getActivity().getIntent().getLongExtra("KEY_LOTTERY_HISTORY_LIVE_ID", 0);
        long longExtra2 = getActivity().getIntent().getLongExtra("KEY_LOTTERY_HISTORY_OBJECT_ID", 0);
        String stringExtra = getActivity().getIntent().getStringExtra("KEY_LOTTERY_HISTORY_OBJECT_NONCE_ID");
        if (stringExtra == null) {
            stringExtra = "";
        }
        String stringExtra2 = getActivity().getIntent().getStringExtra("KEY_LIVE_ANCHOR_USERNAME");
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        if (intExtra == 0 || longExtra == 0 || longExtra2 == 0 || Util.isNullOrNil(stringExtra2)) {
            new StringBuilder("onCreate: error parameter scene = ").append(intExtra).append(", liveId = ").append(longExtra).append(", objectId = ").append(longExtra2).append(", objectNonceId = ").append(stringExtra).append(", anchorUsername = ").append(stringExtra2);
            getActivity().finish();
            AppMethodBeat.o(255784);
            return;
        }
        this.wyw = new FinderLotteryHistoryContract.Presenter(intExtra, longExtra, longExtra2, stringExtra, stringExtra2, new FinderLiveLotteryHistoryLoader(intExtra, longExtra, longExtra2, stringExtra));
        AppCompatActivity activity = getActivity();
        if (activity == null) {
            t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(255784);
            throw tVar;
        }
        MMActivity mMActivity = (MMActivity) activity;
        FinderLotteryHistoryContract.Presenter presenter = this.wyw;
        if (presenter == null) {
            p.btv("presenter");
        }
        FinderLotteryHistoryContract.ViewCallback viewCallback = new FinderLotteryHistoryContract.ViewCallback(mMActivity, presenter);
        FinderLotteryHistoryContract.Presenter presenter2 = this.wyw;
        if (presenter2 == null) {
            p.btv("presenter");
        }
        presenter2.a(viewCallback);
        if (intExtra == 1) {
            boolean booleanExtra = getIntent().getBooleanExtra("KEY_SHOW_SETTING_TITLE", false);
            z = !booleanExtra;
            AppCompatActivity activity2 = getActivity();
            if (activity2 == null) {
                t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(255784);
                throw tVar2;
            }
            MMActivity mMActivity2 = (MMActivity) activity2;
            if (booleanExtra) {
                i2 = R.string.cx5;
            } else {
                i2 = R.string.cx4;
            }
            mMActivity2.setMMTitle(i2);
        } else {
            AppCompatActivity activity3 = getActivity();
            if (activity3 == null) {
                t tVar3 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(255784);
                throw tVar3;
            }
            ((MMActivity) activity3).setMMTitle(R.string.cxi);
            z = true;
        }
        if (z) {
            AppCompatActivity activity4 = getActivity();
            if (activity4 == null) {
                t tVar4 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(255784);
                throw tVar4;
            }
            ((MMActivity) activity4).setBackBtn(new b(this), R.raw.icons_filled_close);
            AppMethodBeat.o(255784);
            return;
        }
        AppCompatActivity activity5 = getActivity();
        if (activity5 == null) {
            t tVar5 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(255784);
            throw tVar5;
        }
        ((MMActivity) activity5).setBackBtn(new c(this));
        AppMethodBeat.o(255784);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class b implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderLiveSingleLotteryHistoryUIC wyy;

        b(FinderLiveSingleLotteryHistoryUIC finderLiveSingleLotteryHistoryUIC) {
            this.wyy = finderLiveSingleLotteryHistoryUIC;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(255782);
            this.wyy.getActivity().finish();
            AppMethodBeat.o(255782);
            return true;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    static final class c implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ FinderLiveSingleLotteryHistoryUIC wyy;

        c(FinderLiveSingleLotteryHistoryUIC finderLiveSingleLotteryHistoryUIC) {
            this.wyy = finderLiveSingleLotteryHistoryUIC;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(255783);
            this.wyy.getActivity().finish();
            AppMethodBeat.o(255783);
            return true;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(255785);
        super.onDestroy();
        if (this.wyw != null) {
            FinderLotteryHistoryContract.Presenter presenter = this.wyw;
            if (presenter == null) {
                p.btv("presenter");
            }
            presenter.onDetach();
        }
        AppMethodBeat.o(255785);
    }
}
