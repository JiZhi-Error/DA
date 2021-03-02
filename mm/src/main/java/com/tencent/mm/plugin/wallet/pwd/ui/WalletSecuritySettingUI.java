package com.tencent.mm.plugin.wallet.pwd.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.av.r;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.g.b.a.kz;
import com.tencent.mm.plugin.wallet.pwd.a.n;
import com.tencent.mm.plugin.wallet.pwd.a.u;
import com.tencent.mm.pluginsdk.model.app.q;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.e;
import com.tencent.mm.ui.widget.a.d;
import com.tencent.mm.wallet_core.c.ad;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class WalletSecuritySettingUI extends MMPreference implements i {
    private Map<String, r.a> Cmg = new HashMap();
    private boolean HKY = true;
    private WalletSecuritySettingHeaderPref HKZ;
    private IconPreference HLa;
    private IconPreference HLb;
    private IconPreference HLc;
    private IconPreference HLd;
    private IconPreference HLe;
    private b HLf;
    private g HLg;
    private f HLh;
    private c HLi;
    private a HLj;
    private ProgressDialog HLk;
    private int gwE = 0;
    private com.tencent.mm.ui.base.preference.f screen;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public WalletSecuritySettingUI() {
        AppMethodBeat.i(69801);
        AppMethodBeat.o(69801);
    }

    /* access modifiers changed from: package-private */
    public class b {
        String AAU;
        String HLp;
        String HLq;
        String HLr;
        String desc;
        int jumpType;
        String title;

        private b() {
        }

        /* synthetic */ b(WalletSecuritySettingUI walletSecuritySettingUI, byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    public class f {
        String AAU;
        String HLC;
        String HLD;
        String HLp;
        String HLq;
        String desc;
        int jumpType;
        int status;
        String title;

        private f() {
        }

        /* synthetic */ f(WalletSecuritySettingUI walletSecuritySettingUI, byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    public class c {
        String AAU;
        String HLp;
        String HLs;
        String HLt;
        String HLu;
        String desc;
        int status;
        String title;

        public final String fPv() {
            AppMethodBeat.i(214097);
            Log.d("MicroMsg.WalletSecuritySettingUI", "check status2: %s, %s", Integer.valueOf(this.status), Integer.valueOf(hashCode()));
            if (this.status == 0) {
                String str = this.HLs;
                AppMethodBeat.o(214097);
                return str;
            } else if (this.status == 1) {
                String str2 = this.HLt;
                AppMethodBeat.o(214097);
                return str2;
            } else if (this.status == 3) {
                AppMethodBeat.o(214097);
                return null;
            } else {
                String str3 = this.HLu;
                AppMethodBeat.o(214097);
                return str3;
            }
        }

        c() {
        }

        public final void hJ(Context context) {
            AppMethodBeat.i(214098);
            if (q.s(context, "com.tencent.qqpimsecure")) {
                this.status = 3;
                h.RTc.c(new Runnable() {
                    /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletSecuritySettingUI.c.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(214096);
                        final boolean fOQ = u.fOQ();
                        WalletSecuritySettingUI.this.runOnUiThread(new Runnable() {
                            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletSecuritySettingUI.c.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                AppMethodBeat.i(214095);
                                c cVar = c.this;
                                boolean z = fOQ;
                                if (WalletSecuritySettingUI.this.HLi != null) {
                                    if (z) {
                                        cVar.status = 2;
                                    } else {
                                        cVar.status = 1;
                                    }
                                    Log.d("MicroMsg.WalletSecuritySettingUI", "check status: %s %s", Integer.valueOf(cVar.status), Integer.valueOf(cVar.hashCode()));
                                    String fPv = WalletSecuritySettingUI.this.HLi.fPv();
                                    if (!Util.isNullOrNil(fPv)) {
                                        WalletSecuritySettingUI.this.HLb.setSummary(fPv);
                                    }
                                    WalletSecuritySettingUI.this.screen.notifyDataSetChanged();
                                }
                                AppMethodBeat.o(214095);
                            }
                        });
                        AppMethodBeat.o(214096);
                    }
                }, "check_qq_security_status");
                AppMethodBeat.o(214098);
                return;
            }
            this.status = 0;
            AppMethodBeat.o(214098);
        }

        public final String getUrl() {
            AppMethodBeat.i(69798);
            if (this.status == 0) {
                String lt = lt("qqpimsecurestatus", "not_installed");
                AppMethodBeat.o(69798);
                return lt;
            } else if (this.status == 2) {
                String lt2 = lt("qqpimsecurestatus", "runing");
                AppMethodBeat.o(69798);
                return lt2;
            } else if (this.status == 1) {
                String lt3 = lt("qqpimsecurestatus", "not_run");
                AppMethodBeat.o(69798);
                return lt3;
            } else {
                String lt4 = lt("qqpimsecurestatus", "not_run");
                AppMethodBeat.o(69798);
                return lt4;
            }
        }

        private String lt(String str, String str2) {
            AppMethodBeat.i(69799);
            String uri = Uri.parse(this.HLp).buildUpon().appendQueryParameter(str, str2).build().toString();
            AppMethodBeat.o(69799);
            return uri;
        }
    }

    static class e {
        String Bah;
        d HLA;
        d HLB;
        String dQx;
        String title;

        e() {
        }
    }

    static class d {
        String HLy;
        String HLz;
        String Hws;
        String pTK;
        int uSc;

        private d() {
        }

        public static d bw(JSONObject jSONObject) {
            AppMethodBeat.i(69800);
            if (jSONObject == null) {
                AppMethodBeat.o(69800);
                return null;
            }
            d dVar = new d();
            dVar.pTK = jSONObject.optString("button_wording");
            dVar.uSc = jSONObject.optInt("jump_type");
            dVar.HLy = jSONObject.optString("jump_h5_url");
            dVar.HLz = jSONObject.optString("tinyapp_name");
            dVar.Hws = jSONObject.optString("tinyapp_path");
            AppMethodBeat.o(69800);
            return dVar;
        }
    }

    /* access modifiers changed from: package-private */
    public class g {
        String AAU;
        String HLE;
        boolean HLF;
        String desc;
        int status;
        String title;

        private g() {
        }

        /* synthetic */ g(WalletSecuritySettingUI walletSecuritySettingUI, byte b2) {
            this();
        }
    }

    /* access modifiers changed from: package-private */
    public class a {
        String HLo;
        String desc;
        String icon;
        int switchState;
        String title;

        private a() {
        }

        /* synthetic */ a(WalletSecuritySettingUI walletSecuritySettingUI, byte b2) {
            this();
        }
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(69802);
        super.onCreate(bundle);
        this.gwE = getIntent().getIntExtra("wallet_lock_jsapi_scene", 0);
        kz kzVar = new kz();
        kzVar.eEH = 11;
        kzVar.eXI = 1;
        kzVar.eXJ = (long) this.gwE;
        kzVar.bfK();
        initView();
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletSecuritySettingUI.AnonymousClass1 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(69790);
                WalletSecuritySettingUI.this.finish();
                AppMethodBeat.o(69790);
                return false;
            }
        });
        if (com.tencent.mm.compatible.util.d.oD(23)) {
            getWindow().setStatusBarColor(getResources().getColor(R.color.afz));
            updataStatusBarIcon(ao.isDarkMode());
        }
        AppMethodBeat.o(69802);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public int getResourceId() {
        return -1;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(69803);
        super.initView();
        this.screen = getPreferenceScreen();
        if (this.screen != null) {
            this.screen.addPreferencesFromResource(R.xml.di);
        }
        com.tencent.mm.kernel.g.aAi();
        String str = (String) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_WALLETLOCK_CURRENT_JSON_TYPE_STRING_SYNC, "");
        if (!Util.isNullOrNil(str)) {
            try {
                bv(new JSONObject(str));
                AppMethodBeat.o(69803);
                return;
            } catch (Exception e2) {
                Log.printErrStackTrace("MicroMsg.WalletSecuritySettingUI", e2, "", new Object[0]);
            }
        }
        AppMethodBeat.o(69803);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity, com.tencent.mm.ui.base.preference.MMPreference
    public void onResume() {
        AppMethodBeat.i(69804);
        super.onResume();
        this.HKZ = (WalletSecuritySettingHeaderPref) this.screen.bmg("wallet_security_basic_info");
        if (this.HKZ != null) {
            WalletSecuritySettingHeaderPref walletSecuritySettingHeaderPref = this.HKZ;
            AnonymousClass2 r4 = new View.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletSecuritySettingUI.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(69791);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pwd/ui/WalletSecuritySettingUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    if (WalletSecuritySettingUI.this.HLf == null || !Util.isNullOrNil(WalletSecuritySettingUI.this.HLf.HLp)) {
                        if (WalletSecuritySettingUI.this.HLf != null && WalletSecuritySettingUI.this.HLf.jumpType == 1 && !Util.isNullOrNil(WalletSecuritySettingUI.this.HLf.HLp)) {
                            Intent intent = new Intent();
                            Log.i("MicroMsg.WalletSecuritySettingUI", "alvinluo jump url: %s", WalletSecuritySettingUI.this.HLf.HLp);
                            intent.putExtra("rawUrl", WalletSecuritySettingUI.this.HLf.HLp);
                            intent.putExtra(e.p.OzJ, true);
                            com.tencent.mm.wallet_core.ui.f.aA(WalletSecuritySettingUI.this.getContext(), intent);
                        } else if (WalletSecuritySettingUI.this.HLf != null && WalletSecuritySettingUI.this.HLf.jumpType == 2) {
                            Util.isNullOrNil(WalletSecuritySettingUI.this.HLf.HLq);
                        }
                        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletSecuritySettingUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                        AppMethodBeat.o(69791);
                        return;
                    }
                    Log.e("MicroMsg.WalletSecuritySettingUI", "alivnluo jump h5 url is null");
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletSecuritySettingUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(69791);
                }
            };
            Object[] objArr = new Object[1];
            objArr[0] = Boolean.valueOf(walletSecuritySettingHeaderPref.HKT == null);
            Log.v("MicroMsg.WalletSecuritySettingHeaderPref", "alvinluo details == null: %b", objArr);
            walletSecuritySettingHeaderPref.HKW = r4;
            if (walletSecuritySettingHeaderPref.HKT != null) {
                walletSecuritySettingHeaderPref.HKT.setOnClickListener(r4);
            }
            WalletSecuritySettingHeaderPref walletSecuritySettingHeaderPref2 = this.HKZ;
            AnonymousClass3 r42 = new View.OnClickListener() {
                /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletSecuritySettingUI.AnonymousClass3 */

                public final void onClick(View view) {
                    AppMethodBeat.i(69792);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/wallet/pwd/ui/WalletSecuritySettingUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Log.v("MicroMsg.WalletSecuritySettingUI", "alvinluo click close");
                    WalletSecuritySettingUI.this.finish();
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/wallet/pwd/ui/WalletSecuritySettingUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(69792);
                }
            };
            Object[] objArr2 = new Object[1];
            objArr2[0] = Boolean.valueOf(walletSecuritySettingHeaderPref2.hTd == null);
            Log.v("MicroMsg.WalletSecuritySettingHeaderPref", "alvinluo closeBtn == null: %b", objArr2);
            walletSecuritySettingHeaderPref2.HKX = r42;
            if (walletSecuritySettingHeaderPref2.hTd != null) {
                walletSecuritySettingHeaderPref2.hTd.setOnClickListener(r42);
            }
        }
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.a(385, this);
        if (this.HKY) {
            this.HLk = com.tencent.mm.ui.base.h.a((Context) this, getString(R.string.a06), false, (DialogInterface.OnCancelListener) null);
            this.HKY = false;
        }
        boolean dJO = ((com.tencent.mm.plugin.fingerprint.d.a) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.fingerprint.d.a.class)).dJO();
        com.tencent.mm.plugin.soter.d.e flM = com.tencent.mm.plugin.soter.d.d.flM();
        String str = flM.FhU;
        String str2 = flM.hFF;
        Log.i("MicroMsg.WalletSecuritySettingUI", "alvinluo getSecurityInfo isOpenTouchPay: %b", Boolean.valueOf(dJO));
        com.tencent.mm.kernel.g.azz().a(new n(dJO, str, str2), 0);
        AppMethodBeat.o(69804);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(69805);
        super.onPause();
        com.tencent.mm.kernel.g.aAi();
        com.tencent.mm.kernel.g.aAg().hqi.b(385, this);
        AppMethodBeat.o(69805);
    }

    private void fPp() {
        AppMethodBeat.i(69806);
        this.HKZ = (WalletSecuritySettingHeaderPref) this.screen.bmg("wallet_security_basic_info");
        if (this.HLf != null) {
            WalletSecuritySettingHeaderPref walletSecuritySettingHeaderPref = this.HKZ;
            String str = this.HLf.title;
            String str2 = this.HLf.desc;
            String str3 = this.HLf.HLr;
            walletSecuritySettingHeaderPref.sUf = str;
            walletSecuritySettingHeaderPref.HKU = str2;
            walletSecuritySettingHeaderPref.HKV = str3;
            walletSecuritySettingHeaderPref.updateView();
            if (Util.isNullOrNil(this.HLf.HLr)) {
                WalletSecuritySettingHeaderPref walletSecuritySettingHeaderPref2 = this.HKZ;
                if (walletSecuritySettingHeaderPref2.HKT != null) {
                    walletSecuritySettingHeaderPref2.HKT.setVisibility(8);
                }
            }
        }
        AppMethodBeat.o(69806);
    }

    private void fPq() {
        AppMethodBeat.i(69807);
        if (this.HLj == null) {
            this.screen.m38do("balance_privacy_info", true);
            AppMethodBeat.o(69807);
            return;
        }
        this.screen.m38do("balance_privacy_info", false);
        this.HLe = (IconPreference) this.screen.bmg("balance_privacy_info");
        a(this.HLj.icon, this.HLe);
        this.HLe.setTitle(this.HLj.title);
        this.HLe.setSummary(this.HLj.HLo);
        this.HLe.setDesc(this.HLj.desc);
        this.HLe.gLF();
        AppMethodBeat.o(69807);
    }

    private void fPr() {
        AppMethodBeat.i(69808);
        if (this.HLg == null) {
            this.screen.m38do("wallet_security_wallet_lock", true);
            AppMethodBeat.o(69808);
            return;
        }
        this.screen.m38do("wallet_security_wallet_lock", false);
        this.HLc = (IconPreference) this.screen.bmg("wallet_security_wallet_lock");
        a(this.HLg.AAU, this.HLc);
        this.HLc.setTitle(this.HLg.title);
        this.HLc.setSummary(this.HLg.HLE);
        this.HLc.setDesc(this.HLg.desc);
        this.HLc.gLF();
        AppMethodBeat.o(69808);
    }

    private void fPs() {
        boolean z;
        AppMethodBeat.i(69809);
        this.screen.m38do("wallet_security_digital_certificate", false);
        this.HLa = (IconPreference) this.screen.bmg("wallet_security_digital_certificate");
        ad.hhv();
        com.tencent.mm.kernel.g.aAi();
        if (((Integer) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_WALLETDIGITAL_CERT_SHOW_INT_SYNC, (Object) 0)).intValue() > 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
            this.screen.m38do("wallet_security_digital_certificate", true);
            AppMethodBeat.o(69809);
        } else if (this.HLa == null) {
            AppMethodBeat.o(69809);
        } else {
            if (!ad.hhv().hhw()) {
                this.HLa.setSummary(R.string.irq);
            } else if (!Util.isNullOrNil(ad.hhv().Ruq)) {
                this.HLa.setSummary(ad.hhv().Ruq);
            } else {
                this.HLa.setSummary(R.string.iro);
            }
            a(ad.hhv().Rur, this.HLa);
            this.HLa.setTitle(ad.hhv().Rup);
            this.HLa.setDesc(ad.hhv().Ruo);
            this.HLa.gLF();
            AppMethodBeat.o(69809);
        }
    }

    private void fPt() {
        AppMethodBeat.i(69810);
        this.HLb = (IconPreference) this.screen.bmg("wallet_security_pay_guard");
        if (this.HLi == null) {
            this.screen.m38do("wallet_security_pay_guard", true);
            AppMethodBeat.o(69810);
            return;
        }
        this.screen.m38do("wallet_security_pay_guard", false);
        a(this.HLi.AAU, this.HLb);
        this.HLb.setTitle(this.HLi.title);
        String fPv = this.HLi.fPv();
        if (!Util.isNullOrNil(fPv)) {
            this.HLb.setSummary(fPv);
        }
        this.HLb.setDesc(this.HLi.desc);
        this.HLb.gLF();
        AppMethodBeat.o(69810);
    }

    private void fPu() {
        AppMethodBeat.i(69811);
        this.screen = getPreferenceScreen();
        this.screen.m38do("wallet_security_safety_insurance", false);
        this.HLd = (IconPreference) this.screen.bmg("wallet_security_safety_insurance");
        if (this.HLd != null) {
            this.HLd.setSummary(R.string.irr);
        }
        if (this.HLh == null) {
            this.screen.m38do("wallet_security_safety_insurance", true);
            AppMethodBeat.o(69811);
            return;
        }
        a(this.HLh.AAU, this.HLd);
        this.HLd.setTitle(this.HLh.title);
        this.HLd.setSummary(this.HLh.HLC);
        this.HLd.setDesc(this.HLh.desc);
        this.HLd.gLF();
        AppMethodBeat.o(69811);
    }

    @Override // com.tencent.mm.ui.base.preference.MMPreference
    public boolean onPreferenceTreeClick(com.tencent.mm.ui.base.preference.f fVar, Preference preference) {
        AppMethodBeat.i(69812);
        if ("wallet_security_digital_certificate".equals(preference.mKey)) {
            kz kzVar = new kz();
            kzVar.eEH = 12;
            kzVar.eXI = 1;
            kzVar.bfK();
            com.tencent.mm.br.c.b(this, "wallet", ".pwd.ui.WalletDigitalCertUI", new Intent());
            AppMethodBeat.o(69812);
            return true;
        } else if ("wallet_security_pay_guard".equals(preference.mKey)) {
            if (this.HLi == null) {
                AppMethodBeat.o(69812);
                return true;
            }
            Log.i("MicroMsg.WalletSecuritySettingUI", "jump url %s ", this.HLi.getUrl());
            com.tencent.mm.wallet_core.ui.f.cO(this, this.HLi.getUrl());
            AppMethodBeat.o(69812);
            return true;
        } else if ("wallet_security_wallet_lock".equals(preference.mKey)) {
            ((com.tencent.mm.plugin.walletlock.a.b) com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.walletlock.a.b.class)).j(this, new Intent());
            AppMethodBeat.o(69812);
            return true;
        } else if (!"wallet_security_safety_insurance".equals(preference.mKey)) {
            if ("balance_privacy_info".equals(preference.mKey)) {
                if (this.HLj == null) {
                    AppMethodBeat.o(69812);
                    return true;
                }
                com.tencent.mm.br.c.V(this, "wallet", ".pwd.ui.WalletBalancePrivacyUI");
            }
            AppMethodBeat.o(69812);
            return false;
        } else if (this.HLh == null) {
            AppMethodBeat.o(69812);
            return true;
        } else {
            kz kzVar2 = new kz();
            kzVar2.eEH = 15;
            kzVar2.eXI = 1;
            kzVar2.bfK();
            if (this.HLh.jumpType == 2) {
                wq wqVar = new wq();
                wqVar.ecI.appVersion = 0;
                wqVar.ecI.userName = this.HLh.HLD;
                wqVar.ecI.ecK = this.HLh.HLq;
                EventCenter.instance.publish(wqVar);
            } else {
                Intent intent = new Intent();
                intent.putExtra("rawUrl", this.HLh.HLp);
                Log.d("MicroMsg.WalletSecuritySettingUI", "raw url: %s", intent.getStringExtra("rawUrl"));
                intent.putExtra(e.p.OzJ, true);
                com.tencent.mm.wallet_core.ui.f.aA(getContext(), intent);
            }
            AppMethodBeat.o(69812);
            return true;
        }
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        final e eVar;
        AppMethodBeat.i(69813);
        Log.v("MicroMsg.WalletSecuritySettingUI", "alvinluo errType: %d, errCode: %d, errMsg: %s", Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (qVar instanceof n) {
            JSONObject jSONObject = ((n) qVar).HIy;
            Log.v("MicroMsg.WalletSecuritySettingUI", "alvinluo json: %s", jSONObject);
            bv(jSONObject);
            if (jSONObject != null && !((Boolean) com.tencent.mm.kernel.g.aAh().azQ().get(ar.a.USERINFO_HAD_SHOW_WALLET_SECURITY_TIPS_BOOLEAN, Boolean.FALSE)).booleanValue()) {
                JSONObject optJSONObject = jSONObject.optJSONObject("dialog_info");
                if (optJSONObject == null) {
                    eVar = null;
                } else {
                    e eVar2 = new e();
                    eVar2.title = optJSONObject.optString("title");
                    eVar2.dQx = optJSONObject.optString("wording");
                    eVar2.Bah = optJSONObject.optString("logo");
                    eVar2.HLA = d.bw(optJSONObject.optJSONObject("left_btn"));
                    eVar2.HLB = d.bw(optJSONObject.optJSONObject("right_btn"));
                    eVar = eVar2;
                }
                if (eVar != null) {
                    d.a aVar = new d.a(this);
                    View inflate = LayoutInflater.from(this).inflate(R.layout.ca9, (ViewGroup) null, false);
                    ((CdnImageView) inflate.findViewById(R.id.jr6)).gI(eVar.Bah, R.drawable.crv);
                    ((TextView) inflate.findViewById(R.id.jr7)).setText(eVar.dQx);
                    aVar.Dl(true);
                    aVar.Dk(false);
                    aVar.hs(inflate);
                    aVar.bon(eVar.title);
                    if (eVar.HLB != null && !Util.isNullOrNil(eVar.HLB.pTK)) {
                        aVar.bou(eVar.HLB.pTK);
                        aVar.a(true, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletSecuritySettingUI.AnonymousClass4 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(69793);
                                if (eVar.HLB.uSc == 1) {
                                    com.tencent.mm.wallet_core.ui.f.o(WalletSecuritySettingUI.this.getContext(), eVar.HLB.HLy, true);
                                    AppMethodBeat.o(69793);
                                    return;
                                }
                                if (eVar.HLB.uSc == 2) {
                                    com.tencent.mm.wallet_core.ui.f.u(eVar.HLB.HLz, eVar.HLB.Hws, 0, 1000);
                                }
                                AppMethodBeat.o(69793);
                            }
                        });
                    }
                    if (eVar.HLA != null && !Util.isNullOrNil(eVar.HLA.pTK)) {
                        aVar.bov(eVar.HLA.pTK);
                        aVar.d(new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletSecuritySettingUI.AnonymousClass5 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(69794);
                                if (eVar.HLA.uSc == 1) {
                                    com.tencent.mm.wallet_core.ui.f.o(WalletSecuritySettingUI.this.getContext(), eVar.HLA.HLy, true);
                                    AppMethodBeat.o(69794);
                                } else if (eVar.HLA.uSc == 2) {
                                    com.tencent.mm.wallet_core.ui.f.u(eVar.HLA.HLz, eVar.HLA.Hws, 0, 1000);
                                    AppMethodBeat.o(69794);
                                } else {
                                    dialogInterface.dismiss();
                                    AppMethodBeat.o(69794);
                                }
                            }
                        });
                    }
                    aVar.hbn().show();
                    com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_HAD_SHOW_WALLET_SECURITY_TIPS_BOOLEAN, Boolean.TRUE);
                }
            }
        }
        AppMethodBeat.o(69813);
    }

    private void onError(String str) {
        AppMethodBeat.i(69814);
        if (this.HLk != null && this.HLk.isShowing()) {
            this.HLk.dismiss();
        }
        com.tencent.mm.ui.base.h.a((Context) this, str, "", false, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletSecuritySettingUI.AnonymousClass6 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(69795);
                WalletSecuritySettingUI.this.finish();
                AppMethodBeat.o(69795);
            }
        });
        AppMethodBeat.o(69814);
    }

    private void bv(JSONObject jSONObject) {
        AppMethodBeat.i(69815);
        if (jSONObject == null) {
            Log.e("MicroMsg.WalletSecuritySettingUI", "alvinluo security info json is null");
            onError(getString(R.string.ire));
            AppMethodBeat.o(69815);
            return;
        }
        try {
            this.screen = getPreferenceScreen();
            if (jSONObject.has("basic_security_item")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("basic_security_item");
                this.HLf = new b(this, (byte) 0);
                this.HLf.title = jSONObject2.optString("title");
                this.HLf.desc = jSONObject2.optString("desc");
                this.HLf.AAU = jSONObject2.optString("logo_url");
            }
            if (jSONObject.has("wallet_lock_info")) {
                JSONObject jSONObject3 = jSONObject.getJSONObject("wallet_lock_info");
                this.HLg = new g(this, (byte) 0);
                this.HLg.title = jSONObject3.optString("wallet_lock_title");
                this.HLg.desc = jSONObject3.optString("wallet_lock_desc");
                this.HLg.AAU = jSONObject3.getString("wallet_lock_logo_url");
                this.HLg.status = jSONObject3.optInt("wallet_lock_status");
                this.HLg.HLE = jSONObject3.optString("wallet_lock_status_name");
                this.HLg.HLF = jSONObject3.optBoolean("is_open_touch_pay", false);
            }
            if (jSONObject.has("property_security_info")) {
                JSONObject jSONObject4 = jSONObject.getJSONObject("property_security_info");
                this.HLh = new f(this, (byte) 0);
                this.HLh.title = jSONObject4.optString("title", "");
                this.HLh.desc = jSONObject4.optString("desc", "");
                this.HLh.AAU = jSONObject4.optString("logo_url", "");
                this.HLh.status = jSONObject4.optInt("status", 0);
                this.HLh.HLC = jSONObject4.optString("status_name");
                this.HLh.jumpType = jSONObject4.optInt("jump_type");
                this.HLh.HLp = jSONObject4.optString("jump_h5_url");
                this.HLh.HLD = jSONObject4.optString("tinyapp_username");
                this.HLh.HLq = jSONObject4.optString("tinyapp_path");
            }
            if (jSONObject.has("safe_manager_info")) {
                JSONObject jSONObject5 = jSONObject.getJSONObject("safe_manager_info");
                if (this.HLi == null) {
                    this.HLi = new c();
                }
                this.HLi.title = jSONObject5.optString("title", "");
                this.HLi.desc = jSONObject5.optString("desc", "");
                this.HLi.AAU = jSONObject5.optString("logo_url", "");
                this.HLi.HLt = jSONObject5.optString("installed_status_name");
                this.HLi.HLs = jSONObject5.optString("uninstall_status_name");
                this.HLi.HLu = jSONObject5.optString("protected_mode_name");
                this.HLi.HLp = jSONObject5.optString("jump_h5_url");
                this.HLi.hJ(this);
            }
            if (jSONObject.has("balance_privacy_info")) {
                JSONObject jSONObject6 = jSONObject.getJSONObject("balance_privacy_info");
                this.HLj = new a(this, (byte) 0);
                this.HLj.icon = jSONObject6.optString("icon", "");
                this.HLj.title = jSONObject6.optString("title", "");
                this.HLj.desc = jSONObject6.optString("desc", "");
                this.HLj.switchState = jSONObject6.optInt("switch_state");
                this.HLj.HLo = jSONObject6.optString("switch_state_info");
            }
            ad.hhv().ck(jSONObject);
            com.tencent.mm.kernel.g.aAi();
            com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.USERINFO_WALLETLOCK_CURRENT_JSON_TYPE_STRING_SYNC, jSONObject.toString());
            fPp();
            fPr();
            fPs();
            fPt();
            fPu();
            fPq();
            this.screen.notifyDataSetChanged();
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.WalletSecuritySettingUI", e2, "", new Object[0]);
            onError(getString(R.string.ire));
        }
        dismissDialog();
        AppMethodBeat.o(69815);
    }

    private void dismissDialog() {
        AppMethodBeat.i(69816);
        if (this.HLk != null && this.HLk.isShowing()) {
            this.HLk.dismiss();
        }
        AppMethodBeat.o(69816);
    }

    private void a(String str, final IconPreference iconPreference) {
        AppMethodBeat.i(69817);
        if (iconPreference == null) {
            AppMethodBeat.o(69817);
            return;
        }
        com.tencent.mm.av.q.bcQ();
        Bitmap EP = com.tencent.mm.av.d.EP(str);
        if (EP != null) {
            iconPreference.drawable = new BitmapDrawable(getContext().getResources(), EP);
            AppMethodBeat.o(69817);
            return;
        }
        if (!Util.isNullOrNil(str)) {
            AnonymousClass7 r0 = new r.a() {
                /* class com.tencent.mm.plugin.wallet.pwd.ui.WalletSecuritySettingUI.AnonymousClass7 */

                @Override // com.tencent.mm.av.r.a
                public final void a(String str, Bitmap bitmap, String str2) {
                    AppMethodBeat.i(69796);
                    Log.i("MicroMsg.WalletSecuritySettingUI", "alvinluo icon url: %s", str);
                    iconPreference.drawable = new BitmapDrawable(WalletSecuritySettingUI.this.getContext().getResources(), bitmap);
                    WalletSecuritySettingUI.this.Cmg.remove(str);
                    AppMethodBeat.o(69796);
                }
            };
            this.Cmg.put(str, r0);
            com.tencent.mm.av.q.bcU().a(str, r0);
        }
        AppMethodBeat.o(69817);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(69818);
        for (Map.Entry<String, r.a> entry : this.Cmg.entrySet()) {
            com.tencent.mm.av.q.bcU().b(entry.getKey(), entry.getValue());
        }
        this.Cmg.clear();
        super.onDestroy();
        AppMethodBeat.o(69818);
    }
}
