package com.tencent.mm.plugin.setting.ui.setting;

import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.contact.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.jsapi.k.r;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.newtips.a;
import com.tencent.mm.plugin.newtips.a.d;
import com.tencent.mm.plugin.newtips.a.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.btz;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.PluginTextPreference;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.thumbplayer.core.common.TPMediaCodecProfileLevel;
import java.util.ArrayList;
import java.util.HashMap;

public class SettingsPluginsUI extends MMPreference implements i {
    private static int Ddt = 1;
    private static HashMap<String, Integer> Ddu = new HashMap<String, Integer>() {
        /* class com.tencent.mm.plugin.setting.ui.setting.SettingsPluginsUI.AnonymousClass1 */

        {
            AppMethodBeat.i(74334);
            put("qqmail", 3);
            put("newsapp", 8);
            put("masssendapp", 9);
            put("feedsapp", 10);
            put("linkedinplugin", 13);
            put("facebookapp", 16);
            put("gh_43f2581f6fd6", 18);
            put("downloaderapp", 19);
            put("gh_3dfda90e39d6", 20);
            put("gh_f0a92aa7146c", 21);
            put("gh_579db1f2cf89", 22);
            AppMethodBeat.o(74334);
        }
    };
    private boolean Ddv;
    private boolean Ddw;
    private f screen;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static {
        AppMethodBeat.i(74342);
        AppMethodBeat.o(74342);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.cr;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(74336);
        super.onCreate(bundle);
        this.screen = getPreferenceScreen();
        initView();
        h.INSTANCE.a(14098, 5);
        h.INSTANCE.a(12846, Integer.valueOf(Ddt));
        ay.a.iDq.aL("gh_43f2581f6fd6", "");
        AppMethodBeat.o(74336);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(74337);
        super.onDestroy();
        AppMethodBeat.o(74337);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(74338);
        setMMTitle(R.string.gsm);
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsPluginsUI.AnonymousClass2 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74335);
                SettingsPluginsUI.this.hideVKB();
                SettingsPluginsUI.this.finish();
                AppMethodBeat.o(74335);
                return true;
            }
        });
        AppMethodBeat.o(74338);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        boolean z;
        AppMethodBeat.i(74339);
        super.onResume();
        as Kn = ((l) g.af(l.class)).aSN().Kn("gh_f0a92aa7146c");
        if (Kn != null) {
            z = c.oR(Kn.field_type);
        } else {
            z = false;
        }
        Log.i("MicroMsg.SettingsPluginsUI", "needGetReceipAssistPlugin result：%s", Boolean.valueOf(z));
        if (!z) {
            g.azz().a(2745, this);
            g.azz().a(new com.tencent.mm.plugin.setting.model.g(), 0);
        }
        if (1 != ((b) g.af(b.class)).a(b.a.clicfg_minishop_plugin_enabled, 0)) {
            Log.i("MicroMsg.SettingsPluginsUI", "fetchMiniShopHelperPluginShowStatusIfNeed, not need");
        } else {
            as Kn2 = ((l) g.af(l.class)).aSN().Kn("gh_579db1f2cf89");
            boolean z2 = Kn2 != null ? !c.oR(Kn2.field_type) : true;
            Log.i("MicroMsg.SettingsPluginsUI", "fetchMiniShopHelperPluginShowStatusIfNeed, needFetch: ".concat(String.valueOf(z2)));
            if (z2) {
                g.azz().a(4158, this);
                g.azz().a(new com.tencent.mm.plugin.setting.model.f(), 0);
            }
        }
        boY();
        AppMethodBeat.o(74339);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(74340);
        super.onPause();
        AppMethodBeat.o(74340);
    }

    private void boY() {
        boolean z = false;
        AppMethodBeat.i(256591);
        this.screen.removeAll();
        this.screen.c(new PreferenceSmallCategory(this));
        ArrayList<PluginPreference> arrayList = new ArrayList();
        ArrayList<PluginPreference> arrayList2 = new ArrayList();
        boolean aUM = z.aUM();
        if (!aUM) {
            aUM = Util.getInt(com.tencent.mm.n.h.aqJ().getValue("BindQQSwitch"), 1) == 1;
        }
        if (!aUM) {
            Log.i("MicroMsg.SettingsPluginsUI", "summerqq BindQQSwitch off");
        }
        if (!WeChatBrands.Business.Entries.HomePluginQQMail.banned() && aUM && com.tencent.mm.br.c.aZU("qqmail")) {
            PluginPreference pluginPreference = new PluginPreference(this);
            if (pluginPreference.aNc("qqmail")) {
                pluginPreference.setTitle(pluginPreference.CZj);
                if ((z.aUl() & 1) == 0) {
                    arrayList.add(pluginPreference);
                } else if (com.tencent.mm.aw.b.bdE()) {
                    arrayList2.add(pluginPreference);
                }
            }
        }
        if (!WeChatBrands.Business.Entries.HomePluginQQMail.banned() && com.tencent.mm.br.c.aZU("readerapp")) {
            PluginPreference pluginPreference2 = new PluginPreference(this);
            if (pluginPreference2.aNc("newsapp")) {
                pluginPreference2.setTitle(pluginPreference2.CZj);
                if ((z.aUl() & 524288) == 0) {
                    arrayList.add(pluginPreference2);
                } else if (com.tencent.mm.aw.b.bdE()) {
                    arrayList2.add(pluginPreference2);
                }
            }
        }
        if (!WeChatBrands.Business.Entries.MeSetSecurityFacebook.banned()) {
            PluginPreference pluginPreference3 = new PluginPreference(this);
            if (pluginPreference3.aNc("facebookapp")) {
                pluginPreference3.setTitle(pluginPreference3.CZj);
                if ((z.aUl() & 8192) == 0) {
                    arrayList.add(pluginPreference3);
                } else if (com.tencent.mm.aw.b.bdD()) {
                    arrayList2.add(pluginPreference3);
                }
            }
        }
        if (com.tencent.mm.br.c.aZU("masssend")) {
            PluginPreference pluginPreference4 = new PluginPreference(this);
            if (pluginPreference4.aNc("masssendapp")) {
                pluginPreference4.setTitle(pluginPreference4.CZj);
                if ((z.aUl() & 65536) == 0) {
                    arrayList.add(pluginPreference4);
                } else {
                    arrayList2.add(pluginPreference4);
                }
            }
        }
        PluginPreference pluginPreference5 = new PluginPreference(this);
        pluginPreference5.jT("gh_43f2581f6fd6", getString(R.string.c2n));
        pluginPreference5.setTitle(pluginPreference5.CZj);
        if (((com.tencent.mm.plugin.sport.a.b) g.af(com.tencent.mm.plugin.sport.a.b.class)).fmg()) {
            arrayList.add(pluginPreference5);
        } else {
            arrayList2.add(pluginPreference5);
        }
        a.exo();
        this.Ddw = e.Ty(d.ADb);
        pluginPreference5.CZm = this.Ddw;
        PluginPreference pluginPreference6 = new PluginPreference(this);
        pluginPreference6.jT("gh_3dfda90e39d6", getString(R.string.fow));
        pluginPreference6.setTitle(pluginPreference6.CZj);
        as Kn = ((l) g.af(l.class)).aSN().Kn("gh_3dfda90e39d6");
        if (Kn != null ? c.oR(Kn.field_type) : false) {
            arrayList.add(pluginPreference6);
        } else {
            arrayList2.add(pluginPreference6);
        }
        PluginPreference pluginPreference7 = new PluginPreference(this);
        pluginPreference7.jT("gh_f0a92aa7146c", getString(R.string.fov));
        pluginPreference7.setTitle(pluginPreference7.CZj);
        as Kn2 = ((l) g.af(l.class)).aSN().Kn("gh_f0a92aa7146c");
        if (Kn2 != null ? c.oR(Kn2.field_type) : false) {
            arrayList.add(pluginPreference7);
        } else {
            g.aAi();
            int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_SETTING_PLUGIN_SHOW_PAY_COLLECTION_FLAG_INT_SYNC, (Object) 0)).intValue();
            Log.i("MicroMsg.SettingsPluginsUI", "SETTING_PLUGIN_SHOW_PAY_COLLECTION Flag :%s", Integer.valueOf(intValue));
            if (intValue == 1) {
                arrayList2.add(pluginPreference7);
            }
        }
        if (1 != ((b) g.af(b.class)).a(b.a.clicfg_minishop_plugin_enabled, 0)) {
            Log.i("MicroMsg.SettingsPluginsUI", "addMiniShopHelperIfNeed, not need");
        } else {
            PluginPreference pluginPreference8 = new PluginPreference(this);
            pluginPreference8.jT("gh_579db1f2cf89", getString(R.string.dye));
            pluginPreference8.setTitle(pluginPreference8.CZj);
            as Kn3 = ((l) g.af(l.class)).aSN().Kn("gh_579db1f2cf89");
            if (Kn3 != null ? c.oR(Kn3.field_type) : false) {
                arrayList.add(pluginPreference8);
            } else {
                int intValue2 = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_SETTING_PLUGIN_SHOW_MINI_SHOP_HELPER_FLAG_INT_SYNC, (Object) 0)).intValue();
                Log.i("MicroMsg.SettingsPluginsUI", "addMiniShopHelperIfNeed, USERINFO_SETTING_PLUGIN_SHOW_MINI_SHOP_HELPER_FLAG_INT_SYNC: ".concat(String.valueOf(intValue2)));
                if (1 == intValue2) {
                    arrayList2.add(pluginPreference8);
                }
            }
        }
        String value = com.tencent.mm.n.h.aqJ().getValue("LinkedinPluginClose");
        if (Util.isNullOrNil(value) || Util.getInt(value, 0) == 0) {
            PluginPreference pluginPreference9 = new PluginPreference(this);
            if (pluginPreference9.aNc("linkedinplugin")) {
                pluginPreference9.setTitle(pluginPreference9.CZj);
                boolean z2 = (z.aUl() & TPMediaCodecProfileLevel.HEVCMainTierLevel62) == 0;
                if (!Util.isNullOrNil((String) g.aAh().azQ().get(286721, (Object) null))) {
                    z = true;
                }
                if (z2 && z) {
                    arrayList.add(pluginPreference9);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            PluginTextPreference pluginTextPreference = new PluginTextPreference(this);
            pluginTextPreference.OZn = R.raw.setting_plugin_install;
            pluginTextPreference.alN(R.string.gss);
            this.screen.c(pluginTextPreference);
        }
        String str = (String) g.aAh().azQ().get(ar.a.USERINFO_SETTING_PLUGIN_SWITCH_NAMES_STRING, "");
        PluginPreference pluginPreference10 = null;
        for (PluginPreference pluginPreference11 : arrayList) {
            pluginPreference11.sUb = 255;
            if (str.contains(pluginPreference11.CZi)) {
                pluginPreference11.CZm = true;
                if (pluginPreference10 == null) {
                    pluginPreference10 = pluginPreference11;
                }
            }
            this.screen.c(pluginPreference11);
        }
        this.screen.c(new PreferenceSmallCategory(this));
        PluginTextPreference pluginTextPreference2 = new PluginTextPreference(this);
        pluginTextPreference2.OZn = R.raw.setting_plugin_uninstall;
        pluginTextPreference2.alN(R.string.gsz);
        this.screen.c(pluginTextPreference2);
        if (arrayList2.isEmpty()) {
            this.screen.c(new PluginEmptyTextPreference(this));
        }
        for (PluginPreference pluginPreference12 : arrayList2) {
            pluginPreference12.sUb = r.CTRL_INDEX;
            if (str.contains(pluginPreference12.CZi)) {
                pluginPreference12.CZm = true;
                if (pluginPreference10 == null) {
                    pluginPreference10 = pluginPreference12;
                }
            }
            this.screen.c(pluginPreference12);
        }
        this.screen.c(new PreferenceSmallCategory(this));
        if (pluginPreference10 != null) {
            setSelection(this.screen.bmj(pluginPreference10.mKey));
        }
        AppMethodBeat.o(256591);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        btz btz;
        AppMethodBeat.i(256592);
        Log.i("MicroMsg.SettingsPluginsUI", "errType:" + i2 + " errCode:" + i3 + " errMsg:" + str + " scenetype:" + qVar.getType());
        if (qVar instanceof com.tencent.mm.plugin.setting.model.g) {
            g.azz().b(2745, this);
            if (i2 == 0 || i3 == 0) {
                com.tencent.mm.plugin.setting.model.g gVar = (com.tencent.mm.plugin.setting.model.g) qVar;
                if (gVar.CXL == null) {
                    btz = new btz();
                } else {
                    btz = gVar.CXL;
                }
                if (btz.MaG == 1) {
                    Log.i("MicroMsg.SettingsPluginsUI", "need to show unstall ReceipAssistPlugin");
                    g.aAh().azQ().set(ar.a.USERINFO_SETTING_PLUGIN_SHOW_PAY_COLLECTION_FLAG_INT_SYNC, (Object) 1);
                } else {
                    g.aAh().azQ().set(ar.a.USERINFO_SETTING_PLUGIN_SHOW_PAY_COLLECTION_FLAG_INT_SYNC, (Object) 0);
                }
                boY();
                AppMethodBeat.o(256592);
                return;
            }
            Log.e("MicroMsg.SettingsPluginsUI", "errType %d | errCode %d | errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
            AppMethodBeat.o(256592);
            return;
        }
        if (qVar instanceof com.tencent.mm.plugin.setting.model.f) {
            g.azz().b(4158, this);
            if (i2 == 0 || i3 == 0) {
                if (((com.tencent.mm.plugin.setting.model.f) qVar).CXK) {
                    Log.i("MicroMsg.SettingsPluginsUI", "need to show unstall MiniShopHelperPlugin");
                    g.aAh().azQ().set(ar.a.USERINFO_SETTING_PLUGIN_SHOW_MINI_SHOP_HELPER_FLAG_INT_SYNC, (Object) 1);
                } else {
                    g.aAh().azQ().set(ar.a.USERINFO_SETTING_PLUGIN_SHOW_MINI_SHOP_HELPER_FLAG_INT_SYNC, (Object) 0);
                }
                boY();
                AppMethodBeat.o(256592);
                return;
            }
            Log.e("MicroMsg.SettingsPluginsUI", "errType %d | errCode %d | errMsg %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        }
        AppMethodBeat.o(256592);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x012d  */
    @Override // com.tencent.mm.ui.base.preference.MMPreference
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f r10, com.tencent.mm.ui.base.preference.Preference r11) {
        /*
        // Method dump skipped, instructions count: 342
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.setting.ui.setting.SettingsPluginsUI.onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f, com.tencent.mm.ui.base.preference.Preference):boolean");
    }
}
