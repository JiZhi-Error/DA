package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.base.model.c;
import com.tencent.mm.plugin.wallet_core.c.u;
import com.tencent.mm.plugin.wallet_core.model.ad;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;

public class WalletSwitchWalletCurrencyUI extends WalletBaseUI implements View.OnClickListener {
    private ListView Ikm;
    private ArrayList<ad> Ikn = null;
    private t Iko = null;
    private ad Ikp;
    private ad Ikq;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.report.MMSecDataActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.wallet_core.ui.WalletBaseUI
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(71248);
        super.onCreate(bundle);
        setMMTitle(R.string.it9);
        g.aAi();
        g.aAh().azQ().set(ar.a.USERINFO_HAD_SHOW_WALLET_MULTI_WALLET_GUIDE_BOOLEAN, Boolean.TRUE);
        getIntent().getIntExtra("switch_wallet_scene", 0);
        this.Ikn = t.fQL().fSs();
        if (this.Ikn == null || this.Ikn.size() == 0) {
            Log.i("MicroMsg.WalletSwitchWalletCurrencyUI", "not data cache,do NetSceneQueryUserWallet");
            yu(true);
        } else {
            Log.i("MicroMsg.WalletSwitchWalletCurrencyUI", "use cache data first, and do NetSceneQueryUserWallet for update cache");
            yu(false);
        }
        initView();
        setResult(0);
        AppMethodBeat.o(71248);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(71249);
        this.Ikm = (ListView) findViewById(R.id.hn5);
        this.Iko = new t(this, this.Ikn);
        this.Ikm.setAdapter((ListAdapter) this.Iko);
        if (this.Ikn != null && this.Ikn.size() > 0) {
            this.Iko.mData = this.Ikn;
            this.Iko.notifyDataSetChanged();
        }
        this.Ikm.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletSwitchWalletCurrencyUI.AnonymousClass1 */

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                AppMethodBeat.i(71247);
                b bVar = new b();
                bVar.bm(adapterView);
                bVar.bm(view);
                bVar.pH(i2);
                bVar.zo(j2);
                a.b("com/tencent/mm/plugin/wallet_core/ui/WalletSwitchWalletCurrencyUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V", this, bVar.axR());
                ad aeV = WalletSwitchWalletCurrencyUI.this.Iko.aeV(i2);
                WalletSwitchWalletCurrencyUI.this.Ikq = WalletSwitchWalletCurrencyUI.this.Iko.Iks;
                if (aeV != null && (WalletSwitchWalletCurrencyUI.this.Ikq == null || !WalletSwitchWalletCurrencyUI.this.Ikq.field_wallet_tpa_country.equals(aeV.field_wallet_tpa_country))) {
                    WalletSwitchWalletCurrencyUI.this.Ikp = aeV;
                    WalletSwitchWalletCurrencyUI walletSwitchWalletCurrencyUI = WalletSwitchWalletCurrencyUI.this;
                    String str = aeV.field_wallet_tpa_country;
                    Log.i("MicroMsg.WalletSwitchWalletCurrencyUI", "doSetUserWallet walletid = ".concat(String.valueOf(str)));
                    walletSwitchWalletCurrencyUI.doSceneForceProgress(new u(str));
                }
                a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletSwitchWalletCurrencyUI$1", "android/widget/AdapterView$OnItemClickListener", "onItemClick", "(Landroid/widget/AdapterView;Landroid/view/View;IJ)V");
                AppMethodBeat.o(71247);
            }
        });
        AppMethodBeat.o(71249);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletBaseUI
    public boolean onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(71250);
        if (qVar instanceof com.tencent.mm.plugin.wallet_core.c.q) {
            if (i2 == 0 && i3 == 0) {
                Log.i("MicroMsg.WalletSwitchWalletCurrencyUI", "NetSceneQueryUserWallet succ and update view");
                this.Ikn = t.fQL().fSs();
                this.Iko.mData = this.Ikn;
                this.Iko.notifyDataSetChanged();
                AppMethodBeat.o(71250);
                return true;
            }
            Log.e("MicroMsg.WalletSwitchWalletCurrencyUI", "NetSceneQueryUserWallet error");
            if (this.Ikn == null) {
                Log.e("MicroMsg.WalletSwitchWalletCurrencyUI", "wallet list is null in cache");
                AppMethodBeat.o(71250);
                return false;
            }
            Log.e("MicroMsg.WalletSwitchWalletCurrencyUI", "use cache wallet list data");
            AppMethodBeat.o(71250);
            return true;
        } else if ((qVar instanceof u) && i2 == 0 && i3 == 0) {
            this.Ikp.field_wallet_selected = 1;
            Log.i("MicroMsg.WalletSwitchWalletCurrencyUI", "set user wallet succ. current wallet type = " + this.Ikp.field_wallet_type + " " + this.Ikp.field_wallet_tpa_country_mask);
            ap.gni().reset();
            t.fQL().update(this.Ikp, new String[0]);
            ad adVar = this.Iko.Iks;
            if (adVar != null) {
                adVar.field_wallet_selected = 0;
                t.fQL().update(adVar, new String[0]);
            }
            g.aAi();
            g.aAh().azQ().set(339975, Integer.valueOf(this.Ikp.field_wallet_type));
            g.aAi();
            g.aAh().azQ().set(ar.a.USERINFO_WALLET_REGION_TYPE_INT_SYNC, Integer.valueOf(this.Ikp.field_wallet_tpa_country_mask));
            c.cjL();
            if (z.aUp()) {
                t.fQC();
                t.aq(this, null);
            }
            Intent intent = new Intent();
            intent.putExtra("is_switch_wallet", 1);
            setResult(-1, intent);
            finish();
            AppMethodBeat.o(71250);
            return true;
        } else {
            AppMethodBeat.o(71250);
            return false;
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.ca_;
    }

    private void yu(boolean z) {
        AppMethodBeat.i(71251);
        Log.i("MicroMsg.WalletSwitchWalletCurrencyUI", "doGetAllWalletType isShowProcess = ".concat(String.valueOf(z)));
        doSceneProgress(new com.tencent.mm.plugin.wallet_core.c.q(), z);
        AppMethodBeat.o(71251);
    }

    public void onClick(View view) {
        AppMethodBeat.i(71252);
        b bVar = new b();
        bVar.bm(view);
        a.b("com/tencent/mm/plugin/wallet_core/ui/WalletSwitchWalletCurrencyUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
        a.a(this, "com/tencent/mm/plugin/wallet_core/ui/WalletSwitchWalletCurrencyUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(71252);
    }
}
