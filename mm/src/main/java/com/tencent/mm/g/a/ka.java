package com.tencent.mm.g.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ka extends IEvent {
    public a dOV;
    public b dOW;

    public static final class a {
        public Context context;
    }

    public static final class b {
        public String dOX;
    }

    public ka() {
        this((byte) 0);
    }

    private ka(byte b2) {
        AppMethodBeat.i(155370);
        this.dOV = new a();
        this.dOW = new b();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(155370);
    }
}
