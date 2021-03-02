package com.tencent.mm.plugin.account.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aw.b;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.friend.ui.RecommendFriendUI;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;

public class InviteRecommendChoiceUI extends MMPreference {
    private f screen;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean autoRefresh() {
        return false;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.bd;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(128052);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(128052);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(128054);
        setMMTitle(R.string.gjv);
        this.screen = getPreferenceScreen();
        b.bdF();
        this.screen.e((IconPreference) this.screen.bmg("settings_invite_facebook_friends"));
        IconPreference iconPreference = (IconPreference) this.screen.bmg("settings_invite_qq_friends");
        if (z.aTX() == 0) {
            this.screen.e(iconPreference);
        }
        IconPreference iconPreference2 = (IconPreference) this.screen.bmg("settings_recommend_by_mail");
        if (z.aTX() == 0) {
            this.screen.e(iconPreference2);
        }
        IconPreference iconPreference3 = (IconPreference) this.screen.bmg("settings_recommend_by_mb");
        if (((l) g.af(l.class)).aSW().aEY("@t.qq.com") == null) {
            this.screen.e(iconPreference3);
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.ui.InviteRecommendChoiceUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(128051);
                InviteRecommendChoiceUI.this.hideVKB();
                InviteRecommendChoiceUI.this.finish();
                AppMethodBeat.o(128051);
                return true;
            }
        });
        AppMethodBeat.o(128054);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(128053);
        String str = preference.mKey;
        if (str.equals("settings_invite_qq_friends")) {
            Intent intent = new Intent(this, RecommendFriendUI.class);
            intent.putExtra("recommend_type", Integer.toString(0));
            a bl = new a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/account/ui/InviteRecommendChoiceUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/InviteRecommendChoiceUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        } else if (str.equals("settings_recommend_by_mail")) {
            Intent intent2 = new Intent(this, RecommendFriendUI.class);
            intent2.putExtra("recommend_type", Integer.toString(2));
            a bl2 = new a().bl(intent2);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl2.axQ(), "com/tencent/mm/plugin/account/ui/InviteRecommendChoiceUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl2.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/InviteRecommendChoiceUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        } else if (str.equals("settings_recommend_by_mb")) {
            Intent intent3 = new Intent(this, RecommendFriendUI.class);
            intent3.putExtra("recommend_type", Integer.toString(1));
            a bl3 = new a().bl(intent3);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl3.axQ(), "com/tencent/mm/plugin/account/ui/InviteRecommendChoiceUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl3.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/InviteRecommendChoiceUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        } else if (str.equals("settings_invite_mobile_friends")) {
            Intent intent4 = new Intent("android.intent.action.VIEW");
            intent4.putExtra("sms_body", getString(R.string.e4h, new Object[]{g.aAh().azQ().get(2, (Object) null)}));
            intent4.setType("vnd.android-dir/mms-sms");
            if (Util.isIntentAvailable(this, intent4)) {
                a bl4 = new a().bl(intent4);
                com.tencent.mm.hellhoundlib.a.a.a(this, bl4.axQ(), "com/tencent/mm/plugin/account/ui/InviteRecommendChoiceUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl4.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/InviteRecommendChoiceUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            } else {
                Toast.makeText(this, (int) R.string.giz, 1).show();
            }
        } else if (str.equals("settings_invite_facebook_friends")) {
            a bl5 = new a().bl(new Intent(this, InviteFacebookFriendsUI.class));
            com.tencent.mm.hellhoundlib.a.a.a(this, bl5.axQ(), "com/tencent/mm/plugin/account/ui/InviteRecommendChoiceUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl5.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/InviteRecommendChoiceUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(128053);
        return false;
    }
}
