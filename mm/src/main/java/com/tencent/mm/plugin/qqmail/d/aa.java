package com.tencent.mm.plugin.qqmail.d;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;

public final class aa {
    public z Bsj;

    public aa() {
        AppMethodBeat.i(122760);
        String str = (String) g.aAh().azQ().get(282625, "");
        try {
            this.Bsj = new z();
            this.Bsj.parseFrom(Base64.decode(str, 0));
            AppMethodBeat.o(122760);
        } catch (Exception e2) {
            Log.printErrStackTrace("MicroMsg.ShareMailInfoMgr", e2, "", new Object[0]);
            Log.w("MicroMsg.ShareMailInfoMgr", "parse from config fail");
            this.Bsj = new z();
            AppMethodBeat.o(122760);
        }
    }
}
