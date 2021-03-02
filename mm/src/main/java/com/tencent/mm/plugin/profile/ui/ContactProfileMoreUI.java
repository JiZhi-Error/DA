package com.tencent.mm.plugin.profile.ui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fts.a.a.k;
import com.tencent.mm.plugin.fts.a.e;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.profile.a.b;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class ContactProfileMoreUI extends MMPreference implements l {
    private b Bcm;
    private String goe;
    ah gtd;
    private String gwx;
    boolean gxS = false;
    private f nRm;
    private as rjX;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.ap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:107:0x0357  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0192  */
    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r11) {
        /*
        // Method dump skipped, instructions count: 976
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.profile.ui.ContactProfileMoreUI.onCreate(android.os.Bundle):void");
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(27040);
        super.onDestroy();
        this.Bcm.destroy();
        AppMethodBeat.o(27040);
    }

    @Override // com.tencent.mm.plugin.fts.a.l
    public final void b(k kVar) {
        AppMethodBeat.i(27041);
        Preference bmg = this.nRm.bmg("common_chatroom");
        if (kVar.resultCode == 0) {
            int intValue = ((Integer) kVar.wXb.get(0).userData).intValue();
            bmg.setSummary(getString(R.string.ba_, new Object[]{Integer.valueOf(intValue)}));
            bmg.getExtras().putInt("count", intValue);
        } else {
            bmg.setSummary(getString(R.string.ba_, new Object[]{0}));
        }
        this.nRm.notifyDataSetChanged();
        AppMethodBeat.o(27041);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(27038);
        if (preference.mKey.equals("common_chatroom")) {
            int i2 = preference.getExtras().getInt("count", 0);
            e.Nl(i2);
            if (i2 > 0) {
                Intent intent = new Intent(this, CommonChatroomInfoUI.class);
                intent.putExtra("Select_Talker_Name", this.rjX.field_username);
                a bl = new a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/profile/ui/ContactProfileMoreUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/profile/ui/ContactProfileMoreUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            }
            AppMethodBeat.o(27038);
            return true;
        }
        if (preference.mKey.equals("weishop")) {
            Intent intent2 = new Intent();
            intent2.putExtra("rawUrl", preference.getExtras().getString("shopUrl"));
            intent2.putExtra("geta8key_username", z.aTY());
            c.b(this, "webview", ".ui.tools.WebViewUI", intent2);
        } else if (preference.mKey.equals("send_to_friend")) {
            this.Bcm.eDU();
        } else if (preference.mKey.equals("add_to_black")) {
            this.Bcm.sE(false);
        } else if (preference.mKey.equals("expose")) {
            this.Bcm.eDX();
        } else if (preference.mKey.equals("delete_contact")) {
            this.Bcm.eDT();
        }
        AppMethodBeat.o(27038);
        return false;
    }
}
