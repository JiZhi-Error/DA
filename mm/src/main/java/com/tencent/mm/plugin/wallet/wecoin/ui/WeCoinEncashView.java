package com.tencent.mm.plugin.wallet.wecoin.ui;

import android.app.Dialog;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.wallet.wecoin.model.WeCoinEncashViewModel;
import com.tencent.mm.plugin.wallet.wecoin.model.WecoinEncashKVData;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.protocal.protobuf.ajj;
import com.tencent.mm.protocal.protobuf.cdg;
import com.tencent.mm.protocal.protobuf.ddc;
import com.tencent.mm.protocal.protobuf.dek;
import com.tencent.mm.protocal.protobuf.fbz;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.ao;
import com.tencent.mm.wallet_core.c.ah;
import com.tencent.mm.wallet_core.keyboard.WcPayKeyboard;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.e;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import kotlin.t;

@kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000 Q2\u00020\u0001:\u0001QB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\bH\u0002J\b\u0010\u001c\u001a\u00020\u0006H\u0014J\u0012\u0010\u001d\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0002J\u0012\u0010 \u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010!H\u0002J\b\u0010\"\u001a\u00020\u0019H\u0002J\b\u0010#\u001a\u00020\u0019H\u0002J\b\u0010$\u001a\u00020\u0019H\u0014J\b\u0010%\u001a\u00020\bH\u0014J\"\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\b\u0010)\u001a\u0004\u0018\u00010*H\u0014J\u0012\u0010+\u001a\u00020\u00192\b\u0010)\u001a\u0004\u0018\u00010*H\u0002J\u0012\u0010,\u001a\u00020\u00192\b\u0010-\u001a\u0004\u0018\u00010.H\u0016J\b\u0010/\u001a\u00020\u0019H\u0016J\u0012\u00100\u001a\u00020\u00192\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u0018\u00103\u001a\u00020\b2\u0006\u00104\u001a\u00020\u00062\u0006\u00105\u001a\u000206H\u0016J\b\u00107\u001a\u00020\u0019H\u0016J\b\u00108\u001a\u00020\u0019H\u0016J,\u00109\u001a\u00020\b2\u0006\u0010:\u001a\u00020\u00062\u0006\u0010;\u001a\u00020\u00062\b\u0010<\u001a\u0004\u0018\u00010=2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u0010\u0010@\u001a\u00020\u00192\u0006\u0010A\u001a\u00020BH\u0002J\b\u0010C\u001a\u00020\u0019H\u0002J\b\u0010D\u001a\u00020\u0019H\u0002J\b\u0010E\u001a\u00020\u0019H\u0002J\u0017\u0010F\u001a\u00020\u00192\b\u0010G\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0002\u0010HJ\u0012\u0010I\u001a\u00020\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010JH\u0002J\u0012\u0010K\u001a\u00020\u00192\b\u0010L\u001a\u0004\u0018\u00010MH\u0002J\u0010\u0010N\u001a\u00020\u00192\u0006\u0010O\u001a\u00020=H\u0002J\b\u0010P\u001a\u00020\u0019H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006R"}, hxF = {"Lcom/tencent/mm/plugin/wallet/wecoin/ui/WeCoinEncashView;", "Lcom/tencent/mm/wallet_core/ui/WalletBaseUI;", "()V", "autoShowWxKbRunnable", "Ljava/lang/Runnable;", "hintTextColor", "", "inputValid", "", "mEncashTitleTV", "Landroid/widget/TextView;", "mInputMoneyText", "Lcom/tencent/mm/wallet_core/ui/formview/WalletFormView;", "mTotalBalanceWithdrawTip", "mViewModel", "Lcom/tencent/mm/plugin/wallet/wecoin/model/WeCoinEncashViewModel;", "mWxKbInterceptState", "mainContent", "Landroid/view/ViewGroup;", "originHintWording", "", "rootView", "Landroid/widget/ScrollView;", "state", "bindData", "", "checkSetSaveFetchButtonEnable", "enable", "getLayoutId", "gotoWeCoinFetchResultUI", "info", "Lcom/tencent/mm/protocal/protobuf/EncashResultPageInfo;", "handleInterceptWinInfo", "Lcom/tencent/mm/protocal/protobuf/PrepareIncomeEncashResponse;", "initKVData", "initKeyBoardView", "initView", "isHandleAutoShowNormalStWcKb", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCheckPwdSucceeded", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onDialogDismiss", "dialog", "Landroid/app/Dialog;", "onKeyUp", "keyCode", "event", "Landroid/view/KeyEvent;", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "prepareEncashRequest", "amount", "", "removeWxKbRunnables", "scrollTop", "setupViews", "showDialog", "show", "(Ljava/lang/Boolean;)V", "showErrorMsg", "Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "startCheckPwdUI", NativeProtocol.WEB_DIALOG_PARAMS, "Lcom/tencent/mm/protocal/protobuf/WxPayUserTokenParams;", "updateTipsText", "money", "updateView", "Companion", "plugin-wxpay_release"})
public class WeCoinEncashView extends WalletBaseUI {
    public static final a HOP = new a((byte) 0);
    private ViewGroup HAO;
    private ScrollView HBm;
    private CharSequence HBr;
    private boolean HBz;
    private TextView HOL;
    private WalletFormView HOM;
    private TextView HON;
    private WeCoinEncashViewModel HOO;
    private boolean HvA;
    private final Runnable jVx = new b(this);
    private int state;
    private int wfU;

    static {
        AppMethodBeat.i(212826);
        AppMethodBeat.o(212826);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/WxPayUserTokenParams;", "onChanged"})
    static final class c<T> implements Observer<fbz> {
        final /* synthetic */ WeCoinEncashView HOQ;

        c(WeCoinEncashView weCoinEncashView) {
            this.HOQ = weCoinEncashView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(fbz fbz) {
            AppMethodBeat.i(212799);
            WeCoinEncashView.a(this.HOQ, fbz);
            AppMethodBeat.o(212799);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/plugin/wallet/wecoin/model/CgiRespInfo;", "onChanged"})
    static final class d<T> implements Observer<com.tencent.mm.plugin.wallet.wecoin.model.a> {
        final /* synthetic */ WeCoinEncashView HOQ;

        d(WeCoinEncashView weCoinEncashView) {
            this.HOQ = weCoinEncashView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(com.tencent.mm.plugin.wallet.wecoin.model.a aVar) {
            AppMethodBeat.i(212800);
            WeCoinEncashView.a(this.HOQ, aVar);
            AppMethodBeat.o(212800);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/EncashResultPageInfo;", "onChanged"})
    static final class e<T> implements Observer<ajj> {
        final /* synthetic */ WeCoinEncashView HOQ;

        e(WeCoinEncashView weCoinEncashView) {
            this.HOQ = weCoinEncashView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(ajj ajj) {
            AppMethodBeat.i(212801);
            WeCoinEncashView.a(this.HOQ, ajj);
            AppMethodBeat.o(212801);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lcom/tencent/mm/protocal/protobuf/PrepareIncomeEncashResponse;", "onChanged"})
    static final class f<T> implements Observer<dek> {
        final /* synthetic */ WeCoinEncashView HOQ;

        f(WeCoinEncashView weCoinEncashView) {
            this.HOQ = weCoinEncashView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(dek dek) {
            AppMethodBeat.i(212802);
            WeCoinEncashView.a(this.HOQ, dek);
            AppMethodBeat.o(212802);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "", "onChanged", "(Ljava/lang/Boolean;)V"})
    static final class g<T> implements Observer<Boolean> {
        final /* synthetic */ WeCoinEncashView HOQ;

        g(WeCoinEncashView weCoinEncashView) {
            this.HOQ = weCoinEncashView;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // android.arch.lifecycle.Observer
        public final /* synthetic */ void onChanged(Boolean bool) {
            AppMethodBeat.i(212803);
            WeCoinEncashView.a(this.HOQ, bool);
            AppMethodBeat.o(212803);
        }
    }

    public WeCoinEncashView() {
        AppMethodBeat.i(212825);
        Context context = MMApplicationContext.getContext();
        kotlin.g.b.p.g(context, "MMApplicationContext.getContext()");
        this.wfU = context.getResources().getColor(R.color.FG_1);
        AppMethodBeat.o(212825);
    }

    public static final /* synthetic */ WeCoinEncashViewModel a(WeCoinEncashView weCoinEncashView) {
        AppMethodBeat.i(212827);
        WeCoinEncashViewModel weCoinEncashViewModel = weCoinEncashView.HOO;
        if (weCoinEncashViewModel == null) {
            kotlin.g.b.p.btv("mViewModel");
        }
        AppMethodBeat.o(212827);
        return weCoinEncashViewModel;
    }

    public static final /* synthetic */ boolean c(WeCoinEncashView weCoinEncashView) {
        AppMethodBeat.i(212828);
        boolean needConfirmFinish = weCoinEncashView.needConfirmFinish();
        AppMethodBeat.o(212828);
        return needConfirmFinish;
    }

    public static final /* synthetic */ WalletFormView e(WeCoinEncashView weCoinEncashView) {
        AppMethodBeat.i(212834);
        WalletFormView walletFormView = weCoinEncashView.HOM;
        if (walletFormView == null) {
            kotlin.g.b.p.btv("mInputMoneyText");
        }
        AppMethodBeat.o(212834);
        return walletFormView;
    }

    public static final /* synthetic */ ScrollView g(WeCoinEncashView weCoinEncashView) {
        AppMethodBeat.i(212837);
        ScrollView scrollView = weCoinEncashView.HBm;
        if (scrollView == null) {
            kotlin.g.b.p.btv("rootView");
        }
        AppMethodBeat.o(212837);
        return scrollView;
    }

    public static final /* synthetic */ TextView h(WeCoinEncashView weCoinEncashView) {
        AppMethodBeat.i(212839);
        TextView textView = weCoinEncashView.HOL;
        if (textView == null) {
            kotlin.g.b.p.btv("mEncashTitleTV");
        }
        AppMethodBeat.o(212839);
        return textView;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000¨\u0006\t"}, hxF = {"Lcom/tencent/mm/plugin/wallet/wecoin/ui/WeCoinEncashView$Companion;", "", "()V", "KEY_BOARD_RUNABLE_DELAY_MS", "", "REQUEST_CODE_GO_VERIFY_PASSWORD", "", "TAG", "", "plugin-wxpay_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(212815);
        super.onCreate(bundle);
        initView();
        ViewModel viewModel = ViewModelProviders.of(this).get(WeCoinEncashViewModel.class);
        kotlin.g.b.p.g(viewModel, "ViewModelProviders.of(th…ashViewModel::class.java)");
        this.HOO = (WeCoinEncashViewModel) viewModel;
        WeCoinEncashViewModel weCoinEncashViewModel = this.HOO;
        if (weCoinEncashViewModel == null) {
            kotlin.g.b.p.btv("mViewModel");
        }
        weCoinEncashViewModel.HNi.observe(this, new c(this));
        WeCoinEncashViewModel weCoinEncashViewModel2 = this.HOO;
        if (weCoinEncashViewModel2 == null) {
            kotlin.g.b.p.btv("mViewModel");
        }
        weCoinEncashViewModel2.HMQ.observe(this, new d(this));
        WeCoinEncashViewModel weCoinEncashViewModel3 = this.HOO;
        if (weCoinEncashViewModel3 == null) {
            kotlin.g.b.p.btv("mViewModel");
        }
        weCoinEncashViewModel3.HNj.observe(this, new e(this));
        WeCoinEncashViewModel weCoinEncashViewModel4 = this.HOO;
        if (weCoinEncashViewModel4 == null) {
            kotlin.g.b.p.btv("mViewModel");
        }
        weCoinEncashViewModel4.HMS.observe(this, new f(this));
        WeCoinEncashViewModel weCoinEncashViewModel5 = this.HOO;
        if (weCoinEncashViewModel5 == null) {
            kotlin.g.b.p.btv("mViewModel");
        }
        weCoinEncashViewModel5.qiR.observe(this, new g(this));
        WeCoinEncashViewModel weCoinEncashViewModel6 = this.HOO;
        if (weCoinEncashViewModel6 == null) {
            kotlin.g.b.p.btv("mViewModel");
        }
        weCoinEncashViewModel6.HNm = (WecoinEncashKVData) getIntent().getParcelableExtra("wecoin_enter_encash_business_kv_data");
        AppMethodBeat.o(212815);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onResume() {
        AppMethodBeat.i(212816);
        super.onResume();
        Log.i("MicroMsg.WeCoinEncashView", "onResume()");
        if (this.state == 3 && isHandleAutoShowNormalStWcKb()) {
            MMHandlerThread.postToMainThreadDelayed(this.jVx, 300);
        }
        this.state = 2;
        AppMethodBeat.o(212816);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onPause() {
        AppMethodBeat.i(212817);
        super.onPause();
        Log.i("MicroMsg.WeCoinEncashView", "onPause()");
        WcPayKeyboard wcPayKeyboard = this.mWcKeyboard;
        kotlin.g.b.p.g(wcPayKeyboard, "mWcKeyboard");
        if (!wcPayKeyboard.hgQ()) {
            this.state = 3;
        }
        AppMethodBeat.o(212817);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onDestroy() {
        AppMethodBeat.i(212818);
        super.onDestroy();
        MMHandlerThread.removeRunnable(this.jVx);
        AppMethodBeat.o(212818);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c1;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(212819);
        kotlin.g.b.p.h(keyEvent, "event");
        if (this.mWcKeyboard == null || !this.mWcKeyboard.onKeyUp(i2, keyEvent)) {
            boolean onKeyUp = super.onKeyUp(i2, keyEvent);
            AppMethodBeat.o(212819);
            return onKeyUp;
        }
        AppMethodBeat.o(212819);
        return true;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        return true;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onActivityResult(int i2, int i3, Intent intent) {
        boolean z;
        AppMethodBeat.i(212820);
        Log.i("MicroMsg.WeCoinEncashView", "onActivityResult() requestCode:%s, resultCode:%s", Integer.valueOf(i2), Integer.valueOf(i3));
        super.onActivityResult(i2, i3, intent);
        if (i2 != 3001) {
            AppMethodBeat.o(212820);
        } else if (i3 == -1) {
            String stringExtra = intent != null ? intent.getStringExtra("token") : null;
            String str = stringExtra;
            if (str == null || str.length() == 0) {
                z = true;
            } else {
                z = false;
            }
            if (!z) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1581, 95);
                WeCoinEncashViewModel weCoinEncashViewModel = this.HOO;
                if (weCoinEncashViewModel == null) {
                    kotlin.g.b.p.btv("mViewModel");
                }
                weCoinEncashViewModel.a(stringExtra, this);
                AppMethodBeat.o(212820);
                return;
            }
            WeCoinEncashViewModel weCoinEncashViewModel2 = this.HOO;
            if (weCoinEncashViewModel2 == null) {
                kotlin.g.b.p.btv("mViewModel");
            }
            weCoinEncashViewModel2.aeH(5);
            com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1581, 94);
            AppMethodBeat.o(212820);
        } else {
            if (i3 == 0) {
                WeCoinEncashViewModel weCoinEncashViewModel3 = this.HOO;
                if (weCoinEncashViewModel3 == null) {
                    kotlin.g.b.p.btv("mViewModel");
                }
                weCoinEncashViewModel3.aeH(5);
                com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1581, 94);
            }
            AppMethodBeat.o(212820);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
    public static final class j implements MenuItem.OnMenuItemClickListener {
        final /* synthetic */ WeCoinEncashView HOQ;

        j(WeCoinEncashView weCoinEncashView) {
            this.HOQ = weCoinEncashView;
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(212806);
            WeCoinEncashView.a(this.HOQ).aeH(20);
            this.HOQ.mPayResultType = 4;
            if (WeCoinEncashView.c(this.HOQ)) {
                this.HOQ.hideVKB();
                this.HOQ.showDialog(1000);
            } else {
                this.HOQ.finish();
            }
            AppMethodBeat.o(212806);
            return true;
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(212821);
        setBackBtn(new j(this));
        setActionbarColor(getResources().getColor(R.color.a2r));
        hideActionbarLine();
        View findViewById = findViewById(R.id.dyw);
        kotlin.g.b.p.g(findViewById, "findViewById(R.id.input_money_wv)");
        this.HOM = (WalletFormView) findViewById;
        View findViewById2 = findViewById(R.id.c3m);
        kotlin.g.b.p.g(findViewById2, "findViewById(R.id.encash_money_title_tv)");
        this.HOL = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.f68);
        kotlin.g.b.p.g(findViewById3, "findViewById(R.id.main_content)");
        this.HAO = (ViewGroup) findViewById3;
        View findViewById4 = findViewById(R.id.iu4);
        kotlin.g.b.p.g(findViewById4, "findViewById(R.id.total_balance_hint)");
        this.HON = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.exb);
        kotlin.g.b.p.g(findViewById5, "findViewById(R.id.lqt_root_view)");
        this.HBm = (ScrollView) findViewById5;
        WalletFormView walletFormView = this.HOM;
        if (walletFormView == null) {
            kotlin.g.b.p.btv("mInputMoneyText");
        }
        TextView titleTv = walletFormView.getTitleTv();
        kotlin.g.b.p.g(titleTv, "mInputMoneyText.titleTv");
        titleTv.setText(ah.hhA());
        TextView textView = this.HON;
        if (textView == null) {
            kotlin.g.b.p.btv("mTotalBalanceWithdrawTip");
        }
        textView.setText("");
        TextView textView2 = this.HON;
        if (textView2 == null) {
            kotlin.g.b.p.btv("mTotalBalanceWithdrawTip");
        }
        textView2.setClickable(true);
        TextView textView3 = this.HON;
        if (textView3 == null) {
            kotlin.g.b.p.btv("mTotalBalanceWithdrawTip");
        }
        textView3.setOnTouchListener(new com.tencent.mm.pluginsdk.ui.span.o(this));
        TextView textView4 = (TextView) findViewById(R.id.ev1);
        kotlin.g.b.p.g(textView4, "cftText");
        ao.a(textView4.getPaint(), 0.8f);
        setMMTitle(R.string.i6p);
        this.state = 1;
        this.mWcKeyboard = (WcPayKeyboard) findViewById(R.id.joy);
        WcPayKeyboard wcPayKeyboard = this.mWcKeyboard;
        kotlin.g.b.p.g(wcPayKeyboard, "mWcKeyboard");
        ViewGroup.LayoutParams layoutParams = wcPayKeyboard.getLayoutParams();
        if (layoutParams == null) {
            t tVar = new t("null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
            AppMethodBeat.o(212821);
            throw tVar;
        }
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) layoutParams;
        layoutParams2.addRule(12);
        WcPayKeyboard wcPayKeyboard2 = this.mWcKeyboard;
        kotlin.g.b.p.g(wcPayKeyboard2, "mWcKeyboard");
        wcPayKeyboard2.setLayoutParams(layoutParams2);
        WalletFormView walletFormView2 = this.HOM;
        if (walletFormView2 == null) {
            kotlin.g.b.p.btv("mInputMoneyText");
        }
        setWPKeyboard(walletFormView2.getContentEt(), false, false);
        this.mWcKeyboard.setActionText(getString(R.string.i6p));
        if (com.tencent.mm.compatible.util.d.oF(27)) {
            WalletFormView walletFormView3 = this.HOM;
            if (walletFormView3 == null) {
                kotlin.g.b.p.btv("mInputMoneyText");
            }
            walletFormView3.hic();
        }
        ViewGroup viewGroup = this.HAO;
        if (viewGroup == null) {
            kotlin.g.b.p.btv("mainContent");
        }
        viewGroup.setOnTouchListener(new i(this));
        xP(false);
        WalletFormView walletFormView4 = this.HOM;
        if (walletFormView4 == null) {
            kotlin.g.b.p.btv("mInputMoneyText");
        }
        walletFormView4.a(new l(this));
        setTenpayKBStateListener(new m(this));
        o oVar = new o(this);
        WalletFormView walletFormView5 = this.HOM;
        if (walletFormView5 == null) {
            kotlin.g.b.p.btv("mInputMoneyText");
        }
        walletFormView5.getContentEt().setOnEditorActionListener(new n(oVar));
        long longExtra = getIntent().getLongExtra("wecoin_income_balance", 0);
        if (longExtra > 0) {
            String string = getString(R.string.j2h, new Object[]{Double.valueOf(com.tencent.mm.plugin.wallet.wecoin.c.c.lo(String.valueOf(longExtra), "100"))});
            kotlin.g.b.p.g(string, "getString(R.string.wecoi…igDecimal.ROUND_CEILING))");
            int length = string.length();
            SpannableString spannableString = new SpannableString(string + " " + getString(R.string.j2i));
            spannableString.setSpan(new com.tencent.mm.wallet_core.ui.e(new p(this, longExtra)), length, spannableString.length(), 18);
            this.HBr = spannableString;
            TextView textView5 = this.HON;
            if (textView5 == null) {
                kotlin.g.b.p.btv("mTotalBalanceWithdrawTip");
            }
            textView5.setText(spannableString);
        }
        AppMethodBeat.o(212821);
    }

    @Override // com.tencent.mm.ui.widget.a.c, com.tencent.mm.ui.MMActivity
    public void onDialogDismiss(Dialog dialog) {
        AppMethodBeat.i(212822);
        Log.i("MicroMsg.WeCoinEncashView", "onDialogDismiss()");
        if (this.state == 2 && isHandleAutoShowNormalStWcKb()) {
            MMHandlerThread.postToMainThreadDelayed(this.jVx, 300);
        }
        AppMethodBeat.o(212822);
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00060\u0006H\n¢\u0006\u0002\b\u0007"}, hxF = {"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
    public static final class i implements View.OnTouchListener {
        final /* synthetic */ WeCoinEncashView HOQ;

        i(WeCoinEncashView weCoinEncashView) {
            this.HOQ = weCoinEncashView;
        }

        public final boolean onTouch(View view, MotionEvent motionEvent) {
            AppMethodBeat.i(212805);
            WcPayKeyboard wcPayKeyboard = this.HOQ.mWcKeyboard;
            kotlin.g.b.p.g(wcPayKeyboard, "mWcKeyboard");
            if (wcPayKeyboard.isShown()) {
                WcPayKeyboard wcPayKeyboard2 = this.HOQ.mWcKeyboard;
                kotlin.g.b.p.g(wcPayKeyboard2, "mWcKeyboard");
                if (wcPayKeyboard2.hgP()) {
                    this.HOQ.mWcKeyboard.hgN();
                    AppMethodBeat.o(212805);
                    return true;
                }
            }
            AppMethodBeat.o(212805);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class p implements e.a {
        final /* synthetic */ WeCoinEncashView HOQ;
        final /* synthetic */ long upv;

        p(WeCoinEncashView weCoinEncashView, long j2) {
            this.HOQ = weCoinEncashView;
            this.upv = j2;
        }

        @Override // com.tencent.mm.wallet_core.ui.e.a
        public final void bmr() {
            AppMethodBeat.i(212814);
            WeCoinEncashView.a(this.HOQ).aeH(4);
            WeCoinEncashView.e(this.HOQ).setText(com.tencent.mm.wallet_core.ui.f.formatMoney2f(com.tencent.mm.plugin.wallet.wecoin.c.c.lo(String.valueOf(this.upv), "100")));
            WeCoinEncashView.e(this.HOQ).getContentEt().requestFocus();
            this.HOQ.showWcKb();
            AppMethodBeat.o(212814);
        }
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J(\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J(\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, hxF = {"com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinEncashView$setupViews$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-wxpay_release"})
    public static final class l implements TextWatcher {
        final /* synthetic */ WeCoinEncashView HOQ;

        /* JADX WARN: Incorrect args count in method signature: ()V */
        l(WeCoinEncashView weCoinEncashView) {
            this.HOQ = weCoinEncashView;
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            AppMethodBeat.i(212808);
            kotlin.g.b.p.h(charSequence, "s");
            AppMethodBeat.o(212808);
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            AppMethodBeat.i(212809);
            kotlin.g.b.p.h(charSequence, "s");
            AppMethodBeat.o(212809);
        }

        public final void afterTextChanged(Editable editable) {
            AppMethodBeat.i(212810);
            kotlin.g.b.p.h(editable, "s");
            String obj = editable.toString();
            if (kotlin.n.n.J(obj, ".", false)) {
                editable.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
            } else if (WalletFormView.a(obj, WeCoinEncashView.e(this.HOQ).getContentEt())) {
                AppMethodBeat.o(212810);
                return;
            }
            String obj2 = editable.toString();
            int a2 = kotlin.n.n.a((CharSequence) obj2, ".", 0, false, 6);
            int length = obj2.length();
            if (a2 >= 0 && length - a2 > 3) {
                WalletFormView.a(WeCoinEncashView.e(this.HOQ).getContentEt(), obj2, a2 + 3, length);
            } else if (a2 > 12) {
                WalletFormView.a(WeCoinEncashView.e(this.HOQ).getContentEt(), obj2, 12, a2);
            } else if (a2 == -1 && length > 12) {
                WalletFormView.a(WeCoinEncashView.e(this.HOQ).getContentEt(), obj2, 12, length);
            }
            WeCoinEncashView.a(this.HOQ, editable.toString());
            AppMethodBeat.o(212810);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", "visitable", "", "onVisibleStateChange"})
    public static final class m implements com.tencent.mm.wallet_core.ui.a {
        final /* synthetic */ WeCoinEncashView HOQ;

        m(WeCoinEncashView weCoinEncashView) {
            this.HOQ = weCoinEncashView;
        }

        @Override // com.tencent.mm.wallet_core.ui.a
        public final void onVisibleStateChange(boolean z) {
            AppMethodBeat.i(212811);
            if (z) {
                WeCoinEncashView.f(this.HOQ);
                AppMethodBeat.o(212811);
                return;
            }
            WeCoinEncashView.g(this.HOQ).scrollTo(0, 0);
            AppMethodBeat.o(212811);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class o implements View.OnClickListener {
        final /* synthetic */ WeCoinEncashView HOQ;

        o(WeCoinEncashView weCoinEncashView) {
            this.HOQ = weCoinEncashView;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(212813);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinEncashView$setupViews$clickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            if (com.tencent.mm.plugin.wallet.wecoin.c.c.isFastClick()) {
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinEncashView$setupViews$clickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(212813);
                return;
            }
            String text = WeCoinEncashView.e(this.HOQ).getText();
            kotlin.g.b.p.g(text, "mInputMoneyText.text");
            int lp = com.tencent.mm.plugin.wallet.wecoin.c.c.lp(text, "100");
            if (lp > 0) {
                WeCoinEncashView.a(this.HOQ).aeH(6);
                this.HOQ.hideWcKb();
                Log.i("MicroMsg.WeCoinEncashView", "click encash to cft");
                WeCoinEncashView.a(this.HOQ, (long) lp);
            }
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinEncashView$setupViews$clickListener$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(212813);
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u001c\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u0007\u001a\n \u0004*\u0004\u0018\u00010\b0\bH\n¢\u0006\u0002\b\t"}, hxF = {"<anonymous>", "", "v", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "actionId", "", "event", "Landroid/view/KeyEvent;", "onEditorAction"})
    public static final class n implements TextView.OnEditorActionListener {
        final /* synthetic */ View.OnClickListener HOT;

        n(View.OnClickListener onClickListener) {
            this.HOT = onClickListener;
        }

        public final boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
            AppMethodBeat.i(212812);
            if (keyEvent == null) {
                AppMethodBeat.o(212812);
            } else if (keyEvent.getAction() == 1 && keyEvent.getKeyCode() == 66) {
                Log.i("MicroMsg.WeCoinEncashView", "click enter");
                this.HOT.onClick(null);
                AppMethodBeat.o(212812);
            } else {
                AppMethodBeat.o(212812);
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    public static final class k implements Runnable {
        final /* synthetic */ WeCoinEncashView HOQ;

        k(WeCoinEncashView weCoinEncashView) {
            this.HOQ = weCoinEncashView;
        }

        public final void run() {
            AppMethodBeat.i(212807);
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            WeCoinEncashView.h(this.HOQ).getLocationInWindow(iArr);
            WeCoinEncashView.g(this.HOQ).getLocationInWindow(iArr2);
            Log.d("MicroMsg.WeCoinEncashView", "scroll y: %s", Integer.valueOf(iArr[1] - iArr2[1]));
            WeCoinEncashView.g(this.HOQ).scrollBy(0, iArr[1] - iArr2[1]);
            AppMethodBeat.o(212807);
        }
    }

    private final void xP(boolean z) {
        AppMethodBeat.i(212823);
        Log.i("MicroMsg.WeCoinEncashView", "check enable: %s", Boolean.valueOf(z));
        if (!z || !this.HBz) {
            this.mWcKeyboard.DH(false);
            AppMethodBeat.o(212823);
            return;
        }
        this.mWcKeyboard.DH(true);
        AppMethodBeat.o(212823);
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "run"})
    static final class b implements Runnable {
        final /* synthetic */ WeCoinEncashView HOQ;

        b(WeCoinEncashView weCoinEncashView) {
            this.HOQ = weCoinEncashView;
        }

        public final void run() {
            AppMethodBeat.i(212798);
            this.HOQ.showNormalStWcKb();
            AppMethodBeat.o(212798);
        }
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean isHandleAutoShowNormalStWcKb() {
        AppMethodBeat.i(212824);
        WcPayKeyboard wcPayKeyboard = this.mWcKeyboard;
        kotlin.g.b.p.g(wcPayKeyboard, "mWcKeyboard");
        Log.d("MicroMsg.WeCoinEncashView", "isHandleAutoShowNormalStWcKb() mWxKbInterceptState:%s isAutoShowNormalStWcKb:%s", Boolean.valueOf(this.HvA), Boolean.valueOf(wcPayKeyboard.hgR()));
        if (!this.HvA) {
            WcPayKeyboard wcPayKeyboard2 = this.mWcKeyboard;
            kotlin.g.b.p.g(wcPayKeyboard2, "mWcKeyboard");
            if (wcPayKeyboard2.hgR()) {
                AppMethodBeat.o(212824);
                return true;
            }
        }
        AppMethodBeat.o(212824);
        return false;
    }

    @kotlin.l(hxD = {1, 1, 16}, hxE = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\u0006¸\u0006\u0000"}, hxF = {"com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinEncashView$handleInterceptWinInfo$1$clickListener$1", "Lcom/tencent/mm/plugin/wallet/wecoin/model/InterceptWinClickListener;", "onClick", "", "item", "Lcom/tencent/mm/protocal/protobuf/PopUpJumpInfo;", "plugin-wxpay_release"})
    public static final class h implements com.tencent.mm.plugin.wallet.wecoin.model.b {
        final /* synthetic */ WeCoinEncashView HOQ;
        final /* synthetic */ fbz HOR;
        final /* synthetic */ dek HOS;

        h(fbz fbz, WeCoinEncashView weCoinEncashView, dek dek) {
            this.HOR = fbz;
            this.HOQ = weCoinEncashView;
            this.HOS = dek;
        }

        @Override // com.tencent.mm.plugin.wallet.wecoin.model.b
        public final void a(ddc ddc) {
            AppMethodBeat.i(212804);
            if (ddc != null) {
                if (ddc.action == 3) {
                    WeCoinEncashView.a(this.HOQ, this.HOR);
                }
                AppMethodBeat.o(212804);
                return;
            }
            AppMethodBeat.o(212804);
        }
    }

    public static final /* synthetic */ void a(WeCoinEncashView weCoinEncashView, fbz fbz) {
        AppMethodBeat.i(212829);
        Log.i("MicroMsg.WeCoinEncashView", "startCheckPwdUI, params ".concat(String.valueOf(fbz)));
        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1581, 93);
        if (fbz != null) {
            Intent intent = new Intent();
            intent.putExtra("appId", fbz.dNI);
            intent.putExtra("timeStamp", fbz.dmc);
            intent.putExtra("nonceStr", fbz.qcM);
            intent.putExtra("packageExt", fbz.Nyc);
            intent.putExtra("signtype", fbz.qcK);
            intent.putExtra("paySignature", fbz.MiN);
            intent.putExtra("scene", 1);
            com.tencent.mm.br.c.a((Context) weCoinEncashView, "wallet_core", ".ui.WalletCheckPwdUI", intent, 3001, false);
            AppMethodBeat.o(212829);
            return;
        }
        AppMethodBeat.o(212829);
    }

    public static final /* synthetic */ void a(WeCoinEncashView weCoinEncashView, com.tencent.mm.plugin.wallet.wecoin.model.a aVar) {
        AppMethodBeat.i(212830);
        AppCompatActivity context = weCoinEncashView.getContext();
        kotlin.g.b.p.g(context, "context");
        com.tencent.mm.plugin.wallet.wecoin.c.c.a(context, aVar);
        AppMethodBeat.o(212830);
    }

    public static final /* synthetic */ void a(WeCoinEncashView weCoinEncashView, ajj ajj) {
        AppMethodBeat.i(212831);
        Log.i("MicroMsg.WeCoinEncashView", "gotoWeCoinFetchResultUI, info ".concat(String.valueOf(ajj)));
        if (ajj != null) {
            weCoinEncashView.finish();
            WeCoinEncashViewModel weCoinEncashViewModel = weCoinEncashView.HOO;
            if (weCoinEncashViewModel == null) {
                kotlin.g.b.p.btv("mViewModel");
            }
            weCoinEncashViewModel.aeH(21);
            Orders orders = new Orders();
            WeCoinEncashViewModel weCoinEncashViewModel2 = weCoinEncashView.HOO;
            if (weCoinEncashViewModel2 == null) {
                kotlin.g.b.p.btv("mViewModel");
            }
            orders.dDO = (double) weCoinEncashViewModel2.HNk;
            orders.AOl = "CNY";
            orders.HYW = ajj.LsT;
            orders.HYX = ajj.LsU;
            Intent intent = new Intent(weCoinEncashView.getContext(), WeCoinBalanceDetailView.class);
            intent.putExtra("key_orders", orders);
            WeCoinEncashViewModel weCoinEncashViewModel3 = weCoinEncashView.HOO;
            if (weCoinEncashViewModel3 == null) {
                kotlin.g.b.p.btv("mViewModel");
            }
            intent.putExtra("wecoin_fetch_result_kv_data", weCoinEncashViewModel3.HNm);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(weCoinEncashView, bl.axQ(), "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinEncashView", "gotoWeCoinFetchResultUI", "(Lcom/tencent/mm/protocal/protobuf/EncashResultPageInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            weCoinEncashView.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(weCoinEncashView, "com/tencent/mm/plugin/wallet/wecoin/ui/WeCoinEncashView", "gotoWeCoinFetchResultUI", "(Lcom/tencent/mm/protocal/protobuf/EncashResultPageInfo;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(212831);
            return;
        }
        AppMethodBeat.o(212831);
    }

    public static final /* synthetic */ void a(WeCoinEncashView weCoinEncashView, dek dek) {
        cdg cdg;
        AppMethodBeat.i(212832);
        Log.d("MicroMsg.WeCoinEncashView", "handleInterceptWinInfo: ".concat(String.valueOf(dek)));
        if (dek == null || (cdg = dek.MJy) == null) {
            AppMethodBeat.o(212832);
            return;
        }
        h hVar = new h(dek.MJx, weCoinEncashView, dek);
        AppCompatActivity context = weCoinEncashView.getContext();
        kotlin.g.b.p.g(context, "context");
        com.tencent.mm.plugin.wallet.wecoin.c.c.a(context, cdg, hVar);
        AppMethodBeat.o(212832);
    }

    public static final /* synthetic */ void a(WeCoinEncashView weCoinEncashView, Boolean bool) {
        AppMethodBeat.i(212833);
        if (bool == null) {
            AppMethodBeat.o(212833);
        } else if (bool.booleanValue()) {
            weCoinEncashView.showLoading(true);
            AppMethodBeat.o(212833);
        } else {
            weCoinEncashView.hideLoading();
            AppMethodBeat.o(212833);
        }
    }

    public static final /* synthetic */ void a(WeCoinEncashView weCoinEncashView, String str) {
        AppMethodBeat.i(212835);
        Log.i("MicroMsg.WeCoinEncashView", "update tips: %s", str);
        long nF = com.tencent.mm.wallet_core.ui.f.nF(String.valueOf(str), "100");
        if (nF <= 0) {
            TextView textView = weCoinEncashView.HON;
            if (textView == null) {
                kotlin.g.b.p.btv("mTotalBalanceWithdrawTip");
            }
            textView.setText(weCoinEncashView.HBr);
            TextView textView2 = weCoinEncashView.HON;
            if (textView2 == null) {
                kotlin.g.b.p.btv("mTotalBalanceWithdrawTip");
            }
            textView2.setTextColor(weCoinEncashView.wfU);
            weCoinEncashView.HBz = false;
            weCoinEncashView.xP(false);
            AppMethodBeat.o(212835);
        } else if (nF > weCoinEncashView.getIntent().getLongExtra("wecoin_income_balance", 0)) {
            TextView textView3 = weCoinEncashView.HON;
            if (textView3 == null) {
                kotlin.g.b.p.btv("mTotalBalanceWithdrawTip");
            }
            textView3.setText(weCoinEncashView.getString(R.string.j2g));
            TextView textView4 = weCoinEncashView.HON;
            if (textView4 == null) {
                kotlin.g.b.p.btv("mTotalBalanceWithdrawTip");
            }
            textView4.setTextColor(weCoinEncashView.getResources().getColor(R.color.Red_100));
            weCoinEncashView.HBz = false;
            weCoinEncashView.xP(false);
            AppMethodBeat.o(212835);
        } else {
            TextView textView5 = weCoinEncashView.HON;
            if (textView5 == null) {
                kotlin.g.b.p.btv("mTotalBalanceWithdrawTip");
            }
            textView5.setText(weCoinEncashView.HBr);
            TextView textView6 = weCoinEncashView.HON;
            if (textView6 == null) {
                kotlin.g.b.p.btv("mTotalBalanceWithdrawTip");
            }
            textView6.setTextColor(weCoinEncashView.wfU);
            weCoinEncashView.HBz = true;
            weCoinEncashView.xP(true);
            AppMethodBeat.o(212835);
        }
    }

    public static final /* synthetic */ void f(WeCoinEncashView weCoinEncashView) {
        AppMethodBeat.i(212836);
        ScrollView scrollView = weCoinEncashView.HBm;
        if (scrollView == null) {
            kotlin.g.b.p.btv("rootView");
        }
        scrollView.postDelayed(new k(weCoinEncashView), 100);
        AppMethodBeat.o(212836);
    }

    public static final /* synthetic */ void a(WeCoinEncashView weCoinEncashView, long j2) {
        String str;
        AppMethodBeat.i(212838);
        Log.i("MicroMsg.WeCoinEncashView", "prepareEncashRequest, amount ".concat(String.valueOf(j2)));
        WeCoinEncashViewModel weCoinEncashViewModel = weCoinEncashView.HOO;
        if (weCoinEncashViewModel == null) {
            kotlin.g.b.p.btv("mViewModel");
        }
        WeCoinEncashView weCoinEncashView2 = weCoinEncashView;
        kotlin.g.b.p.h(weCoinEncashView2, "keeper");
        com.tencent.mm.plugin.wallet.wecoin.c.a.a(weCoinEncashViewModel.qiR, Boolean.TRUE);
        String fPE = com.tencent.mm.plugin.wallet.wecoin.c.c.fPE();
        weCoinEncashViewModel.zfX = fPE;
        weCoinEncashViewModel.HNk = j2;
        WecoinEncashKVData wecoinEncashKVData = weCoinEncashViewModel.HNm;
        if (wecoinEncashKVData == null || (str = wecoinEncashKVData.nZz) == null) {
            str = "";
        }
        weCoinEncashViewModel.f(6, 1, 0, "");
        com.tencent.mm.plugin.report.service.h.INSTANCE.dN(1581, 90);
        new com.tencent.mm.plugin.wallet.wecoin.b.j(fPE, str, j2).aYI().b(new WeCoinEncashViewModel.c(weCoinEncashViewModel)).a(weCoinEncashView2);
        AppMethodBeat.o(212838);
    }
}
