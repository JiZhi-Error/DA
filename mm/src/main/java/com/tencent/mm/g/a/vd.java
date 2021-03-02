package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class vd extends IEvent {
    public a ebw;

    public static final class a {
        public int ebA = 0;
        public String ebx;
        public String eby;
        public String ebz;
    }

    public vd() {
        this((byte) 0);
    }

    private vd(byte b2) {
        AppMethodBeat.i(201821);
        this.ebw = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(201821);
    }
}
