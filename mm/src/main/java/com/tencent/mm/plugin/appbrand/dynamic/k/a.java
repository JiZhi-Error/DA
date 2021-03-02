package com.tencent.mm.plugin.appbrand.dynamic.k;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.concurrent.CountDownLatch;

public final class a {
    public static <T extends com.tencent.mm.kernel.c.a> T aA(Class<T> cls) {
        AppMethodBeat.i(121518);
        T t = (T) g.af(cls);
        if (t != null) {
            AppMethodBeat.o(121518);
            return t;
        } else if (Looper.myLooper() == Looper.getMainLooper()) {
            AppMethodBeat.o(121518);
            return null;
        } else if (!g.aAi().hrh.hrB) {
            final CountDownLatch countDownLatch = new CountDownLatch(1);
            AnonymousClass1 r1 = new com.tencent.mm.kernel.api.g() {
                /* class com.tencent.mm.plugin.appbrand.dynamic.k.a.AnonymousClass1 */

                @Override // com.tencent.mm.kernel.api.g
                public final void WY() {
                    AppMethodBeat.i(121516);
                    countDownLatch.countDown();
                    AppMethodBeat.o(121516);
                }

                @Override // com.tencent.mm.kernel.api.g
                public final void cQ(boolean z) {
                    AppMethodBeat.i(121517);
                    countDownLatch.countDown();
                    AppMethodBeat.o(121517);
                }
            };
            g.aAi().a(r1);
            try {
                countDownLatch.await();
                g.aAi().b(r1);
            } catch (InterruptedException e2) {
                Log.printErrStackTrace("MicroMsg.SyncGetter", e2, "", new Object[0]);
                g.aAi().b(r1);
            } catch (Throwable th) {
                g.aAi().b(r1);
                AppMethodBeat.o(121518);
                throw th;
            }
            T t2 = (T) g.af(cls);
            AppMethodBeat.o(121518);
            return t2;
        } else {
            AppMethodBeat.o(121518);
            return null;
        }
    }
}
