package com.tencent.mm.sdk.thread;

import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.thread.api.IThreadPool;

@Deprecated
public class ThreadPool implements IThreadPool {
    static final /* synthetic */ boolean $assertionsDisabled = (!ThreadPool.class.desiredAssertionStatus());
    public static final ThreadPool INSTANCE = new ThreadPool();
    public static final String TAG = "MicroMsg.ThreadPool";

    static {
        AppMethodBeat.i(158155);
        AppMethodBeat.o(158155);
    }

    public ThreadPool() {
        AppMethodBeat.i(158135);
        AppMethodBeat.o(158135);
    }

    @Deprecated
    public void adapterPost(final Runnable runnable, final String str) {
        AppMethodBeat.i(158142);
        if ($assertionsDisabled || runnable != null) {
            h.RTc.aX(new com.tencent.f.i.h() {
                /* class com.tencent.mm.sdk.thread.ThreadPool.AnonymousClass1 */

                @Override // com.tencent.f.i.h, com.tencent.f.i.g
                public String getKey() {
                    return str;
                }

                public void run() {
                    AppMethodBeat.i(158103);
                    runnable.run();
                    AppMethodBeat.o(158103);
                }
            });
            AppMethodBeat.o(158142);
            return;
        }
        AssertionError assertionError = new AssertionError();
        AppMethodBeat.o(158142);
        throw assertionError;
    }

    @Deprecated
    public static void post(Runnable runnable, String str) {
        AppMethodBeat.i(158143);
        INSTANCE.adapterPost(runnable, str);
        AppMethodBeat.o(158143);
    }

    @Deprecated
    public static void post(Runnable runnable, String str, int i2) {
        AppMethodBeat.i(230537);
        INSTANCE.adapterPost(runnable, str);
        AppMethodBeat.o(230537);
    }

    @Deprecated
    public static void postAtFront(Runnable runnable, String str) {
        AppMethodBeat.i(158145);
        INSTANCE.adapterPost(runnable, str);
        AppMethodBeat.o(158145);
    }
}
