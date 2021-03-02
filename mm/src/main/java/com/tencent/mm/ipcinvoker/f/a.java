package com.tencent.mm.ipcinvoker.f;

import android.os.IBinder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.h.b;

public final class a implements IBinder.DeathRecipient {
    private final String process;

    public a(String str) {
        this.process = str;
    }

    public final void binderDied() {
        AppMethodBeat.i(158820);
        b.i("IPC.DeathRecipientImpl", "binderDied(%s)", this.process);
        if (this.process == null || this.process.length() == 0) {
            AppMethodBeat.o(158820);
            return;
        }
        b.Ft(this.process);
        AppMethodBeat.o(158820);
    }
}
