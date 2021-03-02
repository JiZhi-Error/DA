package com.tencent.mm.plugin.setting.ui.setting;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.cc.b;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bu;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.account.ui.LanguagePreference;
import com.tencent.mm.plugin.setting.SwitchAccountReceiver;
import com.tencent.mm.plugin.setting.c;
import com.tencent.mm.plugin.setting.ui.widget.FontSelectorView;
import com.tencent.mm.sdk.platformtools.LocaleGen;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.SystemProperty;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.platformtools.WeChatSomeFeatureSwitch;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.t;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SettingsLanguageUI extends MMPreference {
    private static final String[] LOCALES = LocaleGen.LOCALES;
    private List<LanguagePreference.a> Dcg;
    private boolean Dch = false;
    private String languageCode;
    private f screen;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(74178);
        super.onCreate(bundle);
        this.screen = getPreferenceScreen();
        initView();
        AppMethodBeat.o(74178);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(74179);
        super.onDestroy();
        AppMethodBeat.o(74179);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return -1;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        String[] stringArray;
        AppMethodBeat.i(74180);
        setMMTitle(R.string.gpm);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsLanguageUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74175);
                SettingsLanguageUI.this.hideVKB();
                SettingsLanguageUI.this.finish();
                AppMethodBeat.o(74175);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.gpl), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsLanguageUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74176);
                SettingsLanguageUI.a(SettingsLanguageUI.this, SettingsLanguageUI.this.languageCode, SettingsLanguageUI.this.Dch);
                SettingsLanguageUI.this.finish();
                AppMethodBeat.o(74176);
                return true;
            }
        }, null, t.b.GREEN);
        this.Dch = getIntent().getBooleanExtra("not_auth_setting", false);
        this.screen.removeAll();
        if (WeChatSomeFeatureSwitch.temporaryBlockMinorLanguage()) {
            stringArray = getResources().getStringArray(R.array.r);
        } else {
            stringArray = getResources().getStringArray(R.array.q);
        }
        this.languageCode = LocaleUtil.loadApplicationLanguageSettings(getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), this);
        this.Dcg = new ArrayList();
        String[] strArr = LOCALES;
        if (WeChatSomeFeatureSwitch.temporaryBlockMinorLanguage()) {
            strArr = LocaleGen.LOCALES_BLOCK_MINOR_LANG;
        }
        for (int i2 = 0; i2 < strArr.length; i2++) {
            String str = strArr[i2];
            this.Dcg.add(new LanguagePreference.a(stringArray[i2], "", str, this.languageCode.equalsIgnoreCase(str)));
        }
        for (LanguagePreference.a aVar : this.Dcg) {
            LanguagePreference languagePreference = new LanguagePreference(this);
            languagePreference.a(aVar);
            this.screen.c(languagePreference);
        }
        this.screen.c(new PreferenceCategory(this));
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(74180);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(74181);
        if (preference instanceof LanguagePreference) {
            LanguagePreference.a aVar = ((LanguagePreference) preference).kln;
            if (aVar == null) {
                AppMethodBeat.o(74181);
                return false;
            }
            this.languageCode = aVar.klq;
            for (LanguagePreference.a aVar2 : this.Dcg) {
                aVar2.isSelected = false;
            }
            aVar.isSelected = true;
            fVar.notifyDataSetChanged();
            AppMethodBeat.o(74181);
            return true;
        }
        AppMethodBeat.o(74181);
        return false;
    }

    static /* synthetic */ void a(SettingsLanguageUI settingsLanguageUI, String str, boolean z) {
        AppMethodBeat.i(74182);
        Locale transLanguageToLocale = LocaleUtil.transLanguageToLocale(str);
        if (LocaleUtil.LANGUAGE_DEFAULT.equalsIgnoreCase(str)) {
            if (Build.VERSION.SDK_INT >= 24) {
                transLanguageToLocale = LocaleUtil.sysDefaultLocale;
                Locale.setDefault(transLanguageToLocale);
            } else {
                transLanguageToLocale = Locale.getDefault();
            }
        }
        LocaleUtil.saveApplicationLanguage(settingsLanguageUI.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), settingsLanguageUI, str);
        WeChatBrands.updateLang(str);
        LocaleUtil.updateApplicationResourceLocale(settingsLanguageUI, transLanguageToLocale);
        SystemProperty.setProperty("system_property_key_locale", str);
        MMApplicationContext.setResources(b.a(settingsLanguageUI.getApplication().getResources(), settingsLanguageUI.getApplication()));
        if (z) {
            c.jRt.o(new Intent().putExtra("Intro_Need_Clear_Top ", true), settingsLanguageUI);
            AppMethodBeat.o(74182);
            return;
        }
        g.azz().a(new bu(new bu.a() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsLanguageUI.AnonymousClass3 */

            @Override // com.tencent.mm.model.bu.a
            public final void a(com.tencent.mm.network.g gVar) {
                AppMethodBeat.i(74177);
                if (gVar == null) {
                    AppMethodBeat.o(74177);
                    return;
                }
                g.aAf();
                gVar.aZh().a(new byte[0], new byte[0], new byte[0], a.getUin());
                AppMethodBeat.o(74177);
            }
        }), 0);
        Intent intent = new Intent();
        intent.setComponent(new ComponentName(e.n.Ozn, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_RELOAD_RESOURCES");
        intent.putExtra("tools_language", str);
        MMApplicationContext.getContext().sendBroadcast(intent);
        if (!com.tencent.mm.br.c.ayt()) {
            intent.setComponent(new ComponentName(e.n.Ozn, "com.tencent.mm.booter.MMReceivers$ToolsMpProcessReceiver"));
            MMApplicationContext.getContext().sendBroadcast(intent);
        }
        Intent intent2 = new Intent(settingsLanguageUI, SwitchAccountReceiver.class);
        intent2.putExtra("switch_process_action_code_key", "action_reload_resources");
        intent2.putExtra("switch_language", str);
        MMApplicationContext.getContext().sendBroadcast(intent2);
        FontSelectorView.eTL();
        h.aqK().gMe.clear();
        Intent intent3 = new Intent();
        intent3.putExtra("Intro_Need_Clear_Top ", true);
        c.jRt.o(intent3, settingsLanguageUI);
        AppMethodBeat.o(74182);
    }
}
