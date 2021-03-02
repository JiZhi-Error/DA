package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.HashMap;

public final class lm extends IEvent {
    public a dQO;

    public static final class a {
        public HashMap dQP;
        public String key;
    }

    public lm() {
        this((byte) 0);
    }

    private lm(byte b2) {
        AppMethodBeat.i(128846);
        this.dQO = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(128846);
    }
}
