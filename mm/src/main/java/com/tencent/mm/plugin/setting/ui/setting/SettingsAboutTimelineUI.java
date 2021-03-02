package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.sns.b.o;
import com.tencent.mm.protocal.protobuf.ebj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class SettingsAboutTimelineUI extends MMPreference {
    private boolean DaS = false;
    private boolean DaT = false;
    private String gna = "";
    private f screen;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.c9;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(74069);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(74069);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        AppMethodBeat.i(74070);
        super.onResume();
        ebj ebj = new ebj();
        if (o.DCN != null) {
            ebj = o.DCN.aNV(this.gna);
        }
        if (ebj == null) {
            Log.e("MicroMsg.SettingsAboutTimelineUI", "userinfo is null");
        } else {
            int i2 = ebj.Nbc;
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.screen.bmg("timeline_stranger_show");
            if (checkBoxPreference != null) {
                this.DaT = (i2 & 1) > 0;
                SharedPreferences sharedPreferences = getSharedPreferences(getPackageName() + "_preferences", 0);
                if (!this.DaT) {
                    checkBoxPreference.setChecked(true);
                    sharedPreferences.edit().putBoolean("timeline_stranger_show", true).commit();
                } else {
                    checkBoxPreference.setChecked(false);
                    sharedPreferences.edit().putBoolean("timeline_stranger_show", false).commit();
                }
            }
        }
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(74070);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(74072);
        super.onDestroy();
        if (this.DaS && o.DCN != null) {
            ebj cg = o.DCN.cg(this.gna, this.DaT);
            if (cg == null) {
                AppMethodBeat.o(74072);
                return;
            } else {
                Log.d("MicroMsg.SettingsAboutTimelineUI", "userinfo " + cg.toString());
                ((l) g.af(l.class)).aSM().d(new k.a(51, cg));
            }
        }
        AppMethodBeat.o(74072);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(74073);
        this.screen = getPreferenceScreen();
        setMMTitle(R.string.gsg);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsAboutTimelineUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74068);
                SettingsAboutTimelineUI.this.hideVKB();
                SettingsAboutTimelineUI.this.finish();
                AppMethodBeat.o(74068);
                return true;
            }
        });
        this.gna = z.aTY();
        AppMethodBeat.o(74073);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        boolean z;
        AppMethodBeat.i(74071);
        String str = preference.mKey;
        if (str.equals("timline_outside_permiss")) {
            Intent intent = new Intent();
            intent.putExtra("k_sns_tag_id", 4L);
            intent.putExtra("k_sns_from_settings_about_sns", 1);
            c.b(this, "sns", ".ui.SnsBlackDetailUI", intent);
        }
        if (str.equals("timeline_black_permiss")) {
            Intent intent2 = new Intent();
            intent2.putExtra("k_sns_tag_id", 5L);
            intent2.putExtra("k_sns_from_settings_about_sns", 2);
            c.b(this, "sns", ".ui.SnsTagDetailUI", intent2);
        }
        if (str.equals("timeline_stranger_show")) {
            if (!this.DaT) {
                z = true;
            } else {
                z = false;
            }
            this.DaT = z;
            if (o.DCN != null) {
                o.DCN.cf(this.gna, this.DaT);
            }
            this.DaS = true;
        }
        AppMethodBeat.o(74071);
        return false;
    }
}
