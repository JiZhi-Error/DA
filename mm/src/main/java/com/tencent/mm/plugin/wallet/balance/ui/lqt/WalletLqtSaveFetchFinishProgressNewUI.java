package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchResultItemView;
import com.tencent.mm.protocal.protobuf.dlv;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import java.util.Arrays;
import kotlin.g.b.ae;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\r\u001a\u00020\u000eH\u0014J\u0012\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J,\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00172\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000¨\u0006\u001c"}, hxF = {"Lcom/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchFinishProgressNewUI;", "Lcom/tencent/mm/wallet_core/ui/WalletBaseUI;", "()V", "contentLayout", "Landroid/widget/LinearLayout;", "finishBtn", "Landroid/view/View;", "redeemFundRes", "Lcom/tencent/mm/protocal/protobuf/RedeemFundRes;", "title", "Landroid/widget/TextView;", "getLayoutId", "", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSceneEnd", "", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "redeemToString", "Companion", "plugin-wxpay_release"})
public final class WalletLqtSaveFetchFinishProgressNewUI extends WalletBaseUI {
    public static final a HAy = new a((byte) 0);
    private View HAw;
    private dlv HAx;
    private TextView hbb;
    private LinearLayout oVX;

    static {
        AppMethodBeat.i(212686);
        AppMethodBeat.o(212686);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, hxF = {"Lcom/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchFinishProgressNewUI$Companion;", "", "()V", "TAG", "", "plugin-wxpay_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public final void onCreate(Bundle bundle) {
        String str;
        AppMethodBeat.i(212684);
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar == null) {
            p.hyc();
        }
        supportActionBar.hide();
        showHomeBtn(false);
        enableBackMenu(false);
        setBackBtnVisible(false);
        this.mController.setStatusBarColor(getResources().getColor(R.color.afz));
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_redeem_res");
        this.HAx = new dlv();
        try {
            dlv dlv = this.HAx;
            if (dlv == null) {
                p.btv("redeemFundRes");
            }
            dlv.parseFrom(byteArrayExtra);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.WalletLqtSaveFetchFinishProgressNewUI", e2, "parse redeemFundRes error!", new Object[0]);
            finish();
        }
        Object[] objArr = new Object[1];
        dlv dlv2 = this.HAx;
        if (dlv2 == null) {
            p.btv("redeemFundRes");
        }
        if (dlv2 != null) {
            ae aeVar = ae.SYK;
            str = String.format("status:%s, wording_for_status2:%s, pre_arrive_time_wording:%s, redeem_fee:%s, bank_name:%s, card_tail:%s, failure_wording:%s", Arrays.copyOf(new Object[]{Integer.valueOf(dlv2.status), dlv2.MPv, dlv2.MPw, Integer.valueOf(dlv2.MJd), dlv2.ynT, dlv2.AOk, dlv2.MPx}, 7));
            p.g(str, "java.lang.String.format(format, *args)");
        } else {
            str = "";
        }
        objArr[0] = str;
        Log.i("MicroMsg.WalletLqtSaveFetchFinishProgressNewUI", "onCreate, redeemRes: %s", objArr);
        initView();
        h.INSTANCE.a(20287, 8);
        AppMethodBeat.o(212684);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final void initView() {
        AppMethodBeat.i(212685);
        View findViewById = findViewById(R.id.ewk);
        p.g(findViewById, "findViewById(R.id.lqt_fetch_result_finish_title)");
        this.hbb = (TextView) findViewById;
        dlv dlv = this.HAx;
        if (dlv == null) {
            p.btv("redeemFundRes");
        }
        if (!Util.isNullOrNil(dlv.MPy)) {
            Object[] objArr = new Object[1];
            dlv dlv2 = this.HAx;
            if (dlv2 == null) {
                p.btv("redeemFundRes");
            }
            objArr[0] = dlv2.MPy;
            Log.i("MicroMsg.WalletLqtSaveFetchFinishProgressNewUI", "redeemFundRes.pre_arrival_time_headline: %s", objArr);
            TextView textView = this.hbb;
            if (textView == null) {
                p.btv("title");
            }
            dlv dlv3 = this.HAx;
            if (dlv3 == null) {
                p.btv("redeemFundRes");
            }
            textView.setText(dlv3.MPy);
        } else {
            TextView textView2 = this.hbb;
            if (textView2 == null) {
                p.btv("title");
            }
            textView2.setText(getString(R.string.b6x));
        }
        View findViewById2 = findViewById(R.id.ewh);
        p.g(findViewById2, "findViewById(R.id.lqt_fe…lt_finish_content_layout)");
        this.oVX = (LinearLayout) findViewById2;
        WalletBalanceFetchResultItemView walletBalanceFetchResultItemView = new WalletBalanceFetchResultItemView((Context) this, true);
        dlv dlv4 = this.HAx;
        if (dlv4 == null) {
            p.btv("redeemFundRes");
        }
        walletBalanceFetchResultItemView.b(R.string.ii5, f.D((double) (((float) dlv4.MJd) / 100.0f)));
        LinearLayout linearLayout = this.oVX;
        if (linearLayout == null) {
            p.btv("contentLayout");
        }
        linearLayout.addView(walletBalanceFetchResultItemView);
        dlv dlv5 = this.HAx;
        if (dlv5 == null) {
            p.btv("redeemFundRes");
        }
        if (!Util.isNullOrNil(dlv5.ynT)) {
            dlv dlv6 = this.HAx;
            if (dlv6 == null) {
                p.btv("redeemFundRes");
            }
            String str = dlv6.ynT;
            dlv dlv7 = this.HAx;
            if (dlv7 == null) {
                p.btv("redeemFundRes");
            }
            if (!Util.isNullOrNil(dlv7.AOk)) {
                StringBuilder append = new StringBuilder().append(str).append(" (");
                dlv dlv8 = this.HAx;
                if (dlv8 == null) {
                    p.btv("redeemFundRes");
                }
                str = append.append(dlv8.AOk).append(")").toString();
            }
            WalletBalanceFetchResultItemView walletBalanceFetchResultItemView2 = new WalletBalanceFetchResultItemView(this);
            walletBalanceFetchResultItemView2.b(R.string.igo, str);
            LinearLayout linearLayout2 = this.oVX;
            if (linearLayout2 == null) {
                p.btv("contentLayout");
            }
            linearLayout2.addView(walletBalanceFetchResultItemView2);
        }
        View findViewById3 = findViewById(R.id.ewg);
        p.g(findViewById3, "findViewById(R.id.lqt_fetch_result_finish_btn)");
        this.HAw = findViewById3;
        View view = this.HAw;
        if (view == null) {
            p.btv("finishBtn");
        }
        view.setOnClickListener(new b(this));
        AppMethodBeat.o(212685);
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    public static final class b implements View.OnClickListener {
        final /* synthetic */ WalletLqtSaveFetchFinishProgressNewUI HAz;

        b(WalletLqtSaveFetchFinishProgressNewUI walletLqtSaveFetchFinishProgressNewUI) {
            this.HAz = walletLqtSaveFetchFinishProgressNewUI;
        }

        public final void onClick(View view) {
            AppMethodBeat.i(212683);
            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
            bVar.bm(view);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchFinishProgressNewUI$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
            this.HAz.finish();
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchFinishProgressNewUI$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(212683);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public final int getLayoutId() {
        return R.layout.b37;
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public final boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        return false;
    }
}
