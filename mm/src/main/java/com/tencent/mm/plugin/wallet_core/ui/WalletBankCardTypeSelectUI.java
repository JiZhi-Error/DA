package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.SelectPreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.t;
import java.util.ArrayList;

public class WalletBankCardTypeSelectUI extends MMPreference {
    private ArrayList<String> Idc;
    private String Idd;
    private SelectPreference Ide;
    private SelectPreference Idf;
    private f screen;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.da;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(70715);
        super.onCreate(bundle);
        setMMTitle(R.string.ic8);
        this.Idc = getIntent().getStringArrayListExtra("bank_type_show_list");
        initView();
        AppMethodBeat.o(70715);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(70716);
        this.screen = getPreferenceScreen();
        for (int i2 = 0; i2 < this.Idc.size(); i2++) {
            SelectPreference selectPreference = new SelectPreference(getContext());
            selectPreference.setKey(this.Idc.get(i2));
            selectPreference.setTitle(this.Idc.get(i2));
            this.screen.c(selectPreference);
        }
        if (this.Idc.get(0) != null) {
            this.Idf = (SelectPreference) this.screen.bmg(this.Idc.get(0));
            this.Idf.isSelected = true;
            this.Idd = this.Idc.get(0);
            this.screen.notifyDataSetChanged();
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletBankCardTypeSelectUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(174508);
                WalletBankCardTypeSelectUI.this.hideVKB();
                WalletBankCardTypeSelectUI.this.finish();
                AppMethodBeat.o(174508);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.vl), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletBankCardTypeSelectUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(174509);
                Intent intent = new Intent();
                intent.putExtra("bank_card_acc_name", WalletBankCardTypeSelectUI.this.Idd);
                Log.i("WalletBankCardTypeSelectUI", "item bank: %s", WalletBankCardTypeSelectUI.this.Idd);
                WalletBankCardTypeSelectUI.this.setResult(-1, intent);
                WalletBankCardTypeSelectUI.this.finish();
                AppMethodBeat.o(174509);
                return true;
            }
        }, null, t.b.GREEN);
        AppMethodBeat.o(70716);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(174510);
        String str = preference.mKey;
        for (int i2 = 0; i2 < this.Idc.size(); i2++) {
            if (str.equals(this.Idc.get(i2))) {
                this.Ide = (SelectPreference) fVar.bmg(this.Idc.get(i2));
                this.Ide.isSelected = true;
                this.Idd = this.Idc.get(i2);
                if (!this.Idf.mKey.equals(this.Ide.mKey)) {
                    this.Idf.isSelected = false;
                    this.Idf = this.Ide;
                }
                fVar.notifyDataSetChanged();
            }
        }
        AppMethodBeat.o(174510);
        return false;
    }
}
