package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import com.facebook.internal.NativeProtocol;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.setting.model.UserAuthItemParcelable;
import com.tencent.mm.plugin.setting.model.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.preference.h;
import com.tencent.mm.ui.base.q;
import java.util.ArrayList;

public class SettingsModifyUserAuthUI extends MMPreference implements i {
    private h Ddd;
    private String appId;
    private q gut;
    private int scene;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(74256);
        super.onCreate(bundle);
        this.Ddd = (h) getPreferenceScreen();
        ArrayList<UserAuthItemParcelable> parcelableArrayListExtra = getIntent().getParcelableArrayListExtra("app_auth_items");
        this.appId = getIntent().getStringExtra("app_id");
        this.scene = getIntent().getIntExtra("modify_scene", 1);
        if (parcelableArrayListExtra != null && !parcelableArrayListExtra.isEmpty()) {
            for (UserAuthItemParcelable userAuthItemParcelable : parcelableArrayListExtra) {
                CheckBoxPreference checkBoxPreference = new CheckBoxPreference(this);
                checkBoxPreference.setTitle(userAuthItemParcelable.CYp);
                if (userAuthItemParcelable.scope.equals("snsapi_friend")) {
                    checkBoxPreference.setSummary(R.string.gne);
                }
                checkBoxPreference.setKey(userAuthItemParcelable.scope);
                checkBoxPreference.setChecked(userAuthItemParcelable.state == 1);
                checkBoxPreference.OZw = false;
                this.Ddd.a(checkBoxPreference, -1);
            }
        }
        setMMTitle(getIntent().getStringExtra(NativeProtocol.BRIDGE_ARG_APP_NAME_STRING));
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyUserAuthUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74254);
                SettingsModifyUserAuthUI.this.finish();
                AppMethodBeat.o(74254);
                return true;
            }
        });
        AppMethodBeat.o(74256);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        boolean z = true;
        AppMethodBeat.i(74257);
        Log.i("MicroMsg.SettingsModifyUserAuthUI", "errCode %d, errMsg %s", Integer.valueOf(i3), str);
        if (this.gut != null) {
            this.gut.dismiss();
        }
        if (i2 == 0 && i3 == 0) {
            String str2 = ((k) qVar).CXO;
            int i4 = ((k) qVar).CXP;
            if (!Util.isNullOrNil(str2)) {
                CheckBoxPreference checkBoxPreference = (CheckBoxPreference) this.Ddd.bmg(str2);
                if (i4 != 1) {
                    z = false;
                }
                checkBoxPreference.setChecked(z);
            }
            AppMethodBeat.o(74257);
            return;
        }
        com.tencent.mm.ui.base.h.cD(this, str);
        AppMethodBeat.o(74257);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        AppMethodBeat.i(74258);
        super.onResume();
        g.azz().a(1144, this);
        AppMethodBeat.o(74258);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(74259);
        super.onPause();
        g.azz().b(1144, this);
        AppMethodBeat.o(74259);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return -1;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        int i2;
        AppMethodBeat.i(74260);
        if (((CheckBoxPreference) preference).isChecked()) {
            i2 = 1;
        } else {
            i2 = 2;
        }
        final k kVar = new k(this.appId, preference.mKey, i2, this.scene);
        g.azz().a(kVar, 0);
        this.gut = com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.ys), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsModifyUserAuthUI.AnonymousClass2 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(74255);
                g.azz().a(kVar);
                AppMethodBeat.o(74255);
            }
        });
        AppMethodBeat.o(74260);
        return true;
    }
}
