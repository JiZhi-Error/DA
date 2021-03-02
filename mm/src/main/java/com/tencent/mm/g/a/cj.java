package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class cj extends IEvent {
    public a dFB;
    public b dFC;

    public static final class a {
        public Context context;
        public String dFD;
        public String username;
    }

    public static final class b {
        public boolean dFE = false;
    }

    public cj() {
        this((byte) 0);
    }

    private cj(byte b2) {
        AppMethodBeat.i(149859);
        this.dFB = new a();
        this.dFC = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(149859);
    }
}
