package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.setting.model.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsPluginsNotifyUI extends MMPreference {
    private f screen;
    private int state;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(74328);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(74328);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        AppMethodBeat.i(74329);
        super.onResume();
        eTt();
        AppMethodBeat.o(74329);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return -1;
    }

    private void eTt() {
        AppMethodBeat.i(74331);
        this.screen.removeAll();
        Preference preference = new Preference(this);
        preference.setTitle(R.string.gsi);
        preference.setKey("settings_plugings_disturb_on");
        preference.setLayoutResource(R.layout.b8j);
        if (this.state == 0) {
            preference.setWidgetLayoutResource(R.layout.b_m);
        } else {
            preference.setWidgetLayoutResource(R.layout.b_n);
        }
        this.screen.c(preference);
        Preference preference2 = new Preference(this);
        preference2.setTitle(R.string.gsj);
        preference2.setKey("settings_plugings_disturb_on_night");
        preference2.setLayoutResource(R.layout.b8j);
        if (this.state == 1) {
            preference2.setWidgetLayoutResource(R.layout.b_m);
        } else {
            preference2.setWidgetLayoutResource(R.layout.b_n);
        }
        this.screen.c(preference2);
        Preference preference3 = new Preference(this);
        preference3.setTitle(R.string.gsh);
        preference3.setKey("settings_plugings_disturb_off");
        preference3.setLayoutResource(R.layout.b8j);
        if (this.state == 2) {
            preference3.setWidgetLayoutResource(R.layout.b_m);
        } else {
            preference3.setWidgetLayoutResource(R.layout.b_n);
        }
        this.screen.c(preference3);
        Preference preference4 = new Preference(this);
        preference4.setTitle(R.string.gsk);
        preference4.setLayoutResource(R.layout.b_7);
        this.screen.c(preference4);
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(74331);
    }

    private void Xr(int i2) {
        AppMethodBeat.i(74332);
        this.state = i2;
        if (this.state == 1 || this.state == 0) {
            g.aAh().azQ().set(8200, Boolean.TRUE);
            if (this.state == 1) {
                g.aAh().azQ().set(8201, (Object) 22);
                g.aAh().azQ().set(8208, (Object) 8);
                ((l) g.af(l.class)).aSM().d(new n(true, 22, 8));
            } else {
                g.aAh().azQ().set(8201, (Object) 0);
                g.aAh().azQ().set(8208, (Object) 0);
                ((l) g.af(l.class)).aSM().d(new n(true, 0, 0));
            }
        } else {
            g.aAh().azQ().set(8200, Boolean.FALSE);
            ((l) g.af(l.class)).aSM().d(new n());
        }
        eTt();
        AppMethodBeat.o(74332);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(74330);
        String str = preference.mKey;
        if (str.equals("settings_plugings_disturb_on")) {
            Xr(0);
        }
        if (str.equals("settings_plugings_disturb_on_night")) {
            Xr(1);
        }
        if (str.equals("settings_plugings_disturb_off")) {
            Xr(2);
        }
        AppMethodBeat.o(74330);
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(74333);
        Boolean valueOf = Boolean.valueOf(z.aUz());
        int aUJ = z.aUJ();
        int aUK = z.aUK();
        if (valueOf.booleanValue()) {
            this.state = aUJ == aUK ? 0 : 1;
        } else {
            this.state = 2;
        }
        Log.d("ui.settings.SettingsPlugingsNotify", valueOf + "st " + aUJ + " ed " + aUK + "  state " + this.state);
        this.state = this.state;
        this.screen = getPreferenceScreen();
        setMMTitle(R.string.gsl);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsPluginsNotifyUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74327);
                SettingsPluginsNotifyUI.this.hideVKB();
                SettingsPluginsNotifyUI.this.finish();
                AppMethodBeat.o(74327);
                return true;
            }
        });
        AppMethodBeat.o(74333);
    }
}
