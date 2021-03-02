package com.tencent.mm.ipcinvoker.wx_extension.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.c.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.c;

public final class a {

    /* renamed from: com.tencent.mm.ipcinvoker.wx_extension.a.a$a  reason: collision with other inner class name */
    public static final class C0356a {
        public static a hnM = new a();

        static {
            AppMethodBeat.i(153086);
            AppMethodBeat.o(153086);
        }
    }

    public static c Fu(String str) {
        AppMethodBeat.i(153087);
        if (str == null || str.length() == 0) {
            Log.i("MicroMsg.IPCNewABTest", "get ABTestItem by layerId failed, id is null.", str);
            AppMethodBeat.o(153087);
            return null;
        } else if (!g.aAe().azG().aBb()) {
            com.tencent.mm.model.c.c cVar = com.tencent.mm.model.c.c.iHj;
            c Lg = com.tencent.mm.model.c.c.Lg(str);
            AppMethodBeat.o(153087);
            return Lg;
        } else if (!g.aAi().hrh.hrB || !g.aAf().hpY) {
            Log.e("MicroMsg.IPCNewABTest", "kernel or account not ready.");
            AppMethodBeat.o(153087);
            return null;
        } else {
            c Fu = d.aXu().Fu(str);
            AppMethodBeat.o(153087);
            return Fu;
        }
    }
}
