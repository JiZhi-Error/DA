package com.tencent.mm.plugin.wallet_core.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.wallet_core.id_verify.model.Profession;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.preference.f;

public class WalletSelectProfessionUI extends MMPreference {
    private static final String TAG = "MicroMsg.WalletSelectProfessionUI";
    protected Profession[] mProfessions = null;
    private f screen;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(71230);
        super.onCreate(bundle);
        setMMTitle(R.string.ise);
        this.screen = getPreferenceScreen();
        PreferenceTitleCategory preferenceTitleCategory = new PreferenceTitleCategory(getContext());
        preferenceTitleCategory.setTitle(getString(R.string.isd));
        preferenceTitleCategory.setKey("title_category");
        this.screen.c(preferenceTitleCategory);
        Parcelable[] parcelableArrayExtra = getIntent().getParcelableArrayExtra("key_profession_list");
        if (parcelableArrayExtra != null && parcelableArrayExtra.length > 0) {
            this.mProfessions = new Profession[parcelableArrayExtra.length];
            for (int i2 = 0; i2 < this.mProfessions.length; i2++) {
                this.mProfessions[i2] = (Profession) parcelableArrayExtra[i2];
            }
        }
        if (this.mProfessions != null) {
            Profession[] professionArr = this.mProfessions;
            int i3 = 0;
            for (Profession profession : professionArr) {
                if (profession != null && !Util.isNullOrNil(profession.HTX)) {
                    Preference preference = new Preference(getContext());
                    preference.setTitle(profession.HTX);
                    preference.setKey("index_".concat(String.valueOf(i3)));
                    this.screen.c(preference);
                }
                i3++;
            }
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.wallet_core.ui.WalletSelectProfessionUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(71229);
                WalletSelectProfessionUI.this.setResult(0);
                WalletSelectProfessionUI.this.finish();
                AppMethodBeat.o(71229);
                return true;
            }
        });
        AppMethodBeat.o(71230);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return -1;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(71231);
        if (preference.mKey.startsWith("index_")) {
            String[] split = preference.mKey.split("_");
            if (split.length == 2) {
                Profession profession = this.mProfessions[Util.getInt(split[1], 0)];
                Intent intent = new Intent();
                intent.putExtra("key_select_profession", profession);
                setResult(-1, intent);
            } else {
                Log.w(TAG, "error key: %s, %s", preference.mKey, preference.getTitle());
                setResult(0);
            }
            finish();
        }
        AppMethodBeat.o(71231);
        return true;
    }
}
