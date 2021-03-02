package com.tencent.mm.plugin.setting.ui.setting;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aj.n;
import com.tencent.mm.aj.p;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ab;
import com.tencent.mm.g.a.ad;
import com.tencent.mm.g.a.fb;
import com.tencent.mm.g.a.hd;
import com.tencent.mm.g.a.ma;
import com.tencent.mm.kernel.g;
import com.tencent.mm.kernel.i;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.ae;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.n.h;
import com.tencent.mm.network.af;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.account.bind.ui.BindMContactIntroUI;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.ui.RegByMobileSetPwdUI;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.pluginsdk.ui.a;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.ChannelUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMEntryLock;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.preference.ButtonPreference;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.IconSwitchKeyValuePreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.SwitchKeyValuePreference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.tools.a;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.y.a;
import com.tencent.mm.y.c;
import com.tencent.soter.core.biometric.FaceManager;
import java.util.ArrayList;

@i
public class SettingsUI extends MMPreference implements MStorageEx.IOnStorageChange {
    private ProgressDialog Dav = null;
    private MTimerHandler Daw;
    private com.tencent.mm.ak.i Dax = null;
    private PersonalPreference DeC = null;
    private com.tencent.mm.ak.i DeD = null;
    private a.AbstractC2176a DeE = new a.AbstractC2176a() {
        /* class com.tencent.mm.plugin.setting.ui.setting.SettingsUI.AnonymousClass1 */

        @Override // com.tencent.mm.y.a.AbstractC2176a
        public final void D(int i2, String str) {
            AppMethodBeat.i(74495);
            if (i2 == 262145 || i2 == 262157 || i2 == 262158 || i2 == 262164) {
                SettingsUI.a(SettingsUI.this);
            }
            AppMethodBeat.o(74495);
        }

        @Override // com.tencent.mm.y.a.AbstractC2176a
        public final void b(ar.a aVar) {
            AppMethodBeat.i(74496);
            if (aVar != null && aVar == ar.a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC) {
                SettingsUI.b(SettingsUI.this);
            }
            AppMethodBeat.o(74496);
        }
    };
    private Dialog DeF = null;
    private d DeG;
    private CheckBox DeH;
    private com.tencent.mm.ak.i DeI = null;
    private MTimerHandler cve;
    private MTimerHandler jer = null;
    private e nVN;
    private com.tencent.mm.ak.i onSceneEndCallback = null;
    private f screen;
    private View yTE;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SettingsUI() {
        AppMethodBeat.i(74528);
        AppMethodBeat.o(74528);
    }

    static /* synthetic */ void a(SettingsUI settingsUI) {
        AppMethodBeat.i(74548);
        settingsUI.eSU();
        AppMethodBeat.o(74548);
    }

    static /* synthetic */ void b(SettingsUI settingsUI) {
        AppMethodBeat.i(74549);
        settingsUI.eTB();
        AppMethodBeat.o(74549);
    }

    static /* synthetic */ boolean c(SettingsUI settingsUI) {
        AppMethodBeat.i(74550);
        boolean eTF = settingsUI.eTF();
        AppMethodBeat.o(74550);
        return eTF;
    }

    static /* synthetic */ boolean d(SettingsUI settingsUI) {
        AppMethodBeat.i(74551);
        boolean eTG = settingsUI.eTG();
        AppMethodBeat.o(74551);
        return eTG;
    }

    static /* synthetic */ void e(SettingsUI settingsUI) {
        AppMethodBeat.i(74552);
        settingsUI.eTE();
        AppMethodBeat.o(74552);
    }

    static /* synthetic */ void i(SettingsUI settingsUI) {
        AppMethodBeat.i(74554);
        settingsUI.uv(false);
        AppMethodBeat.o(74554);
    }

    static /* synthetic */ void p(SettingsUI settingsUI) {
        AppMethodBeat.i(74556);
        settingsUI.eTI();
        AppMethodBeat.o(74556);
    }

    static /* synthetic */ void z(SettingsUI settingsUI) {
        AppMethodBeat.i(74558);
        settingsUI.eTx();
        AppMethodBeat.o(74558);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return R.xml.cd;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(74529);
        super.onCreate(bundle);
        initView();
        g.aAh().azQ().add(this);
        c.axV().a(this.DeE);
        if (Util.getInt(h.aqJ().getValue("VoiceprintEntry"), 0) == 1 && (g.aAh().azQ().getInt(40, 0) & 131072) == 0) {
            g.aAh().azQ().set(ar.a.USERINFO_VOICEPRINT_MORE_TAB_DOT_SHOW_BOOLEAN, Boolean.FALSE);
            Log.i("MicroMsg.SettingsUI", "unset more tab dot");
        }
        AppMethodBeat.o(74529);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(74530);
        if (g.aAc()) {
            g.aAh().azQ().remove(this);
            c.axV().b(this.DeE);
        }
        if (this.onSceneEndCallback != null) {
            g.azz().b(281, this.onSceneEndCallback);
        }
        if (this.Dax != null) {
            g.azz().b(255, this.Dax);
        }
        if (this.DeI != null) {
            g.azz().b(281, this.DeI);
        }
        super.onDestroy();
        AppMethodBeat.o(74530);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(74531);
        Log.v("MicroMsg.SettingsUI", "settings handle");
        switch (i2) {
            case 2:
                if (intent == null) {
                    AppMethodBeat.o(74531);
                    return;
                }
                String h2 = s.h(getApplicationContext(), intent, com.tencent.mm.plugin.image.d.aSY());
                if (h2 == null) {
                    AppMethodBeat.o(74531);
                    return;
                }
                Intent intent2 = new Intent();
                intent2.putExtra("CropImageMode", 1);
                p.aYn();
                intent2.putExtra("CropImage_OutputPath", com.tencent.mm.aj.e.M(z.aTY(), true));
                intent2.putExtra("CropImage_ImgPath", h2);
                com.tencent.mm.plugin.setting.c.jRt.a(this, intent, intent2, com.tencent.mm.plugin.image.d.aSY(), 4, (a.AbstractC2129a) null);
                AppMethodBeat.o(74531);
                return;
            case 3:
                String h3 = s.h(getApplicationContext(), intent, com.tencent.mm.plugin.image.d.aSY());
                if (h3 == null) {
                    AppMethodBeat.o(74531);
                    return;
                }
                Intent intent3 = new Intent();
                intent3.putExtra("CropImageMode", 1);
                intent3.putExtra("CropImage_OutputPath", h3);
                intent3.putExtra("CropImage_ImgPath", h3);
                com.tencent.mm.plugin.setting.c.jRt.a(getContext(), intent3, 4);
                AppMethodBeat.o(74531);
                return;
            case 4:
                if (intent == null) {
                    AppMethodBeat.o(74531);
                    return;
                }
                String stringExtra = intent.getStringExtra("CropImage_OutputPath");
                if (stringExtra == null) {
                    Log.e("MicroMsg.SettingsUI", "crop picture failed");
                } else {
                    new n(getContext(), stringExtra).G(null);
                }
                super.onActivityResult(i2, i3, intent);
                AppMethodBeat.o(74531);
                return;
            case 5:
                if (i3 == -1) {
                    eTx();
                }
                AppMethodBeat.o(74531);
                return;
            default:
                AppMethodBeat.o(74531);
                return;
        }
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(74532);
        super.onPause();
        if (g.aAc()) {
            g.aAk().postAtFrontOfQueueToWorker(new Runnable() {
                /* class com.tencent.mm.plugin.setting.ui.setting.SettingsUI.AnonymousClass12 */

                public final void run() {
                    AppMethodBeat.i(74508);
                    g.aAh().azQ().gBI();
                    AppMethodBeat.o(74508);
                }
            });
        }
        AppMethodBeat.o(74532);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        AppMethodBeat.i(74533);
        PersonalPreference personalPreference = (PersonalPreference) this.screen.bmg("settings_account");
        if (personalPreference != null) {
            String aTY = z.aTY();
            personalPreference.iKs = null;
            personalPreference.CZh = -1;
            personalPreference.uNR = aTY;
            if (personalPreference.tlo != null) {
                a.b.c(personalPreference.tlo, personalPreference.uNR);
            }
        }
        if (((b) g.af(b.class)).a(b.a.clicfg_settings_device_entry, 0) != 1) {
            fb fbVar = new fb();
            EventCenter.instance.publish(fbVar);
            if (!fbVar.dIu.dGX) {
                this.screen.e(this.screen.bmg("settings_about_device"));
            }
        }
        eTB();
        IconSwitchKeyValuePreference iconSwitchKeyValuePreference = (IconSwitchKeyValuePreference) this.screen.bmg("settings_teen_mode");
        if (iconSwitchKeyValuePreference == null) {
            Log.e("MicroMsg.SettingsUI", "updateTeenMode Preference null");
        } else if (((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).fvr()) {
            this.screen.m38do("settings_teen_mode", true);
            Log.i("MicroMsg.SettingsUI", "need hide teen-mode entrance");
        } else {
            this.screen.m38do("settings_teen_mode", false);
            boolean Vt = ((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).Vt();
            Log.d("MicroMsg.SettingsUI", "isTeenModeEnable :".concat(String.valueOf(Vt)));
            if (Vt) {
                iconSwitchKeyValuePreference.setSummary(getString(R.string.glo));
            } else {
                iconSwitchKeyValuePreference.setSummary(getString(R.string.gmj));
            }
            iconSwitchKeyValuePreference.alK(-1);
        }
        eTD();
        eSU();
        eTC();
        IconPreference iconPreference = (IconPreference) this.screen.bmg("settings_welab");
        com.tencent.mm.plugin.welab.a.a.c cVar = (com.tencent.mm.plugin.welab.a.a.c) g.af(com.tencent.mm.plugin.welab.a.a.c.class);
        if (cVar.gjj()) {
            iconPreference.alD(0);
            iconPreference.gY(getString(R.string.x4), R.drawable.amr);
        } else {
            iconPreference.alD(8);
        }
        if (!cVar.gjk()) {
            iconPreference.la(8, -1);
        } else if (cVar.gji()) {
            iconPreference.la(0, R.drawable.b1a);
        } else {
            iconPreference.la(0, R.raw.welab_icon_grey);
        }
        if (WeChatBrands.Business.Entries.MeSetPlugin.banned()) {
            this.screen.m38do("settings_welab", true);
        }
        Log.v("MicroMsg.SettingsUI", "on resume");
        super.onResume();
        AppMethodBeat.o(74533);
    }

    private void eTB() {
        AppMethodBeat.i(74534);
        IconPreference iconPreference = (IconPreference) this.screen.bmg("settings_account_info");
        if (iconPreference == null) {
            Log.e("MicroMsg.SettingsUI", "safedevicesate preference is null");
            AppMethodBeat.o(74534);
            return;
        }
        iconPreference.alI(8);
        if (c.axV().a(ar.a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC, 266257)) {
            iconPreference.alF(0);
        } else {
            iconPreference.alF(8);
        }
        if (Util.getInt(h.aqJ().getValue("VoiceprintEntry"), 0) == 1) {
            if (!((Boolean) g.aAh().azQ().get(ar.a.USERINFO_VOICEPRINT_SETTING_ACCOUNT_INFO_DOT_SHOW_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                iconPreference.alD(8);
                iconPreference.gY("", -1);
            } else if ((g.aAh().azQ().getInt(40, 0) & 131072) == 0) {
                iconPreference.gY(getString(R.string.x4), R.drawable.amr);
                iconPreference.alD(0);
                Log.i("MicroMsg.SettingsUI", "show voiceprint dot");
            }
            this.screen.notifyDataSetChanged();
        }
        AppMethodBeat.o(74534);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(74535);
        setMMTitle(R.string.gvb);
        this.screen = getPreferenceScreen();
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsUI.AnonymousClass23 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(74522);
                SettingsUI.this.finish();
                AppMethodBeat.o(74522);
                return true;
            }
        });
        this.nVN = new e((Context) this, 1, false);
        this.nVN.HLX = new o.f() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsUI.AnonymousClass24 */

            @Override // com.tencent.mm.ui.base.o.f
            public final void onCreateMMMenu(m mVar) {
                AppMethodBeat.i(74523);
                if (mVar.gKQ()) {
                    mVar.aS(1, R.string.en_, R.raw.menu_logout_single);
                    mVar.aS(2, R.string.en8, R.raw.menu_close_wechat);
                }
                AppMethodBeat.o(74523);
            }
        };
        this.nVN.PGl = new e.b() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsUI.AnonymousClass25 */

            @Override // com.tencent.mm.ui.widget.a.e.b
            public final void onDismiss() {
            }
        };
        this.nVN.HLY = new o.g() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsUI.AnonymousClass26 */

            @Override // com.tencent.mm.ui.base.o.g
            public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                AppMethodBeat.i(74524);
                switch (menuItem.getItemId()) {
                    case 1:
                        SettingsUI.c(SettingsUI.this);
                        AppMethodBeat.o(74524);
                        return;
                    case 2:
                        SettingsUI.d(SettingsUI.this);
                        break;
                }
                AppMethodBeat.o(74524);
            }
        };
        setToTop(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsUI.AnonymousClass27 */

            public final void onClick(View view) {
                AppMethodBeat.i(74525);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/setting/ui/setting/SettingsUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                SettingsUI.this.onSetToTop();
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsUI$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(74525);
            }
        });
        eTD();
        eSU();
        eTC();
        ButtonPreference buttonPreference = (ButtonPreference) this.screen.bmg("settings_switch_account");
        buttonPreference.OXm = false;
        buttonPreference.gX(getString(R.string.guu), getContext().getResources().getColor(R.color.FG_0));
        ButtonPreference buttonPreference2 = (ButtonPreference) this.screen.bmg("settings_logout");
        buttonPreference2.OXm = false;
        buttonPreference2.gX(getString(R.string.gpt), getContext().getResources().getColor(R.color.FG_0));
        AppMethodBeat.o(74535);
    }

    @Override // com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange
    public void onNotifyChange(int i2, MStorageEx mStorageEx, Object obj) {
        AppMethodBeat.i(74536);
        int nullAsInt = Util.nullAsInt(obj, 0);
        Log.d("MicroMsg.SettingsUI", "onNotifyChange event:%d obj:%d stg:%s", Integer.valueOf(i2), Integer.valueOf(nullAsInt), mStorageEx);
        if (mStorageEx != g.aAh().azQ() || nullAsInt <= 0) {
            Log.e("MicroMsg.SettingsUI", "onNotifyChange error obj:%d stg:%s", Integer.valueOf(nullAsInt), mStorageEx);
            AppMethodBeat.o(74536);
            return;
        }
        if (4 == nullAsInt) {
            g.aAh().azQ().get(2, (Object) null);
            g.aAh().azQ().get(4, (Object) null);
        }
        if (6 == nullAsInt) {
            eTD();
            AppMethodBeat.o(74536);
            return;
        }
        if (64 == nullAsInt) {
            eTB();
        }
        AppMethodBeat.o(74536);
    }

    private void eSU() {
        int i2;
        int i3 = 0;
        AppMethodBeat.i(74537);
        IconPreference iconPreference = (IconPreference) this.screen.bmg("settings_about_micromsg");
        boolean nullAs = Util.nullAs(Boolean.valueOf(c.axV().cO(262145, 266243)), false);
        boolean cP = c.axV().cP(262157, 266262);
        boolean cP2 = c.axV().cP(262164, 266269);
        if (ChannelUtil.isNokiaAol) {
            iconPreference.gY("", -1);
            iconPreference.alD(8);
        } else if (nullAs) {
            iconPreference.alD(0);
            iconPreference.gY(getString(R.string.x4), R.drawable.amr);
        } else if (cP) {
            iconPreference.alF(0);
        } else if (((com.tencent.mm.plugin.updater.a.a) g.ah(com.tencent.mm.plugin.updater.a.a.class)).hasAboutWechatRedDot()) {
            iconPreference.alF(0);
        } else if (cP2) {
            iconPreference.alF(0);
        } else {
            iconPreference.alF(8);
            iconPreference.gY("", -1);
            iconPreference.alD(8);
        }
        boolean cP3 = c.axV().cP(262158, 266265);
        IconPreference iconPreference2 = (IconPreference) this.screen.bmg("settings_about_system");
        if (cP3) {
            i2 = 0;
        } else {
            i2 = 8;
        }
        iconPreference2.alF(i2);
        com.tencent.mm.plugin.newtips.a.exo();
        if (!com.tencent.mm.plugin.newtips.a.e.Ty(com.tencent.mm.plugin.newtips.a.d.ADb)) {
            i3 = 8;
        }
        iconPreference2.alF(i3);
        com.tencent.mm.cc.c.gvE();
        iconPreference2.alF(8);
        AppMethodBeat.o(74537);
    }

    private void eTC() {
        AppMethodBeat.i(74538);
        IconPreference iconPreference = (IconPreference) this.screen.bmg("settings_about_privacy");
        if (iconPreference != null) {
            if (((Integer) g.aAh().azQ().get(ar.a.USERINFO_PRIVATY_RED_DOT_WILL_SHOW_ID_INT, (Object) 0)).intValue() > ((Integer) g.aAh().azQ().get(ar.a.USERINFO_PRIVATY_RED_DOT_DID_SHOW_ID_INT, (Object) 0)).intValue()) {
                iconPreference.alF(0);
                AppMethodBeat.o(74538);
                return;
            }
            iconPreference.alF(8);
        }
        AppMethodBeat.o(74538);
    }

    private void eTD() {
        AppMethodBeat.i(74539);
        l.a bnZ = l.bnZ();
        SwitchKeyValuePreference switchKeyValuePreference = (SwitchKeyValuePreference) this.screen.bmg("settings_bind_mobile");
        if (switchKeyValuePreference != null) {
            switchKeyValuePreference.BE(bnZ == l.a.SUCC || bnZ == l.a.SUCC_UNLOAD);
            switchKeyValuePreference.setSummary((bnZ == l.a.SUCC || bnZ == l.a.SUCC_UNLOAD) ? R.string.gsp : R.string.gso);
        }
        AppMethodBeat.o(74539);
    }

    private void eTE() {
        AppMethodBeat.i(74541);
        Intent intent = new Intent(this, SettingsSwitchAccountUI.class);
        intent.putExtra("key_scene", 0);
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "jumpToSwitchAccount", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "jumpToSwitchAccount", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(74541);
    }

    private void eTx() {
        AppMethodBeat.i(74542);
        Log.i("MicroMsg.SettingsUI", "oneliang logout mm");
        com.tencent.mm.plugin.setting.c.jRu.Xe();
        g.aAh().azQ().remove(this);
        ma maVar = new ma();
        maVar.dRA.status = 0;
        maVar.dRA.bDZ = 0;
        EventCenter.instance.publish(maVar);
        ad adVar = new ad();
        adVar.dDb.dDc = true;
        EventCenter.instance.publish(adVar);
        MMEntryLock.unlock("show_whatsnew");
        com.tencent.mm.kernel.l.s(this, true);
        com.tencent.mm.plugin.report.service.g.Wn(8);
        g.aAg().azy();
        EventCenter.instance.publish(new ab());
        MMApplicationContext.getContext().getSharedPreferences("switch_account_preferences", 0).edit().putBoolean("last_logout_switch_account", false).commit();
        Intent intent = new Intent();
        intent.addFlags(67108864);
        intent.putExtra("Intro_Switch", true);
        com.tencent.mm.plugin.setting.c.jRt.o(intent, getContext());
        t.Q(this, null);
        finish();
        AppMethodBeat.o(74542);
    }

    private boolean eTF() {
        AppMethodBeat.i(74543);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11545, 1);
        Log.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutOutside");
        if (this.DeF != null) {
            this.DeF.show();
            AppMethodBeat.o(74543);
        } else {
            Log.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutOutside");
            this.DeF = com.tencent.mm.ui.base.h.c(this, getString(R.string.gpx), "", getString(R.string.gpt), getString(R.string.gpw), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.setting.ui.setting.SettingsUI.AnonymousClass2 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(74497);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(11545, 3);
                    Log.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutConfirm");
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(99, 145, 1, false);
                    if (!(g.azz() == null || g.azz().iMw == null)) {
                        g.azz().iMw.fz(false);
                    }
                    if (SettingsUI.this.DeF != null) {
                        SettingsUI.this.DeF.dismiss();
                    }
                    SettingsUI.g(SettingsUI.this);
                    AppMethodBeat.o(74497);
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.setting.ui.setting.SettingsUI.AnonymousClass3 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(74498);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(11545, 2);
                    Log.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutCancel");
                    if (SettingsUI.this.DeF != null) {
                        SettingsUI.this.DeF.dismiss();
                    }
                    AppMethodBeat.o(74498);
                }
            });
            AppMethodBeat.o(74543);
        }
        return true;
    }

    private boolean eTG() {
        AppMethodBeat.i(74544);
        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11545, 4);
        Log.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseWeChat");
        if (this.yTE == null) {
            this.yTE = View.inflate(getContext(), R.layout.bqs, null);
            this.DeH = (CheckBox) this.yTE.findViewById(R.id.hn1);
            this.DeH.setChecked(true);
        }
        if (this.DeG == null) {
            this.DeG = com.tencent.mm.ui.base.h.a(getContext(), (String) null, this.yTE, getString(R.string.en8), getString(R.string.sz), new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.setting.ui.setting.SettingsUI.AnonymousClass4 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(74499);
                    com.tencent.mm.modelstat.c.bgb().commitNow();
                    ((com.tencent.mm.plugin.expt.b.e) g.af(com.tencent.mm.plugin.expt.b.e.class)).logout();
                    if (SettingsUI.this.DeH == null || !SettingsUI.this.DeH.isChecked()) {
                        Log.i("MicroMsg.SettingsUI", "normally exit");
                        com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(99, 144, 1, false);
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(11545, 7);
                        Log.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseConfirmWithoutNotify");
                        if (!(g.azz() == null || g.azz().iMw == null)) {
                            g.azz().iMw.fz(false);
                        }
                        EventCenter.instance.publish(new hd());
                        SettingsUI.j(SettingsUI.this);
                        AppMethodBeat.o(74499);
                        return;
                    }
                    Log.i("MicroMsg.SettingsUI", "push notify mode exit");
                    com.tencent.mm.plugin.report.service.h.INSTANCE.idkeyStat(99, 143, 1, false);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(11545, 6);
                    Log.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseConfirmWithNotify");
                    af.bke().edit().putBoolean("is_in_notify_mode", true).commit();
                    SettingsUI.i(SettingsUI.this);
                    AppMethodBeat.o(74499);
                }
            }, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.setting.ui.setting.SettingsUI.AnonymousClass5 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(74500);
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(11545, 5);
                    Log.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_CloseCancel");
                    AppMethodBeat.o(74500);
                }
            });
        } else {
            this.DeG.show();
        }
        AppMethodBeat.o(74544);
        return true;
    }

    private void eTH() {
        AppMethodBeat.i(74545);
        com.tencent.mm.ak.t azz = g.azz();
        AnonymousClass19 r2 = new com.tencent.mm.ak.i() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsUI.AnonymousClass19 */

            @Override // com.tencent.mm.ak.i
            public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                AppMethodBeat.i(74517);
                String aTY = z.aTY();
                if (ch.iFO.KI(aTY)) {
                    ch.iFO.l(aTY, "last_logout_no_pwd_ticket", "");
                }
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.setting.ui.setting.SettingsUI.AnonymousClass19.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(74516);
                        g.azz().b(282, SettingsUI.this.onSceneEndCallback);
                        SettingsUI.this.DeD = null;
                        AppMethodBeat.o(74516);
                    }
                });
                AppMethodBeat.o(74517);
            }
        };
        this.DeD = r2;
        azz.a(282, r2);
        g.azz().a(new com.tencent.mm.modelsimple.s(), 0);
        AppMethodBeat.o(74545);
    }

    private void uv(boolean z) {
        AppMethodBeat.i(74546);
        MMEntryLock.unlock("welcome_page_show");
        if (z) {
            ((com.tencent.mm.plugin.notification.b.a) g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().alc();
        } else {
            ((com.tencent.mm.plugin.notification.b.a) g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().r(-1, null);
        }
        ad adVar = new ad();
        adVar.dDb.dDc = false;
        EventCenter.instance.publish(adVar);
        com.tencent.mm.plugin.setting.c.jRu.Xc();
        ((com.tencent.mm.plugin.notification.b.a) g.ah(com.tencent.mm.plugin.notification.b.a.class)).getNotification().alb();
        finish();
        if (com.tencent.mm.pluginsdk.i.c.JYn != null) {
            com.tencent.mm.pluginsdk.i.c.JYn.n(getContext(), z);
        }
        AppMethodBeat.o(74546);
    }

    private void eTI() {
        AppMethodBeat.i(74547);
        com.tencent.mm.ak.t azz = g.azz();
        AnonymousClass20 r2 = new com.tencent.mm.ak.i() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsUI.AnonymousClass20 */

            @Override // com.tencent.mm.ak.i
            public final void onSceneEnd(final int i2, final int i3, String str, final q qVar) {
                AppMethodBeat.i(74519);
                Log.d("MicroMsg.SettingsUI", "onSceneEnd " + i2 + " errCode " + i3 + " errMsg " + str + "  " + qVar.getType());
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.setting.ui.setting.SettingsUI.AnonymousClass20.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(74518);
                        g.azz().b(255, SettingsUI.this.Dax);
                        SettingsUI.this.Dax = null;
                        if (SettingsUI.this.Daw != null) {
                            SettingsUI.this.Daw.stopTimer();
                            SettingsUI.this.Daw = null;
                        }
                        if (SettingsUI.this.Dav != null) {
                            SettingsUI.this.Dav.dismiss();
                        }
                        if (qVar.getType() == 255 && ((u) qVar).jkg == 1) {
                            if (i3 == -3 && i2 == 4) {
                                Intent intent = new Intent(SettingsUI.this.getContext(), RegByMobileSetPwdUI.class);
                                intent.putExtra("kintent_hint", SettingsUI.this.getString(R.string.fzz));
                                SettingsUI.this.startActivityForResult(intent, 0);
                                AppMethodBeat.o(74518);
                                return;
                            }
                            SettingsUI.B(SettingsUI.this);
                        }
                        AppMethodBeat.o(74518);
                    }
                });
                AppMethodBeat.o(74519);
            }
        };
        this.Dax = r2;
        azz.a(255, r2);
        final u uVar = new u(2);
        uVar.jkg = 1;
        g.azz().a(uVar, 0);
        this.Daw = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsUI.AnonymousClass21 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(74520);
                g.azz().a(uVar);
                g.azz().b(255, SettingsUI.this.Dax);
                SettingsUI.this.Dax = null;
                if (SettingsUI.this.Daw != null) {
                    SettingsUI.this.Daw.stopTimer();
                    SettingsUI.this.Daw = null;
                }
                if (SettingsUI.this.Dav != null) {
                    SettingsUI.this.Dav.cancel();
                }
                SettingsUI.B(SettingsUI.this);
                AppMethodBeat.o(74520);
                return false;
            }
        }, false);
        this.Daw.startTimer(3000);
        AppCompatActivity context = getContext();
        getString(R.string.zb);
        this.Dav = com.tencent.mm.ui.base.h.a((Context) context, getString(R.string.j5d), false, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsUI.AnonymousClass22 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(74521);
                g.azz().a(uVar);
                g.azz().b(255, SettingsUI.this.Dax);
                SettingsUI.this.Dax = null;
                if (SettingsUI.this.Daw != null) {
                    SettingsUI.this.Daw.stopTimer();
                    SettingsUI.this.Daw = null;
                }
                if (SettingsUI.this.Dav != null) {
                    SettingsUI.this.Dav.dismiss();
                }
                AppMethodBeat.o(74521);
            }
        });
        AppMethodBeat.o(74547);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(f fVar, Preference preference) {
        String string;
        AppMethodBeat.i(74540);
        String str = preference.mKey;
        Log.i("MicroMsg.SettingsUI", str + " item has been clicked!");
        if ("settings_welab".equals(str)) {
            Intent intent = new Intent();
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add("labs_browse");
            intent.putStringArrayListExtra("key_exclude_apps", arrayList);
            ((com.tencent.mm.plugin.welab.a.a.c) g.af(com.tencent.mm.plugin.welab.a.a.c.class)).at(this, intent);
            AppMethodBeat.o(74540);
            return true;
        } else if ("settings_account_info".equals(str)) {
            if (Util.getInt(h.aqJ().getValue("VoiceprintEntry"), 0) == 1 && (g.aAh().azQ().getInt(40, 0) & 131072) == 0) {
                g.aAh().azQ().set(ar.a.USERINFO_VOICEPRINT_SETTING_ACCOUNT_INFO_DOT_SHOW_BOOLEAN, Boolean.FALSE);
                Log.i("MicroMsg.SettingsUI", "unset setting account info dot show");
            }
            c.axV().b(ar.a.NEW_BANDAGE_DATASOURCE_DEVICE_PROTECT_STRING_SYNC, 266257);
            startActivity(SettingsAccountInfoUI.class);
            AppMethodBeat.o(74540);
            return true;
        } else if ("settings_teen_mode".equals(str)) {
            boolean Vt = ((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).Vt();
            ((com.tencent.mm.plugin.teenmode.a.b) g.af(com.tencent.mm.plugin.teenmode.a.b.class)).pl(1);
            Intent intent2 = new Intent();
            if (!Vt) {
                com.tencent.mm.br.c.b(this, "teenmode", ".ui.SettingsTeenModeIntro", intent2);
            } else {
                com.tencent.mm.br.c.b(this, "teenmode", ".ui.TeenModeVerifyPwdUI", intent2);
            }
            AppMethodBeat.o(74540);
            return true;
        } else if ("settings_account".equals(str)) {
            AppCompatActivity context = getContext();
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(this, SettingsPersonalInfoUI.class));
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetAccount", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetAccount", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(74540);
            return true;
        } else if (str.equals("settings_bind_mobile")) {
            Intent intent3 = new Intent(this, BindMContactIntroUI.class);
            intent3.putExtra("key_upload_scene", 4);
            MMWizardActivity.ay(this, intent3);
            AppMethodBeat.o(74540);
            return true;
        } else if (str.equals("settings_about_privacy")) {
            int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_PRIVATY_RED_DOT_WILL_SHOW_ID_INT, (Object) 0)).intValue();
            if (intValue > ((Integer) g.aAh().azQ().get(ar.a.USERINFO_PRIVATY_RED_DOT_DID_SHOW_ID_INT, (Object) 0)).intValue()) {
                g.aAh().azQ().set(ar.a.USERINFO_PRIVATY_RED_DOT_DID_SHOW_ID_INT, Integer.valueOf(intValue));
            }
            com.tencent.mm.plugin.report.service.h.INSTANCE.kvStat(21529, String.format("%s,%s", Long.valueOf(System.currentTimeMillis()), 4));
            com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(this, SettingsPrivacyUI.class));
            com.tencent.mm.hellhoundlib.a.a.a(this, bl2.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetPrivacy", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl2.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetPrivacy", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(74540);
            return true;
        } else if (str.equals("settings_about_system")) {
            c.axV().cQ(262158, 266265);
            com.tencent.mm.hellhoundlib.b.a bl3 = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(this, SettingsAboutSystemUI.class));
            com.tencent.mm.hellhoundlib.a.a.a(this, bl3.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetSystem", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl3.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetSystem", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(74540);
            return true;
        } else if (str.equals("settings_about_micromsg")) {
            c.axV().cQ(262145, 266243);
            c.axV().cQ(262157, 266262);
            c.axV().cQ(262164, 266269);
            AppCompatActivity context2 = getContext();
            com.tencent.mm.hellhoundlib.b.a bl4 = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(this, SettingsAboutMicroMsgUI.class));
            com.tencent.mm.hellhoundlib.a.a.a(context2, bl4.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetMicroMsg", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context2.startActivity((Intent) bl4.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context2, "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetMicroMsg", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            ((com.tencent.mm.plugin.updater.a.a) g.ah(com.tencent.mm.plugin.updater.a.a.class)).clickAboutWechatRedDot();
            new MMHandler().postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.setting.ui.setting.SettingsUI.AnonymousClass29 */

                public final void run() {
                    AppMethodBeat.i(74527);
                    com.tencent.mm.cr.d.hiy();
                    AppMethodBeat.o(74527);
                }
            }, 100);
            AppMethodBeat.o(74540);
            return true;
        } else if (str.equals("settings_about_device")) {
            if (((b) g.af(b.class)).a(b.a.clicfg_settings_device_entry, 0) != 1) {
                com.tencent.mm.br.c.b(getContext(), "exdevice", ".ui.ExdeviceManageDeviceUI", new Intent());
            } else {
                com.tencent.mm.plugin.appbrand.api.g gVar = new com.tencent.mm.plugin.appbrand.api.g();
                gVar.appId = "wxd930c3b7cf7c92e6";
                gVar.kHw = "pages/device-list/device-list.html";
                gVar.version = 0;
                gVar.iOo = 0;
                gVar.scene = FaceManager.FACE_ACQUIRED_BRIGHT;
                ((r) g.af(r.class)).a(getContext(), gVar);
            }
            AppMethodBeat.o(74540);
            return true;
        } else if (str.equals("settings_logout")) {
            if (com.tencent.mm.aw.b.isOverseasUser()) {
                Log.i("MicroMsg.SettingsUI", "oversea user logout");
                com.tencent.mm.ui.base.h.a((Context) getContext(), true, getResources().getString(R.string.gpx), "", getResources().getString(R.string.gpt), getString(R.string.sz), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.setting.ui.setting.SettingsUI.AnonymousClass13 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(74509);
                        SettingsUI.g(SettingsUI.this);
                        AppMethodBeat.o(74509);
                    }
                }, (DialogInterface.OnClickListener) null);
                AppMethodBeat.o(74540);
                return true;
            }
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(11545, 8);
            Log.i("MicroMsg.SettingsUI", "reprot: MM_LightPushCloseWechat == OP_LogoutCloseEntrance");
            if (ch.iFO.aWo().size() > 1) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(14978, 1, 10, ch.iFO.aWp());
            } else {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(14978, 0, 10, ch.iFO.aWp());
            }
            this.nVN.dGm();
            AppMethodBeat.o(74540);
            return true;
        } else if (str.equals("settings_exit")) {
            boolean eTG = eTG();
            AppMethodBeat.o(74540);
            return eTG;
        } else if (str.equals("settings_logout_option")) {
            boolean eTF = eTF();
            AppMethodBeat.o(74540);
            return eTF;
        } else if (str.equals("settings_notification_preference")) {
            com.tencent.mm.hellhoundlib.b.a bl5 = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(this, SettingsNotificationUI.class));
            com.tencent.mm.hellhoundlib.a.a.a(this, bl5.axQ(), "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetNotification", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl5.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/setting/ui/setting/SettingsUI", "goToSetNotification", "()Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(74540);
            return true;
        } else if (str.equals("settings_chatting")) {
            startActivity(SettingsChattingUI.class);
            AppMethodBeat.o(74540);
            return true;
        } else if (str.equals("settings_active_time")) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(11351, 1, 0);
            startActivity(SettingsActiveTimeUI.class);
            AppMethodBeat.o(74540);
            return true;
        } else {
            if (str.equals("settings_feedback")) {
                if (WeChatBrands.AppInfo.current().isMainland()) {
                    if (!ChannelUtil.isNokiaAol && LocaleUtil.getApplicationLanguage().equals(LocaleUtil.CHINA)) {
                        string = getString(R.string.j1o);
                    } else if (LocaleUtil.getApplicationLanguage().equals(LocaleUtil.HONGKONG)) {
                        string = getString(R.string.j1p);
                    } else if (LocaleUtil.getApplicationLanguage().equals(LocaleUtil.TAIWAN)) {
                        string = getString(R.string.j1q);
                    } else {
                        string = getString(R.string.j1r);
                    }
                    Log.d("MicroMsg.SettingsUI", "using faq webpage");
                    Intent intent4 = new Intent();
                    intent4.putExtra("showShare", false);
                    intent4.putExtra("rawUrl", string);
                    intent4.putExtra("show_feedback", false);
                    intent4.putExtra("KShowFixToolsBtn", true);
                    com.tencent.mm.br.c.b(getContext(), "webview", ".ui.tools.WebViewUI", intent4);
                } else {
                    com.tencent.mm.pluginsdk.g.ce(MMApplicationContext.getContext(), "weixin://dl/feedback");
                }
            } else if (str.equals("settings_switch_account")) {
                if (ch.iFO.aWo().size() > 1) {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(14978, 1, 6, ch.iFO.aWp());
                } else {
                    com.tencent.mm.plugin.report.service.h.INSTANCE.a(14978, 0, 6, ch.iFO.aWp());
                }
                if (g.aAh().azQ().getBoolean(ar.a.USERINFO_SETTING_SWITCH_ACCOUNT_FIRST_CLICK_BOOLEAN_SYNC, true)) {
                    g.aAh().azQ().set(ar.a.USERINFO_SETTING_SWITCH_ACCOUNT_FIRST_CLICK_BOOLEAN_SYNC, Boolean.FALSE);
                    com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.guv), getString(R.string.guw), getString(R.string.w1), false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.setting.ui.setting.SettingsUI.AnonymousClass28 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(74526);
                            SettingsUI.e(SettingsUI.this);
                            AppMethodBeat.o(74526);
                        }
                    });
                } else {
                    eTE();
                }
            }
            AppMethodBeat.o(74540);
            return false;
        }
    }

    static /* synthetic */ void g(SettingsUI settingsUI) {
        AppMethodBeat.i(74553);
        g.aAf();
        Log.w("MicroMsg.SettingsUI", "dklogout User LOGOUT Now uin:%d , clear cookie", Integer.valueOf(com.tencent.mm.kernel.a.getUin()));
        EventCenter.instance.publish(new hd());
        com.tencent.mm.modelstat.c.bgb().commitNow();
        ((com.tencent.mm.plugin.expt.b.e) g.af(com.tencent.mm.plugin.expt.b.e.class)).logout();
        com.tencent.mm.ak.t azz = g.azz();
        AnonymousClass9 r2 = new com.tencent.mm.ak.i() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsUI.AnonymousClass9 */

            @Override // com.tencent.mm.ak.i
            public final void onSceneEnd(final int i2, final int i3, String str, final q qVar) {
                AppMethodBeat.i(74505);
                Log.d("MicroMsg.SettingsUI", "onSceneEnd " + i2 + " errCode " + i3 + " errMsg " + str + "  " + qVar.getType());
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.setting.ui.setting.SettingsUI.AnonymousClass9.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(74504);
                        g.azz().b(255, SettingsUI.this.Dax);
                        SettingsUI.this.Dax = null;
                        if (SettingsUI.this.Daw != null) {
                            SettingsUI.this.Daw.stopTimer();
                            SettingsUI.this.Daw = null;
                        }
                        if (SettingsUI.this.Dav != null) {
                            SettingsUI.this.Dav.dismiss();
                        }
                        if (qVar.getType() == 255 && ((u) qVar).jkg == 2) {
                            if (i3 == -3 && i2 == 4) {
                                Intent intent = new Intent(SettingsUI.this.getContext(), RegByMobileSetPwdUI.class);
                                intent.putExtra("kintent_hint", SettingsUI.this.getString(R.string.fzz));
                                SettingsUI.this.startActivityForResult(intent, 5);
                                AppMethodBeat.o(74504);
                                return;
                            }
                            SettingsUI.u(SettingsUI.this);
                        }
                        AppMethodBeat.o(74504);
                    }
                });
                AppMethodBeat.o(74505);
            }
        };
        settingsUI.Dax = r2;
        azz.a(255, r2);
        final u uVar = new u(2);
        uVar.jkg = 2;
        g.azz().a(uVar, 0);
        settingsUI.Daw = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsUI.AnonymousClass10 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(74506);
                g.azz().a(uVar);
                g.azz().b(255, SettingsUI.this.Dax);
                SettingsUI.this.Dax = null;
                if (SettingsUI.this.Daw != null) {
                    SettingsUI.this.Daw.stopTimer();
                    SettingsUI.this.Daw = null;
                }
                if (SettingsUI.this.Dav != null) {
                    SettingsUI.this.Dav.cancel();
                }
                SettingsUI.u(SettingsUI.this);
                AppMethodBeat.o(74506);
                return false;
            }
        }, false);
        settingsUI.Daw.startTimer(12000);
        settingsUI.getString(R.string.zb);
        settingsUI.Dav = com.tencent.mm.ui.base.h.a((Context) settingsUI, settingsUI.getString(R.string.j5f), false, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsUI.AnonymousClass11 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(74507);
                g.azz().a(uVar);
                g.azz().b(255, SettingsUI.this.Dax);
                SettingsUI.this.Dax = null;
                if (SettingsUI.this.Daw != null) {
                    SettingsUI.this.Daw.stopTimer();
                    SettingsUI.this.Daw = null;
                }
                if (SettingsUI.this.Dav != null) {
                    SettingsUI.this.Dav.dismiss();
                }
                AppMethodBeat.o(74507);
            }
        });
        if (g.aAc()) {
            bf.iDu.Km(com.tencent.mm.aj.c.Me(z.aTY()));
        }
        AppMethodBeat.o(74553);
    }

    static /* synthetic */ void j(SettingsUI settingsUI) {
        AppMethodBeat.i(74555);
        g.aAf();
        Log.w("MicroMsg.SettingsUI", "dklogout User EXIT Now uin:%d", Integer.valueOf(com.tencent.mm.kernel.a.getUin()));
        if (com.tencent.mm.kernel.a.qd(g.aAf().hpS)) {
            com.tencent.mm.ak.t azz = g.azz();
            AnonymousClass6 r2 = new com.tencent.mm.ak.i() {
                /* class com.tencent.mm.plugin.setting.ui.setting.SettingsUI.AnonymousClass6 */

                @Override // com.tencent.mm.ak.i
                public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                    AppMethodBeat.i(74501);
                    g.azz().b(281, SettingsUI.this.DeI);
                    SettingsUI.this.DeI = null;
                    if (SettingsUI.this.jer != null) {
                        SettingsUI.this.jer.stopTimer();
                        SettingsUI.this.jer = null;
                    }
                    if (SettingsUI.this.Dav != null) {
                        SettingsUI.this.Dav.dismiss();
                    }
                    SettingsUI.p(SettingsUI.this);
                    AppMethodBeat.o(74501);
                }
            };
            settingsUI.DeI = r2;
            azz.a(281, r2);
            final ae aeVar = new ae(2);
            g.azz().a(aeVar, 0);
            settingsUI.jer = new MTimerHandler(new MTimerHandler.CallBack() {
                /* class com.tencent.mm.plugin.setting.ui.setting.SettingsUI.AnonymousClass7 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(74502);
                    g.azz().a(aeVar);
                    g.azz().b(281, SettingsUI.this.DeI);
                    SettingsUI.this.DeI = null;
                    if (SettingsUI.this.jer != null) {
                        SettingsUI.this.jer.stopTimer();
                        SettingsUI.this.jer = null;
                    }
                    if (SettingsUI.this.Dav != null) {
                        SettingsUI.this.Dav.dismiss();
                    }
                    SettingsUI.p(SettingsUI.this);
                    AppMethodBeat.o(74502);
                    return false;
                }
            }, false);
            settingsUI.jer.startTimer(5000);
            AppCompatActivity context = settingsUI.getContext();
            settingsUI.getString(R.string.zb);
            settingsUI.Dav = com.tencent.mm.ui.base.h.a((Context) context, settingsUI.getString(R.string.j19), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.setting.ui.setting.SettingsUI.AnonymousClass8 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(74503);
                    g.azz().a(aeVar);
                    g.azz().b(281, SettingsUI.this.DeI);
                    SettingsUI.this.DeI = null;
                    if (SettingsUI.this.jer != null) {
                        SettingsUI.this.jer.stopTimer();
                        SettingsUI.this.jer = null;
                    }
                    if (SettingsUI.this.Dav != null) {
                        SettingsUI.this.Dav.dismiss();
                    }
                    AppMethodBeat.o(74503);
                }
            });
            AppMethodBeat.o(74555);
            return;
        }
        settingsUI.eTI();
        AppMethodBeat.o(74555);
    }

    static /* synthetic */ void u(SettingsUI settingsUI) {
        AppMethodBeat.i(74557);
        if (!com.tencent.mm.kernel.a.qd(g.aAf().hpS) || BuildInfo.EX_DEVICE_LOGIN || !ao.gJH()) {
            settingsUI.eTH();
            settingsUI.cve = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
                /* class com.tencent.mm.plugin.setting.ui.setting.SettingsUI.AnonymousClass17 */

                @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
                public final boolean onTimerExpired() {
                    AppMethodBeat.i(74514);
                    g.azz().b(281, SettingsUI.this.onSceneEndCallback);
                    g.azz().b(282, SettingsUI.this.DeD);
                    SettingsUI.this.onSceneEndCallback = null;
                    SettingsUI.this.DeD = null;
                    if (SettingsUI.this.cve != null) {
                        SettingsUI.this.cve.stopTimer();
                    }
                    if (SettingsUI.this.Dav != null) {
                        SettingsUI.this.Dav.cancel();
                    }
                    SettingsUI.z(SettingsUI.this);
                    AppMethodBeat.o(74514);
                    return false;
                }
            }, false);
            settingsUI.cve.startTimer(3000);
            settingsUI.getString(R.string.zb);
            settingsUI.Dav = com.tencent.mm.ui.base.h.a((Context) settingsUI, settingsUI.getString(R.string.j5f), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.setting.ui.setting.SettingsUI.AnonymousClass18 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(74515);
                    g.azz().b(281, SettingsUI.this.onSceneEndCallback);
                    g.azz().b(282, SettingsUI.this.DeD);
                    SettingsUI.this.onSceneEndCallback = null;
                    SettingsUI.this.DeD = null;
                    if (SettingsUI.this.Daw != null) {
                        SettingsUI.this.Daw.stopTimer();
                        SettingsUI.this.Daw = null;
                    }
                    if (SettingsUI.this.Dav != null) {
                        SettingsUI.this.Dav.dismiss();
                    }
                    AppMethodBeat.o(74515);
                }
            });
            AppMethodBeat.o(74557);
            return;
        }
        com.tencent.mm.ak.t azz = g.azz();
        AnonymousClass14 r2 = new com.tencent.mm.ak.i() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsUI.AnonymousClass14 */

            @Override // com.tencent.mm.ak.i
            public final void onSceneEnd(int i2, int i3, String str, q qVar) {
                AppMethodBeat.i(74511);
                MMHandlerThread.postToMainThread(new Runnable() {
                    /* class com.tencent.mm.plugin.setting.ui.setting.SettingsUI.AnonymousClass14.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(74510);
                        g.azz().b(281, SettingsUI.this.onSceneEndCallback);
                        SettingsUI.this.onSceneEndCallback = null;
                        AppMethodBeat.o(74510);
                    }
                });
                AppMethodBeat.o(74511);
            }
        };
        settingsUI.onSceneEndCallback = r2;
        azz.a(281, r2);
        final ae aeVar = new ae(2);
        g.azz().a(aeVar, 0);
        settingsUI.eTH();
        settingsUI.Daw = new MTimerHandler(Looper.getMainLooper(), (MTimerHandler.CallBack) new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsUI.AnonymousClass15 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(74512);
                g.azz().a(aeVar);
                g.azz().b(281, SettingsUI.this.onSceneEndCallback);
                g.azz().b(282, SettingsUI.this.DeD);
                SettingsUI.this.onSceneEndCallback = null;
                SettingsUI.this.DeD = null;
                if (SettingsUI.this.Daw != null) {
                    SettingsUI.this.Daw.stopTimer();
                    SettingsUI.this.Daw = null;
                }
                if (SettingsUI.this.Dav != null) {
                    SettingsUI.this.Dav.cancel();
                }
                SettingsUI.z(SettingsUI.this);
                AppMethodBeat.o(74512);
                return false;
            }
        }, false);
        settingsUI.Daw.startTimer(5000);
        settingsUI.getString(R.string.zb);
        settingsUI.Dav = com.tencent.mm.ui.base.h.a((Context) settingsUI, settingsUI.getString(R.string.j19), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.setting.ui.setting.SettingsUI.AnonymousClass16 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(74513);
                g.azz().a(aeVar);
                g.azz().b(281, SettingsUI.this.onSceneEndCallback);
                g.azz().b(282, SettingsUI.this.DeD);
                SettingsUI.this.onSceneEndCallback = null;
                SettingsUI.this.DeD = null;
                if (SettingsUI.this.Daw != null) {
                    SettingsUI.this.Daw.stopTimer();
                    SettingsUI.this.Daw = null;
                }
                if (SettingsUI.this.Dav != null) {
                    SettingsUI.this.Dav.dismiss();
                }
                AppMethodBeat.o(74513);
            }
        });
        AppMethodBeat.o(74557);
    }

    static /* synthetic */ void B(SettingsUI settingsUI) {
        AppMethodBeat.i(74559);
        settingsUI.uv(true);
        AppMethodBeat.o(74559);
    }
}
