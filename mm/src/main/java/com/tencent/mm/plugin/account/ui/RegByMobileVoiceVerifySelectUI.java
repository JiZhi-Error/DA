package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.aw.b;
import com.tencent.mm.plugin.account.ui.LanguagePreference;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceCategory;
import com.tencent.mm.ui.base.preference.f;

public class RegByMobileVoiceVerifySelectUI extends MMPreference implements i {
    private LanguagePreference.a[] kqS;
    private String languageCode;
    private f screen;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(128618);
        super.onCreate(bundle);
        this.screen = getPreferenceScreen();
        initView();
        AppMethodBeat.o(128618);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(128619);
        super.onDestroy();
        AppMethodBeat.o(128619);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.layout.j6;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(128620);
        if (preference instanceof LanguagePreference) {
            LanguagePreference.a aVar = ((LanguagePreference) preference).kln;
            if (aVar == null) {
                AppMethodBeat.o(128620);
                return false;
            }
            Intent intent = new Intent();
            Bundle bundle = new Bundle();
            bundle.putString("voice_verify_language", aVar.klo);
            bundle.putString("voice_verify_code", aVar.klq);
            intent.putExtras(bundle);
            setResult(0, intent);
            finish();
            AppMethodBeat.o(128620);
            return true;
        }
        AppMethodBeat.o(128620);
        return false;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(128621);
        hideVKB();
        this.languageCode = getIntent().getExtras().getString("voice_verify_code");
        setMMTitle(R.string.afg);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.ui.RegByMobileVoiceVerifySelectUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(128617);
                RegByMobileVoiceVerifySelectUI.this.hideVKB();
                RegByMobileVoiceVerifySelectUI.this.finish();
                AppMethodBeat.o(128617);
                return true;
            }
        });
        this.kqS = bpI();
        if (this.kqS == null || this.kqS.length <= 0) {
            AppMethodBeat.o(128621);
            return;
        }
        this.screen.removeAll();
        this.screen.c(new PreferenceCategory(this));
        LanguagePreference.a[] aVarArr = this.kqS;
        for (LanguagePreference.a aVar : aVarArr) {
            if (aVar.klq.equalsIgnoreCase(this.languageCode)) {
                aVar.isSelected = true;
            }
            LanguagePreference languagePreference = new LanguagePreference(this);
            languagePreference.a(aVar);
            languagePreference.setKey(aVar.klq);
            this.screen.c(languagePreference);
        }
        AppMethodBeat.o(128621);
    }

    public static String Ty(String str) {
        AppMethodBeat.i(128622);
        LanguagePreference.a[] bpI = bpI();
        String Ph = b.Ph(str);
        for (LanguagePreference.a aVar : bpI) {
            if (aVar.klq.equalsIgnoreCase(Ph)) {
                String str2 = aVar.klo;
                AppMethodBeat.o(128622);
                return str2;
            }
        }
        AppMethodBeat.o(128622);
        return "English";
    }

    private static LanguagePreference.a[] bpI() {
        AppMethodBeat.i(128623);
        String[] split = MMApplicationContext.getContext().getString(R.string.afa).trim().split(",");
        LanguagePreference.a[] aVarArr = new LanguagePreference.a[split.length];
        for (int i2 = 0; i2 < split.length; i2++) {
            String[] split2 = split[i2].trim().split(":");
            aVarArr[i2] = new LanguagePreference.a(split2[1], split2[2], split2[0], false);
        }
        AppMethodBeat.o(128623);
        return aVarArr;
    }
}
