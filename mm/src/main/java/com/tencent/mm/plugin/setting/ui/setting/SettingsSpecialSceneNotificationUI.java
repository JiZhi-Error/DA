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

public class SettingsSpecialSceneNotificationUI extends MMPreference {
    private f screen;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.cn;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(74427);
        super.onCreate(bundle);
        setMMTitle(R.string.guo);
        AppMethodBeat.o(74427);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(74428);
        this.screen = getPreferenceScreen();
        this.screen.removeAll();
        this.screen.addPreferencesFromResource(getResourceId());
        this.screen.m38do("settings_specail_scene_sound", false);
        ((CheckBoxPreference) this.screen.bmg("settings_specail_scene_sound")).setChecked(g.apY());
        this.screen.m38do("settings_specail_scene_shake", false);
        ((CheckBoxPreference) this.screen.bmg("settings_specail_scene_shake")).setChecked(g.apZ());
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsSpecialSceneNotificationUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74426);
                SettingsSpecialSceneNotificationUI.this.hideVKB();
                SettingsSpecialSceneNotificationUI.this.finish();
                AppMethodBeat.o(74426);
                return true;
            }
        });
        AppMethodBeat.o(74428);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(74429);
        super.onPause();
        AppMethodBeat.o(74429);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        AppMethodBeat.i(74430);
        super.onResume();
        initView();
        AppMethodBeat.o(74430);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(74432);
        super.onDestroy();
        AppMethodBeat.o(74432);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(74431);
        String str = preference.mKey;
        if (str.equals("settings_specail_scene_sound")) {
            g.dF(((CheckBoxPreference) preference).isChecked());
            initView();
            AppMethodBeat.o(74431);
            return true;
        } else if (str.equals("settings_specail_scene_shake")) {
            g.dG(((CheckBoxPreference) preference).isChecked());
            initView();
            Util.shake(this, ((CheckBoxPreference) preference).isChecked());
            AppMethodBeat.o(74431);
            return true;
        } else {
            AppMethodBeat.o(74431);
            return false;
        }
    }
}
