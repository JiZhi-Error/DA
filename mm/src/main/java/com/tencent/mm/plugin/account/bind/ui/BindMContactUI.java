package com.tencent.mm.plugin.account.bind.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.aw.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.a.b.a;
import com.tencent.mm.plugin.account.friend.ui.i;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.sdk.platformtools.WeChatSomeFeatureSwitch;
import com.tencent.mm.storage.ar;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;

public class BindMContactUI extends MMWizardActivity {
    private String countryCode = null;
    private String dSf;
    private int fromScene = 0;
    private boolean jZU = false;
    private String jbZ = null;
    private i kaH;
    private EditText kaW;
    private LinearLayout kaX;
    private TextView kaY;
    private TextView kaZ;
    private TextView kba;
    private String kbb = null;

    @Override // com.tencent.mm.ui.MMWizardActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void b(BindMContactUI bindMContactUI, String str) {
        AppMethodBeat.i(184511);
        bindMContactUI.SL(str);
        AppMethodBeat.o(184511);
    }

    static /* synthetic */ void g(BindMContactUI bindMContactUI) {
        AppMethodBeat.i(109905);
        bindMContactUI.bno();
        AppMethodBeat.o(109905);
    }

    @Override // com.tencent.mm.ui.MMWizardActivity, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(109895);
        super.onCreate(bundle);
        setMMTitle(R.string.aei);
        this.jbZ = Util.nullAs(getIntent().getStringExtra("country_name"), "");
        this.countryCode = Util.nullAs(getIntent().getStringExtra("couttry_code"), "");
        this.kbb = Util.nullAs(getIntent().getStringExtra("bindmcontact_shortmobile"), "");
        initView();
        AppMethodBeat.o(109895);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(109896);
        super.onDestroy();
        if (this.kaH != null) {
            this.kaH.recycle();
        }
        AppMethodBeat.o(109896);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(109897);
        if (i2 == 4) {
            bno();
            AppMethodBeat.o(109897);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(109897);
        return onKeyDown;
    }

    private void bno() {
        int i2;
        int i3;
        AppMethodBeat.i(109898);
        if (this.fromScene == 0 || this.fromScene == 3) {
            if (this.fromScene == 3) {
                i2 = R.string.ady;
            } else {
                i2 = R.string.adx;
            }
            if (this.fromScene == 3) {
                i3 = R.string.ae0;
            } else {
                i3 = R.string.adz;
            }
            h.a(this, i2, i3, new DialogInterface.OnClickListener() {
                /* class com.tencent.mm.plugin.account.bind.ui.BindMContactUI.AnonymousClass1 */

                public final void onClick(DialogInterface dialogInterface, int i2) {
                    AppMethodBeat.i(109886);
                    BindMContactUI.a(BindMContactUI.this);
                    AppMethodBeat.o(109886);
                }
            }, (DialogInterface.OnClickListener) null);
            AppMethodBeat.o(109898);
            return;
        }
        OHY.clear();
        ala(1);
        AppMethodBeat.o(109898);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        String str;
        AppMethodBeat.i(109899);
        this.jZU = getIntent().getBooleanExtra("KEnterFromBanner", false);
        this.fromScene = getIntent().getIntExtra("bind_scene", 0);
        Log.i("MicroMsg.BindMContactUI", "bindScene:%d", Integer.valueOf(this.fromScene));
        this.kaW = (EditText) findViewById(R.id.a47);
        this.kaX = (LinearLayout) findViewById(R.id.bgn);
        this.kaZ = (TextView) findViewById(R.id.bgp);
        this.kba = (TextView) findViewById(R.id.bgk);
        this.kaY = (TextView) findViewById(R.id.hlu);
        if (this.fromScene == 3) {
            String str2 = (String) g.aAh().azQ().get(6, (Object) null);
            if (!Util.isNullOrNil(str2)) {
                if (str2.startsWith("+")) {
                    str = PhoneFormater.extractCountryCode(str2);
                    if (!Util.isNullOrNil(str)) {
                        str2 = str2.substring(str.length() + 1);
                    }
                } else {
                    str = "86";
                }
                String formatNumber = new PhoneFormater().formatNumber(str, str2);
                this.kaY.setText(getString(R.string.adm, new Object[]{formatNumber}));
            }
        }
        if (WeChatSomeFeatureSwitch.onlyUSMobile()) {
            this.countryCode = "1";
            this.jbZ = b.bt(this.countryCode, getString(R.string.bj8));
        }
        if (!Util.isNullOrNil(this.jbZ)) {
            this.kaZ.setText(this.jbZ);
        }
        if (Util.isNullOrNil(this.countryCode)) {
            this.countryCode = getString(R.string.bj9);
            if (this.countryCode.startsWith("+")) {
                this.countryCode = this.countryCode.substring(1);
            }
        }
        this.kba.setText("+" + this.countryCode);
        if (this.kbb == null || this.kbb.equals("")) {
            g.aAk().postAtFrontOfWorker(new MMHandlerThread.IWaitWorkThread() {
                /* class com.tencent.mm.plugin.account.bind.ui.BindMContactUI.AnonymousClass2 */
                String num;

                @Override // com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread
                public final boolean onPostExecute() {
                    AppMethodBeat.i(109887);
                    if (Util.isNullOrNil(new StringBuilder().append((Object) BindMContactUI.this.kaW.getText()).toString().trim())) {
                        if (!Util.isNullOrNil(this.num)) {
                            BindMContactUI.this.kaW.setText(this.num);
                            BindMContactUI.this.kaW.setSelection(this.num.length());
                        } else {
                            BindMContactUI.this.kaW.setText("");
                        }
                    }
                    AppMethodBeat.o(109887);
                    return true;
                }

                @Override // com.tencent.mm.sdk.platformtools.MMHandlerThread.IWaitWorkThread
                public final boolean doInBackground() {
                    AppMethodBeat.i(109888);
                    AppMethodBeat.o(109888);
                    return true;
                }

                public final String toString() {
                    AppMethodBeat.i(109889);
                    String str = super.toString() + "|initView";
                    AppMethodBeat.o(109889);
                    return str;
                }
            });
        } else {
            this.kaW.setText(this.kbb);
            this.kaW.setSelection(this.kbb.length());
        }
        addTextOptionMenu(0, getString(R.string.x5), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.bind.ui.BindMContactUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                int i2;
                int i3 = 0;
                AppMethodBeat.i(109890);
                BindMContactUI.this.dSf = BindMContactUI.this.kba.getText().toString().trim() + Util.trimPhoneNumber(BindMContactUI.this.kaW.getText().toString());
                if (!com.tencent.mm.pluginsdk.b.bcT(BindMContactUI.this.dSf) || Util.trimPhoneNumber(BindMContactUI.this.kaW.getText().toString()).length() <= 0) {
                    h.n(BindMContactUI.this, R.string.ae_, R.string.zb);
                    AppMethodBeat.o(109890);
                } else {
                    int e2 = BindMContactUI.e(BindMContactUI.this);
                    Log.i("MicroMsg.BindMContactUI", "nextStep %d", Integer.valueOf(e2));
                    switch (e2) {
                        case 0:
                            h.c(BindMContactUI.this, BindMContactUI.this.getString(R.string.aem), "", true);
                            break;
                        case 1:
                            Log.i("MicroMsg.BindMContactUI", "do next, send sms to self");
                            BindMContactUI.b(BindMContactUI.this, BindMContactUI.this.dSf);
                            break;
                        case 2:
                            String bu = b.bu("86", BindMContactUI.this.getString(R.string.bj8));
                            boolean booleanValue = ((Boolean) g.aAh().azQ().get(ar.a.USERINFO_NEED_OPENPLATFORM_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
                            BindMContactUI bindMContactUI = BindMContactUI.this;
                            Object[] objArr = new Object[5];
                            objArr[0] = LocaleUtil.getApplicationLanguage();
                            objArr[1] = bu;
                            objArr[2] = "login";
                            objArr[3] = 1;
                            if (booleanValue) {
                                i2 = 1;
                            } else {
                                i2 = 0;
                            }
                            objArr[4] = Integer.valueOf(i2);
                            a.b(BindMContactUI.this, bindMContactUI.getString(R.string.ee8, objArr), 30767, true);
                            break;
                        case 3:
                            String bu2 = b.bu(BindMContactUI.this.countryCode, BindMContactUI.this.getString(R.string.bj8));
                            boolean booleanValue2 = ((Boolean) g.aAh().azQ().get(ar.a.USERINFO_NEED_OPENPLATFORM_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
                            BindMContactUI bindMContactUI2 = BindMContactUI.this;
                            Object[] objArr2 = new Object[5];
                            objArr2[0] = LocaleUtil.getApplicationLanguage();
                            objArr2[1] = bu2;
                            objArr2[2] = "login";
                            objArr2[3] = 1;
                            if (booleanValue2) {
                                i3 = 1;
                            }
                            objArr2[4] = Integer.valueOf(i3);
                            a.b(BindMContactUI.this, bindMContactUI2.getString(R.string.ee8, objArr2), 30766, true);
                            break;
                        case 4:
                            String bu3 = b.bu(BindMContactUI.this.countryCode, BindMContactUI.this.getString(R.string.bj8));
                            boolean booleanValue3 = ((Boolean) g.aAh().azQ().get(ar.a.USERINFO_NEED_OPENPLATFORM_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
                            BindMContactUI bindMContactUI3 = BindMContactUI.this;
                            Object[] objArr3 = new Object[5];
                            objArr3[0] = LocaleUtil.getApplicationLanguage();
                            objArr3[1] = bu3;
                            objArr3[2] = "bindMobileA";
                            objArr3[3] = 1;
                            if (booleanValue3) {
                                i3 = 1;
                            }
                            objArr3[4] = Integer.valueOf(i3);
                            a.b(BindMContactUI.this, bindMContactUI3.getString(R.string.ee8, objArr3), 30767, true);
                            break;
                        case 5:
                            String bu4 = b.bu(BindMContactUI.this.countryCode, BindMContactUI.this.getString(R.string.bj8));
                            boolean booleanValue4 = ((Boolean) g.aAh().azQ().get(ar.a.USERINFO_NEED_OPENPLATFORM_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
                            BindMContactUI bindMContactUI4 = BindMContactUI.this;
                            Object[] objArr4 = new Object[5];
                            objArr4[0] = LocaleUtil.getApplicationLanguage();
                            objArr4[1] = bu4;
                            objArr4[2] = "bindMobileB";
                            objArr4[3] = 1;
                            if (booleanValue4) {
                                i3 = 1;
                            }
                            objArr4[4] = Integer.valueOf(i3);
                            a.b(BindMContactUI.this, bindMContactUI4.getString(R.string.ee8, objArr4), 30767, true);
                            break;
                        case 6:
                            String bu5 = b.bu(BindMContactUI.this.countryCode, BindMContactUI.this.getString(R.string.bj8));
                            boolean booleanValue5 = ((Boolean) g.aAh().azQ().get(ar.a.USERINFO_NEED_OPENPLATFORM_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
                            BindMContactUI bindMContactUI5 = BindMContactUI.this;
                            Object[] objArr5 = new Object[5];
                            objArr5[0] = LocaleUtil.getApplicationLanguage();
                            objArr5[1] = bu5;
                            objArr5[2] = "bindMobileC";
                            objArr5[3] = 1;
                            if (booleanValue5) {
                                i3 = 1;
                            }
                            objArr5[4] = Integer.valueOf(i3);
                            a.b(BindMContactUI.this, bindMContactUI5.getString(R.string.ee8, objArr5), 30767, true);
                            break;
                        case 7:
                            String bu6 = b.bu(BindMContactUI.this.countryCode, BindMContactUI.this.getString(R.string.bj8));
                            boolean booleanValue6 = ((Boolean) g.aAh().azQ().get(ar.a.USERINFO_NEED_OPENPLATFORM_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
                            BindMContactUI bindMContactUI6 = BindMContactUI.this;
                            Object[] objArr6 = new Object[5];
                            objArr6[0] = LocaleUtil.getApplicationLanguage();
                            objArr6[1] = bu6;
                            objArr6[2] = "bindMobileD";
                            objArr6[3] = 1;
                            if (booleanValue6) {
                                i3 = 1;
                            }
                            objArr6[4] = Integer.valueOf(i3);
                            a.b(BindMContactUI.this, bindMContactUI6.getString(R.string.ee8, objArr6), 30767, true);
                            break;
                    }
                    AppMethodBeat.o(109890);
                }
                return true;
            }
        });
        this.kaW.requestFocus();
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.bind.ui.BindMContactUI.AnonymousClass4 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(109891);
                BindMContactUI.g(BindMContactUI.this);
                AppMethodBeat.o(109891);
                return true;
            }
        });
        this.kaX.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.bind.ui.BindMContactUI.AnonymousClass5 */

            public final void onClick(View view) {
                AppMethodBeat.i(109892);
                com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/BindMContactUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Intent intent = new Intent();
                intent.putExtra("country_name", BindMContactUI.this.jbZ);
                intent.putExtra("couttry_code", BindMContactUI.this.countryCode);
                com.tencent.mm.plugin.account.a.a.jRt.b(intent, (Activity) BindMContactUI.this);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/BindMContactUI$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(109892);
            }
        });
        AppMethodBeat.o(109899);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Bundle bundleExtra;
        AppMethodBeat.i(109900);
        super.onActivityResult(i2, i3, intent);
        switch (i3) {
            case 100:
                this.jbZ = Util.nullAs(intent.getStringExtra("country_name"), "");
                this.countryCode = Util.nullAs(intent.getStringExtra("couttry_code"), "");
                if (!this.jbZ.equals("")) {
                    this.kaZ.setText(this.jbZ);
                }
                if (!this.countryCode.equals("")) {
                    this.kba.setText("+" + this.countryCode);
                    break;
                }
                break;
        }
        switch (i2) {
            case 30765:
                if (!(intent == null || (bundleExtra = intent.getBundleExtra("result_data")) == null || !bundleExtra.getString("go_next", "").equals("birthdayComfirmOK"))) {
                    SL(this.dSf);
                    break;
                }
            case 30766:
                if (intent != null) {
                    Bundle bundleExtra2 = intent.getBundleExtra("result_data");
                    if (bundleExtra2 != null && bundleExtra2.getString("go_next", "").equals("agree_privacy")) {
                        MMHandlerThread.postToMainThreadDelayed(new Runnable() {
                            /* class com.tencent.mm.plugin.account.bind.ui.BindMContactUI.AnonymousClass6 */

                            public final void run() {
                                AppMethodBeat.i(109893);
                                a.b(BindMContactUI.this, BindMContactUI.this.getString(R.string.du9, new Object[]{LocaleUtil.getApplicationLanguage()}), 30765, true);
                                com.tencent.mm.ui.base.b.ke(BindMContactUI.this);
                                AppMethodBeat.o(109893);
                            }
                        }, 100);
                    }
                    AppMethodBeat.o(109900);
                    return;
                }
                break;
            case 30767:
                if (intent != null) {
                    Bundle bundleExtra3 = intent.getBundleExtra("result_data");
                    if (bundleExtra3 != null && bundleExtra3.getString("go_next", "").equals("agree_privacy")) {
                        SL(this.dSf);
                    }
                    AppMethodBeat.o(109900);
                    return;
                }
                break;
        }
        AppMethodBeat.o(109900);
    }

    private void SL(final String str) {
        AppMethodBeat.i(109901);
        if (this.kaH == null) {
            i.b bVar = i.b.BINDMOBILE;
            if (this.fromScene == 3) {
                bVar = i.b.CHANGEMOBILE;
            }
            this.kaH = new i(bVar, this, new i.a() {
                /* class com.tencent.mm.plugin.account.bind.ui.BindMContactUI.AnonymousClass7 */

                @Override // com.tencent.mm.plugin.account.friend.ui.i.a
                public final void h(int i2, Bundle bundle) {
                    AppMethodBeat.i(109894);
                    if (i2 == 1) {
                        Log.i("MicroMsg.BindMContactUI", "next to BindMContactVerifyUI for bind mobile");
                        Intent intent = new Intent(BindMContactUI.this, BindMContactVerifyUI.class);
                        intent.putExtra("bindmcontact_mobile", str);
                        intent.putExtra("KEnterFromBanner", BindMContactUI.this.jZU);
                        intent.putExtra("bind_scene", BindMContactUI.this.fromScene);
                        MMWizardActivity.ay(BindMContactUI.this, intent);
                    }
                    AppMethodBeat.o(109894);
                }
            });
        }
        this.kaH.Tm(str);
        AppMethodBeat.o(109901);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.j2;
    }

    static /* synthetic */ void a(BindMContactUI bindMContactUI) {
        AppMethodBeat.i(109902);
        bindMContactUI.ala(1);
        AppMethodBeat.o(109902);
    }

    static /* synthetic */ int e(BindMContactUI bindMContactUI) {
        String str;
        AppMethodBeat.i(184510);
        String nullAs = Util.nullAs((String) g.aAh().azQ().get(274436, (Object) null), WeChatBrands.AppInfo.LANG_CN);
        boolean equalsIgnoreCase = WeChatBrands.AppInfo.LANG_CN.equalsIgnoreCase(nullAs);
        boolean Pi = b.Pi(nullAs);
        Log.i("MicroMsg.BindMContactUI", "regCountry %s, gdpr %s", nullAs, Boolean.valueOf(Pi));
        String str2 = (String) g.aAh().azQ().get(6, (Object) null);
        String str3 = "";
        if (!Util.isNullOrNil(str2)) {
            str = PhoneFormater.extractCountryCode(str2);
            str3 = b.bu(str, bindMContactUI.getString(R.string.bj8));
        } else {
            str = str2;
        }
        if (Util.isNullOrNil(str3)) {
            str3 = nullAs;
        }
        boolean equalsIgnoreCase2 = WeChatBrands.AppInfo.LANG_CN.equalsIgnoreCase(str3);
        boolean Pi2 = b.Pi(str3);
        Log.i("MicroMsg.BindMContactUI", "curBindMobile %s, curBindIso %s, gdpr %s", str, str3, Boolean.valueOf(Pi2));
        boolean equals = bindMContactUI.countryCode.equals("86");
        boolean Pj = b.Pj(bindMContactUI.countryCode);
        Log.i("MicroMsg.BindMContactUI", "countryCode %s, gdpr %s", bindMContactUI.countryCode, Boolean.valueOf(Pj));
        if (equals) {
            if (d.KyP) {
                if (equalsIgnoreCase) {
                    if (!equalsIgnoreCase2) {
                        if (Pi2) {
                            AppMethodBeat.o(184510);
                            return 5;
                        }
                        AppMethodBeat.o(184510);
                        return 4;
                    }
                } else if (Pi) {
                    AppMethodBeat.o(184510);
                    return 6;
                } else if (Pi2) {
                    AppMethodBeat.o(184510);
                    return 6;
                } else {
                    AppMethodBeat.o(184510);
                    return 7;
                }
            }
        } else if (equalsIgnoreCase) {
            if (Pj) {
                AppMethodBeat.o(184510);
                return 0;
            }
            AppMethodBeat.o(184510);
            return 2;
        } else if (!Pi && Pj) {
            AppMethodBeat.o(184510);
            return 3;
        }
        AppMethodBeat.o(184510);
        return 1;
    }
}
