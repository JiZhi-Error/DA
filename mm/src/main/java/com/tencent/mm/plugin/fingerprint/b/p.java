package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.soter.core.c.j;
import java.security.Signature;

public enum p {
    IML;
    
    public String wFE = null;
    String wFL = null;
    public boolean wFM = false;
    private Signature wFN = null;
    public j wFO = null;

    private p(String str) {
    }

    public static p valueOf(String str) {
        AppMethodBeat.i(64390);
        p pVar = (p) Enum.valueOf(p.class, str);
        AppMethodBeat.o(64390);
        return pVar;
    }

    static {
        AppMethodBeat.i(64392);
        AppMethodBeat.o(64392);
    }

    public final void reset() {
        AppMethodBeat.i(64391);
        Log.i("MicroMsg.WalletFingerprintVerifyManager", "hy: start reset");
        this.wFN = null;
        this.wFE = null;
        this.wFM = false;
        this.wFL = "";
        AppMethodBeat.o(64391);
    }
}
