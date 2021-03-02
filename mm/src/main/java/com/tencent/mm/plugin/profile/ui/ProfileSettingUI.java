package com.tencent.mm.plugin.profile.ui;

import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.profile.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class ProfileSettingUI extends MMPreference implements MStorageEx.IOnStorageChange {
    private b Bif;
    private as rjX;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.bw;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(231894);
        super.onCreate(bundle);
        String nullAsNil = Util.nullAsNil(getIntent().getStringExtra("Contact_User"));
        if (Util.isNullOrNil(nullAsNil)) {
            Log.e("MicroMsg.ProfileSettingUI", "username is null %s", nullAsNil);
            finish();
            AppMethodBeat.o(231894);
            return;
        }
        bg.aVF();
        this.rjX = c.aSN().Kn(nullAsNil);
        this.Bif = new b(this, this.rjX);
        setMMTitle(R.string.fqi);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.profile.ui.ProfileSettingUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(231893);
                ProfileSettingUI.this.finish();
                AppMethodBeat.o(231893);
                return true;
            }
        });
        initView();
        bg.aVF();
        c.aSN().add(this);
        AppMethodBeat.o(231894);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x008c, code lost:
        if ("3552365301".equals(r6.rjX.field_openImAppid) != false) goto L_0x008e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00a0, code lost:
        if (com.tencent.mm.contact.c.oR(r6.rjX.field_type) != false) goto L_0x00a2;
     */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x013d  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x01c4  */
    @Override // com.tencent.mm.ui.MMActivity
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void initView() {
        /*
        // Method dump skipped, instructions count: 476
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.profile.ui.ProfileSettingUI.initView():void");
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(231896);
        this.Bif.destroy();
        bg.aVF();
        c.aSN().remove(this);
        super.onDestroy();
        AppMethodBeat.o(231896);
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(231898);
        if ((obj instanceof String) && this.rjX.field_username.equals((String) obj)) {
            bg.aVF();
            this.rjX = c.aSN().Kn((String) obj);
            if (this.rjX != null) {
                this.Bif.rjX = this.rjX;
                initView();
                getPreferenceScreen().notifyDataSetChanged();
            }
        }
        AppMethodBeat.o(231898);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(231897);
        String str = preference.mKey;
        Log.i("MicroMsg.ProfileSettingUI", str + " item has been clicked!");
        if (str.equals("setting_remark")) {
            this.Bif.Lc(1);
            AppMethodBeat.o(231897);
            return true;
        } else if (str.equals("setting_permission")) {
            this.Bif.Lc(3);
            AppMethodBeat.o(231897);
            return true;
        } else if (str.equals("setting_send_card")) {
            this.Bif.Lc(4);
            AppMethodBeat.o(231897);
            return true;
        } else if (str.equals("setting_shortcut")) {
            this.Bif.Lc(7);
            AppMethodBeat.o(231897);
            return true;
        } else if (str.equals("setting_star")) {
            this.Bif.Lc(2);
            AppMethodBeat.o(231897);
            return true;
        } else if (str.equals("setting_blacklist")) {
            this.Bif.Lc(5);
            AppMethodBeat.o(231897);
            return true;
        } else if (str.equals("setting_report")) {
            this.Bif.Lc(9);
            AppMethodBeat.o(231897);
            return true;
        } else if (str.equals("setting_delete")) {
            this.Bif.Lc(6);
            AppMethodBeat.o(231897);
            return true;
        } else {
            AppMethodBeat.o(231897);
            return false;
        }
    }
}
