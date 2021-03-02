package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import java.util.List;

public final class qt extends IEvent {
    public a dXj;

    public static final class a {
        public List dXk;
    }

    public qt() {
        this((byte) 0);
    }

    private qt(byte b2) {
        AppMethodBeat.i(118413);
        this.dXj = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(118413);
    }
}
