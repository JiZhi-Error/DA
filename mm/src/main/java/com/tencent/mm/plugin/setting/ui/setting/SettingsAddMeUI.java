package com.tencent.mm.plugin.setting.ui.setting;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.a;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.preference.h;
import java.util.HashMap;
import java.util.Map;

public class SettingsAddMeUI extends MMPreference {
    private int Dbj;
    private HashMap<Integer, Integer> kbt = new HashMap<>();
    private long qAb;
    private f screen;
    private int status;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SettingsAddMeUI() {
        AppMethodBeat.i(74099);
        AppMethodBeat.o(74099);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public h createAdapter(SharedPreferences sharedPreferences) {
        AppMethodBeat.i(74100);
        a aVar = new a(this, getListView(), sharedPreferences);
        AppMethodBeat.o(74100);
        return aVar;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.c_;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(74101);
        super.onCreate(bundle);
        this.screen = getPreferenceScreen();
        this.Dbj = z.aUe();
        this.status = z.aUc();
        this.qAb = z.aUd();
        initView();
        AppMethodBeat.o(74101);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(74102);
        super.onPause();
        Log.d("MicroMsg.SettingsAddMeUI", "plug:" + this.Dbj + ",status:" + this.status + ",extstatus:" + this.qAb);
        g.aAh().azQ().set(7, Integer.valueOf(this.status));
        g.aAh().azQ().set(40, Integer.valueOf(this.Dbj));
        g.aAh().azQ().set(147457, Long.valueOf(this.qAb));
        for (Map.Entry<Integer, Integer> entry : this.kbt.entrySet()) {
            int intValue = entry.getKey().intValue();
            int intValue2 = entry.getValue().intValue();
            bfx bfx = new bfx();
            bfx.LPB = intValue;
            bfx.BsD = intValue2;
            ((l) g.af(l.class)).aSM().d(new k.a(23, bfx));
            Log.d("MicroMsg.SettingsAddMeUI", "switch  " + intValue + " " + intValue2);
        }
        this.kbt.clear();
        AppMethodBeat.o(74102);
    }

    private void i(boolean z, int i2, int i3) {
        AppMethodBeat.i(74104);
        Log.d("MicroMsg.SettingsAddMeUI", "switch change : open = " + z + " item value = " + i2 + " functionId = " + i3);
        if (z) {
            this.status |= i2;
        } else {
            this.status &= i2 ^ -1;
        }
        this.kbt.put(Integer.valueOf(i3), Integer.valueOf(z ? 1 : 2));
        AppMethodBeat.o(74104);
    }

    private void k(boolean z, int i2, int i3) {
        AppMethodBeat.i(74105);
        Log.d("MicroMsg.SettingsAddMeUI", "switch ext change : open = " + z + " item value = " + i2 + " functionId = " + i3);
        if (z) {
            this.qAb |= (long) i2;
        } else {
            this.qAb &= (long) (i2 ^ -1);
        }
        this.kbt.put(Integer.valueOf(i3), Integer.valueOf(z ? 1 : 2));
        AppMethodBeat.o(74105);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        boolean z;
        boolean z2;
        AppMethodBeat.i(74106);
        setMMTitle(R.string.gnb);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsAddMeUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74098);
                SettingsAddMeUI.this.hideVKB();
                SettingsAddMeUI.this.finish();
                AppMethodBeat.o(74098);
                return true;
            }
        });
        Log.d("MicroMsg.SettingsAddMeUI", "plug:" + this.Dbj + ",status:" + this.status + ",extstatus:" + this.qAb);
        this.screen.removeAll();
        this.screen.addPreferencesFromResource(getResourceId());
        Integer num = (Integer) g.aAh().azQ().get(9, (Object) null);
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.screen.bmg("settings_find_me_by_QQ");
        checkBoxPreference.OZw = false;
        if (WeChatBrands.Business.Entries.MeSetPrivacyAddByQQ.banned() || num == null || num.intValue() == 0) {
            this.screen.e(checkBoxPreference);
        } else {
            checkBoxPreference.setChecked(!UM(8) || !UM(16));
        }
        String str = (String) g.aAh().azQ().get(6, (Object) null);
        CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) this.screen.bmg("settings_find_me_by_mobile");
        checkBoxPreference2.OZw = false;
        if (str == null || str.length() <= 0) {
            this.screen.e(checkBoxPreference2);
        } else {
            if (!UM(512)) {
                z2 = true;
            } else {
                z2 = false;
            }
            checkBoxPreference2.setChecked(z2);
        }
        CheckBoxPreference checkBoxPreference3 = (CheckBoxPreference) this.screen.bmg("settings_find_me_by_weixin");
        checkBoxPreference3.OZw = false;
        if ((this.Dbj & 512) != 0) {
            checkBoxPreference3.setChecked(false);
        } else {
            checkBoxPreference3.setChecked(true);
        }
        CheckBoxPreference checkBoxPreference4 = (CheckBoxPreference) this.screen.bmg("settings_find_me_by_google");
        if (!UM(524288)) {
            z = true;
        } else {
            z = false;
        }
        checkBoxPreference4.setChecked(z);
        checkBoxPreference4.OZw = false;
        String str2 = (String) g.aAh().azQ().get(208903, (Object) null);
        if (!Util.isOverseasUser(this) || TextUtils.isEmpty(str2)) {
            this.screen.e(checkBoxPreference4);
        }
        CheckBoxPreference checkBoxPreference5 = (CheckBoxPreference) this.screen.bmg("settings_add_me_by_chatroom");
        checkBoxPreference5.OZw = false;
        if ((this.qAb & 1) != 0) {
            checkBoxPreference5.setChecked(false);
        } else {
            checkBoxPreference5.setChecked(true);
        }
        CheckBoxPreference checkBoxPreference6 = (CheckBoxPreference) this.screen.bmg("settings_add_me_by_qrcode");
        checkBoxPreference6.OZw = false;
        if ((this.qAb & 2) != 0) {
            checkBoxPreference6.setChecked(false);
        } else {
            checkBoxPreference6.setChecked(true);
        }
        CheckBoxPreference checkBoxPreference7 = (CheckBoxPreference) this.screen.bmg("settings_add_me_by_namecard");
        checkBoxPreference7.OZw = false;
        if ((this.qAb & 4) != 0) {
            checkBoxPreference7.setChecked(false);
        } else {
            checkBoxPreference7.setChecked(true);
        }
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(74106);
    }

    private boolean UM(int i2) {
        return (this.status & i2) != 0;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        int i2;
        boolean z = false;
        AppMethodBeat.i(74103);
        String str = preference.mKey;
        Log.i("MicroMsg.SettingsAddMeUI", str + " item has been clicked!");
        if (str.equals("settings_find_me_by_QQ")) {
            boolean z2 = !((CheckBoxPreference) fVar.bmg("settings_find_me_by_QQ")).isChecked();
            i(z2, 8, 2);
            i(z2, 16, 3);
            AppMethodBeat.o(74103);
            return true;
        } else if (str.equals("settings_find_me_by_weixin")) {
            if (!((CheckBoxPreference) fVar.bmg("settings_find_me_by_weixin")).isChecked()) {
                z = true;
            }
            Log.d("MicroMsg.SettingsAddMeUI", "switch plug change : open = " + z + " item value = 512 functionId = 25");
            if (z) {
                this.Dbj |= 512;
            } else {
                this.Dbj &= -513;
            }
            if (z) {
                i2 = 1;
            } else {
                i2 = 2;
            }
            this.kbt.put(25, Integer.valueOf(i2));
            AppMethodBeat.o(74103);
            return true;
        } else if (str.equals("settings_find_me_by_mobile")) {
            if (!((CheckBoxPreference) fVar.bmg("settings_find_me_by_mobile")).isChecked()) {
                z = true;
            }
            i(z, 512, 8);
            AppMethodBeat.o(74103);
            return true;
        } else if (str.equals("settings_find_me_by_google")) {
            if (!((CheckBoxPreference) fVar.bmg("settings_find_me_by_google")).isChecked()) {
                z = true;
            }
            i(z, 524288, 30);
            AppMethodBeat.o(74103);
            return true;
        } else if (str.equals("settings_add_me_by_chatroom")) {
            if (!((CheckBoxPreference) fVar.bmg("settings_add_me_by_chatroom")).isChecked()) {
                z = true;
            }
            k(z, 1, 38);
            AppMethodBeat.o(74103);
            return true;
        } else if (str.equals("settings_add_me_by_qrcode")) {
            if (!((CheckBoxPreference) fVar.bmg("settings_add_me_by_qrcode")).isChecked()) {
                z = true;
            }
            k(z, 2, 39);
            AppMethodBeat.o(74103);
            return true;
        } else if (str.equals("settings_add_me_by_namecard")) {
            if (!((CheckBoxPreference) fVar.bmg("settings_add_me_by_namecard")).isChecked()) {
                z = true;
            }
            k(z, 4, 40);
            AppMethodBeat.o(74103);
            return true;
        } else {
            AppMethodBeat.o(74103);
            return false;
        }
    }
}
