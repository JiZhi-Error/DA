package com.tencent.mm.pluginsdk;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class t {
    private static boolean JTf = false;
    public boolean JTe = false;
    public String mTag = "";

    public t(String str) {
        this.mTag = str;
    }

    public static void glY() {
        JTf = true;
    }

    public final boolean fP(String str) {
        AppMethodBeat.i(141158);
        if (JTf) {
            Log.i("MicroMsg.SplashOptimizing", "[%s], check cancel", this.mTag);
            AppMethodBeat.o(141158);
            return false;
        } else if (this.JTe) {
            Log.i("MicroMsg.SplashOptimizing", "[%s], recreate activity, skip this %s", this.mTag, str);
            AppMethodBeat.o(141158);
            return true;
        } else {
            AppMethodBeat.o(141158);
            return false;
        }
    }
}
