package com.tencent.mm.g.a;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class nz extends IEvent {
    public a dUc;

    public static final class a {
        public String dUd;
        public Bundle params;
    }

    public nz() {
        this((byte) 0);
    }

    private nz(byte b2) {
        AppMethodBeat.i(77797);
        this.dUc = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(77797);
    }
}
