package com.tencent.mm.plugin.zero.tasks;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.kernel.a.c.a;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.Log;

public class LoadProtocolJNITask extends a {
    @Override // com.tencent.mm.kernel.a.c.b
    public void execute(g gVar) {
        AppMethodBeat.i(133034);
        getClass().getClassLoader();
        j.Ed("MMProtocalJni");
        retryOnce(new Runnable() {
            /* class com.tencent.mm.plugin.zero.tasks.LoadProtocolJNITask.AnonymousClass1 */

            public void run() {
                AppMethodBeat.i(133031);
                MMProtocalJni.setClientPackVersion(d.KyO);
                AppMethodBeat.o(133031);
            }
        });
        retryOnce(new Runnable() {
            /* class com.tencent.mm.plugin.zero.tasks.LoadProtocolJNITask.AnonymousClass2 */

            public void run() {
                AppMethodBeat.i(133032);
                MMProtocalJni.setProtocalJniLogLevel(Log.getLogLevel());
                AppMethodBeat.o(133032);
            }
        });
        retryOnce(new Runnable() {
            /* class com.tencent.mm.plugin.zero.tasks.LoadProtocolJNITask.AnonymousClass3 */

            public void run() {
                AppMethodBeat.i(133033);
                MMProtocalJni.setIsLite(false);
                AppMethodBeat.o(133033);
            }
        });
        AppMethodBeat.o(133034);
    }

    private void retryOnce(Runnable runnable) {
        AppMethodBeat.i(133035);
        try {
            runnable.run();
            AppMethodBeat.o(133035);
        } catch (Throwable th) {
            runnable.run();
            AppMethodBeat.o(133035);
        }
    }

    @Override // com.tencent.mm.kernel.a.c.b, com.tencent.mm.kernel.a.c.a
    public String name() {
        return "boot-load-MMProtocalJni-library";
    }
}
