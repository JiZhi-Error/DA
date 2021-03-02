package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bz;
import com.tencent.mm.model.z;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.account.bind.ui.BindLinkedInUI;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.setting.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;

public class SettingsPersonalMoreUI extends MMPreference implements MStorageEx.IOnStorageChange {
    private int fuA = -1;
    private f screen;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(74320);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(74320);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.cp;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(74321);
        setMMTitle(R.string.gsd);
        this.screen = getPreferenceScreen();
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalMoreUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74319);
                SettingsPersonalMoreUI.this.hideVKB();
                SettingsPersonalMoreUI.this.finish();
                AppMethodBeat.o(74319);
                return true;
            }
        });
        AppMethodBeat.o(74321);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        boolean z;
        boolean z2 = false;
        AppMethodBeat.i(74322);
        super.onResume();
        this.fuA = Util.nullAs((Integer) g.aAh().azQ().get(12290, (Object) null), 0);
        Preference bmg = this.screen.bmg("settings_sex");
        switch (this.fuA) {
            case 1:
                bmg.setSummary(getString(R.string.gxi));
                break;
            case 2:
                bmg.setSummary(getString(R.string.gxh));
                break;
        }
        bz aWj = bz.aWj();
        this.screen.bmg("settings_district").setSummary(aa.It(Util.nullAsNil(aWj.getProvince())) + " " + Util.nullAsNil(aWj.getCity()));
        eTs();
        boolean z3 = (z.aUl() & TPMediaCodecProfileLevel.HEVCMainTierLevel62) == 0;
        String value = h.aqJ().getValue("LinkedinPluginClose");
        if (Util.isNullOrNil(value) || Util.getInt(value, 0) == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!Util.isNullOrNil((String) g.aAh().azQ().get(286721, (Object) null))) {
            z2 = true;
        }
        if (!z3 || !z || !z2) {
            this.screen.m38do("settings_linkedin", true);
            AppMethodBeat.o(74322);
            return;
        }
        Preference bmg2 = this.screen.bmg("settings_linkedin");
        if ((z.aUc() & 4194304) == 0) {
            bmg2.setSummary(getString(R.string.gpq));
            AppMethodBeat.o(74322);
            return;
        }
        bmg2.setSummary(getString(R.string.gpr));
        AppMethodBeat.o(74322);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(74323);
        super.onPause();
        bz aWj = bz.aWj();
        if (this.fuA != -1) {
            aWj.fuA = this.fuA;
        }
        ((l) g.af(l.class)).aSM().d(new k.a(1, bz.a(aWj)));
        AppMethodBeat.o(74323);
    }

    private void eTs() {
        AppMethodBeat.i(74324);
        Preference bmg = this.screen.bmg("settings_signature");
        String nullAsNil = Util.nullAsNil((String) g.aAh().azQ().get(12291, (Object) null));
        if (nullAsNil.length() <= 0) {
            nullAsNil = getString(R.string.gu1);
        }
        bmg.setSummary(com.tencent.mm.pluginsdk.ui.span.l.c(this, nullAsNil));
        AppMethodBeat.o(74324);
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(74326);
        int nullAsInt = Util.nullAsInt(obj, 0);
        Log.d("SettingsPersonalMoreUI", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i2), Integer.valueOf(nullAsInt), mStorageEx);
        if (mStorageEx != g.aAh().azQ() || nullAsInt <= 0) {
            Log.e("SettingsPersonalMoreUI", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(nullAsInt), mStorageEx);
            AppMethodBeat.o(74326);
            return;
        }
        if (12291 == nullAsInt) {
            eTs();
        }
        AppMethodBeat.o(74326);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(74325);
        String str = preference.mKey;
        if (str.equals("settings_district")) {
            c.jRt.b(new Intent(), (Context) getContext());
            AppMethodBeat.o(74325);
            return true;
        } else if (str.equals("settings_signature")) {
            a bl = new a().bl(new Intent(this, EditSignatureUI.class));
            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalMoreUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalMoreUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(74325);
            return true;
        } else if (str.equals("settings_linkedin")) {
            Intent intent = new Intent(this, BindLinkedInUI.class);
            intent.putExtra("oversea_entry", true);
            a bl2 = new a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl2.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalMoreUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl2.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalMoreUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(74325);
            return true;
        } else if (str.equals("settings_sex")) {
            a bl3 = new a().bl(new Intent(this, SelectSexUI.class));
            com.tencent.mm.hellhoundlib.a.a.a(this, bl3.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalMoreUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl3.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalMoreUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(74325);
            return true;
        } else {
            AppMethodBeat.o(74325);
            return false;
        }
    }
}
