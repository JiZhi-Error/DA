package com.tencent.mm.plugin.setting.ui.setting;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.us;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.game.api.b;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.teenmode.a.b;
import com.tencent.mm.plugin.websearch.api.i;
import com.tencent.mm.pluginsdk.i.d;
import com.tencent.mm.protocal.protobuf.bfx;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.a;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.preference.h;
import java.util.HashMap;
import java.util.Map;

public class SettingsManageFindMoreUI extends MMPreference {
    private HashMap<Integer, Integer> Dct = new HashMap<>();
    private HashMap<Integer, Integer> Dcu = new HashMap<>();
    private int Dcv;
    private HashMap<Integer, Integer> kbt = new HashMap<>();
    private long qAb;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SettingsManageFindMoreUI() {
        AppMethodBeat.i(74209);
        AppMethodBeat.o(74209);
    }

    static /* synthetic */ void a(SettingsManageFindMoreUI settingsManageFindMoreUI, boolean z) {
        AppMethodBeat.i(164134);
        settingsManageFindMoreUI.b(z, 2097152, 50);
        AppMethodBeat.o(164134);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(74210);
        super.onCreate(bundle);
        this.qAb = z.aUd();
        this.Dcv = z.aUl();
        Log.i("MicroMsg.SettingsManageFindMoreUI", "onCreate extStatus %d, pluginFlag %d", Long.valueOf(this.qAb), Integer.valueOf(this.Dcv));
        initView();
        AppMethodBeat.o(74210);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public h createAdapter(SharedPreferences sharedPreferences) {
        AppMethodBeat.i(74211);
        a aVar = new a(this, getListView(), sharedPreferences);
        AppMethodBeat.o(74211);
        return aVar;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.cj;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        boolean z;
        long j2 = 0;
        long j3 = 1;
        int i2 = 0;
        AppMethodBeat.i(74212);
        if (!(preference instanceof CheckBoxPreference)) {
            AppMethodBeat.o(74212);
        } else {
            final CheckBoxPreference checkBoxPreference = (CheckBoxPreference) preference;
            String str = preference.mKey;
            Log.i("MicroMsg.SettingsManageFindMoreUI", "click pref key %s", str);
            int i3 = -1;
            if (str.equals("settings_sns_switch")) {
                U(checkBoxPreference.isChecked(), 32768);
                i3 = 0;
            } else if (str.equals("settings_scan_switch")) {
                if (!WeChatBrands.Business.Entries.GlobalScan.checkAvailable(this)) {
                    AppMethodBeat.o(74212);
                } else {
                    b(checkBoxPreference.isChecked(), 1048576, 49);
                    i3 = 1;
                }
            } else if (str.equals("settings_search_switch")) {
                if (!WeChatBrands.Business.Entries.MeSetDiscoverySearch.checkAvailable(this)) {
                    AppMethodBeat.o(74212);
                } else if (!checkBoxPreference.isChecked()) {
                    if (((i) g.af(i.class)).b(this, new Runnable() {
                        /* class com.tencent.mm.plugin.setting.ui.setting.SettingsManageFindMoreUI.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(74206);
                            checkBoxPreference.setChecked(false);
                            SettingsManageFindMoreUI.a(SettingsManageFindMoreUI.this, checkBoxPreference.isChecked());
                            AppMethodBeat.o(74206);
                        }
                    })) {
                        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsManageFindMoreUI.AnonymousClass2 */

                            public final void run() {
                                AppMethodBeat.i(74207);
                                checkBoxPreference.setChecked(true);
                                AppMethodBeat.o(74207);
                            }
                        }, 500);
                    }
                    i3 = 3;
                } else {
                    b(checkBoxPreference.isChecked(), 2097152, 50);
                    i3 = 3;
                }
            } else if (str.equals("settings_shopping_switch")) {
                if (!WeChatBrands.Business.Entries.MeSetDiscoveryShop.checkAvailable(this)) {
                    AppMethodBeat.o(74212);
                } else {
                    i3 = 6;
                    b(checkBoxPreference.isChecked(), 4194304, 51);
                }
            } else if (str.equals("settings_game_switch")) {
                if (!WeChatBrands.Business.Entries.MeSetDiscoveryGame.checkAvailable(this)) {
                    AppMethodBeat.o(74212);
                } else {
                    b(checkBoxPreference.isChecked(), 8388608, 52);
                    com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.INSTANCE;
                    if (!checkBoxPreference.isChecked()) {
                        j2 = 1;
                    }
                    hVar.idkeyStat(848, j2, 1, false);
                    i3 = 7;
                }
            } else if (str.equals("settings_miniprogram_switch")) {
                if (!WeChatBrands.Business.Entries.MeSetDiscoveryAppbrand.checkAvailable(this)) {
                    AppMethodBeat.o(74212);
                } else {
                    i3 = 8;
                    b(checkBoxPreference.isChecked(), 16777216, 53);
                }
            } else if (str.equals("settings_wechatout_switch")) {
                if (!WeChatBrands.Business.Entries.MeSetDiscoveryWeChatOut.checkAvailable(this)) {
                    AppMethodBeat.o(74212);
                } else {
                    i3 = 9;
                    b(checkBoxPreference.isChecked(), 33554432, 54);
                }
            } else if (str.equals("settings_shake_switch")) {
                if (!WeChatBrands.Business.Entries.MeSetDiscoveryShake.checkAvailable(this)) {
                    AppMethodBeat.o(74212);
                } else {
                    i3 = 2;
                    U(checkBoxPreference.isChecked(), 256);
                }
            } else if (str.equals("settings_nearby_switch")) {
                if (!WeChatBrands.Business.Entries.MeSetDiscoveryNearby.checkAvailable(this)) {
                    AppMethodBeat.o(74212);
                } else {
                    i3 = 4;
                    U(checkBoxPreference.isChecked(), 512);
                }
            } else if (str.equals("settings_nearby_live_friend_switch")) {
                if (!WeChatBrands.Business.Entries.MeSetDiscoveryNearbyLiveFriends.checkAvailable(this)) {
                    AppMethodBeat.o(74212);
                } else {
                    b(checkBoxPreference.isChecked(), 70368744177664L, 61);
                    f preferenceScreen = getPreferenceScreen();
                    if (!checkBoxPreference.isChecked()) {
                        z = true;
                    } else {
                        z = false;
                    }
                    preferenceScreen.m38do("settings_nearby_live_friend_person_switch", z);
                    com.tencent.mm.plugin.setting.a.a aVar = com.tencent.mm.plugin.setting.a.a.CYr;
                    if (!checkBoxPreference.isChecked()) {
                        j3 = 0;
                    }
                    com.tencent.mm.plugin.setting.a.a.ak(12, j3);
                    i3 = 5;
                }
            } else if (str.equals("settings_nearby_live_friend_person_switch")) {
                if (!WeChatBrands.Business.Entries.MeSetDiscoveryNearbyLiveFriendsPerson.checkAvailable(this)) {
                    AppMethodBeat.o(74212);
                } else {
                    i3 = 12;
                    U(checkBoxPreference.isChecked(), 512);
                    com.tencent.mm.plugin.setting.a.a aVar2 = com.tencent.mm.plugin.setting.a.a.CYr;
                    if (!checkBoxPreference.isChecked()) {
                        j3 = 0;
                    }
                    com.tencent.mm.plugin.setting.a.a.ak(13, j3);
                }
            } else if (str.equals("settings_look_switch")) {
                if (!WeChatBrands.Business.Entries.MeSetDiscoveryLooks.checkAvailable(this)) {
                    AppMethodBeat.o(74212);
                } else {
                    ((com.tencent.mm.plugin.welab.a.a.a) g.af(com.tencent.mm.plugin.welab.a.a.a.class)).cR("labs_browse", checkBoxPreference.isChecked());
                    if (checkBoxPreference.isChecked()) {
                        this.qAb &= -67108865;
                        i3 = 10;
                    } else {
                        this.qAb |= 67108864;
                        i3 = 10;
                    }
                }
            } else if (str.equals("settings_finder_switch")) {
                if (!WeChatBrands.Business.Entries.MeSetDiscoveryChannels.checkAvailable(this)) {
                    AppMethodBeat.o(74212);
                } else {
                    i3 = 11;
                    b(checkBoxPreference.isChecked(), 34359738368L, 57);
                }
            }
            if (checkBoxPreference.isChecked()) {
                i2 = 1;
            }
            if (i3 >= 0) {
                this.Dcu.put(Integer.valueOf(i3), Integer.valueOf(i2));
            }
            AppMethodBeat.o(74212);
        }
        return true;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        AppMethodBeat.i(74213);
        setMMTitle(R.string.gq2);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsManageFindMoreUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74208);
                SettingsManageFindMoreUI.this.finish();
                AppMethodBeat.o(74208);
                return true;
            }
        });
        CheckBoxPreference checkBoxPreference = (CheckBoxPreference) getPreferenceScreen().bmg("settings_sns_switch");
        checkBoxPreference.OZw = false;
        boolean IL = IL(32768);
        Log.i("MicroMsg.SettingsManageFindMoreUI", "openSns %s", Boolean.valueOf(IL));
        if (IL) {
            checkBoxPreference.setChecked(true);
            this.Dct.put(0, 1);
        } else {
            checkBoxPreference.setChecked(false);
            this.Dct.put(0, 0);
        }
        boolean showFinderEntry = ((aj) g.ah(aj.class)).showFinderEntry();
        Log.i("MicroMsg.SettingsManageFindMoreUI", "showFinder %s", Boolean.valueOf(showFinderEntry));
        if (!((b) g.af(b.class)).Vt() || ((b) g.af(b.class)).dxW() != 2) {
            z = false;
        } else {
            z = true;
        }
        if (!showFinderEntry || z) {
            getPreferenceScreen().m38do("settings_finder_switch", true);
        } else {
            CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) getPreferenceScreen().bmg("settings_finder_switch");
            checkBoxPreference2.OZw = false;
            if (IK(34359738368L)) {
                checkBoxPreference2.setChecked(false);
                this.Dct.put(11, 0);
            } else {
                checkBoxPreference2.setChecked(true);
                this.Dct.put(11, 1);
            }
            a(WeChatBrands.Business.Entries.MeSetDiscoveryChannels, "settings_finder_switch");
        }
        CheckBoxPreference checkBoxPreference3 = (CheckBoxPreference) getPreferenceScreen().bmg("settings_scan_switch");
        checkBoxPreference3.OZw = false;
        if (IK(1048576)) {
            checkBoxPreference3.setChecked(false);
            this.Dct.put(1, 0);
        } else {
            checkBoxPreference3.setChecked(true);
            this.Dct.put(1, 1);
        }
        a(WeChatBrands.Business.Entries.GlobalScan, "settings_scan_switch");
        CheckBoxPreference checkBoxPreference4 = (CheckBoxPreference) getPreferenceScreen().bmg("settings_shake_switch");
        checkBoxPreference4.OZw = false;
        boolean IL2 = IL(256);
        Log.i("MicroMsg.SettingsManageFindMoreUI", "openShake %s", Boolean.valueOf(IL2));
        if (IL2) {
            checkBoxPreference4.setChecked(true);
            this.Dct.put(2, 1);
        } else {
            checkBoxPreference4.setChecked(false);
            this.Dct.put(2, 0);
        }
        a(WeChatBrands.Business.Entries.MeSetDiscoveryShake, "settings_shake_switch");
        if (((b) g.af(b.class)).Vt()) {
            getPreferenceScreen().m38do("settings_shake_switch", true);
        } else {
            getPreferenceScreen().m38do("settings_shake_switch", false);
        }
        CheckBoxPreference checkBoxPreference5 = (CheckBoxPreference) getPreferenceScreen().bmg("settings_look_switch");
        checkBoxPreference5.OZw = false;
        if (!IK(67108864)) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (com.tencent.mm.aw.b.Pi((String) g.aAh().azQ().get(274436, (Object) null))) {
            getPreferenceScreen().m38do("settings_look_switch", true);
            Log.i("MicroMsg.SettingsManageFindMoreUI", "european user");
            z3 = false;
            z2 = false;
        } else {
            z3 = true;
        }
        boolean Vt = ((b) g.af(b.class)).Vt();
        Log.i("MicroMsg.SettingsManageFindMoreUI", "isInExperiment %s ,openLook %s, isTeenMode:%s", Boolean.valueOf(z3), Boolean.valueOf(z2), Boolean.valueOf(Vt));
        if (z3 && z2 && !Vt) {
            checkBoxPreference5.setChecked(true);
            this.Dct.put(10, 1);
        } else if (!z3 || Vt) {
            getPreferenceScreen().m38do("settings_look_switch", true);
        } else {
            getPreferenceScreen().m38do("settings_look_switch", false);
            checkBoxPreference5.setChecked(false);
            this.Dct.put(10, 0);
        }
        a(WeChatBrands.Business.Entries.MeSetDiscoveryLooks, "settings_look_switch");
        CheckBoxPreference checkBoxPreference6 = (CheckBoxPreference) getPreferenceScreen().bmg("settings_search_switch");
        checkBoxPreference6.OZw = false;
        if (IK(2097152)) {
            checkBoxPreference6.setChecked(false);
            this.Dct.put(3, 0);
        } else {
            checkBoxPreference6.setChecked(true);
            this.Dct.put(3, 1);
        }
        a(WeChatBrands.Business.Entries.MeSetDiscoverySearch, "settings_search_switch");
        if (((aj) g.ah(aj.class)).getFinderUtilApi().dDf()) {
            getPreferenceScreen().m38do("settings_nearby_switch", true);
            CheckBoxPreference checkBoxPreference7 = (CheckBoxPreference) getPreferenceScreen().bmg("settings_nearby_live_friend_switch");
            checkBoxPreference7.OZw = false;
            CheckBoxPreference checkBoxPreference8 = (CheckBoxPreference) getPreferenceScreen().bmg("settings_nearby_live_friend_person_switch");
            checkBoxPreference8.OZw = false;
            boolean z6 = !IK(70368744177664L);
            boolean IL3 = IL(512);
            Log.i("MicroMsg.SettingsManageFindMoreUI", "openNearbyLiveFriends:%s openNearbyLiveFriendsPerson:%s", Boolean.valueOf(z6), Boolean.valueOf(IL3));
            if (z6) {
                checkBoxPreference7.setChecked(true);
                this.Dct.put(5, 1);
                getPreferenceScreen().m38do("settings_nearby_live_friend_person_switch", false);
            } else {
                checkBoxPreference7.setChecked(false);
                this.Dct.put(5, 0);
                getPreferenceScreen().m38do("settings_nearby_live_friend_person_switch", true);
            }
            if (IL3) {
                checkBoxPreference8.setChecked(true);
                this.Dct.put(4, 1);
            } else {
                checkBoxPreference8.setChecked(false);
                this.Dct.put(4, 0);
            }
            a(WeChatBrands.Business.Entries.MeSetDiscoveryNearbyLiveFriends, "settings_nearby_live_friend_switch");
            a(WeChatBrands.Business.Entries.MeSetDiscoveryNearbyLiveFriendsPerson, "settings_nearby_live_friend_person_switch");
            if (((b) g.af(b.class)).Vt()) {
                getPreferenceScreen().m38do("settings_nearby_live_friend_switch", true);
                getPreferenceScreen().m38do("settings_nearby_live_friend_person_switch", true);
            } else {
                getPreferenceScreen().m38do("settings_nearby_live_friend_switch", false);
            }
        } else {
            getPreferenceScreen().m38do("settings_nearby_live_friend_switch", true);
            getPreferenceScreen().m38do("settings_nearby_live_friend_person_switch", true);
            CheckBoxPreference checkBoxPreference9 = (CheckBoxPreference) getPreferenceScreen().bmg("settings_nearby_switch");
            checkBoxPreference9.OZw = false;
            boolean IL4 = IL(512);
            Log.i("MicroMsg.SettingsManageFindMoreUI", "openNearby %s", Boolean.valueOf(IL4));
            if (IL4) {
                checkBoxPreference9.setChecked(true);
                this.Dct.put(4, 1);
            } else {
                checkBoxPreference9.setChecked(false);
                this.Dct.put(4, 0);
            }
            a(WeChatBrands.Business.Entries.MeSetDiscoveryNearby, "settings_nearby_switch");
            if (((b) g.af(b.class)).Vt()) {
                getPreferenceScreen().m38do("settings_nearby_switch", true);
            } else {
                getPreferenceScreen().m38do("settings_nearby_switch", false);
            }
        }
        d.a aVar = d.JYo;
        if (aVar == null || !aVar.fsY()) {
            z4 = false;
        } else {
            z4 = true;
        }
        Log.i("MicroMsg.SettingsManageFindMoreUI", "showShopping %s", Boolean.valueOf(z4));
        boolean Vt2 = ((b) g.af(b.class)).Vt();
        CheckBoxPreference checkBoxPreference10 = (CheckBoxPreference) getPreferenceScreen().bmg("settings_shopping_switch");
        checkBoxPreference10.OZw = false;
        if (!z4 || Vt2) {
            getPreferenceScreen().m38do("settings_shopping_switch", true);
        } else {
            getPreferenceScreen().m38do("settings_shopping_switch", false);
        }
        if (IK(4194304)) {
            checkBoxPreference10.setChecked(false);
            this.Dct.put(6, 0);
        } else {
            checkBoxPreference10.setChecked(true);
            this.Dct.put(6, 1);
        }
        a(WeChatBrands.Business.Entries.MeSetDiscoveryShop, "settings_shopping_switch");
        com.tencent.mm.plugin.game.api.b dSQ = b.a.dSQ();
        CheckBoxPreference checkBoxPreference11 = (CheckBoxPreference) getPreferenceScreen().bmg("settings_game_switch");
        checkBoxPreference11.OZw = false;
        boolean Vt3 = ((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).Vt();
        if (dSQ == null || !dSQ.dSE() || Vt3) {
            getPreferenceScreen().m38do("settings_game_switch", true);
        } else if (IK(8388608)) {
            checkBoxPreference11.setChecked(false);
            this.Dct.put(7, 0);
        } else {
            checkBoxPreference11.setChecked(true);
            this.Dct.put(7, 1);
        }
        a(WeChatBrands.Business.Entries.MeSetDiscoveryGame, "settings_game_switch");
        us usVar = new us();
        usVar.eaU.eaW = true;
        EventCenter.instance.publish(usVar);
        boolean z7 = usVar.eaV.eaX;
        boolean z8 = ((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).Vt() && ((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).dxW() == 2;
        Log.i("MicroMsg.SettingsManageFindMoreUI", "shouldShowMiniProgram %s, isTeenModeAndNotAccessRight:%s", Boolean.valueOf(z7), Boolean.valueOf(z8));
        CheckBoxPreference checkBoxPreference12 = (CheckBoxPreference) getPreferenceScreen().bmg("settings_miniprogram_switch");
        checkBoxPreference12.OZw = false;
        if (!z7 || z8) {
            getPreferenceScreen().m38do("settings_miniprogram_switch", true);
        } else if (IK(16777216)) {
            checkBoxPreference12.setChecked(false);
            this.Dct.put(8, 0);
        } else {
            checkBoxPreference12.setChecked(true);
            this.Dct.put(8, 1);
        }
        a(WeChatBrands.Business.Entries.MeSetDiscoveryAppbrand, "settings_miniprogram_switch");
        CheckBoxPreference checkBoxPreference13 = (CheckBoxPreference) getPreferenceScreen().bmg("settings_wechatout_switch");
        if (com.tencent.mm.n.h.aqJ().getInt("WCOEntranceSwitch", 0) > 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        Log.i("MicroMsg.SettingsManageFindMoreUI", "showWeChatOut %s", Boolean.valueOf(z5));
        if (z5) {
            checkBoxPreference13.OZw = false;
            if (IK(33554432)) {
                checkBoxPreference13.setChecked(false);
                this.Dct.put(9, 0);
            } else {
                checkBoxPreference13.setChecked(true);
                this.Dct.put(9, 1);
            }
        } else {
            getPreferenceScreen().m38do("settings_wechatout_switch", true);
        }
        a(WeChatBrands.Business.Entries.MeSetDiscoveryWeChatOut, "settings_wechatout_switch");
        Preference bmg = getPreferenceScreen().bmg("settings_switch_bottom_tip");
        if (com.tencent.mm.aw.b.Pi((String) g.aAh().azQ().get(274436, (Object) null))) {
            bmg.setTitle(R.string.gq6);
        }
        getPreferenceScreen().notifyDataSetChanged();
        AppMethodBeat.o(74213);
    }

    private void a(final WeChatBrands.Business.Entries entries, String str) {
        AppMethodBeat.i(256547);
        if (entries.restricted()) {
            if (entries.banned()) {
                getPreferenceScreen().m38do(str, true);
                AppMethodBeat.o(256547);
                return;
            }
            CheckBoxPreference checkBoxPreference = (CheckBoxPreference) getPreferenceScreen().bmg(str);
            checkBoxPreference.gLz();
            checkBoxPreference.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.setting.ui.setting.SettingsManageFindMoreUI.AnonymousClass4 */

                public final void onClick(View view) {
                    AppMethodBeat.i(256546);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsManageFindMoreUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    entries.checkAvailable(view.getContext());
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsManageFindMoreUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(256546);
                }
            });
        }
        AppMethodBeat.o(256547);
    }

    private void b(boolean z, long j2, int i2) {
        AppMethodBeat.i(164133);
        Log.i("MicroMsg.SettingsManageFindMoreUI", "switch ext change : open = " + z + " item value = " + j2 + " functionId = " + i2);
        if (z) {
            this.qAb &= -1 ^ j2;
        } else {
            this.qAb |= j2;
        }
        this.kbt.put(Integer.valueOf(i2), Integer.valueOf(z ? 1 : 2));
        AppMethodBeat.o(164133);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void finish() {
        AppMethodBeat.i(74215);
        super.finish();
        Log.i("MicroMsg.SettingsManageFindMoreUI", "oplog extstatus:" + this.qAb + ",pluginFlag:" + this.Dcv);
        g.aAh().azQ().set(147457, Long.valueOf(this.qAb));
        g.aAh().azQ().set(34, Integer.valueOf(this.Dcv));
        for (Map.Entry<Integer, Integer> entry : this.kbt.entrySet()) {
            int intValue = entry.getKey().intValue();
            int intValue2 = entry.getValue().intValue();
            bfx bfx = new bfx();
            bfx.LPB = intValue;
            bfx.BsD = intValue2;
            ((l) g.af(l.class)).aSM().d(new k.a(23, bfx));
            Log.d("MicroMsg.SettingsManageFindMoreUI", "switch  " + intValue + " " + intValue2);
        }
        this.kbt.clear();
        ((l) g.af(l.class)).aSM().d(new com.tencent.mm.ba.l("", "", "", "", "", "", "", "", this.Dcv, "", ""));
        bUV();
        AppMethodBeat.o(74215);
    }

    private boolean IK(long j2) {
        return (this.qAb & j2) != 0;
    }

    private boolean IL(long j2) {
        return (((long) this.Dcv) & j2) == 0;
    }

    private void U(boolean z, int i2) {
        AppMethodBeat.i(74216);
        Log.i("MicroMsg.SettingsManageFindMoreUI", "switch plugin flag, open %s, flag %d", Boolean.valueOf(z), Integer.valueOf(i2));
        if (!z) {
            this.Dcv |= i2;
            AppMethodBeat.o(74216);
            return;
        }
        this.Dcv &= i2 ^ -1;
        AppMethodBeat.o(74216);
    }

    private void bUV() {
        AppMethodBeat.i(74217);
        for (Integer num : this.Dcu.keySet()) {
            int intValue = num.intValue();
            if (this.Dct.containsKey(Integer.valueOf(intValue)) && this.Dct.get(Integer.valueOf(intValue)) != this.Dcu.get(Integer.valueOf(intValue))) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(15185, Integer.valueOf(intValue), this.Dcu.get(Integer.valueOf(intValue)), 1);
                if (intValue == 0) {
                    if (this.Dcu.get(Integer.valueOf(intValue)).intValue() == 0) {
                        g.aAh().azQ().set(ar.a.USERINFO_SNS_ENTRY_SWITCH_INT, (Object) -1);
                    } else if (this.Dcu.get(Integer.valueOf(intValue)).intValue() == 1) {
                        g.aAh().azQ().set(ar.a.USERINFO_SNS_ENTRY_SWITCH_INT, (Object) 1);
                    }
                }
            }
        }
        AppMethodBeat.o(74217);
    }
}
