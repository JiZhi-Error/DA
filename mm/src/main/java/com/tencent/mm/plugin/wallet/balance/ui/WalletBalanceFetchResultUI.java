package com.tencent.mm.plugin.wallet.balance.ui;

import android.content.Context;
import android.content.DialogInterface;
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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.wallet_core.id_verify.util.RealnameGuideHelper;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.f;
import com.tencent.sqlitelint.util.SQLiteLintUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;

@a(19)
public class WalletBalanceFetchResultUI extends WalletBaseUI {
    private TextView CkA;
    private TextView CkB;
    private TextView CkC;
    private TextView CkD;
    private ImageView Ckv;
    private ImageView Ckw;
    private ImageView Ckx;
    private TextView Cky;
    private TextView Ckz;
    private Orders CwO;
    private LinearLayout ncf;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(68573);
        super.onCreate(bundle);
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
            int i2 = Build.VERSION.SDK_INT;
        }
        getContentView().setFitsSystemWindows(true);
        this.CwO = (Orders) getInput().getParcelable("key_orders");
        if (this.CwO == null) {
            Log.w("MicroMsg.WalletBalanceFetchResultUI", "order is null!");
            finish();
            AppMethodBeat.o(68573);
            return;
        }
        initView();
        setMMTitle((String) getNetController().getTips(0));
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchResultUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(68570);
                WalletBalanceFetchResultUI.a(WalletBalanceFetchResultUI.this);
                AppMethodBeat.o(68570);
                return false;
            }
        });
        AppMethodBeat.o(68573);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(68574);
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
        this.Cky.setText(R.string.i6j);
        this.Ckz.setText(R.string.i6h);
        this.Ckz.setTextColor(getResources().getColor(R.color.a2x));
        this.CkA.setText(R.string.i6e);
        this.CkB = (TextView) findViewById(R.id.acm);
        this.CkC = (TextView) findViewById(R.id.acn);
        this.CkD = (TextView) findViewById(R.id.aco);
        this.CkB.setVisibility(8);
        this.CkC.setText(getString(R.string.i66, new Object[]{new SimpleDateFormat(SQLiteLintUtil.YYYY_MM_DD_HH_mm).format(new Date(this.CwO.HYW))}));
        this.CkC.setVisibility(0);
        this.CkD.setVisibility(8);
        this.ncf = (LinearLayout) findViewById(R.id.acg);
        this.ncf.setBackgroundResource(R.drawable.f0);
        String string = getInput().getString("key_fetch_result_show_info");
        ArrayList<j.a> arrayList = new ArrayList();
        if (!Util.isNullOrNil(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    j.a bI = j.a.bI(jSONArray.optJSONObject(i2));
                    if (bI != null) {
                        arrayList.add(bI);
                    }
                }
            } catch (JSONException e2) {
                Log.printErrStackTrace("MicroMsg.WalletBalanceFetchResultUI", e2, "", new Object[0]);
            }
        }
        Log.d("MicroMsg.WalletBalanceFetchResultUI", "show info: %s", Integer.valueOf(arrayList.size()));
        if (!arrayList.isEmpty()) {
            for (j.a aVar : arrayList) {
                if (aVar.HXQ != null) {
                    WalletBalanceFetchResultItemView walletBalanceFetchResultItemView = new WalletBalanceFetchResultItemView(this, aVar.id != 3);
                    walletBalanceFetchResultItemView.a(aVar.HXQ.name, aVar.HXQ.value, aVar.HXQ.xEk, aVar.HXQ.Iaq, aVar.id == 3);
                    this.ncf.addView(walletBalanceFetchResultItemView);
                }
            }
        } else {
            WalletBalanceFetchResultItemView walletBalanceFetchResultItemView2 = new WalletBalanceFetchResultItemView((Context) this, true);
            walletBalanceFetchResultItemView2.b(R.string.i76, f.d(this.CwO.dDO, this.CwO.AOl));
            this.ncf.addView(walletBalanceFetchResultItemView2);
            if (this.CwO.CoZ > 0.0d) {
                WalletBalanceFetchResultItemView walletBalanceFetchResultItemView3 = new WalletBalanceFetchResultItemView((Context) this, true);
                walletBalanceFetchResultItemView3.b(R.string.i6y, f.d(this.CwO.CoZ, this.CwO.AOl));
                this.ncf.addView(walletBalanceFetchResultItemView3);
            }
            if (this.CwO.HZd != null && this.CwO.HZd.size() > 0) {
                Orders.Commodity commodity = this.CwO.HZd.get(0);
                String str = commodity.AOj;
                String str2 = !Util.isNullOrNil(commodity.HZG) ? str + " " + getString(R.string.inh) + commodity.HZG : str;
                WalletBalanceFetchResultItemView walletBalanceFetchResultItemView4 = new WalletBalanceFetchResultItemView(this);
                walletBalanceFetchResultItemView4.b(R.string.i62, str2);
                this.ncf.addView(walletBalanceFetchResultItemView4);
            }
        }
        ((Button) findViewById(R.id.acj)).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchResultUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(68571);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchResultUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                WalletBalanceFetchResultUI.a(WalletBalanceFetchResultUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/balance/ui/WalletBalanceFetchResultUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(68571);
            }
        });
        findViewById(R.id.ad1).setVisibility(8);
        findViewById(R.id.ach).setVisibility(8);
        AppMethodBeat.o(68574);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ic;
    }

    static /* synthetic */ void a(WalletBalanceFetchResultUI walletBalanceFetchResultUI) {
        AppMethodBeat.i(68575);
        if (walletBalanceFetchResultUI.getInput().containsKey("key_realname_guide_helper")) {
            RealnameGuideHelper realnameGuideHelper = (RealnameGuideHelper) walletBalanceFetchResultUI.getInput().getParcelable("key_realname_guide_helper");
            if (realnameGuideHelper != null) {
                Bundle bundle = new Bundle();
                bundle.putString("realname_verify_process_jump_activity", ".balance.ui.WalletBalanceResultUI");
                bundle.putString("realname_verify_process_jump_plugin", "wallet");
                realnameGuideHelper.b(walletBalanceFetchResultUI, bundle, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet.balance.ui.WalletBalanceFetchResultUI.AnonymousClass3 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(68572);
                        WalletBalanceFetchResultUI.this.getProcess().a(WalletBalanceFetchResultUI.this, 0, WalletBalanceFetchResultUI.this.getInput());
                        AppMethodBeat.o(68572);
                    }
                });
                walletBalanceFetchResultUI.getInput().remove("key_realname_guide_helper");
            }
            AppMethodBeat.o(68575);
            return;
        }
        walletBalanceFetchResultUI.getProcess().a(walletBalanceFetchResultUI, 0, walletBalanceFetchResultUI.getInput());
        AppMethodBeat.o(68575);
    }
}
