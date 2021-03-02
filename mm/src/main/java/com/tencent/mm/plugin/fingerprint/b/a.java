package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.g.a.ow;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.a.i;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class a implements com.tencent.mm.plugin.fingerprint.d.a {
    protected i wEX;

    @Override // com.tencent.mm.plugin.fingerprint.d.a
    public final void dJN() {
        Log.i("MicroMsg.BaseFingerprintImp", "showFingerPrintEntrance");
        if (dJO() && !dJU()) {
            Log.e("MicroMsg.BaseFingerprintImp", "the fingerprint is open ready, but system has none Finger print ids!");
        } else if (dJR() && !dKc()) {
            Log.e("MicroMsg.BaseFingerprintImp", "the faceid is open ready, but system has none face ids!");
        } else if (ae.gKx.gIE != 1) {
            Log.e("MicroMsg.BaseFingerprintImp", "hy: device info not support");
        }
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.a
    public final boolean dJO() {
        return ((i) g.af(i.class)).dKn();
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.a
    public boolean dJP() {
        return false;
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.a
    public boolean dJQ() {
        return false;
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.a
    public final void a(ow owVar, int i2, String str) {
        Log.i("MicroMsg.BaseFingerprintImp", "hy: onOpenFingerprintAuthFailed");
        if (owVar != null && owVar.dUQ.dUU != null) {
            owVar.dUR = new ow.b();
            owVar.dUR.errCode = i2;
            owVar.dUR.dNR = "";
            owVar.dUR.dNS = "";
            owVar.dUR.errMsg = str;
            owVar.dUR.dUW = type();
            owVar.dUQ.dUU.run();
        }
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.a
    public final void pj(boolean z) {
        Log.i("MicroMsg.BaseFingerprintImp", "hy: set isOpenFp: %b", Boolean.valueOf(z));
        ((i) g.af(i.class)).pp(z);
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.a
    public final boolean dJR() {
        return ((i) g.af(i.class)).dKo();
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.a
    public final void pk(boolean z) {
        Log.i("MicroMsg.BaseFingerprintImp", "set is open faceid: %s", Boolean.valueOf(z));
        ((i) g.af(i.class)).pq(z);
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.a
    public String dJS() {
        return "";
    }

    @Override // com.tencent.mm.plugin.fingerprint.d.a
    public final void a(i iVar) {
        this.wEX = iVar;
    }
}
