package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class it extends IEvent {
    public a dNs;
    public b dNt;

    public static final class a {
        public int EX = 0;
        public Context context;
        public String param;
    }

    public static final class b {
        public String result;
    }

    public it() {
        this((byte) 0);
    }

    private it(byte b2) {
        AppMethodBeat.i(89640);
        this.dNs = new a();
        this.dNt = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(89640);
    }
}
