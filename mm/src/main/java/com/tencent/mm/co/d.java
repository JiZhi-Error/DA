package com.tencent.mm.co;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.vending.h.a;

public final class d implements a {
    private MMHandler mHandler;

    public d(MMHandler mMHandler) {
        this.mHandler = mMHandler;
    }

    public static d b(MMHandler mMHandler) {
        AppMethodBeat.i(133525);
        d dVar = new d(mMHandler);
        AppMethodBeat.o(133525);
        return dVar;
    }

    @Override // com.tencent.mm.vending.h.a
    public final void post(Runnable runnable) {
        AppMethodBeat.i(133526);
        this.mHandler.post(runnable);
        AppMethodBeat.o(133526);
    }

    @Override // com.tencent.mm.vending.h.a
    public final void c(Runnable runnable, long j2) {
        AppMethodBeat.i(133527);
        this.mHandler.postDelayed(runnable, j2);
        AppMethodBeat.o(133527);
    }

    @Override // com.tencent.mm.vending.h.a
    public final Looper getLooper() {
        AppMethodBeat.i(133528);
        Looper looper = this.mHandler.getLooper();
        AppMethodBeat.o(133528);
        return looper;
    }

    @Override // com.tencent.mm.vending.h.a
    public final void fS() {
        AppMethodBeat.i(133529);
        this.mHandler.removeCallbacksAndMessages(null);
        AppMethodBeat.o(133529);
    }
}
