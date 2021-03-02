package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class f {
    private boolean VC;

    public final synchronized boolean open() {
        boolean z = true;
        synchronized (this) {
            AppMethodBeat.i(93133);
            if (this.VC) {
                z = false;
                AppMethodBeat.o(93133);
            } else {
                this.VC = true;
                notifyAll();
                AppMethodBeat.o(93133);
            }
        }
        return z;
    }

    public final synchronized boolean close() {
        boolean z;
        z = this.VC;
        this.VC = false;
        return z;
    }

    public final synchronized void block() {
        AppMethodBeat.i(93134);
        while (!this.VC) {
            wait();
        }
        AppMethodBeat.o(93134);
    }
}
