package com.tencent.mm.plugin.remittance.mobile.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.g.b.a.lc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.newtips.NormalIconNewTipPreference;
import com.tencent.mm.plugin.newtips.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.ui.e;

public class BankMobileRemittanceChooseUI extends MMPreference {
    private NormalIconNewTipPreference Cmj;
    private NormalIconNewTipPreference Cmk;
    private f screen;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void eNu() {
        AppMethodBeat.i(213709);
        Wa(11);
        AppMethodBeat.o(213709);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.q;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(67666);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(67666);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(67667);
        super.initView();
        setMMTitle("");
        hideActionbarLine();
        setActionbarColor(getResources().getColor(R.color.afz));
        setBackGroundColorResource(R.color.afz);
        if (getListView() != null) {
            int dimensionPixelSize = getContext().getResources().getDimensionPixelSize(R.dimen.ce);
            getListView().setPadding(dimensionPixelSize, 0, dimensionPixelSize, 0);
            getListView().setBackgroundColor(getResources().getColor(R.color.afz));
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.remittance.mobile.ui.BankMobileRemittanceChooseUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(67664);
                BankMobileRemittanceChooseUI.this.finish();
                AppMethodBeat.o(67664);
                return true;
            }
        });
        this.screen = getPreferenceScreen();
        this.Cmj = (NormalIconNewTipPreference) this.screen.bmg("bank_mobile_remit_choose_bank");
        this.Cmk = (NormalIconNewTipPreference) this.screen.bmg("bank_mobile_remit_choose_mobile");
        this.Cmj.OYi = true;
        this.Cmj.setDesc(getString(R.string.aas));
        this.Cmj.gLF();
        this.Cmj.alI(8);
        this.Cmj.a(this.screen);
        a.exl().h(this.Cmj);
        this.Cmk.OYi = true;
        this.Cmk.setDesc(getString(R.string.aau));
        this.Cmk.gLF();
        this.Cmk.alI(8);
        this.Cmk.a(this.screen);
        a.exl().h(this.Cmk);
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(67667);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        AppMethodBeat.i(67668);
        super.onResume();
        setBackGroundColorResource(R.color.afz);
        getContentView().post(new Runnable() {
            /* class com.tencent.mm.plugin.remittance.mobile.ui.BankMobileRemittanceChooseUI.AnonymousClass2 */

            public final void run() {
                AppMethodBeat.i(213706);
                BankMobileRemittanceChooseUI.a(BankMobileRemittanceChooseUI.this);
                AppMethodBeat.o(213706);
            }
        });
        AppMethodBeat.o(67668);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public View getBottomView() {
        AppMethodBeat.i(67669);
        LinearLayout linearLayout = (LinearLayout) aa.jQ(getContext()).inflate(R.layout.i4, (ViewGroup) null);
        String string = getString(R.string.aaq);
        com.tencent.mm.wallet_core.ui.f.a((TextView) linearLayout.findViewById(R.id.a0o), string, 0, string.length(), new e(new e.a() {
            /* class com.tencent.mm.plugin.remittance.mobile.ui.BankMobileRemittanceChooseUI.AnonymousClass3 */

            @Override // com.tencent.mm.wallet_core.ui.e.a
            public final void bmr() {
                AppMethodBeat.i(213707);
                Log.i("MicroMsg.BankMobile.BankMobileRemittanceChooseUI", "onClick() go to WalletPasswordSettingUI");
                Intent intent = new Intent();
                intent.putExtra("key_enter_scene", 1);
                c.b(BankMobileRemittanceChooseUI.this.getContext(), "wallet", ".pwd.ui.WalletPasswordSettingUI", intent);
                BankMobileRemittanceChooseUI.eNu();
                AppMethodBeat.o(213707);
            }
        }), getContext());
        AppMethodBeat.o(67669);
        return linearLayout;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(67670);
        super.onDestroy();
        AppMethodBeat.o(67670);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(67671);
        Log.i("MicroMsg.BankMobile.BankMobileRemittanceChooseUI", "onPreferenceTreeClick() key:%s", preference.mKey);
        if (Util.isEqual("bank_mobile_remit_choose_bank", preference.mKey)) {
            a.exl().TC(21);
            c.V(getContext(), "remittance", ".bankcard.ui.BankRemitBankcardInputUI");
            AppMethodBeat.o(67671);
            return true;
        } else if (Util.isEqual("bank_mobile_remit_choose_mobile", preference.mKey)) {
            a.exl().TC(22);
            if (g.aAh().azQ().getBoolean(ar.a.USERINFO_MOBILE_REMITTANCE_WELOCOME_PAGE_SHOW_BOOLEAN_SYNC, true)) {
                c.V(getContext(), "remittance", ".mobile.ui.MobileRemitWelcomeUI");
            } else {
                c.V(getContext(), "remittance", ".mobile.ui.MobileRemitNumberInputUI");
            }
            Wa(4);
            AppMethodBeat.o(67671);
            return true;
        } else {
            AppMethodBeat.o(67671);
            return false;
        }
    }

    private static void Wa(int i2) {
        AppMethodBeat.i(67672);
        lc lcVar = new lc();
        lcVar.ejA = (long) i2;
        lcVar.bfK();
        AppMethodBeat.o(67672);
    }

    static /* synthetic */ void a(BankMobileRemittanceChooseUI bankMobileRemittanceChooseUI) {
        boolean z = true;
        AppMethodBeat.i(213708);
        CharSequence text = ClipboardHelper.getText(bankMobileRemittanceChooseUI);
        if (!Util.isNullOrNil(text)) {
            String replace = text.toString().replace(" ", "");
            if (!Util.isNullOrNil(replace) && (com.tencent.mm.plugin.remittance.a.c.eMU().CiD == null || !Util.isEqual(com.tencent.mm.plugin.remittance.a.c.eMU().CiD.toString(), replace))) {
                String trim = replace.trim();
                Log.d("MicroMsg.BankMobile.BankMobileRemittanceChooseUI", "text:%s", trim);
                if (k.a.Kra.matcher(trim).find()) {
                    a.a(bankMobileRemittanceChooseUI, false, trim);
                } else if (k.a.KqZ.matcher(trim).find()) {
                    a.a(bankMobileRemittanceChooseUI, true, trim);
                } else {
                    z = false;
                }
                if (z) {
                    com.tencent.mm.plugin.remittance.a.c.eMU().CiD = trim;
                }
            }
        }
        AppMethodBeat.o(213708);
    }
}
