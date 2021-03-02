package com.tencent.mm.plugin.setting.ui.setting;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.n;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.xr;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.z;
import com.tencent.mm.n.h;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.i.a.af;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.plugin.image.d;
import com.tencent.mm.plugin.patmsg.PluginPatMsg;
import com.tencent.mm.plugin.setting.model.j;
import com.tencent.mm.plugin.wallet.wecoin.a.c;
import com.tencent.mm.plugin.wallet.wecoin.a.e;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.ErrorCode;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.ar;
import com.tencent.mm.storage.as;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.preference.HeadImgNewPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.tools.a;
import com.tencent.mm.vfs.o;

public class SettingsPersonalInfoUI extends MMPreference implements i, MStorageEx.IOnStorageChange {
    private j Ddp;
    private boolean jZU;
    private f screen;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void a(SettingsPersonalInfoUI settingsPersonalInfoUI) {
        AppMethodBeat.i(74318);
        settingsPersonalInfoUI.eTq();
        AppMethodBeat.o(74318);
    }

    static /* synthetic */ void a(SettingsPersonalInfoUI settingsPersonalInfoUI, boolean z) {
        AppMethodBeat.i(256590);
        settingsPersonalInfoUI.uu(z);
        AppMethodBeat.o(256590);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.cq;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(74308);
        super.onCreate(bundle);
        if (getIntent().getBooleanExtra("jumptoPat", false)) {
            eTr();
        }
        initView();
        if (getIntent().getBooleanExtra("intent_set_avatar", false)) {
            this.jZU = getIntent().getBooleanExtra("KEnterFromBanner", false);
            a.jRu.s(this);
        }
        g.azz().a(1191, this);
        AppMethodBeat.o(74308);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(74309);
        Log.d("MicroMsg.SettingsPersonalInfoUI", "SettingsPersonalInfoUI.onDestroy()");
        if (g.aAc()) {
            g.aAh().azQ().remove(this);
        }
        if (this.Ddp != null) {
            g.azz().a(this.Ddp);
        }
        g.azz().b(1191, this);
        super.onDestroy();
        AppMethodBeat.o(74309);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(74310);
        setMMTitle(R.string.gsc);
        g.aAh().azQ().add(this);
        this.screen = getPreferenceScreen();
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalInfoUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74303);
                SettingsPersonalInfoUI.this.hideVKB();
                SettingsPersonalInfoUI.this.finish();
                AppMethodBeat.o(74303);
                return true;
            }
        });
        AppMethodBeat.o(74310);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        final String str;
        AppMethodBeat.i(74311);
        eSZ();
        eTq();
        String str2 = (String) g.aAh().azQ().get(4, (Object) null);
        if (str2 != null && str2.length() > 0) {
            this.screen.bmg("settings_name").setSummary(l.c(this, str2));
        }
        Preference bmg = this.screen.bmg("settings_pat");
        if (!((PluginPatMsg) g.ah(PluginPatMsg.class)).isPatEnable() || ((b) g.af(b.class)).a(b.a.clicfg_pat_modify_suffix, 1) == 0) {
            this.screen.m38do("settings_pat", true);
        } else {
            this.screen.m38do("settings_pat", false);
            bmg.setSummary(l.c(this, (String) g.aAh().azQ().get(ar.a.USERINFO_PAT_SUFFIX_STRING_SYNC, (Object) null)));
        }
        this.screen.m38do("settings_address", Util.isOverseasUser(this) || WeChatBrands.Business.Entries.MeAvatarAddress.banned());
        if (((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).Vt()) {
            this.screen.m38do("settings_finder_recent_like", true);
        } else {
            uu(((aj) g.ah(aj.class)).getFinderSwitchApi().a(new af.a<Boolean>() {
                /* class com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalInfoUI.AnonymousClass6 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.plugin.i.a.af.a
                public final /* synthetic */ void bn(Boolean bool) {
                    AppMethodBeat.i(256587);
                    SettingsPersonalInfoUI.a(SettingsPersonalInfoUI.this, bool.booleanValue());
                    AppMethodBeat.o(256587);
                }
            }));
        }
        boolean z = WeChatBrands.Business.Entries.MeAvatarInvoiceTitle.banned() || !Util.nullAsFalse(Boolean.valueOf(g.aAh().azQ().getBoolean(ar.a.USERINFO_ABOUT_INVOICE_ENTRANCE_BOOLEAN, false)));
        this.screen.m38do("settings_invoice", z);
        if (z) {
            this.Ddp = new j();
            g.azz().a(this.Ddp, 0);
        }
        boolean z2 = ((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).Vt() || !((c) g.af(c.class)).dfq();
        final Preference bmg2 = this.screen.bmg("settings_wecoin");
        this.screen.m38do("settings_wecoin", z2);
        if (!z2) {
            long longValue = ((c) g.af(c.class)).hXF().longValue();
            Log.i("MicroMsg.SettingsPersonalInfoUI", "updateWeCoinEntry balance catch: %s", Long.valueOf(longValue));
            if (longValue > 0) {
                str = longValue + " " + getString(R.string.jdw);
            } else {
                str = "";
            }
            bmg2.setSummary(str);
            ((c) g.af(c.class)).a(new e<Long>() {
                /* class com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalInfoUI.AnonymousClass7 */

                /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
                @Override // com.tencent.mm.plugin.wallet.wecoin.a.e
                public final /* synthetic */ void onSuccess(Long l) {
                    AppMethodBeat.i(263555);
                    Long l2 = l;
                    String str = "";
                    if (l2.longValue() > 0) {
                        str = l2 + " " + SettingsPersonalInfoUI.this.getString(R.string.jdw);
                    }
                    bmg2.setSummary(str);
                    if (!str.equals(str)) {
                        SettingsPersonalInfoUI.c(SettingsPersonalInfoUI.this);
                    }
                    AppMethodBeat.o(263555);
                }

                @Override // com.tencent.mm.plugin.wallet.wecoin.a.e
                public final void p(int i2, int i3, String str) {
                }
            });
        }
        super.onResume();
        AppMethodBeat.o(74311);
    }

    private void eSZ() {
        AppMethodBeat.i(74313);
        Preference bmg = this.screen.bmg("settings_username");
        String aTZ = z.aTZ();
        String aTY = z.aTY();
        if (Util.isNullOrNil(aTZ)) {
            if (as.bjx(aTY)) {
                bmg.setSummary(getString(R.string.gs7));
            } else {
                bmg.setSummary(aTY);
            }
            if (!as.bjy(z.aTY()) && h.aqJ().getInt("EnableModAlias", 0) == 0) {
                bmg.alO(8);
            }
        } else {
            bmg.setSummary(aTZ);
            if (h.aqJ().getInt("EnableModAlias", 0) == 0) {
                bmg.alO(8);
            }
        }
        if (WeChatBrands.Business.Entries.MeAvatarWeChatId.restricted()) {
            bmg.alO(8);
        }
        AppMethodBeat.o(74313);
    }

    private void eTq() {
        AppMethodBeat.i(74314);
        HeadImgNewPreference headImgNewPreference = (HeadImgNewPreference) this.screen.bmg("settings_change_avatar");
        headImgNewPreference.bmf(z.aTY());
        headImgNewPreference.zHh = new View.OnClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalInfoUI.AnonymousClass2 */

            public final void onClick(View view) {
                AppMethodBeat.i(74304);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent(SettingsPersonalInfoUI.this, PreviewHdHeadImg.class);
                AppCompatActivity context = SettingsPersonalInfoUI.this.getContext();
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI$2", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(74304);
            }
        };
        AppMethodBeat.o(74314);
    }

    private void eTr() {
        AppMethodBeat.i(256588);
        Intent intent = new Intent();
        intent.setClass(this, SettingsModifyPatSuffixUI.class);
        intent.putExtras(getIntent());
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "goToSetPatSuffix", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "goToSetPatSuffix", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(256588);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(74315);
        Log.i("MicroMsg.SettingsPersonalInfoUI", "onAcvityResult requestCode:%d, resultCode:%d", Integer.valueOf(i2), Integer.valueOf(i3));
        if (i3 != -1) {
            if (i2 == 3 || i2 == 2 || i2 == 4) {
                new MMHandler(Looper.getMainLooper()).post(new Runnable() {
                    /* class com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalInfoUI.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(74305);
                        xr xrVar = new xr();
                        xrVar.edW.edY = true;
                        EventCenter.instance.publish(xrVar);
                        AppMethodBeat.o(74305);
                    }
                });
            }
            AppMethodBeat.o(74315);
            return;
        }
        switch (i2) {
            case 2:
                if (intent == null) {
                    AppMethodBeat.o(74315);
                    return;
                }
                Intent intent2 = new Intent();
                intent2.putExtra("CropImageMode", 1);
                intent2.putExtra("CropImage_Filter", true);
                p.aYn();
                intent2.putExtra("CropImage_OutputPath", com.tencent.mm.aj.e.M(z.aTY() + ".crop", true));
                intent2.putExtra("CropImage_ImgPath", (String) null);
                intent2.putExtra("CropImage_from_scene", 3);
                com.tencent.mm.plugin.setting.c.jRt.a(this, intent, intent2, d.aSY(), 4, (a.AbstractC2129a) null);
                AppMethodBeat.o(74315);
                return;
            case 3:
                String h2 = s.h(getApplicationContext(), intent, d.aSY());
                if (h2 == null) {
                    AppMethodBeat.o(74315);
                    return;
                }
                Intent intent3 = new Intent();
                intent3.putExtra("CropImageMode", 1);
                intent3.putExtra("CropImage_OutputPath", h2);
                intent3.putExtra("CropImage_ImgPath", h2);
                intent3.putExtra("CropImage_from_scene", 3);
                com.tencent.mm.plugin.setting.c.jRt.a(this, intent3, 4);
                AppMethodBeat.o(74315);
                return;
            case 4:
                new MMHandler(Looper.getMainLooper()).post(new Runnable() {
                    /* class com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalInfoUI.AnonymousClass4 */

                    public final void run() {
                        AppMethodBeat.i(74306);
                        xr xrVar = new xr();
                        xrVar.edW.edY = true;
                        EventCenter.instance.publish(xrVar);
                        AppMethodBeat.o(74306);
                    }
                });
                if (intent == null) {
                    AppMethodBeat.o(74315);
                    return;
                }
                String stringExtra = intent.getStringExtra("CropImage_OutputPath");
                String aTY = z.aTY();
                p.aYn();
                final Bitmap Mo = com.tencent.mm.aj.e.Mo(aTY);
                if (stringExtra == null) {
                    Log.e("MicroMsg.SettingsPersonalInfoUI", "crop picture failed");
                    AppMethodBeat.o(74315);
                    return;
                }
                Log.i("MicroMsg.SettingsPersonalInfoUI", "onActivityResult(CONTEXT_MENU_CROP_PICTURE)  file:%s, size:%d", stringExtra, Long.valueOf(new o(stringExtra).length()));
                new n(getContext(), stringExtra).G(new Runnable() {
                    /* class com.tencent.mm.plugin.setting.ui.setting.SettingsPersonalInfoUI.AnonymousClass5 */

                    public final void run() {
                        AppMethodBeat.i(74307);
                        Log.d("MicroMsg.SettingsPersonalInfoUI", "updateHeadImg hasUin:%b user:%s", Boolean.valueOf(g.aAc()), z.aTY());
                        if (g.aAc()) {
                            if (Mo != null) {
                                p.aYn();
                                PreviewHdHeadImg.e(Mo, com.tencent.mm.aj.e.M(z.aTY() + ".last", true));
                            }
                            bf.iDu.Km(com.tencent.mm.aj.c.Me(z.aTY()));
                        }
                        SettingsPersonalInfoUI.a(SettingsPersonalInfoUI.this);
                        if (SettingsPersonalInfoUI.this.jZU) {
                            com.tencent.mm.plugin.report.service.h.INSTANCE.a(ErrorCode.ERROR_OUTOF_MEMORY, 4, 4);
                        }
                        AppMethodBeat.o(74307);
                    }
                });
                AppMethodBeat.o(74315);
                return;
            default:
                AppMethodBeat.o(74315);
                return;
        }
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(74316);
        int nullAsInt = Util.nullAsInt(obj, 0);
        Log.d("MicroMsg.SettingsPersonalInfoUI", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i2), Integer.valueOf(nullAsInt), mStorageEx);
        if (mStorageEx != g.aAh().azQ() || nullAsInt <= 0) {
            Log.e("MicroMsg.SettingsPersonalInfoUI", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(nullAsInt), mStorageEx);
            AppMethodBeat.o(74316);
            return;
        }
        eSZ();
        AppMethodBeat.o(74316);
    }

    private void uu(boolean z) {
        AppMethodBeat.i(256589);
        if (!(!((aj) g.ah(aj.class)).getFinderSwitchApi().dCr()) || !z) {
            this.screen.m38do("settings_finder_recent_like", true);
            AppMethodBeat.o(256589);
            return;
        }
        this.screen.m38do("settings_finder_recent_like", false);
        AppMethodBeat.o(256589);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        String str;
        AppMethodBeat.i(74312);
        String str2 = preference.mKey;
        Log.d("MicroMsg.SettingsPersonalInfoUI", "key = ".concat(String.valueOf(str2)));
        if (str2.equals("settings_change_avatar")) {
            boolean s = com.tencent.mm.plugin.account.a.a.jRu.s(this);
            AppMethodBeat.o(74312);
            return s;
        } else if (str2.equals("settings_username")) {
            if (WeChatBrands.Business.Entries.MeAvatarWeChatId.restricted()) {
                AppMethodBeat.o(74312);
                return true;
            } else if (!Util.isNullOrNil(z.aTZ()) || !as.bjy(z.aTY()) || h.aqJ().getInt("EnableModAlias", 0) != 0) {
                if (h.aqJ().getInt("EnableModAlias", 0) != 0) {
                    Intent intent = new Intent(this, SettingsAliasUI.class);
                    intent.putExtra("WizardRootClass", SettingsPersonalInfoUI.class.getCanonicalName());
                    MMWizardActivity.ay(this, intent);
                }
                AppMethodBeat.o(74312);
                return true;
            } else {
                startActivity(SettingsCreateAliasUI.class);
                AppMethodBeat.o(74312);
                return true;
            }
        } else if (str2.equals("settings_name")) {
            Intent intent2 = new Intent();
            intent2.setClass(this, SettingsModifyNameUI.class);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "goTosetName", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "goTosetName", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(74312);
            return true;
        } else {
            if (str2.equals("settings_qrcode")) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11264, 2);
                AppCompatActivity context = getContext();
                com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(this, SelfQRCodeUI.class));
                com.tencent.mm.hellhoundlib.a.a.a(context, bl2.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl2.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            } else if (str2.equals("settings_more_info")) {
                com.tencent.mm.hellhoundlib.b.a bl3 = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(this, SettingsPersonalMoreUI.class));
                com.tencent.mm.hellhoundlib.a.a.a(this, bl3.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl3.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsPersonalInfoUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            } else if (str2.equals("settings_address")) {
                if (!WeChatBrands.Business.Entries.MeAvatarAddress.checkAvailable(getContext())) {
                    AppMethodBeat.o(74312);
                    return true;
                }
                Intent intent3 = new Intent();
                intent3.putExtra("launch_from_webview", false);
                com.tencent.mm.br.c.c(getContext(), "address", ".ui.WalletSelectAddrUI", intent3);
                AppMethodBeat.o(74312);
                return true;
            } else if (str2.equals("settings_invoice")) {
                if (!WeChatBrands.Business.Entries.MeAvatarInvoiceTitle.checkAvailable(getContext())) {
                    AppMethodBeat.o(74312);
                    return true;
                }
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(14199, 1);
                Intent intent4 = new Intent();
                intent4.putExtra("launch_from_webview", false);
                com.tencent.mm.br.c.c(getContext(), "address", ".ui.InvoiceListUI", intent4);
                AppMethodBeat.o(74312);
                return true;
            } else if (str2.equals("settings_pat")) {
                eTr();
            } else if (str2.equals("settings_wecoin")) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(21650, 0);
                Intent intent5 = new Intent();
                intent5.putExtra("launch_from_webview", false);
                com.tencent.mm.br.c.c(getContext(), "wallet", ".wecoin.ui.WeCoinRechargeView", intent5);
            } else if (str2.equals("settings_finder_recent_like")) {
                String str3 = (String) g.aAh().azQ().get(4, (Object) null);
                if (Util.isNullOrNil(str3)) {
                    str = "";
                } else {
                    str = str3;
                }
                ((aj) g.ah(aj.class)).getFinderUtilApi().b(this, z.aTY(), str, 92);
            }
            AppMethodBeat.o(74312);
            return false;
        }
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        boolean z = false;
        AppMethodBeat.i(74317);
        if (WeChatBrands.Business.Entries.MeAvatarInvoiceTitle.banned() || !Util.nullAsFalse(Boolean.valueOf(g.aAh().azQ().getBoolean(ar.a.USERINFO_ABOUT_INVOICE_ENTRANCE_BOOLEAN, false)))) {
            z = true;
        }
        this.screen.m38do("settings_invoice", z);
        AppMethodBeat.o(74317);
    }

    static /* synthetic */ void c(SettingsPersonalInfoUI settingsPersonalInfoUI) {
        AppMethodBeat.i(263556);
        if (settingsPersonalInfoUI.screen instanceof com.tencent.mm.ui.base.preference.h) {
            ((com.tencent.mm.ui.base.preference.h) settingsPersonalInfoUI.screen).notifyDataSetChanged();
        }
        AppMethodBeat.o(263556);
    }
}
