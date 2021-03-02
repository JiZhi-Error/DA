package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.gen.IAsyncTask;
import com.tencent.kinda.gen.KEventLoop;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public class KindaUIEventLoop implements KEventLoop {
    @Override // com.tencent.kinda.gen.KEventLoop
    public void post(final IAsyncTask iAsyncTask) {
        AppMethodBeat.i(18658);
        MMHandlerThread.postToMainThread(new Runnable() {
            /* class com.tencent.kinda.framework.module.impl.KindaUIEventLoop.AnonymousClass1 */

            public void run() {
                AppMethodBeat.i(18657);
                iAsyncTask.execute();
                AppMethodBeat.o(18657);
            }
        });
        AppMethodBeat.o(18658);
    }
}
