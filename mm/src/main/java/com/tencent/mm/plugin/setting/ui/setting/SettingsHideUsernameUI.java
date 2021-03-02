package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.bfx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsHideUsernameUI extends MMPreference {
    private int Dbj;
    private CheckBoxPreference Dce;
    private boolean oBV;
    private long qAb;
    private f screen;
    private String username;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(74169);
        super.onCreate(bundle);
        this.username = z.aTZ();
        if (Util.isNullOrNil(this.username)) {
            this.username = z.aTY();
        }
        this.screen = getPreferenceScreen();
        this.qAb = z.aUd();
        this.Dbj = z.aUe();
        initView();
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsHideUsernameUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74168);
                SettingsHideUsernameUI.this.finish();
                AppMethodBeat.o(74168);
                return true;
            }
        });
        AppMethodBeat.o(74169);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        boolean z = true;
        AppMethodBeat.i(74170);
        setMMTitle(R.string.gw_);
        this.screen.bmg("settings_my_username").setSummary(this.username);
        boolean z2 = (this.qAb & 16384) != 0;
        this.oBV = z2;
        Log.d("MicroMsg.SettingsHideUsernameUI", "is hide: %s", Boolean.valueOf(z2));
        this.Dce = (CheckBoxPreference) this.screen.bmg("settings_show_username");
        this.Dce.OZw = false;
        CheckBoxPreference checkBoxPreference = this.Dce;
        if (z2) {
            z = false;
        }
        checkBoxPreference.setChecked(z);
        if (Util.isNullOrNil(z.aUa())) {
            this.Dce.setEnabled(false);
        }
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(74170);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.cc;
    }

    private void eTf() {
        AppMethodBeat.i(74172);
        if (this.oBV) {
            this.Dce.setSummary(getString(R.string.gtx));
            AppMethodBeat.o(74172);
        } else if (this.Dce.isEnabled()) {
            this.Dce.setSummary(getString(R.string.gtv));
            AppMethodBeat.o(74172);
        } else {
            this.Dce.setSummary(getString(R.string.gtw));
            AppMethodBeat.o(74172);
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        AppMethodBeat.i(74173);
        super.onResume();
        eTf();
        AppMethodBeat.o(74173);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        boolean z = false;
        int i2 = 1;
        AppMethodBeat.i(74174);
        super.onPause();
        Log.d("MicroMsg.SettingsHideUsernameUI", "hide: %s", Boolean.valueOf(this.oBV));
        if ((this.qAb & 16384) != 0) {
            z = true;
        }
        if (z != this.oBV) {
            if (this.oBV) {
                this.qAb |= 16384;
                this.Dbj |= 512;
            } else {
                this.qAb &= -16385;
                this.Dbj &= -513;
            }
            g.aAi();
            g.aAh().azQ().set(147457, Long.valueOf(this.qAb));
            g.aAi();
            g.aAh().azQ().set(40, Integer.valueOf(this.Dbj));
            bfx bfx = new bfx();
            bfx.LPB = 46;
            if (this.oBV) {
                i2 = 2;
            }
            bfx.BsD = i2;
            ((l) g.af(l.class)).aSM().d(new k.a(23, bfx));
        }
        AppMethodBeat.o(74174);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        boolean z = false;
        AppMethodBeat.i(74171);
        if (preference.mKey.equals("settings_show_username")) {
            if (!((CheckBoxPreference) preference).isChecked()) {
                z = true;
            }
            this.oBV = z;
            eTf();
            AppMethodBeat.o(74171);
            return true;
        }
        AppMethodBeat.o(74171);
        return false;
    }
}
