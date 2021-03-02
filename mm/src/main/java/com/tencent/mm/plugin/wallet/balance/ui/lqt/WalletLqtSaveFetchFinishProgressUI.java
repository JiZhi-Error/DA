package com.tencent.mm.plugin.wallet.balance.ui.lqt;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchResultItemView;
import com.tencent.mm.protocal.protobuf.dlv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;

public class WalletLqtSaveFetchFinishProgressUI extends WalletBaseUI {
    private TextView CkA;
    private TextView CkB;
    private TextView CkC;
    private TextView CkD;
    private ImageView Ckv;
    private ImageView Ckw;
    private ImageView Ckx;
    private TextView Cky;
    private TextView Ckz;
    private dlv HAx;
    private LinearLayout ncf;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        String str;
        AppMethodBeat.i(68959);
        super.onCreate(bundle);
        byte[] byteArrayExtra = getIntent().getByteArrayExtra("key_redeem_res");
        this.HAx = new dlv();
        try {
            this.HAx.parseFrom(byteArrayExtra);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.WalletLqtSaveFetchFinishProgressUI", e2, "parse redeemFundRes error!", new Object[0]);
            finish();
        }
        Object[] objArr = new Object[1];
        dlv dlv = this.HAx;
        if (dlv != null) {
            str = String.format("status:%s, wording_for_status2:%s, pre_arrive_time_wording:%s, redeem_fee:%s, bank_name:%s, card_tail:%s, failure_wording:%s", Integer.valueOf(dlv.status), dlv.MPv, dlv.MPw, Integer.valueOf(dlv.MJd), dlv.ynT, dlv.AOk, dlv.MPx);
        } else {
            str = "";
        }
        objArr[0] = str;
        Log.i("MicroMsg.WalletLqtSaveFetchFinishProgressUI", "onCreate, redeemRes: %s", objArr);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.afz)));
        View customView = getSupportActionBar().getCustomView();
        if (customView != null) {
            View findViewById = customView.findViewById(R.id.brt);
            if (findViewById != null) {
                findViewById.setBackgroundColor(getResources().getColor(R.color.ua));
            }
            View findViewById2 = customView.findViewById(16908308);
            if (findViewById2 != null && (findViewById2 instanceof TextView)) {
                ((TextView) findViewById2).setTextColor(getResources().getColor(R.color.a2x));
            }
        }
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.addFlags(Integer.MIN_VALUE);
            window.setStatusBarColor(getResources().getColor(R.color.afz));
            if (Build.VERSION.SDK_INT >= 23) {
                getWindow().getDecorView().setSystemUiVisibility(8192);
            }
        }
        getContentView().setFitsSystemWindows(true);
        initView();
        showHomeBtn(false);
        enableBackMenu(false);
        setBackBtnVisible(false);
        setMMTitle(R.string.igp);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchFinishProgressUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(68957);
                WalletLqtSaveFetchFinishProgressUI.this.finish();
                AppMethodBeat.o(68957);
                return false;
            }
        });
        AppMethodBeat.o(68959);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(68960);
        this.Ckv = (ImageView) findViewById(R.id.acp);
        this.Ckw = (ImageView) findViewById(R.id.acq);
        this.Ckx = (ImageView) findViewById(R.id.acr);
        this.Ckv.setImageResource(R.drawable.f1);
        this.Ckw.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.Ckw.setImageResource(R.raw.remittance_wait);
        this.Ckx.setImageResource(R.drawable.f2);
        this.Cky = (TextView) findViewById(R.id.acx);
        this.Ckz = (TextView) findViewById(R.id.acy);
        this.CkA = (TextView) findViewById(R.id.acz);
        this.Cky.setText(R.string.ih3);
        this.Ckz.setText(this.HAx.MPv);
        this.Ckz.setTextColor(getResources().getColor(R.color.a2x));
        this.CkA.setText(R.string.i6e);
        this.CkB = (TextView) findViewById(R.id.acm);
        this.CkC = (TextView) findViewById(R.id.acn);
        this.CkD = (TextView) findViewById(R.id.aco);
        this.CkB.setVisibility(8);
        this.CkC.setText(this.HAx.MPw);
        this.CkC.setVisibility(0);
        this.CkD.setVisibility(8);
        this.ncf = (LinearLayout) findViewById(R.id.acg);
        this.ncf.setBackgroundResource(R.drawable.f0);
        WalletBalanceFetchResultItemView walletBalanceFetchResultItemView = new WalletBalanceFetchResultItemView((Context) this, true);
        walletBalanceFetchResultItemView.b(R.string.ii5, f.D((double) (((float) this.HAx.MJd) / 100.0f)));
        this.ncf.addView(walletBalanceFetchResultItemView);
        if (!Util.isNullOrNil(this.HAx.ynT)) {
            String str = this.HAx.ynT;
            if (!Util.isNullOrNil(this.HAx.AOk)) {
                str = str + " " + getString(R.string.inh) + this.HAx.AOk;
            }
            WalletBalanceFetchResultItemView walletBalanceFetchResultItemView2 = new WalletBalanceFetchResultItemView(this);
            walletBalanceFetchResultItemView2.b(R.string.ign, str);
            this.ncf.addView(walletBalanceFetchResultItemView2);
        }
        if (!Util.isNullOrNil(this.HAx.MPx)) {
            WalletBalanceFetchResultItemView walletBalanceFetchResultItemView3 = new WalletBalanceFetchResultItemView(this);
            walletBalanceFetchResultItemView3.b(R.string.igj, this.HAx.MPx);
            this.ncf.addView(walletBalanceFetchResultItemView3);
        }
        ((Button) findViewById(R.id.acj)).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.lqt.WalletLqtSaveFetchFinishProgressUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(68958);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchFinishProgressUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WalletLqtSaveFetchFinishProgressUI.this.finish();
                a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/lqt/WalletLqtSaveFetchFinishProgressUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(68958);
            }
        });
        findViewById(R.id.ad1).setVisibility(8);
        findViewById(R.id.ach).setVisibility(8);
        AppMethodBeat.o(68960);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ic;
    }
}
