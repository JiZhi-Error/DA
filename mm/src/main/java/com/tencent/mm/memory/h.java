package com.tencent.mm.memory;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.SynchronizedPool;
import com.tencent.mm.sdk.thread.ThreadPool;
import java.nio.ByteBuffer;

public final class h extends SynchronizedPool<ByteBuffer> {
    public static h itz = new h();

    static /* synthetic */ void a(h hVar, Object obj) {
        AppMethodBeat.i(212150);
        hVar.putWithoutCheck(obj);
        AppMethodBeat.o(212150);
    }

    static {
        AppMethodBeat.i(156425);
        ThreadPool.post(new Runnable() {
            /* class com.tencent.mm.memory.h.AnonymousClass1 */

            public final void run() {
                AppMethodBeat.i(156424);
                for (int i2 = 0; i2 < 10; i2++) {
                    h.a(h.itz, ByteBuffer.allocate(16384));
                }
                AppMethodBeat.o(156424);
            }
        }, "DecodeTempStorage_preload");
        AppMethodBeat.o(156425);
    }

    private h() {
        super(20);
    }
}
