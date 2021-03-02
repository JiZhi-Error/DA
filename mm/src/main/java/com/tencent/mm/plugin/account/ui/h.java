package com.tencent.mm.plugin.account.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bu;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.platformtools.e;
import com.tencent.mm.platformtools.y;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;

public final class h {
    private String account = "";
    private String edo;
    boolean kmX = false;
    private String knh = "";
    private a kni;
    private String username = "";

    public interface a {
        void a(ProgressDialog progressDialog);
    }

    public h(a aVar, String str, String str2, String str3) {
        this.username = str;
        this.account = str3;
        this.knh = str2;
        this.kni = aVar;
    }

    public final void b(MMActivity mMActivity) {
        AppMethodBeat.i(128262);
        String str = this.account;
        if (Util.isNullOrNil(this.account)) {
            str = this.username;
        }
        final t tVar = new t(str, this.knh, 0, "", "", "", 0, "", false, true);
        g.azz().a(tVar, 0);
        a aVar = this.kni;
        mMActivity.getString(R.string.zb);
        aVar.a(com.tencent.mm.ui.base.h.a((Context) mMActivity, mMActivity.getString(R.string.emm), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
            /* class com.tencent.mm.plugin.account.ui.h.AnonymousClass1 */

            public final void onCancel(DialogInterface dialogInterface) {
                AppMethodBeat.i(128259);
                g.azz().a(tVar);
                AppMethodBeat.o(128259);
            }
        }));
        AppMethodBeat.o(128262);
    }

    public final void a(final MMActivity mMActivity, int i2, int i3, String str, q qVar) {
        boolean z;
        boolean z2;
        String ayX;
        AppMethodBeat.i(128263);
        if (i2 == 4 && (i3 == -16 || i3 == -17)) {
            g.azz().a(new bu(new bu.a() {
                /* class com.tencent.mm.plugin.account.ui.h.AnonymousClass2 */

                @Override // com.tencent.mm.model.bu.a
                public final void a(com.tencent.mm.network.g gVar) {
                    AppMethodBeat.i(128260);
                    if (gVar == null) {
                        AppMethodBeat.o(128260);
                        return;
                    }
                    g.aAf();
                    gVar.aZh().a(new byte[0], new byte[0], new byte[0], com.tencent.mm.kernel.a.getUin());
                    AppMethodBeat.o(128260);
                }
            }), 0);
            z = true;
        } else {
            z = false;
        }
        if (qVar instanceof t) {
            this.edo = ((t) qVar).bfk();
        }
        if (z || (i2 == 0 && i3 == 0)) {
            com.tencent.mm.kernel.a.unhold();
            com.tencent.mm.platformtools.t.dr(mMActivity);
            y.St(this.account);
            y.showAddrBookUploadConfirm(mMActivity, new Runnable() {
                /* class com.tencent.mm.plugin.account.ui.h.AnonymousClass3 */

                public final void run() {
                    AppMethodBeat.i(128261);
                    Intent bZ = com.tencent.mm.plugin.account.a.a.jRt.bZ(mMActivity);
                    bZ.addFlags(67108864);
                    MMActivity mMActivity = mMActivity;
                    com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(bZ);
                    com.tencent.mm.hellhoundlib.a.a.a(mMActivity, bl.axQ(), "com/tencent/mm/plugin/account/ui/MobileAutoLogin$3", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    mMActivity.startActivity((Intent) bl.pG(0));
                    com.tencent.mm.hellhoundlib.a.a.a(mMActivity, "com/tencent/mm/plugin/account/ui/MobileAutoLogin$3", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                    mMActivity.finish();
                    AppMethodBeat.o(128261);
                }
            }, false, 2);
            if (this.kmX) {
                com.tencent.mm.plugin.report.service.h.INSTANCE.a(11930, MMApplicationContext.getContext().getSharedPreferences("randomid_prefs", com.tencent.mm.compatible.util.g.aps()).getString("randomID", ""), 4);
            }
            AppMethodBeat.o(128263);
        } else if (i3 == -106) {
            y.g(mMActivity, str, 0);
            AppMethodBeat.o(128263);
        } else if (i3 == -217) {
            y.a(mMActivity, e.a((t) qVar), i3);
            AppMethodBeat.o(128263);
        } else {
            if (com.tencent.mm.plugin.account.a.a.jRu.a(mMActivity, i2, i3, str)) {
                z2 = true;
            } else {
                if (i2 == 4) {
                    switch (i3) {
                        case -2023:
                        case -100:
                            com.tencent.mm.kernel.a.hold();
                            g.aAf();
                            if (TextUtils.isEmpty(com.tencent.mm.kernel.a.ayX())) {
                                ayX = com.tencent.mm.cb.a.aI(mMActivity, R.string.ev5);
                            } else {
                                g.aAf();
                                ayX = com.tencent.mm.kernel.a.ayX();
                            }
                            com.tencent.mm.ui.base.h.a(mMActivity, ayX, mMActivity.getString(R.string.zb), new DialogInterface.OnClickListener() {
                                /* class com.tencent.mm.plugin.account.ui.h.AnonymousClass4 */

                                public final void onClick(DialogInterface dialogInterface, int i2) {
                                }
                            }, new DialogInterface.OnCancelListener() {
                                /* class com.tencent.mm.plugin.account.ui.h.AnonymousClass5 */

                                public final void onCancel(DialogInterface dialogInterface) {
                                }
                            });
                            z2 = true;
                            break;
                        case -140:
                            if (!Util.isNullOrNil(this.edo)) {
                                y.m(mMActivity, str, this.edo);
                            }
                            z2 = true;
                            break;
                        case -75:
                            com.tencent.mm.ui.base.h.n(mMActivity, R.string.gz, R.string.zb);
                            z2 = true;
                            break;
                        case -72:
                            com.tencent.mm.ui.base.h.n(mMActivity, R.string.g0b, R.string.zb);
                            z2 = true;
                            break;
                        case -9:
                            com.tencent.mm.ui.base.h.n(mMActivity, R.string.em7, R.string.em8);
                            z2 = true;
                            break;
                        case -1:
                            if (g.azz().aYS() == 5) {
                                com.tencent.mm.ui.base.h.n(mMActivity, R.string.fbf, R.string.fbe);
                                z2 = true;
                                break;
                            }
                        case -4:
                        case -3:
                            com.tencent.mm.ui.base.h.n(mMActivity, R.string.by2, R.string.em8);
                            z2 = true;
                            break;
                    }
                }
                z2 = false;
            }
            if (z2) {
                AppMethodBeat.o(128263);
                return;
            }
            Toast.makeText(mMActivity, mMActivity.getString(R.string.de5, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}), 0).show();
            AppMethodBeat.o(128263);
        }
    }
}
