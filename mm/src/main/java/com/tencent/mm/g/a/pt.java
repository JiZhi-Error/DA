package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class pt extends IEvent {
    public a dVJ;

    public static final class a {
        public String dVK;
        public int dVL;
        public long dVM;
        public String query;
        public int type;
    }

    public pt() {
        this((byte) 0);
    }

    private pt(byte b2) {
        AppMethodBeat.i(104419);
        this.dVJ = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(104419);
    }
}
