package com.tencent.mm.av.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.c.p;
import com.tencent.mm.av.a.d.a;
import com.tencent.mm.sdk.platformtools.Log;

public final class g implements p {
    private a<String, Integer> jbG = new a<>(10);

    public g() {
        AppMethodBeat.i(130423);
        AppMethodBeat.o(130423);
    }

    @Override // com.tencent.mm.av.a.c.p
    public final synchronized boolean OY(String str) {
        boolean z;
        AppMethodBeat.i(130424);
        if (this.jbG.check(str)) {
            int intValue = this.jbG.get(str).intValue();
            this.jbG.put(str, Integer.valueOf(intValue + 1));
            if (intValue >= 50) {
                if (intValue == 50 || intValue % 500 == 0) {
                    Log.i("MicroMsg.imageloader.DefaultImageRetryDownloadListener", "Url %s retry over time %d current time:%d, then stop retry download", str, 50, Integer.valueOf(intValue));
                }
                AppMethodBeat.o(130424);
                z = false;
            }
            AppMethodBeat.o(130424);
            z = true;
        } else {
            this.jbG.put(str, 1);
            AppMethodBeat.o(130424);
            z = true;
        }
        return z;
    }
}
