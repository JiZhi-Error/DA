package com.tencent.mm.plugin.wallet.pwd.ui;

import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.wallet_core.c.aj;
import com.tencent.mm.protocal.protobuf.cqd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class WalletDelayTransferSettingUI extends MMPreference implements i {
    private String Crp;
    private Preference HJd;
    private Preference HJe;
    private Preference HJf;
    private Preference HJg;
    private String HJh;
    private int HJi = 0;
    private String mTitle;
    private long qAb;
    private f screen;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        boolean z;
        AppMethodBeat.i(69620);
        fixStatusbar(true);
        super.onCreate(bundle);
        setActionbarColor(getActionbarColor());
        this.screen = getPreferenceScreen();
        this.screen.addPreferencesFromResource(R.xml.dc);
        g.aAi();
        this.qAb = ((Long) g.aAh().azQ().get(147457, (Object) 0L)).longValue();
        initView();
        g.aAi();
        g.aAg().hqi.a(385, this);
        g.aAi();
        this.HJh = (String) g.aAh().azQ().get(ar.a.USERINFO_DELAY_TRANSFER_REMIND_WORDING_STRING, "");
        g.aAi();
        this.mTitle = (String) g.aAh().azQ().get(ar.a.USERINFO_DELAY_TRANSFER_SWITCH_WORDING_STRING, "");
        g.aAi();
        this.Crp = (String) g.aAh().azQ().get(ar.a.USERINFO_DELAY_TRANSFER_DESC_URL_STRING, "");
        g.aAi();
        this.HJi = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_DELAY_TRANSFER_DESC_URL_FLAG_INT, (Object) 0)).intValue();
        if (Util.isNullOrNil(this.HJh) || Util.isNullOrNil(this.mTitle) || Util.isNullOrNil(this.Crp)) {
            z = aj.a(true, null);
        } else {
            this.HJg.setTitle(this.HJh);
            setMMTitle(this.mTitle);
            fOY();
            z = aj.a(false, null);
        }
        com.tencent.mm.wallet_core.ui.f.hhT();
        if (!z) {
            Log.i("MicroMsg.WalletDelayTransferSettingUI", "no need do scene, remove listener");
            g.aAi();
            g.aAg().hqi.b(385, this);
        }
        AppMethodBeat.o(69620);
    }

    private void fOY() {
        AppMethodBeat.i(69621);
        if (this.HJi != 1 || Util.isNullOrNil(this.Crp)) {
            removeAllOptionMenu();
            AppMethodBeat.o(69621);
            return;
        }
        addIconOptionMenu(0, R.drawable.crt, new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletDelayTransferSettingUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(69618);
                com.tencent.mm.wallet_core.ui.f.p(WalletDelayTransferSettingUI.this.getContext(), WalletDelayTransferSettingUI.this.Crp, false);
                AppMethodBeat.o(69618);
                return false;
            }
        });
        AppMethodBeat.o(69621);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(69622);
        this.HJd = this.screen.bmg("wallet_transfer_realtime");
        this.HJe = this.screen.bmg("wallet_transfer_2h");
        this.HJf = this.screen.bmg("wallet_transfer_24h");
        this.HJg = this.screen.bmg("wallet_transfer_title_tips");
        this.HJd.alO(8);
        this.HJe.alO(8);
        this.HJf.alO(8);
        fOZ();
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletDelayTransferSettingUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(69619);
                WalletDelayTransferSettingUI.this.finish();
                AppMethodBeat.o(69619);
                return false;
            }
        });
        AppMethodBeat.o(69622);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        int i2 = 1;
        AppMethodBeat.i(69623);
        super.onDestroy();
        Log.i("MicroMsg.WalletDelayTransferSettingUI", "do oplog, %s", Long.valueOf(this.qAb));
        if (!UM(16)) {
            i2 = UM(32) ? 2 : 0;
        }
        cqd cqd = new cqd();
        cqd.Cyb = i2;
        ((l) g.af(l.class)).aSM().d(new k.a(205, cqd));
        g.aAi();
        g.aAg().hqi.b(385, this);
        AppMethodBeat.o(69623);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return -1;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(69625);
        if (qVar instanceof aj) {
            if (i2 == 0 && i3 == 0) {
                this.HJh = ((aj) qVar).HQw;
                this.mTitle = ((aj) qVar).HQv;
                this.Crp = ((aj) qVar).HQy;
                this.HJi = ((aj) qVar).HQz;
                if (!Util.isNullOrNil(this.HJh)) {
                    this.HJg.setTitle(this.HJh);
                } else {
                    Log.i("MicroMsg.WalletDelayTransferSettingUI", "use hardcode wording");
                    this.HJg.setTitle(R.string.iby);
                }
                if (!Util.isNullOrNil(this.mTitle)) {
                    setMMTitle(this.mTitle);
                } else {
                    Log.i("MicroMsg.WalletDelayTransferSettingUI", "use hardcode title wording");
                    setMMTitle(R.string.ila);
                }
                fOY();
            } else {
                Log.i("MicroMsg.WalletDelayTransferSettingUI", "net error, use hardcode wording");
                this.HJg.setTitle(R.string.iby);
                setMMTitle(R.string.ila);
            }
            this.screen.notifyDataSetChanged();
            AppMethodBeat.o(69625);
            return;
        }
        Log.i("MicroMsg.WalletDelayTransferSettingUI", "other scene");
        AppMethodBeat.o(69625);
    }

    private boolean UM(int i2) {
        return (this.qAb & ((long) i2)) != 0;
    }

    private void fOZ() {
        AppMethodBeat.i(69626);
        if (UM(16)) {
            fPb();
            AppMethodBeat.o(69626);
        } else if (UM(32)) {
            fPc();
            AppMethodBeat.o(69626);
        } else {
            fPa();
            AppMethodBeat.o(69626);
        }
    }

    private void fPa() {
        AppMethodBeat.i(69627);
        this.HJd.setWidgetLayoutResource(R.layout.b_m);
        this.HJe.setWidgetLayoutResource(R.layout.b_n);
        this.HJf.setWidgetLayoutResource(R.layout.b_n);
        AppMethodBeat.o(69627);
    }

    private void fPb() {
        AppMethodBeat.i(69628);
        this.HJd.setWidgetLayoutResource(R.layout.b_n);
        this.HJe.setWidgetLayoutResource(R.layout.b_m);
        this.HJf.setWidgetLayoutResource(R.layout.b_n);
        AppMethodBeat.o(69628);
    }

    private void fPc() {
        AppMethodBeat.i(69629);
        this.HJd.setWidgetLayoutResource(R.layout.b_n);
        this.HJe.setWidgetLayoutResource(R.layout.b_n);
        this.HJf.setWidgetLayoutResource(R.layout.b_m);
        AppMethodBeat.o(69629);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(69624);
        String str = preference.mKey;
        if ("wallet_transfer_realtime".equals(str)) {
            this.qAb &= -17;
            this.qAb &= -33;
        } else if ("wallet_transfer_2h".equals(str)) {
            this.qAb &= -33;
            this.qAb |= 16;
        } else if ("wallet_transfer_24h".equals(str)) {
            this.qAb &= -17;
            this.qAb |= 32;
        }
        fOZ();
        g.aAi();
        g.aAh().azQ().set(147457, Long.valueOf(this.qAb));
        finish();
        AppMethodBeat.o(69624);
        return true;
    }
}
