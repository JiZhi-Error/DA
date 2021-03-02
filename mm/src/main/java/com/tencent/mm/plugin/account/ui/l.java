package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.animation.AnimationUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.cc.h;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.account.model.m;
import com.tencent.mm.plugin.account.ui.MobileInputUI;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.ewf;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;

public final class l implements i, MobileInputUI.b {
    private MobileInputUI knl;
    private String knm;
    private String knn;
    private int kno = 0;
    private String knu;
    int knv = 1;

    static /* synthetic */ void a(l lVar) {
        AppMethodBeat.i(128302);
        lVar.bpm();
        AppMethodBeat.o(128302);
    }

    @Override // com.tencent.mm.plugin.account.ui.MobileInputUI.b
    public final void a(final MobileInputUI mobileInputUI) {
        AppMethodBeat.i(128296);
        this.knl = mobileInputUI;
        String str = "";
        if (d.KyR || BuildInfo.IS_FLAVOR_BLUE) {
            str = str + h.jr(mobileInputUI);
        }
        mobileInputUI.setMMTitle(str);
        mobileInputUI.showOptionMenu(false);
        mobileInputUI.knI.setVisibility(0);
        mobileInputUI.knI.setVisibility(0);
        mobileInputUI.kaX.setVisibility(0);
        mobileInputUI.knB.setVisibility(0);
        mobileInputUI.knC.requestFocus();
        mobileInputUI.knE.setVisibility(0);
        mobileInputUI.kmS.setVisibility(0);
        mobileInputUI.knM.setVisibility(8);
        mobileInputUI.knH.setVisibility(0);
        mobileInputUI.knH.setText(R.string.en5);
        mobileInputUI.knG.setOnClickListener(new View.OnClickListener() {
            /* class com.tencent.mm.plugin.account.ui.l.AnonymousClass1 */

            public final void onClick(View view) {
                AppMethodBeat.i(128292);
                b bVar = new b();
                bVar.bm(view);
                a.b("com/tencent/mm/plugin/account/ui/MobileInputRegLogic$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                String bu = com.tencent.mm.aw.b.bu(mobileInputUI.countryCode, mobileInputUI.getString(R.string.bj8));
                com.tencent.mm.plugin.account.a.b.a.b(mobileInputUI, mobileInputUI.getString(R.string.htp, new Object[]{LocaleUtil.getApplicationLanguage(), bu}), 0, false);
                a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputRegLogic$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(128292);
            }
        });
        AppMethodBeat.o(128296);
    }

    @Override // com.tencent.mm.plugin.account.ui.MobileInputUI.b
    public final void start() {
        AppMethodBeat.i(128297);
        g.azz().a(145, this);
        StringBuilder sb = new StringBuilder();
        g.aAf();
        StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R200_100,");
        g.aAf();
        com.tencent.mm.plugin.b.a.j(true, append.append(com.tencent.mm.kernel.a.FN("R200_100")).append(",1").toString());
        com.tencent.mm.plugin.b.a.bxk("R200_100");
        this.kno = 0;
        AppMethodBeat.o(128297);
    }

    @Override // com.tencent.mm.plugin.account.ui.MobileInputUI.b
    public final void stop() {
        AppMethodBeat.i(128298);
        g.azz().b(145, this);
        StringBuilder sb = new StringBuilder();
        g.aAf();
        StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R200_100,");
        g.aAf();
        com.tencent.mm.plugin.b.a.j(false, append.append(com.tencent.mm.kernel.a.FN("R200_100")).append(",2").toString());
        AppMethodBeat.o(128298);
    }

    @Override // com.tencent.mm.plugin.account.ui.MobileInputUI.b
    public final void a(MobileInputUI.a aVar) {
        int i2;
        AppMethodBeat.i(128299);
        switch (aVar) {
            case GoNext:
                this.knl.hideVKB();
                if (this.knl.knF.isChecked()) {
                    switch (this.knv) {
                        case 1:
                            com.tencent.mm.plugin.account.a.b.a.b(this.knl, this.knl.getString(R.string.ee8, new Object[]{LocaleUtil.getApplicationLanguage(), com.tencent.mm.aw.b.bu(this.knl.countryCode, this.knl.getString(R.string.bj8)), "reg", 1, 0}), 32047, false);
                            break;
                        case 2:
                            bpm();
                            break;
                        default:
                            this.knl.knO = PhoneFormater.countryCodeWithPlus(this.knl.countryCode);
                            this.knl.knP = this.knl.knB.getText().toString();
                            String str = this.knl.knO + this.knl.knP;
                            if (com.tencent.mm.plugin.account.a.b.a.V(this.knl, this.knl.klM.getText().toString())) {
                                if (this.knl.kdn != null && this.knl.kdn.isShowing()) {
                                    Log.d("MicroMsg.MobileInputRegLogic", "already checking ");
                                    break;
                                } else {
                                    MobileInputUI mobileInputUI = this.knl;
                                    MobileInputUI mobileInputUI2 = this.knl;
                                    this.knl.getString(R.string.zb);
                                    mobileInputUI.kdn = com.tencent.mm.ui.base.h.a((Context) mobileInputUI2, this.knl.getString(R.string.fyo), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                                        /* class com.tencent.mm.plugin.account.ui.l.AnonymousClass2 */

                                        public final void onCancel(DialogInterface dialogInterface) {
                                        }
                                    });
                                    String obj = this.knl.knB.getText().toString();
                                    if (this.knm != null && this.knn != null && !obj.equals(this.knm) && obj.equals(this.knn)) {
                                        i2 = 1;
                                    } else if (this.knm == null || this.knn == null || this.knn.equals(this.knm) || obj.equals(this.knn)) {
                                        i2 = 0;
                                    } else {
                                        i2 = 2;
                                    }
                                    com.tencent.mm.modelfriend.a aVar2 = new com.tencent.mm.modelfriend.a(str, 12, "", 0, "");
                                    aVar2.sZ(this.kno);
                                    aVar2.ta(i2);
                                    if (com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIO("ie_reg_eu")) {
                                        com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIN("ie_reg_eu");
                                    }
                                    ewf ewf = new ewf();
                                    ewf.NtO = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIP("ie_reg_eu"));
                                    ewf.NtP = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIS("ce_reg"));
                                    ewf.NtQ = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.INSTANCE.exJ());
                                    ewf.NtU = new SKBuiltinBuffer_t().setBuffer(com.tencent.mm.plugin.normsg.a.d.INSTANCE.exM());
                                    String aIT = com.tencent.mm.plugin.normsg.a.d.INSTANCE.aIT("ce_reg");
                                    if (aIT != null) {
                                        ewf.NtV = new SKBuiltinBuffer_t().setBuffer(aIT.getBytes());
                                    }
                                    aVar2.a(ewf);
                                    g.azz().a(aVar2, 0);
                                    this.knm = this.knl.knB.getText().toString();
                                    this.kno++;
                                    break;
                                }
                            }
                            break;
                    }
                    this.knv = 0;
                    break;
                } else {
                    this.knl.knE.startAnimation(AnimationUtils.loadAnimation(this.knl, R.anim.a1));
                    AppMethodBeat.o(128299);
                    return;
                }
                break;
        }
        AppMethodBeat.o(128299);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        AppMethodBeat.i(128300);
        Log.i("MicroMsg.MobileInputRegLogic", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        if (this.knl.kdn != null) {
            this.knl.kdn.dismiss();
            this.knl.kdn = null;
        }
        if (i3 == -75) {
            com.tencent.mm.ui.base.h.n(this.knl, R.string.h0, R.string.fxq);
            AppMethodBeat.o(128300);
            return;
        }
        if (qVar.getType() == 145) {
            if (i3 == -41 || i3 == -59) {
                com.tencent.mm.h.a Dk = com.tencent.mm.h.a.Dk(str);
                if (Dk != null) {
                    Dk.a(this.knl, null, null);
                    AppMethodBeat.o(128300);
                    return;
                }
                com.tencent.mm.ui.base.h.n(this.knl, R.string.fz6, R.string.fz7);
                AppMethodBeat.o(128300);
                return;
            }
            int Vj = ((com.tencent.mm.modelfriend.a) qVar).Vj();
            if (Vj == 12) {
                this.knl.knP = PhoneFormater.pureNumber(this.knl.knP);
                this.knn = this.knl.knO + this.knl.knP;
                this.knu = ((com.tencent.mm.modelfriend.a) qVar).bbU();
                if (i3 == -36 || i3 == -35 || i3 == -3) {
                    String bbI = ((com.tencent.mm.modelfriend.a) qVar).bbI();
                    if (!Util.isNullOrNil(bbI)) {
                        this.knl.knP = bbI.trim();
                    }
                    StringBuilder sb = new StringBuilder();
                    g.aAf();
                    StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R200_200,");
                    g.aAf();
                    com.tencent.mm.plugin.b.a.j(true, append.append(com.tencent.mm.kernel.a.FN("R200_200")).append(",1").toString());
                    com.tencent.mm.h.a Dk2 = com.tencent.mm.h.a.Dk(str);
                    if (Dk2 != null) {
                        Dk2.a(this.knl, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.account.ui.l.AnonymousClass3 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(128293);
                                l.a(l.this);
                                AppMethodBeat.o(128293);
                            }
                        }, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.account.ui.l.AnonymousClass4 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(128294);
                                StringBuilder sb = new StringBuilder();
                                g.aAf();
                                StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R200_200,");
                                g.aAf();
                                com.tencent.mm.plugin.b.a.j(true, append.append(com.tencent.mm.kernel.a.FN("R200_200")).append(",2").toString());
                                AppMethodBeat.o(128294);
                            }
                        });
                        AppMethodBeat.o(128300);
                        return;
                    }
                    bpm();
                    StringBuilder sb2 = new StringBuilder();
                    g.aAf();
                    StringBuilder append2 = sb2.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R200_200,");
                    g.aAf();
                    com.tencent.mm.plugin.b.a.j(true, append2.append(com.tencent.mm.kernel.a.FN("R200_200")).append(",2").toString());
                    AppMethodBeat.o(128300);
                    return;
                } else if (i3 == -355) {
                    y.g(this.knl, str, 32046);
                    AppMethodBeat.o(128300);
                    return;
                } else if (i3 == -34) {
                    com.tencent.mm.ui.base.h.c(this.knl, this.knl.getString(R.string.adu), "", true);
                    AppMethodBeat.o(128300);
                    return;
                }
            }
            if (Vj == 14) {
                if (i3 == 0 || str == null) {
                    if (((com.tencent.mm.modelfriend.a) qVar).bbJ() == 1) {
                        String bbL = ((com.tencent.mm.modelfriend.a) qVar).bbL();
                        String bbK = ((com.tencent.mm.modelfriend.a) qVar).bbK();
                        Intent intent = new Intent(this.knl, RegByMobileSendSmsUI.class);
                        intent.putExtra("from_mobile", this.knl.knO + this.knl.knP);
                        intent.putExtra("to_mobile", bbL);
                        intent.putExtra("verify_code", bbK);
                        intent.putExtra("key_reg_style", 2);
                        intent.putExtra("kintent_password", this.knl.klM.getText().toString());
                        intent.putExtra("regsession_id", this.knu);
                        MobileInputUI mobileInputUI = this.knl;
                        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                        a.a(mobileInputUI, bl.axQ(), "com/tencent/mm/plugin/account/ui/MobileInputRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        mobileInputUI.startActivity((Intent) bl.pG(0));
                        a.a(mobileInputUI, "com/tencent/mm/plugin/account/ui/MobileInputRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    } else {
                        com.tencent.mm.plugin.b.a.bxl("R200_300");
                        Intent intent2 = new Intent();
                        intent2.putExtra("bindmcontact_mobile", this.knl.knO + " " + this.knl.knB.getText().toString());
                        intent2.putExtra("bindmcontact_shortmobile", this.knl.knP);
                        intent2.putExtra("country_name", this.knl.jbZ);
                        intent2.putExtra("couttry_code", this.knl.countryCode);
                        intent2.putExtra("mobileverify_countdownsec", ((com.tencent.mm.modelfriend.a) qVar).bbO());
                        intent2.putExtra("mobileverify_countdownstyle", ((com.tencent.mm.modelfriend.a) qVar).bbP());
                        intent2.putExtra("mobileverify_fb", ((com.tencent.mm.modelfriend.a) qVar).bbQ());
                        intent2.putExtra("mobileverify_reg_qq", ((com.tencent.mm.modelfriend.a) qVar).bbR());
                        intent2.putExtra("key_reg_style", 2);
                        intent2.putExtra("kintent_password", this.knl.klM.getText().toString());
                        intent2.putExtra("mobile_verify_purpose", 2);
                        intent2.putExtra("regsession_id", this.knu);
                        intent2.setClass(this.knl, MobileVerifyUI.class);
                        MobileInputUI mobileInputUI2 = this.knl;
                        com.tencent.mm.hellhoundlib.b.a bl2 = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                        a.a(mobileInputUI2, bl2.axQ(), "com/tencent/mm/plugin/account/ui/MobileInputRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        mobileInputUI2.startActivity((Intent) bl2.pG(0));
                        a.a(mobileInputUI2, "com/tencent/mm/plugin/account/ui/MobileInputRegLogic", "onSceneEnd", "(IILjava/lang/String;Lcom/tencent/mm/modelbase/NetSceneBase;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        m.a(m.a.SENT);
                    }
                } else if (i3 == -34) {
                    com.tencent.mm.ui.base.h.c(this.knl, this.knl.getString(R.string.adu), "", true);
                    AppMethodBeat.o(128300);
                    return;
                } else if (com.tencent.mm.plugin.account.a.a.jRu.a(this.knl, i2, i3, str)) {
                    AppMethodBeat.o(128300);
                    return;
                }
            }
            com.tencent.mm.h.a Dk3 = com.tencent.mm.h.a.Dk(str);
            if (!(Dk3 == null || this.knl == null || !Dk3.a(this.knl, null, null))) {
                AppMethodBeat.o(128300);
                return;
            }
        }
        AppMethodBeat.o(128300);
    }

    private void bpm() {
        AppMethodBeat.i(128301);
        MobileInputUI mobileInputUI = this.knl;
        MobileInputUI mobileInputUI2 = this.knl;
        this.knl.getString(R.string.zb);
        mobileInputUI.kdn = com.tencent.mm.ui.base.h.a((Context) mobileInputUI2, this.knl.getString(R.string.fyo), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.account.ui.l.AnonymousClass5 */

            public final void onCancel(DialogInterface dialogInterface) {
            }
        });
        com.tencent.mm.modelfriend.a aVar = new com.tencent.mm.modelfriend.a(this.knl.knO + this.knl.knP, 14, "", 0, "");
        aVar.Ok(this.knu);
        g.azz().a(aVar, 0);
        AppMethodBeat.o(128301);
    }
}
