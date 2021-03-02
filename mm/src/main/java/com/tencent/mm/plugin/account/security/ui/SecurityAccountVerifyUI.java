package com.tencent.mm.plugin.account.security.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.pay.tool.APPluginConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.plugin.account.security.a.f;
import com.tencent.mm.plugin.b.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;

public class SecurityAccountVerifyUI extends MMWizardActivity implements i {
    private static final String kju = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2f) + "/cgi-bin/mmsupport-bin/readtemplate?lang=%s&t=w_unprotect&step=1&f=Android");
    private String dOX;
    private String dOZ;
    private String dSf;
    private ProgressDialog gtM = null;
    private String kbV;
    private EditText kjC;
    private TextView kjD;
    private TextView kjE;
    private Button kjF;
    private boolean kjG = false;
    private String kjv;
    private Button kjy;
    private MTimerHandler timer;

    @Override // com.tencent.mm.ui.MMWizardActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void f(SecurityAccountVerifyUI securityAccountVerifyUI) {
        AppMethodBeat.i(238821);
        securityAccountVerifyUI.bnm();
        AppMethodBeat.o(238821);
    }

    static {
        AppMethodBeat.i(238822);
        AppMethodBeat.o(238822);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bp9;
    }

    @Override // com.tencent.mm.ui.MMWizardActivity, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(125605);
        super.onCreate(bundle);
        this.kbV = a.caK();
        initView();
        AppMethodBeat.o(125605);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(125606);
        g.azz().a(145, this);
        g.azz().a(132, this);
        super.onResume();
        if (!this.kjG) {
            StringBuilder sb = new StringBuilder();
            g.aAf();
            StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",L600_200,");
            g.aAf();
            a.j(true, append.append(com.tencent.mm.kernel.a.FN("L600_200")).append(",1").toString());
            a.bxk("L600_200");
        }
        AppMethodBeat.o(125606);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(125607);
        g.azz().b(145, this);
        g.azz().b(132, this);
        super.onPause();
        if (!this.kjG) {
            StringBuilder sb = new StringBuilder();
            g.aAf();
            StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",L600_200,");
            g.aAf();
            a.j(false, append.append(com.tencent.mm.kernel.a.FN("L600_200")).append(",2").toString());
        }
        AppMethodBeat.o(125607);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onDestroy() {
        AppMethodBeat.i(125608);
        super.onDestroy();
        this.timer.stopTimer();
        AppMethodBeat.o(125608);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(125609);
        this.dSf = getIntent().getStringExtra("binded_mobile");
        this.kjv = getIntent().getStringExtra("auth_ticket");
        this.kjG = getIntent().getBooleanExtra("re_open_verify", false);
        this.kjC = (EditText) findViewById(R.id.a4e);
        this.kjD = (TextView) findViewById(R.id.fh4);
        this.kjE = (TextView) findViewById(R.id.h40);
        this.kjF = (Button) findViewById(R.id.h3z);
        this.kjC.addTextChangedListener(new TextWatcher() {
            /* class com.tencent.mm.plugin.account.security.ui.SecurityAccountVerifyUI.AnonymousClass1 */

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void afterTextChanged(Editable editable) {
                AppMethodBeat.i(125597);
                SecurityAccountVerifyUI.this.enableOptionMenu(editable != null && !Util.isNullOrNil(editable.toString()));
                AppMethodBeat.o(125597);
            }
        });
        this.kjD.setText(Util.getPrivacyPhoneNum(this.dSf));
        this.kjE.setTag(60);
        this.timer = new MTimerHandler(new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.account.security.ui.SecurityAccountVerifyUI.AnonymousClass2 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(125598);
                int intValue = ((Integer) SecurityAccountVerifyUI.this.kjE.getTag()).intValue();
                if (intValue <= 1) {
                    SecurityAccountVerifyUI.this.kjF.setVisibility(0);
                    SecurityAccountVerifyUI.this.kjE.setVisibility(8);
                    AppMethodBeat.o(125598);
                    return false;
                }
                int i2 = intValue - 1;
                SecurityAccountVerifyUI.this.kjE.setTag(Integer.valueOf(i2));
                SecurityAccountVerifyUI.this.kjE.setText(SecurityAccountVerifyUI.this.getString(R.string.gae, new Object[]{Integer.valueOf(i2)}));
                if (SecurityAccountVerifyUI.this.kjE.getVisibility() != 0) {
                    SecurityAccountVerifyUI.this.kjE.setVisibility(0);
                }
                AppMethodBeat.o(125598);
                return true;
            }
        }, true);
        this.kjF.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.security.ui.SecurityAccountVerifyUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(125600);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/security/ui/SecurityAccountVerifyUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                Log.v("MicroMsg.SecurityAccountVerifyUI", "on resend verify code button click");
                SecurityAccountVerifyUI.this.kjF.setVisibility(8);
                SecurityAccountVerifyUI.this.kjE.setTag(60);
                SecurityAccountVerifyUI.this.timer.stopTimer();
                SecurityAccountVerifyUI.this.timer.startTimer(1000);
                final com.tencent.mm.modelfriend.a aVar = new com.tencent.mm.modelfriend.a(SecurityAccountVerifyUI.this.dSf, 10, "", "", SecurityAccountVerifyUI.this.kjv);
                g.azz().a(aVar, 0);
                SecurityAccountVerifyUI securityAccountVerifyUI = SecurityAccountVerifyUI.this;
                AppCompatActivity context = SecurityAccountVerifyUI.this.getContext();
                SecurityAccountVerifyUI.this.getString(R.string.zb);
                securityAccountVerifyUI.gtM = h.a((Context) context, SecurityAccountVerifyUI.this.getString(R.string.gah), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.account.security.ui.SecurityAccountVerifyUI.AnonymousClass3.AnonymousClass1 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(125599);
                        g.azz().a(aVar);
                        AppMethodBeat.o(125599);
                    }
                });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/security/ui/SecurityAccountVerifyUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(125600);
            }
        });
        if (!this.kjG) {
            this.kjy = (Button) findViewById(R.id.b44);
            this.kjy.setVisibility(0);
            this.kjy.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.account.security.ui.SecurityAccountVerifyUI.AnonymousClass4 */

                public final void onClick(View view) {
                    AppMethodBeat.i(125601);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/security/ui/SecurityAccountVerifyUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    StringBuilder sb = new StringBuilder();
                    g.aAf();
                    StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",L600_300,");
                    g.aAf();
                    a.DX(append.append(com.tencent.mm.kernel.a.FN("L600_300")).append(",1").toString());
                    String loadApplicationLanguage = LocaleUtil.loadApplicationLanguage(SecurityAccountVerifyUI.this.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), SecurityAccountVerifyUI.this);
                    Intent intent = new Intent();
                    intent.putExtra("rawUrl", String.format(SecurityAccountVerifyUI.kju, loadApplicationLanguage));
                    intent.putExtra("useJs", true);
                    intent.putExtra("vertical_scroll", true);
                    intent.putExtra("title", SecurityAccountVerifyUI.this.getString(R.string.gac));
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("showShare", false);
                    intent.putExtra("neverGetA8Key", true);
                    intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
                    intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
                    com.tencent.mm.plugin.account.a.a.jRt.i(intent, SecurityAccountVerifyUI.this);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/security/ui/SecurityAccountVerifyUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(125601);
                }
            });
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.security.ui.SecurityAccountVerifyUI.AnonymousClass5 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(125602);
                SecurityAccountVerifyUI.f(SecurityAccountVerifyUI.this);
                AppMethodBeat.o(125602);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.x5), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.security.ui.SecurityAccountVerifyUI.AnonymousClass6 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                final q zVar;
                AppMethodBeat.i(125604);
                String trim = SecurityAccountVerifyUI.this.kjC.getText().toString().trim();
                if (Util.isNullOrNil(trim)) {
                    h.n(SecurityAccountVerifyUI.this, R.string.af_, R.string.zb);
                    AppMethodBeat.o(125604);
                } else {
                    SecurityAccountVerifyUI.this.hideVKB();
                    SecurityAccountVerifyUI.this.dOX = f.dD(SecurityAccountVerifyUI.this);
                    SecurityAccountVerifyUI.this.dOZ = f.boP();
                    if (!SecurityAccountVerifyUI.this.kjG) {
                        zVar = new com.tencent.mm.modelfriend.a(SecurityAccountVerifyUI.this.dSf, trim, "", SecurityAccountVerifyUI.this.kjv, SecurityAccountVerifyUI.this.dOX, SecurityAccountVerifyUI.this.dOZ);
                    } else {
                        zVar = new z(SecurityAccountVerifyUI.this.dSf, 11, trim, "", SecurityAccountVerifyUI.this.dOX, SecurityAccountVerifyUI.this.dOZ);
                    }
                    g.azz().a(zVar, 0);
                    SecurityAccountVerifyUI securityAccountVerifyUI = SecurityAccountVerifyUI.this;
                    SecurityAccountVerifyUI securityAccountVerifyUI2 = SecurityAccountVerifyUI.this;
                    SecurityAccountVerifyUI.this.getString(R.string.zb);
                    securityAccountVerifyUI.gtM = h.a((Context) securityAccountVerifyUI2, SecurityAccountVerifyUI.this.getString(R.string.aey), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.plugin.account.security.ui.SecurityAccountVerifyUI.AnonymousClass6.AnonymousClass1 */

                        public final void onCancel(DialogInterface dialogInterface) {
                            AppMethodBeat.i(125603);
                            g.azz().a(zVar);
                            AppMethodBeat.o(125603);
                        }
                    });
                    AppMethodBeat.o(125604);
                }
                return true;
            }
        });
        enableOptionMenu(false);
        setMMTitle(R.string.ga7);
        this.timer.startTimer(1000);
        AppMethodBeat.o(125609);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(125610);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getRepeatCount() == 0) {
            bnm();
            AppMethodBeat.o(125610);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(125610);
        return onKeyDown;
    }

    private void bnm() {
        AppMethodBeat.i(125611);
        cancel();
        ala(1);
        AppMethodBeat.o(125611);
    }

    private boolean n(int i2, int i3, String str) {
        boolean z = true;
        AppMethodBeat.i(125613);
        if (com.tencent.mm.plugin.account.a.a.jRu.a(getContext(), i2, i3, str)) {
            AppMethodBeat.o(125613);
        } else {
            switch (i3) {
                case -74:
                    h.a(getContext(), (int) R.string.adq, (int) R.string.zb, (DialogInterface.OnClickListener) null);
                    break;
                case -57:
                case -1:
                    Toast.makeText(getContext(), (int) R.string.u5, 0).show();
                    break;
                case APPluginConstants.ERROR_IO_SSLException_SSLHandshakeException:
                    Toast.makeText(getContext(), (int) R.string.adt, 0).show();
                    break;
                case APPluginConstants.ERROR_IO_ObjectStreamException_InvalidObjectException:
                    Toast.makeText(this, (int) R.string.adu, 0).show();
                    break;
                case APPluginConstants.ERROR_IO_ObjectStreamException_InvalidClassException:
                    h.a(getContext(), (int) R.string.af3, (int) R.string.af9, (DialogInterface.OnClickListener) null);
                    break;
                case APPluginConstants.ERROR_IO_NoHttpResponseException:
                    h.a(getContext(), (int) R.string.af4, (int) R.string.af9, (DialogInterface.OnClickListener) null);
                    break;
                default:
                    z = false;
                    break;
            }
            AppMethodBeat.o(125613);
        }
        return z;
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(125612);
        if (this.gtM != null && this.gtM.isShowing()) {
            this.gtM.dismiss();
            this.gtM = null;
        }
        switch (qVar.getType()) {
            case 145:
                com.tencent.mm.modelfriend.a aVar = (com.tencent.mm.modelfriend.a) qVar;
                if (aVar.Vj() == 10) {
                    if (i2 == 0 && i3 == 0) {
                        Log.i("MicroMsg.SecurityAccountVerifyUI", "resend verify code successfully");
                        AppMethodBeat.o(125612);
                        return;
                    }
                    Log.w("MicroMsg.SecurityAccountVerifyUI", "resend verify code fail, errType %d, errCode %d", Integer.valueOf(i2), Integer.valueOf(i3));
                    if (n(i2, i3, str)) {
                        AppMethodBeat.o(125612);
                        return;
                    }
                    Toast.makeText(getContext(), getString(R.string.gaf, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}), 0).show();
                    AppMethodBeat.o(125612);
                    return;
                } else if (aVar.Vj() != 11) {
                    Log.w("MicroMsg.SecurityAccountVerifyUI", "unknow bind mobile for reg op code %d, errType %d, errCode %d", Integer.valueOf(aVar.Vj()), Integer.valueOf(i2), Integer.valueOf(i3));
                    AppMethodBeat.o(125612);
                    return;
                } else if (i2 == 0 && i3 == 0) {
                    this.kjv = aVar.bbH();
                    Log.d("MicroMsg.SecurityAccountVerifyUI", "duanyi test bind opmobile verify authticket = " + this.kjv);
                    int intExtra = getIntent().getIntExtra("from_source", 1);
                    Intent intent = new Intent();
                    intent.putExtra("from_source", intExtra);
                    intent.putExtra("binded_mobile", this.dSf);
                    switch (intExtra) {
                        case 1:
                        case 2:
                        case 5:
                        case 6:
                            intent.addFlags(67108864);
                            intent.putExtra("auth_ticket", this.kjv);
                            com.tencent.mm.plugin.account.a.a.jRt.a(this, intent, (Intent) null);
                            finish();
                            AppMethodBeat.o(125612);
                            return;
                        case 3:
                            intent.addFlags(67108864);
                            intent.putExtra("auth_ticket", this.kjv);
                            String stringExtra = getIntent().getStringExtra("WizardTransactionId");
                            if (stringExtra == null) {
                                stringExtra = "";
                            }
                            Intent intent2 = (Intent) OHY.get(stringExtra);
                            OHY.clear();
                            if (intent2 != null) {
                                com.tencent.mm.plugin.account.a.a.jRt.a(this, intent, intent2);
                            } else {
                                com.tencent.mm.plugin.account.a.a.jRt.a(this, intent, (Intent) null);
                            }
                            finish();
                            AppMethodBeat.o(125612);
                            return;
                        case 4:
                        default:
                            ala(1);
                            AppMethodBeat.o(125612);
                            return;
                    }
                } else {
                    Log.w("MicroMsg.SecurityAccountVerifyUI", "verify verify-code fail, errType %d, errCode %d", Integer.valueOf(i2), Integer.valueOf(i3));
                    if (n(i2, i3, str)) {
                        AppMethodBeat.o(125612);
                        return;
                    }
                    Toast.makeText(getContext(), getString(R.string.gaj, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}), 0).show();
                    AppMethodBeat.o(125612);
                    return;
                }
            case 132:
                if (i2 != 0 || i3 != 0) {
                    if (!n(i2, i3, str)) {
                        Toast.makeText(this, getString(R.string.gaj, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}), 0).show();
                        break;
                    } else {
                        AppMethodBeat.o(125612);
                        return;
                    }
                } else {
                    f.p(true, true);
                    Intent intent3 = new Intent(this, MySafeDeviceListUI.class);
                    intent3.addFlags(67108864);
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent3);
                    com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/account/security/ui/SecurityAccountVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/security/ui/SecurityAccountVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    finish();
                    AppMethodBeat.o(125612);
                    return;
                }
        }
        AppMethodBeat.o(125612);
    }
}
