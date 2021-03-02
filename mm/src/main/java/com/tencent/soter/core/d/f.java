package com.tencent.soter.core.d;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.CountDownLatch;

public final class f {
    private static Handler RQg = null;
    CountDownLatch JTq = null;

    public final void countDown() {
        AppMethodBeat.i(88726);
        if (this.JTq != null) {
            this.JTq.countDown();
        }
        AppMethodBeat.o(88726);
    }
}
