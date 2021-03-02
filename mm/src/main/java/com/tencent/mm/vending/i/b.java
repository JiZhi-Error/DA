package com.tencent.mm.vending.i;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b {
    private static b RaQ = new b();
    public HandlerThread RaP = new HandlerThread("Vending-LogicThread");
    private Handler mHandler;

    private b() {
        AppMethodBeat.i(74942);
        this.RaP.start();
        this.mHandler = new Handler(this.RaP.getLooper());
        AppMethodBeat.o(74942);
    }

    static {
        AppMethodBeat.i(74943);
        AppMethodBeat.o(74943);
    }

    public static b hdL() {
        return RaQ;
    }
}
