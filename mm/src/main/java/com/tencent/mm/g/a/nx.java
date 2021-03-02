package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class nx extends IEvent {
    public a dTZ;

    public static final class a {
        public String nickName;
        public int type;
        public String userName;
    }

    public nx() {
        this((byte) 0);
    }

    private nx(byte b2) {
        AppMethodBeat.i(42654);
        this.dTZ = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(42654);
    }
}
