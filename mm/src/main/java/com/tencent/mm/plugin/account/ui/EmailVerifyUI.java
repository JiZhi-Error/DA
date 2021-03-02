package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.pay.tool.APPluginConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.ab;
import com.tencent.mm.plugin.account.friend.a.s;
import com.tencent.mm.plugin.appbrand.jsapi.audio.n;
import com.tencent.mm.plugin.b.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MMAutoSwitchEditTextView;
import com.tencent.mm.ui.base.h;

public class EmailVerifyUI extends MMActivity implements i {
    private ProgressDialog gtM = null;
    private String kbV;
    private boolean kkA = false;
    private TextView kkr;
    private TextView kks;
    private MMAutoSwitchEditTextView kkt;
    private Button kku;
    private Button kkv;
    private String kkw;
    private String kkx;
    private String kky;
    private String kkz;

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void d(EmailVerifyUI emailVerifyUI) {
        AppMethodBeat.i(127926);
        emailVerifyUI.goBack();
        AppMethodBeat.o(127926);
    }

    @Override // android.support.v4.app.SupportActivity, com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, android.support.v7.app.AppCompatActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(127918);
        super.onCreate(bundle);
        initView();
        this.kbV = a.caK();
        AppMethodBeat.o(127918);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onResume() {
        AppMethodBeat.i(127919);
        super.onResume();
        g.azz().a(n.CTRL_INDEX, this);
        StringBuilder sb = new StringBuilder();
        g.aAf();
        StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R500_200,");
        g.aAf();
        a.j(true, append.append(com.tencent.mm.kernel.a.FN("R500_200")).append(",1").toString());
        a.bxk("R500_200");
        AppMethodBeat.o(127919);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, com.tencent.mm.hellhoundlib.activities.HellActivity, com.tencent.mm.ui.MMFragmentActivity, android.support.v4.app.FragmentActivity
    public void onPause() {
        AppMethodBeat.i(127920);
        super.onPause();
        g.azz().b(n.CTRL_INDEX, this);
        StringBuilder sb = new StringBuilder();
        g.aAf();
        StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R500_200,");
        g.aAf();
        a.j(false, append.append(com.tencent.mm.kernel.a.FN("R500_200")).append(",2").toString());
        AppMethodBeat.o(127920);
    }

    @Override // com.tencent.mm.ui.MMActivity
    public int getLayoutId() {
        return R.layout.c54;
    }

    @Override // com.tencent.mm.ui.MMActivity
    public void initView() {
        AppMethodBeat.i(127921);
        setMMTitle(R.string.fyf);
        this.kkr = (TextView) findViewById(R.id.j31);
        this.kkr.setText(Html.fromHtml(getString(R.string.fxz)));
        this.kks = (TextView) findViewById(R.id.bys);
        this.kkw = getIntent().getStringExtra("email_address");
        if (!Util.isNullOrNil(this.kkw)) {
            this.kks.setText(this.kkw);
        } else {
            Log.w("MicroMsg.EmailVerifyUI", "email add is null or nill");
        }
        this.kky = getIntent().getStringExtra("password");
        this.kkx = getIntent().getStringExtra("email_login_page");
        Log.i("MicroMsg.EmailVerifyUI", "user register:email add:[%s], password not allowed to printf, login page:[%s]", this.kkw, this.kkx);
        this.kkt = (MMAutoSwitchEditTextView) findViewById(R.id.wi);
        this.kkt.setOnInputFinished(new MMAutoSwitchEditTextView.a() {
            /* class com.tencent.mm.plugin.account.ui.EmailVerifyUI.AnonymousClass1 */

            @Override // com.tencent.mm.ui.base.MMAutoSwitchEditTextView.a
            public final void Tq(String str) {
                AppMethodBeat.i(127909);
                EmailVerifyUI.this.enableOptionMenu(true);
                EmailVerifyUI.a(EmailVerifyUI.this, str);
                AppMethodBeat.o(127909);
            }
        });
        this.kkt.setOnTextChanged(new MMAutoSwitchEditTextView.b() {
            /* class com.tencent.mm.plugin.account.ui.EmailVerifyUI.AnonymousClass2 */

            @Override // com.tencent.mm.ui.base.MMAutoSwitchEditTextView.b
            public final void boW() {
                AppMethodBeat.i(127910);
                EmailVerifyUI.this.enableOptionMenu(false);
                AppMethodBeat.o(127910);
            }
        });
        this.kkv = (Button) findViewById(R.id.gs6);
        this.kkv.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.EmailVerifyUI.AnonymousClass3 */

            public final void onClick(View view) {
                AppMethodBeat.i(127913);
                b bVar = new b();
                bVar.bm(view);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/EmailVerifyUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                StringBuilder sb = new StringBuilder();
                g.aAf();
                StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R500_250,");
                g.aAf();
                a.DX(append.append(com.tencent.mm.kernel.a.FN("R500_250")).append(",3").toString());
                h.a(EmailVerifyUI.this, (int) R.string.fy7, (int) R.string.fxx, (int) R.string.x_, (int) R.string.sz, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.account.ui.EmailVerifyUI.AnonymousClass3.AnonymousClass1 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(127912);
                        final ab abVar = new ab(EmailVerifyUI.this.kkw, EmailVerifyUI.this.kky);
                        g.azz().a(abVar, 0);
                        EmailVerifyUI emailVerifyUI = EmailVerifyUI.this;
                        EmailVerifyUI emailVerifyUI2 = EmailVerifyUI.this;
                        EmailVerifyUI.this.getString(R.string.zb);
                        emailVerifyUI.gtM = h.a((Context) emailVerifyUI2, EmailVerifyUI.this.getString(R.string.fye), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                            /* class com.tencent.mm.plugin.account.ui.EmailVerifyUI.AnonymousClass3.AnonymousClass1.AnonymousClass1 */

                            public final void onCancel(DialogInterface dialogInterface) {
                                AppMethodBeat.i(127911);
                                g.azz().a(abVar);
                                AppMethodBeat.o(127911);
                            }
                        });
                        AppMethodBeat.o(127912);
                    }
                }, (DialogInterface.OnClickListener) null);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/EmailVerifyUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(127913);
            }
        });
        this.kku = (Button) findViewById(R.id.g47);
        if (Util.isNullOrNil(this.kkx) || Util.isNullOrNil(this.kkw)) {
            this.kku.setVisibility(8);
        } else {
            this.kku.setVisibility(0);
            this.kku.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.account.ui.EmailVerifyUI.AnonymousClass4 */

                public final void onClick(View view) {
                    AppMethodBeat.i(127914);
                    b bVar = new b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/EmailVerifyUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    Util.jump(EmailVerifyUI.this, EmailVerifyUI.this.kkx);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/EmailVerifyUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(127914);
                }
            });
        }
        setBackBtn(new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.ui.EmailVerifyUI.AnonymousClass5 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127915);
                EmailVerifyUI.d(EmailVerifyUI.this);
                AppMethodBeat.o(127915);
                return true;
            }
        });
        addTextOptionMenu(0, getString(R.string.x5), new MenuItem.OnMenuItemClickListener() {
            /* class com.tencent.mm.plugin.account.ui.EmailVerifyUI.AnonymousClass6 */

            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(127916);
                EmailVerifyUI.this.kkz = EmailVerifyUI.this.kkt.getText();
                if (Util.isNullOrNil(EmailVerifyUI.this.kkz) || EmailVerifyUI.this.kkz.length() != 12) {
                    EmailVerifyUI.this.enableOptionMenu(false);
                } else {
                    EmailVerifyUI.a(EmailVerifyUI.this, EmailVerifyUI.this.kkz);
                }
                AppMethodBeat.o(127916);
                return true;
            }
        });
        enableOptionMenu(false);
        AppMethodBeat.o(127921);
    }

    @Override // com.tencent.mm.ui.component.UIComponentActivity, com.tencent.mm.ui.MMActivity, android.support.v7.app.AppCompatActivity
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        AppMethodBeat.i(127922);
        if (i2 == 4 && keyEvent.getRepeatCount() == 0) {
            goBack();
            AppMethodBeat.o(127922);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i2, keyEvent);
        AppMethodBeat.o(127922);
        return onKeyDown;
    }

    private void goBack() {
        AppMethodBeat.i(127923);
        a.bxl(this.kbV);
        finish();
        AppMethodBeat.o(127923);
    }

    @Override // com.tencent.mm.ak.i
    public void onSceneEnd(int i2, int i3, String str, q qVar) {
        boolean z;
        AppMethodBeat.i(127924);
        Log.i("MicroMsg.EmailVerifyUI", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        this.kkA = false;
        if (this.gtM != null && this.gtM.isShowing()) {
            this.gtM.dismiss();
            this.gtM = null;
        }
        if (qVar.getType() != 481) {
            Log.e("MicroMsg.EmailVerifyUI", "error cgi type callback:[%d]", Integer.valueOf(qVar.getType()));
            AppMethodBeat.o(127924);
            return;
        }
        int i4 = ((s.a) ((ab) qVar).iMO.getReqObj()).keR.KMz;
        if (i2 != 0 || i3 != 0) {
            if (!com.tencent.mm.plugin.account.a.a.jRu.a(this, i2, i3, str)) {
                switch (i3) {
                    case APPluginConstants.ERROR_IO_ObjectStreamException_InvalidObjectException:
                        Toast.makeText(this, (int) R.string.fxv, 0).show();
                        z = true;
                        break;
                    case APPluginConstants.ERROR_IO_ObjectStreamException_InvalidClassException:
                        h.a(this, (int) R.string.fxw, (int) R.string.fxx, (DialogInterface.OnClickListener) null);
                        z = true;
                        break;
                    case APPluginConstants.ERROR_IO_NoHttpResponseException:
                        h.a(this, (int) R.string.fxy, (int) R.string.fxx, (DialogInterface.OnClickListener) null);
                        StringBuilder sb = new StringBuilder();
                        g.aAf();
                        StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R500_260,");
                        g.aAf();
                        a.DX(append.append(com.tencent.mm.kernel.a.FN("R500_260")).append(",3").toString());
                        z = true;
                        break;
                    default:
                        z = false;
                        break;
                }
            } else {
                z = true;
            }
            if (z) {
                AppMethodBeat.o(127924);
            } else if (i4 == 2) {
                Toast.makeText(this, getString(R.string.fyg, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}), 0).show();
                AppMethodBeat.o(127924);
            } else {
                if (i4 == 1) {
                    Toast.makeText(this, getString(R.string.fy8, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}), 0).show();
                }
                AppMethodBeat.o(127924);
            }
        } else if (i4 == 2) {
            a.bxl("R200_900_email");
            Intent intent = new Intent(this, RegSetInfoUI.class);
            intent.putExtra("regsetinfo_ticket", ((s.b) ((ab) qVar).iMO.getRespObj()).keS.Bri);
            intent.putExtra("regsetinfo_user", this.kkw);
            intent.putExtra("regsetinfo_ismobile", 3);
            intent.putExtra("regsetinfo_NextStyle", ((ab) qVar).bfw());
            intent.putExtra("regsetinfo_pwd", this.kky);
            intent.putExtra("regsetinfo_bind_email", this.kkw);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(this, bl.axQ(), "com/tencent/mm/plugin/account/ui/EmailVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/EmailVerifyUI", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(127924);
        } else if (i4 == 1) {
            StringBuilder sb2 = new StringBuilder();
            g.aAf();
            StringBuilder append2 = sb2.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R22_resend_email_code_alert,");
            g.aAf();
            a.DX(append2.append(com.tencent.mm.kernel.a.FN("R22_resend_email_code_alert")).append(",3").toString());
            h.cD(this, getString(R.string.fy9));
            AppMethodBeat.o(127924);
        } else {
            Log.e("MicroMsg.EmailVerifyUI", "err opcode");
            AppMethodBeat.o(127924);
        }
    }

    static /* synthetic */ void a(EmailVerifyUI emailVerifyUI, String str) {
        AppMethodBeat.i(127925);
        if (emailVerifyUI.kkA) {
            Log.i("MicroMsg.EmailVerifyUI", "is verifying, wait a minute");
            AppMethodBeat.o(127925);
            return;
        }
        emailVerifyUI.kkA = true;
        final ab abVar = new ab(emailVerifyUI.kkw, emailVerifyUI.kky, str);
        g.azz().a(abVar, 0);
        emailVerifyUI.getString(R.string.zb);
        emailVerifyUI.gtM = h.a((Context) emailVerifyUI, emailVerifyUI.getString(R.string.fyd), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.account.ui.EmailVerifyUI.AnonymousClass7 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(127917);
                g.azz().a(abVar);
                AppMethodBeat.o(127917);
            }
        });
        AppMethodBeat.o(127925);
    }
}
