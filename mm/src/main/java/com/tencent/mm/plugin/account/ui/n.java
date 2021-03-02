package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.plugin.account.friend.a.z;
import com.tencent.mm.plugin.account.ui.MobileVerifyUI;
import com.tencent.mm.plugin.account.ui.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;

public final class n implements i, MobileVerifyUI.c {
    SecurityImage kdp = null;
    g klt = null;
    private h klz = null;
    private int knQ;
    MobileVerifyUI koA;

    public n(int i2) {
        AppMethodBeat.i(128410);
        this.knQ = i2;
        Log.i("MicroMsg.MobileVerifyForgetPwdLogic", "forget pwd, purpose %d", Integer.valueOf(i2));
        AppMethodBeat.o(128410);
    }

    @Override // com.tencent.mm.plugin.account.ui.MobileVerifyUI.c
    public final void a(MobileVerifyUI mobileVerifyUI) {
        this.koA = mobileVerifyUI;
    }

    @Override // com.tencent.mm.plugin.account.ui.MobileVerifyUI.c
    public final void start() {
        AppMethodBeat.i(128411);
        StringBuilder sb = new StringBuilder();
        g.aAf();
        StringBuilder append = sb.append(a.azt()).append(",").append(getClass().getName()).append(",F200_300,");
        g.aAf();
        com.tencent.mm.plugin.b.a.j(true, append.append(a.FN("F200_300")).append(",1").toString());
        com.tencent.mm.plugin.b.a.bxk("F200_300");
        AppMethodBeat.o(128411);
    }

    @Override // com.tencent.mm.plugin.account.ui.MobileVerifyUI.c
    public final void stop() {
        AppMethodBeat.i(128412);
        int i2 = 2;
        if (this.koA.kpe != -1) {
            i2 = this.koA.kpe;
        }
        StringBuilder sb = new StringBuilder();
        g.aAf();
        StringBuilder append = sb.append(a.azt()).append(",").append(getClass().getName()).append(",F200_300,");
        g.aAf();
        com.tencent.mm.plugin.b.a.j(false, append.append(a.FN("F200_300")).append(",").append(i2).toString());
        AppMethodBeat.o(128412);
    }

    @Override // com.tencent.mm.plugin.account.ui.MobileVerifyUI.c
    public final boolean a(MobileVerifyUI.a aVar) {
        AppMethodBeat.i(128413);
        switch (aVar) {
            case GoNext:
                bpt();
                break;
            case DoSend:
                StringBuilder sb = new StringBuilder();
                g.aAf();
                StringBuilder append = sb.append(a.azt()).append(",").append(getClass().getName()).append(",R200_400,");
                g.aAf();
                com.tencent.mm.plugin.b.a.DX(append.append(a.FN("R200_400")).append(",1").toString());
                q qVar = null;
                if (this.knQ == 3) {
                    qVar = new com.tencent.mm.modelfriend.a(this.koA.dSf, 8, "", 0, "");
                } else if (this.knQ == 5) {
                    qVar = new z(this.koA.dSf, 20, "", 0, "");
                }
                if (qVar != null) {
                    g.azz().a(qVar, 0);
                    break;
                }
                break;
            case DoProcessSMS:
                bpt();
                break;
        }
        AppMethodBeat.o(128413);
        return false;
    }

    private void bpt() {
        AppMethodBeat.i(128414);
        StringBuilder sb = new StringBuilder();
        g.aAf();
        StringBuilder append = sb.append(a.azt()).append(",").append(getClass().getName()).append(",R200_350_auto,");
        g.aAf();
        com.tencent.mm.plugin.b.a.DX(append.append(a.FN("R200_350_auto")).append(",1").toString());
        g.azz().a(145, this);
        g.azz().a(132, this);
        final q qVar = null;
        if (this.knQ == 3) {
            qVar = new com.tencent.mm.modelfriend.a(this.koA.dSf, 9, this.koA.kbd.getText().toString().trim(), 0, "");
        } else if (this.knQ == 5) {
            qVar = new z(this.koA.dSf, 21, this.koA.kbd.getText().toString().trim(), 0, "");
        }
        if (qVar != null) {
            g.azz().a(qVar, 0);
            MobileVerifyUI mobileVerifyUI = this.koA;
            MobileVerifyUI mobileVerifyUI2 = this.koA;
            this.koA.getString(R.string.zb);
            mobileVerifyUI.gtM = h.a((Context) mobileVerifyUI2, this.koA.getString(R.string.aey), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                /* class com.tencent.mm.plugin.account.ui.n.AnonymousClass1 */

                public final void onCancel(DialogInterface dialogInterface) {
                    AppMethodBeat.i(128406);
                    g.azz().a(qVar);
                    g.azz().b(145, n.this);
                    g.azz().b(132, n.this);
                    AppMethodBeat.o(128406);
                }
            });
        }
        AppMethodBeat.o(128414);
    }

    @Override // com.tencent.mm.ak.i
    public final void onSceneEnd(int i2, int i3, String str, q qVar) {
        com.tencent.mm.h.a Dk;
        AppMethodBeat.i(128415);
        Log.i("MicroMsg.MobileVerifyForgetPwdLogic", "onSceneEnd: errType = " + i2 + " errCode = " + i3 + " errMsg = " + str);
        if (this.koA.gtM != null) {
            this.koA.gtM.dismiss();
            this.koA.gtM = null;
        }
        if (this.klt == null) {
            this.klt = new g();
        }
        if ((qVar.getType() == 252 || qVar.getType() == 701) && this.klz != null) {
            g.azz().b(701, this);
            g.azz().b(252, this);
            this.klt.kds = ((t) qVar).bfl();
            this.klt.kdr = ((t) qVar).bfm();
            this.klt.kdt = ((t) qVar).bfn();
            this.klt.kmJ = ((t) qVar).getSecCodeType();
            if (i3 == -6 || i3 == -311 || i3 == -310) {
                g.azz().a(701, this);
                g.azz().a(252, this);
                if (this.kdp == null) {
                    this.kdp = SecurityImage.a.a(this.koA, this.klt.kmJ, this.klt.kdr, this.klt.kds, this.klt.kdt, new DialogInterface.OnClickListener() {
                        /* class com.tencent.mm.plugin.account.ui.n.AnonymousClass2 */

                        public final void onClick(DialogInterface dialogInterface, int i2) {
                            AppMethodBeat.i(128408);
                            Log.d("MicroMsg.MobileVerifyForgetPwdLogic", "imgSid:" + n.this.klt.kds + " img len" + n.this.klt.kdr.length + " " + f.apq());
                            final t tVar = new t(n.this.klt.account, n.this.klt.kmI, n.this.klt.kmJ, n.this.kdp.getSecImgCode(), n.this.kdp.getSecImgSid(), n.this.kdp.getSecImgEncryptKey(), 1, "", false, true);
                            g.azz().a(tVar, 0);
                            MobileVerifyUI mobileVerifyUI = n.this.koA;
                            n.this.koA.getString(R.string.zb);
                            h.a((Context) mobileVerifyUI, n.this.koA.getString(R.string.emm), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                                /* class com.tencent.mm.plugin.account.ui.n.AnonymousClass2.AnonymousClass1 */

                                public final void onCancel(DialogInterface dialogInterface) {
                                    AppMethodBeat.i(128407);
                                    g.azz().a(tVar);
                                    g.azz().b(701, n.this);
                                    g.azz().b(252, n.this);
                                    AppMethodBeat.o(128407);
                                }
                            });
                            AppMethodBeat.o(128408);
                        }
                    }, null, new DialogInterface.OnDismissListener() {
                        /* class com.tencent.mm.plugin.account.ui.n.AnonymousClass3 */

                        public final void onDismiss(DialogInterface dialogInterface) {
                            n.this.kdp = null;
                        }
                    }, this.klt);
                    AppMethodBeat.o(128415);
                    return;
                }
                Log.d("MicroMsg.MobileVerifyForgetPwdLogic", "imgSid:" + this.klt.kds + " img len" + this.klt.kdr.length + " " + f.apq());
                this.kdp.b(this.klt.kmJ, this.klt.kdr, this.klt.kds, this.klt.kdt);
                AppMethodBeat.o(128415);
                return;
            }
            this.klz.a(this.koA, i2, i3, str, qVar);
            if (i2 == 0 && i3 == 0) {
                boolean z = true;
                if (qVar instanceof t) {
                    z = ((t) qVar).bfu();
                }
                this.koA.gq(z);
            }
            AppMethodBeat.o(128415);
            return;
        }
        if (qVar.getType() == 145) {
            this.klt.account = ((com.tencent.mm.modelfriend.a) qVar).getUsername();
            this.klt.kmI = ((com.tencent.mm.modelfriend.a) qVar).bbF();
            g.azz().b(145, this);
            if (i2 == 0 && i3 == 0) {
                if (this.knQ == 3) {
                    g.azz().a(701, this);
                    g.azz().a(252, this);
                    this.klz = new h(new h.a() {
                        /* class com.tencent.mm.plugin.account.ui.n.AnonymousClass4 */

                        @Override // com.tencent.mm.plugin.account.ui.h.a
                        public final void a(ProgressDialog progressDialog) {
                            n.this.koA.gtM = progressDialog;
                        }
                    }, ((com.tencent.mm.modelfriend.a) qVar).getUsername(), ((com.tencent.mm.modelfriend.a) qVar).bbF(), this.koA.dSf);
                    this.klz.b(this.koA);
                }
                AppMethodBeat.o(128415);
                return;
            } else if (i3 == -51) {
                com.tencent.mm.h.a Dk2 = com.tencent.mm.h.a.Dk(str);
                if (Dk2 != null) {
                    Dk2.a(this.koA, null, null);
                    AppMethodBeat.o(128415);
                    return;
                }
                com.tencent.mm.ui.base.h.n(this.koA, R.string.af3, R.string.af9);
                AppMethodBeat.o(128415);
                return;
            }
        }
        if (qVar.getType() == 132) {
            g.azz().b(132, this);
            if (i2 == 0 && i3 == 0) {
                if (this.knQ == 5) {
                    String bbG = ((z) qVar).bbG();
                    Intent intent = new Intent();
                    intent.putExtra("setpwd_ticket", bbG);
                    this.koA.setResult(-1, intent);
                    this.koA.finish();
                }
                AppMethodBeat.o(128415);
                return;
            } else if (i3 == -51) {
                com.tencent.mm.h.a Dk3 = com.tencent.mm.h.a.Dk(str);
                if (Dk3 != null) {
                    Dk3.a(this.koA, null, null);
                    AppMethodBeat.o(128415);
                    return;
                }
                com.tencent.mm.ui.base.h.n(this.koA, R.string.af3, R.string.af9);
                AppMethodBeat.o(128415);
                return;
            }
        }
        if (this.koA.n(i2, i3, str)) {
            AppMethodBeat.o(128415);
        } else if ((qVar.getType() == 252 || qVar.getType() == 701) && (Dk = com.tencent.mm.h.a.Dk(str)) != null && Dk.a(this.koA, null, null)) {
            AppMethodBeat.o(128415);
        } else {
            if (!(i2 == 0 && i3 == 0)) {
                Toast.makeText(this.koA, this.koA.getString(R.string.af2, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}), 0).show();
            }
            AppMethodBeat.o(128415);
        }
    }
}
