package com.tencent.mm.plugin.walletlock.fingerprint.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.soter.a.a.a;

public final class h {
    public a Ivg = null;

    public final void release() {
        AppMethodBeat.i(129702);
        Log.i("MicroMsg.SoterFingerprintAuthManager", "alvinluo release fingerprint auth");
        if (this.Ivg != null) {
            this.Ivg.DP(true);
        }
        AppMethodBeat.o(129702);
    }
}
