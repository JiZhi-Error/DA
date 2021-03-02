package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TimePicker;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.be;
import com.tencent.mm.n.g;
import com.tencent.mm.plugin.notification.PluginNotification;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import java.sql.Time;
import java.text.DateFormat;

public class SettingsActiveTimeUI extends MMPreference {
    private int Dbc;
    private int Dbd;
    private int Dbe;
    private int Dbf;
    private boolean Dbg = false;
    private final TimePickerDialog.OnTimeSetListener Dbh = new TimePickerDialog.OnTimeSetListener() {
        /* class com.tencent.mm.plugin.setting.ui.setting.SettingsActiveTimeUI.AnonymousClass2 */

        public final void onTimeSet(TimePicker timePicker, int i2, int i3) {
            AppMethodBeat.i(74087);
            if (SettingsActiveTimeUI.this.Dbg) {
                SettingsActiveTimeUI.this.Dbc = i2;
                SettingsActiveTimeUI.this.Dbd = i3;
                SettingsActiveTimeUI.b(SettingsActiveTimeUI.this);
            } else {
                SettingsActiveTimeUI.this.Dbe = i2;
                SettingsActiveTimeUI.this.Dbf = i3;
                SettingsActiveTimeUI.c(SettingsActiveTimeUI.this);
            }
            SettingsActiveTimeUI.this.initView();
            AppMethodBeat.o(74087);
        }
    };
    private boolean isActive = false;
    private Preference oQX;
    private Preference oQY;
    private f screen;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SettingsActiveTimeUI() {
        AppMethodBeat.i(74088);
        AppMethodBeat.o(74088);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(74089);
        super.onCreate(bundle);
        setMMTitle(R.string.gn5);
        this.screen = getPreferenceScreen();
        initView();
        AppMethodBeat.o(74089);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(74090);
        this.screen.removeAll();
        this.screen.addPreferencesFromResource(R.xml.cg);
        this.oQY = this.screen.bmg("settings_active_begin_time");
        this.Dbc = g.aqg();
        this.Dbd = g.aqi();
        this.oQY.setSummary(i(this, this.Dbc, this.Dbd));
        this.oQX = this.screen.bmg("settings_active_end_time");
        this.Dbe = g.aqf();
        this.Dbf = g.aqh();
        this.oQX.setSummary(i(this, this.Dbe, this.Dbf));
        this.isActive = !g.aqe();
        ((CheckBoxPreference) this.screen.bmg("settings_active_silence_time")).setChecked(this.isActive);
        if (this.isActive) {
            this.oQY.setEnabled(true);
            this.oQX.setEnabled(true);
        } else {
            this.oQY.setEnabled(false);
            this.oQX.setEnabled(false);
        }
        if (!this.isActive) {
            this.screen.e(this.oQY);
            this.screen.e(this.oQX);
        }
        this.screen.m38do("settings_active_time_full", true);
        this.screen.notifyDataSetChanged();
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsActiveTimeUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74086);
                SettingsActiveTimeUI.this.hideVKB();
                SettingsActiveTimeUI.this.finish();
                AppMethodBeat.o(74086);
                return true;
            }
        });
        AppMethodBeat.o(74090);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.cg;
    }

    /* access modifiers changed from: protected */
    public Dialog onCreateDialog(int i2) {
        AppMethodBeat.i(74092);
        switch (i2) {
            case 1:
                if (this.Dbg) {
                    TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(), this.Dbh, this.Dbc, this.Dbd, false);
                    AppMethodBeat.o(74092);
                    return timePickerDialog;
                }
                TimePickerDialog timePickerDialog2 = new TimePickerDialog(getContext(), this.Dbh, this.Dbe, this.Dbf, false);
                AppMethodBeat.o(74092);
                return timePickerDialog2;
            default:
                AppMethodBeat.o(74092);
                return null;
        }
    }

    /* access modifiers changed from: protected */
    public void onPrepareDialog(int i2, Dialog dialog) {
        AppMethodBeat.i(74093);
        switch (i2) {
            case 1:
                if (this.Dbg) {
                    ((TimePickerDialog) dialog).updateTime(this.Dbc, this.Dbd);
                    AppMethodBeat.o(74093);
                    return;
                }
                ((TimePickerDialog) dialog).updateTime(this.Dbe, this.Dbf);
                AppMethodBeat.o(74093);
                return;
            default:
                AppMethodBeat.o(74093);
                return;
        }
    }

    private static String i(Context context, int i2, int i3) {
        int i4;
        AppMethodBeat.i(74094);
        String loadApplicationLanguageSettings = LocaleUtil.loadApplicationLanguageSettings(context.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), context);
        String applicationLanguage = LocaleUtil.getApplicationLanguage();
        if (loadApplicationLanguageSettings.equalsIgnoreCase(LocaleUtil.CHINA) || (loadApplicationLanguageSettings.equalsIgnoreCase(LocaleUtil.LANGUAGE_DEFAULT) && LocaleUtil.CHINA.equalsIgnoreCase(applicationLanguage))) {
            if (i2 > 12) {
                i4 = i2 - 12;
            } else {
                i4 = i2;
            }
            String str = ((Object) com.tencent.mm.pluginsdk.i.f.v(context, (((long) i2) * Util.MILLSECONDS_OF_HOUR) + (((long) i3) * Util.MILLSECONDS_OF_MINUTE))) + String.format("%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3));
            AppMethodBeat.o(74094);
            return str;
        }
        String format = DateFormat.getTimeInstance(3, LocaleUtil.transLanguageToLocale(loadApplicationLanguageSettings)).format(new Time(i2, i3, 0));
        AppMethodBeat.o(74094);
        return format;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(74095);
        super.onDestroy();
        be.rY(2);
        AppMethodBeat.o(74095);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        int i2;
        AppMethodBeat.i(74091);
        if (preference.mKey.equals("settings_active_begin_time")) {
            this.Dbg = true;
            showDialog(1);
            AppMethodBeat.o(74091);
            return true;
        } else if (preference.mKey.equals("settings_active_end_time")) {
            this.Dbg = false;
            showDialog(1);
            AppMethodBeat.o(74091);
            return true;
        } else if (preference.mKey.equals("settings_active_silence_time")) {
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.screen.bmg("settings_active_silence_time");
            g.dJ(!checkBoxPreference.isChecked());
            PluginNotification.createActiveTimeNotification();
            h hVar = h.INSTANCE;
            Object[] objArr = new Object[2];
            objArr[0] = 0;
            if (checkBoxPreference.isChecked()) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            objArr[1] = Integer.valueOf(i2);
            hVar.a(11351, objArr);
            initView();
            AppMethodBeat.o(74091);
            return true;
        } else {
            AppMethodBeat.o(74091);
            return false;
        }
    }

    static /* synthetic */ void b(SettingsActiveTimeUI settingsActiveTimeUI) {
        AppMethodBeat.i(74096);
        g.cv(settingsActiveTimeUI.Dbc, settingsActiveTimeUI.Dbd);
        AppMethodBeat.o(74096);
    }

    static /* synthetic */ void c(SettingsActiveTimeUI settingsActiveTimeUI) {
        AppMethodBeat.i(74097);
        g.cu(settingsActiveTimeUI.Dbe, settingsActiveTimeUI.Dbf);
        AppMethodBeat.o(74097);
    }
}
