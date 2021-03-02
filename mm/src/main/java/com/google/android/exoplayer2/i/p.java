package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.IOException;
import java.util.PriorityQueue;

public final class p {
    public final PriorityQueue<Integer> bHs;
    public int bHt;
    public final Object lock;

    public static class a extends IOException {
    }

    public final void xr() {
        AppMethodBeat.i(93193);
        synchronized (this.lock) {
            try {
                this.bHs.remove(0);
                this.bHt = this.bHs.isEmpty() ? Integer.MIN_VALUE : this.bHs.peek().intValue();
                this.lock.notifyAll();
            } finally {
                AppMethodBeat.o(93193);
            }
        }
    }
}
