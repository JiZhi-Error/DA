package com.tencent.mm.co;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.j;

public final class k {
    public final byte[] mLock = new byte[1];

    public k() {
        AppMethodBeat.i(158422);
        AppMethodBeat.o(158422);
    }

    public final void done() {
        AppMethodBeat.i(158423);
        synchronized (this.mLock) {
            try {
                if (this.mLock[0] == -1) {
                    this.mLock[0] = 1;
                    this.mLock.notifyAll();
                    j.i("MicroMsg.WxWaitingLock", "notify done %s", this);
                }
            } finally {
                AppMethodBeat.o(158423);
            }
        }
    }
}
