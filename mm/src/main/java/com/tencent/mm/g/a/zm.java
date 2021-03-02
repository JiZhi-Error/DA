package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class zm extends IEvent {
    public a efD;

    public static final class a {
        public Context context;
    }

    public zm() {
        this((byte) 0);
    }

    private zm(byte b2) {
        AppMethodBeat.i(130929);
        this.efD = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(130929);
    }
}
