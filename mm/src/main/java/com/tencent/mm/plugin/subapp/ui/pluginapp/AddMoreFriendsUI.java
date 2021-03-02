package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.api.q;
import com.tencent.mm.bh.e;
import com.tencent.mm.br.c;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.bind.ui.MobileFriendUI;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceInfoCategory;
import com.tencent.mm.ui.base.preference.f;
import java.util.Map;

public class AddMoreFriendsUI extends MMPreference {
    private final int FMU = 4;
    private final int FMV = 9;
    private f screen;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.f3175b;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getForceOrientation() {
        return 1;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(29198);
        super.onCreate(bundle);
        initView();
        AppMethodBeat.o(29198);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        String string;
        Preference bmg;
        AppMethodBeat.i(29199);
        super.onResume();
        boolean Vu = ((q) g.af(q.class)).Vu();
        if (!c.aZU("brandservice") || !Vu) {
            this.screen.m38do("find_friends_by_web", true);
        } else {
            this.screen.m38do("find_friends_by_web", false);
        }
        this.screen.notifyDataSetChanged();
        AddFriendSearchPreference addFriendSearchPreference = (AddFriendSearchPreference) this.screen.bmg("find_friends_by_input");
        addFriendSearchPreference.FMO = getString(R.string.bi5);
        addFriendSearchPreference.FMQ = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.subapp.ui.pluginapp.AddMoreFriendsUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(29196);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/subapp/ui/pluginapp/AddMoreFriendsUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent putExtra = new Intent().putExtra("Search_Scene", 2).putExtra("MMActivity.OverrideEnterAnimation", 0).putExtra("MMActivity.OverrideExitAnimation", 0);
                Bundle bundle = null;
                if (Build.VERSION.SDK_INT >= 21 && !ao.isDarkMode()) {
                    bundle = ActivityOptions.makeSceneTransitionAnimation(AddMoreFriendsUI.this, new Pair[0]).toBundle();
                }
                d.b(AddMoreFriendsUI.this.getContext(), ".ui.FTSAddFriendUI", putExtra, bundle);
                a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/AddMoreFriendsUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(29196);
            }
        };
        PreferenceInfoCategory preferenceInfoCategory = (PreferenceInfoCategory) this.screen.bmg("find_friends_info");
        String aTY = z.aTY();
        String aTZ = z.aTZ();
        bg.aVF();
        String pureNumber = PhoneFormater.pureNumber((String) com.tencent.mm.model.c.azQ().get(6, (Object) null));
        if (!Util.isNullOrNil(aTZ)) {
            string = getString(R.string.cf6, new Object[]{aTZ});
        } else if (!as.bjx(aTY)) {
            string = getString(R.string.cf6, new Object[]{aTY});
        } else if (!Util.isNullOrNil(pureNumber)) {
            string = getString(R.string.cf7, new Object[]{PhoneFormater.formatMobileString(pureNumber)});
        } else {
            string = getString(R.string.cf8);
        }
        preferenceInfoCategory.setTitle(string);
        AnonymousClass4 r1 = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.subapp.ui.pluginapp.AddMoreFriendsUI.AnonymousClass4 */

            public final void onClick(View view) {
                AppMethodBeat.i(29197);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/subapp/ui/pluginapp/AddMoreFriendsUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                h.INSTANCE.a(11264, 1);
                Intent intent = new Intent();
                intent.setClassName(AddMoreFriendsUI.this, "com.tencent.mm.plugin.setting.ui.setting.SelfQRCodeUI");
                AppCompatActivity context = AddMoreFriendsUI.this.getContext();
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                a.a(context, bl.axQ(), "com/tencent/mm/plugin/subapp/ui/pluginapp/AddMoreFriendsUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                a.a(context, "com/tencent/mm/plugin/subapp/ui/pluginapp/AddMoreFriendsUI$4", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/AddMoreFriendsUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(29197);
            }
        };
        preferenceInfoCategory.OZL = r1;
        preferenceInfoCategory.OZM = r1;
        ((AddFriendItemPreference) this.screen.bmg("find_friends_create_pwdgroup")).CZl = 8;
        com.tencent.mm.cr.d.hiy();
        if (!(getPreferenceScreen() == null || (bmg = getPreferenceScreen().bmg("find_friends_by_web")) == null)) {
            bmg.setEnabled(true);
        }
        AppMethodBeat.o(29199);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(29200);
        super.onPause();
        AppMethodBeat.o(29200);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(29201);
        super.onDestroy();
        AppMethodBeat.o(29201);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(29202);
        if ("find_friends_by_qrcode".equals(preference.mKey)) {
            Intent intent = new Intent();
            intent.putExtra("BaseScanUI_select_scan_mode", 1);
            intent.putExtra("GetFriendQRCodeUI.INTENT_FROM_ACTIVITY", 0);
            intent.setFlags(65536);
            h.INSTANCE.a(11265, 1);
            if (!com.tencent.mm.q.a.o(this, true) && !e.bgF() && !com.tencent.mm.q.a.r(getContext(), true)) {
                c.b(this, "scanner", ".ui.BaseScanUI", intent);
            }
            AppMethodBeat.o(29202);
            return true;
        } else if ("find_friends_by_other_way".equals(preference.mKey)) {
            if (l.bnZ() != l.a.SUCC) {
                Intent intent2 = new Intent(this, BindMContactIntroUI.class);
                intent2.putExtra("key_upload_scene", 6);
                MMWizardActivity.ay(this, intent2);
                AppMethodBeat.o(29202);
                return true;
            }
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(this, MobileFriendUI.class));
            a.a(this, bl.axQ(), "com/tencent/mm/plugin/subapp/ui/pluginapp/AddMoreFriendsUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/AddMoreFriendsUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(29202);
            return true;
        } else if ("find_friends_by_web".equals(preference.mKey)) {
            if (!WeChatBrands.Business.Entries.ContactNewFriendOa.checkAvailable(getContext())) {
                AppMethodBeat.o(29202);
                return true;
            }
            if (ai.afs(0)) {
                ((i) g.af(i.class)).a(MMApplicationContext.getContext(), new Runnable() {
                    /* class com.tencent.mm.plugin.subapp.ui.pluginapp.AddMoreFriendsUI.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(29194);
                        Intent fXX = ai.fXX();
                        fXX.putExtra("KRightBtn", true);
                        fXX.putExtra("ftsneedkeyboard", true);
                        fXX.putExtra("key_load_js_without_delay", true);
                        fXX.putExtra("ftsType", 1);
                        fXX.putExtra("ftsbizscene", 9);
                        Map<String, String> h2 = ai.h(9, true, 0);
                        String afq = ai.afq(Util.safeParseInt(h2.get("scene")));
                        h2.put("sessionId", afq);
                        h2.put("subSessionId", afq);
                        fXX.putExtra("sessionId", afq);
                        fXX.putExtra("subSessionId", afq);
                        fXX.putExtra("rawUrl", ai.bd(h2));
                        Bundle bundle = null;
                        if (Build.VERSION.SDK_INT >= 21 && !ao.isDarkMode()) {
                            bundle = ActivityOptions.makeSceneTransitionAnimation(AddMoreFriendsUI.this, new Pair[0]).toBundle();
                        }
                        c.a(AddMoreFriendsUI.this, "webview", ".ui.tools.fts.FTSSearchTabWebViewUI", fXX, bundle);
                        AppMethodBeat.o(29194);
                    }
                });
                preference.setEnabled(false);
            } else {
                Log.e("MicroMsg.AddMoreFriendsUI", "fts h5 template not avail");
            }
            AppMethodBeat.o(29202);
            return true;
        } else if ("find_friends_by_radar".equals(preference.mKey)) {
            c.V(this, "radar", ".ui.RadarSearchUI");
            AppMethodBeat.o(29202);
            return true;
        } else if ("find_friends_create_pwdgroup".equals(preference.mKey)) {
            h.INSTANCE.a(11140, 1);
            c.V(this, "pwdgroup", ".ui.FacingCreateChatRoomAllInOneUI");
            AppMethodBeat.o(29202);
            return true;
        } else if ("find_friends_by_invite".equals(preference.mKey)) {
            int intExtra = getIntent().getIntExtra("invite_friend_scene", 4);
            h.INSTANCE.a(14034, Integer.valueOf(intExtra));
            Intent intent3 = new Intent(this, InviteFriendsBy3rdUI.class);
            intent3.putExtra("Invite_friends", intExtra);
            com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent3);
            a.a(this, bl2.axQ(), "com/tencent/mm/plugin/subapp/ui/pluginapp/AddMoreFriendsUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl2.pG(0));
            a.a(this, "com/tencent/mm/plugin/subapp/ui/pluginapp/AddMoreFriendsUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(29202);
            return true;
        } else if (!"find_friends_by_ww".equals(preference.mKey)) {
            AppMethodBeat.o(29202);
            return false;
        } else if (!WeChatBrands.Business.Entries.ContactNewFriendWeWeCom.checkAvailable(getContext())) {
            AppMethodBeat.o(29202);
            return true;
        } else {
            Intent putExtra = new Intent().putExtra("Search_Scene", 2).putExtra("MMActivity.OverrideEnterAnimation", 0).putExtra("MMActivity.OverrideExitAnimation", 0);
            Bundle bundle = null;
            if (Build.VERSION.SDK_INT >= 21 && !ao.isDarkMode()) {
                bundle = ActivityOptions.makeSceneTransitionAnimation(this, new Pair[0]).toBundle();
            }
            d.b(getContext(), ".ui.FTSAddWw", putExtra, bundle);
            AppMethodBeat.o(29202);
            return true;
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(29203);
        setMMTitle(R.string.dc);
        this.screen = getPreferenceScreen();
        AddFriendItemPreference addFriendItemPreference = new AddFriendItemPreference(getContext());
        addFriendItemPreference.setKey("find_friends_by_invite");
        addFriendItemPreference.setTitle(R.string.ceq);
        addFriendItemPreference.gr();
        addFriendItemPreference.setSummary(R.string.cer);
        if ((Util.getInt(com.tencent.mm.n.h.aqJ().getValue("InviteFriendsControlFlags"), 0) & 4) > 0) {
            this.screen.a(addFriendItemPreference, 4);
        }
        hideActionbarLine();
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.subapp.ui.pluginapp.AddMoreFriendsUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(29195);
                AddMoreFriendsUI.this.finish();
                AppMethodBeat.o(29195);
                return true;
            }
        });
        AppMethodBeat.o(29203);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(29204);
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(29204);
        return onKeyDown;
    }
}
