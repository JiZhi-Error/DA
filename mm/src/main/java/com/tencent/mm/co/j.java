package com.tencent.mm.co;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class j {
    public final byte[] mLock = new byte[1];

    public j() {
        AppMethodBeat.i(125332);
        AppMethodBeat.o(125332);
    }

    public final void hip() {
        AppMethodBeat.i(125333);
        synchronized (this.mLock) {
            try {
                if (this.mLock[0] != 0) {
                    Log.i("MicroMsg.WxTimeoutLock", "no need lock %s", this);
                } else {
                    try {
                        this.mLock.wait(3000);
                    } catch (InterruptedException e2) {
                        Log.printErrStackTrace("MicroMsg.WxTimeoutLock", e2, "", new Object[0]);
                    }
                }
            } finally {
                AppMethodBeat.o(125333);
            }
        }
    }
}
