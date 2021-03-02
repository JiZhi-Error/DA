package com.tencent.mm.co;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.j;
import com.tencent.mm.sdk.platformtools.Log;

public final class b {
    private long RwU = -1;
    private final byte[] mLock = new byte[1];

    public b() {
        AppMethodBeat.i(158417);
        AppMethodBeat.o(158417);
    }

    public final void hin() {
        AppMethodBeat.i(158418);
        synchronized (this.mLock) {
            try {
                if (this.mLock[0] == 0) {
                    this.mLock[0] = 1;
                    this.RwU = Thread.currentThread().getId();
                    j.i("MicroMsg.WxConsumedLock", "lock %s", this);
                } else {
                    try {
                        if (this.RwU != Thread.currentThread().getId()) {
                            j.i("MicroMsg.WxConsumedLock", "lock waiting %s", this);
                            this.mLock.wait();
                            j.d("MicroMsg.WxConsumedLock", "unlock waiting %s", this);
                        } else {
                            j.d("MicroMsg.WxConsumedLock", "reenter lock not need waiting %s", this);
                        }
                    } catch (InterruptedException e2) {
                        Log.printErrStackTrace("MicroMsg.WxConsumedLock", e2, "", new Object[0]);
                    }
                }
            } finally {
                AppMethodBeat.o(158418);
            }
        }
    }

    public final void done() {
        AppMethodBeat.i(158419);
        synchronized (this.mLock) {
            try {
                if (this.mLock[0] != 0) {
                    this.mLock[0] = 0;
                    this.RwU = -1;
                    this.mLock.notifyAll();
                    j.i("MicroMsg.WxConsumedLock", "notify done %s", this);
                }
            } finally {
                AppMethodBeat.o(158419);
            }
        }
    }
}
