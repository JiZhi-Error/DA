package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.b.a.ie;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.ball.c.b;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.bfx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsAboutCamera extends MMPreference {
    private final String CZZ = "settings_auto_mul_terminal_sync_tip";
    private final String Daa = "settings_auto_mul_terminal_sync";
    private final String Dab = "settings_take_photo_auto_save_tip";
    private final String Dac = "settings_take_photo_auto_save_photo";
    private final String Dad = "settings_take_photo_auto_save_video";
    private final String Dae = "settings_sns_auto_play_switch";
    private final String Daf = "settings_sns_auto_play_tip";
    private final String Dag = "settings_voip_audio_switch_mobile_net";
    private final String Dah = "settings_voip_audio_switch_mobile_net_tip";
    private int Dai = 0;
    private long qAb;
    private f screen;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(74012);
        super.onCreate(bundle);
        this.qAb = z.aUd();
        this.Dai = getIntent().getIntExtra("activity_caller_params", 0);
        initView();
        AppMethodBeat.o(74012);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        AppMethodBeat.i(256496);
        super.onResume();
        if (this.Dai == 1) {
            ((b) g.af(b.class)).jS(true);
            com.tencent.mm.plugin.ball.f.f.e(true, false, true);
        }
        AppMethodBeat.o(256496);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.ch;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        boolean z;
        AppMethodBeat.i(74014);
        this.screen = getPreferenceScreen();
        if (!SettingsAboutSystemUI.eSY()) {
            setMMTitle(R.string.gse);
        } else {
            setMMTitle(R.string.gsf);
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsAboutCamera.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74011);
                SettingsAboutCamera.this.hideVKB();
                SettingsAboutCamera.this.finish();
                AppMethodBeat.o(74011);
                return true;
            }
        });
        boolean booleanValue = ((Boolean) g.aAh().azQ().get(ar.a.USERINFO_WEIXIN_MUL_TERMINAL_AUTOSYNC_BOOLEAN, Boolean.TRUE)).booleanValue();
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.screen.bmg("settings_auto_mul_terminal_sync");
        checkBoxPreference.OZw = false;
        checkBoxPreference.setChecked(booleanValue);
        boolean booleanValue2 = ((Boolean) g.aAh().azQ().get(ar.a.USERINFO_WEIXIN_CAMERASAVEIMAGE_STATE_BOOLEAN, Boolean.TRUE)).booleanValue();
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) this.screen.bmg("settings_take_photo_auto_save_photo");
        checkBoxPreference2.OZw = false;
        checkBoxPreference2.setChecked(booleanValue2);
        boolean booleanValue3 = ((Boolean) g.aAh().azQ().get(ar.a.USERINFO_WEIXIN_CAMERASAVEVIDEO_STATE_BOOLEAN, Boolean.TRUE)).booleanValue();
        CheckBoxPreference checkBoxPreference3 = (CheckBoxPreference) this.screen.bmg("settings_take_photo_auto_save_video");
        checkBoxPreference3.setChecked(booleanValue3);
        checkBoxPreference3.OZw = false;
        boolean booleanValue4 = ((Boolean) g.aAh().azQ().get(ar.a.USERINFO_WEIXIN_SNSAUTOPLAY_AUTOSYNC_BOOLEAN, Boolean.TRUE)).booleanValue();
        CheckBoxPreference checkBoxPreference4 = (CheckBoxPreference) this.screen.bmg("settings_sns_auto_play_switch");
        checkBoxPreference4.setChecked(booleanValue4);
        checkBoxPreference4.OZw = false;
        if (SettingsAboutSystemUI.eSY()) {
            if ((this.qAb & 137438953472L) != 0) {
                z = true;
            } else {
                z = false;
            }
            boolean z2 = !z;
            CheckBoxPreference checkBoxPreference5 = (CheckBoxPreference) this.screen.bmg("settings_voip_audio_switch_mobile_net");
            checkBoxPreference5.setChecked(z2);
            checkBoxPreference5.OZw = false;
        }
        this.screen.notifyDataSetChanged();
        if (this.Dai == 1) {
            this.screen.m38do("settings_sns_auto_play_switch", true);
            this.screen.m38do("settings_sns_auto_play_tip", true);
            this.screen.m38do("settings_take_photo_auto_save_photo", true);
            this.screen.m38do("settings_take_photo_auto_save_video", true);
            this.screen.m38do("settings_auto_mul_terminal_sync", true);
            this.screen.m38do("settings_auto_mul_terminal_sync_tip", true);
            this.screen.m38do("settings_take_photo_auto_save_tip", true);
            AppMethodBeat.o(74014);
            return;
        }
        boolean z3 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_sns_video_autoplay, 0) == 1;
        String lowerCase = Build.MODEL.toLowerCase();
        String a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_sns_video_autoplay_disable_device, "");
        if (!Util.isNullOrNil(a2) && a2.contains(lowerCase)) {
            Log.i("ui.settings.SettingsAboutCamera", "model %s is hit, expt:%s", lowerCase, a2);
            z3 = false;
        }
        if (!z3) {
            this.screen.m38do("settings_sns_auto_play_switch", true);
            this.screen.m38do("settings_sns_auto_play_tip", true);
        }
        if (!SettingsAboutSystemUI.eSY()) {
            this.screen.m38do("settings_voip_audio_switch_mobile_net", true);
            this.screen.m38do("settings_voip_audio_switch_mobile_net_tip", true);
        }
        AppMethodBeat.o(74014);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        int i2;
        int i3;
        int i4;
        int i5 = 1;
        AppMethodBeat.i(74015);
        super.onDestroy();
        ie ieVar = new ie();
        ieVar.eNt = 2;
        if (((Boolean) g.aAh().azQ().get(ar.a.USERINFO_WEIXIN_MUL_TERMINAL_AUTOSYNC_BOOLEAN, Boolean.TRUE)).booleanValue()) {
            i2 = 1;
        } else {
            i2 = 2;
        }
        ieVar.eNu = i2;
        if (((Boolean) g.aAh().azQ().get(ar.a.USERINFO_WEIXIN_CAMERASAVEIMAGE_STATE_BOOLEAN, Boolean.TRUE)).booleanValue()) {
            i3 = 1;
        } else {
            i3 = 2;
        }
        ieVar.eNv = i3;
        if (((Boolean) g.aAh().azQ().get(ar.a.USERINFO_WEIXIN_CAMERASAVEVIDEO_STATE_BOOLEAN, Boolean.TRUE)).booleanValue()) {
            i4 = 1;
        } else {
            i4 = 2;
        }
        ieVar.eNw = i4;
        if (!((Boolean) g.aAh().azQ().get(ar.a.USERINFO_WEIXIN_SNSAUTOPLAY_AUTOSYNC_BOOLEAN, Boolean.TRUE)).booleanValue()) {
            i5 = 2;
        }
        ieVar.eNx = i5;
        ieVar.bfK();
        AppMethodBeat.o(74015);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        int i2;
        boolean z;
        boolean z2;
        boolean z3;
        int i3 = 1;
        AppMethodBeat.i(74013);
        String str = preference.mKey;
        if (str.equals("settings_auto_mul_terminal_sync")) {
            g.aAh().azQ().set(ar.a.USERINFO_WEIXIN_MUL_TERMINAL_AUTOSYNC_BOOLEAN, Boolean.valueOf(!((Boolean) g.aAh().azQ().get(ar.a.USERINFO_WEIXIN_MUL_TERMINAL_AUTOSYNC_BOOLEAN, Boolean.TRUE)).booleanValue()));
        }
        if (str.equals("settings_take_photo_auto_save_photo")) {
            boolean booleanValue = ((Boolean) g.aAh().azQ().get(ar.a.USERINFO_WEIXIN_CAMERASAVEIMAGE_STATE_BOOLEAN, Boolean.TRUE)).booleanValue();
            ao azQ = g.aAh().azQ();
            ar.a aVar = ar.a.USERINFO_WEIXIN_CAMERASAVEIMAGE_STATE_BOOLEAN;
            if (!booleanValue) {
                z3 = true;
            } else {
                z3 = false;
            }
            azQ.set(aVar, Boolean.valueOf(z3));
        }
        if (str.equals("settings_take_photo_auto_save_video")) {
            boolean booleanValue2 = ((Boolean) g.aAh().azQ().get(ar.a.USERINFO_WEIXIN_CAMERASAVEVIDEO_STATE_BOOLEAN, Boolean.TRUE)).booleanValue();
            ao azQ2 = g.aAh().azQ();
            ar.a aVar2 = ar.a.USERINFO_WEIXIN_CAMERASAVEVIDEO_STATE_BOOLEAN;
            if (!booleanValue2) {
                z2 = true;
            } else {
                z2 = false;
            }
            azQ2.set(aVar2, Boolean.valueOf(z2));
        }
        if (str.equals("settings_sns_auto_play_switch")) {
            boolean booleanValue3 = ((Boolean) g.aAh().azQ().get(ar.a.USERINFO_WEIXIN_SNSAUTOPLAY_AUTOSYNC_BOOLEAN, Boolean.TRUE)).booleanValue();
            ao azQ3 = g.aAh().azQ();
            ar.a aVar3 = ar.a.USERINFO_WEIXIN_SNSAUTOPLAY_AUTOSYNC_BOOLEAN;
            if (!booleanValue3) {
                z = true;
            } else {
                z = false;
            }
            azQ3.set(aVar3, Boolean.valueOf(z));
        }
        if (str.equals("settings_voip_audio_switch_mobile_net")) {
            boolean isChecked = ((CheckBoxPreference) preference).isChecked();
            Log.i("ui.settings.SettingsAboutCamera", "switch ext change : open = " + isChecked + " item value = 137438953472 functionId = 58");
            if (isChecked) {
                this.qAb &= -137438953473L;
            } else {
                this.qAb |= 137438953472L;
            }
            if (isChecked) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            bfx bfx = new bfx();
            bfx.LPB = 58;
            bfx.BsD = i2;
            ((l) g.af(l.class)).aSM().d(new k.a(23, bfx));
            g.aAh().azQ().set(147457, Long.valueOf(this.qAb));
        }
        ie ieVar = new ie();
        ieVar.eNt = 3;
        if (Util.isEqual(str, "settings_auto_mul_terminal_sync")) {
            if (!((Boolean) g.aAh().azQ().get(ar.a.USERINFO_WEIXIN_MUL_TERMINAL_AUTOSYNC_BOOLEAN, Boolean.TRUE)).booleanValue()) {
                i3 = 2;
            }
            ieVar.eNu = i3;
        } else if (Util.isEqual(str, "settings_take_photo_auto_save_photo")) {
            if (!((Boolean) g.aAh().azQ().get(ar.a.USERINFO_WEIXIN_CAMERASAVEIMAGE_STATE_BOOLEAN, Boolean.TRUE)).booleanValue()) {
                i3 = 2;
            }
            ieVar.eNv = i3;
        } else if (Util.isEqual(str, "settings_take_photo_auto_save_video")) {
            if (!((Boolean) g.aAh().azQ().get(ar.a.USERINFO_WEIXIN_CAMERASAVEVIDEO_STATE_BOOLEAN, Boolean.TRUE)).booleanValue()) {
                i3 = 2;
            }
            ieVar.eNw = i3;
        } else if (Util.isEqual(str, "settings_sns_auto_play_switch")) {
            if (!((Boolean) g.aAh().azQ().get(ar.a.USERINFO_WEIXIN_SNSAUTOPLAY_AUTOSYNC_BOOLEAN, Boolean.TRUE)).booleanValue()) {
                i3 = 2;
            }
            ieVar.eNx = i3;
        }
        ieVar.bfK();
        AppMethodBeat.o(74013);
        return false;
    }
}
