package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.aw.b;
import com.tencent.mm.g.b.a.ka;
import com.tencent.mm.hellhoundlib.b.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.ui.MobileInputUI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.WeChatBrands;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.widget.a.e;
import java.util.ArrayList;

public final class j implements i, MobileInputUI.b {
    private SecurityImage kdp = null;
    ka kkY = new ka();
    private h klz = null;
    MobileInputUI knl;

    public j() {
        AppMethodBeat.i(128279);
        AppMethodBeat.o(128279);
    }

    @Override // com.tencent.mm.plugin.account.ui.MobileInputUI.b
    public final void a(MobileInputUI mobileInputUI) {
        AppMethodBeat.i(128280);
        this.knl = mobileInputUI;
        mobileInputUI.kaX.setVisibility(0);
        mobileInputUI.knB.setVisibility(0);
        mobileInputUI.knC.requestFocus();
        mobileInputUI.knH.setText(R.string.x5);
        mobileInputUI.knH.setVisibility(0);
        mobileInputUI.knJ.setVisibility(0);
        final ArrayList arrayList = new ArrayList();
        n nVar = new n(this.knl, 2001, 0);
        if (WeChatBrands.AppInfo.current().isMainland()) {
            nVar.setTitle(R.string.elt);
        } else {
            nVar.setTitle(R.string.elv);
        }
        arrayList.add(nVar);
        final n nVar2 = new n(this.knl, 2002, 0);
        if (b.bdD()) {
            nVar2.setTitle(R.string.elp);
            arrayList.add(nVar2);
        }
        if (arrayList.size() > 1) {
            final e eVar = new e((Context) this.knl, 1, false);
            eVar.HLX = new o.f() {
                /* class com.tencent.mm.plugin.account.ui.j.AnonymousClass1 */

                @Override // com.tencent.mm.ui.base.o.f
                public final void onCreateMMMenu(m mVar) {
                    AppMethodBeat.i(128274);
                    if (mVar.size() == 0) {
                        for (n nVar : arrayList) {
                            mVar.g(nVar);
                        }
                    }
                    AppMethodBeat.o(128274);
                }
            };
            eVar.HLY = new o.g() {
                /* class com.tencent.mm.plugin.account.ui.j.AnonymousClass2 */

                @Override // com.tencent.mm.ui.base.o.g
                public final void onMMMenuItemSelected(MenuItem menuItem, int i2) {
                    AppMethodBeat.i(128275);
                    switch (menuItem.getItemId()) {
                        case 2001:
                            j.a(j.this);
                            AppMethodBeat.o(128275);
                            return;
                        case 2002:
                            j jVar = j.this;
                            jVar.kkY.eTd = 1;
                            jVar.kkY.ejA = 10;
                            jVar.kkY.bfK();
                            Intent intent = new Intent(jVar.knl, FacebookLoginUI.class);
                            MobileInputUI mobileInputUI = jVar.knl;
                            a bl = new a().bl(intent);
                            com.tencent.mm.hellhoundlib.a.a.a(mobileInputUI, bl.axQ(), "com/tencent/mm/plugin/account/ui/MobileInputLoginLogic", "jumpToLoginFacebook", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            mobileInputUI.startActivity((Intent) bl.pG(0));
                            com.tencent.mm.hellhoundlib.a.a.a(mobileInputUI, "com/tencent/mm/plugin/account/ui/MobileInputLoginLogic", "jumpToLoginFacebook", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            break;
                    }
                    AppMethodBeat.o(128275);
                }
            };
            eVar.PGl = new e.b() {
                /* class com.tencent.mm.plugin.account.ui.j.AnonymousClass3 */

                @Override // com.tencent.mm.ui.widget.a.e.b
                public final void onDismiss() {
                }
            };
            this.knl.knL.setText(R.string.elu);
            this.knl.knL.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.account.ui.j.AnonymousClass4 */

                public final void onClick(View view) {
                    AppMethodBeat.i(128276);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileInputLoginLogic$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    j.this.knl.hideVKB();
                    eVar.dGm();
                    if (arrayList.contains(nVar2)) {
                        j.this.kkY.eTd = 1;
                        j.this.kkY.ejA = 9;
                        j.this.kkY.bfK();
                    }
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputLoginLogic$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(128276);
                }
            });
        } else {
            if (WeChatBrands.AppInfo.current().isMainland()) {
                this.knl.knL.setText(R.string.elt);
            } else {
                this.knl.knL.setText(R.string.elv);
            }
            this.knl.knL.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.account.ui.j.AnonymousClass5 */

                public final void onClick(View view) {
                    AppMethodBeat.i(128277);
                    com.tencent.mm.hellhoundlib.b.b bVar = new com.tencent.mm.hellhoundlib.b.b();
                    bVar.bm(view);
                    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/ui/MobileInputLoginLogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    j.a(j.this);
                    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputLoginLogic$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(128277);
                }
            });
        }
        this.knl.knL.setVisibility(0);
        AppMethodBeat.o(128280);
    }

    @Override // com.tencent.mm.plugin.account.ui.MobileInputUI.b
    public final void start() {
        AppMethodBeat.i(128281);
        g.azz().a(145, this);
        StringBuilder sb = new StringBuilder();
        g.aAf();
        StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",L200_100,");
        g.aAf();
        com.tencent.mm.plugin.b.a.j(true, append.append(com.tencent.mm.kernel.a.FN("L200_100")).append(",1").toString());
        com.tencent.mm.plugin.b.a.bxk("L200_100");
        AppMethodBeat.o(128281);
    }

    @Override // com.tencent.mm.plugin.account.ui.MobileInputUI.b
    public final void stop() {
        AppMethodBeat.i(128282);
        g.azz().b(145, this);
        StringBuilder sb = new StringBuilder();
        g.aAf();
        StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",L200_100,");
        g.aAf();
        com.tencent.mm.plugin.b.a.j(false, append.append(com.tencent.mm.kernel.a.FN("L200_100")).append(",2").toString());
        AppMethodBeat.o(128282);
    }

    @Override // com.tencent.mm.plugin.account.ui.MobileInputUI.b
    public final void a(MobileInputUI.a aVar) {
        AppMethodBeat.i(128283);
        switch (aVar) {
            case GoNext:
                this.knl.knO = PhoneFormater.countryCodeWithPlus(this.knl.countryCode);
                this.knl.knP = this.knl.knC.getText().toString();
                String pureNumber = PhoneFormater.pureNumber(this.knl.knO + this.knl.knP);
                MobileInputUI mobileInputUI = this.knl;
                MobileInputUI mobileInputUI2 = this.knl;
                this.knl.getString(R.string.zb);
                mobileInputUI.kdn = h.a((Context) mobileInputUI2, this.knl.getString(R.string.fyo), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.account.ui.j.AnonymousClass6 */

                    public final void onCancel(DialogInterface dialogInterface) {
                    }
                });
                g.azz().a(new com.tencent.mm.modelfriend.a(pureNumber, 13, "", 0, ""), 0);
                break;
        }
        AppMethodBeat.o(128283);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(128284);
        Log.i("MicroMsg.MobileInputLoginLogic", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        if (this.knl.kdn != null) {
            this.knl.kdn.dismiss();
            this.knl.kdn = null;
        }
        if ((qVar.getType() == 252 || qVar.getType() == 701) && this.klz != null) {
            this.klz.kmX = this.knl.kmX;
            this.klz.a(this.knl, i2, i3, str, qVar);
            AppMethodBeat.o(128284);
        } else if (qVar.getType() != 145 || ((com.tencent.mm.modelfriend.a) qVar).Vj() != 13) {
            AppMethodBeat.o(128284);
        } else if (i3 == -41) {
            com.tencent.mm.h.a Dk = com.tencent.mm.h.a.Dk(str);
            if (Dk != null) {
                Dk.a(this.knl, null, null);
                AppMethodBeat.o(128284);
                return;
            }
            h.n(this.knl, R.string.fz6, R.string.fz7);
            AppMethodBeat.o(128284);
        } else if (i3 == -1) {
            Toast.makeText(this.knl, this.knl.getString(R.string.de5, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}), 0).show();
            AppMethodBeat.o(128284);
        } else if (i3 == -34) {
            h.c(this.knl, this.knl.getString(R.string.adu), "", true);
            AppMethodBeat.o(128284);
        } else {
            this.knl.hideVKB();
            Intent intent = new Intent(this.knl, MobileInputUI.class);
            intent.putExtra("mobile_input_purpose", -1);
            intent.putExtra("mobile_auth_type", 7);
            intent.putExtra("from_switch_account", this.knl.klv);
            intent.putExtra("couttry_code", this.knl.countryCode);
            intent.putExtra("input_mobile_number", this.knl.knP);
            MobileInputUI mobileInputUI = this.knl;
            a bl = new a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(mobileInputUI, bl.axQ(), "com/tencent/mm/plugin/account/ui/MobileInputLoginLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            mobileInputUI.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(mobileInputUI, "com/tencent/mm/plugin/account/ui/MobileInputLoginLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            AppMethodBeat.o(128284);
        }
    }

    static /* synthetic */ void a(j jVar) {
        AppMethodBeat.i(128285);
        jVar.knl.kmr[0] = 1;
        Intent intent = new Intent();
        intent.putExtra("from_switch_account", jVar.knl.klv);
        intent.setClass(jVar.knl, LoginUI.class);
        MobileInputUI mobileInputUI = jVar.knl;
        a bl = new a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(mobileInputUI, bl.axQ(), "com/tencent/mm/plugin/account/ui/MobileInputLoginLogic", "jumpToLoginWeXinQQMail", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        mobileInputUI.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(mobileInputUI, "com/tencent/mm/plugin/account/ui/MobileInputLoginLogic", "jumpToLoginWeXinQQMail", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        jVar.knl.finish();
        AppMethodBeat.o(128285);
    }
}
