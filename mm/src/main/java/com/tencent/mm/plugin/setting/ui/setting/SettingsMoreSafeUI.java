package com.tencent.mm.plugin.setting.ui.setting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseIntArray;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.b.p;
import com.tencent.mm.g.a.ad;
import com.tencent.mm.g.a.hd;
import com.tencent.mm.g.a.ma;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.l;
import com.tencent.mm.model.z;
import com.tencent.mm.n.h;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.account.model.e;
import com.tencent.mm.plugin.account.ui.FacebookAuthUI;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.IconSwitchKeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.y.c;
import junit.framework.Assert;

public class SettingsMoreSafeUI extends MMPreference implements i, MStorageEx.IOnStorageChange {
    private SparseIntArray Dba = new SparseIntArray();
    private String Ddg = null;
    private String Ddh;
    private ProgressDialog gtM;
    private f screen;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SettingsMoreSafeUI() {
        AppMethodBeat.i(74264);
        this.Dba.put(0, R.string.go6);
        this.Dba.put(-82, R.string.gmd);
        this.Dba.put(-83, R.string.gma);
        this.Dba.put(-84, R.string.gmb);
        this.Dba.put(-85, R.string.gm5);
        this.Dba.put(-86, R.string.gmf);
        AppMethodBeat.o(74264);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.ck;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(74265);
        super.onCreate(bundle);
        initView();
        g.azz().a(256, this);
        AppMethodBeat.o(74265);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(74266);
        super.onDestroy();
        g.azz().b(256, this);
        AppMethodBeat.o(74266);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(74267);
        setMMTitle(R.string.gr7);
        this.screen = getPreferenceScreen();
        if (((Integer) g.aAh().azQ().get(9, (Object) 0)).intValue() != 0) {
            Log.i("MicroMsg.SettingsMoreSafeUI", "summerqq BindQQSwitch bindqq");
        } else if (Util.getInt(h.aqJ().getValue("BindQQSwitch"), 1) != 1) {
            this.screen.m38do("settings_uin", true);
            Log.i("MicroMsg.SettingsMoreSafeUI", "summerqq BindQQSwitch off");
        }
        this.Ddg = h.aqJ().getValue("CloseAcctUrl");
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsMoreSafeUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74261);
                SettingsMoreSafeUI.this.hideVKB();
                SettingsMoreSafeUI.this.finish();
                AppMethodBeat.o(74261);
                return true;
            }
        });
        AppMethodBeat.o(74267);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        AppMethodBeat.i(74268);
        eTm();
        eTj();
        eTl();
        String value = h.aqJ().getValue("ShowExportUserDataEntry");
        if (!Util.isNullOrNil(value)) {
            this.Ddh = value;
        } else {
            this.Ddh = "";
            this.screen.m38do("settings_dump_personal_data", true);
        }
        eTk();
        this.screen.e(this.screen.bmg("settings_about_domainmail"));
        if (Util.isNullOrNil(this.Ddg)) {
            this.screen.e(this.screen.bmg("settings_delete_account"));
        }
        super.onResume();
        AppMethodBeat.o(74268);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(74269);
        super.onPause();
        AppMethodBeat.o(74269);
    }

    private void eTj() {
        AppMethodBeat.i(74271);
        Preference bmg = this.screen.bmg("settings_email_addr");
        Assert.assertNotNull(bmg);
        String str = (String) g.aAh().azQ().get(5, (Object) null);
        Integer num = (Integer) g.aAh().azQ().get(7, (Object) null);
        if (num != null && (num.intValue() & 2) != 0) {
            bmg.setSummary(R.string.god);
            AppMethodBeat.o(74271);
        } else if (str != null) {
            bmg.setSummary(R.string.goc);
            AppMethodBeat.o(74271);
        } else {
            bmg.setSummary(R.string.gm4);
            AppMethodBeat.o(74271);
        }
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(74272);
        eTm();
        eTj();
        eTl();
        eTk();
        AppMethodBeat.o(74272);
    }

    private void eTk() {
        AppMethodBeat.i(74273);
        IconSwitchKeyValuePreference iconSwitchKeyValuePreference = (IconSwitchKeyValuePreference) this.screen.bmg("settings_phone_security");
        if (iconSwitchKeyValuePreference == null) {
            Log.e("MicroMsg.SettingsMoreSafeUI", "phone_security preference is null");
            AppMethodBeat.o(74273);
        } else if (ChannelUtil.isGPVersion()) {
            this.screen.m38do("settings_phone_security", true);
            AppMethodBeat.o(74273);
        } else if (c.axV().a(ar.a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC)) {
            iconSwitchKeyValuePreference.alF(0);
            AppMethodBeat.o(74273);
        } else {
            iconSwitchKeyValuePreference.alF(8);
            AppMethodBeat.o(74273);
        }
    }

    private void eTl() {
        AppMethodBeat.i(74274);
        Preference bmg = this.screen.bmg("settings_facebook");
        if (bmg == null) {
            Log.e("MicroMsg.SettingsMoreSafeUI", "updateFacebook Preference null");
            AppMethodBeat.o(74274);
        } else if (WeChatBrands.Business.Entries.MeSetSecurityFacebook.banned() || !z.aUC()) {
            this.screen.e(bmg);
            AppMethodBeat.o(74274);
        } else if (!z.aUF()) {
            bmg.setSummary(getString(R.string.gnr));
            AppMethodBeat.o(74274);
        } else {
            bmg.setSummary((String) g.aAh().azQ().get(65826, (Object) null));
            AppMethodBeat.o(74274);
        }
    }

    private void eTm() {
        AppMethodBeat.i(74275);
        Preference bmg = this.screen.bmg("settings_bind_qq");
        if (bmg == null) {
            Log.e("MicroMsg.SettingsMoreSafeUI", "updateUin Preference null");
            AppMethodBeat.o(74275);
            return;
        }
        int intValue = ((Integer) g.aAh().azQ().get(9, (Object) 0)).intValue();
        if (intValue == 0) {
            Log.i("MicroMsg.SettingsMoreSafeUI", "updateUin 0 Preference");
            if (Util.getInt(h.aqJ().getValue("BindQQSwitch"), 1) != 1) {
                this.screen.m38do("settings_uin", true);
            } else {
                bmg.setSummary(R.string.gnr);
            }
        } else {
            bmg.setSummary(new StringBuilder().append(new p(intValue)).toString());
        }
        if (WeChatBrands.Business.Entries.MeSetSecurityQQ.banned()) {
            this.screen.e(bmg);
        }
        AppMethodBeat.o(74275);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(74276);
        Log.d("MicroMsg.SettingsMoreSafeUI", "onSceneEnd " + i2 + " errCode " + i3 + " errMsg " + str + "  " + qVar.getType());
        if (this.gtM != null) {
            this.gtM.dismiss();
            this.gtM = null;
        }
        if (qVar.getType() == 256) {
            if (!(i2 == 0 && i3 == 0) && com.tencent.mm.plugin.setting.c.jRu.a(this, i2, i3, str)) {
                AppMethodBeat.o(74276);
                return;
            }
            int i4 = this.Dba.get(i3);
            String string = getString(R.string.go5, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
            if (i4 != 0) {
                try {
                    string = getString(i4);
                } catch (Exception e2) {
                    Log.e("MicroMsg.SettingsMoreSafeUI", "try get string by id %d, fail:%s", Integer.valueOf(i4), e2.getMessage());
                    Log.printErrStackTrace("MicroMsg.SettingsMoreSafeUI", e2, "", new Object[0]);
                }
            }
            com.tencent.mm.ui.base.h.cD(getContext(), string);
        }
        AppMethodBeat.o(74276);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(74277);
        super.onActivityResult(i2, i3, intent);
        if (i2 == 2) {
            switch (i3) {
                case -1:
                    if (!(g.azz() == null || g.azz().iMw == null)) {
                        g.azz().iMw.fz(false);
                    }
                    EventCenter.instance.publish(new hd());
                    com.tencent.mm.plugin.setting.c.jRu.Xe();
                    g.aAh().azQ().remove(this);
                    ma maVar = new ma();
                    maVar.dRA.status = 0;
                    maVar.dRA.bDZ = 3;
                    EventCenter.instance.publish(maVar);
                    ad adVar = new ad();
                    adVar.dDb.dDc = true;
                    EventCenter.instance.publish(adVar);
                    MMEntryLock.unlock("show_whatsnew");
                    l.s(this, true);
                    Intent intent2 = new Intent();
                    intent2.addFlags(67108864);
                    intent2.putExtra("Intro_Switch", true);
                    com.tencent.mm.plugin.setting.c.jRt.o(intent2, getContext());
                    t.Q(this, null);
                    finish();
                    break;
            }
        }
        AppMethodBeat.o(74277);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        String string;
        AppMethodBeat.i(74270);
        String str = preference.mKey;
        Log.i("MicroMsg.SettingsMoreSafeUI", str + " item has been clicked!");
        if (Util.isNullOrNil(str)) {
            AppMethodBeat.o(74270);
            return false;
        } else if (str.equals("settings_facebook")) {
            if (WeChatBrands.Business.Entries.MeSetSecurityFacebook.checkAvailable(this)) {
                startActivity(FacebookAuthUI.class);
            }
            AppMethodBeat.o(74270);
            return true;
        } else if (str.equals("settings_email_addr")) {
            Integer num = (Integer) g.aAh().azQ().get(7, (Object) null);
            boolean z = (num == null || (num.intValue() & 2) == 0) ? false : true;
            String str2 = (String) g.aAh().azQ().get(5, (Object) null);
            if (z || !Util.isNullOrNil(str2)) {
                a bl = new a().bl(new Intent(getContext(), SettingsModifyEmailAddrUI.class));
                com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsMoreSafeUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsMoreSafeUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            } else {
                if (this.gtM != null) {
                    Log.w("MicroMsg.SettingsMoreSafeUI", "do get email input, but tips dialog has not dismissed");
                    this.gtM.dismiss();
                    this.gtM = null;
                }
                com.tencent.mm.ui.base.h.a(getContext(), getString(R.string.gqr), Util.nullAs(t.dy(getContext()), ""), getString(R.string.gqs), 50, new h.b() {
                    /* class com.tencent.mm.plugin.setting.ui.setting.SettingsMoreSafeUI.AnonymousClass2 */

                    @Override // com.tencent.mm.ui.base.h.b
                    public final boolean onFinish(CharSequence charSequence) {
                        AppMethodBeat.i(74263);
                        if (!Util.isValidEmail(charSequence.toString())) {
                            com.tencent.mm.ui.base.h.cD(SettingsMoreSafeUI.this.getContext(), SettingsMoreSafeUI.this.getString(R.string.hvg));
                            AppMethodBeat.o(74263);
                            return false;
                        }
                        com.tencent.mm.plugin.setting.c.jRu.WZ();
                        final e eVar = new e(e.kir, charSequence.toString());
                        g.azz().a(eVar, 0);
                        SettingsMoreSafeUI settingsMoreSafeUI = SettingsMoreSafeUI.this;
                        AppCompatActivity context = SettingsMoreSafeUI.this.getContext();
                        SettingsMoreSafeUI.this.getString(R.string.zb);
                        settingsMoreSafeUI.gtM = com.tencent.mm.ui.base.h.a((Context) context, SettingsMoreSafeUI.this.getString(R.string.gns), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsMoreSafeUI.AnonymousClass2.AnonymousClass1 */

                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(74262);
                                g.azz().a(eVar);
                                AppMethodBeat.o(74262);
                            }
                        });
                        AppMethodBeat.o(74263);
                        return true;
                    }
                });
            }
            AppMethodBeat.o(74270);
            return true;
        } else if (str.equals("settings_bind_qq")) {
            if (WeChatBrands.Business.Entries.MeSetSecurityQQ.checkAvailable(this)) {
                com.tencent.mm.plugin.setting.c.jRt.g(new Intent(), this);
            }
            AppMethodBeat.o(74270);
            return true;
        } else {
            if (str.equals("settings_phone_security")) {
                Intent intent = new Intent();
                int i2 = c.axV().a(ar.a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC) ? 1 : 0;
                c.axV().b(ar.a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC, false);
                ((IconPreference) preference).alF(8);
                int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_DEVICE_PROTECT_SECURITY_STATUS_INT_SYNC, (Object) 0)).intValue();
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(10939, Integer.valueOf(intValue));
                if (Util.isServiceRunning(this, "com.tencent.server.back.BackEngine")) {
                    string = getString(R.string.frg, new Object[]{Integer.valueOf(intValue), 1, Integer.valueOf(i2)});
                } else {
                    string = getString(R.string.frg, new Object[]{Integer.valueOf(intValue), 0, Integer.valueOf(i2)});
                }
                intent.putExtra("rawUrl", string);
                intent.putExtra("show_bottom", false);
                intent.putExtra("showShare", false);
                com.tencent.mm.br.c.b(getContext(), "webview", ".ui.tools.WebViewUI", intent);
            } else if (str.equals("settings_delete_account")) {
                Intent intent2 = new Intent();
                if (!Util.isNullOrNil(this.Ddg)) {
                    intent2.putExtra("rawUrl", this.Ddg + "&lang=" + LocaleUtil.getCurrentLanguage(getContext()));
                    intent2.putExtra("showShare", true);
                    intent2.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
                    com.tencent.mm.br.c.b(getContext(), "webview", ".ui.tools.WebViewUI", intent2, 2);
                }
            } else if (str.equals("settings_dump_personal_data")) {
                Intent intent3 = new Intent();
                if (!Util.isNullOrNil(this.Ddh)) {
                    intent3.putExtra("rawUrl", this.Ddh);
                    intent3.putExtra("showShare", false);
                    intent3.putExtra("needRedirect", false);
                    intent3.putExtra("neverGetA8Key", false);
                    intent3.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
                    com.tencent.mm.br.c.b(getContext(), "webview", ".ui.tools.WebViewUI", intent3);
                }
            }
            AppMethodBeat.o(74270);
            return false;
        }
    }
}
