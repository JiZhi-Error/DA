package com.tencent.mm.plugin.qqmail.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.ui.base.preference.KeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class MailAddrProfileUI extends MMPreference {
    private boolean BvY;
    private String name;
    private f screen;
    private String yFq;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.bh;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(123060);
        super.onCreate(bundle);
        this.name = getIntent().getStringExtra("name");
        this.yFq = getIntent().getStringExtra("addr");
        this.BvY = getIntent().getBooleanExtra("can_compose", false);
        initView();
        AppMethodBeat.o(123060);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(123061);
        setMMTitle(R.string.e42);
        this.screen = getPreferenceScreen();
        ((KeyValuePreference) this.screen.bmg("mail_receiver_info_name")).setSummary(this.name);
        ((KeyValuePreference) this.screen.bmg("mail_receiver_info_addr")).setSummary(getIntent().getStringExtra("addr"));
        Preference bmg = this.screen.bmg("mail_compose_btn");
        if (!this.BvY) {
            this.screen.e(bmg);
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.qqmail.ui.MailAddrProfileUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(123059);
                MailAddrProfileUI.this.hideVKB();
                MailAddrProfileUI.this.finish();
                AppMethodBeat.o(123059);
                return true;
            }
        });
        AppMethodBeat.o(123061);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(123062);
        if (preference.mKey.equals("mail_compose_btn")) {
            Intent intent = new Intent(this, ComposeUI.class);
            intent.putExtra("composeType", 4);
            intent.putExtra("toList", new String[]{this.name + " " + this.yFq});
            a bl = new a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/qqmail/ui/MailAddrProfileUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/qqmail/ui/MailAddrProfileUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            finish();
        }
        AppMethodBeat.o(123062);
        return false;
    }
}
