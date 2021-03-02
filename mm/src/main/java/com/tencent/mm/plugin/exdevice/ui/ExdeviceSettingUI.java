package com.tencent.mm.plugin.exdevice.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.model.bg;
import com.tencent.mm.plugin.exdevice.g.a.o;
import com.tencent.mm.plugin.sport.a.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.q;

public class ExdeviceSettingUI extends MMPreference implements i {
    int cSx = -1;
    private final String rKQ = "notify_rank";
    private final String rKR = "notify_like";
    private final String rKS = "join_rank";
    boolean rKT;
    private ProgressDialog rKU;
    private CheckBoxPreference rKV;
    private CheckBoxPreference rKW;
    private CheckBoxPreference rKX;
    private boolean rKY;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(24291);
        super.onCreate(bundle);
        c.pl(38);
        bg.azz().a(1044, this);
        this.rKV = (CheckBoxPreference) getPreferenceScreen().bmg("notify_rank");
        this.rKW = (CheckBoxPreference) getPreferenceScreen().bmg("notify_like");
        this.rKX = (CheckBoxPreference) getPreferenceScreen().bmg("join_rank");
        bg.aVF();
        Integer num = (Integer) com.tencent.mm.model.c.azQ().get(397310, (Object) 0);
        Log.d("MicroMsg.ExdeviceSettingUI", "hy: setting flag: %d", num);
        if (num == null || num.intValue() == 0) {
            this.rKT = false;
            this.rKV.setChecked(true);
            this.rKW.setChecked(true);
            this.rKX.setChecked(true);
            getPreferenceScreen().notifyDataSetChanged();
            this.rKU = q.show(this, "", "", true, false);
        } else {
            this.rKT = true;
            this.cSx = num.intValue();
            cMd();
        }
        bg.azz().a(new o(2, 0), 0);
        setMMTitle(R.string.fyu);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceSettingUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(24288);
                ExdeviceSettingUI.this.finish();
                AppMethodBeat.o(24288);
                return false;
            }
        });
        AppMethodBeat.o(24291);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(24292);
        super.onDestroy();
        bg.azz().b(1044, this);
        if (this.rKU != null && this.rKU.isShowing()) {
            this.rKU.dismiss();
        }
        if (this.rKT) {
            if (this.rKV.isChecked()) {
                this.cSx |= 1;
            } else {
                this.cSx &= -2;
            }
            if (this.rKW.isChecked()) {
                this.cSx |= 2;
            } else {
                this.cSx &= -3;
            }
            if (this.rKX.isChecked()) {
                this.cSx |= 8;
            } else {
                this.cSx &= -9;
            }
            bg.aVF();
            com.tencent.mm.model.c.azQ().set(397310, Integer.valueOf(this.cSx));
            Log.d("MicroMsg.ExdeviceSettingUI", "hy: doscene setting flag to %d", Integer.valueOf(this.cSx));
            bg.azz().a(new o(1, this.cSx), 0);
        }
        AppMethodBeat.o(24292);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.au;
    }

    private void cMd() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(24293);
        this.rKV.setChecked((this.cSx & 1) == 1);
        CheckBoxPreference checkBoxPreference = this.rKW;
        if ((this.cSx & 2) == 2) {
            z = true;
        } else {
            z = false;
        }
        checkBoxPreference.setChecked(z);
        CheckBoxPreference checkBoxPreference2 = this.rKX;
        if ((this.cSx & 8) != 8) {
            z2 = false;
        }
        checkBoxPreference2.setChecked(z2);
        getPreferenceScreen().notifyDataSetChanged();
        AppMethodBeat.o(24293);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        AppMethodBeat.i(24294);
        if (i2 == 0 && i3 == 0) {
            Log.d("MicroMsg.ExdeviceSettingUI", "hy: scene end ok");
            o oVar = (o) qVar;
            if (oVar.opType != 2) {
                Log.i("MicroMsg.ExdeviceSettingUI", "It isn't a GET_FLAG opType(%d).", Integer.valueOf(oVar.opType));
                AppMethodBeat.o(24294);
                return;
            }
            if (this.rKU != null && this.rKU.isShowing()) {
                runOnUiThread(new Runnable() {
                    /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceSettingUI.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(24289);
                        ExdeviceSettingUI.this.rKU.dismiss();
                        AppMethodBeat.o(24289);
                    }
                });
            }
            this.rKT = true;
            if (this.cSx == oVar.rCV) {
                Log.i("MicroMsg.ExdeviceSettingUI", "flag has not changed.(%s)", Integer.valueOf(this.cSx));
                AppMethodBeat.o(24294);
                return;
            }
            this.cSx = oVar.rCV;
            Log.d("MicroMsg.ExdeviceSettingUI", "hy: onSceneEnd setting flag to %d", Integer.valueOf(this.cSx));
            bg.aVF();
            com.tencent.mm.model.c.azQ().set(397310, Integer.valueOf(this.cSx));
            if (!this.rKY) {
                cMd();
            }
            AppMethodBeat.o(24294);
            return;
        }
        if (this.rKU != null && this.rKU.isShowing()) {
            runOnUiThread(new Runnable() {
                /* class com.tencent.mm.plugin.exdevice.ui.ExdeviceSettingUI.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(24290);
                    ExdeviceSettingUI.this.rKU.dismiss();
                    AppMethodBeat.o(24290);
                }
            });
        }
        Toast.makeText(this, "scene error", 0).show();
        finish();
        AppMethodBeat.o(24294);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(24295);
        Log.d("MicroMsg.ExdeviceSettingUI", "onPreferenceTreeClick, key is %s.", preference.mKey);
        if (preference.mKey.equals("black_contact_list")) {
            com.tencent.mm.br.c.V(this, "sport", ".ui.SportBlackListUI");
        } else {
            this.rKY = true;
        }
        AppMethodBeat.o(24295);
        return false;
    }
}
