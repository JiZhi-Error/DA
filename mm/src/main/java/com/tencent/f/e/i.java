package com.tencent.f.e;

import android.os.Handler;
import android.os.Looper;
import com.tencent.f.j.a;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class i implements g {
    private Handler handler = new Handler(Looper.getMainLooper());

    public i() {
        AppMethodBeat.i(183314);
        AppMethodBeat.o(183314);
    }

    public final void execute(Runnable runnable) {
        AppMethodBeat.i(183315);
        if (Thread.currentThread().getId() == this.handler.getLooper().getThread().getId()) {
            runnable.run();
            AppMethodBeat.o(183315);
            return;
        }
        this.handler.post(runnable);
        AppMethodBeat.o(183315);
    }

    @Override // com.tencent.f.e.g
    public final String getTag() {
        AppMethodBeat.i(183316);
        String str = a.hmD().tag;
        AppMethodBeat.o(183316);
        return str;
    }

    @Override // com.tencent.f.e.g
    public final void onShutdown() {
        AppMethodBeat.i(183317);
        this.handler.removeCallbacksAndMessages(null);
        AppMethodBeat.o(183317);
    }
}
