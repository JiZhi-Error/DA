package com.tencent.mm.plugin.nearby.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bz;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.ChoicePreference;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class NearbyPersonalInfoUI extends MMPreference {
    private int fuA = -1;
    private f screen;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(89886);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(89886);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(89887);
        super.onDestroy();
        AppMethodBeat.o(89887);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(89888);
        setMMTitle(R.string.faz);
        this.screen = getPreferenceScreen();
        ((KeyValuePreference) this.screen.bmg("settings_signature")).OYB = false;
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.nearby.ui.NearbyPersonalInfoUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(89883);
                NearbyPersonalInfoUI.this.finish();
                AppMethodBeat.o(89883);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.x5), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.nearby.ui.NearbyPersonalInfoUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(89884);
                if (NearbyPersonalInfoUI.this.fuA != -1) {
                    bz aWj = bz.aWj();
                    aWj.fuA = NearbyPersonalInfoUI.this.fuA;
                    bz.a(aWj);
                }
                bz aWk = bz.aWk();
                if (aWk == null) {
                    NearbyPersonalInfoUI.b(NearbyPersonalInfoUI.this);
                } else {
                    String nullAsNil = Util.nullAsNil(aWk.getProvince());
                    Util.nullAsNil(aWk.getCity());
                    int i2 = aWk.fuA;
                    if (Util.isNullOrNil(nullAsNil) || i2 == 0) {
                        NearbyPersonalInfoUI.b(NearbyPersonalInfoUI.this);
                    } else {
                        a.ih(NearbyPersonalInfoUI.this.getContext());
                        bz aWj2 = bz.aWj();
                        if (i2 != -1) {
                            aWj2.fuA = i2;
                        }
                        ((l) g.af(l.class)).aSM().d(new k.a(1, bz.a(aWj2)));
                        NearbyPersonalInfoUI.this.finish();
                    }
                }
                AppMethodBeat.o(89884);
                return true;
            }
        });
        ((ChoicePreference) this.screen.bmg("settings_sex")).OXy = new Preference.a() {
            /* class com.tencent.mm.plugin.nearby.ui.NearbyPersonalInfoUI.AnonymousClass3 */

            @Override // com.tencent.mm.ui.base.preference.Preference.a
            public final boolean a(Preference preference, Object obj) {
                AppMethodBeat.i(89885);
                String str = (String) obj;
                if ("male".equalsIgnoreCase(str)) {
                    NearbyPersonalInfoUI.this.fuA = 1;
                } else if ("female".equalsIgnoreCase(str)) {
                    NearbyPersonalInfoUI.this.fuA = 2;
                }
                AppMethodBeat.o(89885);
                return false;
            }
        };
        int nullAs = Util.nullAs((Integer) g.aAh().azQ().get(12290, (Object) null), 0);
        ChoicePreference choicePreference = (ChoicePreference) this.screen.bmg("settings_sex");
        choicePreference.setTitle(Html.fromHtml(getString(R.string.gts) + "<font color='red'>*</font>"));
        switch (nullAs) {
            case 1:
                choicePreference.setValue("male");
                AppMethodBeat.o(89888);
                return;
            case 2:
                choicePreference.setValue("female");
                AppMethodBeat.o(89888);
                return;
            default:
                choicePreference.setValue("unknown");
                AppMethodBeat.o(89888);
                return;
        }
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.bm;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        AppMethodBeat.i(89889);
        bz aWj = bz.aWj();
        String province = aWj.getProvince();
        String city = aWj.getCity();
        Preference bmg = this.screen.bmg("settings_district");
        bmg.setSummary(aa.It(province) + " " + city);
        bmg.setTitle(Html.fromHtml(getString(R.string.go_) + "<font color='red'>*</font>"));
        Preference bmg2 = this.screen.bmg("settings_signature");
        String nullAsNil = Util.nullAsNil((String) g.aAh().azQ().get(12291, (Object) null));
        if (nullAsNil.length() <= 0) {
            nullAsNil = getString(R.string.gu1);
        }
        bmg2.setSummary(com.tencent.mm.pluginsdk.ui.span.l.c(this, nullAsNil));
        super.onResume();
        AppMethodBeat.o(89889);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(89890);
        String str = preference.mKey;
        if ("settings_district".equals(str)) {
            com.tencent.mm.plugin.nearby.a.jRt.b((Intent) null, (Context) this);
            AppMethodBeat.o(89890);
            return true;
        } else if ("settings_signature".equals(str)) {
            com.tencent.mm.plugin.nearby.a.jRt.bX(this);
            overridePendingTransition(R.anim.dq, R.anim.dp);
            AppMethodBeat.o(89890);
            return true;
        } else {
            AppMethodBeat.o(89890);
            return false;
        }
    }

    static /* synthetic */ void b(NearbyPersonalInfoUI nearbyPersonalInfoUI) {
        AppMethodBeat.i(89891);
        h.a(nearbyPersonalInfoUI.getContext(), (int) R.string.fb0, (int) R.string.zb, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.nearby.ui.NearbyPersonalInfoUI.AnonymousClass4 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        });
        AppMethodBeat.o(89891);
    }
}
