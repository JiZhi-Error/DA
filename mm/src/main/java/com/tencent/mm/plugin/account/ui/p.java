package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ak.i;
import com.tencent.mm.g.b.a.ka;
import com.tencent.mm.kernel.g;
import com.tencent.mm.modelfriend.a;
import com.tencent.mm.plugin.account.model.m;
import com.tencent.mm.plugin.account.ui.MobileVerifyUI;
import com.tencent.mm.ui.base.h;

public final class p implements i, MobileVerifyUI.c {
    String gwF;
    ka kkY = new ka();
    h klz = null;
    MobileVerifyUI koA;
    String koG;
    private boolean koH = true;

    public p() {
        AppMethodBeat.i(128435);
        AppMethodBeat.o(128435);
    }

    @Override // com.tencent.mm.plugin.account.ui.MobileVerifyUI.c
    public final void a(MobileVerifyUI mobileVerifyUI) {
        this.koA = mobileVerifyUI;
    }

    @Override // com.tencent.mm.plugin.account.ui.MobileVerifyUI.c
    public final void start() {
        AppMethodBeat.i(128436);
        g.azz().a(126, this);
        AppMethodBeat.o(128436);
    }

    @Override // com.tencent.mm.plugin.account.ui.MobileVerifyUI.c
    public final void stop() {
        AppMethodBeat.i(128437);
        g.azz().b(126, this);
        AppMethodBeat.o(128437);
    }

    @Override // com.tencent.mm.plugin.account.ui.MobileVerifyUI.c
    public final boolean a(MobileVerifyUI.a aVar) {
        AppMethodBeat.i(128438);
        switch (aVar) {
            case GoBack:
                h.c(this.koA, this.koA.getString(R.string.f2i), "", this.koA.getString(R.string.f2j), this.koA.getString(R.string.f2k), new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.account.ui.p.AnonymousClass9 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                        AppMethodBeat.i(128430);
                        p.this.koA.finish();
                        m.a(m.a.NONE);
                        AppMethodBeat.o(128430);
                    }
                }, new DialogInterface.OnClickListener() {
                    /* class com.tencent.mm.plugin.account.ui.p.AnonymousClass10 */

                    public final void onClick(DialogInterface dialogInterface, int i2) {
                    }
                });
                AppMethodBeat.o(128438);
                return true;
            case GoNext:
                g.azz().a(145, this);
                final a aVar2 = new a(this.koA.dSf, 15, this.koA.kbd.getText().toString().trim(), 0, "");
                aVar2.Ok(this.koA.knu);
                g.azz().a(aVar2, 0);
                MobileVerifyUI mobileVerifyUI = this.koA;
                MobileVerifyUI mobileVerifyUI2 = this.koA;
                this.koA.getString(R.string.zb);
                mobileVerifyUI.gtM = h.a((Context) mobileVerifyUI2, this.koA.getString(R.string.aey), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.account.ui.p.AnonymousClass11 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(128431);
                        g.azz().a(aVar2);
                        g.azz().b(145, p.this);
                        AppMethodBeat.o(128431);
                    }
                });
                break;
            case DoSend:
                g.azz().a(145, this);
                a aVar3 = new a(this.koA.dSf, 14, "", 0, "");
                aVar3.Ok(this.koA.knu);
                g.azz().a(aVar3, 0);
                m.a(m.a.SENT);
                break;
            case DoProcessSMS:
                StringBuilder sb = new StringBuilder();
                g.aAf();
                StringBuilder append = sb.append(com.tencent.mm.kernel.a.azt()).append(",").append(getClass().getName()).append(",R200_350_auto,");
                g.aAf();
                com.tencent.mm.plugin.b.a.DX(append.append(com.tencent.mm.kernel.a.FN("R200_350_auto")).append(",1").toString());
                g.azz().a(145, this);
                final a aVar4 = new a(this.koA.dSf, 15, this.koA.kbd.getText().toString().trim(), 0, "");
                aVar4.Ok(this.koA.knu);
                g.azz().a(aVar4, 0);
                MobileVerifyUI mobileVerifyUI3 = this.koA;
                MobileVerifyUI mobileVerifyUI4 = this.koA;
                this.koA.getString(R.string.zb);
                mobileVerifyUI3.gtM = h.a((Context) mobileVerifyUI4, this.koA.getString(R.string.aey), true, (DialogInterface.OnCancelListener) new DialogInterface.OnCancelListener() {
                    /* class com.tencent.mm.plugin.account.ui.p.AnonymousClass1 */

                    public final void onCancel(DialogInterface dialogInterface) {
                        AppMethodBeat.i(128422);
                        g.azz().a(aVar4);
                        g.azz().b(145, p.this);
                        AppMethodBeat.o(128422);
                    }
                });
                break;
        }
        AppMethodBeat.o(128438);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:85:0x0621  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x06d1  */
    @Override // com.tencent.mm.ak.i
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSceneEnd(int r25, int r26, java.lang.String r27, final com.tencent.mm.ak.q r28) {
        /*
        // Method dump skipped, instructions count: 2192
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.account.ui.p.onSceneEnd(int, int, java.lang.String, com.tencent.mm.ak.q):void");
    }
}
