package com.tencent.mm.plugin.fingerprint.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.thread.ThreadPool;

public final class o {
    a wFI;

    public interface a {
        void ZA(String str);
    }

    public o(a aVar) {
        this.wFI = aVar;
    }

    public final void bDI() {
        AppMethodBeat.i(64388);
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.plugin.fingerprint.b.o.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(64387);
                String str = "";
                if (d.dJX()) {
                    Log.i("MicroMsg.SyncGenRsaKey", "device is support FingerPrintAuth");
                    str = FingerPrintAuth.genRsaKey(d.fL(MMApplicationContext.getContext()), d.getUserId(), q.aoG());
                } else {
                    Log.e("MicroMsg.SyncGenRsaKey", "device is not support FingerPrintAuth");
                }
                if (o.this.wFI != null) {
                    o.this.wFI.ZA(str);
                }
                AppMethodBeat.o(64387);
            }
        }, getClass().getName());
        AppMethodBeat.o(64388);
    }
}
