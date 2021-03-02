package com.tencent.mm.vending.h;

import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b implements a {
    public Handler mHandler;

    public b(Handler handler) {
        this.mHandler = handler;
    }

    @Override // com.tencent.mm.vending.h.a
    public final void post(Runnable runnable) {
        AppMethodBeat.i(74911);
        this.mHandler.post(runnable);
        AppMethodBeat.o(74911);
    }

    @Override // com.tencent.mm.vending.h.a
    public final void c(Runnable runnable, long j2) {
        AppMethodBeat.i(74912);
        this.mHandler.postDelayed(runnable, j2);
        AppMethodBeat.o(74912);
    }

    @Override // com.tencent.mm.vending.h.a
    public final Looper getLooper() {
        AppMethodBeat.i(74913);
        Looper looper = this.mHandler.getLooper();
        AppMethodBeat.o(74913);
        return looper;
    }

    @Override // com.tencent.mm.vending.h.a
    public final void fS() {
        AppMethodBeat.i(74914);
        this.mHandler.removeCallbacksAndMessages(null);
        AppMethodBeat.o(74914);
    }
}
