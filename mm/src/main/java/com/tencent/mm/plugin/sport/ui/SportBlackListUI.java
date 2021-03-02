package com.tencent.mm.plugin.sport.ui;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.ViewGroup;
import com.google.android.gms.common.Scopes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.c.ch;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.contact.u;
import java.util.ArrayList;
import java.util.List;

public class SportBlackListUI extends MMPreference {
    private List<String> FjN;
    private ContactListExpandPreference.a FjO = new ContactListExpandPreference.a() {
        /* class com.tencent.mm.plugin.sport.ui.SportBlackListUI.AnonymousClass2 */

        @Override // com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a
        public final void og(int i2) {
            AppMethodBeat.i(28812);
            String aio = SportBlackListUI.this.gtU.aio(i2);
            if (Util.isNullOrNil(aio)) {
                AppMethodBeat.o(28812);
                return;
            }
            SportBlackListUI.this.FjN.remove(aio);
            SportBlackListUI.this.gtU.H(null, SportBlackListUI.this.FjN);
            SportBlackListUI.this.gtU.refresh();
            bg.aVF();
            ab.s(c.aSN().Kn(aio));
            com.tencent.mm.plugin.sport.a.c.pl(40);
            AppMethodBeat.o(28812);
        }

        @Override // com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a
        public final void oh(int i2) {
            AppMethodBeat.i(28813);
            SportBlackListUI.c(SportBlackListUI.this);
            AppMethodBeat.o(28813);
        }

        @Override // com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a
        public final void e(ViewGroup viewGroup, int i2) {
            AppMethodBeat.i(232062);
            String aio = SportBlackListUI.this.gtU.aio(i2);
            Intent intent = new Intent();
            intent.putExtra("Contact_User", aio);
            com.tencent.mm.br.c.b(SportBlackListUI.this, Scopes.PROFILE, ".ui.ContactInfoUI", intent);
            AppMethodBeat.o(232062);
        }

        @Override // com.tencent.mm.pluginsdk.ui.applet.ContactListExpandPreference.a
        public final void amF() {
            AppMethodBeat.i(28815);
            SportBlackListUI.this.gtU.gpE();
            AppMethodBeat.o(28815);
        }
    };
    private ContactListExpandPreference gtU;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SportBlackListUI() {
        AppMethodBeat.i(28816);
        AppMethodBeat.o(28816);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(28817);
        super.onCreate(bundle);
        com.tencent.mm.plugin.sport.a.c.pl(39);
        if (this.FjN == null) {
            this.FjN = new ArrayList();
        }
        bg.aVF();
        Cursor e2 = c.aSN().e("@werun.black.android", "", null);
        while (e2.moveToNext()) {
            this.FjN.add(e2.getString(e2.getColumnIndex(ch.COL_USERNAME)));
        }
        e2.close();
        this.gtU = (ContactListExpandPreference) getPreferenceScreen().bmg("black_contact_list_pref");
        this.gtU.a(getPreferenceScreen(), this.gtU.mKey);
        this.gtU.zU(true).zV(true);
        this.gtU.H(null, this.FjN);
        this.gtU.a(this.FjO);
        this.gtU.setSummary(R.string.c2m);
        setMMTitle(getString(R.string.c15));
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.sport.ui.SportBlackListUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(28811);
                SportBlackListUI.this.finish();
                AppMethodBeat.o(28811);
                return false;
            }
        });
        AppMethodBeat.o(28817);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.d2;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        return false;
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(28818);
        super.onActivityResult(i2, i3, intent);
        if (i2 == 0) {
            if (intent == null) {
                AppMethodBeat.o(28818);
                return;
            }
            String stringExtra = intent.getStringExtra("Select_Contact");
            if (Util.isNullOrNil(stringExtra)) {
                AppMethodBeat.o(28818);
                return;
            }
            ArrayList<String> stringsToList = Util.stringsToList(stringExtra.split(","));
            if (stringsToList == null) {
                AppMethodBeat.o(28818);
                return;
            }
            this.FjN.addAll(stringsToList);
            this.gtU.H(null, this.FjN);
            this.gtU.refresh();
            for (String str : stringsToList) {
                bg.aVF();
                ab.r(c.aSN().Kn(str));
            }
        }
        AppMethodBeat.o(28818);
    }

    static /* synthetic */ void c(SportBlackListUI sportBlackListUI) {
        AppMethodBeat.i(28819);
        String listToString = Util.listToString(sportBlackListUI.FjN, ",");
        Intent intent = new Intent();
        intent.putExtra("titile", sportBlackListUI.getString(R.string.g4));
        intent.putExtra("list_type", 1);
        intent.putExtra("list_attr", u.Q(u.PWT, 1024));
        intent.putExtra("always_select_contact", listToString);
        com.tencent.mm.br.c.c(sportBlackListUI, ".ui.contact.SelectContactUI", intent, 0);
        AppMethodBeat.o(28819);
    }
}
