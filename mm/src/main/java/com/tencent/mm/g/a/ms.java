package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class ms extends IEvent {
    public a dSm;

    public static final class a {
        public byte[] dSn;
        public int dSo;
        public boolean dSp;
    }

    public ms() {
        this((byte) 0);
    }

    private ms(byte b2) {
        AppMethodBeat.i(19821);
        this.dSm = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(19821);
    }
}
