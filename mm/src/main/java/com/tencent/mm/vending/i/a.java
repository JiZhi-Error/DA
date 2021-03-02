package com.tencent.mm.vending.i;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a {
    private static a RaO = new a();
    public HandlerThread RaN = new HandlerThread("Vending-HeavyWorkThread", 10);
    private Handler mHandler;

    private a() {
        AppMethodBeat.i(74940);
        this.RaN.start();
        this.mHandler = new Handler(this.RaN.getLooper());
        AppMethodBeat.o(74940);
    }

    static {
        AppMethodBeat.i(74941);
        AppMethodBeat.o(74941);
    }

    public static a hdK() {
        return RaO;
    }
}
