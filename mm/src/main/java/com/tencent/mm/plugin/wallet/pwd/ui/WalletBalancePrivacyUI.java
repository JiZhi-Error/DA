package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.av.r;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.plugin.wallet.pwd.a.k;
import com.tencent.mm.plugin.wallet_core.model.al;
import com.tencent.mm.plugin.wallet_core.model.am;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.protocal.protobuf.dwo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.wallet_core.ui.h;
import java.util.Map;

public class WalletBalancePrivacyUI extends MMPreference implements i {
    private WalletBalancePrivacyCheckBoxPreference HIN;
    private WalletBalancePrivacyMMHeaderPreference HIO;
    private Dialog jUV;
    private f screen;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(69593);
        super.onCreate(bundle);
        hideActionbarLine();
        initView();
        AppMethodBeat.o(69593);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        AppMethodBeat.i(69594);
        super.onResume();
        g.aAi();
        g.aAg().hqi.a(2635, this);
        g.aAi();
        g.aAg().hqi.a(2554, this);
        AppMethodBeat.o(69594);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.d_;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(69596);
        setMMTitle("");
        setActionbarColor(getResources().getColor(R.color.afz));
        setBackGroundColorResource(R.color.afz);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletBalancePrivacyUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(69590);
                WalletBalancePrivacyUI.this.finish();
                AppMethodBeat.o(69590);
                return true;
            }
        });
        if (getListView() != null) {
            getListView().setBackgroundColor(getResources().getColor(R.color.afz));
        }
        this.screen = getPreferenceScreen();
        if (this.screen != null) {
            this.screen.removeAll();
        }
        this.HIN = (WalletBalancePrivacyCheckBoxPreference) this.screen.bmg("wallet_banlance_privacy_cb");
        this.jUV = h.c(this, false, null);
        g.aAi();
        g.aAg().hqi.a(new com.tencent.mm.plugin.wallet.pwd.a.i(), 0);
        AppMethodBeat.o(69596);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        dwo dwo;
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(69597);
        Log.i("MicroMsg.WalletBalancePrivacyUI", "onSceneEnd() errType:" + i2 + " errCode:" + i3 + " errMsg:" + str + " netsceneType:" + qVar.getType());
        if (qVar instanceof com.tencent.mm.plugin.wallet.pwd.a.i) {
            if (i2 == 0 && i3 == 0) {
                Log.i("MicroMsg.WalletBalancePrivacyUI", "success get balance privacy detail");
                com.tencent.mm.plugin.wallet.pwd.a.i iVar = (com.tencent.mm.plugin.wallet.pwd.a.i) qVar;
                if (this.screen == null || iVar == null || iVar.fOO() == null || iVar.fOO().MMQ == null) {
                    z = false;
                } else {
                    Log.i("MicroMsg.WalletBalancePrivacyUI", "refresh() title_icon:%s,title:%s,switch_title:%s,switch_desc:%s,switch_state:%s", iVar.fOO().MMQ.Nuu, iVar.fOO().MMQ.title, iVar.fOO().MMQ.Nkr, iVar.fOO().MMQ.Nuv, Integer.valueOf(iVar.fOO().MMP));
                    this.screen.addPreferencesFromResource(R.xml.d_);
                    this.HIO = (WalletBalancePrivacyMMHeaderPreference) this.screen.bmg("wallet_balance_privacy_header");
                    this.HIO.icon = iVar.fOO().MMQ.Nuu;
                    this.HIO.title = iVar.fOO().MMQ.title;
                    this.HIN = (WalletBalancePrivacyCheckBoxPreference) this.screen.bmg("wallet_banlance_privacy_cb");
                    this.HIN.OZw = false;
                    this.HIN.setTitle(iVar.fOO().MMQ.Nkr);
                    this.HIN.setSummary(iVar.fOO().MMQ.Nuv);
                    this.HIN.oD = Util.isEqual(iVar.fOO().MMP, 1);
                    this.screen.notifyDataSetChanged();
                    z = true;
                }
                if (this.jUV != null && this.jUV.isShowing()) {
                    this.jUV.dismiss();
                }
                if (!z) {
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.ire), "", false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletBalancePrivacyUI.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(69591);
                            WalletBalancePrivacyUI.this.finish();
                            AppMethodBeat.o(69591);
                        }
                    });
                }
            } else {
                Log.i("MicroMsg.WalletBalancePrivacyUI", "fail get balance privacy detail");
                if (this.jUV != null && this.jUV.isShowing()) {
                    this.jUV.dismiss();
                }
                com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.ire), "", false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletBalancePrivacyUI.AnonymousClass3 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(69592);
                        WalletBalancePrivacyUI.this.finish();
                        AppMethodBeat.o(69592);
                    }
                });
            }
        }
        if (qVar instanceof k) {
            if (i2 == 0 && i3 == 0) {
                int i4 = ((k) qVar).fOP().MMP;
                if (this.HIN == null) {
                    this.HIN = (WalletBalancePrivacyCheckBoxPreference) this.screen.bmg("wallet_banlance_privacy_cb");
                }
                Object[] objArr = new Object[2];
                objArr[0] = this.HIN != null ? Boolean.valueOf(this.HIN.isChecked()) : BuildConfig.COMMAND;
                objArr[1] = Integer.valueOf(i4);
                Log.i("MicroMsg.WalletBalancePrivacyUI", "success set balance privacy detail:%s switchState:%s", objArr);
                am fRN = t.fQD().fRN();
                fRN.field_wallet_entrance_balance_switch_state = ((k) qVar).fOP().MMP;
                t.fQD().b(fRN);
                t.fQI().IbM = new al(fRN.field_switchConfig, fRN.field_wallet_entrance_balance_switch_state);
                if (this.HIN != null) {
                    WalletBalancePrivacyCheckBoxPreference walletBalancePrivacyCheckBoxPreference = this.HIN;
                    if (i4 != 1) {
                        z2 = false;
                    }
                    walletBalancePrivacyCheckBoxPreference.xZ(z2);
                }
                AppMethodBeat.o(69597);
                return;
            }
            u.makeText(this, getString(R.string.ir_), 1).show();
            if (this.HIN == null) {
                this.HIN.xZ(!this.HIN.isChecked());
            }
            Object[] objArr2 = new Object[1];
            k kVar = (k) qVar;
            if (kVar.HIn == null) {
                dwo = new dwo();
            } else {
                dwo = kVar.HIn;
            }
            objArr2[0] = Integer.valueOf(dwo.MWM);
            Log.i("MicroMsg.WalletBalancePrivacyUI", "fail set balance privacy %s", objArr2);
        }
        AppMethodBeat.o(69597);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(69598);
        super.onDestroy();
        if (this.HIO != null) {
            WalletBalancePrivacyMMHeaderPreference walletBalancePrivacyMMHeaderPreference = this.HIO;
            for (Map.Entry<String, r.a> entry : walletBalancePrivacyMMHeaderPreference.Cmg.entrySet()) {
                com.tencent.mm.av.q.bcU().b(entry.getKey(), entry.getValue());
            }
            walletBalancePrivacyMMHeaderPreference.Cmg.clear();
        }
        g.aAi();
        g.aAg().hqi.b(2635, this);
        g.aAi();
        g.aAg().hqi.b(2554, this);
        AppMethodBeat.o(69598);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(69595);
        if (Util.isEqual(preference.mKey, "wallet_banlance_privacy_cb")) {
            Log.i("MicroMsg.WalletBalancePrivacyUI", "set balance privacy: %s", Boolean.valueOf(((WalletBalancePrivacyCheckBoxPreference) preference).isChecked()));
            g.aAi();
            g.aAg().hqi.a(new k(((WalletBalancePrivacyCheckBoxPreference) preference).isChecked()), 0);
        }
        AppMethodBeat.o(69595);
        return false;
    }
}
