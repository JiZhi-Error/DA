package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.n.g;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsVoipSoundVibrateUI extends MMPreference {
    private f screen;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.co;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(74561);
        super.onCreate(bundle);
        setMMTitle(R.string.gws);
        AppMethodBeat.o(74561);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(74562);
        this.screen = getPreferenceScreen();
        this.screen.removeAll();
        this.screen.addPreferencesFromResource(getResourceId());
        this.screen.m38do("settings_voip_sound", false);
        ((CheckBoxPreference) this.screen.bmg("settings_voip_sound")).setChecked(g.aqa());
        this.screen.m38do("settings_voip_shake", false);
        ((CheckBoxPreference) this.screen.bmg("settings_voip_shake")).setChecked(g.aqb());
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsVoipSoundVibrateUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74560);
                SettingsVoipSoundVibrateUI.this.hideVKB();
                SettingsVoipSoundVibrateUI.this.finish();
                AppMethodBeat.o(74560);
                return true;
            }
        });
        AppMethodBeat.o(74562);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(74563);
        super.onPause();
        AppMethodBeat.o(74563);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        AppMethodBeat.i(74564);
        super.onResume();
        initView();
        AppMethodBeat.o(74564);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(74566);
        super.onDestroy();
        AppMethodBeat.o(74566);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(74565);
        String str = preference.mKey;
        if (str.equals("settings_voip_sound")) {
            g.dH(((CheckBoxPreference) preference).isChecked());
            initView();
            AppMethodBeat.o(74565);
            return true;
        } else if (str.equals("settings_voip_shake")) {
            g.dI(((CheckBoxPreference) preference).isChecked());
            initView();
            Util.shake(this, ((CheckBoxPreference) preference).isChecked());
            AppMethodBeat.o(74565);
            return true;
        } else {
            AppMethodBeat.o(74565);
            return false;
        }
    }
}
