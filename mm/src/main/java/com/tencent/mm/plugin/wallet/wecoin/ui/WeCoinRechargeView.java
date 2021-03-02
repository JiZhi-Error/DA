package com.tencent.mm.plugin.wallet.wecoin.ui;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet.wecoin.c.c;
import com.tencent.mm.plugin.wallet.wecoin.model.WeCoinRechargeViewModel;
import com.tencent.mm.plugin.wallet.wecoin.model.WecoinEncashKVData;
import com.tencent.mm.plugin.wallet.wecoin.model.e;
import com.tencent.mm.plugin.wallet.wecoin.model.h;
import com.tencent.mm.plugin.wallet_core.ui.view.WcPayMoneyLoadingView;
import com.tencent.mm.protocal.protobuf.abq;
import com.tencent.mm.protocal.protobuf.byp;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.t;
import com.tencent.mm.ui.widget.a.g;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.tinker.loader.hotplug.EnvConsts;
import java.math.RoundingMode;
import kotlin.t;
import kotlin.x;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u0000 :2\u00020\u0001:\u0001:B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0015H\u0014J\b\u0010\u0019\u001a\u00020\u0015H\u0002J\b\u0010\u001a\u001a\u00020\u0015H\u0002J\b\u0010\u001b\u001a\u00020\u0015H\u0016J\u0012\u0010\u001c\u001a\u00020\u00152\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0015H\u0014J\b\u0010 \u001a\u00020\u0015H\u0014J\u0017\u0010!\u001a\u00020\u00152\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0002\u0010$J\u0012\u0010%\u001a\u00020\u00152\b\u0010&\u001a\u0004\u0018\u00010'H\u0002J\b\u0010(\u001a\u00020\u0015H\u0002J\u0017\u0010)\u001a\u00020\u00152\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0002\u0010$J\u0012\u0010*\u001a\u00020\u00152\b\u0010+\u001a\u0004\u0018\u00010,H\u0002J\u0012\u0010-\u001a\u00020\u00152\b\u0010.\u001a\u0004\u0018\u00010/H\u0002J\b\u00100\u001a\u00020\u0015H\u0002J\u0017\u00101\u001a\u00020\u00152\b\u00102\u001a\u0004\u0018\u00010#H\u0002¢\u0006\u0002\u0010$J\u0012\u00103\u001a\u00020\u00152\b\u0010+\u001a\u0004\u0018\u00010,H\u0002J\u0012\u00104\u001a\u00020\u00152\b\u00105\u001a\u0004\u0018\u000106H\u0002J\u0017\u00107\u001a\u00020\u00152\b\u0010.\u001a\u0004\u0018\u000108H\u0002¢\u0006\u0002\u00109R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000¨\u0006;"}, hxF = {"Lcom/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "mBalanceView", "Lcom/tencent/mm/plugin/wallet_core/ui/view/WcPayMoneyLoadingView;", "mBannerView", "Landroid/view/View;", "mFaqTv", "Landroid/widget/TextView;", "mMoneyLoadingPb", "Landroid/widget/ProgressBar;", "mNoBalanceTipsTv", "mSwitchDeviceTipsView", "mTotalBalanceLl", "Landroid/widget/LinearLayout;", "mViewModel", "Lcom/tencent/mm/plugin/wallet/wecoin/model/WeCoinRechargeViewModel;", "mWeCoinBalanceView", "mWeCoinRechargeButton", "Landroid/widget/Button;", "bindData", "", "getLayoutId", "", "initView", "loadCacheData", "loadData", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "showDeviceSwitchTips", "hasShow", "", "(Ljava/lang/Boolean;)V", "showErrorMsg", "info", "Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "showGridBottomSheet", "showTutorialDialog", "updateFaqView", "url", "", "updateIncomeBalance", "balance", "Lcom/tencent/mm/plugin/wallet/wecoin/model/UserIncomeDetailData;", "updateMainContentView", "updateRechargeButtonState", "midasInitialized", "updateRightOptionMenu", "updateTopBannerView", "bannerContent", "Lcom/tencent/mm/protocal/protobuf/CoinBanner;", "updateTotalBalance", "", "(Ljava/lang/Long;)V", "Companion", "plugin-wxpay_release"})
public final class WeCoinRechargeView extends MMActivity {
    public static final a HPl = new a((byte) 0);
    private TextView HOY;
    private WeCoinRechargeViewModel HPe;
    private LinearLayout HPf;
    private TextView HPg;
    private View HPh;
    private TextView HPi;
    private Button HPj;
    private TextView HPk;
    private WcPayMoneyLoadingView Hwb;
    private ProgressBar zmU;

    static {
        AppMethodBeat.i(212901);
        AppMethodBeat.o(212901);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "onChanged", "(Ljava/lang/Boolean;)V"})
    static final class b<T> implements Observer<Boolean> {
        final /* synthetic */ WeCoinRechargeView HPm;

        b(WeCoinRechargeView weCoinRechargeView) {
            this.HPm = weCoinRechargeView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(Boolean bool) {
            AppMethodBeat.i(212878);
            WeCoinRechargeView.a(this.HPm, bool);
            AppMethodBeat.o(212878);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/wallet/wecoin/model/UserIncomeDetailData;", "onChanged"})
    static final class c<T> implements Observer<com.tencent.mm.plugin.wallet.wecoin.model.f> {
        final /* synthetic */ WeCoinRechargeView HPm;

        c(WeCoinRechargeView weCoinRechargeView) {
            this.HPm = weCoinRechargeView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(com.tencent.mm.plugin.wallet.wecoin.model.f fVar) {
            AppMethodBeat.i(212879);
            WeCoinRechargeView.a(this.HPm, fVar);
            AppMethodBeat.o(212879);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "onChanged", "(Ljava/lang/Long;)V"})
    static final class d<T> implements Observer<Long> {
        final /* synthetic */ WeCoinRechargeView HPm;

        d(WeCoinRechargeView weCoinRechargeView) {
            this.HPm = weCoinRechargeView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(Long l) {
            AppMethodBeat.i(212880);
            WeCoinRechargeView.a(this.HPm, l);
            AppMethodBeat.o(212880);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "onChanged"})
    static final class e<T> implements Observer<String> {
        final /* synthetic */ WeCoinRechargeView HPm;

        e(WeCoinRechargeView weCoinRechargeView) {
            this.HPm = weCoinRechargeView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(String str) {
            AppMethodBeat.i(212881);
            WeCoinRechargeView.a(this.HPm, str);
            AppMethodBeat.o(212881);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "onChanged"})
    static final class f<T> implements Observer<String> {
        final /* synthetic */ WeCoinRechargeView HPm;

        f(WeCoinRechargeView weCoinRechargeView) {
            this.HPm = weCoinRechargeView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(String str) {
            AppMethodBeat.i(212882);
            WeCoinRechargeView.b(this.HPm, str);
            AppMethodBeat.o(212882);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "onChanged"})
    static final class g<T> implements Observer<com.tencent.mm.plugin.wallet.wecoin.model.a> {
        final /* synthetic */ WeCoinRechargeView HPm;

        g(WeCoinRechargeView weCoinRechargeView) {
            this.HPm = weCoinRechargeView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(com.tencent.mm.plugin.wallet.wecoin.model.a aVar) {
            AppMethodBeat.i(212883);
            WeCoinRechargeView.a(this.HPm, aVar);
            AppMethodBeat.o(212883);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/CoinBanner;", "onChanged"})
    static final class h<T> implements Observer<abq> {
        final /* synthetic */ WeCoinRechargeView HPm;

        h(WeCoinRechargeView weCoinRechargeView) {
            this.HPm = weCoinRechargeView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(abq abq) {
            AppMethodBeat.i(212884);
            WeCoinRechargeView.a(this.HPm, abq);
            AppMethodBeat.o(212884);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "onChanged", "(Ljava/lang/Boolean;)V"})
    static final class i<T> implements Observer<Boolean> {
        final /* synthetic */ WeCoinRechargeView HPm;

        i(WeCoinRechargeView weCoinRechargeView) {
            this.HPm = weCoinRechargeView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(Boolean bool) {
            AppMethodBeat.i(212885);
            Boolean bool2 = bool;
            WeCoinRechargeView.b(this.HPm, bool2);
            WeCoinRechargeView.c(this.HPm, bool2);
            WeCoinRechargeView.a(this.HPm);
            WeCoinRechargeViewModel.fPI();
            AppMethodBeat.o(212885);
        }
    }

    public static final /* synthetic */ WeCoinRechargeViewModel a(WeCoinRechargeView weCoinRechargeView) {
        AppMethodBeat.i(212902);
        WeCoinRechargeViewModel weCoinRechargeViewModel = weCoinRechargeView.HPe;
        if (weCoinRechargeViewModel == null) {
            kotlin.g.b.p.btv("mViewModel");
        }
        AppMethodBeat.o(212902);
        return weCoinRechargeViewModel;
    }

    public static final /* synthetic */ void a(WeCoinRechargeView weCoinRechargeView, Boolean bool) {
        AppMethodBeat.i(212904);
        weCoinRechargeView.o(bool);
        AppMethodBeat.o(212904);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$Companion;", "", "()V", "TAG", "", "plugin-wxpay_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onCreate(Bundle bundle) {
        AppMethodBeat.i(212895);
        super.onCreate(bundle);
        initView();
        ViewModel viewModel = ViewModelProviders.of(this).get(WeCoinRechargeViewModel.class);
        kotlin.g.b.p.g(viewModel, "ViewModelProviders.of(th…rgeViewModel::class.java)");
        this.HPe = (WeCoinRechargeViewModel) viewModel;
        WeCoinRechargeViewModel weCoinRechargeViewModel = this.HPe;
        if (weCoinRechargeViewModel == null) {
            kotlin.g.b.p.btv("mViewModel");
        }
        weCoinRechargeViewModel.HNS.observe(this, new b(this));
        WeCoinRechargeViewModel weCoinRechargeViewModel2 = this.HPe;
        if (weCoinRechargeViewModel2 == null) {
            kotlin.g.b.p.btv("mViewModel");
        }
        weCoinRechargeViewModel2.HNv.observe(this, new c(this));
        WeCoinRechargeViewModel weCoinRechargeViewModel3 = this.HPe;
        if (weCoinRechargeViewModel3 == null) {
            kotlin.g.b.p.btv("mViewModel");
        }
        weCoinRechargeViewModel3.HMR.observe(this, new d(this));
        WeCoinRechargeViewModel weCoinRechargeViewModel4 = this.HPe;
        if (weCoinRechargeViewModel4 == null) {
            kotlin.g.b.p.btv("mViewModel");
        }
        weCoinRechargeViewModel4.HNU.observe(this, new e(this));
        WeCoinRechargeViewModel weCoinRechargeViewModel5 = this.HPe;
        if (weCoinRechargeViewModel5 == null) {
            kotlin.g.b.p.btv("mViewModel");
        }
        weCoinRechargeViewModel5.HNT.observe(this, new f(this));
        WeCoinRechargeViewModel weCoinRechargeViewModel6 = this.HPe;
        if (weCoinRechargeViewModel6 == null) {
            kotlin.g.b.p.btv("mViewModel");
        }
        weCoinRechargeViewModel6.HMQ.observe(this, new g(this));
        WeCoinRechargeViewModel weCoinRechargeViewModel7 = this.HPe;
        if (weCoinRechargeViewModel7 == null) {
            kotlin.g.b.p.btv("mViewModel");
        }
        weCoinRechargeViewModel7.HNx.observe(this, new h(this));
        WeCoinRechargeViewModel weCoinRechargeViewModel8 = this.HPe;
        if (weCoinRechargeViewModel8 == null) {
            kotlin.g.b.p.btv("mViewModel");
        }
        weCoinRechargeViewModel8.HNV.observe(this, new i(this));
        WeCoinRechargeViewModel weCoinRechargeViewModel9 = this.HPe;
        if (weCoinRechargeViewModel9 == null) {
            kotlin.g.b.p.btv("mViewModel");
        }
        byp fPL = com.tencent.mm.plugin.wallet.wecoin.c.c.fPL();
        if (fPL != null) {
            Log.i("MicroMsg.WeCoinRechargeViewModel", "load wecoin page info snapshot");
            com.tencent.mm.plugin.wallet.wecoin.c.c.d("MicroMsg.WeCoinRechargeViewModel", fPL);
            weCoinRechargeViewModel9.HNv.postValue(new com.tencent.mm.plugin.wallet.wecoin.model.f(fPL.MdX, fPL.LWJ));
            weCoinRechargeViewModel9.HMR.postValue(Long.valueOf(fPL.LoC));
            weCoinRechargeViewModel9.HNT.postValue(fPL.LWL);
            weCoinRechargeViewModel9.HNU.postValue(fPL.MdW);
            weCoinRechargeViewModel9.HNx.postValue(fPL.LWM);
            weCoinRechargeViewModel9.HNW = fPL;
            AppMethodBeat.o(212895);
            return;
        }
        AppMethodBeat.o(212895);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onResume() {
        AppMethodBeat.i(212896);
        super.onResume();
        WeCoinRechargeViewModel weCoinRechargeViewModel = this.HPe;
        if (weCoinRechargeViewModel == null) {
            kotlin.g.b.p.btv("mViewModel");
        }
        com.tencent.mm.kernel.e aAh = com.tencent.mm.kernel.g.aAh();
        kotlin.g.b.p.g(aAh, "MMKernel.storage()");
        Object obj = aAh.azQ().get(ar.a.USERINFO_WECOIN_PAGE_HAS_SHOW_TUTORIAL_BOOLEAN_SYNC, Boolean.FALSE);
        if (obj == null) {
            t tVar = new t("null cannot be cast to non-null type kotlin.Boolean");
            AppMethodBeat.o(212896);
            throw tVar;
        }
        weCoinRechargeViewModel.HNV.postValue(Boolean.valueOf(((Boolean) obj).booleanValue()));
        WeCoinRechargeViewModel weCoinRechargeViewModel2 = this.HPe;
        if (weCoinRechargeViewModel2 == null) {
            kotlin.g.b.p.btv("mViewModel");
        }
        WeCoinRechargeView weCoinRechargeView = this;
        kotlin.g.b.p.h(weCoinRechargeView, EnvConsts.ACTIVITY_MANAGER_SRVNAME);
        WeCoinRechargeViewModel.c cVar = new WeCoinRechargeViewModel.c(weCoinRechargeViewModel2);
        h.a aVar = com.tencent.mm.plugin.wallet.wecoin.model.h.HNL;
        com.tencent.mm.plugin.wallet.wecoin.model.h.HNK.b(weCoinRechargeView, cVar);
        WeCoinRechargeViewModel weCoinRechargeViewModel3 = this.HPe;
        if (weCoinRechargeViewModel3 == null) {
            kotlin.g.b.p.btv("mViewModel");
        }
        WeCoinRechargeView weCoinRechargeView2 = this;
        kotlin.g.b.p.h(weCoinRechargeView2, "keeper");
        WeCoinRechargeViewModel.L(1, 0, "");
        new com.tencent.mm.plugin.wallet.wecoin.b.h().aYI().b(new WeCoinRechargeViewModel.b(weCoinRechargeViewModel3)).a(weCoinRechargeView2);
        AppMethodBeat.o(212896);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, android.support.v4.app.FragmentActivity
    public final void onBackPressed() {
        AppMethodBeat.i(212897);
        if (this.HPe == null) {
            kotlin.g.b.p.btv("mViewModel");
        }
        WeCoinRechargeViewModel.aeH(8);
        super.onBackPressed();
        AppMethodBeat.o(212897);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public final void onDestroy() {
        AppMethodBeat.i(212898);
        super.onDestroy();
        WeCoinRechargeViewModel weCoinRechargeViewModel = this.HPe;
        if (weCoinRechargeViewModel == null) {
            kotlin.g.b.p.btv("mViewModel");
        }
        byp byp = weCoinRechargeViewModel.HNW;
        if (byp != null) {
            kotlin.g.b.p.h(byp, "response");
            Log.d("MicroMsg.WeCoinUtils", "save WecoinPageInfoResponse snapshot");
            com.tencent.mm.ac.d.i(new c.e(byp));
            AppMethodBeat.o(212898);
            return;
        }
        AppMethodBeat.o(212898);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.c3;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void initView() {
        AppMethodBeat.i(212899);
        setContentViewVisibility(0);
        setActionbarColor(getResources().getColor(R.color.afw));
        View findViewById = findViewById(R.id.jm0);
        kotlin.g.b.p.g(findViewById, "findViewById(R.id.wecoin_balance_account_ll)");
        this.HPf = (LinearLayout) findViewById;
        View findViewById2 = findViewById(R.id.jk3);
        kotlin.g.b.p.g(findViewById2, "findViewById(R.id.we_coin_no_balance_tips_tv)");
        this.HPg = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.jme);
        kotlin.g.b.p.g(findViewById3, "findViewById(R.id.wecoin_recharge_banner_ll)");
        this.HPh = findViewById3;
        View findViewById4 = findViewById(R.id.jk1);
        kotlin.g.b.p.g(findViewById4, "findViewById(R.id.we_coin_balance_tv)");
        this.HPi = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.jmh);
        kotlin.g.b.p.g(findViewById5, "findViewById(R.id.wecoin_switch_device_tips)");
        this.HPk = (TextView) findViewById5;
        String aqk = com.tencent.mm.wallet_core.ui.f.aqk(0);
        try {
            TextView textView = this.HPi;
            if (textView == null) {
                kotlin.g.b.p.btv("mWeCoinBalanceView");
            }
            AppCompatActivity context = getContext();
            kotlin.g.b.p.g(context, "context");
            textView.setTypeface(Typeface.createFromAsset(context.getAssets(), aqk));
        } catch (Exception e2) {
            Log.e("MicroMsg.WeCoinRechargeView", "setTypeface() Exception:%s", e2.getMessage());
        }
        View findViewById6 = findViewById(R.id.jdn);
        kotlin.g.b.p.g(findViewById6, "findViewById(R.id.wallet_balance_view)");
        this.Hwb = (WcPayMoneyLoadingView) findViewById6;
        View findViewById7 = findViewById(R.id.jg5);
        kotlin.g.b.p.g(findViewById7, "findViewById(R.id.wallet_money_load_pb)");
        this.zmU = (ProgressBar) findViewById7;
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
        View findViewById8 = findViewById(R.id.jm4);
        kotlin.g.b.p.g(findViewById8, "findViewById(R.id.wecoin_detail_faq_link_tv)");
        this.HOY = (TextView) findViewById8;
        TextView textView2 = this.HOY;
        if (textView2 == null) {
            kotlin.g.b.p.btv("mFaqTv");
        }
        ao.a(textView2.getPaint(), 0.8f);
        hideActionbarLine();
        setBackBtn(new j(this));
        setMMTitle("");
        View findViewById9 = findViewById(R.id.jmf);
        kotlin.g.b.p.g(findViewById9, "findViewById(R.id.wecoin_recharge_btn)");
        this.HPj = (Button) findViewById9;
        Window window = getWindow();
        kotlin.g.b.p.g(window, "window");
        window.getDecorView().post(new k(this));
        WcPayMoneyLoadingView wcPayMoneyLoadingView4 = this.Hwb;
        if (wcPayMoneyLoadingView4 == null) {
            kotlin.g.b.p.btv("mBalanceView");
        }
        wcPayMoneyLoadingView4.cH(AppEventsConstants.EVENT_PARAM_VALUE_NO, false);
        o(Boolean.FALSE);
        AppMethodBeat.o(212899);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    public static final class j implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ WeCoinRechargeView HPm;

        j(WeCoinRechargeView weCoinRechargeView) {
            this.HPm = weCoinRechargeView;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(212886);
            WeCoinRechargeView.a(this.HPm);
            WeCoinRechargeViewModel.aeH(8);
            this.HPm.finish();
            AppMethodBeat.o(212886);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class k implements Runnable {
        final /* synthetic */ WeCoinRechargeView HPm;

        k(WeCoinRechargeView weCoinRechargeView) {
            this.HPm = weCoinRechargeView;
        }

        public final void run() {
            AppMethodBeat.i(212887);
            WeCoinRechargeView.b(this.HPm);
            AppMethodBeat.o(212887);
        }
    }

    private final void o(Boolean bool) {
        AppMethodBeat.i(212900);
        Button button = this.HPj;
        if (button == null) {
            kotlin.g.b.p.btv("mWeCoinRechargeButton");
        }
        button.setEnabled(false);
        if (bool != null) {
            if (bool.booleanValue()) {
                Button button2 = this.HPj;
                if (button2 == null) {
                    kotlin.g.b.p.btv("mWeCoinRechargeButton");
                }
                button2.setEnabled(true);
                Button button3 = this.HPj;
                if (button3 == null) {
                    kotlin.g.b.p.btv("mWeCoinRechargeButton");
                }
                button3.setOnClickListener(new o(this));
            }
            AppMethodBeat.o(212900);
            return;
        }
        AppMethodBeat.o(212900);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$updateRechargeButtonState$1$1"})
    public static final class o implements View.OnClickListener {
        final /* synthetic */ WeCoinRechargeView HPm;

        o(WeCoinRechargeView weCoinRechargeView) {
            this.HPm = weCoinRechargeView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(212891);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$updateRechargeButtonState$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (!com.tencent.mm.plugin.wallet.wecoin.c.c.isFastClick()) {
                WeCoinRechargeView.a(this.HPm);
                WeCoinRechargeViewModel.aeH(4);
                WeCoinRechargeView.c(this.HPm);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$updateRechargeButtonState$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(212891);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$updateIncomeBalance$1$1"})
    public static final class n implements View.OnClickListener {
        final /* synthetic */ WeCoinRechargeView HPm;
        final /* synthetic */ LinearLayout HPo;

        n(WeCoinRechargeView weCoinRechargeView, LinearLayout linearLayout) {
            this.HPm = weCoinRechargeView;
            this.HPo = linearLayout;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(212890);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$updateIncomeBalance$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            WeCoinRechargeView.a(this.HPm);
            WeCoinRechargeViewModel.aeH(7);
            Intent intent = new Intent(this.HPm.getContext(), WeCoinIncomeDetailView.class);
            intent.putExtra("wecoin_enter_encash_business_kv_data", new WecoinEncashKVData(2, "", ""));
            WeCoinRechargeView weCoinRechargeView = this.HPm;
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(weCoinRechargeView, bl.axQ(), "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$updateIncomeBalance$$inlined$apply$lambda$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            weCoinRechargeView.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(weCoinRechargeView, "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$updateIncomeBalance$$inlined$apply$lambda$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$updateIncomeBalance$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(212890);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick", "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$updateRightOptionMenu$1$1"})
    public static final class q implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ WeCoinRechargeView HPm;
        final /* synthetic */ String pFh;
        final /* synthetic */ kotlin.g.a.a qgW;

        q(kotlin.g.a.a aVar, WeCoinRechargeView weCoinRechargeView, String str) {
            this.qgW = aVar;
            this.HPm = weCoinRechargeView;
            this.pFh = str;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(212893);
            WeCoinRechargeView.a(this.HPm);
            WeCoinRechargeViewModel.aeH(1);
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(21658, 1);
            this.qgW.invoke();
            AppMethodBeat.o(212893);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$updateTopBannerView$1$1"})
    public static final class r implements View.OnClickListener {
        final /* synthetic */ abq HPd;
        final /* synthetic */ WeCoinRechargeView HPm;

        r(abq abq, WeCoinRechargeView weCoinRechargeView) {
            this.HPd = abq;
            this.HPm = weCoinRechargeView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(212894);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$updateTopBannerView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            WeCoinRechargeView.a(this.HPm);
            WeCoinRechargeViewModel.aeH(3);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", this.HPd.url);
            com.tencent.mm.wallet_core.ui.f.aA(this.HPm, intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$updateTopBannerView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(212894);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005¨\u0006\u0006"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$updateFaqView$1$1"})
    public static final class m implements View.OnClickListener {
        final /* synthetic */ WeCoinRechargeView HPm;
        final /* synthetic */ String pFh;

        m(WeCoinRechargeView weCoinRechargeView, String str) {
            this.HPm = weCoinRechargeView;
            this.pFh = str;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(212889);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$updateFaqView$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            WeCoinRechargeView.a(this.HPm);
            WeCoinRechargeViewModel.aeH(5);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", this.pFh);
            intent.putExtra("showShare", false);
            intent.putExtra(e.p.OzJ, true);
            com.tencent.mm.wallet_core.ui.f.aA(this.HPm.getContext(), intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$updateFaqView$$inlined$let$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(212889);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "onClick", "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$showTutorialDialog$1$1"})
    public static final class l implements g.a {
        final /* synthetic */ WeCoinRechargeView HPm;
        final /* synthetic */ com.tencent.mm.ui.widget.a.g HPn;

        l(com.tencent.mm.ui.widget.a.g gVar, WeCoinRechargeView weCoinRechargeView) {
            this.HPn = gVar;
            this.HPm = weCoinRechargeView;
        }

        @Override // com.tencent.mm.ui.widget.a.g.a
        public final void onClick() {
            AppMethodBeat.i(212888);
            WeCoinRechargeView.a(this.HPm);
            WeCoinRechargeViewModel.aeH(10);
            this.HPn.bMo();
            AppMethodBeat.o(212888);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, hxF = {"<anonymous>", "", "invoke", "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinRechargeView$updateRightOptionMenu$1$func$1"})
    public static final class p extends kotlin.g.b.q implements kotlin.g.a.a<x> {
        final /* synthetic */ WeCoinRechargeView HPm;
        final /* synthetic */ String pFh;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(WeCoinRechargeView weCoinRechargeView, String str) {
            super(0);
            this.HPm = weCoinRechargeView;
            this.pFh = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(212892);
            Intent intent = new Intent();
            intent.putExtra("rawUrl", this.pFh);
            intent.putExtra("showShare", false);
            intent.putExtra(e.p.OzJ, true);
            com.tencent.mm.wallet_core.ui.f.aA(this.HPm.getContext(), intent);
            x xVar = x.SXb;
            AppMethodBeat.o(212892);
            return xVar;
        }
    }

    public static final /* synthetic */ void b(WeCoinRechargeView weCoinRechargeView) {
        int max;
        int i2;
        int i3;
        AppMethodBeat.i(212903);
        int i4 = ao.az(weCoinRechargeView).y;
        WeCoinRechargeView weCoinRechargeView2 = weCoinRechargeView;
        Object systemService = weCoinRechargeView2.getSystemService("window");
        if (systemService == null) {
            t tVar = new t("null cannot be cast to non-null type android.view.WindowManager");
            AppMethodBeat.o(212903);
            throw tVar;
        }
        WindowManager windowManager = (WindowManager) systemService;
        if (windowManager == null) {
            Log.e("MicroMsg.WeCoinUtils", "getRealBottomHeight, get NULL windowManager");
            max = 0;
        } else {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            Point point = new Point();
            defaultDisplay.getSize(point);
            Point az = ao.az(weCoinRechargeView2);
            Math.max(point.y, point.x);
            int max2 = Math.max(az.y, az.x);
            Rect rect = new Rect();
            Window window = weCoinRechargeView2.getWindow();
            kotlin.g.b.p.g(window, "context.window");
            window.getDecorView().getWindowVisibleDisplayFrame(rect);
            max = max2 - Math.max(rect.bottom - rect.top, rect.right - rect.left);
        }
        int statusBarHeight = max - ao.getStatusBarHeight(weCoinRechargeView);
        if (statusBarHeight > 0) {
            i2 = i4 - ao.aD(weCoinRechargeView);
        } else {
            i2 = i4;
        }
        ActionBar supportActionBar = weCoinRechargeView.getSupportActionBar();
        if (supportActionBar != null) {
            kotlin.g.b.p.g(supportActionBar, LocaleUtil.ITALIAN);
            i3 = supportActionBar.getHeight();
            if (i3 <= 0) {
                i3 = weCoinRechargeView.getResources().getDimensionPixelSize(R.dimen.b9);
            }
        } else {
            i3 = 0;
        }
        int statusBarHeight2 = ((i2 - i3) - ao.getStatusBarHeight(weCoinRechargeView)) - weCoinRechargeView.getResources().getDimensionPixelSize(R.dimen.c6);
        int fromDPToPix = com.tencent.mm.cb.a.fromDPToPix((Context) weCoinRechargeView, 520);
        Log.i("MicroMsg.WeCoinRechargeView", "updateMainContentView, [contentViewHeight] " + statusBarHeight2 + ", [maxSpaceSize] " + fromDPToPix + ", [bottomHeight] " + statusBarHeight);
        if (statusBarHeight2 <= fromDPToPix) {
            fromDPToPix = statusBarHeight2;
        }
        View findViewById = weCoinRechargeView.findViewById(R.id.jm2);
        kotlin.g.b.p.g(findViewById, "mainContentLayout");
        ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = fromDPToPix;
            findViewById.setLayoutParams(layoutParams);
            AppMethodBeat.o(212903);
            return;
        }
        AppMethodBeat.o(212903);
    }

    public static final /* synthetic */ void a(WeCoinRechargeView weCoinRechargeView, com.tencent.mm.plugin.wallet.wecoin.model.f fVar) {
        AppMethodBeat.i(212905);
        Log.i("MicroMsg.WeCoinRechargeView", "updateIncomeBalance: [blance] ".concat(String.valueOf(fVar)));
        LinearLayout linearLayout = (LinearLayout) weCoinRechargeView.findViewById(R.id.jm6);
        kotlin.g.b.p.g(linearLayout, "incomeBalanceBtn");
        linearLayout.setVisibility(8);
        if (fVar != null) {
            if (fVar.HNg) {
                if (weCoinRechargeView.HPe == null) {
                    kotlin.g.b.p.btv("mViewModel");
                }
                WeCoinRechargeViewModel.aeH(6);
                linearLayout.setOnClickListener(new n(weCoinRechargeView, linearLayout));
                String formatMoney2f = com.tencent.mm.wallet_core.ui.f.formatMoney2f(com.tencent.mm.wallet_core.ui.f.b(new StringBuilder().append(fVar.HNh).toString(), "100", 2, RoundingMode.HALF_UP).doubleValue());
                WcPayMoneyLoadingView wcPayMoneyLoadingView = weCoinRechargeView.Hwb;
                if (wcPayMoneyLoadingView == null) {
                    kotlin.g.b.p.btv("mBalanceView");
                }
                wcPayMoneyLoadingView.cH(formatMoney2f, false);
                linearLayout.setVisibility(0);
            }
            AppMethodBeat.o(212905);
            return;
        }
        AppMethodBeat.o(212905);
    }

    public static final /* synthetic */ void a(WeCoinRechargeView weCoinRechargeView, Long l2) {
        AppMethodBeat.i(212906);
        Log.i("MicroMsg.WeCoinRechargeView", "updateTotalBalance: [blance] ".concat(String.valueOf(l2)));
        TextView textView = weCoinRechargeView.HPg;
        if (textView == null) {
            kotlin.g.b.p.btv("mNoBalanceTipsTv");
        }
        textView.setVisibility(0);
        LinearLayout linearLayout = weCoinRechargeView.HPf;
        if (linearLayout == null) {
            kotlin.g.b.p.btv("mTotalBalanceLl");
        }
        linearLayout.setVisibility(8);
        long longValue = l2 != null ? l2.longValue() : 0;
        if (longValue > 0) {
            TextView textView2 = weCoinRechargeView.HPi;
            if (textView2 == null) {
                kotlin.g.b.p.btv("mWeCoinBalanceView");
            }
            textView2.setText(String.valueOf(longValue));
            TextView textView3 = weCoinRechargeView.HPg;
            if (textView3 == null) {
                kotlin.g.b.p.btv("mNoBalanceTipsTv");
            }
            textView3.setVisibility(8);
            LinearLayout linearLayout2 = weCoinRechargeView.HPf;
            if (linearLayout2 == null) {
                kotlin.g.b.p.btv("mTotalBalanceLl");
            }
            linearLayout2.setVisibility(0);
        }
        AppMethodBeat.o(212906);
    }

    public static final /* synthetic */ void a(WeCoinRechargeView weCoinRechargeView, String str) {
        AppMethodBeat.i(212907);
        Log.i("MicroMsg.WeCoinRechargeView", "updateRightOptionMenu: [url] ".concat(String.valueOf(str)));
        weCoinRechargeView.removeAllOptionMenu();
        if (str != null) {
            String string = weCoinRechargeView.getString(R.string.j2a);
            kotlin.g.b.p.g(string, "getString(R.string.wecoin_balance_option_detail)");
            weCoinRechargeView.addTextOptionMenu(0, string, new q(new p(weCoinRechargeView, str), weCoinRechargeView, str), null, t.b.TRANSPARENT_BG_BLACK_TEXT);
        }
        AppMethodBeat.o(212907);
    }

    public static final /* synthetic */ void b(WeCoinRechargeView weCoinRechargeView, String str) {
        AppMethodBeat.i(212908);
        Log.i("MicroMsg.WeCoinRechargeView", "updateFaqView: [url] ".concat(String.valueOf(str)));
        TextView textView = weCoinRechargeView.HOY;
        if (textView == null) {
            kotlin.g.b.p.btv("mFaqTv");
        }
        textView.setVisibility(8);
        if (str != null) {
            TextView textView2 = weCoinRechargeView.HOY;
            if (textView2 == null) {
                kotlin.g.b.p.btv("mFaqTv");
            }
            textView2.setOnClickListener(new m(weCoinRechargeView, str));
            TextView textView3 = weCoinRechargeView.HOY;
            if (textView3 == null) {
                kotlin.g.b.p.btv("mFaqTv");
            }
            textView3.setVisibility(0);
        }
        AppMethodBeat.o(212908);
    }

    public static final /* synthetic */ void a(WeCoinRechargeView weCoinRechargeView, com.tencent.mm.plugin.wallet.wecoin.model.a aVar) {
        AppMethodBeat.i(212909);
        AppCompatActivity context = weCoinRechargeView.getContext();
        kotlin.g.b.p.g(context, "context");
        com.tencent.mm.plugin.wallet.wecoin.c.c.a(context, aVar);
        AppMethodBeat.o(212909);
    }

    public static final /* synthetic */ void a(WeCoinRechargeView weCoinRechargeView, abq abq) {
        boolean z;
        AppMethodBeat.i(212910);
        Log.i("MicroMsg.WeCoinRechargeView", "bannerContent: [bannerContent] ".concat(String.valueOf(abq)));
        View view = weCoinRechargeView.HPh;
        if (view == null) {
            kotlin.g.b.p.btv("mBannerView");
        }
        view.setVisibility(8);
        if (abq != null) {
            if (!TextUtils.isEmpty(abq.content)) {
                if (weCoinRechargeView.HPe == null) {
                    kotlin.g.b.p.btv("mViewModel");
                }
                WeCoinRechargeViewModel.aeH(2);
                View view2 = weCoinRechargeView.HPh;
                if (view2 == null) {
                    kotlin.g.b.p.btv("mBannerView");
                }
                view2.setVisibility(0);
                View view3 = weCoinRechargeView.HPh;
                if (view3 == null) {
                    kotlin.g.b.p.btv("mBannerView");
                }
                TextView textView = (TextView) view3.findViewById(R.id.jmd);
                kotlin.g.b.p.g(textView, "bannerText");
                textView.setText(abq.content);
                View view4 = weCoinRechargeView.HPh;
                if (view4 == null) {
                    kotlin.g.b.p.btv("mBannerView");
                }
                WeImageView weImageView = (WeImageView) view4.findViewById(R.id.jmc);
                String str = abq.url;
                if (str == null || str.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    kotlin.g.b.p.g(weImageView, "iconsRight");
                    weImageView.setVisibility(8);
                    AppMethodBeat.o(212910);
                    return;
                }
                kotlin.g.b.p.g(weImageView, "iconsRight");
                weImageView.setVisibility(0);
                View view5 = weCoinRechargeView.HPh;
                if (view5 == null) {
                    kotlin.g.b.p.btv("mBannerView");
                }
                view5.setOnClickListener(new r(abq, weCoinRechargeView));
            }
            AppMethodBeat.o(212910);
            return;
        }
        AppMethodBeat.o(212910);
    }

    public static final /* synthetic */ void b(WeCoinRechargeView weCoinRechargeView, Boolean bool) {
        AppMethodBeat.i(212911);
        if (bool != null) {
            if (!bool.booleanValue()) {
                if (weCoinRechargeView.HPe == null) {
                    kotlin.g.b.p.btv("mViewModel");
                }
                WeCoinRechargeViewModel.aeH(9);
                com.tencent.mm.ui.widget.a.g gVar = new com.tencent.mm.ui.widget.a.g(weCoinRechargeView.getContext(), 2, 0);
                LinearLayout linearLayout = new LinearLayout(weCoinRechargeView.getContext());
                linearLayout.setOrientation(1);
                WeImageView weImageView = new WeImageView(weCoinRechargeView.getContext());
                linearLayout.addView(weImageView);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(weImageView.getLayoutParams());
                layoutParams.width = com.tencent.mm.cb.a.aH(weCoinRechargeView.getContext(), R.dimen.ce);
                layoutParams.height = com.tencent.mm.cb.a.aH(weCoinRechargeView.getContext(), R.dimen.ce);
                layoutParams.topMargin = com.tencent.mm.cb.a.aH(weCoinRechargeView.getContext(), R.dimen.cn);
                layoutParams.gravity = 17;
                weImageView.setIconColor(weCoinRechargeView.getResources().getColor(R.color.fo));
                weImageView.setImageResource(R.raw.wecoin_tutorial_dialog_icon);
                weImageView.setLayoutParams(layoutParams);
                TextView textView = new TextView(weCoinRechargeView.getContext());
                linearLayout.addView(textView);
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(textView.getLayoutParams());
                layoutParams2.width = -1;
                layoutParams2.height = -2;
                layoutParams2.topMargin = com.tencent.mm.cb.a.aH(weCoinRechargeView.getContext(), R.dimen.ce);
                layoutParams2.bottomMargin = com.tencent.mm.cb.a.aH(weCoinRechargeView.getContext(), R.dimen.cb);
                textView.setTextColor(weCoinRechargeView.getResources().getColor(R.color.fr));
                textView.setTextSize(1, 17.0f);
                ao.a(textView.getPaint(), 0.8f);
                textView.setText(weCoinRechargeView.getString(R.string.j2u));
                textView.setGravity(17);
                textView.setLayoutParams(layoutParams2);
                gVar.setCustomView(linearLayout);
                gVar.T(weCoinRechargeView.getString(R.string.j2t));
                gVar.ape(1);
                gVar.aeF(weCoinRechargeView.getResources().getColor(R.color.Green_90));
                gVar.a(new l(gVar, weCoinRechargeView));
                gVar.dGm();
            }
            AppMethodBeat.o(212911);
            return;
        }
        AppMethodBeat.o(212911);
    }

    public static final /* synthetic */ void c(WeCoinRechargeView weCoinRechargeView, Boolean bool) {
        AppMethodBeat.i(212912);
        if (bool == null) {
            AppMethodBeat.o(212912);
        } else if (!bool.booleanValue()) {
            TextView textView = weCoinRechargeView.HPk;
            if (textView == null) {
                kotlin.g.b.p.btv("mSwitchDeviceTipsView");
            }
            textView.setText(weCoinRechargeView.getString(R.string.j2p));
            AppMethodBeat.o(212912);
        } else {
            TextView textView2 = weCoinRechargeView.HPk;
            if (textView2 == null) {
                kotlin.g.b.p.btv("mSwitchDeviceTipsView");
            }
            textView2.setText("");
            AppMethodBeat.o(212912);
        }
    }

    public static final /* synthetic */ void c(WeCoinRechargeView weCoinRechargeView) {
        AppMethodBeat.i(212913);
        e.b bVar = com.tencent.mm.plugin.wallet.wecoin.model.e.HMM;
        e.a aVar = new e.a();
        aVar.HMJ = false;
        aVar.mScene = 0;
        com.tencent.mm.plugin.wallet.wecoin.model.e fPD = aVar.fPD();
        AppCompatActivity context = weCoinRechargeView.getContext();
        kotlin.g.b.p.g(context, "context");
        new a(context, fPD);
        AppMethodBeat.o(212913);
    }
}
