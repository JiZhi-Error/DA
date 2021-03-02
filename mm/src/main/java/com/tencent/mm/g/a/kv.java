package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class kv extends IEvent {
    public a dPV;

    public static final class a {
        public Context dPW;
        public long dPX;
        public boolean dPY;
    }

    public kv() {
        this((byte) 0);
    }

    private kv(byte b2) {
        AppMethodBeat.i(114792);
        this.dPV = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(114792);
    }
}
