package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.finder.feed.model.FinderLiveWecoinHotLoader;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLiveWeCoinHotConstract;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u000eH\u0016J\b\u0010\u0012\u001a\u00020\u000eH\u0002R\u001a\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0014"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveWeCoinHotUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "fragment", "Landroid/support/v4/app/Fragment;", "(Landroid/support/v4/app/Fragment;)V", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveWeCoinHotConstract$Presenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveWeCoinHotConstract$Presenter;", "setPresenter", "(Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLiveWeCoinHotConstract$Presenter;)V", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "setWindowStyle", "Companion", "plugin-finder_release"})
public final class FinderLiveWeCoinHotUIC extends UIComponent {
    public static final a wyG = new a((byte) 0);
    public FinderLiveWeCoinHotConstract.Presenter uXX;

    static {
        AppMethodBeat.i(255829);
        AppMethodBeat.o(255829);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLiveWeCoinHotUIC$Companion;", "", "()V", "KEY_LIVE_ID", "", "KEY_OBJECT_ID", "KEY_OBJECT_NONCE_ID", "KEY_SESSION_ID", "TYPE_MEMBER_ONLINE", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FinderLiveWeCoinHotUIC(Fragment fragment) {
        super(fragment);
        p.h(fragment, "fragment");
        AppMethodBeat.i(255828);
        AppMethodBeat.o(255828);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final int getLayoutId() {
        return R.layout.ag3;
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(255826);
        super.onCreate(bundle);
        if (getActivity() instanceof MMActivity) {
            AppCompatActivity activity = getActivity();
            if (activity == null) {
                t tVar = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
                AppMethodBeat.o(255826);
                throw tVar;
            }
            ((MMActivity) activity).setSelfNavigationBarVisible(8);
        }
        getContext().getWindow().addFlags(2097280);
        getContext().getWindow().addFlags(67108864);
        if (Build.VERSION.SDK_INT >= 21) {
            getContext().getWindow().clearFlags(67108864);
            Window window = getContext().getWindow();
            p.g(window, "context.window");
            View decorView = window.getDecorView();
            p.g(decorView, "context.window.decorView");
            decorView.setSystemUiVisibility(1792);
            getContext().getWindow().addFlags(Integer.MIN_VALUE);
            Window window2 = getContext().getWindow();
            p.g(window2, "context.window");
            window2.setStatusBarColor(0);
            Window window3 = getContext().getWindow();
            p.g(window3, "context.window");
            window3.setNavigationBarColor(0);
        }
        getContext().getWindow().setFormat(-3);
        getContext().getWindow().setSoftInputMode(51);
        long longExtra = getActivity().getIntent().getLongExtra("KEY_LIVE_ID", 0);
        long longExtra2 = getActivity().getIntent().getLongExtra("KEY_OBJECT_ID", 0);
        String stringExtra = getActivity().getIntent().getStringExtra("KEY_OBJECT_NONCE_ID");
        if (stringExtra == null) {
            stringExtra = "";
        }
        String stringExtra2 = getActivity().getIntent().getStringExtra("KEY_SESSION_ID");
        if (stringExtra2 == null) {
            stringExtra2 = "";
        }
        long longExtra3 = getActivity().getIntent().getLongExtra("TYPE_MEMBER_ONLINE", 0);
        if (longExtra == 0 || longExtra2 == 0 || Util.isNullOrNil(stringExtra)) {
            Log.e("SimpleUIComponent", "onCreate: error parameter liveId = " + longExtra + ", objectId = " + longExtra2 + ", objectNonceId = " + stringExtra + ", sessionId:" + stringExtra2);
            getActivity().finish();
            AppMethodBeat.o(255826);
            return;
        }
        this.uXX = new FinderLiveWeCoinHotConstract.Presenter(new FinderLiveWecoinHotLoader(longExtra, longExtra2, stringExtra));
        FinderLiveWeCoinHotConstract.Presenter presenter = this.uXX;
        if (presenter == null) {
            p.btv("presenter");
        }
        presenter.USA = longExtra3;
        AppCompatActivity activity2 = getActivity();
        if (activity2 == null) {
            t tVar2 = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
            AppMethodBeat.o(255826);
            throw tVar2;
        }
        MMActivity mMActivity = (MMActivity) activity2;
        FinderLiveWeCoinHotConstract.Presenter presenter2 = this.uXX;
        if (presenter2 == null) {
            p.btv("presenter");
        }
        FinderLiveWeCoinHotConstract.ViewCallback viewCallback = new FinderLiveWeCoinHotConstract.ViewCallback(mMActivity, presenter2);
        FinderLiveWeCoinHotConstract.Presenter presenter3 = this.uXX;
        if (presenter3 == null) {
            p.btv("presenter");
        }
        presenter3.a(viewCallback);
        AppMethodBeat.o(255826);
    }

    @Override // com.tencent.mm.ui.component.UIComponent
    public final void onDestroy() {
        AppMethodBeat.i(255827);
        super.onDestroy();
        if (this.uXX != null) {
            FinderLiveWeCoinHotConstract.Presenter presenter = this.uXX;
            if (presenter == null) {
                p.btv("presenter");
            }
            presenter.onDetach();
        }
        AppMethodBeat.o(255827);
    }
}
