package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.ce;
import com.tencent.mm.g.a.on;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.a.zr;
import com.tencent.mm.g.a.zv;
import com.tencent.mm.g.b.a.kv;
import com.tencent.mm.g.b.a.ky;
import com.tencent.mm.g.b.a.kz;
import com.tencent.mm.g.b.a.lc;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.wallet.pwd.a.f;
import com.tencent.mm.plugin.wallet.pwd.a.h;
import com.tencent.mm.plugin.wallet.pwd.a.m;
import com.tencent.mm.plugin.wallet_core.c.ad;
import com.tencent.mm.plugin.wallet_core.c.aj;
import com.tencent.mm.plugin.wallet_core.model.ag;
import com.tencent.mm.plugin.wallet_core.model.t;
import com.tencent.mm.plugin.wallet_core.utils.g;
import com.tencent.mm.plugin.walletlock.a.b;
import com.tencent.mm.pluginsdk.wallet.a;
import com.tencent.mm.protocal.protobuf.dju;
import com.tencent.mm.protocal.protobuf.ehf;
import com.tencent.mm.protocal.protobuf.ejs;
import com.tencent.mm.sdk.crash.CrashReportFactory;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.base.preference.CheckBoxPreference;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.PreferenceFooterCategory;
import com.tencent.mm.ui.base.preference.PreferenceSmallCategory;
import com.tencent.mm.ui.base.preference.PreferenceTitleCategory;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.e;
import com.tencent.mm.wallet_core.c.l;
import com.tencent.mm.wallet_core.d;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

public class WalletPasswordSettingUI extends MMPreference implements i {
    IListener HDJ = new IListener<zr>() {
        /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI.AnonymousClass12 */

        {
            AppMethodBeat.i(160870);
            this.__eventId = zr.class.getName().hashCode();
            AppMethodBeat.o(160870);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(zr zrVar) {
            AppMethodBeat.i(69744);
            WalletPasswordSettingUI.a(WalletPasswordSettingUI.this, true);
            WalletPasswordSettingUI.this.fPn();
            AppMethodBeat.o(69744);
            return false;
        }
    };
    private lc HKA;
    private boolean HKB = false;
    private int HKC = 0;
    private int HKD = 0;
    private int HKE = 2;
    private List<Preference> HKF = new ArrayList();
    private boolean HKG = false;
    private IListener<on> HKH = new IListener<on>() {
        /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI.AnonymousClass13 */

        {
            AppMethodBeat.i(160871);
            this.__eventId = on.class.getName().hashCode();
            AppMethodBeat.o(160871);
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.tencent.mm.sdk.event.IEvent] */
        @Override // com.tencent.mm.sdk.event.IListener
        public final /* synthetic */ boolean callback(on onVar) {
            AppMethodBeat.i(69746);
            MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI.AnonymousClass13.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(69745);
                    Log.i("MicroMsg.WalletPasswordSettingUI", "update after soter init");
                    WalletPasswordSettingUI.d(WalletPasswordSettingUI.this);
                    AppMethodBeat.o(69745);
                }
            }, 500);
            AppMethodBeat.o(69746);
            return false;
        }
    };
    private d.a HKI = new d.a() {
        /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI.AnonymousClass15 */

        @Override // com.tencent.mm.wallet_core.d.a
        public final Intent q(int i2, Bundle bundle) {
            AppMethodBeat.i(69749);
            Log.i("MicroMsg.WalletPasswordSettingUI", "end readname process");
            WalletPasswordSettingUI.a(WalletPasswordSettingUI.this, false);
            zv zvVar = new zv();
            if (i2 == -1) {
                zvVar.efR.scene = 17;
            } else if (i2 == 0) {
                zvVar.efR.scene = 18;
            } else {
                zvVar.efR.scene = 0;
            }
            zvVar.efS.efJ = new Runnable() {
                /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI.AnonymousClass15.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(69748);
                    WalletPasswordSettingUI.this.fPn();
                    AppMethodBeat.o(69748);
                }
            };
            EventCenter.instance.publish(zvVar);
            AppMethodBeat.o(69749);
            return null;
        }
    };
    private f.a HKk;
    CheckBoxPreference HKm;
    RightBelowPreference HKn;
    CheckBoxPreference HKo;
    private Dialog HKp = null;
    private boolean HKq = false;
    private IconPreference HKr;
    private Preference HKs;
    private String HKt;
    private String HKu;
    private String HKv;
    private ag HKw;
    private ag HKx;
    private ag HKy;
    private h.a HKz;
    private MMHandler handler = new MMHandler(new MMHandler.Callback() {
        /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI.AnonymousClass1 */

        public final boolean handleMessage(Message message) {
            AppMethodBeat.i(69735);
            switch (message.what) {
                case 1:
                    WalletPasswordSettingUI.a(WalletPasswordSettingUI.this);
                    break;
                case 2:
                    WalletPasswordSettingUI.b(WalletPasswordSettingUI.this);
                    break;
                case 3:
                    WalletPasswordSettingUI.c(WalletPasswordSettingUI.this);
                    break;
            }
            AppMethodBeat.o(69735);
            return false;
        }
    });
    private boolean hmr;
    private int scene;
    private com.tencent.mm.ui.base.preference.f screen;
    private Dialog tipDialog;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletPasswordSettingUI() {
        AppMethodBeat.i(69753);
        AppMethodBeat.o(69753);
    }

    static /* synthetic */ void a(WalletPasswordSettingUI walletPasswordSettingUI, ag agVar) {
        AppMethodBeat.i(214094);
        walletPasswordSettingUI.a(agVar);
        AppMethodBeat.o(214094);
    }

    static /* synthetic */ void a(WalletPasswordSettingUI walletPasswordSettingUI, boolean z) {
        AppMethodBeat.i(69775);
        walletPasswordSettingUI.yc(z);
        AppMethodBeat.o(69775);
    }

    static /* synthetic */ void d(WalletPasswordSettingUI walletPasswordSettingUI) {
        AppMethodBeat.i(69776);
        walletPasswordSettingUI.fPo();
        AppMethodBeat.o(69776);
    }

    static /* synthetic */ void e(WalletPasswordSettingUI walletPasswordSettingUI) {
        AppMethodBeat.i(69777);
        walletPasswordSettingUI.yb(false);
        AppMethodBeat.o(69777);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return -1;
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        boolean z;
        AppMethodBeat.i(69754);
        fixStatusbar(true);
        super.onCreate(bundle);
        setActionbarColor(getActionbarColor());
        g.aAi();
        g.aAg().hqi.a(385, this);
        g.aAi();
        g.aAg().hqi.a(1477, this);
        g.aAi();
        g.aAg().hqi.a(1813, this);
        g.aAi();
        g.aAg().hqi.a(1724, this);
        EventCenter.instance.addListener(this.HDJ);
        this.HKH.alive();
        this.hmr = getIntent().getBooleanExtra("key_is_from_system", false);
        this.scene = getIntent().getIntExtra("key_enter_scene", 0);
        this.HKq = getIntent().getBooleanExtra("key_default_show_currency", false);
        if (this.hmr) {
            Log.i("MicroMsg.WalletPasswordSettingUI", "hy: enter password setting from system setting");
            ((b) g.af(b.class)).a(this, null);
        }
        initView();
        String str = (String) g.aAh().azQ().get(ar.a.USERINFO_WALLET_HB_REFUND_CONFIG_REFACTOR_STRING_SYNC, "");
        if (!Util.isNullOrNil(str)) {
            this.HKk = f.a.aUZ(str);
            Log.d("MicroMsg.WalletPasswordSettingUI", "updateHbRefundConfig() mHbRefundConfig:%s", this.HKk);
        } else {
            Log.i("MicroMsg.WalletPasswordSettingUI", "updateHbRefundConfig() jsonString == null");
        }
        yd(false);
        f fVar = new f();
        g.aAi();
        g.aAg().hqi.a(fVar, 0);
        t.fQC();
        boolean fQR = t.fQR();
        Log.i("MicroMsg.WalletPasswordSettingUI", "mobileRemitSwitch:%s", Boolean.valueOf(fQR));
        if (fQR) {
            String str2 = (String) g.aAh().azQ().get(ar.a.USERINFO_MOBILE_REMITTANCE_SWITCH_CONFIG_STRING_SYNC, "");
            if (!Util.isNullOrNil(str2)) {
                this.HKz = h.a.aVa(str2);
                Log.i("MicroMsg.WalletPasswordSettingUI", "updateMobileRemitConfig() mMobileRemitSwitchConfig:%s", this.HKk);
            } else {
                Log.i("MicroMsg.WalletPasswordSettingUI", "updateMobileRemitConfig() jsonString == null");
            }
            ye(false);
            g.aAi();
            this.HKE = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_MOBILE_REMITTANCE_SWITCH_GRANT_FLAG_INT_SYNC, (Object) 2)).intValue();
            Log.i("MicroMsg.WalletPasswordSettingUI", "get mobileRemitGrantFlag: %s", Integer.valueOf(this.HKE));
            if (this.HKE == 0) {
                this.HKE = 2;
            }
            h hVar = new h(this.HKE);
            g.aAi();
            g.aAg().hqi.a(hVar, 0);
        } else {
            ye(false);
        }
        g.aAi();
        long longValue = ((Long) g.aAh().azQ().get(ar.a.USERINFO_WALLET_PREF_INFO_CACHE_TIME_LONG_SYNC, (Object) 0L)).longValue();
        g.aAi();
        int intValue = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_WALLET_PREF_INFO_EXPIRES_INT_SYNC, (Object) 0)).intValue();
        Log.i("MicroMsg.NetSceneTenpayPayManager", "check isExpire %s %s %s", Long.valueOf(longValue), Integer.valueOf(intValue), Long.valueOf(((long) intValue) + longValue));
        if (longValue <= 0 || new Date().getTime() / 1000 > longValue + ((long) intValue)) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            yc(false);
        } else {
            g.aAi();
            this.HKu = (String) g.aAh().azQ().get(ar.a.USERINFO_WALLET_REALNAME_URL_STRING_SYNC, "");
            this.HKw = t.fQH().aVD("wallet_open_auto_pay");
            if (this.HKw != null && this.HKw.field_is_show == 1) {
                Log.i("MicroMsg.WalletPasswordSettingUI", "deduct info from cache is not null");
                this.HKt = this.HKw.field_pref_url;
                aZ(this.HKw.field_pref_title, this.HKw.field_pref_url, this.HKw.field_tinyapp_path);
            } else if (this.HKw == null) {
                Log.i("MicroMsg.WalletPasswordSettingUI", "deduct info from cache is null");
            } else {
                Log.i("MicroMsg.WalletPasswordSettingUI", "mOpenAutoPayPrefInfo.field_is_show = " + this.HKw.field_is_show + " and mOpenAutoPayPrefInfo.field_pref_url is null?" + Util.isNullOrNil(this.HKw.field_pref_url));
            }
        }
        g.aAi();
        this.HKC = ((Integer) g.aAh().azQ().get(ar.a.USERINFO_DELAY_TRANSFER_SHOW_SWITCH_FLAG_INT, (Object) 0)).intValue();
        g.aAi();
        this.HKv = (String) g.aAh().azQ().get(ar.a.USERINFO_DELAY_TRANSFER_SWITCH_WORDING_STRING, "");
        if (Util.isNullOrNil(this.HKv)) {
            aj.a(true, null);
        } else {
            this.HKs.setTitle(this.HKv);
            aj.a(true, null);
        }
        if (this.HKC == 0) {
            this.screen.m38do("wallet_delay_transfer_date", true);
        }
        AppMethodBeat.o(69754);
    }

    private void aZ(String str, String str2, String str3) {
        AppMethodBeat.i(214093);
        this.HKr.setTitle(str);
        if (!Util.isNullOrNil(str2) || !Util.isNullOrNil(str3)) {
            this.screen.m38do("wallet_open_auto_pay", false);
            AppMethodBeat.o(214093);
            return;
        }
        this.screen.m38do("wallet_open_auto_pay", true);
        Log.e("MicroMsg.WalletPasswordSettingUI", "deduct_url is null or tinyappPath is null");
        AppMethodBeat.o(214093);
    }

    private void fPj() {
        AppMethodBeat.i(69756);
        g.aAi();
        String str = (String) g.aAh().azQ().get(ar.a.USERINFO_WALLET_USERINFO_UNREGTITLE_TYPE_STRING_SYNC, "");
        g.aAi();
        String str2 = (String) g.aAh().azQ().get(ar.a.USERINFO_WALLET_USERINFO_UNREGURL_TYPE_STRING_SYNC, "");
        Log.i("MicroMsg.WalletPasswordSettingUI", "updateUnRegPref unreg_title %s unreg_url %s", str, str2);
        if (Util.isNullOrNil(str) || Util.isNullOrNil(str2) || !t.fQI().fRk()) {
            this.screen.m38do("wallet_password_setting_un_reg", true);
            AppMethodBeat.o(69756);
            return;
        }
        this.screen.m38do("wallet_password_setting_un_reg", false);
        AppMethodBeat.o(69756);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        AppMethodBeat.i(69757);
        super.onResume();
        if (((b) g.af(b.class)).fUG()) {
            finish();
        } else {
            fPn();
            if (this.HKG) {
                this.HKG = false;
                yc(false);
            }
        }
        g.aAi();
        g.aAg().hqi.a(new ad(null, 1), 0);
        AppMethodBeat.o(69757);
    }

    /* access modifiers changed from: protected */
    public int fPk() {
        return R.xml.df;
    }

    /* access modifiers changed from: protected */
    public void fPl() {
        AppMethodBeat.i(69759);
        if (((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_android_pay_modify_pwd_cross_platform, false)) {
            ((a) g.af(a.class)).startModifyPwdUseCase(this, new Bundle());
            AppMethodBeat.o(69759);
            return;
        }
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.pwd.b.class, (Bundle) null, (d.a) null);
        AppMethodBeat.o(69759);
    }

    /* access modifiers changed from: protected */
    public void fPm() {
        boolean z = false;
        AppMethodBeat.i(69760);
        Bundle bundle = new Bundle();
        bundle.putBoolean("key_is_paymanager", true);
        bundle.putInt("key_forgot_scene", 2);
        com.tencent.mm.wallet_core.b.hgC();
        if (com.tencent.mm.wallet_core.b.b(b.a.clicfg_android_kinda_reset_pwd_open, false)) {
            Log.d("MicroMsg.WalletPasswordSettingUI", "startKindaResetPwd:true");
            ((a) g.af(a.class)).startResetPwdUseCase(this, bundle);
            z = true;
        } else {
            Log.d("MicroMsg.WalletPasswordSettingUI", "startKindaResetPwd:false");
        }
        if (z) {
            AppMethodBeat.o(69760);
            return;
        }
        com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet.pwd.a.class, bundle, (d.a) null);
        AppMethodBeat.o(69760);
    }

    private void yb(boolean z) {
        AppMethodBeat.i(69761);
        getDefaultSharedPreferences().edit().putBoolean("wallet_fingerprint_switch", z).commit();
        this.HKm.setChecked(z);
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(69761);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f fVar, Preference preference) {
        int i2;
        int i3;
        AppMethodBeat.i(69762);
        if ("wallet_modify_password".equals(preference.mKey)) {
            fPl();
            com.tencent.mm.wallet_core.ui.f.aqm(24);
            AppMethodBeat.o(69762);
            return true;
        } else if ("wallet_forget_password".equals(preference.mKey)) {
            g.aAi();
            String str = (String) g.aAh().azQ().get(ar.a.USERINFO_WALLET_DEDUCT_FORGET_URL_STRING, "");
            if (!Util.isNullOrNil(str)) {
                Log.i("MicroMsg.WalletPasswordSettingUI", "jump to forget_url %s", str);
                com.tencent.mm.wallet_core.ui.f.o(getContext(), str, false);
                ky kyVar = new ky();
                kyVar.eXG = 2;
                kyVar.eXH = 2;
                kyVar.bfK();
                AppMethodBeat.o(69762);
                return true;
            }
            String fRx = t.fQI().fRx();
            if (!Util.isNullOrNil(fRx)) {
                Log.i("MicroMsg.WalletPasswordSettingUI", "jump to forget url: %s", fRx);
                com.tencent.mm.wallet_core.ui.f.o(this, fRx, false);
                AppMethodBeat.o(69762);
                return true;
            }
            fPm();
            ky kyVar2 = new ky();
            kyVar2.eXG = 2;
            kyVar2.eXH = 1;
            kyVar2.bfK();
            com.tencent.mm.wallet_core.ui.f.aqm(25);
            AppMethodBeat.o(69762);
            return true;
        } else if ("wallet_realname_verify".equals(preference.mKey)) {
            if (!t.fQI().fRk()) {
                Log.i("MicroMsg.WalletPasswordSettingUI", "go to RealNameVerifyProcess");
                Bundle bundle = new Bundle();
                bundle.putInt("real_name_verify_mode", 0);
                bundle.putString("realname_verify_process_jump_plugin", "wallet");
                bundle.putString("realname_verify_process_jump_activity", ".pwd.ui.WalletPasswordSettingUI");
                com.tencent.mm.wallet_core.a.a(this, com.tencent.mm.plugin.wallet_core.id_verify.a.class, bundle, this.HKI);
            } else if (!Util.isNullOrNil(this.HKu)) {
                Log.i("MicroMsg.WalletPasswordSettingUI", "jump to mRealnameUrl");
                Intent intent = new Intent();
                intent.putExtra("rawUrl", this.HKu);
                intent.putExtra("showShare", false);
                intent.putExtra(e.p.OzJ, true);
                com.tencent.mm.wallet_core.ui.f.aA(getContext(), intent);
            } else {
                Log.e("MicroMsg.WalletPasswordSettingUI", "mRealnameUrl is null");
            }
            AppMethodBeat.o(69762);
            return true;
        } else if ("wallet_lucky_money_refund_way".equals(preference.mKey)) {
            Intent intent2 = new Intent(this, WalletLuckyMoneyRefundWayUI.class);
            intent2.putExtra("key_hb_refund_config", this.HKk.fON().toString());
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            kv kvVar = new kv();
            g.aAi();
            if (Util.isEqual(((Long) g.aAh().azQ().get(ar.a.USERINFO_EXT_PAY_SETTING_LONG_SYNC, (Object) 0L)).longValue() & 3, 2)) {
                i3 = 2;
            } else {
                i3 = 1;
            }
            kvVar.esA = (long) i3;
            kvVar.bfK();
            AppMethodBeat.o(69762);
            return true;
        } else if ("wallet_biometric_pay".equals(preference.mKey)) {
            com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(this, WalletBiometricPaySettingsUI.class));
            com.tencent.mm.hellhoundlib.a.a.a(this, bl2.axQ(), "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl2.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(69762);
            return true;
        } else if ("wallet_open_auto_pay".equals(preference.mKey)) {
            a(this.HKw);
            this.HKr.alE(8);
            AppMethodBeat.o(69762);
            return true;
        } else if ("wallet_digitalcert".equals(preference.mKey)) {
            if (!this.HKB) {
                m mVar = new m();
                g.aAi();
                g.aAg().hqi.a(mVar, 0);
            }
            c.b(this, "wallet", ".pwd.ui.WalletDigitalCertUI", new Intent());
            AppMethodBeat.o(69762);
            return true;
        } else if ("wallet_delay_transfer_date".equals(preference.mKey)) {
            com.tencent.mm.hellhoundlib.b.a bl3 = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(this, WalletDelayTransferSettingUI.class));
            com.tencent.mm.hellhoundlib.a.a.a(this, bl3.axQ(), "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl3.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(69762);
            return true;
        } else {
            if ("wallet_password_setting_un_reg".equals(preference.mKey)) {
                g.aAi();
                Intent intent3 = new Intent();
                intent3.putExtra("rawUrl", (String) g.aAh().azQ().get(ar.a.USERINFO_WALLET_USERINFO_UNREGURL_TYPE_STRING_SYNC, ""));
                intent3.putExtra("showShare", false);
                intent3.putExtra(e.p.OzJ, true);
                com.tencent.mm.wallet_core.ui.f.aA(getContext(), intent3);
            }
            if ("wallet_switch_currency".equals(preference.mKey)) {
                a(this.HKx);
                AppMethodBeat.o(69762);
                return true;
            } else if ("wallet_im_mch".equals(preference.mKey)) {
                a(this.HKy);
                AppMethodBeat.o(69762);
                return true;
            } else if ("wallet_universal_pay_order".equals(preference.mKey)) {
                com.tencent.mm.hellhoundlib.b.a bl4 = new com.tencent.mm.hellhoundlib.b.a().bl(new Intent(getContext(), WalletUniversalPayOrderUI.class));
                com.tencent.mm.hellhoundlib.a.a.a(this, bl4.axQ(), "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                startActivity((Intent) bl4.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI", "onPreferenceTreeClick", "(Lcom/tencent/mm/ui/base/preference/IPreferenceScreen;Lcom/tencent/mm/ui/base/preference/Preference;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                AppMethodBeat.o(69762);
                return true;
            } else if ("wallet_function_settings".equals(preference.mKey)) {
                c.V(getContext(), "mall", ".ui.MallFunctionSettingsUI");
                AppMethodBeat.o(69762);
                return true;
            } else if ("mobile_remit_switch".equals(preference.mKey)) {
                if (((CheckBoxPreference) preference).isChecked()) {
                    i2 = 1;
                } else {
                    i2 = 2;
                }
                this.HKA = new lc();
                this.HKA.ejA = (long) i2;
                if (this.scene == 0) {
                    this.HKA.eXL = 2;
                } else if (this.scene == 1) {
                    this.HKA.eXL = 1;
                }
                this.HKA.bfK();
                com.tencent.mm.plugin.wallet.pwd.a.g gVar = new com.tencent.mm.plugin.wallet.pwd.a.g(i2, this.HKE);
                g.aAi();
                g.aAg().hqi.a(gVar, 0);
                if (this.HKp == null) {
                    this.HKp = com.tencent.mm.ui.base.h.a((Context) this, 0, (int) R.style.lj, getString(R.string.ekc), false, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI.AnonymousClass16 */

                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(69750);
                            Log.i("MicroMsg.WalletPasswordSettingUI", "mChangeMobileRemitSwDialog onCancel");
                            AppMethodBeat.o(69750);
                        }
                    });
                } else {
                    this.HKp.show();
                }
                AppMethodBeat.o(69762);
                return true;
            } else {
                AppMethodBeat.o(69762);
                return false;
            }
        }
    }

    private void a(ag agVar) {
        AppMethodBeat.i(69763);
        switch (agVar.field_jump_type) {
            case 1:
                Log.i("MicroMsg.WalletPasswordSettingUI", "jump type h5, url: %s", agVar.field_pref_url);
                if (!Util.isNullOrNil(agVar.field_pref_url)) {
                    com.tencent.mm.wallet_core.ui.f.o(this, agVar.field_pref_url, false);
                    AppMethodBeat.o(69763);
                    return;
                }
                break;
            case 2:
                if (!Util.isNullOrNil(agVar.field_tinyapp_username)) {
                    wq wqVar = new wq();
                    wqVar.ecI.userName = agVar.field_tinyapp_username;
                    wqVar.ecI.ecK = Util.nullAs(agVar.field_tinyapp_path, "");
                    wqVar.ecI.scene = 1066;
                    wqVar.ecI.ecL = 0;
                    EventCenter.instance.publish(wqVar);
                    AppMethodBeat.o(69763);
                    return;
                }
                break;
            case 3:
                Log.i("MicroMsg.WalletPasswordSettingUI", "jump type payment management");
                c.V(this, "wallet", ".pwd.ui.WalletPasswordSettingUI");
                AppMethodBeat.o(69763);
                return;
            case 4:
                Log.i("MicroMsg.WalletPasswordSettingUI", "jump type payment security");
                Intent intent = new Intent();
                intent.putExtra("wallet_lock_jsapi_scene", 1);
                c.b(this, "wallet", ".pwd.ui.WalletSecuritySettingUI", intent);
                new kz();
                AppMethodBeat.o(69763);
                return;
            case 5:
                Log.i("MicroMsg.WalletPasswordSettingUI", "jump type wallet switch");
                c.d(this, "wallet_core", ".ui.WalletSwitchWalletCurrencyUI", 65281);
                AppMethodBeat.o(69763);
                return;
            case 8:
                Log.i("MicroMsg.WalletPasswordSettingUI", "jump type honey pay");
                c.V(this, "honey_pay", ".ui.HoneyPayMainUI");
                break;
        }
        AppMethodBeat.o(69763);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        AppMethodBeat.i(69764);
        if (i2 == 65281 && i3 == -1) {
            if (z.aUp()) {
                finish();
            } else {
                setResult(-1, intent);
                finish();
            }
        }
        super.onActivityResult(i2, i3, intent);
        AppMethodBeat.o(69764);
    }

    /* access modifiers changed from: protected */
    public void fPn() {
        boolean z;
        boolean z2;
        int i2;
        AppMethodBeat.i(69765);
        if (t.fQI().fRm() || t.fQI().fRl()) {
            this.screen.m38do("wallet_modify_password", true);
            this.screen.m38do("wallet_forget_password", true);
            this.screen.m38do("wallet_realname_verify", false);
            this.screen.bmg("wallet_realname_verify").setSummary(R.string.img);
            this.screen.m38do("wallet_universal_pay_order", true);
            this.screen.m38do("wallet_switch_currency", true);
            this.screen.m38do("wallet_switch_category", true);
            this.screen.m38do("wallet_biometric_pay", true);
        } else if (t.fQI().fRk()) {
            this.screen.m38do("wallet_modify_password", false);
            this.screen.m38do("wallet_forget_password", false);
            this.screen.m38do("wallet_realname_verify", false);
            this.screen.bmg("wallet_realname_verify").setSummary(R.string.imm);
            this.screen.m38do("wallet_universal_pay_order", true);
            fPo();
        } else {
            Log.e("MicroMsg.WalletPasswordSettingUI", "unknow reg state");
        }
        this.screen.m38do("wallet_universal_pay_order", true);
        this.screen.m38do("wallet_digitalcert", true);
        this.HKx = t.fQH().aVD("wallet_switch_currency");
        if (this.HKx == null || this.HKx.field_is_show != 1) {
            this.screen.m38do("wallet_switch_currency", true);
            z = true;
        } else {
            this.screen.m38do("wallet_switch_currency", false);
            Preference bmg = this.screen.bmg("wallet_switch_currency");
            bmg.setTitle(this.HKx.field_pref_title);
            bmg.setSummary(this.HKx.field_pref_desc);
            z = false;
        }
        this.HKy = t.fQH().aVD("wallet_im_mch");
        if (this.HKy == null || this.HKy.field_is_show != 1) {
            this.screen.m38do("wallet_im_mch", true);
            z2 = true;
        } else {
            this.screen.m38do("wallet_im_mch", false);
            Preference bmg2 = this.screen.bmg("wallet_im_mch");
            bmg2.setTitle(this.HKy.field_pref_title);
            bmg2.setSummary(this.HKy.field_pref_desc);
            z2 = false;
        }
        Log.i("MicroMsg.WalletPasswordSettingUI", "hideSwitch: %s, hideImMch: %s", Boolean.valueOf(z), Boolean.valueOf(z2));
        if (!z || !z2) {
            this.screen.m38do("wallet_switch_category", false);
        } else {
            this.screen.m38do("wallet_switch_category", true);
        }
        g.aAi();
        long longValue = ((Long) g.aAh().azQ().get(147457, (Object) 0L)).longValue();
        int i3 = R.string.ibx;
        if ((16 & longValue) != 0) {
            i3 = R.string.ibw;
        } else if ((longValue & 32) != 0) {
            i3 = R.string.ibv;
        }
        this.screen.bmg("wallet_delay_transfer_date").setSummary(i3);
        int a2 = ((com.tencent.mm.plugin.expt.b.b) g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.clicfg_wcpay_android_wallet_management_entry, 1);
        boolean z3 = CrashReportFactory.hasDebuger() || BuildInfo.IS_FLAVOR_RED;
        if (a2 != 0 || z3) {
            this.screen.m38do("wallet_function_settings", false);
        } else {
            this.screen.m38do("wallet_function_settings", true);
        }
        yd(false);
        Log.i("MicroMsg.WalletPasswordSettingUI", "updateExtraSectionData()");
        if (this.HKF != null && this.HKF.size() > 0) {
            for (Preference preference : this.HKF) {
                this.screen.e(preference);
            }
            this.HKF.clear();
        }
        int indexOf = this.screen.indexOf("wallet_lucky_money_refund_way");
        g.aAi();
        String str = (String) g.aAh().azQ().get(ar.a.USERINFO_PAY_MANAGE_EXTRA_SECTION_DATA_STRING_SYNC, "");
        if (!Util.isNullOrNil(str)) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                int i4 = indexOf;
                for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                    m.a bt = m.a.bt(jSONArray.getJSONObject(i5));
                    if (bt.HIw != null) {
                        Log.i("MicroMsg.WalletPasswordSettingUI", " Parse header ");
                        ehf ehf = bt.HIw;
                        PreferenceTitleCategory preferenceTitleCategory = new PreferenceTitleCategory(getContext());
                        preferenceTitleCategory.OZC = true;
                        preferenceTitleCategory.setTitle(com.tencent.mm.plugin.wallet_core.utils.g.a(getContext(), ehf, (g.a) null));
                        i2 = i4 + 1;
                        this.screen.a(preferenceTitleCategory, i2);
                        this.HKF.add(preferenceTitleCategory);
                    } else {
                        PreferenceSmallCategory preferenceSmallCategory = new PreferenceSmallCategory(getContext());
                        i2 = i4 + 1;
                        this.screen.a(preferenceSmallCategory, i2);
                        this.HKF.add(preferenceSmallCategory);
                    }
                    Iterator<ag> it = bt.HIv.iterator();
                    int i6 = i2;
                    while (it.hasNext()) {
                        final ag next = it.next();
                        Log.i("MicroMsg.WalletPasswordSettingUI", " mWalletPrefInfo.field_pref_key :%s ", next.field_pref_key);
                        AnonymousClass10 r8 = new Preference(getContext()) {
                            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI.AnonymousClass10 */

                            @Override // com.tencent.mm.ui.base.preference.Preference
                            public final void onBindView(View view) {
                                AppMethodBeat.i(214091);
                                super.onBindView(view);
                                if (this.OZp != null) {
                                    view.setOnClickListener(new View.OnClickListener() {
                                        /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI.AnonymousClass10.AnonymousClass1 */

                                        public final void onClick(View view) {
                                            AppMethodBeat.i(214090);
                                            com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                                            bVar.bm(view);
                                            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI$18$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                                            AnonymousClass10.this.OZp.a(null);
                                            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletPasswordSettingUI$18$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                                            AppMethodBeat.o(214090);
                                        }
                                    });
                                }
                                AppMethodBeat.o(214091);
                            }
                        };
                        r8.setLayoutResource(R.layout.b8j);
                        r8.setTitle(next.field_pref_title);
                        r8.setSummary(next.field_pref_desc);
                        r8.OZp = new Preference.b() {
                            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI.AnonymousClass11 */

                            @Override // com.tencent.mm.ui.base.preference.Preference.b
                            public final boolean a(Preference preference) {
                                AppMethodBeat.i(214092);
                                WalletPasswordSettingUI.a(WalletPasswordSettingUI.this, next);
                                WalletPasswordSettingUI.this.HKG = true;
                                AppMethodBeat.o(214092);
                                return true;
                            }
                        };
                        i6++;
                        this.screen.a(r8, i6);
                        this.HKF.add(r8);
                        Log.i("MicroMsg.WalletPasswordSettingUI", " add mWalletPrefInfo.field_pref_key :%s ", next.field_pref_key);
                    }
                    if (bt.HIx != null) {
                        Log.i("MicroMsg.WalletPasswordSettingUI", " Parse footer ");
                        ehf ehf2 = bt.HIx;
                        PreferenceFooterCategory preferenceFooterCategory = new PreferenceFooterCategory(getContext());
                        preferenceFooterCategory.OZC = true;
                        preferenceFooterCategory.setTitle(com.tencent.mm.plugin.wallet_core.utils.g.a(getContext(), ehf2, (g.a) null));
                        i4 = i6 + 1;
                        this.screen.a(preferenceFooterCategory, i4);
                        this.HKF.add(preferenceFooterCategory);
                    } else {
                        i4 = i6 + 1;
                        PreferenceSmallCategory preferenceSmallCategory2 = new PreferenceSmallCategory(getContext());
                        this.screen.a(preferenceSmallCategory2, i4);
                        this.HKF.add(preferenceSmallCategory2);
                    }
                }
                this.screen.notifyDataSetChanged();
            } catch (JSONException e2) {
                Log.e("MicroMsg.WalletPasswordSettingUI", " parse EXTRA_Data failed :%s", e2.getMessage());
            }
        }
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(69765);
    }

    private void fPo() {
        AppMethodBeat.i(69766);
        if (t.fQI().fRm() || t.fQI().fRl()) {
            this.screen.m38do("wallet_biometric_pay", true);
            AppMethodBeat.o(69766);
            return;
        }
        com.tencent.mm.plugin.fingerprint.d.a aVar = (com.tencent.mm.plugin.fingerprint.d.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fingerprint.d.a.class);
        if (com.tencent.mm.plugin.wallet.b.a.fPB() && com.tencent.mm.plugin.wallet.b.a.fPC()) {
            this.HKn.setTitle(R.string.im7);
            this.HKn.setSummary(R.string.im6);
            if (aVar.dJR()) {
                this.HKn.S(getString(R.string.i8n));
            } else if (aVar.dJO()) {
                this.HKn.S(getString(R.string.i8o));
            } else {
                this.HKn.S(getString(R.string.hk4));
            }
            this.screen.m38do("wallet_biometric_pay", false);
            AppMethodBeat.o(69766);
        } else if (com.tencent.mm.plugin.wallet.b.a.fPB()) {
            this.HKn.setTitle(R.string.im5);
            this.HKn.setSummary(R.string.im4);
            if (aVar.dJO()) {
                this.HKn.S(getString(R.string.hjt));
            } else {
                this.HKn.S(getString(R.string.hk4));
            }
            this.screen.m38do("wallet_biometric_pay", false);
            AppMethodBeat.o(69766);
        } else if (com.tencent.mm.plugin.wallet.b.a.fPC()) {
            this.HKn.setTitle(R.string.im3);
            this.HKn.setSummary(R.string.im2);
            if (aVar.dJR()) {
                this.HKn.S(getString(R.string.hjt));
            } else {
                this.HKn.S(getString(R.string.hk4));
            }
            this.screen.m38do("wallet_biometric_pay", false);
            AppMethodBeat.o(69766);
        } else {
            this.screen.m38do("wallet_biometric_pay", true);
            AppMethodBeat.o(69766);
        }
    }

    private void yc(boolean z) {
        AppMethodBeat.i(69767);
        m mVar = new m();
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(mVar, 0);
        this.HKB = true;
        if (z) {
            this.tipDialog = com.tencent.mm.wallet_core.ui.h.a((Context) this, false, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI.AnonymousClass6 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(69738);
                    if (WalletPasswordSettingUI.this.tipDialog != null) {
                        WalletPasswordSettingUI.this.tipDialog.dismiss();
                    }
                    AppMethodBeat.o(69738);
                }
            });
        }
        AppMethodBeat.o(69767);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        ejs ejs;
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(69768);
        Log.i("MicroMsg.WalletPasswordSettingUI", "errType:" + i2 + " errCode:" + i3 + " errMsg:" + str + " scenetype:" + qVar.getType());
        if (i2 == 0 && i3 == 0) {
            if (qVar instanceof ad) {
                fPn();
                fPj();
                AppMethodBeat.o(69768);
                return;
            } else if (qVar instanceof m) {
                fPn();
                m mVar = (m) qVar;
                Log.i("MicroMsg.WalletPasswordSettingUI", "isShowDeduct=" + mVar.HIp);
                this.HKu = mVar.HIt;
                this.HKw = t.fQH().aVD("wallet_open_auto_pay");
                if (this.HKw == null || this.HKw.field_is_show != 1) {
                    this.screen.m38do("wallet_open_auto_pay", true);
                } else {
                    Log.i("MicroMsg.WalletPasswordSettingUI", "deduct info from cgi is not null");
                    this.HKt = this.HKw.field_pref_url;
                    aZ(this.HKw.field_pref_title, this.HKw.field_pref_url, this.HKw.field_tinyapp_path);
                }
                fPj();
                if (this.tipDialog != null) {
                    this.tipDialog.dismiss();
                }
                AppMethodBeat.o(69768);
                return;
            } else if (qVar instanceof aj) {
                this.HKv = ((aj) qVar).HQv;
                this.HKC = ((aj) qVar).HQA;
                if (this.HKC == 0) {
                    this.screen.m38do("wallet_delay_transfer_date", true);
                    AppMethodBeat.o(69768);
                    return;
                }
                if (!Util.isNullOrNil(this.HKv)) {
                    this.HKs.setTitle(this.HKv);
                } else {
                    Log.i("MicroMsg.WalletPasswordSettingUI", "use hardcode wording");
                }
                this.screen.m38do("wallet_delay_transfer_date", false);
                AppMethodBeat.o(69768);
                return;
            } else if (qVar instanceof f) {
                this.HKk = ((f) qVar).fOM();
                yd(true);
                Log.d("MicroMsg.WalletPasswordSettingUI", "mHbRefundConfig.getJSONObjectString().toString() :%s", this.HKk.fON());
                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_HB_REFUND_CONFIG_REFACTOR_STRING_SYNC, this.HKk.fON());
                AppMethodBeat.o(69768);
                return;
            } else if (qVar instanceof h) {
                h hVar = (h) qVar;
                if (hVar.HIk == null) {
                    hVar.HIk = new h.a();
                    hVar.HIk.pTZ = hVar.HIj.pTZ;
                    hVar.HIk.pUa = hVar.HIj.pUa;
                    hVar.HIk.pTt = hVar.HIj.pTt;
                    hVar.HIk.HIl = hVar.HIj.HIl;
                    hVar.HIk.HHX = hVar.HIj.HHX;
                    hVar.HIk.dQx = hVar.HIj.dQx;
                }
                this.HKz = hVar.HIk;
                ye(true);
                Log.i("MicroMsg.WalletPasswordSettingUI", "mMobileRemitSwitchConfig.getJSONObjectString().toString() :%s", this.HKz.fON());
                com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_MOBILE_REMITTANCE_SWITCH_CONFIG_STRING_SYNC, this.HKz.fON());
                AppMethodBeat.o(69768);
                return;
            } else if (qVar instanceof com.tencent.mm.plugin.wallet.pwd.a.g) {
                if (this.HKp != null && this.HKp.isShowing()) {
                    this.HKp.dismiss();
                }
                com.tencent.mm.plugin.wallet.pwd.a.g gVar = (com.tencent.mm.plugin.wallet.pwd.a.g) qVar;
                if (gVar.HIi == null) {
                    ejs = new ejs();
                } else {
                    ejs = gVar.HIi;
                }
                if (ejs == null) {
                    com.tencent.mm.ui.base.h.a((Context) this, Util.isNullOrNil(str) ? getString(R.string.ibn) : str, "", getResources().getString(R.string.f1r), false, (DialogInterface.OnClickListener) null).show();
                }
                Object[] objArr = new Object[5];
                objArr[0] = Integer.valueOf(ejs.pTZ);
                objArr[1] = ejs.pUa;
                if (ejs.LgT == null) {
                    z = true;
                } else {
                    z = false;
                }
                objArr[2] = Boolean.valueOf(z);
                objArr[3] = Integer.valueOf(ejs.NiZ);
                objArr[4] = ejs.dQx;
                Log.i("MicroMsg.WalletPasswordSettingUI", "NetSceneMobileRemitChangeSwitch ret_code:%s ret_msg:%s real_name_info:%s resp.grant_flag：%s resp.wording:%s", objArr);
                int i4 = ejs.NiZ;
                String str2 = ejs.dQx;
                if (Util.isNullOrNil(str2)) {
                    Log.i("MicroMsg.WalletPasswordSettingUI", "summaryWording is null");
                } else {
                    this.HKE = i4;
                    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_MOBILE_REMITTANCE_SWITCH_GRANT_FLAG_INT_SYNC, Integer.valueOf(i4));
                    this.HKz.dQx = str2;
                    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_MOBILE_REMITTANCE_SWITCH_CONFIG_STRING_SYNC, this.HKz.fON());
                    aVc(str2);
                    this.screen.notifyDataSetChanged();
                }
                if (ejs.pTZ != 0) {
                    if (ejs.pTZ == 416) {
                        if (ejs.LgT != null) {
                            Bundle bundle = new Bundle();
                            bundle.putString("realname_verify_process_jump_activity", ".pwd.ui.WalletPasswordSettingUI");
                            bundle.putString("realname_verify_process_jump_plugin", "wallet");
                            int i5 = ejs.pTZ;
                            dju dju = ejs.LgT;
                            new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI.AnonymousClass8 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(69741);
                                    Log.i("MicroMsg.WalletPasswordSettingUI", "RealnameVerifyUtil cancel");
                                    AppMethodBeat.o(69741);
                                }
                            };
                            com.tencent.mm.plugin.wallet_core.id_verify.util.a.a(this, i5, dju, bundle, 1012);
                        } else {
                            com.tencent.mm.ui.base.h.a((Context) this, Util.isNullOrNil(ejs.pUa) ? getString(R.string.ibn) : ejs.pUa, "", getResources().getString(R.string.f1r), false, (DialogInterface.OnClickListener) null).show();
                        }
                    } else if (ejs.Nja != null) {
                        Log.i("MicroMsg.WalletPasswordSettingUI", "NetSceneMobileRemitChangeSwitch show jump_win");
                        l.a(getContext(), ejs.Nja, (Object) null, new l.a() {
                            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI.AnonymousClass9 */

                            @Override // com.tencent.mm.wallet_core.c.l.a
                            public final void eNp() {
                                AppMethodBeat.i(163868);
                                Log.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:none");
                                AppMethodBeat.o(163868);
                            }

                            @Override // com.tencent.mm.wallet_core.c.l.a
                            public final void eNw() {
                                AppMethodBeat.i(69742);
                                Log.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:exit");
                                WalletPasswordSettingUI.this.finish();
                                AppMethodBeat.o(69742);
                            }

                            @Override // com.tencent.mm.wallet_core.c.l.a
                            public final void dP(Object obj) {
                                AppMethodBeat.i(69743);
                                Log.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:continue");
                                AppMethodBeat.o(69743);
                            }

                            @Override // com.tencent.mm.wallet_core.c.l.a
                            public final int eNq() {
                                return 1149;
                            }

                            @Override // com.tencent.mm.wallet_core.c.l.a
                            public final void eNr() {
                                AppMethodBeat.i(163869);
                                Log.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click");
                                AppMethodBeat.o(163869);
                            }

                            @Override // com.tencent.mm.wallet_core.c.l.a
                            public final void eNs() {
                                AppMethodBeat.i(163870);
                                Log.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:former_page");
                                AppMethodBeat.o(163870);
                            }
                        });
                    } else if (ejs.pTZ != 0) {
                        com.tencent.mm.ui.base.h.a((Context) this, Util.isNullOrNil(ejs.pUa) ? getString(R.string.ibn) : ejs.pUa, "", getResources().getString(R.string.f1r), false, (DialogInterface.OnClickListener) null).show();
                    }
                    CheckBoxPreference checkBoxPreference = this.HKo;
                    if (this.HKo.isChecked()) {
                        z2 = false;
                    }
                    checkBoxPreference.setChecked(z2);
                    this.screen.notifyDataSetChanged();
                    AppMethodBeat.o(69768);
                    return;
                } else if (ejs.Nja != null) {
                    Log.i("MicroMsg.WalletPasswordSettingUI", "NetSceneMobileRemitChangeSwitch show jump_win");
                    l.a(getContext(), ejs.Nja, (Object) null, new l.a() {
                        /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI.AnonymousClass7 */

                        @Override // com.tencent.mm.wallet_core.c.l.a
                        public final void eNp() {
                            AppMethodBeat.i(163865);
                            Log.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:none");
                            AppMethodBeat.o(163865);
                        }

                        @Override // com.tencent.mm.wallet_core.c.l.a
                        public final void eNw() {
                            AppMethodBeat.i(69739);
                            Log.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:exit");
                            WalletPasswordSettingUI.this.finish();
                            AppMethodBeat.o(69739);
                        }

                        @Override // com.tencent.mm.wallet_core.c.l.a
                        public final void dP(Object obj) {
                            AppMethodBeat.i(69740);
                            Log.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:continue");
                            AppMethodBeat.o(69740);
                        }

                        @Override // com.tencent.mm.wallet_core.c.l.a
                        public final int eNq() {
                            return 1149;
                        }

                        @Override // com.tencent.mm.wallet_core.c.l.a
                        public final void eNr() {
                            AppMethodBeat.i(163866);
                            Log.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click");
                            AppMethodBeat.o(163866);
                        }

                        @Override // com.tencent.mm.wallet_core.c.l.a
                        public final void eNs() {
                            AppMethodBeat.i(163867);
                            Log.i("MicroMsg.WalletPasswordSettingUI", "jump_win dialog click jumpItem.action:JUMPITEM_ACTION_FORMER_PAGE");
                            AppMethodBeat.o(163867);
                        }
                    });
                    CheckBoxPreference checkBoxPreference2 = this.HKo;
                    if (this.HKo.isChecked()) {
                        z2 = false;
                    }
                    checkBoxPreference2.setChecked(z2);
                    this.screen.notifyDataSetChanged();
                    AppMethodBeat.o(69768);
                    return;
                } else if (this.HKo.isChecked()) {
                    com.tencent.mm.kernel.g.aAi();
                    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_MOBILE_REMITTANCE_BIND_MOBILE_TRANSFER_INT_SYNC, (Object) 1);
                    AppMethodBeat.o(69768);
                    return;
                } else {
                    com.tencent.mm.kernel.g.aAi();
                    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_MOBILE_REMITTANCE_BIND_MOBILE_TRANSFER_INT_SYNC, (Object) 0);
                    AppMethodBeat.o(69768);
                    return;
                }
            }
        } else if (qVar instanceof aj) {
            Log.i("MicroMsg.WalletPasswordSettingUI", "net error, use hardcode wording");
            AppMethodBeat.o(69768);
            return;
        } else if (qVar instanceof f) {
            Log.i("MicroMsg.WalletPasswordSettingUI", "wallet_lucky_money_refund_way use cache");
            AppMethodBeat.o(69768);
            return;
        } else if (qVar instanceof f) {
            Log.i("MicroMsg.WalletPasswordSettingUI", "mobile_remit_switch use cache");
            AppMethodBeat.o(69768);
            return;
        } else if (qVar instanceof com.tencent.mm.plugin.wallet.pwd.a.g) {
            Log.i("MicroMsg.WalletPasswordSettingUI", "NetSceneMobileRemitChangeSwitch no success");
            if (this.HKp != null && this.HKp.isShowing()) {
                this.HKp.dismiss();
            }
            AppCompatActivity context = getContext();
            if (Util.isNullOrNil(str)) {
                str = getString(R.string.f1s);
            }
            u.makeText(context, str, 0).show();
            CheckBoxPreference checkBoxPreference3 = this.HKo;
            if (this.HKo.isChecked()) {
                z2 = false;
            }
            checkBoxPreference3.setChecked(z2);
            this.screen.notifyDataSetChanged();
        }
        AppMethodBeat.o(69768);
    }

    private void yd(boolean z) {
        AppMethodBeat.i(69769);
        if (this.HKk == null) {
            Log.i("MicroMsg.WalletPasswordSettingUI", "updateHbRefundPref() mHbRefundConfig == null");
            this.screen.m38do("wallet_lucky_money_refund_way", true);
        } else {
            Log.i("MicroMsg.WalletPasswordSettingUI", "updateHbRefundPref() disabled:%s retcode:%s entrance_name:%s", Boolean.valueOf(this.HKk.HIg), Integer.valueOf(this.HKk.dDN), this.HKk.HHX);
            if (this.HKk.HIg || !Util.isEqual(this.HKk.dDN, 0)) {
                this.screen.m38do("wallet_lucky_money_refund_way", true);
            } else if (Util.isNullOrNil(this.HKk.HHX)) {
                this.screen.m38do("wallet_lucky_money_refund_way", true);
                AppMethodBeat.o(69769);
                return;
            } else {
                IconPreference iconPreference = (IconPreference) this.screen.bmg("wallet_lucky_money_refund_way");
                iconPreference.setTitle(this.HKk.HHX);
                com.tencent.mm.kernel.g.aAi();
                long longValue = ((Long) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_EXT_PAY_SETTING_LONG_SYNC, (Object) 0L)).longValue() & 3;
                Log.i("MicroMsg.WalletPasswordSettingUI", "updateHbRefundPref() extStatus:%s", Long.toBinaryString(longValue));
                if (Util.isEqual(longValue, 2)) {
                    iconPreference.setSummary(this.HKk.HIb);
                } else {
                    iconPreference.setSummary(this.HKk.HHZ);
                }
                if (z && this.HKk.HHY) {
                    com.tencent.mm.kernel.g.aAi();
                    if (!((Boolean) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_WALLET_HB_REFUND_RED_DOT_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue()) {
                        iconPreference.alF(0);
                        com.tencent.mm.kernel.g.aAi();
                        com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_HB_REFUND_RED_DOT_BOOLEAN_SYNC, Boolean.TRUE);
                    } else {
                        iconPreference.alF(8);
                    }
                }
                this.screen.m38do("wallet_lucky_money_refund_way", false);
            }
        }
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(69769);
    }

    private void ye(boolean z) {
        CheckBoxPreference checkBoxPreference;
        boolean z2;
        AppMethodBeat.i(69770);
        Log.i("MicroMsg.WalletPasswordSettingUI", "updateMobileRemitSwitchPref() fromCgi:%s", Boolean.valueOf(z));
        if (this.HKz == null) {
            Log.i("MicroMsg.WalletPasswordSettingUI", "updateMobileRemitSwitchPref() mMobileRemitSwitchConfig == null");
            this.screen.m38do("mobile_remit_switch", true);
        } else if (this.HKz.pTZ != 0 || !this.HKz.pTt) {
            this.screen.m38do("mobile_remit_switch", true);
            AppMethodBeat.o(69770);
            return;
        } else if (Util.isNullOrNil(this.HKz.HHX)) {
            this.screen.m38do("mobile_remit_switch", false);
            AppMethodBeat.o(69770);
            return;
        } else {
            this.HKo.setTitle(this.HKz.HHX);
            aVc(this.HKz.dQx);
            if (z) {
                CheckBoxPreference checkBoxPreference2 = this.HKo;
                z2 = this.HKz.HIl;
                checkBoxPreference = checkBoxPreference2;
            } else {
                com.tencent.mm.kernel.g.aAi();
                int intValue = ((Integer) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_MOBILE_REMITTANCE_BIND_MOBILE_TRANSFER_INT_SYNC, (Object) 0)).intValue();
                Log.i("MicroMsg.WalletPasswordSettingUI", "updateMobileRemitSwitchPref() mobileRemitSw:%s", Integer.valueOf(intValue));
                checkBoxPreference = this.HKo;
                z2 = intValue == 1;
            }
            checkBoxPreference.setChecked(z2);
            this.screen.m38do("mobile_remit_switch", false);
        }
        this.screen.notifyDataSetChanged();
        AppMethodBeat.o(69770);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(69771);
        super.onDestroy();
        EventCenter.instance.removeListener(this.HDJ);
        this.HKH.dead();
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.b(385, this);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.b(1477, this);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.b(1813, this);
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.b(1724, this);
        AppMethodBeat.o(69771);
    }

    private void aVc(String str) {
        AppMethodBeat.i(182520);
        if (Util.isNullOrNil(str)) {
            Log.i("MicroMsg.WalletPasswordSettingUI", "summaryWording is null");
            AppMethodBeat.o(182520);
        } else if (str.contains("wc_custom_link")) {
            SpannableString a2 = com.tencent.mm.pluginsdk.ui.span.l.a((Context) this, (CharSequence) str, 10, false, (Object) null);
            this.HKo.OZB = true;
            this.HKo.setSummary(a2);
            AppMethodBeat.o(182520);
        } else {
            this.HKo.setSummary(str);
            AppMethodBeat.o(182520);
        }
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        String string;
        AppMethodBeat.i(69758);
        if (z.aUo()) {
            string = getString(R.string.ims);
        } else {
            string = getString(R.string.imr);
        }
        setMMTitle(string);
        com.tencent.mm.wallet_core.ui.f.hhT();
        this.screen = getPreferenceScreen();
        this.screen.addPreferencesFromResource(fPk());
        this.HKr = (IconPreference) this.screen.bmg("wallet_open_auto_pay");
        this.HKs = this.screen.bmg("wallet_delay_transfer_date");
        com.tencent.mm.kernel.g.aAi();
        if (!((Boolean) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_WALLET_PAY_DEDUCT_IS_NEW_BOOLEAN_SYNC, Boolean.TRUE)).booleanValue()) {
            this.HKr.gZ(getString(R.string.x4), R.drawable.amr);
            this.HKr.alE(0);
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLET_PAY_DEDUCT_IS_NEW_BOOLEAN_SYNC, Boolean.TRUE);
        }
        this.HKm = (CheckBoxPreference) this.screen.bmg("wallet_fingerprint_switch");
        this.HKn = (RightBelowPreference) this.screen.bmg("wallet_biometric_pay");
        this.HKo = (CheckBoxPreference) this.screen.bmg("mobile_remit_switch");
        fPn();
        this.screen.m38do("nfc_idpay", true);
        this.screen.m38do("wallet_open_auto_pay", true);
        this.screen.m38do("wallet_universal_pay_order", true);
        this.screen.m38do("wallet_lucky_money_refund_way", true);
        fPj();
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI.AnonymousClass14 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(69747);
                WalletPasswordSettingUI.this.finish();
                AppMethodBeat.o(69747);
                return true;
            }
        });
        if (com.tencent.mm.plugin.wallet.b.a.fPC()) {
            com.tencent.mm.plugin.report.service.h.INSTANCE.a(15817, 0);
        }
        AppMethodBeat.o(69758);
    }

    static /* synthetic */ void a(WalletPasswordSettingUI walletPasswordSettingUI) {
        AppMethodBeat.i(69772);
        com.tencent.mm.ui.base.h.a((Context) walletPasswordSettingUI, false, walletPasswordSettingUI.getResources().getString(R.string.dbu), "", walletPasswordSettingUI.getResources().getString(R.string.x_), walletPasswordSettingUI.getResources().getString(R.string.sz), (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI.AnonymousClass17 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(69752);
                final Dialog c2 = com.tencent.mm.wallet_core.ui.h.c(WalletPasswordSettingUI.this.getContext(), false, null);
                final ce ceVar = new ce();
                ceVar.callback = new Runnable() {
                    /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI.AnonymousClass17.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(69751);
                        if (ceVar.dFp != null) {
                            if (c2 != null) {
                                c2.dismiss();
                            }
                            if (ceVar.dFp.retCode == 0) {
                                WalletPasswordSettingUI.e(WalletPasswordSettingUI.this);
                                com.tencent.mm.kernel.g.aAi();
                                com.tencent.mm.kernel.g.aAg().hqi.a(new ad(null, 19), 0);
                                AppMethodBeat.o(69751);
                                return;
                            }
                            WalletPasswordSettingUI.f(WalletPasswordSettingUI.this);
                            WalletPasswordSettingUI.g(WalletPasswordSettingUI.this);
                        }
                        AppMethodBeat.o(69751);
                    }
                };
                EventCenter.instance.asyncPublish(ceVar, WalletPasswordSettingUI.this.getMainLooper());
                AppMethodBeat.o(69752);
            }
        }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(69736);
                WalletPasswordSettingUI.f(WalletPasswordSettingUI.this);
                AppMethodBeat.o(69736);
            }
        });
        AppMethodBeat.o(69772);
    }

    static /* synthetic */ void b(WalletPasswordSettingUI walletPasswordSettingUI) {
        AppMethodBeat.i(69773);
        walletPasswordSettingUI.yb(false);
        final com.tencent.mm.plugin.fingerprint.d.a aVar = (com.tencent.mm.plugin.fingerprint.d.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fingerprint.d.a.class);
        com.tencent.mm.ui.base.h.a((Context) walletPasswordSettingUI, walletPasswordSettingUI.getResources().getString(R.string.imq), "", walletPasswordSettingUI.getResources().getString(aVar.dJW() ? R.string.imp : R.string.x_), walletPasswordSettingUI.getString(R.string.sz), true, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI.AnonymousClass3 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(69737);
                Log.i("MicroMsg.WalletPasswordSettingUI", "user click the button to set system fingerprint");
                aVar.fK(WalletPasswordSettingUI.this);
                AppMethodBeat.o(69737);
            }
        }, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI.AnonymousClass4 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        });
        AppMethodBeat.o(69773);
    }

    static /* synthetic */ void c(WalletPasswordSettingUI walletPasswordSettingUI) {
        AppMethodBeat.i(69774);
        walletPasswordSettingUI.yb(false);
        com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fingerprint.d.a.class);
        com.tencent.mm.ui.base.h.a(walletPasswordSettingUI, walletPasswordSettingUI.getResources().getString(R.string.imo), "", walletPasswordSettingUI.getString(R.string.imn), new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletPasswordSettingUI.AnonymousClass5 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
            }
        });
        AppMethodBeat.o(69774);
    }

    static /* synthetic */ void f(WalletPasswordSettingUI walletPasswordSettingUI) {
        AppMethodBeat.i(69778);
        com.tencent.mm.plugin.fingerprint.d.a aVar = (com.tencent.mm.plugin.fingerprint.d.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fingerprint.d.a.class);
        if (walletPasswordSettingUI.HKm.isChecked() != aVar.dJO()) {
            walletPasswordSettingUI.yb(aVar.dJO());
            AppMethodBeat.o(69778);
            return;
        }
        AppMethodBeat.o(69778);
    }

    static /* synthetic */ void g(WalletPasswordSettingUI walletPasswordSettingUI) {
        AppMethodBeat.i(69779);
        com.tencent.mm.ui.base.h.c(walletPasswordSettingUI, walletPasswordSettingUI.getResources().getString(R.string.dbw), "", true);
        AppMethodBeat.o(69779);
    }
}
