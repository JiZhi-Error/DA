package com.tencent.mm.plugin.account.bind.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.view.View;
import android.widget.EditText;
import com.pay.tool.APPluginConstants;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelsimple.ad;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.protocal.protobuf.ept;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.widget.a.d;

public final class f implements i {
    Context context;
    private View kdm = null;
    q kdn = null;
    d kdo = null;
    SecurityImage kdp = null;
    String kdq = "";
    private byte[] kdr = null;
    private String kds = "";
    private String kdt;
    private a kdu;

    public interface a {
        void bnF();

        boolean dI(int i2, int i3);
    }

    public f(Context context2, a aVar) {
        this.context = context2;
        this.kdu = aVar;
    }

    public final void aSs() {
        AppMethodBeat.i(110182);
        g.azz().a(384, this);
        AppMethodBeat.o(110182);
    }

    public final void onDetach() {
        AppMethodBeat.i(110183);
        g.azz().b(384, this);
        if (this.kdu != null) {
            this.kdu.bnF();
        }
        AppMethodBeat.o(110183);
    }

    public final void bnG() {
        AppMethodBeat.i(110184);
        this.kdm = View.inflate(this.context, R.layout.bq_, null);
        final EditText editText = (EditText) this.kdm.findViewById(R.id.hks);
        editText.setHint(R.string.ag5);
        this.kdo = h.a(this.context, this.context.getString(R.string.ag0), this.kdm, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.account.bind.ui.f.AnonymousClass1 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(110175);
                f.this.kdo = null;
                f fVar = f.this;
                String trim = editText.getText().toString().trim();
                fVar.aSs();
                fVar.kdq = trim;
                Context context = fVar.context;
                fVar.context.getString(R.string.zb);
                fVar.kdn = h.a(context, fVar.context.getString(R.string.gko), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.account.bind.ui.f.AnonymousClass3 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(110177);
                        f.this.onDetach();
                        AppMethodBeat.o(110177);
                    }
                });
                g.azz().a(new ad(5, fVar.kdq, "", "", "", false, 1), 0);
                AppMethodBeat.o(110175);
            }
        }, new DialogInterface.OnClickListener() {
            /* class com.tencent.mm.plugin.account.bind.ui.f.AnonymousClass2 */

            public final void onClick(DialogInterface dialogInterface, int i2) {
                AppMethodBeat.i(110176);
                f.this.kdo = null;
                f.this.onDetach();
                AppMethodBeat.o(110176);
            }
        });
        AppMethodBeat.o(110184);
    }

    @Override // com.tencent.mm.ak.i
    @TargetApi(17)
    public final void onSceneEnd(int i2, int i3, String str, com.tencent.mm.ak.q qVar) {
        byte[] a2;
        AppMethodBeat.i(110185);
        onDetach();
        if (qVar == null || qVar.getType() != 384) {
            AppMethodBeat.o(110185);
            return;
        }
        if (this.kdn != null) {
            this.kdn.dismiss();
            this.kdn = null;
        }
        this.kds = z.a(((ept) ((ad) qVar).rr.iLL.iLR).Mdj);
        ad adVar = (ad) qVar;
        if (((ept) adVar.rr.iLL.iLR).KLb == null || ((ept) adVar.rr.iLL.iLR).KLb.getILen() <= 0) {
            a2 = z.a(((ept) adVar.rr.iLL.iLR).KHp);
        } else {
            a2 = g.aAf().azh().Ai(adVar.jkB);
        }
        this.kdr = a2;
        if (this.kdu == null || !this.kdu.dI(i2, i3)) {
            if (this.context instanceof Activity) {
                Activity activity = (Activity) this.context;
                if (activity.isFinishing() || (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed())) {
                    AppMethodBeat.o(110185);
                    return;
                }
            }
            if (i2 == 4) {
                switch (i3) {
                    case -311:
                    case -310:
                    case -6:
                        if (g.aAc()) {
                            if (this.kdp == null) {
                                this.kdp = SecurityImage.a.a(this.context, 0, this.kdr, this.kds, this.kdt, new DialogInterface.OnClickListener() {
                                    /* class com.tencent.mm.plugin.account.bind.ui.f.AnonymousClass5 */

                                    public final void onClick(DialogInterface dialogInterface, int i2) {
                                        AppMethodBeat.i(110180);
                                        final ad adVar = new ad(5, f.this.kdq, f.this.kdp.getSecImgSid(), f.this.kdp.getSecImgCode(), f.this.kdp.getSecImgEncryptKey(), true, 1);
                                        f.this.aSs();
                                        g.azz().a(adVar, 0);
                                        f fVar = f.this;
                                        Context context = f.this.context;
                                        f.this.context.getString(R.string.zb);
                                        fVar.kdn = h.a(context, f.this.context.getString(R.string.emm), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                                            /* class com.tencent.mm.plugin.account.bind.ui.f.AnonymousClass5.AnonymousClass1 */

                                            public final void onCancel(DialogInterface dialogInterface) {
                                                AppMethodBeat.i(110179);
                                                f.this.onDetach();
                                                g.azz().a(adVar);
                                                AppMethodBeat.o(110179);
                                            }
                                        });
                                        AppMethodBeat.o(110180);
                                    }
                                }, null, new DialogInterface.OnDismissListener() {
                                    /* class com.tencent.mm.plugin.account.bind.ui.f.AnonymousClass6 */

                                    public final void onDismiss(DialogInterface dialogInterface) {
                                        f.this.kdp = null;
                                    }
                                }, new b());
                                AppMethodBeat.o(110185);
                                return;
                            }
                            this.kdp.b(0, this.kdr, this.kds, this.kdt);
                        }
                        AppMethodBeat.o(110185);
                        return;
                    case -72:
                        this.kdo = h.n(this.context, R.string.b17, R.string.zb);
                        AppMethodBeat.o(110185);
                        return;
                    case APPluginConstants.ERROR_IO_ObjectStreamException_InvalidObjectException:
                        this.kdo = h.c(this.context, this.context.getString(R.string.afx), this.context.getString(R.string.zb), true);
                        AppMethodBeat.o(110185);
                        return;
                    case -3:
                        this.kdo = h.a(this.context, this.context.getString(R.string.ag4), this.context.getString(R.string.zb), new DialogInterface.OnClickListener() {
                            /* class com.tencent.mm.plugin.account.bind.ui.f.AnonymousClass4 */

                            public final void onClick(DialogInterface dialogInterface, int i2) {
                                AppMethodBeat.i(110178);
                                f.this.kdo = null;
                                f.this.onDetach();
                                f.this.bnG();
                                AppMethodBeat.o(110178);
                            }
                        }, (DialogInterface.OnClickListener) null);
                        AppMethodBeat.o(110185);
                        return;
                    default:
                        com.tencent.mm.h.a Dk = com.tencent.mm.h.a.Dk(str);
                        if (Dk != null) {
                            Dk.a(this.context, null, null);
                            AppMethodBeat.o(110185);
                            return;
                        }
                        AppMethodBeat.o(110185);
                        return;
                }
            } else {
                com.tencent.mm.h.a Dk2 = com.tencent.mm.h.a.Dk(str);
                if (Dk2 != null) {
                    Dk2.a(this.context, null, null);
                    AppMethodBeat.o(110185);
                    return;
                }
                AppMethodBeat.o(110185);
            }
        } else {
            AppMethodBeat.o(110185);
        }
    }

    class b extends SecurityImage.b {
        b() {
        }

        @Override // com.tencent.mm.ui.applet.SecurityImage.b
        public final void bnH() {
            AppMethodBeat.i(110181);
            f.this.aSs();
            g.azz().a(new ad(5, f.this.kdq, f.this.kdp.getSecImgSid(), f.this.kdp.getSecImgCode(), f.this.kdp.getSecImgEncryptKey(), true, 1), 0);
            AppMethodBeat.o(110181);
        }
    }
}
