package com.tencent.thumbplayer.utils;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class i extends ReentrantReadWriteLock {
    public Condition Sfu = writeLock().newCondition();

    public i() {
        AppMethodBeat.i(189665);
        AppMethodBeat.o(189665);
    }

    public final boolean OG(long j2) {
        AppMethodBeat.i(189666);
        boolean z = false;
        int i2 = 3;
        while (true) {
            int i3 = i2 - 1;
            if (i3 < 0) {
                break;
            }
            try {
                z = this.Sfu.await(500, TimeUnit.MILLISECONDS);
                break;
            } catch (InterruptedException e2) {
                g.e("TPReadWriteLock", e2);
                i2 = i3;
            }
        }
        AppMethodBeat.o(189666);
        return z;
    }
}
