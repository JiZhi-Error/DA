package com.tencent.mm.plugin.fingerprint.b.a;

import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fingerprint.b.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar;

public abstract class a implements i {
    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final boolean dKn() {
        return d.dKh();
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final void pp(boolean z) {
        Log.i("MicroMsg.AbstractBiometricPayManager", "hy: set isOpenFp: %b", Boolean.valueOf(z));
        d.pl(z);
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final boolean dKo() {
        return ((Boolean) g.aAh().azQ().get(ar.a.USERINFO_FACE_ID_IS_OPEN_BOOLEAN_SYNC, Boolean.FALSE)).booleanValue();
    }

    @Override // com.tencent.mm.plugin.fingerprint.b.a.i
    public final void pq(boolean z) {
        Log.i("MicroMsg.AbstractBiometricPayManager", "set is open faceid: %s", Boolean.valueOf(z));
        g.aAh().azQ().set(ar.a.USERINFO_FACE_ID_IS_OPEN_BOOLEAN_SYNC, Boolean.valueOf(z));
    }
}
