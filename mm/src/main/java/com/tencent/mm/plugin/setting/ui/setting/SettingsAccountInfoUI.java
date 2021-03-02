package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseIntArray;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.g.a.bm;
import com.tencent.mm.g.a.si;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ay;
import com.tencent.mm.model.z;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.IconSwitchKeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.PluginTextPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.y.c;

public class SettingsAccountInfoUI extends MMPreference implements MStorageEx.IOnStorageChange {
    private static final String DaV = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2m) + "/cgi-bin/readtemplate?check=false&t=weixin_faq_verifyaccount&platform=android&lang=%s");
    private View DaW;
    private TextView DaX;
    private EditText DaY;
    private boolean DaZ;
    private SparseIntArray Dba = new SparseIntArray();
    private f screen;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SettingsAccountInfoUI() {
        AppMethodBeat.i(74075);
        this.Dba.put(0, R.string.go6);
        this.Dba.put(-82, R.string.gmd);
        this.Dba.put(-83, R.string.gma);
        this.Dba.put(-84, R.string.gmb);
        this.Dba.put(-85, R.string.gm5);
        this.Dba.put(-86, R.string.gmf);
        AppMethodBeat.o(74075);
    }

    static {
        AppMethodBeat.i(256510);
        AppMethodBeat.o(256510);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.cf;
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean autoRefresh() {
        return true;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(74076);
        super.onCreate(bundle);
        initView();
        g.aAh().azQ().add(this);
        AppMethodBeat.o(74076);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(74077);
        super.onDestroy();
        g.aAh().azQ().remove(this);
        AppMethodBeat.o(74077);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(74078);
        setMMTitle(R.string.gn2);
        this.screen = getPreferenceScreen();
        this.DaW = View.inflate(this, R.layout.bqa, null);
        this.DaX = (TextView) this.DaW.findViewById(R.id.hku);
        this.DaX.setText(getString(R.string.gpb));
        this.DaY = (EditText) this.DaW.findViewById(R.id.hkt);
        this.DaY.setInputType(129);
        if (WeChatBrands.Business.Entries.MeSetSecurityVoicePrint.banned() || Util.getInt(h.aqJ().getValue("VoiceprintEntry"), 0) != 1) {
            this.screen.m38do("settings_voiceprint_title", true);
        } else if (!g.aAc()) {
            Log.e("MicroMsg.SettingsAccountInfoUI", "update voiceprint dot, account not ready!");
            AppMethodBeat.o(74078);
            return;
        } else {
            IconPreference iconPreference = (IconPreference) this.screen.bmg("settings_voiceprint_title");
            if (((Boolean) g.aAh().azQ().get(ar.a.USERINFO_VOICEPRINT_SETTING_ACCOUNT_INFO_NEW_SHOW_BOOLEAN, Boolean.FALSE)).booleanValue() && (g.aAh().azQ().getInt(40, 0) & 131072) == 0) {
                iconPreference.gY(getString(R.string.x4), R.drawable.amr);
                iconPreference.alD(0);
                Log.i("MicroMsg.SettingsAccountInfoUI", "show voiceprint dot");
                this.screen.notifyDataSetChanged();
            }
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsAccountInfoUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74074);
                SettingsAccountInfoUI.this.hideVKB();
                SettingsAccountInfoUI.this.finish();
                AppMethodBeat.o(74074);
                return true;
            }
        });
        AppMethodBeat.o(74078);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        Bitmap bitmap;
        AppMethodBeat.i(74079);
        eSZ();
        eTb();
        this.DaZ = false;
        IconPreference iconPreference = (IconPreference) this.screen.bmg("settings_more_safe");
        if (c.axV().b(ar.a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC, ar.a.NEW_BANDAGE_WATCHER_SETTINGS_MORE_SAFE_STRING_SYNC)) {
            iconPreference.alF(0);
        } else {
            iconPreference.alF(8);
        }
        eTa();
        eTc();
        this.screen.m38do("settings_facedect_title", true);
        PluginTextPreference pluginTextPreference = (PluginTextPreference) this.screen.bmg("settings_about_vusertitle");
        SelfVuserPreference selfVuserPreference = (SelfVuserPreference) this.screen.bmg("settings_about_vuserinfo");
        Preference bmg = this.screen.bmg("settings_about_vuser_about");
        int nullAsNil = Util.nullAsNil((Integer) g.aAh().azQ().get(66049, (Object) null));
        if (nullAsNil != 0) {
            pluginTextPreference.visibility = 8;
            pluginTextPreference.alN(R.string.bhj);
            if (ay.a.iDs != null) {
                bitmap = BackwardSupportUtil.BitmapFactory.decodeFile(ay.a.iDs.rV(nullAsNil), 2.0f);
            } else {
                bitmap = null;
            }
            selfVuserPreference.drawable = new BitmapDrawable(getResources(), bitmap);
            selfVuserPreference.text = (String) g.aAh().azQ().get(66050, (Object) null);
        } else {
            this.screen.e(pluginTextPreference);
            this.screen.e(selfVuserPreference);
            this.screen.e(bmg);
        }
        super.onResume();
        AppMethodBeat.o(74079);
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(74081);
        eSZ();
        eTb();
        eTa();
        eTc();
        AppMethodBeat.o(74081);
    }

    private void eSZ() {
        AppMethodBeat.i(74082);
        Preference bmg = this.screen.bmg("settings_username");
        String aTY = z.aTY();
        String aTZ = z.aTZ();
        if (Util.isNullOrNil(aTZ)) {
            if (as.bjx(aTY)) {
                bmg.setSummary(getString(R.string.gs7));
            } else {
                bmg.setSummary(aTY);
            }
            if (!as.bjy(z.aTY()) && h.aqJ().getInt("EnableModAlias", 0) == 0) {
                bmg.alO(8);
                AppMethodBeat.o(74082);
                return;
            }
        } else {
            bmg.setSummary(aTZ);
            if (h.aqJ().getInt("EnableModAlias", 0) == 0) {
                bmg.alO(8);
            }
        }
        AppMethodBeat.o(74082);
    }

    private void eTa() {
        AppMethodBeat.i(74083);
        if (this.screen.bmg("settings_manage_login_device") == null) {
            Log.e("MicroMsg.SettingsAccountInfoUI", "safedevicesate preference is null");
            AppMethodBeat.o(74083);
            return;
        }
        this.screen.m38do("settings_manage_login_device", false);
        AppMethodBeat.o(74083);
    }

    private void eTb() {
        AppMethodBeat.i(74084);
        IconSwitchKeyValuePreference iconSwitchKeyValuePreference = (IconSwitchKeyValuePreference) this.screen.bmg("settings_mobile");
        if (iconSwitchKeyValuePreference == null) {
            Log.e("MicroMsg.SettingsAccountInfoUI", "updateMobile Preference null");
            AppMethodBeat.o(74084);
            return;
        }
        String str = (String) g.aAh().azQ().get(6, (Object) null);
        Log.d("MicroMsg.SettingsAccountInfoUI", "mobile :".concat(String.valueOf(str)));
        if (str == null || str.length() <= 0) {
            iconSwitchKeyValuePreference.setSummary(getString(R.string.gnr));
            iconSwitchKeyValuePreference.alK(0);
            AppMethodBeat.o(74084);
            return;
        }
        iconSwitchKeyValuePreference.setSummary(str);
        iconSwitchKeyValuePreference.alK(1);
        AppMethodBeat.o(74084);
    }

    private void eTc() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(74085);
        bm bmVar = new bm();
        EventCenter.instance.publish(bmVar);
        if (!bmVar.dEH.dEI || !bmVar.dEH.dEJ || !bmVar.dEH.dEK) {
            z = false;
        } else {
            z = true;
        }
        Log.i("MicroMsg.SettingsAccountInfoUI", "check is support soter, isSupportSoter: %b, isSupportFP: %b, isSystemHasFPEnrolled: %b", Boolean.valueOf(bmVar.dEH.dEI), Boolean.valueOf(bmVar.dEH.dEJ), Boolean.valueOf(bmVar.dEH.dEK));
        f fVar = this.screen;
        if (z) {
            z2 = false;
        }
        fVar.m38do("settings_fingerprint_title", z2);
        AppMethodBeat.o(74085);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        AppMethodBeat.i(74080);
        String str = preference.mKey;
        Log.i("MicroMsg.SettingsAccountInfoUI", str + " item has been clicked!");
        z.aTY();
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(74080);
            return false;
        }
        if (str.equals("settings_username")) {
            if (Util.isNullOrNil(z.aTZ()) && as.bjy(z.aTY()) && h.aqJ().getInt("EnableModAlias", 0) == 0) {
                startActivity(SettingsCreateAliasUI.class);
                AppMethodBeat.o(74080);
                return true;
            } else if (h.aqJ().getInt("EnableModAlias", 0) != 0) {
                Intent intent = new Intent(this, SettingsAliasUI.class);
                intent.putExtra("WizardRootClass", SettingsAccountInfoUI.class.getCanonicalName());
                MMWizardActivity.ay(this, intent);
            }
        }
        if (str.equals("settings_mobile")) {
            Intent intent2 = new Intent(this, BindMContactIntroUI.class);
            intent2.putExtra("key_upload_scene", 4);
            MMWizardActivity.ay(this, intent2);
            AppMethodBeat.o(74080);
            return true;
        }
        if (str.equals("settings_about_vuser_about")) {
            Util.jump(getContext(), String.format(DaV, LocaleUtil.getApplicationLanguage()));
        } else if (str.equals("settings_independent_password")) {
            Intent intent3 = new Intent();
            intent3.putExtra("kintent_hint", getString(R.string.gr1));
            startActivity(RegByMobileSetPwdUI.class, intent3);
        } else if (str.equals("settings_manage_login_device")) {
            com.tencent.mm.br.c.V(this, "account", ".security.ui.MySafeDeviceListUI");
        } else if (str.equals("settings_security_center")) {
            String value = h.aqJ().getValue("WeChatSafeCenterUrl");
            Log.i("MicroMsg.SettingsAccountInfoUI", "safe center url %s", value);
            if (Util.isNullOrNil(value)) {
                value = getString(R.string.j1x) + LocaleUtil.getApplicationLanguage();
            }
            AppCompatActivity context = getContext();
            Intent intent4 = new Intent();
            intent4.putExtra("rawUrl", value);
            intent4.putExtra("showShare", true);
            intent4.putExtra("show_bottom", false);
            intent4.putExtra("needRedirect", false);
            intent4.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
            intent4.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
            com.tencent.mm.br.c.b(context, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", intent4);
        } else if (str.equals("settings_voiceprint_title")) {
            if (Util.getInt(h.aqJ().getValue("VoiceprintEntry"), 0) == 1 && (g.aAh().azQ().getInt(40, 0) & 131072) == 0) {
                g.aAh().azQ().set(ar.a.USERINFO_VOICEPRINT_SETTING_ACCOUNT_INFO_NEW_SHOW_BOOLEAN, Boolean.FALSE);
                ((IconPreference) this.screen.bmg("settings_voiceprint_title")).alD(8);
                this.screen.notifyDataSetChanged();
                Log.i("MicroMsg.SettingsAccountInfoUI", "unset setting account info new show");
            }
            com.tencent.mm.br.c.V(getContext(), "voiceprint", "com.tencent.mm.plugin.voiceprint.ui.SettingsVoicePrintUI");
        } else if (str.equals("settings_facedect_title")) {
            si siVar = new si();
            siVar.dYX.context = this;
            EventCenter.instance.publish(siVar);
            boolean z = siVar.dYY.dYN;
            Log.i("MicroMsg.SettingsAccountInfoUI", "hy: is start to face settings succ: %b", Boolean.valueOf(z));
            if (!z) {
                u.makeText(getContext(), getString(R.string.c6n), 0).show();
            }
        } else if (str.equals("settings_trust_friend")) {
            startActivity(SettingsTrustFriendUI.class);
        } else if (str.equals("settings_more_safe")) {
            c.axV().c(ar.a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC, ar.a.NEW_BANDAGE_WATCHER_SETTINGS_MORE_SAFE_STRING_SYNC);
            startActivity(SettingsMoreSafeUI.class);
        }
        AppMethodBeat.o(74080);
        return false;
    }
}
