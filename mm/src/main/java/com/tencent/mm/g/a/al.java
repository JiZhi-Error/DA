package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.event.IEvent;

public final class al extends IEvent {
    public a dDm;

    public static final class a {
        public b dDn;
        public boolean independent = true;
        public int level = 1;
    }

    public al() {
        this((byte) 0);
    }

    private al(byte b2) {
        AppMethodBeat.i(149852);
        this.dDm = new a();
        this.order = false;
        this.callback = null;
        AppMethodBeat.o(149852);
    }
}
