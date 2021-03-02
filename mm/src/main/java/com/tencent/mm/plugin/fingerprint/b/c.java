package com.tencent.mm.plugin.fingerprint.b;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.b.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ow;
import com.tencent.mm.plugin.fingerprint.b.a.b;
import com.tencent.mm.plugin.fingerprint.b.a.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.Map;

public final class c extends a {
    private String dNR;
    private String wFa;
    private a wFb = new a(this, (byte) 0);
    private com.tencent.mm.plugin.fingerprint.d.c wFc = null;

    public c() {
        AppMethodBeat.i(64295);
        AppMethodBeat.o(64295);
    }

    class a implements a.b {
        private a() {
        }

        /* synthetic */ a(c cVar, byte b2) {
            this();
        }

        @Override // com.huawei.b.a.b
        public final void bQ(int i2, int i3) {
            AppMethodBeat.i(64293);
            if (c.this.wFc != null) {
                com.tencent.mm.plugin.fingerprint.d.c unused = c.this.wFc;
            }
            AppMethodBeat.o(64293);
        }

        @Override // com.huawei.b.a.b
        public final void D(int i2, int i3, int i4) {
            AppMethodBeat.i(64294);
            if (c.this.wFc != null) {
                c.this.wFc.gz(i2, i3);
            }
            AppMethodBeat.o(64294);
        }
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.a
    public final void dJV() {
        AppMethodBeat.i(64299);
        Log.i("MicroMsg.FingerPrintMgrImpl", "initFP");
        this.wEX.prepare();
        AppMethodBeat.o(64299);
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.a
    public final boolean dJW() {
        return true;
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.a
    public final boolean dJX() {
        AppMethodBeat.i(64300);
        boolean dJX = d.dJX();
        AppMethodBeat.o(64300);
        return dJX;
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.a
    public final int a(final com.tencent.mm.plugin.fingerprint.d.c cVar, boolean z) {
        AppMethodBeat.i(64301);
        this.wEX.a(MMApplicationContext.getContext(), new f(p.IML.wFL, (byte) 0), new b() {
            /* class com.tencent.mm.plugin.fingerprint.b.c.AnonymousClass1 */

            @Override // com.tencent.mm.plugin.fingerprint.b.a.b
            public final void a(com.tencent.mm.plugin.fingerprint.b.a.c cVar) {
                boolean z;
                AppMethodBeat.i(64292);
                if (cVar.errCode == 0) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    c.this.dNR = cVar.dNR;
                    c.this.wFa = cVar.dNS;
                }
                cVar.gz(cVar.errCode, cVar.dNP);
                AppMethodBeat.o(64292);
            }
        });
        AppMethodBeat.o(64301);
        return 0;
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.a
    public final int a(com.tencent.mm.plugin.fingerprint.d.c cVar) {
        return 0;
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.a
    public final void a(ow owVar, int i2) {
        AppMethodBeat.i(64302);
        if (!TextUtils.isEmpty(this.dNR)) {
            Log.i("MicroMsg.FingerPrintMgrImpl", "success gen encrypted_pay_info!");
        } else {
            Log.i("MicroMsg.FingerPrintMgrImpl", "fail gen encrypted_pay_info!");
        }
        if (!TextUtils.isEmpty(this.wFa)) {
            Log.i("MicroMsg.FingerPrintMgrImpl", "success gen encrypted_pay_sign!");
        } else {
            Log.i("MicroMsg.FingerPrintMgrImpl", "fail gen encrypted_pay_sign!");
        }
        Log.i("MicroMsg.FingerPrintMgrImpl", "callback FingerPrintAuthEvent onSuccess()");
        if (!(owVar == null || owVar.dUQ.dUU == null)) {
            ow.b bVar = new ow.b();
            bVar.dUW = type();
            bVar.errCode = 0;
            bVar.dNR = this.dNR;
            bVar.dNS = this.wFa;
            bVar.dNP = i2;
            owVar.dUR = bVar;
            owVar.dUQ.dUU.run();
        }
        this.dNR = "";
        this.wFa = "";
        AppMethodBeat.o(64302);
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.a
    public final Map<String, String> dJY() {
        return null;
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.a
    public final Map<String, String> dJZ() {
        return null;
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.a
    public final boolean dKa() {
        return true;
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.a
    public final boolean a(boolean z, boolean z2, Bundle bundle) {
        return false;
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.a
    public final boolean dKb() {
        return false;
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.a
    public final boolean dKc() {
        return false;
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.a
    public final boolean dJT() {
        AppMethodBeat.i(64296);
        boolean fN = this.wEX.fN(MMApplicationContext.getContext());
        AppMethodBeat.o(64296);
        return fN;
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.a
    public final boolean dJU() {
        AppMethodBeat.i(64297);
        boolean dKr = this.wEX.dKr();
        AppMethodBeat.o(64297);
        return dKr;
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.a
    public final void fK(Context context) {
        AppMethodBeat.i(64298);
        if (context != null) {
            Intent intent = new Intent();
            intent.setAction("com.android.settings.fingerprint.FingerprintSettings");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setFlags(268435456);
            com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
            com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/huawei/securitymgr/HwFingerprintAuth", "startRigesterFinger", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
            context.startActivity((Intent) bl.pG(0));
            com.tencent.mm.hellhoundlib.a.a.a(context, "com/huawei/securitymgr/HwFingerprintAuth", "startRigesterFinger", "(Landroid/content/Context;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        }
        AppMethodBeat.o(64298);
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.a
    public final void userCancel() {
        AppMethodBeat.i(64303);
        this.wEX.cancel();
        AppMethodBeat.o(64303);
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.a
    public final int type() {
        AppMethodBeat.i(64304);
        int dKu = this.wEX.dKu();
        AppMethodBeat.o(64304);
        return dKu;
    }
}
