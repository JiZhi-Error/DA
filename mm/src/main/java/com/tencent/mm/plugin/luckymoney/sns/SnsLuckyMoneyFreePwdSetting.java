package com.tencent.mm.plugin.luckymoney.sns;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.vt;
import com.tencent.mm.plugin.luckymoney.sns.b.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.wallet_core.d;
import com.tencent.mm.wallet_core.ui.WalletPreferenceUI;

public class SnsLuckyMoneyFreePwdSetting extends WalletPreferenceUI {
    protected f nRm;
    protected CheckBoxPreference yYG;

    @Override // com.tencent.mm.wallet_core.ui.WalletPreferenceUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    private static void PN(int i2) {
        AppMethodBeat.i(65353);
        vt vtVar = new vt();
        vtVar.ebU.key = i2;
        vtVar.ebU.value = 1;
        vtVar.ebU.ebV = true;
        EventCenter.instance.publish(vtVar);
        AppMethodBeat.o(65353);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletPreferenceUI, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(65354);
        super.onCreate(bundle);
        initView();
        PN(116);
        AppMethodBeat.o(65354);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(65355);
        this.nRm = getPreferenceScreen();
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.luckymoney.sns.SnsLuckyMoneyFreePwdSetting.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(65352);
                SnsLuckyMoneyFreePwdSetting.this.finish();
                AppMethodBeat.o(65352);
                return false;
            }
        });
        setMMTitle(R.string.epo);
        this.yYG = (CheckBoxPreference) this.nRm.bmg("open_sns_pay_pref");
        efA();
        AppMethodBeat.o(65355);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        AppMethodBeat.i(65356);
        efA();
        super.onResume();
        AppMethodBeat.o(65356);
    }

    private void efA() {
        boolean z = true;
        AppMethodBeat.i(65357);
        if (a.efC() != 1) {
            z = false;
        }
        this.yYG.setChecked(z);
        getDefaultSharedPreferences().edit().putBoolean("open_sns_pay_pref", z).commit();
        if (!TextUtils.isEmpty(a.efD())) {
            Log.i(MMPreference.TAG, "SetSnsPayTitle:" + a.efD());
            this.yYG.setTitle(a.efD());
        } else {
            Log.i(MMPreference.TAG, "SetSnsPayTitle is empty");
            this.yYG.setTitle(R.string.epl);
        }
        if (!TextUtils.isEmpty(a.efE())) {
            Log.i(MMPreference.TAG, "SetSnsPayWording:" + a.efE());
            this.yYG.setSummary(a.efE());
        } else {
            Log.i(MMPreference.TAG, "getSetSnsPayWording is empty");
            this.yYG.setSummary(R.string.epk);
        }
        this.nRm.notifyDataSetChanged();
        AppMethodBeat.o(65357);
    }

    private void qL(boolean z) {
        AppMethodBeat.i(65358);
        getDefaultSharedPreferences().edit().putBoolean("open_sns_pay_pref", z).commit();
        this.yYG.setChecked(z);
        this.nRm.notifyDataSetChanged();
        AppMethodBeat.o(65358);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletPreferenceUI, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(65359);
        super.onDestroy();
        AppMethodBeat.o(65359);
    }

    @Override // com.tencent.mm.wallet_core.ui.WalletPreferenceUI
    public final boolean e(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(65360);
        if (qVar instanceof com.tencent.mm.plugin.luckymoney.sns.a.a) {
            Log.i(MMPreference.TAG, "free pwd setting onWalletSceneEnd, errType:" + i2 + " errCode:" + i3 + " errMsg:" + str);
            if (i2 != 0 || i3 != 0) {
                PN(119);
                Log.i(MMPreference.TAG, "onWalletSceneEnd() NetSceneSnsPayManage is failed, do nothing");
                efA();
            } else if (((com.tencent.mm.plugin.luckymoney.sns.a.a) qVar).yYV == 1) {
                Log.i(MMPreference.TAG, "onWalletSceneEnd() NetSceneSnsPayManage is success, setIsOpenSnsPay with 1");
                PN(119);
                qL(true);
            } else {
                qL(false);
                PN(118);
                Log.i(MMPreference.TAG, "onWalletSceneEnd() NetSceneSnsPayManage is success, setIsOpenSnsPay with 0");
            }
        }
        AppMethodBeat.o(65360);
        return false;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.cz;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(65361);
        if ("open_sns_pay_pref".equals(preference.mKey)) {
            if (this.yYG.isChecked() || a.efC() != 1) {
                PN(120);
                com.tencent.mm.wallet_core.a.a(this, a.class, (Bundle) null, (d.a) null);
            } else {
                hhW().a(new com.tencent.mm.plugin.luckymoney.sns.a.a(0, "", ""), true, 1);
                PN(117);
            }
        }
        AppMethodBeat.o(65361);
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v4.app.FragmentActivity
    public void onNewIntent(Intent intent) {
        AppMethodBeat.i(65362);
        super.onNewIntent(intent);
        AppMethodBeat.o(65362);
    }
}
