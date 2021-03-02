package com.tencent.mm.plugin.wallet.wecoin.ui;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI;
import com.tencent.mm.plugin.wallet.wecoin.c.c;
import com.tencent.mm.plugin.wallet.wecoin.model.WeCoinIncomeDetailViewModel;
import com.tencent.mm.plugin.wallet.wecoin.model.WecoinEncashKVData;
import com.tencent.mm.plugin.wallet_core.ui.view.WcPayMoneyLoadingView;
import com.tencent.mm.protocal.protobuf.abq;
import com.tencent.mm.protocal.protobuf.bop;
import com.tencent.mm.protocal.protobuf.djt;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.math.RoundingMode;
import java.util.Collection;
import java.util.UUID;
import org.json.JSONArray;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0014J\b\u0010\u0015\u001a\u00020\u0012H\u0002J\b\u0010\u0016\u001a\u00020\u0012H\u0002J\b\u0010\u0017\u001a\u00020\u0012H\u0014J\"\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u00142\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u0012H\u0016J\u0012\u0010\u001e\u001a\u00020\u00122\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u0012H\u0014J\b\u0010\"\u001a\u00020\u0012H\u0014J\u0010\u0010#\u001a\u00020\u00122\u0006\u0010$\u001a\u00020%H\u0002J\b\u0010&\u001a\u00020\u0012H\u0002J\u0012\u0010'\u001a\u00020\u00122\b\u0010$\u001a\u0004\u0018\u00010(H\u0002J\u0017\u0010)\u001a\u00020\u00122\b\u0010*\u001a\u0004\u0018\u00010+H\u0002¢\u0006\u0002\u0010,J\u0017\u0010-\u001a\u00020\u00122\b\u0010.\u001a\u0004\u0018\u00010+H\u0002¢\u0006\u0002\u0010,J\b\u0010/\u001a\u00020\u0012H\u0002J\u0012\u00100\u001a\u00020\u00122\b\u00101\u001a\u0004\u0018\u000102H\u0002J\u0017\u00103\u001a\u00020\u00122\b\u00104\u001a\u0004\u0018\u000105H\u0002¢\u0006\u0002\u00106J\u0012\u00107\u001a\u00020\u00122\b\u00101\u001a\u0004\u0018\u000102H\u0002J\u0012\u00108\u001a\u00020\u00122\b\u00109\u001a\u0004\u0018\u00010:H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000¨\u0006<"}, hxF = {"Lcom/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "mBalanceView", "Lcom/tencent/mm/plugin/wallet_core/ui/view/WcPayMoneyLoadingView;", "mFaqTv", "Landroid/widget/TextView;", "mFetchBtn", "Landroid/widget/Button;", "mIncomeBalanceLL", "Landroid/widget/LinearLayout;", "mMoneyLoadingPb", "Landroid/widget/ProgressBar;", "mProgressDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "mViewModel", "Lcom/tencent/mm/plugin/wallet/wecoin/model/WeCoinIncomeDetailViewModel;", "bindData", "", "getLayoutId", "", "gotoIncomeBalanceView", "initKVData", "initView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "openRealNameAuth", "info", "Lcom/tencent/mm/protocal/protobuf/RealNameAuthInfo;", "showAlertDialog", "showErrorMsg", "Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "showProgressDialog", "isShow", "", "(Ljava/lang/Boolean;)V", "updateAuthored", "authored", "updateClickButtonEvent", "updateFaqView", "url", "", "updateIncomeBalanceView", "balance", "", "(Ljava/lang/Long;)V", "updateRightOptionMenu", "updateTopBannerView", "bannerContent", "Lcom/tencent/mm/protocal/protobuf/CoinBanner;", "Companion", "plugin-wxpay_release"})
public final class WeCoinIncomeDetailView extends MMActivity {
    public static final a HOZ = new a((byte) 0);
    private LinearLayout HOW;
    private WeCoinIncomeDetailViewModel HOX;
    private TextView HOY;
    private Button HvV;
    private WcPayMoneyLoadingView Hwb;
    private q gxX;
    private ProgressBar zmU;

    static {
        AppMethodBeat.i(212865);
        AppMethodBeat.o(212865);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "onChanged"})
    static final class b<T> implements Observer<String> {
        final /* synthetic */ WeCoinIncomeDetailView HPa;

        b(WeCoinIncomeDetailView weCoinIncomeDetailView) {
            this.HPa = weCoinIncomeDetailView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(String str) {
            AppMethodBeat.i(212842);
            WeCoinIncomeDetailView.a(this.HPa, str);
            AppMethodBeat.o(212842);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "onChanged", "(Ljava/lang/Long;)V"})
    static final class c<T> implements Observer<Long> {
        final /* synthetic */ WeCoinIncomeDetailView HPa;

        c(WeCoinIncomeDetailView weCoinIncomeDetailView) {
            this.HPa = weCoinIncomeDetailView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(Long l) {
            AppMethodBeat.i(212843);
            WeCoinIncomeDetailView.a(this.HPa, l);
            WeCoinIncomeDetailView.c(this.HPa);
            AppMethodBeat.o(212843);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "onChanged"})
    static final class d<T> implements Observer<String> {
        final /* synthetic */ WeCoinIncomeDetailView HPa;

        d(WeCoinIncomeDetailView weCoinIncomeDetailView) {
            this.HPa = weCoinIncomeDetailView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(String str) {
            AppMethodBeat.i(212844);
            WeCoinIncomeDetailView.b(this.HPa, str);
            AppMethodBeat.o(212844);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "onChanged"})
    static final class f<T> implements Observer<com.tencent.mm.plugin.wallet.wecoin.model.a> {
        final /* synthetic */ WeCoinIncomeDetailView HPa;

        f(WeCoinIncomeDetailView weCoinIncomeDetailView) {
            this.HPa = weCoinIncomeDetailView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(com.tencent.mm.plugin.wallet.wecoin.model.a aVar) {
            AppMethodBeat.i(212846);
            WeCoinIncomeDetailView.a(this.HPa, aVar);
            AppMethodBeat.o(212846);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "onChanged", "(Ljava/lang/Boolean;)V"})
    static final class g<T> implements Observer<Boolean> {
        final /* synthetic */ WeCoinIncomeDetailView HPa;

        g(WeCoinIncomeDetailView weCoinIncomeDetailView) {
            this.HPa = weCoinIncomeDetailView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(Boolean bool) {
            AppMethodBeat.i(212847);
            WeCoinIncomeDetailView.a(this.HPa, bool);
            AppMethodBeat.o(212847);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/CoinBanner;", "onChanged"})
    static final class h<T> implements Observer<abq> {
        final /* synthetic */ WeCoinIncomeDetailView HPa;

        h(WeCoinIncomeDetailView weCoinIncomeDetailView) {
            this.HPa = weCoinIncomeDetailView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(abq abq) {
            AppMethodBeat.i(212848);
            WeCoinIncomeDetailView.a(this.HPa, abq);
            AppMethodBeat.o(212848);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "onChanged", "(Ljava/lang/Boolean;)V"})
    static final class i<T> implements Observer<Boolean> {
        final /* synthetic */ WeCoinIncomeDetailView HPa;

        i(WeCoinIncomeDetailView weCoinIncomeDetailView) {
            this.HPa = weCoinIncomeDetailView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(Boolean bool) {
            AppMethodBeat.i(212849);
            WeCoinIncomeDetailView.b(this.HPa, bool);
            AppMethodBeat.o(212849);
        }
    }

    public static final /* synthetic */ void a(WeCoinIncomeDetailView weCoinIncomeDetailView, Long l2) {
        AppMethodBeat.i(212869);
        weCoinIncomeDetailView.l(l2);
        AppMethodBeat.o(212869);
    }

    public static final /* synthetic */ WeCoinIncomeDetailViewModel b(WeCoinIncomeDetailView weCoinIncomeDetailView) {
        AppMethodBeat.i(212867);
        WeCoinIncomeDetailViewModel weCoinIncomeDetailViewModel = weCoinIncomeDetailView.HOX;
        if (weCoinIncomeDetailViewModel == null) {
            kotlin.g.b.p.btv("mViewModel");
        }
        AppMethodBeat.o(212867);
        return weCoinIncomeDetailViewModel;
    }

    public static final /* synthetic */ void d(WeCoinIncomeDetailView weCoinIncomeDetailView) {
        AppMethodBeat.i(212877);
        weCoinIncomeDetailView.fPJ();
        AppMethodBeat.o(212877);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView$Companion;", "", "()V", "REQUEST_CODE_GO_REAL_NAME", "", "TAG", "", "plugin-wxpay_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(212857);
        super.onCreate(bundle);
        initView();
        ViewModel viewModel = ViewModelProviders.of(this).get(WeCoinIncomeDetailViewModel.class);
        kotlin.g.b.p.g(viewModel, "ViewModelProviders.of(th…ailViewModel::class.java)");
        this.HOX = (WeCoinIncomeDetailViewModel) viewModel;
        WeCoinIncomeDetailViewModel weCoinIncomeDetailViewModel = this.HOX;
        if (weCoinIncomeDetailViewModel == null) {
            kotlin.g.b.p.btv("mViewModel");
        }
        weCoinIncomeDetailViewModel.HNt.observe(this, new b(this));
        WeCoinIncomeDetailViewModel weCoinIncomeDetailViewModel2 = this.HOX;
        if (weCoinIncomeDetailViewModel2 == null) {
            kotlin.g.b.p.btv("mViewModel");
        }
        weCoinIncomeDetailViewModel2.HNv.observe(this, new c(this));
        WeCoinIncomeDetailViewModel weCoinIncomeDetailViewModel3 = this.HOX;
        if (weCoinIncomeDetailViewModel3 == null) {
            kotlin.g.b.p.btv("mViewModel");
        }
        weCoinIncomeDetailViewModel3.HNu.observe(this, new d(this));
        WeCoinIncomeDetailViewModel weCoinIncomeDetailViewModel4 = this.HOX;
        if (weCoinIncomeDetailViewModel4 == null) {
            kotlin.g.b.p.btv("mViewModel");
        }
        weCoinIncomeDetailViewModel4.HNw.observe(this, new e(this));
        WeCoinIncomeDetailViewModel weCoinIncomeDetailViewModel5 = this.HOX;
        if (weCoinIncomeDetailViewModel5 == null) {
            kotlin.g.b.p.btv("mViewModel");
        }
        weCoinIncomeDetailViewModel5.HMQ.observe(this, new f(this));
        WeCoinIncomeDetailViewModel weCoinIncomeDetailViewModel6 = this.HOX;
        if (weCoinIncomeDetailViewModel6 == null) {
            kotlin.g.b.p.btv("mViewModel");
        }
        weCoinIncomeDetailViewModel6.HNy.observe(this, new g(this));
        WeCoinIncomeDetailViewModel weCoinIncomeDetailViewModel7 = this.HOX;
        if (weCoinIncomeDetailViewModel7 == null) {
            kotlin.g.b.p.btv("mViewModel");
        }
        weCoinIncomeDetailViewModel7.HNx.observe(this, new h(this));
        WeCoinIncomeDetailViewModel weCoinIncomeDetailViewModel8 = this.HOX;
        if (weCoinIncomeDetailViewModel8 == null) {
            kotlin.g.b.p.btv("mViewModel");
        }
        weCoinIncomeDetailViewModel8.qiR.observe(this, new i(this));
        WeCoinIncomeDetailViewModel weCoinIncomeDetailViewModel9 = this.HOX;
        if (weCoinIncomeDetailViewModel9 == null) {
            kotlin.g.b.p.btv("mViewModel");
        }
        WecoinEncashKVData wecoinEncashKVData = (WecoinEncashKVData) getIntent().getParcelableExtra("wecoin_enter_encash_business_kv_data");
        if (wecoinEncashKVData != null) {
            weCoinIncomeDetailViewModel9.HNm = new WecoinEncashKVData(wecoinEncashKVData.HNZ, wecoinEncashKVData.HMK, com.tencent.mm.plugin.wallet.wecoin.c.c.fPE());
        }
        WeCoinIncomeDetailViewModel weCoinIncomeDetailViewModel10 = this.HOX;
        if (weCoinIncomeDetailViewModel10 == null) {
            kotlin.g.b.p.btv("mViewModel");
        }
        bop fPM = com.tencent.mm.plugin.wallet.wecoin.c.c.fPM();
        if (fPM != null) {
            weCoinIncomeDetailViewModel10.HNt.postValue(fPM.LWK);
            weCoinIncomeDetailViewModel10.HNu.postValue(fPM.LWL);
            weCoinIncomeDetailViewModel10.HNv.postValue(Long.valueOf(fPM.LWJ));
            weCoinIncomeDetailViewModel10.HNw.postValue(fPM.LWN);
            weCoinIncomeDetailViewModel10.HNx.postValue(fPM.LWM);
            weCoinIncomeDetailViewModel10.HNz = fPM;
            AppMethodBeat.o(212857);
            return;
        }
        AppMethodBeat.o(212857);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(212858);
        super.onResume();
        WeCoinIncomeDetailViewModel weCoinIncomeDetailViewModel = this.HOX;
        if (weCoinIncomeDetailViewModel == null) {
            kotlin.g.b.p.btv("mViewModel");
        }
        WeCoinIncomeDetailView weCoinIncomeDetailView = this;
        kotlin.g.b.p.h(weCoinIncomeDetailView, "keeper");
        weCoinIncomeDetailViewModel.a("", 9, 1, 0, "");
        new com.tencent.mm.plugin.wallet.wecoin.b.g().aYI().b(new WeCoinIncomeDetailViewModel.b(weCoinIncomeDetailViewModel)).a(weCoinIncomeDetailView);
        AppMethodBeat.o(212858);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(212859);
        super.onDestroy();
        WeCoinIncomeDetailViewModel weCoinIncomeDetailViewModel = this.HOX;
        if (weCoinIncomeDetailViewModel == null) {
            kotlin.g.b.p.btv("mViewModel");
        }
        bop bop = weCoinIncomeDetailViewModel.HNz;
        if (bop != null) {
            kotlin.g.b.p.h(bop, "response");
            Log.d("MicroMsg.WeCoinUtils", "save WecoinIncomePageInfoResponse snapshot");
            com.tencent.mm.ac.d.i(new c.d(bop));
            AppMethodBeat.o(212859);
            return;
        }
        AppMethodBeat.o(212859);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public final void onBackPressed() {
        AppMethodBeat.i(212860);
        WeCoinIncomeDetailViewModel weCoinIncomeDetailViewModel = this.HOX;
        if (weCoinIncomeDetailViewModel == null) {
            kotlin.g.b.p.btv("mViewModel");
        }
        weCoinIncomeDetailViewModel.aeH(10);
        super.onBackPressed();
        AppMethodBeat.o(212860);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void initView() {
        AppMethodBeat.i(212861);
        setActionbarColor(getResources().getColor(R.color.afz));
        hideActionbarLine();
        setMMTitle("");
        View findViewById = findViewById(R.id.jdn);
        kotlin.g.b.p.g(findViewById, "findViewById(R.id.wallet_balance_view)");
        this.Hwb = (WcPayMoneyLoadingView) findViewById;
        View findViewById2 = findViewById(R.id.jg5);
        kotlin.g.b.p.g(findViewById2, "findViewById(R.id.wallet_money_load_pb)");
        this.zmU = (ProgressBar) findViewById2;
        View findViewById3 = findViewById(R.id.jm8);
        kotlin.g.b.p.g(findViewById3, "findViewById(R.id.wecoin_income_banner_ll)");
        this.HOW = (LinearLayout) findViewById3;
        WcPayMoneyLoadingView wcPayMoneyLoadingView = this.Hwb;
        if (wcPayMoneyLoadingView == null) {
            kotlin.g.b.p.btv("mBalanceView");
        }
        ProgressBar progressBar = this.zmU;
        if (progressBar == null) {
            kotlin.g.b.p.btv("mMoneyLoadingPb");
        }
        wcPayMoneyLoadingView.setLoadingPb(progressBar);
        WcPayMoneyLoadingView wcPayMoneyLoadingView2 = this.Hwb;
        if (wcPayMoneyLoadingView2 == null) {
            kotlin.g.b.p.btv("mBalanceView");
        }
        wcPayMoneyLoadingView2.setPrefixSymbol(getString(R.string.ir3));
        Lifecycle lifecycle = getLifecycle();
        WcPayMoneyLoadingView wcPayMoneyLoadingView3 = this.Hwb;
        if (wcPayMoneyLoadingView3 == null) {
            kotlin.g.b.p.btv("mBalanceView");
        }
        lifecycle.addObserver(wcPayMoneyLoadingView3);
        View findViewById4 = findViewById(R.id.jda);
        kotlin.g.b.p.g(findViewById4, "findViewById(R.id.wallet…alance_manager_fetch_btn)");
        this.HvV = (Button) findViewById4;
        View findViewById5 = findViewById(R.id.jdc);
        kotlin.g.b.p.g(findViewById5, "findViewById(R.id.wallet_balance_manager_qanda)");
        this.HOY = (TextView) findViewById5;
        ((WeImageView) findViewById(R.id.jma)).setOnClickListener(new j(this));
        TextView textView = this.HOY;
        if (textView == null) {
            kotlin.g.b.p.btv("mFaqTv");
        }
        ao.a(textView.getPaint(), 0.8f);
        setBackBtn(new k(this), R.raw.actionbar_icon_dark_back);
        l(0L);
        AppMethodBeat.o(212861);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class j implements View.OnClickListener {
        final /* synthetic */ WeCoinIncomeDetailView HPa;

        j(WeCoinIncomeDetailView weCoinIncomeDetailView) {
            this.HPa = weCoinIncomeDetailView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(212850);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            WeCoinIncomeDetailView.a(this.HPa);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(212850);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    public static final class k implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ WeCoinIncomeDetailView HPa;

        k(WeCoinIncomeDetailView weCoinIncomeDetailView) {
            this.HPa = weCoinIncomeDetailView;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(212851);
            WeCoinIncomeDetailView.b(this.HPa).aeH(10);
            this.HPa.finish();
            AppMethodBeat.o(212851);
            return true;
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.c2;
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick", "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView$updateRightOptionMenu$1$1"})
    public static final class o implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ WeCoinIncomeDetailView HPa;
        final /* synthetic */ String pFh;

        o(WeCoinIncomeDetailView weCoinIncomeDetailView, String str) {
            this.HPa = weCoinIncomeDetailView;
            this.pFh = str;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(212855);
            WeCoinIncomeDetailView.b(this.HPa).aeH(3);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", this.pFh);
            intent.putExtra("showShare", false);
            intent.putExtra(e.p.OzJ, true);
            com.tencent.mm.wallet_core.ui.f.aA(this.HPa.getContext(), intent);
            AppMethodBeat.o(212855);
            return true;
        }
    }

    private final void l(Long l2) {
        AppMethodBeat.i(212862);
        if (l2 != null) {
            String formatMoney2f = com.tencent.mm.wallet_core.ui.f.formatMoney2f(com.tencent.mm.wallet_core.ui.f.b(String.valueOf(l2.longValue()), "100", 2, RoundingMode.HALF_UP).doubleValue());
            WcPayMoneyLoadingView wcPayMoneyLoadingView = this.Hwb;
            if (wcPayMoneyLoadingView == null) {
                kotlin.g.b.p.btv("mBalanceView");
            }
            wcPayMoneyLoadingView.cH(formatMoney2f, false);
            AppMethodBeat.o(212862);
            return;
        }
        AppMethodBeat.o(212862);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView$updateFaqView$1$1"})
    public static final class n implements View.OnClickListener {
        final /* synthetic */ WeCoinIncomeDetailView HPa;
        final /* synthetic */ String pFh;

        n(WeCoinIncomeDetailView weCoinIncomeDetailView, String str) {
            this.HPa = weCoinIncomeDetailView;
            this.pFh = str;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(212854);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView$updateFaqView$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            WeCoinIncomeDetailView.b(this.HPa).aeH(7);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", this.pFh);
            intent.putExtra("showShare", false);
            intent.putExtra(e.p.OzJ, true);
            com.tencent.mm.wallet_core.ui.f.aA(this.HPa.getContext(), intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView$updateFaqView$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(212854);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView$updateTopBannerView$1$1"})
    public static final class p implements View.OnClickListener {
        final /* synthetic */ WeCoinIncomeDetailView HPa;
        final /* synthetic */ abq HPd;

        p(abq abq, WeCoinIncomeDetailView weCoinIncomeDetailView) {
            this.HPd = abq;
            this.HPa = weCoinIncomeDetailView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(212856);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView$updateTopBannerView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            WeCoinIncomeDetailView.b(this.HPa).aeH(9);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", this.HPd.url);
            com.tencent.mm.wallet_core.ui.f.aA(this.HPa, intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView$updateTopBannerView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(212856);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onActivityResult(int i2, int i3, Intent intent) {
        boolean z;
        AppMethodBeat.i(212863);
        Log.d("MicroMsg.WeCoinIncomeDetailView", "onActivityResult() requestCode:%d resultCode: %d", Integer.valueOf(i2), Integer.valueOf(i3));
        super.onActivityResult(i2, i3, intent);
        if (i2 != 2001) {
            AppMethodBeat.o(212863);
            return;
        }
        if (i3 == -1) {
            String stringExtra = intent != null ? intent.getStringExtra("intent_auth_token") : null;
            String str = stringExtra;
            if (str == null || str.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                WeCoinIncomeDetailViewModel weCoinIncomeDetailViewModel = this.HOX;
                if (weCoinIncomeDetailViewModel == null) {
                    kotlin.g.b.p.btv("mViewModel");
                }
                WeCoinIncomeDetailView weCoinIncomeDetailView = this;
                kotlin.g.b.p.h(stringExtra, "token");
                kotlin.g.b.p.h(weCoinIncomeDetailView, "keeper");
                com.tencent.mm.plugin.wallet.wecoin.c.a.a(weCoinIncomeDetailViewModel.qiR, Boolean.TRUE);
                String uuid = UUID.randomUUID().toString();
                kotlin.g.b.p.g(uuid, "uuid.toString()");
                weCoinIncomeDetailViewModel.a(uuid, 10, 1, 0, "");
                new com.tencent.mm.plugin.wallet.wecoin.b.e(stringExtra, uuid).aYI().b(new WeCoinIncomeDetailViewModel.c(weCoinIncomeDetailViewModel, uuid)).a(weCoinIncomeDetailView);
                AppMethodBeat.o(212863);
                return;
            }
        }
        WeCoinIncomeDetailViewModel weCoinIncomeDetailViewModel2 = this.HOX;
        if (weCoinIncomeDetailViewModel2 == null) {
            kotlin.g.b.p.btv("mViewModel");
        }
        weCoinIncomeDetailViewModel2.aeH(19);
        AppMethodBeat.o(212863);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "<anonymous parameter 0>", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "", "onClick"})
    public static final class l implements DialogInterface.OnClickListener {
        public static final l HPb = new l();

        static {
            AppMethodBeat.i(212852);
            AppMethodBeat.o(212852);
        }

        l() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class m implements View.OnClickListener {
        final /* synthetic */ WeCoinIncomeDetailView HPa;
        final /* synthetic */ djt HPc;

        m(WeCoinIncomeDetailView weCoinIncomeDetailView, djt djt) {
            this.HPa = weCoinIncomeDetailView;
            this.HPc = djt;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(212853);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView$updateClickButtonEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            WeCoinIncomeDetailView.b(this.HPa).aeH(2);
            djt djt = this.HPc;
            if (djt == null || djt.status != 1) {
                WeCoinIncomeDetailView.d(this.HPa);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView$updateClickButtonEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(212853);
                return;
            }
            WeCoinIncomeDetailView.b(this.HPa).aeH(11);
            WeCoinIncomeDetailView.a(this.HPa, djt);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView$updateClickButtonEvent$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(212853);
        }
    }

    private final void fPJ() {
        AppMethodBeat.i(212864);
        Log.d("MicroMsg.WeCoinIncomeDetailView", "gotoIncomeBalanceView: ");
        Intent intent = new Intent(getContext(), WeCoinEncashView.class);
        WeCoinIncomeDetailViewModel weCoinIncomeDetailViewModel = this.HOX;
        if (weCoinIncomeDetailViewModel == null) {
            kotlin.g.b.p.btv("mViewModel");
        }
        Long value = weCoinIncomeDetailViewModel.HNv.getValue();
        if (value != null) {
            intent.putExtra("wecoin_income_balance", value.longValue());
        }
        WeCoinIncomeDetailViewModel weCoinIncomeDetailViewModel2 = this.HOX;
        if (weCoinIncomeDetailViewModel2 == null) {
            kotlin.g.b.p.btv("mViewModel");
        }
        intent.putExtra("wecoin_enter_encash_business_kv_data", weCoinIncomeDetailViewModel2.HNm);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView", "gotoIncomeBalanceView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinIncomeDetailView", "gotoIncomeBalanceView", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(212864);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/RealNameAuthInfo;", "onChanged"})
    static final class e<T> implements Observer<djt> {
        final /* synthetic */ WeCoinIncomeDetailView HPa;

        e(WeCoinIncomeDetailView weCoinIncomeDetailView) {
            this.HPa = weCoinIncomeDetailView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(djt djt) {
            AppMethodBeat.i(212845);
            WeCoinIncomeDetailView.c(this.HPa);
            AppMethodBeat.o(212845);
        }
    }

    public static final /* synthetic */ void a(WeCoinIncomeDetailView weCoinIncomeDetailView) {
        AppMethodBeat.i(212866);
        WeCoinIncomeDetailViewModel weCoinIncomeDetailViewModel = weCoinIncomeDetailView.HOX;
        if (weCoinIncomeDetailViewModel == null) {
            kotlin.g.b.p.btv("mViewModel");
        }
        weCoinIncomeDetailViewModel.aeH(1);
        String string = weCoinIncomeDetailView.getString(R.string.j2e);
        kotlin.g.b.p.g(string, "getString(R.string.wecoi…cash_tips_dialog_content)");
        String string2 = weCoinIncomeDetailView.getString(R.string.j2c);
        kotlin.g.b.p.g(string2, "getString(R.string.wecoi…ft_button_common_wording)");
        com.tencent.mm.ui.base.h.a((Context) weCoinIncomeDetailView.getContext(), string, "", string2, false, (DialogInterface.OnClickListener) l.HPb);
        AppMethodBeat.o(212866);
    }

    public static final /* synthetic */ void a(WeCoinIncomeDetailView weCoinIncomeDetailView, String str) {
        AppMethodBeat.i(212868);
        weCoinIncomeDetailView.removeAllOptionMenu();
        if (str != null) {
            String string = weCoinIncomeDetailView.getString(R.string.j2m);
            kotlin.g.b.p.g(string, "getString(R.string.wecoi…tax_income_option_detail)");
            weCoinIncomeDetailView.addTextOptionMenu(0, string, new o(weCoinIncomeDetailView, str), null, t.b.TRANSPARENT_BG_BLACK_TEXT);
        }
        AppMethodBeat.o(212868);
    }

    public static final /* synthetic */ void c(WeCoinIncomeDetailView weCoinIncomeDetailView) {
        AppMethodBeat.i(212870);
        WeCoinIncomeDetailViewModel weCoinIncomeDetailViewModel = weCoinIncomeDetailView.HOX;
        if (weCoinIncomeDetailViewModel == null) {
            kotlin.g.b.p.btv("mViewModel");
        }
        djt value = weCoinIncomeDetailViewModel.HNw.getValue();
        WeCoinIncomeDetailViewModel weCoinIncomeDetailViewModel2 = weCoinIncomeDetailView.HOX;
        if (weCoinIncomeDetailViewModel2 == null) {
            kotlin.g.b.p.btv("mViewModel");
        }
        Long value2 = weCoinIncomeDetailViewModel2.HNv.getValue();
        if (value2 == null) {
            value2 = 0L;
        }
        kotlin.g.b.p.g(value2, "mViewModel.getIncomeBalance().value ?: 0");
        long longValue = value2.longValue();
        Log.d("MicroMsg.WeCoinIncomeDetailView", "updateClickButtonEvent, AuthInfo: " + value + ", balance: " + longValue);
        Button button = weCoinIncomeDetailView.HvV;
        if (button == null) {
            kotlin.g.b.p.btv("mFetchBtn");
        }
        button.setEnabled(false);
        if (longValue > 0) {
            Button button2 = weCoinIncomeDetailView.HvV;
            if (button2 == null) {
                kotlin.g.b.p.btv("mFetchBtn");
            }
            button2.setEnabled(true);
            Button button3 = weCoinIncomeDetailView.HvV;
            if (button3 == null) {
                kotlin.g.b.p.btv("mFetchBtn");
            }
            button3.setOnClickListener(new m(weCoinIncomeDetailView, value));
        }
        AppMethodBeat.o(212870);
    }

    public static final /* synthetic */ void b(WeCoinIncomeDetailView weCoinIncomeDetailView, String str) {
        AppMethodBeat.i(212871);
        TextView textView = weCoinIncomeDetailView.HOY;
        if (textView == null) {
            kotlin.g.b.p.btv("mFaqTv");
        }
        textView.setVisibility(4);
        if (str != null) {
            TextView textView2 = weCoinIncomeDetailView.HOY;
            if (textView2 == null) {
                kotlin.g.b.p.btv("mFaqTv");
            }
            textView2.setOnClickListener(new n(weCoinIncomeDetailView, str));
            TextView textView3 = weCoinIncomeDetailView.HOY;
            if (textView3 == null) {
                kotlin.g.b.p.btv("mFaqTv");
            }
            textView3.setVisibility(0);
        }
        AppMethodBeat.o(212871);
    }

    public static final /* synthetic */ void a(WeCoinIncomeDetailView weCoinIncomeDetailView, com.tencent.mm.plugin.wallet.wecoin.model.a aVar) {
        AppMethodBeat.i(212872);
        AppCompatActivity context = weCoinIncomeDetailView.getContext();
        kotlin.g.b.p.g(context, "context");
        com.tencent.mm.plugin.wallet.wecoin.c.c.a(context, aVar);
        AppMethodBeat.o(212872);
    }

    public static final /* synthetic */ void a(WeCoinIncomeDetailView weCoinIncomeDetailView, Boolean bool) {
        AppMethodBeat.i(212873);
        Log.d("MicroMsg.WeCoinIncomeDetailView", "updateAuthored: ".concat(String.valueOf(bool)));
        if (bool != null) {
            if (bool.booleanValue()) {
                weCoinIncomeDetailView.fPJ();
            }
            AppMethodBeat.o(212873);
            return;
        }
        AppMethodBeat.o(212873);
    }

    public static final /* synthetic */ void a(WeCoinIncomeDetailView weCoinIncomeDetailView, abq abq) {
        boolean z;
        AppMethodBeat.i(212874);
        LinearLayout linearLayout = weCoinIncomeDetailView.HOW;
        if (linearLayout == null) {
            kotlin.g.b.p.btv("mIncomeBalanceLL");
        }
        linearLayout.setVisibility(8);
        if (abq != null) {
            String str = abq.content;
            if (!(str == null || str.length() == 0)) {
                WeCoinIncomeDetailViewModel weCoinIncomeDetailViewModel = weCoinIncomeDetailView.HOX;
                if (weCoinIncomeDetailViewModel == null) {
                    kotlin.g.b.p.btv("mViewModel");
                }
                weCoinIncomeDetailViewModel.aeH(8);
                LinearLayout linearLayout2 = weCoinIncomeDetailView.HOW;
                if (linearLayout2 == null) {
                    kotlin.g.b.p.btv("mIncomeBalanceLL");
                }
                linearLayout2.setVisibility(0);
                LinearLayout linearLayout3 = weCoinIncomeDetailView.HOW;
                if (linearLayout3 == null) {
                    kotlin.g.b.p.btv("mIncomeBalanceLL");
                }
                TextView textView = (TextView) linearLayout3.findViewById(R.id.jm_);
                kotlin.g.b.p.g(textView, "bannerText");
                textView.setText(abq.content);
                LinearLayout linearLayout4 = weCoinIncomeDetailView.HOW;
                if (linearLayout4 == null) {
                    kotlin.g.b.p.btv("mIncomeBalanceLL");
                }
                WeImageView weImageView = (WeImageView) linearLayout4.findViewById(R.id.jm9);
                String str2 = abq.url;
                if (str2 == null || str2.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    kotlin.g.b.p.g(weImageView, "iconsRight");
                    weImageView.setVisibility(8);
                    AppMethodBeat.o(212874);
                    return;
                }
                kotlin.g.b.p.g(weImageView, "iconsRight");
                weImageView.setVisibility(0);
                LinearLayout linearLayout5 = weCoinIncomeDetailView.HOW;
                if (linearLayout5 == null) {
                    kotlin.g.b.p.btv("mIncomeBalanceLL");
                }
                linearLayout5.setOnClickListener(new p(abq, weCoinIncomeDetailView));
            }
            AppMethodBeat.o(212874);
            return;
        }
        AppMethodBeat.o(212874);
    }

    public static final /* synthetic */ void b(WeCoinIncomeDetailView weCoinIncomeDetailView, Boolean bool) {
        q qVar;
        AppMethodBeat.i(212875);
        Log.d("MicroMsg.WeCoinIncomeDetailView", "showProgressDialog: ".concat(String.valueOf(bool)));
        if (bool != null) {
            if (bool.booleanValue()) {
                qVar = q.a(weCoinIncomeDetailView.getContext(), weCoinIncomeDetailView.getContext().getString(R.string.ekc), false, 3, null);
            } else {
                q qVar2 = weCoinIncomeDetailView.gxX;
                if (qVar2 != null) {
                    qVar2.dismiss();
                }
                qVar = null;
            }
            weCoinIncomeDetailView.gxX = qVar;
        }
        AppMethodBeat.o(212875);
    }

    public static final /* synthetic */ void a(WeCoinIncomeDetailView weCoinIncomeDetailView, djt djt) {
        String str;
        String str2 = null;
        AppMethodBeat.i(212876);
        Log.d("MicroMsg.WeCoinIncomeDetailView", "openRealNameAuth, info: ".concat(String.valueOf(djt)));
        Intent intent = new Intent(weCoinIncomeDetailView, AppBrandIDCardUI.class);
        intent.putExtra("intent_appid", djt.dNI);
        intent.putExtra("intent_category_id", new JSONArray((Collection) djt.MNJ).toString());
        intent.putExtra("intent_auth_type", djt.MNK);
        intent.putExtra("id_ui_theme", 2);
        intent.putExtra("wecoin_apply_info", djt.MNL);
        intent.putExtra("wecoin_protocol_url", djt.egn);
        WeCoinIncomeDetailViewModel weCoinIncomeDetailViewModel = weCoinIncomeDetailView.HOX;
        if (weCoinIncomeDetailViewModel == null) {
            kotlin.g.b.p.btv("mViewModel");
        }
        WecoinEncashKVData wecoinEncashKVData = weCoinIncomeDetailViewModel.HNm;
        intent.putExtra("wecoin_kv_scene_id", wecoinEncashKVData != null ? Integer.valueOf(wecoinEncashKVData.HNZ) : null);
        WeCoinIncomeDetailViewModel weCoinIncomeDetailViewModel2 = weCoinIncomeDetailView.HOX;
        if (weCoinIncomeDetailViewModel2 == null) {
            kotlin.g.b.p.btv("mViewModel");
        }
        WecoinEncashKVData wecoinEncashKVData2 = weCoinIncomeDetailViewModel2.HNm;
        if (wecoinEncashKVData2 != null) {
            str = wecoinEncashKVData2.HMK;
        } else {
            str = null;
        }
        intent.putExtra("wecoin_kv_session_id", str);
        WeCoinIncomeDetailViewModel weCoinIncomeDetailViewModel3 = weCoinIncomeDetailView.HOX;
        if (weCoinIncomeDetailViewModel3 == null) {
            kotlin.g.b.p.btv("mViewModel");
        }
        WecoinEncashKVData wecoinEncashKVData3 = weCoinIncomeDetailViewModel3.HNm;
        if (wecoinEncashKVData3 != null) {
            str2 = wecoinEncashKVData3.nZz;
        }
        intent.putExtra("wecoin_kv_cgi_session_id", str2);
        com.tencent.mm.br.c.b(weCoinIncomeDetailView.getContext(), "appbrand", ".ui.autofill.AppBrandIDCardUI", intent, 2001);
        AppMethodBeat.o(212876);
    }
}
