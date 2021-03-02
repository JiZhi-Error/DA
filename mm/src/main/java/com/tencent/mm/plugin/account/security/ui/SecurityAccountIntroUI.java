package com.tencent.mm.plugin.account.security.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.pay.tool.APPluginConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.plugin.b.a;
import com.tencent.mm.protocal.GeneralControlWrapper;
import com.tencent.mm.protocal.JsapiPermissionWrapper;
import com.tencent.mm.protocal.protobuf.mi;
import com.tencent.mm.sdk.http.HttpWrapperBase;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.h;
import java.util.Map;

public class SecurityAccountIntroUI extends MMWizardActivity implements i {
    private static final String kju = (HttpWrapperBase.PROTOCAL_HTTPS + WeChatHosts.domainString(R.string.e2f) + "/cgi-bin/mmsupport-bin/readtemplate?lang=%s&t=w_unprotect&step=1&f=Android");
    private String dSf;
    private ProgressDialog gtM = null;
    private String jumpUrl;
    private String kbV;
    private String kjv;
    private String kjw;
    private boolean kjx = false;
    private Button kjy;

    @Override // com.tencent.mm.ui.MMWizardActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void e(SecurityAccountIntroUI securityAccountIntroUI) {
        AppMethodBeat.i(238819);
        securityAccountIntroUI.bnm();
        AppMethodBeat.o(238819);
    }

    static {
        AppMethodBeat.i(238820);
        AppMethodBeat.o(238820);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.bp7;
    }

    @Override // com.tencent.mm.ui.MMWizardActivity, android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        Map<String, String> parseXml;
        AppMethodBeat.i(125589);
        super.onCreate(bundle);
        this.kjv = getIntent().getStringExtra("auth_ticket");
        this.dSf = getIntent().getStringExtra("binded_mobile");
        this.kjx = getIntent().getBooleanExtra("re_open_verify", false);
        String stringExtra = getIntent().getStringExtra("close_safe_device_style");
        Log.i("MicroMsg.SecurityAccountIntroUI", "summerphone authTicket[%s], showStyle[%s]", Util.secPrint(this.kjv), stringExtra);
        if (!Util.isNullOrNil(stringExtra) && (parseXml = XmlParser.parseXml(stringExtra, "wording", null)) != null) {
            this.kjw = parseXml.get(".wording.title");
            this.jumpUrl = parseXml.get(".wording.url");
            Log.i("MicroMsg.SecurityAccountIntroUI", "summerphone closeBtnText[%s], jumpUrl[%s]", this.kjw, this.jumpUrl);
        }
        this.kbV = a.caK();
        initView();
        AppMethodBeat.o(125589);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(125590);
        super.onResume();
        g.azz().a(145, this);
        g.azz().a(132, this);
        if (!this.kjx) {
            StringBuilder sb = new StringBuilder();
            g.aAf();
            StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",L600_100,");
            g.aAf();
            a.j(true, append.append(com.tencent.mm.kernel.a.FN("L600_100")).append(",1").toString());
            a.bxk("L600_100");
        }
        AppMethodBeat.o(125590);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(125591);
        super.onPause();
        g.azz().b(145, this);
        g.azz().b(132, this);
        if (!this.kjx) {
            StringBuilder sb = new StringBuilder();
            g.aAf();
            StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",L600_100,");
            g.aAf();
            a.j(false, append.append(com.tencent.mm.kernel.a.FN("L600_100")).append(",2").toString());
        }
        AppMethodBeat.o(125591);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(125592);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getRepeatCount() == 0) {
            bnm();
            AppMethodBeat.o(125592);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(125592);
        return onKeyDown;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(125593);
        setMMTitle(R.string.gal);
        findViewById(R.id.g4w).setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.security.ui.SecurityAccountIntroUI.AnonymousClass1 */

            public final void onClick(View view) {
                final q zVar;
                AppMethodBeat.i(125586);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/security/ui/SecurityAccountIntroUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                if (!SecurityAccountIntroUI.this.kjx) {
                    zVar = new com.tencent.mm.modelfriend.a(SecurityAccountIntroUI.this.dSf, 10, "", "", SecurityAccountIntroUI.this.kjv);
                } else {
                    zVar = new z(SecurityAccountIntroUI.this.dSf, 10, "", 0, "");
                }
                g.azz().a(zVar, 0);
                SecurityAccountIntroUI securityAccountIntroUI = SecurityAccountIntroUI.this;
                SecurityAccountIntroUI securityAccountIntroUI2 = SecurityAccountIntroUI.this;
                SecurityAccountIntroUI.this.getString(R.string.zb);
                securityAccountIntroUI.gtM = h.a((Context) securityAccountIntroUI2, SecurityAccountIntroUI.this.getString(R.string.gah), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.account.security.ui.SecurityAccountIntroUI.AnonymousClass1.AnonymousClass1 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(125585);
                        g.azz().a(zVar);
                        AppMethodBeat.o(125585);
                    }
                });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/security/ui/SecurityAccountIntroUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(125586);
            }
        });
        if (!this.kjx) {
            this.kjy = (Button) findViewById(R.id.b44);
            if (!Util.isNullOrNil(this.kjw)) {
                this.kjy.setText(this.kjw);
            }
            this.kjy.setVisibility(0);
            this.kjy.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.account.security.ui.SecurityAccountIntroUI.AnonymousClass2 */

                public final void onClick(View view) {
                    AppMethodBeat.i(125587);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/security/ui/SecurityAccountIntroUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    String loadApplicationLanguage = LocaleUtil.loadApplicationLanguage(SecurityAccountIntroUI.this.getSharedPreferences(MMApplicationContext.getDefaultPreferencePath(), 0), SecurityAccountIntroUI.this);
                    Intent intent = new Intent();
                    if (Util.isNullOrNil(SecurityAccountIntroUI.this.jumpUrl)) {
                        intent.putExtra("rawUrl", String.format(SecurityAccountIntroUI.kju, loadApplicationLanguage));
                    } else {
                        intent.putExtra("rawUrl", SecurityAccountIntroUI.this.jumpUrl);
                    }
                    intent.putExtra("useJs", true);
                    intent.putExtra("vertical_scroll", true);
                    intent.putExtra("title", SecurityAccountIntroUI.this.getString(R.string.gac));
                    intent.putExtra("show_bottom", false);
                    intent.putExtra("showShare", false);
                    intent.putExtra("neverGetA8Key", true);
                    intent.putExtra("hardcode_jspermission", JsapiPermissionWrapper.Kzm);
                    intent.putExtra("hardcode_general_ctrl", GeneralControlWrapper.Kzg);
                    com.tencent.mm.plugin.account.a.a.jRt.i(intent, SecurityAccountIntroUI.this);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/security/ui/SecurityAccountIntroUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(125587);
                }
            });
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.security.ui.SecurityAccountIntroUI.AnonymousClass3 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(125588);
                SecurityAccountIntroUI.e(SecurityAccountIntroUI.this);
                AppMethodBeat.o(125588);
                return true;
            }
        });
        AppMethodBeat.o(125593);
    }

    private void bnm() {
        AppMethodBeat.i(125594);
        a.bxl(this.kbV);
        cancel();
        ala(1);
        AppMethodBeat.o(125594);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        boolean z;
        String str2;
        AppMethodBeat.i(125595);
        if (this.gtM != null && this.gtM.isShowing()) {
            this.gtM.dismiss();
            this.gtM = null;
        }
        if (i2 == 0 && i3 == 0) {
            if (!this.kjx) {
                str2 = ((com.tencent.mm.modelfriend.a) qVar).bbH();
            } else {
                str2 = ((mi) ((z) qVar).rr.iLL.iLR).KLk;
            }
            Log.d("MicroMsg.SecurityAccountIntroUI", "duanyi test authTicket_login = " + this.kjv + "duanyi test authTicket_check = " + str2);
            Intent intent = new Intent(this, SecurityAccountVerifyUI.class);
            intent.putExtra("auth_ticket", str2);
            intent.putExtra("binded_mobile", this.dSf);
            intent.putExtra("re_open_verify", this.kjx);
            intent.putExtra("from_source", getIntent().getIntExtra("from_source", 1));
            ay(this, intent);
            if (getIntent().getIntExtra("from_source", 1) == 3) {
                finish();
            }
            AppMethodBeat.o(125595);
            return;
        }
        switch (i3) {
            case -74:
                h.a(this, (int) R.string.adq, (int) R.string.zb, (DialogInterface.OnClickListener) null);
                z = true;
                break;
            case -57:
            case -1:
                Toast.makeText(this, (int) R.string.u5, 0).show();
                z = true;
                break;
            case APPluginConstants.ERROR_IO_SSLException_SSLHandshakeException:
                Toast.makeText(this, (int) R.string.adt, 0).show();
                z = true;
                break;
            case APPluginConstants.ERROR_IO_ObjectStreamException_InvalidObjectException:
                Toast.makeText(this, (int) R.string.adu, 0).show();
                z = true;
                break;
            default:
                z = false;
                break;
        }
        if (z || com.tencent.mm.plugin.account.a.a.jRu.a(this, i2, i3, str)) {
            AppMethodBeat.o(125595);
            return;
        }
        Toast.makeText(this, getString(R.string.gaf, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}), 0).show();
        AppMethodBeat.o(125595);
    }
}
