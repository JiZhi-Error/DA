package com.tencent.mm.plugin.shake.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ay.e;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.n.h;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.shake.a;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class ShakePersonalInfoUI extends MMPreference {
    private f screen;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.cx;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(28438);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(28438);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(28440);
        setMMTitle(R.string.gyq);
        this.screen = getPreferenceScreen();
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.screen.bmg("shake_item_sound");
        bg.aVF();
        if (c.azQ().get(4112, (Object) null) == null) {
            bg.aVF();
            c.azQ().set(4112, Boolean.TRUE);
        }
        bg.aVF();
        checkBoxPreference.setChecked(Util.nullAsTrue((Boolean) c.azQ().get(4112, (Object) null)));
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.shake.ui.ShakePersonalInfoUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(28437);
                ShakePersonalInfoUI.this.finish();
                AppMethodBeat.o(28437);
                return true;
            }
        });
        if (!e.bek()) {
            this.screen.bmi("shake_item_shake_music_list");
        }
        AppMethodBeat.o(28440);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        boolean z = false;
        AppMethodBeat.i(28441);
        super.onResume();
        if (bg.aAc()) {
            a.jRu.WZ();
        }
        if (this.screen.bmg("shake_item_shake_tv_list") == null) {
            Log.e(MMPreference.TAG, "shake_tv_list preference is null");
            AppMethodBeat.o(28441);
            return;
        }
        if (Util.getInt(h.aqK().aj("ShowConfig", "showShakeTV"), 0) == 1) {
            z = true;
        }
        Log.d("MicroMsg.ConfigListDecoder", "isShowShakeTV : ".concat(String.valueOf(z)));
        if (!z && !ac.jOt) {
            this.screen.m38do("shake_item_shake_tv_list", true);
        }
        AppMethodBeat.o(28441);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(28442);
        if (i2 == 4) {
            finish();
            AppMethodBeat.o(28442);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(28442);
        return onKeyDown;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(28444);
        switch (i2) {
            case 1:
                if (intent == null) {
                    AppMethodBeat.o(28444);
                    return;
                }
                Intent intent2 = new Intent();
                intent2.putExtra("CropImageMode", 4);
                intent2.putExtra("CropImage_Filter", true);
                intent2.putExtra("CropImage_DirectlyIntoFilter", true);
                StringBuilder sb = new StringBuilder();
                bg.aVF();
                intent2.putExtra("CropImage_OutputPath", sb.append(c.aSY()).append("custom_shake_img_filename.jpg").toString());
                a.jRt.a(intent2, 2, this, intent);
                AppMethodBeat.o(28444);
                return;
            case 2:
                if (intent == null) {
                    AppMethodBeat.o(28444);
                    return;
                }
                String stringExtra = intent.getStringExtra("CropImage_OutputPath");
                bg.aVF();
                c.azQ().set(4110, Boolean.FALSE);
                bg.aVF();
                c.azQ().set(4111, stringExtra);
                AppMethodBeat.o(28444);
                return;
            default:
                AppMethodBeat.o(28444);
                return;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(28439);
        a.jRu.WZ();
        super.onDestroy();
        AppMethodBeat.o(28439);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(28443);
        String str = preference.mKey;
        if ("shake_item_default_bgimg".equals(str)) {
            bg.aVF();
            c.azQ().set(4110, Boolean.TRUE);
            com.tencent.mm.ui.base.h.cD(this, getResources().getString(R.string.gzq));
        }
        if ("shake_item_change_bgimg".equals(str)) {
            s.c(this, 1, null);
        }
        if ("shake_item_sound".equals(str)) {
            bg.aVF();
            boolean nullAsTrue = Util.nullAsTrue((Boolean) c.azQ().get(4112, (Object) null));
            bg.aVF();
            c.azQ().set(4112, Boolean.valueOf(!nullAsTrue));
        }
        if ("say_hi_list_shake_title".equals(str)) {
            Intent intent = new Intent(this, ShakeSayHiListUI.class);
            intent.putExtra("IntentSayHiType", 1);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/shake/ui/ShakePersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakePersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        if ("shake_item_histoty_list".equals(str)) {
            Intent intent2 = new Intent(this, ShakeItemListUI.class);
            intent2.putExtra("_key_show_type_", 100);
            intent2.putExtra("_key_title_", getString(R.string.gyp));
            com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl2.axQ(), "com/tencent/mm/plugin/shake/ui/ShakePersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl2.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakePersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        if ("shake_msg_list".equals(str)) {
            Intent intent3 = new Intent(this, ShakeMsgListUI.class);
            intent3.putExtra("shake_msg_from", 2);
            intent3.putExtra("shake_msg_list_title", getString(R.string.h0b));
            com.tencent.mm.hellhoundlib.b.a bl3 = new com.tencent.mm.hellhoundlib.b.a().bl(intent3);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl3.axQ(), "com/tencent/mm/plugin/shake/ui/ShakePersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl3.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/shake/ui/ShakePersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(28443);
        return false;
    }
}
