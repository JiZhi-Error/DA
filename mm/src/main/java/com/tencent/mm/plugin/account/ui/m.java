package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.pay.tool.APPluginConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bf;
import com.tencent.mm.model.bu;
import com.tencent.mm.model.ch;
import com.tencent.mm.model.z;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.platformtools.e;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.ui.MobileInputUI;
import com.tencent.mm.plugin.account.ui.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.PhoneFormater;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;
import com.tencent.recovery.wx.util.WXUtil;

public final class m implements i, MobileInputUI.b {
    String account;
    private String dQC;
    private String edo;
    SecurityImage kdp = null;
    private String kjv;
    private boolean klu = true;
    private String klw;
    MobileInputUI knl;

    static /* synthetic */ void a(m mVar) {
        AppMethodBeat.i(128330);
        mVar.bpn();
        AppMethodBeat.o(128330);
    }

    static /* synthetic */ void a(m mVar, String str, String str2) {
        AppMethodBeat.i(128328);
        mVar.cc(str, str2);
        AppMethodBeat.o(128328);
    }

    static /* synthetic */ void b(m mVar, String str) {
        AppMethodBeat.i(128332);
        mVar.Tu(str);
        AppMethodBeat.o(128332);
    }

    @Override // com.tencent.mm.plugin.account.ui.MobileInputUI.b
    public final void a(MobileInputUI mobileInputUI) {
        AppMethodBeat.i(128319);
        this.knl = mobileInputUI;
        mobileInputUI.knJ.setVisibility(0);
        this.account = mobileInputUI.getIntent().getStringExtra("binded_mobile");
        if (Util.isNullOrNil(this.account)) {
            this.account = PhoneFormater.pureNumber(mobileInputUI.knO + mobileInputUI.knP);
        }
        mobileInputUI.knC.setTextColor(mobileInputUI.getResources().getColor(R.color.uj));
        mobileInputUI.knC.setEnabled(false);
        mobileInputUI.knC.setFocusable(false);
        mobileInputUI.knB.setFocusable(false);
        mobileInputUI.knB.setText(PhoneFormater.pureNumber(this.account));
        mobileInputUI.knB.setVisibility(0);
        bpn();
        mobileInputUI.knL.setVisibility(0);
        mobileInputUI.knH.setText(R.string.emf);
        mobileInputUI.knH.setVisibility(0);
        mobileInputUI.knH.setEnabled(true);
        this.klw = bf.iDu.aA(WXUtil.LAST_LOGIN_WEXIN_USERNAME, "");
        this.kjv = mobileInputUI.getIntent().getStringExtra("auth_ticket");
        if (!Util.isNullOrNil(this.kjv)) {
            new MMHandler().postDelayed(new Runnable() {
                /* class com.tencent.mm.plugin.account.ui.m.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(128303);
                    m.a(m.this, g.bpk(), g.bpl());
                    AppMethodBeat.o(128303);
                }
            }, 500);
        }
        AppMethodBeat.o(128319);
    }

    private void bpn() {
        AppMethodBeat.i(128320);
        if (this.knl.iDM == 6) {
            this.knl.knD.reset();
            this.knl.knL.setText(R.string.emi);
            this.knl.kmS.setVisibility(8);
            this.knl.knD.setVisibility(0);
            this.knl.knD.getContentEditText().requestFocus();
            this.knl.knD.setSendSmsBtnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.account.ui.m.AnonymousClass12 */

                public final void onClick(View view) {
                    AppMethodBeat.i(128311);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    m.a(m.this, m.this.account);
                    a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(128311);
                }
            });
            this.knl.knL.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.account.ui.m.AnonymousClass13 */

                public final void onClick(View view) {
                    AppMethodBeat.i(128312);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    m.this.knl.kmr[1] = 2;
                    m.this.knl.iDM = 7;
                    m.this.knl.knD.reset();
                    g.azz().b(145, m.this);
                    m.a(m.this);
                    a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(128312);
                }
            });
            AppMethodBeat.o(128320);
            return;
        }
        if (this.knl.iDM == 7) {
            this.knl.knL.setText(R.string.emj);
            this.knl.kmS.setVisibility(0);
            this.knl.klM.requestFocus();
            this.knl.knD.setVisibility(8);
            this.knl.knL.setOnClickListener(new View.OnClickListener() {
                /* class com.tencent.mm.plugin.account.ui.m.AnonymousClass14 */

                public final void onClick(View view) {
                    AppMethodBeat.i(128313);
                    b bVar = new b();
                    bVar.bm(view);
                    a.b("com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, bVar.axR());
                    m.this.knl.kmr[1] = 1;
                    m.this.knl.iDM = 6;
                    g.azz().a(145, m.this);
                    m.a(m.this);
                    a.a(this, "com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                    AppMethodBeat.o(128313);
                }
            });
        }
        AppMethodBeat.o(128320);
    }

    @Override // com.tencent.mm.plugin.account.ui.MobileInputUI.b
    public final void start() {
        AppMethodBeat.i(128321);
        g.azz().a(252, this);
        g.azz().a(701, this);
        g.azz().a(145, this);
        StringBuilder sb = new StringBuilder();
        g.aAf();
        StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",L200_100,");
        g.aAf();
        com.tencent.mm.plugin.b.a.j(true, append.append(com.tencent.mm.kernel.a.FN("L200_100")).append(",1").toString());
        com.tencent.mm.plugin.b.a.bxk("L200_100");
        AppMethodBeat.o(128321);
    }

    @Override // com.tencent.mm.plugin.account.ui.MobileInputUI.b
    public final void stop() {
        AppMethodBeat.i(128322);
        g.azz().b(701, this);
        g.azz().b(252, this);
        g.azz().b(145, this);
        StringBuilder sb = new StringBuilder();
        g.aAf();
        StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",L200_100,");
        g.aAf();
        com.tencent.mm.plugin.b.a.j(false, append.append(com.tencent.mm.kernel.a.FN("L200_100")).append(",2").toString());
        AppMethodBeat.o(128322);
    }

    @Override // com.tencent.mm.plugin.account.ui.MobileInputUI.b
    public final void a(MobileInputUI.a aVar) {
        AppMethodBeat.i(128323);
        switch (aVar) {
            case GoNext:
                this.knl.hideVKB();
                this.knl.knO = PhoneFormater.countryCodeWithPlus(this.knl.countryCode);
                this.knl.knP = this.knl.knC.getText().toString();
                if (!Util.isNullOrNil(this.knl.knO) && !Util.isNullOrNil(this.knl.knP)) {
                    if (this.knl.iDM != 7) {
                        if (this.knl.iDM == 6) {
                            String trim = this.knl.knD.getText().toString().trim();
                            if (!Util.isNullOrNil(trim)) {
                                this.knl.hideVKB();
                                final com.tencent.mm.modelfriend.a aVar2 = new com.tencent.mm.modelfriend.a(this.account, 17, trim, 0, "");
                                g.azz().a(aVar2, 0);
                                MobileInputUI mobileInputUI = this.knl;
                                MobileInputUI mobileInputUI2 = this.knl;
                                this.knl.getString(R.string.zb);
                                mobileInputUI.kdn = h.a((Context) mobileInputUI2, this.knl.getString(R.string.aey), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                                    /* class com.tencent.mm.plugin.account.ui.m.AnonymousClass16 */

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        AppMethodBeat.i(128315);
                                        g.azz().a(aVar2);
                                        AppMethodBeat.o(128315);
                                    }
                                });
                                break;
                            } else {
                                h.n(this.knl, R.string.hvr, R.string.em8);
                                AppMethodBeat.o(128323);
                                return;
                            }
                        }
                    } else if (!Util.isNullOrNil(this.dQC)) {
                        cc(this.account, this.dQC);
                        AppMethodBeat.o(128323);
                        return;
                    } else {
                        cc(this.account, this.knl.klM.getText().toString());
                        AppMethodBeat.o(128323);
                        return;
                    }
                } else {
                    AppMethodBeat.o(128323);
                    return;
                }
                break;
        }
        AppMethodBeat.o(128323);
    }

    private void Tu(String str) {
        AppMethodBeat.i(128324);
        final com.tencent.mm.modelfriend.a aVar = new com.tencent.mm.modelfriend.a(str, 16, "", 0, "");
        g.azz().a(aVar, 0);
        MobileInputUI mobileInputUI = this.knl;
        MobileInputUI mobileInputUI2 = this.knl;
        this.knl.getString(R.string.zb);
        mobileInputUI.kdn = h.a((Context) mobileInputUI2, this.knl.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.account.ui.m.AnonymousClass17 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(128316);
                g.azz().a(aVar);
                AppMethodBeat.o(128316);
            }
        });
        AppMethodBeat.o(128324);
    }

    private void cc(String str, String str2) {
        AppMethodBeat.i(128325);
        if (Util.isNullOrNil(str)) {
            h.n(this.knl, R.string.hvs, R.string.em8);
            AppMethodBeat.o(128325);
        } else if (Util.isNullOrNil(str2)) {
            h.n(this.knl, R.string.hvk, R.string.em8);
            AppMethodBeat.o(128325);
        } else {
            this.knl.klM.setText(str2);
            this.knl.hideVKB();
            final t tVar = new t(str, str2, (String) null, 1);
            g.azz().a(tVar, 0);
            MobileInputUI mobileInputUI = this.knl;
            MobileInputUI mobileInputUI2 = this.knl;
            this.knl.getString(R.string.zb);
            mobileInputUI.kdn = h.a((Context) mobileInputUI2, this.knl.getString(R.string.emm), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.account.ui.m.AnonymousClass18 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(128317);
                    g.azz().a(tVar);
                    AppMethodBeat.o(128317);
                }
            });
            AppMethodBeat.o(128325);
        }
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        boolean z;
        AppMethodBeat.i(128326);
        Log.i("MicroMsg.MobileInputIndepPassLoginLogic", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        if (this.knl.kdn != null) {
            this.knl.kdn.dismiss();
            this.knl.kdn = null;
        }
        if (qVar.getType() == 145) {
            int Vj = ((com.tencent.mm.modelfriend.a) qVar).Vj();
            if (Vj == 13) {
                if (i3 == -36) {
                    com.tencent.mm.h.a Dk = com.tencent.mm.h.a.Dk(str);
                    if (((com.tencent.mm.modelfriend.a) qVar).bbJ() == 1) {
                        Log.i("MicroMsg.MobileInputIndepPassLoginLogic", "login check state, sms up");
                        if (Dk != null) {
                            Dk.a(this.knl, new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.plugin.account.ui.m.AnonymousClass19 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                    AppMethodBeat.i(128318);
                                    m.b(m.this);
                                    AppMethodBeat.o(128318);
                                }
                            }, null);
                            AppMethodBeat.o(128326);
                            return;
                        }
                        h.a(this.knl, this.knl.getString(R.string.em3), "", new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.account.ui.m.AnonymousClass2 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(128304);
                                m.b(m.this);
                                AppMethodBeat.o(128304);
                            }
                        }, (DialogInterface.OnClickListener) null);
                    } else if (Dk != null) {
                        Dk.a(this.knl, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.account.ui.m.AnonymousClass3 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(128305);
                                m.this.knl.knD.bTu();
                                m.b(m.this, m.this.account);
                                AppMethodBeat.o(128305);
                            }
                        }, null);
                        AppMethodBeat.o(128326);
                        return;
                    } else {
                        this.knl.knD.bTu();
                        Tu(this.account);
                    }
                }
            } else if (Vj == 16) {
                if (i3 == -41) {
                    this.knl.knD.reset();
                    h.n(this.knl, R.string.fz6, R.string.fz7);
                    AppMethodBeat.o(128326);
                    return;
                } else if (i3 == -75) {
                    this.knl.knD.reset();
                    h.c(this.knl, this.knl.getString(R.string.gz), "", true);
                    AppMethodBeat.o(128326);
                    return;
                } else if (i3 == -106) {
                    this.knl.knD.reset();
                    y.g(this.knl, str, 32045);
                    AppMethodBeat.o(128326);
                    return;
                }
            } else if (Vj == 17) {
                if (i2 == 0 && i3 == 0) {
                    new h(new h.a() {
                        /* class com.tencent.mm.plugin.account.ui.m.AnonymousClass4 */

                        @Override // com.tencent.mm.plugin.account.ui.h.a
                        public final void a(ProgressDialog progressDialog) {
                            m.this.knl.kdn = (com.tencent.mm.ui.base.q) progressDialog;
                        }
                    }, ((com.tencent.mm.modelfriend.a) qVar).getUsername(), ((com.tencent.mm.modelfriend.a) qVar).bbF(), this.account).b(this.knl);
                    AppMethodBeat.o(128326);
                    return;
                } else if (n(i2, i3, str)) {
                    AppMethodBeat.o(128326);
                    return;
                } else {
                    com.tencent.mm.h.a Dk2 = com.tencent.mm.h.a.Dk(str);
                    if (Dk2 != null) {
                        Dk2.a(this.knl, null, null);
                    }
                }
            }
        } else if (qVar.getType() == 252 || qVar.getType() == 701) {
            this.edo = ((t) qVar).bfk();
            final g gVar = new g();
            gVar.kds = ((t) qVar).bfl();
            gVar.kdr = ((t) qVar).bfm();
            gVar.kdt = ((t) qVar).bfn();
            gVar.kmJ = ((t) qVar).getSecCodeType();
            gVar.account = ((t) qVar).account;
            gVar.kdq = this.knl.klM.getText().toString();
            if (i3 == -75) {
                y.dz(this.knl);
                AppMethodBeat.o(128326);
                return;
            } else if (i3 == -106) {
                y.g(this.knl, str, 32045);
                AppMethodBeat.o(128326);
                return;
            } else if (i3 == -217) {
                y.a(this.knl, e.a((t) qVar), i3);
                AppMethodBeat.o(128326);
                return;
            } else if (i3 == -205) {
                this.kjv = ((t) qVar).bbH();
                String bfp = ((t) qVar).bfp();
                String bfs = ((t) qVar).bfs();
                Log.i("MicroMsg.MobileInputIndepPassLoginLogic", "summerphone MM_ERR_QQ_OK_NEED_MOBILE authTicket[%s], closeShowStyle[%s]", Util.secPrint(this.kjv), bfs);
                g.a(gVar);
                Intent intent = new Intent();
                intent.putExtra("auth_ticket", this.kjv);
                intent.putExtra("binded_mobile", bfp);
                intent.putExtra("close_safe_device_style", bfs);
                intent.putExtra("from_source", 6);
                com.tencent.mm.plugin.account.a.a.jRt.g(this.knl, intent);
                AppMethodBeat.o(128326);
                return;
            } else if (i3 == -140) {
                if (!Util.isNullOrNil(this.edo)) {
                    y.m(this.knl, str, this.edo);
                }
                AppMethodBeat.o(128326);
                return;
            } else {
                if (i2 == 4 && (i3 == -16 || i3 == -17)) {
                    g.azz().a(new bu(new bu.a() {
                        /* class com.tencent.mm.plugin.account.ui.m.AnonymousClass5 */

                        @Override // com.tencent.mm.model.bu.a
                        public final void a(com.tencent.mm.network.g gVar) {
                            AppMethodBeat.i(128306);
                            if (gVar == null) {
                                AppMethodBeat.o(128306);
                                return;
                            }
                            g.aAf();
                            gVar.aZh().a(new byte[0], new byte[0], new byte[0], com.tencent.mm.kernel.a.getUin());
                            AppMethodBeat.o(128306);
                        }
                    }), 0);
                    z = true;
                } else {
                    z = false;
                }
                if (i3 == -6 || i3 == -311 || i3 == -310) {
                    if (this.kdp == null) {
                        this.kdp = SecurityImage.a.a(this.knl, gVar.kmJ, gVar.kdr, gVar.kds, gVar.kdt, new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.account.ui.m.AnonymousClass6 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(128308);
                                Log.d("MicroMsg.MobileInputIndepPassLoginLogic", "imgSid:" + gVar.kds + " img len" + gVar.kdr.length + " " + f.apq());
                                final t tVar = new t(gVar.account, gVar.kdq, gVar.kmJ, m.this.kdp.getSecImgCode(), m.this.kdp.getSecImgSid(), m.this.kdp.getSecImgEncryptKey(), 1, "", false, false);
                                g.azz().a(tVar, 0);
                                MobileInputUI mobileInputUI = m.this.knl;
                                MobileInputUI mobileInputUI2 = m.this.knl;
                                m.this.knl.getString(R.string.zb);
                                mobileInputUI.kdn = com.tencent.mm.ui.base.h.a((Context) mobileInputUI2, m.this.knl.getString(R.string.emm), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                                    /* class com.tencent.mm.plugin.account.ui.m.AnonymousClass6.AnonymousClass1 */

                                    public final void onCancel(DialogInterface dialogInterface) {
                                        AppMethodBeat.i(128307);
                                        g.azz().a(tVar);
                                        AppMethodBeat.o(128307);
                                    }
                                });
                                AppMethodBeat.o(128308);
                            }
                        }, null, new DialogInterface.OnDismissListener() {
                            /* class com.tencent.mm.plugin.account.ui.m.AnonymousClass7 */

                            public final void onDismiss(DialogInterface dialogInterface) {
                                m.this.kdp = null;
                            }
                        }, gVar);
                        AppMethodBeat.o(128326);
                        return;
                    }
                    Log.d("MicroMsg.MobileInputIndepPassLoginLogic", "imgSid:" + gVar.kds + " img len" + gVar.kdr.length + " " + f.apq());
                    this.kdp.b(gVar.kmJ, gVar.kdr, gVar.kds, gVar.kdt);
                    AppMethodBeat.o(128326);
                    return;
                } else if (z || (i2 == 0 && i3 == 0)) {
                    g.aAf();
                    com.tencent.mm.kernel.a.unhold();
                    l.boe();
                    Log.i("MicroMsg.MobileInputIndepPassLoginLogic", "login username %s", gVar.account);
                    y.St(gVar.account);
                    String aA = bf.iDu.aA(WXUtil.LAST_LOGIN_WEXIN_USERNAME, "");
                    com.tencent.mm.platformtools.t.dr(this.knl);
                    if (this.knl.klv) {
                        ch.iFO.aR(this.klw, aA);
                        ch.iFO.h(z.aTY(), z.aUS());
                        com.tencent.mm.plugin.report.service.h.INSTANCE.a(14978, 1, 9, ch.iFO.aWp());
                    }
                    y.showAddrBookUploadConfirm(this.knl, new Runnable() {
                        /* class com.tencent.mm.plugin.account.ui.m.AnonymousClass8 */

                        public final void run() {
                            AppMethodBeat.i(128309);
                            Log.d("MicroMsg.MobileInputIndepPassLoginLogic", "onSceneEnd, in runnable");
                            Intent bZ = com.tencent.mm.plugin.account.a.a.jRt.bZ(m.this.knl);
                            bZ.addFlags(67108864);
                            MobileInputUI mobileInputUI = m.this.knl;
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(bZ);
                            a.a(mobileInputUI, bl.axQ(), "com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$16", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            mobileInputUI.startActivity((Intent) bl.pG(0));
                            a.a(mobileInputUI, "com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic$16", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            m.this.knl.finish();
                            AppMethodBeat.o(128309);
                        }
                    }, false, 2);
                    if (this.knl.iDM == 6) {
                        this.klu = ((t) qVar).bfu();
                        if (((t) qVar).bfo()) {
                            MobileInputUI mobileInputUI = this.knl;
                            boolean z2 = this.klu;
                            Intent intent2 = new Intent(mobileInputUI, RegByMobileSetPwdUI.class);
                            intent2.putExtra("kintent_hint", mobileInputUI.getString(R.string.gr1));
                            intent2.putExtra("kintent_cancelable", z2);
                            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent2);
                            a.a(mobileInputUI, bl.axQ(), "com/tencent/mm/plugin/account/ui/MobileInputUI", "goToSetIndepPwd", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                            mobileInputUI.startActivity((Intent) bl.pG(0));
                            a.a(mobileInputUI, "com/tencent/mm/plugin/account/ui/MobileInputUI", "goToSetIndepPwd", "(Z)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                        }
                    }
                    AppMethodBeat.o(128326);
                    return;
                } else if (n(i2, i3, str)) {
                    AppMethodBeat.o(128326);
                    return;
                } else if (!(i2 == 0 && i3 == 0)) {
                    Toast.makeText(this.knl, this.knl.getString(R.string.de5, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}), 0).show();
                }
            }
        }
        com.tencent.mm.h.a Dk3 = com.tencent.mm.h.a.Dk(str);
        if (Dk3 == null || this.knl == null || !Dk3.a(this.knl, null, null)) {
            AppMethodBeat.o(128326);
        } else {
            AppMethodBeat.o(128326);
        }
    }

    private boolean n(int i2, int i3, String str) {
        String ayX;
        AppMethodBeat.i(128327);
        if (com.tencent.mm.plugin.account.a.a.jRu.a(this.knl, i2, i3, str)) {
            AppMethodBeat.o(128327);
            return true;
        }
        if (i2 == 4) {
            switch (i3) {
                case -2023:
                case -100:
                    g.aAf();
                    com.tencent.mm.kernel.a.hold();
                    MobileInputUI mobileInputUI = this.knl;
                    g.aAf();
                    if (TextUtils.isEmpty(com.tencent.mm.kernel.a.ayX())) {
                        ayX = com.tencent.mm.cb.a.aI(this.knl, R.string.ev5);
                    } else {
                        g.aAf();
                        ayX = com.tencent.mm.kernel.a.ayX();
                    }
                    com.tencent.mm.ui.base.h.a(mobileInputUI, ayX, this.knl.getString(R.string.zb), new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.account.ui.m.AnonymousClass9 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                        }
                    }, new DialogInterface.OnCancelListener() {
                        /* class com.tencent.mm.plugin.account.ui.m.AnonymousClass10 */

                        public final void onCancel(DialogInterface dialogInterface) {
                        }
                    });
                    AppMethodBeat.o(128327);
                    return true;
                case -140:
                    if (!Util.isNullOrNil(this.edo)) {
                        y.m(this.knl, str, this.edo);
                    }
                    AppMethodBeat.o(128327);
                    return true;
                case APPluginConstants.ERROR_IO_ObjectStreamException_InvalidObjectException:
                    Toast.makeText(this.knl, (int) R.string.adu, 0).show();
                    AppMethodBeat.o(128327);
                    return true;
                case APPluginConstants.ERROR_IO_ObjectStreamException_InvalidClassException:
                    com.tencent.mm.ui.base.h.a(this.knl, (int) R.string.af3, (int) R.string.af9, (DialogInterface.OnClickListener) null);
                    AppMethodBeat.o(128327);
                    return true;
                case APPluginConstants.ERROR_IO_NoHttpResponseException:
                    com.tencent.mm.ui.base.h.a(this.knl, (int) R.string.af5, (int) R.string.af9, (DialogInterface.OnClickListener) null);
                    AppMethodBeat.o(128327);
                    return true;
                case -9:
                    com.tencent.mm.ui.base.h.n(this.knl, R.string.em7, R.string.em8);
                    AppMethodBeat.o(128327);
                    return true;
                case -3:
                    com.tencent.mm.ui.base.h.n(this.knl, R.string.by2, R.string.em8);
                    AppMethodBeat.o(128327);
                    return true;
                case -1:
                    if (g.azz().aYS() == 5) {
                        com.tencent.mm.ui.base.h.n(this.knl, R.string.fbf, R.string.fbe);
                        AppMethodBeat.o(128327);
                        return true;
                    }
                    AppMethodBeat.o(128327);
                    return false;
            }
        }
        AppMethodBeat.o(128327);
        return false;
    }

    static /* synthetic */ void a(m mVar, String str) {
        AppMethodBeat.i(128329);
        if (!Util.isNullOrNil(str)) {
            final com.tencent.mm.modelfriend.a aVar = new com.tencent.mm.modelfriend.a(str, 13, "", 0, "");
            g.azz().a(aVar, 0);
            MobileInputUI mobileInputUI = mVar.knl;
            MobileInputUI mobileInputUI2 = mVar.knl;
            mVar.knl.getString(R.string.zb);
            mobileInputUI.kdn = com.tencent.mm.ui.base.h.a((Context) mobileInputUI2, mVar.knl.getString(R.string.a06), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.account.ui.m.AnonymousClass15 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(128314);
                    g.azz().a(aVar);
                    AppMethodBeat.o(128314);
                }
            });
        }
        AppMethodBeat.o(128329);
    }

    static /* synthetic */ void b(m mVar) {
        AppMethodBeat.i(128331);
        Intent intent = new Intent(mVar.knl, LoginByMobileSendSmsUI.class);
        intent.putExtra("from_mobile", mVar.account);
        intent.putExtra("from_switch_account", mVar.knl.klv);
        MobileInputUI mobileInputUI = mVar.knl;
        com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
        a.a(mobileInputUI, bl.axQ(), "com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic", "jumpToLoginSmsUp", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        mobileInputUI.startActivity((Intent) bl.pG(0));
        a.a(mobileInputUI, "com/tencent/mm/plugin/account/ui/MobileInputSmsPwdLoginLogic", "jumpToLoginSmsUp", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(128331);
    }
}
