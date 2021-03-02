package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.cc.h;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.ui.MobileInputUI;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;

public final class i implements com.tencent.mm.ak.i, MobileInputUI.b {
    private MobileInputUI knl;
    private String knm;
    private String knn;
    private int kno = 0;

    static /* synthetic */ void a(i iVar) {
        AppMethodBeat.i(128273);
        iVar.bpm();
        AppMethodBeat.o(128273);
    }

    @Override // com.tencent.mm.plugin.account.ui.MobileInputUI.b
    public final void a(MobileInputUI mobileInputUI) {
        AppMethodBeat.i(128267);
        this.knl = mobileInputUI;
        mobileInputUI.knC.requestFocus();
        mobileInputUI.showVKB();
        String string = mobileInputUI.getString(R.string.g09);
        if (d.KyR || BuildInfo.IS_FLAVOR_BLUE) {
            string = string + h.jr(mobileInputUI);
        }
        mobileInputUI.setMMTitle(string);
        mobileInputUI.kaX.setVisibility(0);
        mobileInputUI.knB.setVisibility(0);
        mobileInputUI.knC.requestFocus();
        mobileInputUI.knH.setText(R.string.x5);
        mobileInputUI.knH.setVisibility(0);
        AppMethodBeat.o(128267);
    }

    @Override // com.tencent.mm.plugin.account.ui.MobileInputUI.b
    public final void start() {
        AppMethodBeat.i(128268);
        g.azz().a(145, this);
        StringBuilder sb = new StringBuilder();
        g.aAf();
        StringBuilder append = sb.append(a.azt()).append(",").append(getClass().getName()).append(",F200_100,");
        g.aAf();
        com.tencent.mm.plugin.b.a.j(true, append.append(a.FN("F200_100")).append(",1").toString());
        com.tencent.mm.plugin.b.a.bxk("F200_100");
        this.kno = 0;
        AppMethodBeat.o(128268);
    }

    @Override // com.tencent.mm.plugin.account.ui.MobileInputUI.b
    public final void stop() {
        AppMethodBeat.i(128269);
        g.azz().b(145, this);
        StringBuilder sb = new StringBuilder();
        g.aAf();
        StringBuilder append = sb.append(a.azt()).append(",").append(getClass().getName()).append(",F200_100,");
        g.aAf();
        com.tencent.mm.plugin.b.a.j(false, append.append(a.FN("F200_100")).append(",2").toString());
        AppMethodBeat.o(128269);
    }

    @Override // com.tencent.mm.plugin.account.ui.MobileInputUI.b
    public final void a(MobileInputUI.a aVar) {
        int i2;
        AppMethodBeat.i(128270);
        switch (aVar) {
            case GoNext:
                this.knl.knO = PhoneFormater.countryCodeWithPlus(this.knl.countryCode);
                this.knl.knP = this.knl.knB.getText().toString();
                String str = this.knl.knO + this.knl.knP;
                if (this.knl.kdn == null) {
                    MobileInputUI mobileInputUI = this.knl;
                    MobileInputUI mobileInputUI2 = this.knl;
                    this.knl.getString(R.string.zb);
                    mobileInputUI.kdn = com.tencent.mm.ui.base.h.a((Context) mobileInputUI2, this.knl.getString(R.string.fyo), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.plugin.account.ui.i.AnonymousClass1 */

                        public final void onCancel(DialogInterface dialogInterface) {
                        }
                    });
                    String obj = this.knl.knB.getText().toString();
                    if (this.knm == null || this.knn == null || obj.equals(this.knm) || !obj.equals(this.knn)) {
                        i2 = (this.knm == null || this.knn == null || this.knn.equals(this.knm) || obj.equals(this.knn)) ? 0 : 2;
                    } else {
                        i2 = 1;
                    }
                    com.tencent.mm.modelfriend.a aVar2 = new com.tencent.mm.modelfriend.a(str, 12, "", 0, "");
                    aVar2.sZ(this.kno);
                    aVar2.ta(i2);
                    g.azz().a(aVar2, 0);
                    this.knm = this.knl.knB.getText().toString();
                    this.kno++;
                    break;
                } else {
                    Log.d("MicroMsg.MobileInputForgetPwdLogic", "already checking ");
                    AppMethodBeat.o(128270);
                    return;
                }
        }
        AppMethodBeat.o(128270);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(128271);
        Log.i("MicroMsg.MobileInputForgetPwdLogic", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        if (this.knl.kdn != null) {
            this.knl.kdn.dismiss();
            this.knl.kdn = null;
        }
        if (i3 == -75) {
            com.tencent.mm.ui.base.h.n(this.knl, R.string.h0, R.string.fxq);
            AppMethodBeat.o(128271);
        } else if (i3 == -41 || i3 == -59) {
            com.tencent.mm.h.a Dk = com.tencent.mm.h.a.Dk(str);
            if (Dk != null) {
                Dk.a(this.knl, null, null);
                AppMethodBeat.o(128271);
                return;
            }
            com.tencent.mm.ui.base.h.n(this.knl, R.string.fz6, R.string.fz7);
            AppMethodBeat.o(128271);
        } else {
            if (qVar.getType() == 145) {
                int Vj = ((com.tencent.mm.modelfriend.a) qVar).Vj();
                if (Vj == 12) {
                    if (i3 == -36 || i3 == -35 || i3 == -3) {
                        String bbI = ((com.tencent.mm.modelfriend.a) qVar).bbI();
                        if (!Util.isNullOrNil(bbI)) {
                            this.knl.knP = bbI.trim();
                        }
                        this.knl.knP = PhoneFormater.pureNumber(this.knl.knP);
                        this.knn = this.knl.knO + this.knl.knP;
                        StringBuilder sb = new StringBuilder();
                        g.aAf();
                        StringBuilder append = sb.append(a.azt()).append(",").append(getClass().getName()).append(",F200_200,");
                        g.aAf();
                        com.tencent.mm.plugin.b.a.j(true, append.append(a.FN("F200_200")).append(",1").toString());
                        com.tencent.mm.h.a Dk2 = com.tencent.mm.h.a.Dk(str);
                        if (Dk2 != null) {
                            Dk2.a(this.knl, new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.plugin.account.ui.i.AnonymousClass2 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(128264);
                                    i.a(i.this);
                                    StringBuilder sb = new StringBuilder();
                                    g.aAf();
                                    StringBuilder append = sb.append(a.azt()).append(",").append(getClass().getName()).append(",F200_200,");
                                    g.aAf();
                                    com.tencent.mm.plugin.b.a.j(true, append.append(a.FN("F200_200")).append(",2").toString());
                                    AppMethodBeat.o(128264);
                                }
                            }, new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.plugin.account.ui.i.AnonymousClass3 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(128265);
                                    StringBuilder sb = new StringBuilder();
                                    g.aAf();
                                    StringBuilder append = sb.append(a.azt()).append(",").append(getClass().getName()).append(",F200_200,");
                                    g.aAf();
                                    com.tencent.mm.plugin.b.a.j(true, append.append(a.FN("F200_200")).append(",2").toString());
                                    AppMethodBeat.o(128265);
                                }
                            });
                            AppMethodBeat.o(128271);
                            return;
                        }
                        bpm();
                        StringBuilder sb2 = new StringBuilder();
                        g.aAf();
                        StringBuilder append2 = sb2.append(a.azt()).append(",").append(getClass().getName()).append(",F200_200,");
                        g.aAf();
                        com.tencent.mm.plugin.b.a.j(true, append2.append(a.FN("F200_200")).append(",2").toString());
                        AppMethodBeat.o(128271);
                        return;
                    } else if (i3 == -34) {
                        com.tencent.mm.ui.base.h.c(this.knl, this.knl.getString(R.string.adu), "", true);
                        AppMethodBeat.o(128271);
                        return;
                    } else {
                        Toast.makeText(this.knl, this.knl.getString(R.string.af2, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}), 0).show();
                    }
                }
                if (Vj == 8 && i3 == 0) {
                    Intent intent = new Intent();
                    intent.putExtra("bindmcontact_mobile", this.knl.knO + " " + this.knl.knB.getText().toString());
                    intent.putExtra("bindmcontact_shortmobile", this.knl.knP);
                    intent.putExtra("country_name", this.knl.jbZ);
                    intent.putExtra("couttry_code", this.knl.countryCode);
                    intent.putExtra("mobileverify_countdownsec", ((com.tencent.mm.modelfriend.a) qVar).bbO());
                    intent.putExtra("mobileverify_countdownstyle", ((com.tencent.mm.modelfriend.a) qVar).bbP());
                    intent.putExtra("mobileverify_fb", ((com.tencent.mm.modelfriend.a) qVar).bbQ());
                    intent.putExtra("mobileverify_reg_qq", ((com.tencent.mm.modelfriend.a) qVar).bbR());
                    intent.putExtra("mobile_verify_purpose", 3);
                    intent.setClass(this.knl, MobileVerifyUI.class);
                    MobileInputUI mobileInputUI = this.knl;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                    com.tencent.mm.hellhoundlib.a.a.a(mobileInputUI, bl.axQ(), "com/tencent/mm/plugin/account/ui/MobileInputForgetPwdLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    mobileInputUI.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(mobileInputUI, "com/tencent/mm/plugin/account/ui/MobileInputForgetPwdLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                }
            }
            AppMethodBeat.o(128271);
        }
    }

    private void bpm() {
        AppMethodBeat.i(128272);
        MobileInputUI mobileInputUI = this.knl;
        MobileInputUI mobileInputUI2 = this.knl;
        this.knl.getString(R.string.zb);
        mobileInputUI.kdn = com.tencent.mm.ui.base.h.a((Context) mobileInputUI2, this.knl.getString(R.string.fyo), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.account.ui.i.AnonymousClass4 */

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        g.azz().a(new com.tencent.mm.modelfriend.a(this.knl.knO + this.knl.knP, 8, "", 0, ""), 0);
        AppMethodBeat.o(128272);
    }
}
